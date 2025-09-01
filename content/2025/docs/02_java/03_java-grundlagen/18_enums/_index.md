---
title: "Enums – Grundlagen"
linkTitle: "Enums"
weight: 18
description: >
  Enums als typsichere Aufzählung: feste Werte definieren, verwenden und mit switch verarbeiten.
  Einsatzbereiche, Syntax und Best Practices in statischen Methoden (Utility-Klassen).
---

## Ziele

- Ich kann in eigenen Worten erklären, was Enums sind und wann man sie nutzt.
- Ich kann ein Enum definieren und in Code korrekt verwenden (Zuweisung, Vergleich, switch).
- Ich kann alle Werte eines Enums iterieren (values) und den Namen ausgeben (name).

{{< zeit lesen="10" >}}

---

## Enums – was und wofür?

Enums (von „enumeration“ / „Aufzählung“) fassen **vordefinierte, feste Werte** zu einem eigenen Datentyp
zusammen. Typische Beispiele sind **Wochentage**, **Himmelsrichtungen**, **Zustände** (READY, RUNNING, FAILED).

**Wann verwenden?**  
Wenn alle möglichen Werte **zur Kompilierzeit** bekannt sind und sich nicht dynamisch ändern.

**Wichtigste Eigenschaften (Grundlagen):**

- Enum-Konstanten sind **typsicher** (kein „magischer String“).
- Vergleich geht mit `==` (es sind einzelne, eindeutige Instanzen).
- In `switch` können Enum-Werte direkt verwendet werden.
- `values()` liefert alle Werte als Array; `name()` liefert den Konstantennamen als String.

> Hinweis: Intern sind Enums Spezialtypen. Die OOP-Details (Konstruktoren, Methoden) folgen im OOP-Modul.

## Enums definieren

- `enum` kann **top-level** (außerhalb einer Klasse) oder **innerhalb** einer Klasse stehen.
- Die **erste Zeile** enthält die **Komma-Liste** der Konstanten (Konvention: GROSSBUCHSTABEN).

Jede Enum-Konstante ist implizit **`public static final`**.

### Beispiel: Definition außerhalb einer Klasse

```java
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class DailyPlanner {
    private static void dailyMood(Weekday day) {
        switch (day) {
            case MONDAY:
                System.out.println("Montage sind nicht meine Lieblinge.");
                break;
            case FRIDAY:
                System.out.println("Zum Glück ist Freitag!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Wochenende ist zu kurz.");
                break;
            default:
                System.out.println("Irgendein Wochentag in der Mitte.");
                break;
        }
    }

    public static void main(String[] args) {
        dailyMood(Weekday.MONDAY);
    }
}
```

### Beispiel: Definition innerhalb einer Klasse

```java
public class DailyPlanner {
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        System.out.println("Ich mag " + Weekday.SATURDAY + " und " + Weekday.SUNDAY + ".");
    }
}
```

## Wann sind Enums besser als Strings?

Ohne Enums werden oft **Strings** für Zustände verwendet. Das ist fehleranfällig:

```java
public class WebShop {
    public static void setOrderState(int orderId, String state) {
        System.out.println("Order " + orderId + " is now " + state);
    }

    public static void setInvoiceState(int invoiceId, String state) {
        System.out.println("Invoice " + invoiceId + " is now " + state);
    }
}

class Demo {
    public static void main(String[] args) {
        WebShop.setOrderState(42, "shipped");
        WebShop.setOrderState(42, "Shippped"); // Tippfehler – trotzdem gültig!
    }
}
```

Mit Enums wird das typsicher und klarer:

```java
enum OrderState { NEW, PROCESSING, SHIPPED, CANCELLED }
enum InvoiceState { OPEN, PAID, CANCELLED }

public class WebShop {
    public static void setOrderState(int orderId, OrderState state) {
        System.out.println("Order " + orderId + " is now " + state);
    }

    public static void setInvoiceState(int invoiceId, InvoiceState state) {
        System.out.println("Invoice " + invoiceId + " is now " + state);
    }
}

class Demo {
    public static void main(String[] args) {
        WebShop.setOrderState(42, OrderState.SHIPPED);
        // WebShop.setOrderState(42, "Shippped"); // Compiler-Fehler! :)
    }
}
```

**Vorteile:**

- Keine Tippfehler möglich (Compiler prüft).
- Methodenparameter sind klar dokumentiert (welche States erlaubt sind).
- Typsicherheit: `OrderState` kann nicht mit `InvoiceState` verwechselt werden.

## Alle Werte iterieren & Namen ausgeben

```java
public class EnumIterationDemo {
    enum Direction { NORTH, EAST, SOUTH, WEST }

    public static void main(String[] args) {
        for (Direction d : Direction.values()) {
            System.out.println("Richtung: " + d.name());
        }
    }
}
```

{{< ninja info>}}
**Merke:** Wie `Strings` sind auch `Enums` bereits Klassen. Was man damit noch so alles machen kann erfährst Du im
OOP-Module.
{{< /ninja >}}
