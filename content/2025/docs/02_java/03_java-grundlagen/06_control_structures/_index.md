---
title: "Kontrollstrukturen"
linkTitle: "Kontrollstrukturen"
weight: 6
description: >
  In diesem Modul lernst du, wie du mit Kontrollstrukturen wie Bedingungen und Schleifen den Ablauf eines Programms gezielt steuerst.
---

## Ziele

- Ich weiss, was eine bedingte Anweisung ist und kann sie korrekt anwenden.
- Ich kann eine Schleife programmieren: `for`, `foreach`, `while` und `do-while`.
- Ich kenne die `switch`-Anweisung.

{{< zeit lesen="15" >}}

## Kontrollstrukturen

Kontrollstrukturen steuern den Ablauf eines Programms. Sie ermöglichen es, bestimmte Codeabschnitte nur unter bestimmten Bedingungen auszuführen (→ bedingte Anweisungen) oder mehrfach zu wiederholen (→ Schleifen).

---

### Bedingte Anweisungen

Eine bedingte Anweisung ist eine Konstruktion, mit der ein Programm – abhängig vom Wahrheitswert eines booleschen Ausdrucks – unterschiedliche Wege gehen kann.

#### If-Statement

```java
if (expression) {
    // do something
}
```

Ist der Ausdruck `expression` in der Klammer `true`, wird der Codeblock ausgeführt. Andernfalls wird er übersprungen.

#### If-Else-Statement

Der obige `if`-Fall kann mit dem Schlüsselwort `else` erweitert werden, um alternative Aktionen auszuführen, wenn der
Ausdruck `false` ist:

```java
if (expression) {
    // do something
} else {
    // do something else
}
```

Im folgenden Beispiel gibt das Programm je nach Wert von num (gerade oder ungerade) unterschiedlichen Text aus. Da eine
Zahl nur gerade oder ungerade sein kann, wird nur eine der beiden Ausgaben gemacht.

Beispiel:

```java
int num = ...; // the num is initialized by some value
if (num % 2 == 0) {
    System.out.println("It's an even number");
} else {
    System.out.println("It's an odd number");
}
```

#### Else-If-Kette

Ein Else-Statement kann durch ein If-Statement erweitert werden.

```java
if (expression0) {
    // do something
} else if (expression1) {
    // do something else
} else if (expressionN) {
    // do something else
} else {
    // in all other cases: do this
}
```

Beispiel:

```java
long dollars = ...;
if (dollars < 1000) {
    System.out.println("Buy a laptop");
} else if (dollars < 2000) {
    System.out.println("Buy a personal computer");
} else if (dollars < 100_000) {
    System.out.println("Buy a server");
} else {
    System.out.println("Buy a data center or a quantum computer");
}
```

{{< ninja warning>}}
Beachte, dass bei einem `if` oder `else-if` alle nachfolgenden `else` ignoriert werden, wenn die `expression` wahr ist.

Würde das `else if (dollars < 100_000)` vor dem `else if (dollars < 2000)` kommen, würde es nie eine Ausgabe `Buy a personal computer` geben, da eine Zahl kleiner 2000 immer auch kleiner als 100'000 ist (auch bei 1500 würde die Ausgabe `Buy a server` gemacht werden).
{{< /ninja >}}

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/06_Bedingte-Ausführung/)" >}}

{{< video "https://www.youtube.com/watch?v=BBNrEkv_Sw4">}}

---

### Switch-Anweisung

Die `switch`-Anweisung prüft den Wert einer Variablen auf mehrere mögliche Fälle.

```java
switch (variable) {
    case value1:
        // ...
        break;
    case value2:
        // ...
        break;
    default:
        // ...
}
```

Ohne `break` wird in den nächsten Fall „hineingefallen“ (fall-through). Der `default`-Fall wird ausgeführt, wenn kein anderer Fall zutrifft.

Seit Java 12:

```java
switch (value) {
    case "happy" -> System.out.println("Keep smiling.");
    case "sad" -> System.out.println("Don't be sad!");
    default -> System.out.println("Unknown mood");
}
```

Switch mit Rückgabe:

```java
int place = 1;

String suffix = switch (place) {
    case 1 -> "st";
    case 2 -> "nd";
    case 3 -> "rd";
    default -> "th";
};

System.out.println("You're on the " + place + suffix + " place.");
```

{{< todo >}}
Lab konvertieren: Aufgabe 2b zum Switch-Statement  
../../../../../labs/02_java/03_java-grundlagen/#aufgabe-2b---das-switch-statement
{{< /todo >}}

---

### Schleifen (Loops)

Mit Schleifen können Anweisungen wiederholt ausgeführt werden.

#### While-Schleife

```java
while (condition) {
    // do something
}
```

Beispiel:

```java
int i = 0;
while (i < 5) {
    System.out.print(i + " ");
    i++;
}
// Output: 0 1 2 3 4
```

#### Do-While-Schleife

```java
do {
    // do something
} while (condition);
```

Diese Schleife wird **mindestens einmal** ausgeführt.

#### For-Schleife

```java
for (initialization; condition; modification) {
    // do something
}
```

Beispiel:

```java
int n = 9;
for (int i = 0; i <= n; i++) {
    System.out.print(i + " ");
}
// Output: 0 1 2 3 4 5 6 7 8 9
```

Summe von 1 bis 10:

```java
int sum = 0;
for (int i = 1; i < 11; i++) {
    sum += i;
}
System.out.println(sum); // Output: 55
```

#### For-Each-Schleife

```java
int[] numbers = { 125, 381, 98, 12, 235 };
for (int number : numbers) {
    System.out.print(number + " ");
}
// Output: 125 381 98 12 235
```

---

#### Lernvideo

[Video zu Schleifen (YouTube)](https://www.youtube.com/watch?v=_y5lnzRZeko)

{{< todo >}}
Lab konvertieren: Aufgabe 3  
../../../../labs/02_java/03_java-grundlagen/#aufgabe-3---loops
{{< /todo >}}
