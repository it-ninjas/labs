---
title: "Mathematik & Logik"
linkTitle: "Mathematik & Logik"
weight: 10
description: >
  Modul #J1
---

## Ziele
* Ich kann arithmetische Ausdrücke schreiben: Addition, Subtraktion, Multiplikation, Division, Modulo (Rest einer Division).
* Ich kenne die relationalen Operatoren: `==`, `>=`, `<=`, `>`, `<`, `!=`.
* Ich kenne die booleschen Operatoren: `&&` (AND), `||` (OR), `!` (NOT), `^`(XOR).

## Mathematik & Logik

Mathe in Java ist sehr einfach. Beachte, dass mathematische Java-Operationen einer bestimmten Reihenfolge folgen (Punkt-Operationen vor Strich-Operationen)

### Arithmetische Operatoren
| Symbol | Arithmetische Operation                 | Beispiel                              |
|--------|-----------------------------------------|---------------------------------------|
| +      | Addition                                | ```int sum = 2 + 3;```                |
| -      | Subtraktion                             | ```int difference = 5 – 2;```         |
| /      | Division                                | ```int quotient = 15 / 5;```          |
| *      | Multiplikation                          | ```int product = 3 * 4;```            |
| %      | Division mit Rest                       | ```int remainder = 7 % 3;```          |
| ++     | Post und Prä-Inkrement (1 addieren)     | ```count++; // (count = count + 1)``` |
| - -    | Post und Prä-Dekrement (1 subtrahieren) | ```count--; // (count = count – 1)``` |

### Post- und Prä-Inkrement
Das Inkrementieren und Dekrementieren von Variablen ist eine sehr häufige Operation.
Von diesem Operator gibt es zwei Varianten:
* Er kann vor der Variable stehen, wie in ```++i``` (Präfix-Schreibweise) oder
* dahinter, wie bei ```i++``` (Postfix-Schreibweise)

Der Präfix-Operator verändert die Variable vor der Auswertung der Programmzeile, und der Postfix-Operator ändert sie nach der Auswertung der Programmzeile. Mit anderen Worten: Nutzen wir einen Präfix-Operator, so wird die Variable erst herauf- bzw. heruntergesetzt und dann der Wert geliefert. Und beim Post-Operator ist es genau umgekehrt.

### Postinkrement
```java
int i = 5;
int c = i++; // c = 5
// ab hier ist i = 6
```

### Präinkrement
```java
int i = 5;
int d = ++i; // d = 6
```

### Postdekrement
```java
int i = 5;
int e = i--; // e = 5
// ab hier ist i = 4
```

### Prädekrement
```java
int i = 5;
int f = --i; // f = 4
```

---

### Vegleichsoperatoren
Die Ergebnisse dieser Operationen sind stets Boolean-Werte.
| Symbol | Vergleich | Beispiel |
| --- | --- | --- |
| >  | grösser als | 5 > 4 |
| <  | kleiner als | 4 < 5 |
| >= | grösser gleich | 3 >= 3 |
| <= | kleiner gleich | 3 <= 3 |
| == | gleich | 2 == 2 |
| != | ungleich | 2 != 4 |

### Boolsche Operatoren
Diese Operatoren basieren auf der boolschen Algebra. Daher arbeiten boolsche Operatoren direkt mit boolschen Werten. Es gibt vier Arten von boolschen Operatoren. Schauen wir uns zunächst ihre Symbole und deren Inhalt in der folgenden Tabelle an, bevor wir erläutern, welche Funktionen sie ausführen.
| Symbol | Boolsche Operation | Erklärung |
| --- | --- | --- |
| && | Logisches UND (AND) | _AND_ gibt nur dann true zurück, wenn die Ausdrücke auf beiden Seiten des Operators true sind (Hinweis: Dieser Ausdruck wird _lazy_ evaluiert. Dies bedeuetet, wenn der erste Ausdruck _false_ ist, wird der zweite Ausdruck nicht mehr ausgewertet |
| \|\| | Logisches ODER (OR) | _OR_ gibt true zurück, wenn der Ausdruck auf einer oder beiden Seiten des Operators true ist (Hinweis: Dieser Ausdruck wird _lazy_ evaluiert. Dies bedeuetet, wenn der erste Ausdruck _true_ ist, wird der zweite Ausdruck nicht mehr ausgewertet |
| ! | Logisches NICHT (NOT) | _NOT_ kehrt den Wert des darauffolgenden booleschen Ausdrucks um. Aus _true_ wird also _false_ und umgekehrt |
| ^ | Logisches ENTWEDER-ODER (XOR) | _XOR_ gibt true zurück, wenn die beiden Ausdrücke unterschiedlich sind |
| & | Logisches UND (AND) | Im Unterschied zum obigen _AND_ wertet dieses immer beide Ausdrücke aus |
| \|  | Logisches ODER (OR) | Im Unterschied zum obigen _OR_ wertet dieses immer beide Ausdrücke aus. |
