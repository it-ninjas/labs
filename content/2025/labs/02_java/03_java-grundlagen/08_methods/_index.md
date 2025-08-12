---
title: "Java Exercises - Methoden"
linkTitle: "Methoden"
type: docs
weight: 8
description: >
  Mit diesen Übungen kannst du dein Wissen über Methoden vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_08_methods.zip) | [Online anschauen](./source/)` >}}

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

2. Öffne eine CMD-Shell und wechsle ins Verzeichnis deines Git-Repositories:  
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
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_08_methods"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_08_methods.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_08_methods"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\08_methods`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/08_methods`
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

## Aufgabe 1: Nachricht drucken

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode:** _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Gibt eine Nachricht auf der Konsole aus, Format: `Nachricht an [Name des Empfängers]: [Nachricht]`  
**Parameter1:** Name des Empfängers [String]  
**Parameter2:** Nachricht [String]  
**Rückgabewert:** Keiner

---

> Halte die Coding Guidelines ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\MessageHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-messagehelper-java):

```java
public class MessageHelper {

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Nachricht drucken"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Minimum von drei Zahlen"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Fibonacci"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\basicexercises\MessageHelperTest.java](./source/#src-test-java-ch-itninja-labs-basicexercises-messagehelpertest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: methode(name, message);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } finally {
            System.setOut(originalOut);
        }
```

**Beispiel 1:**

Eingabe:

```console
yourImplementation("Peter", "Das Meeting beginnt um 9 Uhr.");
```

Ausgabe:

```console
Nachricht an Peter: Das Meeting beginnt um 9 Uhr.
```

**Beispiel 2:**

Eingabe:

```console
yourImplementation("Linda", "Bitte rufe Hans Mustermann zurück.");
```

Ausgabe:

```console
Nachricht an Linda: Bitte rufe Hans Mustermann zurück.
```

## Aufgabe 2: Minimum von drei Zahlen

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode: _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Gibt die kleinste von 3 Zahlen zurück  
**Parameter1:** Erste Zahl [int]  
**Parameter2:** Zweite Zahl [int]  
**Parameter3:** Dritte Zahl [int]  
**Rückgabewert:\*\* Kleinste der 3 Zahlen [int]

---

> Halte die Coding Guidelines ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\NumberHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java):

```java
public class NumberHelper {

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Nachricht drucken"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Minimum von drei Zahlen"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Fibonacci"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\basicexercises\NumberHelperTest.java](./source/#src-test-java-ch-itninja-labs-basicexercises-numberhelpertest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } finally {
        }
```

**Beispiel 1:**

Eingabe:

```console
min = yourImplementation(63, 22, 98);
```

Ausgabe:

```console
Example Output: The minimum from 63, 22 and 98 is 22.

```

**Beispiel 2:**

Eingabe:

```console
min = yourImplementation(17, 67, 32);
```

Ausgabe:

```console
Example Output: The minimum from 17, 67 and 32 is 17.

```

**Beispiel 3:**

Eingabe:

```console
min = yourImplementation(4, 56, 3);
```

Ausgabe:

```console
Example Output: The minimum from 4, 56 and 3 is 3.

```

## Aufgabe 3: Fibonacci

Passe untenstehenden Quellcode an und füge folgende Methode hinzu:

---

**Name der Methode:** _Bestimme selber einen passenden Namen für die Methode_  
**Funktion:** Berechnet die n-te Zahl der Fibonacci-Folge.  
**Parameter1:** n [int]  
**Rückgabewert:** n-te Zahl der Fibonacci-Folge [int]  
**Abgrenzung:** Gibt -1 zurück, wenn Fibonacci-Folge ausserhalb des Wertebreichs von int ist.

---

Informationen zur Fibonacci-Folge findest du [hier](https://de.wikipedia.org/wiki/Fibonacci-Folge).

> Halte die Coding Guidelines ein!

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\FibonacciHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-fibonaccihelper-java):

```java
public class FibonacciHelper {

    // IT-Ninja: Füge hier Deinen Code ein:
}
```

Wenn du die Methode implementiert hast, kannst du sie aus `main` aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // Sample call for "Nachricht drucken"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Minimum von drei Zahlen"
        // IT-Ninja: Füge hier Deinen Code ein:

        // Sample call for "Fibonacci"
        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

Falls du sie testen willst, kannst du sie aus dem vorbereiteten Test aufrufen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\test\java\ch\itninja\labs\basicexercises\FibonacciHelperTest.java](./source/#src-test-java-ch-itninja-labs-basicexercises-fibonaccihelpertest-java):

```java
        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: fibonacci = methode(n);):
            // IT-Ninja: Füge hier Deinen Code ein:
        } finally {
        }
```

**Beispiel 1:**

Eingabe:

```console
fibonacci = yourImplementation(0);
```

Ausgabe:

```console
Example Output: The 0. element of the Fibonacci sequence is 0.

```

**Beispiel 2:**

Eingabe:

```console
fibonacci = yourImplementation(1);
```

Ausgabe:

```console
Example Output: The 1. element of the Fibonacci sequence is 1.

```

**Beispiel 3:**

Eingabe:

```console
fibonacci = yourImplementation(2);
```

Ausgabe:

```console
Example Output: The 2. element of the Fibonacci sequence is 1.

```

**Beispiel 4:**

Eingabe:

```console
fibonacci = yourImplementation(7);
```

Ausgabe:

```console
Example Output: The 7. element of the Fibonacci sequence is 13.

```

**Beispiel 5:**

Eingabe:

```console
fibonacci = yourImplementation(-5);
```

Ausgabe:

```console
Example Output: The -5. element of the Fibonacci sequence is 0.

```

**Beispiel 6:**

Eingabe:

```console
fibonacci = yourImplementation(100);
```

Ausgabe:

```console
Example Output: The 100. element of the Fibonacci sequence is -1.

```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/08_methods/#back-from-lab" "Methoden">}}
