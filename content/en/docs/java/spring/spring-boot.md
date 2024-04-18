---
title: "Spring Boot"
linkTitle: "Spring Boot"
weight: 2
description: >
  Modul #J10 - Spring Boot
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

[//]: # (TODO JPA wird nirgends erklärt?)
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

[//]: # (TODO mailstarter wiklich nötig?)
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


## Testing in Spring Boot

Spring Boot unterstützt das Testen durch die Bereitstellung verschiedener Test-Annotationen wie `@SpringBootTest` und `@WebMvcTest` für das MVC. Diese Annotationen helfen dabei, die richtige Testumgebung für verschiedene Szenarien zu konfigurieren.

## Schreiben von Unit-Tests

### Testen von Services
Das Testen von Service-Klassen in Spring Boot erfolgt oft mit `@MockBean` für das Mocking von Abhängigkeiten und `@Autowired` zur Injektion dieser Services in die Testklasse.

**Beispiel für einen Service-Test in Spring Boot:**
```java
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        User user = new User("Alice");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User created = userService.addUser(user);
        assertThat(created).isNotNull();
        assertThat(created.getName()).isEqualTo("Alice");
    }
}
```

### Testen von JDBC-Repositories
Um JDBC-basierte Datenzugriffsschichten zu testen, sollte `@JdbcTest` verwendet werden, das eine H2-In-Memory-Datenbank konfiguriert und den Anwendungskontext auf JDBC-Komponenten einschränkt.

**Beispiel für einen JDBC Repository-Test:**
```java
@JdbcTest
public class UserRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testFindByUsername() {
        jdbcTemplate.update("INSERT INTO users (username) VALUES (?)", "Alice");
        String username = jdbcTemplate.queryForObject("SELECT username FROM users WHERE username = ?", String.class, "Alice");
        assertThat(username).isEqualTo("Alice");
    }
}
```

**Einrichtung einer H2-Datenbank für Tests:**
Du kannst die H2-Datenbank in deinem `application-test.properties` oder `application.properties` Datei wie folgt konfigurieren:

```properties
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

### Ordnerstruktur für `application-test.properties`

Die `application-test.properties` Datei sollte im Verzeichnis `src/test/resources` der Spring Boot-Anwendung platziert werden. Diese Struktur sorgt dafür, dass die Testkonfigurationen separat von den Produktionskonfigurationen gehalten werden und nur während der Testausführung geladen werden.

```
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |       |-- example/
|   |           |-- myapp/
|   |               |-- YourProductionCode.java
|   |-- resources/
|       |-- application.properties  # Konfigurationsdatei für die Produktionsumgebung
|-- test/
|   |-- java/
|   |   |-- com/
|   |       |-- example/
|   |           |-- myapp/
|   |               |-- integration/
|   |                   |-- YourIntegrationTests.java
|   |-- resources/
|       |-- application-test.properties  # Konfigurationsdatei speziell für Tests
|       |-- schema.sql
|       |-- data.sql

```

## Schreiben von Integrationstests

### Testen von Controllern
Das Testen von Web Controllern nutzt `@WebMvcTest`, um den Spring MVC-Anwendungskontext zu laden. Mit `MockMvc` können HTTP-Anfragen simuliert werden.

**Beispiel für einen Controller-Test:**
```java
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        Mockito.when(userService.getUserById(1L)).thenReturn(new User("Alice"));
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }
}
```

### Testen von REST-APIs
Für breiter angelegte Integrationstests, die den vollen Stack betreffen, verwendet man `@SpringBootTest` zusammen mit `TestRestTemplate` oder `MockMvc`.

**Beispiel für einen REST API-Test:**
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUserEndpoints() {
        ResponseEntity<User> response = restTemplate.postForEntity("/users", new User("Bob"), User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getName()).isEqualTo("Bob");
    }
}


```


## Profile

In Spring kann man verschiedene Profile erstellen. Damit kann man sicherstellen, dass bestimmte `@Bean`s
nur entsprechend gesetzt werden, wenn eine bestimmte Bedingung zutrifft. Die Datenbank soll zum Beispiel nur Beispieldaten
laden, wenn das `Dev`-Profil aktiv ist, ansonsten soll eine richtige Datenbank verwendet werden.

Mit der `@Profile` Annotation kann man einer Klasse oder Methode (Beans) sagen, ob sie bei einem
Profil läuft. Das standard Profil ist `default`, wenn irgendein Profil aktiv ist, wird das `default`
Profil deaktiviert.
Hier ist ein Beispiel:

```java
@Component
@Profile("test")
public class TestString {
    @Bean
    public String test() {
        return "test";
    }
}
```

Im Beispiel lädt die Komponente `TestString` nur, wenn das Profil `test` aktiv ist.  
Bei der `@Profile`-Annotation kann man auch logische Operatoren wie "Und" (`&`) , "Oder" (`|`) und "Nicht" (`!`) benutzen.
Hier ein Beispiel:

```java
@Component
public class Demo {
    @Bean
    @Profile("default")
    public String defaultString() {
        return "Standard Profil";
    }
    
    @Bean
    @Profile("test | test2")
    public String testString() {
        return "Test Test";
    }
    
    @Bean
    @Profile("!(default | test | test2)")
    public String rewoltString() {
        return "None of the above";
    }
}
```

In diesem Beispiel werden die Methoden angesteuert. Wenn das Profil `default` aktiv ist, wird
die `defaultString` Methode geladen, wenn das Profil `test` oder `test2` aktiv ist, wird
die `testString` Methode geladen, wenn keines der obengenannten Profile aktiv ist, wird
die `rewoltString`-Methode geladen.

In Spring kann man Mehrere Profile aktivieren. Die Profile können mit dem Program gesetzt werden.  
Beispiel hier:

```java
AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("test");
        ctx.register(SomeConfig.class,StandaloneDataConfig.class,JndiDataConfig.class);
        ctx.refresh();
```

Die Profile können auch über die `spring.profiles.active` Property aktiviert werden.
Beispiel hier:

```properties
spring.profiles.active="test"
```

Bei beiden Möglichkeiten wurde das Profil `test` aktiviert. Weitere Informationen in
der [offiziellen Dokumentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition-profiles).