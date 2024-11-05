---
title: "Advanced console.log(...)'s"
type: docs
linkTitle: "Advanced console.log(...)'s"
weight: 23
date: 2023-01-09
description: >
  Modul #F4 - JavaScript - Die Browser-Konsole
---

## Motivation

Die JavaScript-Konsole bietet viele hilfreiche Tools an, um Texte zu loggen. Diese Möglichkeiten schauen wir uns hier an.

## Ziele

- Du kennst Alternativen zu `console.log(...)`.

## Basics

Die `console.log(...)`-Struktur in JavaScript ist das Äquivalent zu `System.out.println(...)` in Java, `Console.WriteLine(...)` in C#, `print(...)` in Python oder `puts ...` in Ruby.

Es gibt in JavaScript noch weitere Alternativen zu `console.log(...)`, die durchaus nützlich sind.

Zum Beispiel kannst du den Logs eine Kategorie zuordnen, wobei die Logs in unterschiedlichen Farben angezeigt werden:

- `console.info(...)` (neutral)
- `console.warn(...)` (gelb/orange/grün)
- `console.error(...)` (rot)
- `console.debug(...)` (blau, aber nur sichtbar, wenn "Alle [Log-]Ebenen" in der Konsole angezeigt werden)

### Nie mehr Counter-Variablen für Debugging-Zwecke!

Wenn du beispielsweise feststellen möchtest, wie oft etwas aufgerufen wird, kann dir `console.count("")` weiterhelfen:

```javascript
console.count("alarm");
>>> alarm: 3
```

### Objekte loggen

Wenn du Objekte mit ihren Attributen und Werten loggen möchtest, dann bietet sich die `console.dir(...)`-Funktion an:

```javascript
console.dir(person);
>>> Person {
      name: 'Confused Nick Young',
      age: undefined,
      gender: 'male',
      lovesJavaScript: true
    }
```

### Tabelle loggen
Möchtest du beispielsweise ein Array in Form einer Tabelle loggen, kannst du das mit `console.table(...)` bewerkstelligen.

```javascript
console.table(
    [person1, person2]
)

>>>     ┌─────────┬────────────────────────┬───────────┬───────────┬─────────────────┐
        │ (index) │         name           │    age    │ gender    │ lovesJavaScript │
        ├─────────┼────────────────────────┼───────────┼───────────┼─────────────────┤
        │    0    │ 'Confused Nick Young'  │ undefined │ 'male'    │      false      │
        │    1    │'Tuxedo Winnie the Pooh'│ undefined │ undefined │      true       │
        └─────────┴────────────────────────┴───────────┴───────────┴─────────────────┘
```

### Log stylen

Wenn du `%c` zu der Message im Log hinzufügst, kannst du den angezeigten Text stylen:

```javascript
console.log(
  "%cHello World",
  "color: blue; font-weight: bolder; background-color: white; border: 1px solid; border-radius: 2em; padding: 1em;",
);
```

### Fehlerhafte Werte loggen

Als Entwickler:in möchtest du informiert werden, wenn an einem Ort fehlerhafte Werte zurückgegeben wurden (zum Beispiel Rückgabe-Werte von Funktionen).

Hierfür bietet sich `console.assert(...)` an:

```javascript
let connectionToDatabase = connectToDatabase(); // returns `null` if connection fails.
console.assert(
    connectionToDatabase != null,
    {
        connectionToDatabase: connectionToDatabase,
        errorMsg: "Es konnte keine Verbindung zur Datenbank hergestellt werden. ¯\_(ツ)_/¯"
    });

>>> Assertionsfehler: {
        connectionToDatabase: null,
        errorMsg: 'Es konnte keine Verbindung zur Datenbank hergestellt werden. ¯_(ツ)_/¯'
    }
```
