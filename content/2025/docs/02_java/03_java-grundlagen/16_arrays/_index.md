---
title: "Arrays"
linkTitle: "Arrays"
weight: 16
description: >
  In diesem Modul lernst du, wie man Arrays in Java verwendet, durchläuft und Daten darin speichert oder daraus liest.
---

{{< module "J1" >}}

## Ziele

- Ich weiss, was ein Array ist und wozu es verwendet wird.
- Ich kann Arrays deklarieren, instantiieren und initialisieren.
- Ich kann Werte aus Arrays lesen und in Arrays schreiben.
- Ich kenne den Unterschied zwischen `for` und `foreach` beim Durchlaufen eines Arrays.
- Ich kann aus einem `String` mit `.split(...)` ein Array erzeugen.
- Ich weiss, wie ein zweidimensionales Array aufgebaut ist und wie man damit arbeitet.

{{< zeit lesen="15" >}}

## Einführung

Oft müssen in einem Programm mehrere Werte desselben Datentyps zusammen gespeichert werden.  
Anstatt für jeden Wert eine eigene Variable zu erstellen, kann man **Arrays** verwenden.

Ein Array ist eine feste Sammlung von Elementen, die alle denselben Datentyp haben und über einen **Index** angesprochen
werden. Die Länge eines Arrays wird einmal bei der Erstellung festgelegt.

## Deklaration und Initialisierung

Ein Array wird in zwei Schritten erstellt:

1. **Deklaration** – Festlegen des Datentyps und Namens
2. **Initialisierung** – Erstellen des Array-Objekts und Festlegen der Länge

Die Deklaration eines Arrays enthält folgende Bestandteile:
| Reihenfolge | Bedeutung | Beispiel |
| ----------- | ------------------- | ----------------------------------------- |
| 1. | Typ | `String, int, double, char, ...` |
| 2. | Eckige Klammern | `[]` |
| 3. | Bezeichner / Namen | `words, numbers, values, letters...` |

In Java müssen wir zum Zeitpunkt der Deklaration eines Arrays folgendes angeben:

- den Datentyp
- den Namen

Konkret können wir so ein `String`-Array deklarieren:

```java
// Deklaration
String[] words;
```

Zum Zeitpunkt der Initialisierung müssen wir folgendes angeben:

- die Grösse

Das Code-Beispiel von der "Deklaration" deklariert die Variable _words_, erstellt das Array-Objekt jedoch noch nicht.
Der Operator _new_ wird in Java zum Erstellen von neuen Objekten verwendet:

```java
String[] words = new String[5];
```

Damit wird ein Array-Objekt der Länge 5 (also mit 5 Elementen) instantiiert. Die fünf Elemente dieses Arrays wurden mit
Standardwerten initialisiert. Bei einem Array des Datentyps `String` ist der Default-Wert `null`. Alle Werte im Array
werden also mit `null` aufgefüllt.

Wir können die Werte der Array-Elemente auch gleich direkt angeben:

```java
String[] words = { "Hai", "Oktopus", "Rochen", "Wal", "Fisch" };
```

Es wird damit ein Array mit der Grösse 5 und den angegebenen Werten erstellt.

### Länge eines Arrays

Die Anzahl der Elemente in einem Array wird als Länge eines Arrays bezeichnet. Diese Länge wird zum Zeitpunkt der
Erstellung eines Arrays einmal festgelegt. Sie kann später in einem Programm nur durch Definition eines neuen Arrays und
dem Kopieren von Werten geändert werden.

Wir können die Länge eines Arrays mithilfe einer in Java integrierten Funktionalität überprüfen:

```java
System.out.println("Anzahl Elemente: " + words.length);
```

## Indizierung

Die Indizes in einem Array reichen immer von `0` bis `length-1`. Ein Array mit den ersten 100 natürlichen Zahlen hat
beispielsweise eine Länge von 100 und Indizes von 0 bis 99.

```java
System.out.println(words[0]); // Erstes Element -> "Hai"
System.out.println(words[words.length - 1]); // Letztes Element -> "Fisch"
```

{{< ninja warning>}}
Das ist eine häufige Fehlerquelle bei Programmen. Es passiert einem immer wieder, dass man für das letzte Element im
Array als Index die Länge des Arrays nimmt. Das führt dann zu einer ArrayIndexOutOfBoundsException, welche erst zur
Laufzeit auftritt.
{{< /ninja>}}

## Werte schreiben

Wenn wir den Wert eines Elements in unserem Array verändern möchten, geschieht dies folgendermassen:

```java
words[index] = value;
```

Wenn du also das 4. Element (Index 3) mit dem Wert `"Delfin"` ersetzen möchtest, dann kannst du das wie folgt tun:

```java
// Aktueller Wert
System.out.println(words[3]); // Ausgabe: Wal

// Wert ändern
words[3] = "Delfin";

// Wert lesen
String word = words[3];
System.out.println(word); // Ausgabe: Delfin
```

## Arrays durchlaufen

Im Modul [Kontrollstrukturen](../06_control_structures/) hast du bereits die `for`-Schleife kennengelernt. Mit dieser
kannst du mit einem index durch das ganze Array iterieren:

```java
for (int i = 0; i < words.length; i++) {
    System.out.println("Tier: " + words[i]);
}
```

Für Arrays gibt es aber auch noch die `foreach`-Schleife, welche kürzer und direkter ist:

```java
for (String word : words) {
    System.out.println("Tier: " + animal);
}
```

{{< ninja tip>}}
`foreach` eignet sich besonders gut, wenn du alle Elemente durchgehen möchtest und den Index nicht benötigst.
{{< /ninja >}}

{{< video "https://www.youtube.com/watch?v=SRJZ1XmqHfA" "Theoretische Erklärung" >}}
{{< video "https://www.youtube.com/watch?v=lfIUilgq4qo" "Anwendung in Java" >}}

## Arrays und Strings

Du hast [Strings](../13_strings/) im letzten Module kennengelernt. Zwei nützliche Methode welche Strings bietet haben
wir dort noch nicht behandelt, weil sie Kentnisse über Arrays voraussetzen.

### Strings in Arrays umwandeln – `.split(...)`

Mit `.split(...)` können Strings in Arrays aufgeteilt werden:

```java
String text = "Apfel,Birne,Kirsche";
String[] words = text.split(",");

for (String word : words) {
    System.out.println("Frucht: " + word);
}
```

**Ablauf:**

1. Der String `"Apfel,Birne,Kirsche"` wird beim Komma getrennt.
2. Es entsteht ein Array mit drei Elementen.
3. Das Array wird mit `foreach` ausgegeben.

Anzufügen ist noch, dass es sich beim Suchbegriff um eine sogenannten ["Regulären Ausdruck" (RegEx)](../14_regex/)
handelt.

## Arrays in Strings umwandeln - `String.join(...)`

Mit `String.join(...)` kann man aus einem Array einen String erzeugen.

```java
String[] words = {"Apfel", "Birne", "Kirsche"};
String text = String.join(",", words);

System.out.println("Früchte: " + text); // Ausgabe: "Früchte: Apfel,Birne,Kirsche"
```

## Zweidimensionale Arrays

is jetzt hast du ausschliesslich Arrays gesehen, die auf eine Dimension beschränkt waren. Diese Arrays sind praktisch,
um Listen-Artige Daten zu speichern. Zweidimensionale Arrays haben wie es der Name schon verrät eine zweite Dimension.
Diese Art von Arrays sind praktisch für tabellarische Daten.

Du kannst dir ein 2D-Array wie eine Excel vorstellen. Es besteht aus Reihen und Spalten die gleich wie im normalen Array
mit einem Index/einer Position definiert werden.

Für die Deklaration eines zweidimensionalen Arrays wird eine Angabe von der Anzahl Reihen und Spalten benötigt.
Bei dieser Art von Array können die gleichen Datentypen wie bei den normalen Arrays verwendet werden. So sieht
schliesslich die Syntax aus:

```java
int rows = 3;
int cols = 2;
int[][] matrix = new int[rows][cols];
```

Da wir jetzt im zweidimensionalen Bereich unterwegs sind, müssen wir für den Zugriff auf Elemente beide Dimensionen
beachten. Das bedeutet, dass wir anders als bei einfachen Arrays 2 verschiedene indexe angeben müssen.

Hier ein Beispiel dazu:

```java
matrix[0][1] = 42;
System.out.println(matrix[0][1]); // Ausgabe: 42
```

### Durchlaufen mit verschachtelten Schleifen

Um auf alle Elemente im zweidimensionalen Array zuzugreifen, müssen wir eine verschachtelte `for`-Schleife verwenden:

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.println();
}
```

Du kannst aber auch eine verschachtelte `foreach`-Schleife verwenden:

```java
foreach (int[] row: matrix) {
    for (int value: row) {
        System.out.print(value + "\t");
    }
    System.out.println();
}
```

{{< video "https://www.youtube.com/watch?v=R0YzQPBusAg" >}}

---

{{< todo >}}
Labs konvertieren:

Aufgabe 9  
../../../../labs/02_java/03_java-grundlagen/#aufgabe-9---arrays
{{< /todo >}}
