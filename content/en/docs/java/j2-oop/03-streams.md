---
title: "Streams Basics"
linkTitle: "Streams"
weight: 3
description: >
  Modul #J2
---

## Ziele
* Ich weiss, was Streams sind.
* Ich kann Streams für die Iteration über Listen anwenden.
* Ich kenne ein paar wichtige Methoden aus dem Stream Interface.

---

## Streams
Mit Java 8 ist das Stream-API zum `java.util`-Package des JDKs hinzugekommen.
Das API ist eine Erweiterung des Java-Collection-Frameworks mit einer Schnittstelle im Stil der funktionalen Programmierung.
Mit dem Stream-API wurden mächtige Möglichkeiten zur Durchführung von Operationen auf `Array`s und `List`en eingeführt.

In diesem Teil wird erklärt, was `Stream`s sind und wie sie für Operationen auf Arrays und Listen eingesetzt werden können.

### Was ist ein Stream?
Streams des Interface `java.util.stream.Stream<T>` stellen Ströme von Referenzen dar, die es erlauben, 
verkettete Operationen auf diesen Referenzen nacheinander oder parallel auszuführen.
Die Daten, die durch die Referenzen repräsentiert werden, werden durch den Stream selbst nicht verändert.

Ein Stream ist also keine Datenstruktur für sich. Er erhält sein Input aus andere Datenstrukturen wie 
z.B. Arrays oder Listen und führt die gewünschte Operationen auf diesem Input aus
ohne die ursprüngliche Datenstruktur zu verändern.

Streams stellen Operationen zur Verfügung, welche in zwei Kategorien unterteilt werden können:
- _Intermediäre Operationen_, welche am Ende der Verarbeitung in einem Stream resultieren (und somit eine weitere, verkettete Verarbeitung ermöglichen).
- _Terminale Operationen_, welche am Ende der Verarbeitung einen Wert zurückliefern (und somit den Stream beenden)

Ist ein Stream einmal beendet, so können keine weiteren Operationen auf ihm ausgeführt werden.

Folgendes Bild illustriert die Arbeitsweise von Streams
![Java Streams](../Streams.png "Java Streams")

Nachfolgend ist ein Code in der `main(...)`-Methode aufgelistet, der aus einem Array
1. alle Taschenwaffen (`fitsInPocket`) herausfiltert (_Intermediäre Operation_),
2. dann bei diesen das Gewicht (`weight`) für den nächsten Schritt übernommen wird (_Intermediäre Operation_),
3. damit dann die Summe (`sum()`) der Gewichte berechnet werden kann (_Terminale Operation_).

Konzentriere dich bei diesem Code nur auf die 4 Zeilen unterhalb des Kommentars "Gewicht aller verdeckbaren Waffen".
Die einzelnen Bestandteile werden in den weiteren Unterkapitel genauer beleuchtet:

```java
import java.util.Arrays;

public class Weapon {
    private String name;
    private double weight;
    private boolean fitsInPocket;

    public Weapon(String name, double weight, boolean fitsInPocket) {
        this.name = name;
        this.weight = weight;
        this.fitsInPocket = fitsInPocket;
    }

    public static void main(String[] args) {
        Weapon[] weapons = {
                new Weapon("Shuriken", 0.02, true),
                new Weapon("Ninjatō", 1.2, false),
                new Weapon("Kusarigama", 2.5, false),
                new Weapon("Kunai", 0.15, true),
                new Weapon("Fukiya", 0.1, true),
                new Weapon("Kyoketsu-Shoge", 1.8, false),
                new Weapon("Kusari-fundo", 1.0, false),
                new Weapon("Nekote", 0.5, true),
                new Weapon("Makibishi", 0.03, true),
                new Weapon("Tekko-Kagi", 0.8, true)
        };

        // Gewicht aller verdeckbaren Waffen:
        double weightOfPocketWeapon = Arrays.stream(weapons)
                .filter(weapon -> weapon.fitsInPocket)
                .mapToDouble(weapon -> weapon.weight)
                .sum();

        System.out.println("All pocket weapons together weight " + weightOfPocketWeapon + " kg.");
    }

}
```


### Erzeugung von Streams
Wie erwähnt, können Streams aus Arrays, Listen und anderen Collections oder aber auch aus Einzelobjekten erzeugt werden.

#### Erzeugung aus Elementes eines Arrays
Aus den Elementen eines Arrays kann ein Stream mithilfe der Klasse Arrays aus dem java.util-Package wie folgt erzeugt werden:
```java
int[] numbers = {1, 2, 3, 4};
IntStream numbersStream = Arrays.stream(numbers); // IntStream ist eine Spezialisierung von Stream, welche die Verabeitung von primitive int-Werte ermöglicht

String[] greeting = {"Hello", "Streams"};
Stream<String> greetingStream = Arrays.stream(greeting); // Anhand der spitzigen Klammern wird ersichtlich, welche Objekttypen durch den Stream verarbeitet werden
```

#### Erzeugung aus Elementen einer Liste / eine Collection
Wenn eine Liste bereits vorhanden ist, kann die Methode stream() aufgerufen werden um einen Stream 
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

Ein `IntStream` besitzt mehr Methoden als ein `Stream<Integer>`. So kannst du auf dem Stream z.B. direkt eine Summe (`.sum()`) berechnen, statt selbst eine Summen-Funktion zu implementieren.

Hast du z.B. ein `Stream<Integer>` und möchtest aber eine Summe berechnen, dann kannst du z.B. den `Stream<Integer>` mit der Methode `mapToInt(...)` in einen `IntStream` umwandeln:

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

IntStream intStream = integerStream.mapToInt(Integer::intValue); 

int summe = intStream.sum();
System.out.println("Summe der Zahlen 1 bis 5: " + summe);
```

Lasse dich von der "_Methodenreferenz_" `Integer::intValue` nicht verwirren - wird in einem der nächsten Unterkapitel erklärt. Diese wird hier angegeben, damit beim Stream klar ist, wie jeder einzelne `Integer` in einen `int` umgewandelt wird. In diesem Fall wird ein `Integer integer` wie folgt umgewandelt: `int neuerWert = integer.intValue()`.

### Funktionale Interfaces
Streams arbeiten mit sog. Lambda-Expressions oder Methodenreferenzen (diese werden im nächsten Abschnitten erläutert).
Damit klar wird, was Lambda-Expressions sind, müssen wir zuerst funktionale Interfaces verstehen.

Ein funktionales Interface (_functional interface_) ist ein Interface, welche eine einzige abstrakte Methode beinhaltet.
Das heisst, solche Interfaces stellen eine einzige Funktionalität zur Verfügung.

Vor Java 8 mussten funktionale Interfaces, wie alle andere Interfaces auch durch Klassen implementiert werden 
oder es musste für sie eine innere, anonyme Klasse definiert werden.
Seit Java 8 kann eine Lambda-Expression statt eine anonyme Klasse verwendet werden, um die einzige Methode des funktionalen Interfaces umzusetzen.

### Lambda Expressions
Lambda Expressions (Lambda-Ausdrücke) wurden in Java 8 eingeführt, um vor allem folgende Funktionalität zur Verfügung zu stellen:
- Funktionen als Argumente für Methoden zu ermöglichen.
- Funktionen erstellen, welche zu keiner Klasse gehören.
- Eine Lambda-Expression kann wie ein Objekt weitergereicht und erst später ausgeführt werden.
Da Lambda-Expressions oft in Streams verwendet werden, wird hier aufgezeigt, wie Lambdas aussehen und wie sie verwendet werden können.

Lambda-Ausdrücke in Java sind quasi Methoden ohne Namen. Sie bestehen aus folgenden Elementen:
- eine Liste von formalen Parametern. Mehrere Parameter werden durch ein Komma separiert und mit Klammern umrundet.
(keine Parameter werden mit leeren Klammern `()` dargestellt, einen Parameter muss nicht zwingend mit Klammern umrundet werden)
- ein Pfeil-Token -> 
- ein Funktionsrumpf. Wenn der Funktionsrumpf mehrere Anweisungen lang ist, wird er mit geschweiften Klammern `{ ... }` umrundet.

![Lambda Expressions](../lambda-expression.jpg "Lambda-Expressions")

Im Gegensatz zu Methoden werden der Rückgabetyp und Exceptions nicht spezifiziert, sondern vom Compiler inferiert.

**Beispiele**

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

Und hier ist noch ein Beispiel, wie du Lambda-Ausdrücke zusammen mit einem eigenen `FunctionalInterface` verwenden kannst:

```java
// So kannst du ein eigenes FunctionalInterface definieren:
@FunctionalInterface  // Diese @-Angabe ist optional und darf auch weggelassen werden.
interface Operator {
    int calculate(int a, int b);
}

public static void main(String[] args) {
    
    // Lambda-Ausdrücke für Addieren und Multiplizieren:
    Operator add = (a, b) -> a + b;
    Operator multiply = (a, b) -> a * b;

    int a = 3, b = 4;

    // Die Funktion wird via Methodennamen aufgerufen, der im Interface spezifiziert wurde (calculate()):
    System.out.println("Summe: " + add.calculate(a, b));
    System.out.println("Produkt: " + multiply.calculate(a, b));
}
```

### Method Reference
Eine Methoden-Referenz ist die verkürzte Schreibweise einer Lambda-Expression, welche nur einen einzigen Methodenaufruf beinhaltet.
Die generische Syntax für Methodenreferenz sieht wie folgt aus: Object::method.
Wenn eine Methoden-Referenz verwendet wird, ist es nicht nötig, die Argumente für die Methode zu deklarieren.

```java
// Lambda-Expression mit einem Methodenaufruf
(word) -> System.out.println(word)

// Method-Reference Syntax der obigen Lambda-Expression
// Das Argument (word) muss nicht mitgegeben werden
System.out::println


```

## Methodenausführung auf Streams
### Die forEach() Methode
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

### Die sorted() Methode
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

### Die `map(...)`- und `mapToInt(...)`-Methode
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

### Die `collect()`-Methode
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

### Die `toArray(...)`-Methode
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