# Java Coding Guidelines

Diese Richtlinien dienen der Vereinheitlichung und Verbesserung der Lesbarkeit und Wartbarkeit von Java-Code. Viele
Unternehmen oder Teams haben eigene Guidelines definiert. Im folgenden Dokument findest Du die Coding Guidelines von
IT-Ninjas für Java – mit ausgewählten Empfehlungen aus dem
[Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

> Frage bei Dir im Unternehmen / Projekt, welche Coding Guidelines verwendet werden!

## Inhaltsverzeichnis

1. [Sprache](#1-Sprache)  
2. [Einrückung und Formatierung](#2-einrückung-und-formatierung)  
3. [Zeilenlänge und Umbrüche](#3-zeilenlänge-und-umbrüche)  
4. [Kommentare](#4-kommentare)  
5. [Benennungsregeln](#5-benennungsregeln)  
6. [Klassenaufbau](#6-klassenaufbau)  
7. [Verwendung von Konstanten](#7-verwendung-von-konstanten)  
8. [Fehlerbehandlung](#8-fehlerbehandlung)  
9. [Hilfreiche Tools](#9-hilfreiche-tools)
10. [Vergleich Java Coding Guidelines](#10-vergleich-java-coding-guidelines)

---

## 1. Sprache

Da viele Projekte heutzutage international ausgerichtet sind, empfehlen wir, im Quellcode inklusive Kommentaren und
Dokumentation konsequent die englische Sprache zu verwenden. Wird stattdessen Deutsch gewählt, sollte auch dies
durchgängig und konsistent erfolgen – ein Mix aus Deutsch und Englisch ist zu vermeiden.

In beiden Fällen gilt: Fachbegriffe dürfen in einer anderen Sprache verwendet werden, wenn eine Übersetzung unüblich 
oder weniger verständlich wäre (z. B. Interface statt Schnittstelle im Deutschen).

## 2. Einrückung und Formatierung

- Einrückung mit **4 Leerzeichen**, keine Tabs.
- `{` kommt **in dieselbe Zeile** wie die Anweisung.
- **Annotations** (z. B. `@Override`) stehen immer **in einer eigenen Zeile** über der Deklaration.

{{< snippet name="format_and_indent" shiftleft="4" file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" >}}

---

## 3. Zeilenlänge und Umbrüche

- Max. **120 Zeichen pro Zeile** (empfohlen).
- Lange Aufrufe umschlagen.

{{< snippet name="long_lines_with_lot_params" shiftleft="4" file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" >}}

---

## 5. Benennungsregeln

| Element     | Stil           | Beispiel                     |
|-------------|----------------|------------------------------|
| Klassen     | PascalCase     | `CustomerAccount`            |
| Methoden    | camelCase      | `getUserName()`              |
| Variablen   | camelCase      | `maxRetries`                 |
| Konstanten  | UPPER_SNAKE    | `MAX_CONNECTIONS`            |
| Pakete      | lower.case     | `com.company.project.module` |

---

## 7. Verwendung von Konstanten

Vermeide "magische Zahlen" oder Strings:

{{< snippet file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" name="name_constants" shiftleft="4" >}}

---

## 4. Kommentare

### Inline-Kommentare

Inline-Kommentare dienen der Verständlichkeit des Codes. Prüfe vor dem Kommentieren, ob sich der Code nicht durch
klarere Benennung oder Struktur vereinfachen lässt.

Zur besseren Lesbarkeit sollten Inline-Kommentare in der Regel auf einer eigenen Zeile vor dem entsprechenden Code
stehen. Kommentare am Zeilenende gelten als Ausnahme und sollten nur für sehr kurze Erklärungen verwendet werden.

{{< snippet name="inline_comment" shiftleft="8" file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" >}}

### JavaDoc-Kommentare

JavaDoc sollte für alle **öffentlichen Klassen, Methoden, Konstruktoren und Felder** verwendet werden, da jede
öffentlich sichtbare API dokumentiert sein sollte. Auch **geschützte (protected)** Elemente sollten dokumentiert werden,
wenn sie Teil einer vererbbaren Klasse oder Schnittstelle sind. Für private Methoden oder Felder ist JavaDoc in der
Regel nicht erforderlich – außer der Code ist komplex oder der Zweck nicht unmittelbar ersichtlich.

Triviale Getter/Setter oder klar benannte Hilfsmethoden benötigen in der Regel keine zusätzliche Dokumentation.

> **Gut benannte Methoden und Parameter machen eine zusätzliche Dokumentation oft überflüssig.** Dennoch sollte bei
komplexem Verhalten oder öffentlich zugänglichen APIs auf aussagekräftige JavaDoc-Kommentare nicht verzichtet werden.

{{< snippet name="javadoc" shiftleft="4" file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" >}}

#### JavaDoc-Tags

- `@param` für Parameter (Pflicht bei mehr als einem oder bei komplexen Parametern)
- `@return` beschreibt den Rückgabewert (Pflicht bei Rückgabe ungleich `void`)
- `@throws` bei jeder deklarativen oder möglichen Exception (empfohlen)

---

## 6. Klassenaufbau

Die Reihenfolge der Elemente innerhalb einer Klasse folgt dem Google Java Style Guide:

1. Konstanten (`public static final`, `private static final`)
2. Statische Felder (`public`, `private`)
3. Instanzvariablen (`public`, `private`)
4. Konstruktoren
5. Öffentliche Methoden
6. Protected Methoden
7. Package-private Methoden
8. Private Methoden
9. Statische Methoden
10. Innere Klassen, Enums

---

## 8. Fehlerbehandlung

- Verwende checked exceptions nur, wenn sinnvoll.  
- Logge Fehler sinnvoll, aber ohne zu spammen.  
- Vermeide leere `catch`-Blöcke – wenn nötig, kommentiere sie mit `// intentionally empty`.

{{< snippet name="exceptions" shiftleft="8" file="/src/00_shared/coding-guidelines/java/src/ch/itninjas/program/Program.java" >}}

---

## 9. Hilfreiche Tools

- **Formatter**: IntelliJ/Eclipse mit einheitlichem Profil  
- **Analyse**: Checkstyle, PMD, SpotBugs, Sonar
- **Build-Integration**: Linter und Formatierung in CI/CD einbauen

---

## 10. Vergleich Java Coding Guidelines

Dieser Vergleich zeigt Gemeinsamkeiten und Unterschiede zwischen IT-Ninjas und anderen bekannten Java-Stilrichtlinien.

### Übersicht

| **Aspekt**                  | **IT-Ninjas (aktualisiert)**           | **Spring Java Format**                | **Google Java Style Guide**        | **Oracle/Sun Conventions**            |
|-----------------------------|----------------------------------------|---------------------------------------|-------------------------------------|----------------------------------------|
| **Einrückung**              | 4 Leerzeichen                         | 4 Leerzeichen                         | **2 Leerzeichen**                   | 4 Leerzeichen                          |
| **Zeilenlänge**             | max. 120 Zeichen                      | max. 120 Zeichen                      | **max. 100 Zeichen strikt**         | **max. 80 Zeichen**                    |
| **Klammern `{}`**           | in derselben Zeile                    | in derselben Zeile                    | in derselben Zeile                  | in derselben Zeile                     |
| **Annotations**             | eigene Zeile                          | eigene Zeile                          | eigene Zeile                        | keine Angabe (vor Java 5 entstanden)   |
| **Leere Blöcke**            | erlaubt mit Kommentar                 | optionaler Kommentar                  | nur mit `// intentionally empty`    | keine konkrete Regel                   |

---

### JavaDoc & Kommentare

| **Aspekt**           | **IT-Ninjas**                         | **Spring Format**                    | **Google Style**                    | **Oracle/Sun**                         |
|----------------------|----------------------------------------|--------------------------------------|-------------------------------------|----------------------------------------|
| **JavaDoc Pflicht**  | für öffentliche APIs                  | für öffentliche APIs empfohlen       | **für alle öffentlichen Elemente**  | für öffentliche Klassen/Methoden       |
| **JavaDoc-Tags**     | `@param`, `@return`, `@throws`        | empfohlen                            | **verpflichtend**                   | empfohlen                              |

---

### Benennungsregeln

| **Element**     | **Alle vier Richtlinien**                                                                 |
|------------------|--------------------------------------------------------------------------------------------|
| **Klassen**       | PascalCase – z. B. `MyService`                                                           |
| **Methoden**      | camelCase – z. B. `calculateSum()`                                                       |
| **Variablen**     | camelCase – z. B. `userName`                                                              |
| **Konstanten**    | UPPER_SNAKE_CASE – z. B. `MAX_SIZE`                                                      |
| **Pakete**        | nur Kleinbuchstaben, z. B. `com.example.project`                                         |

---

### Klassenstruktur

| **Klassenelemente-Reihenfolge** | **IT-Ninjas**                        | **Spring**                         | **Google Style**                   | **Oracle/Sun**                         |
|----------------------------------|--------------------------------------|-------------------------------------|-------------------------------------|----------------------------------------|
| Konstanten → statische Felder → Instanzvariablen → Konstruktor → Methoden | ✅                                | ✅                                  | ✅ mit detaillierter Unterscheidung     | grob ähnlich                          |

---

### Tooling & Formatierung

| **Aspekt**              | **IT-Ninjas**                         | **Spring Format**                        | **Google Style**                             | **Oracle/Sun**                         |
|-------------------------|----------------------------------------|-------------------------------------------|----------------------------------------------|----------------------------------------|
| Formatter               | IntelliJ/Eclipse Profil manuell       | `spring-javaformat` Plugin (Maven/Gradle) | Google Java Format / Checkstyle              | keine Tooling-Angabe                   |
| Checkstyle              | optional                              | nicht direkt verwendet                    | eigene Checkstyle XML                        | Sun Checkstyle-XML verfügbar           |
| IDE-Unterstützung       | manuell einstellbar                   | Spring Boot Starter Integration           | Google Formatter Plugin für IntelliJ         | nicht spezifiziert                     |
