---
title: "Exam Java Grundlagen - Strings"
linkTitle: "Exam Java Grundlagen - Strings"
type: docs
weight: 2
description: >
  Einfache Aufgaben mit Strings
---

## Gegeben

Gegeben ist der folgende String:

```java
String endOfTheWorld =
    "That's great, it starts with an earthquake " +
    "Birds and snakes, and aeroplanes " +
    "And Lenny Bruce is not afraid " +
    "Eye of a hurricane, listen to yourself churn " +
    "World serves its own needs " +
    "Don't mis-serve your own needs " +
    "Speed it up a notch, speed, grunt, no, strength " +
    "The ladder starts to clatter " +
    "With a fear of height, down, height " +
    "Wire in a fire, represent the seven games " +
    "And a government for hire and a combat site " +
    "Left her, wasn't coming in a hurry " +
    "With the Furies breathing down your neck " +
    "Team by team, reporters baffled, trumped, tethered, cropped " +
    "Look at that low plane, fine, then " +
    "Uh oh, overflow, population, common group " +
    "But it'll do, save yourself, serve yourself " +
    "World serves its own needs, listen to your heart bleed " +
    "Tell me with the Rapture and the reverent in the right, right " +
    "You vitriolic, patriotic, slam fight, bright light " +
    "Feeling pretty psyched " +
    "It's the end of the world as we know it " +
    "It's the end of the world as we know it " +
    "It's the end of the world as we know it and I feel fine " +
    "Six o'clock, T.V. hour, don't get caught in foreign tower " +
    "Slash and burn, return, listen to yourself churn " +
    "Lock him in uniform, book burning, bloodletting " +
    "Every motive escalate, automotive incinerate " +
    "Light a candle, light a motive, step down, step down " +
    "Watch your heel crush, crush, uh oh " +
    "This means no fear, cavalier, renegade and steering clear " +
    "A tournament, a tournament, a tournament of lies " +
    "Offer me solutions, offer me alternatives and I decline " +
    "It's the end of the world as we know it (I had some time alone) " +
    "It's the end of the world as we know it (I had some time alone) " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
    "I feel fine (I feel fine) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
    "The other night I drifted nice continental drift divide " +
    "Mountains sit in a line, Leonard Bernstein " +
    "Leonid Brezhnev, Lenny Bruce and Lester Bangs " +
    "Birthday party, cheesecake, jellybean, boom " +
    "You symbiotic, patriotic, slam but neck, right, right " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
    "It's the end of the world as we know it " +
    "It's the end of the world as we know it " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it (time I had some time alone) " +
    "It's the end of the world as we know it and I feel fine (time I had some time alone)";
    // Copyright R.E.M.
```

## Aufgabe 1

Schreibe eine Methode, welche die Anzahl der Wörter zählt, die mindestens zweimal im Text vorkommen. Entferne zu diesem Zweck zuerst die Sonderzeichen.
Die Methode liefert die Anzahl dieser Wörter zurück.

## Aufgabe 2

Schreibe eine Methode, welche die Wörter aus dem obigen Text alphabetisch sortiert. Entferne zu diesem Zweck zuerst die Sonderzeichen.
Die Methode liefert ein Array mit den sortierten Wörtern zurück.

_Die Verwendung von Arrays.sort() und Collections.sort() ist **nicht** erlaubt._

Du kannst allerdings [String.compareTo](https://www.w3schools.com/java/ref_string_compareto.asp) verwenden. Sieh dir zudem diese [Visualisierung](https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/) zu Bubble Sort an. Neben Bubble Sort gibt es noch weitere Sortieralgorithmen, die du anwenden kannst.

## Aufgabe 3

Schreibe eine Methode, welche die durchschnittliche Wortlänge berechnet. Entferne zu diesem Zweck zuerst die Sonderzeichen.
Die Methode liefert die durchschnittliche Wortlänge als Gleitkommazahl zurück.

## Aufgabe 4

Schreibe eine Methode, welche die Wörter aus dem Text nach ihrer Länge sortiert. Kurze Wörter kommen dabei zuerst. Entferne zu diesem Zweck zuerst die Sonderzeichen.
Die Methode liefert ein Array mit den sortierten Wörtern zurück.

## Aufgabe 5

Schreibe eine Methode, welche das Wort zurückliefert, das im Text oben am häufigsten vorkommt. Entferne zu diesem Zweck zuerst die Sonderzeichen.
Die Methode liefert das gesuchte Wort zurück.

## Aufgabe 6

[//]: # "Alte Beschreibung V1"
[//]: # "Schreibe eine Methode, welche die einzelnen Buchstaben des Textes in ein zweidimensionales Array von Strings überführt."
[//]: # "Die erste Dimension hat dabei die Grösse der verschiedenen vorkommenden Zeichen im Text in alphabetischer Reihenfolge."
[//]: # "Sonderzeichen sind ebenfalls Teil dieser alphabetischen Reihenfolge, die Sortierung richtet sich nach dem Integer-Wert der einzelnen Zeichen."
[//]: # "Die zweite Dimension enthält pro Zeichen ein Array mit den Positionen der Zeichen im Text. An erster Stelle steht dabei das jeweilige Zeichen."
[//]: # "Sämtliche Buchstaben sollen immer nur als kleingeschriebene Buchstaben behandelt werden."
[//]: # "Alte Beschreibung V2"
[//]: # "Schreibe eine Methode, welche die einzelnen Buchstaben des Textes in ein zweidimensionales Array von Strings überführt."
[//]: # "In der ersten Reihe sollen alle einzigartigen im Text vorhandenen Buchstaben stehen. "
[//]: # "Diese sollen in alphabetischer Reihenfolge sortiert sein. Sonderzeichen sollen auch aufgelistet werden."
[//]: # "Unter jedem Buchstaben sollen fortlaufend die Positionen(index) im Text dargestellt werden."
[//]: # "Sämtliche Buchstaben sollen immer nur als kleingeschriebene Buchstaben behandelt werden."

Schreibe eine Methode, welche das Vorkommen der einzelnen Buchstaben des Textes mithilfe eines zweidimensionalen Arrays von Strings tabellarisch darstellt.
In der ersten Reihe sollen alle einzigartigen im Text vorhandenen Buchstaben stehen.
Diese sollen in alphabetischer Reihenfolge sortiert sein. Sonderzeichen sollen auch aufgelistet werden.
Stellvertretend für ein Aufkommen soll der Index (Position im Text) unter dem entsprechenden Zeichen aufgelistet werden.
Sämtliche Buchstaben sollen immer nur als kleingeschriebene Buchstaben behandelt werden.

Beispiel:

String text = "H<span style="color: blue">a</span>ll<span style="color: red">o</span> mein N<span style="color: blue">a</span>me ist Cl<span style="color: blue">a</span>udi<span style="color: red">o</span>"

|     | <span style="color: blue">a</span>  | c   | d   | e   | h   | i   | l   | m   | n   | <span style="color: red">o</span>  | s   | t   | u   |
| --- | ----------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- | ---------------------------------- | --- | --- | --- |
| 5   | <span style="color: blue">1</span>  | 20  | 24  | 7   | 0   | 8   | 2   | 6   | 9   | <span style="color: red">4</span>  | 17  | 18  | 23  |
| 10  | <span style="color: blue">12</span> |     |     | 14  |     | 16  | 3   | 13  | 11  | <span style="color: red">26</span> |     |     |     |
| 15  | <span style="color: blue">22</span> |     |     |     |     | 25  | 21  |     |     |                                    |     |     |     |
| 19  |                                     |     |     |     |     |     |     |     |     |                                    |     |     |     |

Der Tabelle kann folgendes entnommen werden:
Der Buchstabe `a` befindet sich an den Positionen `1` und `12` im String `Hallo mein Name ist Claudio`.
Das erste Zeichen in der Tabelle ist ein Leerschlag (whitespace).

Um die Tabelle formattiert auszugeben, kannst du `String.format("%-10s", deineZahl)` verwenden.
Dabei wird der Text immer mit Leerzeichen aufgefüllt und sichergestellt, dass der Text immer 10 Zeichen lang ist, auch wenn die Zahlen unterschiedlich lang sind.
