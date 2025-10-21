---
title: "Java Lists Basics"
linkTitle: "Lists"
weight: 5
description: >
  Modul #J2
---

#### Ziele

- Ich kann ohne Hilfsmittel die Unterschiede zwischen Listen und Arrays in Java nennen.
- Ich kann mindestens drei der wichtigsten Merkmale einer Java-Liste auflisten.
- Ich kann mindestens 5 Methoden einer Liste korrekt und ohne Hilfsmittel nennen.
- Ich kann erklären, wozu die `ArrayList`-Klasse verwendet wird, und was sie für Vorteile mitbringt.
- Ich kann eine neue Liste erstellen und bei ihr Elemente hinzufügen, lesen und entfernen.

---

## Einführung Listen

Für die Aufgaben des OOP-Modules #J2 wirst du effizienter arbeiten können, wenn du statt Arrays sogenannte Listen verwendest.

Aus diesem Grund schieben wir einen kleinen Crash-Kurs zu Listen vor den Einstieg ins OOP.

### Was ist eine Liste?

Eine Liste ist in Java ein Behälter (Container), der Objekte in einer festen Abfolge enthält.<br>
Im Gegensatz zu Arrays, deren Elemente im Speicher in fortlaufender Reihenfolge abgelegt werden und
deren Grösse aus diesem Grund ohne Neuinitialisierung unveränderbar ist,
können Listen flexible Mengen an Objekten enthalten.

Das [List-Interface](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/List.html) ist ein Teil des Java-Collections-Frameworks.
Dieses Framework stellt einige Klassen zur Verfügung, welche das List-Interface umsetzen (mehr dazu in einem späteren Modul).

### Die wichtigsten Merkmale einer Liste

- Eine Liste kann nur Objekte beinhalten (es gibt also keine Liste mit primitiven Datentypen)
- Eine Liste kann nur Objekte eines Typs beinhalten. Dieser Typ wird zur Zeit der Definition der Liste bestimmt.
- Die Elemente innerhalb einer Liste haben eine feste Reihenfolge. Dies bedeutet, dass eine Iteration über eine Liste immer zu einem gleichen Ergebnis mit der gleichen Reihenfolge führt.
- Duplikate innerhalb einer Liste sind erlaubt (dasselbe Objekt darf mehrmals in einer Liste vorkommen)
- Eine Liste kann auch `null`-Elemente beinhalten.
- Die Indizes in einer Liste reichen immer von 0 bis Anzahl Elemente in der Liste minus 1.

---

### Die wichtigsten Methoden einer Liste

Das List-Interface stellt mehrere Methoden zur Verfügung, welche dann von Klassen wie `ArrayList` oder `LinkedList` umgesetzt werden.

Nachfolgend werden einige Methoden und deren Zweck aufgelistet.
Der Rückgabetyp "E" seht hier für einen generischen (universellen) Typ, der stellvertretend für einen spezifischen Objekttyp steht. Dieses Vorgehen wird genauer im Modul [Generics](../11_java-generics) behandelt.

```java
/*
* Returns: the number of elements in this list.
*/
int size();

/*
 * Appends the specified element to the end of this list.
 */
boolean add(E e);

/**
 * Returns the element at the specified position in this list.
 */
E get(int index);

/*
 * Removes the element at the specified position in this list.
 */
E remove(int index);

/*
 * Removes the first occurrence of the specified element from
 * this list, if it is present.
 */
boolean remove(Object o);

/*
 * Returns: true if this list contains the specified element.
 */
boolean contains(Object o);

```

---

## Die Klasse ArrayList

ArrayList gehört zu der Liste der Standardsammelklassen und ist im java.util-Packet definiert.<br>
Die ArrayList ist eine Klasse, die zum Erstellen eines dynamischen Arrays verwendet wird. Dieses Array beinhaltet Objektreferenzen und kann bei Bedarf grösser werden.<br>
Die ArrayList kombiniert die Vorteile eines Arrays (z.B. schneller Zugriff auf einem bestimmten Element) mit den Vorteilen einer Liste (kann dynamisch wachsen) und ist deswegen sehr nützlich um eine Sammlung von Objekten, derer Grösse nicht bekannt ist, zu bearbeiten.
Die ArrayList setzt alle Methoden (obligatorische wie auch optionale) des List-Interfaces um.

### Arbeiten mit einer ArrayList - Beispiel

Um mit ArrayList arbeiten zu können, muss die Klasse zuerst importiert werden.<br>

```java
import java.util.ArrayList;
```

Nun kann eine Variable definiert und eine ArrayList erzeugt werden. Die Syntax hier wird in späteren Modulen erklärt,
hier reicht es zu wissen, dass innerhalb der spitzen Klammern - auf der linken Seite der Definition - der Typ der Objekte angegeben wird, welche dann in der Liste hinzugefügt werden dürfen.

```java
// Erstellen einer ArrayList für String-Objekte.
// Ein Versuch, Objekte anderer Typ in der Liste hinzuzufügen wird in einem Kompilierfehler resultieren.
List<String> words = new ArrayList<>();
```

Sobald eine Liste erzeugt wurde, können beliebig viel Objekte hinzugefügt oder entfernt werden.<br>
Über die Liste kann mit einer Schleife iteriert werden oder auch mit einem Index direkt auf ein Element zugegriffen werden.

```java
// Elemente hinzufügen
words.add("Hello");
words.add("World");
words.add("!");

System.out.println(words); // Output: [Hello, World, !]
System.out.printf("There are %d words in our list\n", words.size());
System.out.printf("Our list contains \"!\". True or false? %b\n", words.contains("!")); // Output: Our list contains "!". True or false? true

System.out.printf("The second word is: %s\n", words.get(1)); // Output: World

for (String word: words) {
    System.out.println(word);
}

words.remove(2); // Entfernt das dritte Element aus der Liste
System.out.println(words); // Output: [Hello, World]
System.out.printf("Our list contains \"!\". True or false? %b\n", words.contains("!")); // Output: Our list contains "!". True or false? false

```

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe 1 und 2](../../../../labs/02_java/04_java-oop/05_lists/) in den OOP-Labs.
