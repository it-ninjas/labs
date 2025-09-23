---
title: "Einführung UML"
linkTitle: "UML Einführung"
weight: 1
description: >
  Grundlagen der UML-Klassendiagramme, um Klassen, Attribute, Methoden und Beziehungen darzustellen
  und in Java-Code zu übersetzen.
---

{{< module "J2" >}}

## Voraussetzungen

- Java Grundlagen (Variablen, Methoden, Kontrollstrukturen)
- Erste Erfahrungen mit Klassen und Objekten sind hilfreich, aber nicht zwingend notwendig

## Ziele

- Grundlagen der UML-Klassendiagramme verstehen
- Klassen, Attribute und Methoden in UML notieren
- Beziehungen wie _Assoziation_, _Vererbung_ und _Aggregation_ darstellen
- UML-Diagramme lesen und in Java-Code übersetzen

{{< zeit lesen="15" >}}

## Einführung

Die **Unified Modeling Language (UML)** ist eine standardisierte Sprache, um Software-Entwürfe grafisch
darzustellen. Besonders in der **Objektorientierten Programmierung (OOP)** hilft UML, Programme zu planen
und Strukturen sichtbar zu machen.

Mit UML kannst du darstellen:

- Welche **Klassen** es gibt
- Welche **Attribute** und **Methoden** sie besitzen
- Wie die **Beziehungen** zwischen Klassen aussehen

So schlägst du eine Brücke zwischen **Konzept** und **Java-Code**.

## Aufbau eines Klassendiagramms

Ein **UML-Klassendiagramm** besteht aus drei Bereichen:

1. **Kopf**: Klassenname
2. **Attribute**: Variablen mit Typ und Sichtbarkeit (`+` public, `-` private)
3. **Methoden**: Funktionen mit Parametern und Rückgabewert

Beispiel:

```text
+-------------------+
|     Person        |
+-------------------+
| - name: String    |
| - age: int        |
+-------------------+
| + getName():String|
| + setName(n:String)|
| + birthday():void |
+-------------------+
```

### Übersetzung in Java-Code

```java
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void birthday() {
        age++;
    }
}
```

## Beziehungen zwischen Klassen

- **Assoziation**: Eine Klasse kennt eine andere  
  → `Student` hat eine `School`
- **Vererbung**: Eine Klasse erbt Eigenschaften von einer anderen  
  → `Car` erbt von `Vehicle`
- **Aggregation/Komposition**: Eine Klasse besteht aus anderen Klassen  
  → `Team` besteht aus mehreren `Player`

Diese Konzepte lernst du im OOP-Teil vertieft kennen. UML dient dir hier als **visuelle Unterstützung**.

{{< ninja tip >}}
UML ist kein Code – aber eine gute Vorbereitung für sauberen Code.  
Nutze es, um deine Ideen klar zu strukturieren.
{{< /ninja >}}
