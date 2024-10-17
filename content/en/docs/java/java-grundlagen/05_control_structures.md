---
title: "Kontrollstrukturen"
linkTitle: "Kontrollstrukturen"
weight: 5
description: >
  Modul #J1
---

## Ziele

- Ich weiss, was eine bedingte Anweisung ist und kann sie korrekt anwenden.
- Ich kann eine Schleife programmieren: `for`, `foreach`, `while` und `do-while`.
- Ich kenne die `switch`-Anweisung.

## Kontrollstrukturen

Kontrollstrukturen dienen dazu, den Ablauf eines Programms zu steuern.
Damit bietet eine Kontrollstruktur die Möglichkeit, Programmteile nur unter gewissen Bedingungen ( → bedingte Anweisungen) auszuführen oder Programmteile zu wiederholen ( → Schleifen).

### Bedingte Anweisungen

Eine bedingte Anweisung ist eine Konstruktion, mit der ein Programm abhängig vom Wert eines boolschen Ausdrucks (`true` oder `false`) unterschiedliche Wege geht.

#### If-Statement

Die einfachste Form der bedingten Anweisung besteht aus dem Schlüsselwort `if`, einem boolschen Ausdruck und einem Block.

```java
if (expression) {

}
```

Wenn der Ausdruck true ist, werden die Anweisungen im Codeblock ausgeführt. Andernfalls werden sie übersprungen.

#### If-Else Statement

Der obige if-Fall kann mit dem Schlüsselwort `else` erweitert werden, um alternative Aktionen auszuführen, wenn der Ausdruck false ist.

```java
if (expression) {
    // do something
} else {
    // do something else
}
```

Im folgenden Beispiel gibt das Programm je nach Wert von num (gerade oder ungerade) unterschiedlichen Text aus.

```java
int num = ...; 	// the num is initialized by some value
if (num % 2 == 0) {
    System.out.println("It's an even number");
} else {
    System.out.println("It's an odd number");
}
```

Da eine Zahl nur gerade oder ungerade sein kann, wird nur eine der beiden Ausgaben gemacht.

#### Else-If-Statements

Ein Else-Statement kann durch ein If-Statement erweitert werden.

```java
if (expression0) {
    // do something
} else if (expression1) {
    // do something else 1
} else if (expressionN) {
    // do something else N
} else {
    // in all other cases: do this…
}
```

Wenn also der erste Ausdruck false ist, wird der zweite Ausdruck überprüft, usw.

Beispiel:

```java
long dollars = ...; // your budget
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

### Lernvideo

Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=BBNrEkv_Sw4).

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 2a zu den if-else-Bedingungen](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-2a---die-if--und-else-bedingungen) in den Labs.

---

#### Switch-Statement

Die Switch-Anweisung bietet eine Möglichkeit, basierend auf dem Wert einer einzelnen Variablen (kein Ausdruck!) zwischen mehreren Fällen zu wählen. Die Variable kann eine Ganzzahl, ein Zeichen, eine Zeichenfolge oder eine Aufzählung sein.

```java
switch (variable) {
    case value1:
        // do something here
        break;
    case value2:
        // do something here
        break;
        //... other cases
    case valueN:
        // do something here
        break;
    default:
        // do something by default
        break; // it can be omitted
}
```

Die Schlüsselwörter `switch` und `case` werden hier immer benötigt. Die Schlüsselwörter `break` und `default` sind optional. Das Schlüsselwort `break` verlässt die Switch-Anweisung.
Wenn ein Fall nicht über das Keyword `break` verfügt, wird auch der darauffolgende Fall ausgewertet. Dies ist spannend, um die einzelnen Auswertungen verketten zu können. Der Default-Fall wird ausgewertet, wenn kein Fall mit dem Variablenwert übereinstimmt.

Seit Java 12 kann das `switch`-Statement kürzer geschrieben werden, indem statt einem Doppelpunkt der Pfeil-Operator `->` verwendet wird und dadurch die `break`-Zeile entfällt:

```java
String mood = "happy";

switch (mood) {
    case "happy" -> System.out.println("Keep smiling.");
    case "sad" -> System.out.println("Don't be sad!");
    case "angry" -> System.out.println("Take a deep breath!");
    default -> System.out.println("I'm sorry, I don't recognize that mood.");
}
```

Ausserdem ist es nun direkt möglich, eine Variable direkt mittels `switch`-Assignment zuzuweisen:

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

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 2b zum Switch-Statement](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-2b---das-switch-statement) in den Labs.

---

### Schleifen (Loops)

Manchmal müssen wir einen Codeblock für eine bestimmte Anzahl wiederholen. Zu diesem Zweck stellt Java die Schleife bereit. Diese Schleife wird häufig verwendet, um über einen Wertebereich oder durch ein Array zu iterieren. For-Loops arbeiten mit einem Schleifenzähler, welcher sehr gut für Indizes von Arrays verwendet werden kann. Bei allen Schleifen ist Vorsicht geboten, da es rasch zu einer unendlichen Anzahl von Ausführungen kommen kann.

#### While-Loop

Die while- Schleife besteht aus einem Codeblock und einer Bedingung (einem booleschen Ausdruck). Wenn die Bedingung erfüllt ist, wird der Code innerhalb des Blocks ausgeführt. Dieser Code wird solange wiederholt, bis die Bedingung nicht mehr erfüllt ist.

```java
while (condition) {
    // body: do something
}
```

Innerhalb des Schleifenkörpers kann das Programm wiederum alle möglichen Java-Anweisungen ausführen. Es kann sogar andere Schleifen enthalten.

Beispiel: Die folgende Schleife gibt Ganzzahlen aus, während eine Variable kleiner als 5 ist.

```java
int i = 0;

while (i < 5) {
    System.out.print(i + " ");
    i++;
}
// Output: 0 1 2 3 4
```

#### Do-While Loop

Die Do-While-Schleife besteht aus einem Codeblock und einer Bedingung (einem boolschen Ausdruck) am Ende. Im Gegensatz zur While-Schleife wird die Do-While-Schleife mindestens einmal ausgeführt, da die Bedingung am Ende steht.

```java
do {
    // body: do something
} while (condition);
```

#### Lernvideo

Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=0dWbm-vb21Y).

#### For-Loop

```java
for (initialization; condition; modification) {
    // do something
}
```

- Bevor die Schleife beginnt, wird einmal die Initialisierungsanweisung (initialization) ausgeführt. Wir bezeichnen diese Variable als Schleifenvariable. Es sind mehrere Schleifenvariablen erlaubt, sie können durch Kommas getrennt werden.
- Die Bedingung (condition) ist ein boolscher Ausdruck, der die Notwendigkeit der nächsten Iteration bestimmt. Wenn die Auswertung der Bedingung false ist, wird die Schleife beendet – ansonsten folgt eine weitere Iteration
- Die Modifikation ist eine Anweisung, die den Wert der Schleifenvariablen verändert. Sie wird nach jeder Iteration aufgerufen. Normalerweise wird der Wert der Variable inkrementiert oder dekrementiert.

Beispiel:

```java
int n = 9;
for (int i = 0; i <= n; i++) {
    System.out.print(i + " ");
}
// Output: 0 1 2 3 4 5 6 7 8 9
```

Innerhalb des Schleifenkörpers kann das Programm wiederum alle möglichen Java-Anweisungen ausführen. Es kann sogar andere Schleifen enthalten. Wie bei allen Blöcken sind die Schleifenvariablen nur innerhalb des Schleifenkörpers sichtbar.
Die Schleifenvariable wird meistens mit einfachen Variablennamen wie i, j, k oder index benannt.

Hier ist ein weiteres Beispiel. Berechnen wir die Summe der Ganzzahlen von 1 bis 10 mit der for-Schleife.

```java
int startInclude = 1;
int endExclude = 11;
int sum = 0;

for (int i = startInclude; i < endExclude; i++) {
    sum += i; //ist das gleiche wie sum = sum + i
}

System.out.println(sum); // Output: 55
```

#### For-Each Loop

Der For-Each-Loop durchläuft alle Elemente eines Arrays oder einer Collection. Die Angaben aus dem For-Loop werden durch eine Schleifenvariable und ein Doppelpunkt ersetzt. (Arrays lernst du später im Kapitel "Arrays" kennen. Daher ist dieses Beispiel hier nur zur Vollständigkeit aufgelistet - du musst dieses Beispiel hier noch nicht verstehen.)

```java
int[] numbers = { 125, 381, 98, 12, 235 };
for (int number: numbers) {
    System.out.print(number + " ");
}
// Output: 125 381 98 12 235
```

Der gezeigte Loop wird also fünfmal ausgeführt und der Wert der Variable _number_ nimmt bei jedem Durchlauf den jeweils nächsten Wert aus dem Array an.

#### Lernvideo

Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=_y5lnzRZeko).

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 3](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-3---loops) in den Labs.
