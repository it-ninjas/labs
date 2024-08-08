---
title: "Zugriffsmodifikatoren"
linkTitle: "Zugriffsmodifikatoren"
weight: 3
description: >
  Modul #J2
---

## Ziele
* Ich kann ohne Hilfsmittel alle Zugriffsmodifikatoren beschreiben.
* Ich kann die Auswirkungen von allen Zugriffsmodifikatoren auf Klassen-, Felder- und Methoden-Ebene beschreiben.
* Ich kann erklären, warum Felder (Instanzvariablen) immer mit dem Schlüsselwort `private` deklariert werden sollten.

## Zugriffsmodifikatoren
In Java können wir Klassen, Feldern und Methoden Zugriffsbeschränkungen auferlegen. Diese Einschränkungen werden durch Zugriffsmodifikatoren festgelegt.
Zugriffsmodifikatoren bestimmen die Sichtbarkeit von Klassen, Feldern und Methoden und damit deren Verwendbarkeit aus anderen Programmteilen.
Es gibt vier Zugriffsmodifikatoren.

### Private
Auf eine private Instanzvariable oder -methode kann von ausserhalb der Klasse nicht zugegriffen werden.
Es ist eine gängige Praxis, Instanzvariablen privat zu halten. Wir möchten schliesslich nicht, dass jemand unsere Daten direkt manipuliert. Dieses Prinzip nennt man auch Kapselung.

Klassen, welche als `private` deklariert werden sind immer sog. _innere_ oder _nested_ Klassen. Auf diese Klassen kann nur innerhalb der umhüllende Klasse zugegriffen werden.

```java
class Person {
    private String name;
}
```
UML-Symbol: `-`

### Public
Auf Klassen, Felder und Methoden, die mit dem Schlüsselwort `public` deklariert sind, kann von einem beliebigen Ort des Programms zugegriffen werden.
Sie sind also öffentlich.
```java
public class Person {
	private String name;

	public String getName() {
		return name;
	}
}
```
Auf öffentliche Methoden und Felder kann ein Objekt über den Punkt-Operator zugreifen.
```java
Person p = new Person();
p.getName();
```
UML-Symbol: `+`

### Protected
Wenn eine Klasse, ein Feld oder eine Methode mit `protected` deklariert ist, dann kann nur vom gleichen Package oder von Unterklassen darauf zugegriffen werden (Unterklassen folgen später im Modul [Objektorientiertes Design](../java-ood)).


Wichtig zu beachten ist, dass Subpackages von Java wie separate Packages behandelt werden. Dementsprechend kann die Klasse `AccessClass.java` wenn die Struktur wie folgt aussieht nicht auf Protected Members der Klasse `ParentClass.java` zugreifen.
```
src
└── ch
    └── sbb
        ├── ParentClass.java
        └── subpackage
            └── AccessClass.java
```


UML-Symbol: `#`.

### Package-Private
Wenn eine Klasse, ein Feld oder eine Methode keinen Zugriffsmodifikator hat, so besitzt sie trotzdem einen. Dieser wird Package-Private genannt. Die Sichtbarkeit ist grundsätzlich private, wird aber auf Klasse im gleichen Package ausgeweitet.
Das bedeutet, dass andere Klassen innerhalb derselben Package, Zugriff auf diese Klasse, Felder und Methoden haben. Für Subpackages gilt das Gleiche wie bei Protected.

### Zusammenfassung
| Modifikator              | Eigene Klasse | Klasse im gleichen Package / innere-Klassen | Unterklassen | Sonstige Klassen |
|--------------------------|---------------|---------------------------------------------|--------------|------------------|
| `private`                | ja            | nein                                        | nein         | nein             |
| `public`                 | ja            | ja                                          | ja           | ja               |
| `protected`              | ja            | ja                                          | ja           | nein             |
| Keinen (package-private) | ja            | ja                                          | ja           | nein             |

---