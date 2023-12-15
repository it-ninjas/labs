---
title: "Java-Einführung"
linkTitle: "Java-Einführung"
weight: 1
description: >
  Modul #J1
---

## Ziele
* Ich weiss, dass jede Anweisung mit einem Strichpunkt abgeschlossen werden muss.
* Ich weiss, dass geschweifte Klammern einen Block definieren und ich verwende sie in jeder Kontrollstruktur, um die Code-Blocks voneinander abzugrenzen.
* Ich kenne die `main`-Methode und weiss, warum eine Applikation nur EINE Main-Methode haben sollte.
* Ich kenne die Methode `System.out.println` und kann sie anwenden.


### Cheatsheet zum Herunterladen
[Core Java Cheatsheet](../../java-grundlagen/cheatsheet.pdf)

---

## Einführung

### Was ist Java?
Java ist eine objektorientierte Programmiersprache, die schon seit ca. zwei Jahrzehnten grosse Popularität geniesst.
Die Entwicklung von Java begann Anfang der 1990er-Jahre beim US-amerikanischen Hard- und Softwarehersteller Sun Microsystems.
1995 wurde die erste Version veröffentlicht. 2010 wurde Sun Microsystems von Oracle übernommen.
Gegenwärtig erscheinen im Halbjahrestakt neue Java-Versionen; die nächste Version, Java 21, wird im September 2023 veröffentlicht.

---

### Wichtigste Merkmale von Java

#### Plattformunabhängigkeit: «Write once, Run anywhere»
Der Compiler wandelt den Quellcode in Bytecode (Kompilat) um, und anschliessend führt die Java Virtual Machine (JVM) den Bytecode aus.
Jedes Betriebssystem hat eine andere JVM, aber jede JVM kann den Bytecode ausführen, daher kann ein- und dieselbe Java-Anwendung auf Windows, Linux, Mac OS und anderen Plattformen lauffähig sein.

#### Mehrfach-Paradigma
Java ist in erster Linie eine objektorientierte und imperative Programmiersprache, bei der fast alles ein Objekt einer Klasse (eines Typs) ist.
Wir können ein typisches Java-Programm als eine Menge von interagierenden Objekten betrachten. Die Objekte können Entitäten aus der realen Welt oder eine Art von Programmierabstraktionen darstellen.
Wenn wir ein Programm schreiben, erklären wir, wie die Objekte miteinander interagieren sollen.
Java unterstützt aber auch andere Programmierparadigmen, darunter generische Programmierung, parallele Programmierung, funktionale Programmierung (teilweise unterstützt) und andere.

#### Ausführbarer Bytecode
Eine kompilierte Klasse, welche bestimmte Voraussetzungen erfüllt (dazu später), kann eigenständig ausgeführt werden.
Applikationen und Klassenbibliotheken bestehen oft aus mehreren Klassen und werden als Java Archive (JAR-Datei genannt) verpackt, verteilt und bereitgestellt.
Eine JAR-Datei ist technisch gesehen eine komprimierte Datei in ZIP-Format und kann auch so erstellt werden, dass sie von der JVM ausgeführt werden kann.

#### Klassenpfad
Um den Bytecode ausführen zu können, muss die JVM wissen wo sich dieser befindet.
Damit die JVM nicht überall suchen muss, wird mit einem Klassenpfad (Classpath) angegeben, wo sie nach dem Bytecode suchen soll.
Der Klassenpfad besteht aus einer Liste von Ordnern und .jar Dateien (sog. Java-Archive) und kann entweder als Parameter bei der Ausführung des Programms oder als eine Umgebungsvariable angegeben werden.

#### Garbage Collector
Der Garbage Collector (Teil der JVM) führt zur Laufzeit eine automatische Speicherbereinigung von unbenutzten Objekten durch. Der Entwickler muss sich also nicht um das Aufräumen von unbenutzen Objekten kümmern.

#### Multithreading
Java unterstützt Multithreading auf der Ebene der Sprache und der Standardbibliothek. Es ermöglicht die gleichzeitige und parallele Ausführung mehrerer Teile eines Java-Programms.

---

### Code, Compile, Run
Ein/e Java-Entwickler/in schreibt ein Programm in eine Textdatei mit der Erweiterung .java. Ein Programm kann eine Vielzahl solcher Dateien enthalten. Dann übersetzt der Compiler (normalerweise javac) das Programm in eine .class-Datei, die den Bytecode des Programms enthält. Danach führt die JVM das Programm aus und gibt Low-Level-Befehle an den Computer. Der Computer ist hier eine Abstraktion, welche ein Server, ein PC oder sogar ein mobiles Gerät sein kann.
Tatsächlich sind die Prozesse komplexer, als hier gezeigt wird. Es ist wichtig, Folgendes zu verstehen: Der Teil vor der JVM ist plattformunabhängig, der Teil nach der JVM ist plattformabhängig.
![](../../java-grundlagen/code-compile-run.png)

---

## Hello World
Anhand des simplen Hello-World-Programms können wir bereits vieles über die zentralen Bestandteile einer Java-Anwendung erklären. Der folgende Sourcecode ist in einer Datei mit dem Namen HelloWorld.java abgelegt.
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

Bei diesem Beispiel arbeiten wir uns nun von aussen nach innen vor. Der erste Teil definiert eine neue Klasse mit dem Namen _HelloWorld_. Die Deklaration der Klasse besteht aus dem Zugriffsmodifizierer _public_ (dazu später mehr) gefolgt vom Keyword _class_ und dem Klassennamen. Jede Java-Datei darf nur eine Klasse mit dem Zugriffsmodifizierer _public_ enthalten, weitere Klassen ohne _public_ sind jedoch erlaubt. Der Name der Klasse mit dem Modifizierer _public_ muss stets mit dem Dateinamen übereinstimmen. Der Klassenname wird stets gross geschrieben, einzelne Wörter werden durch einen erneuten Grossbuchstaben getrennt. Dies wird CamelCase genannt. Der _Block_ der Klasse wird durch geschweifte Klammern angegeben.

Innerhalb der Klasse wird nun eine Main-Methode definiert. Diese Methode ist der Einstiegspunkt eines jeden Java-Programms. Nur über eine solche Methode kann eine Java-Anwendung gestartet werden. Die Methode besteht aus dem Zugriffsmodifizierer _public_, dem Keyword _static_, dem Rückgabewert _void_ und dem Methodennamen _main_.
An den Namen der Methode schliesst sich ein paar runde Klammern an. Innerhalb dieser Klammern befinden sich die _Parameter_ der Methode, in diesem Fall handelt es sich um ein _String_-_Array_. Die Angabe der genannten Teile einer Methode nennt man Methodensignatur. Der _Block_ der Methode wird durch geschweifte Klammern angegeben. Die Main-Methode hat immer die oben gezeigte Signatur.

Innerhalb der Main-Methode sehen wir ein einzelnes Statement. Es besteht aus einer einfachen Anweisung, welche den Text "Hello, world!" auf die Kommandozeile ausgibt.
Die statische Methode _println()_ auf dem öffentlich zugänglichen _Feld_ der Klasse _System_ dient dazu Text auf der Konsole auszugeben. Das Statement wird mit einem Semikolon abgeschlossen.


![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 1](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-1---ausgaben-auf-die-kommandozeile) in den Labs.