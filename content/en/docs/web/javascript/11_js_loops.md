---
title: "Loops"
type: docs
linkTitle: "Loops"
weight: 11
date: 2023-03-30
description: >
    Modul #F4 - JavaScript - Loops.
---

## Ziele
* Du weisst, wie Loops funktionieren.
* Du weisst, welche Loops es gibt und du kannst diese anwenden.

## Loops
Ein Loop ist eine Struktur, mit der man einen Block von Code wiederholt ausführen kann, solange eine bestimmte Bedingung erfüllt ist. Loops sind nützlich, wenn man eine bestimmte Aktion mehrmals ausführen möchten, ohne den Code zu duplizieren.

Es ist möglich, Loops zu verschachteln, um komplexe Iterationsprozesse durchzuführen. Dabei wird ein Loop innerhalb eines anderen Loops ausgeführt.

Wichtig bei der Verwendung von Loops ist es, darauf zu achten, dass die Bedingung, die man verwenden, letztendlich erfüllt wird, um eine Endlosschleife zu vermeiden. Eine Endlosschleife führt dazu, dass der Code in einem Loop stecken bleibt und den Rest des Programms nicht ausführt.

## for-Loops
### for, forEach, for...of
Im Kapitel [Arrays](../../../../docs/web/javascript/08_js_arrays#iterieren) werden die Loops for, forEach und for...of erklärt und können dort nachgelesen werden.


### for...in-Loop
Der for...in-Loop wird verwendet, um über die Eigenschaften eines Objekts zu iterieren.

```javascript
const person = { name: "Max", age: 30, city: "Berlin" };

for (let personProperty in person) {
    console.log(personProperty + ": " + person[personProperty]);
}

// Output:
// name: Max
// age: 30
// city: Berlin
```

## while-Loops
### while-Loop
Der while-Loop wird verwendet, um einen Code-Block so lange auszuführen, wie die angegebene Bedingung wahr ist. Die Bedingung ist ein boolescher Ausdruck, der ausgewertet wird, bevor jeder Durchlauf des Loops beginnt.

```javascript
let i = 0;

while (i < 5) {
  console.log(i);
  i++;
}

// 0
// 1
// 2
// 3
// 4
```

### do...while-Loop
Der do...while-Loop funktioniert ähnlich wie der while-Loop, jedoch wird der Code-Block innerhalb des Loops mindestens einmal ausgeführt, bevor die Bedingung geprüft wird.

```javascript
let i = 0;

do {
  console.log(i);
  i++;
} while (i < 5);

// 0
// 1
// 2
// 3
// 4
```