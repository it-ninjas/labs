---
title: "Conditionals"
type: docs
linkTitle: "Conditionals"
weight: 5
date: 2023-03-24
description: >
    Modul #F4 - JavaScript - Basics und nützliche Eigenschaften von Bedingungen.
---

## Ziele
* Du weisst, welche verschiedenen Conditionals es gibt.
* Du kennst die Vorteile von einem Switch-Statement und weisst es angewandt wird.
* Du weisst, was truthy und falsy Werte sind.


## Conditionals
Conditional Statements oder auch Bedingungsanweisungen sind ein grundlegendes Konzept in JavaScript und anderen Programmiersprachen. Sie ermöglichen es dem Programm, verschiedene Aktionen basierend auf Bedingungen auszuführen. In JavaScript gibt es zwei Hauptarten von Conditionals: `if`/`else`-Statements und `switch`-Statements.


### if/else-Statement
If-Statements überprüfen, ob eine Bedingung. Ist diese true, wird der darauf folgende Codeblock ausgeführt.
```javascript
const condition = true;

if (condition) {
    // condition ist true
}
```

Wenn man nun jedoch einen anderen Codeblock ausführen möchte, falls die Bedingung false ist, kann man das else-Statement verwenden.
```javascript
const condition = false;

if (condition) {
    // condition ist true
} else {
    // condition ist false
}
```

Man kann jedoch auch auf mehrere Bedingungen prüfen, indem `if else`-Statement vor dem `else`-Statement geschrieben werden.
```javascript
const condition1 = false;
const condition2 = true;


if (condition1) {
    // condition1 ist true
} else if (condition2) {
    // condition2 ist true
} else {
    // keine der condition ist true
}
```

In einem If-Statement kann man komplexere Bedingungen schreiben. Hier prüfen wir, ob eine Variable einen bestimmten Wert hat:

```javascript
const variable = 1;

if (variable == 1) {
    // condition ist true, da die variable den Wert 1 hat.
} else {
    // condition ist false
}
```

Das Gleiche funktioniert natürlich auch für Strings:

```javascript
const variable = 'js';

if (variable == 'js') {
    // condition ist true, da die variable den Wert 'js' hat.
} else {
    // condition ist false
}
```

### switch-Statement
`switch`-Statements in JavaScript ermöglichen es, verschiedene Codeblöcke basierend auf verschiedenen Bedingungen auszuführen. Das ist besser, als mehrere `else if` zu verwenden. 

Ein `switch`-Statement besitzt auch immer ein `default` Case, in diesen Codeblock wir der Code festgehalten der ausgeführt werden soll, wenn keine der Bedingungen zutrifft. 

```javascript
const expression = 'Auto';

switch (expression) {
    case 'Bus':
        // Code, der ausgeführt wird, wenn Ausdruck gleich 'Bus' ist
        break;
    case 'Auto':
        // Code, der ausgeführt wird, wenn Ausdruck gleich 'Auto' ist
        break;
    default:
        // Code, der ausgeführt wird, wenn keine der Bedingungen zutrifft
        break;
}
```

Die break in den Cases sind dazu da, das switch-Statement abzubrechen, wenn der Case zutraf und der Codeblock ausgeführt wurde.
```javascript
const expression = 'Auto';

switch (expression) {
    case 'Bus':
        // Code, der ausgeführt wird, wenn Ausdruck gleich 'Bus' ist
        break;
    case 'Auto':
        // Code, der ausgeführt wird, wenn Ausdruck gleich 'Auto' ist
        // break; das break wurde nicht gesetzt oder auskommentiert
    default:
        // Code, der ausgeführt wird, wenn keine der Bedingungen zutrifft 
        // oder Auto zutrifft (da im case Auto das break fehlt.).
        break;
}
```

#### Switch Expressions

Oft kommt es vor, dass du mithilfe eines Switch-Statements z.B. eine Variable zuweisen möchtest. In Java 14 und anderen modernen Programmiersprachen könntest du das wie folgt tun:

```java
int variable = switch (expression) {
  case "Bus" -> 1;
  case "Auto" -> 2;
  default -> 0;
};
```

Wenn die Variable `expression` hier den Wert "Bus" hätte, dann hätte die Variable `variable` den Wert 1, bei "Auto" 2, und sonst 0.

In JavaScript kannst du das Gleiche erreichen, aber mit einem kleinen Trick:

```javascript
const variable = {
  "Bus":  1,
  "Auto": 2
}[expression];
```

und wenn wir den `default`-Wert berücksichtigen möchten, können wir diesen mit dem `??`-Operator ergänzen. Das ist keine offizielle Syntax, funktioniert aber:

```javascript
const variable = {
  "Bus":  1,
  "Auto": 2
}[expression] ?? 0;
```

Ohne den `??`-Operator würden wir für den `default`-Wert `undefined` erhalten. Der `??`-Operator tauscht den Wert mit dem Wert rechts rechts davon aus, falls der Wert `undefined` oder `null` wäre. Du wirst den Operator weiter unten und JavaScript-Objekte in einem anderen Kapitel genauer kennenlernen.




## truthy und falsy
In JavaScript gibt es Konzepte von truthy und falsy Werten. Truthy bezieht sich auf einen Wert, der im booleschen Kontext als wahr interpretiert wird, während falsy sich auf einen Wert bezieht, der als falsch interpretiert wird.

Es gibt sechs falsy Werte: 
* `false`
* `null`
* `undefined`
* `0`
* Not a Number `NaN`
* leeren String (`''`)

Alle anderen Werte sind truthy.

Beispiel:
```javascript
const conditionFalse = false 
const conditionNull = null
const conditionUndefined = undefined
const conditionZero = 0
const conditionNaN = NaN
const conditionEmptyString = ''
    
if (
    conditionFalse || 
    conditionNull || 
    conditionUndefined || 
    conditionZero || 
    conditionNaN || 
    conditionEmptyString
) {
    // Codeblock wird nicht ausgeführt
} else {
    // Codeblock wird ausgeführt
}
```