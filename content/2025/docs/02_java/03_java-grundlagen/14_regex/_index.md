---
title: "RegEx in Java"
linkTitle: "RegEx in Java"
weight: 14
description: >
  In diesem Modul lernst du, wie du reguläre Ausdrücke in Java einsetzt, um Text zu durchsuchen, zu prüfen oder zu
  verarbeiten.
---

{{< todo>}} Erster Release, muss noch angeschaut und Aufgaben müssen definiert werden {{< /todo>}}

{{< module "J1" >}}

## Ziele

- Ich weiss, wie ich in Java reguläre Ausdrücke mit `Pattern` und `Matcher` verwende.
- Ich kann einfache RegEx-Ausdrücke in Java-Code integrieren.
- Ich kenne Sicherheitsaspekte bei der Verwendung von RegEx in Java.

{{< zeit lesen="15" >}}

## Einführung

Lies zuerst das Modul [Regex](../../../99_tools/diverses/regex/), bevor du hier weitermachst.

In Java werden reguläre Ausdrücke über die Klassen **`java.util.regex.Pattern`** und **`java.util.regex.Matcher`**
verwendet.

**Typische Anwendungsfälle:**

- Prüfen, ob ein String einem Muster entspricht
- Teilstrings extrahieren
- Text mit Mustererkennung ersetzen

---

## Beispiel: Prüfen einer E-Mail-Adresse

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailCheck {
    public static void main(String[] args) {
        String email = "test@example.com";
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("E-Mail ist gültig");
        } else {
            System.out.println("E-Mail ist ungültig");
        }
    }
}
```

---

## Beispiel: Alle Zahlen aus einem Text extrahieren

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumberExtractor {
    public static void main(String[] args) {
        String text = "Artikel 123 kostet 45 CHF";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Gefunden: " + matcher.group());
        }
    }
}
```

**Ausgabe:**

```
Gefunden: 123
Gefunden: 45
```

---

## Beispiel: Text ersetzen

```java
public class ReplaceExample {
    public static void main(String[] args) {
        String text = "Meine Telefonnummer ist 079 123 45 67";
        String hidden = text.replaceAll("\\d", "X");

        System.out.println(hidden);
    }
}
```

**Ausgabe:**

```
Meine Telefonnummer ist XXX XXX XX XX
```

---

## Sicherheitsaspekte bei RegEx in Java

### 1. Catastrophic Backtracking

- **Problem:** Auch in Java kann ein ungünstig formulierter RegEx zu extrem langer Laufzeit führen.
- **Beispiel:**
  ```java
  String regex = "(a+)+$";
  Pattern pattern = Pattern.compile(regex);
  Matcher matcher = pattern.matcher("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!");
  System.out.println(matcher.matches()); // dauert sehr lange
  ```
- **Lösung:** Verwende möglichst **präzise Quantifizierer** (`{1,10}` statt `+`), **Atomic Groups** (`(?>...)`) oder
  **possessive Quantifiers** (`++`, `*+`).

### 2. Injection durch dynamische Muster

- **Problem:** Wenn der RegEx direkt aus Benutzereingaben besteht, kann er manipuliert werden.
- **Unsicher:**
  ```java
  Pattern pattern = Pattern.compile(userInput);
  ```
- **Sicherer:** Benutzereingabe **escapen**:
  ```java
  String safeInput = Pattern.quote(userInput);
  Pattern pattern = Pattern.compile(safeInput);
  ```

### 3. Übermäßige Komplexität

- **Problem:** Java-Entwickler neigen dazu, sehr komplexe RegEx zu schreiben, die kaum wartbar sind.
- **Empfehlung:** Komplexe Muster aufteilen, ggf. mit Kommentaren (`(?x)`-Flag) lesbarer machen.

### 4. Falsche Annahmen bei Validierung

- **Problem:** Nur weil ein String das Muster erfüllt, heißt das nicht, dass er inhaltlich gültig ist.
- **Beispiel:** `a@b.c` erfüllt viele E-Mail-RegEx, ist aber oft ungültig.

---

## Best Practices für RegEx in Java

1. **Immer testen** – mit realistischen und Worst-Case-Eingaben.
2. **Komplexität reduzieren** – ggf. mehrere kleine RegEx verwenden.
3. **Benutzereingaben escapen** – `Pattern.quote()` nutzen.
4. **Performance im Blick behalten** – keine unkontrollierten `.*` in Kombination mit `.+`.

---

## Tipp

Testen von Java-RegEx-Ausdrücken online:

- [regex101.com](https://regex101.com) – Java-Modus auswählen
- [RegExPlanet](https://www.regexplanet.com/advanced/java/index.html) – Java-spezifischer RegEx-Tester
