---
title: "Java Exercises - Debugging"
linkTitle: "Debugging"
type: docs
weight: 10
description: >
  Mit diesen Übungen kannst du dein Wissen zum Thema Debuggen vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du weisst was ein Breakpoint ist.
- Du kannst den Debugger starten und den Code Schritt für Schritt ausführen

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_10_debugging.zip) | [Online anschauen](./source/)` >}}

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
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_10_debugging"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_10_debugging.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_10_debugging"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\10_debugging`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/10_debugging`
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

{{< ninja warning>}}
Zum Lösen der folgenden Aufgaben darfst du den Quellcode nicht verändern!
{{< /ninja >}}

## Aufgabe 1 - Wert in Zwischenberechnung herausfinden

Finde heraus, welcher Wert z hat, wenn x = 500 ist.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\MagicNumber.java](./source/#src-main-java-ch-itninja-labs-basicexercises-magicnumber-java):

```java
    public static int generate(int iterations) throws InterruptedException {

// IT-Ninja: Füge hier Deinen Code ein:
        // IT-Ninja: Zum Lösen der folgenden Aufgaben darfst du den Quellcode nicht verändern!

        // IT-Ninja: Aufgabe 1 - Finde heraus, welcher Wert z hat, wenn x = 500 ist.

        // IT-Ninja: Aufgabe 2 - Hat z am Ende immer den gleichen Wert, auch wenn du in der 'for'-Schleife einen
        //                       Breakpoint gesetzt hast?

        // IT-Ninja: Erstelle Screenshots und diskutiere deine Resultate und Erkenntnisse mit deinem Praxisbildner.

        int z = 0;
        for(int x = 0; x < iterations; x++) {
            z = MagicNumberHelper.getSecretValue(x);
        }
        return z;
    }
```

## Aufgabe 2 - Verhalten des Programms beim Debuggen

Beantworte folgende Frage: Hat z am Ende immer den gleichen Wert, auch wenn du in der 'for'-Schleife einen Breakpoint
gesetzt hast?

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\MagicNumber.java](./source/#src-main-java-ch-itninja-labs-basicexercises-magicnumber-java):

```java
    public static int generate(int iterations) throws InterruptedException {

// IT-Ninja: Füge hier Deinen Code ein:
        // IT-Ninja: Zum Lösen der folgenden Aufgaben darfst du den Quellcode nicht verändern!

        // IT-Ninja: Aufgabe 1 - Finde heraus, welcher Wert z hat, wenn x = 500 ist.

        // IT-Ninja: Aufgabe 2 - Hat z am Ende immer den gleichen Wert, auch wenn du in der 'for'-Schleife einen
        //                       Breakpoint gesetzt hast?

        // IT-Ninja: Erstelle Screenshots und diskutiere deine Resultate und Erkenntnisse mit deinem Praxisbildner.

        int z = 0;
        for(int x = 0; x < iterations; x++) {
            z = MagicNumberHelper.getSecretValue(x);
        }
        return z;
    }
```

**Beispiel:**

Eingabe:

```console
MagicNumber.generate(1000);
```

Ausgabe:

```console
-32414486
```

{{< ninja info>}}
Erstelle ScreenShots und diskutiere deine Resultate und Erkenntnisse mit deinem Praxisbildner.
{{< /ninja >}}

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/10_debugging/#back-from-lab" "Debugging – Fehler finden und verstehen">}}
