---
title: "JSDoc"
type: docs
linkTitle: "JSDoc"
weight: 10
date: 2023-01-09
description: >
  Funktionen mit einer Beschreibung versehen, die bei Vorschlägen angezeigt wird.
---


## Ziele
* Du weisst, wie du in JavaScript bei Klassen und Funktionen eine Beschreibung hinzufügen kannst, die dir deine Entwicklungsumgebung anzeigt, wenn du mittels Auto-Completion diese Variable auswählst.
* Du weisst, wie du in JavaScript eine Typ-Angabe machen kannst (die aber zur Laufzeit nichts tut).


## Basics
In TypeScript kannst du jeder Variable einen Typ, jeder Funktion einen Rückgabewert zuweisen. Dies kannst du in JavaScript nicht so einfach.

Trotzdem kannst du dank dem JSDoc-Projekt (https://jsdoc.app/about-getting-started.html) Typ-Angaben machen, damit deine Entwicklungsumbegung reklamiert, wenn z.B. in einer Funktion ein Wert eines falschen Types übergeben wird.

In nächsten Beispiel siehst du, wie du in einer Funktion die Typen spezifizieren kannst:

```javascript
/**
 * Diese Funktion leitet die Argumente dem Konstruktor der Klasse `Person` weiter.
 * @param {string} name                 Der Name der Person
 * @param {Object} namedArgs            (Eigentlich unnötig, wird aber als Label für Referenz auf die named Parameter benötigt)
 * @param {number} [namedArgs.age]      Alter
 * @param {string} [namedArgs.gender]   Geschlecht, darf irgend ein String sein.
 * @returns {Person}                    Ein Personen-Objekt mit den übergebenen Werten.
 */
function createPerson(name, { age = undefined, gender = undefined }) {
    return new Person(name, {
        age: age,
        gender: gender,
    })
}
```

Deine Entwicklungsumgebung könnte diese Informationen nun auch anzeigen:

![VS Code zeigt nun den JSDoc an, wenn du diese Funktion eintippst](../images/vscode-jsdoc.jpg "JSDoc in VS Code")

## Tags

Im vorherigen JSDoc wurden viele Tags verwendet. Hier eine Übersicht zu den wichtigsten:
* `@param`: Damit wird ein Parameter beschrieben
* `@returns`: Damit wird der Rückgabewert beschrieben
* `{number}`: Das ist eine Typangabe. Hier musste das Argument eine Zahl sein.
* `[namedArgs.gender]`: Die eckigen Klammern spezifizieren das Argument als optional (nullable). Ansonsten sollten die Argument nicht den Wert `undefined` oder `null` haben.


Eine Auflistung von JSDoc-Tags findest du auch hier: https://www.typescriptlang.org/docs/handbook/jsdoc-supported-types.html

## Fehler anzeigen, wenn Typen falsch sind
In VS Code gibt es die Möglichkeit, dass die IDE reklamiert, wenn du Werte des falschen Typs übergibst.

Um hiervon Gebrauch zu machen, kann im Projekt-Verzeichnis eine `jsconfig.json`-Datei angelegt werden. Folgende Konfiguration könnte für Browser-Anwendungen Sinn ergeben, wenn sich die JS-Dateinen im Ordner "${workspaceFolder}/static/js/" (nur ein Beispiel, kann natürlich auch etwas anderes Sein) befinden:

```json
{
    "compilerOptions": {
    "module": "commonjs",
    "target": "es6",
    "baseUrl": ".",
    "checkJs": true,
    "importHelpers": true,
    "lib": [
      "DOM",
      "ES2021",
      "DOM.Iterable"
    ]
  },
  "exclude": [
    "node_modules"
  ],
  "include": [
      "static/js/*"
  ]
}
```

Dank dieser Konfiguration würde dir VS Code nun einen Fehler anzeigen, wenn du statt einem `string` eine `number` übergeben würdest:

![VS Code zeigt nun an, dass du einen string angeben solltest anstatt einer number](../images/vscode-jsdoc-error.jpg "checkJs in VS Code")
