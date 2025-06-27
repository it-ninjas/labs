---
title: "Java Exercises - Exception Handling"
linkTitle: "Java Exercises - Exception Handling"
type: docs
weight: 9
description: >
  Aufgaben zu Modul #J5 - [Exception Handling](../../../docs/02_java/09_java-exception_handling)
---

Die folgenden Aufgaben bestehen zum Teil aus Exception Handling. Behandle die Exception also auch so, wie es in der Theorie erklärt wurde.

## Aufgabe 1: File Reader

[Hier](https://github.com/dwyl/english-words/raw/master/words.txt) findest du eine Datei, welche eine Liste mit ungefähr 466 Tausend englischen Wörtern enthält.

Schreibe eine Anwendung, welche diese Wörter einlesen kann, und schreibe jeweils eine Methode für die folgenden Aufgaben:

- Zähle alle Wörter in dieser Liste
- Zähle alle Wörter, welche den Buchstaben Q benutzen
- Gib alle Sonderzeichen zurück, welche in der Liste vorkommen (jedes Zeichen wird nur einmal zurückgegeben)
- 2 weitere Methoden deiner Wahl

Implementiere vorher ein Interface, um deine Methoden zu definieren.
Zudem wird erwartet, dass ein eigenes Testing (wie in [J4 Testing](../../../../docs/02_java/08_java-testing) gelernt) zu der Umsetzung gehört.

## Aufgabe 2: File Writing

Die Verwendung von `System.out.println()` hat das Problem, dass nach einem Neustart der Applikation alle Logs aus der Konsole verschwinden, dies kann mit der Zeit mühsam werden.
Schreibe eine Klasse mit mindestens einer öffentlichen Methode, welcher man einen Text als Parameter gibt. Die Methode soll diesen Text zuerst in eine Datei mit dem Namen application.log speichern und nachher mit `System.out.println()` in die Konsole schreiben. Achte auch hier wieder auf ein entsprechendes Exception Handling.
Zudem wird erwartet, dass ein eigenes Testing (wie in [J4 Testing](../../../../docs/02_java/08_java-testing) gelernt) zu der Umsetzung gehört.

## Aufgabe 3: ParseInt

Wenn wir Zahlen von einem User über die Konsole entgegennehmen wollen, kann man `scanner.nextLine()` brauchen. Wir können aber nie sicher sein, ob es sich bei der Eingabe wirklich um eine Zahl handelt. Darum müssen wir mit einem Exception Handling die Programmlogik vor einem solchen Fall schützen.

Schreibe eine Anwendung, welche den User einzeln für zwei Zahlen fragt und diese dann entweder addiert, subtrahiert, multipliziert, oder dividiert. Die Auswahl der Rechnungsmethode kann zufällig oder durch den Benutzer erfolgen.
Zudem wird erwartet, dass ein eigenes Testing (wie in [J4 Testing](../../../../docs/02_java/08_java-testing) gelernt) zu der Umsetzung gehört.

---

Hier kannst du [zurück zur Theorie](../../../../docs/02_java/09_java-exception_handling/).
