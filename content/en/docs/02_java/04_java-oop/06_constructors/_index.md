---
title: "Konstruktoren"
linkTitle: "Konstruktoren"
weight: 6
description: >
  Modul #J2
---

## Ziele

- Ich kann die zwei Hauptunterschiede von einem Konstruktor und einer gewöhnlichen Methode nennen.
- Ich kann in eigenen Worten erklären, was ein Konstruktor ist und wozu er verwendet wird.
- Ich kann in eigenen Worten erklären, was ein Default-Konstruktor ist, wann er erzeugt wird und wann er entfällt.
- Ich demonstriere die Anwendung von Konstruktoren anhand eines Beispiels ohne Hilfsmittel.

## Konstruktoren

Konstruktoren sind spezielle Methoden, die benutzt werden, sobald ein neues Objekt einer Klasse erstellt wird. Ein Konstruktor einer Klasse wird aufgerufen, wenn eine neue Instanz mit dem Schlüsselwort `new` erstellt wird.
Ein Konstruktor unterscheidet sich von anderen Methoden darin, dass:

- er den gleichen Namen haben muss wie die Klasse, die ihn enthält
- er keinen Rückgabetyp (nicht einmal void) hat

Konstruktoren initialisieren Instanzen (Objekte) der Klasse. Sie können beliebige Parameter enthalten, um beispielsweise Instanzvariablen zu initialisieren.

### Konstruktoren verwenden

Im folgenden Beispiel benutzen wir eine Klasse mit dem Namen `Patient`. Ein Objekt der Klasse hat einen Namen, ein Alter und eine Grösse. Die Klasse verfügt über einen Konstruktor mit drei Parametern, um ein neues Objekt mit bestimmten Werten zu initialisieren.

```java
public class Patient {
    private String name;
	private int age;
    private float height;

    public Patient(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
```

Der Konstruktor akzeptiert drei Parameter. Zum Initialisieren der Felder wird das Schlüsselwort `this` verwendet. Es ist ein Verweis auf die aktuelle Instanz der Klasse. Dieses Schlüsselwort ist nur erforderlich, wenn die Parameter des Konstruktors denselben Namen wie die Felder der Klasse haben (um sie voneinander unterscheiden zu können). Es ist aber allgemein Best Practices das Schlüsselwort `this` zu verwenden.

Nun erstellen wir einige Objekte der Klasse `Patient`:

```java
Patient heinrich = new Patient("Heinrich", 40, 182.0f);
Patient mary = new Patient("Mary", 33, 171.5f);
```

Jetzt haben wir zwei Objekte der Klasse `Patient`. Die beiden Referenzen `heinrich` und `mary` besitzen im Objekt die gleichen Felder, aber die Werte dieser Felder sind pro Objekt unterschiedlich.

Eine Klasse kann mehrere Konstruktoren enthalten, solange sich die Deklarationen der Konstruktoren unterscheiden. Zum Beispiel unterschiedliche Anzahl an Argumenten oder unterschiedliche Datentypen der Argumente.

### Default Konstruktor

Der Compiler stellt automatisch einen Standardkonstruktor ohne Argumente für jede Klasse ohne Konstruktor bereit (das heisst, wir können auch Objekte einer Klasse erstellen, deren Klassenkörper leer ist).

```java
public class Patient {
    private String name;
    private int age;
    private float height;
}
```

Wir können eine Instanz der Klasse Patient mit dem Standardkonstruktor ohne Argumente erstellen:

```java
Patient patient = new Patient();
```

In diesem Fall werden alle Felder mit den Standardwerten ihrer Typen befüllt (z.B: für ein `int` wird `0` als Standardwert definiert).
Wenn wir einen bestimmten Konstruktor definieren, wird der Standardkonstruktor nicht mehr automatisch erstellt.
Wir können einen Konstruktor auch ohne Argumente definieren, und damit eigene Standardwerte für Felder einer Klasse festlegen (der Standartwert für `String` ist `null`). Zum Beispiel können wir das Feld `name` mit `"Unknown"` initialisieren. Durch eine solche Definition wird der Default-Konstruktor ersetzt.

```java
public class Patient {
    private String name;
    private int age;
    private float height;

    public Patient() {
        // Hier wird nur einen Wert für `name` gesetzt, die andere Felder erhalten den Standardwert für ihre respektiven Datentypen.
        this.name = "Unknown";
    }
}
```

### Überladen von Konstruktor

Das Überladen von Konstruktoren bedeutet, dass eine Java-Klasse mehrere Konstruktoren hat, welche sich in der Anzahl der Parameter unterscheiden. Das folgende Beispiel veranschaulicht wie das aussehen könnte:

```java
public class Person {
    private String name;
    private int age;

    // Konstruktor ohne Parameter
    public Person() {
        this("Unknown", 0);  // Ruft den 2-Parameter-Konstruktor mit Standardwerten auf
    }

    // Konstruktor mit 2 Parametern
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Konstruktor mit nur einem Parameter (name)
    public Person(String name) {
        this(name, 0);  // Ruft den 2-Parameter-Konstruktor auf, setzt age auf 0
    }

    // Konstruktor mit nur einem Parameter (age)
    public Person(int age) {
        this("Unknown", age);  // Ruft den 2-Parameter-Konstruktor auf, setzt name auf "Unknown"
    }
}

```

Im Beispiel fällt auf, dass die Konstruktoren jeweils `this()` aufrufen. Mit `this()` kann man in Java aus einem Konstuktor einen Aufruf auf einen anderern Konstruktor innerhalb derselben Klasse machen. Im Beispiel wird dies verwendet, um die Logik nur in einem Konstruktor definieren zu müssen.

### Zusammenfassung

- Jede Java-Klasse verfügt über mindestens einen Konstruktor zum Initialisieren von Objekten.
- Ein Konstruktor hat denselben Namen wie die Klasse, die ihn enthält.
- Ein Konstruktor hat keinen Rückgabewert.
- Wenn eine Klasse keine expliziten Konstruktoren hat, stellt der Java-Compiler automatisch einen Standardkonstruktor ohne Argumente bereit.
- Wird ein eigener Konstruktor definiert, so entfällt der Standardkonstruktor.

---
