---
title: "Java Exercises - Variablen und primitive Datentypen"
linkTitle: "Variablen und Datentypen"
type: docs
weight: 4
description: >
  Mit diesen Übungen kannst du dein Wissen über Variablen und primitive Datentypen vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du weisst was Variablen sind.
- Du kannst eine Variable deklarieren und initialisieren.
- Du weisst was primitive Datentypen sind.
- Du weisst wie man Variablen formatiert auf der Konsole ausgibt.

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
[Download](./it-ninja_02_java_03_java-grundlagen_04_variables-and-types.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [!\*IntelliJ IDEA einrichten](/docs/99_shared/ide/intellij/01_installation/)
   2. Git-Repository einrichten → [!\*Persönliches Git-Repository](/docs/99_shared/collaboration/source-repositories/personal-bitbucket/)

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

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_04_variables-and-types.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Add it-ninja_02_java_03_java-grundlagen_04_variables-and-types"
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
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_04_variables-and-types"
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
`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\04_variables-and-types`
// linux
`[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/04_variables-and-types`
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
git push --set-upstream origin labs/it-ninja_02_java_03_java-grundlagen_04_variables-and-types
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

## Aufgabe 1 - Hello It-Ninja

Erstelle eine Variable, welche deinen Namen beinhaltet.
Gib `Hello [name]` auf der Konsole aus.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\HelloName.java](./source/#src-main-java-ch-itninja-labs-basicexercises-helloname-java):

```java
    public static void printHelloName(){

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispielausgabe:**

```console
Hello It-Ninja
```

## Aufgabe 2 - Reise Report

Gib den folgenden Text mit `System.out.printf(...)` aus. Ersetze die kursiv, fett dargestellten Werte im Logbuch durch
Variablen, welche du selber definieren musst.

---

Reise Report – **_Takeshi_**, Codename **_ShadowFox_**  
Datum der Abreise: **_26. Juli 2025_**  
Mission: **_Code-Review_**  
Startpunkt: **_Lausanne_**  
Zielort: **_St. Gallen_**  
Abfahrt: **_06:14 Uhr_**  
Ankunft: **_09:07 Uhr_**  
Zwischenhalte: **_5_**  
Reisekosten: **_51.80_** **_CHF_**

**_ShadowFox_** nutzte die **_1. Klasse_** am **_26. Juli 2025_**, um sich auf den anstehenden **_Code-Review_**
vorzubereiten. Mit einem Akku-Ladestand von **_92%_** und **_2_** mitgeführten Laptops war **_er_** bestens gerüstet.
Die Mission wurde **_erfolgreich_** abgeschlossen. Die Reisekosten sind in **_CHF_**.

---

Anforderungen:

- Verwende sinnvolle Datentypen (String, int, double, boolean)
- Nutze `printf` mit Formatangaben wie `%.2f`, `%d`, `%s`, `%%`
- Achte auf Lesbarkeit und saubere Struktur

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\TravelReport.java](./source/#src-main-java-ch-itninja-labs-basicexercises-travelreport-java):

```java
    public static void printTravelReport() {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

**Beispiel:**

Eingabe:

```console
TravelReport.printTravelReport();
```

Ausgabe:

```console
Reise Report – Takeshi, Codename ShadowFox
Datum der Abreise: 26. Juli 2025
Mission: Code-Review
Startpunkt: Lausanne
Zielort: St. Gallen
Abfahrt: 06:14 Uhr
Ankunft: 09:07 Uhr
Zwischenhalte: 5
Reisekosten: 51.80 CHF

ShadowFox nutzte die 1. Klasse am 26. Juli 2025, um sich auf die anstehende Code-Review vorzubereiten. Mit einem Akku-Ladestand von 92% und 2 mitgeführten Laptops war er bestens gerüstet. Die Mission wurde erfolgreich abgeschlossen. Die Reisekosten sind in CHF.
```
