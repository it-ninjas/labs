---
title: "Java Exercises - Das Switch Statement"
linkTitle: "Switch Statement"
type: docs
weight: 6
description: >
  Mit diesen Übungen kannst du dein Wissen über den Befehl `switch` vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du kennst den `switch` Befehl.

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-switch.zip) | [Online anschauen](./source/)` >}}

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
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_06_control-structures-switch"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-switch.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-switch"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\06_control-structures-switch`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/06_control-structures-switch`
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

## Aufgabe 1 - Monat ausgeben

Passe die folgende Methode an. Gib abhängig von der Variable `month` den passenden Monat auf der Konsole aus. Der Wert
`1` soll dabei dem Monat `Januar` entsprechen, `2` dem Monat `Februar`, usw. Für Zahlen welche keinem Monat entsprechen
soll `ungültiger Monat` auf der Konsole ausgegeben werden.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\MonthHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-monthhelper-java):

```java
    public static void printMonthByNumber(int month) {

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispiel 1:**

Eingabe:

```console
MonthHelper.printMonthByNumber(1);
```

Ausgabe:

```console
Januar
```

**Beispiel 2:**

Eingabe:

```console
MonthHelper.printMonthByNumber(5);
```

Ausgabe:

```console
Mai
```

**Beispiel 3:**

Eingabe:

```console
MonthHelper.printMonthByNumber(9);
```

Ausgabe:

```console
September
```

**Beispiel 4:**

Eingabe:

```console
MonthHelper.printMonthByNumber(12);
```

Ausgabe:

```console
Dezember
```

**Beispiel 5:**

Eingabe:

```console
MonthHelper.printMonthByNumber(22);
```

Ausgabe:

```console
ungültiger Monat
```

**Beispiel 6:**

Eingabe:

```console
MonthHelper.printMonthByNumber(-3);
```

Ausgabe:

```console
ungültiger Monat
```

## Aufgabe 2 - Wochentag

Passe die folgende Methode an. Gib abhängig von der Variable `weekdayName` auf der Konsole aus, um welchen Wochentag es sich
handelt:

- `Der [weekdayName] ist der [weekday]. Tag in der Woche.`
- `[weekdayName] entspricht keinem bekannten Wochentag.`

Wobei in der Ausgabe `[weekdayName]` durch den Namen des Wochentags ersetzt werden soll und `[weekday]` durch den Tag
der Woche, welche dem Wochentag entspricht. Der Montag soll dabei der erste Tag in der Woche sein.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\WeekHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-weekhelper-java):

```java
    public static void printWeekdayNumber(String weekdayName) {

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispiel 1:**

Eingabe:

```console
WeekHelper.printWeekdayNumber("Freitag");
```

Ausgabe:

```console
Der Freitag ist der 5. Tag in der Woche.
```

**Beispiel 2:**

Eingabe:

```console
WeekHelper.printWeekdayNumber("Donnerstag");
```

Ausgabe:

```console
Der Donnerstag ist der 4. Tag in der Woche.
```

**Beispiel 3:**

Eingabe:

```console
WeekHelper.printWeekdayNumber("Weihnachten");
```

Ausgabe:

```console
Weihnachten entspricht keinem bekannten Wochentag.
```

**Beispiel 4:**

Eingabe:

```console
WeekHelper.printWeekdayNumber("Samstag");
```

Ausgabe:

```console
Der Samstag ist der 6. Tag in der Woche.
```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/06_control_structures/#back-from-lab" "Kontrollstrukturen">}}
