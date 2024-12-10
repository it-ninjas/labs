---
title: "Einführung in TypeScript"
type: docs
linkTitle: "Einführung in TypeScript"
weight: 1
date: 2022-02-16
description: >
  Modul #F5 - TypeScript - JavaScript mit Typen.
---

### Ziele

- Du weisst, was Typescript ist und inwiefern es sich von Javascript unterscheidet.
- Du weisst, welche Vorteile Typescript im Vergleich zu Javascript hat.
- Du weisst, wie du den objektorientierten Programmieransatz in Typescript einbinden kannst und wie man in Typescript Klassen verwendet.

## Was ist TypeScript?

Die Programmiersprache Typescript wurde von Microsoft entwickelt und wurde im Jahr 2012 mit der ersten Version veröffentlicht.
Seitdem wird die Programmiersprache kontinuierlich weiterentwickelt. Zahlreiche JavaScript-Frameworks setzen heute auf die Verwendung von TypeScript.
Dazu gehören zum Beispiel Angular 2+ und React.

TypeScript bildet eine Erweiterung von JavaScript, fügt also JavaScript bestimmte Features hinzu.
Es handelt sich dabei also um ein sogenanntes Superset von JavaScript.

Da Quellcode geschrieben in TypeScript zu JavaScript transpiliert wird, ist der Code in jedem Browser lauffähig.

## Vorteile von TypeScript

- TypeScript hebt Fehler während der Transpilierung hervor, während JavaScript das erst zur Laufzeit macht.
- TypeScript unterstützt statische Typisierung.
- Ermöglicht bessere Code-Strukturierung und Objekt-Orientierte Programmiertechniken.
- TypeScript ist in jedem Browser und jeder JS-Engine lauffähig.
- Hervorragendes "Tooling" mit IntelliSense, das beim Hinzufügen des Codes aktive Hinweise liefert.

## Grundlegende Syntax

Da es sich bei TypeScript um ein Superset von JavaScript handelt, ist JavaScript-Code auch gültiger TypeScript-Code. Jedoch fügt TypeScript darüber hinaus viele neue Funktionen hinzu.

Mit TypeScript wird JavaScript zu einer stark typisierten, objektorientierten Sprache, die C# und Java ähnelt. Dies bedeutet, dass TypeScript-Code für grosse Projekte leichter zu verstehen, verwenden und verwalten ist. Die starke Typisierung bedeutet auch, dass die Sprache vorkompiliert werden kann und dass Variablen keine Werte zugewiesen werden können, die ausserhalb ihres angegebenen Bereichs liegen. Wenn zum Beispiel eine TypeScript-Variable als Zahl deklariert ist, kann man dieser Variable keinen Textwert zuweisen.

## Null Safety

In TypeScript gibt es standardmäßig keine "Null Safety" im Sinne einer statischen Typüberprüfung auf mögliche Null- oder Undefined-Werte. Das bedeutet, dass Variablen jeden Typ annehmen können, einschliesslich `null` oder `undefined`, es sei denn, es wird explizit angegeben, dass sie einen anderen Typ haben sollen.
Das kann dazu führen, dass in TypeScript-Code unerwartete Fehler auftreten, wenn versucht wird, auf Eigenschaften oder Methoden von null- oder undefined-Variablen zuzugreifen. Solche Fehler treten normalerweise zur Laufzeit auf und werden nicht vom Compiler erkannt.

Um das Risiko von Fehlern durch null- oder undefined-Werte zu reduzieren, kann man die Option `strictNullChecks` in der `tsconfig.json`-Datei aktivieren.

## Typanmeldungen

Typdeklarationen können zu Variablen, Funktionsparametern und Funktionsrückgabetypen hinzugefügt werden.
Der Typ folgt jeweils auf einen Doppelpunkt hinter dem Variablennamen:

```typescript
const num: number = 1;
```

Der Compiler überprüft dann die Typen während des Transpilierens und meldet allfällige Typfehler.

Die verschiedenen Grundtypen von TypeScript sind [hier](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html) ersichtlich.

### Type Any

Der Typ `any` ist ein spezieller Typ, der es ermöglicht, Variablen, Funktionen und andere Objekte ohne explizite Typisierung zu deklarieren. Wenn eine Variable oder ein Objekt mit `any` deklariert wird, bedeutet dies, dass der Typ nicht eingeschränkt ist und dass alle Arten von Werten diesem Typ zugewiesen werden können, ohne dass eine Typenüberprüfung durchgeführt wird. Das bedeutet, dass man so die gesamte Typisierung umgehen kann und dann wie bei JavaScript Typfehler erst während der Laufzeit sehen würde.

Beispiel mit `any`, welches zu Laufzeitfehler führt:

```typescript
function add(a: any, b: any) {
  return a + b;
}

const result = add("3", 5);
console.log(result);
```

## Der Objektorientierte Ansatz

Bei der objektorientierten Programmierung handelt es sich um einen Programmierstil / eine Denkweise.

Man kann sich das so vorstellen, dass alles in der objektorientierten Programmierung durch Objekte abgebildet wird.
Jedes "Teil" eines Programmes wird durch ein Objekt beschrieben.

Ein Beispiel:

> In einer Spielewelt gibt es einen frei herumlaufenden Hund.
> Dann wäre dieser Hund nichts anderes als ein Objekt.

    Nun könnte man sich fragen, wie man diesen Hund wahrnimmt, denn nicht jeder Hund ist gleich.
    Sie könnten sich in Rasse, Gattung etc. unterscheiden. Ein Objekt kann also verschiedene Eigenschaften besitzen,
    diese werden auch Attribute genannt.

Nun kann sich unser Hund von Anderen unterscheiden, jedoch kann er noch nicht bellen. Deshalb haben
Objekte auch Funktionen (Methoden). In unserem Beispiel könnte der Hund z.B. über die Methode "bark()" verfügen,
welche es ihm erlaubt, zu bellen.

In unserem Beispiel handelt es sich bei dem Hund um eine Klasse. Klassen sind also wie Baupläne für Objekte.

Nun sagen wir, dass es in unserer Spielwelt auch Katzen gibt.
An dieser Stelle kommt dann die Vererbung ins Spiel.

Hunde sowie Katzen sind beides Tiere. In der Objektorientierten Programmierung würde man dazu also eine Klasse "Animal" erstellen.
Die beiden Klassen "Cat" und "Dog" würden dann die Klasse "Animal" erben. Dies Bedeutet, dass sie die Eigenschaften der Klasse "Animal" übernehmen
und durch ihre eigenen Eigenschaften ergänzen.

Da sich beide Tiere fortbewegen, könnte man also der Klasse "Animal" die Funktion "move()" geben, welche dann von den beiden anderen Klassen geerbt werden würde.
Dadurch hat man verhindert, dass sich die Funktion zum bewegen mehrmals im Quellcode befindet.

![Vererbung](../images/Vererbung.png "Vererbung")

## Klassen

Ein einfaches Beispiel einer Klasse:

```javascript
class Greeter {
    greeting: string;
    constructor(message: string) {
        this.greeting = message;
    }
    greet() {
        return "Hello, " + this.greeting;
    }
}

let greeter = new Greeter("world");
```

In diesem Beispiel wird eine neue Klasse "Greeter" deklariert. Die Klasse enthält 3 Member:

- Das Property "greeting"
- Den Konstruktor
- Die Methode "greet"

Wenn wir in einer Klasse auf ein Member innerhalb der Klasse referenzieren, verwenden wir `this.`.

Auf der letzten Zeile erstellen wir eine neue Instanz der Klasse `Greeter` mit `new`.

## Interfaces

Als Gegenstück zu Klassen exisiteren in Typescript ebenfalls Interfaces.

Klassen haben die Eigenschaft, dass sie in Javascript "reale" Dinge sind. Es ist also möglich, diese über den prototype zu verwenden oder mit "instanceof" den Typ der Klasse zu überprüfen.

Interfaces werden hingegen vom Compiler "gelöscht". Das heisst, dass sie von Javascript (wahrscheinlich) als einfache Objekte interpretiert werden.

Ein Beispiel für ein Interface wäre das folgende:

```javascript
interface Person{
    name: String;
    alter: number;
}
```

### Vererbung

In TypeScript können wir allgemeine objektorientierte Muster verwenden. Eines der grundlegendsten Muster in der klassenbasierten Programmierung ist die Möglichkeit, vorhandene Klassen durch Vererbung zu erweitern, um neue Klassen zu erstellen.

```typescript
class Animal {
  move(distanceInMeters: number = 0) {
    console.log(`Animal moved ${distanceInMeters}m.`);
  }
}

class Dog extends Animal {
  bark() {
    console.log("Woof!");
  }
}

const dog = new Dog();
dog.bark();
dog.move(10);
dog.bark();
```

Dieses Beispiel zeigt die grundlegendste Vererbungsfunktion: Klassen erben Eigenschaften und Methoden von Basisklassen (`Animal`). `Dog` ist hier eine abgeleitete Klasse, die mit dem Schlüsselwort `extends` von der Basisklasse Animal abgeleitet wird. Abgeleitete Klassen werden häufig als Unterklassen bezeichnet, und Basisklassen als Superklassen.

Da `Dog` die Funktionalität von `Animal` erweitert, konnten wir eine Instanz von `Dog` erstellen, die sowohl `bark()` als auch `move()` ausführen konnte.

**Ein komplexeres Beispiel zur Vertiefung:**

```typescript
class Animal {
  name: string;
  constructor(theName: string) {
    this.name = theName;
  }
  move(distanceInMeters: number = 0) {
    console.log(`Animal moved ${distanceInMeters}m.`);
  }
}

class Snake extends Animal {
  constructor(name: string) {
    super(name);
  }
  move(distanceInMeters: number = 5) {
    console.log("Slithering...");
    super.move(distanceInMeters);
  }
}

class Horse extends Animal {
  constructor(name: string) {
    super(name);
  }
  move(distanceInMeters: number = 45) {
    console.log("Galloping...");
    super.move(distanceInMeters);
  }
}

let sammy = new Snake("Sammy the Python");
let tom: Animal = new Horse("Tom the Palomino");

sammy.move();
tom.move(35);
```

In diesem Beispiel werden zwei neue Subklassen von `Animal` erstellt: `Horse` und `Snake`.

Ein Unterschied zum vorherigen Beispiel besteht darin, dass jede abgeleitete Klasse, die eine Konstruktorfunktion enthält, `super()` aufrufen muss, wodurch der Konstruktor der Basisklasse ausgeführt wird. Ausserdem müssen wir `super()` aufrufen, damit wir im Konstruktorkörper auf `name` mit `this` zugreifen können.

Konsolenausgabe des Beispiels:

```
Slithering...
Sammy the Python moved 5m.
Galloping...
Tom the Palomino moved 34m.
```
