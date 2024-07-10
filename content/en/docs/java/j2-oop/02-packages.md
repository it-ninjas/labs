---
title: "Packages"
linkTitle: "Packages"
weight: 2
description: >
  Modul #J2
---

## Ziele
* Ich kann ohne Hilfsmittel mindestens zwei Vorteile für das Verwenden von Packages nennen.
* Ich kann ohne Hilfsmittel die Namenkonvention für Java-Packages beschreiben.
* Ich zeige auf, wie mehrere Klassen vom gleichen Packet mit einem `import`-Statement importiert werden.
* Ich kann korrekt und ohne Hilfsmittel erklären, was ein statischer Import ist und wozu er verwendet wird.
* Ich kann erläutern, warum es keine gute Idee ist, Klassen ohne Package-Anweisung zu schreiben.

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
Programmcode muss organisiert sein. Obwohl die Ordnerstruktur nicht vorgegeben ist, hat sich die folgende Konvention in Java-Projekten (vor allem solche, welche Maven im Einsatz haben - dazu mehr im Maven-Modul) etabliert.

Grundsätzlich legen wir Quellcode im einem Verzeichnis ab, das _src_ genannt wird.
Innerhalb dieses Verzeichnisses legen wir ein Verzeichnis _main_ und darin wiederum ein Verzeichnis _java_ an. Innerhalb des Java-Verzeichnisses können wir beliebig viele eigene Packages anlegen, um unseren Programmcode zu organisieren.

### Klassen mit gleichem Namen
Es kann passieren, dass wir zwei Klassen haben, die den gleichen Namen haben. Beispiel: Wir arbeiten mit der externen Bibliothek Abstract Window Toolkit (AWT). Darin gibt es eine Klasse mit dem Namen _Rectangle_. Es ist natürlich erlaubt eine eigene Klasse mit diesem Namen anzulegen, solang sie sich nicht in einem Package mit dem gleichen Namen befindet.
```java
package ch.sbb.main;

import ch.sbb.rectangle.Rectangle;

public class Main {
    public static void main(String[] args) {
        // Deklaration und Initialisierung eines AWT-Rectangles:
        java.awt.Rectangle rectAWT = new java.awt.Rectangle()

        // Deklaration und Initialisierung eines Rectangles aus dem Package ch.sbb.rectangle:
        Rectangle myRect = new Rectangle();
    }
}
```
* Wir importieren die eigene Rectangle-Klasse mit der Import-Anweisung
* Wir deklarieren und initialisieren ein AWT-Rectangle, indem wir den vollständigen Namen (Package und Klassennamen) angeben

### Import *
Wenn sich zwei Klassen im selben Paket befinden und eine Klasse in der anderen verwendet wird, muss die Klasse nicht importiert werden.
Es ist auch möglich, alle Klassen aus dem Paket zu importieren. Dazu müssen wir einen `*` anstelle eines bestimmten Klassennamens in das Import-Statement schreiben.
```java
import java.awt.*;
```
Alle Klassen eines Packages, wie in diesem Beispiel, zu importieren ist schlechter Style und soll vermieden werden. Es soll immer explizit importiert werden.
### Package java.lang
Obwohl wir die meisten Pakete importieren müssen, gibt es ein Java-Paket, das immer automatisch importiert wird. Es ist `java.lang`. Dieses Paket enthält viele weit verbreitete Klassen wie `String`, `System`, `Long`, `Integer`, `NullPointerException` und andere.

### Statischer Import
Wir können auch statische Elemente (wie z.B. Konstanten oder auch statische Methoden) einer Klasse in eine andere Klasse importieren. Wenn wir `*` in die import-Anweisung schreiben, müssen wir den importierten Klassennamen nicht angeben, bevor wir statische Methoden aufrufen oder statische Felder lesen.
Hier ist ein Beispiel für den statischen Import der Klasse `Arrays`, die viele nützliche Methoden zur Verarbeitung von Arrays enthält:
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

### Eigenes Package definieren
Ein eigenes Package zu definieren ist gar nicht so schwer. Im Grunde muss nur eine Package-Definition zu einer Klasse hinzugefügt werden.
Wir haben als Beispiel die Klasse `Beispiel.java`, welche sich in der folgenden Verzeichnisstruktur befindet:
```
/src
  └── ch
      └── sbb
          └── examplepackage
              └── Beispiel.java
```

Um diese Klasse nun einem Package hinzuzufügen, wird auf der ersten Zeile mit `package com.sbb.examplepackage` der Name des Packages definiert. Der Name entspricht zugleich der Verzeichnisstruktur.

```java
package ch.sbb.examplepackage;

public class Beispiel {
    public void sagHallo() {
        System.out.println("Hallo, Welt!");
    }
}
```
In einer anderen Klasse kann das Package wie zuvor beschrieben importiert und verwendet werden. Ein Beispiel für eine Klasse welche das Package importiert und verwendet könnte wie folgt aussehen:

```java
package ch.sbb.main;

import ch.sbb.examplepackage.*;

public class Main {
    public static void main(String[] args) {
        Beispiel b = new Beispiel();
        
        b.sagHallo();
    }
}
```