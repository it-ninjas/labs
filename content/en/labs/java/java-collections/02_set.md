---
title: "Set - Aufgaben"
linkTitle: "Set"
type: docs
weight: 2
description: >
  Aufgaben zu [Java Collections - Set](../../../../docs/java/java-collections/03_set)  
---

## Aufgabe 1
Schreibe ein Programm, welches die Personen von vier Vereine auswertet.

1. Pro Verein existiert ein `Set` mit allen Vereinsmitliedern (siehe Input).
2. Das Programm analysiert die Vereinsmitglieder und schreibt die folgenden Aussagen in die Konsole (siehe Beispiel-Ausgabe unten):
   - Wie viele Personen machen min. in einem Verein mit: Anzahl: Namen
   - Alle Personen, welche im Fussball und Tanz Verein sind: Anzahl: Namen
   - Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: Anzahl: Namen
3. Die Namen der Personen müssen in alphabetischer Reihenfolge angezeigt werden.
4. Ein eigenes Testing (wie in [J4 Testing](../../../../docs/java/java-testing) gelernt) soll umgesetzt werden.

### Input

{{% details title="4 Sets" %}}
```java
Set<String> fussballVerein = Set.of(
    "Emil", "Hans", "Felix", "Fritz", "Patrick",
    "Hanne", "Anja", "Paula", "Petra", "Anna"
);

Set<String> schwimmVerein = Set.of(
    "Emil", "Klaus", "Paul", "Fritz", "Patrick",
    "Hanne", "Anina", "Nicole", "Petra", "Gerda"
);

Set<String> musikVerein = Set.of(
    "Kari", "Hans", "Max",
    "Karin", "Petra", "Anna"
);

Set<String> tanzVerein = Set.of(
    "Emil", "Hans", "Paul", "Felix", "Max",
    "Lara", "Anja", "Sabine", "Anna"
);

```
{{% /details %}}

### Ausgabe  
Die Ausgabe muss so aussehen:
```text
- Wie viele Personen machen min. in einem Verein mit: 20: Anina,Anja,Anna,Emil,Felix,Fritz,Gerda,Hanne,Hans,Kari,Karin,Klaus,Lara,Max,Nicole,Patrick,Paul,Paula,Petra,Sabine
- Alle Personen, welche im Fussball und Tanz Verein sind: 5: Anja,Anna,Emil,Felix,Hans
- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: 1: Paula

```

### Ausgabe überprüfen
Wie können ihr die Ausgabe überprüfen?
Wir benützen dazu eine kleine Hilfsklasse [`OutputValidation`](https://github.com/it-ninjas/code/blob/main/helper/src/main/java/ch/itninjas/validator/OutputValidation.java).
Die Klasse erlaubt es eure `System.out.println()` Anweisungen mit `OutputValidation.logAndPrint()` zu ersetzten.
Am Schluss des Programmes kann man mit `OutputValidation.printControlHash()` den Hash-Wert der eigenen Ausgabe anzeigen, oder mit `OutputValidation.verifyControlHash()` einen Hash-Wert zur Überprüfung mit eurer Ausgabe überreichen.

Ein Anwendungsbeispiel seht ihr unter [OutputValidationUsage](https://github.com/it-ninjas/code/blob/main/helper/src/main/java/ch/itninjas/validator/OutputValidationUsage.java).

Der Hash für diese Aufgabe ist: **`-1421274666`**

## Aufgabe 2
Wir programmieren eine eigene Set-Klasse `MySet`, welche noch kein Hash-Code verwendet.

1. Es dürfen keine Klassen aus dem Collection-Framework verwendet werden.
2. Die Klasse muss das Interface `MySetInterfaceSimple` implementieren.
3. Die Klasse weiss nicht, wie viele Elemente man speichern muss. Sie muss die Grösse des Arrays dynamische anpassen.
4. Die `toString()` der `java.lang.Object` Klasse soll von der `MySet` so überschrieben werden, dass die Elemente kommasepariert ausgegeben werden.
5. Überprüfe deine Implemenation mit dem JUnitTest [MySetTest](https://github.com/it-ninjas/work/blob/main/labs/src/test/java/ch/itninjas/labs/j7/set/lab2/MySetTest.java)

### Input
{{% details title="Inferface MySetInterfaceSimple" %}}

```java
package com.examples.list;

public interface MySetInterfaceSimple<E> {

    /**
     * Adds the specified element to this set if it is not already present.
     * @param element element to be appended to this list
     * @return true if this set did not already contain the specified element
     */
    boolean add(E element);


    /**
     * Removes the specified element from this set if it is present.
     * @param object object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    boolean remove(Object object);

    /**
     * Returns true if this set contains the specified element.
     * @param object element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(Object object);

    /**
     * Returns the number of elements in this set.
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns true if this set contains no elements.
     * @return true if this set contains no elements
     */
    boolean isEmpty();

    /**
     * Removes all the elements from this set. The set will be empty after this call returns.
     */
    void clear();
}


```

{{% /details %}}

## Aufgabe 3 (Optional)
Wir Kopieren unsere `MySet` Klasse zu der Klasse `MyHashSet` und erweitern diese, damit sie Hash Funktionalität verwendet:

1. Beim Hinzufügen von neuen Elementen wird deren Hash-Code berechnet und ebenfalls abgespeichert.
2. Die Suche nach bestehenden Elementen wird anschliessend über den gespeicherten Hash-Code durchgeführt statt über die Elemente selbst.
3. Du kannst deine Implemenation mit dem gleichen JUnitTest [MySetTest](https://github.com/it-ninjas/work/blob/main/labs/src/test/java/ch/itninjas/labs/j7/set/lab2/MySetTest.java) überprüfen, da sich die neue Klasse gleich verhalten soll. Erstelle vom Test eine Kopie `MyHashSetTest` und ändere `MySet` überall zu `MyHahsSet`.