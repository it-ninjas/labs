---
title: "Git Hands On Aufgabe"
linkTitle: "Git"
type: docs
weight: 3
description: >
  Hands On Aufgabe für Git
---

### Schritt 1: Initialisiere das Git-Repository

1. Öffne dein Terminal oder die Kommandozeile.
2. Erstelle ein neues Verzeichnis und navigiere in dieses.
3. Initialisiere ein neues Git-Repository.

### Schritt 2: Erstelle eine konfliktverursachende Datei

1. Erstelle eine neue Datei mit dem Namen `index.txt` und füge einen Satz hinzu.
2. Speichere die Datei und committe die initiale Version.

### Schritt 3: Erstelle einen neuen Branch und mache Änderungen

1. Erstelle einen neuen Branch mit dem Namen `feature_branch`.
2. Öffne die `index.txt` Datei und ändere den Inhalt.
3. Speichere die Datei.

### Schritt 4: Stashe die Änderungen im Feature-Branch

1. Bevor du den Feature-Branch in den Master-Branch mergst, stashe zuerst die Änderungen.

### Schritt 5: konfliktverursachende Änderungen auf Master

1. Wechsle zurück zum master-Branch.
2. Öffne die `index.txt` Datei und ändere den Inhalt.
3. Speichere die Datei und committe die Änderungen.

### Schritt 6: Cherry-Picke den Feature-Branch

1. Cherry-Picke jetzt die Änderungen aus dem Feature-Branch in den Master-Branch.

### Schritt 7: Merge den Feature-Branch und löse den Konflikt

1. Du wirst einen Konflikt in der `index.txt` Datei erhalten. Öffne die Datei und löse den Konflikt.
2. Speichere die Datei und committe den gelösten Konflikt.

### Schritt 8: Wende den Stash an

1. Jetzt können wir den Stash auf den Master-Branch anwenden, um die zuvor gestashten Änderungen wiederherzustellen.
2. Du wirst wieder einen Konflikt in der `index.txt` Datei erhalten. Öffne die Datei und löse den Konflikt.
3. Speichere die Datei und committe den gelösten Konflikt.