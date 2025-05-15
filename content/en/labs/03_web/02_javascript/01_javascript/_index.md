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

### Aufgabe 2 - Eine andere API anbinden

![task1](/images/task.png) Versuche, ein(e) andere(s) API/Backend anzubinden und etwas auf einer Website anzuzeigen.

### Aufgabe 3 - Uhr

![task1](/images/task.png) Schreibe ein HTML, das eine Uhrzeit visuell anzeigt.

Deine Website soll zentriert eine Uhrzeit anzeigen.
Die Uhrzeit soll analog angezeigt werden - also mit Stunden-, Minuten- und Sekundenzeiger.

Eine analoge Uhr kannst du mit Hilfe von Vektorgrafiken (SVGs) oder Canvas rendern.

Du kannst es aber auch mit gewöhnlichen HTML-Elementen versuchen.

Hilfestellungen zu

- [SVG](https://www.w3schools.com/graphics/svg_intro.asp)
- [Canvas](https://www.w3schools.com/html/html5_canvas.asp)

### Aufgabe 4 - Global Scope, Function Scope und Block-Scope

Im Kapitel [ES6: Variablen deklarieren](../../../../docs/03_web/03_javascript/19_variables#global-scope-und-function-scope) hast du die Funktionsweise vom Global und Function Scope kennengelernt mit einem Beispiel-Code mit `console.log(...)`s. In diesem Beispiel wurden alle Variablen mit `var` deklariert/definiert - also keine `let`s oder `const`s.

![task1](/images/task.png) Ändere in diesem Code alle `var`s zu `let`s oder `const`s.

Beantworte folgende Fragen und dokumentiere deine Antworten:

- Was ist ein Scope?
- Was sind Global Scope, Function Scope und Block-Scope? Was sind die Unterschiede?
- Mit welchem Scope arbeitest du in Java? Begründe.
- Wie werden Variablen im globalen Scope definiert?
- Wie kannst du definieren, welche Variable welchen Scope haben soll?
- Wann könnte die Verwendung von `var` sinnvoll sein?

### Aufgabe 5 - Nummern Liste

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

### Aufgabe 6 - Die optionalen Import-Inseln

![task1](/images/task.png) Entwerfe eine HTML-Seite, welche nachfolgendes JavaScript als Daten-Grundlage verwendet.

- Hierfür musst du eine Klasse `Island` in der Datei `island.js` mit genau EINEM Konstruktor erstellen.
- Auf der HTML-Seite zeigst du alle Inseln an. Wenn eine Insel einen bestimmten Wert besitzt, wird dieser Wert angezeigt, ansonsten nicht. Wenn die Insel ein Bild besitzt, blendest du dieses ein.
- Das nachfolgende Script darfst du NICHT abändern (auch keine geschweiften Klammern beim Import hinzufügen).

```javascript
import Island from "./island.js";

export const islands = [
  new Island({ name: "Atlantis" }),
  new Island({
    name: "Maldives",
    country: "Maldives",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-maldives.jpg",
  }),
  new Island({
    name: "Bora Bora",
    country: "French Polynesia",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-bora-bora.jpg",
  }),
  new Island({
    name: "Seychelles",
    country: "Seychelles",
    imageUrl:
      "https://www.planetware.com/photos-large/SEY/best-islands-seychelles.jpg",
  }),
  new Island({
    name: "Diomede",
    imageUrl:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Little_Diomede_Island_village.jpeg/1280px-Little_Diomede_Island_village.jpeg",
  }),
];

for (const island of islands) {
  console.info(
    `Explore the island ${island.name} in ${
      island.country ?? "an unknown country"
    }: ${island.imageUrl ?? "no image available :/"}`,
  );
}
```

### Aufgabe 7

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
