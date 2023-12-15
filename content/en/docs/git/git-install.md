---
title: "Install Git"
linkTitle: "Install Git"
weight: 2
---

## Inhalt

* [Git unter Linux installieren](#git-unter-linux-installieren)
* [Git unter Windows installieren](#git-unter-windows-installieren)

## Git unter Linux installieren

1. Ist Git schon installiert? `git --version`
2. Falls nicht:
    * Debian basierte Linux (Ubuntu): `sudo apt install git`
    * Redhat basierte Linux (Fedora, Rocky Linux): `sudo dnf install git`

## Git unter Windows installieren

1.  Navigiere zum [Git für Windows Installer](https://git-scm.com/download/win) und lade die neuste Version herunter.
2.  Folge den Installationsanweisungen bis die Installation abgeschlossen ist. 
    - Es wird empfohlen während der Installation Git Bash zu installieren
    ![Git Setup Bash](../git-install/git-setup-bash.png "Git Setup Bash")
    - Es wird empfohlen während der Installation den PATH zu ändern.
    ![Git Setup PATH](../git-install/git-setup-path.png "Git Setup PATH")
3.  Öffne Git Bash
4.  Schreibe `git version` zum Überprüfen, ob Git erfolgreich installiert wurde.
