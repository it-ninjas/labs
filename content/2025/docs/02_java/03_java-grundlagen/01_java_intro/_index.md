---
title: "Struktur und Syntax"
linkTitle: "Struktur und Syntax"
weight: 1
description: >
  In diesem Module lernst du die Struktur kennen, wie ein Java Programm aufgebaut ist.
---

{{< module J1 >}}

## Ziele

- Ich weiss, dass jede Anweisung mit einem Strichpunkt (auch bekannt als Semikolon: `;`) abgeschlossen werden muss.
- Ich weiss, dass geschweifte Klammern einen Block definieren und ich verwende sie in jeder Kontrollstruktur, um die Codeblöcke voneinander abzugrenzen.
- Ich kenne die `main`-Methode und weiss, warum eine Applikation nur EINE main-Methode haben sollte.
- Ich kenne die Methode `System.out.println` und kann sie anwenden.

{{< zeit lesen="10">}}

## Cheatsheet zum Herunterladen

[Core Java Cheatsheet](./resources/cheatsheet.pdf)

---

## Einführung

Als Java-Entwickler/in schreibst du ein Programm in eine Textdatei mit der Erweiterung `.java`. Diese Datei enthält den
Quellcode. Der Compiler (`javac`) wandelt diesen Quellcode in eine `.class`-Datei um, die den Bytecode enthält.
Anschliessend führt die JVM den Bytecode aus. Der Prozess von „Code schreiben“ über „kompilieren“ bis hin zum „ausführen“
sieht einfach aus, doch die eigentliche Arbeit übernimmt die JVM, die den plattformunabhängigen Bytecode ausführt:
![](./images/code-compile-run.png)

{{< ninja info >}}
Wie du im Bild siehst, kann der Java Byte Code auf einem OSX, Linux oder Windows Rechner ausgeführt werden. Das ist der
grosse Vorteil einer platformunabhängigen Programmiersprache. Bei vielen anderen Sprachen wie C oder C++ wandelt der
Compiler den Quellcode zusammen mit platformabhängigen Bibliotheken direkt in Maschinenausführbaren Code um. Dieser Code
wird auch nativer Code bezeichnet und es muss neben der Platform (OSX, Linux, Windows) auch die Architektur des
Prozessors (X86, ARM) bekannt sein.
{{< /ninja >}}

---

## Hello World

Anhand des simplen Hello-World-Programms können wir bereits vieles über die zentralen Bestandteile einer Java-Anwendung erklären. Der folgende Quellcode ist in einer Datei mit dem Namen `HelloWorld.java` abgelegt.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

1. **Klasse definieren**: Der Quellcode beginnt mit der Definition einer Klasse namens `HelloWorld`. Der Name der Klasse muss exakt mit dem Dateinamen übereinstimmen, also wie oben definiert: `HelloWorld.java`. Der Block der Klasse beginnt und endet mit geschweiften Klammern {}.

2. **Die `main`-Methode**: Die main-Methode ist der Startpunkt jedes Java-Programms. Sie wird als Erstes aufgerufen, wenn du dein Programm ausführst. Der Name der Methode ist immer main und ihre Signatur lautet:

   ```java
   public static void main(String[] args){}
   ```

   Dies bedeutet, dass die Methode öffentlich zugänglich (`public`) ist, zur Klasse selbst gehört (`static`) und sie keinen Rückgabewert hat (`void`).

3. **Ausgabe auf die Konsole**: Innerhalb der main-Methode befindet sich die Anweisung `System.out.println("Hello, world!");`. Diese Anweisung gibt den Text „Hello, world!“ in der Konsole aus. Jede Anweisung in Java endet mit einem Semikolon.

Jetzt kennst du die Grundstruktur eines Java-Programms! Probiere es aus, indem du dein erstes Programm schreibst und kompilierst.

{{<aufgabe "../../../../labs/02_java/03_java-grundlagen/01_basicexercises/01_einfaches-hello-world">}}

## Vom einfachen Beispiel zum echten Projekt

Im vorherigen Kapitel hast du ein einfaches Java-Programm geschrieben – eine einzelne Datei mit dem Namen HelloWorld.java. Damit konntest du sehen, wie man ein Java-Programm grundsätzlich startet und ausführt.

Doch sobald Programme grösser werden – mit mehreren Klassen, Tests und Bibliotheken – reicht so ein einzelnes File nicht mehr aus.

Deshalb verwenden wir bei it-ninja von Anfang an ein strukturierteres Projektlayout, wie es auch in der Berufswelt üblich ist. Das klingt auf den ersten Blick vielleicht komplizierter, bringt aber viele Vorteile – vor allem, wenn du später mit modernen Tools und grösseren Projekten arbeitest.

Aber keine Sorge – wir starten jetzt nicht gleich mit viel Theorie oder komplexen Konzepten.
Stattdessen schauen wir uns das Hello World-Beispiel gleich nochmals an – dieses Mal aber in der strukturierten Projektform, wie sie in der Praxis üblich ist.

Dabei wirst du sehen, dass sich gar nicht so viel ändert – aber der Aufbau deutlich mehr Möglichkeiten bietet.
Und danach kannst du direkt mit ein paar kleinen Übungen loslegen, um dich mit dem Aufbau und der Arbeitsweise vertraut zu machen.

{{<aufgaben "../../../../labs/02_java/03_java-grundlagen/01_basicexercises/02_konsole-übungen">}}
