---
title: "Objektorientierte Programmierung Exam"
linkTitle: "Objektorientierte Programmierung Exam"
type: docs
weight: 2
description: >
  Exam zu Modul #J2
---
*Für dieses Exam dürfen auch Inhalte der Themen Lists und Generics verwendet werden.*


## Weltmeisterschaft - OOP Exam

Bei diesem Lab geht es darum, dass du deine Vorgehensweise beim Erstellen eines objekt-orientiertem Modell trainierst.

Zentral bei dieser Aufgabe ist also, wie du das Datenmodell erstellst, welches beschreibt, welche Klassen mit welchen Feldern und Methoden du schreibst.

Ziel ist nicht, dass du dich mit `Scanner`n oder viel Logik herumschlagen musst.

### Sachverhalt

Bei diesem Lab modellierst du das Turnier von der Fussball-WM 1954 in der Schweiz. Im Prinzip sollst du die Informationen, die in der <a href="../results.txt" download>`results.txt`</a>-Datei gespeichert sind, abbilden.

Deine Klassen sollen folgendes abbilden:

* In diesem Turnier (Competition) spielen die Mannschaften (Team) gegeneinander. 
* Jedes Spiel beschreibt entweder eine Vorrunde/Gruppenspiel (GROUP), Play-Off, Viertel- (QUARTER), Halbfinale (SEMI) oder Finale.
* Bei jedem Spiel (Game) gibt es immer eine Heim- (home) und Gast-Mannschaft (visiting/away team).
* Bei jedem Spiel wird festgehalten, wie viele Tore (goals) welche Mannschaft (home oder visiting) geschossen hat. Zudem wird festgehalten, wo (location) das Spiel stattgefunden hat.
* Über die Mannschaften (Team) wissen wir, wie sie heissen (name), z.B. "Schweiz".


### Was soll die Anwendung können?

Auf Stufe Spiel (Game)
* möchten wir erfahren können, ob eine bestimmte Mannschaft dieses Spiel gespielt hat (didTeamPlayThisGame(team)).
* Zudem möchten wir schnell ermitteln können, wie viele Punkte eine Mannschaft in diesem Spiel erzielt hat (Sieg: 3, Unentschieden: 1, Niederlage: 0) (getPointsFor(team)).

Auf Stufe Turnier (Competition)
* wollten wir ermitteln können, welche Mannschaft wie viele Punkte während der Gruppenphase erzielt hat (getScoresDuringGroupStageFor(team)).
* Zudem möchten wir herausfinden, wie viele Tore eine Mannschaft während des ganzen Turniers geschossen hat (getGoalsForTeam(team)).
* Des Weiteren wollen wir eine Auflistung, welche Spiele alles an einem bestimmten Ort (location) stattgefunden haben (getAllGamesForLocation(location)).

Abgesehen von der `main(...)`-Methode soll keine weitere Methode statisch sein.


### Aufgaben

#### Aufgabe 1 - Entwurf
![task1](/images/task.png) Erstelle einen Entwurf vom Klassenmodell.
* Der Entwurf kann auf Papier oder mit einem Tool (z.B. draw.io, Visio, plantUML) erstellt werden.
* Plane auch schon die Methoden im Entwurf ein.

Zeige den Entwurf zuerst einem Coach, bevor du weiterfährst.


#### Aufgabe 2 - Klassen umsetzen
![task1](/images/task.png) Setzte die Klassen im Code um, inkl. Methoden.

Für den Moment müssen die Methoden noch nichts machen und sollen für den Beginn nur einen Default-Wert zurückgeben - der Einfachheit halber.

Ziel dieser Aufgabe ist, dass du dich nur aufs Klassen-Design im Code konzentrierst, nicht aber um die konkreten Methoden-Umsetzungen.

#### Aufgabe 3 - Methoden umsetzen
![task1](/images/task.png) Setze nun die Methoden korrekt um.

Lade hierfür die Daten aus der <a href="../results.txt" download>`results.txt`</a>-Datei. Du sollst die Daten nicht via Dateisystem laden, sondern du kannst die Informationen aus dieser Datei direkt hartkodiert in eine `.java`-Datei hineinschreiben. Wenn dir dein Vorgehen ineffizient vorkommt, dann finde heraus/frage nach, wie du das schneller machen kannst, z.B. indem du mehrere Zeilen gleichzeitig bearbeitest.
