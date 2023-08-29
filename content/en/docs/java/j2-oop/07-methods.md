---
title: "Instanzmethoden"
linkTitle: "Instanzmethoden"
weight: 7
description: >
  Modul #J2
---

## Ziele
* Ich kann Getter- und Setter-Methoden schreiben.
* Ich kenne die Methoden `equals()` und `hashCode()` und weiss unter welchen Umständen und wie ich diese überschreiben soll.

## Instanzmethoden
Methoden werden benutzt, um Funktionen zur Verfügung zu stellen. Diese Funktionalitäten reichen von einfachen Änderungen am Zustand eines Objekts bis zu komplexen Algorithmen zur Berechnung von mathematischen Dingen. Hier passiert also die Magie in einer Applikation.
Diese Methoden können also entweder den Inhalt von Datenfelder ändern oder ihre Werte verwenden, um eine bestimmte Berechnung durchzuführen.
Der Zugriffsmodifizierer einer Methode sollte immer so restriktiv wie möglich gewählt werden.

Eine Methodendeklaration besteht aus bis zu sieben Komponenten:
1. Zugriffsmodifikator. public, protected, private oder package-private
2. Sonstige Modifikatoren. Beispielsweise static oder synchronized
2. Rückgabewert. Der Datentyp des von der Methode zurückgegebenen Werts oder _void_, wenn die Methode keinen Wert zurückgibt
3. Methodenname / Bezeichner
4. Parameterliste in Klammern. Eine durch Kommas getrennte Liste von Eingabeparametern (Datentyp + Bezeichner). Wenn keine Parameter vorhanden sind, genügt die Angabe der beiden Klammern
5. Exceptions. Dazu mehr später im Modul Exception Handling
6. Methodenkörper.

### Namenskonventionen für Methoden
* Erster Buchstabe immer klein
* CamelCase
* sollten aus einem Verb und einem Nomen zusammengesetzt werden
* Möglichst aussagekräftige Namen
* Möglichst keine Abkürzungen

### Getter und Setter
Diese beiden Arten von Methoden sind in der objektorientierten Programmierung unverzichtbar. Eine get-Methode (Getter) ruft den Wert eines bestimmten Datenfelds ab, während eine set-Methode (Setter) ihren Wert verändert. Dies dient dem Prinzip der Kapselung und kann unter anderem dazu verwendet werden, ein bestimmtes Datenfeld read-only zu gestalten (wenn es keine Setter-Methode dazu gibt).

#### Namenskonventionen
Für Getter- und Setter-Methoden werden immer die gleichen Methodennamen verwendet. Als Präfix benutzen wir _get_ und _set_ gefolgt vom Namen des Datenfelds worauf sich die Methode bezieht.
```java
public class Car {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
```
```java
class Demo {
	public static void main(String[] args) {
		Car car = new Car();
		car.setSpeed(100);
		System.out.println(car.getSpeed());
	}
}
```

### Methoden überladen
In Java können wir Methoden überladen. Das heisst, wir können mehrere Methoden mit demselben Namen definieren, solange die Anzahl an Parametern oder die Datentypen der Parameter variiert. Beim Aufruf der Methode wird vom Compiler die entsprechende Definition ausgewählt.
```java
class Calculator {

	public double product(double x, double y) {
		return x * y;
	}

    // Overloading the function to handle three arguments
	public double product(double x, double y, double z) {
		return x * y * z;
	}
    
    // Overloading the function to handle int
	public int product(int x, int y) {
		return x * y;
	}
}
```
```java
class Demo {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double x = 10;
		double y = 20;
		double z = 5
		int a = 12;
		int b = 4;
		System.out.println(cal.product(x, y));
		System.out.println(cal.product(x, y, z));
		System.out.println(cal.product(a, b));
	}
}
```

Methoden, deren Parameter gleich sind (gleiche Anzahl, gleiche Datentypen) und sich lediglich in ihren Rückgabetypen unterscheiden, können nicht überladen werden, da der Compiler nicht in der Lage ist, zwischen ihren Aufrufen zu unterscheiden.

### Die Methoden equals() und hashCode()
Die Methoden *equals()* und *hashCode()* gehören zu den grundlegenden Java APIs.
Beide Methoden gehören automatisch zur öffentlichen Schnittstelle jeder Klasse, da sie durch die implizite Ableitung von der Object-Klasse geerbt werden (mehr dazu im Teil "Objektorientiertes Design" in diesem Modul).<br>
Ob die Default-Umsetzung beider Methoden ausreicht, wird aufgrund von den fachlichen Gegebenheiten entschieden und ggf. werden **beide** Methoden überschrieben.

#### equals()
Die Methode *equals()* ermöglicht uns das aus dem fachlichen Kontext stammende Gleichheitsverständnis im Code umzusetzen.<br>
Die Default-Umsetzung der Methode in der Object-Klasse definiert, dass zwei Objekte nur dann gleich sind wenn sie die gleiche Identität haben. Das heisst, zwei unterschiedliche Instanzen (also zwei Objekte) einer Klasse sind gemäss dieser Umsetzung nicht gleich auch wenn alle Felder der beiden Objekten mit den gleichen Werte befüllt werden. 
Aufgrund der fachlichen Gegebenheiten kann diese Definition der Gleichheit nicht korrekt sein. In so einem Fall muss die Methode *equals()* überschrieben werden.

Bei der Umsetzung müssen folgende Bedingungen für die Definition der Gleichheit bei nicht-null Objekten gemäss [API-Definition für equals()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)) erfüllt werden:<br>
- **Reflexivität**: Das Objekt liefert beim Vergleich mit sich selbst true.
- **Symmetrie**: Das Resultat des Vergleichs x mit y ist gleich wie das des Vergleichs y mit x. Es ist also egal wie verglichen wird.
- **Transivität**: Wenn x gleich y ist und y gleich z, dann ist x gleich z.
- **Konsistenz**: Egal wie häufig der Vergleich durchgeführt wird, es kommt immer dasselbe heraus, sofern sich der Inhalt der Objekte nicht verändert.
- **Behandlung von null**: Der Vergleich mit null liefert immer false.

#### hashCode()
Die Methode *hashCode()* sollte für jedes Objekt einen Hashwert (Fingerabdruck) liefern, der das Objekt möglichst eindeutig identifiziert.<br>
Der berechnete Hashwert ermöglicht einen effizienten und schnellen Zugriff auf ein bestimmtes Objekt innerhalb eines Hash-basierten Containers wie z.B. einer *HashMap*.<br>
Auch für diese Methode definiert die [API-Definition für hashCode()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode()) Bedingungen, welche erfüllt werden müssen damit die Methode zweckmässig verwendet werden kann:

- **Konsistenz**: Egal wie häufig hashCode() aufgerufen wird, es kommt stets dasselbe Resultat zurück, sofern der Inhalt des Objekts nicht geändert wurde.
- **Zusammenhang equals**: Zwei Objekte, die gemäss equals() gleich sind, müssen den gleichen Hashwert liefern.
- **Zusammenhang not-equals**: Zwei Objekte die gemäss equals() verschieden sind, müssen nicht zwingend unterschiedliche Hashwerte liefern. Grundsätzlich wäre es aber besser für die Performanz, wenn verschiedene Objekte auch verschiedene Hashwerte liefern würden.

In der Regel entscheiden wir uns aufgrund von fachlichen Gegebenheiten für die Überschreibung der Methode *equals()*. Die Überschreibung von *hashCode()* resultiert daraus als Konsequenz der Bedingung "Zusammenhang equals".
