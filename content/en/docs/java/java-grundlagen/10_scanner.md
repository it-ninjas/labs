---
title: "Scanner"
linkTitle: "Scanner"
weight: 10
description: >
  Modul #J1
---

## Ziele
* Ich kann eine Eingabe von der Konsole lesen und in einer Variablen speichern.


## Scanner

Eine Möglichkeit, Benutzereingaben in Java vorzunehmen, besteht in der Verwendung der Scanner-Klasse, die verwendet wird, indem zuerst die Definition der Klasse wie in Zeile 1 importiert und dann ein Objekt dieser Klasse wie in Zeile 6 erstellt wird.
```java
import java.util.Scanner;

public class TakeInput {
    public static void main (String[] args) {
	    Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Your name is: " + name);
    }
}
```

**Zeile 1**

Der erste Schritt besteht darin, die Scanner-Klasse zu importieren, damit sie im folgenden Code verwendet werden kann. Die _Java_ Scanner-Klasse stammt aus dem Paket [java.util](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/package-summary.html).
Es ist einfach zu bedienen, muss jedoch importiert werden, damit die Klasse funktioniert.

**Zeile 6**

* Wir deklarieren den Datentyp als _Scanner_ und geben ihm den Bezeichner _scanner_
* Wir weisen der Variable scanner ein neues Objekt zu, welches den System-Eingabestream enthält ([System.in](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html#in))

**Zeile 8**

* Wir deklarieren eine Variable vom Datentyp String mit dem Bezeichner name
* Wir weisen der Variable name das Resultat der Methode _scanner.nextLine()_ zu
* Diese Methode nimmt die Tastatureingabe vom Benutzer auf der Kommandozeile entgegen. Sie wird beendet, wenn der Benutzer die Enter-Taste drückt.

### Zahlen einlesen

Oft möchtest du, dass der Benutzer Zahlen in der Konsole eingeben kann. Hierfür bietet der `Scanner` eine passende Methode an:

```java
System.out.print("Enter an integer: ");
int number = scanner.nextInt();
```

Die `Scanner.nextInt()`-Methode gibt dir die letzte Zahl vor dem Enter und nach dem letzten Leerzeichen zurück.

Wie du es bereits an der mühsamen Formulierung des letzten Satzes siehst, hat diese Methode komische Eigenheiten. Wenn du z.B. nach dem Aufruf von `nextInt()` wieder `nextLine()` aufrufst, so gibt die zweit genannte Methode sofort einen leeren String zurück, weil das Enter von der Zahl noch nicht konsumiert wurde. Um dieses Problem in Java zu beheben, kannst du `nextLine()` 2 mal hintereinander aufrufen.

Für die Labs und das Exams im Modul #J1 kannst du diese Methode gut brauchen. Spiele aber trotzdem ein bisschen mit dieser `nextInt()`-Methode, damit du die komischen Eigenheiten dieser Methode einmal kennenlernst.

---
![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 8](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-8---eingaben-von-der-kommandozeile) in den Labs.