---
title: "Java Generics Grundlagen"
linkTitle: "Java Generics Grundlagen"
weight: 6
description: >
  Modul #J2 - Generics I
---

#### Ziele
* Ich weiss, was generische Programmierung ist
* Ich weiss, was Typsicherheit ist und wie Typverletzung entsteht
* Ich kenne die Vorteile von Generics
* Ich weiss, wann Generics angewendet werden sollen
* Ich weiss, was "bounded types" sind und warum sie angewendet werden
* Ich weiss, was Wildcards im Kontext von Generics sind und wie sie verwendet werden
* Ich weiss, was mit Generics nach der Kompilierung passiert ("type erasure")
* Ich kann generische Klassen und Methoden definieren
* Ich kann generische Klassen und Methoden in meinem Code anwenden

---

## Einführung
Mit Generics sind im Java-Umfeld parametrisierte Datentypen gemeint.
So werden mit Generics Datentypen (Integer, String oder auch benutzerdefinierte Datentypen) als Parameter für Klassen, Interfaces und Methoden mitgegeben. 
Mit Generics ist es also möglich Klassen, Interfaces und Methoden zu schreiben, welche mit unterschiedlichen Datentypen arbeiten können.

Generics funktionieren nur mit Referenz-Datentypen (also nicht mit primitiven Datentypen) und werden nur während der Kompilierung ausgewertet.

## Typsicherheit
Typsicherheit ist einen Zustand, bei dem Datentypen gemäss ihren Definitionen verwendet werden und keine sog. Typverletzungen auftreten.

In der Regel wird bei einer Variable der Datentyp festgelegt. Diesen Datentyp schränkt die Menge der konkreten, zulässigen Werte für diese Variable ein.
Versucht man der Variable nun einen Wert ausserhalb diesen zulässigen Bereich zuzuweisen, so liegt eine Typverletzung vor.

Die Überprüfung der Typsicherheit in Java ist eine Aufgabe des Java-Compilers.
Wenn der Compiler eine Typverletzung zur "Compile-Zeit" entdeckt gibt es einen sog. Kompilierfehler, welcher davor warnt.
Wenn eine Typverletzung unentdeckt bleibt, können zur Laufzeit des Programms schwer analysierbare Fehler auftreten.

**Beispiel einer Typverletzung, welche vom Compiler entdeckt wird**

In der folgenden Klasse wird versucht, ein String zu einer Variable des Typs Integer zuzuweisen
```java
public class Test {
  public static void main(String[] args) {
    Integer myInteger;
    myInteger = "this is not an integer...";
  }
}
```

Beim Versuch, die Klasse zu kompilieren erscheint folgende Fehlermeldung:
![](../java-generics/typverletzung-compile-time.png)

## Warum Generics?
Programme, welche Generics verwenden, haben mehrere Vorteile gegenüber Programmen ohne Generics:
* **Wiederverwendbarer Code:** eine Klasse oder eine Methode kann einmal geschrieben werden und mit unterschiedlichen Datentypen verwendet werden.
* **Typsicherheit:** Generics lösen Fehler während der Kompilierung aus, welche ansonsten erst zur Laufzeit ausgelöst wären.
* **Individuelle Typ-Casting ist nicht nötig:** Wenn bei der Anwendung von Generics der konkrete Typ angegeben wird, muss danach kein Typ-Casting stattfinden.

Schauen wir wie die Typsicherheit eines Programms mit Generics verbessert werden kann.

Die Object-Klasse in Java ist die Super-Klasse aller anderen Klassen und eine Object-Referenz kann beliebige Objekte referenzieren.
Diese Features sind nicht typsicher. Auch durch das Verwenden von Polymorphismus können Typverletzungen entstehen.

**Beispiel Typverletzung, welche nicht zu einem Compiler-Fehler führt**

```java
import java.util.ArrayList;

class Test {
    public static void main(String[] args) {
        // ArrayList erstellen ohne den Typ der Daten darin zu definieren
        ArrayList hitchhikersInfo = new ArrayList();

        hitchhikersInfo.add("Douglas");
        hitchhikersInfo.add("Adams");
        hitchhikersInfo.add(42); // Der Compiler erlaubt diese Zuweisung, da wir den Datentyp in der ArrayList nicht definiert haben

        for (int i=0; i<=hitchhikersInfo.size(); i++) {
            System.out.println((String) hitchhikersInfo.get(i)); // diesen Typ-Casting wäre nicht nötig gewesen, wenn wir die ArrayListe richtig definiert hätten!
        }
    }
}
```
Diese Klasse kompiliert ohne Fehler. Der Compiler warnt zwar, dass hier eine unsichere Operation 
durchgeführt wird, aber er erlaubt diese Operation und die Kompilation ist erfolgreich. 
Beim Ausführen des Programms kommt es jedoch zu einem Laufzeitfehler vom Typ ClassCastException, weil versucht wird
ein Integer in einen String umzuwandeln (Typ-Casting):
![](../java-generics/typverletzung-run-time.png)

Generics helfen solche Laufzeitfehler mit sog. Typvariablen zu vermeiden.
Diese Typvariablen werden zur Zeit der Implementierung zunächst durch Platzhalter repräsentiert 
und dann zum Zeitpunkt der Anwendung konkretisiert.
Im obigen Beispiel hätte der Laufzeitfehler vermieden werden können, in dem wir die ArrayList als 
eine Liste von Strings definiert hätten:
```java
    // ArrayList mit Elementen vom Typ String
    ArrayList<String> hitchhikersInfo = new ArrayList<>();
    ...
    hitchhikersInfo.add(42); // Der Compiler erlaubt diese Zuweisung nicht mehr
```
Beim Versuch, die Klasse erneut zu kompilieren, kommt es zum folgenden Fehler und die Kompilierung schlägt fehl:
![](../java-generics/typverletzung-arraylist-compile-time.png)

## Generics in der Praxis
In Java gibt es zwei Typen von Generics: generische Methoden und generische Klassen.

Eine **generische Methode** kann - wie andere "normale" Methoden auch - Parameter und einen Rückgabewert enthalten.
Der Unterschied zu einer "normalen" Methode liegt darin, dass eine generische Methode sog. Typparameter bearbeitet.
Somit kann eine generische Methode mit unterschiedlichen Datentypen benutzt werden.

Eine **generische Klasse** wird genau gleich wie eine nicht-generische Klasse umgesetzt.
Der Unterschied liegt darin, dass die generische Klasse einen oder mehrere Typparameter definiert.

### Typparameter definieren
In generischen Klassen wie auch in generischen Methoden, werden Typparameter mittels eines Grossbuchstabens definiert, 
welcher innerhalb spitziger Klammern geschrieben wird z.B: &lt;T&gt; oder &lt;I&gt;.

Multiple Typparameter werden durch ein Komma getrennt:  &lt;T, V&gt;

#### Typparameter Namenskonvention
Die Buchstaben, welche für die Definition von Typparametern verwendet werden, nutzen die folgende Namenskonvention: 

| Typname | Zweck   |
|---------|---------|
| T       | Type    |
| E       | Element |
| K       | Key     |
| N       | Number  |
| V       | Value   |

### Generische Klasse
Um generische Klassen zu verwenden, wird zunächst die Klasse mit einem Typparameter definiert 
und bei der Anwendung dieser Klasse (bei der Instanziierung) wird innerhalb der spitzigen Klammern 
der konkrete Datentyp geschrieben.

**Beispiel einer benutzer-definierten, generischen Klasse**

```java
// <T> definiert einen Typparameter
class Test<T> {
    // Deklaration einer Member-Variable vom Typ T
    T obj;
    
    // Konstruktor, erhält ein Object vom Typ T und initialisiert die Member-Variable damit
    Test(T obj) {
        this.obj = obj;
    }
    
    // die Getter-Methode liefert ein Objekt vom Typ T zurück
    public T getObject() {
      return this.obj;
    }
}
```
Sofern sich die obige Klasse auf dem Klassenpfad befindet, kann sie nun wie folgt verwendet werden:
```java
class MyProgram {
    public static void main(String[] args) {
        // Instanziieren der generischen Klasse und setzen den Typ auf Integer
        Test<Integer> integerObject = new Test<Integer>(42);
        System.out.println(integerObject.getObject()); // Output: 42
  
        // instance of String type
        Test<String> stringObject = new Test<String>("Generics are great!");
        System.out.println(stringObject.getObject()); // Output: Generics are great!
    }
}
```
In diesem Beispiel wurde dieselbe generische Klasse einmal mit einem Integer und einmal mit String 
verwendet. Dabei wurde die Typsicherheit sichergestellt.

### Generische Methode
Wie bei generischen Klassen werden auch bei generischen Methoden zunächst die Typparameter 
als Argumente für die Methode definiert und beim Aufruf der Methode werden die konkreten Datentypen mitgegeben.

**Beispiel einer generischen Methode**

```java
public class Test {
    // Definition einer generischen Methode
    static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static void main(String[] args) {
        // Die generische Methode wird mit einem Integer-Argument aufgerufen
        // Achtung: hier wird nicht das primitive Typ "int" verwendet sondern die Wrapper-Klasse Integer!
        genericDisplay(42); // Output: java.lang.Integer = 42
  
        // Die generische Methode wird mit einem String-Argument aufgerufen
        genericDisplay("Generics are great!!"); // Output: java.lang.String = Generics are great!!
  
        // Die generische Methode wird mit einem Double-Argument aufgerufen
        // Achtung: hier wird nicht das primitive Typ "double" verwendet sondern die Wrapper-Klasse Double!
        genericDisplay(42.0);  // Output: java.lang.Double = 42.0

        // Primitive Typen können nicht mit Generics verwendet werden 
        // aber eine ArrayList aus einem Array mit primitiven Typen ist erlaubt, weil Arrays Referenz-Typen sind!
        ArrayList<int[]> arrayListOfIntArray = new ArrayList<>();
        int[] oneAndTwo = {1, 2};
        int[] threeAndFour = {3, 4};
        arrayListOfIntArray.add(oneAndTwo);
        arrayListOfIntArray.add(threeAndFour);
        
        genericDisplay(arrayListOfIntArray);  // Output: java.util.ArrayList = [[I@6b2fad11, [I@79698539]
    }
}
```

Bei der Definition von generischen Methoden gibt es einen Unterschied zwischen statischen Methoden und Member-Methoden einer Klasse.

Bei Member-Methoden, wird die generische Deklaration aus der Klassendefinition verwendet.
Das heisst, der Typparameter, welche bei der Klassendefinition deklariert wird, 
wird dasselbe sein wie denjenigen, welche in der Member-Methode verwendet wird. 

Statische Methoden brauchen jedoch ihre eigen generische Deklaration - vor dem Rückgabewert-Typ.
Das bedeutet, dass der Typparameter einer statischen Methode nicht vom selben Typ sein muss 
wie demjenigen aus der Klassendefinition (auch wenn beide Typparameter gleich heissen!).

```java
public class Test<T> {
    T obj;
    
    // Hier ist T nicht zwingend gleicher Typ wie denjenigen aus der Klassendefinition 
    public static <T> void staticMethod(T element)  {...}
    
    // Hier entspricht der Rückgabewert-Typ denjenigen aus der Klassendefinition
    public T getObject() {
      return this.obj;
    }
 }
```

## Bounded Typparameter
Es gibt Situationen, in denen es Sinn macht die Datentypen, welche als Argument in einem 
parametrisierten Typ verwendet werden dürfen, einzuschränken. Zum Beispiel, eine Methode, 
welche nur mit Zahlen funktionieren kann, sollte keine Datentypen zulassen, 
welche keine Zahl darstellen. Zu diesem Zweck werden sog. Bounded Type-Parameter verwendet.

Bounded Typparameter schränken die möglichen Typen schon bei der Erstellung der generischen Klasse/Methode ein.

Um ein Bounded Typparameter zu definieren wird bei der Definition des Typparameters noch das Wort "extends" und der begrenzende Typ ("upper bound type") hinzugefügt:

Beispiel: **&lt;T extends Number&gt;**: T muss zwingend vom Typ Number sein

Im folgenden Beispiel wird die Klasse "ZooExhibit" (Zoogehege) definiert, welche unterschiedlichen Arten von Tieren beherbergen kann:
```java
public class ZooExhibit<T> {
    private List<T> animals;
    ...
}
```
Wenn wir die Klasse so definieren, könnte T durch alle mögliche Datentypen ersetzt werden:
```java
public class Main {
    public static void main(String[] args) {
        // T kann gemäss Definition auch z.B ein Integer sein!
        // auch wenn ein Integer im Zoogehege nichts verloren hat...
        ZooExhibit<Integer> zooExhibit = new ZooExhibit<>();
    }
}
```
Angenommen, wir haben eine Klasse "Animal" (mit Subklassen wie "Elephant", "Zebra" usw.), können wir
unsere ZooExhibit-Klasse so definieren, dass nur Animal-Typen verwendet werden dürfen:
```java
public class Animal {
}

public class Elephant extends Animal {
}

public class Zebra extends Animal {
}

public class ZooExhibit<T extends Animal> {
    private List<T> animals;
    ...
}
```
Wenn wir nun unserem ZooExhibit befüllen möchten, erlaubt uns der Compiler dies nur mit Animal oder mit einer seinen Subklassen zu tun:
```java
public class Main {
    public static void main(String[] args) {
        // Die folgende Zeile wird nun vom Compiler nicht akzeptiert:
        ZooExhibit<Integer> zooExhibit = new ZooExhibit<>();
        
        // Zoogehege für Elefanten ist erlaubt, da Elephant ein Animal ist:
        ZooExhibit<Elephant> elephantExhibit = new ZooExhibit<>();

        // Dasselbe gilt für Zebras:
        ZooExhibit<Zebra> zebraExhibit = new ZooExhibit<>();
    }
}
```

## Wildcards
In der generischen Programmierung wird das Fragezeichen (?) als Wildcard bezeichnet.
Es repräsentiert eine Referenz auf einen unbekannten Typ.

Um zu verstehen, wozu es Wildcards braucht, schauen wir uns ein Beispiel an:
Angenommen, wir haben die Animal, Elephant und Zebra Klassen vom vorherigen Abschnitt definiert und dazu auch die folgende generische Klasse:
```java
public class AnimalList<T extends Animal> {
    private final List<T> animals = new ArrayList<>();
    ...
}
```
Nun möchten wir diese Klasse in einer anderen Klasse wie folgt verwenden:
```java
public class Zoo {
    public static void main(String[] args) {
        AnimalList<Elephant> elephants = new AnimalList<>();
        AnimalList<Zebra> zebras = new AnimalList<>();
        
        // Der Compiler gibt bei folgenden Zeilen eine Fehlermeldung!
        printAnimalList(elephants);
        printAnimalList(zebras);
    }
    
    private static void printAnimalList(AnimalList<Animal> animals) {
        System.out.println(animals)
    }
}
```
Obwohl Elephant und auch Zebra beide ein Animal sind, gibt der Compiler eine Fehlermeldung beim Versuch,
die Methode *printAnimalList* mit AnimalList<Elephant> resp. mit AnimalList<Zebra> aufzurufen.

Dieser Ansatz (die Super-Klasse zu verwenden, damit die Subklassen auch am gleichen Ort verwendet sein dürfen),
funktioniert zwar mit Arrays, nicht aber mit generischen Klassen.

Der Grund dafür ist der Zeitpunkt der Typ-Prüfung:
Bei Arrays wird erst zur Laufzeit auf den richtigen Typ geprüft (und darum werden allfällige Fehler erst zur Laufzeit entdeckt).
Bei Generics wird diese Prüfung durch den Compiler übernommen da sie zur Laufzeit wegen dem sog. Type-Erasure (dazu später) nicht erfolgen kann.

Der Einsatz von Wildcards ermöglicht es, jeden beliebigen generischen Typ zu akzeptieren.
Wenn wir nun die Methode *printAnimalList* mit einer Wildcard definieren, kompiliert der Rest vom Code einwandfrei:
```java
    private static void printAnimalList(AnimalList<?> animals) {
        System.out.println(animals)
    }
```
Wenn man <?> verwendet, wird dies "unbeschränkter Wildcard Typ" ("unbounded wildcard") genannt.
Es besteht aber auch die Möglichkeit, Wildcards zu beschränken und zwar in zwei verschiedene Arten:
* **Upper-Bound Beschränkung:** Beschränkung auf einen Typ und dessen Kindtypen. Die Syntax sieht dann z.B. so aus: **<? extends Number>** (also irgendein Typ, solange er vom Typ Number oder einer Subklasse davon ist)
* **Lower-Bound Beschränkung:** Beschränkung auf einen Typ und dessen Supertypen. Die Syntax sieht dann z.B. so aus: **<? super Integer>** (also irgendein Typ, solange er vom Typ Integer oder einer Superklasse davon ist)

## Type Erasure
Generics werden nur vom Compiler behandelt und verschwinden zur Laufzeit.
Das heisst, der Compiler entfernt beim Kompilieren alle Informationen, die durch Generics definiert wurden.
Das bedeutet, dass zur Laufzeit nicht bestimmt werden kann, welcher generische Typ verwendet wurde.
Grund für dieses Verhalten war die Notwendigkeit zur Bewahrung der Abwärtskompatibilität zu älteren Java-Versionen, welche keine Generics kennen.

Das Entfernen der generischen Informationen heisst "type erasure" und der Compiler wendet dies an um:
* Alle Typparameter in generischen Typen mit ihren "bound"-Typen (falls definiert) oder mit Object umzutauschen. Der prduzierte Bytecode beinhaltet dann nur "normale" Klassen, Interfaces und Methoden.
* Type-Casting dort wo nötig hinzuzufügen, um die Typsicherheit bewahren zu können
* Sog. Bridge-Methoden zu generieren, um Polymorphismus in erweiterte generische Typen zu bewahren
