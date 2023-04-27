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
Im [Lab zu Modul #J8 (JDBC)](../../java-jdbc/01_jdbc_exercises/), hast du ein persistentes Notenverwaltungssystem umgesetzt.
Zu diesem Zweck hast du eine MariaDB instanz mit folgenden Tabellen aufgesetzt:
* SCHOOL_SUBJECT
* GRADE
* SCHOOL_SUBJECT_GRADE

Mehr Details dazu findest du im obenerwähnten Lab.  
Diese Datenbank und das dazu gehörende Datenbankmodel wirst du für unsere Spring-Aufgabe benötigen.  
Bei Bedarf kannst du das Model erweitern.

## Auftrag
Die Aufgaben in diesem Lab führen dich Schritt für Schritt beim Umsetzen einer Webanwendung mit Spring Boot, welche ein Notenverwaltungssystem entspricht.
Die folgenden Abschnitte listen die grobe funktionale (was soll die Anwendung können) und die nicht funktionale (zusätzliche Anforderungen z.B. an die Qualität der Anwendung) Anforderungen an die Anwendung.
Genauere Details zu den Anforderungen wie auch die Akzeptanzkriterien werden in den entsprechenden Kapiteln aufgeführt.

### Funktionale Anforderungen
* Die Anwendung unterstützt zwei unterschiedlichen Benutzerrollen: "Student" und "Administrator"
* Eine Person mit der Rolle "Student", kann:
  * Alle Fächer und all deren Noten auflisten (ein Fach kann mehreren Noten beinhalten)
  * Alle Fächer und deren Durchschnittsnote auflisten
  * Für ein bestimmtes Fach:
    * Alle Noten und die Durchschnittsnote des Fachs auflisten
    * Eine neue Note hinzufügen
    * Eine bestehende Note ändern
    * Eine bestehende Note löschen
* Eine Person mit der Rolle "Administrator", kann (zusätzlich):
  * Alle Fächer auflisten
  * Neue Fächer hinzufügen
  * Bestehende Fächer bearbeiten
  * Bestehende Fächer löschen

### Nicht funktionale Anforderungen (NFAs)
* Die Code (das Design) der Anwendung ist nach Themen gruppiert.
* Eine Klasse hat eine einzige Aufgabe (Single Responsibility Prinzip).
* Der direkte Zugriff auf der internen Struktur einer Klasse ist verboten (Datenkapselung).
* Jede Klasse ist getestet.

## Schritt 1: Maven-Projekt erstellen / pom.xml
In diesem ersten Schritt wirst du eine Spring Boot Anwendung erstellen und ausführen.
Hier stehen dir zwei Möglichkeiten für die Umsetzung zur Verfügung:
* Die Projektstruktur manuel anzulegen (#Hard-Core-Variante)
* Die Projektstruktur mit Spring-Initializr anlegen (#Easy-Going-Variante)

Beide Möglichkeiten werden in dieser Aufgabe aufgeführt.

### Voraussetzungen (was du brauchst)
* Java 1.7 oder neuer ist installiert
* Maven 3.5 oder neuer ist installiert
* IntelliJ ist installiert und konfiguriert
* Ein Bitbucket Repository steht bereit, um den Code des Projektes zu verwalten und ist auf der lokalen Maschine geklont worden

### Variante I: Projekt manuel anlegen
#### Erstelle ein Maven-Projekt in IntelliJ
Öffne IntelliJ und erstelle ein neues Maven-Projekt (File → New → Project):
![](../assets/03_create_project_with_intellij.png)
Ersetze **GroupId**, **ArtifactId**, **Name** und **Location** durch passende Werte.

#### Passe dein pom.xml File an
Füge das "Parent" wie auch folgende Dependencies und Maven-Plugin in deinem pom.xml File hinzu:
```xml
  <!-- Parent kommt normalerweise nach der modelVersion -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.0.5</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>

  <!-- Dependencies kommen normalerweise nach den Properties -->
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <!-- Build kommen normalerweise nach den Dependencies -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
```
Lade alle Dependencies erneut (Maven-View -> Reload all maven projects).

#### Ersetze die Main Klasse mit einer SpringBootApplikation Klasse
Wenn du beim Erstellen des Projektes "add sample code" angekreuzt hast, beinhaltet dein Projekt nun eine Main-Klasse in deinem Source-Folder (im richtigen Package selbstverständlich).
Diese Main Klasse werden wir nun in einer SpringBootApplication-Klasse umwandeln:
* Nenne die Main Klasse um sodass sie *<name-deines-artefaktes>*Application heisst (z.B. wenn dein Artefakt "demo" heisst, wird die Klasse nun "DemoApplication" heissen).
* Füge die Annotation **@SpringBootApplication** auf der Klassenebene
* Passe deine **main** Methode, dass sie wie folgt aussieht (Ersetzte DemoApplication mit deinem Application-Klassennamen):
```java
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
```

Gratuliere! Du hast nun dein Projekt angelegt, und zwar Hard-Core. Bravo!
Fahre nun mit dem Schritt "Führe deine Anwendung aus" fort.

### Variante II: Projekt mit Spring-Initializr anlegen
Öffne die Seite: https://start.spring.io/ und ersetzte die Angaben zu Group, Artifact (der Name wird sich automatisch ändern) und Description durch passende Werte.  
Füge die Abhängigkeit für "Spring Web" hinzu und drücke den "GENERATE" Knopf.
![](../assets/01_spring-initializr.png)

Entpacke das heruntergeladene Zip-File in deinem Repository-Verzeichnis und öffne die Anwendung als Maven-Projekt in IntelliJ:
File → New → Project from existing sources → Zum Root-Folder des Projektes navigieren und pom.xml auswählen.

### Führe deine Anwendung aus
Öffne deine Application-Klasse (normalerweise heist sie <name-des-artefaktes>Application).
Wenn du Spring-Initializr benutzt hast, wurde diese Klasse für dich automatisch erstellt.
Starte deine Anwendung mit der Default-Run-Konfiguration.

### Akzeptanzkriterien Schritt 1
Du bist mit diesem Schritt fertig erst, wenn folgende Aussagen stimmen:
* Dein Projekt weist eine richtige Maven Projektstruktur aus:  
  ![](../assets/04_projekt_struktur.png)
* Das Projekt ist in IntelliJ richtig konfiguriert (JDK, Maven, Source-Verzeichnisse, Resource-Verzeichnisse usw.)
* Du verstehst, wozu wir die Dependencies im pom.xml File brauchen
* Eine "SpringBootApplication"-Klasse ist vorhanden, ist richtig annotiert und beinhaltet einen "main" Methode, welche die Applikation ausführen lässt. 
* Spring Boot Applikation startet fehlerfrei
* In der Run-Konsole ist eine ähnliche Ausgabe zu sehen:
  ![](../assets/02_application_success_run_console.png)
* Dein Projekt ist im vorbereiteten Bitbucket-Repository vorhanden
* Der Stand des Projektes ist im Bitbucket mit dem Tag "INITIAL_MVN_PROJEKT" versehen

## Schritt 2: Rest Schnittstelle definieren und umsetzen
In diesem Schritt geht es darum die Schnittstelle (die API) zur Anwendung zu definieren.
Über diese Schnittstelle werden Benutzer:innen die gewünschten Aktionen führen

### Code Struktur
Unsere Anwendung hat unterschiedliche Themengebiete, welche aus verschiedenen Funktionen bestehen.
Damit, du die Struktur gemäss NFA anlegen kannst, musst du zuerst die Themengebiete der Anwendung festlegen.
Ein Beispiel zu einem Themengebiet: Schulfachverwaltung (um Schulfächer zu bearbeiten oder auch aufzulisten)

**Aufgabe**  
Für jedes Themengebiet erstellst du ein Java-Package mit einem passenden Namen und fügst dein Code später entsprechend hinein.
Die Themengebiet-Packages kannst du auch weiter verfeinern, wenn dies die Lesbarkeit deines Codes verbessert.

### REST-Schnittstelle definieren
Im vorherigen Abschnitt hast du Themengebiete definiert, welche deine Anwendung abbilden.
Nun wirst du für jedes Themengebiet alle Interaktionen definieren, welche zur Verfügung gestellt werden sollen.
In anderen Worten hier geht es um die Schnittstellendefinition für deine Anwendung.

**Beispiel Schulfachverwaltung**  
Gemäss den funktionalen Anforderungen, müssen folgende Interaktionen zur Verfügung gestellt werden:
* Alle Fächer auflisten
* Neue Fächer hinzufügen
* Bestehende Fächer bearbeiten
* Bestehende Fächer löschen

Die entsprechende Schnittstelle könnte entsprechend so aussehen:

| Beschreibung                | Http-Methode | URL                  | Request-Body Beispiel      | Path-Variable | Response-Body Beispiel                                       |
|-----------------------------|--------------|----------------------|----------------------------|---------------|--------------------------------------------------------------|
| Alle Fächer auflisten       | GET          | /admin/subjects      |                            | keine         | [ {"id": 1, "name": "Deutsch"}, {"id": 2, "name": "Franz"} ] |
| Neues Fach hinzufügen       | POST         | /admin/subjects      | {"name": "Physik"}         | keine         | {"id": 3, "name": "Physik"}                                  |
| Bestehendes Fach bearbeiten | PUT          | /admin/subjects/{id} | {"name": "Physik-Renamed"} | id            | {"id": 3, "name": "Physik-Renamed"}                          |
| Bestehendes Fach löschen    | DELETE       | /admin/subjects/{id} |                            | id            |                                                              |

Dort wo ein Request-Body und/oder ein Response-Body benötigt wird, wird mit JSON-Objekte gearbeitet.
Diese JSON-Objekte werden wir im nächsten Abschnitt verwenden, um die Resource-Representation Klassen zu erzeugen.

**Aufgabe**  
Erstelle nun so eine Tabelle für die restlichen Capabilities und deren Funktionen.
Damit wird die Gesamtschnittstelle für deine Anwendung abgebildet.

### Resource-Representation Klassen erstellen
Bei der Schnittstellendefinition haben wir JSON-Objekte beim Request- und beim Response- Body verwendet.
Diese JSON-Objekte stellen Resource dar.
Im Beispiel der Fachverwaltung-Capabilities stellen die JSON-Objekte ein Schulfach (Subject) dar.

In diesem Abschnitt werden wir für alle JSON-Objekte Java-Klassen erstellen. Das sind sog. Resource-Representation Klassen.
In unserer Anwendung werden wir die Resource-Representation Klassen als sog. DTOs (Data Transfer Objects) umsetzen.
Diese Klassen werden wir später in unseren Controller verwenden.

**Beispiel Schulfachverwaltung**  
Das folgende JSON-Objekt stellt ein Schulfach dar:
```json
{
  "id": 1,
  "name": "Deutsch"
}
```
Daraus können wir unsere DTO-Klasse erstellen (for erst nur mit Feldern und noch keine weitere Funktionalität):
```java
public class SubjectDto {
    private final Long id;
    private final String name;
}
```

**Aufgabe**  
Erstelle nun für jedes JSON-Objekt aus dem vorherigen Abschnitt eine DTO-Klasse.
Denke daran, die Klassen in den richtigen Packages zu setzen.

### Controller erstellen
In Spring werden HTTP Requests von REST-Services von Controllers behandelt.
Das ist eine Java-Klasse, welche mit @RestController annotiert wird.
Die Controller sind die Umsetzung unserer Schnittstellendefinition.
Da wir noch keine persistierten Daten haben, werden wir vorerst Mockdaten aus den Schnittstellenmethoden liefern müssen. 

**Beispiel Schulfachverwaltung**
```java
@RestController
@RequestMapping("admin")
public class SubjectAdminController {

  @GetMapping("/subjects")
  public List<SubjectDto> getAllSubjects() {
    // TODO: Das sind Mockdaten und sollten zu einem späteren mit "echtem" Code ersetzt werden
    return List.of(new SubjectDto(1, "Deutsch"), new SubjectDto(2, "Franz"));
  }

  @PostMapping("/subjects")
  public SubjectDto createNewSubject(@RequestBody SubjectDto newSubject) {
    // TODO: Das sind Mockdaten und sollten zu einem späteren mit "echtem" Code ersetzt werden
    return new SubjectDto(3, "Physik");
  }

  @PutMapping("/subjects/{id}")
  public SubjectDto renameSubject(@RequestBody SubjectDto renamedSubject, @PathVariable Long id) {
    // TODO: Das sind Mockdaten und sollten zu einem späteren mit "echtem" Code ersetzt werden
    return new SubjectDto(3, "Physik-Renamed");
  }

  @DeleteMapping("/subjects/{id}")
  public SubjectDto deleteSubject(@PathVariable Long id) {
    // TODO: Das sind Mockdaten und sollten zu einem späteren mit "echtem" Code ersetzt werden
    return "Subject with id 3 was deleted";
  }
}
```

**Aufgabe**  
Erstelle nun die restlichen Controller und deren Methoden (mit Mockdaten) um die Umsetzung deiner Schnittstelle abzuschliessen.

### Akzeptanzkriterien Schritt 2
* Die REST Schnittstelle ist für jede Funktion definiert
* Es existiert ein Controller per Capability, welche die zur Verfügung gestellten Interaktionen beinhaltet
* Jede API-Methode, welche Wert liefert, schreibt diesen Wert direkt in dem Response-Body (RestController)
* Die API-Methoden sind "RESTful" (siehe [HTTP Methods in RESTful Web Services](https://www.javadevjournal.com/spring/restful-methods/))
* Die API-Methoden, welche Wert(e) liefern, liefern Mockdaten zurück
* Mit Postman oder mit dem HTTP-Browser kann auf jede API-Methode zugegriffen werden
* Für jede API-Methode wurden passende Tests geschrieben und erfolgreich ausgeführt


## Service-Layer umsetzen (Claudio)
DI
Services anlegen
Mock-Daten in Service verschieben
Akzeptanzkriterium: Zugriff mit Postman oder Browser / Unit-Tests umgesetzt

## Persistenz-Layer anlegen (Claudio)
Repos anlegen
Mock-Daten in Repository verschieben
Akzeptanzkriterium: Zugriff mit Postman oder Browser

## Konfiguration anlegen (Claudio)
application.yml mit DB-Konfiguration
Akzeptanzkriterium: Spring Boot Applikation startet mit DB

## Profile anlegen (Smadar)
Admin-Rolle mit zusätzlicher Schnittstelle
Neues Fach hinzufügen

## Persistenz-Layer fertigstellen (Claudio)
Queries schreiben
RowMapper oder ResultSetExtractor umsetzen
Verschiedene Arten von Queries umsetzen (JPQL, Native)

## API testen (Smadar)
Postman
Postman-Collections
IntelliJ HTTP Client

## Integrationstests mit H2 umsetzen (Claudio)
Schema.sql
Data.sql
MockMVC
