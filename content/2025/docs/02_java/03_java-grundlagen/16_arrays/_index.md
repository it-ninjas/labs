---
title: "Arrays"
linkTitle: "Arrays"
weight: 16
description: >
  Modul #J1
---

{{< todo >}} Muss noch überarbeitet werden... {{< /todo >}}

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

### Lernvideo

Wenn du dir die Erklärung noch mit Videos genauer anschauen möchtest, empfiehlt dir das Praxisbildner-Team diese
Videos: [Theoretische Erklärung](https://www.youtube.com/watch?v=SRJZ1XmqHfA),
[Anwendung in Java](https://www.youtube.com/watch?v=lfIUilgq4qo)

## Zweidimensionale Arrays (2D Array)

Bis jetzt hast du ausschliesslich Arrays gesehen, die auf eine Dimension beschränkt waren. Diese Arrays sind praktisch,
um Listen-Artige Daten zu speichern. Zweidimensionale Arrays haben wie es der Name schon verrät eine zweite Dimension.
Diese Art von Arrays sind praktisch für tabellarische Daten.

Du kannst dir ein 2D-Array wie eine Excel vorstellen. Es besteht aus Reihen und Spalten die gleich wie im normalen Array
mit einem Index/einer Position definiert werden.

### Syntax

Für die Deklaration eines zweidimensionalen Arrays wird eine Angabe von der Anzahl Reihen und Spalten benötigt.
Bei dieser Art von Array können die gleichen Datentypen wie bei den normalen Arrays verwendet werden. So sieht schliesslich
die Syntax aus:

```java
int anzahlReihen = 4;
int anzahlSpalten = 3;

int[][] zweiDArray = new int[anzahlReihen][anzahlSpalten];
```

### Zugriff auf Elemente

Da wir jetzt im zweidimensionalen Bereich unterwegs sind, müssen wir für den Zugriff auf Elemente beide Dimensionen beachten.
Das bedeutet, dass wir anders als bei einfachen Arrays 2 verschiedene indexe angeben müssen. Hier ein Beispiel dazu:

```java
int[][] zweiDArray = new int[4][2];

zweiDArray[0][1] = 69; // Wert 69 zuweisen
int output = zweiDArray[0][1]; // Wert auf position 0 1 in zweiDArray in output variable speichern

System.out.println(output); // Ausgabe: 69
```

### Lernvideo

Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Praxisbildner-Team dieses
[Video](https://www.youtube.com/watch?v=R0YzQPBusAg).

---

{{< todo >}}
Labs konvertieren:

Aufgabe 9
../../../../labs/02_java/03_java-grundlagen/#aufgabe-9---arrays
{{< /todo >}}
