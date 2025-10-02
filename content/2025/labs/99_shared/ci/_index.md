---
title: "Continuous Integration (CI) - Automatisiere deine Builds und Tests"
linkTitle: "Continuous Integration (CI)"
type: docs
weight: 5
description: >
  In diesem Abschnitt lernst du, wie du Continuous Integration (CI) einrichtest, um Builds und Tests zu automatisieren.
---

<!--suppress CheckEmptyScriptTag -->

## Voraussetzung

- Du kennst die Grundlagen von Git und verstehst, wie Versionskontrollsysteme funktionieren.
- Du kennst die Grundlagen von Java und Maven und kannst einfache Java-Projekte erstellen und verwalten.
- Du kennst die Grundlagen des Software-Testings.
- Du verstehst YAML Dateien.

## Was ist Continuous Integration (CI)?

Continuous Integration (CI) ist eine Praxis in der Softwareentwicklung, bei der Entwickler ihre Codeänderungen _kontinuierlich_ (continuous) in ein gemeinsames Repository _integrieren_.
Jede Integration wird automatisch durch einen Build-Prozess
und automatisierte Tests überprüft, um sicherzustellen, dass der neue Code keine Fehler oder Konflikte einführt.
Es gibt verschiedene CI Systeme, z.B.

- GitHub Actions
- GitLab CI/CD
- Tekton

## Motivation für CI

Warum ist CI wichtig?
Stell dir vor, du arbeitest in einem Team von Entwicklern an einem grossen Projekt.
Deine Chefin sagt dir, dass du eine neue Funktion implementieren sollst.
Also checkst den `main` Branch aus, implementierst die Funktion, willst sie testen
und stellst fest, dass irgendwas nicht mehr funktioniert.
Nach einigem Suchen findest du heraus, dass Problem schon vor deiner Änderung existierte.
Ein Kollege hat eine Änderung gemacht, die das Problem verursacht hat, und diese
einfach auf den `main` Branch gepusht, ohne sie zu testen.
Das ist frustrierend, oder?
Mit einer funktionierenden CI-Pipeline, die automatisch Builds und Tests durchführt,
hätte dieses Problem vermieden werden können.
Eine gute CI-Pipeline stellt sicher, dass z.B. der `main` Branch immer in einem funktionsfähigen Zustand ist.

## Übung

In dieser Übung lernst du, wie du eine einfache CI-Pipeline mit GitHub Actions[^1] einrichtest.
Die Pipeline wird automatisch ausgeführt, wenn du Code in den `main` Branch pusht.

### Aufgabe 1: Erstelle ein GitHub Repository

1. Gehe zu [GitHub](https://github.com/new) und erstelle ein neues Repository.
2. Initialisiere das Repository mit einer `README.md` Datei.
3. Klicke auf `Create`.
4. Clone das Repository auf deinen Rechner.
5. Öffne das Repository in IntelliJ.
6. Kopiere den Inhalt der Beispielanwendung (aus dem ZIP-File) in das Repository.
   Anschliessend solltest du

   - `./src/main/java/ch/itninja/Main.java`
   - `./src/test/java/ch/itninja/MainTest.java`
   - `./pom.xml`
   - `./.gitignore`

   in deinem Repository haben.

7. Teste, ob Maven funktioniert.

   ```shell
   mvn test
   ```

   Das Ergebnis sollte ungefähr so aussehen

   ```log
   [INFO] Results:
   [INFO]
   [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
   [INFO]
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   ```

8. Verwende `git add .` und `git commit` um einen Commit zu erstellen.
9. Pushe deinen neuen Commit.
   Öffne dein GitHub Repository und überprüfe, ob dein Push funktioniert hat.

### Aufgabe 2: Erstelle einen GitHub Action, um die Tests auszuführen

GitHub Actions sind das CI System von GitHub.
In GitHub Actions definieren wir `workflows`.
Die Workflows speichern wir im Ordner `.github/workflows`.
Ein Workflow besteht aus einem oder mehreren Jobs.
Ein Job kann einen oder mehrere Schritte (`steps`) haben.

1. Erstelle im Root-Verzeichnis deines Projekts den Ordner `.github/workflows`.
2. Erstelle im Ordner `.github/workflows` die Datei `java-test.yml`.
3. Füge folgenden Inhalt in die Datei `java-test.yml` ein:

   ```yaml
   name: java test with maven

   on:
     push:
       branches:
         - main

   jobs:
     java-test:
       runs-on: ubuntu-latest
       steps:
         - uses: actions/checkout@v5
         - uses: actions/setup-java@v4
           with:
             java-version: "21"
             distribution: "temurin"
         - name: Run JUnit tests using Maven
           run: mvn test
   ```

   <details>
   <summary>Was bedeuten die einzelnen Schlüsselworte?</summary>

   - `name`: Der Name des Workflows.
   - `on`: Definiert, wann der Workflow ausgelöst wird. In diesem Fall bei einem Push auf den `main` Branch.
   - `jobs`: Definiert die Jobs, die ausgeführt werden sollen.
   - `java-test`: Der Name des Jobs.
   - `runs-on`: Definiert die Umgebung, in der der Job ausgeführt wird.
   - `steps`: Definiert die einzelnen Schritte des Jobs.
   - `uses`: Verwendet eine vordefinierte Action mit einer bestimmten Version.
     - [actions/checkout](https://www.github.com/actions/checkout/tree/v5/)
     - [actions/setup-java](https://www.github.com/actions/setup-java/tree/v4/)
   - `name`: Der Name eines Schritts.
   - `run`: Führt einen Shell-Befehl aus.

   </details>

   **Wie funktioniert dieser Workflow genau?**

   Unser Workflow mit dem Namen `java test with maven` hat verschiedene Teile:

   - Trigger (`on:`): Bestimmt, bei welchen Ereignissen der Workflow ausgelöst wird.
     Im Beispiel ist das `push` auf `main`.

     Häufig ergänzt man `pull_request`, damit auch PRs geprüft werden, bevor sie gemerged werden.
     Man kann auch `schedule` nutzen, um den Workflow z.B. täglich auszuführen.
     Oder man führt den Workflow nur aus, wenn ein Release erstellt wird.
     Manche Workflows haben gar kein Ereignis als Trigger, sondern werden von anderen Workflows gestartet, d.h. `on: workflow_run`.
     Dies ist nützlich für komplexe CI/CD-Pipelines, da wir so wiederverwendbare Workflows erstellen können.

   - Jobs (`jobs:`): Ein Workflow kann mehrere Jobs haben, die parallel oder nacheinander ausgeführt werden.
     In unserem Beispiel gibt es nur einen Job namens `java-test`.

     Jeder Job läuft in einer frischen Umgebung (Runner) und hat seine eigenen Schritte.
     Jobs können auch durch `needs` voneinander abhängen, d.h. ein Job startet erst, wenn ein anderer erfolgreich abgeschlossen ist.
     Da wir aber nur einen Job haben, ist das hier nicht relevant.

     Unser `java-test` Job hat folgende Bestandteile:

     - `runs-on`: Legt die Ausführungsumgebung (Runner) fest — in der Regel ein Linux-, Windows- oder macOS-Runner.
       In unserem Beispiel nutzen wir `ubuntu-latest`, d.h. die neueste verfügbare Ubuntu Version.
     - `steps`: Die Schritte, die der Job ausführt.
       Jeder Schritt kann eine fertige GitHub Action (`uses:`) oder einen Shell-Befehl (`run:`) ausführen.
       GitHub Actions sind wiederverwendbare Komponenten, die bestimmte Aufgaben erledigen.
       GitHub Actions haben den Vorteil, dass wir uns **nicht** um die Details kümmern müssen.
       In unserem Beispiel müssen wir z.B. nicht selbst Java installieren, sondern nutzen die `actions/setup-java` Action.
       Wir können im jeweiligen Online Repository auch die Dokumentation der Actions lesen, um zu verstehen, was sie tun und welche Eingaben sie erwarten.

       Unser Job hat drei Schritte:

       - `uses: actions/checkout@v5`: Der erste Schritt nutzt `git` bzw. die `actions/checkout` GitHub Action, um den Code aus dem Repository in die Runner-Umgebung zu klonen.

         Bei GitHub Actions können wir git Commit Hashes, Branch-Namen, Tags oder Versionsnummern angeben, um eine spezifische Version der Action zu nutzen.
         Im Beispiel verwenden wir hier die Version `v5`, d.h. wir verwenden den aktuellsten Tag, der mit `v5` beginnt (aktuell ist das `v5.0.0`, könnte aber in Zukunft `v5.3.2` oder höher sein).
         Wenn wir immer die neueste Version einer Action nutzen wollen, könnten wir auch `@main` angeben, was aber nicht empfohlen wird, da es zu unerwarteten Änderungen führen kann.
         Wenn wir eine spezifischere Version wie `v5.3.2` angeben wollen, könnten wir das auch tun.
         Wenn wir immer diesselbe Version einer Action nutzen wollen, auch wenn der Maintainer Tags löscht und neu erstellt, könnten wir auch den Commit Hash angeben, z.B. `@a1b2c3d4e`.

       - `uses: actions/setup-java@v4`: Installiert die gewünschte JDK-Version, damit `mvn` mit der richtigen Java-Version läuft.

         Hier nutzen wir, dass GitHub Actions `inputs` unterstützen, die wir mit `with:` angeben können.
         In unserem Beispiel geben wir die Java-Version `21` und die Distribution `temurin` an.
         Die Action installiert dann automatisch das passende JDK.

       - `run: mvn test`: Führt Maven aus und startet Build und Tests.
         Hier führen wir einen Shell-Befehl aus, der Maven startet und die Tests ausführt.
         Für die Darstellung in der GitHub Actions Oberfläche ist es hilfreich, wenn wir dem Schritt einen Namen geben, z.B. `Run JUnit tests using Maven`.

4. Committe und pushe die Änderungen.
5. Gehe zu deinem GitHub Repository und klicke auf den Reiter `Actions`.
   Du solltest sehen, dass dein Workflow ausgeführt wird.
6. Klicke auf den laufenden Workflow, um die Details zu sehen.
7. Klicke auf den Job `java-test` und dann auf den Step `Run JUnit tests using Maven`.
   Du solltest die Ausgabe von Maven sehen.
8. Am Ende sollte der Workflow erfolgreich sein und mit einem ✅ markiert sein.

### Aufgabe 2a: Teste Deine CI! (Optional)

1. Füge dem Java Code einen Fehler hinzu, der verhindert, dass das Java Programm
   kompiliert werden kann oder die Tests fehlschlagen lässt.
2. Committe und pushe die Änderungen.
3. Gehe zu deinem GitHub Repository und klicke auf den Reiter `Actions`.
   Warte, bis dein Workflow abgeschlossen ist.
   Der Workflow sollte fehlschlagen und mit einem ❌ markiert sein.
4. Klicke auf den Workflow, um die Details zu sehen.
5. Klicke auf den Job `java-test` und dann auf den Step `Run JUnit tests using Maven`.
   Du solltest die Ausgabe von Maven sehen und dort auf den Fehler
   hingewiesen werden, den du gerade eingeführt hast.
6. Fixe den Fehler wieder.
7. Committe und pushe die Änderungen.
8. Der Workflow sollte wieder erfolgreich sein und mit einem ✅ markiert sein.

[^1]: Diese Aufgabe basiert auf <https://docs.github.com/en/actions/tutorials/build-and-test-code/java-with-maven>
