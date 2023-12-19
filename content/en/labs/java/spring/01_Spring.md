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
In diesem ersten Schritt wirst du eine Spring Boot Anwendung erstellen und ausführen.
Hier stehen dir zwei Möglichkeiten für die Umsetzung zur Verfügung:
* Die Projektstruktur manuell anzulegen (#Hard-Core-Variante)
* Die Projektstruktur mit Spring-Initializr anlegen (#Easy-Going-Variante)

Beide Möglichkeiten werden in dieser Aufgabe aufgeführt.

### Voraussetzungen (was du brauchst)
* Java 20 oder neuer ist installiert.
* Maven 3.5 oder neuer ist installiert.
* IntelliJ ist installiert und konfiguriert.
* Ein Bitbucket Repository steht bereit, um den Code des Projektes zu verwalten und ist auf der lokalen Maschine geklont worden.

### Variante I: Projekt manuell anlegen
#### Erstelle ein Maven-Projekt in IntelliJ
Öffne IntelliJ und erstelle ein neues Maven-Projekt (File → New → Project):
![](../assets/03_create_project_with_intellij.png)
Ersetze **GroupId**, **ArtifactId**, **Name** und **Location** durch passende Werte.

#### Passe dein pom.xml File an
Füge den "Parent" und folgende Dependencies und Maven-Plugins in deine pom.xml Datei hinzu:
```xml
  <!-- Parent kommt normalerweise nach der modelVersion -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
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
* Benenne die Main Klasse um, so dass sie <*name-deines-artefaktes*>Application heisst (z.B. wenn dein Artefakt "demo" heisst, wird die Klasse nun "DemoApplication" heissen).
* Füge die Annotation **@SpringBootApplication** auf der Klassenebene hinzu
* Passe deine **main** Methode an, so dass sie wie folgt aussieht (Ersetzte DemoApplication mit deinem Application-Klassennamen):
```java
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
```

Gratuliere! Du hast nun dein Projekt angelegt, und zwar Hard-Core. Bravo!
Fahre nun mit dem Schritt "Führe deine Anwendung aus" fort.

### Variante II: Projekt mit Spring-Initializr anlegen
Öffne die Seite: https://start.spring.io/ und ersetzte die Angaben zu Group, Artifact (der Name wird sich automatisch ändern) und Description durch passende Werte. 
Achte das bei Project "Maven" ausgewählt ist und nicht Gradle.
Füge die Abhängigkeit für "Spring Web" hinzu und drücke den "GENERATE" Knopf.
![](../assets/01_spring-initializr.png)

Entpacke das heruntergeladene Zip-File in deinem Repository-Verzeichnis und öffne die Anwendung als Maven-Projekt in IntelliJ:
File → New → Project from existing sources → Zum Root-Folder des Projektes navigieren und pom.xml auswählen.

### Führe deine Anwendung aus
Öffne deine Application-Klasse (normalerweise heist sie <name-des-artefaktes>Application).
Wenn du Spring-Initializr benutzt hast, wurde diese Klasse für dich automatisch erstellt.
Starte deine Anwendung mit der Default-Run-Konfiguration. Zu diesem Zweck kannst du die Application-Klasse öffnen und die Main-Methode ausführen.

### Akzeptanzkriterien Schritt 1
Du bist mit diesem Schritt fertig erst, wenn folgende Aussagen stimmen:
* Dein Projekt weist eine richtige Maven Projektstruktur aus:  
  ![](../assets/04_projekt_struktur.png)
* Das Projekt ist in IntelliJ richtig konfiguriert (JDK, Maven, Source-Verzeichnisse, Resource-Verzeichnisse usw.)
* Du verstehst, wozu wir die Dependencies im pom.xml File brauchen
* Eine "SpringBootApplication"-Klasse ist vorhanden, ist richtig annotiert und beinhaltet eine "main" Methode, welche die Applikation ausführt. 
* Spring Boot Applikation startet fehlerfrei
* In der Run-Konsole ist eine ähnliche Ausgabe zu sehen:
  ![](../assets/02_application_success_run_console.png)
* Dein Projekt ist im vorbereiteten Bitbucket-Repository vorhanden

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

### Resource-Representation Klassen erstellen
Unsere Schnittstellendefinition verwendet JSON-Objekte bei bestimmten Requests und Responses.
Diese JSON-Objekte stellen sog. "Resource" dar.
Im Beispiel "Neues Schulfach hinzufügen" stellt das JSON-Objekt ein Schulfach dar.

In diesem Abschnitt wirst du für alle JSON-Objekte entsprechende Java-Klassen erstellen. 
Das sind sogenannte Resource-Representation Klassen, auch Modelle genannt.  
In unserer Anwendung werden wir die Resource-Representation Klassen als sog. DTOs (Data Transfer Objects) umsetzen.
Diese Klassen wirst du später in deinen Controllern verwenden.

**Beispiel: Schulfach Resource-Representation**  
Das folgende JSON-Objekt stellt ein Schulfach dar:
```json
{
  "id": 1,
  "name": "Deutsch"
}
```
Daraus können wir unsere DTO-Klasse erstellen (vorerst nur mit Feldern und noch keine weitere Funktionalität):
```java
public class SchulfachDto {
    private final Long id;
    private final String name;
}
```
---

**Aufgabe**  
Erstelle für jedes JSON-Objekt aus dem vorherigen Abschnitt eine DTO-Klasse.
Denke daran, die Klassen in die richtigen Packages zu setzen.

---

### Controller erstellen
In Spring werden HTTP Requests an REST-Services von Controllern behandelt.
Das ist eine Java-Klasse, welche mit *@RestController* annotiert wird.
Controller sind also die Umsetzung unserer Schnittstellendefinition.
Da wir noch keine persistierten Daten haben, wirst du vorerst Mockdaten aus den Schnittstellenmethoden liefern müssen. 

**Beispiel: Controller für die Schulfachverwaltung**
```java
@RestController
@RequestMapping("/api/admin")
public class SchulfachAdminController {

  @PostMapping("/schulfaecher")
  public SchulfachDto createNewSchulfach(@RequestBody SchulfachDto newSchulfach) {
    // TODO: Das sind Mockdaten und sollten zu einem späteren Zeitpunkt mit "echtem" Code ersetzt werden
    return new SchulfachDto(3, "Physik");
  }

  // hier können weitere Methoden der Schnittstelle umgesetzt werden
}
```

---

**Aufgabe**  
Erstelle Controller und Methoden (mit Mockdaten), um die Umsetzung deiner Schnittstellen abzuschliessen.

---

### Akzeptanzkriterien Schritt 2
* Ein grobes System-Design ist vorhanden (z.B. mit der Hilfe des Functional-Decomposition-Diagramm).
* Die Codestruktur entspricht dem Design.
* Die REST Schnittstellen sind für jede relevante Funktion (gemäss funktionalen Anforderungen) dokumentiert und mit Controllern umgesetzt.
* Jede API-Methode, welche einen Wert liefert, schreibt diesen Wert direkt in den Response-Body (RestController)
* Die API-Methoden sind "RESTful" (siehe [HTTP Methods in RESTful Web Services](https://www.javadevjournal.com/spring/restful-methods/))
* Die API-Methoden, welche einen Wert liefern, liefern zurzeit Mockdaten zurück (alle Aufrufe einer Methode liefern immer die gleiche Mockdaten zurück)
* Mit Insomnia oder mit dem HTTP-Browser kann auf jede API-Methode zugegriffen werden
* Für jede API-Methode wurden passende Unit-Tests geschrieben und erfolgreich ausgeführt

## Schritt 3: Services anlegen

### Service-Klassen erstellen
In diesem Schritt wird ein komplett neuer Layer angelegt, welcher die Business-Logik der Applikation enthalten wird.
Er ist zuständig für Aufgaben wie Exception-Handling und Validierung. Dieser Layer wird Service-Layer genannt.
Service-Klassen werden grundsätzlich mit der Annotation *@Service* annotiert.
Diese Annotation ist eine von drei möglichen Spezialisierungen eines Spring Components.

Die möglichen Annotationen für einen Spring Component sind die folgenden:
* *@Component*
* *@Controller*
* *@Service*
* *@Repository*

Im folgenden Beispiel wird nun eine Service-Klasse angelegt, welche den vom Controller empfangenen Request-Body als Parameter entgegennimmt
und diesen dann später weiter verarbeiten wird. Im Moment begnügen wir uns damit die Mock-Daten aus dem Controller hierher zu verschieben.

**Beispiel: Service für die Schulfachverwaltung**
```java
@Service
public class SchulfachAdminService {

  public SchulfachDto createNewSchulfach(SchulfachDto newSchulfach) {
    // TODO: Dies sind die Mock-Daten aus dem Controller, sie werden später durch richtige Daten ersetzt
    return new SchulfachDto(3, "Physik");
  }

  // hier können weitere Methoden des Services umgesetzt werden
}
```

---

**Aufgabe**  
Erstelle die nötigen Service-Klassen mit entsprechenden Methoden und verschiebe die Mock-Daten aus den Controllern in die Service-Methoden.
Versuche die Methoden, welche das gleiche fachliche Thema behandeln im gleichen Service unterzubringen.
Denke daran, die Service-Klassen in das richtige Package zu setzen.

---

### Service-Klassen und Controller verbinden
Nun ist es an der Zeit, die erstellten Controller- und Service-Klassen miteinander zu verbinden. Dazu nutzen wir die Dependency Injection.
Controller- und Service-Klassen werden durch ihre Annotationen als Spring-Components erkannt und durch den Spring Container instanziiert.
Die Injection eines Service in einen Controller kann beispielsweise durch eine Constructor-Injection erfolgen. Durch diese Art von Implementation
holt sich der Controller den Service aus dem Container selbst.
Die Methoden der Controller leiten nun ihre Anfragen an die entsprechenden Service-Klassen weiter.

**Beispiel: Constructor-Injection**
```java
@RestController
@RequestMapping("/api/admin")
public class SchulfachAdminController {

  private final SchulfachAdminService schulfachAdminService;

  public SchulfachAdminController(SchulfachAdminService schulfachAdminService) {
      this.schulfachAdminService = schulfachAdminService;
  }

  @PostMapping("/schulfaecher")
  public SchulfachDto createNewSchulfach(@RequestBody SchulfachDto newSchulfach) {
    return this.schulfachAdminService.createNewSchulfach(newSchulfach);
  }
  
  // ...
}
```

---

**Aufgabe**  
Verbinde die erstellten Controller-Klassen mit den entsprechenden Services.
Leite sämtliche Anfragen aus den Controllern an die Service-Methoden weiter.
Die ursprünglich erstellten Test sollten immer noch erfolgreich ausführbar sein.

---

### Akzeptanzkriterien Schritt 3
* Die Mock-Daten wurden in Methoden auf dem Service-Layer ausgelagert
* Die Service-Klassen sind nach Thema aufgebaut
* Sämtliche Anfragen der Controller (Requests) wurden an die Service-Klassen und deren Methoden weitergeleitet
* Die Controller- und Service-Klassen sind mittels Constructor-Injection miteinander verbunden
* Sämtliche Unit-Tests für die Controller funktionieren nach wie vor
* Für alle Service-Methoden wurden entsprechende neue Unit-Tests geschrieben

## Schritt 4: Datenbank-Verbindung herstellen

### Repository-Klassen erstellen
In diesem Schritt wird erneut ein komplett neuer Layer angelegt, welcher die Verbindung der Applikation zu einer Datenbank aufbauen wird.
Dieser Layer wird Persistenz-Layer genannt.
Repository-Klassen werden grundsätzlich mit der Annotation *@Repository* annotiert.

Die Verbindung zu einer Datenbank kann auf verschiedene Arten realisiert werden.
In diesem Kapitel werden wir JPA oder JDBCTemplate eingehen. 

<details>
  <summary>Möglichkeit 1: JPA-Repository mit Spring Data</summary>

#### Möglichkeit 1: JPA-Repository mit Spring Data
Bei dieser Variante wird die Jakarta Persistence API (JPA) mit Spring Data verwendet.
Sie ermöglicht die automatische Generierung von Queries durch die Deklaration eines entsprechenden Methodennamens.
Dies bedeutet, dass der Methodenname zugleich ein Datenbank-Query darstellt.

Damit diese Möglichkeit der Implementation überhaupt besteht, müssen zuerst sogenannte Entitäten angelegt werden.
Eine Entität ist in Java das Abbild einer Datenbank-Tabelle. Jede Zeile in einer Datenbank-Tabelle führt zu einem neuen Objekt der Entität.
Entitäten können untereinander, genauso wie Datenbank-Tabellen, Beziehungen eingehen.

**Beispiel: Entität für ein Schulfach**
```java
@Entity
@Table(name = "SCHOOL_SUBJECT")
public class Schulfach {
    
  @Id
  @Column(name = "description")
  private String bezeichnung;

}
```

Die gezeigte Entität wird mit `@Entity` annotiert, damit sie generell als solche erkannt wird. Die Annotation `@Table` verbindet die Entität
mit der entsprechenden Tabelle. Für jede Kolonne in der Datenbank wird eine Instanzvariable angelegt, welche diese mit `@Column` und
der Angabe des Spaltennamens mit der entsprechenden Spalten aus der Datenbank verbindet.
Die Annotation `@Id` dient der Markierung des Primärschlüssels.

---

**Aufgabe**  
Erstelle die Entitäten für die anderen beiden Tabellen *GRADE* und *SCHOOL_SUBJECT_GRADE*.
Wähle für alle Attribute die richtigen Datentypen und gib die richtigen Spaltennamen an.

---

Nun sollen die drei Entitäten miteinander verbunden werden. Die Beziehung zwischen den Tabellen ist wie folgt geregelt:
* Ein Eintrag in SCHOOL_SUBJECT_GRADE besitzt immer ein SCHOOL_SUBJECT und eine GRADE
* Eine GRADE kann in mehreren SCHOOL_SUBJECT_GRADE eingesetzt werden
* Ein SCHOOL_SUBJECT kann in mehreren SCHOOL_SUBJECT_GRADE eingesetzt werden

Damit sind die Beziehungen zwischen den Tabellen jeweils 1:m, dies wird auch One-To-Many genannt.
Aus Sicht eines SCHOOL_SUBJECT_GRADE ist die Beziehung umgekehrt m:1, dies wird auch Many-To-One genannt.
Mit diesen Kenntnissen können nun die entsprechenden Annotationen aus JPA verwendet werden, um die Entitäten zu verbinden.

**Beispiel: Beziehung zwischen Schulfach und Mapping-Tabelle**
```java
@Entity
@Table(name = "SCHOOL_SUBJECT")
public class Schulfach {

  @OneToMany(mappedBy = "schulfach")
  private Set<SchulfachNote> noten;

}

@Entity
@Table(name = "SCHOOL_SUBJECT_GRADE")
public class SchulfachNote {

  @ManyToOne
  @JoinColumn(name = "FK_SCHOOL_SUBJECT_ID", nullable = false)
  private Schulfach schulfach;

}
```

Bei der Klasse *Schulfach* sehen wir die Verbindung zu allen Schulfach-Noten über ein Set und die Annotation `@OneToMany`
unter Angabe des Namens der Instanzvariable aus der Klasse `SchulfachNote`.
Bei der Klasse `SchulfachNote` sehen wir die Verbindung zu einem Schulfach über die Annotation `@ManyToOne` und der Angabe
der Kolonne, welche den Fremdschlüssel enthält. Die Angabe von `nullable = false` dient der Angabe, dass die Kolonne des
Fremdschlüssels keine `null`-Werte zulässt.

---

**Aufgabe**  
Verbinde die anderen beiden Entitäten `GRADE` und `SCHOOL_SUBJECT_GRADE` mit den richtigen Beziehungen.

---

Im nächsten Schritt werden nun die Repository-Interfaces angelegt.

**Beispiel: JPA-Repository für die Schulfachverwaltung**
```java
@Repository
public interface SchulfachAdminRepository extends JpaRepository<Schulfach, String> {

}
```

Bei diesem Repository sehen wir die Definition eines Interfaces, welches ein `JpaRepository` erweitert.
Die generischen Angaben stehen für die Klasse der Entität und dessen Primärschlüssel-Typ.
Durch dieses Repository stehen bereits die wichtigsten CRUD-Operationen zur Verfügung.

---

**Aufgabe**  
Erstelle die Repository-Klassen für die beiden anderen Entitäten.

---

Die folgende Aufzählung der Operationen ist nicht vollständig, zeigt aber welchen Funktionsumfang ein solches Repository nun bereits besitzt:
* ` List<T> findAll() ` liefert alle Einträge der Entität zurück
* ` T getReferenceById(ID id) ` liefert den Eintrag mit der entsprechenden ID zurück
* ` Optional<T> findById(ID id) ` liefert den Eintrag mit der entsprechenden ID als Optional zurück
* ` long count() ` zählt alle Einträge
* ` void delete(T entity) ` löscht die angegebene Entität
* ` <S extends T> S save(S entity) ` speichert die angegebene Entität und liefert sie zur weiteren Bearbeitung zurück

Für die Realisierung von Methoden zur Abdeckung der funktionalen Anforderungen dient die folgende Tabelle: 

| Funktionale Anforderung                                                             | Abdeckung durch JpaRepository |
|-------------------------------------------------------------------------------------|-------------------------------|
| Alle Fächer und all deren Noten auflisten (ein Fach kann mehreren Noten beinhalten) | Nein                          |
| Alle Fächer und deren Durchschnittsnote auflisten                                   | Nein                          | 
| Für ein bestimmtes Fach: Alle Noten und die Durchschnittsnote des Fachs auflisten   | Nein                          |
| Für ein bestimmtes Fach: Eine neue Note hinzufügen                                  | Methode `save`                |
| Für ein bestimmtes Fach: Eine bestehende Note ändern                                | Methode `save`                |
| Für ein bestimmtes Fach: Eine bestehende Note löschen                               | Methode `delete`              |
| Alle Fächer auflisten                                                               | Methode `findAll`             |
| Neue Fächer hinzufügen                                                              | Methode `save`                |
| Bestehende Fächer bearbeiten                                                        | Methode `save`                |
| Bestehende Fächer löschen                                                           | Methode `delete`              |

Damit müssen nur die Methoden für die ein wenig komplizierteren Datenbank-Abfragen definiert werden.
Der einfachste Weg zu schnellen Resultaten führt über die Entitäten und deren Verbindungen untereinander.

Eine Note (GRADE) und ein Schulfach (SCHOOL_SUBJECT) sind jeweils über die letzte Tabelle (SCHOOL_SUBJECT_GRADE) miteinander verbunden.
Diese Verbindung kann ebenfalls über JPA in den Entitäten abgebildet werden.

**Beispiel: Many-To-Many Verbindung zwischen Noten und Schulfächern**
```java
@Entity
@Table(name = "SCHOOL_SUBJECT")
public class Schulfach {

  @ManyToMany
  @JoinTable(
          name = "SCHOOL_SUBJECT_GRADE",
          joinColumns = @JoinColumn(name = "FK_SCHOOL_SUBJECT_ID"),
          inverseJoinColumns = @JoinColumn(name = "FK_GRADE_ID")
  )
  private List<Note> noten;

}

@Entity
@Table(name = "GRADE")
public class Note {

  @ManyToMany
  @JoinTable(
          name = "SCHOOL_SUBJECT_GRADE",
          joinColumns = @JoinColumn(name = "FK_GRADE_ID"),
          inverseJoinColumns = @JoinColumn(name = "FK_SCHOOL_SUBJECT_ID")
  )
  private List<SchoolSubject> subjects;

}
```

Es reicht also die "Mapping"-Tabelle und die gerichteten Verbindungen in Form der Kolonnen-Namen anzugeben.

Damit für ein bestimmtes Fach nun alle Noten abgeholt werden können, ist die folgende Implementation notwendig:
**Beispiel: Laden aller Noten für ein bestimmtes Fach**
```java
@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findGradesBySubjectsSubject(String subject);

}
```
</details>

<details>
<summary>Möglichkeit 2: JDBC-Template</summary>

### Möglichkeit 2: JDBC-Template
Wer nicht mehr genau weiss was JDBC ist kann es [hier](./../../../docs/java/java-jdbc.md ) nachlesen.

#### Dependency
Damit JDBC verwendet werden kann, muss zuerst eine neue Dependency in das `pom.xml` hinzufügen werden.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
<version>3.1.0</version>
</dependency>
```

#### Entity-Klasse 
Eine Entity-Klasse ist eine normale Java-Klasse, die als Modell für eine Tabelle in der Datenbank dient. Jedes Objekt dieser Klasse entspricht einer Zeile in der Tabelle.
```java
@Getter
@Setter
public class Grade {
    private Long gradeId;
    private Double gradeValue;
}
```

Die Annotationen `@Getter` und `@Setter` sind zwei der am häufigsten verwendeten Annotationen in Lombok. Sie generieren automatisch Getter- und Setter-Methoden für die Felder einer Klasse. Lombok ist eine Java-Bibliothek, die es Entwicklern ermöglicht, boilerplate Code in ihren Java-Klassen zu reduzieren. 

Damit man Lombok jedoch verwenden kann, muss man die folgende Dependency im `pom.xml` hinzufügen:
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
    <scope>provided</scope>
</dependency>
```

#### Repository
Ein Repository ein Designmuster oder eine Klasse, die den Datenbankzugriff für eine bestimmte Entität oder ein bestimmtes Objektmodell verwaltet. Es hilft, den Code zu organisieren und zentrale Methoden für den Zugriff auf die Datenbank bereitzustellen.

```java

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SchoolSubject> getAllSubjectsAndGrades() {
        return null;
    }
    
    // ...
}
```
</details>


### Repository-Klassen und Service-Klassen verbinden
Die Verbindung zwischen Repository- und Service-Klassen in einer Softwareanwendung ist entscheidend für eine saubere Struktur und effiziente Datenverwaltung. Repository-Klassen handhaben den Datenzugriff, während Service-Klassen die Geschäftslogik umsetzen. Service-Klassen nutzen die Methoden der Repository-Klassen, um auf Daten zuzugreifen oder diese zu manipulieren. Diese Trennung ermöglicht eine klare Aufgabenverteilung, verbessert die Wartbarkeit und erleichtert die Integration von Datenzugriff und Geschäftslogik.

```java
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<SchoolSubjectGradeDto> getAllSubjectsAndGrades() {
        return studentRepository.getAllSubjectsAndGrades();
    }

    // ...
}
```

---

**Aufgabe** 
Füge die benötigte Dependency in dein Projekt ein und erstelle die nötigen Entity-Klassen. Zudem erstelle die benötigten Services und Repositories in der korrekten packages Struktur.

---

### Akzeptanzkriterien Schritt 4
* Dependency wurde im `pom.xml` hinzugefügt.
* Alle nötigen Entities wurden erstellt.
* Alle benötigten Services wurden erstellt und in einen Ordner für alle Services abgelegt. 
* Alle benötigten Repositories wurden erstellt und in einen Ordner für alle Repositories abgelegt.


## Schritt 5: Konfiguration anlegen 
In der Konfigurationsdatei können Einstellungen für die Datenbankverbindung, Log-Ebene, Profile, Spring-Profile, Webserver-Port, Sicherheitskonfigurationen und viele andere Aspekte der Anwendung angegeben werden.

Die zwei häufigsten Arten eine Konfigurationsdatei anzulegen sind in `application.yml` oder die `application.properties`. Der Unterschied der beiden besteht darin das die `application.yml`-Datei, in YAML-Syntax geschrieben ist, und die `application.properties`-Datei eine einfache Key-Value-Paar-Syntax verwendet.

application.properties:
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/[your_database]
spring.datasource.username=[your_username]
spring.datasource.password=[your_password]
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```

application.yml:
```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/[your_database]
    username: [your_username]
    password: [your_password]
    driver-class-name: org.mariadb.jdbc.Driver
```

---

**Aufgabe**  
Erstelle deine Konfigurationsdatei entsprechend deiner Datenbank.

---

### Akzeptanzkriterien Schritt 5
* Die Spring Boot Applikation startet mit der Datenbank.

## Schritt 6: Profile anlegen
In diesem Schritt erstellst du die gewünschten Spring Boot Profile: "student" und "admin".
Diese Profile werden benutzt, um die verfügbare Funktionalität einzuschränken bzw. zu erweitern.
Welche Funktionalität mit welchem Profil zur Verfügung stehen darf, entnimmst du aus den funktionalen Anforderungen.

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
### Repository- und Service-Implementierungen
In Spring Boot ist die Verwendung von Repository- und Service-Implementierungen eine bewährte Methode, um eine saubere Trennung von Geschäftslogik, Datenzugriff und Präsentation sicherzustellen. Diese Trennung hilft, den Code übersichtlich, wartbar und testbar zu machen.

* Repository-Interface: Definiert die Methoden für den Datenzugriff.

* Repository-Implementierung (RepositoryImpl): Implementiert die Methoden des Repository-Interfaces und führt die tatsächlichen Datenbankoperationen aus.

* Service-Interface: Definiert die Methoden für die Geschäftslogik.

* Service-Implementierung (ServiceImpl): Implementiert die Methoden des Service-Interfaces und ruft bei Bedarf das Repository auf, um auf Daten zuzugreifen.

```java
public interface StudentRepository {
    List<SchoolSubject> getAllSubjectsAndGrades();
    
    // ...
}
```

```java
@Repository
public class StudentRepositoryImpl implements StudentRepository { 
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<SchoolSubject> getAllSubjectsAndGrades() {
        return null;
    }
    
    // ...
}
```

---

**Aufgabe**  
Passe deine Services und Repositories entsprechend der Implementierungs-Methode an.

---

### Akzeptanzkriterien Schritt 7
* Alle Services sind mit der Implementierungs-Methode ausgestattet.
* Alle Repositories sind mit der Implementierungs-Methode ausgestattet

<details>
<summary>Schritt 8 Persistenz-Layer fertigstellen (Nur für JDBC)</summary>

## Schritt 8 Persistenz-Layer fertigstellen (Nur für JDBC)

### Queries
Typischerweise implementieren JDBC-Repositories benutzerdefinierte Methoden für spezielle Datenbankabfragen. Diese Methoden nutzen das JdbcTemplate (Teil des Spring-Frameworks), um SQL-Queries auszuführen. Dabei können Platzhalter oder Named Parameters verwendet werden, um dynamische Werte in die Abfragen einzufügen.

`PreparedStatementSetter` ist ein funktionales Interface in Spring JDBC. Es wird verwendet, um Parameter für parametrisierte Abfragen auf einem PreparedStatement festzulegen.
Die Verwendung von `PreparedStatementSetter` hilft, die Logik zum Setzen von Parametern zu kapseln, was den Code modularer und leichter wartbar macht.

```sql
INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES (?)
```
```java
@Repository
public class StudentRepositoryImpl implements StudentRepository { 
    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // ...

  @Override
  public void addSubject(SchoolSubjectDto schoolSubjectDto) {
      String sql = "INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES (?)";
      PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
          preparedStatement.setString(1, schoolSubjectDto.getSubjectName());
      };

      jdbcTemplate.update(sql, preparedStatementSetter);
  }
    
    // ...
}
```

### Mapping
In der Softwareentwicklung stellt sich oft die Frage, wie man das Mapping zwischen verschiedenen Ebenen der Anwendung am besten handhabt. Insbesondere geht es darum, wie man Daten zwischen der Datenbank, der Geschäftslogik (Services) und der Benutzerschnittstelle (DTOs - Data Transfer Objects) hin- und herbewegt.

Eine Möglichkeit ist, das Mapping nicht im Service durchzuführen. Dies wird zwar nicht zwingend empfohlen, aber es ähnelt dem Ansatz von JPA (Java Persistence API) und kann daher vorteilhaft sein. Hierbei wird das Mapping eher in den Repositories durchgeführt. Dies verringert die Belastung des Service mit zusätzlichem Mapping und spezifischen Abfragen (Queries). Allerdings kann dies zu einer unübersichtlichen Repository-Schicht führen, da sie dann sowohl für das Mapping als auch für die Abfragen verantwortlich ist.

Wenn das Mapping im Service durchgeführt wird, bedeutet dies ein zusätzliches Mapping von der Abfrage (Query) zu den Entity-Objekten und dann zu den DTOs. Dies kann ineffizient erscheinen, da man ein Objekt erstellt, das später vom Garbage Collector aufgeräumt werden muss.

Der JPA-Ansatz könnte mehr Daten zurückholen, als tatsächlich benötigt werden, da alle Eigenschaften in das Entity-Objekt geladen werden, selbst wenn sie im DTO nicht benötigt werden. Dies könnte ineffizient sein, insbesondere wenn nur ein Teil der Daten benötigt wird.

Im Kontext von JDBC (Java Database Connectivity) gibt es viele verschiedene Ansätze und keinen "einen" richtigen Weg. Es ist möglich, JPA und JDBC zu mischen, um das Beste aus beiden Welten zu nutzen.

Insgesamt ist die Wahl des richtigen Ansatzes abhängig von den Anforderungen des Projekts, der Skalierbarkeit, der Performance und den individuellen Vorlieben des Entwicklungsteams. Es ist wichtig, die Vor- und Nachteile der verschiedenen Ansätze abzuwägen und den am besten geeigneten Ansatz für das spezifische Projekt zu wählen.

#### DTO zu Entity
Durch das Mappen der Entity-Objekte auf DTOs können wir die Datenstruktur an die spezifischen Anforderungen anpassen. DTOs enthalten nur die relevanten Daten, die zwischen verschiedenen Teilen der Anwendung oder sogar zu externen Systemen übertragen werden müssen. Dies ermöglicht eine effizientere Datenübertragung und verhindert die Offenlegung von sensiblen oder unnötigen Informationen.

Des Weiteren schafft die Verwendung von DTOs eine klare Trennung der Verantwortlichkeiten. Die Entity-Objekte kümmern sich um die Interaktion mit der Datenbank, während die DTOs die übertragenen Daten in geeigneter Form halten. Somit wird eine saubere Architektur gefördert, die gut skalierbar und wartbar ist.
```java
public static SchoolSubject mapDtoToEntity(SchoolSubjectDto dto) {
    if (dto == null) {
        return null;
    }

    SchoolSubject entity = new SchoolSubject();
    entity.setSubjectId(dto.getSubjectId());
    entity.setSubjectName(dto.getSubjectName());
    return entity;
}
```
```java
 @Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void addSubject(SchoolSubjectDto schoolSubjectDto) {
        adminRepository.addSubject(mapDtoToEntity(schoolSubjectDto));
    }
}
```

#### RowMapper
In JDBC, ist der RowMapper ein Interface, das verwendet wird, um das Mapping von Zeilen aus dem ResultSet auf Objekte zu ermöglichen. Es wird verwendet, um das Ergebnis jedes Datensatzes aus der Abfrage in ein Objekt umzuwandeln.

Erstelle eine Klasse, die das `RowMapper`-Interface implementiert und die `mapRow`-Methode überschreibt. In dieser Methode wird definiert, wie eine Zeile aus dem ResultSet in ein Objekt gemappt wird.
```java
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolSubjectDtoRowMapper implements RowMapper<SchoolSubjectDto> {


  @Override
  public SchoolSubjectDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Long subjectId = resultSet.getLong("subject_id");
    String subjectName = resultSet.getString("subject_name");

    return new SchoolSubjectDto(subjectId, subjectName);
  }
}
```

Im RepositoryImpl kann man nun die erstellte Mapper-Methode verwenden, um das Ergebnis der JDBC-Operation zu mappen.
```java
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final CommonDeclarableProperties declarableProperties;

    public StudentRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, CommonDeclarableProperties declarableProperties) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.declarableProperties = declarableProperties;
    }
    
    // ...

    @Override
    public List<SchoolSubjectDto> getAllSubjects() {
        String sql = "SELECT * FROM SCHOOL_SUBJECT";
        return namedParameterJdbcTemplate.query(sql, new SchoolSubjectDtoRowMapper());
    }
    
    // ...

}
```

#### ResultSetExtractor
Auch der ResultSetExtractor ist ein funktionales Interface, das verwendet wird, um das Mapping von ResultSet auf ein Objekt oder eine Liste von Objekten zu ermöglichen. Es ermöglicht eine benutzerdefinierte Verarbeitung der ResultSet-Daten.

Erstelle eine Klasse und verwende das `ResultSetExtractor`-Interface, um zu definieren, wie das ResultSet in ein Objekt oder eine Liste von Objekten umgewandelt werden soll.
```java
public class SchoolSubjectDtoResultSetExtractor implements ResultSetExtractor<List<SchoolSubjectDto>> { 
    
    @Override
    public List<SchoolSubjectDto> extractData(ResultSet resultSet) throws SQLException {
    List<SchoolSubjectDto> schoolSubjectDtos = new ArrayList<>();

    while (resultSet.next()) {
      Long gradeId = resultSet.getLong("subject_id");
      String subjectName = resultSet.getString("subject_name");

      SchoolSubjectDto schoolSubjectDto = new SchoolSubjectDto(gradeId, subjectName);
      schoolSubjectDtos.add(schoolSubjectDto);
    }

    return schoolSubjectDtos;
  }
}
```

Im RepositoryImpl kann man nun die erstellte Extractor-Methode verwenden um das Ergebnis der JDBC Operation zu mappen.
```java
@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public AdminRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // ...

    @Override
    public List<SchoolSubjectDto> getAllSubjects() {
        String sql = "SELECT * FROM SCHOOL_SUBJECT";
        return namedParameterJdbcTemplate.query(sql, new SchoolSubjectDtoResultSetExtractor());
    }

    // ...
}
```

---

**Aufgabe**
Ergänze deine Repositories mit den nötigen SQL-Queries (wähle selbst, ob du es auslagern möchtest oder nicht).
Implementiere die benötigten Mapper und setze sie an den benötigten Orten ein (wähle selbst, ob du es mit einem Mapper oder Extractor machen willst).

---

### Akzeptanzkriterien Schritt 8
* Es werden nun nicht mehr mittels Mockdaten verwendet, sondern direkt SQL-Queries benutzt.
* Die erhaltenen Daten, aus der Datenbank, werden korrekt für die DAOs gemappt.
* Die DAOs werden korrekt gemappt bevor sie an die Datenbank gesendet werden.

</details>

## Schritt 9: API testen
Sobald deine Schnittstelle umgesetzt wird bzw. bereits ab dem zweiten Schritt in diesem Auftrag, kann die Schnittstelle von HTTP-Clients angesprochen und getestet werden.
In diesem Schritt wirst du deine Schnittstelle mit dem *IntelliJ HTTP-Client* testen.

Eine Alternative zum *IntelliJ HTTP-Client* bietet `Swagger` an.
Swagger ist ein Open-Source-Framework, das in erster Linie dazu dient, APIs zu entwerfen, zu dokumentieren und zu testen. Es ermöglicht eine einfache und strukturierte Beschreibung von Webdiensten, um deren Funktionalitäten, Parameter und Endpunkte zu verstehen.

Mit Spring Boot 3 kann man neu nur noch einen Dependency hinzufügen damit der Swagger läuft. Diese sieht folgerndermassen aus:
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>
```

Für unsere Test-Zwecke reicht der IntelliJ HTTP-Client völlig aus.

### Testen mit IntelliJ HTTP Client
Wenn du eine RestController-Klasse in IntelliJ offen hast, wird an einigen Stellen ein Symbol dargestellt wie hier mit Rot unterstrichen:
![](../assets/05_intellij_http_client_symbol.png)

Wenn man den Pfeil neben dem Symbol drückt, kann man die Option "Generate Request in HTTP Client" auswählen:
![](../assets/06_intellij_http_client_dropdown.png)

Somit wird der HTTP-Client Editor geöffnet, mit dem entsprechenden HTTP-Method und Pfad:
![](../assets/07_intellij_http_client_editor.png)

Mit einem Klick auf dem grünen Pfeil, wird die HTTP Request ausgeführt.
Wenn du ein Beispiel brauchst, um zu wissen, wie du Requests erstellst (z.B. solche mit einem Request-Body)
kannst du auf dem *Examples* Pfeil (oben rechts) klicken und die entsprechende Beispiel-Datei öffnen.

Weitere Dokumentation zum IntelliJ HTTP-Client findest du [auf dieser IntelliJ IDEA Seite](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)

---

**Aufgabe**  
Erstelle eine HTTP-Request Datei, welche alle Methoden in deiner Schnittstelle ausführt.

---

### Akzeptanzkriterien Schritt 9
* Eine HTTP-Request Datei liegt vor, welche alle öffentlichen Schnittstellen-Methoden ausführen kann.
* Bei Methoden, welche Parameter oder einen Request-Body brauchen, sind diese in den Requests auch so konfiguriert.
* Jede Methode, welche ausgeführt wird, liefert die erwarteten Ergebnisse (ggf. auch Anpassungen der Daten in der darunterliegenden Datenbank).

## Integrationstests mit H2 umsetzen
Integrationstests mit H2 in einem Spring-Boot-Projekt umzusetzen ist eine bewährte Methode, um die Interaktion zwischen verschiedenen Komponenten einer Anwendung zu testen, ohne auf eine reale Datenbank angewiesen zu sein. 
In diesem Kontext dient H2, eine In-Memory-Datenbank, als Ersatz für die eigentliche Datenbank und erlaubt es, Tests zu schreiben, welche die Anwendungslogik unter simulierten Bedingungen überprüft.

### Struktur
Es wird folgende Ordnerstruktur empfohlen, damit das gesamte Testing wie gewollt funktioniert:
```xml
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |       |-- example/
|   |           |-- myapp/
|   |               |-- YourProductionCode.java
|-- test/
|   |-- java/
|   |   |-- com/
|   |       |-- example/
|   |           |-- myapp/
|   |               |-- integration/
|   |                   |-- YourIntegrationTests.java
|   |-- resources/
|       |-- application-test.properties
|       |-- schema.sql
|       |-- data.sql
```

### Dependencies
Damit man H2 verwenden kann, muss man auch hier noch einen Dependency im `pom.xml` hinzufügen. Diese ist folgende:
```xml
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>test</scope>
</dependency>
```

### Konfiguration anlegen
In der Testkonfiguration (z. B. `application-test.properties`), konfiguriert man H2 als Datenbank für die Integrationstests. Es wird die Verbindungs-URL, der Treiber und die Anmeldeinformationen für H2 festgelegt. Diese Datenbank wird in den Tests automatisch erstellt und verwaltet.

application-test.properties:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.platform=h2
spring.jpa.hibernate.ddl-auto=update
```

application-test.yml:
```yaml
spring: 
  datasource: 
    url: jdbc:h2:mem:testdb
    username: sa
    password: password
    platform: h2
    driver-class-name: org.h2.Driver
jpa: 
  hibernate:
    ddl-auto: update
```

### SQL Files
Nun werden SQL-Skripte benötigt, die das Datenbankschema und Testdaten definieren. Diese Skripte werden während der Testausführung automatisch geladen.

#### Schema File
```sql
CREATE TABLE SCHOOL_SUBJECT (
    subject_id INT AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(255) NOT NULL
);
```

#### Data File
```sql
INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES ('Mathematics');
INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES ('History');
INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES ('Science');
INSERT INTO SCHOOL_SUBJECT (subject_name) VALUES ('English');
```

### Integration Test
Integrationstests sind wichtig, um sicherzustellen, dass verschiedene Komponenten einer Anwendung (z. B. Klassen, Module, Services, REST-Endpunkte) ordnungsgemäss miteinander interagieren und Daten korrekt austauschen. Sie helfen dabei, potenzielle Fehler und Inkompatibilitäten zwischen den Komponenten frühzeitig zu erkennen und zu beheben.

```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("admin")
@ExtendWith(SpringExtension.class)
public class AdminControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AdminService adminService;
    
    @Test
    public void testGetAllSubjects() throws Exception {
      List<SchoolSubjectDto> subjects = new ArrayList<>();
      subjects.add(new SchoolSubjectDto(1, "Mathematics"));
      subjects.add(new SchoolSubjectDto(2, "History"));
    
      when(adminService.getAllSubjects()).thenReturn(subjects);
    
      mockMvc.perform(get("/api/admin/subjects")
                      .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$[0].subjectId").value(1))
              .andExpect(jsonPath("$[0].subjectName").value("Mathematics"))
              .andExpect(jsonPath("$[1].subjectId").value(2))
              .andExpect(jsonPath("$[1].subjectName").value("History"));
    }

    // ...
}
```
