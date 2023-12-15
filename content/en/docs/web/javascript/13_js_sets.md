---
title: "Sets"
type: docs
linkTitle: "Sets"
weight: 13
date: 2023-03-31
description: >
    Modul #F4 - JavaScript - Sets.
---

## Ziele
* Du kennst den Unterschied zwischen Maps und Sets.
* Du kannst Sets erstellen, bearbeiten und Daten abrufen.
* Du kannst Set-Iteratoren erklären.

## Set
Oft möchte man eine Liste haben, in der klar ist, dass jedes Element nur 1x vorkommen kann.

Genau diesen Zweck erfüllt die `Set`.

```javascript
const set = new Set();
```

### Wert hinzufügen
Die `add(value)` Methode fügt einen Wert zur Set hinzu.

Wenn der Wert bereits in der Set vorkommt, wird der Wert kein weiteres Mal hinzugefügt, siehe:

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

console.log(set); // Set {'value1', 'value2', 'value3'} 

set.add('value2');
set.add('value4');

console.log(set); // Set {'value1', 'value2', 'value3', 'value4'} 
```

### Wert löschen
Die Methode `delete()` löscht den angegebenen Wert aus der Set, wenn dieser enthalten ist und gibt `true` zurück. Ansonsten `false`.

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

console.log(set.delete('value1')); // true
console.log(set.delete('value1')); // false
```

### Prüfen, ob Wert vorhanden ist
Die `has()` Methode gibt zurück, ob der angegebene Value im Set enthalten ist oder nicht. Die Methode gibt "true" zurück, wenn der Value im Set vorhanden ist, andernfalls gibt sie "false" zurück.

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

console.log(set.has('value1')); // true
console.log(set.has('value4')); // false
```

### Set zurücksetzen
Die `clear()`-Methode löscht alle Elemente aus der Set.

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

console.log(set.has('value1')); // true
console.log(set.has('value2')); // true
console.log(set.has('value2')); // true

set.clear();

console.log(set.has('value1')); // false
console.log(set.has('value2')); // false
console.log(set.has('value3')); // false
```

### Anzahl Elemente
Die Methode `size()` gibt die Anzahl der Elemente im Set zurück.

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

console.log(set.size); // 3

set.clear();

console.log(set.size); // 0
```

## Set Iteratoren
Im Set existieren im Grunde fast die gleichen Iteratoren wie bei einer Map. Jedoch gibt es bei `keys()` und `entries()` Unterschiede, diese sind nachfolgend nachzulesen.

### values()
`values()` gibt einen Iterator zurück, der die Werte des Sets in der Reihenfolge des Einfügens zurück gibt:

```javascript
const set = new Set();

set.add('value1');
set.add('value2');
set.add('value3');

for (const value of set.values()){
    console.log(value);
}

// value1
// value2
// value3
```

### keys() und entries()
`keys()` gibt einen Iterator zurück, der dieselben Value wie der `values()`-Iterator zurück gibt. Der `keys()`-Iterator ist jedoch nur aus Gründen der Kompatibilität mit der Map-Datenstruktur verfügbar und existiert für Sets nur, weil Sets auf der gleichen Grundlage wie Maps implementiert sind.

Dasselbe gilt auch für die `entries()`-Methode.