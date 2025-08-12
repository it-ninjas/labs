---
title: "Java Exercises - Exception Handling"
linkTitle: "Exception Handling"
type: docs
weight: 9
description: >
  Mit diesen Übungen kannst du erste Erfahrungen beim behandeln von Exceptions sammeln.
---

<!--suppress CheckEmptyScriptTag -->

## Voraussetzungen

- Du kennst `try`, `catch`, `throw`, `throws` und `finally`.

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_09_exception_handling.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [IntelliJ IDEA einrichten](/docs/99_tools/ide/intellij/01_installation/)
   2. Git-Repository einrichten → [Persönliches Git-Repository](/docs/99_tools/zusammenarbeit/source-repositories/personal-bitbucket/)

2. Öffne eine [CMD-Shell](/docs/99_tools/shell/cmd/) und wechsle ins Verzeichnis deines Git-Repositories:  
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

4. Erstelle einen neuen Branch für die Übung:

   {{< code >}}
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_09_exception_handling"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_09_exception_handling.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_09_exception_handling"
   {{< /code >}}

{{< ninja info >}}
Auch hier kannst du einen kürzeren Namen wählen. Verwende **labs** am Anfang des Branch-Namens für Branches, die
deinen eigenen Code enthalten.
{{< /ninja >}}

{{< ninja tip >}}
**Pro-Tipp:**  
Du kannst jederzeit einen weiteren Branch erstellen – z. B. wenn du etwas ausprobieren möchtest. Alternativ kannst
du auch in der Git-History einen alten Stand wiederherstellen, was aber weniger flexibel ist.
{{< /ninja >}}

8. Starte IntelliJ und öffne mit `File → Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht
   hast, findest du das Projekt hier:  
   {{< code >}}
   // windows
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\09_exception_handling`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/09_exception_handling`
   {{< /code >}}

9. Falls du zum ersten Mal mit IntelliJ arbeitest, findest du [hier](/docs/99_tools/ide/intellij/03_run-and-debug)
   eine Anleitung, wie man ein Programm startet.

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

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

## Aufgabe 1 – Sichere Division

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode:** _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Liefert das Resultat der Divsion von `a` durch `b`. Bei einer Divsion durch 0 wird der Wert
`Integer.MAX_VALUE` zurückgeben.  
**Parameter1:** a [int]  
**Parameter2:** b [int]  
**Rückgabewert:** Resultat der Berechnung [int], `Integer,MAX_VALUE` bei Division durch 0.  
**Bedingungen:** Verwende `try` / `catch`, um Division durch 0 korrekt abzufangen. `if` darf nicht verwendet werden.

---

> Halte die Coding Guidelines ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\Calculator.java](./source/#src-main-java-ch-itninja-labs-basicexercises-calculator-java):

```java
public class Calculator {

    private Calculator() {
        // Prevent instantiation
    }

    // Place here the methode for "Sichere Division".

    // IT-Ninja: Füge hier Deinen Code ein:

    // Place here the methode for "Mindestwert sicherstellen".

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Sichere Division"
        // IT-Ninja: Füge hier Deinen Code ein:

        try {
            int age = 16;
            // Sample call for "Alter prüfen"
            // IT-Ninja: Füge hier Deinen Code ein:
            System.out.printf("Das Alter %d ist gültig.%n", age);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Sample call for "Mindestwert sicherstellen"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\CalculatorTest.java](./source/#src-test-java-ch-itninja-labs-calculatortest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } finally {
        }
```

## Aufgabe 2 – Alter prüfen

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode:** _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Prüft das Alter und wirft eine `IllegalArgumentException`, wenn das Alter kleiner 0 oder grösser 130 ist.
Für gültige Werte passiert nichts.  
**Parameter1:** age [int]  
**Rückgabewert:** keiner, `IllegalArgumentException` wenn Alter ausserhalb des erlaubten Bereichs ist.

---

> Halte die Coding Guidelines ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\AgeValidator.java](./source/#src-main-java-ch-itninja-labs-basicexercises-agevalidator-java):

```java
public class AgeValidator {

    // IT-Ninja: Füge hier Deinen Code ein:

    private AgeValidator() {
        // Prevent instantiation
    }

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Sichere Division"
        // IT-Ninja: Füge hier Deinen Code ein:

        try {
            int age = 16;
            // Sample call for "Alter prüfen"
            // IT-Ninja: Füge hier Deinen Code ein:
            System.out.printf("Das Alter %d ist gültig.%n", age);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Sample call for "Mindestwert sicherstellen"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\AgeValidatorTest.java](./source/#src-test-java-ch-itninja-labs-agevalidatortest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } catch (IllegalArgumentException e) {
            excptionOccured = true;
            exceptionMessage = e.getMessage();
        }
```

## Aufgabe 3 – Mindestwert sicherstellen

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode:** _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Dividiert `a` durch `b` und danach `c` durch `d`. Das Resultat wird jeweils zum Total hinzugefügt. Fehler
werden mit **einem einzigen** `try` / `catch` abgefangen. Im `finally`-Block wird abschliessend sichergestellt, dass das
Total mindestens 100 beträgt.  
**Parameter1:** a [int]  
**Parameter2:** b [int]  
**Parameter3:** c [int]  
**Parameter4:** b [int]  
**Rückgabewert:** Total der Berechnung [int]

---

Bei dieser Aufgabe ist es wichtig, dass du die Funktion genau umsetzt auch wenn sie eigentlich keinen Sinn macht oder
besser implementiert werden könnte.

> Halte die Coding Guidelines trotzdem ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\Calculator.java](./source/#src-main-java-ch-itninja-labs-basicexercises-calculator-java):

```java
public class Calculator {

    private Calculator() {
        // Prevent instantiation
    }

    // Place here the methode for "Sichere Division".

    // IT-Ninja: Füge hier Deinen Code ein:

    // Place here the methode for "Mindestwert sicherstellen".

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Sichere Division"
        // IT-Ninja: Füge hier Deinen Code ein:

        try {
            int age = 16;
            // Sample call for "Alter prüfen"
            // IT-Ninja: Füge hier Deinen Code ein:
            System.out.printf("Das Alter %d ist gültig.%n", age);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Sample call for "Mindestwert sicherstellen"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\CalculatorTest.java](./source/#src-test-java-ch-itninja-labs-calculatortest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode für "Mindestwert sicherstellen", welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } finally {
        }
```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/09_exception_handling/#back-from-lab" "Fehlerbehandlung mit Exceptions">}}
