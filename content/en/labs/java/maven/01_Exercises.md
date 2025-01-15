---
title: "Maven - Aufgaben"
linkTitle: "Maven - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #S2 - [Maven](../../../../docs/java/maven)
---

## Auftrag

### Einrichten von Maven

- Generierung REPOSITORY_KEY
- Aufsetzen settings.xml
- IntelliJ Einstellungen überprüfen
- Umgebungsvariable einstellen

### Maven-Projekt aufsetzen

Erstellen eines neuen Projekts, welches wir später für das Modul Unit-Testing verwenden werden.

1. Erstellen eines neuen persönlichen Repositories auf code.sbb.ch, der Name kann frei gewählt werden
2. Klonen des neuen Repositories mit IntelliJ IDEA
3. Repository einrichten, wie auf code.sbb.ch beschrieben (nachdem man das Repo erstellt hat)
4. Im IntelliJ die für Maven erforderliche Ordnerstruktur erstellen
   - Ordner src erstellen
   - Im Ordner src zwei Ordner erstellen: main und test
   - In den beiden Ordnern main und test jeweils zwei weitere Ordner erstellen: java und resources
   - Die Ordner markieren (Rechtsklick -> Mark Directory as...)
     - src/main/java -> Sources Root
     - src/main/resources -> Resources Root
     - src/test/java -> Test Sources Root
     - src/test/resources -> Test Resources Root
5. Am Root des Projektes eine Datei mit dem Namen pom.xml anlegen und den folgenden Inhalt einfügen:

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>

       <groupId>Deine Group-ID</groupId>
       <artifactId>Deine Artifact-ID</artifactId>
       <version>0.0.1-SNAPSHOT</version>
       <name>Name des Projekts</name>
       <description>Beschreibung des Projekts</description>

       <properties>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
           <java.version>Java-Version wählen</java.version>
           <maven.build.timestamp.format>yyyy-MM-dd HH:mm</maven.build.timestamp.format>
           <timestamp>${maven.build.timestamp}</timestamp>
       </properties>

       <dependencies>
           <!-- Test -->
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter</artifactId>
               <version>5.6.2</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter-api</artifactId>
               <version>5.6.2</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter-engine</artifactId>
               <version>5.6.2</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter-params</artifactId>
               <version>5.6.2</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.vintage</groupId>
               <artifactId>junit-vintage-engine</artifactId>
               <version>5.6.2</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.platform</groupId>
               <artifactId>junit-platform-engine</artifactId>
               <version>1.7.0-RC1</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.platform</groupId>
               <artifactId>junit-platform-commons</artifactId>
               <version>1.7.0-RC1</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.mockito</groupId>
               <artifactId>mockito-core</artifactId>
               <version>4.1.0</version>
               <scope>test</scope>
           </dependency>
       </dependencies>

       <build>
           <plugins>
               <plugin>
                   <groupId>org.apache.maven.plugins</groupId>
                   <artifactId>maven-compiler-plugin</artifactId>
                   <configuration>
                       <compilerVersion>${java.version}</compilerVersion>
                       <source>${java.version}</source>
                       <target>${java.version}</target>
                   </configuration>
               </plugin>
           </plugins>
       </build>

       <developers>
           <developer>
               <id>Deine Personalnummer</id>
               <name>Dein Name</name>
               <email>Dein E-Mail</email>
               <organization>SBB</organization>
               <organizationUrl>https://www.sbb.ch</organizationUrl>
               <roles>
                   <role>Deine Rolle</role>
               </roles>
           </developer>
       </developers>
   </project>
   ```

6. Passe die GroupID und ArtifactID gemäss der Theorie an. Dabei könntest du für die GroupID ch.sbb.{dein_name} und für die ArtifactID die aktuelle Aufgabe wählen, also zum Beispiel `ch.sbb.johncarmack:J5`.
7. Das Projekt im IntelliJ als Maven-Projekt hinterlegen, zu diesem Zweck Ctrl+Shift+A drücken und als Aktion "Maven" eintragen.<br>
   Aus der Liste dann entweder "Add as Maven Project" oder "Add Maven Projects" wählen.<br>
   Bei der ersten Aktion wird das Projekt direkt hinzugefügt, bei der zweiten muss das pom.xml noch ausgewählt werden
8. Auf der rechten Seite in IntelliJ gibt es den Tab Maven, dort müsste das Projekt nun erscheinen.

Wenn alles geklappt hat, dann werden die definierten Abhängigkeiten aus dem POM in das lokale Repository heruntergeladen.

---

Hier kannst du [zurück zur Theorie](../../../../docs/java/maven).
