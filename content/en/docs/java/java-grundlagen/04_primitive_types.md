---
title: "Primitive Datentypen"
linkTitle: "Primitive Datentypen"
weight: 4
description: >
  Modul #J1
---

## Ziele
* Ich kenne die primitiven Datentypen in Java: `boolean`, `byte`, `short`, `int`, `long`, `double`, `float`, `char`.


## Primitive Datentypen
Bei Variablen primitiver Datentypen werden die Werte der Variable direkt in der Variable (auf dem Stack) gespeichert. Aus diesem Grund wird dann der Wert der Variable auch dann gelöscht, wenn die Variable gelöscht wird.

Die wichtigsten primitiven Datentypen sind die folgenden:

* `byte` (Ganzzahl)
* `short` (Ganzzahl)
* `int` (Ganzzahl)
* `long` (Ganzzahl)
* `float` (Kommazahl)
* `double` (Kommazahl)
* `boolean` (entweder `true` oder `false`)
* `char` (ein Zeichen wie ein Buchstabe)

### Integraler Datentyp
Integrale Datentypen sind ganze Zahlen, sie besitzen also keine Nachkommastellen.
Die folgenden Datentypen speichern ganzzahlige Werte, sie unterscheiden sich nur in ihrer Grösse:

| Datentyp  | Speicherbedarf  | Bereich                                               |
| --------- | --------------- | ----------------------------------------------------- |
| `byte`    | 8 Bit           | -128 ... 127                                          |
| `short`   | 16 Bit          | -32768 ... 32767                                      |
| `int`     | 32 Bit          | -2 147 483 648 ... 2 147 483 647 (-2^31 ...  2^31-1)  |
| `long`    | 64 Bit          | -2^63 ... 2^63-1                                      |

Ausserdem sind in den Werten von integralen Datentypen Underscores erlaubt, um die Lesbarkeit zu erhöhen (1_000_000).

Beispiele:
```java
int count = 0;
int million = 1_000_000;
```

### Gleitkomma-Datentyp
Gleitkomma-Datentypen speichern wie der Name bereits sagt, Zahlen mit Nachkommastellen. Diese Zahlen besitzen nur eine bestimmte Genauigkeit, sie dürfen also nicht als unendlich genau betrachtet werden.

Die folgenden Datentypen speichern Zahlen mit Nachkommastellen, sie unterscheiden sich in ihrer Grösse und der Art und Weise wie sie innerhalb von Java abgelegt werden:

| Datentyp  | Speicherbedarf  | Bereich                     | Interne Ablage  |
| --------- | --------------- | --------------------------- | --------------- |
| float     | 32 Bit          | +/-1,4E-45 ... +/-3,4E+38   | Dezimalbruch    |
| double    | 64 Bit          | +/-4,9E-324 ... +/-1,7E+308 | Gleitkommazahl  |

Wie folgt können Gleitkommazahlen initialisiert werden:

```java
float radius = 8.5f;
double area = 16.48739d;
double pi = 3.141592653589793;
```

Beachte, dass bei `float`-Zahlen ein `f` folgt, weil es sonst als `double` betrachtet wird.

Trotz Nachkommastellen dürfen Fliesskommzahlen des Typs `float` niemals zur Berechnung von Währungen verwendet werden. Innerhalb von Java wird ein `float` stets als Dezimalbruch geführt und die Ungenauigkeit ist der Grund, warum der Datentyp `float` NICHT für Währungsrechnungen verwendet werden soll.

### Zeichen-Datentyp

Ein **char** ist ein Datentyp, der ein einzelnes Zeichen darstellt.

Ein einzelnes Zeichen kann eine Ziffer, einen Buchstaben oder ein anderes Symbol sein. Um ein Zeichen zu schreiben, verwenden wir einfache Anführungszeichen wie folgt:
```
'A', 'B', 'C', 'x', 'y', 'z', '0', '1', '2', '9'
```

Zeichenliterale können Symbole eines Alphabets, Ziffern von '0' bis '9', Whitespaces (' ') oder andere Zeichen oder Symbole ('$') darstellen. Verwechsle nicht die Zeichen, die Zahlen ('9') darstellen mit den Zahlen selbst (9).
Ein Zeichen kann nicht zwei und mehr Ziffern oder Buchstaben enthalten, da es nur ein einziges Symbol darstellt.

Wir können Zeichen auf verschiedene Arten initialisieren:
| Beschreibung | Code |
| --- | --- |
| Einfache Anführungszeichen | ```char A = 'A';``` |
| Wir können ein Char-Literal als Integral-Literal angeben, das den Unicode-Wert des Zeichens darstellt, und Integral-Literale können entweder in Dezimal-, Oktal- oder Hexadezimalform angegeben werden. Der zulässige Bereich liegt zwischen 0 und 65535. | ```char A = 65;``` |
| In der Unicode-Darstellung ```'\\uxxxx'``` können Zeichenliterale angegeben werden. Hier steht xxxx für 4 Hexadezimalzahlen. | ```char A = '\u0041';``` |

Beispiele:
```java
char letter = 'a';
char point = '.';
letter++; // 'b'
```

#### _Don’t get confused:_
* 123 ist ein Integer, "123" ist ein String;
* 'A' ein Zeichen (char), "A" ist ein String;
* '1' ist ein Zeichen (char), 1 ist ein Integer;

### Logischer Datentyp

Ein `boolean` kann nur zwei verschiedene Werte haben:
* `true` wie wahr (bzw. zutreffend)
* `false` wie falsch/unwahr (bzw. nicht zutreffend)

Ein `boolean` wird oft verwendet, um zu speichern, ob etwas zutrifft bzw. etwas aktiv ist. Dieser Wert wird dann oft in Bedingungen (folgen später) verwendet.

```java
boolean done = false;
boolean isBigger = true;
```

Eine mögliche Verwendung von `boolean`s sind Bedingungen, wenn bestimmter Code nur ausgeführt werden soll, wenn z.B. ein `boolean` den Wert `true` aufweist:

```java
boolean done = false;

if (done)
  System.out.println("You're done");
```

Damit etwas ausgegeben werden würde, müsste die Variable `done` den Wert `true` haben.

### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=NSeJhsah-hE).