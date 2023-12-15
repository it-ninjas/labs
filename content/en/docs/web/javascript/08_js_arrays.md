---
title: "Arrays"
type: docs
linkTitle: "Arrays"
weight: 8
date: 2023-03-28
description: >
    Modul #F4 - JavaScript - Arrays/Listen und ihre Methoden.
---

## Ziele
* Du weisst, wie man ein Array/eine Liste erstellt und updated.
* Du weisst, wie man durch Arrays iteriert, und welcher Ansatz welche Vor-/Nachteile besitzt.

## Arrays Basics
Ein Array ist eine Datenstruktur in JavaScript, die eine geordnete Sammlung von Elementen speichert. Ein Array kann verschiedene Datentypen speichern, einschliesslich Zahlen, Zeichenketten und Objekten. Arrays werden in JavaScript durch eckige Klammern `[]` definiert und die Elemente innerhalb des Arrays werden durch Kommas getrennt.

```javascript
const array = [1, 2, 3, 'vier', 'fünf', {name: 'Max'}]

console.log(array) // [1, 2, 3, 'vier', 'fünf', {name: 'Max'}]
```

Jedes Element im Array hat eine Indexposition, die bei 0 beginnt. Auf die Elemente eines Arrays kann zugegriffen werden, indem der Index des Elements in eckigen Klammern angegeben wird:
```javascript
const array = [1, 2, 3, 'vier', 'fünf', {name: 'Max'}]

console.log(array[0]); // 1
console.log(array[3]); // 'vier'
```

### Erstellen
Um ein Array in JavaScript zu erstellen, kann man die eckigen Klammern-Notation verwenden und die Elemente durch Kommas trennen.

```javascript
const array = [1, 2, 3, 'vier', 'fünf', {name: 'Max'}];

console.log(array); // [1, 2, 3, 'vier', 'fünf', {name: 'Max'}]
```
Es kann auch ein leeres Array erstellt werden:

```javascript
const array = [];

console.log(array); // []
```

### Elemente verändern
Um ein Element an einer bestimmten Position in einem Array anzupassen, wird der entsprechende Index des Elements in eckigen Klammern angeben. Anschliessen kann dieser Wert zugewiesen werden:

```javascript
let array = [1, 2, 3, 4, 5];
array[1] = 10;

console.log(array); // [1, 10, 3, 4, 5]
```

### Länge bestimmen
Man kann die Länge (Anzahl der Elemente) eines JavaScript-Arrays mit der Eigenschaft `length` bestimmen. 

```javascript
const array = [1, 2, 3, 4, 5];

console.log(array.length); // 5
```

## Iterieren
Um durch ein Array zu iterieren, gibt es mehrere Möglichkeiten. Die gängisten davon sind `for`, `forEach` und `for of`

### For-Loop
Der for Loop ist eine Loop, mit der man eine bestimmte Anzahl von Loop durchläufen ausführen kann. Der for Loop wird oft verwendet, um durch Arrays zu iterieren oder um eine Aktion eine bestimmte Anzahl von Malen auszuführen.
```javascript
const array = [1, 2, 3, 4, 5];

for (let i = 0; i < array.length; i++) {
  console.log(array[i]);
}
```

### break
Das `break`-Statement wird verwendet, um den Loop vorzeitig zu beenden.

```javascript
const numbers = [1, 2, 3, 4, 5, 6];

for (let i = 0; i < numbers.length; i++) {
    if (numbers[i] === 4) {
        break;
    }
    console.log(numbers[i]);
}

console.log('Loop beendet!');
// 1
// 2
// 3
// Loop beendet!
```

### continue
Das `continue`-Statement wird verwendet, um den aktuellen Durchlauf des Loops zu überspringen und mit dem nächsten Durchlauf fortzufahren.
```javascript
const numbers = [1, 2, 3, 4, 5, 6]

for (let i = 0; i < numbers.length; i++) {
  if (numbers[i] % 2 === 0) {
    continue;
  }
  console.log(numbers[i]);
}

console.log('Loop beendet!');
// 1
// 3
// 5
// Loop beendet!
```

### forEach-Loop
`forEach` ist eine Methode auf Arrays, um durch jedes Element des Arrays nacheinander zu iterieren. Der `forEach`-Loop ist eine kürzere Schreibweise, um durch ein Array zu iterieren.

Man kann es in JavaScript mit der `function()` lösen:
```javascript
const array = [1, 2, 3, 4, 5];

array.forEach(function(element) {
  console.log(element);
});
// 1
// 2
// 3
// 4 
// 5

```
Wie in Kapitel [Functions](../../../../en/docs/web/javascript/10_js_functions.md#arrow-functions) beschrieben, kann auch eine Arrow-Function verwendet werden:
```javascript
const array = [1, 2, 3, 4, 5];

array.forEach((element) => console.log(element));
// 1
// 2
// 3
// 4 
// 5
```

Im Gegensatz zum `for` Loop bietet die `forEach`-Methode jedoch weniger Kontrolle über den Loop. Zum Beispiel kann man den Loop nicht mit `break` oder `continue` unterbrechen oder überspringen. Ausserdem gibt es so keine Möglichkeit, auf den Index jedes Elements im Array zuzugreifen. Wenn man den Index benötigen, müsste man einen Zähler verwenden.

### for...of-Loop
Der `for (... of ...)`-Loop ist dafür ausgelegt, Arrays oder andere iterierbare Objekte wie Maps, Sets, Strings usw. zu durchlaufen. Dieser Loop ist in der Regel einfacher zu lesen und zu schreiben als ein traditioneller `for`-Loop.

```javascript
const array = [1, 2, 3, 4, 5];

for (const element of array) {
  console.log(element);
}
// 1
// 2
// 3
// 4 
// 5
```

## Funktionen

### Hinzufügen
Mit der `push()`Methode kann man ein Element am Ende des Arrays hinzufügen.

```javascript
let array = [1, 2, 3];

array.push(4)       // einzelnes Element hinzufügen
array.push(5, 6);   // zwei Elemente aufs Mal hinzufügen

const x = 7;
array.push(x);      // Variablen funktionieren natürlich auch:

console.log(array); // [1, 2, 3, 4, 5, 6, 7]
```


### Letztes Element entfernen
Mit der Methode `pop()` kann man das letzte Element aus dem Array entfernen und zurückgeben.

```javascript
let array = [1, 2, 3, 4, 5];
const removedElement = array.pop();

console.log(array); // 1, 2, 3, 4]
console.log(removedElement); // 5
```

### Erstes Element entfernen
Im Gegensatz zu `pop()` verwendet man `shift()` um das erste Element aus dem Array entfernen und zurückgeben zu können.

```javascript
let array = [1, 2, 3, 4, 5];
const removedElement = array.shift();

console.log(array); // [2, 3, 4, 5]
console.log(removedElement); // 1
```

### Elemente am Anfang hinzufügen
Die Methode `unshift()`ist das Gegenstück zu der Methode `shift()`, mit der ein oder mehrere Elemente am Anfang des Arrays hinzugefügt werden können. 

`unshift()` gibt die neue Länge des Arrays zurückgibt.

```javascript
let array = [1, 2, 3];
const newLength = array.unshift(4, 5);

console.log(array); // [4, 5, 1, 2, 3]
console.log(newLength); // 5
```

### Elemente austauschen
Die Methode `slice()` entfernt Elemente aus einem Array und fügt neue Elemente an ihrer Stelle ein. Die `splice()` Methode nimmt drei Parameter an:
1. den Index, an dem man beginnen möchten,
2. die Anzahl der Elemente, die man entfernen möchten, und
3. die neuen Elemente, die man einfügen möchte.

```javascript
let array = [1, 2, 3, 4, 5];
array.splice(1, 1, 'new element 1', 'new element 2');

console.log(array); // [1, 'new element 1', 'new element 2', 3, 4, 5]
```

### Elemente an bestimmter Position hinzufügen oder entfernen
Die `splice()`-Methode wird verwendet, um Elemente im Array hinzuzufügen oder zu entfernen.

`splice()` ändert das ursprüngliche Array und gibt das gelöschte Element oder die gelöschten Elemente zurück.

Beispiel für Elemente löschen:

```javascript
let array = [1, 2, 3, 4, 5];
const removedElements = array.splice(2, 2);

console.log(array); // [1, 2, 5]
console.log(removedElements); // [3, 4]
```

Beispiel für Elemente hinzufügen:
```javascript
let array = [1, 2, 3, 4, 5];

// An der 3. Stelle (Index 2), 0 Elemente entfernen.
// Füge dort die Elemente 6 und 7 hinzu:
array.splice(2, 0, 6, 7);

console.log(array); // [1, 2, 6, 7, 3, 4, 5]
```
### Arrays kombinieren
Die `concat()` Methode gibt ein neues Array zurück, das aus der Verkettung (Zusammenführung) von zwei oder mehr Arrays besteht. Man kann somit mehrere Arrays zusammenmergen.

```javascript
const array1 = [1, 2, 3];
const array2 = [4, 5, 6];
const newArray = array1.concat(array2);

console.log(newArray); // [1, 2, 3, 4, 5, 6]
```

Mehrere Arrays werden wie folgt miteinander verkettet:
```javascript
const array1 = [1, 2, 3];
const array2 = [4, 5, 6];
const array3 = [7, 8, 9];
let newArray = array1.concat(array2, array3);
console.log(newArray); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
```

### Index eines Elements herausfinden
Um den Index eines bestimmten Elements in einem Array zu finden, wird die Methode `indexOf()`verwendet. 

Wenn das Element im Array nicht gefunden wird, gibt die Methode den Wert -1 zurück.

Beispiel:
```javascript
const fruits = ['apple', 'banana', 'orange', 'pear'];
const index = fruits.indexOf('banana');

console.log(index); // 1
```

Beispiel, wenn Element nicht gefunden wird:
```javascript
const fruits = ['apple', 'banana', 'orange', 'pear'];
const index = fruits.indexOf('grape');

console.log(index); // -1 
```

Man kann der Methode auch einen optionalen Parameter hinzufügen, der angibt, ab welchem Index die Suche beginnen soll. Wenn dieser Parameter nicht angegeben wird, wird die Suche ab Index 0 gestartet.
```javascript
const fruits = ['pear', 'banana', 'orange', 'pear'];
const index = fruits.indexOf('pear', 1);

console.log(index); // 3 
```