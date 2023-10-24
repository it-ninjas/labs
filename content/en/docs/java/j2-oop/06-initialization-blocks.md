---
title: "Initialisierungsblöcke"
linkTitle: "Initialisierungsblöcke"
weight: 6
description: >
  Modul #J2
---

## Ziele
* Ich kann in eigenen Worten den Unterschied zwischen statische- und nicht-statische Initialisierungsblöcke erklären.
* Ich kann den Zweck erörtern, welcher Initialisierungsblöcke erfüllen.

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
Innerhalb dieser Initialisierungblöcke können ähnlich wie bei den Konstruktoren bestimmte Initialisierungen durchgeführt werden. Initialisierungsblöcke sind dann nützlich, wenn z.B. bei der Erstellung eines Objekts gewisser Code noch vor der Ausführung des Konstruktors als Vorbereitung ausgeführt werden muss.

Grundsätzlich können die beiden Blöcke beliebigen Programmcode enthalten. Die Reihenfolge bei der Erstellung eines neuen Objekts ist wie folgt:
1.  Statische Variablen
2.  Statische Initialisierungblöcke
3.  Instanzvariablen
4.  Instanzblöcke
5.  Konstruktoren

Eine Java-Klasse kann beliebig viele statische und nicht-statische Initialisierungsblöcke aufweisen. Die Reihenfolge des Aufrufs bei mehreren Blöcken richtet sich nach der Reihenfolge der Implementation (sprich, die oberen Blöcke werden zuerst ausgeführt).

**Beispiel**
Folgendes Beispiel braucht einen statischen Initialisierungsblock, um eine Default-Waffe auszuwählen, die als Default für alle Ninjas gilt. In einem Instanzblock wird die Instanzvariable `weapon` gleich diesem Default-Wert gesetzt, damit das nicht in jedem Konstruktor (stelle dir vor, es gäbe viele davon) gemacht werden muss, wo die `weapon` nicht gesetzt wird.

```java
import java.util.Random;

public class Ninja {
    private String name;
    private String weapon;
    private static String defaultWeapon;
    private static final String[] availableWeapons = {"Shuriken", "Ninjatō", "Kunai"};

    // Instanzblock
    {
        // Default-Wert, damit der Wert nicht in jedem Konstruktor gesetzt werden muss:
        this.weapon = defaultWeapon;
    }
    static {
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(availableWeapons.length);
        defaultWeapon = availableWeapons[randomIndex];
    }

    public Ninja(String name) {
        this.name = name;
    }

    public Ninja(String name, String weapon) {
        this(name);
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", weapon: " + weapon + "]";
    }

    public static void main(String[] args) {
        Ninja ninja1 = new Ninja("Kaito");
        Ninja ninja2 = new Ninja("Kota", "Kusarigama");

        System.out.println(ninja1);
        System.out.println(ninja2);
    }
}
```
