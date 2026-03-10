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

// Ensure all required directories exist
foreach ([$ROOT, $ACCESS_DIR, $USER_DIR, $GROUP_DIR, $IMAGE_DIR, $TRACKING_DIR] as $d) {
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
const DISPLAY_NAME = "displayName";
const MODULE_ID = "moduleId";
const UPDATED = "updated";
const IMAGE = "image";


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

    file_put_contents($file, json_encode($data, JSON_PRETTY_PRINT));
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

    return $_GET[ACCESS_KEY] ?? null;
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

        if (!$file->isFile()) continue;

        if ($file->getExtension() !== JSON_EXTENSION_WITHOUT_POINT) continue;

        // Extract prefix key from filename
        $base = $file->getBasename(JSON_EXTENSION);

        $parts = explode("_", $base, 2);

        $fileKey = $parts[0];

        if ($fileKey === $accessKey) {
            return readJSON($file->getPathname());
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

        if (!$file->isFile()) continue;

        if ($file->getExtension() !== JSON_EXTENSION_WITHOUT_POINT) continue;

        $base = $file->getBasename(JSON_EXTENSION);

        $parts = explode("_", $base, 2);

        $fileKey = $parts[0];

        $data = readJSON($file->getPathname());

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

    $raw = json_decode(file_get_contents("php://input"), true);

    if (!$raw) bad("Invalid JSON");

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

    $raw = json_decode(file_get_contents("php://input"), true);

    if (!$raw) bad("Invalid JSON");

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

        file_put_contents(
            "$TRACKING_DIR/$uid.log",
            $line,
            FILE_APPEND | LOCK_EX
        );

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

        if (!$g) continue;

        $gf = "$GROUP_DIR/$g.json";

        if (!file_exists($gf)) continue;

        $gdata = readJSON($gf);

        if (is_array($gdata)) {

            $isAssoc = array_keys($gdata) !== range(0, count($gdata) - 1);

            if ($isAssoc) {

                foreach ($gdata as $uid => $v) {
                    if ($uid) $userIdSet[$uid] = true;
                }

            } else {

                foreach ($gdata as $uid) {
                    if ($uid) $userIdSet[$uid] = true;
                }

            }
        }
    }

    $result = [];

    foreach (array_keys($userIdSet) as $uid) {

        $uf = "$USER_DIR/$uid.json";

        if (!file_exists($uf)) continue;

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