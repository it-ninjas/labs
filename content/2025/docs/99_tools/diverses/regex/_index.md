---
title: "Reguläre Ausdrücke"
linkTitle: "RegEx"
weight: 10
description: >
  In diesem Modul lernst du die Grundlagen von regulären Ausdrücken, unabhängig von einer Programmiersprache.
---

## Ziele

- Ich weiss, was ein regulärer Ausdruck (RegEx) ist und wofür er verwendet wird.
- Ich kenne die wichtigsten RegEx-Symbole und deren Bedeutung.
- Ich kann einfache RegEx-Ausdrücke lesen und verstehen.
- Ich weiss, wo RegEx typischerweise eingesetzt werden.
- Ich kenne grundlegende Sicherheits- und Performance-Aspekte bei RegEx.

{{< zeit lesen="15" >}}

---

## Einführung

**Reguläre Ausdrücke** (englisch: _Regular Expressions_, kurz **RegEx**) sind eine formale Sprache, um
**Muster in Texten** zu beschreiben. Mit ihnen kannst du prüfen, ob ein Text einem bestimmten Muster entspricht, oder
gezielt Textteile daraus extrahieren.

**Typische Einsatzgebiete:**

- Validierung von Benutzereingaben (z. B. E-Mail, Telefonnummer, Postleitzahl)
- Durchsuchen und Ersetzen von Texten
- Analyse und Extraktion von Daten aus Dateien oder Log-Einträgen

---

## Grundsyntax (Cheat-Tabelle)

| Zeichen   | Bedeutung                        | Beispiel    | Trifft z. B. |
| --------- | -------------------------------- | ----------- | ------------ |
| `.`       | beliebiges Zeichen               | `a.b`       | `a1b`, `a_b` |
| `*`       | 0 oder mehr Wiederholungen       | `ab*`       | `a`, `abb`   |
| `+`       | 1 oder mehr Wiederholungen       | `ab+`       | `ab`, `abb`  |
| `?`       | 0 oder 1 Wiederholung (optional) | `ab?`       | `a`, `ab`    |
| `{3}`     | genau 3 Wiederholungen           | `X{3}`      | `XXX`        |
| `{3,5}`   | 3 bis 5 Wiederholungen           | `X{3,5}`    | `XXX…XXXXX`  |
| `[]`      | Zeichenauswahl                   | `[abc]`     | `a` oder `b` |
| `[^...]`  | Negation in Klasse               | `[^abc]`    | `x`, `1` …   |
| `()`      | Gruppierung / Capturing          | `(abc)+`    | `abcabc`     |
| `(?:...)` | Gruppe **ohne** Capturing        | `(?:ab){2}` | `abab`       |
| `\|`      | Oder (Alternation)               | `rot\|blau` | `rot`/`blau` |
| `\d`      | Ziffer                           | `\d+`       | `123`        |
| `\D`      | **keine** Ziffer                 | `\D+`       | `abc_`       |
| `\w`      | Wortzeichen (`A-Za-z0-9_`)       | `\w+`       | `Test_1`     |
| `\W`      | **kein** Wortzeichen             | `\W+`       | `- !`        |
| `\s`      | Whitespace                       | `\s+`       | `␠`, `\t`    |
| `\S`      | **kein** Whitespace              | `\S+`       | `abc_1`      |

> **Greedy vs. Lazy:** `*?`, `+?`, `{m,n}?` sind **faule** Varianten → sie matchen **so wenig wie möglich**.

---

## Anker & Wortgrenzen

### Zeilen vs. ganze Eingabe

- `^` = Anfang **einer Zeile** (oder Stringanfang, wenn _multiline_ aus)
- `$` = Ende **einer Zeile** (oder Stringende, wenn _multiline_ aus)
- `\A` = **Beginn der gesamten Eingabe** (unabhängig von _multiline_)
- `\z` = **Ende der gesamten Eingabe** (wirklich letztes Zeichen)
  _(Oft existiert auch `\Z` = Ende oder direkt vor letztem Zeilenumbruch.)_

**Faustregel:**

- **Ganze Eingabe validieren?** → `\A … \z`.
- **Zeilenweise prüfen (Logs, CSV)?** → `^ … $` mit _multiline_-Flag.

### Wortgrenzen

- `\b` = **Wortgrenze** (Wechsel zwischen `\w` und Nicht-`\w`) – _zero-width_.
  Beispiel: `\bERROR\b` findet „ERROR“ als **eigenständiges Wort**.
- `\B` = **keine** Wortgrenze.

**Unicode-Hinweis:** In vielen Engines ist `\w` standardmässig ASCII-basiert.
Für Sprachen mit Umlauten/anderen Schriftsystemen prüfe Unicode-Optionen/Property-Klassen deiner Engine
(z. B. `\p{L}`, `\p{N}`).

---

## Lookaheads (Vorausschau)

**Lookaheads** prüfen Bedingungen **an der aktuellen Position**, schauen **nach vorn**, **verbrauchen keine Zeichen**
und **verschieben die Match-Position nicht** (_zero-width assertions_).

- **Positiv** `(?=X)`: Ab hier muss **X** folgen.
- **Negativ** `(?!X)`: Ab hier darf **nicht X** folgen.

**UND-Logik:** Mehrere Lookaheads hintereinander sind **UND** (alle Bedingungen müssen erfüllt sein).
**ODER:** Im **Inneren** eines Lookaheads mit `|` arbeiten.

**Beispiele (neutral):**

- Lokale Bedingung:

  ```regex
  foo(?!bar)
  ```

  → `foo` nur, **wenn nicht** `bar` folgt.

- Reihenfolge egal (global prüfen):

  ```regex
  \A(?=.*\bAlpha\b)(?=.*\bBeta\b)[\s\S]*\z
  ```

- „Nur wenn gefolgt von …“ (Suffix prüfen):
  ```regex
  \b[A-Z]{2}\d{4}(?=-\d{2}\b)
  ```

> `X` im Lookahead kann ein **vollwertiges Teil-Regex** sein (Gruppen, Alternativen, Quantifizierer, Wortgrenzen, Anker
> …).

Weitere Beispiele:

| Regex             | Bedeutung                                                                             |
| ----------------- | ------------------------------------------------------------------------------------- |
| `(?=.*TaFy)`      | schau rechts ob irgend ein Zeichen vorkommt und dann TaFy                             |
| `(?=\STaFy)`      | schau rechts ob kein Lehrzeichen vorkommt und dann TaFy                               |
| `(?=[^s,]*TaFy)`  | schau rechts ob kein Lehrzeichen und kein Komma vorkommt und dann TaFy                |
| `(?=[^s,]*[A-Z])` | schau rechts ob kein Lehrzeichen und kein Komma vorkommt und dann ein Grossbuchstaben |

---

## Mehrere Treffer in einer Zeile finden

- Verwende eine **„find all / global“**-Suche (nicht „ganze Zeile matchen“).
- **Überlappende** Treffer erhältst du per Lookahead-Trick, z. B. `(?=(aa))` findet in `aaaa` die drei überlappenden
  `aa`.

> Hinweis: Wie „global“ aktiviert wird, hängt von der Engine ab (Flag, API-Methode).
> Für dieses Modul genügt: **global suchen** und bei Bedarf **Lookahead** für überlappende Matches.

---

## Beispiele (neutral & kurz)

- **Ganzes Wort „ERROR“**:

  ```regex
  \bERROR\b
  ```

- **Zeile enthält zwei Begriffe (Reihenfolge egal)**:

  ```regex
  ^(?=.*Alpha)(?=.*Beta).*
  ```

- **Nur Ziffern (ganze Eingabe)**:

  ```regex
  \A[0-9]+\z
  ```

- **Token nicht von einem bestimmten Zeichen gefolgt**:
  ```regex
  TOKEN(?!\))
  ```

---

## Flags (Modifikatoren, engine‑neutral)

Flags beeinflussen, **wie** der RegEx interpretiert wird. Bezeichnungen/Schreibweise variieren je nach Engine.
Häufige Konzepte (inline meist als `(?i)`, `(?m)`, `(?s)` … verfügbar):

- **Case‑insensitive** (`i`): Gross/Kleinschreibung ignorieren.
- **Multiline** (`m`): `^` und `$` matchen an **Zeilen**anfang/-ende statt nur am ganzen String.
- **Dotall / Singleline** (`s`): `.` matcht **auch** Zeilenumbrüche.
- **Free‑spacing / Verbose** (`x`): Whitespace/Kommentare im Muster ignorieren (für Lesbarkeit).
- **Unicode‑Optionen**: Verhalten von `\w`, `\b`, Klassen wie `\p{L}` engineabhängig aktivieren.
- **Ungreedy/Default‑lazy** (`U`, PCRE): Kehrt Greedy/Lazy-Standard um (vorsichtig einsetzen).

> Details und exakte Namen sind engineabhängig (Java, .NET, PCRE, JavaScript). Schau in die Dokumentation deiner Engine.

---

## Performance & Sicherheit (kurz & wichtig)

### 1) Catastrophic Backtracking

- **Problem:** Bestimmte Muster werden bei ungünstigen Eingaben extrem langsam.
- **Ursache:** Viele Backtracking-Wege (z. B. verschachtelte „weite“ Quantifizierer).
- **Beispiel:** `(a+)+$` mit langer `a…a!`-Eingabe.
- **Gegenmittel (engine‑abhängig):** Muster präzisieren, _lazy_ sinnvoll einsetzen, atomare Gruppen `(?>...)`,
  possessive Quantifizierer `*+`, `++`, `{m,n}+`, Eingaben **begrenzen**.

### 2) Dynamische RegEx

- **Problem:** Ungeprüfte Benutzereingaben in Muster → Manipulation/Verlangsamung.
- **Lösung:** Eingaben escapen/whitelisten, Längenlimits setzen, ggf. Timeouts (falls vorhanden).

### 3) Überkomplexität

- **Problem:** Sehr komplexe RegEx sind schwer wartbar.
- **Lösung:** Aufteilen (Vorverarbeitung), kommentieren, möglichst **einfach** halten.

### 4) Engine‑Unterschiede

- **Lookarounds:** Moderne Engines (PCRE, .NET, Java) unterstützen Lookaheads; Lookbehind teils eingeschränkt.
  Manche Engines (z. B. RE2) **unterstützen keine Lookarounds**.
- **Unicode:** Verhalten von `\w`, `\b` variiert. Prüfe Flags/Optionen deiner Engine.

---

## Best Practices

1. **So einfach wie möglich.** Erst dann optimieren/erweitern.
2. **Eingabe begrenzen.** Länge, Inhalt, Vorverarbeitung (Trim, Normalisierung).
3. **Global testen.** Einschliesslich Worst-Cases (lange Strings ohne Treffer).
4. **Anker bewusst setzen.** `\A … \z` für „ganze Eingabe“, `^ … $` für Zeilen.
5. **Keine unnötigen „weiten“ Teile.** Unpräzises `.*` vor/um Lookarounds sparsam einsetzen.
6. **Dokumentation lesen**, wenn du Lookarounds, Unicode-Klassen, Flags nutzt (engine-spezifisch).

---

## Tipp

Nutze einen RegEx-Tester (z. B. _regex101_) zum Ausprobieren und Debuggen (mit Erklärungen & Match-Schritten).

---
