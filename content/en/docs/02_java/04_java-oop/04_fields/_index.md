---
title: "Felder"
linkTitle: "Felder"
weight: 4
description: >
  Modul #J2
---

## Ziele

- Ich kann ohne Hilfsmittel die 3 verschiedenen Arten von Variablen auflisten (in welchem Kontext werden die Variablen wie genannt?).
- Ich schreibe eine Definition eines statische Feldes selbstständig und korrekt.
- Ich kann in eigenen Worten erklären, wozu statische Felder benutzt werden.
- Ich kann in eigenen Worten den Unterschied zwischen statischen und nicht-statischen Feldern erklären.

## Felder

Wir haben bereits verschiedene Arten von Variablen kennengelernt:

- Variablen in einer Methode oder einem Codeblock - diese werden als _lokale Variablen_ bezeichnet
- Variablen in Methodendeklarationen oder Konstruktoren - diese werden als _Parameter_ bezeichnet
- Mitgliedsvariablen (member variables) in einer Klasse - diese werden als _Felder_ oder _Instanzvariablen_ bezeichnet

Wir werden uns nun den Feldern widmen. Felder sind Variablen, die innerhalb einer Klasse, aber ausserhalb aller Methoden deklariert werden. Wir definieren sie üblicherweise am Anfang einer Klasse (vor den Methoden).
Es gibt zwei verschiedene Typen von Feldern, statische und nicht-statische.

### Statische Felder - Klassenvariablen / Konstanten

Manchmal brauchen wir eine Variable, die allen Objekten einer Klasse gemeinsam ist. Dann verwenden wir eine Variable, die mit dem Schlüsselwort `static` deklariert ist. Diese Variable bezeichnen wir als statisches Feld oder Klassenvariable. Ein statisches Feld ist der Klasse selbst zugeordnet und nicht den Instanzen (=Objekten) dieser Klasse. Denn jede Instanz (= jedes Objekt) der Klasse teilt sich diese Klassenvariable, die sich an einem festen Ort im Speicher befindet. Egal wie viele Objekte dieser Klasse existieren, der Wert des statischen Feldes ist für alle exakt gleich. Jedes Objekt kann den Wert einer Klassenvariablen lesen und verändern.

```java
public class Counter {
	private static int count = 0;

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.count++; // Erhöhen der Klassenvariable count über ein Objekt
        System.out.println(count); // Output: 1
        Counter.count++; // Erhöhen des statischen Feldes count über den Klassennamen (ohne Objekt!)
        System.out.println(count); // Output: 2
    }
}
```

Angenommen, wir möchten eine Reihe von Bicycle-Objekten erstellen und jedem eine Seriennummer zuweisen, beginnend mit 1 für das erste Objekt. Diese ID-Nummer ist für jedes Objekt eindeutig und daher eine Instanzvariable (was Instanzvariablen sind, dazu kommen wir gleich). Um das zu realisieren, benötigen wir eine Variable, die die Anzahl Fahrräder (Anzahl erzeugter Bicycle-Instanzen) zählt. Vorsicht, diese Art von Implementation ist für mehrere Threads nicht geeignet. Da wir noch nichts von Multithreading wissen, genügt es zu wissen, dass diese Art der Implementation nicht thread-sicher ist (Man spricht von Multithreading bei einem Programm, wenn es mehrere Dinge gleichzeitig parallel ausführt, je nach dem sogar auf mehreren Prozessoren gleichzeitig).

```java
public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;
    private int id;

    private static int numberOfBicycles = 0; // Klassenvariable, die zählt, wieviele Objekte erzeugt werden

    // Diese spezielle Methode, Konstruktor genannt, wird benötigt, um Objekte zu instanzieren --> siehe Kapitel Konstruktoren
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        this.gear = startGear;          // (aktueller Gang)
        this.cadence = startCadence;    // (Umdrehungen / min bei den Pedalen)
        this.speed = startSpeed;        // (km/h)
        this.id = ++numberOfBicycles;   // inkrementiere die Anzahl Fahrräder und weise den Wert der Instanzvariablen id zu
    }
}
```

Manchmal verwenden wir statische Felder, um Konstanten zu definieren. Eine _Konstante_ ist eine Variable, deren Wert nicht mehr verändert werden kann, sobald man ihr einmal einen Wert zugewiesen hat. Um eine Variable als Konstante zu kennzeichnen, verwenden wir zusätzlich das Keyword `final`. Der Name der Konstante wird zudem per Konvention immer in Grossbuchstaben geschrieben. Um mehrere Wörter abzutrennen verwenden wir Underscores `_`.
Zum Beispiel definiert die folgende Variablendeklaration eine Konstante mit dem Namen PI:

```java
static final double PI = 3.141592653589793;
```

### Nicht-statische Felder - Instanzvariablen

Unter einer Instanzvariablen versteht man eine Variable, die einer Instanz einer Klasse, also einem Objekt, zugeordnet ist. Wenn eine neue Instanz erzeugt wird, werden Kopien der Instanzvariablen angelegt. Im Fall der Bicycle-Klasse sind die Instanzvariablen `cadence`, `gear`, `speed` und `id`. Jedes Bicycle-Objekt hat seine eigenen Werte für diese Variablen, d.h. sie werden an unterschiedlichen Orten gespeichert.

---
