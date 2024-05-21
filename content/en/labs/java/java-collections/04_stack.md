---
title: "Stack - Aufgaben"
linkTitle: "Stack"
type: docs
weight: 4
description: >
    Aufgaben zu [Java Collections - Stack](../../../../docs/java/java-collections/05_stack)
---

## Aufgabe 1 (Optional)

Versuche eine eigene Stack-Klasse (`MyStack<E>`) zu implementieren mithilfe von Arrays und verwende dabei keine anderen
Collections-Klassen.

Die MyStack Klasse sollte eine dynamische Grösse haben, d.h. sie der Stack sollte beliebig wachsen können. Da der Stack
mithilfe von Arrays implementiert werden soll, muss also in deiner Klasse die Kapazität des Stacks sichergestellt
werden.

Implementiere die folgenden Methoden:

* `public E push(E item)`
* `public E pop( )` (soll EmptyStackException werfen)
* `public E peek() ` (soll EmptyStackException werfen)
* `int size()`
* `public boolean empty()`

Beachte, dass du die `toString()` Methode anpasst, sodass die MyStack-Stacks beim printen übersichtlich dargestellt
werden, wie im Beispiel oben: [blue, yellow, green, orange]

Zudem wird erwartet, dass ein eigenes Testing (wie in [J4 Testing](../../../../docs/java/java-testing) gelernt) zu der Umsetzung gehört.

## Aufgabe 2 (Optional)

Erweitere deine MyStack Klasse. Implementiere zusätzlich die folgende Methode:

* `public int search(Object o)`


