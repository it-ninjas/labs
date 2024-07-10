---
title: "Testing von REST-Schnittstellen"
linkTitle: "Testing von REST-Schnittstellen"
weight: 16
description: >
  Modul #J10 - Spring Boot
---

Wenn du ein Backend schreibst - was du mit Spring in den meisten Fällen tust, dann möchtest du deinen Code auch ausführen können.
Um deine HTTP-Schnittstellen zu triggern, musst du entsprechende HTTP-Anfragen an dein Backend schicken. Dies kannst du mit HTTP-Clients tun.
Es gibt einen Haufen solcher Programme. In diesem Kapitel zeigen wir dir ein paar.

## Warum werden REST-Schnittstellen getestet?
Das Testen von REST-Schnittstellen trägt dazu bei, die Qualität, Sicherheit und Leistung von APIs zu gewährleisten, sodass sie zuverlässig und effektiv genutzt werden können.


## Swagger
Das erste Tool, das wir vorstellen, um HTTP-/REST-Schnittstellen zu triggern (und zu testen) ist Swagger.
Das tolle an Swagger ist, dass viele Backends (auch Spring) dieses bereits integriert haben, ohne dass du ein weiteres Programm installieren musst.

Swagger ist ein Open-Source-Framework, das zur Dokumentation und zum Testen von "RESTful" Webdiensten verwendet wird.
REST steht für "Representational State Transfer" und bezieht sich auf ein Architekturstil für die Entwicklung von Netzwerkanwendungen.
Swagger bietet Werkzeuge und Spezifikationen, die Entwicklern, Architekten und anderen Beteiligten dabei helfen, 
RESTful APIs zu entwerfen, zu erstellen, zu dokumentieren und die Interoperabilität zwischen verschiedenen Tools und Plattformen zu fördern. Es erleichtert die Kommunikation zwischen Frontend- und Backend-Entwicklern, da die API-Spezifikationen in einer einheitlichen, leicht verständlichen Form vorliegen und Beispiele zeigt, wie eine REST-Schnittstelle aufgerufen werden kann mit welchen Parametern.

Mit Spring Boot 3 wird neu nur noch einen Dependency benötigt, damit der Swagger läuft:
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>
```

Wenn man nun die Applikation startet, kann man auf die URL http://localhost:8080/swagger-ui/index.html# zugreifen. Dort sieht man dan folgendes:

[SwaggerOverview](../java-rest-testing/SwaggerOverview.png)

Auf dem untenstehenden Bild kann man die API-Schnittstelle von einer GET-Anfrage sehen. Mit einem Klick auf den `Try it out`-Button kann man nachher diese Anfrage ausprobieren.

![SwaggerGet](../java-rest-testing/SwaggerGet.png)

Nun erscheint ein grosser blauer Button mit der Aufschrift `Execute`. Auf Knopfdruck wird die GET-Anfrage gesendet und die Antwort wird nach Erhalt angezeigt.

![SwaggerGetTryOut](../java-rest-testing/SwaggerGetTryOut.png)

Was bei den GET-Anfragen galt, gilt auch für POST-Requests. Im Unterschied zur vorherigen Schnittstelle muss bei dieser zusätzlich ein Request Body im JSON-Format angegeben werden.

Möchte man z.B. `GetById` ausführen, dann muss möglicherweise auch noch eine ID angegeben werden.

![SwaggerPost](../java-rest-testing/SwaggerPost.png)

Das Json für den Request-Body kann auch hier erst nach einem Klick auf "Try it out" spezifiziert werden:

![SwaggerPostTryOut](../java-rest-testing/SwaggerPostTryOut.png)

Wenn deine API Zugriffsbeschränkungen oder Authentifizierungsschichten implementiert, ist eine Anpassung der Swagger-Konfiguration notwendig, um diese Sicherheitsmechanismen zu berücksichtigen.

Konfigurationen von Swagger können in verschiedenen Aspekten angepasst werden. Hier sind einige allgemeine Anpassungen:
* Paketfilter für die API-Endpunkte festlegen  `.apis()`
* API-Endpunkt-Pfade filtern `.paths()`
* Allgemeine API-Informationen konfigurieren `.apiInfo()`
* Globale Sicherheitsdefinitionen hinzufügen `.securitySchemes()`, `.securityContexts()`


```java
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Song API",
                "Swagger API for self project",
                "1.0",
                "",
                "Cédric rohrbach",
                "",
                ""
        );
        return apiInfo;
    }
}
```


## IntelliJ HTTP Client
Der IntelliJ HTTP Client ist ein eingebauter HTTP-Client, der Entwicklern ermöglicht, HTTP-Anfragen an Webdienste oder RESTful-APIs zu senden und die Antworten zu überprüfen. 
Dies ist nützlich, um Web-APIs schnell zu testen, ohne eine separate Anwendung von Drittanbietern installieren zu müssen.

Damit man den HTTP Client verwenden kann, muss man zuerst ein solches File erstellen. Dies kann wie folgt getan werden:

![HttpRequestFile](../java-rest-testing/HttpRequestFile.png)

Einige Entwickler legen die HTTP-Dateien in einem separaten Ordner wie "http" oder "requests" im Hauptverzeichnis ihres Projekts ab. Andere bevorzugen es, die HTTP-Dateien im Verzeichnis des Moduls zu speichern, das sie verwenden.

Im File kann man zum Beispiel eine Get Abfrage nach folgenden Schema erstellen.
```
GET http://localhost:8080/api/student/subjects
Accept: application/json
```
Das `api/student/subjects` ist das RequestMapping, welchen in den Controllern festgelegt wurden für den API-Schnittpunkt.

Eine POST- oder PUT-Anfrage, welchen einen Request-Body benötigt, ist wie folgt aufgebaut:
```
POST http://localhost:8080/api/admin/subjects
Content-Type: application/json

{
  "key1": "value1",
  "key2": "value2"
}
```

Wenn man nun die Applikation startet, kann man diese HTTP-Anfrage ausführen und sehen, was die Schnittstelle antwortet.