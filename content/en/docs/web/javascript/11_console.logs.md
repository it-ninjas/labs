---
title: "Advanced console.log(...)'s"
type: docs
linkTitle: "Advanced console.log(...)'s"
weight: 11
date: 2023-01-09
description: >
  Die JavaScript-Konsole bietet viele hilfreiche Tools an, um Text zu loggen. Diese Möglichkeiten schauen wir uns hier an.
---


## Ziele
* Du kennst Alternativen zu `console.log(...)`.


## Basics
Das `console.log(...)` ist das `System.out.println(...)`, das `Console.WriteLine(...)` oder das `print(...)` in JavaScript.

Es gibt aber noch sehr viele Alternativen zu `console.log(...)`, die sehr nützlich sind.

Z.B. kannst du den Logs noch eine Kategorie zuordnen und werden in unterschiedlichen Farben geloggt:
* `console.info(...)` (neutral)
* `console.warn(...)` (gelb/orange/grün)
* `console.error(...)` (rot)
* `console.debug(...)` (blau, aber nur sichtbar, wenn "Alle [Log-]Ebenen" in der Konsole anzeigt)

### Nie mehr Counter-Variablen für Debugging-Zwecke!!
Wenn du z.B. feststellen möchtest, wie oft etwas aufgerufen wird, hilft dir vielleicht `console.count("")` weiter:

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
Mit einem `%c` im Log kannst du den Text stylen:
 
 ```javascript
console.log('%cHello World', 'color: blue; font-weight: bolder; background-color: white; border-radius: 2em; padding: 1em;')
 ```

### Falsche Werte loggen
Als Entwickler bist du informiert werden, wenn irgendwo falsche Werte zurückgegeben wurden (z.B. Rückgabe-Wert einer Funktion).

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