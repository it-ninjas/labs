---
title: "Prototyping und Klassen"
type: docs
linkTitle: "Prototyping und Klassen"
weight: 18
date: 2023-04-20
description: >
  Modul #F4 - JavaScript - Prototypen und Klassen.
---

## Ziele

- Du weisst, was Prototypen sind und dass JavaScript eine Prototyp-basierte Programmiersprache ist. 
- Du weisst, was Klassen sind und wie man diese verwendet. 
- Du weisst, was statische Methoden sind und wie man sie verwendet. 
- Du weisst, was die Methoden `typeOf` und `instanceOf` bewirken, wie man sie verwendet und was die beiden Methoden voneinander unterscheidet. 

## JavaScript ist eine Prototyp-basierte Programmiersprache

JavaScript ist eine Prototyp-basierte Programmiersprache, was bedeutet, dass die Vererbung und die Erstellung von Objekten auf Prototypen basieren.

Ein Prototyp ist ein vordefiniertes Objekt, welches als Vorlage für die Erstellung neuer Objekte dient. Wenn ein neues Objekt erstellt wird, erbt es automatisch Eigenschaften und Methoden von seinem Prototypen.

```javascript
// create Object-Prototyp
const personProto = {
  name: "",
  age: 0,

  speak: function () {
    console.log("Hello World!");
  },
};

// Erstellen eines Objekts basierend auf einem Prototypen
const person1 = Object.create(personProto);
person1.name = "John";
person1.age = 30;

// Erstellen eines weiteren Objekts basierend auf dem Prototypen
const person2 = Object.create(personProto);
person2.name = "Jane";
person2.age = 25;

console.log(person1); // { name: "John", age: 30 }
console.log(person2); // { name: "Jane", age: 25 }
person1.speak(); //'Hello World!'
```

## Klassen in JavaScript

Es gibt in JavaScript das Konzept von Klassen, das in der objektorientierten Programmierung verwendet wird.

```javascript
// Klasse
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  sayHello() {
    console.log("Hello, my name is " + this.name);
  }
}

// Eine Instanz der Klasse erstellen
const person = new Person("Max", 30);

// Eine Methode der Klasse aufrufen
person1.sayHello(); // Hello, my name is Max
```

### static Methods

Es gibt auch hier statische Methoden, welche in Klassen definiert werden, um Methoden aufzurufen, die nicht an eine bestimmte Instanz der Klasse gebunden sind, sondern direkt auf der Klasse selbst aufgerufen werden können.

Statische Methoden sind hilfreich, um Hilfsfunktionen in einer Klasse zu definieren, die nicht auf eine bestimmte Instanz der Klasse angewiesen sind.
Sie können auch verwendet werden, um Konstruktoren in einer Klasse zu definieren, die nur einmal ausgeführt werden müssen, unabhängig davon, wie viele Instanzen der Klasse erstellt werden.

Statische Methoden werden mit dem Schlüsselbegriff `static` vor der Methodendefinition gekennzeichnet.

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  sayHello() {
    console.log("Hello, my name is " + this.name);
  }

  static sayBye() {
    console.log("Bye Bye");
  }
}

const person = new Person("Max", 30);

console.log(person.name); // Max
console.log(person.age); // 30

person.sayHello(); // Hello, my name is Max
Person.sayBye(); // Bye Bye
```

Natürlich kann eine Klasse auch von einer anderen erben. Dazu wird der `extends`-Schlüsselbegriff verwendet:

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
}

class Student extends Person {
  constructor(name, age, major) {
    super(name, age);
    this.major = major;
  }
}

const person = new Person("Max", 30);
const student = new Student("John", 20, "Computer Science");

console.log(person.name); // Max
console.log(person.age); // 30

console.log(student.name); // John
console.log(student.age); // 20
console.log(student.major); // Computer Science
```

### typeof vs instanceof bei Klassen

Es gibt zwei Möglichkeiten, den Typ eines Objekts zu überprüfen: den `typeof`-Operator und den `instanceof`-Operator. Wenn es um Klassen geht, haben beide ihre eigenen Anwendungsfälle und Unterschiede:

`typeof` wird verwendet, um den Typen eines Werts zu überprüfen. Wenn eine Klasse definiert wird, wird ihr Typ als "function" angegeben. Für eine Instanz wird `object` zurückgegeben.

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
}

const person = new Person("Max", 30);

console.log(typeof Person); // "function"
console.log(typeof person); // "object"
```

`instanceof` wird verwendet, um zu überprüfen, ob eine Instanz einer bestimmten Klasse angehört.

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
}

class Student extends Person {
  constructor(name, age, major) {
    super(name, age);
    this.major = major;
  }
}

const person = new Person("Max", 30);
const student = new Student("John", 20, "Computer Science");

console.log(student instanceof Person); // true
console.log(student instanceof Student); // true
console.log(person instanceof Student); // false
```
