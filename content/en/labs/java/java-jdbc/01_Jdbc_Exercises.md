---
title: "JDBC - Aufgaben"
linkTitle: "JDBC - Aufgaben"
type: docs
weight: 1
description: >
  Modul #J8 - JDBC
---

## Persistente Notenverwaltungssystem
Schreibe eine Konsolen-basierte Java Anwendung, welche deine Schulnoten verwaltet und in einer Datenbank persistiert.

Die Anwendung soll mindestens die folgende Funktionalität beinhalten:
- Neue Note für ein bestimmtes Fach erfassen (inkl. Datum)
- Eine bestehende Note löschen
- Eine bestehende Note bearbeiten
- Den aktuellen Notenstand eines Fachs ausgeben (Auflistung aller Noten und die Durchschnittsnote)
- Die Durchschnittsnoten aller Fächer ausgeben (#Zeugnis)

Verwende eine MariaDB und setzte sie selbst auf. Den nötigen Treiber dazu findest du im Internet.
Die Datenbank muss mindestens die folgenden Tabellen beinhalten:
- SCHOOL_SUBJECT - beinhaltet alle Schulfächer
- GRADE - beinhaltet alle gültigen Noten zwischen 1 und 6 (in 0.25 Stufen -> also 1, 1.25. 1.5, 1.75, 2 usw..)
- SCHOOL_SUBJECT_GRADE - beinhaltet die Relation zwischen Schulfächern und Noten. Jede Zeile stellt eine Note für ein Fach an einem bestimmten Tag dar.

Achte auf korrektes Exception-Handling (denke an "try with resources") und sauberen Code.

Zudem wird erwartet, dass ein eigenes Testing (wie in [J4 Testing](./../java-testing) gelernt) zu der Umsetzung gehört.

