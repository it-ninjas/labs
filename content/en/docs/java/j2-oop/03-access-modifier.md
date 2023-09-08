---
title: "Zugriffsmodifikatoren"
linkTitle: "Zugriffsmodifikatoren"
weight: 3
description: >
  Modul #J2
---

## Ziele
* Ich kenne die Zugriffsmodifikatoren `public`, `private` und `protected`.
* Ich weiss, dass Instanzvariablen immer mit dem Schlüsselwort `private` deklariert werden.

## Zugriffsmodifikatoren
In Java können wir Feldern und Methoden Zugriffsbeschränkungen auferlegen. Diese Einschränkungen werden durch Zugriffsmodifikatoren festgelegt.
Zugriffsmodifikatoren bestimmen die Sichtbarkeit von Feldern und Methoden und damit deren Verwendbarkeit aus anderen Programmteilen.
Es gibt vier Zugriffsmodifikatoren.

### Private
Auf eine private Instanzvariable oder -methode kann von ausserhalb der Klasse nicht zugegriffen werden.
Es ist eine gängige Praxis, Instanzvariablen privat zu halten. Wir möchten schliesslich nicht, dass jemand unsere Daten direkt manipuliert. Dieses Prinzip nennt man auch Kapselung.
```java
class Person {
    private String name;
}
```
UML-Symbol: `-`

### Public
Auf Variablen und Methoden, die mit dem Schlüsselwort public deklariert sind, kann von einem beliebigen Ort des Programms zugegriffen werden.
Sie sind also öffentlich.
```java
class Person {
	private String name;

	public String getName() {
		return name;
	}
}
```
Auf öffentliche Methoden und Felder kann ein Objekt über den Punkt-Operator zugreifen.
```java
Person p = new Person();
c.getName();
```
UML-Symbol: `+`

### Protected
Wenn eine Variable oder Methode protected deklariert ist, dann kann nur vom gleichen Package oder von Unterklassen darauf zugegriffen werden (Unterklassen bzw. Vererbung folgt im Modul «Objektorientiertes Design»).
UML-Symbol: `#`

### Package-Private
Wenn eine Variable oder Methode keinen Zugriffsmodifikator hat, so besitzt sie trotzdem einen. Dieser wird Package-Private genannt. Die Sichtbarkeit ist grundsätzlich private, wird aber auf Klasse im gleichen Package ausgeweitet.

### Zusammenfassung
| Modifikator      | Eigene Klasse | Klasse im gleichen Package / innere-Klassen | Unterklassen | Sonstige Klassen |
|------------------|---------------|---------------------------------------------|--------------|------------------|
| `private`        | ja            | nein                                        | nein         | nein             |
| `public`         | ja            | ja                                          | ja           | ja               |
| `protected`      | ja            | ja                                          | ja           | nein             |
| ohne / package   | ja            | ja                                          | nein         | nein             |

---
