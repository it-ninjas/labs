---
title: "Streams Basics"
linkTitle: "Streams"
weight: 3
description: >
  Modul #J2
---

## Ziele
* Ich kann in eigenen Worten skizzieren, was Streams sind und wofür sie verwendet werden.
* Ich kann Streams für die Iteration über Listen anwenden.
* Ich kann mindestens eine intermediäre und eine terminale Stream-Operation aus dem Kopf nennen und beschreiben.

---

## Streams
Mit Java 8 ist das Stream-API zum `java.util`-Package des JDKs hinzugekommen.
Das API ist eine Erweiterung des Java-Collection-Frameworks mit einer Schnittstelle im Stil der funktionalen Programmierung.
Mit dem Stream-API wurden mächtige Möglichkeiten zur Durchführung von Operationen auf `Array`s und `List`en eingeführt.

In diesem Teil wird erklärt, was `Stream`s sind und wie sie für Operationen auf Arrays und Listen eingesetzt werden können.

### Was ist ein Stream?
Streams stellen Ströme von Referenzen dar, die es erlauben, 
verkettete Operationen auf diesen Referenzen nacheinander oder parallel auszuführen.

Ein Stream erhält seinen Input aus Datenstrukturen wie 
Arrays oder Listen und führt die gewünschte Operationen auf diesem Input aus,
ohne die ursprüngliche Datenstruktur zu verändern.

Nachfolgend ist ein Code aufgelistet, der aus einem Array mit den verschiedenen Punktzahlen von verschiedenen Studierenden aus
einer Prüfung
1. alle Punktzahlen aussortiert, die `0` oder kleiner sind (_Intermediäre Operation_ `filter(...)`),
2. dann die Punktzahlen in Noten umrechnet (_Intermediäre Operation_ `mapToDouble(...)`),
3. und dann den Durchschnitt über alle Studierenden berechnet (_Terminale Operation_ `average()`, zu Deutsch "Durchschnitt").

```java
import java.util.Arrays;


int[] scores = new int[] { 4, 19, 22, 23, 0, 12 };
int maxScores = 24;

var averageGrade = Arrays.stream(scores)
        .filter(score -> score > 0)
        .mapToDouble(score -> score * 5.0 / maxScores + 1.0)
        .average();

System.out.println("Average: " + averageGrade.getAsDouble());
```

Die einzelnen Bestandteile werden in den weiteren Unterkapitel genauer beleuchtet und die sogenannten Lambda-Ausdrücke `score -> score > 0` und `score -> score * 5f / maxScores + 1f` werden später erläutert.

### Erzeugung von Streams
Damit überhaupt mit Streams gearbeitet werden kann, muss zuerst ein Stream existieren bzw. erzeugt werden. Streams können aus Arrays, Listen und anderen Collections erzeugt werden.

#### Erzeugung aus Elementes eines Arrays
Aus den Elementen eines Arrays kann ein Stream mithilfe der Klasse `Arrays` aus dem `java.util`-Package wie folgt erzeugt werden:
```java
int[] numbers = {1, 2, 3, 4};
IntStream numbersStream = Arrays.stream(numbers); // IntStream ist eine Spezialisierung von Stream, welche die Verabeitung von primitive int-Werte ermöglicht.

String[] greeting = {"Hello", "Streams"};
Stream<String> greetingStream = Arrays.stream(greeting); // Anhand der spitzigen Klammern wird ersichtlich, welche Objekttypen durch den Stream verarbeitet werden.
```

#### Erzeugung aus Elementen einer Liste
Wenn eine Liste bereits vorhanden ist, kann die Methode `stream()` aufgerufen werden, um einen Stream 
aus den Elementen der Liste zu erzeugen:
```java
List<String> stringList = new ArrayList<>();
stringList.add("Hello");
stringList.add("List");
stringList.add("Stream");

Stream<String> stream2 = stringList.stream();
```

#### Unterschied zwischen generischen Streams und IntStreams
Mit der Methode `Arrays.stream(T[] array)` bekommst du aus einem Array von einem bestimmten Typ `T` ein Stream vom Typ `Stream<T>` - wobei `T` für irgendeine Klasse wie `String` stehen kann.

Ausnahmen gibt es aber für Zahlen:
* ein `int`-Array resultiert in einem `IntStream`,
* ein `double`-Array in einem `DoubleStream`, usw.

An dieser Stelle könnte man sich fragen wieso. Aber die Antwort ist ziemlich klar:

Ein `IntStream` besitzt mehr Methoden als ein `Stream<Integer>`. So kannst du auf dem Stream z.B. direkt eine Summe (`.sum()`) oder Durchschnitt (`.average()`) berechnen, statt selbst diese Funktionen zu implementieren.

Hast du z.B. ein `Stream<Integer>` und möchtest aber eine Summe berechnen, dann kannst du z.B. den `Stream<Integer>` mit der Methode `mapToInt(...)` in einen `IntStream` umwandeln:

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

IntStream intStream = integerStream.mapToInt(Integer::intValue); 

int summe = intStream.sum();
System.out.println("Summe der Zahlen 1 bis 5: " + summe);
```

Lasse dich von der "_Methodenreferenz_" `Integer::intValue` nicht verwirren - wird in einem der nächsten Unterkapitel erklärt. Diese wird hier angegeben, damit beim Stream klar ist, wie jeder einzelne `Integer` in einen `int` umgewandelt wird. In diesem Fall wird ein `Integer integer` wie folgt umgewandelt: `int neuerWert = integer.intValue()`.

### Lambda Expressions
Streams arbeiten mit sog. Lambda-Expressions oder Methodenreferenzen.
Lambda Expressions (Lambda-Ausdrücke) wurden in Java 8 eingeführt, damit Funktionen als Argumente bei Methoden übergeben werden können.

Da Lambda-Expressions oft in Streams verwendet werden, wird hier aufgezeigt, wie Lambdas aussehen und wie sie verwendet werden können.

Lambda-Ausdrücke in Java sind quasi Methoden ohne Namen. Sie bestehen aus folgenden Elementen:
- einer Liste von Parametern. Mehrere Parameter werden durch ein Komma separiert und mit Klammern umrundet.
(keine Parameter werden mit leeren Klammern `()` dargestellt, einen Parameter muss nicht zwingend mit Klammern umrundet werden)
- einem Pfeil-Token `->`
- und einem Funktionsrumpf. Wenn der Funktionsrumpf mehrere Anweisungen lang ist, wird er mit geschweiften Klammern `{ ... }` umrundet. Wenn keine geschweiften Klammern verwendet werden, dann ist der Ausdruck nach dem Pfeil-Token automatisch der Rückgabewert der Funktion (das `return` entfällt).

![Lambda Expressions](../lambda-expression.jpg "Lambda-Expressions")

Im Gegensatz zu Methoden werden der Rückgabetyp und Exceptions nicht spezifiziert, sondern vom Compiler "erraten".

Im Beispiel mit den Prüfungsnoten haben wir mit `.mapToDouble(score -> score * 5.0 / maxScores + 1.0)` die einzelnen Punktzahlen in Noten umgerechnet (`map()`-Methoden werden später erklärt). Hierbei wurde der Lambda-Ausdruck `score -> score * 5.0 / maxScores + 1.0` verwendet. Dieser Lambda-Ausdruck ist eine Funktion (Methode), die beschreibt, wie jede Punktzahl in eine Note umgerechnet werden soll. Würden wir diesen Lambda-Ausdruck in eine Methode umschreiben, dann könnte diese so aussehen:

```java
private static double punkteZuNote(int score) {
    return score * 5.0 / maxScores + 1.0;
}
```

Der Lambda-Ausdruck `score -> score > 0` hingegen könnte als Methode so geschrieben werden:
```java
private static boolean isScoreGreaterThan0(int score) {
    return score > 0;
}
```

**Beispiele**

Hier noch ein paar Beispiele, wie Lambda-Ausdrücke geschrieben werden können:

```java
// keine Parameter
() -> System.out.println("Ich habe kein Parameter")

// ein Parameter
word -> System.out.printf("Ich habe einen Parameter erhalten, nämlich: %s", word)

// zwei oder mehr Parameter
(name, age) -> System.out.println("My name is " + name + " and I am " + age + "years old")

// Funktionsrumpf mehrzeilig
(name, age) -> {
  System.out.println("My name is " + name);
  System.out.println("I am " + age + "years old");
}
```

### Method Reference
Eine Methoden-Referenz ist die verkürzte Schreibweise einer Lambda-Expression, welche nur einen einzigen Methodenaufruf beinhaltet.
Die generische Syntax für Methodenreferenz sieht wie folgt aus: Klasse::methode.
Bei Methoden-Referenzen werden die Argumente für die Methode nicht notiert.

```java
// Lambda-Expression mit einem Methodenaufruf
(word) -> System.out.println(word)

// Method-Reference Syntax der obigen Lambda-Expression
// Das Argument (word) muss nicht mitgegeben werden
System.out::println
```

Der wesentliche Vorteil von dieser Schreibweise ist, dass er kürzer ist. Lambda-Ausdrücke sind aber oft einfacher zu verstehen.

## Methodenausführung auf Streams
Im Beispiel mit den Prüfungsnoten haben wir verschiedene Operationen auf dem Stream durchgeführt, die die einzelnen Werte entweder umrechnen oder am Schluss in einem einzigen Wert zusammenfasst (z.B. `average()`).
Folglich stellen Streams Operationen zur Verfügung, welche in zwei Kategorien unterteilt werden können:
- _Intermediäre Operationen_, welche am Ende der Verarbeitung in einem Stream resultieren (und somit eine weitere, verkettete Verarbeitung ermöglichen) wie z.B. `filter(...)` oder `map(...)`.
- _Terminale Operationen_, welche am Ende der Verarbeitung einen Wert zurückliefern (und somit den Stream beenden) wie `sum()` oder `average()`.

Folgendes Bild illustriert die Arbeitsweise von Streams
![Java Streams](../Streams.png "Java Streams")

Nun werden einige Operationen auf Streams vorgestellt:
* Intermediäre Operationen:
    * `filter(...)` sortiert alle Elemente aus, die NICHT die übergebenen Bedingung erfüllen.
    * `map(...)`, `mapToInt(...)` und `mapToDouble(...)` wandeln die einzelnen Stream-Elemente in andere Werte um (bilden diese ab auf andere).
    * `sorted()` sortiert die einzelnen Werte.
* Terminale Operationen:
    * Mit `forEach(...)` kann für jedes Element etwas gemacht werden (wie jedes Element ausgeben).
    * `collect(...)` und `toArray(...)` füllen die einzelnen Elemente in Listen oder Arrays ab.

### Intermediäre Operationen
#### Die `filter(...)`-Methode
Die `filter(...)`-Methode ist eine intermediäre Operation, die Elemente in einem Stream auf diejenigen beschränkt, die einer bestimmten Bedingung entsprechen. Diese Bedingung wird als Lambda-Ausdruck ausgedrückt, der `true` zurückgibt, wenn das Element im Stream bleiben soll. Gibt er `false` zurück, wird das Element aussortiert.

Im folgenden Beispiel werden alle ungeraden Zahlen aus einem Stream entfernt und dann alle verbleibenden Elemente ausgegeben:
```java
IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15)
        .filter(x -> x % 2 == 0)
        .forEach(System.out::println);
```

#### Die `map(...)`- und `mapToInt(...)`-Methode
Die `map(...)`- und `mapToInt(...)`-Methode gehört zu den intermediären Operationen eines Streams.

Die Methode liefert einen Stream zurück, worin jedes einzelne Element durch den Rückgabewert der übergebenen Funktion ersetzt wurde.

Die `map(...)`-Methode wird oft verwendet, um Daten umzuwandeln oder den Stream auf ein Feld/Methode eines Objekts zu fokussieren.

Hier ein Beispiel, in welchem Zahlen durch ihr Quadrat ersetzt werden:

```java
Stream.of(1,2,3,4).map(x -> x * x).forEach(System.out::println);
```

Und hier ein Beispiel, wo uns nur die Länge der Strings interessiert:

```java
Stream.of("Ein", "Ninja", "bewegt", "sich", "lautlos", "wie", "der", "Wind", "und", "unsichtbar", "wie", "der", "Schatten")
                .map(word -> word.length())
                .forEach(System.out::println);
```

Im zweiten Beispiel könnte unser Ziel sein, die durchschnittliche Länge der Wörter zu berechnen. Wenn man mathematische Operationen mit Streams durchführen möchte, dann ist es oft einfacher, den Stream in einen für den mathematischen Typ spezifischen Stream wie `IntStream` zu "verwandeln", damit Funktionen wie `sum()` und `average()` (Durchschnitt) nicht manuell implementiert werden müssen. Hierfür kannst du statt der `map(...)`- die `mapToInt(...)`-Methode (oder `mapToDouble` und `mapToSingle`) verwenden:

```java
System.out.println(
        "Durchschnittliche Länge eines Wortes: " +


        Stream.of("Ein", "Ninja", "bewegt", "sich", "lautlos", "wie", "der", "Wind", "und", "unsichtbar", "wie", "der", "Schatten")
                .mapToInt(word -> word.length())
                .average()
);
```

#### Die sorted() Methode
Die `sorted()`-Methode gehört zu den intermediären Operationen eines Streams.

Die Methode liefert ein Stream zurück, worin die Elemente im Stream nach ihrer natürlichen Reihenfolge (natural order) sortiert sind.

Die Syntax der Methode ist wie folgt: `Stream<T> sorted()`
wobei `T` der Typ der Elemente innerhalb des Streams ist

**Beispiel mit einem Array**

```java
// Erstelle ein Array mit Strings
String[] greeting = {"C", "A", "B"};

// Sortiere die Strings nach ihrer natürlichen Reihenfolge (alphabetisch) und 
// gib die sortierten Elementen in der Console wieder aus
Arrays.stream(greeting)
      .sorted()
      .forEach(System.out::println);
```

**Beispiel mit einer Liste**

```java
// Erstelle eine Liste mit Zahlen
List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

// Sortiere die Zahlen nach ihrer natürlichen Reihenfolge (numerisch sortiert) und 
// gib die sortierten Elementen in der Console wieder aus
list.stream()
    .sorted()
    .forEach(System.out::println);
```

### Terminale Operationen
#### Die forEach() Methode
Die *forEach(Consumer action)* Methode gehört zu den terminalen Operationen eines Streams.

Der Parameter `action` ist vom Typ `Consumer` (ist ein `FunctionalInterface`). Dieser Typ repräsentiert eine Operation (eine Funktion),
welche nur ein einziges Input-Argument akzeptiert und keine Ergebnisse (also `void`) zurückliefert. 
Ein Beispiel für so ein Consumer ist die Methode `System.out.println(...)`, 
welche maximal ein einziges Objekt als Parameter akzeptiert, dieses Objekt in den Standard-Output ausgibt und `void` (also kein Ergebnis) zurückliefert.
Die Methode `System.out.println` erfüllt also die Bedingungen eines Consumers und kann als Parameter für die `forEach()` Methode verwendet werden

Die `forEach()`-Methode kann als Ersatz für einen `for`-Loop verwendet werden.

**Beispiel mit einem Array**

```java
String[] greeting = {"Hello", "Streams"};

// Hier wid jedes Element des Arrays ausgegeben
for (String word : greeting) {
    System.out.println(word);
}

// Hier wird mithilfe von Streams dasselbe erreicht wie beim for-loop
Arrays.stream(greeting)
      .forEach(word -> System.out.println(word));

// Und nun noch kürzer mit der Method-Reference Syntax der obigen Lambda-Expression
Arrays.stream(greeting)
      .forEach(System.out::println);
```

**Beispiel mit einer Liste**

```java
List<String> greetingList = new ArrayList<>();
greetingList.add("Hello");
greetingList.add("Stream");
greetingList.add("List");

// Einmal mit der vollen Syntax der Lambda-Expression
greetingList.stream().forEach(word -> System.out.println(word));
// Und einmal mit der verkürzte Variante mittels Method-Reference
greetingList.stream().forEach(System.out::println);

// Collection, darunter auch Listen, haben selbst eine forEach Methode, 
// welche die gleiche Ergebnisse liefert, wie diejenige vom Stream-Interface
greetingList.forEach(System.out::println);

```

#### Die `collect()`-Methode
Die `collect(Collector collector)`-Methode ist auch eine terminale Operation auf einem Stream.
Sie ermöglicht es, die Ergebnisse der Bearbeitung des Streams in einer neuen Collection (List, Map usw.) zu speichern.
Dies ist nötig, da bei der Bearbeitung des Streams die ursprüngliche Elemente nicht geändert werden können.

Der Parameter *collector* ist vom Typ [Collector](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collector.html "Collector").
Die Aufgabe eines Collectors besteht darin, mehrere Input-Elemente in einem Result-Container zusammenzufassen.
Zum Beispiel können die Elemente eines Streams in einer Liste "gespeichert" und zurückgeliefert werden.

Um ein Collector zu erzeugen, wird oft die Klasse [Collectors](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Collectors.html "Collectors") aus dem *java.util.stream* Packet verwendet.
Diese beinhaltet mehrere öffentliche, statische Methode um Collectors unterschiedlicher Typen (List, Map usw.) erzeugen zu können.

**Beispiel**

```java
// Erstelle eine Liste von unsortieren Zahlen
List<Integer> unsortedList = Arrays.asList(-9, -18, 0, 25, 4);

// Aus der unstortierte Liste, erstelle eine NEUE, sortierte Liste
List<Integer> sortedList = unsortedList.stream()
                                       .sorted()
                                       .collect(Collectors.toList()); // hier wird aus dem sortierten Stream eine neue Liste erstellt

// gib die unsortierte Liste in der Konsole aus (die Original-Liste wurde nicht verändert!)
unsortedList.forEach(System.out::println);

// gib die sortierte Liste in der Konsole aus
sortedList.forEach(System.out::println);
```

#### Die `toArray(...)`-Methode
Mit der `collect(...)`-Methode kannst du den Stream in eine Liste umwandeln. Wenn du den Stream aber in ein Array umwandeln möchtest, dann hilft dir die `toArray(...)`-Methode:

```java
String[] strings = Stream.of("A", "B", "C")
          // String[]::new muss noch angegeben werden, damit ein String-Array (und nicht ein Object[]) zurückgegeben wird:
          .toArray(String[]::new);


  int[] array = Stream.of(1,2,3,4)
          // Zu einem IntStream umwandeln, weil sonst ein Integer[] statt int[] resultieren müsste:
          .mapToInt(Integer::intValue)
          .toArray();
```

Die `toArray(...)`-Methode ist eine terminale Operation auf einem Stream.


---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 1 - 3](../../../../labs/java/java-lists-and-streams-basics/02_streamexercises) in den Stream-Labs.