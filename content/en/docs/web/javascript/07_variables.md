---
title: "ES6: Variablen deklarieren"
type: docs
linkTitle: "ES6: Variablen deklarieren"
weight: 7
date: 2023-01-09
description: >
  Seit ES2015 (ES6) gibt es in JavaScript weitere neue Möglichkeiten, wie Variablen definiert werden können. Hier schauen wir uns einige davon an.
---

## Ziele
* Du weisst, wie du Variablen deklarierst.
* Du weisst, wann du eine Variable mit `var`, `let` oder `const` deklarierst.
* Du kannst das "Object Destructuring Assignment" anwenden


## Basics

In JavaScript deklarierst du Variablen mit dem `let`- oder `const`-Keyword - egal welcher Typ die Variable haben wird.

Als Grundsatz gilt: Verwende immer `const` ausser du musst die Variable später noch verändern. Dann verwende `let`. Das folgende Listing zeigt auf, wie du mit Variablen deklarieren und zuweisen ("assign") kannst:

```javascript
let a = "A";
const b = "B";
console.log(a);
>>> A

console.log(b)
>>> B

a = "AA"
console.log(a);
>>> AA

b = "BB"
>>> Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:3
```

Wie du siehst, kannst du eine mit `let` zugewiesene Variable verändern. Veränderst du eine `const`-Variable, wird ein Fehler geworfen.

### Scope

Variablen, die mit `const` oder `let` definiert wurden, sind in ihrem Scope/Block sichtbar/verwendbar.

Es ist sehr wichtig, dass du folgenden Code komplett verstehst und wieso es zum entsprechenden Resultat führt - und warum die Verwendung von `const` nicht zu einem Fehler führt:

```javascript
const a = "File";
console.log(1, a);

function myFunction(a="Argument") {
    console.log(2, a);
    if (true) {
        const a = "if";
        console.log(3, a);
    }
    console.log(4, a);
}

myFunction();

console.log(5, a);
```

Dies produziert folgenden Output:
```
1 File
2 Argument
3 if      
4 Argument
5 File  
```


### Wann `var` verwenden?
Folgender Grundsatz gilt: 

__Verwende nie `var`, ausser du musst sicherstellen, dass der Code in Browser funktioniert, welche vor 2015 aktualisiert worden sind.__

Wenn du wissen willst, wieso `var` nicht mehr verwendet werden sollte, dann kannst du dein Wissen hier vertiefen: https://medium.com/@codingsam/awesome-javascript-no-more-var-working-title-999428999994.


### Destructuring Assignment
In JavaScript siehst du sehr oft, dass mehrere Variablen auf einmal definiert werden.

Wie in anderen Programmiersprachen kannst du Variablen in einem einzigen Statement definieren (das ist kein Destructuring Assignment):

```javascript
const a = "A", b = "B";
```

Nun kommt es oft vor, dass du in einem einzigen Methodenaufruf mehrere Werte zurückbekommst - in Form eines Arrays/Liste oder in Form eines Objekts. Oft willst du dann die einzelnen Werte in eigene Variablen speichern. Wie du das machen kannst, wird in den nächsten zwei Unterkapitel behandelt:

#### Destructuring Arrays
Bekommst du ein Array und willst du z.B. den ersten und zweiten Wert aus einem Array je einer Variable zuweisen, dann würdest du das normalerweise tun:

```javascript
const array = ['A', 'B'];
const a = array[0], b = array[1];
```

Diese Schreibweise kannst du mit folgender Syntax vereinfachen:
```javascript
const [a, b] = ['A', 'B'];
```

Ist z.B. das erste Element ein Index/Key/Zeilen- bzw. Spaltenname/... und der Rest das eigentliche Array, dann hilft dir vielleicht diese Schreibweise:

```javascript
const [name, ...values] = ["ColumnName", 1, 2, 3, 4];
```

Hier hat `name` den Wert "ColumnName" und `values` ist das Array `[1, 2, 3, 4]`.

#### Object Destructuring

Diese Schreibweise ist dir sicher schon einmal aufgefallen:

```javascript
const {a, b} = anotherObject;
```

Das ist auch ein ganz einfaches Prinzip. Wenn du nachfolgenden Code verstanden hast, dann weisst du alles, was du zu diesem Thema wissen musst:

```javascript
const object = {a: "A", b: "B", c: "C", d: "D"};

const {a: one, d, b} = object;

console.log(one, d, b);
>>> A D B
```

In diesem Beispiel haben wir den Wert für `a` in die Variable `one` kopiert.

Wie du siehst, spielt hier die Reihenfolge der Variablen __keine__ Rolle.