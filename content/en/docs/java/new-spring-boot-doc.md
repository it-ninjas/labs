---
title: "New Spring Boot Doc"
linkTitle: "New Spring Boot Doc"
weight: 17
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
* Ich kann, eine Rest-Schnittstelle mit Spring-Boot erstellen und diese mit Postman (o.ä)
  ausführen/testen

---

## Spring Boot

Spring Boot ist ein Projekt von Spring, welches dazu gemacht ist, dass man einfacher Spring benutzen
kann, es konfiguriert viele Einstellungen wobei man sie immer noch anpassen kann, es gibt auch
[Spring Boot Initialisierer](https://start.spring.io/#!type=maven-project&language=java) welche ein
Spring Boot Projekt machen, dort kann man dann auch weitere Abhängigkeiten hinzufügen und so weit.

Spring Boot nimmt uns eigentlich sehr viel Arbeit ab, wenn man damit umzugehen weiß.
Z.b. beherrscht spring Boot die Autokonfiguration, kann zusätzlich eigenständige Anwendungen 
erstellen und vieles mehr. Wir gehen hier aber nur auf die wichtigsten Sachen ein.
* Autokonfiguration: Autokonfiguration bedeutet, dass deine Anwendungen bereits mit voreingestellten
Abhängigkeiten initialisiert werden. Dies dient hauptsächlich dazu, Zeit zu sparen und blöde Fehler 
bei der Konfiguration zu vermeiden.
* Meinungsansatz: Spring Boot wählt nach eigenem Ermessen Pakete aus, welche installiert und welche 
Standardwerte verwendet werden sollen, damit wir das nicht selbst machen müssen. Das Standard Spring
Boot umfasst über 50 solcher spring Starter, jedoch gibt es noch viele weitere, die von 
Drittanbietern zur Verfügung gestellt werden.
* Eigenständige Anwendungen: Spring Boot kann selbst Anwendungen erstellen, die selbst ausgeführt 
werden, ohne sich auf einen externen Webserver zu verlassen. Infolgedessen kannst du deine Anwendung
auf jeder Plattform starten, indem du einfach auf ausführen drückst. (Falls man eine Anwendung ohne 
eingebetteten Webserver erstellen will, kann man diese Funktion einfach deaktivieren).

Nun ist aber die Frage, was ist überhaupt der Unterschied zwischen Spring Framework und Spring Boot?
Und welches davon ist besser?

Da Spring Boot auf dem Spring Framework aufbaut, gibt es in der Grundstruktur keine großen 
Unterschiede. Jedoch einer der größten Unterschiede ist das Spring Boot sehr viel auf 
Komfortfunktionen setzt wie z.b. einen schnellen Projektstart, Starter Pakete und so weiter. 
Zudem besitzt Spring Boot noch Funktionen wie z.b. Eingebetteter Server, um Komplexität zu vermeiden.
Automatische Konfigurationen für die Spring Funktionalität.

In der Praxis lohnt sich eine Verwendung von Spring Boot, außer du benötigst eine sehr einzigartige
Konfiguration implementieren. Da man mit Boot auch auf das Annotationssystemvon dem Spring Framework
zugreifen kann und der Anwendung immer problemlos zusätzliche Abhängigkeiten hinzufügen kann, 
wird Boot in den meisten Fällen empfohlen.



### Boot Spezifische Annotationen

Für Spring Boot gibt es spezifische Annotationen, die `@SpringBootApplication` konfiguriert eine
Klasse. Die `@SpringBootApplication` Annotation ist equivalent
zu `@Configuration`, `@EnableAutoConfiguration` und `@ComponentScan`. Die `@EnableAutoConfiguration`
Annotation schaltet die automatische Konfiguration ein was einer der Hauptbestandteile von Spring
Boot ist.

### Spring Boot Starter

Wichtig zu erwähnen ist, dass die hier aufgeführten Starter nur ein Bruchteil von allen sind.
Es sind jedoch die wichtigsten und am häufigsten verwendeten Starter.
* Test Starter: Für Testing brauchen wir normalerweise ein paar der folgenden Erweiterungen:
  JUnit, Hamcrest, Mockito oder Spring Test. Diese könnten wir Manuel einbringen oder wir verwenden
  den Test Starter der das für uns erledigt.
* Data JPA Starter: Der Data JPA Starter hilft dir, dich effizient mit relationalen
  Datenbanken zu verbinden. Intern verwendet der Data JPA Starter die Spring-boot-Jpa-Abhängigkeit.
  Jedoch schreiben wir die SQL-Abfragen nicht mehr wie z.b. bei JDBC, den in der JPA speichern wir
  die Daten von Objekten in Tabellen und umgekehrt.
* Mail Starter: vielleicht wirst du diesen Starter nicht allzu oft verwenden,
  jedoch ist es wichtig ihn zu erwähnen, dass du ihn kennst. Der Mail Starter kann hilfreich sein,
  in der Unternehmensentwicklung, da wir dort das Senden von E-Mails und der direkte Umgang
  mit Java Mail API normalerweise schwierig sein kann. Mail Starter verbirgt diese Komplexitäten.

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

