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
Spring Boot Projekt machen, dort kann man dann auch weitere Abhängigkeiten hinzufügen und so weiter.

### Boot Spezifische Annotationen

Für Spring Boot gibt es spezifische Annotationen, die `@SpringBootApplication` konfiguriert eine
Klasse. Die `@SpringBootApplication` Annotation ist equivalent
zu `@Configuration`, `@EnableAutoConfiguration` und `@ComponentScan`. Die `@EnableAutoConfiguration`
Annotation schaltet die automatische Konfiguration ein was einer der Hauptbestandteile von Spring
Boot ist.