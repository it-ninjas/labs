---
title: "Bitbucket Repository einrichten"
linkTitle: "Bitbucket Repository"
weight: 3
description: >
  Praktische Anleitung zur Einrichtung eines Git-Repositories in Bitbucket
---

## Voraussetzungen

- Du hast Zugriff auf das Git-Tool Bitbucket
- Git (inkl. Git-Bash) ist auf deinem Computer installiert. Falls nicht, siehe: [Git installieren](../../../../04_git/01_grundwissen/02_git-install)
- Du hast die Grundeinstellungen für Git vorgenommen:

{{< details title="Folgende Einstellungen sind gemeint:" >}}

```bash
git config --global user.name "u123456"
git config --global user.email "u123456@sbb.ch"
# Für Windows zusätzlich:
git config --global core.autocrlf true
git config --global core.longpaths true
```

{{< /details >}}

---

> Wende dich an deinen Praxisbildner, falls du nicht bei der SBB arbeitest (und falls Du bei SBB arbeitest, kannst du in der [Konfiguartion](../../../../../config#apprenticeshipprovider) die spezifischen Anleitungen und Informationen freischalten -> `Wahl der Ausbildungsstätte`).

{{< sbb raw>}}

## Schritt-für-Schritt Anleitung

### 1. Repository in Bitbucket erstellen

1. Öffne [Bitbucket](https://code.sbb.ch/)
2. Logge dich ggf. ein
3. Klicke oben rechts auf dein Profilbild → **View Profile**
4. Klicke auf **Create repository**
5. Vergib einen Namen (z. B. `it-ninja-[deinName]`) und klicke auf **Create Repository**

---

### 2. SSH-Schlüssel erstellen

```bash
ssh-keygen -t rsa -b 4096 -C "u123456@sbb.ch"
```

- Drücke `Enter` für den Standardspeicherort
- Optional: Passphrase setzen

> Die Schlüssel befinden sich in `C:\Users\u123456\.ssh\`:
>
> - `id_rsa` (privat, **niemals weitergeben**)
> - `id_rsa.pub` (öffentlich)

---

### 3. SSH-Schlüssel zu Bitbucket hinzufügen

```bash
type C:\Users\u123456\.ssh\id_rsa.pub
```

- Kopiere den Inhalt und füge ihn unter [SSH-Key hinzufügen](https://code.sbb.ch/plugins/servlet/ssh/account/keys) ein

---

### 4. Repository klonen

> Die genaue URL kannst du im Bitbucket bei deinem erstellten Projekt nachschauen.

```bash
mkdir C:\Users\u123456\local_repos
cd C:\Users\u123456\local_repos
git clone ssh://git@codessh.sbb.ch:7999/~u123456/it-ninja-[deinName].git
```

---

### 5. Projektstruktur anlegen

Falls du ein eigenes Projekt erstellen willst, kannst du jetzt die Projektstruktur anlegen.

```text
it-ninja-[deinName]/
| Example/
| └── src/
|     └── [main.java]
└── README.md
```

---

### 6. Snapshots (Commits) erstellen

```bash
cd it-ninja-[deinName]/J1
git add README.md
git commit -m "README hinzugefügt"
```

---

### 7. Änderungen auf Bitbucket hochladen

```bash
git push origin master
```

---

### 8. Ernstfall testen (Restore)

1. Lokales Repository löschen
2. Neu klonen:

```bash
cd C:\Users\u123456\local_repos
git clone ssh://git@codessh.sbb.ch:7999/~u123456/it-ninja-[deinName].git
```

3. Änderungen an README.md vornehmen
4. Committen und pushen

---

### 9. Praxisbildner berechtigen

1. Repository in Bitbucket öffnen
2. Zu **Repository Settings → Repository Permissions** navigieren
3. **Add user or group** klicken
4. Praxisbildner als Administratoren hinzufügen

{{< /sbb >}}
