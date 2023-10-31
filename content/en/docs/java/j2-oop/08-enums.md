---
title: "Enums"
linkTitle: "Enums"
weight: 8
description: >
  Modul #J2
---
## Ziele
* Ich kann auswendig in eigenen Worten beschreiben, was Enums sind und wann sie benutzt werden.
* Ich setze Enums in einem konkreten Code-Beispiel selbständig und korrekt ein.
* Ich setze Methoden und Konstruktoren in Enums in einem konkreten Code-Beispiel selbständig und korrekt ein.

## Enums
Enums (kurz für "enumeration", zu Deutsch "Aufzählung") bieten die Möglichkeit, vordefinierte Konstanten zusammen zu gruppieren.
Enums werden dann verwendet, wenn alle mögliche Werte zur Kompilierzeit bekannt sind (z.B. alle Wochentage, alle Planeten im Sonnensystem usw.).

In Java sind Aufzählungstypen als Klassen realisiert und die definierten Werte sind als Objekte implementiert. 
Daraus ergeben sich folgenden nützlichen Eigenschaften:
- Enums können Konstruktoren, Instanzvariablen und Instanz-Methoden beinhalten
- Der Name der Enum-Werte kann mithilfe der `toString()`-Methode (oder mit dem Keywort `this`) im Klartext ausgegeben werden.
- Mithilfe des `==`-Operators kann auf Gleichheit geprüft werden.
- Enumerations können in `switch`-Anweisungen verwendet werden.
- Mithilfe der `values`-Methode wird ein Array zurückgegeben, das alle Elemente der Enumeration enthält. In Verbindung mit der erweiterten `for`-Schleife (for-each) können die Elemente sehr einfach durchlaufen werden.

Obwohl Java Enums als Klassen realisiert werden, müssen sie nicht mit `new` instanziiert werden.
Im Gegensatz zu Klassen können Java-Enums weder erweitert werden noch von anderen Klassen erben.

### Enums definieren
Enums können innerhalb oder ausserhalb einer Klasse definiert werden (nicht aber innerhalb einer Methode!).
Um ein Enum zu definieren, wird das Java-Schlüsselwort `enum` verwendet.

Die erste Zeile(n) innerhalb der Enum-Definition soll eine kommagetrennte Liste von Konstanten beinhalten (in Java per Konvention mit Grossbuchstaben geschrieben).
Danach werden allfällige Variablen, Methoden und Konstruktoren definiert.

Jede Enum-Konstante ist implizit **`public static final`**.
Weil es `static` ist, kann über den Enum-Namen darauf zugegriffen werden.
Weil es `final` ist, kann es nicht erweitert werden.

#### Beispiel: Definition ausserhalb einer Klasse
```java
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class DailyPlanner {
    private static void dailyMood(Weekday weekday) {
        switch (weekday) {
            case MONDAY:
                System.out.println("I don't like Mondays");
                break;
            case FRIDAY:
                System.out.println("Thank God it's Friday");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("There aren't enough days in the weekend");
                break;
            default:
                System.out.println("Some Midweek days feel like Mondays when I wish they were Fridays");
                break;
        }
    }

    public static void main(String[] args) {
        dailyMood(Weekday.MONDAY);
    }
}
```

#### Beispiel: Definition innerhalb einer Klasse
```java
public class DailyPlanner {
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        System.out.println("I like " + Weekday.SATURDAY + " and " + Weekday.SUNDAY + " the best");
    }
}
```

### Enum mit einem Konstruktor
Ein Enum-Konstruktor wird für jeder Enum-Konstante während dem Klassenladen des Enums ausgeführt.
Es ist unmöglich, Enum-Objekte explizit zu erzeugen. Darum kann ein Enum-Konstruktor auch nicht direkt aufgerufen werden.

#### Beispiel: Enum mit einem Konstruktor
```java
enum Weekday {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
    
    final int dayNumber;
    Weekday(int dayNumber) {
        this.dayNumber = dayNumber;
        System.out.println("Konstruktor für Tag " + this.toString() + " wird ausgeführt. Das ist der " + this.dayNumber+ ". Tag in der Woche");
    }
}

public class TestDays {
    public static void main(String[] args) {
        Weekday monday = Weekday.MONDAY; // Output:
                                         // Konstruktor für Tag MONDAY wird ausgeführt. Das ist der 1. Tag in der Woche
                                         // Konstruktor für Tag TUESDAY wird ausgeführt. Das ist der 2. Tag in der Woche
                                         // Konstruktor für Tag WEDNESDAY wird ausgeführt. Das ist der 3. Tag in der Woche
                                         // Konstruktor für Tag THURSDAY wird ausgeführt. Das ist der 4. Tag in der Woche
                                         // Konstruktor für Tag FRIDAY wird ausgeführt. Das ist der 5. Tag in der Woche
                                         // Konstruktor für Tag SATURDAY wird ausgeführt. Das ist der 6. Tag in der Woche
                                         // Konstruktor für Tag SUNDAY wird ausgeführt. Das ist der 7. Tag in der Woche
        System.out.println(monday); // Output: MONDAY
    }
}
```

### Enum mit Methoden
Ein Enum kann konkrete wie auch abstrakte Methoden beinhalten. Wenn ein Enum eine abstrakte Methode beinhaltet,
muss jede Instanz (also jede Konstante) dieses Enums diese Methode umsetzen (mehr Information über abstrakten Methoden findest du im Modul OOD).

#### Beispiel: Enum mit konkreten und abstrakten Methoden
```java
enum Color {
    RED {
        // Umsetzung der abstrakten Methode für die Farbe RED
        @Override
        public void colorPoem() {
            System.out.println("Roses are red");
        }
    },
    VIOLET {
        // Umsetzung der abstrakten Methode für die Farbe VIOLET
        @Override
        public void colorPoem() {
            System.out.println("Violets are blue");
        }
    };

    // Konkrete Methode, welche für alle Werte im Enum, dasselbe tut
    public void generalColorInfo(){
        System.out.println("Everyday color is a great color!");
    }

    // Abstrakte Methode, welche von jedem Wert im Enum umgesetzt werden muss
    public abstract void colorPoem();
}

public class Test {
    public static void main(String[] args) {
        Color violet = Color.VIOLET;
        violet.generalColorInfo(); // Output: Everyday color is a great color!
        violet.colorPoem();        // Output: Violets are blue

        Color red = Color.RED;
        red.generalColorInfo(); // Output: Everyday color is a great color!
        red.colorPoem();        // Output: Roses are red
    }
}
```

---
![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgabe](../../../../labs/java/java-oop) in den OOP-Labs.