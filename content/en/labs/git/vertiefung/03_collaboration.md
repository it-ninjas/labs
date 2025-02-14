---
title: "Aufgabe: Arbeiten im Team an einem Projekt"
linkTitle: "Zusammenarbeit 1"
type: docs
weight: 4
description: >
  Aufgabe Zusammenarbeit an einem Projekt ohne Merge-Konflikte [Git Vertiefung](../../../../docs/git/vertiefung/collaboration)
---

In dieser Aufgabe wird die Zusammenarbeit an einem gemeinsamen Projekt ohne Merge-Konflikte simuliert.
Dazu führt jedes Team-Mitglied die nachfolgenden Aktionen auf seinem Rechner aus. Der Lead Developer
legt fest, wer welchen Teil in welcher Datei ändern soll.

Die Schritte 1 bis 5 sind Einzelaufgaben, die jeder Ninja selbständig lösen muss/kann. Schritt 6 ist
eine Teamaufgabe und muss ebenfalls für jeden Feature-Branch ausgeführt werden.

### Schritt 1: Neuen Branch auschecken

1. Starte IntelliJ.
2. Wechsle zum ersten Projekt (Menu › File › Recent Projects).
3. Aktualisiere den lokalen Stand von Git (Menu › Git › Fetch).
4. Checke den oben erstellten Branch aus (Menu › Git › Branches...).

### Schritt 2: Dateien mit ausschliessen

Das Verzeichnis .idea soll von der Versionsverwaltung ausgeschlossen werden. Nutze dazu den passenden
Eintrag aus dem Git-Menu.

### Schritt 3: Unterschiedliche Dateien bearbeiten

Jedes Teammitglied bekommt vom Lead-Developer eine andere Datei für Änderungen zugewiesen bzw. wählt
eine Datei aus. Es werden nur kleine Änderungen vorgenommen, wie z.B.

- zusätzliche Ausgabe über System.out.println,
- Auslagern von Code in eine eigene Methode,
- oder kleinere Verbesserungen.

Durch die Änderungen sollten keine zusätzlichen Fehler im Programm eingebaut werden, es können aber
bekannte Fehler behoben werden. Für die Änderungen sollte nicht mehr als eine halbe Stunde Zeit
benötigt werden.

### Schritt 4: Änderungen auf den Branch pushen

Nun sollen die Änderungen committed und auf den remote Feature-Branch gepusht werden. Gehe dazu in
IntelliJ auf

- _Git › Commit_ im Menu
- oder _Git › Push_ über das Kontextmenu auf dem Projekt.

Wähle unter Changes die geänderten Dateien aus und übertrage sie mit _Commit and Push..._ in das lokale
und remote Git-Repository.

### Schritt 5: Pull Request erstellen

Gehe in Bitbucket (Browser) auf den FeatureBranch und

1. erstelle einen Pull Request (Pull Requests oder Pull-Anfragen in der Seitenleiste),
2. achte dabei darauf, das du `develop` als Zielbranch ausgewählt hast und
3. kontrolliere den Pull Request auf Konflikte.

### Schritt 6: Zusammenführen

Dieser Schritt muss mindestens vom Besitzer des Feature-Branches und vom Lead Developer gemeinsam
bearbeitet werden. Es wird aber empfohlen, dass jeweils alle Team-Mitglied teilnehmen, um den Merge-Vorgang
in Bitbucket zu üben.

1. Ruft den Pull Request in Bitbucket auf.
2. Vergleicht die Codeänderungen des aktuellen Pull Requests zum Stand von `develop` via _diff_.
3. Fügt mindestens ein Team-Mitglied als Prüfer hinzu. (Achtung das kann nicht der Ersteller des Pull Requests sein!)
4. Genehmigt nun als Prüfer den Pull Request (grüner Button).
5. Mergt den Pull Request (sofern dies nicht automatisch startet).
