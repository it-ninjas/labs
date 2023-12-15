---
title: "Arrays - Higher Order Functions"
type: docs
linkTitle: "Arrays - Higher Order Functions"
weight: 9
date: 2023-04-19
description: >
    Modul #F4 - JavaScript - Higher Order Functions von Arrays.
---

## Ziele
* Du kannst ein Array mit Hilfe von High Order Functions filtrieren, deren Elemente umwandeln (`map`) und sortieren.

## Higher Order Functions

### map()
Die `map()` Methode verwendet man, um eine neue Array-Instanz zu erstellen, indem jeder Wert des ursprünglichen Arrays durch eine bestimmte Funktion transformiert wird. Dabei wird eine neue Array-Instanz erstellt, die die transformierten Werte enthält.

```javascript
const numbers = [1, 2, 3, 4, 5];
const squares = numbers.map(function(num) {
  return num * num;
});

console.log(squares); // [1, 4, 9, 16, 25]
```

### filter()
Die Methode `filter()` wird angewendet, um eine neue Array-Instanz zu erstellen, die nur die Elemente des ursprünglichen Arrays enthält, die bestimmte Kriterien erfüllen (Filtern).

```javascript
const numbers = [1, 2, 3, 4, 5];
const evenNumbers = numbers.filter(function(num) {
  return num % 2 === 0;
});

console.log(evenNumbers); // [2, 4]
```

### sort()
Die `sort()`-Methode sortiert die Elemente in einem Array.

Die Standard-Sortierreihenfolge ist alphanumerisch. Das bedeutet, dass die Elemente nach ihrem Unicode-Codepunkt sortiert werden.

```javascript
const fruits = ['Banana', 'Mango', 'Apple', 'Orange'];
const sortedFruits = fruits.sort();

console.log(sortedFruits); // ["Apple", "Banana", "Mango", "Orange"]
```

`sort()` kann auch mit einer Vergleichsfunktion verwendet werden, um die Elemente auf andere Weise zu sortieren.

Die Vergleichsfunktion sollte zwei Argumente haben 
* und einen negativen Wert zurückgeben, wenn das erste Argument vor dem zweiten Argument in der Sortierreihenfolge stehen soll,
* einen positiven Wert, wenn das erste Argument nach dem zweiten Argument stehen soll,
* und 0, wenn sie beide gleich zu gewichten sind.

```javascript
const numbers = [10, 5, 20, 3];
numbers.sort((a, b) => a - b);

console.log(numbers); // [3, 5, 10, 20]
```

### includes() (contains)
Die `includes()` Methode wird verwendet, um zu prüfen, ob ein bestimmtes Element in einem Array vorhanden ist oder nicht. Die Funktion gibt `true` zurück, wenn das Element gefunden wurde, sonst `false`.

```javascript
const fruits = ['Banana', 'Mango', 'Apple', 'Orange'];
const isAppleInFruits = fruits.includes('Apple');

console.log(isAppleInFruits); // true
```

`includes()` kann auch mit einem optionalen zweiten Parameter verwendet werden. Dies ist der Index, der angibt, ab wo die Suche beginnen soll. Wenn dieser Parameter nicht angegeben wird, beginnt die Suche am Anfang des Arrays.

```javascript
const fruits = ['Banana', 'Mango', 'Apple', 'Orange'];
const isAppleInFruits = fruits.includes('Banana', 2);

console.log(isAppleInFruits); // false
```

### some()
Die Methode `some()` prüft, ob zumindest ein Element in einem Array den angegebenen Test bestehen würde. Die Funktion gibt `true` zurück, wenn mindestens ein Element den Test besteht, andernfalls gibt sie `false` zurück.

```javascript
const fruits = ['Banana', 'Mango', 'Apple', 'Orange'];
const isAppleInFruits = fruits.some(fruit => fruit === 'Apple');

console.log(isAppleInFruits); // true
```

### find()
Die `find()` Methode wird verwendet, um das erste Element in einem Array zu finden, das den angegebenen Test bestehen würde. Die Funktion gibt das gefundene Element zurück, falls eines gefunden wird, andernfalls gibt sie `undefined` zurück.

```javascript
const fruits = ['Banana', 'Mango', 'Apple', 'Orange'];
const apple = fruits.find(fruit => fruit === 'Apple');

console.log(apple); // 'Apple'
```

### reduce()
Die `reduce()`-Methode wird verwendet, um das Array auf einen einzigen Wert zu reduzieren. Dabei wird der erste Wert ("Accumulator") genommen und mit dem zweiten kombiniert. Das Ergebnis davon ist der neue Accumulator und mit dem nächsten Wert (Wert des dritten Elements) im Array kombiniert. Dies solange bis man durch das gesamte Array durch ist.

Beispiel mit nur Reduktionsfunktion:

```javascript
const numbers = [1, 2, 3, 4, 5];
const sum = numbers.reduce(function(accumulator, currentValue) {
  return accumulator + currentValue;
});

console.log(sum); // 15
```