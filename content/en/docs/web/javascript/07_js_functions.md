---
title: "Functions"
type: docs
linkTitle: "Functions"
weight: 7
date: 2023-03-28
description: >
    Modul #F4 - JavaScript - Verschiedene Arten von Funktionen.
---

## Ziele
* Du weisst, wie eine Funktions-Definition aussieht sowie deren Aufruf.
* Du weisst, was Default-Parameter sind und wie man sie verwendet.
* Du weisst, was Arrow-Functions sind und wie mit dieser Schreibweise Funktionen geschrieben werden.
* Du kennst den Unterschied von Funktionen und Funktions Expressions.
* Du weisst, was Globaler-Scope und Block-Scope bedeutet.


### Funktions-Definition und Aufruf
Eine Funktions-Definition in JavaScript ist eine Möglichkeit, einen Code-Block zu erstellen und diesen zu benennen, der eine bestimmte Aufgabe ausführt.

```javascript
function sum(number1, number2) {
    return number1 + number2;
}
```

Um die Funktion aufzurufen, können wir den Funktionsnamen gefolgt von Runden klammern verwenden und die Argumente innerhalb dieser übergeben:
```javascript
let total = sum(3, 5);
console.log(total); // 8
```

Man kann auch Funktionen ohne Argumente aufrufen, indem man einfach die Klammern leer lässt:
```javascript
function sayHello() {
    console.log('Hello!');
}

sayHello(); // 'Hello!'
```

### Arrow Functions
Arrow-Funktionen sind eine kompakte und prägnante Möglichkeit, Funktionen in JavaScript zu definieren. Im Gegensatz zu herkömmlichen Funktionsdefinitionen haben Arrow-Funktionen einen kürzeren und einfacheren Syntax. Dies ist besonders nützlich, um den Code zu vereinfachen und die Lesbarkeit zu erhöhen. Arrow-Funktionen haben auch eine andere `this`-Binding-Regel im Vergleich zu herkömmlichen Funktionen. In Arrow-Funktionen wird `this` an das `this`-Objekt des äußeren Kontexts gebunden, während bei herkömmlichen Funktionen `this` an das Objekt des Aufrufers gebunden wird.

Im Gegensatz zu herkömmlichen Funktionsdefinition wird der Funktionsname weggelassen und durch einen Pfeil (`=>`) ersetzt.

```javascript
const sum = (number1, number2) => {
     return number1 + number2;
}

let total = sum(3, 5);
console.log(total); // 8
```

Wenn die Funktion nur einen Ausdruck hat, kann sie noch kürzer geschrieben werden, indem die geschweiften Klammern und das return-Schlüsselwort weggelassen werden. Diese Syntax nennt man auch "implizite Rückgabe".
```javascript
const sum = (number1, number2) => number1 + number2;
```

### Function Expressions
Eine Funktionsexpression ist ein anderer Ansatz, um eine Funktion in JavaScript zu definieren. Im Gegensatz zur Funktionsdeklaration wird bei der Funktionsexpression eine Funktion in einer Variablen gespeichert:

```javascript
// Function-Expression:
const sum = function(number1, number2) {
     return number1 + number2;
}

// Das Gleiche mit der Arrow-Function-Schreibweise:
const sum2 = (a, b) => a + b;

console.log(sum(3, 5)); // 8
console.log(sum2(3, 5)); // 8
```

Der Hauptunterschied zwischen einer Funktionsdeklaration und einer Funktionsexpression besteht darin, dass Funktionsexpression nur im Scope der Variabel aufgerufen werden können, sprich erst nach der Zuweisung der Variable.

Dieser Unterschied wird durch den **Hoisting-Prozess** verursacht:
Der Hoisting-Prozess ist ein Konzept, bei dem Variablen- und Funktions**deklarationen** an den Anfang ihres Gültigkeitsbereichs verschoben werden. Mit anderen Worten, bevor der Code ausgeführt wird, werden Variablen und Funktionen in den Speicher geladen und sind somit bereits verfügbar, bevor sie im Code definiert wurden. Im Falle von Funktionsdeklarationen bedeutet das, dass die gesamte Funktionsdefinition im Speicher geladen wird, einschließlich der Funktionsparameter und des Funktionskörpers. Dadurch kann eine Funktion in einem Programm an jeder beliebigen Stelle aufgerufen werden, auch wenn sie erst später im Code definiert wird. Es ist jedoch wichtig zu beachten, dass das Hoisting für Funktionsdeklarationen gilt, nicht aber für Funktionsexpressionen. Wenn man eine Funktion als Funktionsexpressionen definieren, wird sie nicht gehoisted. Das bedeutet, dass man sie erst nach der Definition aufrufen kann.


Beispiel mit Hoisting-Prozess:
```javascript
console.log(multiply(2,3)); // 6
console.log(sum(1,2)); // Cannot access 'sum' before initialization

function multiply(number1, number2) {
    return number1 * number2;
}

const sum = function(number1, number2) {
     return number1 + number2;
}
```