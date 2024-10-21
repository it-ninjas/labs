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
* Ich kann Methoden gezielt in meinem Programm einsetzen.




## Was sind Methoden?
In Java sind Methoden Blöcke von Code, die spezifische Aufgaben ausführen. Sie dienen zur Organisation und 
Wiederverwendung von Code. Methoden ermöglichen es, eine Gruppe von Anweisungen in einem eigenen Codeblock zu kapseln
und diesen Codeblock durch einen Methodenaufruf auszuführen.

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

## Wieso brauche ich Methoden?

Methoden bieten mehrere Vorteile, die deinen Code übersichtlicher und effizienter machen:

- **Wiederverwendbarkeit**: Anstatt denselben Code mehrfach zu schreiben, kannst du ihn in einer Methode bündeln und diese Methode mehrmals aufrufen.
- **Weniger Code-Duplikate**: Durch das Verwenden von Methoden reduzierst du Duplikate im Code, was diesen leichter wartbar und fehlerresistenter macht.
- **Sprechende Methodennamen**: Methoden können selbsterklärende Namen haben, was den Code für andere (und dich selbst) verständlicher macht.
- **Logische Trennung**: Methoden helfen dabei, den Code in logische Abschnitte zu unterteilen, sodass jede Methode eine spezifische Aufgabe übernimmt.

### Beispiel: Division ohne Methoden
Stell dir vor, du möchtest mehrere Zahlen dividieren und dabei vor jeder Division prüfen, ob der Divisor `0` ist. Ohne Methoden sieht der Code vielleicht so aus:

```java
public static void main(String[] args) {
    Random random = new Random();
    
    int a = random.nextInt(11); // eine zufällige Zahl zwischen 0 und 10
    int b = random.nextInt(11);
    int c = random.nextInt(11);
    
    //Vor jeder Rechnung muss überprüft werden, ob der Divisor 0 ist
    if (b != 0) {                   //ist b == 0?
        int ergebnis1 = a / b;
        if (c != 0) {               //ist c == 0?
            int ergebnis2 = ergebnis1 / c;
            System.out.println("Ergebnis: " + ergebnis2);
        } else {
            System.out.println("Division durch 0 nicht erlaubt.");  //falls c == 0 ist
        }
    } else {
        System.out.println("Division durch 0 nicht erlaubt.");      //falls b == 0 ist
    }
}
```

Wie du hier sehen kannst, ist der Code schwierig zu lesen, da die Divisionen verstreut sind. Im Code muss man den Check auf `0` mehrmals definieren. 
Ebenfalls muss die gleiche Fehlermeldung mehrmals definiert werden. Möchtest du eine weitere Division durchführen, musst du den Check und die Fehlermeldung noch mal schreiben.
Das kannst du dir alles durch eine Methode ersparen.

### Beispiel: Division mit Methoden

Wenn du eine Methode erstellst, um die Division durchzuführen und die Prüfung auf `0` zu gruppieren, sieht der Code wesentlich sauberer aus:

```java
public static void main(String[] args) {
    Random random = new Random();

    int a = random.nextInt(11); // eine zufällige Zahl zwischen 0 und 10
    int b = random.nextInt(11);
    int c = random.nextInt(11);

    int ergebnis1 = divide(a, b);
    int ergebnis2 = divide(ergebnis1, c);

    System.out.println("Ergebnis: " + ergebnis2);
}

public int divide(int numerator, int denominator) {
    if (denominator == 0) {
        System.out.println("Division durch 0 nicht erlaubt.");
        return 0;
    }
    return numerator / denominator;
}
```

Durch die Verwendung einer Methode sparst du nicht nur Codezeilen, sondern stellst auch sicher, dass du die Prüfung auf `0` nur einmal schreibst und sie dennoch überall angewendet wird, wo es nötig ist.
Das Gleiche gilt für die Fehlermeldung. Du kannst diese Methode so oft wie du willst für andere Zahlen aufrufen.
Für den Leser ist auch klar, was in diesem Code passiert, da es einen sprechenden Namen (`divide`) hat.


### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=qQ79aq7HZ-U).


![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 5](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-5---methoden) in den Labs.