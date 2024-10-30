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

- Du weisst, welche verschiedenen Conditionals es gibt.
- Du kennst die Vorteile von einem Switch-Statement und weisst, wie es angewandt wird.
- Du weisst, was truthy und falsy Werte sind und welche es gibt.

## Conditionals

Conditional Statements oder auch Bedingungsanweisungen sind ein grundlegendes Konzept in JavaScript und anderen Programmiersprachen. Sie ermöglichen es dem Programm, verschiedene Aktionen je nach Erfüllung der Bedingungen auszuführen. In JavaScript gibt es hauptsächlich zwei Arten von Conditionals: `if`/`else`-Statements und `switch`-Statements.

### `if`/`else`-Statement

If-Statements überprüfen, ob eine Bedingung dem Wert `true` entspricht. Ist das der Fall, wird der darauf folgende Codeblock ausgeführt.

```javascript
const condition = true;

if (condition) {
  // condition ist true
}
```

Wenn man nun jedoch einen anderen Codeblock ausführen möchte, falls die Bedingung dem Wert `false` entspricht, kann man dafür direkt auf den `if`-Block folgend das `else`-Statement verwenden.

```javascript
const condition = false;

if (condition) {
  // condition ist true
} else {
  // condition ist false
}
```

Es ist ebenfalls möglich, mehrere spezifische Bedingungen zu prüfen, bevor der `else`-Block ausgelöst wird. Dazu verwendet man die `else if`-Kontrollstruktur, welche ebenfalls direkt auf den `if`-Block folgt.

```javascript
const condition1 = false;
const condition2 = true;

if (condition1) {
  // condition1 ist true
} else if (condition2) {
  // condition2 ist true
} else {
  // keine der conditions ist true
}
```

In einem If-Statement kann man beliebig komplexe Bedingungen schreiben. Hier wird geprüft, ob eine Variable einen bestimmten Wert hat:

```javascript
const variable = 1;

if (variable == 1) {
  // Condition ist true, da die variable den Wert 1 hat.
} else {
  // Condition ist false
}
```

Das Gleiche funktioniert natürlich auch mit Strings:

```javascript
const variable = "js";

if (variable == "js") {
  // Condition ist true, da die Variable den Wert 'js' hat.
} else {
  // Condition ist false
}
```

### switch-Statement

`switch`-Statements in JavaScript ermöglichen es, verschiedene Codeblöcke basierend auf verschiedenen Bedingungen auszuführen. Das ist aus Übersichtlichkeitsgründen besser, als mehrere `else if` zu verwenden, da mehrere `else if`-Blöcke und eine `switch`-Kondition grundsätzlich dasselbe machen, ein `switch`-Ausdruck aber insbesondere bei vielen Konditionen besser lesbar ist.

Ein `switch`-Statement besitzt immer einen `default` Case. Dieser gibt einen "Ausweg" an, wenn keiner der gegebenen Cases erfüllt wird.  

```javascript
const expression = "Auto";

switch (expression) {
  case "Bus":
    // Code, der ausgeführt wird, wenn Ausdruck gleich 'Bus' ist
    break;
  case "Auto":
    // Code, der ausgeführt wird, wenn Ausdruck gleich 'Auto' ist
    break;
  default:
    // Code, der ausgeführt wird, wenn keine der Bedingungen zutrifft
    break;
}
```

Die `break`-Keywords in den Cases werden verwendet, um das switch-Statement abzubrechen, wenn die Bedingung des Cases zugetroffen hat und der vor dem Keyword kommende Codeblock ausgeführt wurde. Wenn kein `break` im Case vorhanden ist, wird der Switch weiter ausgeführt. 

```javascript
const expression = "Auto";

switch (expression) {
  case "Bus":
    // Code, der ausgeführt wird, wenn der Ausdruck gleich 'Bus' ist
    break;
  case "Auto":
  // Code, der ausgeführt wird, wenn der Ausdruck gleich 'Auto' ist
  // break; das break wurde nicht gesetzt oder auskommentiert
  default:
    // Code, der ausgeführt wird, wenn keine der Bedingungen zutrifft
    // oder Auto zutrifft (da im case Auto das break fehlt.).
    break;
}
```

#### Switch Expressions

Oft kommt es vor, dass du mithilfe eines Switch-Statements je nach Case eine Variable zuweisen möchtest. In Java 14 und anderen modernen Programmiersprachen ist das möglich wie folgt:

```java
int variable = switch (expression) {
  case "Bus" -> 1;
  case "Auto" -> 2;
  default -> 0;
};
```

Wenn die Variable `expression` hier den Wert "Bus" hätte, dann würde der Variable `variable` der Wert 1 zugeschrieben werden, bei "Auto" 2, und in jedem anderen Case 0.

In JavaScript kannst du mit einem kleinen Trick das Gleiche bewerkstelligen:

```javascript
const variable = {
  Bus: 1,
  Auto: 2,
}[expression];
```

Wenn wir den `default`-Wert berücksichtigen möchten, können wir diesen mit dem `??`-Operator ergänzen. Das ist keine "offizielle" Syntax, funktioniert aber:

```javascript
const variable =
  {
    Bus: 1,
    Auto: 2,
  }[expression] ?? 0;
```

Ohne den `??`-Operator würden wir als `default`-Wert `undefined` erhalten. Der `??`-Operator tauscht den Wert mit dem Wert rechts davon aus, falls der resultierende Wert `undefined` oder `null` entspräche. Du wirst den Operator und JavaScript-Objekte in einem anderen Kapitel genauer kennenlernen.

## truthy und falsy

In JavaScript gibt es die Konzepte von `truthy`- und `falsy`-Werten. Truthy bezieht sich auf einen Wert, der im booleschen Kontext als `true` interpretiert wird, während falsy sich auf einen Wert bezieht, der als `false` interpretiert wird.

Es existieren die folgenden `falsy`-Werte:

| Wert          | Typ       | Beschreibung                                                                                                        |
|---------------|-----------|---------------------------------------------------------------------------------------------------------------------|
| `null`          | Null      | Das Keyword `null` beschreibt die Absenz eines Werts - also eine leere Menge                                        |
| `undefined`     | Undefined | Einer der primitiven Werte in Javascript. Eine Variable, welcher kein Wert zugeschrieben ist, nimmt diesen wert an. |
| `false`         | Boolean   | Das Keyword `false` ist einer der beiden Grundwerte eines Booleans.                                                 |
| `NaN`           | Number    | Ein Wert, der beschreibt, dass ein gegebener Wert keine `Number` ist (Not A Number).                                |
| `0`             | Number    | Die Zahl `0`. Beinhält ebenfalls Werte wie `0.0`, `0x0` etc.                                                        |
| `-0`            | Number    | Die Zahl `-0`. Beinhält auch Werte wie `-0.0`, `-0x0` etc.                                                          |
| `0n`            | BigInt    | Die Zahl `0` im Datentyp `BigInt`. Beinhält ebenfalls `0x0n` etc.                                                   |
| `""`            | String    | Ein leerer String-Wert. Beinhält ebenfalls die anderen Schreibweisen für Strings, beispielsweise `''`.              |
| `documment.all` | Object    | `document.all` ist das einzige Objekt in Javascript, welches als `falsy` validiert wird.                            |

Alle Werte, die keinem der in der oberen Tabelle beschriebenen Werte entsprechen, werden in Javascript als `truthy` behandelt. 
