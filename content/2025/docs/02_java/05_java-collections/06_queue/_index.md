---
title: "Queue"
linkTitle: "Queue"
weight: 7
description: >
  Die Datenstruktur für eine Warteschlange: die Queue.
---

## java.util.Queue

Eine Queue ist ähnlich einem Stack ein Behälter, in den Elemente eingefügt und nur in einer bestimmten Reihenfolge
wieder entnommen werden können. Bei den Queues gilt das _First In First Out_ (=FIFO) Prinzip:
Das Einfügen eines Elements erfolgt an einem Ende und heisst _EnQueue_. Die Entfernung eines Elements erfolgt dann am
anderen Ende und heisst _DeQueue_. Das heisst also, das erste Elemente, das einer Queue eingefügt wird, ist das Element
das zuerst der Queue entnommen werden kann.
Queues können in ihrer Grösse beschränkt oder unbeschränkt sein.

![queue2](./images/queue2.png)

Auf Deutsch könnte man Queues als "Warteschlangen" bezeichnen.
Wir kennen Warteschlangen von unserem Alltag:
Beispielsweise vom Einkaufen, wo es eine Schlange von Kunden gibt, die an der Kasse auf einen Kassierer warten.
Ein Kunde stellt sich zu hinterst an und rückt "in der Warteschlange" vor, wenn vorherigen Kunden bedient wurden.

![queue1](./images/queue1.png)

### Alle Methoden vom Interface java.util.Queue

```java
/*
 * Fügt das angegebene Element in diese Queue ein,
 * wenn dies möglich ist, ohne Kapazitätsbeschränkungen zu verletzen.
 * Bei Erfolg wird true zurückgegeben. Eine IllegalStateException wird ausgelöst, wenn derzeit
 * kein Platz verfügbar ist.
 */
boolean add(E e);

/*
 * Fügt das angegebene Element in diese Queue ein,
 * wenn dies möglich ist, ohne Kapazitätsbeschränkungen zu verletzen.
 * Bei Erfolg wird true zurückgegeben und sonst wird false zurückgegeben.
 *
 * Bei der Verwendung einer Queue mit Kapazitätsbeschränkungen ist diese Methode in der Regel add(E e) vorzuziehen,
 * da bei Verletzung der Kapazitätsbeschränkungen keine Exception geworfen wird, sondern false zurückgegeben wird.
 *
 */
boolean offer(E e);

/*
 * Gibt das Element am Anfang des Queues zurück und entfernt es in der Queue.
 * Falls die Queue leer ist, dann wird null zurückgegeben.
 */
E poll();

/*
 * Gibt das Element am Anfang des Queues zurück und entfernt es in der Queue.
 * Diese Methode unterscheidet sich von poll() nur darin, dass sie eine Exception auslöst, wenn die Queue leer ist.
 */
E remove();

/*
 * Gibt das Element am Anfang des Queues zurück, entfernt es aber nicht.
 * Gibt null zurück, wenn die Queue leer ist.
 */
E peek();

/*
 * Gibt das Element am Anfang des Queues zurück, entfernt es aber nicht.
 * Diese Methode unterscheidet sich von peek() nur darin, dass sie eine Exception auslöst, wenn die Queue leer ist.
 */
E element();
```

{{% blocks/lead color="orange" %}}
Aufgaben
{{% /blocks/lead %}}

## Aufgaben

[Aufgaben zu Modul #J6 - Java Collections - Queue + Deque](../../../../labs/02_java/08_java-collections/05_queue)
