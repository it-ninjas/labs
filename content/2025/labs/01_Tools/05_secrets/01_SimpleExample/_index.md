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
* Du weisst, was mit Geheimnissen gemeint ist.
* Du weisst was Umgebungsvariablen sind.
* Du weisst was Maven ist und kannst Maven-Projekte aufsetzen.
* Du weisst wie man bei Maven ein Paket hinzufügt.

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
    git checkout -b "templates/it-ninja_01_Tools_05_secrets_01_SimpleExample"
    ```
    > Du kannst auch einen kürzeren Namen für den Branch wählen. Wir nutzen `templates` am Anfang des Branches für Branches, welche den original Source-Code von den Übungen enthalten.

5. Lade den Source-Code zu den Übungen herunter und entpacke den Inhalt im lokalen Repository ins Root-Verzeichnis: `[[itninja_localrepo|C:\\Users\\u123456\\repos.local\\it-ninjas-lab]]`). Den Source-Code kannst du hier herunterladen: [download](./it-ninja_01_Tools_05_secrets_01_SimpleExample.zip) | [online](./source/)

6. Commite den original Source-Code, damit er sicher im Repository ist:
    ```bash
    git add .
    git commit -m "Initial version from it-ninja"
    ```

7. Erstelle einen neuen Branch um deine Lösung zu implementieren:
    ```bash
    git checkout -b "labs/it-ninja_01_Tools_05_secrets_01_SimpleExample"
    ```
    > Auch hier kannst Du einen kürzeren Namen für den Branch wählen. Nutze `labs` am Anfang des Branches für Branches, welche Code von dir enthalten.

    > **Pro-Tip:** Du kannst jederzeit einen weitere Branch machen, z.B. wenn du mal etwas ausprobieren willst. Alternativ kannst du auch in der History einen alten Stand wiederherstellen, was aber weniger flexibel ist.

8. Starte IntelliJ und öffne mit `File/Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht hast solltest du den Code in deinem Benutzerverzeichnis finden:

    {{<windows>}}`[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\01_Tools\05_secrets\01_SimpleExample`{{</windows>}}

    {{<linux>}}`[[itninja_localrepo|/home/users/u123456/repos.local/it-ninjas-lab]]\01_Tools/05_secrets/01_SimpleExample`{{</linux>}}

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

## Übung

Das Beispiel zeigt, wie ein Projekt korrekt aufgesetzt wird, damit es sicher in einem Git-Repository gesichert werden
kann.

Schaue dir die Datei `.env.template` an und folge den Anweisungen dort. Ersetze dabei `das_geheimnis` mit
`mein_geheimnis`.

{{< pom >}}
<dependency>
  <groupId>io.github.cdimascio</groupId>
  <artifactId>dotenv-java</artifactId>
  <version>3.0.0</version>
</dependency>
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
