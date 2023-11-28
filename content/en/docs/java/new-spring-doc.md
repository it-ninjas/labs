---
title: "New Spring Doc"
linkTitle: "New Spring Doc"
weight: 16
description: >
  Modul #J10 - Spring Framework
---

#### Ziele

* Ich weiss, was ein Java-Framework ist.
* Ich kenne einige Vor- und Nachteile beim Verwenden eines Java-Frameworks.
* Ich kenne ein paar Module des Spring-Frameworks (z.B. Core, Data-Access, Web usw.) und weiss,
  welche Aufgaben sie erfüllen.
* Ich kenne die wichtigsten Spring-Projekte (z.B. Spring-Boot, Spring-Cloud, Spring-Security usw.)
  und weiss wofür ich diese einsetzen kann.
* Ich weiss, was "Inversion of Control" (IoC) bedeutet und kenne dessen Vorteile.
* Ich weiss, was "Dependency-Injection" (DI) ist und kenne die verschiedene Möglichkeiten (z.B.
  Constructor-Based, Setter-Based, Field-Based) um DI in Spring zu benutzen.
* Ich weiss, was ein "Spring-Bean" ist und wie es in Spring erzeugt und verwendet wird.
* Ich kenne die verschiedene Scopes eines "Spring-Beans" (z.B. Singleton, Session, Application
  usw.).
* Ich kenne die, am häufigsten verwendeten, Spring-Bean Annotationen (z.B. `@Configuration`,
  `@Component`, `@Repository`, `@Controller` usw.), wie ich diese einsetze und welchem Zweck sie
  dienen.
* Ich weiss, was "Wiring" ist und wie es in Spring gemacht wird.
* Ich weiss, wofür Properties in Spring verwendet werden und wie ich Properties in Spring setzen
  kann.
* Ich weiss, wozu Spring-Profiles verwendet werden und wie ich sie einsetzen kann.

---

### Framework

Ein Framework ist eine Grundlage, auf der Applikationen basieren. Frameworks stellen Funktionen von
essenzieller Wichtigkeit bereit damit man diese nicht jedes Mal neu schreiben muss.

## Spring Framework

Das Spring Framework gibt uns die Werkzeuge eine einfache Web-Applikation zu erstellen. Mit ihm kann
man vom Internet zugängliche Schnittstellen machen, mit einer Datenbank verbinden oder Objekte
Speichern.

### Module

Für das Spring Framework gibt es mehrere Module welche für verschiedene Dinge zuständig sind. Diese
sind in Gruppen aufgeteilt z.B. Core, Data Access, Web, etc.

[comment]: <> (Bildlink funktioniert auf website, nicht in md!)

![spring-module-overview.png](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/images/spring-overview.png)

Quelle: https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/images/spring-overview.png
 
Das Core Modul enthält alle wichtigen Dinge wie z.B. dependency injection. Im Beans Modul ist alles enthalten, 
das verwendet wird, um Beans (später mehr) zu erstellen.

Das JDBC Modul bietet eine Art JDBC interface, mit welchem man auf Datenbanken zugreifen kann.
Das ORM Modul hingegen, bietet Zugriff auf Object-mapping-APIs wie z.B. JPA, JDO, Hibernate. Mit dem OXM Modul wiederum,
kann man auf Objekt/XML Speicher-Implementationen zugreifen.

Das Web Modul ist für die Kommunikation mit der Aussenwelt (Internet) zuständig.

Weitere Informationen sind in der offiziellen
[Dokumentation](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch01s02.html) zu finden.

### Spring Projekte

Es gibt verschiedenen Spring Projekte, welche alle auf dem Spring Framework basieren und es einem
Erlauben noch mehr mit Spring zu machen. Es gibt z.B. spring-security, welches Sicherheitsaspekte
implementiert, spring-shell, das ein CLI bereitstellt oder spring-boot. Mehr dazu im folgenden
absatz.

Weitere Projekte und Infos dazu sind hier zu finden: https://github.com/spring-projects

[comment]: <> (Link funktioniert auf Website)

#### [Boot](../new-spring-boot-doc#spring-boot)

Spring Boot ist eine Art Vereinfachung des normalen spring Frameworks. Bei Spring Boot können mithilfe
des sogenannten Spring Initializers Abhängigkeiten wie z.B. Datenbanktreiber oder Software für
die Cloud-infrastruktur ausgewählt werden. Somit entfällt die manuelle Konfiguration des Projektes.
Jedoch ist Spring Boot kein Ersatz für das Spring Framework, denn es ist vor allem dafür zuständig die
Konfiguration zu vereinfachen.

## Design-Pattern

Design-Patterns sind wiederverwendbare Vorlagen, die wir beim Erstellen von Anwendungen verwenden
können. Das Gute an diesen Design-Patterns ist, dass diese meist nicht spezifisch für eine
Programmiersprache geschaffen sind, sondern bei vielen verschiedenen Programmiersprachen angewendet
werden können. Es gibt 3 verschiedene Design-Patterns: 1: Kreationsmuster 2: Strukturmuster 3:
Verhaltensmuster.
Wir schauen uns nun einige Design-Patterns an, die auch in Spring eingesetzt werden.

### Inversion of Control

«Inversion of Control» ist ein Prinzip, das besagt, dass eine Entität nur ihre Hauptaufgabe ausführt, was
wiederum bedeutet, dass jede Entität nur für etwas zuständig ist. Wenn man
zum Beispiel mit dem Auto zur Arbeit fährt, ist man für das Fahren und das Arbeiten zuständig. Würde man aber ein
Taxi bestellen ist der Taxifahrer fürs Fahren und du fürs Arbeiten zuständig. Die Zuständigkeiten
sind also getrennt.

Das Spring Framework benutzt das «Inversion of Control» Prinzip.

### Dependency Injection

Eine Dependency oder eine Abhängigkeit (Service) wird in ein Objekt (Client) weitergegeben.
Normalerweise bestimmt ein Objekt, welche Abhängigkeiten es braucht. Das heisst, dass man die
Abhängigkeit einem Objekt, welches diese benötigt übergeben muss und dass man die Abhängigkeit nicht
im Objekt importieren kann.

In Spring gibt es einen sogenannten InversionOfControl-Container. In diesem ist z.B. hinterlegt wie und
wo etwas injected wird.

Man kann diesen Container auf mehrere Arten erstellen. In unserem Fall können wir die Sachen mit Java-Klassen lösen.

In Spring hat man verschiedene Möglichkeiten wie man Abhängigkeiten injected. Zum einen mit Konstruktoren, aber auch mit
Settern und Feldern.

##### Konstruktor Injection

Bei einer Konstruktor Injection fungiert jedes Argument als eine Abhängigkeit.  
Ein Beispiel sieht so aus:

```java

@Configuration
public class AppConfig {

  @Bean
  public Item item1() {
    return new ItemImpl1();
  }

  @Bean
  public Store store() {
    return new Store(item1());
  }
}
```

Die `@Configuration` Annotation besagt das diese Klasse die Konfiguration beinhalten

Die `@Bean` Annotation besagt, dass es sich hier um ein Bean handelt. Mehr dazu [hier](#bean).

##### Setter Injection

Bei der Setter basierten Injection erstellt man Konstruktoren ohne Argumente. Die Injection passiert
dann mit dem Setter. Es wird empfohlen, obligatorische Abhängigkeiten mit Konstruktor Injections zu
machen während man optionale Abhängigkeiten mit Setter Injections macht.  
Hier ein Beispiel:

```java
@Bean
public Store store() {
    Store store=new Store();
    store.setItem(item1());
    return store;
}
```

##### Felder Injection

Bei der Felder Injection werden die Abhängigkeiten direkt in die Felder Injected. Es ist jedoch nicht
empfehlenswert diese Art der injection zu benutzen, da diese Reflection benutzt, was weniger Effizient
ist.  
Hier ein Beispiel:

```java
public class Store {
    @Autowired
    private Item item;
}
```

##### Automatische Abhängigkeiten Injection (Autowired)

Spring kann Abhängigkeiten auch automatisch erkennen und diese einsetzen. Hierbei git es vier verschiedenen
Modi.

* `no` Standartwert, hier wird kein autowiring gemacht.
* `byName` Hier werden die Abhängigkeiten dem Namen nach eingesetzt.
* `byType` Hier werden die Abhängigkeiten dem Typ nach eingesetzt. Gibt es mehrere Beans eines Typus,
  dann gibt es einen Fehler.
* `consturctor` Hier werden die Abhängigkeiten der Konstruktoren Argumente nach eingesetzt. Das
  bedeutet, dass Spring nach Beans sucht, welche denselben Typ wie die Konstruktoren Argumente haben.

Hier ist ein Beispiel mit `byType`:

```java

@Bean(autowire = Autowire.BY_TYPE)
public class Store {
    private Item item;
    
    public setItem(Item item) {
        this.item = item;
    }
}
```

Mit der `@Aurowired` Annotation können wir auch mit Type einsetzten:

```java
public class Store {
    @Autowired
    private Item item;
}
```

Wenn es mehr als eine Bean des gleichen typen gibt, dann kann man mit `@Qualifier` einen Namen
bestimmen:

```java
public class Store {
    @Autowired
    @Qualifier("item1")
    private Item item;
}
```

Quelle und weitere Informationen: https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring

### Singleton

Das Singleton Design-Pattern besagt, dass für Singleton-Klassen nur eine einzige Instanz besteht.
Das bedeutet, wenn eine "neue" Instanz erstellt wird mit `new Klasse()`, 
wird die bestehende Singleton-Instanz zurückgegeben.
Hier ein Beispielbild:

![beispielBild](https://www.baeldung.com/wp-content/uploads/2023/02/singleton_design_pattern3.png)

Quelle: https://www.baeldung.com/wp-content/uploads/2023/02/singleton_design_pattern3.png

### HTTP Access-Control

Die HTTP-Standards um auf Ressourcen zuzugreifen:

* GET – Ressourcen erhalten
* POST – Neue ressourcen erstellen
* DELETE – Ressource löschen
* PUT – Ressourcen aktualisieren oder gegebenenfalls neu erstellen

### Bean

Bean Objekte sind das Rückgrat einer Anwendung. Die Bean Objekte werden instanziiert,
zusammengebaut und von einem Spring IoC-Container (Inversion of Control) verwaltet. Sie werden mit
Metadaten erstellt, die sie danach auch an dem Container weiterliefern.

Die Beans können als XML oder Java Config erstellt werden (wie sonst auch). Der Einfachheit halber
werden wir Java-Beispiele geben. Um ein Bean zu definieren, benutzt man die `@Bean` Annotation auf
einer Methode, welche in einer `@Configuration` Klasse ist (oder ein Interface welches davon erbt).
Beans können auch in einer `@Component` Klasse deklariert werden, wenn sie nicht von anderen Beans
abhängig sind.
Hier ein Beispiel:

```Java
@Configuration
public class AppConfig {
    @Bean
    public TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}
```

Normalerweise werden Beans nach ihren Methoden benannt. Man kann den Namen auch selber Festlegen mit
der `@Bean("meinName")` Annotation.
Hier ein Beispiel:

```java
@Configuration
public class AppConfig {
    @Bean("myThing")
    public Thing thing() {
        return new Thing();
    }
}
```

[Hier ist die offizielle Bean
Dokumentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition)  
[Hier ist die offizielle `@Bean` Annotation Dokumentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-bean-annotation)

##### Scope

Der Scope eines Beans besagt, wann und wie ein Bean erstellt wird.

Hier eine Liste der Scopes:

| Scope       | Beschreibung                                                                                   |
|-------------|------------------------------------------------------------------------------------------------|
| singleton   | (Standard) Erstellt nur **eine** Bean Instanz in jedem IoC container. Mehr [hier](#singleton). |
| prototype   | Erstellt eine unbegrenzte Anzahl an Bean Instanzen.                                            |
| request     | Erstellt für jeden HTTP Request eine Bean Instanz.                                             |
| session     | Erstellt für jede HTTP `Session` eine Bean Instanz.                                            |
| application | Erstellt für jeden `ServetContext` eine Bean Instanz.                                          |
| websocket   | Erstellt für jeden `WebSocket` eine Bean Instanz.                                              |

Die beiden wichtigsten Scopes sind `singleton` und `prototype`.

Singleton besagt, dass es immer nur eine Instanz eines Beans gibt, welche dann geteilt wird. Mehr
dazu [hier](#singleton).

Prototype besagt, dass für jede Abhängigkeit ein neues Bean erstellt wird.  
Hier ein Bild:

![PrototypeScopeBild](../new-spring-doc/prototype.png)

Quelle: https://docs.spring.io/spring-framework/docs/current/reference/html/images/prototype.png

Der Scope wird durch die `@Scope` Annotation festgelegt.  
Hier ein Beispiel:

```java
@Configuration
public class MyConfiguration {
    @Bean
    @Scope("prototype")
    public Encryptor encryptor() {
        // ...
    }
}
```

Weitere Information
hier: https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes

## Spring Struktur

![spring-struktur.png](../new-spring-doc/spring-struktur.png)

Die Meisten modernen Webapplikationen bestehen aus 3 Schichten:

Boundary (Grenze): Auf dieser Schicht wird die Kommunikation mit der Aussenwelt abgewickelt.

Control (Verwaltung): Auf dieser Schicht sind alle Klassen und deren Logik.

Entity (Speicher): Auf dieser Schicht wird alles abgewickelt, was mit Datenspeicherung und Auslesung
zu tun hat (zb. mit Repositories).

Spring hat verschiedene Annotationen für verschiedene Aufgaben. Mit der `@Component` Annotation wird
eine generische Spring Komponente dargestellt. Alle anderen Annotationen sind ebenfalls Komponenten.
Sie grenzen nur ab, was sie genau machen. Mit der `@Configuration` Annotation werden Komponenten für die
Konfiguration definiert. Mit der `@Repository` Annotation werden Komponenten, welche mit der Datenspeicherung zu
tun haben definiert. Mit der `@Controller` Annotation werden Komponenten, welche mit der Kommunikation mit
der Aussenwelt zu tun haben definiert. In der `@Service` Annotation werden Komponenten, welche mit der Kontrolllogik zu
tun haben definiert.

### Repository

Eines der am häufigsten verwendeten Design-Patterns (siehe oben) ist das Repository Design-Pattern.
Es ist ein Interface, welches dafür zuständig ist, uns Zugang zu den Daten in der Datenbank zu bereiten.
Man kann es sich ein wenig, wie einen Bibliothekar vorstellen. Er gibt uns die Bücher zurück, die wir
wollen, ohne dass wir wissen, wie er sie uns beschafft. Wir kennen nur die API, also die Befehle
und welche Resultate wir erwarten können.

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
tun.

### Boundary Layer

In diesem Layer definieren wir unsere REST Ressourcen. Hier ein Beispiel einer Order-Klasse in einem
Webshop:

```java

@RestController
@RequestMapping("/orders")
public class OrderResource {
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
Annotation `@RequestMapping("/orders")` legt fest, dass alle Aufrufe auf Orders diese Rest-Resource
verwenden sollen.

Schauen wir uns dies doch ein bisschen genauer an:

```java
@GetMapping("/{id}")
public Order findById(@PathVariable Long id){
    return orderService.findById(id).orElseThrow(EntityNotFoundException::new);
}
```

Mit der `@GetMapping` Annotation bestimmen wir, dass alle Anfragen auf dem `orders/id` Pfad von der
annotierten Methode gehandelt werden. `@PathVariable` bestimmt, dass die ID als Path-Variable
angegeben wird. Das bedeutet, dass ein Aufruf auf `/orders/12` das gleiche Ergebnis hat wie `findByID(12)`.

```java
@PutMapping("/{id}")
public Order update(@PathVariable Long id,@RequestBody Order order){
    return orderService.update(id,order);
}
```

Die Annotation `@RequestBody` wird verwendet, um anzugeben, dass der Parameter `order` aus dem Request-Body des 
HTTP-Requests gelesen werden soll.

### Control Layer

Der Control Layer bildet den Kern aller Anwendungen und enthält dessen Geschäfts-Logiken. Auf der
technischen Ebene ist der Control Layer die grundlegendste und die am wenigsten interessante Schicht.
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

Diese Klasse ist recht einfach aufgebaut, da sie nur zwei Annotationen, nämlich `@Service` und
`@Transactional`, beinhaltet. Die `@Service` Annotation markiert beans als holder
der Businesslogik. `@Transactional` sagt einfach, dass alle Funktionen in der Klasse in einer
einzigen Transaktion ausgeführt werden sollen. Das musst du vorläufig aber noch nicht verstehen.
Durch die Constructor Injection wird hier auch noch die Bean `OrderRepository` injected.

### Entity Layer

Der Entity Layer ist für die Datenspeicherung zuständig. Auf diesem Layer gibt es die zwei Hauptbestandteile
Entity und Repository. Entities sind Klassen die gespeichert werden, Repositories verwalten
diese Entities.

Auch hier wird mit Annotation gearbeitet, um die Funktionalität umzusetzen. Die `@Entity` Annotation sagt, dass es
sich bei dieser Klasse um ein Entity handelt.

Die `@Table` Annotation sagt, auf welcher Tabelle in der Datenbank diese Klasse gespeichert wird
(Schreibweise `@Table(name = "tabelenNamen")`).

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

Du fragst dich vielleicht wo die Daten gespeichert werden. Normalerweise macht Spring eine temporäre
Datenbank, welche jedoch nach Abschluss des Programmes wieder gelöscht wird. Wenn man die Daten nicht
jedes Mal neu schreiben will, kann man sie in einer "richtigen" Datenbank speichern. Dazu müssen wir
die Spring Konfiguration ändern.

Spring lädt die Konfiguration von einer `application.properies` Datei. Diese Datei befindet sich im
resources Ordner.

Es gibt 5 wichtige Konfigurationen

`spring.datasource.url` gibt die URL der Datenbank an (Format:
`jdbc:[datenbanktyp]://[server]:[port]/[datenbank]`)

`spring.datasource.username` gibt den benutzername der Datenbank an

`spring.datasource.password` gibt das Passwort der Datenbank an

`spring.datasource.driver-class-name` gibt an wo der Datenbank treiber ist (muss als maven
Dependency hinzugefügt werden)

`spring.jpa.hibernate.ddl-auto` sagt wie Spring mit der Datenbank umgehen soll. `update` z.B. sorgt
dafür, dass fehlende Spalten oder dergleichen automatisch erstellt werden und dass nie Sachen
gelöscht werden. `create-drop` erstellt die Datenbank und löscht die Objekte nachher. `none` belässt die
Datenbank.

Hier ist eine beispiel Konfiguration mit einer Mariadb Datenbank:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/order
spring.datasource.username=spring
spring.datasource.password=1234
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

### Profile

In Spring kann man verschiedene Profile erstellen. Damit kann man sicherstellen, das bestimmte Dinge
nur dann gemacht werden, wenn man sie braucht. Die Datenbank soll zum Beispiel nur Beispieldaten
laden, wenn das Dev Profil aktiv ist.

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

Im Beispiel lädt die Komponente `TestString` nur wenn das Profil `test` aktiv ist.  
Bei der `@Profile` Annotation kann man auch logische operatoren wie nicht (`!`), und (`&`) und
oder (`|`) benutzen.  
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
die `rewoltString` Methode geladen.

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

Bei beiden möglichkeiten wurde das Profil `test` aktiviert. Weitere Informationen in
der [offiziellen Dokumentation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition-profiles).