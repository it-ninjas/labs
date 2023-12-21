---
title: "Exam zu Angular"
type: docs
linkTitle: "Angular Exam - Notenverwaltung"
weight: 2
date: 2023-05-24
description: >
    Ein Angular Exam zum Erstellen eines Frontends zu einem bestehenden Backend.
---

## Inhalt
Im Lab von [Spring Boot](../../../../labs/java/spring/01_spring) hast du bereits ein Backend für eine Notenverwaltung geschrieben.
In diesem Exam sollst du zusätzlich ein Frontend schreiben, welches dieses Backend verwendet. Schlussendlich 
solltest du eine komplett selbst erstellte Fullstack Applikation haben, die einwandfrei funktioniert.

### Setup
Bevor du mit den Aufgaben beginnst, solltest du ein neues Angular Projekt wie gelernt aufsetzen. Du kannst beim Setup
bereits das Routing integrieren und wähle als stylesheet SCSS aus. Den Namen kannst du frei wählen. Wenn diese 
Bedingungen erfüllt sind, kannst du mit den Aufgaben beginnen. 

### Anforderungen
#### Funktional
* Die Anwendung unterstützt zwei unterschiedliche Profile: "student" und "admin"
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
* Die Anwendung ist Responsive gestaltet und ist auf Desktop, Tablet und Mobile verwendbar
  * Die Verwendung von Bootstrap ist nicht erlaubt

* Zusätzliche Anforderungen
  * Die Anwendung ist in den Sprachen Deutsch, Französisch und Englisch verfügbar
  * Die Sprache kann direkt in der Applikation gewechselt werden
#### Nicht-Funktional
* Der Code (das Design) der Anwendung ist sinnvoll in entsprechenden Components/Services aufgesplittet.
* Ein Component/Service hat eine einzige Aufgabe (Single Responsibility Prinzip).

## Design
Die Notenverwaltung sollte ungefähr dem vorgegebenen Design entsprechen. Farben und Schriftarten können frei gewählt
werden, jedoch sollte das vorgegebene Design immer noch erkennbar sein. 

Das Design wurde mit Figma erstellt und ist navigierbar. Also kannst du die benötigten Verlinkungen so selbst 
herausfinden. Teilweise wurde eine Funktion, wie das Bearbeiten einer Note, nur einmal umgesetzt. Die Funktion soll
beim Endprodukt aber logischerweise überall umgesetzt sein. Das Design wurde für Desktop, Tablet und Mobile erstellt, 
die Anwendung sollte sich dementsprechend wie im Design anpassen.

Hier der Link zum Design: [Figma Design - Notenverwaltung](https://www.figma.com/proto/CxwGOD9wyGZ1pDucOdusND/Notenverwaltung?type=design&node-id=1-3&scaling=contain&page-id=0%3A1&starting-point-node-id=1%3A3&show-proto-sidebar=1)

[//]: # (INFO!!!!: Link zum Bearbeiten des Designs, falls eine Änderung nötig ist: https://www.figma.com/community/file/1265244364247644334)

Es ist zu empfehlen, dass zum Erstellen der Applikation [Angular Material](https://material.angular.io/) eingesetzt 
wird. So können bereits erstellte Komponenten inklusive Design verwendet werden.

## Aufgabe 1 - Erstellen der Components
Um alle Daten der Notenverwaltung anzeigen, erstellen, löschen und bearbeiten zu können, werden verschiedene Components
benötigt. In dieser Aufgabe solltest du diese Punkte abarbeiten:
* Überlege dir anhand der [Anforderungen](#anforderungen), wofür du alles einen Component benötigst. Die Unterscheidung
zwischen Admin und Student Profil kann aktuell ignoriert werden. Erstelle bereits jetzt alle Components dazu.
* Entwickle ein einfaches und benutzerfreundliches Design für die einzelnen Seiten.
* Verwende aktuell feste Daten, diese werden in einer späteren Aufgabe ersetzt.

## Aufgabe 2 - Models erstellen und verwenden
Aktuell werden in deiner Applikation feste Daten angezeigt, die im HTML angegeben sind. Da die Daten später jedoch
aus dem Backend kommen sollten, ist es von Vorteil, wenn du Models hast, die den benötigten Daten entsprechen. Diese
Punkte sollten in dieser Aufgabe erledigt werden:
* Erstelle alle deiner Meinung nach benötigten Models.
* Ändere deine festen Daten und setze deine erstellten Models ein.
* Versuche, wo nötig, Forms zu verwenden, um diese Später verwenden zu können.
> Tipp: Wenn du dir unsicher bist welche Daten du benötigst, kannst du im Backend bei den DAOs etwas spicken und so die 
richtige Struktur finden.

## Aufgabe 3 - Services erstellen und verwenden
Da wir bald schon das Backend anbinden, solltest du noch die benötigten Services erstellen. Erledige dazu folgende Aufgaben:
* Erstelle alle deiner Meinung nach benötigten Services
* Lass alle Daten aus einem Service laden und erstelle dazu Mockdaten

## Aufgabe 4 - Backend anbinden
In dieser Aufgabe verbindest du jetzt das Frontend mit dem Backend. Erledige dazu diese Aufgaben:
* Verwende die korrekten Endpoints aus dem Backend
* Hole die Daten Asynchron aus dem Backend
* Entferne alle Mockdaten

## Aufgabe 5 - Admin und Student
Ab diesem Zeitpunkt sollten alle grundlegenden Funktionen deiner Applikation umgesetzt sein, Glückwunsch! Jetzt möchten
wir noch die Admin- und Student-Funktionen trennen. Dazu besteht im Backend ein Endpunkt, welcher das gestartete Profil 
im Backend an das Frontend sendet. Darüber soll das Frontend die verschiedenen freischalten oder verstecken.
Dazu hast du im Backend einen oder mehrere Endpunkte erstellt, die du jetzt einsetzen kannst.
Deine Applikation soll auch selbständig erkennen, welche Funktionen verfügbar sind und welche nicht.

