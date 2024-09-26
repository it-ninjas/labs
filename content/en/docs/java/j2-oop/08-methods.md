---
title: "Instanzmethoden"
linkTitle: "Instanzmethoden"
weight: 8
description: >
  Modul #J2
---

## Ziele
* Ich kann alle Komponenten auswendig aufzählen, die zu einer Methodendeklaration gehören.
* Ich kann auswendig die Regeln aufzählen, die ein Methodenname einhalten sollte (Konventionen).
* Ich schreibe Getter- und Setter-Methoden gemäss Namenskonventionen.
* Ich kann in eigenen Worten erklären, warum der Zugriffsmodifikator einer Methode so restriktiv wie möglich gewählt werden sollte.
* Ich kann die Voraussetzungen, um Methoden überladen zu können, vollständig aufzählen.
* Ich kann in eigenen Worten die Umstände erläutern, wann die `equals`- und die `hashCode`-Methode überschrieben werden sollten.
* Ich kann in eigenen Worten die Bedingungen beschreiben, welche bei der Überschreibung der Methode `equals` erfüllt werden müssen.
* Ich kann in eigenen Worten die Bedingungen beschreiben, welche bei der Überschreibung der Methode `hashCode` erfüllt werden müssen.

## Instanzmethoden
Methoden sind dafür da, bestimmte Aufgaben auszuführen. Sie können den Zustand eines Objekts ändern oder Berechnungen durchführen. Kurz gesagt, hier passiert die "Magie" in einer Anwendung.
Zum Beispiel kann eine Methode den Wert eines Datenfeldes ändern (wie die Geschwindigkeit eines Autos) oder eine Berechnung durchführen (wie das Berechnen der benötigten Zeit, um eine bestimmte Strecke zurückzulegen).


Eine Methodendeklaration besteht aus bis zu sieben Komponenten
1. **Zugriffsmodifikator**: `public`, `protected`, `private` oder package-private. Er bestimmt, wer auf die Methode zugreifen kann. Wichtig: Wähle immer den Modifikator, der den Zugriff so eingeschränkt wie möglich hält.
2. **Andere Modifikatoren**: Beispielsweise `static` oder `synchronized`.
   - `static`: Wenn eine Methode als `static` deklariert wird, gehört sie zur Klasse und nicht zu einer Instanz der Klasse. Das bedeutet, dass du die Methode aufrufen kannst, ohne ein Objekt der Klasse zu erstellen. Zum Beispiel: `Math.abs()`. Das wird später in der objektorientierten Programmierung wichtig, musst du jetzt aber noch nicht verstehen.
   - `synchronized`: Dieser Modifikator sorgt dafür, dass die Methode nur von einem Thread gleichzeitig ausgeführt werden kann. Das ist wichtig, wenn mehrere Threads gleichzeitig auf dieselben Daten zugreifen und diese ändern, um Fehler zu vermeiden.
3. **Rückgabewert**: Das ist der Datentyp, den die Methode zurückgibt. Wenn nichts zurückgegeben wird, verwendet man `void`.
4. **Methodenname**: Der Name der Methode, zum Beispiel `calculateTimeToDistance`.
5. **Parameterliste**: Die Werte, die die Methode als Eingabe bekommt. Das ist eine Liste in Klammern, wie zum Beispiel `(int distance)`, wobei auch mehrere Parameter erlaubt sind. Wenn keine Parameter gebraucht werden, lässt man die Klammern leer.
6. **Ausnahmen (Exceptions)**: Hier wird festgelegt, welche Fehler die Methode auslösen kann. Mehr dazu gibt es später im Modul "Exception Handling".
7. **Methodenkörper**: Der Code in geschweiften Klammern {}, der die Methode ausführt.

### Beispiel: Methode für ein Auto

Schauen wir uns eine Methode (`calculateTimeToDistance`) für ein Auto an:
```java
public class Auto{
    // Ein Datenfeld für die Geschwindigkeit des Autos (in km/h)
    private int speedInKmh;

    // Eine Methode, um die Zeit zu berechnen, die benötigt wird, um eine bestimmte Distanz (distance) zu überwinden
    public double calculateTimeToDistance(int distanceInKm) throws ArithmeticException  {
        return (double) distance / this.speed;
    }
}
```

Erklärung der Methode:
- **Zugriffsmodifikator**: `public` - Die Methode kann von aussen aufgerufen werden.
- **Andere Modifikatoren**: Keine.
- **Rückgabewert**: `double` - Die Methode gibt die benötigte Zeit in Stunden zurück, daher der Datentyp double.
- **Methodenname**: `calculateTimeToDistance` - Der Name sagt klar aus, was die Methode macht.
- **Parameterliste**: `int distanceInKm` - Die Methode braucht die Distanz  als Eingabewert.
- **Ausnahmen (Exceptions)**: `throws ArithmeticException`  - Falls die Geschwindigkeit 0 ist, könnte es zu einer Exception kommen, weil eine Division durch 0 nicht möglich ist. Dies wird in einem späteren Kapitel genauer erklärt.
- **Methodenkörper**: Die Berechnung wird durchgeführt, indem die Distanz durch die Geschwindigkeit geteilt wird.

### Namenskonventionen für Methoden
Methodennamen sollen - per Konvention - folgende Regeln einhalten:
* Der erste Buchstabe ist immer klein.
* Verwende CamelCase: Das bedeutet, dass alle Buchstaben des ersten Worts klein geschrieben werden. Ab dann wird jeweils der erste Buchstaben von jedem Wort gross geschrieben. Beispiele: `equals`, `printThisToConsole`.
* Der Methodenname soll ein Verb enthalten, welches die Funktionalität der Methode beschreibt. Wenn es dem Verständnis der Funktionalität dient, wird dieses Verb zusammen mit einem Nomen zusammengesetzt.
* Der Name sollte möglichst klar und verständlich sein, damit man sofort weiss, was die Methode macht.
* Vermeide Abkürzungen, schreibe die Wörter lieber aus (ausser es sind sehr bekannte Abkürzungen).

### Getter und Setter
Eine `get`-Methode (auch **Getter** genannt) holt den Wert eines bestimmten Datenfelds und gibt ihn zurück. 
Eine `set`-Methode (auch **Setter** genannt) ändert den Wert dieses Datenfelds. 
Das Ganze gehört zum **Prinzip der Kapselung**, was bedeutet, dass Daten sicher verwaltet werden.

Du fragst dich vielleicht: **Warum nicht einfach alle meine Variablen als `public` deklarieren?** 
Das klingt doch einfacher, oder? Aber das Problem ist, dass jeder Teil deines Programms dann direkt auf die Daten zugreifen und sie ändern könnte – auch unbeabsichtigt. 
Mit `get`- und `set`-Methoden kannst du kontrollieren, wer auf die Daten zugreifen oder sie verändern darf. Zum Beispiel auch, wenn andere Entwickler auf deinem Code arbeiten.
Zum Beispiel: Wenn du nur eine `get`-Methode ohne `set`-Methode erstellst, machst du das Datenfeld von ausserhalb nur lesbar – man kann es also nicht ändern.

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
In Java können wir Methoden überladen. 
Das heisst, wir können mehrere Methoden mit demselben Namen definieren, solange die Anzahl an Parametern oder die Datentypen der Parameter variieren. 
Beim Aufruf der Methode wird vom Compiler die entsprechende Definition ausgewählt.
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
		double z = 5;
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
Die Methoden `equals()` und `hashCode()` sind wichtige Bestandteile der Java-APIs. Sie sind automatisch in jeder Klasse vorhanden, weil sie von der **Object-Klasse** geerbt werden. 
Das bedeutet, dass jede Klasse in Java diese beiden Methoden hat, auch wenn du sie nicht selbst hinzufügst. 
Mehr darüber erfährst du im Modul "Objektorientiertes Design (OOD)".


#### equals()
Du hast bereits im Thema String gesehen, dass man mit `equals()` überprüft, ob zwei Objekte denselben Wert haben. 
Der Unterschied zu `==` ist, dass `==` nur prüft, ob beide Objekte exakt dasselbe sind, also die gleiche Speicheradresse haben. 
Mit `equals()` hingegen vergleichst du den Inhalt der Objekte.

Standardmässig definiert die `equals()`-Methode in der **Object-Klasse**, dass zwei Objekte nur dann gleich sind, wenn sie exakt die gleiche Identität haben. 
Das bedeutet, dass zwei unterschiedliche Objekte derselben Klasse als nicht gleich angesehen werden, selbst wenn alle ihre Felder die gleichen Werte enthalten.
Es wird also die Speicheradresse mit `==` verlgichen:
```java
// Der Code aus der Klasse Object in Java
public boolean equals(Object obj) {
    return (this == obj);
}
```

Das passt aber nicht immer, besonders wenn du den Inhalt der Objekte vergleichen möchtest oder du nur spezifische Eigenschaften, wie zum Beispiel eine ID vergleichen möchtest. 
In diesem Fall musst du die `equals()`-Methode überschreiben, um die Gleichheit richtig zu definieren.

Bei der Umsetzung müssen folgende Bedingungen für die Definition der Gleichheit bei nicht-`null` Objekten gemäss [API-Definition für equals()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)) erfüllt werden:
- **Reflexivität**: Das Objekt liefert beim Vergleich mit sich selbst true.
- **Symmetrie**: Wenn Objekt x gleich Objekt y ist, dann muss y auch gleich x sein.
- **Transivität**: Wenn x gleich y ist und y gleich z, dann muss auch x gleich z sein.
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
carA.setSpeed(4);

if (carA.equals(carB)){
    System.out.println("Both cars are equal.");
} else {
    System.out.println("The cars are different.");
}
// Output: The cars are different.
```

#### hashCode()
Die Methode `hashCode()` erstellt für jedes Objekt einen **Hashwert** – das ist wie ein Fingerabdruck, der das Objekt möglichst eindeutig beschreibt. 
Dieser Hashwert wird aus den Feldern des Objekts berechnet. Der Hashwert ist eine Zahl, der Rückgabetyp von `hashCode` ist also ein `int`.

Falls du genauer erfahren möchtest, wie Hashing funktioniert, kannst du diesen [Beitrag](https://www.tessa-dam.com/de/wiki-de-reader/hash) lesen.

Der Hashwert ermöglicht es Java, Objekte effizient zu vergleichen und zu verwalten. Wichtig ist, dass der Hashwert immer dieselbe Zahl liefert, solange sich das Objekt nicht ändert.

Auch für diese Methode definiert die [API-Definition für hashCode()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#hashCode()) Bedingungen, welche erfüllt werden müssen, damit die Methode zweckmässig verwendet werden kann:

- **Konsistenz**: Jedes Mal, wenn `hashCode()` aufgerufen wird, muss derselbe Wert zurückgegeben werden, solange das Objekt unverändert bleibt.
- **Zusammenhang mit `equals()`**: Zwei Objekte, die gemäss `equals()` gleich sind, müssen den gleichen Hashwert liefern.
- **Zusammenhang bei ungleichen Objekten**: Zwei Objekte die gemäss `equals()` verschieden sind, müssen nicht zwingend unterschiedliche Hashwerte liefern. Grundsätzlich wäre es aber besser für die Performanz, wenn verschiedene Objekte auch verschiedene Hashwerte liefern würden.

Wenn du die Methode `equals()` überschreibst, solltest du auch `hashCode()` überschreiben, damit beide zusammen korrekt funktionieren.

Hier ein Beispiel für die Klasse `Car`, wie eine mögliche `hashCode()`-Methode aussehen könnte. Hier haben wir 2 weitere Felder aus Demonstrationsgründen hinzugefügt:

```java
public class Car {
    private int speed;
    private String brand;
    private float remainingAmountOfFuel;
    
    @Override
    public int hashCode() {
        return Objects.hash(speed, brand, remainingAmountOfFuel);
    }
}
```

Oft sieht man statt `Objects.hash(...)` auch eine eigene Implementation wie die folgende:

```java
@Override
public int hashCode() {
	int result = speed;
	result = 31 * result + (brand != null ? brand.hashCode() : 0);
	result = 31 * result + (remainingAmountOfFuel != +0.0f ? Float.floatToIntBits(remainingAmountOfFuel) : 0);
	return result;
}
```