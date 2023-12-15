---
title: "Maven und Continuous Integration"
linkTitle: "Maven"
weight: 8
description: >
  Modul #S2
---

#### Ziele
* Ich kenne die Grundlagen von Maven
* Ich kann Maven lokal konfigurieren
* Ich kann im Artifactory Abhängigkeiten suchen und diese verwenden
* Ich kenne die Grundlagen von Project Object Models (pom)
* Ich kenne die wichtigsten Maven Befehle und kann diese auf der Kommandozeile anwenden
* Ich kann die Abhängigkeiten meiner Applikationen mit Maven verwalten
* Ich kann Maven Plugins konfigurieren und damit meinen Maven-Build steuern
* Ich kann den Begriff Continuous Integration erklären
* Ich kenne die Komponenten der Deployment-Pipeline und deren Aufgaben

## Maven
### Allgemeine Informationen
Apache Maven ist ein Build-Management Tool. Von einer einzelnen Datei aus, kann Maven den Build eines Projektes steuern.
Diese zentrale Datei ist das Project Object Model, kurz auch POM genannt. Der Build eines Projektes kann dabei von einfacher Kompilierung bis zur Auslieferung einer Anwendung auf eine bestimmte Plattform reichen.

Damit Maven funktionieren kann, benötigt ein Projekt die folgenden Dinge:
* Eine Maven-Installation, entweder separat oder Built-In wie beispielsweise mit IntelliJ
* Eine POM-Datei pro Projekt oder Modul (es handelt sich um eine XML-Datei)
* Ein zentrales Maven-Repository
* Ein lokales Maven-Repository
* Eine Konfigurationsdatei mit dem Namen settings.xml

---

### Installation
Die Installation von Apache Maven wurde idealerweise bereits durchgeführt. Falls nicht, kann Maven hier heruntergeladen werden:
[https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi), beim Herunterladen das Binary auswählen (nicht die Source).

---

### pom.xml
Der Aufbau eines POM kann grob in folgende Abschnitte unterteilt werden, hier erklärt an einem umfangreichen Beispiel.
Die einzelnen Teile werden gleich im Anschluss näher erläutert. Bitte beachte, dass dieses POM nicht alle Inhalte erklären kann, es dient nur als erstes Beispiel.

```xmlmarkdown.md
<!-- (1) Header -->
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- (2) Angaben zum Artefakt -->
    <groupId>ch.sbb.interviewtool</groupId>
    <artifactId>interviewtool-backend</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!-- (3) Angaben zum Parent-Projekt -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.4.RELEASE</version>
        <relativePath/>
    </parent>

    <!-- (4) Properties -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
        <maven.build.timestamp.format>yyyy-MM-dd HH:mm</maven.build.timestamp.format>
        <timestamp>${maven.build.timestamp}</timestamp>
    </properties>

    <!-- (5) Abhängigkeiten -->
    <dependencies>
        <!-- Spring Boot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web-services</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.6</version>
        </dependency>

        <!-- Datenbank -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>

        <!-- Unit- und Integrationstests -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <!-- (6) Build-Informationen -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <compilerVersion>1.8</compilerVersion>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <!-- (7) Auslieferung -->
    <distributionManagement>
        <repository>
            <id>mvn</id>
            <url>https://bin.sbb.ch/artifactory/cca.mvn/</url>
        </repository>
        <snapshotRepository>
            <id>mvn</id>
            <url>https://bin.sbb.ch/artifactory/cca.mvn/</url>
        </snapshotRepository>
    </distributionManagement>

    <!-- (8) Entwickler-Informationen -->
    <developers>
        <developer>
            <id>U000000</id>
            <name>Vorname Name</name>
            <email>vorname.name@sbb.ch</email>
            <organization>SBB</organization>
            <organizationUrl>https://www.sbb.ch</organizationUrl>
            <roles>
                <role>Software Architect</role>
                <role>Lead Developer</role>
            </roles>
        </developer>
    </developers>
</project>
```

#### Abschnitt 1
Der Header einer POM-Datei bleibt grundsätzlich so wie dargestellt. Die Angaben zum Schema sind dabei optional. Falls andere Schemas verwendet werden, so sind diese hier zu deklarieren.

#### Abschnitt 2
Die Angaben zum Artefakt enthalten die folgenden Informationen:
* Gruppen-ID: Normalerweise eine umgekehrte URL, also beispielsweise ch.sbb.interviewtool. Darin sollte der Projektname enthalten sein
* Artefakt-ID: Der Name des Projekts oder der Komponente
* Version: Die momentane Version des Projekts, diese wird später durch Releases verändert
* Paketierung: Angabe, in welcher Form das Artefakt geliefert wird. Der Default ist Java Archive (JAR)

Bei der Versionierung nutzt Maven die folgenden Standards:
- Major-Version
- Minor-Version
- Incremental-Version
- Build-Number
- Qualifier

Dazu ein paar Beispiele:

| Typ                 | Beispiel                              |
|---------------------|---------------------------------------|
| Major-Version       | <font color="red">1</font>.2.1        |
| Minor-Version       | 2.<font color="red">0</font>          |
| Incremental-Version | 1.2<font color="red">-SNAPSHOT</font> |
| Patch               | 1.2.<font color="red">1</font>        |
| Build-Number        | 1.4.2<font color="red">-12</font>     |
| Qualifier           | 1.2<font color="red">-beta-2</font>   |

Alle Versionen mit Qualifier sind dabei älter als die gleiche Version ohne Qualifier. Beispielsweise ist die Version **1.2-beta-2** älter als die Version **1.2**.
Gleiche Versionen mit unterschiedlichen Qualifiern werden durch den Vergleich dieser als String verglichen. So ist die Version **1.2-beta-2** neuer als die Version **1.2-alpha-6**.

Der SNAPSHOT Qualifier wird verwendet, wenn eine Version noch nicht ausgeliefert wurde. So wird die Version **0.1.2-SNAPSHOT** sehr wahrscheinlich als Version **0.1.2** ausgeliefert werden.

#### Abschnitt 3
Falls das Projekt Bestandteil eines anderen Projektes ist, müssen hier die Artefakt-Angaben des sogenannten Parent-Projekts hinterlegt werden. Dies ist vorallem bei Spring-Boot Projekten wichtig.

#### Abschnitt 4
Die Einstellungen in Maven sind beliebig wählbare Tags. So kann beispielsweise eine bestimmte Einstellung oder eine Version definiert werden.

Beispiel:
```xml
<special.setting>Value</special.setting>
```
Innerhalb der POM-Datei kann dann mit
```
${special.setting}
```
auf die Einstellung (Tag) und damit auf deren Wert (Value) zugegriffen werden.

#### Abschnitt 5
Abhängigkeiten zu Fremdbibliotheken. Diese sollten stets Gruppen-ID, Artefakt-ID und Version enthalten. Der Typ der Abhängigkeit gibt an, um welche Art von Bibliothek es sich handelt. Nicht alle Java-Bibliotheken werden als JAR ausgeliefert.
Mögliche Typen sind hier zu finden: [https://maven.apache.org/ref/3.6.3/maven-core/artifact-handlers.html](https://maven.apache.org/ref/3.6.3/maven-core/artifact-handlers.html)
Vielfach wird auch noch der Scope verwendet, er gibt an in welchem Umfang die Fremdbibliothek miteinbezogen wird.
Mögliche Scopes sind:
* compile - Das ist der Default-Scope. Bibliotheken sind in allen Klassenpfaden verfügbar (Classpath)
* provided - Gleich wie compile, ausser das die Bibliothek zur Laufzeit von einem Container (wie dem JDK) erwartet und bereitgestellt wird
* runtime - Zeigt an, dass die Bibliothek zur Kompilierung nicht verwendet wird. Zur Laufzeit steht sie dann zur Verfügung
* test - Die Bibliothek steht nur für Tests zur Verfügung
* system - Gleich wie provided, mit der Ausnahme, dass die Bibliothek explizit auf dem System zur Verfügung stehen muss

#### Abschnitt 6
Die Build-Informationen konfigurieren den Ablauf des Maven-Builds. Mit Plugins kann der Build selbst durch spezifische Erweiterungen beliebig angepasst werden.
Es ist auch möglich eigene Maven-Plugins zu entwickeln. Es stehen sehr viele Plugins für Maven zur Verfügung, eine Übersicht gibt es [hier](https://maven.apache.org/plugins/index.html).

#### Abschnitt 7
Die Auslieferungs-Sektion bestimmt, wo die Artefakte nach dem Build abgelegt werden sollen.

#### Abschnitt 8
Die Entwickler-Informationen dienen dazu, an der Entwicklung beteiligte Personen zu identifizieren.

---

### IntelliJ IDEA einrichten
Im IntelliJ findet man in den allgemeinen Einstellungen auch die Einstellungen für Maven.
![](../maven/1657700434.png)

Die wichtigsten Einstellungen sind:

| Einstellung          | Beschreibung                                                                                                                                       |
|----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| Maven home directory | Zeigt auf das Verzeichnis einer Maven-Installation. Das IntelliJ verfügt bereits über eine Maven-Installation, diese wird als "Bundled" bezeichnet |
| User settings file   | Die XML-Datei, welche weiter oben angelegt wurde                                                                                                   |
| Local repository     | Der Ablageort für das lokale Repository, dieser ist normalerweise unter C:\Users\\\<Personalnummer>\\.m2.\\repository zu finden                    |

Bei diesen Einstellungen muss überprüft werden, dass die Pfad-Angaben für die XML-Datei und das lokale Repository korrekt sind.

---

### Umgebungsvariable aufsetzen
Damit Maven auch auf der Command-Line funktioniert, muss eine Umgebungsvariable gesetzt werden.
Im Windows muss also der Pfad zur Built-In Version des IntelliJ hinterlegt werden. Die folgenden Schritte sind dazu notwendig:

| #   | Beschreibung                                                                                                                    |
|-----|---------------------------------------------------------------------------------------------------------------------------------|
| 1   | Anwendung "Systemumgebungsvariablen bearbeiten" aus der Systemsteuerung starten                                                 |
| 2   | Unten rechts auf den Button "Umgebungsvariablen" klicken                                                                        |
| 3   | Im unteren Teil "Systemvariablen" die Variable "Path" suchen und anklicken                                                      |
| 4   | Auf den Button "Bearbeiten..." klicken                                                                                          |
| 5   | Oben rechts auf den Button "Neu" klicken, es erscheint eine neue Zeile ganz unten                                               |
| 6   | Den Pfad zum Built-In Maven einfügen. Dieser ist normalerweise "\<Installationsort IntelliJ IDEA>\plugins\maven\lib\maven3\bin" |
| 7   | Alle offenen Windows-Fenster mit "OK" schliessen                                                                                |

---

### Commands
Maven lässt sich auf der Kommandozeile oder im IntelliJ-Terminal ausführen. Damit wir sehen, ob das wirklich klappt könnt ihr das Terminal öffnen und den folgenden Befehl eingeben:

```console
mvn -version
```

Das sollte nun in etwa so aussehen:

![](../maven/1657700535.png)

Bevor wir die einzelnen Befehle kurz anschauen werfen wir einen Blick auf die einzelnen Phasen des Maven-Lebenszyklus.

![](../maven/1657700671.png)

Jeder der in der Grafik genannten Befehle wird zusätzlich die vorangehenden Befehle ausführen.
Die Ausführung von "mvn package" wird also die Phasen _validate_, _compile_, _test_ und _package_ ausführen.

#### help
```console
mvn -help
```
Das Ergebnis dürfte klar sein. Maven listet alle möglichen Befehle auf.

#### dependency:tree
```console
mvn dependency:tree
```
Dieser Befehl listet alle Abhängigkeiten zu Fremdbibliotheken als Baum auf.
Das ist grundsätzlich sehr praktisch wenn man doppelte Abhängigkeiten erkennen/vermeiden will.

#### clean
```console
mvn clean
```
Dieser Befehl löscht alle vorherigen lokale Maven-Build-Artefakte, indem er das Verzeichnis "target" löscht.

#### compile
```console
mvn compile
```
Kompiliert den Sourcecode je nach Abhängigkeit von Plugins.
Wenn also beispielsweise ein Maven-Compiler-Plugin verwendet wird, so wird dieses als Regelwerk für die Kompilierung herangezogen.

#### test
```console
mvn test
```
Führt alle Tests aus. In einem Java-Projekt sind dies beispielsweise alle Unit-Tests mit jUnit.

#### package
```console
mvn package
```
Führt einen lokalen Maven-Build aus, startet alle Tests und paketiert die Anwendung (normalerweise als JAR) in das Verzeichnis "target".

#### verify
```console
mvn verify
```
Prüft die Testergebnisse aller ausgeführten Integrationstests, normalerweise wird das Maven-Failsafe-Plugin für diesen Maven-Befehl vorausgesetzt.

#### install
```console
mvn install
```
"Installiert" den Artefakt im lokalen Maven-Repository.

#### deploy
```console
mvn deploy
```
"Installiert" den Artefakt im Remote-Repository (Artifactory).

Die Maven-Befehle lassen sich kombinieren. Sehr nützlich ist zum Beispiel:
```console
mvn clean install
```

Selbstverständlich gibt es sehr viele zusätzliche Optionen für die einzelnen Maven-Befehle.

---
