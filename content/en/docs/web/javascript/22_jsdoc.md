---
title: "JSDoc"
type: docs
linkTitle: "JSDoc"
weight: 22
date: 2023-01-09
description: >
  Modul #F4 - JavaScript - Funktionen mit einer Beschreibung versehen.
---

## Motivation

Wenn du existierende Funktionen benutzen möchtest, dann wäre es doch praktisch, wenn deine IDE dir direkt mitteilt, was die Funktion bewirkt und welche Typen die Parameter haben. Das lässt sich mit JSDoc erreichen.

## Ziele

- Du weisst, wie du in JavaScript zu Klassen und Funktionen eine Beschreibung hinzufügen kannst, die dir deine Entwicklungsumgebung anzeigt, wenn du diese mittels Auto-Completion auswählst.
- Du weisst, wie du in JavaScript eine Typ-Angabe machen kannst (die aber zur Laufzeit nichts bewirkt).

## Basics

In TypeScript kannst du jeder Variable einen Typ und jeder Funktion einen Rückgabewert zuweisen. Dsa geht in JavaScript nicht so einfach.

Trotzdem kannst du dank des JSDoc-Projekts (https://jsdoc.app/about-getting-started.html) Typ-Angaben machen, damit deine Entwicklungsumgebung sich beschwert, wenn beispielsweise in einer Funktion ein Wert eines falschen Types übergeben wird.

In nächsten Beispiel siehst du, wie du in einer Funktion die Typen spezifizieren kannst:

```javascript
/**
 * Diese Funktion leitet die Argumente dem Konstruktor der Klasse `Person` weiter.
 * @param {string} name                 Der Name der Person
 * @param {Object} namedArgs            (Eigentlich unnötig, wird aber als Label für die Referenz auf die named Parameter benötigt)
 * @param {number} [namedArgs.age]      Alter
 * @param {string} [namedArgs.gender]   Geschlecht, darf irgend ein String sein.
 * @returns {Person}                    Ein Personen-Objekt mit den übergebenen Werten.
 */
function createPerson(name, { age = undefined, gender = undefined }) {
  return new Person(name, {
    age: age,
    gender: gender,
  });
}
```

Deine Entwicklungsumgebung kann diese Informationen nun auch anzeigen:

![VS Code zeigt nun den JSDoc an, wenn du diese Funktion eintippst](../images/vscode-jsdoc.jpg "JSDoc in VS Code")

## Tags

Im vorherigen JSDoc wurden viele Tags verwendet. Hier eine kleine Übersicht zu den wichtigsten:

- `@param`: Damit wird ein Parameter beschrieben.
- `@returns`: Damit wird der Rückgabewert beschrieben.
- `{number}`: Das ist eine Typangabe. Im Beispiel muss das Argument eine Zahl sein.
- `[namedArgs.gender]`: Die eckigen Klammern spezifizieren das Argument als optional (nullable). Ansonsten sollten die Argumente nicht den Wert `undefined` oder `null` annehmen.

Eine Auflistung aller JSDoc-Tags findest du hier: https://www.typescriptlang.org/docs/handbook/jsdoc-supported-types.html

## Fehler anzeigen, wenn Typen falsch sind

In VS Code gibt es die Möglichkeit, dass die IDE eine Meldung ausgibt, wenn du Werte des falschen Typs übergibst.

Um hiervon Gebrauch zu machen, kann im Projekt-Verzeichnis eine `jsconfig.json`-Datei angelegt werden. Folgende Konfiguration könnte für Browser-Anwendungen Sinn ergeben, wenn sich die JS-Dateien beispielsweise im Ordner "${workspaceFolder}/static/js/" befinden:

```json
{
  "compilerOptions": {
    "module": "commonjs",
    "target": "es6",
    "baseUrl": ".",
    "checkJs": true,
    "importHelpers": true,
    "lib": ["DOM", "ES2021", "DOM.Iterable"]
  },
  "exclude": ["node_modules"],
  "include": ["static/js/*"]
}
```

Dank dieser Konfiguration würde dir VS Code nun einen Fehler anzeigen, wenn du statt einem `string` eine `number` übergeben würdest:

![VS Code zeigt nun an, dass du einen string angeben solltest anstatt einer number](../images/vscode-jsdoc-error.jpg "checkJs in VS Code")
