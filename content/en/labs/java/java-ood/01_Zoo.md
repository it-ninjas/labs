---
title: "Zoo"
linkTitle: "Zoo"
type: docs
weight: 1
description: >
  Aufgabe zu Modul #J3 - OOD - Zoo
---
Modelliere* einen Klassenaufbau für einen Zoo. Folgende Klassen sollen enthalten sein: 
- Personen
- Gehege
- Tiere

Jede dieser Klassen soll mehrere Spezialisierungen enthalten.

> *Modelliere bedeutet in diesem Zusammenhang, dass du nur den Aufbau mittels Klassen darstellen musst. Es wird keine Funktionalität gefordert.  

Bei den Personen wird zwischen Mitarbeitern und Mitgliedern unterschieden.
Ein Mitarbeiter hat beispielsweise einen Lohn, welcher ein Mitglied nicht hat.
Die folgenden Attribute sollen vorhanden sein:
- Lohn
- Beschreibung des Jobs
- Telefonnummer
- Mitglied seit
- Nummer der Mitglied-Karte

Verteile die Attribute also korrekt auf die Generalisierung und die Spezialisierungen.

Bei den Gehegen wird unterschieden zwischen Gelände, Terrarium, Aquarium und Käfig.
Die einzigartigen Eigenschaften der verschiedenen Gehege sollen wie folgt modelliert werden:
- Gehege-Nummer
- Grösse in Quadratmeter
- Temperatur
- Feuchtigkeit
- Süss- / Salzwasser
- Fassungsvermögen
- Zaunhöhe
- Wassergraben vorhanden

Verteile die Attribute also korrekt auf die Generalisierung und die Spezalisierung.
Selbstverständlich kann ein Gehege auch von einem anderen abgeleitet werden.

Bei den Tieren könnt ihr selber entscheiden, welche Tiere euer Zoo enthalten soll und wie diese auf die Gehege verteilt werden.<br>
Falls ihr keine Ideen habt, gibt es hier ein paar Beispiele:
- Landtiere
- Amphibien
- Wassertiere
- Vögel 

oder
- Aufteilung nach Spezies wie Insekten, Säugetiere, Wirbeltiere, Reptilien

oder
- Aufteilung nach Ernährung (Fleischfresser, Pflanzenfresser, Allesfresser :-))

Der Zoo hat also Mitarbeiter und Mitglieder und verschiedene Tiere, die in verschiedenen Gehegen leben.
Die Beziehung zwischen den einzelnen Klassen wie dem Zoo seinen Gehegen und Tieren soll sich an der realen Welt orientieren.
