---
title: "Java Exercises - Einfaches Hello World"
linkTitle: "Einfaches Hello World"
type: docs
weight: 0
description: >
  Hier kannst Du erste Erfahrungen sammeln mit einem einfachen Java Programm
---

## Voraussetzung

- Du bist bereit die nachfolgende Anleitung gründlich zu lesen.

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_Java_03_java-grundlagen_00_Einfaches-Hello-World.zip) | [Online anschauen](./source/)` >}}

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
   // Linux/macOS
   cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
   git status
   {{< /code >}}

3. Stelle sicher, dass alle Dateien im Git-Repository committed sind. Mit **git status** erhältst du eine Übersicht:

   {{< code >}}
   git status
   {{< /code >}}

4. Erstelle einen neuen Branch für die Übung:

   {{< code >}}
   git checkout -b "templates/it-ninja_02_Java_03_java-grundlagen_00_Einfaches-Hello-World"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_Java_03_java-grundlagen_00_Einfaches-Hello-World.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_Java_03_java-grundlagen_00_Einfaches-Hello-World"
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
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_Java\03_java-grundlagen\00_Einfaches-Hello-World`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_Java/03_java-grundlagen/00_Einfaches-Hello-World`
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

## Einführung

Der zur Übung gehörende Quellcode zeigt dir ein einfaches Programm, welches den Text `Hello World` auf die Konsole
ausgibt. Er soll dir helfen, dich mit der Entwicklungsumgebung (IntelliJ) vertraut zu machen.

## Aufgabe - Hello World

Schau Dir das Programm an und versuche es zum Laufen zu bringen. Versuche, ein paar kleine Änderungen am Programm
vorzunehmen.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\Main.java](./source/#src-main-java):

```java
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
    }
}
```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/01_java_intro/#back-from-lab" "Struktur und Syntax">}}

---

{{<dokumentation "../../../../docs/99_tools/ide/intellij/01_installation/#back-from-lab" "IntelliJ installieren">}}

---

{{<dokumentation "../../../../docs/99_tools/ide/intellij/03_run-and-debug/#back-from-lab" "Mit IntelliJ Java Code kompilieren, ausführen und debuggen">}}
