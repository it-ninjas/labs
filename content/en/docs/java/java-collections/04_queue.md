---
title: "Queue"
linkTitle: "Queue"
weight: 4
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

![queue2](../../java-collections/queue2.png)

Auf Deutsch könnte man Queues als "Warteschlangen" bezeichnen.
Wir kennen Warteschlangen von unserem Alltag:
Beispielsweise vom Einkaufen, wo es eine Schlange von Kunden gibt, die an der Kasse auf einen Kassierer warten.
Ein Kunde stellt sich zu hinterst an  und rückt "in der Warteschlange" vor, wenn vorherigen Kunden bedient wurden.

![queue1](../../java-collections/queue1.png)

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


## java.util.Deque
Die Deque ist eine Queue mit zwei Enden, und Datenelemente können an beiden Enden hinzugefügt oder entfernt
werden. Die Deque in Java wird über die das Interface java.util.Deque implementiert, die ein
Subtyp des Interface java.util.Queue ist.

![deque1](../../java-collections/deque1.png)


### Alle Methoden vom Interface java.util.Deque

```java

/*
 * Fügt das angegebene Element an den Anfang dieser Deque ein,
 * wenn dies möglich ist, ohne Kapazitätsbeschränkungen zu verletzen 
 * und löst eine IllegalStateException aus, wenn derzeit kein Platz verfügbar ist.
 */
void addFirst(E e);

/*
 * Fügt das angegebene Element an das Ende dieser Deque ein,
 * wenn dies  möglich ist, ohne Kapazitätsbeschränkungen zu verletzen
 * und löst eine IllegalStateException aus, wenn derzeit kein Platz verfügbar ist.
 */
void addLast(E e);

/*
 * Fügt das angegebene Element an den Anfang dieser Deque ein,
 * wenn dies  möglich ist, ohne Kapazitätsbeschränkungen zu verletzen.
 * Bei Erfolg wird true zurückgegeben und sonst wird false zurückgegeben.
 *
 * Bei der Verwendung einer Deque mit Kapazitätsbeschränkungen ist diese Methode in der Regel addFirst(E e) vorzuziehen, 
 * da bei Verletzung der Kapazitätsbeschränkungen keine Exception geworfen wird, sondern false zurückgegeben wird.
 * 
 */
boolean offerFirst(E e);

/*
 * Fügt das angegebene Element an das Ende dieser Deque ein,
 * wenn dies möglich ist, ohne Kapazitätsbeschränkungen zu verletzen.
 * Bei Erfolg wird true zurückgegeben und sonst wird false zurückgegeben.
 *
 * Bei der Verwendung einer Deque mit Kapazitätsbeschränkungen ist diese Methode in der Regel addLast(E e) vorzuziehen,
 * da bei Verletzung der Kapazitätsbeschränkungen keine Exception geworfen wird, sondern false zurückgegeben wird.
 *
 */
boolean offerLast(E e);

/*
 * Gibt das Element am Anfang des Deques zurück und entfernt es in der Deque.
 * Falls die Deque leer ist, dann wird null zurückgegeben.
 */
E pollFirst();

/*
 * Gibt das Element am Ende des Deques zurück und entfernt es in der Deque.
 * Falls die Deque leer ist, dann wird null zurückgegeben.
 */
E pollLast();

/*
 * Gibt das Element am Anfang des Deques zurück und entfernt es in der Deque.
 * Diese Methode unterscheidet sich von pollFirst() nur darin, dass sie eine Exception auslöst, wenn die Deque leer ist.
 */
E removeFirst();

/*
 * Gibt das Element am Ende des Deques zurück und entfernt es in der Deque.
 * Diese Methode unterscheidet sich von pollLast() nur darin, dass sie eine Exception auslöst, wenn die Deque leer ist.
 */
E removeLast();

/*
 * Gibt das Element am Anfang des Deques zurück, entfernt es aber nicht.
 * Gibt null zurück, wenn die Deque leer ist.
 */
E peekFirst();

/*
 * Gibt das Element am Ende des Deques zurück, entfernt es aber nicht.
 * Gibt null zurück, wenn die Deque leer ist.
 */
E peekLast();

/*
 * Gibt das Element am Anfang des Deques zurück, entfernt es aber nicht.
 * Diese Methode unterscheidet sich von peekFirst() nur darin, dass sie eine Exception auslöst, wenn die Deque leer ist.
 */
E getFirst();

/*
 * Gibt das Element am Ende des Deques zurück, entfernt es aber nicht.
 * Diese Methode unterscheidet sich von peekLast() nur darin, dass sie eine Exception auslöst, wenn die Deque leer ist.
 */
E getLast();

/*
 * Entfernt das erste Vorkommen des angegebenen Elements aus dieser Deque,
 * sofern es vorhanden ist.  Wenn diese Deque das Element nicht enthält,
 * bleibt sie unverändert.
 */
boolean removeFirstOccurrence(Object o);

/*
 * Entfernt das letzte Vorkommen des angegebenen Elements aus dieser Deque,
 * sofern es vorhanden ist.  Wenn diese Deque das Element nicht enthält,
 * bleibt sie unverändert.
 */
boolean removeLastOccurrence(Object o);

// *** Queue methods ***
...
// *** Stack methods ***
...

```

Im Interface java.util.Deque sind Queue und Stack Methoden ebenfalls deklariert.
Deques, bei denen Elemente nur an einem Ende eingefügt und am nur anderen Ende entnommen werden,
stellen wiederum Queues dar.
Deques, bei denen Elemente an einem Ende eingefügt und am gleichen Ende entnommen werden,
stellen Stacks dar.


