---
title: "Testing von REST-Schnittstellen"
linkTitle: "Testing von REST-Schnittstellen"
weight: 15
description: >
  Modul #J11 - Testing von REST-Schnittstellen
---

## Warum werden REST-Schnittstellen getestet?
Das Testen von REST-Schnittstellen trägt dazu bei, die Qualität, Sicherheit und Leistung von APIs zu gewährleisten, sodass sie zuverlässig und effektiv genutzt werden können.


## Swagger
Swagger ist ein Open-Source-Framework, das zur Dokumentation von RESTful Webdiensten verwendet wird. Es bietet Werkzeuge und Spezifikationen, die Entwicklern, Architekten und anderen Beteiligten dabei helfen, 
RESTful APIs zu entwerfen, zu erstellen, zu dokumentieren und die Interoperabilität zwischen verschiedenen Tools und Plattformen zu fördern. Es erleichtert die Kommunikation zwischen Frontend- und Backend-Entwicklern, da die API-Spezifikationen in einer einheitlichen, leicht verständlichen Form vorliegen..

Mit Spring Boot 3 kann man neu nur noch einen Dependency hinzufügen damit der Swagger läuft. Diese sieht folgerndermassen aus:
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.2.0</version>
</dependency>
```

Wenn man nun die Applikation startet, kann man auf die URL http://localhost:8080/swagger-ui/index.html# zugreifen. Dort sieht man dan folgendes:

[SwaggerOverview](./java-rest-testing/SwaggerOverview.png)

Auf dem untenstehenden Bild kann man die API-Schnittstelle von einem GET sehen. Damit man diese testen kann, muss man rechts auf den `Try it out` Button drücken.

[SwaggerGet](./java-rest-testing/SwaggerGet.png)

Nun erscheint ein grosser blauer Button namens `Execute`. Wenn man diesen betätigt wird die GET Request abgesendet und die Antwort wird angezeigt.

[SwaggerGetTryOut](./java-rest-testing/SwaggerGetTryOut.png)

Das genau gleich wie beim GET gilt auch für einen POST. Der Unterschied ist das man hier noch den Request Body angeben muss in JSON Format. Evtl. auch noch eine ID, diesen muss jedoch auch so angegeben werden, wenn man zum Beispiel ein GetById ausführen möchte.

[SwaggerPost](./java-rest-testing/SwaggerPost.png)

[SwaggerPostTryOut](./java-rest-testing/SwaggerPostTryOut.png)


## IntelliJ HTTP Client
Der IntelliJ HTTP Client ist ein eingebauter HTTP-Client, der Entwicklern ermöglicht, HTTP-Anfragen an Webdienste oder RESTful-APIs zu senden und die Antworten zu überprüfen. 
Dies ist nützlich, wenn Sie mit Web-APIs arbeiten und diese schnell und effizient testen möchten, ohne eine separate Anwendung oder Werkzeuge von Drittanbietern verwenden zu müssen.

Damit man den HTTP Client verwenden kann muss man zuerst ein solches File erstellen. Dies kann wie folgt getan werden:

[HttpRequestFile](./java-rest-testing/HttpRequestFile.png)

Einige Entwickler legen die HTTP-Dateien in einem separaten Ordner wie "http" oder "requests" im Hauptverzeichnis ihres Projekts ab. Andere bevorzugen es, die HTTP-Dateien im Verzeichnis des Moduls zu speichern, das sie verwenden.

Im File kann man zum Beispiel eine Get Abfrage nach folgenden Schema erstellen.
```http request
GET http://localhost:8080/api/student/subjects
Accept: application/json
```
Das `api/student/subjects` ist das RequestMapping, welchen in den Controllern festgelegt wurden für den API-Schnittpunkt.

Eine Post oder Put, welchen einen Request Body benutzt sie zum Beispiel dann so aus:
```http request
POST http://localhost:8080/api/admin/subjects
Content-Type: application/json

{
  "key1": "value1",
  "key2": "value2"
}
```

Wenn man nun die Applikation startet, kann man diese HTTP Abfrage ausführen und sehen was die Schnittstelle zurückgibt.
