---
title: "Objektorientierte Programmierung Challenge"
linkTitle: "Objektorientierte Programmierung Challenge"
type: docs
weight: 2
description: >
  Challenge zu Modul #J2
---

### Hogwarts Sorting Hat System

Hogwarts ist bekanntlich die beste Schule für Hexerei und Zauberei.
Alle Hogwarts Schüler:innen werden vor Beginn des ersten Schuljahres gemäss ihren
Charakter-Eigenschaften und Fähigkeiten in einem der vier Hogwarts "Häuser" eingeteilt.
Die Einteilung in die Häuser ist die Aufgabe des "sprechenden Hutes" (engl. "Sorting Hat").

Der sprechende Hut ist mittlerweile mehr als 1000 Jahre alt und soll in den verdienten Ruhestand gehen.
Dazu ist die Digitalisierung auch bei Hogwarts endlich angekommen und der Schulmeister möchte dich beauftragen
ein Sorting-Hat System zu bauen, welche die Aufgabe des sprechenden Hutes übernimmt und neue Schüler:innen
in eines der vier Hogwarts-Häuser aufgrund von bestimmten Kriterien und Eigenschaften einteilt.

#### Die Hogwarts Häuser und ihre Eigenschaften/Merkmale

Die vier Hogwarts Häuser - Gryffindor, Hufflepuff, Ravenclaw und Slytherin - haben bestimmte Merkmale
und Eigenschaften, welche dem sprechenden Hut dabei helfen, die Schüler:innen in das richtige Haus einzuteilen.

Die folgende Tabelle listet ein paar wichtige Merkmale für jedes Haus auf:

| Haus       | Wichtigste Charakter-Eigenschaften                              | Hausfarben          | Haustier | Element | Gründer:in        | Anzahl Schüler:innen |
| ---------- | --------------------------------------------------------------- | ------------------- | -------- | ------- | ----------------- | -------------------- |
| Gryffindor | Tapferkeit, Kühnheit, Courage, Ritterlichkeit, Entschlossenheit | Gold, Scharlachrot  | Löwe     | Feuer   | Godric Gryffindor | 31                   |
| Hufflepuff | Fleiss, Hingabe, Geduld, Loyalität, Fairplay                    | Gelb, Schwarz       | Dachs    | Erde    | Helga Hufflepuff  | 15                   |
| Ravenclaw  | Intelligenz, Wissen, Neugier, Kreativität, geistige Wendigkeit  | Blau, Bronze        | Adler    | Luft    | Rowena Ravenclaw  | 33                   |
| Slytherin  | Ehrgeiz, Führerschaft, Selbsterhaltung, List, Einfallsreichtum  | Smaragdgrün, Silber | Schlange | Wasser  | Salazar Slytherin | 48                   |

#### Einteilungsalgorithmus

Der sprechende Hut teilt angehende Hogwarts Schüler:innen in eines der vier Hogwarts-Häuser
anhand von bestimmten Kriterien ein. Diese Kriterien sind:

- Charakter-Eigenschaften der Person, verglichen mit den Charakter-Eigenschaften, welche dem/der Gründer:in des Hauses wichtig waren
- Lieblingsfarbe, verglichen mit den Hausfarben
- Verwandtschaft mit einem ehemaligen Mitglied eines der Häuser
- Das Wunschhaus der Person, welche eingeteilt werden soll

Der/die Schüler:in wird zu jedem Kriterium befragt (mehrere Antworten sind bei den meisten Kriterien möglich!).
Die Antworten zu jedem Kriterium werden bewertet, sodass am Schluss für jedes Haus eine Gesamtbewertung vorliegt.
Der/die Schüler:in wird in das Haus mit dem höchsten Wert eingeteilt.

Aber vorsicht, es gelten auch folgende Bestimmungen, welche die Auswertung des gewählten Hauses beeinflussen:

- Nicht alle Kriterien/Werte werden beim Einteilungsentscheid gleich gewichtet (die Gewichtung wird später erläutert).
- Wenn zwei Häuser die gleiche Bewertung erhalten, wird das Haus mit der niedrigeren Anzahl Schüler:innen ausgewählt.
- Das Wunschhaus wird bei der Gesamtbeurteilung manchmal berücksichtigt und manchmal nicht (mehr dazu später)

#### Gewichtung der Kriterien

Folgend findest du die Bestimmungen und Gewichtungen, welche bei der Auswertung des passenden Hauses eingehalten werden müssen.
Die Gesamtauswertung eines Hauses besteht aus der Summe aller Punkte, welche bei jedem Kriterium für dieses Haus berechnet worden sind.

##### Charakter-Eigenschaften

Es sind insgesamt 20 Charakter-Eigenschaften möglich (siehe Tabelle der Hogwarts-Häuser hier oben).
Der/die Benutzer:in muss mindestens drei Charakter-Eigenschaften auswählen, welche zu ihm/ihr passen.

Per Haus, hat jede Charakter-Eigenschaft ein Gewicht zwischen 1 und 20.
Die wichtigsten Charakter-Eigenschaften eines Hauses erhalten die höchsten Gewichtswerte für dieses Haus.
Die anderen Charakter-Eigenschaften bekommen niedrigere Werte.
Bei der Auswertung werden für jedes Haus die Gewichtswerte für die eingegebenen Eigenschaften zusammenaddiert.

##### Farben

In Hogwarts gibt es vier Hausfarben-Paare, also insgesamt acht Hausfarben (siehe Tabelle der Hogwarts-Häuser hier oben).
Der/die Benutzer:in gibt seine/ihre Lieblingsfarbe ein.
Wenn die Farbe, mit einer Hausfarbe übereinstimmt, erhält dieses Haus zusätzliche 10 Punkte.

##### Verwandtschaft

Eine Person kann mehrere Verwandte haben, welche in Hogwarts studiert haben und entsprechend
einem Haus eingeteilt wurden.  
Die Anzahl Verwandte, welche einem Haus eingeteilt wurden, gibt diesem Haus einen zusätzlichen Wert,
welcher der Fakultät dieser Anzahl Verwandten entspricht.

_Hinweis:_ eine Person kann mehrere Verwandte haben, welche in unterschiedliche Häuser eingeteilt worden waren...

##### Wunschhaus

Der/die Benutzer:in kann sein/ihr Wunschhaus eingeben.
Das Wunschhaus "schenkt" dem gewählten Haus eine zufällige Anzahl Punkte zwischen 5 und 10 zur
Gesamtbeurteilung aber nur wenn der/die Benutzer:in auch eine der Hausfarben dieses Hauses als Lieblingsfarbe ausgewählt hat.

#### Anforderungen an das System

- Verwende viele verschiedene Klassen, um dein System zu modellieren
- Erzeuge ein gutes Abbild der Aufgabenstellung
- Die _main_ Methode soll nur zur Interaktion mit dem/der Benutzer:in dienen.
- Skizziere dein Modell, sodass du es danach auch erklären kannst
- Teil der Aufgabe ist es, bestimmte Prinzipien kennenzulernen und zu verstehen. Wende entsprechend bei der Umsetzung folgende Prinzipien an:
  - Single Responsibility Principle
  - Immutable Objects

**Bonus Anforderungen**

- Wenn sinnvoll, wende Generics an
- Verwende, wenn möglich, Streams statt Loops
- Füge ein Einteilungskriterium hinzu

_Wenn du an der Challenge teilnehmen willst, dann musst du die Aufgabe alleine lösen.
Die Lösung vom Pult-Nachbar interessiert uns also nicht._
