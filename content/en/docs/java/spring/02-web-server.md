---
title: "Simples Backend"
linkTitle: "Simples Backend"
weight: 2
description: >
  Modul #J10 - Spring Framework
---

# Backends / Web-Server
Ein Backend - wofür wir z.B. Spring Boot verwenden - ist vereinfacht gesagt ein HTTP-Request-Handler: Er akzeptiert HTTP-Anfragen (Request) und beantwortet diese (Response).

Vorher haben wir uns angeschaut, wie wir in Java eine HTTP-Anfrage auf einen anderen Server schicken können.

Nun kehren wir den Spiess um:

Wir stellen den Web-Server zur Verfügung und akzeptieren eingehende HTTP-Anfragen und beantworten diese.

Hierfür bauen wir uns eine sehr kleine Webanwendung mit Spring Boot. Ziel dieses Kapitels ist es noch nicht, Spring Boot zu verstehen, sondern was ein Backend tut (HTTP-Request-Handler).


## Erstes Backend aufsetzen

Um ein einfaches Backend zu erstellen, gehe auf https://start.spring.io/ und erstelle ein neues Spring-Projekt mit folgenden Werten:
| Eigenschaft   | Wert              |
| ------------- | ------------------|
| Project       | Maven             |
| Language      | Java              |
| Spring Boot   | 3.2.0             |
| Java          | 17 (oder neuer)   |

Klicke anschliessend auf "Generate" und entpacke die heruntergeladen Datei. Öffne das Maven-Projekt anschliessend.

Stelle anschliessend sicher, dass du im `pom.xml` unter `<dependencies>` folgende Abhängigkeit registriert hast:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Installiere anschliessend die Dependencies mit `mvn install` oder wenn das nicht klappt, dann in IntelliJ: "View" -> "Tool Window" -> "Maven" und dann im neuen Tab auf der Seite den Projektnamen aufklappen und innerhalb von "Lifecycle" dann "install" ausführen.

Anschliessend prüfst du rasch, ob das Backend funktioniert, indem du die Klasse mit der `main()`-Methode ausführst (`src/main/java/.../?Application.java`). Du solltest eine solche Ausgabe erhalten:

```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

2023-12-19T17:07:19.801+01:00  INFO 12836 --- [           main] c.i.s.SimpleBackendApplication           : Starting SimpleBackendApplication using Java 17.0.9
2023-12-19T17:07:19.803+01:00  INFO 12836 --- [           main] c.i.s.SimpleBackendApplication           : No active profile set, falling back to 1 default profile: "default"
2023-12-19T17:07:20.207+01:00  INFO 12836 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2023-12-19T17:07:20.212+01:00  INFO 12836 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-12-19T17:07:20.212+01:00  INFO 12836 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.16]
2023-12-19T17:07:20.235+01:00  INFO 12836 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-12-19T17:07:20.235+01:00  INFO 12836 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 411 ms
2023-12-19T17:07:20.384+01:00  INFO 12836 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2023-12-19T17:07:20.388+01:00  INFO 12836 --- [           main] c.i.s.SimpleBackendApplication           : Started SimpleBackendApplication in 0.744 seconds (process running for 0.979)
```

## Erste REST-Schnittstelle definieren
Erstelle nun eine Java-Klasse mit der Endung "Controller.java" (z.B. `HelloWorldController`) mit einem Inhalt wie diesen:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    @GetMapping("/{name}")
    public String helloWorld(@PathVariable String name) {
        return "Hello " + name;
    }
}
```

Öffne nun mit deinem Browser diese URL: http://localhost:8080/hello-world/ninja

Im Browser solltest du folgendes sehen:

![Spring Hello World](./02-01-hello-world.png)

Im Browser siehst du also nun den Rückgabewert der Methode `helloWorld`, weil du die URL `"/hello-world/{name}"` auf diese Methode umgeleitet hast. Das Argument `name` hast du mit `@PathVariable` annotiert, damit der Wert aus der URL ausgelesen wird.

Folgende Annotationen hast du verwendet, die folgendes tun:

| Annotation                        | Zweck                                                                                                                 |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `@RestController`                 | Definiert eine Klasse als Controller: Die Klasse handelt HTTP-Anfragen.                                               |
| `@RequestMapping("/hello-world")` | Definiert, mit welcher URL die Anfragen beginnen, die von dieser Klasse abgehandelt werden.                           |
| `@GetMapping("/{name}")`          | Definiert, dass nur Anfragen von dieser Methode abgefangen werden, die mit der HTTP-Methode `GET` verschickt werden.  |