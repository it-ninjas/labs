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
- Ich kenne den ternären (ternary) Operator

{{< zeit lesen="15" >}}

## Einführung

Kontrollstrukturen steuern den Ablauf eines Programms. Sie ermöglichen es, bestimmte Codeabschnitte nur unter bestimmten Bedingungen auszuführen (→ bedingte Anweisungen) oder mehrfach zu wiederholen (→ Schleifen).

---

## Bedingte Anweisungen

Eine bedingte Anweisung ist eine Konstruktion, mit der ein Programm – abhängig vom Wahrheitswert eines booleschen Ausdrucks – unterschiedliche Wege gehen kann.

{{< ninja tip >}}
Eine _Anweisung_ ist z. B. `System.out.println(...)`. Ein _Anweisungsblock_ ist ein Codeblock mit `{ ... }`, der mehrere Anweisungen enthalten kann.
{{< /ninja >}}

### If-Statement

```java
if (expression) {
    // do something
}
```

Ist der Ausdruck `expression` in der Klammer `true`, wird der Codeblock ausgeführt. Andernfalls wird er übersprungen.

### If-Else-Statement

Der obige `if`-Fall kann mit dem Schlüsselwort `else` erweitert werden, um alternative Aktionen auszuführen, wenn der Ausdruck `false` ist:

```java
if (expression) {
    // do something
} else {
    // do something else
}
```

Im folgenden Beispiel gibt das Programm je nach Wert von `num` (gerade oder ungerade) unterschiedlichen Text aus. Da eine
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

### Else-If-Kette

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

{{< ninja warning >}}
Beachte, dass bei einem `if` oder `else-if` alle nachfolgenden `else` oder `else-if` ignoriert werden, wenn die
`expression` wahr ist.

Würde das `else if (dollars < 100_000)` vor dem `else if (dollars < 2000)` kommen, würde es nie eine Ausgabe `Buy a personal computer` geben, da eine Zahl kleiner 2000 immer auch kleiner als 100'000 ist.
{{< /ninja >}}

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/06_control-structures-if/)" >}}

---

{{< video "https://www.youtube.com/watch?v=BBNrEkv_Sw4">}}

---

## Switch-Anweisung

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

Seit Java 12 sind auch die folgenden Schreibweisen möglich:

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

---

## Ternärer (Ternary) Operator

{{< ninja tip >}}
_Ternär_ bedeutet „drei-teilig“. Ein ternärer Operator hat:

1. eine Bedingung,
2. einen Wert, wenn sie `true` ist,
3. einen Wert, wenn sie `false` ist.
   {{< /ninja >}}

Mit dem ternären Operator kannst du kurz und elegant eine Bedingung mit Rückgabe formulieren:

`bedingung ? wertWennTrue : wertWennFalse`

Beispiel:

```java
String tooYoung = "You are too young";
String oldEnough = "You are old enough :)";

int age = 17;
System.out.println(age >= 18 ? oldEnough : tooYoung);
// Output: You are too young

age = 26;
System.out.println(age >= 18 ? oldEnough : tooYoung);
// Output: You are old enough :)
```

### Verschachtelter Ternary Operator:

```java
int years = 12;
String rank = years >= 20 ? "Kage"
            : years >= 10 ? "Chunin"
            : years >= 5  ? "Academy Student"
            : "Candidate";

System.out.println("Your current rank is " + rank);
// Output: Your current rank is Chunin
```

{{< ninja info >}}
Verschachtelte ternäre Operatoren sind schwer lesbar. Wenn du merkst, dass du beim Lesen Mühe hast, verwende lieber eine `if-else`-Struktur.
{{< /ninja >}}

---

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/06_control-structures-switch/)" >}}

---

## Schleifen (Loops)

Mit Schleifen können Anweisungen wiederholt ausgeführt werden.

### While-Schleife

Bei der while-Schleife wird die nachfolgende Anweisung oder der nachfolgende Anweisungs-Block solange ausgeführt, bis
die Bedingung nicht mehr erfüllt ist. Falls die Bedingung bereits vor der ersten Prüfung nicht erfüllt ist, wird die
nachfolgende Anweisung oder der nachfolgende Anweisungs-Block nie ausgeführt.

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

### Do-While-Schleife

Die do-while-Schleife funktionert gleich wie die while-Schleife mit dem Unterschied, das die Anweisung oder der
Anweisungs-Block mindestens einmal ausgeführt wird, bevor die Bedingung überprüft wird.

```java
do {
    // do something
} while (condition);
```

Diese Schleife wird **mindestens einmal** ausgeführt.

### For-Schleife

Bei der for-Schleife wird ein Wert initialisert, die Bedingung überprüft und wenn die Bedingung erfüllt ist, wird die
nachfolgende Anweisung oder der nachfolgende Anweisungs-Block ausgeführt und der Wert kann über Anweisungen modifiziert
werden.

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

Bei diesem Beispiel wird `System.out.print(i + " ");` für alle Zahlen `i` von 0 bis 9 ausgeführt.

### For-Each-Schleife

Wenn du eine Liste oder Array hast, kannst du mit der for-each-Schleife für jedes Element in der Liste oder dem Array
eine Anweisung oder einen Anweisungs-Block ausführen. Was Listen und Arrays sind, wirst du in einen späteren Kapitel
noch kennenlernen.

```java
int[] numbers = { 125, 381, 98, 12, 235 };
for (int number : numbers) {
    System.out.print(number + " ");
}
// Output: 125 381 98 12 235
```

{{< ninja tip >}}
Du kannst eine `for-each`-Schleife verwenden, wenn du **nicht** den Index brauchst, sondern einfach über alle Elemente einer Liste oder eines Arrays gehen willst.
{{< /ninja >}}

---

{{< video "https://www.youtube.com/watch?v=_y5lnzRZeko" "YouTube">}}

---

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/06_control-structures-loops/)" >}}
