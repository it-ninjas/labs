---
title: "Exam zu Angular"
type: docs
linkTitle: "Angular Exam Notenverwaltung"
weight: 2
date: 2023-05-24
description: >
    Ein Angular Exam zum Erstellen eines Frontends zu einem bestehenden Backend.
---

## Inhalt
In den Labs/Exams von Spring Boot / Java hast du bereits ein Backend für eine Notenverwaltung geschrieben.
In diesem Exam sollst du zusätzlich ein Frontend schreiben, welches dieses Backend verwendet. Schlussendlich 
solltest du eine komplett selbst erstellte Fullstack Applikation haben, die einwandfrei funktioniert.

### Setup
Bevor du mit den Aufgaben beginnst, solltest du ein neues Angular Projekt wie gelernt aufsetzen. Du kannst beim Setup
bereits das Routing integrieren und wähle als stylesheet SCSS aus. Den Namen kannst du frei wählen. Wenn diese 
Bedingungen erfüllt sind, kannst du mit den Aufgaben beginnen. 

### Anforderungen
#### Funktional
* Die Anwendung unterstützt zwei unterschiedlichen Profilen: "student" und "admin"
* Wenn die Anwendung mit dem Profil "student" gestartet wird, steht folgende Funktionalität zur Verfügung:
    * Alle Fächer und all deren Noten auflisten (ein Fach kann mehreren Noten beinhalten)
    * Alle Fächer und deren Durchschnittsnote auflisten
    * Für ein bestimmtes Fach:
        * Alle Noten und die Durchschnittsnote des Fachs auflisten
        * Eine neue Note hinzufügen
        * Eine bestehende Note ändern
        * Eine bestehende Note löschen
* Wenn die Anwendung mit dem Profil "admin" gestartet wird, steht zusätzlich auch folgende Funktionalität zur Verfügung:
    * Alle Fächer auflisten
    * Neue Fächer hinzufügen
    * Bestehende Fächer bearbeiten
    * Bestehende Fächer löschen

[//]: # (TODO: Macht Internationalization sinn? Die Daten werden ja nur in Deutsch gespeichert?)
* Zusätzliche Anforderungen
  * Die Anwendung ist in den Sprachen Deutsch, Französisch und Englisch verfügbar
  * Die Sprache kann direkt in der Applikation gewechselt werden
#### Nicht-Funktional
* Der Code (das Design) der Anwendung ist sinnvoll in entsprechenden Components/Services aufgesplittet.
* Ein Component/Service hat eine einzige Aufgabe (Single Responsibility Prinzip).
* Mögliche Exceptions wurden abgefangen und dem Benutzer wo nötig mitgeteilt.

[//]: # (TODO: Eventuell ist oberes Kriterium nicht sehr genau)
* Jeder Component/Service ist getestet.

## Aufgabe 1 - Erstellen der Components
[//]: # (TODO: Eventuell sollte ein Design für die Notenverwaltung erstellt werden)
Um alle Daten der Notenverwaltung anzeigen, erstellen, löschen und bearbeiten zu können, werden verschiedene Components
benötigt. In dieser Aufgabe solltest du diese Punkte abarbeiten:
* Überlege dir anhand der [Anforderungen](#anforderungen), wofür du alles einen Component benötigst. Die Unterscheidung
zwischen Admin und Student profil kann aktuell ignoriert werden. Erstelle bereits jetzt alle Components dazu.
* Entwickle ein einfaches und benutzerfreundliches Design für die einzelnen Seiten.
* Verwende aktuell feste Daten, diese werden in einer späteren Aufgabe ersetzt.

## Aufgabe 2 - Models erstellen und verwenden
Aktuell werden in deiner Applikation feste Daten angezeigt, die im HTML angegeben sind. Da die Daten später jedoch
aus dem Backend kommen sollten, ist es von Vorteil, wenn du Models hast, die den benötigten Daten entsprechen. Diese
Punkte sollten in dieser Aufgabe erledigt werden:
* Erstelle alle deiner Meinung nach benötigten Models
* Entferne deine aktuell festen Daten und ersetze sie mit Daten, die du im Typescript mit deinen Models erstellst
* Versuche, wo nötig, Forms zu verwenden, um diese Später verwenden zu können.
> Tipp: Wenn du dir unsicher bist welche Daten du benötigst, kannst du im Backend etwas spicken und so die richtige
Struktur finden.

## Aufgabe 3 - Services erstellen und verwenden
Da wir bald schon das Backend anbinden solltest du noch die benötigten Services erstellen. Dazu solltest du folgende 
Dinge machen:
* Erstelle alle deiner Meinung nach benötigten Services
* Lass alle Daten aus einem Service laden und erstelle dazu Mockdaten

## Aufgabe 4 - Backend anbinden
In dieser Aufgabe verbindest du jetzt das Frontend mit dem Backend. Erledige dazu diese Aufgaben:
* Verwende die korrekten Endpoints aus dem Backend
* Hole die Daten Asynchron aus dem Backend
* Entferne alle Mockdaten

## Aufgabe 5 - Admin und Student
Ab diesem Zeitpunkt sollten alle grundlegenden Funktionen deiner Applikation umgesetzt sein, Glückwunsch! Jetzt möchten
wir noch die Admin- und Student-Funktionen trennen.

[//]: # (TODO: Definieren, wie die unterscheidung zwischen student und admin gemacht wird)

## Aufgabe 6 - Testing
Wie in den Anforderungen bereits erwähnt, ist das Ziel alle Components und Services zu testen. Dazu werden die normalen
`spec.ts` Dateien verwendet. Schlussendlich solltest du eine Coverage von mindestens 90% haben.

[//]: # (TODO: Macht Internationalization sinn? Die Daten werden ja nur in Deutsch gespeichert?)
[//]: # (Multilanguage umzusetzen dauert wahrscheinlich zu lange)
## Aufgabe 7 - Zusatzaufgabe: Internationalization
Durch Internationalization soll deine Applikation in insgesamt 3 Sprachen verfügbar sein. Ausserdem sollte die Sprache
direkt in der Applikation gewechselt werden können.
