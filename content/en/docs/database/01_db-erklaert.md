---
title: "Datenbank 101"
linkTitle: "Datenbank 101"
weight: 1
---

## Ziele
* Du kennst den allgemeinen Aufbau einer Datenbank und kannst ihn erklären
* Du kennst den Unterschied zwischen raltionalen und No-SQL Datenbanken
* Du weisst wann welcher Datenbank-typ sinn macht
* Du kennst die wichtigsten Datentypen und ihren Nutzen

## Was ist eine Datenbank?
Eine Datenbank ist ein System zur elektronischen Verwaltung von Daten.
Grundsätzlich sagt der Name "Datenbank" bereits was sie ist: In einer Datenbank werden Daten in einer bestimmten Ordnung abgelegt.
Ähnlich wie bei einer normalen Bank werden die Daten an einem klar definierten Ort abgespeichert.
Fast so wie bei deinem Bankkonto, wo jeweils der Lohn eingezahlt wird.

Eine Datenbank ist meist in Stufen aufgebaut, die wie folgt aussehen können:

Zu oberst ist die Datenbank an sich. Sie ist eigentlich das Gebäude der Bank wo schlussendlich die Infrastruktur,
sowie das Geld zu finden ist.

Die nächste Stufe ist das Schema. Dieses ist mit einem Raum zu vergleichen, der viele verschiedene
Aktenschränke beinhaltet.

Diese Aktenschränke wären in einer Datenbank die Tabellen. Die Tabellen beinhalten schlussendlich
die verschiedenen Daten, wie zum Beispiel dein erwähntes Bankkonto mit deinem Kontostand.

Schlussendlich sieht der Aufbau also so aus: 

![](../images/Beispiel_Bank.png)

### Schema und Tabelle
Ein Schema ist eine strukturierte Art und Weise, wie Daten organisiert werden. Es legt fest, wie die Datenbank aufgebaut
ist und wie die Daten gespeichert und abgerufen werden können. Eine Tabelle ist ein Tabellenblatt mit Spalten und
Zeilen, in dem die eigentlichen Daten gespeichert werden. Schemata und Tabellen helfen dabei, Daten organisiert und
leicht zugänglich zu halten. Sie ermöglichen es uns, Daten effizient abzufragen, zu aktualisieren und zu verwalten.
Schemata und Tabellen sind auch wichtig, um die Sicherheit und Integrität der Daten zu gewährleisten, indem sie
Zugriffsrechte und Einschränkungen festlegen.

## Arten von Datenbanken
In diesem Kapitel soll ein kleiner Überblick der verschiedenen Arten von Datenbanken und deren 
Vor- und Nachteile geklärt werden.

Die am meisten verwendeten Datenbank Arten sind Relationale *(SQL)* und NO-SQL Datenbanken.
Relationale *(SQL)* Datenbanken werden klar am häufigsten eingesetzt und sind auch am bekanntesten
> Bei den Übungen, sowie Exams werden ausschliesslich Relationale *(SQL)* Datenbanken verwendet.

### Relational *(SQL)*
Relationale Datenbanken sind ähnlich wie Excel Tabellen aufgebaut. Der Name kommt vom Konzept der Relationen (Tabellen)
, die es ermöglichen, Daten logisch und strukturiert zu speichern und abzurufen. Sie verwenden Tabellen, die jeweils 
Zeilen und Spalten beinhalten *(auch Rows und Columns genannt)*. Pro Spalte *(Column)*, auch **Attribut** genannt, 
muss ein Datentyp festgelegt werden. Dieser Datentyp definiert, welche Art von Daten in dieser Spalte gespeichert 
werden kann. Beispiel: Eine Spalte mit dem Namen "Alter" hat einen nummerischen Datentyp. Also können
ausschliesslich Zahlen in dieser Spalte eingegeben werden. 

Eine Zeile *(Row)*, auch **Tupel** genannt, beinhaltet jeweils einen ganzen Datensatz, wie beispielsweise alle 
Benutzerdaten.

![](../images/Begriffe_relationaler_Datenbanken.png)

*Quelle: https://de.wikipedia.org/wiki/Datenbanktabelle*

### NO-SQL
Im Gegensatz zu relationalen Datenbanken speichern NoSQL-Datenbanken Daten in Formaten wie Dokumenten, 
Schlüssel-Wert-Paaren, Spalten oder Graphen. Dies ermöglicht es, unstrukturierte Daten effektiver zu speichern und 
abzurufen. Außerdem sind NoSQL-Datenbanken horizontal skalierbar, was bedeutet, dass sie auf mehrere Server verteilt 
werden können, um die Leistung zu verbessern und die Belastung auf mehrere Maschinen zu verteilen.

Wie erklärt gibt es viele verschiedene Ansätze bei NO-SQL, deshalb gibt es auch keine gemeinsame Syntax wie es sie bei
SQL gibt. Bei den verschiedenen Anbietern kann also die Verwendung sehr unterscheiden. Auch wegen der verschiedenen 
Speicherarten ist keine NO-SQL Datenbank wie die andere.

![](../images/NoSQLDatabases.jpg)

*Quelle: https://www.geeksforgeeks.org/types-of-nosql-databases/*

### Wann verwende ich welche Datenbank?
Eine relationale Datenbank eignet sich gut für Anwendungsfälle, bei denen eine komplexe Datenstruktur mit starken
Beziehungen zwischen den Daten besteht, z. B. in Unternehmenssystemen oder Finanzanwendungen, da sie eine konsistente
und sichere Datenhaltung gewährleistet.

NoSQL-Datenbanken sind nützlich, wenn Flexibilität und Skalierbarkeit Priorität haben und wenn die Datenstruktur häufig
geändert werden muss oder es viele unstrukturierte oder semistrukturierte Daten gibt, wie beispielsweise in Big
Data-Anwendungen, sozialen Netzwerken oder Echtzeit-Analysen.

## Datentypen
In diesem Teil werden kurz die wichtigsten Datentypen aufgelistet. Je nach Datenbank können die Namen der Datentypen
abweichen, sollten jedoch von der Funktionalität gleich sein. In dieser Auflistung wurden die PostgreSQL Datentypen
verwendet:

| Typ-Name   | Beschreibung                                                                                                            | Beispiel              |
|------------|-------------------------------------------------------------------------------------------------------------------------|-----------------------|
| INTEGER    | Ganze Zahlen ohne Nachkommastellen im Bereich von -2.147.483.648 bis 2.147.483.647.                                     | 123                   |
| NUMERIC    | Genaue Dezimalzahlen mit beliebiger Anzahl von Dezimalstellen, häufig in der Finanz- und Buchhaltungsbranche verwendet. | 1234.567              |
| CHAR(n)    | Zeichenkette mit fester Länge von n Zeichen, aufgefüllt mit Leerzeichen, falls kürzer.                                  | 'ABC'                 |
| VARCHAR(n) | Zeichenkette mit variabler Länge bis maximal n Zeichen.                                                                 | 'OpenAI'              |
| DATE       | Datumsangaben im Bereich zwischen 4713 v. Chr. und 5874897 n. Chr.                                                      | '2023-05-31'          |
| TIME       | Zeitwerte im Bereich zwischen 00:00:00 und 24:00:00.                                                                    | '14:30:00'            |
| TIMESTAMP  | Datum und Uhrzeit kombiniert, häufig für Zeitstempel in Anwendungen verwendet.                                          | '2023-05-31 14:30:00' |
| BOOLEAN    | Wahrheitswerte (TRUE oder FALSE), oft für Ja/Nein-Entscheidungen verwendet.                                             | TRUE                  |


Wenn du noch mehr über die einzelnen Datentypen erfahren möchtest, findest du unter diesem Link alle verfügbaren
Datentypen in PostgreSQL: [Liste aller Datentypen (PostgreSQL)](https://www.postgresql.org/docs/current/datatype.html#:~:text=The%20following%20types%20(or%20spellings,without%20time%20zone)%2C%20xml%20.)

