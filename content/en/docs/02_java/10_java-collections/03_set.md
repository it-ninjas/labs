---
title: "HashSet"
linkTitle: "HashSet"
weight: 3
description: >
  Die gebräuchlichste Umsetzung eines Set: HashSet.
---

## java.util.Set

Eine [`Set`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html) verwendet man, um eine Menge von Elemente zu speichern.
Dabei werden keine Duplikate gespeichert.
Die [`java.util.HashSet`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html) ist die gebräuchlichste Implementierung eines Sets.
Man könnte zum Beispiel in einem Set alle Wörter eines Texts speichern.
Tritt ein Wort mehrmals auf, so wird dieses Wort nur bei ersten Male gespeichert.
Im Set sind so alle auftretenden Wörter gespeichert und die `size()` Methode liefert die Anzahl unterschiedlicher Wörter zurück.

{{% alert title="Ein Set hat keine Duplikate!" color="primary" %}}
{{% /alert %}}

Dabei ist der Schlüssel immer eindeutig. Speichert man zwei Zuweisungen mit dem gleichen Schlüssel, so wird die erste Zuweisung überschrieben.

![set1](./images/set-set1.svg)

Die Benennung eines Sets sollte der Inhalt beschreiben.  
Zum Beispiel:

- `nameSet` --> ein **Set** mit **Namen**
- `names` --> mehrere Namen

### Methodenübersicht

```java
Set<String> nameSet = new HashSet<>();
nameSet.add("Peter");
nameSet.add("Anna");
nameSet.add("Kurt");
nameSet.add("Anna");
nameSet.add("Petra");

System.out.println(nameSet.size()); // Output: 4
System.out.println(nameSet.contains("Peter")); // Output: true
System.out.println(nameSet.remove("Emil")); // Output: false
System.out.println(nameSet.remove("Anna")); // Output: true
System.out.println(nameSet.size()); // Output: 3
nameSet.clear();
System.out.println(nameSet.isEmpty()); // Output: true

```

Die Elemente eines `Set` kann man mit den `Collection` Methoden abrufen:

- **iterator()**: Ein Iterator über die Elemente
- **stream()**: Ein sequentieller Stream über die Elemente
- **forEach()**: Führt eine bestimmte Aktion über alle Elemente aus

Die Reihenfolge der Elemente ist nicht garantiert.
Es existieren Implementierung wie das `SortedSet`, welche eine bestimmte Reihenfolge sicherstellt.

{{% blocks/lead color="orange" %}}
Beispiel
{{% /blocks/lead %}}

## Beispiel

Für die Beispiele verwenden wir die folgende initialisierte `HashMap`:

```java
Set<String> nameSet = new HashSet<>();
nameSet.add("Peter");
nameSet.add("Anna");
nameSet.add("Kurt");
nameSet.add("Anna");
nameSet.add("Petra");

```

### Beispiel 1 - Set erstellen

```java
// mit Konstruktor
Set<String> nameSet = new HashSet<>();
nameSet.add("Peter");
nameSet.add("Emil");

// mit statischer of() Methode
Set<String> nameSet = Set.of("Peter", "Emil");
// of() liefert ein unmodifizierbares Set zurück. Kein HashSet!

```

### Beispiel 2 - Auslesen der Elemente

```java
// Abfrage der Elemente mit einem Iterator:
Iterator<String> iterator = nameSet.iterator();
while(iterator.hasNext()) {
        System.out.println(iterator.next());
}

// Abfrage der Elemente mit einer for Schleife:
for (String name : nameSet){
        System.out.println(name);
}

// Abfrage der Elemente mit einem Stream:
nameSet.stream().forEach(name -> System.out.println(name));

// Abfrage der Elemente mit einem forEach:
nameSet.forEach(name -> System.out.println(name));

```

{{% blocks/lead color="orange" %}}
Aufgaben
{{% /blocks/lead %}}

## Aufgaben

[Aufgaben zu Modul #J6 - Java Collections - Set](../../../../labs/java/java-collections/02_set)
