---
title: "Git Hands On Aufgabe"
linkTitle: "Git"
type: docs
weight: 3
description: >
  Hands On Aufgabe für [Git](../../../../docs/git/)
---

### Schritt 1: Initialisiere ein Git-Repository

1. Öffne dein Terminal oder die Kommandozeile
2. Erstelle ein neues Verzeichnis und navigiere in dieses
3. Initialisiere ein neues Git-Repository mit `git init`

### Schritt 2: Erstelle eine konfliktverursachende Datei

1. Erstelle eine neue Datei mit dem Namen `index.txt` und füge einen Satz hinzu.
2. Speichere die Datei und committe die initiale Version
   ```shell
   git add index.txt
   git commit -m "Add index.txt"
   ```

### Schritt 3: Erstelle einen neuen Branch und mache Änderungen

1. Erstelle einen neuen Branch mit dem Namen `feature/my-cool-feature`.
   ```shell
   git branch feature/my-cool-feature
   git switch feature/my-cool-feature
   ```
2. Öffne die `index.txt` Datei und ändere den Inhalt.
3. Speichere die Datei.

### Schritt 4: Änderungen im Feature-Branch stashen

1. Bevor du den Feature-Branch in den Master-Branch mergst, stashe zuerst die Änderungen.
   ```shell
   git stash save "My stashed changes"
   git stash list
   ```

### Schritt 5: Konfliktverursachende Änderungen auf Master hinzufügen

1. Wechsle zurück zum master-Branch.
2. Öffne die `index.txt` Datei und ändere den Inhalt.
3. Speichere die Datei und committe die Änderungen.
   ```
   git add index.txt
   git commit -m "Changed something in index.html"
   ```

### Schritt 6: Änderungen aus dem Feature-Branch in den Master-Branch picken

Übernimm nun den letzten Commit aus dem Feature-Branch in den Master-Branch, mithilfe von `cherry-pick`.

1. Mit `git log --oneline` den letzten Commit-Hash anzeigen, in diesem Fall wäre das `ea95358`

   ```⏲ 38ms
   6238890 (HEAD -> master) Changed something in index.html
   ea95358 (feature/my-cool-branch) Added index.txt
   ```

2. Danach die Änderungen aus dem Feature-Branch cherry-picken

   ```
   git log --oneline
   git cherry-pick <COMMIT-HASH>
   ```

3. Wenn alles richtige gemacht wurde, erscheint danach eine Warnung über einen Merge-Konflikt
   ```
   Auto-merging index.txt
   CONFLICT (add/add): Merge conflict in index.txt
   error: could not apply ea95358... Added index.txt
   ...
   ```

### Schritt 7: Löse den Merge-Konflikt

Um den Merge-Konflikt zu lösen, öffnest du am besten Visual Studio Code oder IntelliJ. Du kannst es natürlich auch über das Terminal versuchen, wenn du mutig genug bist.

<details>
<summary>Vim schliessen</summary>
Je nach Betriebssystem und Einstellungen, kann es sein das git automatisch den Texteditor Vim öffnet. Das sieht dann etwa so aus wie im Bild unten.

Um den Editor wieder zu schliessen, kannst du die folgende Schritte verwenden:

1. `ESC` drücken
2. `:` drücken
3. `q!` eintippen
4. `ENTER` drücken
   ![](../images/vim.png "Vim")

</details>

### Schritt 8: Wende den Stash an

1. Jetzt können wir den Stash auf den Master-Branch anwenden, um die zuvor gestashten Änderungen wiederherzustellen.

```shell
git stash pop 0
```

2. Du wirst wieder einen Konflikt in der `index.txt` Datei erhalten. Öffne die Datei und löse den Konflikt. Du kannst das wieder mit dem Tool deiner Wahl machen.
3. Speichere die Datei und committe den gelösten Konflikt.
