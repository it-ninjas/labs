---
title: "Java Exercises - Ausgabe auf die Kommandozeile"
linkTitle: "Konsole-Übungen"
type: docs
weight: 2
description: >
  Mit diesen Übungen kannst du dein Wissen über die Ausgabe auf die Kommandozeile (Konsole) vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

## Voraussetzung

- Du weisst, was mit Konsole gemeint ist.
- Du kannst Ausgaben auf die Konsole machen.
- Du weisst wie und warum man Zeichen escapen muss.

## Vorbereitungsarbeiten

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [IntelliJ IDEA einrichten](/docs/02_java/02_intellij-einrichten/)
   2. Git-Repository einrichten → [Persönliches Git-Repository](/docs/01_tools/02_personal-bitbucket/)

2. Öffne eine CMD-Shell und wechsle ins Verzeichnis deines Git-Repositories:  
   {{<codeblock os="windows" lang="bash">}}
   // Windows
   cd /d "[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]"
   git status
   // Linux/macOS
   cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
   git status
   {{</codeblock>}}

3. Stelle sicher, dass alle Dateien im Git-Repository committed sind. Mit **git status** erhältst du eine Übersicht:

   ```bash
   git status
   ```

4. Erstelle einen neuen Branch für die Übung:

   ```bash
   git checkout -b "templates/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen"
   ```

   {{< ninja info >}}
   Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens für Branches, welche den ursprünglichen Übungscode enthalten.
   {{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   ```bash
   git add .
   git commit -m "Initial version from it-ninja"
   ```

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   ```bash
   git checkout -b "labs/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen"
   ```

   {{< ninja info >}}
   Auch hier kannst du einen kürzeren Namen wählen. Verwende **labs** am Anfang des Branch-Namens für Branches, die deinen eigenen Code enthalten.
   {{< /ninja >}}
   {{< ninja tip >}}
   **Pro-Tipp:**  
   Du kannst jederzeit einen weiteren Branch erstellen – z. B. wenn du etwas ausprobieren möchtest. Alternativ kannst du auch in der Git-History einen alten Stand wiederherstellen, was aber weniger flexibel ist.
   {{< /ninja >}}

8. Starte IntelliJ und öffne mit `File → Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht hast, findest du das Projekt hier:  
   {{<windows>}}
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_Java\03_java-grundlagen\01_BasicExercises\02_Konsole-Übungen`
   {{</windows>}}
   {{<linux>}}
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_Java/03_java-grundlagen/01_BasicExercises/02_Konsole-Übungen`
   {{</linux>}}

9. Falls du zum ersten Mal mit IntelliJ arbeitest, findest du [hier](/docs/99_tools/ide/intellij/03_run-and-debug) eine Anleitung, wie man ein Programm startet.

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

{{< ninja tip >}}
Die meisten Übungen sind professionell strukturiert – so wie in echten Softwareprojekten. Zu gutem Code gehören auch
Tests, die sicherstellen, dass dein Code wie erwartet funktioniert. Sofern nicht anders erwähnt, kannst du mit folgendem
Befehl im Root-Verzeichnis des Projekts (dort, wo sich auch die `pom.xml` befindet) überprüfen, ob du die Aufgabe
korrekt gelöst hast:

```bash
mvn test
```

Viel Erfolg!
{{< /ninja >}}

## Aufgabe 1 - Hello World

Passe den Code an damit `Hello World` auf der Konsole ausgegeben wird.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\HelloWorld.java](./source/#src-main-java-ch-itninja-labs-basicexercises-helloworld-java):

```java
    public static void printHelloWorld(){

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

**Beispielausgabe:**

```console
Hello World
```

## Aufgabe 2 - Ascii House

Zeichne ein Haus in der Konsole. Du darfst dazu folgende Zeichen verwenden:

*  `'/'`, `'\'`, `'+'`, `'-'`, `'_'`, `'['`, `']'`, `'|'`, Leerzeichen (`' '`)

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\AsciiHouse.java](./source/#src-main-java-ch-itninja-labs-basicexercises-asciihouse-java):

```java
    public static void printHouse(){

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

> **Hinweis:** Vorsicht bei `'\'`, das ist ein besonderes Zeichen in einem String und muss escaped werden, das
heisst für ein `'\'` muss man innerhalb von einem String das Zeichen zweimal schreiben → `".\\."`

Falls unklar ist, was hier gemeint ist, schau dir [ASCII-Art](https://de.wikipedia.org/wiki/ASCII-Art) an.

Hier eine Katze als Beispiel:

```console
 /\_/\
( o.o )
 > ^ <
```

## Aufgabe 3 - Ascii Swiss Flag

Zeichne eine Schweizer Fahne. Die Fahne muss einen Rahmen haben. Du darfst dazu
folgende Zeichen verwenden:

- Im Rahmen: `'|'`, `'-'`, `'+''`, Leerzeichen (`' '`)
- Innerhalb: `'|'`, `'-'`, `'+'`, `'*'`, `'='`, `'@''`, Leerzeichen (`' '`)

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\AsciiSwissFlag.java](./source/#src-main-java-ch-itninja-labs-basicexercises-asciiswissflag-java):

```java
    public static void printSwissFlag(){

        // IT-Ninja: Füge hier Deinen Code ein:

    }
```

Falls unklar ist, was hier gemeint ist, schau dir [ASCII-Art](https://de.wikipedia.org/wiki/ASCII-Art) an.

Hier ist die japanische Flagge als Beispiel:
```console
 ------------------
|                  |
|       @@@@       |
|     @@@@@@@@     |
|    @@@@@@@@@@    |
|     @@@@@@@@     |
|       @@@@       |
|                  |
 ------------------
```

---
{{<dokumentation "../../../../../docs/02_java/03_java-grundlagen/01_java_intro/#back-from-lab" "Struktur und Syntax">}}
