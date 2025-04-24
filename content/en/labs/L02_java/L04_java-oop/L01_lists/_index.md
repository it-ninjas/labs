---
title: "Lists Basics - Aufgaben"
linkTitle: "Lists Basics - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #J2 - Lists Basics
---

### Aufgabe 1

In dieser Aufgabe werden wir eine Liste von Wörtern analysieren. Die Liste enthält bereits vordefinierte Wörter, und dein Programm soll die folgenden Schritte ausführen:

- Gib die **Anzahl der Wörter** in der Liste aus.
- Gib **alle Wörter** in der Konsole wieder.
- Gib alle **Nomen** (Wörter, die mit einem grossen Buchstaben beginnen) **in Grossbuchstaben** aus.
- Gib die **Wörter in umgekehrter Reihenfolge** aus.

Die Liste, die du verwenden sollst, lautet:

```java
List<String> words = new ArrayList<>(List.of(
    "Abstraktion", "API", "Annotation", "ArrayList", "Bedingung", "Bibliothek",
    "Bytecode", "Collection", "Compiler", "Debugging", "Deployment", "entwickeln",
    "Exception", "Framework", "GarbageCollector", "generisch", "HashMap",
    "Heap", "implementieren", "Interface", "JVM", "Kapselung", "Klasse",
    "konstruieren", "Konstruktor", "Lambda", "lernen", "Methoden",
    "Modifikator", "Objekt", "optimieren", "Polymorphismus", "reflektieren",
    "Reflexion", "Schleife", "sortieren", "Stack", "Stream", "Synchronisation",
    "Thread", "TreeSet", "UnitTest", "Variable", "Vererbung"
));
```

_Bei der Umsetzung dürfen keine Streams verwendet werden!_

---

### Aufgabe 2

Schreibe ein Programm, das die **Fibonacci-Zahlen** bis zu einer bestimmten Zahl **n** berechnet und in einer ArrayList speichert.

#### Was ist Fibonacci?

Die **Fibonacci-Folge** ist eine berühmte Zahlenreihe, bei der **jede Zahl die Summe der beiden vorangehenden Zahlen ist**. Sie beginnt immer mit den Zahlen 0 und 1.
Die ersten Fibonacci-Zahlen sind:

```
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
```

Die Berechnungen verlaufen also folgendermassen:

- 0 (erste Zahl, fixer Wert)
- 1 (zweite Zahl, fixer Wert)
- 1 (= 0 + 1)
- 2 (= 1 + 1)
- 3 (= 1 + 2)
- 5 (= 2 + 3)
- 8 (= 3 + 5)
- 13 (= 5 + 8)
- 21 (= 8 + 13)
- 34 (= 13 + 21)
- ...

Eine ArrayList eignet sich besonders gut, um Fibonacci-Zahlen zu speichern, da wir im Voraus nicht wissen, wie viele Zahlen berechnet werden müssen, bis eine bestimmte Zahl erreicht ist.
Die ArrayList kann dynamisch wachsen und neue Zahlen aufnehmen.
Durch diese Aufgabe lernst du den Umgang mit ArrayLists und wie sie sich dynamisch vergrössern lassen, ohne dass du dir Gedanken über die feste Größe von Arrays machen musst.

Die Fibonacci-Folge ist relevant, weil sie in der **Natur** häufig vorkommt, wie bei der Anordnung von Blättern oder der Struktur von Tannenzapfen.

#### Umsetzung

Du schreibst eine Methode für die Berechnung der Fibonacci-Zahlen bis zu einem bestimmten Wert.
Die Methode berechnet die Fibonacci-Zahlen, bis die aktuell berechnete Zahl grösser als **n** ist, und gibt die Liste der berechneten Fibonacci-Zahlen als Rückgabewert zurück.
Es ist also vor der Berechnung unklar, wie lange die Liste werden kann.

Methodensignatur:

```java
List<Integer> fibonacci(int n);
```

Wenn wir also zum Beispiel **n** auf 20 setzen, wäre das Resultat eine ArrayList mit den folgenden Einträgen:

```java
[0, 1, 1, 2, 3, 5, 8, 13, 21]
```

21 ist grösser als 20, deshalb stoppt die Liste nach diesem Eintrag.

_Bei der Umsetzung dürfen keine Streams verwendet werden!_

---

Hier kannst du [zurück zur Theorie](../../../../docs/02_java/04_java-oop/05_list-basics).
