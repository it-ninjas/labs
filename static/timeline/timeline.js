// =====================================================================
// Configuration
// =====================================================================

const SERVER_URL = "https://ninja.sirprepo.com/api";

const avatarCache = {};
let lastUsers = [];
let newImagePending = false;

console.log("[init] SERVER_URL =", SERVER_URL);


// =====================================================================
// Local user object
// =====================================================================

let ninja = {
    accessKey: "",
    userId: null,         // null => kein Avatar / read-only
    displayName: "",
    image: "",
    moduleId: null,
    posX: null,
    posY: null
};


let lastModuleId = null;
let lowestModuleId = null;
let loggedIn = false;

console.log("[init] ninja initial:", ninja);


// =====================================================================
// Local Storage
// =====================================================================

function loadNinja() {
    console.log("[loadNinja] reading localStorage");

    const raw = localStorage.getItem("ninja");
    if (!raw) {
        console.log("[loadNinja] none found");
        return;
    }

    ninja = JSON.parse(raw);
    console.log("[loadNinja] loaded:", ninja);

    if (!ninja.accessKey) {
        console.log("[loadNinja] no accessKey – skip");
        return;
    }

    setTimeout(async () => {
        console.log("[loadNinja] auto me() start");
        await loadMe(); // neue Funktion (siehe Punkt 3)
    }, 200);
}

async function loadMe() {

    if (!ninja.accessKey) return false;

    let res;
    let data;

    try {
        res = await fetch(`${SERVER_URL}/me?accessKey=${encodeURIComponent(ninja.accessKey)}`);
        data = await res.json();
    } catch (err) {
        console.warn("[me] error", err);
        return false;
    }

    console.log("[me] resp:", data);

    if (res.status !== 200 || data.error) {
        console.warn("[me] failed");
        return false;
    }

    loggedIn = true;

    // server decides if user has an avatar (userId present) and whether can write
    ninja.userId      = data.userId ?? null;
    ninja.displayName = ninja.displayName ?? data.displayName ?? null;
    ninja.moduleId    = data.moduleId ?? ninja.moduleId;

    // If we have an avatar userId, fetch image
    if (ninja.userId) {
        await loadMyImage();
    }

    saveNinja();

    // snap + show only if userId exists
    if (ninja.userId) {
        let id = ninja.moduleId || lowestModuleId;
        let moduleEl = document.querySelector(`[data-module-id="${id}"]`);
        if (moduleEl) snapAvatarToModule(moduleEl);
        showAvatar();
    } else {
        hideAvatar();
    }

    return true;
}

async function loadMyImage() {

    if (!ninja.accessKey || !ninja.userId) return;

    try {
        const res = await fetch(
            `${SERVER_URL}/image?accessKey=${encodeURIComponent(ninja.accessKey)}&userId=${encodeURIComponent(ninja.userId)}`
        );
        const data = await res.json();

        ninja.image = data.image || "";
    } catch (err) {
        console.warn("[loadMyImage] error", err);
    }
}

function saveNinja() {
    console.log("[saveNinja] saving:", ninja);
    localStorage.setItem("ninja", JSON.stringify(ninja));
}

async function toBase64(file) {
    return new Promise(resolve => {
        const r = new FileReader();
        r.onload = e => resolve(e.target.result);
        r.readAsDataURL(file);
    });
}

// =====================================================================
// Access helpers
// =====================================================================

function hasAccess() {
    return ninja.accessKey != null && ninja.accessKey !== "";
}

function canWrite() {
    return ninja.userId != null && ninja.userId !== "";
}

// =====================================================================
// Dialog
// =====================================================================

function openDialog() {
    console.log("[openDialog]", ninja);
    document.getElementById("ninjaDialog").classList.remove("hidden");
    updateDialogUI();
}

function updateDialogUI() {

    document.getElementById("ninjaKey").value  = ninja.accessKey || "";
    document.getElementById("ninjaName").value = ninja.displayName || "";

    const key     = document.getElementById("ninjaKey");
    const name    = document.getElementById("ninjaName");
    const image   = document.getElementById("ninjaImage");

    const btnSave   = document.getElementById("ninjaSave");
    const btnLogout = document.getElementById("ninjaLogout");

    // reset
    key.readOnly = false;

    name.style.display    = "none";
    image.style.display   = "none";
    btnSave.style.display = "none";
    btnLogout.style.display = "none";
    image.disabled = true;
    name.disabled   = true;        

    // --------------------------------------------------
    // Zustand A – kein AccessKey
    // --------------------------------------------------
    if (!hasAccess()) {
        btnSave.style.display = "inline-block";
        return;
    }

    // AccessKey vorhanden → immer readonly
    key.readOnly = true;

    // --------------------------------------------------
    // Zustand B – Read only
    // --------------------------------------------------
    if (!canWrite()) {
        btnLogout.style.display = "inline-block";
        return;
    }

    // --------------------------------------------------
    // Zustand C – Read + Write
    // --------------------------------------------------
    image.disabled = false;
    name.disabled   = false;        
    name.style.display  = "block";
    image.style.display = "block";

    btnSave.style.display   = "inline-block";
    btnLogout.style.display = "inline-block";
}

function logout() {

    if (!confirm("Zugriff wirklich entfernen?")) return;

    ninja.accessKey = null;
    ninja.userId = null;
    ninja.displayName = "";
    ninja.image = null;
    loggedIn = false;

    saveNinja();

    hideAvatar();
    closeDialog();
}

function closeDialog() {
    console.log("[closeDialog]");
    document.getElementById("ninjaDialog").classList.add("hidden");
}

async function saveDialog() {
    console.log("[saveDialog] save pressed");

    ninja.accessKey  = document.getElementById("ninjaKey").value.trim();
    ninja.displayName = document.getElementById("ninjaName").value.trim();

    // 1️⃣ Kein Access → abbrechen, Dialog bleibt offen
    if (!ninja.accessKey) {
        alert("Access-Key fehlt");
        updateDialogUI();
        return;
    }

    // 2️⃣ Access prüfen
    const ok = await loadMe();   // <-- dein /me Endpoint
    updateDialogUI();
    if (!ok) {
        alert("Ungültiger Access-Key");
        return;                  // ❗ Dialog bleibt offen
    }

    // 3️⃣ Schreibrecht → DisplayName Pflicht
    if (canWrite()) {
        ninja.displayName = document.getElementById("ninjaName").value.trim();
        if (!ninja.displayName) {
            alert("Anzeige-Name fehlt");
            updateDialogUI();
            return;              // ❗ Dialog bleibt offen
        }
    }

    const file = document.getElementById("ninjaImage").files[0];

    if (file) {
        console.log("[saveDialog] new image file:", file.name);
        ninja.image = await resizeImageToMax400(file);
        newImagePending = true;
        showAvatar();
    }

    saveNinja();

    if (canWrite() && ninja.moduleId) {
        await sendUpdatePosition();
    }
  
    // upload new image
    if (newImagePending) {
        await sendUpdateImage();
        newImagePending = false;
    }

    closeDialog();               // ✅ nur wenn alles OK
}


async function resizeImageToMax400(file) {

    return new Promise((resolve, reject) => {

        const img = new Image();
        const reader = new FileReader();

        reader.onload = e => img.src = e.target.result;
        reader.onerror = reject;

        img.onload = () => {

            const max = 400;
            let { width, height } = img;

            if (width > height) {
                if (width > max) {
                    height = Math.round(height * (max / width));
                    width = max;
                }
            } else {
                if (height > max) {
                    width = Math.round(width * (max / height));
                    height = max;
                }
            }

            const canvas = document.createElement("canvas");
            canvas.width = width;
            canvas.height = height;

            const ctx = canvas.getContext("2d");

            // white background (PNG transparency!)
            ctx.fillStyle = "#fff";
            ctx.fillRect(0, 0, width, height);

            ctx.drawImage(img, 0, 0, width, height);

            // JPEG = much smaller than PNG
            const base64 = canvas.toDataURL("image/jpeg", 0.85);

            resolve(base64);
        };

        reader.readAsDataURL(file);
    });
}

// =====================================================================
// Avatar Rendering
// =====================================================================

const avatar = document.getElementById("ninjaAvatar");
let dragging = false;

function showAvatar() {

    if (!loggedIn) {
        avatar.classList.add("hidden");
        return;
    }

    if (!ninja.image) {
        avatar.style.background = "#333";
    } else {
        avatar.style.backgroundImage = `url(${ninja.image})`;
        avatar.style.backgroundSize  = "cover";
    }

    avatar.classList.remove("hidden");
}

function hideAvatar() {
    avatar.classList.add("hidden");
}


// =====================================================================
// Drag Events
// =====================================================================

function startDrag(e) {

    if (!loggedIn) return;
    if (!canWrite()) return;

    dragging = true;

    hideUserPopup();
    document.querySelectorAll(".other-ninja").forEach(e => e.remove());

    document.body.appendChild(avatar);
    avatar.style.position = "absolute";

    e.preventDefault();
}

function doDrag(e) {
    if (!dragging) return;

    const rect = avatar.getBoundingClientRect();
    const x = e.pageX - rect.width / 2;
    const y = e.pageY - rect.height / 2;

    avatar.style.left = x + "px";
    avatar.style.top  = y + "px";
}

async function endDrag() {
    if (!dragging) return;
    dragging = false;

    const moduleEl = detectModule();

    if (moduleEl) {
        snapAvatarToModule(moduleEl);
    } else {
        snapFallback();
    }

    saveNinja();
    await sendUpdatePosition();
    renderOthers(lastUsers);
}


// =====================================================================
// Detect module & Position snap
// =====================================================================

function detectModule() {
    const avatarRect = avatar.getBoundingClientRect();
    const modules = [...document.querySelectorAll(".module")];

    for (const mod of modules) {
        const r = mod.getBoundingClientRect();
        const x = avatarRect.left + avatarRect.width / 2;
        const y = avatarRect.top  + avatarRect.height / 2;

        const inside =
            x >= r.left &&
            x <= r.right &&
            y >= r.top &&
            y <= r.bottom;

        if (inside) return mod;
    }

    return null;
}

function snapAvatarToModule(moduleEl) {
    const r = moduleEl.getBoundingClientRect();
    const x = r.left + window.scrollX;
    const y = r.bottom + window.scrollY;

    avatar.style.position = "absolute";
    avatar.style.left = (x - 5) + "px";
    avatar.style.top  = (y - 55) + "px";

    ninja.moduleId = moduleEl.dataset.moduleId;
    ninja.posX = x;
    ninja.posY = y;
    lastModuleId = ninja.moduleId;
}

function snapFallback() {
    if (lastModuleId) {
        const el = document.querySelector(`[data-module-id="${lastModuleId}"]`);
        if (el) return snapAvatarToModule(el);
    }

    if (lowestModuleId) {
        const el = document.querySelector(`[data-module-id="${lowestModuleId}"]`);
        if (el) return snapAvatarToModule(el);
    }
}


// =====================================================================
// API Calls
// =====================================================================

async function sendUpdatePosition() {

    if (!loggedIn) return;
    if (!ninja.userId) return; 
    if (!ninja.moduleId) return;
    if (!canWrite()) return;

    const payload = {
        accessKey: ninja.accessKey,
        moduleId: ninja.moduleId,
        displayName: ninja.displayName
    };

    try {

        console.log("[sendUpdatePosition] post", payload);

        await fetch(`${SERVER_URL}/update-position`, {
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(payload)
        });
    }
    catch (err) {
        console.warn("[sendUpdatePosition] error", err);
    }
}

async function sendUpdateImage() {

    if (!canWrite()) {
        console.log("[sendUpdateImage] skip – no write access");
        return;
    }

    if (!ninja.image) {
        console.log("[sendUpdateImage] skip – no image");
        return;
    }

    const payload = {
        accessKey: ninja.accessKey,
        image: ninja.image
    };

    console.log("[sendUpdateImage] post", payload);

    await fetch(`${SERVER_URL}/update-image`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    });
}

// =====================================================================
// Load others
// =====================================================================

async function loadOthers() {

    if (!loggedIn || !ninja.accessKey){
        hideOthers();
        return;
    }
    const url = `${SERVER_URL}/list?accessKey=${encodeURIComponent(ninja.accessKey)}`;

    let users;

    try {
        const res = await fetch(url);
        users = await res.json();
    }
    catch (err) {
        console.warn("[loadOthers] error", err);
        return;
    }

    if (!Array.isArray(users)) return;

    await loadMissingImages(users);
    lastUsers = users;
    renderOthers(users);
}


// =====================================================================
// Load missing images
// =====================================================================

async function loadMissingImages(users) {

    for (const u of users) {
        if (!u.userId) continue;
        if (avatarCache[u.userId]) continue;

        const url = `${SERVER_URL}/image?accessKey=${encodeURIComponent(ninja.accessKey)}&userId=${encodeURIComponent(u.userId)}`;

        try {
            const res = await fetch(url);
            const data = await res.json();
            avatarCache[u.userId] = data.image || null;
        }
        catch (err) {
            console.warn("[loadMissingImages] error", u.userId, err);
        }
    }
}


// =====================================================================
// Render others
// =====================================================================
function hideOthers() {
    document.querySelectorAll(".other-ninja").forEach(e => e.remove());
    document.querySelectorAll(".other-ninja-popup").forEach(e => e.remove());
}

function renderOthers(list) {

    hideOthers();

    if (dragging) return;

    const groups = {};

    for (const u of list) {

        if (ninja.userId && u.userId === ninja.userId) {
            u.moduleId = ninja.moduleId;
        }

        if (!u.moduleId) continue;

        if (!groups[u.moduleId]) groups[u.moduleId] = [];
        groups[u.moduleId].push(u);
    }

    for (const [moduleId, users] of Object.entries(groups)) {

        const mod = document.querySelector(`[data-module-id="${moduleId}"]`);
        if (!mod) continue;

        const r = mod.getBoundingClientRect();
        const x = r.left + window.scrollX;
        const y = r.bottom  + window.scrollY;

        const me = users.find(u => u.userId === ninja.userId);
        const others = users.filter(u => u.userId !== ninja.userId);

        if (me && others.length > 0) {
            renderMyBadge(others, x, y);
            continue;
        }

        if (!me && others.length === 1) {
            renderSingleOther(others[0], x, y);
            continue;
        }

        if (!me && others.length > 1) {
            renderGroupOther(others, x, y);
            continue;
        }
    }
}


// =====================================================================
// Popup components
// =====================================================================

function renderMyBadge(users, x, y) {

    if (dragging) return;

    const count = users.length;
    const badge = document.createElement("div");
    badge.className = "other-ninja";

    badge.textContent = "+" + count;

    badge.style.position = "absolute";
    badge.style.left = (x + 44) + "px";
    badge.style.top  = (y - 14) + "px";
    badge.style.width = "18px";
    badge.style.height= "18px";
    badge.style.borderRadius = "50%";
    badge.style.background = "rgba(200,20,20,0.9)";
    badge.style.color = "white";
    badge.style.fontSize = "11px";
    badge.style.fontWeight = "bold";
    badge.style.display = "flex";
    badge.style.alignItems = "center";
    badge.style.justifyContent = "center";
    badge.style.zIndex = "2000";
    badge.style.cursor = "pointer";

    badge.addEventListener("mouseenter", () => showGroupPopup(users, x + 50, y));
    badge.addEventListener("mouseleave", hideUserPopup);

    document.body.appendChild(badge);
}

function renderSingleOther(u, x, y) {

    let size = 40;

    const el = document.createElement("div");
    el.className = "other-ninja";

    const img = avatarCache[u.userId];

    if (img) {
        el.style.backgroundImage = `url(${img})`;
        el.style.backgroundSize = "cover";
    } else {
        el.textContent = "?";
    }

    el.style.position = "absolute";
    el.style.left = (x - 5 ) + "px";
    el.style.top  = (y - size + 5) + "px";
    el.style.width = size + "px";
    el.style.height= size + "px";
    el.style.borderRadius = "50%";
    el.style.backgroundColor = "#666";
    el.style.zIndex = "1500";

    el.addEventListener("mouseenter", () => showGroupPopup([u], x + 50, y));
    el.addEventListener("mouseleave", hideUserPopup);

    document.body.appendChild(el);
}

function renderGroupOther(users, x, y) {

    let size = 40;

    const el = document.createElement("div");
    el.className = "other-ninja";

    el.textContent = users.length;

    el.style.position = "absolute";
    el.style.left = (x - 5) + "px";
    el.style.top  = (y - size + 5) + "px";
    el.style.width = size + "px";
    el.style.height= size + "px";
    el.style.borderRadius = "50%";
    el.style.backgroundColor = "rgba(0,0,0,0.7)";
    el.style.color = "white";
    el.style.fontSize = "18px";
    el.style.fontWeight = "bold";
    el.style.display = "flex";
    el.style.alignItems = "center";
    el.style.justifyContent = "center";
    el.style.zIndex = "1500";
    el.style.cursor = "default";

    el.addEventListener("mouseenter", () => showGroupPopup(users, x + 50, y));
    el.addEventListener("mouseleave", hideUserPopup);

    document.body.appendChild(el);
}

function hideUserPopup() {
    document.querySelectorAll(".other-ninja-popup").forEach(e => e.remove());
}

function showGroupPopup(users, x, y) {
    if (dragging) return;

    hideUserPopup();

    const pop = document.createElement("div");
    pop.className = "other-ninja-popup";

    pop.style.position = "absolute";
    pop.style.left = x + "px";
    pop.style.top  = y + "px";
    pop.style.background = "rgba(40,40,40,0.95)";
    pop.style.padding = "8px 10px";
    pop.style.borderRadius = "6px";
    pop.style.color = "white";
    pop.style.fontSize = "13px";
    pop.style.boxShadow = "0 2px 6px rgba(0,0,0,0.35)";
    pop.style.zIndex = "3000";
    pop.style.pointerEvents = "none";

    for (const u of users) {

        const row = document.createElement("div");
        row.style.display = "flex";
        row.style.alignItems = "center";
        row.style.marginBottom = "6px";

        // avatar small
        const img = avatarCache[u.userId];
        if (img) {
            const icon = document.createElement("div");
            icon.style.width = "20px";
            icon.style.height= "20px";
            icon.style.borderRadius = "50%";
            icon.style.backgroundImage = `url(${img})`;
            icon.style.backgroundSize = "cover";
            icon.style.marginRight = "6px";
            row.appendChild(icon);
        }

        // name
        const name = document.createElement("div");
        name.textContent = u.displayName;
        row.appendChild(name);

        pop.appendChild(row);
    }

    document.body.appendChild(pop);
}

// =====================================================================
// UI Dialog Styling (minimal nice)
// =====================================================================

function applyDialogStyles() {

    const dlg = document.getElementById("ninjaDialog");
    dlg.style.position = "fixed";
    dlg.style.left = "50%";
    dlg.style.top = "50%";
    dlg.style.transform = "translate(-50%, -50%)";
    dlg.style.background = "#222";
    dlg.style.padding = "20px";
    dlg.style.borderRadius = "8px";
    dlg.style.boxShadow = "0 4px 10px rgba(0,0,0,0.5)";
    dlg.style.color = "white";
    dlg.style.zIndex = "5000";
    dlg.style.minWidth = "320px";

    dlg.querySelectorAll("input").forEach(i => {
        i.style.width = "100%";
        i.style.marginBottom = "10px";
        i.style.padding = "6px 8px";
        i.style.borderRadius = "4px";
        i.style.border = "1px solid #444";
        i.style.background = "#333";
        i.style.color = "white";
    });

    dlg.querySelectorAll("button").forEach(b => {
        b.style.marginTop = "10px";
        b.style.padding = "8px 14px";
        b.style.borderRadius = "4px";
        b.style.border = "none";
        b.style.cursor = "pointer";
        b.style.fontWeight = "bold";
    });

    document.getElementById("ninjaSave").style.background = "#0a8";
    document.getElementById("ninjaClose").style.background = "#555";
}




// =====================================================================
// Init
// =====================================================================

function determineLowestModuleId() {

    const modules = [...document.querySelectorAll(".module")];
    let ids = modules.map(m => parseInt(m.dataset.moduleId, 10)).filter(n => !isNaN(n));

    if (ids.length === 0) return;

    ids.sort((a,b) => a-b);
    lowestModuleId = ids[0].toString();
}

window.addEventListener("DOMContentLoaded", () => {

    document.addEventListener("modules-ready", timelineInit, { once: true });
});

function timelineInit() {

    applyDialogStyles();

    const btnSave  = document.getElementById("ninjaSave");
    const btnOpen  = document.getElementById("ninjaBtn");
    const btnClose = document.getElementById("ninjaClose");
    const btnLogout= document.getElementById("ninjaLogout");

    if (btnSave)  btnSave.onclick  = saveDialog;
    if (btnOpen)  btnOpen.onclick  = openDialog;
    if (btnClose) btnClose.onclick = closeDialog;
    if (btnLogout) btnLogout.onclick = logout;

    // Drag handlers
    avatar.addEventListener("mousedown", startDrag);
    window.addEventListener("mousemove", doDrag);
    window.addEventListener("mouseup", endDrag);

    // Init from storage
    determineLowestModuleId();
    loadNinja();

    // Poll others
    loadOthers();
    setInterval(loadOthers, 5000);
}
