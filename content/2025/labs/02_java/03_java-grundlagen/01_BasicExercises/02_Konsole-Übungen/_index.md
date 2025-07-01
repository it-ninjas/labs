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
* Du weisst, was mit Konsole gemeint ist.
* Du kannst Ausgaben auf die Konsole machen.
* Du weisst wie und warum man Zeichen escapen muss.

## Vorbereitungsarbeiten

> **Neu bei it-ninja?**  
  Die Anleitung enthält ein paar Befehle und Fachbegriffe, welche dir wahrscheinlich noch nichts sagen. Mach dir deswegen keine Sorgen. In den kommenden Modulen werden wir dir alles Schritt für Schritt erklären und schon bald bist auch du ein it-ninja.

Um die folgenden Aufgaben erfolgreich umzusetzen musst du folgende Schritte erledigen:

1. Beim ersten Mal:

    1. IntelliJ IDEA installieren -> [IntelliJ IDEA einrichten](/docs/02_java/02_intellij-einrichten/)
    2. Git-Repository einrichten -> [Persönliches Git-Repository](/docs/01_tools/02_personal-bitbucket/)


2. Öffne eine CMD-Shell und wechsle ins Verzeichnis von deinem Git-Repository

    {{<codeblock os="windows" lang="bash">}}
    //windows bash
    cd /d "[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]"
    git status
    //linux bash
    cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
    git status
    {{</codeblock>}}

3. Stelle sicher, dass alle Dateien im Git-Repository commited sind. Mit `git status` kannst du dir eine Übersicht verschaffen:
    ```bash
    git status
    ```

4. Erstelle einen neuen Branch für die Übung:
    ```bash
    git checkout -b "templates/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen"
    ```
    > Du kannst auch einen kürzeren Namen für den Branch wählen. Wir nutzen `templates` am Anfang des Branches für Branches, welche den original Source-Code von den Übungen enthalten.

5. Lade den Source-Code zu den Übungen herunter und entpacke den Inhalt im lokalen Repository ins Root-Verzeichnis: `[[itninja_localrepo|C:\\Users\\u123456\\repos.local\\it-ninjas-lab]]`). Den Source-Code kannst du hier herunterladen: [download](./it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen.zip) | [online](./source/)

6. Commite den original Source-Code, damit er sicher im Repository ist:
    ```bash
    git add .
    git commit -m "Initial version from it-ninja"
    ```

7. Erstelle einen neuen Branch um deine Lösung zu implementieren:
    ```bash
    git checkout -b "labs/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_02_Konsole-Übungen"
    ```
    > Auch hier kannst Du einen kürzeren Namen für den Branch wählen. Nutze `labs` am Anfang des Branches für Branches, welche Code von dir enthalten.

    > **Pro-Tip:** Du kannst jederzeit einen weitere Branch machen, z.B. wenn du mal etwas ausprobieren willst. Alternativ kannst du auch in der History einen alten Stand wiederherstellen, was aber weniger flexibel ist.

8. Starte IntelliJ und öffne mit `File/Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht hast solltest du den Code in deinem Benutzerverzeichnis finden:

    {{<windows>}}`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_Java\03_java-grundlagen\01_BasicExercises\02_Konsole-Übungen`{{</windows>}}

    {{<linux>}}`[[itninja_localrepo|/home/users/u123456/repos.local/it-ninjas-lab]]\02_Java/03_java-grundlagen/01_BasicExercises/02_Konsole-Übungen`{{</linux>}}

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

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

* Im Rahmen: `'|'`, `'-'`, `'+''`, Leerzeichen (`' '`) 
* Innerhalb: `'|'`, `'-'`, `'+'`, `'*'`, `'='`, `'@''`, Leerzeichen (`' '`)

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
