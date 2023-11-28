---
title: "Instanzmethoden"
linkTitle: "Instanzmethoden"
weight: 7
description: >
  Modul #J2
---

## Ziele
* Ich kann alle Komponenten auswendig aufzählen, die zu einer Methodendeklaration dazugehören.
* Ich kann auswendig die Regeln aufzählen, die ein Methodenname einhalten sollte (Konventionen).
* Ich schreibe Getter- und Setter-Methoden gemäss Namenskonventionen.
* Ich kann in eigenen Worten erklären, warum der Zugriffsmodifikator einer Methode so restriktiv wie möglich gewählt werden sollte.
* Ich kann die Voraussetzungen, um Methoden überladen zu können, vollständig aufzählen.
* Ich kann in eigenen Worten die Umstände erläutern, wann die `equals`- und die `hashCode`-Methode überschrieben werden sollten.
* Ich kann in eigenen Worten die Bedingungen beschreiben, welche bei der Überschreibung der Methode `equals` erfüllt werden müssen.
* Ich kann in eigenen Worten die Bedingungen beschreiben, welche bei der Überschreibung der Methode `hashCode` erfüllt werden müssen.

## Instanzmethoden
Methoden werden benutzt, um Funktionalitäten zur Verfügung zu stellen. Diese Funktionalitäten reichen von einfachen Änderungen am Zustand eines Objekts bis zu komplexen Algorithmen zur Berechnung von mathematischen Dingen. Hier passiert also die Magie in einer Applikation.
Diese Methoden können also entweder den Inhalt von Datenfelder ändern oder ihre Werte verwenden, um eine bestimmte Berechnung durchzuführen.

Eine Methodendeklaration besteht aus bis zu sieben Komponenten:
1. Zugriffsmodifikator: `public`, `protected`, `private` oder package-private. Der Zugriffsmodifikator sollte immer so restriktiv wie möglich gewählt werden.
2. Sonstige Modifikatoren. Beispielsweise `static` oder `synchronized`.
2. Rückgabewert. Der Datentyp des von der Methode zurückgegebenen Werts oder `void`, wenn die Methode keinen Wert zurückgibt.
3. Methodenname / Bezeichner.
4. Parameterliste in Klammern. Eine durch Kommas getrennte Liste von Eingabeparametern (Datentyp + Bezeichner). Wenn keine Parameter benötigt werden, genügt die Angabe der beiden Klammern.
5. Exceptions (also welche Fehler, die die Methode wirft). Dazu mehr später im Modul Exception Handling.
6. Methodenkörper (der Code in geschweiften Klammern, der die Methode ausführt).

### Namenskonventionen für Methoden
Methodennamen sollen - per Konvention - folgende Regeln einhalten:
* Erster Buchstabe ist immer klein.
* CamelCase: Alle Buchstaben sind klein. Wenn der Methodenname aus mehreren Worten besteht, wird jeweils der erste Buchstabe ab dem zweiten Wort grossgeschrieben. Beispiele: `equals`, `printThisToConsole`.
* Der Methodenname soll ein Verb enthalten, welches die Funktionalität der Methode beschreibt. Wenn es dem Verständnis der Funktionalität dient, wird dieses Verb zusammen mit einem Nomen zusammengesetzt.
* Der Methodenname soll möglichst aussagekräftig sein.
* Statt Abkürzungen sollen die einzelnen Wörter möglichst ausgeschrieben werden (ausser es handelt sich um sehr bekannte Abkürzungen).

### Getter und Setter
Eine `get`-Methode (_Getter_) ruft den Wert eines bestimmten Datenfelds ab und gibt diesen Wert zurück, während eine `set`-Methode (_Setter_) ihren Wert verändert. Dies dient dem _Prinzip der Kapselung_ und kann unter anderem dazu verwendet werden, ein bestimmtes Datenfeld als read-only (nur lesbar) gegen aussen zu gestalten (wenn es keine Setter-Methode dazu gibt).

#### Namenskonventionen
Für Getter- und Setter-Methoden werden immer die gleichen Methodennamen verwendet. Als Präfix benutzen wir `get` und `set` gefolgt vom Namen des Datenfelds worauf sich die Methode bezieht.
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
In Java können wir Methoden überladen. Das heisst, wir können mehrere Methoden mit demselben Namen definieren, solange die Anzahl an Parametern oder die Datentypen der Parameter variieren. Beim Aufruf der Methode wird vom Compiler die entsprechende Definition ausgewählt.
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
Die Methoden `equals()` und `hashCode()` gehören zu den grundlegenden Java APIs.
Beide Methoden gehören automatisch zur öffentlichen Schnittstelle jeder Klasse, da sie durch die implizite Ableitung von der Object-Klasse geerbt werden (mehr dazu im Modul "Objektorientiertes Design (OOD)").

#### equals()
Möchtest du überprüfen, ob zwei Objekte den gleichen Wert repräsentieren, dann verwendest du die Methode `equals()`.

Die Default-Umsetzung der Methode in der Object-Klasse definiert, dass zwei Objekte nur dann gleich sind, wenn sie die gleiche Identität haben. Das heisst, zwei unterschiedliche Instanzen (also zwei Objekte) einer Klasse sind gemäss dieser Umsetzung nicht gleich auch wenn alle Felder der beiden Objekten mit den gleichen Werte befüllt werden.

Aufgrund der fachlichen Gegebenheiten kann diese Definition der Gleichheit nicht korrekt sein. In so einem Fall muss die Methode `equals()` überschrieben werden.

Bei der Umsetzung müssen folgende Bedingungen für die Definition der Gleichheit bei nicht-`null` Objekten gemäss [API-Definition für equals()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)) erfüllt werden:
- **Reflexivität**: Das Objekt liefert beim Vergleich mit sich selbst true.
- **Symmetrie**: Das Resultat des Vergleichs x mit y ist gleich wie das des Vergleichs y mit x. Es ist also egal wie verglichen wird.
- **Transivität**: Wenn x gleich y ist und y gleich z, dann ist x gleich z.
- **Konsistenz**: Egal wie häufig der Vergleich durchgeführt wird, es kommt immer dasselbe heraus, sofern sich der Inhalt der Objekte nicht verändert.
- **Behandlung von `null`**: Der Vergleich mit `null` liefert immer false.

Eine mögliche Implementierung von `equals()` für die Klasse `Car` könnte wie folgt aussehen:

```java
@Override
public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Car car = (Car) other;
    return speed == car.speed;
}
```

(Die Angabe ("Annotation") von `@Override` ist freiwillig. Sie wird angegeben, wenn eine bestehende Methode (z.B. von der Klasse `Object`) überschrieben wird. Diese Angabe bewirkt, dass es ein Kompilierfehler gibt, falls keine bestehende Methode überschrieben wird.)

Die `equals()`-Methode kannst du wie eine ganz normale Methode aufrufen, wird aber meistens in einer `if`-Anweisung verwendet:

```java
Car carA = new Car();
carA.setSpeed(3);
Car carB = new Car();

if (carA.equals(carB)){
    System.out.println("Both cars are equal.");
} else {
    System.out.println("The cars are different.");
}
```

#### hashCode()
Die Methode `hashCode()` sollte für jedes Objekt einen Hashwert (Fingerabdruck) liefern, der das Objekt möglichst eindeutig identifiziert.

Der berechnete Hashwert ermöglicht einen effizienten und schnellen Zugriff auf ein bestimmtes Objekt innerhalb eines Hash-basierten Containers wie z.B. einer `HashMap`.

Auch für diese Methode definiert die [API-Definition für hashCode()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#hashCode()) Bedingungen, welche erfüllt werden müssen, damit die Methode zweckmässig verwendet werden kann:

- **Konsistenz**: Egal wie häufig `hashCode()` aufgerufen wird, es kommt stets dasselbe Resultat zurück, sofern der Inhalt des Objekts nicht geändert wurde.
- **Zusammenhang equals**: Zwei Objekte, die gemäss `equals()` gleich sind, müssen den gleichen Hashwert liefern.
- **Zusammenhang not-equals**: Zwei Objekte die gemäss `equals()` verschieden sind, müssen nicht zwingend unterschiedliche Hashwerte liefern. Grundsätzlich wäre es aber besser für die Performanz, wenn verschiedene Objekte auch verschiedene Hashwerte liefern würden.

In der Regel entscheiden wir uns aufgrund von fachlichen Gegebenheiten für die Überschreibung der Methode `equals()`. Die Überschreibung von `hashCode()` resultiert daraus als Konsequenz der Bedingung "Zusammenhang equals".
