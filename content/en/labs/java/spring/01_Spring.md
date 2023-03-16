---
title: "Spring und Spring Boot - Aufgaben"
linkTitle: "Spring und Spring Boot - Aufgaben"
type: docs
weight: 1
description: >
Umsetzung einer Spring Boot Applikation für die Notenverwaltung aus Modul #J8
---

# Aufträge

## Voraussetzungen (Smadar)
Verweis auf Kapitel J8

## Auftrag (Smadar)
Auftrag mit Zielen und Anforderungen beschreiben

## Maven-Projekt erstellen / pom.xml (Smadar)
Zwei Varianten (manuell, Initializr)
Akzeptanzkriterium: Spring Boot Applikation startet

## API definieren und umsetzen (Smadar)
DTOs definieren
Controller
URLs / REST
Mock-Daten anlegen
Akzeptanzkriterium: Zugriff mit Postman oder Browser

## Service-Layer umsetzen (Claudio)
DI
Services anlegen
Mock-Daten in Service verschieben
Akzeptanzkriterium: Zugriff mit Postman oder Browser / Unit-Tests umgesetzt

## Persistenz-Layer anlegen (Claudio)
Repos anlegen
Mock-Daten in Repository verschieben
Akzeptanzkriterium: Zugriff mit Postman oder Browser

## Konfiguration anlegen (Claudio)
application.yml mit DB-Konfiguration
Akzeptanzkriterium: Spring Boot Applikation startet mit DB

## Profile anlegen (Smadar)
Admin-Rolle mit zusätzlicher Schnittstelle
Neues Fach hinzufügen

## Persistenz-Layer fertigstellen (Claudio)
Queries schreiben
RowMapper oder ResultSetExtractor umsetzen
Verschiedene Arten von Queries umsetzen (JPQL, Native)

## API testen (Smadar)
Postman
Postman-Collections
IntelliJ HTTP Client

## Integrationstests mit H2 umsetzen (Claudio)
Schema.sql
Data.sql
MockMVC
