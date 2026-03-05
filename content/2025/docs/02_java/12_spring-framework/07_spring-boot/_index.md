---
title: "Spring Boot"
linkTitle: "Spring Boot"
weight: 7
description: >
  Modul #J8 - Spring Framework - Spring Boot
---

#### Ziele

- Ich weiss was Spring Boot ist und wofür es verwendet wird.
- Ich kenne die Unterschiede zwischen dem Spring-Framework und Spring Boot.
- Ich kann eine einfache Spring Boot Applikation erzeugen (Bootstrap).
- Ich kenne die am häufigsten verwendeten Spring Boot Annotationen (z.B. `@SpringBootApplication`,
  `@EnableAutoConfiguration`) und deren Bedeutung.
- Ich weiss was ein Spring Boot Starter ist und kenne die am häufigsten verwendeten
  Spring Boot Starter (z.B. Web-Starter, Test-Starter usw.) und deren Zweck.
- Ich kann eine Rest-Schnittstelle mit Spring Boot erstellen und diese mit Insomnia (o.ä)
  ausführen und testen

---

## Spring Boot

Spring Boot ist ein Projekt von Spring, welches dazu gemacht ist, einfacher Spring benutzen
zu können. Es gibt viele Voreinstellungen, die auch nachträglich noch geändert werden können. Es gibt auch
den [Spring Initializr](https://start.spring.io/), der ein Spring Boot Projekt erstellt.
Dort kann man dann auch weitere Abhängigkeiten und Funktionalitäten hinzufügen.

Spring Boot nimmt uns eigentlich sehr viel Arbeit ab, wenn man damit umzugehen weiss.
Z.B. beherrscht Spring Boot die Autokonfiguration, kann zusätzlich eigenständige Anwendungen
erstellen und vieles mehr. Wir gehen hier aber nur auf die wichtigsten Aspekte ein.

- Autokonfiguration: Autokonfiguration bedeutet, dass deine Anwendungen bereits mit voreingestellten
  Abhängigkeiten initialisiert werden. Dies dient hauptsächlich dazu, Zeit zu sparen und blöde Fehler
  bei der Konfiguration zu vermeiden. Durch die Autokonfiguration erhältst du ein sofort ausführbares Programm.
- Meinungsansatz: Spring Boot wählt nach eigenem Ermessen Pakete aus und welche
  Standardwerte verwendet werden sollen, damit wir das nicht selbst machen müssen. Standard Spring
  Boot umfasst über 50 solcher Spring Starter, jedoch gibt es noch viele weitere, die von
  Drittanbietern zur Verfügung gestellt werden.
- Eigenständige Anwendungen: Spring Boot kann selbst Anwendungen erstellen, die eigenständig ausgeführt
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

In der Praxis lohnt sich die Verwendung von Spring Boot, ausser du benötigst eine sehr einzigartige
Konfiguration. Da man mit Boot auch auf das Annotationssystem des Spring Frameworks
zugreifen kann und der Anwendung immer problemlos zusätzliche Abhängigkeiten hinzufügen kann,
wird Boot in den meisten Fällen empfohlen.

### Spring Boot spezifische Annotationen

Für Spring Boot gibt es spezifische Annotationen. Die `@SpringBootApplication` konfiguriert eine
Klasse. Die `@SpringBootApplication` Annotation ist equivalent
zu `@Configuration`, `@EnableAutoConfiguration` und `@ComponentScan`. Die `@EnableAutoConfiguration`
Annotation schaltet die automatische Konfiguration ein, was einer der Hauptbestandteile von Spring
Boot ist.
Mehr dazu findest du [hier](../06_annotationen).

## Debuggen von Spring Boot

Spring Boot Code ist in Java geschrieben, dementsprechend bleibt das Debuggen grundsätzlich gleich.
Jedoch musst du die Interaktionen zwischen Repositorys, Services und Controllern gut verstehen und wissen,
wo du die Breakpoints zu setzen hast. Im Zweifelsfall kann dir die Funktion Step Into behilflich sein.

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgaben](../../../../labs/02_java/12_spring-framework/01_Spring) in den Labs.
