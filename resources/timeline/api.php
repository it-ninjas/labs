<?php

// ============================================================
// CORS
// ============================================================

// Allowed frontend origins that may access this API
$allowedOrigins = [
    "https://labs.it-ninjas.ch",
    "https://dosai.sirprepo.com",
    "https://ninja.sirprepo.com"
];

$origin = $_SERVER["HTTP_ORIGIN"] ?? "";

// Allow only requests from known origins
if (in_array($origin, $allowedOrigins)) {
    header("Access-Control-Allow-Origin: $origin");
}

// Allowed request headers and methods
header("Access-Control-Allow-Headers: Content-Type, Authorization");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");

header("Content-Type: application/json");

// Handle preflight CORS requests
if ($_SERVER["REQUEST_METHOD"] === "OPTIONS") {
    http_response_code(200);
    exit;
}


// ============================================================
// Paths
// ============================================================

// Base storage directory
$ROOT = __DIR__ . "/data";

$ACCESS_DIR   = "$ROOT/access";
$USER_DIR     = "$ROOT/users";
$GROUP_DIR    = "$ROOT/groups";
$IMAGE_DIR    = "$ROOT/images";
$TRACKING_DIR = "$ROOT/tracking";
$FEEDBACK_DIR = "$ROOT/feedback";

// Ensure all required directories exist
foreach ([$ROOT, $ACCESS_DIR, $USER_DIR, $GROUP_DIR, $IMAGE_DIR, $TRACKING_DIR, $FEEDBACK_DIR] as $d) {
    if (!file_exists($d)) {
        mkdir($d, 0777, true);
    }
}


// ============================================================
// Constants
// ============================================================

const INVALID_ACCESS_KEY = "Invalid accessKey";
const MISSING_FIELD = "Missing field: %s";

const JSON_EXTENSION_WITHOUT_POINT = "json";
const JSON_EXTENSION = ".json";

const ACCESS_KEY = "accessKey";
const ERROR_KEY = "error";

const USER_ID = "userId";
const ADMIN = "admin";
const VIEW = "view";
const WRITE = "write";
const FEEDBACK = "feedback";
const DISPLAY_NAME = "displayName";
const MODULE_ID = "moduleId";
const UPDATED = "updated";
const IMAGE = "image";
const PATH_KEY = "path";
const PAYLOAD = "payload";
const COUNT_KEY = "count";
const START_KEY = "start";
const END_KEY = "end";
const SCOPE_KEY = "scope";
const SCOPE_MINE = "mine";
const SCOPE_ALL = "all";
const COMMON_ACCESS_FILE = "common.json";


// ============================================================
// Helpers
// ============================================================

/**
 * Sends an error response and stops script execution.
 *
 * @param string $msg  Error message
 * @param int    $code HTTP status code
 */
function bad(string $msg, int $code = 400) {

    http_response_code($code);

    echo json_encode([ERROR_KEY => $msg]);

    exit;
}

/**
 * Sends a JSON response and terminates execution.
 *
 * @param array $data Response payload
 */
function jsonResponse(array $data): void {

    echo json_encode($data);

    exit;
}

/**
 * Reads a JSON file and returns the decoded array.
 * Returns an empty array if the file does not exist
 * or the content cannot be parsed.
 *
 * @param string $file
 * @return array
 */
function readJSON(string $file): array {

    if (!file_exists($file)) {
        return [];
    }

    $data = json_decode(file_get_contents($file), true);

    return is_array($data) ? $data : [];
}

/**
 * Writes an array to disk as formatted JSON.
 *
 * @param string $file
 * @param array  $data
 */
function writeJSON(string $file, array $data): void {

    file_put_contents($file, json_encode($data, JSON_PRETTY_PRINT), LOCK_EX);
}

/**
 * Reads JSON request body and validates it.
 *
 * @return array
 */
function readBody(): array {

    $raw = json_decode(file_get_contents("php://input"), true);

    if (!$raw) {
        bad("Invalid JSON");
    }

    return $raw;
}

/**
 * Appends a line to a log file using file locking.
 * Prevents race conditions between concurrent requests.
 *
 * @param string $file
 * @param string $line
 */
function appendLog(string $file, string $line): void {

    $fp = fopen($file, "a");

    if (!$fp) {
        bad("Cannot open log file", 500);
    }

    flock($fp, LOCK_EX);
    fwrite($fp, $line);
    fflush($fp);
    flock($fp, LOCK_UN);

    fclose($fp);
}

/**
 * Ensures required fields are present in a request payload.
 *
 * @param array $data
 * @param array $fields
 */
function requireFields(array $data, array $fields): void {

    foreach ($fields as $f) {

        if (!isset($data[$f]) || $data[$f] === "") {
            bad(sprintf(MISSING_FIELD, $f));
        }
    }
}

/**
 * Normalizes hint paths used when listing access tokens.
 * Converts Windows paths to Unix style and removes duplicate slashes.
 *
 * @param string $hint
 * @return string
 */
function normalizeHint(string $hint): string {

    $hint = str_replace("\\", "/", $hint);

    while (strpos($hint, "//") !== false) {
        $hint = str_replace("//", "/", $hint);
    }

    return trim($hint, "/");
}

/**
 * Returns true when an array is a list with numeric keys from 0..n-1.
 *
 * @param array $data
 * @return bool
 */
function isListArray(array $data): bool {

    return array_keys($data) === range(0, count($data) - 1);
}

/**
 * Merges and de-duplicates a list array while preserving order.
 *
 * @param array $left
 * @param array $right
 * @return array
 */
function mergeUniqueList(array $left, array $right): array {

    $seen = [];
    $result = [];

    foreach (array_merge($left, $right) as $value) {

        $key = is_scalar($value) || $value === null
            ? json_encode($value)
            : serialize($value);

        if (isset($seen[$key])) {
            continue;
        }

        $seen[$key] = true;
        $result[] = $value;
    }

    return $result;
}

/**
 * Merges access-related JSON structures.
 * Scalar values from the token file override common.json values.
 * List arrays are merged as a union while preserving order.
 *
 * @param mixed $base
 * @param mixed $override
 * @return mixed
 */
function mergeAccessValue($base, $override) {

    if (!is_array($base) || !is_array($override)) {
        return $override;
    }

    if (isListArray($base) && isListArray($override)) {
        return mergeUniqueList($base, $override);
    }

    $result = $base;

    foreach ($override as $key => $value) {

        if (array_key_exists($key, $result)) {
            $result[$key] = mergeAccessValue($result[$key], $value);
        } else {
            $result[$key] = $value;
        }
    }

    return $result;
}

/**
 * Reads and resolves a single access file, including common.json from the
 * same directory when present.
 *
 * @param string $file
 * @return array
 */
function readAccessDefinition(string $file): array {

    $tokenData = readJSON($file);
    $commonFile = dirname($file) . DIRECTORY_SEPARATOR . COMMON_ACCESS_FILE;

    if (basename($file) === COMMON_ACCESS_FILE || !file_exists($commonFile)) {
        return $tokenData;
    }

    $commonData = readJSON($commonFile);

    return is_array($commonData)
        ? mergeAccessValue($commonData, $tokenData)
        : $tokenData;
}

/**
 * Validates that a userId cannot escape the storage directory.
 * Only checks for path separators.
 *
 * @param string|null $uid
 */
function validateUserId(?string $uid): void {

    if ($uid !== null && preg_match('/[\/\\\\]/', $uid)) {
        bad("Invalid userId");
    }
}

/**
 * Validates a feedback group identifier.
 *
 * @param string|null $group
 */
function validateFeedbackGroup(?string $group): void {

    if ($group === null || !preg_match('/^[a-z]+$/', $group)) {
        bad("Invalid feedback group");
    }
}

/**
 * Validates a hierarchical feedback path.
 *
 * Allowed:
 *   segment-one/segment-two
 *
 * Forbidden:
 *   backslashes, .., empty segments, leading or trailing slash
 *
 * @param string|null $path
 */
function validateFeedbackPath(?string $path): void {

    if ($path === null || $path === "") {
        bad("Invalid feedback path");
    }

    if (str_contains($path, "\\") || str_contains($path, "..")) {
        bad("Invalid feedback path");
    }

    if (str_starts_with($path, "/") || str_ends_with($path, "/")) {
        bad("Invalid feedback path");
    }

    $segments = explode("/", $path);

    foreach ($segments as $segment) {
        if ($segment === "" || $segment === "." || $segment === "..") {
            bad("Invalid feedback path");
        }
    }
}

/**
 * Ensures a directory exists.
 *
 * @param string $dir
 */
function ensureDirectory(string $dir): void {

    if (!is_dir($dir) && !mkdir($dir, 0777, true) && !is_dir($dir)) {
        bad("Cannot create directory", 500);
    }
}

/**
 * Writes any JSON-serializable value to disk.
 *
 * @param string $file
 * @param mixed  $data
 */
function writeJSONValue(string $file, $data): void {

    file_put_contents($file, json_encode($data, JSON_PRETTY_PRINT), LOCK_EX);
}

/**
 * Validates a timestamp filter and returns it as an integer.
 *
 * @param string $name
 * @param mixed  $value
 * @return int
 */
function parseTimestampFilter(string $name, $value): int {

    if (!is_scalar($value) || !preg_match('/^\d+$/', (string) $value)) {
        bad("Invalid $name");
    }

    return (int) $value;
}

/**
 * Builds a safe feedback directory path for a group and optional logical path.
 *
 * @param string      $group
 * @param string|null $path
 * @return string
 */
function buildFeedbackDirectory(string $group, ?string $path = null): string {

    global $FEEDBACK_DIR;

    validateFeedbackGroup($group);

    $baseDir = $FEEDBACK_DIR . DIRECTORY_SEPARATOR . $group;

    if ($path === null || $path === "") {
        return $baseDir;
    }

    validateFeedbackPath($path);

    return $baseDir . DIRECTORY_SEPARATOR . str_replace("/", DIRECTORY_SEPARATOR, $path);
}

/**
 * Checks whether the caller may access a feedback group.
 *
 * @param array  $access
 * @param string $group
 */
function requireFeedbackGroupAccess(array $access, string $group): void {

    $allowedGroups = is_array($access[FEEDBACK] ?? null) ? $access[FEEDBACK] : [];

    if (!in_array($group, $allowedGroups, true)) {
        bad("No feedback permission", 403);
    }
}


// ============================================================
// Access-Key lookup
// ============================================================

/**
 * Extracts the access key from the request.
 *
 * Supports:
 *   Authorization: Bearer <key>
 *   GET parameter accessKey (fallback)
 *
 * @return string|null
 */
function getAccessKey(): ?string {

    $h = $_SERVER["HTTP_AUTHORIZATION"] ?? null;

    if ($h && preg_match('/Bearer\s+(.*)$/i', $h, $m)) {
        return $m[1];
    }

    if (isset($_GET[ACCESS_KEY])) {
        return $_GET[ACCESS_KEY];
    }

    // Fallback: accept accessKey in JSON body
    $raw = json_decode(file_get_contents("php://input"), true);

    return (is_array($raw) && !empty($raw[ACCESS_KEY])) ? $raw[ACCESS_KEY] : null;
}

/**
 * Searches the access directory for a matching access definition.
 *
 * File naming format:
 *   <accessKey>_description.json
 *
 * Only the prefix before the first "_" is used as the access key.
 *
 * @param string $accessKey
 * @return array|null
 */
function findAccess(string $accessKey): ?array {

    global $ACCESS_DIR;

    $it = new RecursiveIteratorIterator(
        new RecursiveDirectoryIterator($ACCESS_DIR, FilesystemIterator::SKIP_DOTS)
    );

    foreach ($it as $file) {

        if (!$file->isFile()) {
            continue;
        }

        if ($file->getExtension() !== JSON_EXTENSION_WITHOUT_POINT) {
            continue;
        }

        if ($file->getFilename() === COMMON_ACCESS_FILE) {
            continue;
        }

        // Extract prefix key from filename
        $base = $file->getBasename(JSON_EXTENSION);

        $parts = explode("_", $base, 2);

        $fileKey = $parts[0];

        if ($fileKey === $accessKey) {
            return readAccessDefinition($file->getPathname());
        }
    }

    return null;
}

/**
 * Ensures a valid access key is provided.
 *
 * @return array Access definition
 */
function requireAccess(): array {

    $key = getAccessKey();

    if (!$key) {
        bad("Missing accessKey");
    }

    $access = findAccess($key);

    if (!$access) {
        bad(INVALID_ACCESS_KEY, 403);
    }

    return $access;
}

/**
 * Ensures the caller has admin privileges.
 *
 * @return array Access definition
 */
function requireAdminAccess(): array {

    $access = requireAccess();

    if (!($access[ADMIN] ?? false)) {
        bad("Admin access required", 403);
    }

    return $access;
}


// ============================================================
// Routing
// ============================================================

// HTTP method used for the request
$method = $_SERVER["REQUEST_METHOD"];

// Extract endpoint name from URL
$endpoint = trim(basename(parse_url($_SERVER["REQUEST_URI"], PHP_URL_PATH)), "/");


// ============================================================
// GET /me
// ============================================================

if ($method === "GET" && $endpoint === "me") {

    $access = requireAccess();

    $uid = $access[USER_ID] ?? null;

    validateUserId($uid);

    global $USER_DIR;

    $userFile = "$USER_DIR/$uid.json";

    $user = readJSON($userFile);

    jsonResponse([
        USER_ID => $access[USER_ID] ?? null,
        WRITE => $access[WRITE] ?? [],
        VIEW => $access[VIEW] ?? [],
        DISPLAY_NAME => $user[DISPLAY_NAME] ?? null,
        IMAGE => $user[IMAGE] ?? null,
        MODULE_ID => $user[MODULE_ID] ?? null,
    ]);
}


// ============================================================
// GET /userinfo
// ============================================================
// Admin-only: list all access tokens with hint and userId
// ============================================================

if ($method === "GET" && $endpoint === "userinfo") {

    $access = requireAdminAccess();

    $format = strtolower($_GET["format"] ?? "json");

    global $ACCESS_DIR;

    $rows = [];

    $it = new RecursiveIteratorIterator(
        new RecursiveDirectoryIterator($ACCESS_DIR, FilesystemIterator::SKIP_DOTS)
    );

    foreach ($it as $file) {

        if (!$file->isFile()) {
            continue;
        }

        if ($file->getExtension() !== JSON_EXTENSION_WITHOUT_POINT) {
            continue;
        }

        if ($file->getFilename() === COMMON_ACCESS_FILE) {
            continue;
        }

        $base = $file->getBasename(JSON_EXTENSION);

        $parts = explode("_", $base, 2);

        $fileKey = $parts[0];

        $data = readAccessDefinition($file->getPathname());

        $hintParts = [];

        // Include directory structure in hint
        $relPath = str_replace($ACCESS_DIR, "", $file->getPath());

        if ($relPath && $relPath !== DIRECTORY_SEPARATOR) {
            $hintParts[] = trim($relPath, "/\\");
        }

        // Include filename suffix in hint
        if (isset($parts[1])) {
            $hintParts[] = $parts[1];
        }

        $hint = normalizeHint(implode("/", $hintParts));

        $rows[] = [
            ACCESS_KEY => $fileKey,
            "hint" => $hint,
            USER_ID => $data[USER_ID] ?? null
        ];
    }

    
    // CSV output
    if ($format === "csv") {

        header("Content-Type: text/csv; charset=utf-8");

        echo "accessKey,hint,userId\n";

        foreach ($rows as $r) {

            echo sprintf(
                "\"%s\",\"%s\",\"%s\"\n",
                $r[ACCESS_KEY],
                $r["hint"],
                $r[USER_ID] ?? ""
            );
        }

        exit;
    }

    // Markdown output
    if ($format === "markdown") {

        header("Content-Type: text/markdown; charset=utf-8");

        echo "| Hint | AccessKey | UserId |\n";
        echo "|------|-----------|--------|\n";

        foreach ($rows as $r) {

            echo sprintf(
                "| %s | `%s` | %s |\n",
                $r["hint"],
                $r[ACCESS_KEY],
                $r[USER_ID] ?? ""
            );
        }

        exit;
    }

    echo json_encode($rows, JSON_PRETTY_PRINT);

    exit;
}


// ============================================================
// POST /update-image
// ============================================================

if ($method === "POST" && $endpoint === "update-image") {

    $raw = readBody();

    requireFields($raw, [IMAGE]);

    $access = requireAccess();

    $img = $raw[IMAGE];

     // Prevent large base64 uploads
    if (strlen($img) > 5_000_000) {
        bad("Image too large");
    }

    $userId = $access[USER_ID] ?? null;

    if (!$userId) {
        bad("No avatar allowed", 403);
    }

    validateUserId($userId);

    if (!str_starts_with($img, "data:image/")) {
        bad("Invalid image data");
    }

    global $IMAGE_DIR;

    $data = preg_replace('/^data:image\/\w+;base64,/', '', $img);

    file_put_contents("$IMAGE_DIR/$userId.jpg", base64_decode($data));

    jsonResponse(["ok" => true]);
}


// ============================================================
// POST /update-position
// ============================================================

if ($method === "POST" && $endpoint === "update-position") {

    $raw = readBody();

    requireFields($raw, [MODULE_ID, DISPLAY_NAME]);

    $access = requireAccess();

    if (empty($access[USER_ID])) {
        bad("No avatar permission", 403);
    }

    $uid  = $access[USER_ID];
    $mod  = $raw[MODULE_ID];
    $name = $raw[DISPLAY_NAME];
    $now  = time();

    validateUserId($uid);

    global $USER_DIR, $TRACKING_DIR, $GROUP_DIR;

    $userFile = "$USER_DIR/$uid.json";

    $user = readJSON($userFile);

    $lastModule = $user[MODULE_ID] ?? null;

    // Track module changes
    if ($lastModule !== $mod) {

        $ts = time();

        $line = "$uid;$mod;$ts\n";

        appendLog("$TRACKING_DIR/$uid.log", $line);

        $user[UPDATED] = $ts;
    }

    $user[USER_ID] = $uid;
    $user[MODULE_ID] = $mod;
    $user[UPDATED] = $now;
    $user[DISPLAY_NAME] = $name;

    writeJSON($userFile, $user);

    // Update all write groups
    foreach ($access[WRITE] ?? [] as $group) {

        $gFile = "$GROUP_DIR/$group.json";

        $g = readJSON($gFile);

        $g[$uid] = [
            USER_ID => $uid,
            MODULE_ID => $mod,
            UPDATED => $now
        ];

        writeJSON($gFile, $g);
    }

    jsonResponse(["ok" => true]);
}


// ============================================================
// POST /feedback
// ============================================================

if ($method === "POST" && $endpoint === "feedback") {

    $raw = readBody();

    requireFields($raw, [FEEDBACK, PATH_KEY]);

    if (!array_key_exists(PAYLOAD, $raw)) {
        bad(sprintf(MISSING_FIELD, PAYLOAD));
    }

    $access = requireAccess();
    $group = (string) $raw[FEEDBACK];
    $path = (string) $raw[PATH_KEY];
    $payload = $raw[PAYLOAD];
    $timestamp = (int) floor(microtime(true) * 1000);
    $userId = $access[USER_ID] ?? null;

    if (!$userId) {
        bad("Feedback requires userId", 403);
    }

    validateUserId($userId);
    validateFeedbackGroup($group);
    validateFeedbackPath($path);
    requireFeedbackGroupAccess($access, $group);

    $targetDir = buildFeedbackDirectory($group, $path) . DIRECTORY_SEPARATOR . $userId;

    ensureDirectory($targetDir);

    $file = $targetDir . DIRECTORY_SEPARATOR . $timestamp . JSON_EXTENSION;

    writeJSONValue($file, $payload);

    jsonResponse([
        "ok" => true,
        FEEDBACK => $group,
        PATH_KEY => $path,
        USER_ID => $userId,
        "timestamp" => $timestamp
    ]);
}


// ============================================================
// GET /list
// ============================================================

if ($method === "GET" && $endpoint === "list") {

    $access = requireAccess();

    $view  = is_array($access[VIEW] ?? null) ? $access[VIEW] : [];
    $write = is_array($access[WRITE] ?? null) ? $access[WRITE] : [];

    // Union of readable groups
    $groupsToRead = array_values(array_unique(array_merge($view, $write)));

    global $GROUP_DIR, $USER_DIR, $IMAGE_DIR;

    $userIdSet = [];

    foreach ($groupsToRead as $g) {

        if (!$g) {
            continue;
        }

        $gf = "$GROUP_DIR/$g.json";

        if (!file_exists($gf)) {
            continue;
        }

        $gdata = readJSON($gf);

        if (is_array($gdata)) {

            $isAssoc = array_keys($gdata) !== range(0, count($gdata) - 1);

            if ($isAssoc) {

                foreach ($gdata as $uid => $v) {
                    if ($uid) {
                        $userIdSet[$uid] = true;
                    }
                }

            } else {

                foreach ($gdata as $uid) {
                    if ($uid) {
                        $userIdSet[$uid] = true;
                    }
                }

            }
        }
    }

    $result = [];

    foreach (array_keys($userIdSet) as $uid) {

        $uf = "$USER_DIR/$uid.json";

        if (!file_exists($uf)) {
            continue;
        }

        $u = readJSON($uf);

        $result[] = [
            USER_ID => $uid,
            DISPLAY_NAME => $u[DISPLAY_NAME] ?? null,
            MODULE_ID => $u[MODULE_ID] ?? null,
            UPDATED => $u[UPDATED] ?? null,
            "hasImage" => file_exists("$IMAGE_DIR/$uid.jpg")
        ];
    }

    jsonResponse(array_values($result));
}


// ============================================================
// GET /feedback
// ============================================================

if ($method === "GET" && $endpoint === "feedback") {

    $access = requireAccess();

    $group = $_GET[FEEDBACK] ?? null;
    $path = $_GET[PATH_KEY] ?? null;
    $scope = strtolower((string) ($_GET[SCOPE_KEY] ?? SCOPE_MINE));
    $countParam = $_GET[COUNT_KEY] ?? 100;
    $userId = $access[USER_ID] ?? null;

    validateFeedbackGroup($group);
    requireFeedbackGroupAccess($access, $group);

    if ($path !== null && $path !== "") {
        validateFeedbackPath($path);
    } else {
        $path = null;
    }

    if (!preg_match('/^\d+$/', (string) $countParam)) {
        bad("Invalid count");
    }

    $count = (int) $countParam;

    if ($count < 1 || $count > 500) {
        bad("Invalid count");
    }

    if ($scope !== SCOPE_MINE && $scope !== SCOPE_ALL) {
        bad("Invalid scope");
    }

    if ($scope === SCOPE_ALL && !($access[ADMIN] ?? false)) {
        bad("Admin access required", 403);
    }

    if ($scope === SCOPE_MINE) {
        if (!$userId) {
            bad("Feedback requires userId", 403);
        }

        validateUserId($userId);
    }

    $start = isset($_GET[START_KEY]) ? parseTimestampFilter(START_KEY, $_GET[START_KEY]) : null;
    $end = isset($_GET[END_KEY]) ? parseTimestampFilter(END_KEY, $_GET[END_KEY]) : null;

    if ($start !== null && $end !== null && $start > $end) {
        bad("Invalid range");
    }

    $searchRoot = buildFeedbackDirectory($group, $path);
    $items = [];

    if (is_dir($searchRoot)) {

        $it = new RecursiveIteratorIterator(
            new RecursiveDirectoryIterator($searchRoot, FilesystemIterator::SKIP_DOTS)
        );

        foreach ($it as $file) {

            if (!$file->isFile() || $file->getExtension() !== JSON_EXTENSION_WITHOUT_POINT) {
                continue;
            }

            $timestampRaw = $file->getBasename(JSON_EXTENSION);

            if (!preg_match('/^\d+$/', $timestampRaw)) {
                continue;
            }

            $timestamp = (int) $timestampRaw;

            if ($start !== null && $timestamp < $start) {
                continue;
            }

            if ($end !== null && $timestamp > $end) {
                continue;
            }

            $relativeFile = substr($file->getPathname(), strlen(buildFeedbackDirectory($group)) + 1);
            $relativeFile = str_replace("\\", "/", $relativeFile);
            $parts = explode("/", $relativeFile);

            if (count($parts) < 3) {
                continue;
            }

            $entryUserId = $parts[count($parts) - 2];
            $entryPathParts = array_slice($parts, 0, -2);
            $entryPath = implode("/", $entryPathParts);

            validateUserId($entryUserId);

            if ($scope === SCOPE_MINE && $entryUserId !== $userId) {
                continue;
            }

            $items[] = [
                "timestamp" => $timestamp,
                USER_ID => $entryUserId,
                PATH_KEY => $entryPath,
                "file" => $file->getPathname()
            ];
        }
    }

    usort($items, function (array $left, array $right): int {
        return $right["timestamp"] <=> $left["timestamp"];
    });

    $items = array_slice($items, 0, $count);
    $responseItems = [];

    foreach ($items as $item) {
        $responseItems[] = [
            FEEDBACK => $group,
            PATH_KEY => $item[PATH_KEY],
            USER_ID => $item[USER_ID],
            "timestamp" => $item["timestamp"],
            PAYLOAD => json_decode(file_get_contents($item["file"]), true)
        ];
    }

    $timestamps = array_column($items, "timestamp");

    jsonResponse([
        FEEDBACK => $group,
        PATH_KEY => $path,
        SCOPE_KEY => $scope,
        COUNT_KEY => count($responseItems),
        "oldestTimestamp" => $timestamps ? min($timestamps) : null,
        "newestTimestamp" => $timestamps ? max($timestamps) : null,
        "items" => $responseItems
    ]);
}


// ============================================================
// GET /image
// ============================================================

if ($method === "GET" && $endpoint === "image") {

    $access = requireAccess();

    $uid = $_GET[USER_ID] ?? null;

    if (!$uid) {
        bad("Missing userId");
    }

    validateUserId($uid);

    // Must have at least read access
    if (empty($access[VIEW]) && empty($access[WRITE])) {
        bad("No permission", 403);
    }

    global $IMAGE_DIR;

    $file = "$IMAGE_DIR/$uid.jpg";

    if (!file_exists($file)) {
        jsonResponse([IMAGE => null]);
    }

    jsonResponse([
        IMAGE => "data:image/jpeg;base64," . base64_encode(file_get_contents($file))
    ]);
}


// ============================================================
// Fallback
// ============================================================

http_response_code(404);

echo json_encode([ERROR_KEY => "Endpoint not found"]);
