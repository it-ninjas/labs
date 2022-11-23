---
title: "LinkedList"
linkTitle: "LinkedList"
weight: 5
description: >
  Eine verkettete Liste, die LinkedList.
---

## java.util.LinkedList

LinkedLists sind verkettete Listen. D.h. die Elemnte der Listen sind zu einander verkettet
und nicht wie bei einer ArrayList an bestimmten Positionen platziert.

java.util.LinkedList implementiert zwei Collection-Interfaces: java.util.List und java.util.Deque.
Das bedeutet grundsätzlich, dass sie sowohl die Methoden des List-Interfaces implementiert, als auch die des Deque-Interfaces.

Grundsätzlich gibt es zwei Arten von verketteten Listen: Einfach verkettete Listen und doppelt verkettete Liste.
Wir werden beide anschauen, wie sie im Allgeimeinen aussehen.
Die java.util.LinkedList ist die Implementierung einer doppelt verketteten Liste..

### Einfach verkettete Listen

Verkettete Listen bestehen aus Knoten (Nodes).
Jeder Knoten enthält ein Element und eine Referenz auf einen weiteren Knoten, falls dieser vorhanden ist.
Die Knoten sind somit über eine Referenz auf jeweils den nächsten Knoten miteinander verkettet.
Die verkettete Liste enthält schlussendlich eine Referenz auf den ersten Knoten in der Liste.
Der letzte Knoten enthält eine Referenz auf `null`.

![linkedlist1](../../java-collections/linkedlist1.png)


#### Element zu einer einfach verketten Liste hinzufügen

Wird ein Knoten zu einer einfach verketteten Liste hinzugefügt, dann muss die Referenz des Knotens davor
auf dieses Element zeigen und die Referenz des Elements, das hinzugefügt wird, muss auf den nächsten Knoten zeigen.
So wird ein neuer Knoten zwischen zwei Knoten eingeschoben.

![linkedlist2](../../java-collections/linkedlist2.png)

#### Element zu aus einer einfach verketten Liste löschen

Wird ein Knoten aus einer einfach verketteten Liste gelöscht, dann muss die Referenz des Knotens davor
auf das zu löschende Element gelöscht werden und ersetzt werden mit der Referenz auf das nächste Element.
Die Referenz des Elements, das gelöscht wird, auf das nächste Element muss auch gelöscht werden.
So wird ein bestehender Knoten zwischen zwei Knoten entfernt.

![linkedlist3](../../java-collections/linkedlist3.png)

### Doppelt verkettete Listen

In einer doppelt verketteten Liste haben die Knoten nicht nur eine Referenz auf den nächsten Knoten, sondern
auch eine Referenzen auf den vorherigen Knoten.
Eine mögliche Implementierung einder doppelt verketteten Liste könnte sein, dass der letzte Knoten,
wie auch schon bei einer einfach verketteten Liste eine Referenz auf `null` hat als nächsten Knoten
und der erste Knoten in einer doppelt verketteten Liste eine Referenz auf `null` hat als vorherigen Knoten.
Zusätzlich hat man eine Referenz auf den Kopf der Liste, d.h. auf den ersten Knoten
und eine Referenze auf den letzten Knoten der Liste.

![linkedlist4](../../java-collections/linkedlist4.png)

Das Einfügen und Entfernen funktioniert analog zu einer einfach verketteten Liste.

#### Ein Element aus einer (einfach oder doppelt) verketteten Liste auslesen
Wenn man ein Element in einer einfach verketteten Liste auslesen möchte, dann muss man vom ersten Knoten
anfangen und ein Knoten nach dem anderen die Liste durchlaufen bis zu diesem Element. Im "schlimmsten" Fall
muss über alle Knoten iteriert werden, wenn das Element, das mun sucht, im letzten Knoten ist.

#### ArrayList vs. LinkedList

Der Vorteil von LinkedLists besteht darin, dass Elemente schneller hinzugefügt und schneller aus der Liste
gelöscht werden können im Vergleich zu ArrayLists.
Bei einer LinkedList müssen nur die Referenzen zum "Vorgänger" und "Nachfolgen" angepasst werden, wenn man ein Element
einfügen oder löschen möchte.
Der Nachteil jedoch besteht darin, dass der Zugriff auf Elementen der Liste an einer bestimmten Position
im Vergleich zu ArrayLists langsamer ist, da in diesem Fall die Liste bis zu dem entsprechenden Element
durchlaufen werden muss.
Die Entscheidung für einen bestimmten Listen-Typ ist also  abhängig von der Art und Anzahl
der Zugriffe.

### LinkedList-Klasse im Java
Die LinkedList-Klasse im Java (java.util.LinkedList) implementiert eine doppelt verkettete Liste.
Sie ist so implementiert, dass sie zwei Referenzen enthält, zum einen die Referenz
zum ersten Knoten und zum anderen die Referenz zum zweiten Knoten:

```java
public class LinkedList<E>  extends AbstractSequentialList<E>  implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
  transient int size = 0;

  /**
   * Pointer to first node.
   */
  transient Node<E> first;

  /**
   * Pointer to last node.
   */
  transient Node<E> last;
  
  ...
}

```

Ein Knoten, also das Objekt des Typs `Node`, enthält 
* das Element, welches einen generischen Typ hat (deshalb `Node<E>`),
* die Referenz auf den vorherigen Knoten, also auf ein Node-Objekt 
* und eine Referenz auf den nächsten Knoten.

Die statische Klasse `Node<E>` ist innerhalb der Klasse java.util.LinkedList definiert:

```java
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

```
### Einige Methoden der Klasse java.util.LinkedList

```java
/*
 * Konstruktor: Erstellt eine initial leere Liste
 */
public LinkedList()

/*
 * Gibt das erste Element der Liste zurück.
 */
public E getFirst()

/*
 * Gibt das letzte Element der Liste zurück.
 */
public E getLast()

/*
 * Entfernt das erste Element der Liste und gibt es zurück.
 */
public E removeFirst()

/*
 * Entfernt das letzte Element der Liste und gibt es zurück.
 */
public E removeLast()

/*
 * Fügt das angegeben Element an den Anfang der Liste ein.
 */
public void addFirst(E e)

/*
 * Fügt das angegebene Element an das Ende der Liste an.
 */
public void addLast(E e)
...
        
// *** Queue and Deque methods ***
        ...
// *** Stack methods ***
        ...
// *** List methods ***
        ...


```

### Beispiele

Beispiele kommen noch

### Übungen

Übungen kommen noch



Fortsetzung folgt...
