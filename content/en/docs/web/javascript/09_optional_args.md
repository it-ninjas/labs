---
title: "ES6: Optionale Argumente in Methoden und Konstruktoren"
type: docs
linkTitle: "ES6: Optionale Argumente"
weight: 9
date: 2023-01-09
description: >
  Seit ES2015 (ES6) gibt es in JavaScript die Möglichkeit, den Parametern von Methoden einen Default-Wert zu geben.
---


## Ziele
* Du weisst, wie du in JavaScript optionale Argumente in einem Parameter einen Default-Wert zuweisen kannst.
* Du weisst, wie du Named Arguments in Parameter verwenden kannst.


## Basics

Methoden (und daher auch Konstruktore) besitzen oft Werte, die zwingend übergeben werden müssen und welche, die optional sind.

Beim nächsten Beispiel wäre z.B. der Name bei einer Person zwingend, das Alter, Geschlecht und sein/ihr Verhältnis zu JavaScript optional:

```javascript
class Person {
    name;
    age;
    gender;
    lovesJavaScript;

    constructor(name, age = undefined, gender = undefined, lovesJavaScript = true) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.lovesJavaScript = lovesJavaScript;
    }
}

new Person("Sweating Towel Guy", 44);
>>> Person {name: 'Sweating Towel Guy', age: 44, gender: undefined, lovesJavaScript: true}
```

Mit dieser Lösung hast du zwar eine Lösung, das die Präferenz einer Person bez. JavaScript speichert, auch wenn nur ein Name angebeben wird. Aber was wäre, wenn du Eine Person erstellen möchtest mit einem Geschlecht, aber das Alter nicht angeben möchtest?

Hierfür bieten sich dann Named Parameters an:


## Named Parameters
Dank dem Object Destructuring aus ES6 kannst du alle optionale Argument einzeln zuweisen bzw. überspringen. Das könnte wie folgt aussehen:

```javascript
class Person {

    constructor(name, {age = undefined, gender = undefined, lovesJavaScript = true}) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.lovesJavaScript = lovesJavaScript;
    }
}

new Person("Steven Crowder", {gender: "male"});
>>> Person {name: 'Steven Crowder', age: undefined, gender: 'male', lovesJavaScript: true}
```