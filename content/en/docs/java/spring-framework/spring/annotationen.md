---
title: "Annotationen"
linkTitle: "Annotationen"
weight: 17
description: >
  Modul #J8 - Spring Framework - Was sind Annotationen und welche gibt es in Spring?
---

## Annotationen in Spring

Annotationen in Spring sind spezielle Markierungen im Code, die verwendet werden,
um Metadaten bereitzustellen und das Verhalten von Klassen, Methoden oder Feldern zu konfigurieren.
Sie helfen dabei, den Code sauberer und lesbarer zu machen, indem sie die Konfiguration direkt in den Code integrieren,
anstatt sie in separaten XML-Dateien zu verwalten.

Einige häufig verwendete Annotationen in Spring sind:

- `@Component`
- `@Autowired`
- `@Service` und `@Repository`
- `@Controller`

Durch die Verwendung von Annotationen können Entwickler die Konfiguration und das Verhalten ihrer Spring-Anwendungen
direkt im Code definieren, was die Entwicklung und Wartung erleichtert.

### Die verschiedenen Arten von Annotationen

#### Spring Annotationen

`@Configuration`: In Spring wird diese Annotation verwendet,
um eine Klasse als Konfigurationsklasse zu markieren. Das bedeutet, dass diese Klasse Methoden enthalten kann,
die Beans definieren und konfigurieren. Wenn Spring eine solche Klasse sieht, wird sie verwendet,
um die Beans zu erstellen und zu verwalten, die für die Anwendung benötigt werden.

`@Bean`: Die Annotation `@Bean` in Spring wird verwendet, um eine Methode in einer `@Configuration`-Klasse zu kennzeichnen,
die eine Bean definiert und zurückgibt. Wenn Spring diese Methode aufruft, erstellt es das zurückgegebene Objekt als Bean
und verwaltet es im Spring IoC Container. Dadurch kannst du die Erstellung und Konfiguration von Beans zentral in deiner Konfigurationsklasse steuern.

`@Component`: Diese Annotation wird in Spring verwendet, um eine Klasse als Bean zu markieren, die vom Spring IoC Container verwaltet werden soll.
Wenn Spring eine Klasse mit dieser Annotation findet, wird sie automatisch instanziiert und als Bean registriert.
Das bedeutet, dass du diese Klasse nicht manuell konfigurieren musst, sondern Spring kümmert sich um die Erstellung und Verwaltung.
`@Component` ist eine generische Annotation, und es gibt spezialisierte Versionen wie `@Service`, `@Repository` und `@Controller` für spezifische Anwendungsfälle.

`@ComponentScan`: Mit dieser Annotation in Spring kannst du festlegen, in welchen Paketen nach Komponenten wie `@Component`,
`@Service`, `@Repository` und `@Controller` gesucht werden soll. Diese Annotation wird häufig in einer Konfigurationsklasse zusammen mit `@Configuration` verwendet.
Beim Start der Anwendung scannt Spring die angegebenen Pakete und registriert automatisch alle gefundenen Komponenten als Beans im IoC Container.
Dadurch wird die Verwaltung und Konfiguration der Anwendung vereinfacht, da du nicht jede Bean manuell definieren musst.

`@Autowired`: Mit der Annotation `@Autowired` in Spring kannst du die automatische Injektion von Abhängigkeiten nutzen.
Das bedeutet, dass Spring die benötigten Beans automatisch findet und sie in das markierte Feld,
den Konstruktor oder die Methode einfügt. Dadurch entfällt die Notwendigkeit, Abhängigkeiten manuell zu instanziieren,
was den Code sauberer und übersichtlicher macht. `@Autowired` erleichtert die Verwaltung von Abhängigkeiten und fördert die lose Kopplung in deiner Anwendung.

`@Service`: Wird in Spring verwendet, um eine Klasse als Service-Komponente zu kennzeichnen.
Services sind spezialisierte Komponenten, die Geschäftslogik enthalten und häufig als Vermittler zwischen dem Controller und dem Repository fungieren.
Durch die Verwendung von `@Service` erkennt Spring die Klasse als Bean und verwaltet sie automatisch im IoC Container.
Das ermöglicht eine saubere Trennung der Geschäftslogik von anderen Schichten der Anwendung und fördert die Wiederverwendbarkeit
und Testbarkeit des Codes.

`@Repository`: Diese Annotation wird verwendet, um eine Klasse in Spring als Datenzugriffsschicht zu markieren.
Diese Annotation stellt sicher, dass die Klasse für Datenbankoperationen wie Speichern, Abrufen, Aktualisieren und Löschen verantwortlich ist.
Wenn Spring eine Klasse mit @Repository entdeckt, wird sie als Bean registriert und es werden zusätzliche Funktionen wie die automatische Behandlung von Datenbankausnahmen aktiviert.
Dies verbessert die Verwaltung von Datenbankzugriffen und gewährleistet eine klare Trennung zwischen der Datenzugriffsschicht und anderen Teilen der Anwendung.

#### MVC Annotationen

`@Controller`: Um eine Klasse in Spring als Web-Controller zu kennzeichnen, wird die Annotation `@Controller` verwendet. Diese Annotation zeigt an, dass die Klasse HTTP-Anfragen entgegennimmt
und darauf reagiert. Ein Controller verarbeitet die eingehenden Anfragen, delegiert die Geschäftslogik an entsprechende Services und gibt die passenden Antworten zurück.
Typischerweise werden in einem Controller Methoden mit weiteren Annotationen wie `@GetMapping` oder `@PostMapping` versehen,
um spezifische Endpunkte und HTTP-Methoden zu definieren. Durch die Verwendung von `@Controller` wird die Klasse als Bean im Spring IoC Container registriert,
was die Strukturierung und Verwaltung von Webanfragen innerhalb der Anwendung erleichtert.

`@RequestMapping`: Es ermöglicht dir, in Spring HTTP-Anfragen bestimmten Methoden in deinem Controller zuzuordnen.
Es gibt spezialisierte Versionen dieser Annotation für die verschiedenen HTTP-Methoden, die den Code lesbarer und spezifischer machen.
Hier sind die 4 wichtigsten Varianten:

- `@GetMapping`: Verarbeitung von GET-Anfragen. Diese Anfragen werden typischerweise verwendet, um Daten abzurufen.
- `@PostMapping`: Verwendung für POST-Anfragen. Diese Anfragen werden oft verwendet, um neue Daten zu erstellen oder zu senden.
- `@PutMapping`: Wird verwendet, um PUT-Anfragen zu verarbeiten. Diese Anfragen dienen in der Regel dazu, vorhandene Daten zu aktualisieren.
- `@DeleteMapping`: Verarbeitung von DELETE-Anfragen. Diese Anfragen werden genutzt, um Daten zu löschen.

Diese spezialisierten Annotationen machen deinen Code klarer und einfacher zu verstehen, indem sie explizit angeben, welche HTTP-Methode verwendet wird.

`@PathVariable`: Mit `@PathVariable` kannst du in Spring Platzhalter in der URL eines HTTP-Requests direkt an Methodenparameter im Controller binden.
Diese Annotation ermöglicht es dir, dynamische Teile der URL zu erfassen und in deiner Methode zu verwenden. Dies ist besonders nützlich, wenn du RESTful APIs entwickelst,
bei denen Ressourcen über eindeutige Identifikatoren in der URL aufgerufen werden.

Zum Beispiel kannst du in einer URL wie `/users/{id}` den Wert des `{id}`-Platzhalters direkt in deine Methode einfügen,
um den entsprechenden Benutzer zu verarbeiten. Indem du `@PathVariable` in deiner Methodensignatur verwendest,
kannst du diesen Wert einfach abrufen und weiterverarbeiten.

```java
@GetMapping("/users/{id}")
public User getUserById(@PathVariable("id") Long userId) {
    // Logik zur Verarbeitung des Benutzer-IDs
    return userService.findById(userId);
}
```

In diesem Beispiel wird der Wert des URL-Platzhalters `{id}` automatisch der Methode als Parameter `userId` übergeben,
was die Handhabung von dynamischen URLs erleichtert und den Code klarer und lesbarer macht.

`@RequestParam`: Wenn du HTTP-Request-Parameter an Methodenparameter im Controller binden möchtest,
ist `@RequestParam` die richtige Wahl. Diese Annotation ermöglicht es dir, Werte aus der URL-Abfragezeichenfolge
direkt in deine Methode zu integrieren und weiterzuverarbeiten. Das ist besonders hilfreich, wenn du Daten wie Filterkriterien,
Suchbegriffe oder andere Parameter übergeben möchtest.

Zum Beispiel kannst du in einer URL wie `/search?query=Spring` den Wert des Query-Parameters `query` direkt in deiner Methode verwenden.
Indem du `@RequestParam` in deiner Methodensignatur angibst, kannst du diesen Wert abrufen und damit arbeiten.

```java
@GetMapping("/search")
public String search(@RequestParam("query") String searchQuery) {
    // Logik zur Verarbeitung des Suchbegriffs
    return "Ergebnisse für: " + searchQuery;
}
```

In diesem Beispiel wird der Wert des Query-Parameters `query` automatisch der Methode als Parameter `searchQuery` übergeben.
Dies erleichtert die Handhabung von URL-Parametern und macht deinen Code klarer und besser strukturiert.

`@RequestBody`: Um den Inhalt einer HTTP-Anfrage direkt an ein Methodenparameter zu binden, verwendest du `@RequestBody` in Spring.
Diese Annotation ist besonders nützlich, wenn du JSON- oder XML-Daten von einem Client empfangen und in ein Java-Objekt umwandeln möchtest.
`@RequestBody` sorgt dafür, dass der Inhalt des Anfragekörpers automatisch deserialisiert und dem entsprechenden Parameter zugewiesen wird.

Zum Beispiel, wenn du eine POST-Anfrage sendest, die JSON-Daten enthält, kannst du diese Daten direkt in deiner Methode verarbeiten:

```java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User newUser) {
    // Logik zur Verarbeitung des neuen Benutzers
    userService.save(newUser);
    return ResponseEntity.ok(newUser);
}
```

In diesem Beispiel wird der JSON-Inhalt der POST-Anfrage in das `User`-Objekt `newUser` umgewandelt.
Dies erleichtert die Arbeit mit komplexen Datenstrukturen und sorgt für einen klaren und übersichtlichen Code,
indem die Umwandlung von JSON zu Java-Objekten automatisch von Spring übernommen wird.

`@RequestHeader`: Mit `@RequestHeader` in Spring kannst du HTTP-Header-Werte direkt an Methodenparameter im Controller binden.
Diese Annotation ermöglicht es dir, spezifische Header-Informationen aus einer Anfrage zu extrahieren und in deiner Methode zu verwenden.
Das ist besonders nützlich, wenn du Metadaten wie Authentifizierungsinformationen, Content-Type oder andere benutzerdefinierte Header benötigst.

Zum Beispiel kannst du den Wert eines spezifischen HTTP-Headers wie `User-Agent` direkt in deiner Methode verarbeiten:

```java
@GetMapping("/user-agent")
public ResponseEntity<String> getUserAgent(@RequestHeader("User-Agent") String userAgent) {
    // Logik zur Verarbeitung des User-Agent-Headers
    return ResponseEntity.ok("User-Agent: " + userAgent);
}
```

In diesem Beispiel wird der Wert des `User-Agent`-Headers automatisch der Methode als Parameter `userAgent` übergeben.
Dies erleichtert die Arbeit mit HTTP-Headern und macht deinen Code klarer und besser strukturiert.

#### Spring Boot Annotationen

`@SpringBootApplication`: Es ist eine zentrale Annotation in Spring Boot, die als Einstiegspunkt für die Anwendung dient.
Diese Annotation fasst mehrere wichtige Konfigurationen zusammen und vereinfacht so den Start und die Konfiguration deiner Spring Boot Anwendung.

Hier sind die drei Hauptbestandteile, die `@SpringBootApplication` kombiniert:

- `@Configuration`: Markiert die Klasse als eine Quelle für Bean-Definitionen.
- `@EnableAutoConfiguration`: Aktiviert die automatische Konfiguration von Spring Boot, basierend auf den in der Abhängigkeiten angegebenen Bibliotheken.
- `@ComponentScan`: Ermöglicht das automatische Scannen und Registrieren von Beans in den angegebenen Paketen.

Ein typisches Beispiel für den Einsatz von `@SpringBootApplication` sieht so aus:

```java
@SpringBootApplication
public class MyApplication {
    public static void main(String args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

In diesem Beispiel wird die `MyApplication`-Klasse als Ausgangspunkt für die Spring Boot Anwendung verwendet.
Durch die Verwendung von `@SpringBootApplication` wird die Konfiguration vereinfacht und du kannst schnell eine lauffähige Spring-Anwendung erstellen,
da die wichtigsten Einstellungen und Scans automatisch durchgeführt werden.

`@EnableAutoConfiguration`: Um die automatische Konfiguration in einer Spring-Boot-Anwendung zu aktivieren, verwendest du `@EnableAutoConfiguration`.
Diese Annotation sorgt dafür, dass Spring Boot die Konfigurationseinstellungen basierend auf den Abhängigkeiten, die sich im Klassenpfad befinden,
automatisch übernimmt. Dies ermöglicht es dir, eine Spring-Anwendung schnell und einfach zu starten, ohne umfangreiche Konfigurationsdateien erstellen zu müssen.

Wenn du `@EnableAutoConfiguration` in deiner Hauptanwendungsklasse verwendest, durchsucht Spring Boot den Klassenpfad nach Bibliotheken und
aktiviert automatisch die entsprechenden Konfigurationen. Zum Beispiel, wenn du eine Datenbankabhängigkeit hinzufügst, wird Spring Boot automatisch die Datenbankkonfiguration vornehmen.
