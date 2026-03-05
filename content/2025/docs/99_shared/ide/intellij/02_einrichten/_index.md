---
title: "IntelliJ einrichten"
linkTitle: "Einrichten"
weight: 2
description: >
  IntelliJ IDEA einrichten
---

## Ziele

- Du kennst die wichtigsten Funktionen von IntelliJ IDEA.
- Du kannst Projekte in IntelliJ IDEA anlegen, konfigurieren und verwalten.
- Du kannst Plugins suchen und installieren.

---

## Einführung in IntelliJ IDEA

Besuche die folgenden Links und lies dir die Inhalte aufmerksam durch:

- [Navigation und Suche](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#navigation-and-search)
- [Benutzeroberfläche](https://www.jetbrains.com/help/idea/guided-tour-around-the-user-interface.html)

{{< ninja type="info" >}}
Ansicht und Verhalten können je nach IntelliJ-Version, installierten Plugins oder deinen Einstellungen leicht abweichen.
{{< /ninja >}}

## Tastenkombinationen (Keymap)

IntelliJ bietet viele nützliche Shortcuts, um effizienter zu arbeiten. Du findest die wichtigsten in der offiziellen Referenz:

👉 [IntelliJ IDEA Reference Card (PDF)](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)

### Personalisierte Keymap

Manche Tastenkombinationen funktionieren nur unter bestimmten Bedingungen. Zum Beispiel ist `Ctrl + /` nur auf Tastaturen mit Nummernblock verfügbar.

Du kannst deine Shortcuts anpassen:

1. Öffne die Einstellungen (`Ctrl + Alt + S`).
2. Suche nach **Keymap**.
3. Ändere oder suche Tastenkombinationen.
4. Alternativ kannst du auch eine andere Keymap wie _Eclipse_ oder _Visual Studio_ wählen.

{{< ninja type="tip" >}}
Unter **Help → Keymap Reference** kannst du deine persönliche Keymap als PDF exportieren.
{{< /ninja >}}

### Nützliche Tastenkombinationen für den Einstieg

| Funktion                                           | Shortcut           |
| -------------------------------------------------- | ------------------ |
| Einstellungen öffnen                               | Ctrl + Alt + S     |
| Überall suchen                                     | 2× Shift           |
| Smart Code Completion                              | Ctrl + Alt + Space |
| Code formatieren                                   | Ctrl + Alt + L     |
| Imports optimieren                                 | Ctrl + Alt + O     |
| Code generieren (Konstruktor, Getter, Setter usw.) | Alt + Insert       |

### Code-Snippets mit Kürzeln

IntelliJ bietet Kürzel, mit denen du automatisch Code generieren kannst. Nutze `Ctrl + J`, um alle verfügbaren Kürzel anzuzeigen.

| Kürzel    | Funktion                               |
| --------- | -------------------------------------- |
| `psvm`    | `public static void main(...)`-Methode |
| `sout`    | `System.out.println(...)`              |
| `souf`    | Formatierter `System.out.printf(...)`  |
| `serr`    | `System.err.println(...)`              |
| `fori`    | for-Schleife mit Zähler `i`            |
| `foreach` | foreach-Schleife                       |
| `ifn`     | if (x == null)                         |
| `itli`    | Iteration über eine Liste              |
| `itit`    | Iteration mit Iterator                 |

## Neues Projekt anlegen

Nutze folgendes offizielles Tutorial für deinen Einstieg:
👉 [Dein erstes Java-Projekt erstellen](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html)

{{< ninja type="tip" >}}
Für viele unserer Übungen stellen wir dir ein vorbereitetes Projekt zur Verfügung. Trotzdem lohnt es sich, das Anlegen eines neuen Projekts selbst zu üben – vielleicht willst du ja bald deine eigene Applikation entwickeln.
{{< /ninja >}}

## Plugins installieren

Plugins erweitern die Funktionalität von IntelliJ IDEA. Du findest sie unter **Einstellungen → Plugins** im Marktplatz.

### Warum Plugins?

- Integration mit Git, Application Servern usw.
- Unterstützung für zusätzliche Sprachen und Frameworks
- Produktivitätssteigerung durch Live-Vorschau, File Watcher, Shortcuts
- Lernhilfe durch Übungs-Plugins

### Empfehlung: Key Promoter X

Dieses Plugin zeigt dir bei jeder Mausaktion den entsprechenden Shortcut an – ideal, um effizienter zu arbeiten.

## Code formatieren

So formatierst du deinen Code in IntelliJ IDEA:

1. Wähle den gewünschten Code aus (eine Zeile, ein Block oder alles).
2. Nutze die Tastenkombination:
   - Windows/Linux: `Ctrl + Alt + L`
   - macOS: `Cmd + Option + L`

   Oder über das Kontextmenü: **Rechtsklick → Code neu formatieren**

### Formatierungsstil anpassen

Wenn du den Stil ändern möchtest:

1. **Datei** → **Einstellungen** (Windows/Linux)  
   **IntelliJ IDEA** → **Einstellungen** (macOS)
2. Navigiere zu **Editor → Code-Stil**.
3. Wähle die Sprache (z. B. Java).
4. Passe Einrückungen, Leerzeichen, Klammern usw. an.
5. Speichern mit **OK** oder **Apply**.

IntelliJ wendet die Regeln künftig bei jeder Formatierung automatisch an.

---
