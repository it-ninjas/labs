---
title: "Constraints"
linkTitle: "Constraints"
weight: 3
---

## Ziele
* Du weisst wofür Constraints verwendet werden
* Du kennst die wichtigsten Constraints
* Du kannst ein Constraint erstellen

## Was ist ein Constraint?
Ein Constraint in SQL ist dazu da den Inhalt eines Attributs weiter zu beschränken. Theoretisch ist die Angabe des 
Datentyps bereits eine Art Constraint, da bestimmt wird was für ein Wertebereich eingefügt werden darf. Ein Constraint
kann entweder beim Erstellen der Tabelle oder mit einem `ALTER`-Statement hinzugefügt werden. Constraints können sich 
auf eine Tabelle oder eine einzelne Spalte beziehen. Ebenso können mehrere Constraints, sowohl bei Tabellen als auch
bei Spalten, gleichzeitig angewendet werden.

## Not Null
Das `Not Null` Constraint legt fest, dass ein Attribut nicht Null, spricht **nicht leer** sein darf. Das kann
beispielsweise bei einer Id, die zum Verbinden von Tabellen verwendet wird, eingesetzt werden, damit es immer einen Wert
gibt. Hier ein Beispiel wie ein `Not Null` Constraint erstellt wird:

```sql
CREATE TABLE person(personen_id number NOT NULL, vorname varchar(255), nachname varchar(255));
```

```sql
-- Funktioniert nicht, da die Id nicht null sein darf.
INSERT INTO person VALUES (null, null, null);

-- Funktioniert nicht, da keine Id hinzugefügt wird.
INSERT INTO person(vorname, nachname) VALUES ("Peter", "Fischer");

-- Funktioniert, da die Id angegeben wird und die anderen Attribute null sein dürfen.
INSERT INTO person VALUES (1, null, null);
```

## Unique
Das `Unique` Constraint bedingt, dass jeder eingefügte Wert einzigartig, also noch nicht in der Spalte oder in der Tabelle, vorhanden. So können
beispielsweise duplikationen von Ids verhindert werden. Hier ein Beispiel zum `Unique` Constraint:

```sql
CREATE TABLE person(personen_id number UNIQUE, vorname varchar(255), nachname varchar(255));
```

Beispieldaten Person:

| personen_id | vorname | nachname |
|-------------|---------|----------|
| 1           | Hans    | Peterson |
| 2           | Peter   | Fritschi |
| 3           | Fritz   | Hansen   |


```sql
-- Funktioniert nicht, da bereits eine Person mit der personen_id 2 besteht.
INSERT INTO person VALUES (2, "Ueli", "Mueli");

-- Funktioniert, da keine Person mit der personen_id 4 besteht.
INSERT INTO person VALUES (4, "Karl", "Karlsen");
```

## Primary Key
Das `Primary Key` Constraint kombiniert prinzipiell die Constraints `Unique` und `Not Null` zu einem. Gerade für Ids ist
dieses Constraint praktisch, da in eigentlich jedem Fall eine Id bestehen sollte und sie auch eindeutig sein sollte.
Hier ein beispiel zum `Primary Key`:

```sql
CREATE TABLE person(personen_id number PRIMARY KEY, vorname varchar(255), nachname varchar(255));
```

Beispieldaten Person:

| personen_id | vorname | nachname |
|-------------|---------|----------|
| 1           | Hans    | Peterson |
| 2           | Peter   | Fritschi |
| 3           | Fritz   | Hansen   |


```sql
-- Funktioniert nicht, da keine personen_id angegeben wurde.
INSERT INTO person VALUES (null, "Philippe", "Pfister");

-- Funktioniert nicht, da bereits eine Person mit der personen_id 2 besteht.
INSERT INTO person VALUES (2, "Ueli", "Mueli");

-- Funktioniert, da keine Person mit der personen_id 4 besteht.
INSERT INTO person VALUES (4, "Karl", "Karlsen");
```

## Foreign Key
Das `Foreign Key` Constraint stellt sicher, dass der Wert in einer Spalte einer Tabelle auf einen existierenden Wert in 
einer anderen Tabelle verweist. Das bedeutet, dass die Beziehungen zwischen den Tabellen beibehalten werden und 
Datenkonsistenz gewährleistet wird. Ein Fremdschlüssel wird durch das Verknüpfen von Spalten in verschiedenen Tabellen 
erstellt. Dazu wird im CREATE das Keyword `REFERENCES` verwendet. Dort wird angegeben, auf welche Spalte der 
Fremdschlüssel verweist. Hier ein Beispiel dazu:

```sql
CREATE TABLE adresse(id number PRIMARY KEY, strasse varchar(255), hausnummer number, plz number, ort varchar(255));

CREATE TABLE person(id number PRIMARY KEY, vorname varchar(255), nachname varchar(255), alter number, adresse_id number 
FOREIGN KEY REFERENCES adresse(id));
```
> **Info:** Die Benennung des Fremdschlüssels wurde in diesem Beispiel der Einfachheit halber nicht korrekt gemacht.
> Je nach Naming Convention im Projekt muss der Fremdschüssel anders benannt werden. Hier ein Link mit weiteren Infos:
> [Naming Conventions SQL Server](https://www.dotnettricks.com/learn/sqlserver/sql-server-naming-conventions-and-standards)

Beispiel Daten Person:

| id | vorname   | nachname  | alter | adresse_id |
|----|-----------|-----------|-------|------------|
| 1  | Christoph | Spycher   | 45    | 1          |
| 2  | Sepp      | Blatter   | 87    | 2          |
| 3  | Gianni    | Infantion | 53    | 2          |
| 4  | Nilo      | Nashorn   | 2     | 3          |


Beispiel Daten Adresse:

| id | strasse              | hausnummer | plz  | ort     |
|----|----------------------|------------|------|---------|
| 1  | Papeiermuehlestrasse | 71         | 3014 | Bern    |
| 2  | Seestrasse           | 27         | 8002 | Zuerich |
| 3  | Binningerstrasse     | 30         | 3054 | Basel   |

```sql
-- Funktioniert nicht, da in der Tabelle Adresse keine Adresse mit der Id 27 besteht.
INSERT INTO person VALUES (5, "Boris", "Biberratte", 4, 27);

-- Funktioniert, da die Id 3 in der Tabelle Adresse vergeben ist.
INSERT INTO person VALUES (5, "Hans", "Hecht", 4, 3);

-- Funktioniert, da der Foreign Key auch null sein darf.
INSERT INTO person VALUES (5, "Silvia", "Stachelschwein", 4, null);
```
