---
title: "Java Exercises - Loops"
linkTitle: "Loops"
type: docs
weight: 6
description: >
  Mit diesen Übungen kannst du dein Wissen über die Befehle `for`, `while` und `do` vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du kennst die Befehle `for`, `while` und `do`.

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
[Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-loops.zip) | [Online anschauen](./source/)` >}}

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

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_06_control-structures-loops.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Add it-ninja_02_java_03_java-grundlagen_06_control-structures-loops"
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
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-loops"
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
`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\06_control-structures-loops`
// linux
`[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/06_control-structures-loops`
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
git push --set-upstream origin labs/it-ninja_02_java_03_java-grundlagen_06_control-structures-loops
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

## Aufgabe 1 - Summe aller durch 8 teilbaren Zahlen von 1 bis 100

Passe die folgende Methode an. Zähle alle Zahlen von **1 bis 100** zusammen, welche durch **8** teilbar sind und gib das
Resultat auf der Konsole aus:

- `Die Summe aller durch 8 teilbaren Zahlen von 1 bis 100 beträgt 624.`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\NumberHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java):

```java
    public static void sumDivisibleByEightFixedRange() {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

**Beispiel:**

Eingabe:

```console
NumberHelper.sumDivisibleByEightFixedRange()
```

Ausgabe:

```console
Die Summe aller durch 8 teilbaren Zahlen von 1 bis 100 beträgt 624.
```

## Aufgabe 2 - Summe aller durch X teilbaren Zahlen

Passe die folgende Methode an. Zähle alle Zahlen von `min` bis `max` zusammen, welche durch `divisor` teilbar sind und gib das
Resultat auf der Konsole aus:

- `Die Summe aller durch [divisor] teilbaren Zahlen von [min] bis [max] beträgt [result].`

> Abgrenzung: Wenn `max` kleiner als `min` ist oder wenn `divisor` kleiner gleich 0 ist, soll folgender Text auf der
> Konsole ausgegeben werden: `Berechnung mit diesen Werten nicht möglich`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\NumberHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java):

```java
    public static void sumDivisibleBy(int min, int max, int divisor) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

**Beispiel 1:**

Eingabe:

```console
NumberHelper.sumDivisibleBy(10, 30, 7);
```

Ausgabe:

```console
Die Summe aller durch 7 teilbaren Zahlen von 10 bis 30 beträgt 63.
```

**Beispiel 2:**

Eingabe:

```console
NumberHelper.sumDivisibleBy(30, 10, 7);
```

Ausgabe:

```console
Berechnung mit diesen Werten nicht möglich.
```

## Aufgabe 3 - Summe gemeinsames Vielfaches zweier Zahlen

Passe die folgende Methode an. Zähle alle Zahlen von `min` bis `max` zusammen, welche ein gemeinsames Vielfaches von den
beiden Zahlen `number1` und `number2`sind und gib das Resultat auf der Konsole aus:

- `Summe der Zahlen von [min] bis [max], die ein gemeinsames Vielfache von [number1] und [number2] sind: [result].`

> Abgrenzung: Wenn `max` kleiner als `min` ist oder wenn eine der Zahlen `number1` oder 'number2' kleiner gleich 0 ist,
> soll folgender Text auf der Konsole ausgegeben werden: `Berechnung mit diesen Werten nicht möglich`

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\NumberHelper.java](./source/#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java):

```java
    public static void sumCommonMultiples(int min, int max, int number1, int number2) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

**Beispiel 1:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(1, 50, 3, 5);
```

Ausgabe:

```console
Summe der Zahlen von 1 bis 50, die ein gemeinsames Vielfache von 3 und 5 sind: 90.
```

**Beispiel 2:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(1, 100, 4, 6);
```

Ausgabe:

```console
Summe der Zahlen von 1 bis 100, die ein gemeinsames Vielfache von 4 und 6 sind: 432.
```

**Beispiel 3:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(1, 10, 4, 6);
```

Ausgabe:

```console
Summe der Zahlen von 1 bis 10, die ein gemeinsames Vielfache von 4 und 6 sind: 0.
```

**Beispiel 4:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(50, 1, 3, 5);
```

Ausgabe:

```console
Berechnung mit diesen Werten nicht möglich.
```

**Beispiel 5:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(15, 15, 3, 5);
```

Ausgabe:

```console
Summe der Zahlen von 15 bis 15, die ein gemeinsames Vielfache von 3 und 5 sind: 15.
```

**Beispiel 6:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(60, 60, 4, 6);
```

Ausgabe:

```console
Summe der Zahlen von 60 bis 60, die ein gemeinsames Vielfache von 4 und 6 sind: 60.
```

**Beispiel 7:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(-30, 30, 6, 10);
```

Ausgabe:

```console
Summe der Zahlen von -30 bis 30, die ein gemeinsames Vielfache von 6 und 10 sind: 0.
```

**Beispiel 8:**

Eingabe:

```console
NumberHelper.sumCommonMultiples(1, 1000, 8, 12);
```

Ausgabe:

```console
Summe der Zahlen von 1 bis 1000, die ein gemeinsames Vielfache von 8 und 12 sind: 20664.
```
