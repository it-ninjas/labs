---
title: "Secrets - Geheimnisse sicher hinterlegen"
linkTitle: "SimpleExample"
type: docs
weight: 1
description: >
  Dieses Beispiel zeigt, wie man Geheimnisse in einer Java Applikation sicher hinterlegen kann.
---

<!--suppress CheckEmptyScriptTag -->

## Voraussetzung

- Du weisst, was mit Geheimnissen gemeint ist.
- Du weisst was Umgebungsvariablen sind.
- Du weisst was Maven ist und kannst Maven-Projekte aufsetzen.
- Du weisst wie man bei Maven ein Paket hinzufügt.

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
   git checkout -b "templates/it-ninja_01_Tools_05_secrets_01_SimpleExample"
   {{< /code >}}

   {{< ninja info >}}
   Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens für Branches, welche den ursprünglichen Übungscode enthalten.
   {{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_01_Tools_05_secrets_01_SimpleExample.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_01_Tools_05_secrets_01_SimpleExample"
   {{< /code >}}

   {{< ninja info >}}
   Auch hier kannst du einen kürzeren Namen wählen. Verwende **labs** am Anfang des Branch-Namens für Branches, die deinen eigenen Code enthalten.
   {{< /ninja >}}
   {{< ninja tip >}}
   **Pro-Tipp:**  
   Du kannst jederzeit einen weiteren Branch erstellen – z. B. wenn du etwas ausprobieren möchtest. Alternativ kannst du auch in der Git-History einen alten Stand wiederherstellen, was aber weniger flexibel ist.
   {{< /ninja >}}

8. Starte IntelliJ und öffne mit `File → Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht hast, findest du das Projekt hier:  
   {{<windows>}}
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\01_Tools\05_secrets\01_SimpleExample`
   {{</windows>}}
   {{<linux>}}
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\01_Tools/05_secrets/01_SimpleExample`
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

## Übung

Das Beispiel zeigt, wie ein Projekt korrekt aufgesetzt wird, damit es sicher in einem Git-Repository gesichert werden
kann.

Schaue dir die Datei `.env.template` an und folge den Anweisungen dort. Ersetze dabei `das_geheimnis` mit
`mein_geheimnis`.

{{< pom >}}

```xml
<dependency>
  <groupId>io.github.cdimascio</groupId>
  <artifactId>dotenv-java</artifactId>
  <version>3.0.0</version>
</dependency>
```

{{< /pom >}}

Wenn Du alles korrekt erledigt hast, sollte der Unittest erfolgreich durchlaufen:

```
mvn test
```

{{< ninja tip>}}
Wenn du den Unittest anschaust, wirst du feststellen, dass auch dort nirgends das Geheimnis im Klartext steht. Um zu
testen, ob du das Geheimnis korrekt konfiguriert hast vergleichen wir es mit einem Hash. Der Hash kann nicht zurück in
einen Klartext verwandelt werden, aber mit der Funktion `match` kann man feststellen, ob ein Wert den gleich Hash
erzeugt und so verifizieren, ob der Wert korrekt ist.
{{< /ninja >}}
