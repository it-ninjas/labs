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
ssh-keygen -t rsa -b 4096 -C "[deine-email]"
```

- Drücke `Enter` für den Standardspeicherort
- Optional: Passphrase setzen

> Die Schlüssel befinden sich in `C:\Users\[username]\.ssh\`:
>
> - `id_rsa` (privat, **niemals weitergeben**)
> - `id_rsa.pub` (öffentlich)

---

### 3. SSH-Schlüssel zu Bitbucket hinzufügen

```bash
type C:\Users\u123456\.ssh\id_rsa.pub
```

> In Windows kannst du die Datei auch einfach mit notepad.exe öffnen und den Inhalt kopieren.

- Kopiere den Inhalt und füge ihn unter [SSH-Key hinzufügen](https://code.sbb.ch/plugins/servlet/ssh/account/keys) ein

---

### 4. Repository klonen

> Die genaue URL kannst du im Bitbucket bei deinem erstellten Projekt nachschauen.

{{< ninja tip>}}
Wie Word-Dokumente unter `Dokumente` abgelegt werden, legen wir unseren Quellcode in einem seperaten Ordner ab. In der
Talent Factory habe wir uns für `C:\Users\u123456\local_repos` entschieden.
{{< /ninja>}}

```bash
mkdir C:\Users\u123456\local_repos
cd C:\Users\u123456\local_repos
git clone ssh://git@codessh.sbb.ch:7999/~u123456/it-ninja-[deinName].git
```

---

### 5. Praxisbildner berechtigen

1. Repository in Bitbucket öffnen
2. Zu **Repository Settings → Repository Permissions** navigieren
3. **Add user or group** klicken
4. Praxisbildner als Administratoren hinzufügen

{{< /sbb >}}
