---
title: "Java Exercises - Einfaches Hello World"
linkTitle: "Einfaches-Hello-World"
type: docs
weight: 1
description: >
  Hier kannst Du erste Erfahrungen sammeln mit einem einfachen Java Programm
---

## Voraussetzung
* Du bist bereit die nachfolgende Anleitung gründlich zu lesen.

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
    git checkout -b "templates/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_01_Einfaches-Hello-World"
    ```
    > Du kannst auch einen kürzeren Namen für den Branch wählen. Wir nutzen `templates` am Anfang des Branches für Branches, welche den original Source-Code von den Übungen enthalten.

5. Lade den Source-Code zu den Übungen herunter und entpacke den Inhalt im lokalen Repository ins Root-Verzeichnis: `[[itninja_localrepo|C:\\Users\\u123456\\repos.local\\it-ninjas-lab]]`). Den Source-Code kannst du hier herunterladen: [download](./it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_01_Einfaches-Hello-World.zip) | [online](./source/)

6. Commite den original Source-Code, damit er sicher im Repository ist:
    ```bash
    git add .
    git commit -m "Initial version from it-ninja"
    ```

7. Erstelle einen neuen Branch um deine Lösung zu implementieren:
    ```bash
    git checkout -b "labs/it-ninja_02_Java_03_java-grundlagen_01_BasicExercises_01_Einfaches-Hello-World"
    ```
    > Auch hier kannst Du einen kürzeren Namen für den Branch wählen. Nutze `labs` am Anfang des Branches für Branches, welche Code von dir enthalten.

    > **Pro-Tip:** Du kannst jederzeit einen weitere Branch machen, z.B. wenn du mal etwas ausprobieren willst. Alternativ kannst du auch in der History einen alten Stand wiederherstellen, was aber weniger flexibel ist.

8. Starte IntelliJ und öffne mit `File/Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht hast solltest du den Code in deinem Benutzerverzeichnis finden:

    {{<windows>}}`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_Java\03_java-grundlagen\01_BasicExercises\01_Einfaches-Hello-World`{{</windows>}}

    {{<linux>}}`[[itninja_localrepo|/home/users/u123456/repos.local/it-ninjas-lab]]\02_Java/03_java-grundlagen/01_BasicExercises/01_Einfaches-Hello-World`{{</linux>}}

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

## Einführung

## Aufgabe 1 - Hello World

Schau Dir das Programm an und versuche es zum Laufen zu bringen. Versuche, ein paar kleine Änderungen am Programm 
vorzunehmen. 

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\Main.java](./source/#src-main-java):

```java
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
        System.out.println("Hello again, world!");
    }
}
```
