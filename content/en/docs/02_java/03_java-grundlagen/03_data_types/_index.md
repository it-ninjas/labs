---
title: "Datentypen"
linkTitle: "Datentypen"
weight: 3
description: >
  Modul #J1
---

## Ziele

- Ich weiss, was Datentypen sind.

## Datentypen

In Java sind Variablen stark typisiert. Das heisst, dass alle Variablen bei ihrer Erstellung mit einem Datentyp versehen
werden müssen.

Um z.B. eine Zahl wie `3` vom Typ `int` in eine Variable `sum` zu speichern, tun wir folgendes:

```java
int sum = 3;
```

Seit Java 10 gibt es Typinferenz für lokale Variablen, das heisst, eine lokale Variable kann deklariert und
initialisiert werden (muss gleichzeitig geschehen), ohne dass ein Datentyp angegeben werden muss - anstelle des
Datentyps kann _var_ verwendet werden:

```java
var sum = 20;
```

Es gibt zwei Arten von Datentypen:

- Primitive Datentypen
- und Referenztypen.

Der grundlegende Unterschied besteht darin, dass eine primitive Variable den tatsächlichen Wert speichert, während eine
Referenzvariable die Adresse des Objekts speichert, auf welches sie sich bezieht.

Dies hat mit dem Java Memory Modell zu tun. Das nachfolgende Bild zeigt das Java Memory Modell als einfache Darstellung:

![Java Memory Modell](./images/Datentypen.png)

Es besteht grundsätzlich aus dem Stack Memory und dem Heap Space. Primitive Datentypen (wird im nächsten Kapitel erklärt) werden nur auf dem Stack angelegt.
Objekte, wie das im Bild gezeigte Auto (Car), sind im Heap abgelegt. Die Referenz auf das Objekt wird auf dem Stack
angelegt. Die Referenz "zeigt" also auf das Objekt im Heap.

Dieser fundamentale Unterschied ist relevant beim Vergleich von Werten und Referenzen. Später wirst du lernen, dass der
Vergleichs-Operator `==` stets die Werte auf dem Stack miteinander vergleicht. Bei Referenzen wird dort also überprüft,
ob sie auf dasselbe Objekt zeigen. Wenn der Inhalt von Objekten verglichen werden soll, so muss dies mit der Methode
`equals()` gemacht werden.
