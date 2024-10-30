---
title: "Operatoren"
type: docs
linkTitle: "Operatoren"
weight: 6
date: 2023-04-19
description: >
  Modul #F4 - JavaScript - Operatoren.
---

## Ziele

- Du kennst den Unterschied zwischen Vergleichs-Operatoren und logischen Operatoren.
- Du kennst spezielle Operatoren wie `!!`, `??`, `??=` und kannst diese anwenden.

## Vergleiches und logische Operatoren

### Vergleichsoperatoren (comparison operators)

Vergleichsoperatoren werden verwendet, um den Wert zweier Variablen oder Ausdrücke miteinander zu vergleichen. Es existieren die folgenden Vergleichsoperatoren:

- Gleichheit (`==`)
- Ungleichheit (`!=`)
- Strikte Gleichheit (`===`)
- Strikte Ungleichheit (`!==`)
- Grösser als (`>`)
- Kleiner als (`<`)
- Grösser-Gleich (`>=`)
- Kleiner-Gleich (`<=`)

```javascript
const a = 5;
const b = 10;
const c = "5";
const d = 10;

// Gleichheit
console.log(a == b); // false
console.log(a == c); // true

// Ungleichheit
console.log(a != b); // true

//Strikte Gleichheit
console.log(a === b); // false
console.log(a === c); // false

// Strikte Ungleichheit
console.log(a !== b); // true

// Grösser als
console.log(a > b); // false

// Kleiner als
console.log(a < b); // true

// Grösser-Gleich
console.log(a >= b); // false
console.log(b >= d); // true

// Kleiner-Gleich
console.log(a <= b); // true
console.log(b <= d); // true
```

#### Unterschiede von Gleichheit und strikter Gleichheit

- Das doppelte Gleichheitszeichen `==` führt einen "schwachen" Vergleich durch. Das bedeutet konkret, dass JavaScript bei der Verwendung des doppelten Gleichheitszeichens versucht, den Wert beider Operanden zu vergleichen, indem es sie in einen gemeinsamen Typen konvertiert. Wenn die Operanden unterschiedliche Datentypen haben, führt JavaScript implizite Typumwandlungen durch, um sie zu vergleichen.
- Das dreifache Gleichheitszeichen `===` führt einen "starken" Vergleich durch. Das bedeutet konkret, dass JavaScript bei der Verwendung des dreifachen Gleichheitszeichens nicht nur den Wert der Operanden vergleicht, sondern auch ihren Datentyp im Vergleich berücksichtigt. Sollten die Operanden unterschiedliche Datentypen haben, wird als Ergebnis eines Vergleichs mit dem dreifachen Gleichheitszeichen immer `false` resultieren.

Hier sind einige Beispiele, die den Unterschied zwischen `==` und `===` genauer veranschaulichen:

```javascript
console.log(5 == "5"); // true
console.log(5 === "5"); // false

console.log(true == 1); // true, weil Binär die 0 für `false` steht und alles über 0 als `true` validiert wird
console.log(true === 1); // false

console.log(null == undefined); // true
console.log(null === undefined); // false
```

### Logische Operatoren (logical operators)

Logische Operatoren werden verwendet, um mehrere Bedingungen miteinander zu kombinieren und Ausdrücke zu evaluieren. Hierbei gibt es folgende Operatoren:

- Bitwise AND (`&`)
- AND (`&&`)
- Bitwise OR (`|`)
- OR (`||`)
- NOT (`!`)

#### Bitwise AND

Der bitwise AND-Operator vergleicht jedes Bit in den beiden Operanden und gibt für jede Bitposition im Ergebnis eine 1 zurück, wenn sowohl der linke als auch der rechte Operand an dieser Bitposition eine 1 haben. Wenn der linke oder der rechte Operand eine 0 an dieser Bitposition hat, gibt der bitweise AND-Operator auch eine 0 zurück.

Beispiel:

```javascript
const a = 5; // 00000000000000000000000000000101
const b = 3; // 00000000000000000000000000000011

console.log(a & b); // 00000000000000000000000000000001
// Expected output: 1
```

#### AND (logisches AND)

Der AND-Operator wird verwendet, um zu überprüfen, ob alle Operanden, auf die er angewandt wird, `true` sind. Wenn ja, gibt er den Wert `true` zurück, andernfalls gibt er `false` zurück. Der Operator wird häufig in Bedingungen verwendet, um zu überprüfen, ob mehrere Bedingungen erfüllt sind, bevor eine Aktion ausgeführt wird.

Beispiel:

```javascript
const a = 5;
const b = 10;

if (a > 0 && b == 15) {
  // Wenn beide Bedingungen true sind, wird der folgende Codeblock ausgeführt
  console.log("1");
} else if (a > 0 && b == 10) {
  // Wenn beide Bedingungen true sind, wird der folgende Codeblock ausgeführt
  console.log("2");
} else {
  // Wenn beide Bedingungen nicht true sind, wird der folgende Codeblock ausgeführt
  console.log("3");
}
// Expected output: '2'
```

#### Bitwise OR

Der bitweise OR-Operator vergleicht jedes Bit innerhalb der beiden Operanden und gibt für jede Bitposition im Ergebnis eine 1 zurück, wenn entweder der linke oder der rechte Operand oder beide Operanden an dieser Bitposition eine 1 haben. Wenn sowohl der linke als auch der rechte Operand an dieser Bitposition eine 0 haben, gibt der bitweise OR-Operator eine 0 zurück.

Beispiel:

```javascript
const a = 5; // 00000000000000000000000000000101
const b = 3; // 00000000000000000000000000000011

console.log(a | b); // 00000000000000000000000000000111
// Expected output: 7
```

#### OR (logisches OR)

Der OR-Operator wird verwendet, um zu überprüfen, ob mindestens einer der Operanden, auf die er angewendet wird, wahr ist. Wenn ja, gibt er den Wert `true` zurück, andernfalls gibt er `false` zurück. Der Operator wird häufig in Bedingungen verwendet, um alternative Bedingungen zu überprüfen und eine Aktion auszuführen, wenn mindestens eine der Bedingungen erfüllt ist.

Beispiel:

```javascript
const a = 5;
const b = 10;

if (a < 0 || b == 15) {
  // Wenn eine der Bedingungen true ist, wird der folgende Codeblock ausgeführt
  console.log("1");
} else if (a > 0 || b == 15) {
  // Wenn eine der Bedingungen true ist, wird der folgende Codeblock ausgeführt
  console.log("2");
} else {
  // Wenn beide Bedingungen nicht true sind, wird der folgende Codeblock ausgeführt
  console.log("3");
}
// Expected output: '2'
```

#### NOT (logisches NOT)

Der NOT-Operator wird verwendet, um einen booleschen Wert umzukehren, was heisst, dass `true` zu `false` und `false` zu `true` wird. Wenn ein Operand `true` ist, gibt der Operator `false` zurück, und wenn der Operand `false` ist, gibt er `true` zurück. Der Operator wird häufig in Bedingungen verwendet, um die Aussage einer Bedingung umzukehren.

Beispiel:

```javascript
const a = 5;
const b = 10;

if (!(a > 0 && b == 10)) {
  console.log("1");
} else if (!(a > 0 && b == 15)) {
  console.log("2");
} else {
  console.log("3");
}
// Expected output: '2'
```

## Special Operators

### doppeltes NOT (`!!`)

Der doppelte NOT-Operator wird verwendet, um einen Wert in einen booleschen Wert umzuwandeln. Die erste Negation kehrt den Wert um und die zweite Negation kehrt ihn wieder zurück, sodass der resultierende Wert immer ein boolescher Ausdruck ist. War der ursprüngliche Wert truthy, so wird das Ergebnis `true` sein, andernfalls `false`. Der doppelte Negationsoperator wird häufig verwendet, um sicherzustellen, dass ein Wert wirklich einem booleschen Ausdruck entspricht.

```javascript
console.log(0); // 0
console.log(!!0); // false

console.log(1); // 1
console.log(!!1); // true

console.log(-1); // -1
console.log(!!-1); // true

console.log(1 / 0); // Infinity
console.log(!!(1 / 0)); // true

console.log(parseInt("js")); // NaN
console.log(!!parseInt("js")); // false

console.log(""); // ''
console.log(!!""); // false

console.log("js"); // 'js'
console.log(!!"js"); // true

console.log("false"); // 'false'
console.log(!!"false"); // true auch wenn es einen falsy value hat

console.log(person.name); // undefined
console.log(!!person.name); // false

console.log(undefined); // undefined
console.log(!!undefined); // false

console.log(null); // null
console.log(!!null); // false

console.log({}); // {}
console.log(!!{}); // true

console.log([]); // []
console.log(!![]); // true
```

### Logischer OR Assignment Operator (`||=`)

Der Operator `||=` prüft, ob die linke Seite des Operators falsy ist. Wenn die linke Seite falsy ist, wird der rechte Operand ausgewertet und der Wert diesem zugewiesen. Wenn die linke Seite truthy ist, wird der linke Wert beibehalten und kein weiterer Ausdruck ausgewertet.

Beispiel:

```javascript
let falsyVariable = "";
let truthyVariable = "Welt!";

falsyVariable ||= "Hallo";
truthyVariable ||= "Mensch";

console.log(falsyVariable); // 'Hallo'
console.log(truthyVariable); // 'Welt!'
```

### Logischer AND Assignment Operator (`&&=`)

Der Operator `&&=` prüft, ob die linke Seite des Operators truthy ist. Wenn die linke Seite truthy ist, wird der rechte Operand ausgewertet und der Wert diesem zugewiesen. Wenn die linke Seite falsy ist, wird der linke Wert beibehalten und kein weiterer Ausdruck ausgewertet.

Beispiel:

```javascript
let falsyVariable = "";
let truthyVariable = "Welt!";

falsyVariable &&= "Hallo";
truthyVariable &&= "Mensch";

console.log(falsyVariable); // ''
console.log(truthyVariable); // 'Mensch'
```

### nullish coalescing Assignment Operator (`??=`)

Der Operator `??=` prüft, ob die linke Seite des Operators `null` oder `undefined` ist. Wenn die linke Seite `null` oder `undefined` ist, wird der rechte Operand ausgewertet und der Wert diesem zugewiesen. Wenn die linke Seite einen anderen falsy Wert als `null` oder `undefined` hat, wird der linke Wert beibehalten und kein weiterer Ausdruck ausgewertet.

Beispiel:

```javascript
let nullVariable = null;
let falsyVariable = "";

nullVariable ??= "hello";
falsyVariable ??= "world";

console.log(nullVariable); // "hello"
console.log(falsyVariable); // ""
```

### nullish coalescing Operator (`??`)

Der Operator `??` gibt den linken Ausdruck zurück, wenn er `null` oder `undefined` ergibt, andernfalls gibt er den rechten Ausdruck zurück. Im Gegensatz zum logischen OR-Operator (`||`) behandelt der Nullish Coalescing-Operator nur `null` und `undefined` als falsy Werte, und alle anderen Werte werden als truthy behandelt.

Beispiel:

```javascript
const nullCheck = null ?? "left is null";
console.log(nullCheck); // 'left is null'

const zeroCheck = 0 ?? 42;
console.log(zeroCheck); // 0

const undefinedCheck = undefined ?? "left is undefined";
console.log(undefinedCheck); // 'left is undefined'

const emptyStringCheck = "" ?? "empty string";
console.log(emptyStringCheck); // '' weil ein leerer String zwar falsy aber nicht null oder undefined ist
```

### ternary Operator (`?:`)

Der Ternary-Operator (`?:`) ermöglicht es, eine Zuweisung kombiniert mit einer Bedingung (`if`/`else`) auf eine einzige Anweisung zu reduzieren.

Schauen wir uns hierfür folgendes Beispiel an, für das eine  `if`/`else`-Struktur umgesetzt wird:

```javascript
const age = 18;

let canVote;
if (age >= 18) {
  canVote = "yes";
} else {
  canVote = "no";
}

console.log(canVote); // 'yes'
```

Hier haben wir 6 Zeilen Code gebraucht, um bedingt eine Variable zu setzen. Mit dem ternary-Operator können wir das Ganze auf eine Zeile reduzieren (und wir können direkt das Ergebnis per `const` zuweisen):

```javascript
const age = 18;

const canVote = age >= 18 ? "yes" : "no";

console.log(canVote); // 'yes'
```

Oft wird diese Syntax bei Zuweisungen verwendet, kann aber auch anderorts verwendet werden, beispielsweise für Parameter:

Beispiel:

```javascript
const oddNumber = 5;
console.log(oddNumber % 2 === 0 ? "even" : "odd"); // 'odd'
```

Ganz allgemein lautet die Syntax:

```javascript
condition ? expression1 : expression2;
```

Zuerst wird die Bedingung (condition) ausgewertet. Wenn diese `true` entspricht, wird `expression1` ausgeführt und zurückgegeben, andernfalls `expression2`.
