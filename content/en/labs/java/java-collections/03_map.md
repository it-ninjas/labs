---
title: "Map - Aufgaben"
linkTitle: "Map"
type: docs
weight: 3
description: >
  Aufgaben zu [Java Collections - Map](../../../../docs/java/java-collections/04_map)
---

## Aufgabe 1
Postleitzahlen einlesen und verarbeiten:

1. Schreibe ein Programm, welches Postleitzahlen aus einer CSV-Datei herausliest und in einer HashMap speichert.
2. Nach dem Speichern schreibt das Programm verschiedene Informationen zu den Daten in die Konsole (siehe Ausgabe).
3. Verwendet wieder die kleine Hilfsklasse [`OutputValidation`](https://github.com/it-ninjas/code/blob/main/helper/src/main/java/ch/itninjas/validator/OutputValidation.java) zum Verifizieren von eurem Konsole-Output. 
4. Ein eigenes Testing (wie in [J4 Testing](./../java-testing) gelernt) soll umgesetzt werden.


### Input
- <a href="/files/csv/Postleitzahlen_UTF8.csv">PLZ (UTF8 Format)</a>
- <a href="/files/csv/Postleitzahlen_ISO-8859-1.csv">PLZ (ISO-8859-1 Format)</a>

### Ausgabe  
Die Ausgabe muss das folgende Format aufweisen. Beachte, dass die Aufzählungen der Ortschaften sortiert sind.
```text
- Anzahl PLZ: 42
- Kleinste PLZ der Gemeinde Bern: 4444 Bern
- Grösste PLZ der Gemeinde Bern: 4444 Bern
- Anzahl Gemeinden mit mehr als 10 Buchstaben: 42
- Anzahl Gemeinden mit 7 Buchstaben: 42
- Anzahl Gemeinden mit der Buchstabenfolge 'ent': 42
- Gemeinden mit 3 Buchstaben: Abc, Def, Xzz
- Anzahl Buchstaben der kleinsten Gemeinden: 2
- Kleinsten Gemeinden: di, ri, ru
- Anzahl Buchstaben der grössten Gemeinden: 5
- Grössten Gemeinden: diwil, riwil, ruwil
```
> **Ausgabe überprüfen**  
> Der Konsole-Output Hash für diese Aufgabe ist: **`1768988137`**

## Aufgabe 2 (Optional)
Wir programmieren eine eigene Map-Klasse `MyMap`, welche noch keinen Hash-Code verwendet:

1. Es dürfen keine Klassen aus dem Collection-Framework verwendet werden.
2. Die Klasse muss das Interface `MyMapInterface` implementieren.
3. Die Klasse weiss nicht, wie viele Elemente man speichert. Sie muss die Grösse internen Datenstruktur dynamische anpassen.
4. Die `toString()` der `java.lang.Object` Klasse soll von der `MyMap` so überschrieben werden, dass die Elemente kommasepariert ausgegeben werden.
5. Ein eigenes Testing (wie in [J4 Testing](./../java-testing) gelernt) soll umgesetzt werden.


{{% details title="Inferface MyMapInterface" %}}

```java
package com.examples.list;

public interface MyMapInterface<K, V> {

    /**
     * Associates the specified value with the specified key in this map.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     */
    V put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this map contains no mapping for the key
     */
    V get(Object key);

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Removes all the mappings from this map.
     * The map will be empty after this call returns.
     */
    void clear();

    /**
     * Removes the mapping for a key from this map if it is present.
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     */
    V remove(Object key);

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.
     * @param key key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     *         key
     */
    boolean containsKey(Object key);

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the
     *         specified value
     */
    boolean containsValue(Object value);
}

```

{{% /details %}}

## Aufgabe 3 (Optional)
Wir Kopieren unsere `MyMap` Klasse zu der Klasse `MyHashMap` und erweitern diese, damit sie Hash Funktionalität verwendet:

1. Beim Hinzufügen von Zuweisungen wird der Hash-Code vom Schlüssel berechnet und ebenfalls abgespeichert.
2. Die Schlüsselsuche wird anschliessend über die gespeicherten Hash-Code der Schlüssel durchgeführt statt über die Schlüssel selbst.
3. Ein eigenes Testing (wie in [J4 Testing](./../java-testing) gelernt) soll umgesetzt werden.

