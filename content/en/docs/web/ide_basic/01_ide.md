---
title: "IDE"
linkTitle: "IDE"
weight: 1
date: 2022-02-16
description: >
    In diesem Kapitel wird die IDE beschrieben.
---

# IDE
In den folgenden Kapiteln ist alles aufgeführt was man für das Programmieren mit HTML und CSS benötigt.

## VS Code
Die Beispiele in diesem Modul werden mit Visual Studio Code erklärt. Visual Studio Code ist ein kostenloser Codierungseditor, mit welchem du schnell mit dem Coden beginnen kannst. Du kannst Visual Studio Code verwenden, um in beinahe jeder Programmiersprache zu programmieren, ohne den Editor zu wechseln. Es werden viele Sprachen unterstützt, darunter sind JavaScript, Angular, Vue und viele mehr.
https://code.visualstudio.com/

### Extensions
Folgende Extensions sind praktisch für die Entwicklung von Webapps mit VS Code:

    VS-Code:
    - Code Spell Checker
    - ESLint
    - GitLens
    - Material Icon Theme
    - Path Intellisense
    - Prettier – Code formatter
    - Auto Rename Tag
    - Auto Close Tag
    - Better Comments
    - Template String Converter
    - Live Server

## IntelliJ
IntelliJ IDEA ist eine IDE für Softwareentwicklung, die von JetBrains entwickelt wurde. Es ist eine der beliebtesten IDEs für die Entwicklung von Java-Anwendungen, bietet jedoch auch Unterstützung für viele andere Programmiersprachen und Technologien wie Kotlin, Scala, Groovy, JavaScript, TypeScript, HTML, CSS, SQL etc.

IntelliJ kann man am besten über die JetBrains Toolbox herunterladen. https://www.jetbrains.com/lp/toolbox/

### Extensions (Plugins)
Folgende Extensions sind praktisch für die Entwicklung von Webapps mit IntelliJ:

    IntelliJ:
    - Prettier
    - Rainbow Bracket
    - Key Promoter X
    - ESLint (muss mittels npm instlliert werden, Anleitung befindet sich im Kapitel zu den Linter.)
    - LiveEdit 

## Vim
Vim steht für "**V**i **IM**proved" und ist ein erweiterter Texteditor, der auf dem älteren vi-Editor basiert. Es ist ein beliebter Texteditor unter Entwicklern und Systemadministratoren, der auf verschiedenen Betriebssystemen wie Linux, macOS und Windows verwendet werden kann. Vim zeichnet sich durch seine Effizienz, Flexibilität und Erweiterbarkeit aus.

Für VS-Code muss man das Plugin `Vim` und für IntelliJ das Plugin `IdeaVim` installieren, damit man diesen Editor verwenden kann.


## Live-Server
### Wozu braucht man den Live-Server?
Normalerweise verwendet der Browser HTTP, um Websites und andere Ressourcen von einem Server zu laden. Beim lokalen Entwickeln greifen Entwickler jedoch häufig direkt über den Browser auf das Dateisystem zu. Es gibt jedoch bestimmte Techniken, wie z. B. JavaScript-Module, die Ressourcen nur über HTTP laden können. Aus diesem Grund müssen wir für bestimmte Funktionen auch lokal einen Webserver verwenden, der die Ressourcen über HTTP bereitstellt.

Die Live-Server-Erweiterung erfüllt genau diese Anforderungen: Sie ermöglicht es, Dateien in einem bestimmten Ordner (dem Projektverzeichnis) auf deiner Festplatte über HTTP verfügbar zu machen. Ein zusätzliches Feature besteht darin, dass deine Seite automatisch aktualisiert wird, sobald du Änderungen vornimmst.

### Live-Server in VS Code
Die Live-Server Extension ist eine beliebte Erweiterung für Visual Studio Code, die Entwicklern dabei hilft, Webanwendungen während der Entwicklung automatisch neu zu laden. Sie ermöglicht es, eine lokale Entwicklungsumgebung einzurichten und den Code in Echtzeit zu aktualisieren, ohne die Seite manuell neu zu laden.

Live-Server erstellt einen einfachen Entwicklungsserver auf dem lokalen Rechner, der die Webanwendung unter einer lokalen Adresse (z.B. "http://localhost:5500") bereitstellt. Dadurch kann man die Anwendung in einer isolierten Umgebung testen und auf sie zugreifen.

Neben der Bereitstellung von HTML-, CSS- und JavaScript-Dateien unterstützt Live-Server auch das Laden von statischen Dateien wie Bildern, Schriftarten und anderen Ressourcen. Dadurch kann man die gesamte Webanwendung über den Entwicklungsserver verfügbar machen.

Um eine Datei (z.B. eine HTML-Datei) via Live Server im Browser zu öffnen, tätige einen Rechtsklick auf die gewünschte Datei und klicke auf "Open with Live Server". Nun geht die gewünschte Seite im Browser auf und ist erreichbar via die URL "http://localhost:5500".

Ganz unten in VS Code siehst du nun einen versteckten Button mit der Aufschrift "Port 5500". Wenn du darauf klickst, beendest du den Live Server wieder. [Besser noch ein Bild hinzufügen]


### Live-Server in IntelliJ
Wenn man jedoch IntelliJ als seine IDE wählt, kann man ähnlich wie bei VS Code einen Liv Server mittels Extension erhalten. Dazu muss mah jedoch die Extension LiveEdit installieren. Nach dem man es installiert hat muss man es noch ein wenig konfigurieren, dafür einfach in den Einstellungen auf "Build, Execution, Deployment" -> Debugger -> Live Edit.
Dort muss man folgendes anpassen:
* "Update Node.js application on changes in" Checkbox anwählen und Millisekunden auf 300ms ändern.
* "Update application in Chrome on changes in" Checkbox anwählen und Millisekunden auf 300ms ändern.
* "JavaScript, HTML and CSS" auswählen.
* "Track changes in files compiled to JavaScript, HTML or CSS" Checkbox anwählen.
* "Restart if hotswap fails" Checkbox anwählen.

Das gesamte nun sichern und danach kann es verwendet werden. Dazu muss man einfach den Debugger starten und ein Chromefernster öffnet sich. Man kann nun im Code Änderungen vornhemen solange man im Debugger ist und es wird live im Chromefenster aktualisiert.

![task1](/images/task.png) 15' - Einzelarbeit

    Installiere die IDE, die genannten Extensions, und richte sie entsprechend deiner Präferenz ein.

## Git
Git ist dir bereits bekannt ein Codeversionierungssystem, welches bei diesem Modul genutzt wird.

![task2](/images/task.png) 5' - Einzelarbeit
    
    Installiere Git. Hierfür gibt es zwei Möglichkeiten:
    
    1. Vielleicht klappt es unter Windows direkt mit diesem Kommandozeilenbefehl:
        
        winget install --id Git.Git -e --source winget

    2. Ansonsten lade es unter folgendem Link herunter: https://git-scm.com/.
    
        Bei der Installation sind keine Anpassungen zwingend. Vielleicht helfen dir in Zukunft die "Components" "Windows Explorer integration - Git Bash Here" und "Add a Git Bash Profile to Windows Terminal". Ansonsten kannst du dich einfach durchklicken.

