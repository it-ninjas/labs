---
title: "Iteration"
linkTitle: "Iteration"
weight: 9
---

## Iteration über Collections

Iteration ist die Bearbeitung der Elemente einer Collection nacheinander. Es gibt verschiedene Möglichkeiten, über
Collections zu iterieren, die meisten davon wurden schon in den vorhergehenden Kapiteln in Beispielen verwendet, und
werden hier zur Referenz noch einmal zusammengefasst.

### for Schleife

Die klassische for-Schleife kann verwendet werden, um über eine Collection zu iterieren, sie wurde schon bei den Arrays behandelt:

```java
List<String> items = List.of("Apple", "Banana", "Cherry");

for(int i = 0; i < items.size(); i++) {
    System.out.println(items.get(i));
}
```

Das funktioniert natürlich nur für Collections, die einen nummerierten Index verwenden, also primär für Listen.

### for-each Schleife

Die for-each Schleife (auch erweiterte for-Schleife genannt) ist eine einfachere und lesbarere Möglichkeit, über
Collections zu iterieren. Sie benötigt keinen Index, sondern gibt einfach der Reihe nach jedes Elemnt der Collection
in den Schleifen-Body. Beispiel List:

```java
List<String> items = List.of("Apple", "Banana", "Cherry");

for (String item : items) {
    System.out.println(item);
}
```

In der Praxis ist das aber die häufigste Form der Iteration. Die for-each Schleife funktioniert auch mit Sets:

```java
Set<String> items = Set.of("Apple", "Banana", "Cherry");

for (String item : items) {
    System.out.println(item);
}
```

Maps können auch mit der for-each Schleife durchlaufen werden, allerdings benötigen sie wegen der Key-Value Struktur
ein Bisschen Sonderbehandlung.
Interessieren uns nur die Werte, können wir die `values()` Methode der Map verwenden:

```java
Map<String, Integer> items = Map.of("Apple", 1, "Banana", 2, "Cherry", 3);

for (Integer value : items.values()) {
    System.out.println(value);
}
```

Möchten wir nur die Keys, können wir die `keySet()` Methode der Map verwenden:

```java
for (String key : items.keySet()) {
    System.out.println(key);
}
```

Wollen wir sowohl die Keys als auch die Values, können wir die `entrySet()` Methode der Map verwenden. Sie gibt für
jeden Eintrag ein Objekt zurück, von dem man den Key und den Value auslesen kann:

```java
for(Map.Entry<String, Integer> entry : items.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### forEach-Methode

Viele Collections bieten eine `forEach`-Methode an, die eine Lambda-Funktion als Parameter entgegennimmt. Diese
Funktion wird für jedes Element der Collection aufgerufen. Beispiel List:

```java
List<String> items = List.of("Apple", "Banana", "Cherry");

items.forEach(item -> System.out.println(item));
```

Dasselbe für Sets:

```java
Set<String> items = Set.of("Apple", "Banana", "Cherry");

items.forEach(item -> System.out.println(item));
```

Für Maps gibt es eine spezielle `forEach()`-Methode, die zwei Parameter für Key und Value entgegennimmt:

```java
Map<String, Integer> items = Map.of("Apple", 1, "Banana", 2, "Cherry", 3);

items.forEach((key, value) -> System.out.println(key + ": " + value));
```

### Iterator

Es gibt noch die Möglichkeit des Iterators. Ein Iterator ist ein Objekt, dass sich die bisher verarbeiteten Elemente
merkt und mit der `next()` Methode das nächste Element zurückgibt. Mit der `hasNext()` Methode kann überprüft werden,
ob noch weitere Elemente vorhanden sind. Beispiel List:

```java
List<String> items = List.of("Apple", "Banana", "Cherry");

Iterator<String> it = items.iterator();

while (it.hasNext()) {
    String item = it.next();
    System.out.println(item);
}
```

Maps können auch mit einem Iterator durchlaufen werden, benötigen aber wieder ein bisschen Spezialbehandlung:

```java
Map<String, Integer> items = Map.of("Apple", 1, "Banana", 2, "Cherry", 3);

Iterator<Map.Entry<String, Integer>> it = items.entrySet().iterator();

while (it.hasNext()) {
    Map.Entry<String, Integer> entry = it.next();
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

Iteratoren werden heutzutage eher selten verwendet, da die for-each Schleife in der Regel ausreichend und lesbarer ist.
Sie haben aber einen kleinen Vorteil: Wenn man eine Klasse schreibt, die eine Collection beinhaltet, möchte man die
vielleicht nicht einem Aufrufer in einem Getter zurückgeben:

```java
import java.util.ArrayList;

class LeakingListContainer {
    private List<String> privateList = new ArrayList<>();

    public List<String> getPrivateList() {
        return privateList;
    }
}
```

Das kommt in der Praxis zwar häufig vor, verletzt aber die Kapselung. Ein Benutzer des Objektes kann so mit der Liste
machen, was er will:

```java
leakingListContainer.getPrivateList().clear();
```

Möchte man die Kontrolle über die Liste behalten, aber einem Aufrufer trotzdem ermöglichen, über die interne Liste zu
iterieren, geht das mit einem Iterator:

```java
import java.util.ArrayList;

class NonLeakingListContaier {
    private List<String> privateList = new ArrayList<>();

    public Iterator<String> getPrivateList() {
        return privateList.iterator();
    }
}
```

So muss die Listenreferenz selbst nicht veröffentlicht werden. Denselben Zweck würde man mit einer defensiven Kopie
erfüllen, das braucht aber mehr Zeit und Speicher. Trotzdem sollte dieses Muster sparsam verwendet werden, da es nicht
sehr intuitiv ist, und man in der Praxis meistens mit for-each Schleifen arbeiten möchte.

## Aufgaben

[Aufgaben zu Modul #J6 - Java Collections](../../../../labs/02_java/05_java-collections)
