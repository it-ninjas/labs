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
[Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-switch.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [!\*IntelliJ IDEA einrichten](/docs/99_shared/ide/intellij/01_installation/)
   2. Git-Repository einrichten → {{<puzzle type="subtle">}}[!\*Persönliches Git-Repository](/docs/99_shared/collaboration/source-repositories/github/){{</puzzle>}}{{<sbb type="subtle">}}[!\*Persönliches Git-Repository](/docs/99_shared/collaboration/source-repositories/personal-bitbucket/){{</sbb>}}

2. Öffne eine [!\*CMD-Shell](/docs/99_shared/shell/cmd/) und wechsle ins Verzeichnis deines Git-Repositories:  
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
   git commit -m "[Kommentar der deine Änderung beschreibt]"
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

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-switch.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Add it-ninja_02_java_03_java-grundlagen_06_control-structures-switch"
   git push
   {{< /code >}}

{{< ninja info >}}
Beim ersten Mal reklamiert Git, da es den Template Branch auf dem Server noch nicht gibt. Kopiere den Befehl aus der
Fehlermeldung. Er sollte etwa folgende Form haben:

{{< code >}}
git push --set-upstream origin templates
{{< /code >}}

{{< /ninja >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-switch"
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
`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\06_control-structures-switch`
// linux
`[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/06_control-structures-switch`
{{< /code >}}

9. Falls du zum ersten Mal mit IntelliJ arbeitest, findest du [!\*hier](/docs/99_shared/ide/intellij/03_run-and-debug)
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
git push --set-upstream origin labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-switch
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
