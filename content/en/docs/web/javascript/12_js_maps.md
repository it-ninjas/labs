---
title: "Maps"
type: docs
linkTitle: "Maps"
weight: 12
date: 2023-03-31
description: >
  Modul #F4 - JavaScript - Maps.
---

## Ziele

- Du kennst den Unterschied zwischen Maps und Sets.
- Du kannst Maps erstellen, bearbeiten und Daten abrufen.
- Du kannst Map-Iteratoren verwenden.

## Map

Maps sind spezielle Objekte, die eine Zuordnung eines Keys zu einem Value ermöglichen. Der Key kann ein beliebiges Objekt sein, während der Value beliebig sein kann. Eine Map speichert keine Duplikat-Keys.

```javascript
const map = new Map();
```

### Eintrag hinzufügen

Mit der `set()`-Methode wird ein neues Key-Value-Paar zur Map hinzugefügt. Der erste Parameter der Methode ist der Key und der zweite Parameter ist der Value, der mit dem Key assoziiert werden soll. Wenn die Map bereits einen Eintrag mit dem angegebenen Key enthält, wird der neue Value anstelle des alten Values gespeichert.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map); // Map {'key1' => 'value1', 'key2' => 'value2', 'key3' => 'value3'}

map.set("key1", "value4");

console.log(map); // Map {'key1' => 'value4', 'key2' => 'value2', 'key3' => 'value3'}
```

### Wert (value) für Key ermitteln

Die `get(key)` Methode gibt den Value zurück, der mit einem bestimmten Key in der Map assoziiert wird. Wenn der Key nicht vorhanden ist, gibt die Methode `undefined` zurück.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map.get("key1")); // 'value1'
console.log(map.get("key4")); // undefined
```

### Prüfen, ob Key vorhanden ist

Die `has(key)` Methode wird verwendet, um zu überprüfen, ob ein bestimmter Key in der Map vorhanden ist. Die Methode gibt, je nachdem ob der Key gefunden wurde oder nicht, einen entsprechenden booleschen Wert zurück.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map.has("key1")); // true
console.log(map.has("key4")); // false
```

### Eintrag löschen

Die Methode `delete(key)` löscht den angegebenen Key und den zugehörigen Value aus der Map. Wenn der Key in der Map vorhanden ist, wird er zusammen mit dem Value entfernt, und die Methode gibt "true" zurück. Wenn der Key nicht vorhanden ist, wird die Map nicht verändert und die Methode gibt "false" zurück.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map.delete("key1")); // true
console.log(map.delete("key4")); // false
console.log(map.get("key1")); // undefined
```

### Map zurücksetzen

Die `clear()`-Methode kann verwendet werden, um alle Key-Value-Paare aus einer Map zu entfernen und diese somit auf den Zustand einer leeren Map zurückzusetzen.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map.get("key1")); // 'value1'
console.log(map.get("key2")); // 'value2'
console.log(map.get("key3")); // 'value2'

map.clear();

console.log(map.get("key1")); // undefined
console.log(map.get("key2")); // undefined
console.log(map.get("key3")); // undefined
```

### Anzahl Elemente

Die `size` Methode einer Map gibt die Anzahl der Key-Value-Paare in der Map zurück.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

console.log(map.size); // 3

map.delete("key1");

console.log(map.size); // 2

map.clear();

console.log(map.size); // 0
```

## Map Iteratoren

Iteratoren sind Objekte, die eine Möglichkeit bereitstellen, auf die Elemente einer Sammlung nacheinander zuzugreifen. Ein Iterator bietet also eine sequenzielle Schnittstelle, die es einem ermöglicht, die Elemente einer Sammlung in einer bestimmten Reihenfolge abzurufen.

### entries()

Die `entries()`-Methode gibt einen Iterator zurück, der alle Key-Value-Paare der Map in der Reihenfolge ihrer Hinzufügung enthält. Jedes Element des Iterators ist ein Array mit zwei Elementen, dem Key und dem zugehörigen Value.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

for (const [key, value] of map.entries()) {
  console.log([key, value]);
}

// Array [ "key1", "value1" ]
// Array [ "key2", "value2" ]
// Array [ "key3", "value3" ]
```

### keys()

Die `keys()`-Methode gibt einen Iterator zurück, der nur die Keys der Map enthält.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

for (const key of map.keys()) {
  console.log(key);
}

// key1
// key2
// key3
```

### values()

Die `values()`-Methode gibt einen Iterator zurück, der im Gegensatz zu der `keys()`-Methode nur die Values der Map enthält.

```javascript
const map = new Map();

map.set("key1", "value1");
map.set("key2", "value2");
map.set("key3", "value3");

for (const value of map.values()) {
  console.log(value);
}

// value1
// value2
// value3
```

## Der Unterschied zwischen Maps und Sets

Maps und Sets funktionieren relativ ähnlich, haben aber trotzdem ein paar Unterschiede zueinander, welche die beiden Datenstrukturen unterscheiden. Auf die genaue Funktionsweise wird im nächsten Abschnitt der Dokumentation genauer eingegangen.

### Nutzen

Maps werden verwendet, um Werte zu speichern, welche jeweils ein `key-value`-Paar beinhalten. Sets hingegen werden verwendet, um Werte zu speichern, bei denen der `value` einzigartig ist.

### Einzigartigkeit

Maps erzwingen die Einzigartigkeit des `key`-Elements, während Sets die Einzigartigkeit des `value`-Elements erzwingen.

### Zugriff auf den Inhalt

Um auf die Daten einer Map zuzugreifen, wird das `key`-Element verwendet. Um auf den Inhalt eines Sets zuzugreifen, wird das `value`-Element verwendet.
