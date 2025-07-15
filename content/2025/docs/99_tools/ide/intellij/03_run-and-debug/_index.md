---
title: "Mit IntelliJ Java Code kompilieren, ausführen und debuggen"
linkTitle: "Kompilieren, Ausführen und Debuggen"
weight: 3
description: >
  Wie kann ich meinen erstellten Java-Code kompilieren, ausführen und debuggen.
---

## Ziele

- Du kannst deinen Java-Code in IntelliJ ausführen
- Du verstehst, wie du Breakpoints setzt und deinen Code debuggen kannst
- Du lernst die wichtigsten Shortcuts und Funktionen für das Entwickeln mit IntelliJ kennen

---

{{< ninja type="tip" >}}
Um erste Erfahrungen mit IntelliJ zu machen, kannst Du das
{{<lablink "[Hello World Beispiel](../../../../../labs/02_Java/03_java-grundlagen/00_Einfaches-Hello-World/)">}}
von it-ninjas verwenden.
{{< /ninja >}}

## Java-Programm ausführen

Sobald dein Java-Programm eine `main`-Methode enthält, kannst du es direkt starten:

1. Öffne die Datei mit der `main`-Methode.
2. Klicke links neben die Zeilennummer (dort erscheint ein grünes Dreieck).
3. Wähle **Run 'Dateiname.main()'** aus.

Alternativ kannst du über das Menü oben auf den **Play-Button** klicken oder `Shift + F10` drücken.

{{< ninja type="tip" >}}
Du kannst mehrere Run-Konfigurationen definieren – zum Beispiel für verschiedene Klassen oder Tests.
{{< /ninja >}}

---

## Projekt kompilieren

IntelliJ kompiliert deinen Code automatisch im Hintergrund, sobald du speicherst.  
Manuelles Kompilieren geht so:

- Über das Menü: `Build → Build Project`
- Tastenkürzel: `Ctrl + F9`

Wenn du Fehler machst, werden sie sofort hervorgehoben – das spart dir viel Zeit.

---

## Debugging in IntelliJ

Fehler finden geht einfacher, wenn du den Debugger verwendest.

### Breakpoint setzen

1. Klicke links neben eine Zeilennummer → roter Punkt erscheint.
2. Starte das Programm im Debug-Modus: `Shift + F9` oder Rechtsklick auf das grüne Dreieck → **Debug '...'**.

### Debugger-Ansicht

Sobald der Code anhält:

- Du siehst aktuelle Variablen und deren Werte
- Du kannst mit den Buttons **Step Over**, **Step Into** oder **Resume** den Code durchgehen

{{< ninja type="info" >}}
Im Debug-Fenster kannst du sogar Variablen ändern oder Ausdrücke live auswerten – perfekt zum Testen von Vermutungen!
{{< /ninja >}}

---

## Häufige Shortcuts

| Aktion                      | Shortcut      |
| --------------------------- | ------------- |
| Programm ausführen          | `Shift + F10` |
| Debug starten               | `Shift + F9`  |
| Projekt kompilieren         | `Ctrl + F9`   |
| Nächste Zeile (Debug)       | `F8`          |
| In Methode springen (Debug) | `F7`          |

---

## Fazit

IntelliJ unterstützt dich bei jedem Schritt – vom ersten Ausführen bis zum systematischen Debugging.  
Mit ein paar Handgriffen kannst du effizient Fehler finden und verstehen, wie dein Programm wirklich funktioniert.

{{< ninja type="tip" >}}
Nutze den Debugger regelmässig – das verbessert nicht nur deinen Code, sondern auch dein Verständnis für Programmabläufe.
{{< /ninja >}}
