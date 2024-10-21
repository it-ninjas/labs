---
title: "Objektorientierte Programmierung"
linkTitle: "Objektorientierte Programmierung"
weight: 1
description: >
  Modul #J2
---

## Ziele

- Ich kann ohne Hilfsmittel die Bestandteile einer Klasse vollständig auflisten.
- Ich kann den Unterschied zwischen einer Klasse und einem Objekt mit konkreten Beispielen
  demonstrieren.
- Ich implementiere Klassen anhand vorgegebenen Anforderungen und instanziiere (erzeuge) Objekte
  dazu.

---

## Einführung

In der realen Welt können wir viele Objekte wie Autos, Gebäude und Menschen um uns herum finden.
Alle diese Objekte haben einen bestimmten Zustand/Merkmale und ein bestimmtes Verhalten.

Wenn wir ein Auto betrachten, so könnte sein Zustand/seine Merkmale

- einen Markennamen,
- eine bestimmte Geschwindigkeit
- oder den zu tankenden Kraftstoff enthalten.

Mögliche Verhaltensweisen eines Autos sind normalerweise

- fahren
- und einparken.

## Problemstellung

Stell dir vor, du möchtest ein Auto in Java programmieren. Dazu könnten wir für jedes Auto einfach drei separate Variablen verwenden:

```java
public class AutoProblemOhneOOP {

    public static void main(String[] args) {
        String autoName = "BMW";
        int geschwindigkeit = 120;
        String kraftstoff = "Benzin";

        // Weitere Autos
        String autoName2 = "Audi";
        int geschwindigkeit2 = 100;
        String kraftstoff2 = "Diesel";
    }
}
```

Das funktioniert für ein oder zwei Autos, aber was passiert, wenn wir viele Autos haben? Was passiert, wenn wir viele Autos haben? Es wird schwierig, jedes Auto mit seinen individuellen Merkmalen zu verwalten, und der Code wird unübersichtlich. Wir müssten
mehrere Variablen für jeden Zustand eines Autos pflegen. Eine Lösung wäre die Verwendung von Arrays:

```java
public class AutoProblemMitArrays {

    public static void main(String[] args) {
        String[] autoName = {"BMW", "Audi"};
        int[] geschwindigkeit = {120, 100};
        String[] kraftstoff = {"Benzin", "Diesel"};
    }
}
```

Probleme mit dieser Lösung:

- Wir müssen immer sicherstellen, dass die Daten für jedes Auto an der gleichen Position in allen
  Arrays stehen. Das erhöht die Komplexität.
- Es ist schwer, weitere Funktionen für jedes Auto hinzuzufügen oder das Verhalten zu modellieren.

Wäre es nicht cool, wenn wir diese Eigenschaften zusammenfassen könnten?
Eine bessere Lösung besteht darin, eine **Klasse** zu erstellen, die alle Merkmale eines Autos
beschreibt. Dadurch können wir sowohl den Zustand als auch das Verhalten eines Autos kapseln.

```java
public class Auto {
    String marke;
    int geschwindigkeit;
    String kraftstoff;
}
```

Nun können wir **Objekte** dieser Klasse erstellen. Ein Objekt hat diese Eigenschaften zur Verfügung
und kann sie entsprechend setzen:

```java
public class AutoBeispiel {

  public static void main(String[] args) {
    Auto auto1 = new Auto(); //mit new wird ein neues Objekt von dieser Klasse erstellt
    auto1.marke = "BMW";
    auto1.geschwindigkeit = 120;
    auto1.kraftstoff = "Benzin";

    Auto auto2 = new Auto();
    auto2.marke = "Audi";
    auto2.geschwindigkeit = 100;
    auto2.kraftstoff = "Diesel";

    System.out.println(auto1.marke); // Output: BMW
    System.out.println(auto2.marke); //Output: Audi

  }
}
```

Vorteile dieser Lösung:

- Die Eigenschaften eines Autos sind in einer einzigen Einheit (Klasse) zusammengefasst.
- Es ist einfach, neue Autos zu erstellen und zu verwalten, da wir nicht mehr mehrere Arrays benötigen. Wir können einfach einen Array von unserem Typ Auto erstellen: `Auto[] autos`.
- Der Code wird klarer und wartbarer.

Klassen können noch viel mehr als nur Behälter für mehrere Variablen sein. Das wirst du in den folgenden Kapiteln lernen.

### Definitionen

Um die nachfolgenden Kapitel besser zu verstehen, ist es hilfreich zuerst einige Basisdefinitionen zu etablieren.

#### Objektorientierte Programmierung

Das Konzept der objektorientierten Programmierung soll helfen eine Struktur in eine Anwendung zu
bringen.
Das Ziel ist es, Daten und Methoden, die zusammengehören, in einer Klasse zusammenzufassen.
Dies führt auch dazu, dass der Code wiederverwendbarer wird, da einfach neue Instanzen/Objekte
dieser Klasse erstellt werden können.

#### Klasse

Eine Klasse ist eine Vorlage, die die gemeinsamen Eigenschaften und das Verhalten von Objekten desselben Typs beschreibt Die Klasse dient als Bauplan für die Abbildung
von realen Objekten in Softwareobjekte und beschreibt Attribute (Eigenschaften) und Methoden (
Verhaltensweisen) der Objekte.

#### Objekt

Ein Objekt bezeichnet in der objektorientierten Programmierung ein Exemplar eines bestimmten
Datentyps oder einer bestimmter Klasse. Objekte sind konkrete Ausprägungen (=Instanzen) einer Klasse
und werden zur Laufzeit erzeugt (Instanziierung).

#### Datenfelder

Datenfelder (Attribute) enthalten Informationen, die für Objekte dieser Klasse relevant sind.
Beispielsweise hat ein Auto eine Höchstgeschwindigkeit, eine bestimmte Anzahl von Sitzen, usw. Das
heisst, ein Feld ist eine Variable, in der Daten gespeichert werden können. Es kann einen beliebigen
Typ haben, einschliesslich primitiver Typen (`int`, `float`, `boolean` usw.) und Klassen. Eine
Klasse kann auch sich selber als Feld enthalten. Eine Klasse kann beliebig viele Felder haben.

#### Methoden

Methoden dienen dazu, den Zustand eines Objekts zu verändern. Die Methode `refuel()` (siehe
Klassendiagramm unten) füllt beispielsweise den Tank, bis dessen Kapazität erreicht wird.

#### Zusammenfassung

Klassen werden verwendet, um benutzerdefinierte Datentypen darzustellen. Damit werden Attribute und
Verhalten, welche zu diesem neuen Datentyp gehören, an einer Stelle im Code zusammengefasst und
verwaltet. Diese neuen, benutzerdefinierte Datentypen können dann wie anderen Datentypen (primitive
Datentypen oder andere Klassen) verwendet werden.

Beginnen wir mit einem Beispiel einer Auto-Klasse; hier siehst du das UML-Klassendiagramm der
Klasse `Car`, die wir selber erfunden haben. Die oberen 4 Einträge sind ihre Instanzvariablen und
die untersten 3 sind ihre Methoden. Einträge mit einem `-` sind `private`, Einträge mit einem `+`
sind öffentlich (`public`):

| `class Car`              |
| ------------------------ |
| - topSpeed: `int`        |
| - totalSeats: `int`      |
| - fuelCapacity: `int`    |
| - manufacturer: `String` |
| + refuel(): `void`       |
| + park(): `void`         |
| + drive(): `void`        |

---

## Klassen und Objekte im Schnelldurchlauf

### Klassen deklarieren

Eine Java Klasse besteht aus zwei Teilen: Dem Klassenkopf und dem Klassenrumpf.

Im Klassenkopf (auch Klassendeklaration genannt) wird eine neue Klasse mit dem Keyword `class`
gefolgt vom Namen der Klasse deklariert. Per Konvention folgt die Benamsung der Klasse dem
PascalCase. Das bedeutet, dass der Klassen-Name und jedes neue Wort darin mit einem Grossbuchstaben
beginnt, der Rest besteht aus Kleinbuchstaben.

Wie folgt kannst du eine Klasse mit dem Namen _Nothing_ erstellen:

```java
public class Nothing {

}
```

Der "Klassenrumpf" besteht aus einer öffnender `{` und schliessenden geschweiften Klammer `}`. Diese
Klammern bilden die Grenzen der Klasse. Der Klassenrumpf kann Felder, Methoden und Konstruktoren
enthalten. Felder speichern Daten, Methoden definieren das Verhalten und Konstruktoren ermöglichen
es uns, neue Objekte der Klasse zu erstellen und zu initialisieren. Felder und Methoden gelten als
Klassenmitglieder (_class members_).

Der Quellcode einer Klasse wird in eine .java-Datei eingefügt. Normalerweise enthält eine
Quellcodedatei nur eine Klasse und hat denselben Namen wie diese Klasse. Manchmal kann eine Datei
jedoch auch mehrere Klassen enthalten, jedoch darf es nur eine öffentliche (public) Klasse pro Datei
geben. Deren Name muss mit dem Dateinamen übereinstimmen.

Nachfolgend die Klasse `Patient` in der Datei `Patient.java`:

```java
public class Patient {

    String name;         // Feld bzw. Instanzvariable vom Datentyp String mit dem Bezeichner 'name'
    int age;             // Feld bzw. Instanzvariable vom Datentyp int mit dem Bezeichner 'age'
    float size;          // Feld bzw. Instanzvariable vom Datentyp float mit dem Bezeichner 'size'
    String[] complaints; // ein Feld kann auch ein Array sein
}
```

Diese Klasse repräsentiert einen Patienten in einem Krankenhausinformationssystem. Sie verfügt über
vier Felder: `name`, `age`, `size` und `complaints`. Alle Objekte der Klasse Patient haben dieselben
Felder, aber ihre Werte können für jedes Objekt unterschiedlich sein.

### Objekte erstellen

**Patient.java**

```java
class Patient {

    String name;
    int age;
    float height;
}
```

Wir können ein Objekt (auch "eine Instanz" genannt) der Klasse `Patient` mit dem Operator `new`
erstellen:

```java
Patient patient = new Patient();
```

Wenn du ein neues Objekt erstellst, wird jedes Feld mit dem Standardwert des entsprechenden Typs
initialisiert (insofern du keinen Konstruktor mit Argumenten verwendest, dazu aber später mehr).
Wenn die Instanzvariablen eines Objektes nicht mit einem Zugriffsmodifikator wie `private` versehen
sind (dazu unten mehr), können wir mittels Punkt-Operator auf die Variablen des Objekts zugreifen:

```java
System.out.println(patient.name); // es wird null ausgeben
System.out.println(patient.age);  // es wird 0 ausgeben
```

Das folgende Programm erstellt zwei Objekte der Klasse Patient und druckt die Informationen der
Objekte aus.

**PatientDemo.java**

```java
public class PatientDemo {

    public static void main(String[] args) {
        // Wir erstellen einen neuen Patienten, alle Variablen werden mit ihren Standardwerten initialisiert
        Patient john = new Patient();
        // Wir greifen über den Punkt-Operator auf die Variablen zu und speichern Werte darin
        john.name = "John";
        john.age = 30;
        john.height = 180f;
        System.out.println(john.name + " " + john.age + " " + john.height);

        Patient alice = new Patient();
        alice.name = "Alice";
        alice.age = 22;
        alice.height = 165f;
        System.out.println(alice.name + " " + alice.age + " " + alice.height);
    }
}
```

Im obigen Code haben wir zwei Patienten erstellt, John und Alice, die Werte ihrer Felder definiert
und dann die Informationen über sie ausgedruckt. Wir sehen, dass wir mit dem Punkt-Operator auf die
Felder des Objekts zugreifen können (john.name = "John"). Allerdings soll hier erwähnt sein, dass
das nur geht, wenn die Instanzvariablen nicht private sind (wir behandeln das Thema
Zugriffsmodifikatoren später).

### Referenzen teilen

Objekte sind Referenztypen. In einer Variable wird also nicht das Objekt selbst, sondern die
Speicheradresse hinterlegt, welche auf das Objekt zeigt. Es können sich also mehrere Referenzen auf
dasselbe Objekt beziehen.

```java
Patient patient = new Patient();
patient.name = "Mary";
patient.age = 24;
System.out.println(patient.name + " " + patient.age); // Mary 24

// Wir weisen der Variablen patient2 die Speicheradresse der Variablen patient zu
Patient patient2 = patient;
System.out.println(patient2.name + " " + patient2.age); // Mary 24
```

Es ist wichtig zu verstehen, dass sich die zwei Referenzen oben auf das gleiche Objekt im Speicher
beziehen und nicht auf zwei unabhängige Kopien. Da unsere Klasse veränderbar ist, können wir das
Objekt mit Hilfe beider Referenzen ändern.

```java
patient.age = 25;
System.out.println(patient2.age); // 25
```

---
