---
title: "Wassermenge Challange"
linkTitle: "Wassermenge Challange"
type: docs
weight: 2
description: >
  Challange zu Modul #J2 - Wassermenge
---

Schreibe eine Anwendung, welche entscheidet ob ein Damm geöffnet oder geschlossen werden muss. Die Entscheidung wird
anhand der Wassermenge gefällt, welche in einen See hineinfliesst, verglichen mit der Wassermenge, welche aus diesem See
herausfliesst wenn der Damm geöffnet ist. Es soll sichergestellt werden, dass die Wassermenge sich zwischen dem
Minimal- und Maximalvolumen bewegt.

Ein See

- kann mit einer Wassermenge zu einem gegebenen Zeitpunkt (LocalDateTime) initialisiert werden
- hat ein Mindestvolumen in Liter
- hat ein Maximalvolumen in Liter

Eine Wassermenge

- hat eine Menge pro Zeit
- hat eine Einheit wie Liter, Hektoliter oder m³ pro Stunde

## Die Anwendung soll

- Auskunft geben, ob die hineinfliessende Wassermenge gleich ist wie die herausfliessende Wassermenge.
- Eine Methode haben, welche abhängig von Zeit, Zuflussmenge und Abflussmenge berechnet, ob
  - Damm geöffnet werden muss, wenn die Wassermenge grösser ist als das Maximalvolumen.
  - Damm geschlossen werden muss, wenn die Wassermenge kleiner ist als das Minimalvolumen.
- Die Methode wird zur Simlation in einem Loop aufgerufen, wobei jede Interation einem definierbaren Zeitpunkt
  entspricht.

_Es sollen Setter-Methoden für das ändern des Zu- und Ablusses verwendet werden!_

## Aufgabe 1

Schreibe ein Programm, dass die Anforderungen auf eine objekt-orientierte Art und Weise umsetzt - d.h., dass die
Methoden immer noch funktionieren würden, auch wenn es mehrere Dämme geben würde.

Simuliere das Verhalten des Damms über eine längere Zeit. Beim Start soll die Menge im See einen zufälligen Wert
enthalten, welcher zwischen dem Minimal- und Maximalvolumen liegt. Während der Simulation sollen Zufluss und Abfluss
verändert werden, um Regen- oder Trockenperioden zu simulieren (Tip: Simulation mit Start- und Endzeit und einer Liste
mit Zeiten, wann sich Zu- und Abfluss ändern sollen, nutze LocalDateTime für die Zeiten).

Eine Methode `status()` soll ein String zurückgeben, welcher zum Zeitpunkt des Aufrufs aussagt

- welche Menge sich im See befindet
- wie gross der Zufluss ist
- wie gross der Abfluss ist
- ob der Damm offen oder geschlossen ist.

## Aufgabe 2 - Zustände speichern

(Erst nach dem Kapitel "Veränderbarkeit" lösen.)

Erweitere die `status()`-Methode so, dass bei jeder Status-Abfrage (also beim Aufruf der Methode) ein Objekt erstellt
und in einer Liste gespeichert wird. Das Objekt muss folgende Informationen enthalten:

- Zeitpunkt der Messung (LocalDateTime)
- welche Menge sich im See befindet (in Liter)
- wie gross der Zufluss ist (als Objekte eurer Klasse für die Wassermenge)
- wie gross der Abfluss ist (als Objekte eurer Klasse für die Wassermenge)
- ob der Damm offen oder geschlossen ist (Boolean).

Schreibe eine Methode, welche dir die Liste der gespeicherten Zustände zurückgibt. Gib am Ende des Programs eine Liste
auf der Konsole aus mit allen gespeicherten Zuständen.

---

Hier kannst du [zurück zur Theorie](../../../../docs/02_java/04_java-oop).
