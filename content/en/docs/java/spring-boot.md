---
title: "Spring Boot"
linkTitle: "Spring Boot"
weight: 15
description: >
  Modul #J11 - Spring Boot
---

#### Ziele

* Ich weiss, was Spring-Boot ist und wozu es verwendet wird.
* Ich kenne die Unterschiede zwischen dem Spring-Framework und Spring-Boot.
* Ich kann eine einfache Spring-Boot-Applikation erzeugen (Bootstrap).
* Ich kenne die, am häufigsten verwendeten Spring-Boot Annotationen (z.B. `@SpringBootApplication`,
  `@EnableAutoConfiguration`) und deren Bedeutung.
* Ich weiss, was ein Spring-Boot-Starter ist und kenne die am häufigsten verwendeten
  Spring-Boot-Starter (z.B. Web-Starter, Test-Starter usw.) und deren Zweck.
* Ich kann, eine Rest-Schnittstelle mit Spring-Boot erstellen und diese mit Insomnia (o.ä)
  ausführen/testen

---

## Spring Boot

Spring Boot ist ein Projekt von Spring, welches dazu gemacht ist, einfacher Spring benutzen
zu können. Es gibt viele Voreinstellungen, die auch nachträglich noch geändert werden können. Es gibt auch
den [Spring Initializr](https://start.spring.io/), der ein Spring Boot Projekt erstellt.
Dort kann man dann auch weitere Abhängigkeiten und Funktionalitäten hinzufügen.

Spring Boot nimmt uns eigentlich sehr viel Arbeit ab, wenn man damit umzugehen weiß.
Z.B. beherrscht Spring Boot die Autokonfiguration, kann zusätzlich eigenständige Anwendungen 
erstellen und vieles mehr. Wir gehen hier aber nur auf die wichtigsten Aspekte ein.
* Autokonfiguration: Autokonfiguration bedeutet, dass deine Anwendungen bereits mit voreingestellten
Abhängigkeiten initialisiert werden. Dies dient hauptsächlich dazu, Zeit zu sparen und blöde Fehler 
bei der Konfiguration zu vermeiden. Durch die Autokonfiguration erhältst du ein sofort ausführbares Programm.
* Meinungsansatz: Spring Boot wählt nach eigenem Ermessen Pakete aus und welche 
Standardwerte verwendet werden sollen, damit wir das nicht selbst machen müssen. Standard Spring
Boot umfasst über 50 solcher Spring Starter, jedoch gibt es noch viele weitere, die von 
Drittanbietern zur Verfügung gestellt werden.
* Eigenständige Anwendungen: Spring Boot kann selbst Anwendungen erstellen, die eigenständig ausgeführt 
werden, ohne sich auf einen externen Webserver zu verlassen. Infolgedessen kannst du deine Anwendung
auf jeder Plattform starten, indem du einfach auf ausführen drückst. Falls man eine Anwendung ohne 
eingebetteten Webserver erstellen will, kann man diese Funktion einfach deaktivieren.

Nun ist aber die Frage, was ist überhaupt der Unterschied zwischen dem Spring Framework und Spring Boot?
Und was davon ist besser?

Da Spring Boot auf dem Spring Framework aufbaut, gibt es in der Grundstruktur keine grossen 
Unterschiede. Einer der grössten Unterschiede ist jedoch, dass Spring Boot sehr viel auf
Komfortfunktionen setzt wie z.B. einen schnellen Projektstart, Starter Pakete und so weiter. 
Zudem besitzt Spring Boot noch Funktionen wie z.B. eingebettete Server, um Komplexität zu vermeiden aber auch 
automatische Konfigurationen für die Spring Funktionalität.

In der Praxis lohnt sich eine Verwendung von Spring Boot, außer du benötigst eine sehr einzigartige
Konfiguration. Da man mit Boot auch auf das Annotationssystem des Spring Frameworks
zugreifen kann und der Anwendung immer problemlos zusätzliche Abhängigkeiten hinzufügen kann, 
wird Boot in den meisten Fällen empfohlen.

### Boot Spezifische Annotationen

Für Spring Boot gibt es spezifische Annotationen. Die `@SpringBootApplication` konfiguriert eine
Klasse. Die `@SpringBootApplication` Annotation ist equivalent
zu `@Configuration`, `@EnableAutoConfiguration` und `@ComponentScan`. Die `@EnableAutoConfiguration`
Annotation schaltet die automatische Konfiguration ein, was einer der Hauptbestandteile von Spring
Boot ist.

### Spring Boot Starter

Wichtig zu erwähnen ist, dass die hier aufgeführten Starter nur ein Bruchteil von allen verfügbaren sind.
Es sind jedoch die wichtigsten und am häufigsten verwendeten Starter.
* Test Starter: Für Testing brauchen wir normalerweise ein Paar der folgenden Erweiterungen:
  JUnit, Hamcrest, Mockito oder Spring Test. Diese könnten wir manuell einbinden oder verwenden
  den Test Starter der das für uns erledigt.
* Data JPA Starter: Der Data JPA Starter hilft dir, dich effizient mit relationalen
  Datenbanken zu verbinden. Intern verwendet der Data JPA Starter die Spring-boot-Jpa-Abhängigkeit.
  Jedoch schreiben wir die SQL-Abfragen nicht mehr wie z.b. bei JDBC, denn in der JPA speichern wir
  die Daten von Objekten in Tabellen und umgekehrt.
* Mail Starter: Vielleicht wirst du diesen Starter nicht allzu oft verwenden,
  jedoch ist es wichtig ihn zu erwähnen, damit du ihn kennst. Der Mail Starter kann hilfreich sein
  in der Unternehmensentwicklung, da dort das Senden von E-Mails und der direkte Umgang
  mit Java Mail API normalerweise schwierig sein kann. Mail Starter verbirgt diese Komplexitäten.
* Web Starter: Der Spring Boot Web Starter konfiguriert dir automatisch folgende Dinge: Dispatcher,
  Servlet, Fehlerseite, Web-JAR's und Eingebettete Servlet-Behälter. Dies sind alles wichtige
  Konfigurationen, wenn du ein Spring Boot Backend für Web aufbauen willst.

Nun schauen wir uns noch kurz an, wie man diese Starter in sein Projekt einbringen würde:

Test Starter:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
Data JPA Starter
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
Mail Starter
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
Web Starter
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>2.2.2.RELEASE</version>
</dependency>  
```