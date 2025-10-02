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

   Unser Job `java-test` verwendet `ubuntu-latest` als Basis, um seine Schritte
   auszuführen.
   Unser Job hat 3 Schritte:

   - Schritt 1: Checke den aktuellen Stand des Repositories aus.
   - Schritt 2: Setze Java. Hier können wir die Java Version angeben, die wir benutzen.
   - Schritt 3: Führe `mvn test` aus.

4. Committe und pushe die Änderungen.
5. Gehe zu deinem GitHub Repository und klicke auf den Reiter `Actions`.
   Du solltest sehen, dass dein Workflow ausgeführt wird.
6. Klicke auf den laufenden Workflow, um die Details zu sehen.
7. Klicke auf den Job `java-test` und dann auf den Step `Run JUnit tests using Maven`.
   Du solltest die Ausgabe von Maven sehen.
8. Am Ende sollte der Workflow erfolgreich sein und mit einem ✅ markiert sein.

Herzlichen Glückwunsch!
Du hast deine erste CI erstellt!

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
