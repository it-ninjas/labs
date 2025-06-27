---
title: "Exam Java Grundlagen - Zahlen-Array"
linkTitle: "Exam Java Grundlagen - Zahlen-Array"
type: docs
weight: 1
description: >
  Einfache Aufgaben mit einem Zahlen-Array
---

## Gegeben

Gegeben ist das folgende Array mit Zahlen:

```java
int[] numbers = {
    -8, 0, 13, 0, -8, 23, -22, 18, -6, -1,
    -21, -1, 2, 20, -24, 21, 25, -16, -10, -2,
    -20, 15, -15, 0, -16, -19, 13, 24, -3, 7,
    21, -15, 21, -11, 4, -17, 3, 11, 22, 12,
    11, 12, 6, -4, -21, -20, -24, -3, -25, -13,
    17, 19, 19, 20, 22, 9, -10, 12, 16, -1,
    21, -24, 12, 19, -7, 15, 5, -22, 23, 12,
    6, 2, -14, 12, 17, -13, 3, -4, -16, 8,
    16, 6, -23, 0, 3, -16, -6, -14, 8, 25,
    -22, 2, 7, 8, -6, 20, 3, -5, -19, -15 };
```

## Aufgabe 1

Schreibe eine Methode, welche alle Zahlen im Array zählt, welche zwischen 0 und 10 liegen und keine 5 sind.
Die Methode liefert die Anzahl dieser Zahlen zurück.

## Aufgabe 2

Schreibe eine Methode, welche aus dem Array alle positiven Zahlen inklusive 0 in ein neues Array schreibt.
Die Reihenfolge der Zahlen im Array muss gleich bleiben. Die Methode liefert das neue Array zurück.

## Aufgabe 3

Schreibe eine Methode, welche aus dem Array alle Zahlen sucht, welche nicht mehr als 10 von der Zahl -6 abweichen.
Schreibe diese Zahlen in ein neues Array. Die Methode liefert das neue Array zurück.

## Aufgabe 4

Schreibe eine Methode, welche alle Zahlen aus dem Array in positive Zahlen verwandelt und diese in ein neues Array schreibt.
Die Methode liefert das neue Array zurück.

_`Math.abs` darf für diese Aufgabe nicht verwendet werden._

## Aufgabe 5

Schreibe eine Methode, welche alle Zahlen aus dem Array ausliest, die sich von ihren direkten Nachbarn um jeweils nicht mehr als den Wert 5 unterscheiden.
Schreibe diese Zahlen in ein neues Array. Die Methode liefert das neue Array zurück. Für die erste und die letzte Zahl im Array gibt es nur einen Nachbar.

Ein Beispiel:

```java
int[] beispiel = { 2, 5, 19, 15, 12, 18 };
```

Hier würde die Methode folgenden Array zurückgeben:

```java
int[] result = { 2, 15 };
```

Erklärung:

- **2**: &nbsp; Kein Nachbar links, Nachbar rechts (5) mit Unterschied <span style="color:green">3</span>.
- **5**: &nbsp; Nachbar links (2) mit Unterschied <span style="color:green">3</span>, Nachbar rechts (19) mit Unterschied <span style="color:red">14</span>.
- **19**: Nachbar links (5) mit Unterschied <span style="color:red">14</span>, Nachbar rechts (15) mit Unterschied <span style="color:green">4</span>.
- **15**: Nachbar links (19) mit Unterschied <span style="color:green">4</span>, Nachbar rechts (12) mit Unterschied <span style="color:green">3</span>.
- **12**: Nachbar links (15) mit Unterschied <span style="color:green">3</span>, Nachbar rechts (18) mit Unterschied <span style="color:red">6</span>.
- **18**: Nachbar links (12) mit Unterschied <span style="color:red">6</span>, kein Nachbar rechts.
