---
title: "Wassermenge"
linkTitle: "Wassermenge"
type: docs
weight: 6
description: >
  Aufgabe zu Modul #J2 - OOP - Wassermenge
---

Schreibe eine Anwendung, welche entscheidet ob ein Damm geöffnet sein muss oder nicht.
Die Entscheidung wird anhand der Wassermenge, welche in einen See hineinfliesst, verglichen
mit der Wassermenge, welche aus diesem See wieder herausfliesst, gefällt.

Eine Wassermenge

- hat eine Menge
- hat eine Einheit wie Liter, Hektoliter oder m³

## Die Anwendung soll

- Auskunft geben, ob die hineinfliessende Wassermenge gleich ist wie die herausfliessende Wassermenge
- Den Damm nur dann öffnen, wenn die hineinfliessende Wassermenge grösser ist als die herausfliessende Wassermenge.

_Es sollen keine Setter-Methoden für das Einfügen der Werte verwendet werden!_

## Aufgabe 1

Schreibe ein Programm, dass die Anforderungen auf eine objekt-orientierte Art und Weise umsetzt - d.h., dass die Methoden immer noch funktionieren würden, auch wenn es mehrere Dämme geben würde.

Simuliere einen Damm zu drei verschiedenen Zeitpunkten mit unterschiedlichen hinein- und hinausfliessenden Wassermengen.

Eine Methode `status()` soll einen Wert zurückgeben, der aussagt, ob der Damm zum gegebenen Zeitpunkt offen oder geschlossen ist.

## Aufgabe 2 - Zustände speichern

(Erst nach dem Kapitel "Veränderbarkeit" lösen.)

Erweitere die `status()`-Methode so, dass bei jeder Status-Abfrage (also beim Aufruf der Methode) die Mengen in einer Liste gespeichert werden - und zwar als Objekte eurer Klasse für die Wassermenge.

Am Ende des Programms sollen alle Mengen inkl. Einheiten dann in der Konsole ausgegeben werden.

---

Hier kannst du [zurück zur Theorie](../../../../docs/02_java/04_java-oop).
