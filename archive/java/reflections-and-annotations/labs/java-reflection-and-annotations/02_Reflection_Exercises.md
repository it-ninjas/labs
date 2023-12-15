---
title: "Reflection API - Aufgaben"
linkTitle: "Reflection API - Aufgaben"
type: docs
weight: 2
description: >
  Aufgaben zu Modul #J6 - Annotationen & Reflection API
---

Die folgende Aufgabe dient der Vertiefung der beiden Themen Reflection API und Annotations.

## Aufgabe 1

Implementiere eine Klasse _Person_ mit den Attributen Namen und Alter.
Die Klasse muss einen Konstruktor mit beiden Attributen aufweisen. Für beide Attribute muss eine
Get-Methode implementiert werden.  
Implementiere zudem eine toString Methode.

## Aufgabe 2

Implementiere eine eigene Annotation. Die Annotation soll der Auffindung der Klasse zur Erzeugung
von Instanzen der oben genannten Klasse dienen und die folgenden Eigenschaften aufweisen:

- Verfügbar zur Laufzeit
- Verfügbar auf Klassen

Der Name der Annotation soll anhand ihres Zwecks gewählt werden. Die Annotation hat keine Attribute.

## Aufgabe 3

Implementiere eine weitere Annotation. Die Annotation soll der Angabe von Daten für Personen dienen.
Sie muss die folgenden Eigenschaften aufweisen:

- Verfügbar zur Laufzeit
- Verfügbar auf Konstruktoren
- Attribut für die Namen von Personen als String-Array
- Attribut für das Alter von Personen als Integer-Array

## Aufgabe 4

Wende die beiden Annotationen auf deine Person-Klasse an. Eine auf der Klasse, die Andere auf dem
Konstruktor.  
Die Annotation auf dem Konstruktor muss mindestens drei Namen und drei Altersangaben aufweisen.

## Aufgabe 5

Implementiere eine Main-Klasse mit einer Main-Methode und nutze Reflection, um Instanzen anhand der
Konstruktor-Annotation zu erzeugen. Gehe dabei wie folgt vor:

- Hol dir eine Klasseninstanz über den Package- und Klassennamen oder über das statische Feld class
- Hol dir auf der Klasseninstanz den Konstruktor
- Hol dir vom Konstruktor die Annotation
- Hol aus der Annotation die Namen und Altersangaben
- Nutze die Angaben in einem Loop, um entsprechend viele Instanzen der Klasse Person zu erzeugen
- Drucke die Angaben der Personen auf der Kommandozeile aus
