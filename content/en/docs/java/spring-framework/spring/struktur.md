---
title: "Struktur"
linkTitle: "Struktur"
weight: 16
description: >
  Modul #J8 - Spring Framework - Wie ist die Spring Struktur aufgebaut?
---

## Spring Struktur

![spring-struktur.png](../images/spring-struktur.png)

Die Meisten modernen Webapplikationen bestehen aus 3 Schichten:

| Layer                | Beschreibung                                                                                                          |
| -------------------- | --------------------------------------------------------------------------------------------------------------------- |
| Boundary (Grenze)    | Auf dieser Schicht wird die Kommunikation mit der Aussenwelt abgewickelt.                                             |
| Control (Verwaltung) | Auf dieser Schicht sind alle Klassen und deren Logik.                                                                 |
| Entity (Speicher)    | Auf dieser Schicht wird alles abgewickelt, was mit Datenspeicherung und Auslesung zu tun hat (z.B. mit Repositories). |

Spring hat verschiedene Annotationen für verschiedene Aufgaben. Mit der `@Component` Annotation wird
eine generische Spring Komponente dargestellt. Alle anderen Annotationen sind ebenfalls Komponenten.
Sie grenzen nur ab, was sie genau machen. Mit der `@Configuration` Annotation werden Komponenten für die
Konfiguration definiert. Mit der `@Repository` Annotation werden Komponenten, welche mit der Datenspeicherung zu
tun haben definiert. Mit der `@Controller` Annotation werden Komponenten, welche mit der Kommunikation mit
der Aussenwelt zu tun haben definiert. In der `@Service` Annotation werden Komponenten, welche mit der Kontrolllogik zu
tun haben definiert.

Mehr Informationen zu den einzelnen Annotationen findest du [hier](annotationen.md).

### Die Schichten (Layer) in Spring

#### Boundary Layer

In diesem Layer definieren wir unsere REST Ressourcen. Hier ein Beispiel einer Order-Klasse in einem
Webshop:

```java

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
```

Dies ist eine Rest-Resource und sie wird definiert mit der Annotation `@RestController`. Die
Annotation `@RequestMapping("/orders")` legt fest, dass alle Aufrufe, wessen URL mit `"/orders"` beginnen, diesen Rest-Controller
verwenden sollen.

#### Control Layer

Der Control Layer bildet den Kern aller Anwendungen und enthält dessen Geschäfts-Logiken. Auf der
technischen Ebene ist der Control Layer die grundlegendste Schicht.
Die Control Layer könnte wie folgt aussehen:

```java
@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long id, Order order) {
        Order toUpdate = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        toUpdate.setName(order.getName());
        return toUpdate;
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
```

Diese Klasse besitzt nur zwei Annotationen nämlich `@Service` und
`@Transactional`. Die `@Service` Annotation markiert Beans als Holder
der Businesslogik. `@Transactional` sagt einfach, dass alle Funktionen in der Klasse in einer
einzigen Transaktion ausgeführt werden sollen. Das musst du vorläufig aber noch nicht verstehen.
Durch die Constructor Injection wird hier auch noch die Bean `OrderRepository` injected.

#### Entity Layer

Der Entity Layer ist für die Datenspeicherung zuständig. Auf diesem Layer gibt es die zwei Hauptbestandteile
Entity und Repository. Entities sind Klassen, die eine Datenbank-Tabelle repräsentieren. Die Repositories hingegen verwalten
diese Entities.

Auch hier wird mit Annotationen gearbeitet, um die Funktionalitäten umzusetzen. Die `@Entity` Annotation sagt, dass es
sich bei dieser Klasse um ein Entity handelt.

Die `@Table` Annotation sagt auf welcher Tabelle in der Datenbank diese Klasse gespeichert wird
(Schreibweise `@Table(name = "tabellenNamen")`).

Die `@GeneratedValue` Annotation besagt, dass dieser Wert in der Tabelle/Datenbank automatisch generiert wird.

Die `@Id` Annotation sagt, dass dieses Feld als Primärschlüssel in der Tabelle fungiert.

Hier ist ein Beispiel:

```java
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```

Damit wir auf die Daten zugreifen können, brauchen wir ein Repository. Dazu können wir ein Interface
implementieren, welches `CrudRepository` extended. Das `CrudRepository` hat schon viele Methoden
implementiert, deshalb müssen wir keine eigenen implementieren.

Hier ein Beispiel:

```java
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
```

Du fragst dich vielleicht, wo die Daten gespeichert werden. Normalerweise macht Spring eine temporäre
Datenbank, welche jedoch nach Abschluss des Programmes wieder gelöscht wird. Wenn man die Daten nicht
jedes Mal neu schreiben will, kann man sie in einer "richtigen" Datenbank speichern. Dazu müssen wir
die Spring Konfiguration ändern.

Spring lädt die Konfiguration von einer Datei mit dem Namen `application.properies` bzw. `application.yaml`. Diese Datei befindet sich im
`resources`-Ordner (oft im Ordner "src/main" oder "src/test").

Folgende 5 Konfigurationen werden oft im Zusammenhang mit Datenbanken benötigt:

| Konfiguration                         | Beschreibung                                                                                                                                                                                                                                                                                 |
| ------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `spring.datasource.url`               | gibt die URL der Datenbank an (Format:`jdbc:[datenbanktyp]://[server]:[port]/[datenbank]`)                                                                                                                                                                                                   |
| `spring.datasource.username`          | gibt den Benutzername an, mit dem die Verbindung zur Datenbank aufgebaut werden soll.                                                                                                                                                                                                        |
| `spring.datasource.password`          | gibt das Passwort der Datenbank an.                                                                                                                                                                                                                                                          |
| `spring.datasource.driver-class-name` | gibt an, welcher Datenbanktreiber verwendet wird (muss als Maven-Dependency hinzugefügt werden)                                                                                                                                                                                              |
| `spring.jpa.hibernate.ddl-auto`       | beschreibt, wie Spring mit der Datenbank umgehen soll. `update` z.B. sorgt dafür, dass fehlende Spalten oder dergleichen automatisch erstellt werden und dass nie Sachen gelöscht werden. `create-drop` erstellt die Datenbank und löscht die Objekte nachher. `none` belässt die Datenbank. |

Hier ist eine Beispiel-Konfiguration mit einer Mariadb Datenbank:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/order
spring.datasource.username=spring
spring.datasource.password=1234
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

##### Repository

Eines der am häufigsten verwendeten Design-Patterns ist das Repository Design-Pattern. 
Ein Repository ist eine Schnittstelle, die den Zugriff auf Daten in der Datenbank ermöglicht. 
Man kann es sich wie einen Bibliothekar vorstellen: Der Bibliothekar findet und bringt uns die gewünschten Bücher,
ohne dass wir wissen müssen, wie er sie findet. Wir kennen nur die "Befehle" (Methoden) des Repositorys und welche Ergebnisse wir erwarten können.

```java
public interface ArticleRepository {
    List<Article> readAll();

    List<Article> readLatest();

    List<Article> readByTags(Tag... tags);

    Article readById(long id);

    Article create(Article article);

    Article update(Article article);

    Article delete(Article article);
}
```

Meistens wird das Interface im Hintergrund vom Framework implementiert und wir müssen nichts dafür
tun, ausser den richtigen Methodennamen und Rückgabewert zu wählen, damit Spring weiss, was es implementieren soll.

### Profile

In Spring kann man verschiedene Profile erstellen. Damit wird sichergestellt, dass bestimmte `@Bean`s
nur entsprechend gesetzt werden, sobald eine bestimmte Bedingung zutrifft. Die Datenbank soll zum Beispiel nur Beispieldaten
laden, wenn das `Dev`-Profil aktiv ist, ansonsten soll eine richtige Datenbank verwendet werden.

Mit der `@Profile` Annotation kann man einer Klasse oder Methode (Beans) sagen, ob sie bei einem
Profil läuft. Das standard Profil ist `default`, sobald ein anderes Profil aktiv ist, wird das `default`
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

In diesem Beispiel werden Methoden angesteuert, sobald ein Profil aktiv ist. Wenn das Profil `default` aktiv ist, wird
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
der [offiziellen Dokumentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition-profiles) oder in dieser [Erklärung](https://www.baeldung.com/spring-profiles).