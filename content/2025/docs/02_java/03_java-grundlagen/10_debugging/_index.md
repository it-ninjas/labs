---
title: "Debugging – Fehler finden und verstehen"
linkTitle: "Debugging"
weight: 9
description: >
  Du lernst, wie du mit Debugging-Strategien und einfachen Hilfsmitteln Fehler in deinem Code findest – auch ohne IDE.
---

## Ziele

- Du verstehst, was Debugging ist und warum es wichtig ist.
- Du kannst zwischen Debugging und einfachem Logging unterscheiden.
- Du kennst verschiedene Wege, Fehler im Code zu analysieren.

## Wieso ist Debuggen wichtig?

Es gibt viele Gründe, warum Programme Fehler enthalten können – z. B. falsche Annahmen, vergessene Sonderfälle oder
unerwartete Eingaben.
Typische Fehler sind:

- falsche Berechnungen
- `NullPointerException`
- Endlosschleifen
- falsche Bedingungen (`if` falsch herum)
- Methoden werden nicht aufgerufen oder liefern falsche Werte zurück

Mittels debuggen kannst du den Fehler einkreisen und dann jede Anweisung Schritt für Schritt ausführen und prüfen, ob
die Anweisung wie erwartet Funktioniert.

### Was bringt Debuggen?

- Fehler gezielt finden, indem man den Code **Schritt für Schritt** durchläuft
- Werte von Variablen und den Kontrollfluss beobachten
- Besseres Verständnis für fremden oder komplexen Code

## Debugging vs. Logging

Viele Anfänger schreiben `System.out.println(...)`, um zu sehen, was im Code passiert. Das funktioniert, hat aber Nachteile:

- Konsolenausgaben verlangsamen das Programm
- Der Code wird unübersichtlicher
- Logs werden oft **vergessen zu entfernen** und gelangen so in Git oder sogar auf den Server

{{< ninja tip >}}
In IntelliJ kannst du stattdessen einen sogenannten **Log-Breakpoint** setzen. Das ist wie ein `System.out.println`, aber ohne den Code zu verändern.
{{< /ninja >}}

## Wie kann man debuggen – auch ohne Tool?

1. **Code genau lesen** – viele Fehler erkennt man durch genaues Nachdenken.
2. **Tests schreiben** – zeigen sofort, wenn etwas nicht stimmt.
3. **Logs schreiben** – gezielt und kontrolliert.
4. **Assertions verwenden** – helfen, Annahmen zu überprüfen.

## Debugging vs. Fehlersuche im Feld

Beim Entwickeln am eigenen Rechner kann man den Code komfortabel debuggen – z. B. mit einem Debugger wie in IntelliJ.
Im **Produktivbetrieb (im Feld)** ist das aber nicht möglich:

- Man kann keine Breakpoints setzen, weil das Programm bereits läuft.
- Man hat keinen Zugriff auf eine Entwicklungsumgebung.
- Das Verhalten darf **nicht unterbrochen** oder **verändert** werden.

### Logging im Feld

Deshalb ist **Logging** im Feld die wichtigste Methode, um Fehler zu finden:

- Man loggt gezielt Informationen (z. B. Zustände, Fehlermeldungen, Eingabewerte)
- Diese Logs werden in eine Datei oder Datenbank geschrieben und später analysiert
- Logging sollte sparsam, aber **gezielt** eingesetzt werden

{{< ninja warning >}}
Auch Logging kann das Verhalten eines Programms verändern – vor allem in zeitkritischen oder nebenläufigen Systemen. Jeder Log-Eintrag braucht Rechenzeit und kann z. B. Threads blockieren oder IO-Prozesse verlangsamen.
{{< /ninja >}}

{{< ninja tip >}}
In zeitkritischen Methoden (z. B. bei Hardware-Ansteuerung oder Animationen) sollte Logging nur mit Bedacht oder gar nicht eingesetzt werden. Stattdessen kann man Zustände puffern und später gesammelt ausgeben.
{{< /ninja >}}

Für die Java Grundlagen reichen vorderhand die Debug-Möglichkeiten aus, welche IntelliJ bietet. Das Logging werden wir
erst in einem späteren Modul einsetzen.

{{< ninja tip>}}
Auch während der Entwicklung ist es nicht falsch, den Programmfluss per Ausgabe auf die Konsole oder mittels Logging
festzuhalten. Dies Informationen liefern wertvolle Informationen, wo man mit dem Debugen effektiv beginnen soll. Vor
allem bei grösseren Programmen ist es ineffizient, das gesamte Programm bis zum Fehler Schritt für Schritt abzuarbeiten.
{{< /ninja>}}

## Nächste Schritte

Wenn du Java mit IntelliJ verwendest, solltest du das integrierte Debugging-Tool kennenlernen:

[Debugging in IntelliJ](../../../99_tools/ide/intellij/06_debugging/)

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/10_debugging/)" >}}
