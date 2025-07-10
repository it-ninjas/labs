---
title: "Primitive Datentypen"
linkTitle: "Primitive Datentypen"
weight: 4
description: >
  In diesem Modul lernst du die primitiven Datentypen in Java kennen – also Werte wie Zahlen, Zeichen oder Wahrheitswerte.
---

## Ziele

- Ich kenne die primitiven Datentypen in Java: `boolean`, `byte`, `short`, `int`, `long`, `double`, `float`, `char`.

{{< zeit lesen="25" >}}

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

Zur besseren Lesbarkeit darfst du Underscores verwenden:

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

Beachte: `float`-Werte benötigen das Suffix `f`. Für **exakte** Berechnungen (z. B. Geldbeträge) verwende `BigDecimal`.

### Warum `BigDecimal` statt `double`?

Der Typ `double` speichert Gleitkommazahlen im **Binärformat**. Viele Dezimalzahlen wie `0.1` oder `0.2` lassen sich im
Binärsystem **nicht exakt darstellen** – ähnlich wie `1/3` in Dezimal als `0.333...` unendlich lang ist.

Das führt zu **kleinen Rundungsfehlern**, die in Finanzanwendungen problematisch sind.

#### Beispiel:

```java
double x = 0.1;
double y = 0.2;
System.out.println(x + y); // ergibt 0.30000000000000004
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

System.out.println(result); // ergibt 0.3
```

{{< ninja tip >}}
Übergib Werte mit Nachkommastellen **immer als String** (`new BigDecimal("0.1")`), sonst übernimmst du den ungenauen `double`-Wert.

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
letter++; // ergibt 'b'
```

{{< ninja >}}
**Warum ergibt `letter++` den Buchstaben `'b'`?**

Ein Computer kennt keine Zeichen, sondern nur Zahlen. Auch ein `char` wird intern als 16-Bit-Zahlenwert gespeichert.  
Java verwendet für Zeichen die Unicode-Codierung nach UTF-16. In der Unicode-Tabelle ist genau definiert,  
welche Zahl welchem Zeichen entspricht. Ein `char` deckt dabei die Zeichen aus der **Basic Multilingual Plane (BMP)** ab.

Wenn man nun `letter++` schreibt (das ist das gleiche wie `letter = letter + 1`), wird der Zahlenwert um eins erhöht.  
Dadurch ergibt sich automatisch das **nächste Zeichen** in der Unicode-Tabelle: Aus `'a'` wird `'b'`, aus `'9'` wird `':'`, usw.

→ Zur [Unicode-Tabelle](https://symbl.cc/de/unicode-table/#latin-extended-a)
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

Der `if`-Block wird nur ausgeführt, wenn `done` den Wert `true` hat.

---

{{< video "https://www.youtube.com/watch?v=NSeJhsah-hE" >}}
