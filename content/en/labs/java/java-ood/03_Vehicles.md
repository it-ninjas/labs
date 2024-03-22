---
title: "Vehicles"
linkTitle: "Vehicles"
type: docs
weight: 3
description: >
 Aufgabe zu Modul #J3 - OOD - Vehicles
---

Entwirf ein Fahrzeugverwaltungssystem für ein Autohaus.

Das Fahrzeugverwaltungssystem soll die Verwaltung von verschiedenen Fahrzeugtypen wie Autos, Lastwagen, Motorrädern. ermöglichen. 
Jedes Fahrzeug soll eine eindeutige Fahrzeugidentifikationsnummer (VIN) haben.

Jedes Fahrzeug verfügt über folgende Eigenschaften:
- Fahrzeugtyp (Auto, Lastwagen, Motorrad)
- Marke
- Modell
- Farbe
- Baujahr
- Preis
- Verfügbarkeit (ob das Fahrzeug zum Verkauf steht oder nicht)

Das Auto hat zudem:
- Type (Familienauto, Sportauto etc.)
- Anzahl Sitze
- Stauraum im Kofferraum in m^2

Der Lastwagen hat zudem:
- mit Anhänger
- Ladefläche

Das Motorrad hat zudem:
- Fahrzeugklasse (Sportmotorrad, Cruiser, Touring)

Das Fahrzeugverwaltungssystem soll die folgenden Funktionen unterstützen:
- Hinzufügen eines neuen Fahrzeugs zum Inventar des Autohauses.
- Aktualisieren der Details eines vorhandenen Fahrzeugs (z. B. Preisänderung, Verfügbarkeitsstatus, Ausstattungsmerkmale hinzufügen/entfernen).
- Entfernen eines Fahrzeugs aus dem Inventar, wenn es verkauft wurde oder nicht mehr verfügbar ist.
- Anzeigen einer Liste aller verfügbaren Fahrzeuge zum Verkauf.
- Reservierung eines Fahrzeugs für einen Kunden, bevor der endgültige Kauf abgeschlossen ist.
- Verkauf eines reservierten Fahrzeugs und Aktualisierung des Bestands.
