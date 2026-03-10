<?php

// ============================================================
// CORS
// ============================================================

$allowedOrigins = [
    "https://labs.it-ninjas.ch",
    "https://dosai.sirprepo.com",
    "https://ninja.sirprepo.com"
];

$origin = $_SERVER["HTTP_ORIGIN"] ?? "";

if (in_array($origin, $allowedOrigins)) {
    header("Access-Control-Allow-Origin: $origin");
}

header("Access-Control-Allow-Headers: Content-Type, X-Access-Key");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Content-Type: application/json");

if ($_SERVER["REQUEST_METHOD"] === "OPTIONS") {
    http_response_code(200);
    exit;
}

// ============================================================
// Paths
// ============================================================

$ROOT = __DIR__ . "/data";
$ACCESS_DIR = "$ROOT/access";
$USER_DIR   = "$ROOT/users";
$GROUP_DIR  = "$ROOT/groups";
$IMAGE_DIR  = "$ROOT/images";
$TRACKING_DIR = "$ROOT/tracking";

foreach ([$ROOT, $ACCESS_DIR, $USER_DIR, $GROUP_DIR, $IMAGE_DIR, $TRACKING_DIR] as $d) {
    if (!file_exists($d)) mkdir($d, 0777, true);
}

// ============================================================
// Helpers
// ============================================================

function bad(string $msg, int $code = 400) {
    http_response_code($code);
    echo json_encode(["error" => $msg]);
    exit;
}

function readJSON(string $file): array {
    return file_exists($file)
        ? json_decode(file_get_contents($file), true)
        : [];
}

function writeJSON(string $file, array $data): void {
    file_put_contents($file, json_encode($data, JSON_PRETTY_PRINT));
}

function requireFields(array $data, array $fields): void {
    foreach ($fields as $f) {
        if (!isset($data[$f]) || $data[$f] === "") {
            bad("Missing field: $f");
        }
    }
}

function normalizeHint(string $hint): string {
    $hint = str_replace("\\", "/", $hint);
    while (strpos($hint, "//") !== false) {
        $hint = str_replace("//", "/", $hint);
    }
    return trim($hint, "/");
}

// ============================================================
// Access-Key lookup (recursive, prefix match)
// ============================================================

function getAccessKey(): ?string {

    $h = $_SERVER["HTTP_AUTHORIZATION"] ?? null;

    if ($h && preg_match('/Bearer\s+(.*)$/i', $h, $m)) {
        return $m[1];
    }

    return $_GET["accessKey"] ?? null;
}

function findAccess(string $accessKey): ?array {
    global $ACCESS_DIR;

    $it = new RecursiveIteratorIterator(
        new RecursiveDirectoryIterator($ACCESS_DIR, FilesystemIterator::SKIP_DOTS)
    );

    foreach ($it as $file) {
        if (!$file->isFile()) continue;
        if ($file->getExtension() !== "json") continue;

        $name = $file->getBasename(); // inkl. .json

        // muss mit accessKey beginnen UND auf .json enden
        if (str_equal($name, "$accessKey.json")) {
            return readJSON($file->getPathname());
        }
    }

    return null;
}

function requireAdminAccess(string $accessKey): array {
    $access = findAccess($accessKey);
    if (!$access) bad("Invalid accessKey", 403);
    if (!($access["admin"] ?? false)) {
        bad("Admin access required", 403);
    }
    return $access;
}

// ============================================================
// Routing
// ============================================================

$method   = $_SERVER["REQUEST_METHOD"];
$endpoint = trim(basename(parse_url($_SERVER["REQUEST_URI"], PHP_URL_PATH)), "/");

// ============================================================
// GET /me
// ============================================================

if ($method === "GET" && $endpoint === "me") {

    $key = get_accessKey();
    if (!$key) bad("Missing accessKey");

    $access = findAccess($key);
    if (!$access) bad("Invalid accessKey", 403);

    $uid = $access["userId"] ?? null;
    if (!preg_match('/^[a-zA-Z0-9_\-]+$/', $uid)) {
        bad("Invalid userId");
    }
    $userFile = "$USER_DIR/$uid.json";
    $user = readJSON($userFile);
    
    echo json_encode([
        "userId" => $access["userId"] ?? null,
        "write"  => $access["write"]  ?? [],
        "view"   => $access["view"]   ?? [],
        "displayName" => $user["displayName"] ?? null,
        "image" => $user["image"] ?? null,
        "moduleId" => $user["moduleId"] ?? null,
    ]);
    exit;
}

// ============================================================
// GET /userinfo
// ============================================================
// Admin-only: list all access tokens with hint + userId
// ============================================================

if ($method === "GET" && $endpoint === "userinfo") {

    $accessKey = get_accessKey();
    $format    = strtolower($_GET["format"] ?? "json");

    if (!$accessKey) bad("Missing accessKey");

    $access = findAccess($accessKey);
    if (!$access) bad("Invalid accessKey", 403);

    if (empty($access["admin"]) || $access["admin"] !== true) {
        bad("Admin access required", 403);
    }

    // --------------------------------------------------------
    // Collect all access entries
    // --------------------------------------------------------

    $rows = [];

    $it = new RecursiveIteratorIterator(
        new RecursiveDirectoryIterator($ACCESS_DIR, FilesystemIterator::SKIP_DOTS)
    );

    foreach ($it as $file) {
        if (!$file->isFile()) continue;
        if ($file->getExtension() !== "json") continue;

        $base = $file->getBasename(".json");

        // accessKey is prefix before first "_" if present
        $parts = explode("_", $base, 2);
        $fileKey = $parts[0];

        $data = readJSON($file->getPathname());

        $hintParts = [];

        // hint from path (directory)
        $relPath = str_replace($ACCESS_DIR, "", $file->getPath());
        if ($relPath && $relPath !== DIRECTORY_SEPARATOR) {
            $hintParts[] = trim($relPath, "/\\");
        }

        // hint from filename suffix
        if (isset($parts[1])) {
            $hintParts[] = $parts[1];
        }

        $hint = normalizeHint(implode("/", $hintParts));

        $rows[] = [
            "accessKey" => $fileKey,
            "hint"      => $hint,
            "userId"    => $data["userId"] ?? null
        ];
    }

    // --------------------------------------------------------
    // Output formats
    // --------------------------------------------------------

    if ($format === "csv") {

        header("Content-Type: text/csv; charset=utf-8");

        echo "accessKey,hint,userId\n";
        foreach ($rows as $r) {
            echo sprintf(
                "\"%s\",\"%s\",\"%s\"\n",
                $r["accessKey"],
                $r["hint"],
                $r["userId"] ?? ""
            );
        }
        exit;
    }

    if ($format === "markdown") {

        header("Content-Type: text/markdown; charset=utf-8");

        echo "| Hint | AccessKey | UserId |\n";
        echo "|------|-----------|--------|\n";

        foreach ($rows as $r) {
            echo sprintf(
                "| %s | `%s` | %s |\n",
                $r["hint"],
                $r["accessKey"],
                $r["userId"] ?? ""
            );
        }
        exit;
    }

    // default: JSON
    echo json_encode($rows, JSON_PRETTY_PRINT);
    exit;
}

// ============================================================
// POST /update-image
// ============================================================

if ($method === "POST" && $endpoint === "update-image") {

    $raw = json_decode(file_get_contents("php://input"), true);
    if (!$raw) bad("Invalid JSON");

    requireFields($raw, ["image"]);

    $accessKey = get_accessKey();
    $img       = $raw["image"];

    $access = findAccess($accessKey);
    if (!$access) bad("Invalid accessKey", 403);

    // userId comes ONLY from access mapping
    $userId = $access["userId"] ?? null;
    if (!$userId) bad("No avatar allowed", 403);

    if (!str_starts_with($img, "data:image/")) {
        bad("Invalid image data");
    }

    $data = preg_replace('/^data:image\/\w+;base64,/', '', $img);
    file_put_contents("$IMAGE_DIR/$userId.jpg", base64_decode($data));

    echo json_encode(["ok" => true]);
    exit;
}

// ============================================================
// POST /update-position
// ============================================================

if ($method === "POST" && $endpoint === "update-position") {

    $raw = json_decode(file_get_contents("php://input"), true);
    if (!$raw) bad("Invalid JSON");

    requireFields($raw, ["moduleId", "displayName"]);

    $access = findAccess(get_accessKey());
    if (!$access) bad("Invalid accessKey", 403);

    if (empty($access["userId"])) bad("No avatar permission", 403);

    $uid   = $access["userId"];
    $mod   = $raw["moduleId"];
    $name  = $raw["displayName"];
    $now   = time();

    // update user state
    if (!preg_match('/^[a-zA-Z0-9_\-]+$/', $uid)) {
        bad("Invalid userId in access mapping");
    }
    $userFile = "$USER_DIR/$uid.json";
    $user = readJSON($userFile);

    // === tracking ===

    $lastModule = $user["moduleId"] ?? null;

    if ($lastModule !== $mod) {

        $ts = time();
        $line = "$uid;$mod;$ts\n";

        file_put_contents(
            "$TRACKING_DIR/$uid.log",
            $line,
            FILE_APPEND | LOCK_EX
        );
        $user["updated"]  = $ts;
    }

    $user["userId"]   = $uid;
    $user["moduleId"] = $mod;
    $user["updated"]  = $now;
    $user["displayName"] = $name;
    writeJSON($userFile, $user);

    // write into all write-groups
    foreach ($access["write"] ?? [] as $group) {
        $gFile = "$GROUP_DIR/$group.json";
        $g = readJSON($gFile);

        $g[$uid] = [
            "userId" => $uid,
            "moduleId" => $mod,
            "updated" => $now
        ];

        writeJSON($gFile, $g);
    }

    echo json_encode(["ok" => true]);
    exit;
}

// ============================================================
// GET /list
// ============================================================

// ============================================================
// GET /list?accessKey=ABC123
//   -> returns users that are in any group in (view U write)
// ============================================================

if ($method === "GET" && $endpoint === "list") {

    $key = get_accessKey();
    if (!$key) bad("Missing accessKey");

    $access = findAccess($key);
    if (!$access) bad("Invalid accessKey", 403);

    $view  = isset($access["view"])  && is_array($access["view"])  ? $access["view"]  : [];
    $write = isset($access["write"]) && is_array($access["write"]) ? $access["write"] : [];

    // union groups
    $groupsToRead = array_values(array_unique(array_merge($view, $write)));

    // ------------------------------------------------------------
    // Collect userIds from all allowed groups
    // ------------------------------------------------------------
    $userIdSet = []; // associative set: userId => true

    foreach ($groupsToRead as $g) {
        if (!$g) continue;

        $gf = "$GROUP_DIR/$g.json";
        if (!file_exists($gf)) continue;

        $gdata = readJSON($gf);

        // support both formats:
        // 1) ["u_aaa","u_bbb"]
        // 2) { "u_aaa": true, "u_bbb": true }
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

    // ------------------------------------------------------------
    // Build result from user files (unique by userId)
    // ------------------------------------------------------------
    $result = [];

    foreach (array_keys($userIdSet) as $uid) {

        $uf = "$USER_DIR/$uid.json";
        if (!file_exists($uf)) continue;

        $u = readJSON($uf);

        // minimal shape the frontend expects
        $result[] = [
            "userId"      => $uid,
            "displayName" => $u["displayName"] ?? null,
            "moduleId"    => $u["moduleId"] ?? null,
            "updated"     => $u["updated"] ?? null,
            "hasImage"    => file_exists("$IMAGE_DIR/$uid.jpg")
        ];
    }

    echo json_encode(array_values($result));
    exit;
}

// ============================================================
// GET /image
// ============================================================

if ($method === "GET" && $endpoint === "image") {

    $key = get_accessKey();
    $uid = $_GET["userId"] ?? null;

    if (!$key || !$uid) bad("Missing accessKey or userId");

    $access = findAccess($key);
    if (!$access) bad("Invalid accessKey", 403);

    // must have view or write permission
    if (empty($access["view"]) && empty($access["write"])) {
        bad("No permission", 403);
    }

    $file = "$IMAGE_DIR/$uid.jpg";
    if (!file_exists($file)) {
        echo json_encode(["image" => null]);
        exit;
    }

    echo json_encode([
        "image" => "data:image/jpeg;base64," . base64_encode(file_get_contents($file))
    ]);
    exit;
}

// ============================================================
// Fallback
// ============================================================

http_response_code(404);
echo json_encode(["error" => "Endpoint not found"]);
