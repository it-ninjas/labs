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
Mit Java 8 ist zum java.util-Package des JDK das Stream-API hinzugekommen.
Das API ist eine Erweiterung des Java-Collection-Frameworks mit einer Schnittstelle im Stil der funktionalen Programmierung.
Mit dem Stream-API wurden mächtige Möglichkeiten zur Durchführung von Operationen auf Arrays und Listen eingeführt.<br>
In diesem Teil wird erklärt was Streams sind und wie sie für Operationen auf Arrays und Listen eingesetzt werden können.

### Was ist ein Stream?
Streams des Interface java.util.stream.Stream<T> stellen Ströme von Referenzen dar, die es erlauben, 
verkettete Operationen auf diesen Referenzen nacheinander oder parallel auszuführen.
Die Daten, die durch die Referenzen repräsentiert werden, werden durch den Stream selbst nicht verändert.

Ein Stream ist also keine Datenstruktur für sich. Er erhält sein Input aus andere Datenstrukturen wie 
z.B. Arrays oder Listen und führt die gewünschte Operationen auf diesem Input aus
ohne die ursprüngliche Datenstruktur zu verändern.

Streams stellen Operationen zur Verfügung, welche in zwei Kategorien unterteilt werden können:
- Intermediäre Operationen, welche am Ende der Verarbeitung in einem Stream resultieren (und somit eine weitere, verkettete Verarbeitung ermöglichen).
- Terminale Operationen, welche am Ende der Verarbeitung einen Wert zurückliefern (und somit den Stream beenden)

Ist ein Stream einmal beendet, so können keine weiteren Operationen auf ihm ausgeführt werden.

Folgendes Bild illustriert die Arbeitsweise von Streams
![Java Streams](../Streams.png "Java Streams")


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
### Funktionale Interfaces
Streams arbeiten mit sog. Lambda-Expressions (diese werden im nächsten Abschnitt erläutert).
Damit klar wird, was Lambda-Expressions sind, müssen wir zuerst funktionale Interfaces verstehen.

Ein funktionales Interface (functional interface) ist ein Interface, welche eine einzige abstrakte Methode beinhaltet.
Das heisst, solche Interfaces stellen eine einzige Funktionalität zur Verfügung.

Vor Java 8 mussten funktionale Interfaces, wie alle andere Interfaces auch durch Klassen implementiert werden 
oder es musste für sie eine innere, anonyme Klasse definiert werden.
Seit Java 8 kann eine Lambda-Expression statt eine anonyme Klasse verwendet werden, um die einzige Methode des funktionalen Interfaces umzusetzen.

### Lambda Expressions
Lambda Expressions (Lambda-Ausdrücke) wurden in Java 8 eingeführt, um vor allem folgende Funktionalität zur Verfügung zu stellen:
- Funktionen als Argumente für Methode zu ermöglichen
- Funktionen erstellen, welche zu keiner Klasse gehören
- Eine Lambda-Expression kann wie ein Objekt weitergereicht und erst später ausgeführt werden.
Da Lambda-Expressions oft in Streams verwendet werden, wird hier aufgezeigt wie Lambdas aussehen und wie sie verwendet werden können.

Lambda-Ausdrücke in Java sind quasi Methoden ohne Namen. Sie bestehen aus folgenden Elementen:
- eine Liste von formalen Parametern. Mehrere Parameter werden durch ein Komma separiert und mit Klammern umrundet.
(keine Parameter werden mit leeren Klammern dargestellt, einen Parameter muss nicht zwingend mit Klammern umrundet werden)
- ein Pfeil-Token -> 
- ein Funktionsrumpf. Wenn der Funktionsrumpf mehrzeilig ist, wird er mit geschweiften Klammern umrundet.

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

### Method Reference
Eine Methoden-Referenz ist die verkürzte Schreibweise einer Lambda-Expression, welche nur einen einzigen Methodenaufruf beinhaltet.
Die generische Syntax für Methodenreferenz sieht wie folgt aus: Object::method
Wenn eine Methoden-Referenz verwendet wird, ist es nicht nötig die Argumente für die Methode zu deklarieren.

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

Der Parameter "action" ist vom Typ "Consumer". Dieser Typ repräsentiert eine Operation (eine Funktion),
welche nur ein einziges Input-Argument akzeptiert und keine Ergebnisse zurückliefert. 
Ein Beispiel für so ein Consumer ist die Methode System.out.println, 
welche maximal ein einziges Objekt als Parameter akzeptiert, dieses Objekt in den Standard-Output ausgibt und "void" (also kein Ergebnis) zurückliefert.
Die Methode System.out.println erfüllt also die Bedingungen eines Consumers und kann als Parameter für die *forEach()* Methode verwendet werden

Die *forEach()* Methode kann als Ersatz für einen for-Loop verwendet werden.

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

// Und nun noch kürzer mit dem Method-Reference Syntax der obigen Lambda-Expression
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
Die *sorted()* Methode gehört zu den intermediären Operationen eines Streams.

Die Methode liefert ein Stream zurück, worin die Elemente im Stream nach ihrer natürlichen Reihenfolge (natural order) sortiert sind.

Die Syntax der Methode ist wie folgt: *Stream<T> sorted()*
wobei T der Typ der Elemente innerhalb des Streams ist

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

### Die collect() Methode
Die *collect(Collector collector)* Methode ist auch eine terminale Operation auf einem Stream.
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
