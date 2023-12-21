---
title: "Variablen in Java"
linkTitle: "Variablen"
weight: 2
description: >
  Modul #J1
---

## Ziele

- Ich weiss, was Variablen sind.
- Ich kann eine Variable deklarieren und initialisieren.

## Variablen

Auf der letzten Seite hast du ein kleines "Hello World" geschrieben, welches den Text "Hello, world!" in der Konsole ausschreibt. Stelle sicher, dass dieses Programm bei dir auch läuft.

Ändere dann den Code leicht ab in diesen und führe ihn aus:

```java
public class HelloWorld {
    public static void main(String[] args) {
        var nachricht = "Hello, world!";

        System.out.println(nachricht);
    }
}
```

In diesem Beispiel haben wir den Text, den wir ausgeben wollen ("Hello, world!"), in eine sogenannte "_Variable_" mit dem Namen `nachricht` ausgelagert:

```java
var nachricht = "Hello, world!";
```

Aber was macht dieser Code?

- Mit dem Keyword `var` teilen wir mit, dass wir eine neue Variable definieren.
- Mit `var nachricht` deklarieren wir eine neue Variable mit dem Namen `nachricht`.
- Mit dem `=`-Operator teilen wir mit, dass wir der Variable den Wert von der rechten Seite zuweisen möchten. Die Variable `nachricht` wird dann also den Wert `"Hello, world!"` enthalten.
- Mit dem Semikolon (";") teilen wir mit, dass diese Anweisung (also die Zuweisung der Variable) abgeschlossen ist.

Aber was genau bringt mir das jetzt?

>     Variablen werden dazu verwendet, um Werte zu speichern und später ein- oder mehrmals darauf zuzugreifen.

Möchtest du beispielsweise diesen Text 5 mal ausgeben, dann könntest du das wie folgt tun:

```java
public class HelloWorld {
    public static void main(String[] args) {
        var nachricht = "Hello, world!";

        System.out.println(nachricht);
        System.out.println(nachricht);
        System.out.println(nachricht);
        System.out.println(nachricht);
        System.out.println(nachricht);
    }
}
```

### Deklaration

Bevor eine Variable verwendet werden kann, muss das Programm diese Variable kennen. Dies tust du, indem du sie "deklarierst".
Unter der Deklaration einer Variable versteht man das erste "Erwähnen" einer Variable. In Java bedeutet dies, dass der Typ der Variable festgelegt wird.

Formal gilt:

```
<Typ-der-Variable> <Variablen-Name>;
```

Wir geben also den Datentyp und den Namen der Variable an.

Im vorherigen Beispiel hatten wir eine Variable so definiert:

```java
var nachricht = "Hello, world!";
```

Das Keyword `var` ist ein neueres Feature von Java, das den Typ erratet. Normalerweise gibt man stattdessen den Typ der Variable an:

```java
String nachricht;
```

Bei der Variable `nachricht` ist also `String` der Typ. `String` bedeutet, dass es sich hierbei um einen _Text_ - also eine "_Zeichenkette_" - handelt.

Der Wert selbst muss bei der Deklaration nicht zwingend festgelegt werden. Zur _Laufzeit_ (also wenn das Programm läuft) wird dann für die Variable einen Bereich im Arbeitsspeicher (RAM) reserviert. Hier werden später die Werte, die der Variablen zugewiesen werden, gespeichert. Die Grösse des Speicherbereichs hängt vom Typ der Variable ab.

### Initialisierung

Unter dem Begriff Initialisierung wird die direkte Zuweisen eines Wertes bei der Deklaration einer Variablen verstanden.
Lokale Variablen (Variablen, die lediglich innerhalb einer Methode gültig sind) müssen initialisiert werden, bevor sie verwendet werden können.

Formal wird wie folgt eine Variable initialisiert (inkl. Deklaration):

```java
<Typ-der-Variable> <Variablen-Name> = <Wert-der-Variable>;
```

Hier ein kleines Beispiel, in welchem der Variable `number` den Wert 3 zuweisen und ausgeben:

```java
public static void main(String[] args) {
	int number = 3;
  System.out.println(number);
}
```

Nachfolgend ein Beispiel, in welchem versucht wird, zwei Zahlen zu addieren. Der erste Summand `firstSummand` hat den Wert `1`, beim zweiten Summand `secondSummand` wird kein Wert zugewiesen:

```java
public static void main(String[] args) {
	int firstSummand = 1;
	int secondSummand;
	int sum = firstSummand + secondSummand;
	System.out.println(sum);
}
```

Weil die Variable **secondSummand** nicht initialisiert wurde, kann die Zuweisung **int sum = firstSummand + secondSummand** folglich nicht funktionieren. Deswegen führt dieser Code zu dieser Fehlermeldung:

```
error: variable secondSummand might not have been initialized.
```

Um dieses Problem zu lösen, muss die Variable `secondSummand` initialisiert (also einen Wert zugewiesen) werden:

```java
public static void main(String[] args) {
	int firstSummand = 1;
	int secondSummand = 2;
	int sum = firstSummand + secondSummand;
	System.out.println(sum);
}
```

#### Deklaration mit Initialisierung

Wir können eine Variable nacheinander deklarieren und dann initialisieren oder beides zusammen:

```java
int number;     // 1. Deklaration
number = 2;     // 2. Initialisierung

int number = 2; // beides in einer Zeile
```

### Namensgebung

Variablen dienen dazu, Werte zu speichern. Zur Benennung von Variablen gibt es vier Regeln:

- Variablennamen beginnen mit einem Kleinbuchstaben.
- Ein Variablenname darf die Buchstaben A-Z und a-z enthalten.
- Ein Variablenname darf beliebige Zahlen von 0-9 enthalten, nicht aber am Anfang.
- Ein Variablenname darf die Sonderzeichen $ und \_ enthalten.

Der Name einer Variable sollte so gewählt werden, dass klar ist, welcher Wert darin gespeichert wird. Als Beispiel wählen wir den Namen _sum_ für eine Variable, welche das Resultat einer Addition enthält.

### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=8YI0etAGQGA). Relevant sind nur die Themen bis 4:25.
