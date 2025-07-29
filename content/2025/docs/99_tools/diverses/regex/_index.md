---
title: "Reguläre Ausdrücke"
linkTitle: "RegEx"
weight: 10
description: >
  In diesem Modul lernst du die Grundlagen von regulären Ausdrücken, unabhängig von einer Programmiersprache.
---

{{< todo>}} Erster Release, muss noch angeschaut werden. {{< /todo>}}

## Ziele

- Ich weiss, was ein regulärer Ausdruck (RegEx) ist und wofür er verwendet wird.
- Ich kenne die wichtigsten RegEx-Symbole und deren Bedeutung.
- Ich kann einfache RegEx-Ausdrücke lesen und verstehen.
- Ich weiss, wo RegEx typischerweise eingesetzt werden.
- Ich kenne grundlegende Sicherheitsaspekte im Umgang mit RegEx.

{{< zeit lesen="15" >}}

## Einführung

**Reguläre Ausdrücke** (englisch: _Regular Expressions_, kurz **RegEx**) sind eine formale Sprache, um
**Muster in Texten** zu beschreiben. Mit ihnen kannst du prüfen, ob ein Text einem bestimmten Muster entspricht, oder
gezielt Textteile daraus extrahieren.

**Typische Einsatzgebiete:**

- Validierung von Benutzereingaben (z. B. E-Mail, Telefonnummer, Postleitzahl)
- Durchsuchen und Ersetzen von Texten
- Analyse und Extraktion von Daten aus Dateien oder Log-Einträgen

---

## Grundsyntax

| Zeichen | Bedeutung                    | Beispiel      | Beschreibung                    |
| ------- | ---------------------------- | ------------- | ------------------------------- | ----- | ----------------- |
| `.`     | beliebiges Zeichen           | `a.b`         | Findet `aXb`, `a1b`, `a_b` usw. |
| `*`     | 0 oder mehr Wiederholungen   | `ab*`         | `a`, `ab`, `abb`, `abbb`        |
| `+`     | 1 oder mehr Wiederholungen   | `ab+`         | `ab`, `abb`, `abbb`             |
| `?`     | 0 oder 1 Wiederholung        | `ab?`         | `a`, `ab`                       |
| `[]`    | Zeichenauswahl               | `[abc]`       | `a`, `b` oder `c`               |
| `[^]`   | Negation                     | `[^abc]`      | alles außer `a`, `b`, `c`       |
| `()`    | Gruppierung                  | `(abc)+`      | `abc`, `abcabc`, …              |
| `       | `                            | Oder-Operator | `rot                            | blau` | `rot` oder `blau` |
| `\d`    | Ziffer                       | `\d{3}`       | genau 3 Ziffern                 |
| `\w`    | Buchstabe/Ziffer/Unterstrich | `\w+`         | ein oder mehrere Wortzeichen    |
| `\s`    | Leerzeichen                  | `\s+`         | ein oder mehrere Leerzeichen    |

---

## Beispiele

**E-Mail-Adresse prüfen:**

```
^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,}$
```

**Schweizer Telefonnummer prüfen:**

```
^0\d{2}\s\d{3}\s\d{2}\s\d{2}$
```

**Nur Zahlen:**

```
^[0-9]+$
```

---

## Sicherheitsaspekte

Reguläre Ausdrücke können bei falscher oder unvorsichtiger Anwendung **Sicherheits- und Performanceprobleme** verursachen.
Die wichtigsten Risiken sind:

### 1. Catastrophic Backtracking

- **Problem:** Manche RegEx-Ausdrücke können bei bestimmten Eingaben extrem langsam werden.
- **Grund:** Der RegEx-Interpreter probiert sehr viele mögliche Kombinationen aus, bevor er entscheidet, dass ein Match
  nicht möglich ist.
- **Folge:** Hohe CPU-Last, im Extremfall ein **Denial of Service (ReDoS)**.
- **Beispiel:**
  ```regex
  (a+)+$
  ```
  Eingabe: `"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!"` → führt zu Millionen von Vergleichsoperationen.

### 2. Injection durch dynamische RegEx-Erstellung

- **Problem:** Wenn Benutzereingaben ungeprüft in einen RegEx übernommen werden, kann der Nutzer das Muster verändern.
- **Grund:** RegEx-Sonderzeichen wie `.` oder `*` können das Suchmuster manipulieren.
- **Folge:** Falsche oder unerwartete Treffer, absichtliche Verlangsamung.
- **Beispiel:**
  ```java
  // Unsicher – Benutzer bestimmt den gesamten Ausdruck
  Pattern pattern = Pattern.compile(userInput);
  ```
  → `userInput = ".*"` findet alles.

### 3. Übermäßige Komplexität

- **Problem:** Sehr komplexe RegEx-Ausdrücke sind schwer zu lesen und zu warten.
- **Folge:** Höheres Risiko für Fehler, falsche Matches oder Sicherheitslücken.
- **Beispiel:**
  ```regex
  ^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*?&]).{8,}$
  ```
  → Passwort-RegEx, schwer wartbar.

### 4. Falsche Annahmen bei Validierung

- **Problem:** RegEx wird manchmal als alleinige Validierungsmethode verwendet.
- **Grund:** RegEx prüft nur, ob ein Text einem Muster entspricht – nicht, ob er inhaltlich gültig ist.
- **Folge:** Formell korrekte, aber inhaltlich falsche Daten können akzeptiert werden.
- **Beispiel:**
  - E-Mail: `a@b.c` passt, ist aber oft ungültig.
  - Telefonnummer: `000 000 00 00` erfüllt das Format, ist aber keine echte Nummer.

---

## Best Practices

1. **Einfache RegEx verwenden** – unnötig komplexe Muster vermeiden.
2. **Eingaben vorverarbeiten** – z. B. Whitespace entfernen, Größe begrenzen.
3. **RegEx testen** – Worst-Case-Eingaben prüfen (lange Strings ohne Treffer).
4. **Zusätzliche Logik** – RegEx nur als einen Teil der Validierung nutzen.

---

## Tipp

Teste RegEx-Ausdrücke mit einem Online-Tool wie [regex101.com](https://regex101.com).
