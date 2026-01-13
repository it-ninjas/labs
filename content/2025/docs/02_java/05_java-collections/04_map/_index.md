---
title: "Map"
linkTitle: "Map"
weight: 5
description: >
  Eine Liste von Schlüssel-Wert-Paaren.
---

## java.util.Map

Eine [`Map`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html) verwendet man, um Zuweisungen zu speichern.
Die [`java.util.HashMap`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html) ist die gebräuchlichste Map.
Man könnte zum Beispiel ein Register mit Postleitzahlen (PLZ) und den dazugehörigen Orten speichern.
Die PLZ ist der Schlüssel und der Ort ist der zugewiesene Wert.

{{% alert title="Eine Zuweisung besteht aus einem Schlüssel (Key) und einem Wert (Value)." color="primary" %}}
{{% /alert %}}

Dabei ist der Schlüssel immer eindeutig. Speichert man zwei Zuweisungen mit dem gleichen Schlüssel, so wird die erste Zuweisung überschrieben.

![list1](./images/map.svg)

Bei der Benennung eine Map versucht man die Zuweisung zu beschreiben:  
`plzToCityMap` --> **PLZ** zu **City** Zuweisung

### Methodenübersicht

```java
Map<Integer, String> plzToCityMap = new HashMap<>();
plzToCityMap.put(3000, "Zürich");
plzToCityMap.put(3000, "Bern");
plzToCityMap.put(3011, "Bern");
plzToCityMap.put(1234, "Vessy");
plzToCityMap.put(3920, "Zermatt");

System.out.println(plzToCityMap.size()); // Output: 4
System.out.println(plzToCityMap.get(3000)); // Output: Bern
System.out.println(plzToCityMap.containsKey(1234)); // Output: true
System.out.println(plzToCityMap.containsValue("Zürich")); // Output: false
System.out.println(plzToCityMap.containsValue("Zermatt")); // Output: true

```

Die `Map` offeriert drei Collection Ansichten auf den gespeicherten Inhalt:

- **keySet()**: Set auf alle Schlüssel
- **values()**: Collection auf alle Werte
- **entrySet()**: Set auf alle Schlüssel-Werte Zuweisungen
- **forEach()**: Führt eine bestimmte Aktion über alle Elemente aus

Die Reihenfolge des Inhalts hängt von der Implementierung der Iteratoren ab, welche eine konkrete Map Klasse für die einzelnen Collection-Ansichten verwendet. Manche Implementation wie die `TreeMap` garantiert eine bestimmte Reihenfolge, andere wie die `HashMap` keine.

{{% blocks/lead color="orange" %}}
Beispiel
{{% /blocks/lead %}}

## Beispiel

Für die Beispiele verwenden wir folgende `HashMap`:

```java
Map<Integer, String> plzToCityMap = new HashMap<>();
plzToCityMap.put(3000, "Zürich");
plzToCityMap.put(3000, "Bern");
plzToCityMap.put(3011, "Bern");
plzToCityMap.put(1234, "Vessy");
plzToCityMap.put(3920, "Zermatt");

```

### Beispiel 1 - Auslesen der Schlüssel, Werte und Zuweisungen

Mit der Methode `keySet()` kann man alle Schlüssel einer `Map` abfragen.
Der Rückgabewert ist ein `Set`, welches wir bestens kennen:

```java
// Abfrage der Schlüssel mit einem Iterator:
Iterator<Integer> plzIterator = plzToCityMap.keySet().iterator();
while(plzIterator.hasNext()) {
        System.out.println(plzIterator.next());
}

// Abfrage der Schlüssel mit einer FOR Schleife:
for (Integer plz : plzToCityMap.keySet()) {
        System.out.println(plz);
}

// Abfrage der Schlüssel mit einem Stream:
plzToCityMap.keySet().stream()
        .forEach(plz -> System.out.println(plz));
}

```

Ebenso kann man die Werte der Zuweisungen mit der Methode `values()` abfragen.
Als Resultat erhält man eine `Collection`.

```java
// Abfrage der Werte mit einem Iterator:
Iterator<String> nameIterator = plzToCityMap.values().iterator();
while(nameIterator.hasNext()) {
        System.out.println(nameIterator.next());
}

// Abfrage der Werte mit einer FOR Schleife:
for (String name : plzToCityMap.values()){
        System.out.println(name);
}

// Abfrage der Werte mit einem Stream:
plzToCityMap.values().stream()
        .forEach(name -> System.out.println(name));
}

// Abfrage der Werte mit einem forEach:
plzToCityMap.values().forEach(name -> System.out.println(name))
```

Es besteht auch die Möglichkeit mit der Methode `entrySet()` die Zuweisungen mit Schlüssel und Wert abzufragen.
Man erhält wieder ein `Set`.

```java
// Abfrage der Zuweisungen mit einem Iterator:
Iterator<Map.Entry<Integer, String>> plzCityIterator = plzToCityMap.entrySet().iterator();
while(plzCityIterator.hasNext()) {
        Map.Entry<Integer, String> entry = plzCityIterator.next();
        System.out.println(entry.getKey() + " : " + entry.getValue());
}

// Abfrage der Zuweisungen mit einer FOR Schleife:
for (Map.Entry entry : plzToCityMap.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
}

// Abfrage der Zuweisungen mit einem Stream:
plzToCityMap.entrySet().stream()
        .forEach(plzCity -> System.out.println(plzCity.getKey() + " : " + plzCity.getValue()));

// Abfrage der Zuweisungen mit einem forEach:
plzToCityMap.forEach((plz, city) -> System.out.println(plz + " : " + city));

```

{{% blocks/lead color="orange" %}}
Aufgaben
{{% /blocks/lead %}}

## Aufgaben

[Aufgaben zu Modul #J6 - Java Collections](../../../../labs/02_java/05_java-collections)
