---
title: "Aufgabe: Arbeiten im Team an einem Projekt"
linkTitle: "Zusammenarbeit 2"
type: docs
weight: 5
description: >
  Aufgabe Zusammenarbeit an einem Projekt mit Merge-Konflikten [Git Vertiefung](../../../../docs/git/vertiefung/collaboration)
---

In dieser Aufgabe wird die Zusammenarbeit an einem gemeinsamen Projekt mit Merge-Konflikte und deren
Lösung simuliert. Dazu führt jedes Team-Mitglied die nachfolgenden Aktionen auf seinem Rechner aus.
Der Lead Developer legt fest, welche Datei geändert werden soll.

Die Schritte 1 bis 4 sind Einzelaufgaben, die jeder Ninja selbständig lösen muss/kann. Die Schritte
5 bis 7 sind Teamaufgaben.

### Schritt 1: Feature-Branch aktualisieren

**Diese Aufgabe kann erst gestartet werden, wenn alle Feature-Branches aus dem [vorherigen Lab](../../../labs/git/vertiefung/03_collaboration)
erfolgreich gemergt wurden.**
1. Starte IntelliJ!
2. Wechsle zum ersten Projekt (Menu › File › Recent Projects)!
3. Achte darauf, dass du auf deinem Feature-branch arbeitest!
4. Aktualisiere den lokalen Stand von Git (Menu › Git › Fetch)!
5. Aktualisiere den Stand des Feature-Branch mit *Git › rebase* von `develop`!

### Schritt 2: Bearbeiten der gleichen Codestelle

Jedes Teammitglied führt Änderungen an der Methode/Datei aus, die vorher gemeinsam festlegt wurde.
Achte darauf, dass die Änderungen auf den einzelnen Feature-Branches zwar die gleichen Codezeilen
betreffen, aber nicht identisch sind.

Die Änderungen sollten nicht mehr als eine halbe Stunde Zeit benötigen.

### Schritt 3: Änderungen auf den Branch pushen

Anschliessend werden die Änderungen committet und auf den remote Feature-Branch gepusht.
Gehe dazu in IntelliJ auf
- *Git › Commit...* im Menu
- oder *Git › Push...* über das Kontextmenu auf dem Projekt.

Wähle unter Changes die geänderten Dateien aus und übertrage sie mit *Commit and Push...* in das
lokale und remote Git-Repository.

### Schritt 4: Pull Request erstellen und überprüfen

Gehe in Bitbucket (Browser) auf den Feature-Branch und

1. Erstelle einen Pull Request (Pull Requests oder Pull-Anfragen in der Seitenleiste)!
2. Achte dabei darauf, das du `develop` als Zielbranch ausgewählt hast!
3. Kontrolliere den Pull Request auf Konflikte!
(Solange noch kein Pull Request gemergt wurde, sollten hier keine Konflikte auftreten.)

### Schritt 5: Mergen des ersten Feature-Branch

Legt ein Team-Mitglied fest, welches seinen Feature-Branch als erstes auf `develop` mergt. Bei dieser
Aktion sollte es noch nicht zu Konflikten kommen.

### Schritt 6: Mergen der übrigen Feature-Branches

Legt nun die Reihenfolge fest, in der die übrigen Feature-Branches auf `develop` gemergt werden sollen.
Führt die folgenden Schritte jeweils vollständig aus, bevor ihr mit dem nächsten Branch startet.

1. Wechselt auf den Pull Request!
2. Kontrolliert den aktuellen Zusatnd (es sollten Konflikte vorhanden sein)!
3. Überprüft den Code mit *diff*!
4. Löst den Konflikt manuell oder folgt den Empfehlungen von Bitbucket!
5. Genehmigt den Pull Request, wenn der Konflikt gelöst ist! (Achtung, das kann nicht der Ersteller des Pull Requests machen!)
6. Führt Merge auf `develop` aus!
7. Wiederholt Punkt 1 bis 6 für den nächsten Pull Request!

### Schritt 7: Überprüfen des finalen Standes

Geht nun zum `develop` Branch und überprüft, ob alle Änderungen korrekt übernommen wurden. In der Praxis
sollten Tests (Unittests und/oder integrative Tests) existieren, die ohne Fehler ausführbar sein müssen.
