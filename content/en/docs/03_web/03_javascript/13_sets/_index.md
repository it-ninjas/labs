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

- Du kennst den Unterschied zwischen Maps und Sets.
- Du kannst Sets erstellen, bearbeiten und Daten aus diesen abrufen.
- Du kannst Set-Iteratoren erklären.

## Set

Oft möchte man eine Liste haben, in der gegeben sein soll, dass jedes Element nur einmal vorkommen kann.

Genau diesen Zweck erfüllt die `Set`-Datenstruktur.

```javascript
const set = new Set();
```

### Wert hinzufügen

Die `add(value)`-Methode fügt einen Wert zu einem Set hinzu.

Wenn der Wert bereits im Set vorkommt, wird der Wert kein weiteres Mal hinzugefügt, wie im folgenden Beispiel gezeigt wird:

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

console.log(set); // Set {'value1', 'value2', 'value3'}

set.add("value2");
set.add("value4");

console.log(set); // Set {'value1', 'value2', 'value3', 'value4'}
```

### Wert löschen

Die `delete()`-Methode löscht den angegebenen Wert aus dem Set, wenn dieser enthalten ist und gibt als Rückgabewert `true` aus, ansonsten `false`.

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

console.log(set.delete("value1")); // true
console.log(set.delete("value1")); // false
```

### Prüfen, ob ein Wert vorhanden ist

Die `has()`-Methode gibt zurück, ob der angegebene Value im Set enthalten ist oder nicht. Die Methode gibt `true` zurück, wenn der Value im Set vorhanden ist, andernfalls gibt sie `false` zurück.

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

console.log(set.has("value1")); // true
console.log(set.has("value4")); // false
```

### Set zurücksetzen

Die `clear()`-Methode löscht alle Elemente aus dem Set.

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

console.log(set.has("value1")); // true
console.log(set.has("value2")); // true
console.log(set.has("value2")); // true

set.clear();

console.log(set.has("value1")); // false
console.log(set.has("value2")); // false
console.log(set.has("value3")); // false
```

### Anzahl Elemente

Die `size()`-Methode gibt die Anzahl der Elemente in einem Set zurück.

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

console.log(set.size); // 3

set.clear();

console.log(set.size); // 0
```

## Set Iteratoren

Im Set existieren im Grunde beinahe die gleichen Iteratoren wie bei einer Map. Jedoch gibt es bei `keys()` und `entries()` Unterschiede, welche nachfolgend genauer beschrieben werden.

### values()

`values()` gibt einen Iterator zurück, der die Werte des Sets in der Reihenfolge des Einfügens zurückgibt:

```javascript
const set = new Set();

set.add("value1");
set.add("value2");
set.add("value3");

for (const value of set.values()) {
  console.log(value);
}

// value1
// value2
// value3
```

### keys() und entries()

`keys()` gibt einen Iterator zurück, der dieselben Values wie der `values()`-Iterator zurück gibt. Der `keys()`-Iterator ist jedoch nur aus Gründen der Kompatibilität mit der Map-Datenstruktur verfügbar und existiert für Sets nur, weil Sets auf der gleichen Grundlage wie Maps implementiert sind.

Dasselbe gilt auch für die `entries()`-Methode.
