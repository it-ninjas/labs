---
title: "Konstruktoren"
linkTitle: "Konstruktoren"
weight: 5
description: >
  Modul #J2
---

## Ziele
* Ich weiss, was ein Konstruktor ist.

## Konstruktoren
Konstruktoren sind spezielle Methoden, die benutzt werden sobald ein neues Objekt einer Klasse erstellt wird. Ein Konstruktor einer Klasse wird aufgerufen, wenn eine neue Instanz mit dem Schlüsselwort _new_ erstellt wird.
Ein Konstruktor unterscheidet sich von anderen Methoden darin, dass:
* er den gleichen Namen haben muss wie die Klasse, die ihn enthält
* er keinen Rückgabetyp (nicht einmal void) hat

Konstruktoren initialisieren Instanzen (Objekte) der Klasse. Sie können beliebige Parameter enthalten, um beispielsweise Instanzvariablen zu initialisieren.

### Konstruktoren verwenden
Im folgenden Beispiel benutzen wir eine Klasse mit dem Namen _Patient_. Ein Objekt der Klasse hat einen Namen, ein Alter und eine Grösse. Die Klasse verfügt über einen Konstruktor mit drei Parametern, um ein neues Objekt mit bestimmten Werten zu initialisieren.
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
Der Konstruktor akzeptiert drei Parameter. Zum Initialisieren der Felder wird das Schlüsselwort _this_ verwendet. Es ist ein Verweis auf die aktuelle Instanz der Klasse. Dieses Schlüsselwort ist nur erforderlich, wenn die Parameter des Konstruktors denselben Namen wie die Felder der Klasse haben (um sie voneinander unterscheiden zu können). Es ist aber allgemein Best Practices das Schlüsselwort _this_ zu verwenden.
Nun erstellen wir einige Objekte der Klasse Patient:
```java
Patient heinrich = new Patient("Heinrich", 40, 182.0f);
Patient mary = new Patient("Mary", 33, 171.5f);
```
Jetzt haben wir zwei Objekte der Klasse _Patient_. Die beiden Referenzen _heinrich_ und _mary_ besitzen im Objekt die gleichen Felder, aber die Werte dieser Felder sind pro Objekt unterschiedlich.

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
Wir können eine Instanz der Klasse Patient mit dem Standardkonstruktor ohne Argumente erstellen.
```java
Patient patient = new Patient();
```
In diesem Fall werden alle Felder mit den Standardwerten ihrer Typen gefüllt.
Wenn wir einen bestimmten Konstruktor definieren, wird der Standardkonstruktor nicht mehr automatisch erstellt.
Wir können einen Konstruktor auch ohne Argumente definieren, aber damit Standardwerte für Felder einer Klasse festlegen. Zum Beispiel können wir das Feld _name_ mit "Unknown" initialisieren. Durch eine solche Definition wird der Default-Konstruktor ersetzt.
```java
public class Patient {
    private String name;
    private int age;
    private float height;

    public Patient() {
        this.name = "Unknown";
    }
}
```

### Zusammenfassung
* Jede Java-Klasse verfügt über mindestens einen Konstruktor zum Initialisieren von Objekten
* Ein Konstruktor hat denselben Namen wie die Klasse, die ihn enthält
* Ein Konstruktor hat keinen Rückgabewert
* Wenn eine Klasse keine expliziten Konstruktoren hat, stellt der Java-Compiler automatisch einen Standardkonstruktor ohne Argumente bereit
* Wird ein eigener Konstruktor definiert, so entfällt der Standardkonstruktor

---
