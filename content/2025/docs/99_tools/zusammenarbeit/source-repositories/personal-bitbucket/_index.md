---
title: "Bitbucket Repository einrichten"
linkTitle: "Bitbucket Repository"
weight: 3
description: >
  Praktische Anleitung zur Einrichtung eines Git-Repositories in Bitbucket
---

## Voraussetzungen

- Du hast Zugriff auf das Git-Tool Bitbucket
- Git (inkl. Git-Bash) ist auf deinem Computer installiert. Falls nicht, siehe:
  [Git installieren](../../../../04_git/01_grundwissen/02_git-install)
- Du hast die Grundeinstellungen für Git vorgenommen:

  {{< code >}}
  git config --global user.name "u123456"  
  git config --global user.email "u123456@sbb.ch"

  # Für Windows zusätzlich:

  git config --global core.autocrlf true  
  git config --global core.longpaths true  
  {{< /code >}}

---

> Wende dich an deinen Praxisbildner, falls du nicht bei der SBB arbeitest (und falls Du bei SBB arbeitest, kannst du in
> der [!\*Konfiguartion](../../../../../config#apprenticeshipprovider) die spezifischen Anleitungen und Informationen
> freischalten -> `Wahl der Ausbildungsstätte`).

{{< sbb raw>}}

## Schritt-für-Schritt Anleitung

### 1. Öffne Bitbucket

1. Öffne [!Bitbucket](https://code.sbb.ch/)
2. Logge dich ggf. ein

---

### 2. SSH-Schlüssel erstellen

1. Öffne eine [CMD Shell](../../../shell/cmd/) und gib den folgenden Befehl ein:

{{< ninja info>}}
In früheren Versionen von diesem Modul wurden RSA-Keys eingesetzt. Da diese Keys nicht mehr als sehr sicher gelten
wechseln wir zu den besseren ed25519-Keys.
{{< /ninja>}}

{{< ninja warning>}}
**Existiert die Datei bereits, dann überschreibe sie nicht!**

Der ssh-key ist ein Schlüssel um sich mit anderen Rechnern zu verbinden. Ändert man diesen Schlüssel, muss man auf den
anderen Rechnern, wo man bisher Zugang hatte, überall den öffentlichen Teil (das Schlüsselloch) anpassen.
{{< /ninja>}}

```bash
  ssh-keygen -t ed25519 -C "deine.email@sbb.ch"
```

2. Drücke `Enter` für den Standardspeicherort

3. Optional: Passphrase setzen

{{< ninja info>}}
Da sich der Schlüssel auf deinem Rechner in deinem persönlichen Ordner befindet, ist es ok, den Schlüssel nicht durch
ein Passwort zu schützen.
{{< /ninja>}}

4. Die Schlüssel befinden sich in `C:\Users\[username]\.ssh\`:

> - `id_ed25519` (privat, **niemals weitergeben**)
> - `id_ed25519.pub` (öffentlich)

---

### 3. SSH-Schlüssel zu Bitbucket hinzufügen

1. Zeige den Öffentlichen Schlüssel an:

   ```bash
   type C:\Users\u123456\.ssh\id_ed25519.pub
   ```

   > In Windows kannst du die Datei auch einfach mit notepad.exe öffnen und den Inhalt kopieren.

2. Kopiere den Inhalt und füge ihn unter [SSH-Key hinzufügen](https://code.sbb.ch/plugins/servlet/ssh/account/keys) ein.

---

### 4. Erstelle ein Repository und klone es

1. Öffne dein **[Bitbucket Konto](https://code.sbb.ch/profile)**
2. Klicke auf **Repository erstellen**
3. Vergib einen Namen (z. B. `it-ninja-[deinName]`) und klicke auf **Repository erstellen**

4. Öffne auf deinem Rechner den Ordner, wo Repositories abgelegt werden sollen

   {{< ninja tip>}}
   Wie Word-Dokumente unter `Dokumente` abgelegt werden, legen wir unseren Quellcode in einem seperaten Ordner ab. In
   der Talent Factory haben wir uns für `C:\Users\u123456\local_repos` entschieden.
   {{< /ninja>}}

   Falls der Ordner noch nicht existiert, muss er zuerst erstellt werden:

   {{< code >}}
   mkdir C:\Users\u123456\local_repos
   {{< /code>}}

   Öffne ihn:
   {{< code >}}
   cd C:\Users\u123456\local_repos
   {{< /code>}}

5. Clone das Repository. Den Befehl dazu findest du auf der Seite von deinem Projekt. Er sollte in etwa so aussehen:
   {{< code >}}
   git clone ssh://git@codessh.sbb.ch:7999/~u123456/it-ninja-[deinName].git
   {{< /code>}}

---

### 5. Erstelle ein README.md und pushe es

{{< ninja warning>}}
Mit diesem Schritt wird sichergestellt, dass es keinen leeren Master Branch gibt.
{{< /ninja>}}

Führe die folgenden Befehle aus:

{{< code >}}
cd C:\Users\u123456\local_repos\it-ninja-[deinName]
echo it-ninja repository > ./README.md
git add .
git commit -m "Initial Commit"
git push
{{< /code>}}

### 6. Praxisbildner berechtigen

1. Repository in Bitbucket öffnen
2. Zu **Repository Settings → Repository Permissions** navigieren
3. **Add user or group** klicken
4. Praxisbildner als Administratoren hinzufügen

{{< /sbb >}}
