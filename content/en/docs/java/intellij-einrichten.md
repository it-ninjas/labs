---
title: "IntelliJ IDEA einrichten"
linkTitle: "IntelliJ IDEA - einrichten"
weight: 2
description: >
  Modul #O4 - IntelliJ
---

#### Ziele
* Ich kenne die wichtigsten Funktionen der IntelliJ IDEA
* Ich kann Projekte innerhalb IntelliJ IDEA neu anlegen, konfigurieren und verwalten
* Ich kann IntelliJ IDEA zusammen mit einem GIT-Repository verwenden
* Ich kann Plugins suchen und installieren
* Ich verstehe das Grundprinzip von Debugging

---

### Einführung in IntelliJ IDEA

Besuche die folgenden Links und lies die Informationen durch:
- [Navigation und Suche](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#navigation-and-search)
- [Benutzer Interface](https://www.jetbrains.com/help/idea/guided-tour-around-the-user-interface.html)

Die Ansicht und/oder das Verhalten kann abhängig von den installierten Plugins, der IntelliJ IDEA Version oder den Benutzereinstellungen variieren.

### Default Keymap

IntelliJ verfügt über diverse Tastenkombinationen, um die Produktivität zu erhöhen.
Im unten stehenden PDF findest du die standardmässig eingestellten Tastenkombinationen.
[IntelliJ IDEA Reference Card](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)

### Personalisierte Keymap

Es kann vorkommen, dass einige Tastenkombinationen nicht ausführbar sind, als Beispiel ist die Kombination Ctrl + / nur ausführbar, wenn die Tastatur über einen Nummernblock verfügt.
Um die Tastenkombinationen deinen Bedürfnissen anzupassen, kannst du in den Einstellungen im IntelliJ nach Keymap und der entsprechenden Funktion suchen und diese anpassen.
Zusätzlich bietet IntelliJ IDEA diverse Keymaps an, welche sich z.B. an den Tastenkombinationen von Eclipse oder Visual Studio orientieren und die Umstellung erleichtern sollen.

Falls Du die Tastenkombinationen deinen Bedürfnissen angepasst hast, kannst du dir deine personalisierte Keymap als PDF von IntelliJ IDEA erstellen lassen unter Help &rarr; Keymap Reference.

#### Wichtige Kombinationen für den Anfang

| Funktion                                           | Shortcut          |
|----------------------------------------------------|-------------------|
| Einstellungen öffnen                               | Ctrl + Alt + S    |
| Überall suchen                                     | 2x Shift          |
| Smart Code Completion                              | Ctr + Alt + Space |
| Code formatieren                                   | Ctrl + Alt + L    |
| Imports optimieren                                 | Ctrl + Alt + O    |
| Generiere Code (Constructor, Getter, Setter, etc.) | Alt + Insert      |

#### Wichtige Kombinationen zur Code-Generierung

IntelliJ bietet nicht nur Tastenkombinationen, um die Produktivität zu verbessern, sondern auch vordefinierte Wörter, Kürzel oder Buchstaben, welche automatisch Code generieren.
Mit der Tastenkombination Ctrl + J kannst du diese anzeigen lassen.
  
| Code                                                             | Shortcut |
|------------------------------------------------------------------|----------|
| eine main()-Methode                                              | psvm     |
| eine forEach-Schleife                                            | foreach  |
| eine for-Schleife mit "i" als Zähler                             | fori     |
| einen if == null check                                           | ifn      |
| eine Iteration (while-Schleife) über einen Iterator              | itit     |
| eine Iteration (for-Schleife) über eine Liste                    | itli     |
| eine print()-Methode, welche einen Error auf der Konsole ausgibt | serr     |
| eine print()-Methode                                             | sout     |
| eine formatierte print()-Methode                                 | souf     |

### Neues Projekt anlegen

Um einen ersten Einblick in die Erstellung eines neuen Projektes zu erhalten kann das folgende Tutorial von IntelliJ IDEA absolviert werden:
[https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html)

### Installation von Plugins

Plugins erweitern die Kernfunktionalität von IntelliJ IDEA.

* Plugins ermöglichen die Integration mit Versionskontrollsystemen, Anwendungsservern und anderen externen Applikationen
* Plugins fügen Unterstützung bei der Kodierungshilfe für verschiedene Sprachen und Frameworks hinzu
* Plugins steigern die Produktivität mit Shortcut-Hinweisen, Live-Vorschauen, File Watchers etc.
* Plugins helfen dir beim Erlernen einer neuen Programmiersprache mit Programmierübungen und Verifizierung

Plugins müssen über den Marktplatz von IntelliJ installiert werden. Dieser ist über die Einstellungen unter Plugins verfügbar.
Dort können Plugins gesucht und über einen Klick auf Install einfach und unkompliziert installiert werden.

#### Hilfreiche Plugins für den Anfang

Ein sehr hilfreiches Plugin ist der "Key Promoter X". Dieses Plugin ermöglicht das Erlernen der IntelliJ IDEA Tastenkombinationen.
Jede verfügbare Tastenkombinationen wird dir bei Verwendung eines Menüs oder Kontextmenüs angezeigt.

### Code-Formatierung
Um den Code in IntelliJ IDEA zu formatieren, können die integrierten Funktionen für Codeformatierung verwendet werden. So kann der Code formatiert werden:

1. Den Code auswählen, welcher zu formatieren ist. Es kann sich um eine einzelne Zeile, einen Codeblock oder die gesamte Datei handeln.

2. Die entsprechende Tastenkombination basierend auf deinem Betriebssystem drücken:

Windows/Linux: Strg + Alt + L
macOS: Cmd + Option + L

Alternativ kann mit der rechten Maustaste auf den ausgewählten Code geklickt und "Code neu formatieren" im Kontextmenü ausgewählt werden.

3. IntelliJ IDEA wird den ausgewählten Code automatisch gemäss den konfigurierten Codeformatierungseinstellungen formatieren.

Wenn die Codeformatierungseinstellungen in IntelliJ  noch nicht konfiguriert wurden, kann das je nach den entsprechend Vorlieben angepasst werden. So kann man die Codeformatierung konfigurieren:

1. Zu "Datei" > "Einstellungen" (Windows/Linux) oder "IntelliJ IDEA" > "Einstellungen" (macOS) gehen.

2. In dem Einstellungsfenster zu "Editor" > "Code-Stil" navigieren.

3. Die gewünschte Programmiersprache auswählen, für die der Code-Stil konfiguriert werden möchte (z.B. Java, JavaScript usw.).

4. Die Codeformatierungseinstellungen nach den Vorlieben anpassen. Man kann Einrückung, Abstände, Platzierung der Klammern und viele andere Formatierungsoptionen festlegen.

5. Auf "Übernehmen" oder "OK" klicken, um die Änderungen zu speichern.

Nachdem der Code-Stil konfiguriert wurde, wird IntelliJ die definierten Formatierungsregeln anwenden, wenn die Tastenkombination für die Codeformatierung verwendet wird oder "Code neu formatieren" im Kontextmenü ausgewählt wird.


### Debugging-Grundlagen

Der Debugger wird benutzt, um mithilfe von Breakpoints den Code während der Ausführung anzuhalten, zu analysieren und Fehler im Code zu finden.
Mehr Informationen dazu gibt es unter dem folgenden Link:
[Debug Code](https://www.jetbrains.com/help/idea/debugging-code.html)
