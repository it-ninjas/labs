---
title: "Git Hands On Aufgabe"
linkTitle: "Git"
type: docs
weight: 3
description: >
  Hands On Aufgabe für [Git](../../../../docs/git/)
---

### Schritt 1: Initialisiere ein Git-Repository

1. Öffne dein Terminal oder die Kommandozeile.
2. Erstelle ein neues Verzeichnis.
3. Navigiere in das gerade erstellte Verzeichnis.
4. Initialisiere ein neues Git-Repository.
   ```shell
   git init
   git status
   ```

### Schritt 2: Erstelle eine konfliktverursachende Datei

1. Erstelle eine neue Datei mit dem Namen `index.txt` und füge einen Satz hinzu.
2. Speichere die Datei und committe die initiale Version.
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
2. Öffne die `index.txt` Datei und ändere den Inhalt. Die Änderung soll dabei auf der gleichen Zeile sein wie den Satz den du zuvor hinzugefügt hast. Z.B. `Mein Satz` zu `Mein viel besserer Satz`.
3. Speichere die Datei.

### Schritt 4: Änderungen im Feature-Branch stashens

1. Bevor du den Feature-Branch in den Master-Branch mergst, stashe zuerst die Änderungen.
   ```shell
   git stash save "My stashed changes"
   git stash list
   ```

### Schritt 5: Konfliktverursachende Änderungen auf Master hinzufügen

1. Wechsle zurück zum `master`-Branch.
2. Öffne die `index.txt` Datei und ändere den Inhalt.
3. Speichere die Datei und committe die Änderungen.
   ```
   git add index.txt
   git commit -m "Changed something in index.html"
   ```

### Schritt 6: Änderungen aus dem Feature-Branch in den Master-Branch picken

Übernimm nun den letzten Commit aus dem Feature-Branch in den Master-Branch, mithilfe von `cherry-pick`.

1. Mit `git log --oneline` den letzten Commit-Hash anzeigen, in diesem Fall wäre das `ea95358`.

   ```⏲ 38ms
   6238890 (HEAD -> master) Changed something in index.html
   ea95358 (feature/my-cool-branch) Added index.txt
   ```

2. Danach die Änderungen aus dem Feature-Branch cherry-picken.

   ```
   git log --oneline
   git cherry-pick <COMMIT-HASH>
   ```

3. Wenn alles richtige gemacht wurde, erscheint danach eine Warnung über einen Merge-Konflikt.
   ```
   Auto-merging index.txt
   CONFLICT (add/add): Merge conflict in index.txt
   error: could not apply ea95358... Added index.txt
   ...
   ```

### Schritt 7: Löse den Merge-Konflikt

Um den Merge-Konflikt zu lösen, öffnest du am besten IntelliJ(empfohlen) oder Visual Studio Code. Du kannst es natürlich auch über das Terminal versuchen, wenn du mutig genug bist.

Grundsätzlich entsteht ein Merge-Conflict, wenn am gleichen Ort unterschiedliche Änderungen vorgenommen wurden. Git kann dann die Änderungen nicht mehr automatisch zusammenführen (mergen).

Git zeigt einen Merge-Konflikt mithilfe von `<<<`, `>>>` und `===` an. Der Text bei `<<<` sind deine Änderungen, die Änderungen bei `>>>` kommen aus dem Remote-Repository. Getrennt werden sie durch eine Zeile an Gleichzeichen `===`. Oft abstrahiert deine IDE diese Darstellung jedoch noch.

Bei dieser List von Hobbies wurde lokal die Zeile "Schlafen" hinzugefügt, remote wurde auf der gleichen Zeile jedoch "Gym" hinzugefügt.

```
- Lesen
- Gamen
<<<<<<< HEAD
- Schlafen
=======
- Gym
>>>>>>> 3c55804e0fa4cac9002edb45443d4a9c95bc26b4
```

Um den Konflikt zu lösen hast folgende Möglichkeiten:

- Du behältst deine Änderungen und verwirfst die Anderen
  ```
  - Lesen
  - Gamen
  - Schlafen
  ```
- Du verwirfst deine Änderungen und behältst die Anderen
  ```
  - Lesen
  - Gamen
  - Gym
  ```
- Du behältst alle Änderungen
  ```
  - Lesen
  - Gamen
  - Schlafen
  - Gym
  ```
- Du verwirfst beide Änderungen
  ```
  - Lesen
  - Gamen
  ```
- Eine Mischung aus allen vorherigen Möglichkeiten
  ```
  - Lesen
  - Gamen
  - Schlafen oder Gym
  ```

Um einen Merge-Konflikt zu lösen, musst du also aus diesen Möglichkeiten auswählen. Du kannst das für jeden Konflikt unterschiedlich machen. Deine IDE wird dir dabei einige Hilfestellungen liefern, welche den Prozess etwas vereinfachen, siehe dazu die Felder weiter unten.

<details>
   <summary>Konflikt mit IntelliJ lösen</summary>
   <p>
      IntelliJ hat ein eingebautes UI um Merge Konflikte zu lösen. JetBrains stellt eine <a href="https://www.jetbrains.com/help/idea/resolve-conflicts.html">super Anleitung</a> zur Verfügung.
   </p>
</details>

<details>
   <summary>Konflikt mit Visual Studio Code lösen</summary>
   <p>
      Visual Studio Code hat sogar zwei verschiedene Arten, wie du Merge-Konflikte lösen kannst. Einen eher simpeln Ansatz, "Inline Editor" genannt, und einen der etwas mehr an IntelliJ erinnert, "3-Way Editor" genannt.
   </p>
   <p>
      Eine gute Anleitung zu beiden findest du <a href="https://monsterlessons-academy.com/posts/resolving-merge-conflicts-in-visual-studio-code-the-easy-way">hier</a>.
   </p>
</details>
   
<details>
<summary>Vim schliessen</summary>
Je nach Betriebssystem und Einstellungen, kann es sein das Git automatisch den Texteditor Vim öffnet. Das sieht dann etwa so aus wie im Bild unten.

Um den Editor wieder zu schliessen, kannst du die folgende Schritte verwenden:

1. `ESC` drücken
2. `:` drücken
3. `q!` eintippen
4. `ENTER` drücken
   ![](../images/vim.png "Vim")

</details>

Es gibt noch unzählige weitere Tools wie [Meld](http://meldmerge.org/) oder vimdiff, welche dazu genutzt werden können Merge-Konflikte zu lösen. Du darfst dich gerne durchprobieren und das Tool wählen, welches dir am besten gefällt. Für die meisten reicht das Tooling ihrer IDE.

### Schritt 8: Änderungen vom Stash anwenden

1. Jetzt können wir die Änderungen auf dem Stash, dem Master-Branch hinzufügen.

   ```shell
   git stash pop 0
   ```

2. Du wirst wieder einen Konflikt in der `index.txt` Datei erhalten. Löse den Konflikt. Du kannst das wieder mit dem Tool deiner Wahl machen.
3. Speichere die Datei und mache einen Commit.
