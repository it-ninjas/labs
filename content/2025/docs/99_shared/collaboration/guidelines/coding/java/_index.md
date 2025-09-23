---
title: "Java Coding Guidelines"
linkTitle: "Java Coding Guidelines"
weight: 2
description: >
  Regeln, damit Java-Code gut lesbar und wartbar bleibt.
---

Diese Richtlinien helfen dir, Java-Code lesbar, konsistent und wartbar zu schreiben. Sie orientieren sich an den Erfahrungen der IT-Ninjas und enthalten ausgewählte Empfehlungen aus dem [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

{{< ninja tip>}}
Kläre im Projekt oder Unternehmen, ob eigene Coding Guidelines gelten.
{{< /ninja >}}

---

## Motivation

Guter Code ist **Teamkommunikation**. Klare Struktur, konsistente Formatierung und verständliche Namen helfen dir – und allen, die deinen Code warten oder erweitern müssen.

Vergleiche selbst dieses Beispiel:

```java
public class W{double c(double[]p,double s){double t=0;for(double x:p)t+=x;return t*(1-s);}}
```

Ist dieser Code **leicht verständlich**?

Hier dasselbe, nach den Java Coding Guidelines von IT-Ninjas:

```java
public class ShoppingCart {

    /**
     * Calculates the total amount after applying a discount.
     *
     * @param prices Array of item prices
     * @param discount Discount as a decimal (e.g. 0.05 for 5%)
     * @return Total amount after discount
     */
    public double calculateTotalWithDiscount(double[] prices, double discount) {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
        return total * (1 - discount);
    }
}
```

Der Unterschied ist klar:

- Die **Namen** machen deutlich, was der Code tut.
- Strukturierte Formatierung verbessert die Lesbarkeit.
- Dokumentation erklärt die Schnittstelle.

---

## Sprache

Verwende durchgehend **Englisch** im Code, in Kommentaren und in der Dokumentation – besonders in internationalen Projekten. Alternativ ist auch **Deutsch** erlaubt, jedoch **kein Sprachmix**. Fachbegriffe dürfen verwendet werden, wenn sie gängig und verständlich sind (z. B. `interface`).

---

## Einrückung und Formatierung

- Verwende **4 Leerzeichen**, keine Tabs.
- `{` steht **in derselben Zeile** wie die Anweisung.
- **Annotations** (z. B. `@Override`) stehen immer **in eigener Zeile**.

{{< snippet name="format_and_indent" shiftleft="4" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

---

## Zeilenlänge und Umbrüche

- Empfohlene maximale Zeilenlänge: **120 Zeichen**
- Lange Ausdrücke umschlagen – Parameter pro Zeile.
  {{< snippet name="long_lines_with_lot_params" shiftleft="4" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

---

## Benennungsregeln

| Element    | Stil        | Beispiel                     |
| ---------- | ----------- | ---------------------------- |
| Klassen    | PascalCase  | `CustomerAccount`            |
| Methoden   | camelCase   | `getUserName()`              |
| Variablen  | camelCase   | `maxRetries`                 |
| Konstanten | UPPER_SNAKE | `MAX_CONNECTIONS`            |
| Pakete     | lower.case  | `com.company.project.module` |

---

## Konstanten

Vermeide "magische Zahlen" oder Strings. Verwende benannte Konstanten mit sinnvollen Namen.

{{< snippet name="name_constants" shiftleft="4" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

---

## Kommentare

### Inline-Kommentare

- Nur wenn nötig – guter Code erklärt sich selbst.
- Meist **eigene Zeile** vor dem Code.
- Nur bei sehr kurzen Hinweisen: am Zeilenende.

{{< snippet name="inline_comment" shiftleft="8" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

### JavaDoc

- Für **öffentliche** Klassen, Methoden, Konstruktoren und Felder
- Auch bei **protected**, wenn sie vererbbar sind
- **Private** nur bei komplexem Verhalten
- Keine JavaDoc für triviale Getter/Setter nötig

> **Tipp**: Aussagekräftige Namen reduzieren den Bedarf an JavaDoc.

{{< snippet name="javadoc" shiftleft="4" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

#### JavaDoc-Tags

- `@param` – bei mehreren oder komplexen Parametern
- `@return` – wenn Methode etwas zurückgibt
- `@throws` – bei geworfenen Exceptions

---

## Klassenaufbau

Reihenfolge innerhalb einer Klasse (nach Google Java Style Guide):

1. `public static final` Konstanten
2. Statische Felder
3. Instanzvariablen
4. Konstruktoren
5. Öffentliche Methoden
6. Geschützte Methoden
7. Package-private Methoden
8. Private Methoden
9. Statische Methoden
10. Innere Klassen und Enums

---

## Fehlerbehandlung

- **Checked Exceptions** nur, wenn sinnvoll
- Fehler sinnvoll **loggen**, keine Log-Spam
- Leere `catch`-Blöcke nur mit Kommentar wie `// intentionally empty`

{{< snippet name="exceptions" shiftleft="8" file="/assets/snippets/coding-guidelines/java/src/ch/itninjas/program/CodeSnippets.java" >}}

---

## Tools

- **Formatter**: IntelliJ / Eclipse mit einheitlichem Profil
- **Analyse**: Checkstyle, PMD, SpotBugs, Sonar
- **CI/CD**: Format- und Lint-Checks im Build-Prozess

---

## Vergleich mit anderen Guidelines

### Übersicht

| Aspekt        | IT-Ninjas        | Spring Format        | Google Style             | Oracle/Sun          |
| ------------- | ---------------- | -------------------- | ------------------------ | ------------------- |
| Einrückung    | 4 Leerzeichen    | 4 Leerzeichen        | **2 Leerzeichen**        | 4 Leerzeichen       |
| Zeilenlänge   | max. 120 Zeichen | max. 120 Zeichen     | **max. 100 Zeichen**     | **max. 80 Zeichen** |
| Klammern `{}` | gleiche Zeile    | gleiche Zeile        | gleiche Zeile            | gleiche Zeile       |
| Annotations   | eigene Zeile     | eigene Zeile         | eigene Zeile             | –                   |
| Leere Blöcke  | mit Kommentar    | optionaler Kommentar | `// intentionally empty` | –                   |

### JavaDoc & Kommentare

| Aspekt          | IT-Ninjas           | Spring Format | Google Style               | Oracle/Sun |
| --------------- | ------------------- | ------------- | -------------------------- | ---------- |
| JavaDoc Pflicht | öffentliche APIs    | empfohlen     | **alle öffentlichen APIs** | empfohlen  |
| JavaDoc-Tags    | param/return/throws | empfohlen     | **verpflichtend**          | empfohlen  |

### Benennungen (alle identisch)

| Element    | Stil        | Beispiel              |
| ---------- | ----------- | --------------------- |
| Klassen    | PascalCase  | `MyService`           |
| Methoden   | camelCase   | `calculateSum()`      |
| Variablen  | camelCase   | `userName`            |
| Konstanten | UPPER_SNAKE | `MAX_SIZE`            |
| Pakete     | lower.case  | `com.example.project` |

### Klassenstruktur

| Reihenfolge (vereinfacht)                    | IT-Ninjas | Spring | Google | Oracle |
| -------------------------------------------- | --------- | ------ | ------ | ------ |
| Konstanten → Felder → Konstruktor → Methoden | ✅        | ✅     | ✅     | ✅     |

### Tooling

| Aspekt          | IT-Ninjas                  | Spring Format       | Google Style             | Oracle/Sun         |
| --------------- | -------------------------- | ------------------- | ------------------------ | ------------------ |
| Formatter       | IntelliJ/Eclipse (manuell) | `spring-javaformat` | Google Java Format       | keine Vorgabe      |
| Checkstyle      | optional                   | selten verwendet    | eigene Checkstyle-Regeln | Sun Checkstyle-XML |
| IDE-Integration | manuell                    | gut integriert      | Plugins verfügbar        | –                  |
