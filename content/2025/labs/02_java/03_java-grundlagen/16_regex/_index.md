---
title: "Java Exercises - Regex"
linkTitle: "Regex"
type: docs
weight: 16
description: >
  Mit diesen Übungen kannst du dein Wissen zum Thema Regex vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Ich kann mit Regex Zeichenketten im Text erkennen und extrahieren.
- Ich verstehe, wie man Regex schrittweise und sicher testet.

{{< ninja tip>}}

Wir stellen dir bei den Übungen jeweils komplette Projekte zur Verfügung. Du musst grundsätzlich nur dort was anpassen,
wo die folgende Kommentarzeile steht:
{{< code >}}
// IT-Ninja: Füge hier Deinen Code ein:
{{< /code >}}

Alles andere kannst du für den Moment ignorieren. Wir erklären dir die einzelnen Zeilen Schritt für Schritt in den
Modulen.
{{< /ninja>}}

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja warning >}}
Diese Schritte musst du bei **jeder Übung erneut machen**. Jede Übung hat ein eigenes ZIP-File, welches du bei dir an
die richtige Stelle kopieren musst. Die Anleitung zeigt dir ziemlich gut, wie das geht...
{{< /ninja>}}

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_16_regex.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [!\*IntelliJ IDEA einrichten](/docs/99_tools/ide/intellij/01_installation/)
   2. Git-Repository einrichten → [!\*Persönliches Git-Repository](/docs/99_tools/zusammenarbeit/source-repositories/personal-bitbucket/)

2. Öffne eine [!\*CMD-Shell](/docs/99_tools/shell/cmd/) und wechsle ins Verzeichnis deines Git-Repositories:  
   {{< code >}}
   // Windows
   cd /d "[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]"
   git status
   // Linux
   cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
   git status
   {{< /code >}}

3. Stelle sicher, dass alle Dateien im Git-Repository committed sind. Mit **git status** erhältst du eine Übersicht:

   {{< code >}}
   git status
   {{< /code >}}

   Falls du bei diesem Befehl einen roten Text siehst, musst du zuerst die aktuellen Dateien sichern:

   {{< code >}}
   git add .
   git commit -m "[gescheiter Kommentar]"
   {{< /code >}}

4. Erstelle oder wechsle in den Template Branch:

   Beim ersten Mal musst du einen Template Branch erstellen:
   {{< code >}}
   git checkout -b "templates"
   {{< /code >}}

   Falls er bereits existiert, kannst du einfach switchen:
   {{< code >}}
   git switch "templates"
   {{< /code >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_16_regex.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Add it-ninja_02_java_03_java-grundlagen_16_regex"
   git push
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_16_regex"
   {{< /code >}}

{{< ninja info >}}
Hier kannst du auch einen kürzeren Namen wählen. Verwende **labs** am Anfang des Branch-Namens für Branches, die
deinen eigenen Code enthalten.

Stelle dir einen Branch vorerst als Ordner vor. Jeder Ordner enthält eine Version oder einen Stand von deinem Quellcode.
Du kannst dann mit git zwischen diesen Ordern hin und her wechseln, sie vergleichen aber später auch zusammenführen.
{{< /ninja >}}

{{< ninja tip >}}
**Pro-Tipp:**  
Du kannst jederzeit einen weiteren Branch erstellen – z. B. wenn du etwas ausprobieren möchtest. Alternativ kannst
du auch in der Git-History einen alten Stand wiederherstellen, was aber weniger flexibel ist.
{{< /ninja >}}

8. Starte IntelliJ und öffne mit `File → Open` das Verzeichnis mit dem Source-Code.

{{< ninja warning >}}
Du musst mit IntelliJ den Ordner suchen, welches einen Ordner `src` oder die Datei `pom.xml` enthält. Ansonsten wird
IntelliJ Mühe haben, dir das Programm zu kompilieren.
{{< /ninja >}}

Wenn du alles korrekt gemacht hast, findest du das Projekt hier:  
 {{< code >}}
// windows
`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\16_regex`
// linux
`[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/16_regex`
{{< /code >}}

9. Falls du zum ersten Mal mit IntelliJ arbeitest, findest du [!\*hier](/docs/99_tools/ide/intellij/03_run-and-debug)
   eine Anleitung, wie man ein Programm startet.

{{< ninja tip >}}
Um das Programm zu starten musst du jeweils die Datei Main.java öffenen. Dann sollte in IntelliJ oben rechts ein grünes
Dreieck vorhanden sein, welches das Programm startet.
{{< /ninja >}}

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

{{< ninja warning >}}
Wenn du alle Änderungen gemacht hast und mit der Übung fertig bist, oder einen 'Zwischenstand' festhalten willst, führe
die folgenden Befehle aus um das Repository auf dem Server zu speichern (von wo du es geklont hast):

{{< code >}}
// Windows
cd /d "[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]"
git add --all
git commit -m "Kurzer Kommentar"
// Linux
cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
git add .
git commit -m "Kurzer Kommentar"
{{< /code >}}

Wenn du deine Änderungen auf dem Git-Server sichern willst, musst du das mit einem `push` machen.

Beim ersten mal musst du git noch mitteilen, wie der Branch auf dem Git-Server heissen soll:

{{< code >}}
git push --set-upstream origin labs/it-ninja_02_java_03_java-grundlagen_16_regex
{{< /code >}}

Bei weiteren `pushes` wird es dann einfacher:

{{< code >}}
git push
{{< /code >}}

{{< /ninja >}}

{{< ninja tip >}}
Die meisten Übungen sind professionell strukturiert – so wie in echten Softwareprojekten. Zu gutem Code gehören auch
Tests, die sicherstellen, dass dein Code wie erwartet funktioniert. Sofern nicht anders erwähnt, kannst du mit
folgendem Befehl im Root-Verzeichnis des Projekts (dort, wo sich auch die `pom.xml` befindet) überprüfen, ob du die
Aufgabe korrekt gelöst hast:

```bash
mvn test
```

Viel Erfolg!
{{< /ninja >}}

{{< /toggle >}}

## Aufgabe 1 - E-Mail-Adressen aus einem Text extrahieren

Schreibe eine Regex, die alle E-Mail-Adressen in einem Text findet. Nutze die bereitgestellte Beispieldatei `data/mixed.txt`.
</itninja description>

- Beispieleingabe: `Meine Adresse: max.mustermann@example.com; Info: test@mail.de`
- Erwartete Treffer: `["max.mustermann@example.com", "test@mail.de"]`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern that matches email-like addresses.
     * Tip: local-part + "@" + domain + TLD of length >= 2.
     */
    public static Pattern buildEmailPattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

## Aufgabe 2 - IBAN formatvalidieren

<itninja description lab="regex-iban">
Validiere IBANs rein syntaktisch (ohne Mod-97-Prüfung). Akzeptiere optionale Leerzeichen zwischen Blöcken.
</itninja description>

- Beispiele: `CH93 0076 2011 6238 5295 7`, `DE89 3704 0044 0532 0130 00`
- Hinweis: Landeskürzel (2 Grossbuchstaben), 2 Ziffern Prüfsumme, restliche Zeichen: A–Z oder 0–9.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern that matches IBANs syntactically with optional spaces.
     * Examples: "CH93 0076 2011 6238 5295 7", "DE89 3704 0044 0532 0130 00"
     * Note: Only format validation here, not the Mod-97 checksum.
     */
    public static Pattern buildIbanPattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

## Aufgabe 3 - Telefonnummern (Schweiz und international)

<itninja description lab="regex-phone">
Erkenne Telefonnummern mit optionalem Ländercode (z. B. +41) und unterschiedlichen Trennzeichen (Leerzeichen, Punkt, Bindestrich).
</itninja description>

- Beispiele: `+41 31 987 65 43`, `031 987 65 43`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern for (Swiss/international) phone numbers with optional country code
     * and separators (space, dot, hyphen). Keep it reasonably permissive.
     */
    public static Pattern buildPhonePattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

## Aufgabe 4 - URLs extrahieren

<itninja description lab="regex-url">
Extrahiere http- und https-URLs aus einem Text, ohne ans Zeilenende zu laufen oder nachfolgende Satzzeichen mitzunehmen.
</itninja description>

- Beispiele: `https://it-ninjas.ch`, `http://example.org/test`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern that captures http/https URLs without trailing punctuation.
     */
    public static Pattern buildUrlPattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

## Aufgabe 5 - Passwort-Policy prüfen

<itninja description lab="regex-password">
Mindestens 8 Zeichen, je 1 Klein- und Grossbuchstabe, 1 Ziffer, 1 Sonderzeichen. Prüfe mit einem einzigen Regex.
</itninja description>

- Beispiel gültig: `SecuRe!234`
- Beispiel ungültig: `password1`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern enforcing: >= 8 chars, at least 1 lowercase, 1 uppercase, 1 digit, 1 symbol.
     * Hint: lookaheads.
     */
    public static Pattern buildPasswordPolicyPattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

### Aufgabe 6 - Schweizer Postleitzahlen (CH-PLZ)

<itninja description lab="regex-ch-plz">
Erkenne CH-Postleitzahlen (genau 4 Ziffern, keine führende 0). Beachte, dass nach der PLZ eine Ortsbezeichnung kommen
muss.
</itninja description>

- Beispiele gültig: `3007`, `1000`
- Beispiele ungültig: `0123`, `12345`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\regex\RegexTasks.java](./source/#src-main-java-ch-itninja-labs-regex-regextasks-java):

```java
    /**
     * Build a Pattern that matches Swiss postal codes (4 digits, no leading zero).
     */
    public static Pattern buildChPostalCodePattern() {
        // TODO: implement
        return Pattern.compile("");
    }
```

---

## Hinweise

- Teste deine Regex iterativ, nutze Raw-Strings (z. B. in Java `Pattern.compile("...")`) und kleine Testfälle.
- Achte darauf, bei Extraktion _nicht zu gierig_ zu matchen und Mehrfachtreffer zu ermöglichen.
- Für IBANs ist eine vollständige Validierung inkl. Prüfziffernrechnung ausserhalb des Regex sinnvoll.
