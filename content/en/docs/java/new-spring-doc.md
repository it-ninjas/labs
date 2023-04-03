---
title: "New Spring Doc"
linkTitle: "New Spring Doc"
weight: 16
description: >
  Modul #J11 - Spring Boot
---

#### Ziele

* Ich weiss, was ein Java-Framework ist.
* Ich kenne einige Vor- und Nachteile beim Verwenden eines Java-Frameworks.
* Ich kenne ein paar Module des Spring-Frameworks (z.B. Core, Data-Access, Web usw.) und weiss, welche Aufgaben sie erfüllen.
* Ich kenne die wichtigste Spring-Projekte (z.B. Spring-Boot, Spring-Cloud, Spring-Security usw.) und weiss wofür ich diese einsetzen kann.
* Ich weiss, was "Inversion of Control" (IoC) bedeutet und kenne dessen Vorteile.
* Ich weiss, was "Dependency-Injection" (DI) ist und kenne die verschiedene Möglichkeiten (z.B. Constructor-Based, Setter-Based, Field-Based) um DI in Spring zu benutzen.
* Ich weiss, was ein "Spring-Bean" ist und wie es in Spring erzeugt und verwendet wird.
* Ich kenne die verschiedene Scopes eines "Spring-Beans" (z.B. Singleton, Session, Application usw.).
* Ich kenne die, am häufigsten verwendeten, Spring-Bean Annotationen (z.B. @Configuration, @Component, @Repository, @Controller usw.), wie ich diese einsetze und welchem Zweck sie dienen.
* Ich weiss, was "Wiring" ist und wie es in Spring gemacht wird.
* Ich weiss, wofür Properties in Spring verwendet werden und wie ich Properties in Spring setzen kann.
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

Für das Spring Framework gibt es mehrere Module welche für verschidene Dinge zuständig sind diese
sind in Gruppen Aufgeteilt zb. Core, Data Access, Web, etc.

[comment]: <> (Bildlink funktioniert auf website, nicht in md!)

![spring-module-overview.png](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/images/spring-overview.png)

Im Core Modul sind alle wichtigen sachen drin zb. dependency injection, etc. Im Beans Modul sind
sachen drin mit dem Man die Beans (später mehr) machen kann.

Das JDBC Modul bietet so eine art JDBC interface, mit welchem man auf Datenbanken zugreifen kann.
Das
ORM modul bietet zugriff auf Object mapping APIs z.B. JPA, JDO, Hibernate. Mit dem OXM Modul kann
man
auf Objekt/XML speicher implementationen zugreifen.

Das Web Modul ist für die Kommunikation mit der Aussenwelt zuständig

Weitere Informationen sind in der offiziellen
Dokumentation: https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch01s02.html

### Spring Projekte

Es gibt verschiedenen Spring Projekte, welche alle auf dem Spring Framework basieren und es einem
Erlauben noch mehr mit Spring zu machen es gibt z.B. spring-security welche Sicherheit aspekte
bringt oder spring-shell welches ein cli bereitstellt oder spring-boot mehr dazu im folgenden
absatz.

Weitere Projekte und infos dazu hier: https://github.com/spring-projects

#### Boot

Spring Boot ist eine Art Vereinfachung des normalen spring Frameworks. Bei Spring Boot kann mithilfe
des sogenannten Spring Initialializers Abhängigkeiten wie z.B. Datenbanktreiber oder Software für
die Cloud-infrastruktur ausgewählt werden. Somit entfällt die manuelle Konfiguration des Projektes.
Jedoch ist Spring Boot kein Ersatz für das Spring Framework, denn es hilft vor allem die
Konfiguration zu vereinfachen.

## Design-Pattern

Design-Patterns sind wiederverwendbare Vorlagen, die wir beim Erstellen von Anwendungen verwenden
können. Das gute an diesen Design-Patterns ist, dass sie meist nicht spezifisch für eine
Programmiersprache geschaffen sind, sondern bei vielen verschiedenen Programmiersprachen angewendet
werden können. Es gibt 3 verschiedene Design-Patterns: 1: Kreationsmuster 2: Strukturmuster 3:
Verhaltensmuster

### Inversion of Control

«Inversion of Control» ist ein Prinzip, das besagt, dass eine Entität nur das macht, was ihre
Hauptaufgabe ist. Das heisst, dass jede Entität nur für etwas zuständig ist. Zum Beispiel wenn man
mit dem Auto zur Arbeit fährt, ist man für das Fahren und das Arbeiten zuständig, würde man aber ein
Taxi bestellen ist der Taxifahrer fürs Fahren und du fürs Arbeiten zuständig. Die Zuständigkeiten
sind also getrennt.

Das Spring Framework benutzt das «Inversion of Control» Prinzip.

### Dependency Injection

Eine Dependency oder eine Abhängigkeit (Service) wird in ein Objekt (Client) weitergegeben
(Normalerweise sagt ein Objekt welche Abhängigkeiten es braucht). Das heisst, dass man die
Abhängigkeit einem Objekt, welches diese Benötigt übergeben muss und dass man die Abhängigkeit nicht
ins Objekt importieren kann.

In Spring gibt es einen sogenannten InversionOfControl container, in dem ist z.B. hinterlegt wie und
wo die sachen Injected werden.

Man kann diesen Container auf mehreren arten machen, eine Art wäre so. In diesem Fall wäre die
Container Datei applicationContext.xml

```Java
ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
```

In Spring kann man Abhängigkeiten mit verschiedenen Möglichkeiten Injecten, mit Konstrukteure, settern und Feldern

### Singleton

Wenn wir über Singleton sprechen, geht es um Objekte, die die einzige Instanz von deren Klasse sind.
Das heisst, wenn wir bereits ein Objekt einer bestimmten Klasse benutzen, können wir sicher sein,
dass es kein weiteres Objekt dieser Klasse hier geben wird.

### HTTP Access-Control

Die HTTP-Standards um auf Ressourcen zuzugreifen:

* GET – Ressourcen erhalten
* POST – Neue ressource erstellen
* DELETE – Ressource löschen
* PUT – Ressource aktualisieren oder gegebenenfalls neu erstellen

### Bean

Bean Objekte sind eigentlich das Rückgrat einer Anwendung. Die Bean Objekte werden instanziiert,
zusammengebaut und von einem Spring IoC-Container (Inversion of Control) verwaltet. Sie werden mit
Metadaten erstellt, die sie danach auch an dem Container weiterliefern.

### Spring Struktur

[comment]: <> (Bildlink funktioniert auf website, nicht in md!)

![spring-struktur.png](../new-spring-doc/spring-struktur.png)

Die Meisten modernen Webapplikationen bestehen aus 3 schichten:

Boundary (Grenze): Auf dieser Schicht wird die Kommunikation mit der Aussenwelt abgewickelt.

Control (Verwaltung): Auf dieser Schicht sind alle Klassen mit der Logik.

Entity (Speicher): Auf dieser Schicht wird alles abgewickelt, was mit Datenspeicherung und Auslesung
zu tun hat (zb. Mit Repositories).

### Repository

Eines der am häufigsten verwendeten Design-Patterns (siehe oben) ist das Repository Design-Pattern.
Es ist ein Interface, das dafür zuständig ist, uns Zugang zu den Daten in der Datenbank zu bereiten.
Man kann es sich ein wenig, wie einen Bibliothekar vorstellen. Er gibt uns die Bücher, die wir
wollen, ohne dass wir wissen, wie er sie uns beschafft. Wir kennen nur die API, also die Befehle,
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

In diesem Layer definieren wir unsere REST Resourcen. Hier ein Beispiel einer Order Klasse in einem
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

Dies ist eine rest resource und sie wird definiert mit der Annotation @RestController. Die
Annotation @RequestMapping("/orders") sagt, dass alle calls auf Orders diese Rest Ressource
verwenden sollen.

Schauen wir uns dies doch ein bisschen genauer an:

```java
@GetMapping("/{id}")
public Order findById(@PathVariable Long id){
    return orderService.findById(id).orElseThrow(EntityNotFoundException::new);
    }
```

Mit der @GetMapping annotation bestimmen wir, dass alle Anfragen auf dem orders/id pfad von der
annotierten Methode gehandelt werden. @PathVariable bestimmt, dass die ID als path variable
angegeben wird. Das bedeutet, dass ein call auf /orders/12 das gleiche wie order findByID(12).

```java
@PutMapping("/{id}")
public Order update(@PathVariable Long id,@RequestBody Order order){
    return orderService.update(id,order);
    }
```

Mit @RequestBody bestimmen wir, dass die Antwort als Body Part der Request kommt.

### Control Layer

Control Layer bildet den Kern aller Anwendungen und enthält dessen Geschäft Logiken. Auf der
Technischen Ebene ist der Control Layer die grundlegendste und die wenigste interessante Schicht.
Der Control Layer könnte wie folgt aussehen:

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

Diese Klasse ist recht einfach aufgebaut, da sie nur zwei Annotationen, nämlich @Service und
@Transactional beinhaltet. Die @Service annotation markiert beans als holder
der business logic. @Transactional sagt einfach, dass alle Funktionen in der Klasse in einer
einzigen Transaktion ausgeführt werden sollen. Das musst du vorläufig aber noch nicht verstehen.
Durch die sogenannte constructor injection wird hier auch noch der bean OrderRepository injected.

### Entity Layer

Der Entity Layer ist für die Datenspeicherung zuständig, auf diesem Layer gibt es zwei hauptbestand
Teile Entity und Repository, Entitys sind klassen welche gespeichert werden, Repositorys verwalten
diese Enitys

Auch hier wird spring mit Annotationen gesagt was es machen soll die `@Entity` sagt, dass es sich
bei dieser Klasse um eine Entity geht.

Die `@Table` Annotation sagt auf welcher tabelle, in der Datenbank, diese Klasse gespeichert wird (
Schreibweise `@Table(name = "tabelenNamen")`)

Die `@GeneratedValue` Annotation besagt das diese werte in der Tabelle gespeichert werden.

Die `@Id` Annotation sagt das dieses Feld als id in der Tabelle fungiert.

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

Damit wir auf die Daten zugreifen können brauchen wir ein Repository dazu können wir ein Interface
machen welches `CrudRepository` extended machen, das `CrudRepository` hat schon viele methoden
implementiert deshalb müssen wir keine eigenen implementieren

Hier ein Beispiel:

```java

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
```

Du fragst dich vielleicht wo die Daten gespeichert werden, normalerweise macht Spring eine temporäre
Datenbank, diese wird nach abschluss des Programmes jedoch wieder gelöscht. Wenn man die Daten nicht
jedes mal neu machen will kann man sie in einer "Richtigen" Datenbank speichern, dazu müssen wir die
Spring Konfiguration ändern.

Spring lädt die Konfiguration von einer `application.properies` Datei (diese befindet sich im
resources Ordner)

Es gibt 5 wichtige Konfigurationen

`spring.datasource.url` gibt die URL der Datenbank an (Format:
jdbc:[datenbanktyp]://[server]:[port]/[datenbank]

`spring.datasource.username` gibt den benutzername der Datenbank an

`spring.datasource.password` gibt das Passwort der Datenbank an

`spring.datasource.driver-class-name` gibt an wo der Datenbank treiber ist (muss als maven
Dependency hinzugefügt werden)

`spring.jpa.hibernate.ddl-auto` sagt wie Spring mit der Datenbank umgehen soll zb. `update` sorgt
dafür das fehlende Spalten oder dergleichen automatisch erstellt werden und es werden nie sachen
gelöscht, `create-drop` macht die Datenbank und löscht die objekte nachher, `none` beläst die
Datenbank

Hier ist eine beispiel Konfiguration mit einer Mariadb Datenbank:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/order
spring.datasource.username=spring
spring.datasource.password=1234
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```