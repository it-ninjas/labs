---
title: "Java Exercises - Variablen und bedingte Anweisungen"
linkTitle: "Bedingte Ausführung"
type: docs
weight: 6
description: >
  Mit diesen Übungen kannst du dein Wissen über bedingte Ausführung vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du verstehst und kennst die verschiedenen Conditional Statements.
- Du weisst, wann und wie welches Conditional Statement eingesetzt werden sollte.

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-if.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [IntelliJ IDEA einrichten](/docs/02_java/02_intellij-einrichten/)
   2. Git-Repository einrichten → [Persönliches Git-Repository](/docs/01_tools/02_personal-bitbucket/)

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
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_06_control-structures-if"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-if.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-if"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\06_control-structures-if`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/06_control-structures-if`
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

## Aufgabe 1 - Zahlenvergleich

Passe die folgende Methode an. Vergleiche die beiden Zahlen 'zahl1' und 'zahl2' und gib das Resultat des Vergleichs auf
auf der Konsole aus:

- `Zahl1(value1) ist kleiner als Zahl2(value2)`
- `Zahl1(value1) ist grösser als Zahl2(value2)`
- `Zahl1(value1) ist gleich gross wie Zahl2(value2)`

Wobei in der Ausgabe `value1` und `value2` durch die tatsächlichen Werte ersetzt werden sollen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\CompareNumbers.java](./source/#src-main-java-ch-itninja-labs-basicexercises-comparenumbers-java):

```java
    public static void compareNumbers(int number1, int number2) {

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispiel 1:**

Eingabe:

```console
CompareNumbers.compareNumbers(-1, 5);
```

Ausgabe:

```console
Zahl1(-1) ist kleiner als Zahl2(5)
```

**Beispiel 2:**

Eingabe:

```console
CompareNumbers.compareNumbers(23, 7);
```

Ausgabe:

```console
Zahl1(23) ist grösser als Zahl2(7)
```

**Beispiel 3:**

Eingabe:

```console
CompareNumbers.compareNumbers(47, 47);
```

Ausgabe:

```console
Zahl1(47) ist gleich gross wie Zahl2(47)
```

**Beispiel 4:**

Eingabe:

```console
CompareNumbers.compareNumbers(0, 0);
```

Ausgabe:

```console
Zahl1(0) ist gleich gross wie Zahl2(0)
```

## Aufgabe 2 - Schaltjahr

Passe die folgende Methode an. Stell fest, ob das übergebene Jahr ein Schaltjahr ist (Gregorianischer Kalender). Gib auf
der Konsole das Resultat aus:

- `Das Jahr year ist ein Schaltjahr gemäss gregorianischem Kalender`
- `Das Jahr year ist kein Schaltjahr gemäss gregorianischem Kalender`

Wobei in der Ausgabe `year` durch das tatsächliche Jahr ersetzt werden soll.
Falls das Jahr ein Schaltjahr ist, soll die Methode `true` zurückgeben, andernfalls `false`.

> Verwende keine logischen Ausdrücke zur Berechnung des Schaltjahres. Nutze stattdessen if-else- und else-if Anweisungen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\LeapYear.java](./source/#src-main-java-ch-itninja-labs-basicexercises-leapyear-java):

```java
    public static boolean isLeapYear(int year) {

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispiel 1:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(1200);
```

Ausgabe:

```console
Das Jahr 1200 ist kein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 2:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(1996);
```

Ausgabe:

```console
Das Jahr 1996 ist ein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 3:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(1900);
```

Ausgabe:

```console
Das Jahr 1900 ist kein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 4:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2000);
```

Ausgabe:

```console
Das Jahr 2000 ist ein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 5:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2021);
```

Ausgabe:

```console
Das Jahr 2021 ist kein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 6:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2024);
```

Ausgabe:

```console
Das Jahr 2024 ist ein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 7:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2100);
```

Ausgabe:

```console
Das Jahr 2100 ist kein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 8:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2400);
```

Ausgabe:

```console
Das Jahr 2400 ist ein Schaltjahr gemäss gregorianischem Kalender
```

**Beispiel 9:**

Eingabe:

```console
boolean result = LeapYear.isLeapYear(2023);
```

Ausgabe:

```console
Das Jahr 2023 ist kein Schaltjahr gemäss gregorianischem Kalender
```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/06_control_structures/#back-from-lab" "Kontrollstrukturen">}}
