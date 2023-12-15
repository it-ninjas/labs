---
title: "Exam zu den Angular-Basics"
type: docs
linkTitle: "Angular-Basics"
weight: 3
date: 2021-05-09
description: >
    Einfache Aufgaben zu den Basics von Angular.
---

# Exam 2 - Angular
![task1](/images/task.png) - Einzelarbeit<br>

## Ausgangslage
In deinem Unternehmen werden die Arbeitszeiten immer noch im Excel erfasst. Dein Linienvorgesetzter ist mit diesem Excel-File nicht mehr so zufrieden. Er verlangt von dir, dass du ein Angular-Projekt realisieren sollst, welches das aktuelle Excel-File ablöst. Designtechnisch ist alles dir überlassen. Du kannst entweder mit einem lokalen Projekt arbeiten oder eine Backendschnittstelle basteln.

## Anforderungen
### Funktionale Anforderungen
Dein Linienvorgesetzter gibt dir folgende funktionale Anforderungen für das Arbeitszeitprogramm:
- Die Mittagszeit von 30 Minuten **muss** gemacht werden. Sofern über 9h gearbeitet wird, **muss** mindestens 1h Mittagspause gemacht werden.
- Man kann entweder von Hand oder mit Hilfe eines QR-Codes ein- und ausstempeln.
- Es gibt drei Rollen: *Admin, Vorgesetzter und Mitarbeiter*.<br>Der *Admin* kann neue Mitglieder (*Admin, Vorgesetzter, Mitarbeiter*) hinzufügen und den *Vorgesetzten* zuweisen. Sieht aber keine Zeitaufschreibung ausser die eigene. Der *Vorgesetzte* sieht die eigene Zeit, wieauch die Zeit seiner Mitarbeiter. Der *Mitarbeiter* sieht nur seine eigene Zeit.
- Der *Admin* kann neue Auftragszeiten (Projekt X, Projekt Y, Daily Business, etc.) hinzufügen, welche von allen Mitarbeitern gewählt werden können.
- Jedes Mitglied **muss** bei der Zeitaufschreibung ein Auftrag wählen, wo er gerade arbeitet. Diese Projekte können favorisiert werden, damit man sie nicht jedes Mal wählen muss.
- Jedes Mitglied kann zudem diverse Zeitcodes anwenden, welche vom Admin hinzugefügt werden. Das sind beispielsweise: Krank, Kompensation, Berufsschule, Ferien,etc.
- Man kann die Zeiten im späteren Verlauf noch ändern. Hierzu werden aber alle geänderten Zeiten (Datum bearbeitung, etc.) angezeigt.
- Jedes Mitglied kann sein Passwort (und Profilbild) ändern.
- Der *Admin* kann die Daten jedes Mitglieds ändern(Nachname, Vorname, Abteilung, etc.) oder löschen.

### Nicht-funktionale Anforderungen
- Das System muss innerhalb von 100ms die Daten liefern.
- IT-Sicherheit: Das System bockiert nach drei Fehlrversuchen die Anmeldung.
- Abfragen können nur mit einem JWT ausgeführt werden.

## Daten
### Mitglieder-Daten
Die Mitglieder bestehen aus folgenden Werten:
- Nachname
- Vorname
- Passwort(muss bei der ersten Anmeldung geändert werden)
- Abteilung
- Arbeitszeit(bspw. 100% oder 8h)
- Rolle
- (nicht zwingend Profilbild)

### Zeit-Daten
Die Zeit besteht aus folgenden Werten:
- Von
- Bis
- Datum

### Auftragszeit-Daten
Die Auftragszeit besteht aus folgenden Werten:
- Auftragsnummer
- Text

### Zeitcodes-Daten
Die Zeitcodes besteht aus folgenden Werten:
- Nummer
- Beschreibung


![hint1](/images/hint.png) - Hinweis:

Beziehungen zwischen Daten nicht vergessen.

Bei Fragen ungeniert melden.