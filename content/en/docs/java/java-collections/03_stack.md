---
title: "Stack"
linkTitle: "Stack"
weight: 3
description: >
  Die Datenstruktur "Stapel".
---

## java.util.Stack

java.util.Stack ist eine weitere Datenstruktur, bei der Elemente eingefügt und wieder entfernt werden können, wobei bei
Stacks immer nur auf dasjenige Element zugegriffen werden kann, das zuletzt eingefügt wurde (Last-In-First-Out = LIFO).
Auf Deutsch könnte man Stack als "Stapel" übersetzen.

![stack1](../../java-collections/stack1.png)

Ein Stack kann leer sein oder kann beliebig wachsen. Mit der Methode `push(E item)` legt man das Element *item* auf den
Stack, d.h. man fügt es zu oberst hinzu.
`pop()` entfernt das oberste Element vom Stack und gibt es zurück.

![stack2](../../java-collections/stack2.png)

Die Methode `peek()` gibt das Element zu oberst auf dem Stack zurück, ohne den Stack zu verändern.

Falls der Stack leer ist und man die Methode `pop()` oder `peek()` aufruft, wird die Exception `EmptyStackException`
geworfen.

Mit der Methode `search(Object o)` kann man ein Element im Stack suchen, wobei die Position des Elements zurückgegeben
wird. Bei den Stacks hat das oberste Element des Stacks die Position 1 und das Element darunter die Position 2, das
Element darunter die Position 3, ect. Das heisst anders als bei den ArrayLists fangen wir nicht bei 0 an die Elemente zu
indexieren, sondern bei 1.

### Alle Methoden der Klasse java.util.Stack

```java
/*
 * Konstruktor: Erstellt einen leeren Stack
 */
public Stack()

/*
 * Fügt ein Element an die oberste Stelle dieses Stacks hinzu.
 */
public E push(E item)

/*
 * Entfernt das Element an der obersten Stellen und gibt dieses Element
 * als Wert dieser Funktion zurück.
 */
public E pop()

/*
 * Gibt das Element an der obersten Stelle des Stacks zurück,
 * ohne es vom Stack zu entfernen.
 */
public E peek()

/*
 * Gibt true zurück, wenn der Stack keine Elemente enthält.
 */
public boolean empty()

/*
 * Gibt die 1-basierte Position vom oberen Ende des Stapels zurück,
 * an der sich das Objekt befindet; der Rückgabewert -1 bedeutet,
 * dass sich das Objekt nicht auf dem Stapel befindet.
 */
public int search(Object o)

```

### Beispiel

#### Beispiel 1

Im folgenden Beispiel erstellen wir zunächst ein leeres Stack mit Elementen vom Typ String und wenden die Methoden der
Stack-Klasse an und sehen, wie diese funktionieren.

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> colors = new Stack<>();
        colors.push("blue");
        colors.push("yellow");
        colors.push("green");
        colors.push("orange");

        System.out.println(colors); // Output: [blue, yellow, green, orange]

        System.out.println("Color on top: " + colors.peek()); // Output: Color on top: orange
        System.out.println(colors); // Output: [blue, yellow, green, orange]

        System.out.println("Color on top: " + colors.pop()); // Output: Color on top: orange
        System.out.println(colors); // Output: [blue, yellow, green]

        System.out.println("Is stack empty? " + colors.empty()); // Output: Is stack empty? false
        System.out.println("Size of stack: " + colors.size()); // Output: Size of stack: 3

        System.out.println("Position of element blue: " + colors.search("blue")); // Output: Position of element blue: 3
        System.out.println("Position of element yellow: " + colors.search("yellow")); // Output: Position of element yellow: 2
        System.out.println("Position of element green: " + colors.search("green")); // Output: Position of element green: 1

    }
}
```

Output:
```
[blue, yellow, green, orange]
Color on top: orange
[blue, yellow, green, orange]
Color on top: orange
[blue, yellow, green]
Is stack empty? false
Size of stack: 3
Position of element blue: 3
Position of element yellow: 2
Position of element green: 1

```

Im oberen Beispiel verwenden wir die Methode *size()*. Diese Methode ist nicht in der java.util.Stack-Klasse
implementiert, wird jedoch von der Vector-Mutterklasse geerbt. Diese Vector-Klasse implementiert zusätzlich weitere
Methoden des List-Interfaces, weshalb diese auch für Stacks verwendet werden können. Ein Stack bzw. die Datenstruktur des
Stacks wird jedoch durch die oben aufgeführten Methoden ausgemacht.

#### Beispiel 2 (EmptyStackException)

In diesem Beispiel rufen wir die `pop()`-Methode auf einem leeren Stack auf:

```java
import java.util.Stack;

public class StackExampleEmptyStackExceptionA {
    public static void main(String[] args) {
        Stack<String> colors = new Stack<>();
        colors.pop(); // Throws: Exception in thread "main" java.util.EmptyStackException
    }
}
```

Dies führt zu folgendem Output:
```
Exception in thread "main" java.util.EmptyStackException
	at java.base/java.util.Stack.peek(Stack.java:102)
	at java.base/java.util.Stack.pop(Stack.java:84)
	at ch.puzzle.stack.StackExampleEmptyStackExceptionA.main(StackExampleEmptyStackExceptionA.java:8)

```

Das gleiche Verhalten lässt sich auch bei der `peek()`-Methode feststellen:

```java
import java.util.Stack;

public class StackExampleEmptyStackExceptionB {
    public static void main(String[] args) {
        Stack<String> colors = new Stack<>();
        colors.peek(); // Throws: Exception in thread "main" java.util.EmptyStackException
    }
}
```

Wie erwartet, kriegen wir folgenden Output:
```
Exception in thread "main" java.util.EmptyStackException
	at java.base/java.util.Stack.peek(Stack.java:102)
	at ch.puzzle.stack.StackExampleEmptyStackExceptionB.main(StackExampleEmptyStackExceptionB.java:8)

```

### Übungen

#### Aufgabe 1

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

#### Aufgabe 2

Erweitere deine MyStack Klasse. Implementiere zusätzlich die folgende Methode:

* `public int search(Object o)`



