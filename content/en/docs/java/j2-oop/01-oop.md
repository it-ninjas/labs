---
title: "Objektorientierte Programmierung"
linkTitle: "Objektorientierte Programmierung"
weight: 1
description: >
  Modul #J2
---

## Ziele
* Ich kann ohne Hilfsmittel die Bestandteile einer Klasse vollständig auflisten.
* Ich kann den Unterschied zwischen einer Klasse und einem Objekt mit konkreten Beispielen demonstrieren.
* Ich implementiere Klassen anhand vorgegebenen Anforderungen und instanziiere (erzeuge) Objekte dazu.

---

## Einführung
In der realen Welt können wir viele Objekte wie Autos, Gebäude und Menschen um uns herum finden. Alle diese Objekte haben einen bestimmten Zustand und ein bestimmtes Verhalten. Wenn wir ein Auto betrachten, so könnte sein Zustand einen Markennamen, eine bestimmte Geschwindigkeit oder den zu tankenden Kraftstoff enthalten. Mögliche Verhaltensweisen eines Autos sind normalerweise fahren und einparken.

### Definitionen
#### Klasse
Unter einer Klasse versteht man in der objektorientierten Programmierung ein abstraktes Modell bzw. einen Bauplan für eine Reihe von ähnlichen Objekten. Die Klasse dient als Bauplan für die Abbildung von realen Objekten in Softwareobjekte und beschreibt Attribute (Eigenschaften) und Methoden (Verhaltensweisen) der Objekte.

#### Objekt
Ein Objekt bezeichnet in der objektorientierten Programmierung ein Exemplar eines bestimmten Datentyps oder einer bestimmter Klasse. Objekte sind konkrete Ausprägungen (=Instanzen) einer Klasse und werden zur Laufzeit erzeugt (Instanziierung).

#### Datenfelder
Datenfelder (Attribute) enthalten Informationen, die für Objekte dieser Klasse relevant sind. Ein Auto hat eine Höchstgeschwindigkeit, eine bestimmte Anzahl von Sitzen, usw. Das heisst, ein Feld ist eine Variable, in der Daten gespeichert werden können. Es kann einen beliebigen Typ haben, einschliesslich primitiver Typen (`int`, `float`, `boolean` usw.) und Klassen. Eine Klasse kann auch sich selber als Feld enthalten. Eine Klasse kann beliebig viele Felder haben.

#### Methoden
Methoden dienen dazu, den Zustand eines Objekts zu verändern. Die Methode `refuel()` (siehe Klassendiagramm unten) füllt beispielsweise den Tank, bis dessen Kapazität erreicht wird.

#### Zusammenfassung
Klassen werden verwendet, um benutzerdefinierte Datentypen darzustellen. Damit werden Attribute und Verhalten, welche zu diesem neuen Datentyp gehören, an einer Stelle im Code zusammengefasst und verwaltet. Diese neuen, benutzerdefinierte Datentypen können dann wie anderen Datentypen (primitive Datentypen oder andere Klassen) verwendet werden.

Beginnen wir mit einem Beispiel einer Auto-Klasse; hier siehst du das UML-Klassendiagramm der Klasse `Car`, die wir selber erfunden haben. Die oberen 4 Einträge sind ihre Instanzvariablen und die untersten 3 sind ihre Methoden. Einträge mit einem `-` sind `private`, Einträge mit einem `+` sind öffentlich (`public`):

| `class Car`               | 
| ------------------------- |
| - topSpeed: `int`         |
| - totalSeats: `int`       |
| - fuelCapacity: `int`     |
| - manufacturer: `String`  |
| + refuel(): `void`        |
| + park(): `void`          |
| + drive(): `void`         |

---

## Klassen und Objekte im Schnelldurchlauf

### Klassen deklarieren
Eine Java Klasse besteht aus zwei Teilen: Dem Klassenkopf und dem Klassenrumpf.

Im Klassenkopf (auch Klassendeklaration genannt) wird eine neue Klasse mit dem Keyword `class` gefolgt vom Namen der Klasse deklariert. Per Konvention folgt die Benamsung der Klasse dem PascalCase. Das bedeutet, dass der Klassen-Name und jedes neue Wort darin mit einem Grossbuchstaben beginnt, der Rest besteht aus Kleinbuchstaben.

Wie folgt kannst du eine Klasse mit dem Namen _Nothing_ erstellen:
```java
public class Nothing {
    
}
```

Der "Klassenrumpf" besteht aus einer öffnender `{` und schliessenden geschweiften Klammer `}`. Diese Klammern bilden die Grenzen der Klasse. Der Klassenrumpf kann Felder, Methoden und Konstruktoren enthalten. Felder speichern Daten, Methoden definieren das Verhalten und Konstruktoren ermöglichen es uns, neue Objekte der Klasse zu erstellen und zu initialisieren. Felder und Methoden gelten als Klassenmitglieder (_class members_).

Der Quellcode einer Klasse wird in eine .java-Datei eingefügt. Normalerweise enthält eine Quellcodedatei nur eine Klasse und hat denselben Namen wie diese Klasse. Manchmal kann eine Datei jedoch auch mehrere Klassen enthalten, jedoch darf es nur eine öffentliche (public) Klasse pro Datei geben. Deren Name muss mit dem Dateinamen übereinstimmen.

Nachfolgend die Klasse `Patient` in der Datei `Patient.java`:

```java
public class Patient {
    String name;         // Feld bzw. Instanzvariable vom Datentyp String mit dem Bezeichner 'name'
    int age;             // Feld bzw. Instanzvariable vom Datentyp int mit dem Bezeichner 'age'
    float size;          // Feld bzw. Instanzvariable vom Datentyp float mit dem Bezeichner 'size'
    String[] complaints; // ein Feld kann auch ein Array sein
}
```
Diese Klasse repräsentiert einen Patienten in einem Krankenhausinformationssystem. Sie verfügt über vier Felder: `name`, `age`, `size` und `complaints`. Alle Objekte der Klasse Patient haben dieselben Felder, aber ihre Werte können für jedes Objekt unterschiedlich sein.


### Objekte erstellen
Wir können ein Objekt (auch "eine Instanz" genannt) der Klasse `Patient` mit dem Operator `new` erstellen:
```java
Patient patient = new Patient();
```
Wenn du ein neues Objekt erstellst, wird jedes Feld mit dem Standardwert des entsprechenden Typs initialisiert (insofern du keinen Konstruktor mit Argumenten verwendest, dazu aber später mehr). Wenn die Instanzvariablen eines Objektes nicht mit einem Zugriffsmodifikator wie `private` versehen sind (dazu unten mehr), können wir mittels Punkt-Operator auf die Variablen des Objekts zugreifen:
```java
System.out.println(patient.name); // es wird null ausgeben
System.out.println(patient.age);  // es wird 0 ausgeben
```
Das folgende Programm erstellt zwei Objekte der Klasse Patient und druckt die Informationen der Objekte aus.

**Patient.java**
```java
class Patient {
    String name;
    int age;
    float height;
}
```

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

Im obigen Code haben wir zwei Patienten erstellt, John und Alice, die Werte ihrer Felder definiert und dann die Informationen über sie ausgedruckt. Wir sehen, dass wir mit dem Punkt-Operator auf die Felder des Objekts zugreifen können (john.name = "John"). Allerdings soll hier erwähnt sein, dass das nur geht, wenn die Instanzvariablen nicht private sind (wir behandeln das Thema Zugriffsmodifikatoren später).

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
