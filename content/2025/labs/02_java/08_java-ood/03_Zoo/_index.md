---
title: "Zoo"
linkTitle: "Zoo"
type: docs
weight: 3
description: >
  Aufgabe zu Modul #J3 - [OOD](../../../../docs/02_java/08_java-ood) - Zoo
---

Modelliere einen Klassenaufbau für einen Zoo. Folgende Klassen sollen enthalten sein:

- Personen
- Gehege
- Tiere

Jede dieser Klassen soll mehrere Spezialisierungen enthalten.

Bei den Personen unterscheidet man zwischen Mitarbeitern und Mitgliedern. Ein Mitarbeiter hat beispielsweise einen Lohn, den ein Mitglied nicht hat. Die folgenden Attribute sollen vorhanden sein:

- Lohn
- Beschreibung des Jobs
- Telefonnummer
- Mitglied seit
- Nummer der Mitglied-Karte

Verteile die Attribute also korrekt auf die Generalisierung und die Spezialisierungen.

Bei den Gehegen wird unterschieden zwischen Gelände, Terrarium, Aquarium und Käfig. Die einzigartigen Eigenschaften der verschiedenen Gehege sollen wie folgt modelliert werden:

- Gehege-Nummer
- Grösse in Quadratmeter
- Temperatur
- Feuchtigkeit
- Süss- / Salzwasser
- Fassungsvermögen
- Zaunhöhe
- Wassergraben vorhanden

Verteile die Attribute also korrekt auf die Generalisierung und die Spezialisierung. Selbstverständlich kann ein Gehege auch von einem anderen abgeleitet werden.

Bei den Tieren ist es festgelegt, dass es Land-, Wasser- und Flugtiere geben soll. Jede dieser Gruppen hat bestimmte Fähigkeiten:

- Landtiere können sich zu Fuss bewegen (z.B. walk()).
- Wassertiere können schwimmen (z.B. swim()).
- Flugtiere können fliegen (z.B. fly()).

Zusätzlich soll jedes Tier eine Methode besitzen, um einen spezifischen Laut von sich zu geben (z.B. makeNoise()).
Das Standardverhalten ist, dass ein Tier kein Ton macht. Bei den Tieren, bei denen das nicht zutrifft, muss dieses Verhalten entsprechend angepasst werden.

Führe Tiere ein, die in mehr als einem dieser Bereiche agieren können (z.B. ein Tier, das sowohl an Land als auch im Wasser leben kann.).
Stelle sicher, dass du mindestens ein Tier hast, welches keinen Laut macht.
Achte darauf, diese Kombinationen korrekt zu modellieren.

Du kannst frei wählen, welche konkreten Tiere dein Zoo enthalten soll und wie diese auf die Gehege verteilt werden. Beispiele wären:

- Krokodil (Land- und Wassertier)
- Adler (Land- und Flugtier)
- Pinguin (Land- und Wassertier)
- Qualle (Wassertier)

Der Zoo hat also Mitarbeiter und Mitglieder sowie verschiedene Tiere, die in verschiedenen Gehegen leben. Die Beziehungen zwischen den Klassen, wie Zoo, Gehegen und Tieren, sollten den realen Verhältnissen in einem Zoo nachempfunden sein.

Info: Bei dieser Aufgabe darf man NICHT Gebrauch von Lombok machen.

---

Hier kannst du [zurück zur Theorie](../../../../docs/02_java/08_java-ood).
