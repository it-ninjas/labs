---
title: "Arrays"
linkTitle: "Arrays"
weight: 10
description: >
  Modul #J1
---

## Ziele

- Ich kenne Arrays und kann diese instantiieren, ihnen Werte von Indexen entnehmen und Werte an Indexe zuweisen.

## Arrays

### Definition

Häufig benötigen Software-Entwickler mehrere zusammengehörige Variablen desselben Datentyps, die logisch oder verwaltungstechnisch zusammengehören. Es wäre aber sehr aufwendig, diese Variablen alle einzeln zu deklarieren und zu verarbeiten. Zudem ist es möglich, dass die Anzahl an Objekten noch unbekannt ist und erst bei der Ausführung des Programms definiert wird. Deswegen wird in Java, wie in anderen Programmiersprachen auch, die Verwendung von Arrays unterstützt. In Arrays lassen sich beliebige primitive Datentypen und Objekte speichern und systematisch bearbeiten. Alle Variablen haben einen gemeinsamen Namen, werden aber über unterschiedliche Indizes angesprochen. Unter `Arrays` kannst du dir so etwas wie eine Liste vorstellen.

### Deklaration

Die Deklaration eines Arrays enthält folgende Bestandteile:
| Reihenfolge | Bedeutung | Beispiel |
| ----------- | ------------------- | ----------------------------------------- |
| 1. | Typ | `String, int, double, char, ...` |
| 2. | Eckige Klammern | `[]` |
| 3. | Bezeichner / Namen | `words, numbers, values, letters...` |

Konkret können wir so ein `String`-Array deklarieren:

```java
String[] words;
```

### Syntax

In Java müssen wir zum Zeitpunkt der Deklaration eines Arrays folgendes angeben:

- den Datentyp
- den Namen

und zum Zeitpunkt der Initialisierung:

- die Grösse

Das Code-Beispiel von der "Deklaration" deklariert die Variable _words_, erstellt das Array-Objekt jedoch noch nicht. Der Operator _new_ wird in Java zum Erstellen von neuen Objekten verwendet:

```java
String[] words = new String[5];
```

Damit wird ein Array-Objekt der Länge 5 (also mit 5 Elementen) instantiiert. Die fünf Elemente dieses Arrays wurden mit Standardwerten initialisiert. Bei einem Array des Datentyps `String` ist der Default-Wert `null`. Alle Werte im Array werden also mit `null` aufgefüllt.

Wir können die Werte der Array-Elemente auch gleich direkt angeben:

```java
String[] words = { "Hai", "Oktopus", "Rochen", "Wal", "Fisch" };
```

Es wird also ein Array mit der Grösse 5 und den angegebenen Werten erstellt.

### Länge eines Arrays

Die Anzahl der Elemente in einem Array wird als Länge eines Arrays bezeichnet. Diese Länge wird zum Zeitpunkt der Erstellung eines Arrays einmal festgelegt. Sie kann später in einem Programm nur durch Definition eines neuen Arrays und dem Kopieren von Werten geändert werden.

Wir können die Länge eines Arrays mithilfe einer in Java integrierten Funktionalität überprüfen:

```java
words.length
```

### Indizierung

Die Indizes in einem Array reichen immer von `0` bis `length-1`. Ein Array mit den ersten 100 natürlichen Zahlen hat beispielsweise eine Länge von 100 und Indizes von 0 bis 99.

### Zugriff auf Elemente

Wenn wir den Wert eines Elements in unserem Array verändern möchten, geschieht dies folgendermassen:

```java
words[index] = value;
```

Wenn du also das 4. Element (Index 3) mit dem Wert `"Delfin"` ersetzen möchtest, dann kannst du das wie folgt tun:

```java
words[index] = "Delfin";
```

Und wenn wir den Wert eines Array-Elements in einer Variablen ausserhalb des Arrays speichern wollen:

```java
String value = words[index];
```

### Durch alle Elemente durchgehen
Im Kapitel der "Kontrollstrukturen" hast du die `for`- und "foreach"-Schlaufe kennengelernt. Beide Schlaufen eignen sich, um ein Array durchzugehen ("iterieren"). Hier ein kleiner Reminder:

```java
System.out.println("Wörter ausgegeben in der for-Schlaufe");
for (int i = 0; i < words.length; i++) {
    System.out.print(words[i] + "\t");
}

System.out.println("\nWörter ausgegeben in der forEach-Schlaufe");
for (String word : words) {
    System.out.print(word + "\t");
}
```

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 8](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-8---arrays) in den Labs.
