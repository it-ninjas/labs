---
title: "Labs zu Signals"
type: docs
linkTitle: "Signals Labs"
weight: 3
date: 2024-07-03
description: >
    Aufgaben zu Signals in Angular.
---

# Aufgaben

## Aufgabe 1
1. Erstelle eine neue Angular-Komponente mit dem Namen SignalExample.
2. Verwende die Funktion `createSignal`, um innerhalb der Komponente ein Signal namens `messageSignal` zu definieren.
3. Zeige den Wert von messageSignal im Template an.


## Aufgabe 2
1. Erweitere die Komponente aus Aufgabe 1 um zwei Eingabefelder - eines für einen Namen und eines für eine Nachricht.
2. Binde die Werte dieser Eingabefelder an separate Signale (`nameSignal` und `messageSignal`).
3. Zeige eine formatierte Nachricht im Template unter Verwendung der Werte aus den Signalen an.


## Aufgabe 3
1. Füge zur Komponente aus den vorherigen Aufgaben einen Button hinzu.
2. Verwende ein Signal (`showMessageSignal`), um die Sichtbarkeit einer Nachrichten-Div im Template zu steuern.
3. Beim Klicken des Buttons, ändere den Wert von `showMessageSignal`, um die Nachricht anzuzeigen/zu verbergen


## Aufgabe 4
1. Erstelle einen Service namens `DatenService` mit einem Signal `dataSignal`, das ein Array von Daten emittiert.
2. Injiziere den DatenService in die bestehen3.de Komponente der vorherigen Aufgaben.
3. Verwende `dataSignal, um eine Liste von Daten im Komponenten-Template anzuzeigen


## Aufgabe 5
1. Füge der Komponente aus der vorherigen Aufgaben einen Effekt hinzu, der eine Nachricht protokolliert, wenn sich das `messageSignal` ändert.
2. Teste den Effekt, indem du den Wert von messageSignal änderst und die Konsole beobachtest.

