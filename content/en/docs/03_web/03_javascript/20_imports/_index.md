---
title: "ES6: Importe"
type: docs
linkTitle: "ES6: Importe"
weight: 20
date: 2023-01-09
description: >
  Modul #F4 - JavaScript - Aus anderen JavaScript-Dateien importieren
---

## Motivation

Seit ES2015 (ES6) gibt es in JavaScript die Möglichkeit, Exporte aus anderen JavaScript-Dateien zu importieren.

## Ziele

- Du weisst, wann du in JavaScript das Keyword `import` brauchen kannst.
- Du weisst, wie du `export`s `import`ieren kannst.
- Du weisst, welche Variablen, Klassen, Methoden etc. in einer Datei `public` sind.
- Du kennst die Unterschiede zwischen `default` und `named` Exports und Imports.

## Basics

Was ist das Ergebnis, wenn ein Browser eine JavaScript-Datei mit folgendem Inhalt lädt?

```javascript
var x = "Gugus";
```

Diese Datei bewirkt, dass in allen anderen Dateien je nachdem die ominöse Variable `x` ebenfalls verfügbar ist, abhängig davon, was zuerst geladen wird.

Das ist in vielerlei Hinsicht unvorteilhaft:

- Was, wenn in mehreren Dateien eine Variable `x` deklariert wird?
- Was, wenn wir diese Variable eigentlich gar nicht veröffentlichen wollten?
- Diese Variable ist möglicherweise in den Entwicklertools ([F12]-Taste) in der Konsole direkt ohne Aufwand auslesbar und manipulierbar.
- Was, wenn du eine gleichnamige Variable aus einer anderen Datei benötigst?

Um eben diesen Problemen aus dem Weg zu gehen, wurden in ES6 JavaScript-Modules eingeführt.

Hast du in einer JavaScript-Datei Variablen, Funktionen oder Klassen, die du in einer anderen Datei brauchen willst, dann kannst du diese wie folgt deklarieren:

```javascript
export const a = "A";
export const b = "B";

export class Person {
  name;
  constructor(name) {
    this.name = name;
  }
}
```

Nun kannst du diese Variablen in einer anderen JavaScript-Datei wie folgt importieren:

```javascript
import { a, b, Person } from "./path/to/your/file.js";
```

## Imports in HTML-Dateien

Vielleicht kommst du mal in die Situation, dass du in einem Browser ohne JS-Framework wie React oder Angular ein JavaScript-Modul laden möchtest. Das kannst du in HTML wie folgt machen:

```html
<script type="module">
  import { a, b, Person } from "./file.js";
  console.log(a, b, new Person("Monkey Puppet"));
</script>
```

Beachte, dass die `type`-Angabe im `<script>`-Tag zwingend ist und die Imports nur innerhalb dieses `<script>`-Tags verfügbar sind.

Möchtest du ohne die Angabe von `type="module"` Variablen importieren (beispielsweise in den Entwicklertools deines Browsers), dann kannst du nicht wie gewohnt das `import`-Keyword benutzen. Importieren kannst du dann auf die folgende Art:

```javascript
const { a, b, Person } = await import("./file.js");
```

In diesem Beispiel hast du `import(...)` wie eine Funktion verwendet. Weil diese "Funktion" ein `Promise` zurückgibt (da sie das Modul `async`hron lädt), sollte hier der Import `await`ed werden. So kann sichergestellt werden, dass der später folgende Code erst aufgerufen wird, nachdem das Modul komplett geladen wurde. Falls du dich nicht mit `async` und `await` auskennst, solltest du den Abschnitt [Promises](https://labs.it-ninjas.ch/docs/web/javascript/16_js_async/) noch einmal anschauen.

## `default` Ex- und Importe

Das ES6-Modul-System unterscheidet zwischen `default`- und `named`-Exporten:

- Eine Datei kann mehrere `named`-Exporte haben. Alle in den bisherigen Beispielen gemachten Exporte waren `named`-Exporte.
- Eine Datei kann hingegen nur einen `default` Export besitzen. Wenn eine Datei z.B. nur etwas exportieren soll, dann eignet sich ein `default`-Export hierfür.

Angenommen, wir haben eine Datei `person.js`, die eine Klasse und ein paar Utility-Funktionen zu dieser Klasse anbietet, dann können die Exporte aussehen wie folgt:

```javascript
export default class Person {
  name;
  constructor(name) {
    this.name = name;
  }
}
export function personFromJson(jsonString) {
  const obj = JSON.parse(jsonString);
  return new Person(obj.name);
}
export function getNameOfPerson(person) {
  return person.name;
}
```

Dieses Beispiel wiederum kann beispielsweise importiert werden wie folgt:

```javascript
import ClassForPerson, { personFromJson, getNameOfPerson } from "./person.js";

const person = personFromJson('{"name": "Mr. Incredible"}');
console.log(getNameOfPerson(person));
>>> Mr. Incredible

console.log(person instanceof ClassForPerson);
>>> true
```

Wie du hier sehen kannst, können wir den `default`-Export mit irgendeinem Namen importieren, der **nicht** mit dem Namen in der Export-Datei übereinstimmen muss.
