---
title: "Methoden"
linkTitle: "Methoden"
weight: 9
description: >
  Modul #J1
---
## Ziele
* Ich weiss, wofür Methoden sind.
* Ich weiss, wie eine Methode aufgebaut ist.
* Ich weiss, wie eine Methode mit Parameter aufgebaut ist.
* Ich weiss, wie eine Methode mit Rückgabewert aufgebaut ist.
* Ich kann Methoden gezielt in meinem Programm Methoden einsetzen.




## Was sind Methoden?
In Java sind Methoden Blöcke von Code, die spezifische Aufgaben ausführen. Sie dienen zur Organisation und 
Wiederverwendung von Code. Methoden ermöglichen es, eine Gruppe von Anweisungen in einem eigenen Codeblock zu kapseln 
und diesen Codeblock durch einen Funktionsaufruf auszuführen.

## Aufbau einer Methode

Eine Methode in Java ist wie folgt aufgebaut:

```java
Rückgabetyp methodName(Parameterliste) {
// Methoden Code
}
```

- `Rückgabetyp`: Dieser Typ gibt an, welchen Datentyp die Methode zurückgibt. Wenn die Methode keinen Rückgabewert hat, wird `void` verwendet.
- `methodName`: Der Name der Methode, über den sie aufgerufen wird.
- `Parameterliste`: Hier werden die Parameter aufgelistet, die die Methode erwartet.
- `Methoden Code`: Dies ist der Codeblock, der die spezifische Aufgabe der Methode ausführt.

## Methoden mit Parametern

Methoden können auch Parameter akzeptieren, die beim Aufruf übergeben werden. Hier ist ein Beispiel:

```java
void greetUser(String name) {
System.out.println("Hallo, " + name + "!");
}
```

In diesem Fall erwartet die Methode `greetUser` einen `String`-Parameter, der den Namen des Benutzers enthält.

### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=oSDtCcDXcTM).

## Methoden mit Rückgabewert

Methoden können einen Wert zurückgeben. Hier ist ein Beispiel:

```java
int addiere(int a, int b) {
int summe = a + b;
return summe;
}
```

In diesem Fall gibt die Methode `addiere` die Summe der beiden übergebenen Zahlen als `int` zurück.

### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=qQ79aq7HZ-U).


![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 5](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-5---methoden) in den Labs.