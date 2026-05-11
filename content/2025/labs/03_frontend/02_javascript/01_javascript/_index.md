---
title: "JavaScript - Aufgaben"
linkTitle: "JavaScript - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #F4 - JavaScript
---

### Aufgabe 1 - Seite mit Joke

![task1](/images/task.png) Schreibe eine Website, die auf Knopfdruck einen Witz anzeigt.

Verwende hierfür die Juck Norris-API: `GET https://api.chucknorris.io/jokes/random`

Solltest du fertig mit dieser Aufgabe sein, dann melde dich bei einem Praxisbildner.

### Aufgabe 2 - Global Scope, Function Scope und Block-Scope

Im Kapitel [ES6: Variablen deklarieren](../../../../docs/03_frontend/03_javascript/19_variables#global-scope-und-function-scope) hast du die Funktionsweise vom Global und Function Scope kennengelernt mit einem Beispiel-Code mit `console.log(...)`s. In diesem Beispiel wurden alle Variablen mit `var` deklariert/definiert - also keine `let`s oder `const`s.

![task1](/images/task.png) Ändere in diesem Code alle `var`s zu `let`s oder `const`s.

Beantworte folgende Fragen und dokumentiere deine Antworten:

- Was ist ein Scope?
- Was sind Global Scope, Function Scope und Block-Scope? Was sind die Unterschiede?
- Mit welchem Scope arbeitest du in Java? Begründe.
- Wie werden Variablen im globalen Scope definiert?
- Wie kannst du definieren, welche Variable welchen Scope haben soll?
- Wann könnte die Verwendung von `var` sinnvoll sein?

### Aufgabe 3 - Nummern Liste

Erstelle eine HTML-Seite, auf der ein Benutzer eine Liste von Zahlen eingeben kann.
Die Eingabe soll geprüft werden, damit der Benutzer nur Zahlen eingeben kann. Der Benutzer kann die Liste speichern und
dann Operationen auf der Liste durchführen lassen. Es sind folgende Operationen gefordert:

- Die grösste Zahl der Liste finden.
- Die kleinste Zahl der Liste finden.
- Die Summe aller geraden Zahlen der Liste finden.
- Die Summe der ungeraden Zahlen der Liste finden.
- Die Liste der grösse nach sortieren.
- Alle Zahlen der Liste zusammenrechnen.
- Den Durchschnitt der Liste errechnen.

Die Ergebnisse der Operationen sollen dem Benutzer im HTML angezeigt werden.


### Aufgabe 5

Schreibe eine Funktion, die ein Array von Objekten erwartet. Jedes Objekt im Array repräsentiert einen Schüler mit den folgenden Eigenschaften:

- name: Der Name des Schülers
- grades: Ein Array von Noten des Schülers (in Dezimalzahlen)

Jeder Schüler darf nur einmal vorkommen, also keine Duplikate.

Die Funktion soll ein Promise zurückgeben, das den Durchschnitt der Noten aller Schüler berechnet und als Ergebnis ein Objekt zurückgibt, das den Durchschnitt als eine Dezimalzahl und eine Beschreibung des Durchschnitts enthält. Die Beschreibung sollte basierend auf folgendem generiert werden:

- Wenn der Durchschnitt 6,0 ist, soll die Beschreibung "Sehr gut" sein.
- Wenn der Durchschnitt grösser oder gleich 5,0 und kleiner als 6,0 ist, soll die Beschreibung "Gut" sein.
- Wenn der Durchschnitt grösser oder gleich 4,0 und kleiner als 5,0 ist, soll die Beschreibung "Befriedigend" sein.
- Wenn der Durchschnitt grösser oder gleich 3,0 und kleiner als 4,0 ist, soll die Beschreibung "Ausreichend" sein.
- Wenn der Durchschnitt kleiner als 3,0 ist, soll die Beschreibung "Mangelhaft" sein.

Schreibe zusätzlich eine Funktion, um neue Schüler zu erfassen. Der zu erfassende Schüler darf jedoch noch nicht existieren ansonsten soll eine Exception geworfen werden. Auch die Noten sollen validiert werden so, dass nur Dezimalzahlen als Noten akzeptiert werden und die Dezimalzahl muss zwischen 1.0 und 6.0 liegen.

Noch zu ergänzen sind je eine Funktion, welche beide auch ein Array von Schülern erwarten. Die eine Funktion soll den Schüler mit der besten und die andere Funktion mit dem schlechtesten Durchschnitt herausfinden. Die Funktionen sollen den Namen des Schülers und dessen Durchschnitt zurückgegeben. Versuche diese beiden Funktionen mit so wenig Redundanzen wie möglich zu schreiben (evtl. kann man eine Funktion draus machen).

Die letzte Funktion sollte ein Array von Schülern entgegennehmen und sie anhand des Durchschnitts ordnen. Der schlechteste Durchschnitt kommt zuerst. Die Funktion soll ein Promise mit nur den Namen aller Schüler zurückgeben, nachdem diese sortiert wurden.

Schreibe ein HTML-File, in welchem man neue Schüler hinzufügen kann und wo die Ergebnisse aus den Funktionen angezeigt werden.
