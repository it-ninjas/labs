---
title: "Spring"
linkTitle: "Spring"
weight: 2
description: >
  Modul #J8 - Spring Framework - Spring
---

## Spring

### Ziele

- Ich kann am Beispiel Spring erklären, was ein "Framework" ausmacht, indem ich Unterschiede zu einer gewöhnlichen externen Library aufzählen kann.
- Ich kenne einige Vor- und Nachteile, wenn ein Frameworks im Projekt eingesetzt wird.
- Ich kann erläutern, welche Zuständigkeiten die folgenden Module im Spring-Framework haben: Core, Data-Access, Web und
  welche Aufgaben sie erfüllen.
- Ich bin mit den bedeutendsten Spring-Projekten (Spring-Boot, Spring-Cloud, Spring-Security) vertraut, und kann erklären, wann und wofür welche eingesetzt werden.
- Ich verstehe das Konzept hinter "Inversion of Control" (IoC) und kann erklären, auf welche Art und Weise es in Spring eingesetzt wird.
- Ich kann mind. 2 Arten auflisten, wie "Dependency-Injection" (DI) dazu verwendet werden kann, um Variabeln automatisch einen Wert zuzuweisen.
  (Constructor-Based, Setter-Based, Field-Based) um DI in Spring zu benutzen.
- Ich kann das Konzept hinter `@Bean`s in Spring skizzieren und kann erläutern, wie `@Bean`s definiert und verwendet werden können.
- Ich kann den Scopes einer "Spring-Beans" ändern. (z.B. Singleton, Session, Application
  usw.).
- Ich kenne die am häufigsten verwendeten Spring-Bean-Annotationen `@Service`, `@Configuration`,
  `@Component`, `@Repository`, `@Controller` und weiss, wie ich diese einsetze und welchen Zweck sie
  erfüllen.
- Ich weiss, was "Wiring" bedeutet und wie es in Spring verwendet wird.
- Ich kann in Spring-Projekten sogenannte Properties setzen und abfragen.
- Ich kenne Anwendungsfälle, in welchen Spring-Profiles verwendet werden und weiss, wie ich sie setzen kann.

### Framework

Ein Framework kann die Grundstruktur für Applikationen vorgeben.
Es stellt Funktionen, Bibliotheken und Regeln bereit, um den Entwicklungsprozess zu erleichtern und zu beschleunigen.
Häufig gibt es eine standartisierte Struktur und Methodik vor, um eine gewisse Konsistenz und Qualität des Codes und der Software sicherzustellen.

## Spring Framework

Das Spring Framework ist ein weit verbreitetes Framework für die Entwicklung von Java-Anwendungen.
Es bietet eine umfassende Infrastruktur, die Entwicklern hilft, robuste und wartbare Anwendungen zu erstellen.
Eines der Kernkonzepte von Spring ist die Inversion of Control (IoC), bei der das Framework die Verantwortung
für das Erstellen und Verwalten von Objekten übernimmt, anstatt dass der Entwickler dies manuell tun muss.

Spring bietet viele nützliche Module und Funktionen, wie z.B. Spring MVC für die Entwicklung von Webanwendungen,
Spring Data für den einfachen Zugriff auf Datenbanken und Spring Security für die Implementierung von Sicherheitsfunktionen.
Durch die Nutzung von Spring können Entwickler sich auf die Geschäftslogik ihrer Anwendungen konzentrieren,
während das Framework viele der wiederkehrenden Aufgaben übernimmt. Dies führt zu saubererem, besser organisiertem Code
und erleichtert die Wartung und Erweiterung der Anwendungen.

### Module

Das Spring-Framework besteht aus verschiedenen Modulen, die unterschiedliche Aufgaben erfüllen und in Kategorien wie
Core, Data Access, Web usw. organisiert sind.

![spring-module-overview.png](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/images/spring-overview.png)

Quelle: https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/images/spring-overview.png

Das Core-Modul umfasst essenzielle Funktionen wie Dependency Injection. Das Beans-Modul beinhaltet alles, was zur
Erstellung von Beans benötigt wird.

Das JDBC-Modul bietet ein JDBC-Interface für den Datenbankzugriff. Das ORM-Modul ermöglicht den Zugriff auf
Object-Mapping-APIs wie JPA, JDO, Hibernate. Das OXM-Modul ermöglicht den Zugriff auf
Objekt/XML-Speicher-Implementierungen.

Das Web-Modul ist für die Kommunikation mit der Aussenwelt (Internet) verantwortlich.

Weitere Informationen befinden sich in der offiziellen
[Dokumentation](https://docs.spring.io/spring-framework/docs/4.0.x/spring-framework-reference/html/index.html).

### Spring Projekte

Es gibt verschiedene Spring-Projekte, die auf dem Spring Framework aufbauen und dessen Anwendungsmöglichkeiten
erweitern. Zu diesen gehören z. B. Spring Security, Spring Shell, Spring Boot, die jeweils spezifische
Funktionalitäten bereitstellen.

Mehr dazu auf [GitHub Spring Projects](https://github.com/spring-projects).

#### Spring Boot

[Spring Boot](../07_spring-boot) vereinfacht das normale Spring Framework. Mit dem Spring Initializer können Abhängigkeiten wie
Datenbanktreiber oder Software für die Cloud-Infrastruktur ausgewählt werden, was die manuelle Konfiguration des
Projekts überflüssig macht. Spring Boot ist jedoch kein Ersatz für das Spring Framework, sondern vereinfacht die
Konfiguration.
