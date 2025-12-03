---
title: "Rollenspiel"
linkTitle: "Rollenspiel"
type: docs
weight: 1
description: >
  Exam zu Modul #J3 - OOD - Rollenspiel
---

In dieser Aufgabe wird ein Fantasy-Rollenspiel mit Vererbung modelliert.
Lies zuerst die Einführung und arbeite dann die untenstehenden Aufgaben ab.

## Einführung

### Spielfiguren

- Es gibt verschiedene Spielfiguren:
  - Menschen
  - Zwerge
  - Elfen
  - Orks
  - Goblins
  - Trolle
- Jede Spielfigur hat einen Namen und besitzt eine bestimmte Anzahl an Lebenspunkten. Diese Lebenspunkte werden später im Kampf mit anderen Spielfiguren verringert
- Elfen können zaubern und haben einen Zauberwert
- Alle Spielfigur-Klassen sollen in einem entsprechenden Package angelegt werden
  - Optional: Falls die Optionalen Anforderungen bezüglich Rüstung und oder Gegenstände umgesetzt werden muss die folgende Anforderung auch umgesetzt werden:
    - Jede Spielfigur hat eine gewisse Tragkraft um Gegenstände und Ausrüstung mit sich herumtragen zu können (siehe weiter unten)

### Waffen

- Es gibt verschiedene Waffenarten
  - Nahkampfwaffen (Schwert und Keule)
  - Fernkampfwaffen (Bogen und Wurfmesser)
- Alle Waffen haben einen Angriffswert
- Nahkampfwaffen haben zusätzlich zu ihrem Angriffswert noch einen Verteidigungswert
- Alle Waffen haben ein Gewicht
- Alle Waffen-Klassen sollen in einem entsprechenden Package angelegt werden

### Gegenstände (Optional)

- Es gibt verschiedene Gegenstände
  - Tränke (Heiltrank und Stärketrank)
    - Ein Heiltrank kann bei einer Spielfigur eine bestimmte Anzahl an Lebenspunkten wiederherstellen
    - Ein Stärketrank erhöht den Angriffswert einer Spielfigur dauerhaft um einen bestimmten Wert
  - Zauberringe (Kraftring, Schutzring)
    - Ein Kraftring erhöht die Tragkraft einer Spielfigur dauerhaft um einen bestimmten Wert
    - Ein Schutzring verringert dauerhaft den erlittenen Schaden
- Jeder Gegenstand hat eine Bezeichnung und ein Gewicht
- Alle Gegenstand-Klassen sollen in einem entsprechenden Package angelegt werden

---

## Aufgabe 1

Implementation

- der Packages
- der Klassen
- der Instanzvariablen in den Klassen
- der Beziehungen zwischen den einzelnen Klassen

Vergiss nicht, dass es Generalisierungen und Spezalisierungen gibt. Achte auf eine gute Namensgebung bei Klassen und Variablen.

---

## Aufgabe 2

Ergänze die Applikation mit den folgenden Möglichkeiten:

#### Spielfigur

- Jede Spielfigur braucht einen Namen um instanziiert werden zu können
- Zu Beginn hat eine Spielfigur keine Waffe
- Jede Spielfigur hat eine Methode, die ihren Kampfwert zurückgibt
  - Der Kampfwert der Spielfigur setzt sich aus dem Kampfwert der akitven Waffe und der Multiplikation mit einer Zufallszahl zusammen. Die Zufallszahl liegt zwischen 0.9 und 1.1
  - Wenn eine Spielfigur keine Waffe besitzt, so ist ihr Kampfwert 1

**Elfen**

- Um einen Elfen instanziieren zu können, muss zusätzlich zum Namen der Zauberwert des Elfen angegeben werden
- Einem Elfen wird die Hälfte seines Zauberwerts zum Kampfwert addiert
- Elfen sind gute Bogenschützen, ihr Kampfwert erhöht sich um 50%, wenn sie einen Bogen als aktive Waffe benutzen

**Goblins**

- Goblins sind gute Bogenschützen, ihr Kampfwert erhöht sich um 50%, wenn sie einen Bogen als aktive Waffe benutzen

**Trolle**

- Trolle verdoppeln ihren Kampfwert wenn sie eine Keule verwenden

**Orks**

- Orks können in einen Kampfrausch verfallen, wenn ihre Lebenspunkte unter 25% fallen. Sie erhalten dann den dreifachen Kampfwert und erleiden nur den halben Schaden

#### Waffen

- Jede Spielfigur kann mit einer Waffe ausgerüstet werden
  - Ist die Waffe zu schwer für die verbleibende Tragkraft, so kann die Spielfigur die Waffe nicht aufnehmen
  - Eine Spielfigur kann mehrere Waffen mit sich rumtragen, aber jeweils nur eine Waffe aktiv verwenden
- Alle Keulen haben den Angriffswert 5 und den Verteidigungswert 5. Die beiden Werte sind also konstant
- Jede Waffe hat einen Kampfwert
  - Waffen geben als Kampfwert ihren Angriffswert zurück
  - Bei Nahkampfwaffen wird zum Angriffswert der halbe Verteidigungswert hinzuaddiert
- Falls das Attribut Tragkraft implementiert wurde gelten noch folgende Anforderungen:
  - Optional: Wird eine Waffe aufgenommen, wird die Tragkraft entsprechend reduziert
  - Optional: Spielfiguren können Waffen ablegen, um die verbleibende Tragkraft zu erhöhen

#### Gegenstände (Optional)

- Jede Spielfigur kann Gegenstände bis zur maximalen Tragkraft aufnehmen
  - Wird ein Gegenstand aufgenommen, wird die Tragkraft entsprechend reduziert
  - Ist der Gegenstand zu schwer für die verbleibende Tragkraft, so kann die Spielfigur den Gegenstand nicht aufnehmen
  - Eine Spielfigur kann mehrere Gegenstände mit sich rumtragen und diese Gegenstände später im Kampf aktiv einsetzen

#### Kampf

- Jede Spielfigur kann gegen eine andere Spielfigur kämpfen
  - Der Kampf findet in Runden statt
  - Es wird solange gekämpft, bis eine oder beide Spielfiguren keine Lebenspunkte mehr haben
  - Steht nach 20 Runden noch kein Sieger fest, wird der Kampf abgebrochen
  - Bei jeder Runde wird der Kampfwert der einen Spielfigur den Lebenspunkten des Gegners abgezogen und umgekehrt
  - Diejenige Spielfigur mit den meisten verbliebenen Lebenspunkten gewinnt
- Optional: Jede Spielfigur kann in einem Kampf von ihren Gegenständen Gebrauch machen

---

## Aufgabe 3

- Definiere nun eigene Regeln für deine Spielfiguren, damit das Spiel ein wenig ausgeglichener wird
- Die Regeln können beliebig geändert werden
- Es dürfen natürlich auch neue Waffen und Gegenstände (falls umgesetzt) eingeführt werden
- Dein Entwurf soll mindestens eine neue Spielfigur, eine neue Waffe, einen neuen Gegenstand und eine neue Spezialität für eine Spielfigur enthalten

---

## Aufgabe 4

- Die Kämpfe können sehr unausgeglichen sein
- Das Spiel soll so gestaltet werden, dass nicht immer die gleichen Spielfiguren gewinnen

---

## Aufgabe 5

- Das Spiel soll für alle Aktionen einen übersichtlichen Log generieren
- Eine Ausgabe für die Kommandozeile genügt, wenn sie sauber formatiert ist

---

## Aufgabe 6

Die Applikation hat nun aufgrund der vielen Klassen und Möglichkeiten eine gewisse Grösse erreicht und damit auch an Übersichtlichkeit verloren.
Die Logik der Applikation ist nun, je nach Implementation, in sehr vielen unterschiedlichen Klassen vorhanden.
In bestimmten Fällen, wie der Spezalisierung einer bestimmten Klasse, ist dies in Ordnung.

Wir arbeiten aber wenn immer möglich nach dem Single-Responsibility-Principle. Dieses Prinzip besagt, dass jeder Teil (bspw. Klasse, Methode) einer Applikation
nur für genau eine Aufgabe innerhalb dieser Applikation zuständig und verantwortlich ist. Kurz gesagt: eine Methode macht beispielsweise niemals zwei verschiedene Dinge gleichzeitig.

- Erstelle eine Klasse, welche den Kampf zwischen zwei Spielfiguren verwaltet. Diese Klasse enthält diverse Methoden und ist verantwortlich für:
  - das Starten eines neuen Kampfes zwischen zwei Spielfiguren
  - das Zählen der Kampfrunden
  - das Verrechnen von Schaden
  - das Ermitteln des Gewinners
- Stelle sicher, dass die spezalisierten Modell-Klassen (Elf, Heiltrank) nur die Logik enthalten, die für eine Spezalisierung gerechtfertigt ist
  - Beispiel 1: die Berechnung des Kampfwerts eines Elfen gehört in die Elf-Klasse, die diese die Spezialisierung für einen Elfen enthält
  - Beispiel 2: der Kampf zwischen zwei Spielfiguren gehört NICHT in die Spielfigur-Klasse, da diese generell gültige Informationen zu einer Spielfigur enthält und das eigentliche "Spiel" mit dem Kampf zweier Spielfiguren nicht die Aufgabe dieser Klasse ist

---

## Aufgabe 7 (Optional)

- Das Spiel soll erweitert werden, dass eine Spielfigur eine Rüstung tragen kann
- Es gibt leichte und schwere Rüstungen
  - Elfen und Goblins dürfen nur leichte Rüstungen tragen
  - Menschen, Zwerge und Orks dürfen schwere Rüstungen tragen
  - Trolle können aufgrund ihrer Grösse keine Rüstung tragen
  - Eine Spielfigur, welche eine schwere Rüstung tragen kann, kann selbstverständlich auch eine leichte Rüstung anziehen
- Eine Spielfigur muss nicht zwingend eine Rüstung tragen
- Jede Rüstung hat ein Gewicht, welches die Tragkraft der Spielfigur entsprechend verringert
- Eine Spielfigur kann eine Rüstung anziehen oder sie ablegen
- Mit dem Tragen einer Rüstung ist es einer Spielfigur möglich im Kampf pro Runde den Schaden komplett zu verhindern. Die schwere Rüstung ist dabei erfolgreicher. Das Verhindern von Schaden passiert zufällig

---

## Aufgabe 8

- Verhindere die Instanziierung von Klassen, die keinen Sinn ergeben (Beispiel Waffe, Spielfigur, ...)

---

## Aufgabe 9

- Jede Spielfigur erhält einen Initiative-Wert
- Je höher der Wert, desto früher darf die Spielfigur im Kampf zuschlagen
- Tiefere Werte verteilen also ihren Schaden später als höhere Werte
- Eine Spielfigur mit tiefem Initiative-Wert kann nicht mehr zurückschlagen wenn sie getötet wird
- Das Tragen von schweren Rüstungen verringert den Initiative-Wert (falls umgesetzt)
