---
title: "Spring und Spring Boot - Aufgaben"
linkTitle: "Spring und Spring Boot - Aufgaben"
type: docs
weight: 1
description: >
  Umsetzung einer Spring Boot Applikation für die Notenverwaltung aus Modul #J8
---

# Aufträge

## Voraussetzungen

Im [Lab zu Modul #J8 (JDBC)](../../11_java-jdbc/01_Jdbc_Exercises) hast du ein persistentes Notenverwaltungssystem umgesetzt.
Zu diesem Zweck hast du eine MariaDB-Instanz mit folgenden Tabellen aufgesetzt:

- SCHOOL_SUBJECT
- GRADE
- SCHOOL_SUBJECT_GRADE

Mehr Details dazu findest du im obenerwähnten Lab. Diese Datenbank und das dazu gehörende Datenbankmodel wirst du für unsere Spring-Aufgabe benötigen.  
Bei Bedarf kannst du das Model erweitern.

## Auftrag

Die Aufgaben in diesem Lab führen dich Schritt für Schritt durch die Umsetzung einer Webanwendung mit Spring Boot, welche einem Notenverwaltungssystem entspricht.
Die folgenden Abschnitte listen die groben Funktionalen (was soll die Anwendung können) und die nicht-funktionalen (zusätzliche Anforderungen z.B. an die Qualität der Anwendung) Anforderungen an die Anwendung auf.
Der Ablauf, um ein Spring Projekt zu erstellen, findet du in den Docs zu [Spring Boot](../../../../docs/02_java//12_spring-framework/08_projekt-erstellen).

### Funktionale Anforderungen

- Die Anwendung unterstützt zwei unterschiedliche Profile: "student" und "admin"
- Wenn die Anwendung mit dem Profil "student" gestartet wird, stehen die folgenden Funktionalitäten zur Verfügung:
  - Alle Fächer und all deren Noten auflisten (ein Fach kann mehreren Noten beinhalten)
  - Alle Fächer und deren Durchschnittsnote auflisten
  - Für ein bestimmtes Fach:
    - Alle Noten und die Durchschnittsnote des Fachs auflisten
    - Eine neue Note hinzufügen
    - Eine bestehende Note ändern
    - Eine bestehende Note löschen
- Wenn die Anwendung mit dem Profil "admin" gestartet wird, stehen zusätzlich auch folgende Funktionalitäten zur Verfügung:
  - Alle Fächer auflisten
  - Neue Fächer hinzufügen
  - Bestehende Fächer bearbeiten
  - Bestehende Fächer löschen
- Die Anwendung bietet die Möglichkeit abzufragen, welches Profil gestartet ist.

### Nicht funktionale Anforderungen (NFAs)

- Der Code (das Design) der Anwendung ist sinnvoll in entsprechenden Packages aufgeteilt.
- Eine Klasse hat eine einzige Aufgabe (Single Responsibility Principle).
- Direkter Zugriff auf der internen Struktur einer Klasse ist verboten (Encapsulation / Information Hiding).
- Jede Klasse ist getestet.

## Unittests

Schreibe zu den Integrationtests auch noch Unittest. Diese solltest du aus [J4 Testing](../../../../docs/02_java/10_java-testing) bereits kennen.

---

Zurück zur [Spring](../../../../docs/02_java/12_spring-framework/02_spring) und [Spring Boot](../../../../docs/02_java/12_spring-framework/07_spring-boot) Theorie.
