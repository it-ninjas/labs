---
title: "Spring und Spring Boot - Aufgaben"
linkTitle: "Spring und Spring Boot - Aufgaben"
type: docs
weight: 1
description: >
  Umsetzung einer Spring Boot Applikation für die Notenverwaltung aus Modul #J8
---

# Aufträge

## Voraussetzungen (Smadar -> Ready for Review)
Im [Lab zu Modul #J8 (JDBC)](../../java-jdbc/01_jdbc_exercises/), hast du ein persistentes Notenverwaltungssystem umgesetzt.
Zu diesem Zweck hast du eine MariaDB instanz mit folgenden Tabellen aufgesetzt:
* SCHOOL_SUBJECT
* GRADE
* SCHOOL_SUBJECT_GRADE

Mehr Details dazu findest du im obenerwähnten Lab.  
Diese Datenbank und das dazu gehörende Datenbankmodel wirst du für unsere Spring-Aufgabe benötigen.  
Bei Bedarf kannst du das Model erweitern.

## Auftrag (Smadar -> Ready for Review)
Die Aufgaben in diesem Lab führen dich Schritt für Schritt beim Umsetzen einer Webanwendung mit Spring Boot, welche ein Notenverwaltungssystem entspricht.
Am Ende dieses Auftrags wird deine Webanwendung zwei Rollen von Benutzern unterstützen:
* "Anwender"
* "Administrator"

Ein/Eine Anwender:in kann Information zu seiner/ihrer Fächer und Noten anschauen und in jedem Fach die Noten verwalten (hinzufügen, bearbeiten, löschen).
Ein/Eine Administrator:in kann zusätzlich die Fächer bearbeiten (hinzufügen, bearbeiten, löschen).
Die genauen Anforderungen und Akzeptanzkriterien werden in den nächsten Kapiteln detailliert aufgeführt. 


## Schritt 1: Maven-Projekt erstellen / pom.xml (Smadar -> Ready for Review)
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

### Akzeptanzkriterien:
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

## Schritt 2: API definieren und umsetzen (Smadar)
DTOs definieren
Controller
URLs / REST
Mock-Daten anlegen
Akzeptanzkriterium: Zugriff mit Postman oder Browser

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
