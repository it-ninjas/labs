---
title: "Statische und nicht-statische Elemente"
linkTitle: "Static / Non-Static"
weight: 10
description: >
  Modul #J2
---


## Ziele
* Ich kenne den Unterschied zwischen statischen und nicht statischen Elementen.
* Ich weiss, wann ich das Schlüsselwort static verwenden sollte und wann nicht.
* Ich kenne den Zugriff auf statische und nicht statische Elemente.
* Ich weiss, was eine statische Methode ist und kann sie aufrufen.
* Ich weiss, was eine Utility-Klasse ist und kenne deren wichtigste Bestandteile.
* Ich verstehe den Unterschied zwischen Methoden mit und ohne Rückgabewert.
* Ich kann eine Methodensignatur für Methoden mit und ohne Rückgabewert richtig schreiben.
* Ich kann Methoden schreiben, die Parameter entgegennehmen.

## Static / Non-Static
Statische Elemente (Variablen und Methoden) existieren innerhalb des Java-Ökosystems pro Klasse nur einmal.
Es spielt also keine Rolle wie viele Objekte einer Klasse erzeugt werden, eine statische Variable bleibt über alle Instanzen stets gleich.

Das folgende Beispiel soll dies zeigen:
```java
public class Student {
    public static int numberOfStudents = 0;

    private String name;

    public Student(String name) {
        this.name = name;
        numberOfStudents++;
    }
    
    public String getName() {
        return this.name;
    }
}
```

Die Variable `numberOfStudents` gibt es in Bezug auf die Klasse Student nur einmal. Der Zugriff erfolgt über den Namen der Klasse.
```java
public class Main {
    public static void main(String[] args) {
        Student maria = new Student("Maria");
        System.out.println(Student.numberOfStudents); // output will be 1

        Student rick = new Student("Rick");
        System.out.println(Student.numberOfStudents); // output will be 2
    }
}
```

Will man hingegen den Namen von einem Studenten holen, so erfolgt der Zugriff über die Instanz des entsprechenden Objektes:
```java
public class Main {
    public static void main(String[] args) {
        Student maria = new Student("Maria");
        System.out.println(maria.getName()); // output will be "Maria"

        Student rick = new Student("Rick");
        System.out.println(rick.getName()); // output will be "Rick"
    }
}
```

Die Verwendung des Schlüsselworts `this` ist in einem statischen Kontext nicht möglich, da dieser ja wie erwähnt keine Referenzen verwendet.


### Statische Methoden
Mittlerweile hast du bereits einige statische Methoden kennengelernt, wie zum Beispiel die Main-Methode oder die Methode println() der Klasse System oder die Methode valueOf() der String-Klasse.
Hier wollen wir uns nun genauer anschauen, was statische Methoden sind, denn diese wirst du unter anderem für das Lösen der Übungen benötigen.
Das Keyword _static_ ist ein sehr nützliches Werkzeug in Java. Bei statischen Methoden sind einige wichtige Punkte zu beachten.
* Diese Methoden gehören nicht zu einer Referenz von einem bestimmten Objekt
* Diese Methoden werden über den Klassennamen aufgerufen und nicht über eine Referenz von einem bestimmten Objekt

Wenn also in einem Methodenkopf das Keyword _static_ steht, dann weisst du, dass es sich um eine statische Methode handeln muss.
Schauen wir uns unterschiedliche Methodendeklarationen an (folgendes gilt für statische Methoden wie auch für nicht-statische Methoden):
Wenn eine Methode einen Wert an ihren Aufrufer zurückgeben soll, sprechen wir von einer Methode mit einem _Rückgabewert_:

```java
public static returnType methodName() {
    return returnValue; // der Typ des Rückgabewerts muss vom Typ sein, welcher im Methodenkopf steht
}
```
Wir sehen, dass in der Methodendeklaration angeben werden muss, welcher Typ zurückgegeben wird.

Wenn eine Methode keinen Wert zurückgeben soll, verwenden wir das Keyword _void_:
```java
public static void methodName() {
    
}
```
Das Keyword _return_ ist in Methoden ohne Rückgabewert weiterhin zulässig um die Methode zu verlassen. Die Angabe eines Rückgabewerts entfällt in diesem Fall.

Wir können auch Werte einer Methode übergeben – hierbei sprechen wir von _Parametern_.
```java
public static void methodName(type identifier) {
    
}
```
Ein Parameter besteht immer aus dem Datentyp und einem Bezeichner. Wir können beliebig viele Parameter an eine Methode übergeben. Gemäss den SBB Code Conventions (Regeln für den Programmcode) sollte eine Methode nicht mehr als acht Parameter haben.

#### Regeln
* Die Reihenfolge der Schlüsselwörter im Methodenkopf darf nicht verändert werden
* Bei der Auswahl des Methodennamens müssen die gleichen Regeln wie bei der Benennung einer Variablen eingehalten werden
* Keine doppelten Methoden: Jede Methodensignatur darf in einer Klasse nur einmal vorkommen

#### Aufruf
Innerhalb der gleichen Klasse
```
methodName();
```
Ausserhalb:
```
ClassName.methodName();
```

### Utility-Klassen
Eine Klasse, welche ausschliesslich statische Elemente besitzt, nennt man Utility-Klasse. Ein gutes Beispiel dafür ist die Klasse `Math`.
Eine solche Klasse sollte einen privaten Konstruktor aufweisen, da es keinen Sinn macht von ihr eine Referenz zu erstellen.
Zudem sollte die Klasse als `final` deklariert werden, da eine Vererbung aufgrund des statischen Kontextes ebenfalls keinen Sinn ergibt.

```java
public final class SpeedConverter {

    private SpeedConverter() {
        // Utility class
    }

    public static double toMilesPerHour(double kmh) {
        return kmh * 0.621;
    }
    
    public static double toKilometersPerHour(double mph) {
        return mph * 1.609;
    }
}
```

---
![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [NinjaCups](../../../../labs/java/java-oop/07_ninjacups) in den Labs.