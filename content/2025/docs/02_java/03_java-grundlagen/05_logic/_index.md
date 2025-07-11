---
title: "Mathematik & Logik"
linkTitle: "Mathematik & Logik"
weight: 5
description: >
  Einführung in arithmetische, relationale und boolesche Operatoren in Java – mit vielen Beispielen und klaren Erklärungen.
---

{{< module "J1" >}}

## Ziele

- Ich kann arithmetische Ausdrücke schreiben: Addition, Subtraktion, Multiplikation, Division, Modulo (Rest einer Division).
- Ich kenne die relationalen Operatoren: `==`, `>=`, `<=`, `>`, `<`, `!=`.
- Ich kenne die booleschen Operatoren: `&&` (AND), `||` (OR), `!` (NOT), `^`(XOR).

{{< zeit lesen="15" >}}

## Mathematik & Logik

Mathe in Java ist sehr einfach. Beachte, dass mathematische Java-Operationen einer bestimmten Reihenfolge folgen:  
**Punkt-Operationen vor Strich-Operationen**

### Arithmetische Operatoren

| Symbol | Operation                     | Beispiel                        |
| ------ | ----------------------------- | ------------------------------- |
| `+`    | Addition                      | `int sum = 2 + 3;`              |
| `-`    | Subtraktion                   | `int difference = 5 - 2;`       |
| `/`    | Division                      | `int quotient = 15 / 5;`        |
| `*`    | Multiplikation                | `int product = 3 * 4;`          |
| `%`    | Modulo (Rest einer Division)  | `int remainder = 7 % 3;`        |
| `++`   | Post-/Prä-Inkrement (plus 1)  | `count++; // count = count + 1` |
| `--`   | Post-/Prä-Dekrement (minus 1) | `count--; // count = count - 1` |

### Kurzschreibweise: Zuweisungsoperatoren

Zuweisungsoperatoren kombinieren eine Operation mit einer Zuweisung. Statt z. B. `x = x + 5;` kannst du einfach `x += 5;` schreiben.

| Operator | Bedeutung                    | Beispiel       | Entspricht    |
| -------- | ---------------------------- | -------------- | ------------- | ----- | ------ | --- |
| `+=`     | Addition und Zuweisung       | `x += 5;`      | `x = x + 5;`  |
| `-=`     | Subtraktion und Zuweisung    | `x -= 3;`      | `x = x - 3;`  |
| `*=`     | Multiplikation und Zuweisung | `x *= 2;`      | `x = x * 2;`  |
| `/=`     | Division und Zuweisung       | `x /= 4;`      | `x = x / 4;`  |
| `%=`     | Modulo und Zuweisung         | `x %= 3;`      | `x = x % 3;`  |
| `&=`     | Bitweises UND                | `x &= y;`      | `x = x & y;`  |
| `        | =`                           | Bitweises ODER | `x            | = y;` | `x = x | y;` |
| `^=`     | Bitweises XOR                | `x ^= y;`      | `x = x ^ y;`  |
| `<<=`    | Linksschieben                | `x <<= 1;`     | `x = x << 1;` |
| `>>=`    | Rechtsschieben               | `x >>= 1;`     | `x = x >> 1;` |

### Post- und Prä-Inkrement

Das Erhöhen oder Verringern eines Wertes ist häufig. Es gibt zwei Schreibweisen:

- Präfix: `++i` oder `--i` → zuerst ändern, dann verwenden
- Postfix: `i++` oder `i--` → zuerst verwenden, dann ändern

#### Postinkrement

```java
int i = 5;
int c = i++; // c = 5, danach: i = 6
```

#### Präinkrement

```java
int i = 5;
int d = ++i; // zuvor: i=6, darum d = 6
```

#### Postdekrement

```java
int i = 5;
int e = i--; // e = 5, danach: i = 4
```

#### Prädekrement

```java
int i = 5;
int f = --i; // zuvor: i=4, darum f = 4
```

---

### Vergleichsoperatoren

Das Ergebnis ist immer ein `boolean` (true oder false).

| Symbol | Bedeutung      | Beispiel |
| ------ | -------------- | -------- |
| `>`    | grösser als    | `5 > 4`  |
| `<`    | kleiner als    | `4 < 5`  |
| `>=`   | grösser gleich | `3 >= 3` |
| `<=`   | kleiner gleich | `3 <= 3` |
| `==`   | gleich         | `2 == 2` |
| `!=`   | ungleich       | `2 != 4` |

---

### Boolesche Operatoren

Diese Operatoren arbeiten mit `boolean`-Werten (true/false).

| Symbol | Operation             | Erklärung                                                                               |
| ------ | --------------------- | --------------------------------------------------------------------------------------- | -------------------------------------------- | ---------------------------------------------------------------------------------------- |
| `&&`   | logisches UND         | true nur wenn beide true sind. Lazy-Evaluation: 2. Ausdruck wird nur bei Bedarf geprüft |
| `      |                       | `                                                                                       | logisches ODER                               | true wenn mindestens einer true ist. Lazy-Evaluation: 2. Ausdruck nur bei Bedarf geprüft |
| `!`    | logisches NICHT       | kehrt den Wert um: `!true` → false                                                      |
| `^`    | exklusives ODER (XOR) | true, wenn genau einer true ist                                                         |
| `&`    | UND (nicht lazy)      | beide Ausdrücke werden **immer** ausgewertet                                            |
| `      | `                     | ODER (nicht lazy)                                                                       | beide Ausdrücke werden **immer** ausgewertet |

{{< ninja info >}}
**Was bedeutet Lazy-Evaluation?**

Wenn zwei Ausdrücke zum Beispiel mit `&&` verknüpft sind, wird der zweite Ausdruck **nur** ausgewertet, wenn der erste `true` zurückgibt.  
Gibt der erste `false` zurück, ist das Gesamtergebnis ohnehin `false` – der zweite Ausdruck wird **übersprungen**.  
Das kann zu unerwartetem Verhalten führen, wenn der zweite Ausdruck nicht nur ein Ergebnis liefert, sondern auch Seiteneffekte hat  
(z. B. den Zustand eines Objekts verändert).

Deshalb ist es wichtig, Ausdrücke möglichst ohne Seiteneffekte zu schreiben – ein Prinzip, das du später im Modul _Clean Code_ unter  
dem Stichwort _Single Responsibility_ kennenlernen wirst.

Mit `||` ist es das selbe, nur dass dort der zweite Ausdruck nur ausgewertet wird, wenn der erste Ausdruck `false` zurückgibt.
{{< /ninja >}}

---

### Bitweise Operatoren (Bitwise Operators)

Bitweise Operatoren vergleichen nicht `true` oder `false`, sondern manipulieren einzelne Bits eines Zahlenwerts.  
Sie funktionieren also nur mit Ganzzahlen (`int`, `long`, `byte`, etc.).

| Symbol | Name                 | Beschreibung                                                                 |
|--------|----------------------|------------------------------------------------------------------------------|
| `&`    | UND                  | Bit ist 1, wenn **beide Bits** 1 sind                                       |
| `|`    | ODER                 | Bit ist 1, wenn **mindestens eines** der Bits 1 ist                         |
| `^`    | XOR (exklusives ODER)| Bit ist 1, wenn **genau eines** der Bits 1 ist                              |
| `~`    | NOT (Invertieren)    | Alle Bits werden umgekehrt (1 → 0, 0 → 1)                                   |
| `<<`   | Linksverschiebung    | Verschiebt alle Bits nach links (Multiplizieren mit 2)                      |
| `>>`   | Rechtsverschiebung   | Verschiebt alle Bits nach rechts (Dividieren durch 2, vorzeichenbehaftet)  |
| `>>>`  | Unsigned Shift       | Wie `>>`, aber füllt von links mit 0 (wichtig bei `int` → `long`)           |

#### Beispiel:

```java
int a = 0b1100; // binär: 1100 = 12
int b = 0b1010; // binär: 1010 = 10

int resultAnd = a & b;  // 1000 = 8
int resultOr  = a | b;  // 1110 = 14
int resultXor = a ^ b;  // 0110 = 6
int resultNot = ~a;     // alle Bits invertieren → -13 (2er-Komplement-Darstellung)

System.out.println("a & b = " + resultAnd);
System.out.println("a | b = " + resultOr);
System.out.println("a ^ b = " + resultXor);
System.out.println("~a    = " + resultNot);
```

#### Bitshift Beispiel:

```java
int x = 4;           // 0100
int left = x << 1;   // 1000 → 8 (links verschieben)
int right = x >> 1;  // 0010 → 2 (rechts verschieben)

System.out.println("x << 1 = " + left);
System.out.println("x >> 1 = " + right);
```

{{< ninja info >}}
Bitoperationen sind **nicht dasselbe** wie boolesche Operatoren!  
`&` bei `int` ist **bitweise UND**, bei `boolean` ist es **logisches UND (nicht lazy)**.  
Dasselbe gilt für `|` und `^`.
{{< /ninja >}}

---

### Ternary Operator

Mit dem Ternary Operator kannst du kurz und elegant eine Bedingung formulieren:  
`bedingung ? wertWennTrue : wertWennFalse`

#### Beispiel:

```java
int alter = 17;
String zuJung = "Du bist zu jung";
String genugAlt = "Du bist alt genug :)";

System.out.println(alter >= 18 ? genugAlt : zuJung);
// Ausgabe: Du bist zu jung

alter = 26;

System.out.println(alter >= 18 ? genugAlt : zuJung);
// Ausgabe: Du bist alt genug :)
```

#### Verschachtelter Ternary Operator:

```java
int jahre = 12;
String rang = jahre >= 20 ? "Kage"
             : jahre >= 10 ? "Chunin"
             : jahre >= 5 ? "Akademieschüler"
             : "Anwärter";

System.out.println("Dein aktueller Rang ist " + rang);
// Ausgabe: Dein aktueller Rang ist Chunin
```

---

{{< todo >}}
Lab konvertieren:  
Aufgabe 4  
../../../../labs/02_java/03_java-grundlagen/01_basicexercises/#aufgabe-4---einfache-berechnungen
{{< /todo >}}
