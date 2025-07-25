---
title: "Primitive Datentypen"
linkTitle: "Primitive Datentypen"
weight: 4
description: >
  In diesem Modul lernst du die primitiven Datentypen in Java kennen – also Werte wie Zahlen, Zeichen oder
  Wahrheitswerte.
---

## Ziele

- Ich kenne die primitiven Datentypen in Java: `boolean`, `byte`, `short`, `int`, `long`, `double`, `float`, `char`.
- Ich weiss, wie ich primitive Datentypen (formatiert) auf der Konsole ausgeben kann.

{{< zeit lesen="30" >}}

## Primitive Datentypen

Bei primitiven Datentypen wird der Wert direkt in der Variable gespeichert. Wird die Variable gelöscht, verschwindet
auch ihr Inhalt. Du erkennst primitive Datentypen daran, dass sie klein geschrieben werden. Ein `String` ist daher
**kein** primitiver Datentyp.

Die primitiven Datentypen sind:

- `byte` (Ganzzahl)
- `short` (Ganzzahl)
- `int` (Ganzzahl)
- `long` (Ganzzahl)
- `float` (Kommazahl)
- `double` (Kommazahl)
- `boolean` (`true` oder `false`)
- `char` (ein einzelnes Zeichen)

### Integrale Datentypen

Integrale Datentypen speichern ganze Zahlen ohne Nachkommastellen. Sie unterscheiden sich im Speicherbedarf:

| Datentyp | Speicherbedarf | Bereich                                           |
| -------- | -------------- | ------------------------------------------------- |
| `byte`   | 8 Bit          | -128 bis 127                                      |
| `short`  | 16 Bit         | -32_768 bis 32_767                                |
| `int`    | 32 Bit         | -2_147_483_648 bis 2_147_483_647 (-2³¹ bis 2³¹−1) |
| `long`   | 64 Bit         | -2⁶³ bis 2⁶³−1                                    |

Zur besseren Lesbarkeit darfst du Unterstriche (\_) innerhalb von Zahlen verwenden (sogenannte Underscores):

```java
int count = 0;
int million = 1_000_000;
```

### Gleitkomma-Datentypen

Gleitkommazahlen enthalten Nachkommastellen, sind aber **nicht exakt** – es können Rundungsfehler auftreten.

| Datentyp | Speicherbedarf | Bereich                 | Darstellung             |
| -------- | -------------- | ----------------------- | ----------------------- |
| `float`  | 32 Bit         | ±1.4E−45 bis ±3.4E+38   | Gleitkommazahl (32 Bit) |
| `double` | 64 Bit         | ±4.9E−324 bis ±1.7E+308 | Gleitkommazahl (64 Bit) |

Beispiele:

```java
float radius = 8.5f;
double area = 16.48739d;
double pi = 3.141592653589793;
```

Beachte: `float`-Werte benötigen das Suffix `f`.

{{< ninja warning>}}
Für **exakte** Berechnungen (z. B. Geldbeträge) verwende `BigDecimal`.
{{< /ninja >}}

### Warum `BigDecimal` statt `double`?

Der Typ `double` speichert Gleitkommazahlen im **Binärformat**. Viele Dezimalzahlen wie `0.1` oder `0.2` lassen sich im
Binärsystem **nicht exakt darstellen** – ähnlich wie `1/3` in Dezimal als `0.333...` unendlich lang ist.

Das führt zu **kleinen Rundungsfehlern**, die unter anderem in Finanzanwendungen problematisch sind.

#### Beispiel:

```java
double x = 0.1;
double y = 0.2;
System.out.println(x + y); // gives 0.30000000000000004
```

Auch wenn das nach wenig aussieht: Bei vielen Transaktionen oder Rundungen summieren sich diese Fehler.

#### Die Lösung: `BigDecimal`

`BigDecimal` speichert Zahlen exakt als **Dezimalwerte** und bietet:

- Exakte Rechengenauigkeit
- Kontrollierte Rundung
- Präzise Ausgabe

```java
import java.math.BigDecimal;

BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
BigDecimal result = a.add(b);

System.out.println(result); // gives 0.3
```

{{< ninja tip >}}
Übergib Werte mit Nachkommastellen **immer als String** (`new BigDecimal("0.1")`), sonst übernimmst du den ungenauen
`double`-Wert.

Ganzzahlen kannst Du direkt übergeben (`new BigDecimal(22)`).
{{< /ninja >}}

### Zeichen-Datentyp

Ein `char` steht für genau ein Zeichen: Buchstabe, Zahl oder Symbol.

| Datentyp | Speicherbedarf | Bereich                       |
| -------- | -------------- | ----------------------------- |
| `char`   | 16 Bit         | Unicode-Zeichen gemäss UTF-16 |

```java
char letter = 'a';
char point = '.';
letter++; // gives 'b'
```

{{< ninja >}}
**Warum ergibt `letter++` im Beispiel oben den Buchstaben `'b'`?**

Ein Computer kennt keine Zeichen, sondern nur Zahlen. Auch ein `char` wird intern als 16-Bit-Zahlenwert gespeichert.  
Java verwendet für Zeichen die Unicode-Codierung nach UTF-16. In der Unicode-Tabelle ist genau definiert,  
welche Zahl welchem Zeichen entspricht. Ein `char` deckt dabei die Zeichen aus der **Basic Multilingual Plane (BMP)**
ab.

Wenn man nun `letter++` schreibt (das ist das gleiche wie `letter = letter + 1`), wird der Zahlenwert um eins erhöht.  
Dadurch ergibt sich automatisch das **nächste Zeichen** in der Unicode-Tabelle: Aus `'a'` wird `'b'`, aus `'9'` wird
`':'`, usw.

→ Zur [!Unicode-Tabelle](https://symbl.cc/de/unicode-table)

Darum wird aus `'3' + 7` nicht `10` sondern `58` -> `':'` (Java zeigt auch keinen Fehler, da `char` auch als Zahl
gespeichert wird).

{{< /ninja >}}

Initialisierungsmöglichkeiten:

| Beschreibung                                          | Beispiel             |
| ----------------------------------------------------- | -------------------- |
| Zeichen in einfachen Anführungszeichen                | `char a = 'A';`      |
| Unicode-Zahl (Dezimal, Oktal, Hexadezimal)            | `char a = 65;`       |
| Unicode-Schreibweise `\uXXXX` (vierstellige Hex-Zahl) | `char a = '\u0041';` |

#### Zeichen vs. Zahlen vs. Strings

- `123` ist eine Zahl (`int`), `"123"` ein String
- `'A'` ist ein Zeichen (`char`), `"A"` ein String
- `'1'` ist ein Zeichen (`char`), `1` eine Zahl

### Logischer Datentyp

Ein `boolean` kann nur zwei Zustände annehmen:

- `true` (wahr)
- `false` (falsch)

Beispiel:

```java
boolean done = false;
boolean isBigger = true;

if (done) {
  System.out.println("You're done");
}
```

Der `if`-Block mit `System.out.println("You're done");` wird nur ausgeführt, wenn `done` den Wert `true` hat. Du wirst
in kürze mehr dazu erfahren, was es mit dem `if` auf sich hat.

---

### Ausgabe von Datentypen

Um Werte auf der Konsole auszugeben, hast du bisher `System.out.println(...)` verwendet. Das funktioniert auch mit allen
primitiven Datentypen:

```java
int number = 42;
double temperature = 36.6;
boolean isDone = true;

System.out.println(number);       // Output: 42
System.out.println(temperature);  // Output: 36.6
System.out.println(isDone);       // Output: true
```

#### Formatierte Ausgabe mit `printf`

Wenn du mehr Kontrolle über die Ausgabe haben möchtest – z. B. **nur 2 Nachkommastellen bei einem `double`** –,
verwendest du `System.out.printf(...)`.

```java
double value = 3.14159265;

System.out.printf("Wert auf 2 Stellen: %.2f%n", value); // Gibt: Wert auf 2 Stellen: 3.14
```

Als ersten Parameter übergibst du einen String mit dem Text und Platzhaltern, welche dann durch die nachfolgenden
Parameter ersetzt werden sollen.

##### Wichtige Platzhalter bei `printf`

| Platzhalter | Bedeutung                             | Beispielausgabe |
| ----------- | ------------------------------------- | --------------- |
| `%d`        | Ganzzahl (`int`, `long`, ...)         | `42`            |
| `%f`        | Gleitkommazahl (`float`, `double`)    | `3.14`          |
| `%.2f`      | Gleitkommazahl mit 2 Nachkommastellen | `3.14`          |
| `%c`        | Zeichen (`char`)                      | `A`             |
| `%b`        | Wahrheitswert (`boolean`)             | `true`          |
| `%s`        | String                                | `Hallo`         |
| `%n`        | Neue Zeile (plattformunabhängig)      |                 |

##### Weitere Optionen bei den Platzhaltern

| Format    | Bedeutung                                                 | Beispiel     |
| --------- | --------------------------------------------------------- | ------------ |
| `%5d`     | Zahl mit **mindestens** 5 Stellen (rechtsbündig)          | `   42`      |
| `%-5d`    | Zahl mit **mindestens** 5 Stellen (linksbündig)           | `42   `      |
| `%05d`    | Mit Nullen auffüllen                                      | `00042`      |
| `%,d`     | Tausender-Trennzeichen (je nach Locale)                   | `1,000,000`  |
| `%10.2f`  | Gleitkommazahl: **mind.** 10 Stellen, 2 Nachkommastellen  | `    123.45` |
| `%010.2f` | Gleitkommazahl, **mind.** 10 Stellen mit führenden Nullen | `0000123.45` |

#### Beispiel: Alle Typen formatiert ausgeben

```java
int count = 12;
double price = 5.6789;
char symbol = 'Z';
boolean isActive = true;

System.out.printf("Zahl: %d%n", count);
System.out.printf("Preis: %.2f CHF%n", price);
System.out.printf("Zeichen: %c%n", symbol);
System.out.printf("Status: %b%n", isActive);
```

**Ausgabe:**

```
Zahl: 12
Preis: 5.68 CHF
Zeichen: Z
Status: true
```

Es können beliebig viele Platzhalter definiert werden.

```java
int count = 12;
double price = 5.6789;

System.out.printf("%d Artikel kosten %.2f CHF%n", count, price);
```

**Ausgabe:**

```
12 Artikel kosten 5.68 CHF
```

{{< ninja tip >}}
Wenn du `printf` verwendest, wird **nichts automatisch umgebrochen**. Du musst `\n` oder `%n` selbst angeben, damit der
Text in einer neuen Zeile weitergeht.
{{< /ninja >}}

{{< ninja warning >}}
Java zeigt nur eine Warnung, aber keinen Fehler, wenn:

- mehr Platzhalter als Variablen angegeben sind,
- eine Variable nicht in das gewünschte Format umgewandelt werden kann.

Solche Warnungen sollten nicht ignoriert werden – sie können zur Laufzeit zu unerwartetem Verhalten oder Fehlern führen.
{{< /ninja >}}

---

{{< video "https://www.youtube.com/watch?v=NSeJhsah-hE" >}}

---

{{<aufgabe "[](../../../../labs/02_java/03_java-grundlagen/04_variables-and-types/)">}}
