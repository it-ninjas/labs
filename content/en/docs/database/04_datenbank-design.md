---
title: "Datenbank Design"
linkTitle: "Datenbank Design"
weight: 4
---

## Ziele
* Du weisst was Normalisierung ist und wieso sie wichtig ist
* Du kannst die ersten drei Normalformen in eigenen Worten erklären
* Du kennst den Unterschied zwischen den Begriffen ERM und ERD
* Du kennst die verschiedenen Beziehungstypen im Bereich der Kardinalität

## Normalisierung
Die Normalisierung in SQL ist ein Prozess, bei dem Datenbanktabellen in bestimmte Normalformen gebracht werden, um die
Datenintegrität und -konsistenz sicherzustellen und die Redundanz zu minimieren. Ziel ist es, die Daten effizient und
konsistent zu speichern, zu verwalten und zu abzufragen.

Es gibt verschiedene Ausmasse, in denen ein Datenbankschema gegen Anomalien (wie z.B Inkonsistenz) geschützt werden 
kann. Diese unterschiedliche Ausmasse werden in diesem Zusammenhang Normalformen genannt. In den nächsten Abschnitten, 
wirst du die erste, zweite und dritte Normalformen kennenlernen.

### Erste Normalform (1NF)
Die Erste Normalform (1NF) ist das grundlegende Konzept in der Datenbankentwicklung, das sicherstellt, dass eine Tabelle
atomare Werte enthält und keine wiederholten Gruppen von Attributen zulässt. Das Ziel der 1NF ist es, die Daten in ihre 
einfachsten, nicht weiter unterteilbaren Bestandteile zu zerlegen.

In der ersten Normalform sollte jede Zelle in einer Tabelle nur einen einzigen Wert enthalten. Mehrwertige Attribute 
oder Attribute, die wiederholte Gruppen von Werten enthalten, sind nicht erlaubt. Wenn mehrere Werte zu einem Attribut 
gehören, müssen sie in separate Spalten oder sogar in separate Tabellen ausgelagert werden.

Nun können wir ein Beispiel betrachten:

Angenommen, wir haben eine Tabelle mit Kundendaten, die den Namen, die Adresse und die Telefonnummer enthält. 
Diese Tabelle könnte folgendermassen aussehen:

| Kundennummer | Kundename | Adresse           | Telefonnummer   |
|--------------|-----------|-------------------|-----------------|
| 1            | Max       | Hauptstr. 1, 123  | 123456789       |
| 2            | Lisa      | Nebenstr. 5, 987  | 987654321       |

Nach der Normalisierung in der 1NF würde die Tabelle dann so aussehen:

| Kundennummer | Kundenname | Strasse   | Hausnummer | PLZ | Ort         | Telefonnummer |
|--------------|------------|-----------|------------|-----|-------------|---------------|
| 1            | Max        | Hauptstr. | 1          | 123 | Musterort   | 123456789     |
| 2            | Lisa       | Nebenstr. | 5          | 987 | Beispielort | 987654321     |

Zusammenfassend kann man sagen, dass die erste Normalform (1NF) darauf abzielt, Daten in ihre einfachsten atomaren Werte
zu zerlegen und keine wiederholten Gruppen von Attributen zuzulassen. Dadurch werden die Daten besser strukturiert, die 
Redundanz minimiert und die Datenintegrität verbessert.

### Zweite Normalform (2NF)
Die Zweite Normalform (2NF) zielt darauf ab, Daten so zu strukturieren, dass keine wiederholten Informationen in einer 
Tabelle vorhanden sind. Stattdessen werden die Daten aufgeteilt und in separate Tabellen organisiert, die über einen 
gemeinsamen Schlüssel verknüpft sind. Dadurch werden Daten effizienter gespeichert und logische Konsistenz 
gewährleistet.

Angenommen, wir haben eine Tabelle mit Kundendaten, die Name und Telefonnummer enthält. Zusätzlich speichern 
wir für jeden Kunden die bestellten Produkte und die jeweilige Menge in derselben Tabelle. Die Tabelle könnte also 
folgendermassen aussehen:

| Kundennummer | Kundenname | Telefonnummer | Produkt | Menge |
|--------------|------------|---------------|---------|-------|
| 1            | Max        | 123456789     | Schuhe  | 2     |
| 1            | Max        | 123456789     | Hemd    | 1     |
| 2            | Lisa       | 987654321     | Hose    | 3     |
| 2            | Lisa       | 987654321     | Jacke   | 2     |

In diesem Fall haben wir eine Mischung aus Kundendaten und Bestelldaten in einer einzigen Tabelle. Das Problem dabei 
ist, dass die Kundendaten für jedes Produkt und jede Menge wiederholt werden müssen. Wenn Max zum Beispiel 3 
verschiedene Produkte bestellt, würden seine Kundendaten dreimal wiederholt werden.

Um dieses Problem zu lösen und die Zweite Normalform (2NF) zu erreichen, müssen wir die Daten aufteilen und in separate 
Tabellen organisieren. Eine Tabelle enthält die Kundendaten und eine andere Tabelle enthält die Bestelldaten. 
Beide Tabellen werden durch einen gemeinsamen Schlüssel (Kunde) verknüpft.

**Kundentabelle:**

| Kundennummer | Kundenname | Telefonnummer |
|--------------|------------|---------------|
| 1            | Max        | 123456789     |
| 2            | Lisa       | 987654321     |

**Bestellungstabelle:**

| Kundennummer | Produkt | Menge |
|--------------|---------|-------|
| 1            | Schuhe  | 2     |
| 1            | Hemd    | 1     |
| 2            | Hose    | 3     |
| 2            | Jacke   | 2     |

Dadurch erreichen wir eine klare Trennung der Daten. Die Kundendaten müssen nur einmal gespeichert werden und werden 
über den Schlüssel (Kunde) mit den entsprechenden Bestellungen verknüpft. Das reduziert die Redundanz und sorgt für 
eine bessere Organisation der Daten.

### Dritte Normalform (3NF)
Die 3NF baut auf der zweiten Normalform (2NF) auf, indem sie weitergehende Anforderungen an 
die Strukturierung der Daten stellt.

Das Ziel der Dritten Normalform ist es, sicherzustellen, dass es in einer Datenbanktabelle keine Abhängigkeiten zwischen
Nicht-Schlüsselattributen gibt, die nicht durch den Primärschlüssel erklärt werden können. Mit anderen Worten sollen 
alle Nicht-Schlüsselattribute funktional von einem vollständigen Teil des Primärschlüssels abhängig sein und keine 
funktionalen Abhängigkeiten untereinander aufweisen.

Um die 3NF zu erreichen, müssen die Daten in mehrere Tabellen aufgeteilt werden, wobei jede Tabelle einen spezifischen 
Informationsaspekt repräsentiert. Diese Tabellen werden dann über gemeinsame Schlüssel (also über sog. Fremdschlüssel) verknüpft, um Beziehungen 
zwischen den Daten herzustellen.

Nun können wir ein Beispiel betrachten:

Wir haben eine Ausgangstabelle, die alle Informationen eines Online-Shops beinhaltet. Aktuell ist diese Tabelle noch
nicht normalisiert:

**Ausgangstabelle:**

| Kundenummer | Name | Telefonnummer | ProduktId | Produktname | Bestellmenge | Gesamtpreis |
|-------------|------|---------------|-----------|-------------|--------------|-------------|
| 1           | Max  | 123456789     | 101       | Schuhe      | 2            | 50.00       |
| 1           | Max  | 123456789     | 102       | Hemd        | 1            | 30.00       |
| 2           | Lisa | 987654321     | 103       | Hose        | 4            | 80.00       |
| 2           | Lisa | 987654321     | 104       | Jacke       | 3            | 75.00       |

Um die 3NF zu erreichen, müssen wir die Daten weiter aufteilen und in separate Tabellen organisieren.

Die Aufteilung erfolgt in drei Tabellen: "Kundentabelle", "Produkttabelle" und "Bestellungstabelle". 
Die Spalten der Tabellen könnten wie folgt aussehen:

**Kundentabelle:**

| Kundenummer | Name | Telefonnummer |
|-------------|------|---------------|
| 1           | Max  | 123456789     |
| 2           | Lisa | 987654321     |

**Produkttabelle:**

| ProduktId | Produktname | Produktpreis |
|-----------|-------------|--------------|
| 101       | Schuhe      | 25.00        |
| 102       | Hemd        | 30.00        |
| 103       | Hose        | 20.00        |
| 104       | Jacke       | 25.00        |

**Bestellungstabelle:**

| Kundenummer | ProduktId | Bestellmenge | Gesamtpreis |
|-------------|-----------|--------------|-------------|
| 1           | 101       | 2            | 50.00       |
| 1           | 102       | 1            | 30.00       |
| 2           | 103       | 4            | 80.00       |
| 2           | 104       | 3            | 75.00       |

Nach dieser Aufteilung ist bereits die zweite Normalform erreicht. Um die dritte Normalform also zu erreichen müssen wir
alle Spalten entfernen, die abhängig von Nichtschlüssel-Attributen sind. In unserem Beispiel wäre dies der Gesamtpreis 
in der Bestellungstabelle. Dieser Preis kann anhand der Bestellmenge und dem Produktpreis berechnet werden und ist 
deshalb nicht nötig. Je nach Schema kann die dritte Normalform auch negative Auswirkungen auf die Performance haben, 
da keine berechneten Werte gespeichert werden dürfen. Wenn wir die Änderung in unserem Beispiel vornehmen würde die 
Tabelle schlussendlich so aussehen:

**Bestellungstabelle:**

| Kundenummer | ProduktId | Bestellmenge |
|-------------|-----------|--------------|
| 1           | 101       | 2            |
| 1           | 102       | 1            |
| 2           | 103       | 4            |
| 2           | 104       | 3            |

Durch diese Änderung erfüllt unsere Beispiel-Datenbank die ersten drei Normalformen.

Weiter gibt es auch höhere Normalformen wie die Boyce-Codd-Normalform (BCNF) und die Vierte Normalform (4NF), aber diese sind
für den Anfang weniger relevant und komplexer zu erklären.

## Datenbankdesign
In diesem Teil schauen wird uns hauptsächlich die beiden Begriffe ERM (Entity-Relationship-Modell) und ERD
(Entity-Relationship-Diagramm) an. Wichtig ist den Unterschied der beiden zu kennen.
Ein ERM ist eine Modellierungstechnik, die zur Abbildung der Beziehungen zwischen verschiedenen Entitäten in
einem System verwendet wird. Mit Text wird versucht die Datenbank so einfach und klar wie möglich zu beschreiben, um 
später ein ERD dazu erstellen zu können. Es werden jeweils die Entitäten (Tabellen) und Beziehungen aufgefasst.
Hier ein Beispiel eines einfachen ERMs:

Entitäten:

| Entität-Name | Beschreibung                                                                                                   |
|--------------|----------------------------------------------------------------------------------------------------------------|
| Student      | Jeder Student hat eine eindeutige ID, einen Namen, ein Geburtsdatum und Kontaktdaten.                          |
| Kurs         | Jeder Kurs hat eine eindeutige ID, einen Titel, eine Anzahl von Kreditpunkten und einen zugeordneten Dozenten. |

Beziehungen:

| Beziehungs-Name | Beschreibung                                                                                                                                                                                 |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Einschreibung   | Diese Beziehung zeigt die Verbindung zwischen Studenten und Kursen an. Jede Einschreibung hat eine eindeutige ID und ist mit einem bestimmten Studenten und einem bestimmten Kurs verknüpft. |

Ein ERD ist eine grafische Darstellung eines ERM, die verwendet wird, um die Beziehungen
zwischen Entitäten und Attributen darzustellen. Es besteht aus Entitäten, Attributen und Beziehungen und bietet eine 
formale Möglichkeit, die Struktur und das Verhalten eines Systems darzustellen. In diesem Schritt wird hauptsächlich 
angeschaut, was in der Datenbank benötigt wird und so eine klare Struktur gefunden. Diese Struktur kann dann später in 
einem ERD dargestellt werden.

Es gibt viele verschiedene Zeichen-Softwares für das Erstellen von ERDs. Zu empfehlen ist [draw.io](https://draw.io), 
da es sich dabei um eine Web-Applikation handelt, welche keinen Download benötigt. Auch das spätere Diagramm wurde mit 
draw.io erstellt. Wichtig beim Erstellen sind auch die Kardinalitäten, die für die Beziehungen benötigt werden. 
Schauen wir uns diese also an.

### Kardinalität

Die Kardinalität in einem Entity-Relationship-Modell (ERM) beschreibt die Beziehung zwischen zwei Entitäten und gibt an,
wie viele Instanzen einer Entität mit einer oder mehreren Instanzen einer anderen Entität verbunden sein können. 
Es gibt verschiedene Methode, um die Kardinalität einer Beziehung zu beschreiben. Wir verwenden hauptsächlich die 
[Chen-Notation](https://de.wikipedia.org/wiki/Chen-Notation). Alternativ kann auch die 
[Martin-Notation](https://de.wikipedia.org/wiki/Martin-Notation) verwendet werden. So funktioniert die Chen-Notation:

**1:1 (1 zu 1)**
* Jede Entität der ersten Entitätsmenge steht mit genau einer Entität der zweiten Entitätsmenge in Beziehung, und 
umgekehrt.

**1:c (1 zu [0 oder 1])**
* Jede Entität der ersten Entitätsmenge kann mit höchstens einer Entität der zweiten Entitätsmenge in Beziehung stehen. 
Jede Entität der zweiten Entitätsmenge steht mit genau einer Entität der ersten Entitätsmenge in Beziehung.

**1:m (1 zu [mindestens 1])**
* Jede Entität der ersten Entitätsmenge steht mit mindestens einer Entität der zweiten Entitätsmenge in Beziehung. 
Jede Entität der zweiten Entitätsmenge steht mit genau einer Entität der ersten Entitätsmenge in Beziehung.

**1:mc (1 zu [beliebig vielen])**
* Jede Entität der ersten Entitätsmenge kann mit beliebig vielen Entitäten der zweiten Entitätsmenge in Beziehung 
stehen. Jede Entität der zweiten Entitätsmenge steht mit genau einer Entität der ersten Entitätsmenge in Beziehung.

**c:c ([1 oder 0] zu [0 oder 1])**
* Jede Entität der ersten Entitätsmenge kann mit höchstens einer Entität der zweiten Entitätsmenge in Beziehung stehen, 
und umgekehrt.

**c:m ([0 oder 1] zu [mindestens 1])**
* Jede Entität der ersten Entitätsmenge steht mit mindestens einer Entität der zweiten Entitätsmenge in Beziehung. 
Jede Entität der zweiten Entitätsmenge kann mit höchstens einer Entität der ersten Entitätsmenge in Beziehung stehen.

**c:mc ([0 oder 1] zu [beliebig vielen])**
* Jede Entität der ersten Entitätsmenge kann mit beliebig vielen Entitäten der zweiten Entitätsmenge in Beziehung 
stehen. Jede Entität der zweiten Entitätsmenge kann mit höchstens einer Entität der ersten Entitätsmenge in Beziehung 
stehen.

**m:m ([mindestens 1] zu [mindestens 1])**
* Jede Entität der ersten Entitätsmenge steht mit mindestens einer Entität der zweiten Entitätsmenge in Beziehung, 
und umgekehrt.

**m:mc ([mindestens 1] zu [beliebig vielen])**
* Jede Entität der ersten Entitätsmenge kann mit beliebig vielen Entitäten der zweiten Entitätsmenge in Beziehung 
stehen. Jede Entität der zweiten Entitätsmenge steht mit mindestens einer Entität der ersten Entitätsmenge in Beziehung.

**mc:mc ([beliebig viele] zu [beliebig vielen])**
* Jede Entität der ersten Entitätsmenge kann mit beliebig vielen Entitäten der zweiten Entitätsmenge in Beziehung 
stehen, und umgekehrt.

Wenn wir also unser Wissen in einem ERM aufzeichnen, würde das ungefähr wie in diesem Diagramm aussehen:

![Buch-ERD](../images/Buch-ERD.png)

Hier wurde eine Buchdatenbank dargestellt, die Bücher und Autoren hat.
> Hinweis: mehrere zu mehrere (m:m, mc:m, ...) benötigen normalerweise eine Zwischentabelle, da sonst keine eindeutige
> Verbindung zwischen den Tabellen hergestellt werden kann.