---
title: "Objektorientierte Programmierung"
linkTitle: "Objektorientierte Programmierung"
weight: 4
description: >
  Modul #J2 - OOP
---

#### Ziele
* Ich verstehe, wie eine Klasse aufgebaut ist
* Ich verstehe den Unterschied zwischen einer Klasse und einem Objekt
* Ich weiss, was Datenfelder sind und verstehe den Unterschied zwischen statischen und nicht-statischen Feldern
* Ich weiss, was ein Konstruktor ist
* Ich kann Objekte instanziieren (erzeugen)
* Ich kann Getter- und Setter-Methoden schreiben
* Ich kenne die Zugriffsmodifikatoren 'public', 'private' und 'protected'
* Ich weiss, dass Instanzvariablen immer mit dem Schlüsselwort 'private' deklariert werden
* Ich kenne die Methoden equals() und hashCode() und weiss unter welchen Umständen und wie ich diese überschreiben soll
* Ich weiss was ein Enum ist und wann es benötigt wird
* Ich kann Enums sinnvoll einsetzen
* Ich kann Methoden und Konstruktoren in Enums anwenden

---

## Einführung
In der realen Welt können wir viele Objekte um uns herum finden, wie Autos, Gebäude und Menschen. Alle diese Objekte haben einen bestimmten Zustand und ein bestimmtes Verhalten. Wenn wir ein Auto betrachten so könnte sein Zustand einen Markennamen, eine bestimmte Geschwindigkeit oder den zu tankenden Kraftstoff enthalten. Mögliche Verhaltensweisen eines Autos sind normalerweise fahren und einparken.

### Definitionen
#### Klasse
Unter einer Klasse versteht man in der objektorientierten Programmierung ein abstraktes Modell bzw. einen Bauplan für eine Reihe von ähnlichen Objekten. Die Klasse dient als Bauplan für die Abbildung von realen Objekten in Softwareobjekte und beschreibt Attribute (Eigenschaften) und Methoden (Verhaltensweisen) der Objekte.

#### Objekt
Ein Objekt bezeichnet in der objektorientierten Programmierung ein Exemplar eines bestimmten Datentyps oder einer bestimmter Klasse. Objekte sind konkrete Ausprägungen (=Instanzen) einer Klasse und werden zur Laufzeit erzeugt (Instanziierung).

#### Datenfelder
Datenfelder (Attribute) enthalten Informationen, die für Objekte dieser Klasse relevant sind. Ein Auto hat eine Höchstgeschwindigkeit, eine bestimmte Anzahl von Sitzen, usw. Das heisst, ein Feld ist eine Variable, in der Daten gespeichert werden können. Es kann einen beliebigen Typ haben, einschliesslich primitiver Typen (int, float, boolean usw.) und Klassen. Eine Klasse kann auch sich selber als Feld enthalten. Eine Klasse kann beliebig viele Felder haben

#### Methoden
Methoden dienen dazu, den Zustand eines Objekts zu verändern. Refuel() (siehe Klassendiagramm unten) füllt beispielsweise den Tank, bis dessen Kapazität erreicht wird.
Klassen werden verwendet, um benutzerdefinierte Datentypen zu erstellen. Beginnen wir mit einem Beispiel einer Auto-Klasse, hier siehst du das UML-Klassendiagramm der Klasse Car:

| class Car              | 
|------------------------|
| - topSpeed: int        |
| - totalSeats: int      |
| - fuelCapacity: int    |
| - manufacturer: String |
| + refuel(): void       |
| + park(): void         |
| + drive(): void        |

---

## Klassen und Objekte im Schnelldurchlauf

### Klassen deklarieren
Klassenkopf: Eine neue Klasse wird mit dem Keyword _class_ gefolgt vom Namen der Klasse deklariert.
So kannst du beispielsweise eine Klasse mit dem Namen _Nothing_ erstellen:
```java
public class Nothing {
    
}
```

Der Block kann Felder, Methoden und Konstruktoren enthalten. Felder speichern Daten, Methoden definieren das Verhalten und Konstruktoren ermöglichen es uns, neue Objekte der Klasse zu erstellen und zu initialisieren. Felder und Methoden gelten als Klassenmitglieder (_class members_).

Der Quellcode einer Klasse wird in eine .java-Datei eingefügt. Normalerweise enthält eine Quellcodedatei nur eine Klasse und hat denselben Namen wie diese Klasse. Manchmal kann eine Datei jedoch auch mehrere Klassen enthalten, jedoch darf es nur eine öffentliche (public) Klasse pro Datei geben. Deren Name muss mit dem Dateinamen übereinstimmen.

Patient.java
```java
public class Patient {
    String name;         // Feld bzw. Instanzvariable vom Datentyp String mit dem Bezeichner 'name'
    int age;             // Feld bzw. Instanzvariable vom Datentyp int mit dem Bezeichner 'age'
    float size;          // Feld bzw. Instanzvariable vom Datentyp float mit dem Bezeichner 'size'
    String[] complaints; // ein Feld kann auch ein Array sein
}
```
Diese Klasse repräsentiert einen Patienten in einem Krankenhausinformationssystem. Sie verfügt über vier Felder: _name, age, size_ und _complaints_. Alle Objekte der Klasse Patient haben dieselben Felder, aber ihre Werte können für jedes Objekt unterschiedlich sein.

### Objekte erstellen
Wir können eine Instanz der Klasse Patient mit dem Operator _new_ erstellen:
```java
Patient patient = new Patient();
```
Wenn du ein neues Objekt erstellst, wird jedes Feld mit dem Standardwert des entsprechenden Typs initialisiert (insofern du keinen Konstruktor mit Argumenten verwendest, dazu aber später mehr). Wenn die Instanzvariablen eines Objektes nicht mit einem Zugriffsmodifikator wie _private_ versehen sind (dazu unten mehr), können wir mittels Punkt-Operator auf die Variablen des Objekts zugreifen:
```java
System.out.println(patient.name); // es wird null ausgeben
System.out.println(patient.age);  // es wird 0 ausgeben
```
Das folgende Programm erstellt zwei Objekte der Klasse Patient und druckt die Informationen der Objekte aus.

**PatientDemo.java**
```java
public class PatientDemo {

    public static void main(String[] args) {
        // Wir erstellen einen neuen Patienten, alle Variablen werden mit ihren Standardwerten initialisiert
        Patient john = new Patient();
        // Wir greifen über den Punkt-Operator auf die Variablen zu und speichern Werte darin
        john.name = "John";
        john.age = 30;
        john.size = 180f;
        System.out.println(john.name + " " + john.age + " " + john.height);

        Patient alice = new Patient();
        alice.name = "Alice";
        alice.age = 22;
        alice.height = 165f;
        System.out.println(alice.name + " " + alice.age + " " + alice.height);
    }
}
```
**Patient.java**
```java
class Patient {
    String name;
    int age;
    float size;
}
```
Im obigen Code haben wir zwei Patienten erstellt, John und Alice, die Werte ihrer Felder definiert und dann die Informationen über sie ausgedruckt. Wir sehen, dass wir mit dem Punkt-Operator auf die Felder des Objekts zugreifen können (john.name = "John"). Allerdings soll hier erwähnt sein, dass das nur geht, wenn die Instanzvariablen nicht private sind (wir behandeln das Thema Zugriffsmodifikatoren weiter unten).

### Veränderungen an Objekten - Immutable & mutable objects
In der Programmierung gibt es ein wichtiges Konzept, das Unveränderlichkeit genannt wird. Unveränderlichkeit bedeutet, dass ein Objekt immer dieselben Werte speichert. Wenn wir diese Werte ändern wollen, müssen wir ein neues Objekt erstellen. Das klassische Beispiel ist die Klasse _String_. Zeichenfolgen sind unveränderliche Objekte, sodass alle String-Operationen einen neuen String erzeugen.
```java
String alice = "alice";
alice.toUpperCase();
System.out.println(alice); // Output: alice --> unveränderlich!
String aliceCapitalLetters = alice.toUpperCase();
System.out.println(aliceCapitalLetters); // Output: ALICE
```
Die Klasse Patient ist nicht unveränderlich, da jedes Feld eines Objekts geändert werden kann.
```java
Patient patient = new Patient();
patient.name = "Mary";
patient.name = "Alice";
```

### Referenzen teilen
Objekte sind Referenztypen. In einer Variable wird also nicht das Objekt selbst, sondern die Speicheradresse hinterlegt, welche auf das Objekt zeigt. Es können sich also mehrere Referenzen auf dasselbe Objekt beziehen.
```java
Patient patient = new Patient();
patient.name = "Mary";
patient.age = 24;
System.out.println(patient.name + " " + patient.age); // Mary 24

// Wir weisen der Variablen patient2 die Speicheradresse der Variablen patient zu
Patient patient2 = patient;
System.out.println(patient2.name + " " + patient2.age); // Mary 24
```
Es ist wichtig zu verstehen, dass sich die zwei Referenzen oben auf das gleiche Objekt im Speicher beziehen und nicht auf zwei unabhängige Kopien. Da unsere Klasse veränderbar ist, können wir das Objekt mit Hilfe beider Referenzen ändern.
```java
patient.age = 25;
System.out.println(patient2.age); // 25
```

---

## Packages
Bevor wir uns intensiver mit den Bestandteilen einer Klasse auseinandersetzen, schauen wir uns Packages an.
Ein Package dient der Gruppierung und Organisation von Klassen, Schnittstellen und anderen Packages.
Es wird zwischen zwei Arten von Packages unterschieden:
* implizit importierte Packages
* explizit zu importierende Packages

Wenn wir beispielsweise die Klasse Scanner benötigen, müssen wir dies durch ein _import_ Statement machen.
```java
import java.util.Scanner
```
Die Klasse Scanner befindet sich also im Package _java_ und darin im Package _util_.
Ein Package kann beliebig viele andere Packages enthalten. Ein Package wird auf dem Dateisystem als Verzeichnis behandelt.

### Vorteile
* Code-Organisation. Klassen von gleicher Natur (wie beispielsweise Modelle oder Services) befinden sich im gleichen Package
* Auffindbarkeit. Klassen sind durch die Organisation einfacher zu finden
* Vermeiden von Namenskonflikten. Zwei Klassen dürfen den gleichen Namen haben, solange sie in unterschiedlichen Packages liegen
* Zugriffsteuerung. Bestimmte Zugriffsmodifikatoren erlauben den Zugriff auf Klassen im gleichen Package

### Namenskonventionen
Gemäss der Namenskonvention werden Package-Namen immer in Kleinbuchstaben geschrieben.
Die Trennung der verschiedenen Packages erfolgt beim Import-Statement durch einen Punkt.

### Ordnerstruktur
Programmcode muss organisiert sein. Grundsätzlich legen wir Quellcode im einem Verzeichnis ab, das _src_ genannt wird.
Innerhalb dieses Verzeichnisses legen wir ein Verzeichnis _main_ und ein Verzeichnis _java_ an. Innerhalb des Java-Verzeichnisses können wir beliebig viele eigene Packages anlegen, um unseren Programmcode zu organisieren.

### Klassen mit gleichem Namen
Es kann passieren, dass wir zwei Klassen haben, die den gleichen Namen haben. Beispiel: Wir arbeiten mit der externen Bibliothek Abstract Window Toolkit (AWT). Darin gibt es eine Klasse mit dem Namen _Rectangle_. Es ist natürlich erlaubt eine eigene Klasse mit diesem Namen anzulegen, solang sie sich nicht in einem Package mit dem gleichen Namen befindet.
```java
package ch.sbb.main;

import ch.sbb.rectangle.Rectangle;

public class Main {
    public static void main(String[] args) {
        java.awt.Rectangle rectAWT = new java.awt.Rectangle()
        // ...
        Rectangle myRect = new Rectangle();
        // ...
    }
}
```
* Wir importieren die eigene Rectangle-Klasse mit der Import-Anweisung
* Wir deklarieren und initialisieren ein AWT-Rectangle, indem wir den vollständigen Namen (Package und Klassennamen) angeben

### Import *
Wenn sich zwei Klassen im selben Paket befinden und eine Klasse in der anderen verwendet wird, muss die Klasse nicht importiert werden.
Es ist auch möglich, alle Klassen aus dem Paket zu importieren. Dazu müssen wir einen * anstelle eines bestimmten Klassennamens in das Import-Statement schreiben.
```java
import java.awt.*;
```

### Package java.lang
Obwohl wir die meisten Pakete importieren müssen, gibt es ein Java-Paket, das immer automatisch importiert wird. Es ist java.lang. Dieses Paket enthält viele weit verbreitete Klassen, wie String, System, Long, Integer, NullPointerException und andere.

### Statischer Import
Wir können auch statische Elemente (Konstanten) einer Klasse in eine andere Klasse importieren. Wenn wir * in die import-Anweisung schreiben, müssen wir den importierten Klassennamen nicht angeben, bevor wir statische Methoden aufrufen oder statische Felder lesen.
Hier ist ein Beispiel für den statischen Import der Klasse Arrays, die viele nützliche Methoden zur Verarbeitung von Arrays enthält:
```java
package org.hyperskill.java.packages.theory;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 10, 4, 5, 47, 5, 12 }; // an array
        sort(numbers); // instead of writing Arrays.sort(...)
        int[] copy = copyOf(numbers, numbers.length); // instead of writing Arrays.copyOf(...)
    }
}
```
Wenn wir bei der Implementation von Klassen keine Package-Anweisung schreiben, wird die Klasse ins Default-Package eingefügt. Dies sollte vermieden werden, da Klassen aus dem Default-Package nicht in andere Klasse importiert werden können, welche sich nicht auch im Default-Package befinden.

---

## Zugriffsmodifikatoren
In Java können wir Feldern und Methoden Zugriffsbeschränkungen auferlegen. Diese Einschränkungen werden durch Zugriffsmodifikatoren festgelegt.
Zugriffsmodifikatoren bestimmen die Sichtbarkeit von Feldern und Methoden und damit deren Verwendbarkeit aus anderen Programmteilen.
Es gibt vier Zugriffsmodifikatoren.

### Private
Auf eine private Instanzvariable oder -methode kann von ausserhalb der Klasse nicht zugegriffen werden.
Es ist eine gängige Praxis, Instanzvariablen privat zu halten. Wir möchten schliesslich nicht, dass jemand unsere Daten direkt manipuliert. Dieses Prinzip nennt man auch Kapselung.
```java
class Person {
    private String name;
}
```
UML-Symbol: -

### Public
Auf Variablen und Methoden, die mit dem Schlüsselwort public deklariert sind, kann von einem beliebigen Ort des Programms zugegriffen werden.
Sie sind also öffentlich.
```java
class Person {
	private String name;

	public String getName() {
		return name;
	}
}
```
Auf öffentliche Methoden und Felder kann ein Objekt über den Punkt-Operator zugreifen.
```java
Person p = new Person();
c.getName();
```
UML-Symbol: +

### Protected
Wenn eine Variable oder Methode protected deklariert ist, dann kann nur vom gleichen Package oder von Unterklassen darauf zugegriffen werden (Unterklassen bzw. Vererbung folgt im Modul «Objektorientiertes Design»).
UML-Symbol: #

### Package-Private
Wenn eine Variable oder Methode keinen Zugriffsmodifikator hat, so besitzt sie trotzdem einen. Dieser wird Package-Private genannt. Die Sichtbarkeit ist grundsätzlich private, wird aber auf Klasse im gleichen Package ausgeweitet.

### Zusammenfassung
| Modifikator    | Eigene Klasse | Klasse im gleichen Package / innere-Klassen | Unterklassen | Sonstige Klassen |
|----------------|---------------|---------------------------------------------|--------------|------------------|
| private        | ja            | nein                                        | nein         | nein             |
| public         | ja            | ja                                          | ja           | ja               |
| protected      | ja            | ja                                          | ja           | nein             |
| ohne / package | ja            | ja                                          | nein         | nein             |

---

## Felder
Wir haben bereits verschiedene Arten von Variablen kennengelernt:
* Variablen in einer Methode oder einem Codeblock - diese werden als _lokale Variablen_ bezeichnet
* Variablen in Methodendeklarationen oder Konstruktoren - diese werden als _Parameter_ bezeichnet
* Mitgliedsvariablen (member variables) in einer Klasse - diese werden als _Felder_ oder _Instanzvariablen_ bezeichnet

Wir werden uns nun den Feldern widmen. Felder sind Variablen, die innerhalb einer Klasse, aber ausserhalb aller Methoden deklariert werden. Wir definieren sie üblicherweise am Anfang einer Klasse (vor den Methoden).
Es gibt zwei verschiedene Typen von Feldern, statische und nicht-statische.

### Statische Felder - Klassenvariablen / Konstanten
Manchmal brauchen wir eine Variable, die allen Objekten gemeinsam ist. Dann verwenden wir eine Variable, die mit Schlüsselwort _static_ deklariert ist. Diese Variable bezeichnen wir als statisches Feld oder Klassenvariable. Ein statisches Feld ist der Klasse selbst zugeordnet und nicht den Referenzen dieser Klasse. Denn jede Instanz der Klasse teilt sich diese Klassenvariable, die sich an einem festen Ort im Speicher befindet. Egal wie viele Objekte dieser Klasse existieren, der Wert des statischen Feldes ist für alle exakt gleich. Jedes Objekt kann grundsätzlich den Wert einer Klassenvariablen lese und verändern.
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
Angenommen, wir möchten eine Reihe von Bicycle-Objekten erstellen und jedem eine Seriennummer zuweisen, beginnend mit 1 für das erste Objekt. Diese ID-Nummer ist für jedes Objekt eindeutig und daher eine Instanzvariable (was Instanzvariablen sind, dazu kommen wir gleich). Um das zu realisieren, benötigen wir eine Variable, die die Anzahl Fahrräder (Anzahl erzeugter Bicycle-Instanzen) zählt. Vorsicht, diese Art von Implementation ist für mehrere Threads nicht geeignet. Da wir noch nichts von Multithreading wissen, genügt es zu wissen, dass diese Art der Implementation nicht thread-sicher ist.
```java
public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;
    private int id;

    private static int numberOfBicycles = 0; // Klassenvariable, die zählt, wieviele Objekte erzeugt werden

	// Diese spezielle Methode, Konstruktor genannt, wird benötigt, um Objekte zu instanzieren --> siehe Kapitel Konstruktoren
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        this.gear = startGear;
        this.cadence = startCadence;
        this.speed = startSpeed;
        this.id = ++numberOfBicycles;  // inkrementiere die Anzahl Fahrräder und weise den Wert der Instanzvariablen id zu
    }
}
```
Manchmal verwenden wir statische Felder, um Konstanten zu definieren. Eine _Konstante_ ist eine Variable, deren Wert nicht mehr verändert werden kann, sobald man ihr einmal einen Wert zugewiesen hat. Um eine Variable als Konstante zu kennzeichnen, verwenden wir zusätzlich das Keyword _final_. Der Name der Konstante wird zudem immer in Grossbuchstaben geschrieben. Um mehrere Wörter abzutrennen verwenden wir den Underscore (_).
Zum Beispiel definiert die folgende Variablendeklaration eine Konstante mit dem Namen PI:
```java
static final double PI = 3.141592653589793;
```

### Nicht-statische Felder - Instanzvariablen
Unter einer Instanzvariablen versteht man eine Variable, die einer Instanz einer Klasse, also einem Objekt, zugeordnet ist. Wenn eine neue Instanz erzeugt wird, werden Kopien der Instanzvariablen angelegt. Im Fall der Bicycle-Klasse sind die Instanzvariablen _cadence_, _gear_, _speed_ und _id_. Jedes Bicycle-Objekt hat seine eigenen Werte für diese Variablen, d.h. sie werden an unterschiedlichen Orten gespeichert.

---

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

## Initialisierungsblöcke
Neben Konstruktoren gibt es noch zwei weitere Konstrukte, die der Initialisierung dienen. Statische und nicht-statische Initialisierungsblöcke.
Diese sehen wie folgt aus:
```java
public class Car {

	static {
		// Statischer Initialisierungsblock
	}

	{
		// Instanzblock
	}

	public Car {
		// Konstruktor
	}
}
```
Innerhalb dieser Initialisierungblöcke können ähnlich wie bei den Konstruktoren bestimmte Initialisierungen durchgeführt werden. Grundsätzlich können die beiden Blöcke beliebigen Programmcode enthalten. Die Reihenfolge bei der Erstellung eines neuen Objekts ist wie folgt:
1.  Statische Variablen
2.  Statische Initialisierungblöcke
3.  Instanzvariablen
4.  Instanzblöcke
5.  Konstruktoren

Eine Java-Klasse kann beliebig viele statische und nicht-statische Initialisierungsblöcke aufweisen. Die Reihenfolge des Aufrufs bei mehreren Blöcken richtet sich nach der Reihenfolge der Implementation.

**Beispiele**

Nicht-statischer Initialisierungsblock:
[https://www.tutorialspoint.com/a-non-static-initialization-block-in-java](https://www.tutorialspoint.com/a-non-static-initialization-block-in-java)

Statischer Initialisierungblock:
[https://www.tutorialspoint.com/a-static-initialization-block-in-java](https://www.tutorialspoint.com/a-static-initialization-block-in-java)

---

## Instanzmethoden
Methoden werden benutzt, um Funktionen zur Verfügung zu stellen. Diese Funktionalitäten reichen von einfachen Änderungen am Zustand eines Objekts bis zu komplexen Algorithmen zur Berechnung von mathematischen Dingen. Hier passiert also die Magie in einer Applikation.
Diese Methoden können also entweder den Inhalt von Datenfelder ändern oder ihre Werte verwenden, um eine bestimmte Berechnung durchzuführen.
Der Zugriffsmodifizierer einer Methode sollte immer so restriktiv wie möglich gewählt werden.

Eine Methodendeklaration besteht aus bis zu sieben Komponenten:
1. Zugriffsmodifikator. public, protected, private oder package-private
2. Sonstige Modifikatoren. Beispielsweise static oder synchronized
2. Rückgabewert. Der Datentyp des von der Methode zurückgegebenen Werts oder _void_, wenn die Methode keinen Wert zurückgibt
3. Methodenname / Bezeichner
4. Parameterliste in Klammern. Eine durch Kommas getrennte Liste von Eingabeparametern (Datentyp + Bezeichner). Wenn keine Parameter vorhanden sind, genügt die Angabe der beiden Klammern
5. Exceptions. Dazu mehr später im Modul Exception Handling
6. Methodenkörper.

### Namenskonventionen für Methoden
* Erster Buchstabe immer klein
* CamelCase
* sollten aus einem Verb und einem Nomen zusammengesetzt werden
* Möglichst aussagekräftige Namen
* Möglichst keine Abkürzungen

### Getter und Setter
Diese beiden Arten von Methoden sind in der objektorientierten Programmierung unverzichtbar. Eine get-Methode (Getter) ruft den Wert eines bestimmten Datenfelds ab, während eine set-Methode (Setter) ihren Wert verändert. Dies dient dem Prinzip der Kapselung und kann unter anderem dazu verwendet werden, ein bestimmtes Datenfeld read-only zu gestalten (wenn es keine Setter-Methode dazu gibt).

#### Namenskonventionen
Für Getter- und Setter-Methoden werden immer die gleichen Methodennamen verwendet. Als Präfix benutzen wir _get_ und _set_ gefolgt vom Namen des Datenfelds worauf sich die Methode bezieht.
```java
public class Car {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
```
```java
class Demo {
	public static void main(String[] args) {
		Car car = new Car();
		car.setSpeed(100);
		System.out.println(car.getSpeed());
	}
}
```

### Methoden überladen
In Java können wir Methoden überladen. Das heisst, wir können mehrere Methoden mit demselben Namen definieren, solange die Anzahl an Parametern oder die Datentypen der Parameter variiert. Beim Aufruf der Methode wird vom Compiler die entsprechende Definition ausgewählt.
```java
class Calculator {

	public double product(double x, double y) {
		return x * y;
	}

    // Overloading the function to handle three arguments
	public double product(double x, double y, double z) {
		return x * y * z;
	}
    
    // Overloading the function to handle int
	public int product(int x, int y) {
		return x * y;
	}
}
```
```java
class Demo {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double x = 10;
		double y = 20;
		double z = 5
		int a = 12;
		int b = 4;
		System.out.println(cal.product(x, y));
		System.out.println(cal.product(x, y, z));
		System.out.println(cal.product(a, b));
	}
}
```

Methoden, deren Parameter gleich sind (gleiche Anzahl, gleiche Datentypen) und sich lediglich in ihren Rückgabetypen unterscheiden, können nicht überladen werden, da der Compiler nicht in der Lage ist, zwischen ihren Aufrufen zu unterscheiden.

### Die Methoden equals() und hashCode()
Die Methoden *equals()* und *hashCode()* gehören zu den grundlegenden Java APIs.
Beide Methoden gehören automatisch zur öffentlichen Schnittstelle jeder Klasse, da sie durch die implizite Ableitung von der Object-Klasse geerbt werden (mehr dazu im Teil "Objektorientiertes Design" in diesem Modul).<br>
Ob die Default-Umsetzung beider Methoden ausreicht, wird aufgrund von den fachlichen Gegebenheiten entschieden und ggf. werden **beide** Methoden überschrieben.

#### equals()
Die Methode *equals()* ermöglicht uns das aus dem fachlichen Kontext stammende Gleichheitsverständnis im Code umzusetzen.<br>
Die Default-Umsetzung der Methode in der Object-Klasse definiert, dass zwei Objekte nur dann gleich sind wenn sie die gleiche Identität haben. Das heisst, zwei unterschiedliche Instanzen (also zwei Objekte) einer Klasse sind gemäss dieser Umsetzung nicht gleich auch wenn alle Felder der beiden Objekten mit den gleichen Werte befüllt werden. 
Aufgrund der fachlichen Gegebenheiten kann diese Definition der Gleichheit nicht korrekt sein. In so einem Fall muss die Methode *equals()* überschrieben werden.

Bei der Umsetzung müssen folgende Bedingungen für die Definition der Gleichheit bei nicht-null Objekten gemäss [API-Definition für equals()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)) erfüllt werden:<br>
- **Reflexivität**: Das Objekt liefert beim Vergleich mit sich selbst true.
- **Symmetrie**: Das Resultat des Vergleichs x mit y ist gleich wie das des Vergleichs y mit x. Es ist also egal wie verglichen wird.
- **Transivität**: Wenn x gleich y ist und y gleich z, dann ist x gleich z.
- **Konsistenz**: Egal wie häufig der Vergleich durchgeführt wird, es kommt immer dasselbe heraus, sofern sich der Inhalt der Objekte nicht verändert.
- **Behandlung von null**: Der Vergleich mit null liefert immer false.

#### hashCode()
Die Methode *hashCode()* sollte für jedes Objekt einen Hashwert (Fingerabdruck) liefern, der das Objekt möglichst eindeutig identifiziert.<br>
Der berechnete Hashwert ermöglicht einen effizienten und schnellen Zugriff auf ein bestimmtes Objekt innerhalb eines Hash-basierten Containers wie z.B. einer *HashMap*.<br>
Auch für diese Methode definiert die [API-Definition für hashCode()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode()) Bedingungen, welche erfüllt werden müssen damit die Methode zweckmässig verwendet werden kann:

- **Konsistenz**: Egal wie häufig hashCode() aufgerufen wird, es kommt stets dasselbe Resultat zurück, sofern der Inhalt des Objekts nicht geändert wurde.
- **Zusammenhang equals**: Zwei Objekte, die gemäss equals() gleich sind, müssen den gleichen Hashwert liefern.
- **Zusammenhang not-equals**: Zwei Objekte die gemäss equals() verschieden sind, müssen nicht zwingend unterschiedliche Hashwerte liefern. Grundsätzlich wäre es aber besser für die Performanz, wenn verschiedene Objekte auch verschiedene Hashwerte liefern würden.

In der Regel entscheiden wir uns aufgrund von fachlichen Gegebenheiten für die Überschreibung der Methode *equals()*. Die Überschreibung von *hashCode()* resultiert daraus als Konsequenz der Bedingung "Zusammenhang equals".

## Enums
Enums (kurz für "enumeration", zu Deutsch: Aufzählung) bieten die Möglichkeit, vordefinierte Konstanten zusammen zu gruppieren.
Enums werden dann verwendet, wenn alle mögliche Werte zur Kompilierzeit bekannt sind (z.B. alle Wochentage, alle Planeten im Sonnensystem usw.).

In Java sind Aufzählungstypen als Klassen realisiert und die definierten Werte sind als Objekte implementiert. 
Daraus ergeben sich folgenden nützlichen Eigenschaften:
- Enums können Konstruktoren, Instanzvariablen und Instanz-Methoden beinhalten
- Der Name der Enum-Werte kann mithilfe der toString-Methode (oder mit dem Keywort _this_) im Klartext ausgegeben werden.
- Mithilfe des "=="-Operators kann auf Gleichheit geprüft werden.
- Enumerations können in switch-Anweisungen verwendet werden.
- Mithilfe der values-Methode wird ein Array zurückgegeben, das alle Elemente der Enumeration enthält. In Verbindung mit der erweiterten for-Schleife (for-each) können die Elemente sehr einfach durchlaufen werden.

Obwohl Java Enums als Klassen realisiert werden, müssen sie nicht mit _new_ instanziiert werden.
Im Gegensatz zu Klassen können Java-Enums weder erweitert werden noch von anderen Klassen erben.

### Enums definieren
Enums können innerhalb oder ausserhalb einer Klasse definiert werden (nicht aber innerhalb einer Methode!).
Um ein Enum zu definieren, wird das Java-Schlüsselwort _enum_ verwendet.

Die erste Zeile(n) innerhalb der Enum-Definition soll eine kommagetrennte Liste von Konstanten beinhalten (in Java per Konvention mit Grossbuchstaben geschrieben).
Danach werden allfällige Variablen, Methoden und Konstruktoren definiert.

Jede Enum-Konstante ist implizit _**public static final**_.
Weil es _static_ ist, kann über den Enum-Namen darauf zugegriffen werden.
Weil es _final_ ist, kann es nicht erweitert werden.

#### Beispiel: Definition ausserhalb einer Klasse
```java
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class DailyPlanner {
    private static void dailyMood(Weekday weekday) {
        switch (weekday) {
            case MONDAY:
                System.out.println("I don't like Mondays");
                break;
            case FRIDAY:
                System.out.println("Thank God it's Friday");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("There aren't enough days in the weekend");
                break;
            default:
                System.out.println("Some Midweek days feel like Mondays when I wish the were Fridays");
                break;
        }
    }

    public static void main(String[] args) {
        dailyMood(Weekday.MONDAY);
    }
}
```

#### Beispiel: Definition innerhalb einer Klasse
```java
public class DailyPlanner {
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        System.out.println("I like " + Weekday.SATURDAY + " and " + Weekday.SUNDAY + " the best");
    }
}
```

### Enum mit einem Konstruktor
Ein Enum-Konstruktor wird für jeder Enum-Konstante während dem Klassenladen des Enums ausgeführt.
Es ist unmöglich Enum-Objekte explizit zu erzeugen. Darum kann ein Enum-Konstruktor auch nicht direkt aufgerufen werden.

#### Beispiel: Enum mit einem Konstruktor
```java
enum Weekday {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
    
    final int dayNumber;
    Weekday() {
        System.out.println("Konstruktor für Tag " + this.toString() + " wird ausgeführt. Das ist der " + this.dayNumber+ ". Tag in der Woche");
    }
}

public class TestDays {
    public static void main(String[] args) {
        Weekday monday = Weekday.MONDAY; // Output:
                                         // Konstruktor für Tag MONDAY wird ausgeführt. Das ist der 1. Tag in der Woche
                                         // Konstruktor für Tag TUESDAY wird ausgeführt. Das ist der 2. Tag in der Woche
                                         // Konstruktor für Tag WEDNESDAY wird ausgeführt. Das ist der 3. Tag in der Woche
                                         // Konstruktor für Tag THURSDAY wird ausgeführt. Das ist der 4. Tag in der Woche
                                         // Konstruktor für Tag FRIDAY wird ausgeführt. Das ist der 5. Tag in der Woche
                                         // Konstruktor für Tag SATURDAY wird ausgeführt. Das ist der 6. Tag in der Woche
                                         // Konstruktor für Tag SUNDAY wird ausgeführt. Das ist der 7. Tag in der Woche
        System.out.println(monday); // Output: MONDAY
    }
}
```

### Enum mit Methoden
Ein Enum kann konkrete wie auch abstrakte Methoden beinhalten. Wenn ein Enum eine abstrakte Methode beinhaltet,
muss jede Instanz (also jede Konstante) dieses Enums diese Methode umsetzen (mehr Information über abstrakten Methoden findest du im Modul OOD).

#### Beispiel: Enum mit konkreten und abstrakten Methoden
```java
enum Color {
    RED {
        // Umsetzung der abstrakten Methode für die Farbe RED
        @Override
        public void colorPoem() {
            System.out.println("Roses are red");
        }
    },
    VIOLET {
        // Umsetzung der abstrakten Methode für die Farbe VIOLET
        @Override
        public void colorPoem() {
            System.out.println("Violets are blue");
        }
    };

    // Konkrete Methode, welche für alle Werte im Enum, dasselbe tut
    public void generalColorInfo(){
        System.out.println("Everyday color is a great color!");
    }

    // Abstrakte Methode, welche von jedem Wert im Enum umgesetzt werden muss
    public abstract void colorPoem();
}

public class Test {
    public static void main(String[] args) {
        Color violet = Color.VIOLET;
        violet.generalColorInfo(); // Output: Everyday color is a great color!
        violet.colorPoem();        // Output: Violets are blue

        Color red = Color.RED;
        red.generalColorInfo(); // Output: Everyday color is a great color!
        red.colorPoem();        // Output: Roses are red
    }
}
```
