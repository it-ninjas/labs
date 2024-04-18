---
title: "Spring und Spring Boot - Aufgaben"
linkTitle: "Spring und Spring Boot - Aufgaben"
type: docs
weight: 1
description: >
  Umsetzung einer Spring Boot Applikation für die Notenverwaltung aus Modul #J8
---

# Aufträge

## Voraussetzungen
Im [Lab zu Modul #J8 (JDBC)](../../java-jdbc/01_jdbc_exercises/) hast du ein persistentes Notenverwaltungssystem umgesetzt.
Zu diesem Zweck hast du eine MariaDB-Instanz mit folgenden Tabellen aufgesetzt:
* SCHOOL_SUBJECT
* GRADE
* SCHOOL_SUBJECT_GRADE

Mehr Details dazu findest du im obenerwähnten Lab. Diese Datenbank und das dazu gehörende Datenbankmodel wirst du für unsere Spring-Aufgabe benötigen.  
Bei Bedarf kannst du das Model erweitern.

## Auftrag
Die Aufgaben in diesem Lab führen dich Schritt für Schritt durch die Umsetzung einer Webanwendung mit Spring Boot, welche einem Notenverwaltungssystem entspricht.
Die folgenden Abschnitte listen die groben Funktionalen (was soll die Anwendung können) und die nicht-funktionalen (zusätzliche Anforderungen z.B. an die Qualität der Anwendung) Anforderungen an die Anwendung auf.
Genauere Details zu den Anforderungen und den Akzeptanzkriterien werden in den entsprechenden Kapiteln aufgeführt.

### Funktionale Anforderungen
* Die Anwendung unterstützt zwei unterschiedliche Profile: "student" und "admin"
* Wenn die Anwendung mit dem Profil "student" gestartet wird, stehen die folgenden Funktionalitäten zur Verfügung:
  * Alle Fächer und all deren Noten auflisten (ein Fach kann mehreren Noten beinhalten)
  * Alle Fächer und deren Durchschnittsnote auflisten
  * Für ein bestimmtes Fach:
    * Alle Noten und die Durchschnittsnote des Fachs auflisten
    * Eine neue Note hinzufügen
    * Eine bestehende Note ändern
    * Eine bestehende Note löschen
* Wenn die Anwendung mit dem Profil "admin" gestartet wird, stehen zusätzlich auch folgende Funktionalitäten zur Verfügung:
  * Alle Fächer auflisten
  * Neue Fächer hinzufügen
  * Bestehende Fächer bearbeiten
  * Bestehende Fächer löschen
* Die Anwendung bietet die Möglichkeit abzufragen, welches Profil gestartet ist.

### Nicht funktionale Anforderungen (NFAs)
* Der Code (das Design) der Anwendung ist sinnvoll in entsprechenden Packages aufgesplittet.
* Eine Klasse hat eine einzige Aufgabe (Single Responsibility Principle).
* Direkter Zugriff auf der internen Struktur einer Klasse ist verboten (Encapsulation / Information Hiding).
* Jede Klasse ist getestet.

## Schritt 1: Maven-Projekt erstellen / pom.xml

---

### Akzeptanzkriterien Schritt 1
* Es besteht eine leere Spring Boot Applikation
* Die Applikation ist lauffähig

## Schritt 2: Rest Schnittstellen definieren und umsetzen
In diesem Schritt geht es darum die Schnittstellen (die API) zur Anwendung zu definieren.
Über diese Schnittstellen können die Benutzer:innen die gewünschten Aktionen ausführen

### System-Design erstellen und Code Struktur anlegen
Damit, du den Code gemäss den nicht-funktionalen Anforderungen (NFA) aufbauen kannst, überlege dir zuerst, wie du deine Anwendung zerlegen möchtest.  
Dazu kannst du die Schritte der Methodik "functional decomposition" anwenden (mehr Information zur Methode findest du [in diesem Artikel](https://www.baeldung.com/cs/functional-decomposition)).  
Bei der Zerlegung des Systems beachte auch Prinzipien wie Kohäsion (starke Kohäsion ist gewünscht) und Kopplung (lose Kopplung sollte das Ziel sein). 

**Aufgabe**  
Sobald du die Zerlegung deiner Anwendung gemacht hast, kannst du die passende Java-Packages erstellen, welche diese Zerlegung dann abbildet.
Dein Code fügst du später an den richtigen Stellen hinzu.

### REST-Schnittstelle definieren
Die Struktur für deine Anwendung steht. Nun definierst du die Schnittstellen, womit die Benutzer:innen mit der Anwendung interagieren werden.
Die nötige Funktionalität entnimmst du aus den funktionalen Anforderungen.

**Beispiel: Anforderung - ein neues Schulfach hinzufügen**

Die entsprechende Schnittstelle könnte entsprechend so aussehen:

| Beschreibung               | Http-Methode | URL                 | Request-Body Beispiel      | Path-Variable | Response-Body Beispiel                                       |
|----------------------------|--------------|---------------------|----------------------------|---------------|--------------------------------------------------------------|
| Neues Schulfach hinzufügen | POST         | /admin/schulfaecher | {"name": "Physik"}         | keine         | {"id": 3, "name": "Physik"}                                  |

Dort wo ein Request-Body und/oder ein Response-Body benötigt wird, wird mit JSON-Objekten gearbeitet.
Diese JSON-Objekte werden wir im nächsten Abschnitt verwenden, um die Resource-Representation Klassen zu erzeugen.

---

**Aufgabe**  
Erweitere die obige Tabelle mit den restlichen Funktionen gemäss den funktionalen Anforderungen.
Buche sobald du fertig bist ein Review mit einem Coach, damit spätere Fehler vermieden werden.

---

**Wichtig** Endpunkt für Profil:
Vergiss nicht das du noch einen Endpunkt erstellen musst, um herauszufinden, mit welchem Profil die Anwendung gestartet wurde.

### Akzeptanzkriterien Schritt 2
* Ein grobes System-Design ist vorhanden (z.B. mit der Hilfe des Functional-Decomposition-Diagramm).
* Die Codestruktur entspricht dem Design.
* Die REST Schnittstellen sind für jede relevante Funktion (gemäss funktionalen Anforderungen) dokumentiert und mit Controllern umgesetzt.
* Bei jeder REST Schnittstelle ist markiert, welches Profil diese verwenden kann.
* Jede API-Methode, welche einen Wert liefert, schreibt diesen Wert direkt in den Response-Body (RestController)
* Die API-Methoden sind "RESTful" (siehe [HTTP Methods in RESTful Web Services](https://www.javadevjournal.com/spring/restful-methods/))
* Die API-Methoden, welche einen Wert liefern, liefern zurzeit Mockdaten zurück (alle Aufrufe einer Methode liefern immer die gleiche Mockdaten zurück)
* Mit Insomnia oder mit dem HTTP-Browser kann auf jede API-Methode zugegriffen werden
* Für jede API-Methode wurden passende Unit-Tests geschrieben und erfolgreich ausgeführt

## Schritt 3: Datenbank-Verbindung herstellen

---

### Akzeptanzkriterien Schritt 3
* Dependency wurde im `pom.xml` hinzugefügt.
* Alle nötigen Entities wurden erstellt.
* Alle benötigten Repositories wurden erstellt und in einen Ordner für alle Repositories abgelegt.

## Schritt 4: Services anlegen

---

### Akzeptanzkriterien Schritt 4
* Die Services verwenden die Methoden aus den Repositories 
* Die Service-Klassen sind nach Thema aufgebaut

## Schritt 5: Controller anlegen

---

### Akzeptanzkriterien Schritt 5
* Die Controller-Klassen sind nach Thema aufgebaut
* Sämtliche Anfragen der Controller (Requests) wurden an die Service-Klassen und deren Methoden weitergeleitet
* Die Controller- und Service-Klassen sind mittels Constructor-Injection miteinander verbunden


## Schritt 6: Profile anlegen
In diesem Schritt erstellst du die gewünschten Spring Boot Profile: "student" und "admin".
Diese Profile werden benutzt, um die verfügbare Funktionalität einzuschränken bzw. zu erweitern.
Welche Funktionalität mit welchem Profil zur Verfügung stehen darf, entnimmst du deiner Endpunktplanung.

Mit der *@Profile* Annotation, kannst du bestimmte Beans für das gegebene Profil aktivieren bzw. deaktivieren.

---

**Aufgabe**  
Aktiviere bzw. deaktiviere die Schnittstellen-Funktionalität entsprechend dem aktiven Profil

---

### Akzeptanzkriterien Schritt 6
* Wenn die Anwendung mit dem Profil "student" gestartet wird, darf die Admin-Funktionalität nicht zur Verfügung stehen. Direkter Zugriff auf Admin-URLs liefert den HTTP Status-Code: 404 (Not Found)
* Wenn die Anwendung mit dem Profil "admin" gestartet wird, steht die gesamte Funktionalität zur Verfügung.
* Wenn die Anwendung mit dem Default-Profil gestartet wird, muss sie sich genauso verhalten, wie mit dem "student" Profil.

## Schritt 7 Business-Logik- und Persistenz-Layer anpassen

[//]: # (TODO Entfernen?)

---

### Akzeptanzkriterien Schritt 7
* Alle Services sind mit der Implementierungs-Methode ausgestattet.
* Alle Repositories sind mit der Implementierungs-Methode ausgestattet


## Schritt 8: API testen

---

### Integrationstests mit H2 umsetzen
Integrationstests mit H2 in einem Spring-Boot-Projekt umzusetzen ist eine bewährte Methode, um die Interaktion zwischen verschiedenen Komponenten einer Anwendung zu testen, ohne auf eine reale Datenbank angewiesen zu sein. 
In diesem Kontext dient H2, eine In-Memory-Datenbank, als Ersatz für die eigentliche Datenbank und erlaubt es, Tests zu schreiben, welche die Anwendungslogik unter simulierten Bedingungen überprüft.

### Akzeptanzkriterien Schritt 8
* Eine HTTP-Request Datei liegt vor, welche alle öffentlichen Schnittstellen-Methoden ausführen kann.
* Bei Methoden, welche Parameter oder einen Request-Body brauchen, sind diese in den Requests auch so konfiguriert.
* Jede Methode, welche ausgeführt wird, liefert die erwarteten Ergebnisse (ggf. auch Anpassungen der Daten in der darunterliegenden Datenbank).

