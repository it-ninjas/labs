---
title: "Cheatsheet"
linkTitle: "Cheatsheet"
weight: 1
description: >
  Übersicht über die wichtigsten Shortcodes und Konventionen für Modulseiten im it-ninjas-Projekt.
---

{{< module J1 >}}

## Ziele

- Du verstehst den Aufbau einer typischen Modulseite bei it-ninjas.
- Du kannst alle verfügbaren Shortcodes korrekt einsetzen.
- Du kennst empfohlene und veraltete Shortcodes.

{{< zeit lesen="10">}}

---

## Einführung

Dieses Cheatsheet zeigt dir anhand von Beispielen, wie eine Modulseite im Projekt **it-ninjas** aufgebaut ist. Es
basiert auf dem _it-ninjas Styleguide_ und wird laufend aktualisiert.

---

## Info-Boxen

Verwende Ninja-Boxen, um Informationen klar hervorzuheben:

{{< ninja info >}}
Das ist eine **Info**-Box für ergänzende Hinweise.
{{< /ninja >}}

{{< ninja tip >}}
Das ist eine **Tip**-Box mit einem hilfreichen Hinweis.
{{< /ninja >}}

{{< ninja warning >}}
Das ist eine **Warnung** – hier muss man besonders aufpassen.
{{< /ninja >}}

{{< todo >}}
Hier fehlt noch etwas – markiert als TODO.
{{< /todo >}}

---

## Video einbinden

Für zusätzliche Erklärungen kannst du Videos einbinden:

{{< video "https://www.chilloutzone.net/video/angriff-des-ninja-pinguins.html" "ninja-pinguine" >}}

---

## Code und Aufgaben

### Codeblöcke für verschiedene Betriebssysteme

{{< code >}}
echo Default is visible to all OS
// windows
echo Hello from Windows
// linux
echo Hello from Linux
// all
echo Visible on all OS
{{< /code >}}

---

## Links in einem neuen Fenster

Da das öffnen in einem neuen Fenster von Markdown und Hugo nicht direkt unterstützt wird kümmert sich ein Script beim
starten der Seite darum. Mit einem `!` am Anfang des Link-Text, wird der Link in einem neuen Fenster geöffnet.

Das wird [im gleichen Fenster](https://www.chilloutzone.net/video/angriff-des-ninja-pinguins.html) geöffnet.

Das wird [!in einem neuen Fenster](https://www.chilloutzone.net/video/angriff-des-ninja-pinguins.html) geöffnet.

## Aufgabenlinks

- Einzelne Aufgabe:
  {{< aufgabe "../cheatsheet/" >}}

- Mehrere Aufgaben:
  {{< aufgaben "../cheatsheet/" >}}

## Links zu Labs oder Dokumentationen

- Zu einem Lab:
  {{< lablink "../cheatsheet/" "Zur Aufgabe" >}}

- Markdown-Link-Variante:
  {{< lablink "[Zur Aufgabe](../cheatsheet/)" >}}

- HTML-ähnlich:
  {{< lablinkml "../cheatsheet/" >}}Zur Aufgabe{{< /lablinkml >}}

- Zur Dokumentation zurück:
  {{< dokumentation "../cheatsheet/" >}}
  {{< dokumentation "../cheatsheet/" "Java Grundlagen" >}}

---

## Plattformabhängige Inhalte

Zeige Inhalte nur, wenn ein bestimmtes Betriebssystem konfiguriert ist:

{{< linux >}}
Dieser Abschnitt ist nur unter **Linux** sichtbar.
{{< /linux >}}

{{< windows >}}
Dieser Abschnitt ist nur unter **Windows** sichtbar.
{{< /windows >}}

---

## Formatierte Konfigurationsdateien (z. B. `pom.xml`)

Verwende diesen Shortcode, damit der XML-Code korrekt eingerückt dargestellt wird:

{{< pom >}}

```xml
<dependency>
  <groupId>io.github.cdimascio</groupId>
  <artifactId>dotenv-java</artifactId>
  <version>3.0.0</version>
</dependency>
```

{{< /pom >}}

---

## Unternehmensspezifische Inhalte

{{< sbb >}}
Dieser Abschnitt wird nur angezeigt, wenn **SBB** als Ausbildungsort ausgewählt ist.
{{< /sbb >}}

---

## Veraltete Shortcodes

Folgende Shortcodes sind **deprecated** und sollen nicht mehr verwendet werden:

{{< SBBOnly >}}
Nicht mehr verwenden! Bitte stattdessen Shortcode `sbb` benutzen.
{{< /SBBOnly >}}

---

## ChatGPT Prompt für die it-ninjas Dokumentation

Damit ChatGPT eine Markdown-Datei im **it-ninjas Stil** überarbeiten kann, sollte der Prompt mehr enthalten als nur
technische Anweisungen. Ziel ist es, den charakteristischen Ton, die Zielgruppe und die Formatkonventionen zu
berücksichtigen.

Hier ein vollständiger Prompt, den du nutzen oder anpassen kannst:

```text
Bitte überarbeite folgenden Markdown-Text für das it-ninjas Projekt.

### Zielgruppe:
- Lernende (oft ohne Vorwissen), die Java, IntelliJ oder andere Tools im Rahmen der Ausbildung verwenden
- Ziel ist, Inhalte **leicht verständlich**, **freundlich**, **ermutigend** und **strukturiert** zu präsentieren

### Ton & Stil:
- **Du-Form** verwenden, nicht „man“
- Aktiv, klar, ermutigend, niemals belehrend
- Ein bisschen Witz ist erlaubt, aber stets respektvoll und professionell
- Sprich direkt zur Leserin oder zum Leser („Du lernst...“, „So kannst du...“)

### Struktur & Formatierung:
- Abschnitt **„Ziele“** zu Beginn mit klaren Bulletpoints
- Nach den Zielen ein `{{< zeit lesen="X" >}}`-Block (geschätzte Lesezeit, auf 5 Minuten aufrunden,
  konservativ geschätzt bei 100 Wörtern/Min)
- Abschnittsüberschriften auf der zweiten Ebene (`##`) beginnen
- **Maximale Zeilenlänge 120 Zeichen** (auch in Codeblöcken)
- Wo möglich, passende Shortcodes einsetzen (`ninja`, `lablink`, `aufgabe`, `code`, etc.)
- Veraltete Shortcodes vermeiden (`SBBOnly` z. B.)

### Zusätzliche Hinweise:
- Technische Inhalte wenn möglich mit Beispielen, Bildern oder Code ergänzen
- Am Ende des Dokuments **freundlich abschliessen** (z. B. „Viel Erfolg!“)
- Falls `## Ziele` schon vorhanden ist, nicht duplizieren

### Prettier konform
- Kursiv mit `_..._`, nicht mit `*...*`

### Markdown-Text:
---
(dein Markdown-Text hier)
---
```

Damit erhalten auch andere Autor:innen dieselbe Qualität wie du – und ChatGPT arbeitet im gewünschten _it-ninjas_-Stil.

---

## Hinweise zur Formatierung

- Achte auf **maximal 120 Zeichen pro Zeile**.
- Verwende **aktive Formulierungen**.
- Halte Inhalte **zielgruppengerecht** und gut strukturiert.
- Nutze die zur Verfügung gestellten Shortcodes, um Wiederverwendbarkeit und Einheitlichkeit sicherzustellen.
- Zwischen zwei Kapiteln kommt eine Linie (`---`)
- In allen **Codebeispielen** gilt: Kommentare, Variablennamen, Methodennamen und Code-Sprache sind **auf Englisch**.
- Die **Ausgabe auf der Konsole oder dem Bildschirm** darf hingegen **auf Deutsch** sein (z. B.
  `System.out.println("Hallo Welt")`).

---
