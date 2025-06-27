---
title: "Konfiguration"
type: docs
menu:
  main:
    identifier: "config-de"
    weight: 6
---

<!-- prettier-ignore-start -->

it-ninjas bietet dir einige einfache Konfigurationsmöglichkeiten, die dir die Arbeit erleichtern.  
Du kannst diese Einstellungen jederzeit anpassen – ganz nach deinen Bedürfnissen.

{{< ninja warning >}}
**Zu deiner Sicherheit:** Diese Einstellungen werden nur lokal in deinem Browser gespeichert und verlassen deinen Rechner nicht.  
Das bedeutet allerdings, dass du sie auf einem anderen Gerät erneut eingeben musst.
{{< /ninja >}}

{{< ninja info >}}
Die Einstellungen dienen dazu, Inhalte, welche für dich nicht relevant sind auszublenden. Es handelt sich dabei um keine
vertraulichen Informationen oder Geheimnisse...
{{< /ninja >}}

<div id="loading-indicator" style="color: #555; font-style: italic; margin-bottom: 1em;">
  ⏳ Einstellungen werden geladen...
</div>

<form id="config-form" style="display: none;">
  <label for="username">Benutzername:</label><br />
  <input type="text" id="username" name="username" /><br /><br />

  <label for="localrepo">Pfad zum lokalen Repository (dort wo du deine Übungen speichern willst):</label><br />
  <input type="text" id="localrepo" name="localrepo" style="width: 100%;" /><br /><br />

  <label for="os">Betriebssystem des Entwicklungsrechners:</label><br />
  <select id="os" name="os">
    <option value="Windows">Windows</option>
    <option value="Linux">Linux</option>
  </select><br /><br />

  <label for="apprenticeshipprovider">Wahl der Ausbildungsstätte:</label><br />
  <select id="apprenticeshipprovider" name="apprenticeshipprovider">
    <option value="">(keine)</option>
    <option value="SBB">SBB</option>
    <option value="89grad">89grad</option>
    <option value="Puzzle ITC">Puzzle ITC</option>
    <option value="unic">unic</option>
  </select><br /><br />

  <button type="submit">Speichern</button>

</form>

<p id="save-status" style="color: green; display: none;">Einstellungen gespeichert!</p>

<script>
  function getWithDefault(key, fallback) {
    const value = localStorage.getItem(key);
    if (value === null || value === '') {
      console.log(`ℹ️ ${key} not defined → Use default value: "${fallback}"`);
      return fallback;
    } else {
      console.log(`✅ ${key} loaded: "${value}"`);
      return value;
    }
  }

  function loadSettings(){
    console.log("🚀 Load settings...");

    const username = getWithDefault('itninja_username', 'u123456');
    const os = getWithDefault('itninja_os', 'Windows');
    const apprenticeshipprovider = getWithDefault('itninja_apprenticeshipprovider', '');

    let defaultPath = 'C:\\Users\\u123456\\local_repos\\it-ninja-labs';
    if (os.toLowerCase() === 'linux') {
      defaultPath = '/home/u123456/repos.local/it-ninjas-lab';
    }
    defaultPath = defaultPath.replace("u123456", username);
    window.defaultRepoPath = defaultPath; //store for later

    const localrepo = getWithDefault('itninja_localrepo', defaultPath);

    // init form
    document.getElementById('username').value = username;
    document.getElementById('localrepo').value = localrepo;
    document.getElementById('os').value = os;
    document.getElementById('apprenticeshipprovider').value = apprenticeshipprovider;

    document.getElementById('loading-indicator').style.display = 'none';
    document.getElementById('config-form').style.display = 'block';

    console.log("✅ Settings loaded...");
  }

  function saveSettings(){
    e.preventDefault();

    const username = document.getElementById('username').value;
    const os = document.getElementById('os').value;
    const apprenticeshipprovider = document.getElementById('apprenticeshipprovider').value;
    const localrepoInput = document.getElementById('localrepo').value;

    localStorage.setItem('itninja_username', username);
    localStorage.setItem('itninja_os', os);
    localStorage.setItem('itninja_apprenticeshipprovider', apprenticeshipprovider);

    if (localrepoInput === window.defaultRepoPath) {
      localStorage.setItem('itninja_localrepo', '');
      console.log('ℹ️ Default-Repository path detected → store empty string');
    } else {
      localStorage.setItem('itninja_localrepo', localrepoInput);
      console.log(`✅ Custom-Repository path saved: "${localrepoInput}"`);
    }

    const status = document.getElementById('save-status');
    status.style.display = 'block';

    setTimeout(() => location.reload(), 500); // 🔁 Reload after short break
  }

  // ---------------------------------------------------
  // Main
  // ---------------------------------------------------
  // when loading document...
  window.addEventListener('DOMContentLoaded', () => {
    loadSettings();
  });

  // when pressing submit
  document.getElementById('config-form').addEventListener('submit', (e) => {
    saveSettings();
  });
</script>
<!-- prettier-ignore-end -->
