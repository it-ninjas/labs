---
title: "ES6: Importe"
type: docs
linkTitle: "ES6: Importe"
weight: 8
date: 2023-01-09
description: >
  Seit ES2015 (ES6) gibt es in JavaScript die Möglichkeit, Exporte aus anderen JavaScript-Dateien zu importieren.
---


## Ziele
* Du weisst, wann du in JavaScript das Keyword `import` brauchen kannst.
* Du weisst, wie du `export`s `import`ieren kannst.
* Du weisst, welche Variablen, Klassen, Methoden usw. in einer Datei "public" sind.
* Du kennst die Unterschiede zwischen `default` und named Exports/Imports.


## Basics
Was ist der Einfluss, wenn ein Browser eine JavaScript-Datei mit folgendem Inhalt ladet?

```javascript
var x = "Gugus";
```

Diese Datei bewirkt, dass in allen anderen Dateien evlt. auch diese omniöse Variable `x` verfügbar ist (natürlich abhängig davon, was zuerst geladen wird).

Das kann in sehr vielen Hinsichten schlecht sein:
* Was, wenn in mehreren Dateien eine Variable `x` deklariert wird?
* Was, wenn wir diese Variable eigentlich gar nicht veröffentlichen wollten?
* Diese Variable ist möglicherweise in den Entwicklungstools ([F12]-Taste) in der Konsole direkt ohne Aufwand ersichtlich, ausles- und manipulierbar.
* Was, wenn du eine gleichnamige Variable aus einer anderen Datei benötigst?

Um viele solche Probleme aus dem Weg zu gehen, wurde in ES6 (ECMAScript 2015, JavaScript Standard) JavaScript Modules eingeführt.

Hast du in einer JavaScript-Datei Variablen, Funktionen oder Klassen, die du in einer anderen Datei brauchen willst, dann kannst du das wie folgt tun:

```javascript
export const a = "A";
export const b = "B";

export class Person {
    name;
    constructor(name) { this.name = name;}
}
```

Nun kannst du diese Variablen in einer anderen JavaScript-Datei wie folgt importieren:

```javascript
import { a, b, Person } from "./path/to/your/file.js";
```

## Imports in HTML-Dateien

Vielleicht kommst du mal aus irgendeinem Grund in die Situation, in welcher du im Browser ohne JS-Framework wie React oder Angular ein JavaScript-Modul laden musst. Das kannst du das im HTML wie folgt ganz einfach machen:

```html
<script type="module">

    import {a, b, Person } from "./file.js";
    console.log(a, b, new Person('Monkey Puppet'));

</script>
```

Beachte, dass die `type`-Angabe im `<script>`-Tag zwingend ist und dass die Imports nur innerhalb dieses `<script>`-Tags verfügbar sind.

Möchtest du ohne die Angabe von `type="module"` Variablen importieren (z.B. in den Browser-DevTools), dann kannst du das `import`-Keyword nicht wie gewöhnlich benutzen. Importieren kannst du auf folgende Art und Weise:

```javascript
const {a, b, Person } = await import('./file.js');
```


## `default` Ex- und Importe
Das ES6-Modul-System unterscheidet zwischen `default` und "named" Exporten:
* Eine Datei kann mehrere named-Exporte haben. Alle Exporte bis hier auf der Seite sind named Exporte.
* Eine Datei kann aber nur einen `default` Export besitzen. Wenn eine Datei z.B. nur etwas exportieren soll, dann eignet sich ein `default`-Export hierfür.

Angenommen, wir haben z.B. eine Datei "person.js", die eine Klasse und ein paar Utility-Funktionen zu dieser Klasse anbietet, dann könnten die Exporte wie folgt aussehen:

```javascript
export default class Person {
    name;
    constructor(name) { this.name = name;}
}
export function personFromJson(jsonString){
    const obj = JSON.parse(jsonString);
    return new Person(obj.name);
}
export function getNameOfPerson(person){
    return person.name;
};
```

Dies wiederum könnte z.B. wie folgt importiert werden:

```javascript
import ClassForPerson, { personFromJson, getNameOfPerson } from "./person.js";

const person = personFromJson('{"name": "Mr. Incredible"}');
console.log(getNameOfPerson(person));
>>> Mr. Incredible

console.log(person instanceof ClassForPerson);
>>> true
```

Wie du hier sehen kannst, können wir den `default`-Export mit irgendeinem Namen importieren, der __nicht__ mit dem Namen in der Export-Datei übereinstimmen muss.