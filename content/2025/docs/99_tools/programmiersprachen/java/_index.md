---
title: "Java"
linkTitle: "Java"
weight: 1
description: >
  Alles, was du über Java wissen solltest – von den Grundlagen bis zu fortgeschrittenen Konzepten.
---

## Was ist Java?

Java ist eine objektorientierte Programmiersprache, die seit über zwei Jahrzehnten grosse Popularität geniesst. Die
Entwicklung begann Anfang der 1990er-Jahre beim US-amerikanischen Unternehmen **Sun Microsystems**. 1995 erschien die
erste Java-Version. Seit der Übernahme von Sun durch **Oracle** im Jahr 2010 wird Java von Oracle weiterentwickelt.

Aktuell erscheint alle sechs Monate eine neue Java-Version. Die zuletzt veröffentlichte Version ist **Java 24**
(März 2025). Die nächste geplante Version ist **Java 25**, ein Long-Term-Support-Release (LTS), das im **September 2025**
erscheinen soll.

## Wichtige Merkmale von Java

### Plattformunabhängigkeit: «Write once, run anywhere»

Java-Code wird nicht direkt von der Hardware ausgeführt. Stattdessen wird er vom **Compiler** in sogenannten **Bytecode**
übersetzt. Dieser Bytecode wird von der **Java Virtual Machine (JVM)** interpretiert.

Die JVM ist eine Software, die eine virtuelle Umgebung schafft – sie simuliert einen Computer innerhalb deines Rechners.  
Weil es JVMs für Windows, Linux und macOS gibt, kann derselbe Bytecode auf allen Plattformen ausgeführt werden, **ohne
Anpassung am Code**.

Das macht Java besonders **plattformunabhängig**: Einmal schreiben – überall ausführen.

### Objektorientierte Programmierung

Java ist in erster Linie eine **objektorientierte Sprache**. Das bedeutet: Fast alles besteht aus **Objekten**, die
bestimmte Eigenschaften (Daten) und Fähigkeiten (Methoden) besitzen.

In einem Programm beschreibst du Klassen – das sind **Baupläne** für Objekte.

Ein Beispiel: Ein _Auto_ könnte als Objekt Eigenschaften wie _Farbe_, _Marke_ oder _Anzahl Sitze_ haben und Methoden wie
_fahren()_ oder _stoppen()_.

Ein Java-Programm besteht aus vielen solcher Objekte, die **zusammenarbeiten**, um Aufgaben zu erfüllen.

### Weitere Programmierkonzepte in Java

Neben der Objektorientierung unterstützt Java auch weitere Konzepte:

- **Generische Programmierung**  
  Ermöglicht es, Klassen und Methoden so zu schreiben, dass sie mit beliebigen Datentypen arbeiten.

  Beispiel: `List<String>` oder `List<Integer>`.

- **Parallele Programmierung**  
  Java erlaubt es, mehrere Aufgaben gleichzeitig auszuführen – etwa mit _Threads_. Das ist hilfreich für performante
  Anwendungen.

- **Funktionale Programmierung**  
  Seit Java 8 unterstützt Java Funktionen als Objekte (z. B. Lambdas). Das erlaubt einen funktionalen Stil – oft
  nützlich bei Streams und Events.

- **Prozedurale Programmierung**  
  Bei der prozeduralen Programmierung steht nicht die Modellierung von Objekten im Vordergrund, sondern die Gliederung
  in Funktionen (in Java: statische Methoden), die auf Datenstrukturen zugreifen.  
  Anstatt ein Objekt mit Methoden und Eigenschaften zu definieren, wird eine Datenstruktur verwendet, die an verschiedene
  Funktionen übergeben wird.

{{< ninja info >}}
Gerade als Einsteiger wirst du viele Programme **prozedural** aufbauen. Du verwendest einfache Daten (z. B. `int`,
`String`, Arrays oder Listen) und rufst Methoden auf, ohne eigene Objekte zu definieren. ¨
Das hilft dir, die Grundlagen der Programmierung zu lernen, bevor du dich mit objektorientierten Konzepten beschäftigst.
{{< /ninja >}}

## Begriffe zum Nachschlagen

### Bytecode und Ausführung

Java-Programme werden in **Bytecode** übersetzt – das ist ein plattformunabhängiger Zwischencode. Ausführbare Programme
benötigen eine spezielle Methode namens `main`, z. B.:

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hallo Java!");
  }
}
```

Mehrere Klassen und Bibliotheken werden oft in einer **JAR-Datei** (Java ARchive) zusammengefasst. Eine `.jar` ist
technisch gesehen eine ZIP-Datei mit einem definierten Aufbau.

### Klassenpfad

Der **Klassenpfad** (Classpath) sagt der JVM, **wo** sie nach Klassen und Bibliotheken suchen soll. Er kann beim
Ausführen angegeben oder über Umgebungsvariablen gesetzt werden.

### Garbage Collector

Java kümmert sich automatisch um die Speicherbereinigung. Nicht mehr benötigte Objekte werden durch den **Garbage
Collector** entfernt – du musst dich nicht selbst darum kümmern, wie z. B. in C oder C++.

Das vereinfacht die Programmierung und verhindert viele typische Speicherfehler.

### Multithreading

Java unterstützt die gleichzeitige Ausführung von **mehreren Threads**. Ein Thread ist ein Teilprozess, der unabhängig
vom Rest des Programms läuft.

Das ist nützlich bei:

- parallelen Datenverarbeitungen
- Benutzeroberflächen
- Netzwerkanwendungen

---

[Jetzt starten: Java-Programmierung lernen](../../../02_java/)
