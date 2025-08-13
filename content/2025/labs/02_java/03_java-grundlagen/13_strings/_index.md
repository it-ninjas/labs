---
title: "Java Exercises - Strings"
linkTitle: "Strings"
type: docs
weight: 10
description: >
  Mit diesen Übungen kannst du dein Wissen zum Thema Strings vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du weisst was ein String ist.
- Du kannst eigene Packages und Methoden erstellen

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_13_strings.zip) | [Online anschauen](./source/)` >}}

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
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_13_strings"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_13_strings.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_13_strings"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\13_strings`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/13_strings`
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

## Ausgangslage

Du hast den folgenden String:

```
String poem = """
        Ein Ninja leise wie der Wind,
        Seine Waffen stets geschwind.
        "Shurikens" fliegen, scharf und schnell,
        Klingen funkeln, furchterregend hell.
        "Nunchakus" wirbeln im Tanz,
        Mit jedem Schlag, im Vorteil er ganz.
        Seine Waffen, geheim und klug,
        Begleiten ihn bei jedem Zug.""";
```

{{< ninja info >}}
Schreibe für jede Aufgabe eine eigene Methode, welche den String als Parameter nimmt.
Passe die `main(...)` Methode an, um deinen Quellcode aufzurufen.
{{< /ninja >}}

## Aufgabe 1 - Wörter zählen

Gib in der Konsole die Anzahl Wörtern aus. Als Wort gilt alles was eine Folge von Buchstaben und Zahlen sind.

{{< ninja warning >}}
Die Methode `String.split(...)` darf in dieser Aufgabe nicht verwendet werden. `String.split(...)` wird erst in einem
späteren Modul behandelt.
{{< /ninja >}}

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // IT-Ninja: rufe hier deine Methoden auf und gib die Resultate auf der Konsole aus
    }
```

## Aufgabe 2 - Grossbuchstaben

Gib den Text in Grossbuchstaben aus.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // IT-Ninja: rufe hier deine Methoden auf und gib die Resultate auf der Konsole aus
    }
```

## Aufgabe 2 - Punkte setzen

Gib den Text so aus, dass jedes Leerzeichen mit einem Punkt ersetzt wurde.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // IT-Ninja: rufe hier deine Methoden auf und gib die Resultate auf der Konsole aus
    }
```

## Aufgabe 2 - Wort ausschneiden

Schneide das Wort “Shurikens” aus. Ermittle hierfür die Position des Wortes anhand des "-Zeichens.

**Hinweis:** Die indexOf()-Methode bietet ein optionales Argument fromIndex an. Übergibst du die Position des ersten
Anführungszeichen + 1, dann wird die Position des zweiten zurückgegeben.

{{< ninja warning >}}
Die Methode `String.replace(...)` darf in dieser Aufgabe nicht verwendet werden.
{{< /ninja >}}

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\Main.java](./source/#src-main-java-ch-itninja-labs-main-java):

```java
    public static void main(String[] args) {

        // IT-Ninja: rufe hier deine Methoden auf und gib die Resultate auf der Konsole aus
    }
```
