---
title: "SQL Syntax"
linkTitle: "SQL Syntax"
type: docs
weight: 2
---

## Übung 1
In der ersten Übung sollst du anhand eines Textes ein ERD erstellen.
Du sollst für einen Kunden ein ERD für einen Online-Shop erstellen. Der Kunde gibt dir folgende Informationen:

Der Online-Shop verfügt über Produkte, Kunden und Bestellungen. Ein Kunde kann mehrere Produkte bestellen, 
und eine Bestellung kann mehrere Produkte enthalten. Die Produkte haben Eigenschaften wie Name, Beschreibung und Preis.

Hier sind einige grundlegende Informationen, die dir helfen sollen, ein ERD für den Online-Shop zu erstellen:
1. Produkte:
   - Jedes Produkt hat eine eindeutige Produkt-ID, einen Namen, eine Beschreibung und einen Preis.
2. Kunden:
   - Jeder Kunde hat eine eindeutige Kunden-ID, einen Vornamen, einen Nachnamen, eine Adresse und eine E-Mail-Adresse.
3. Bestellungen:
    - Jede Bestellung hat eine eindeutige Bestell-ID, ein Bestelldatum und ist einem bestimmten Kunden zugeordnet.
4. Bestellpositionen:
    - Eine Bestellung kann mehrere Positionen enthalten, und jede Position ist einem bestimmten Produkt zugeordnet. 
    Eine Position enthält Informationen wie die Produktmenge.

Erstelle das ERD mithilfe von Draw.io so, dass die 3NF erreicht wird. Schaue anschliessend das fertige ERD mit einem 
Coach an, um Feedback dazu zu erhalten.

## Übung 2
Erstelle anhand dieses ERDs eine Datenbank. Verwende hierbei die deiner Meinung nach richtigen Datentypen. Die Datenbank
soll die 3NF erreichen. **Achtung!** das ERD ist nicht in der 3NF. Schau deine fertige Datenbank mit einem Coach an.

![ERD Zoo](../images/Zoo-ERD.png)


## Übung 3
In dieser Übung geht es darum, mit deinen SQL-Kenntnissen einen Mord zu lösen. Ziel ist es, dass du alle Rätsel löst und
das letzte Query mit einem Coach anschaust. Beim Lösen empfiehlt es sich Zwischenschritte aufzuschreiben, um die
Übersicht zu behalten. Falls du diese Zwischenschritte auch mit einem Coach anschauen möchtest, ist dies auch möglich.
[SQL Murder Mystery](https://mystery.knightlab.com/) 
