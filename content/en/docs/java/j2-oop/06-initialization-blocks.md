---
title: "Initialisierungsblöcke"
linkTitle: "Initialisierungsblöcke"
weight: 6
description: >
  Modul #J2
---


## Initialisierungsblöcke
Neben Konstruktoren gibt es noch zwei weitere Konstrukte, die der Initialisierung dienen. Statische und nicht-statische Initialisierungsblöcke.
Diese sehen wie folgt aus:
```java
public class Car {

	static {
		// Statischer Initialisierungsblock
	}

	{
		// Instanzblock
	}

	public Car {
		// Konstruktor
	}
}
```
Innerhalb dieser Initialisierungblöcke können ähnlich wie bei den Konstruktoren bestimmte Initialisierungen durchgeführt werden. Grundsätzlich können die beiden Blöcke beliebigen Programmcode enthalten. Die Reihenfolge bei der Erstellung eines neuen Objekts ist wie folgt:
1.  Statische Variablen
2.  Statische Initialisierungblöcke
3.  Instanzvariablen
4.  Instanzblöcke
5.  Konstruktoren

Eine Java-Klasse kann beliebig viele statische und nicht-statische Initialisierungsblöcke aufweisen. Die Reihenfolge des Aufrufs bei mehreren Blöcken richtet sich nach der Reihenfolge der Implementation.

**Beispiele**

Nicht-statischer Initialisierungsblock:
[https://www.tutorialspoint.com/a-non-static-initialization-block-in-java](https://www.tutorialspoint.com/a-non-static-initialization-block-in-java)

Statischer Initialisierungblock:
[https://www.tutorialspoint.com/a-static-initialization-block-in-java](https://www.tutorialspoint.com/a-static-initialization-block-in-java)

---
