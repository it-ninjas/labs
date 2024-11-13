---
title: "Aufgabe: Arbeiten mit mehreren Projekten"
linkTitle: "Arbeiten an mehreren Projekten"
type: docs
weight: 6
description: >
  Aufgabe Arbeiten an mehreren Projekten [Git Vertiefung](../../../../docs/git/vertiefung/parallel-processing)
---
In diesem Lab soll die Arbeit mit mehreren Git Repositories kennengelernt werden. Dazu wird in einer 
ersten Aufgabe zwischen zwei Repositories gewechselt und jeweils kleinere Änderungen vorgenommen.

Diese Aufgabe ist eine Einzelaufgabe, die von jedem IT-Ninja eigenständig bearbeitet werden muss.

### Schritt 1: Feature-Branch auf dem 2. Repository erstellen
1. Starte deinen Browser!
2. Rufe die Bitbucketseite mit dem zweiten Repository auf!
3. Klicke auf *Branch erstellen*!
4. Wähle den *Branch-Typ* "Feature" aus!
5. Wähle unter *Branch von* "develop" aus!
6. Trage als *Branch-Name*  "Modul-S3-‹dein Vorname›-projekte" ein (ohne Anführungszeichen)!
7. Klicke auf *Branch erstellen*!

### Schritt 2: Neu erstellten Branch auschecken
1. Starte IntelliJ!
2. Wechsle zum zweiten Projekt (Menu › File › Recent Projects)!
3. Klicke bei der entsprechenden Nachfrage "This Window" an!  
4. Aktualisiere den lokalen Stand von Git (Menu › Git › Fetch)!
5. Checke den oben erstellten Branch aus (Menu › Git › Branches...)!

### Schritt 3: Codeänderung
Suche dir eine beliebige Datei des Projekts und ändere einige Codezeilen. Speichere die Änderungen, 
aber führe kein commit aus.

### Schritt 4: Zu Projekt 1 wechseln
1. Wechsle nun zu deinem Feature-Branch von Projekt 1!
2. Klicke bei der entsprechenden Nachfrage "This Window" an. (Der Arbeitsbereich der IDE wird wieder auf das 1. Projekt gesetzt.)
3. Überprüfe, dass wirklich das erste Projekt geladen ist. Du solltest das am Projektnamen erkennen 
und daran, dass keine uncommitteten Änderungen vorhanden sind.

### Schritt 5: Zu Projekt 2 wechseln
Wechsle zurück auf das Projekt zwei und kontrolliere den aktuellen Stand. Deine Änderungen sollten
vorhanden und in der Commit Vorschau auswählbar sein.

Du kannst nun den lokalen Arbeitsbereich zwischen verschiedenen Projekten wechseln. Da bei unterschiedlichen 
Repositories (Projekten) der Zeiger auf das Wurzelverzeichnis des Projekts in der IDE geändert wird,
werden hierbei keine lokalen Daten überschrieben.

### Schritt 6: Projekt in 2. IDE-Fenster öffnen
1. Wähle über *Menu › File › Recent Projects* das erste Projekt aus!
2. Klicke bei der entsprechenden Nachfrage "New Window" an. Es wird eine neue Instanz der IDE mit eigenem Arbeitsbereich geöffnet.
3. Jetzt kannst du durch Switchen der geöffneten IDE-Instanz an beiden Projekten arbeiten.

Mit dieser 2. Variante hast du die Möglichkeit mehrere Repositories direkt in einem lokalen Arbeitsbereich 
zu öffnen und ohne Wartezeit zwischen ihnen zu wechseln.



