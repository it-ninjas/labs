---
title: "Streaming Dienst"
linkTitle: "Streaming Dienst"
type: docs
weight: 4
description: >
  Aufgabe zu Modul #J2 - OOP - Streaming Dienst
---

Schreibe ein Programm, welches einen Streaming Dienst nachstellt.
Die Anwendung soll die Filme und Serien in einem Streaming Dienst abspeichern,
wenn die entsprechende Methode aufgerufen wurde.
Der Streaming Dienst hat auch eine Liste an Personen,
welche ein Abonnement bei dem Streaming Dienst gelöst haben.

Eine Person besitzt

- einen Namen
- eine Email-Adresse
- eine Kreditkarte

Ein Film

- einen Namen
- eine Dauer
- ein Genre
- einen Produzenten

Eine Person kann

- einen Film als gesehen markieren (_View_)
- seine Kreditkarte ändern
- zwischen der Zahlungsart Monatlich oder Jährlich entscheiden

Der Streaming Dienst kann

- die Anzahl der Personen zurückliefern, welche ein Abonnement gelöst haben
- eine neue Person registrieren
- eine Person löschen
- nach einem Film über den Namen suchen
- nach Filmen eines bestimmten Genres suchen
- die anzahl _Views_ auf einem Film wiedergeben
- alle Kreditkarten der Kunden ausgeben _(println)_
  die das Abonnemente per Monatlichen Zahlung bezahlen

_Generell gilt die Regel, dass jede E-Mail-Adresse und jeder Film-Name einzigartig sein muss_

## Zusatzaufgabe (muss nicht gelöst werden):

Dies ist eine Liste aller europäischen Sprachen:
`BULGARIAN,CROATIAN,CZECH,DANISH,DUTCH,ENGLISH,ESTONIAN,FINNISH,FRENCH,GERMAN,GREEK,HUNGARIAN,IRISH,ITALIAN,SLOVENIA,LATVIAN,LITHUANIAN,MALTESE,POLISH,PORTUGUESE,ROMANIAN,SLOVAK,SLOVENE,SPANISH,SWEDISH`

Ein Film soll um den Wert _Sprachen_ erweitert werden. Darin wird gepseichert, in welchen Sprachen der Film verfügbar ist.
**Speichert die Sprache nicht in Form eines Strings!!!**

_Es soll kein Scanner eingesetzt werden._

---

Hier kannst du [zurück zur Theorie](../../../../docs/java/j2-oop).
