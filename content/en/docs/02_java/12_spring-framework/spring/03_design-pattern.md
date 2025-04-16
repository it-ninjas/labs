---
title: "Design-Pattern"
linkTitle: "Design-Pattern"
weight: 3
description: >
  Modul #J8 - Spring Framework - Wie sieht das Design-Pattern aus?
---

## Design-Pattern

Design-Patterns sind wiederverwendbare Vorlagen für die Anwendungsentwicklung und sind nicht spezifisch für eine
Programmiersprache. Es gibt verschiedene Arten, z. B. Kreationsmuster, Strukturmuster und Verhaltensmuster, die auch in
Spring genutzt werden.

### Inversion of Control (IoC)

Inversion of Control (IoC) ist ein Prinzip, das vereinfacht gesagt den Kontroll-Fluss umkehrt.
Das Ziel dabei ist es eine lose Kopplung zu erreichen, wodurch der Code eine bessere Testbarkeit,
Wartbarkeit und Erweiterbarkeit erreicht.

IoC wird in Spring durch "Dependency Injection" geregelt, was im nächsten Kapitel vorgestellt wird.
Dabei werden Abhängigkeiten wie Variablen von einer anderen Klasse durch Spring automatisch erstellt und "injiziert" (eingefügt).
Dadurch erspart man sich die Mühe, die Objekte selbst zu erstellen sowie auch wieder aufzuräumen, da diese automatisch aufgeräumt werden.
Zudem werden Zuständigkeiten dadurch getrennt. Spring nutzt dieses Prinzip.

### Dependency Injection (DI)

DI bezeichnet die Weitergabe einer Abhängigkeit an ein Objekt. Spring verwendet einen Inversion-of-Control-Container,
um zu bestimmen, wie und wo die Injektion erfolgt. Es gibt verschiedene Orte im Code, wo DI eingesetzt werden kann.
Es gibt die Konstruktor-, Setter- und Feld-basierte Injection.

##### Konstruktor Injection

Bei einer Konstruktor-Injection fungiert jedes Argument als eine Abhängigkeit.  
Ein Beispiel sieht so aus:

```java

@Component
public class Store {

    private final ProductCatalog catalog;
    private final PricingService pricing;

    public Store(ProductCatalog catalog, PricingService pricing) {
        this.catalog = catalog;
        this.pricing = pricing;
    }
}
```

In diesem Beispiel werden die Beans `catalog` und `pricing` injektiert. Spring sucht sich die passenden Beans selbst heraus, wenn diese
zuvor als solche gekennzeichnet wurden, siehe [hier](#beans).

##### Felder Injection

Bei der Felder Injection werden die Abhängigkeiten direkt in die Felder Injected.
Hier ein Beispiel:

```java
public class Store {
    @Autowired
    private Item item;
}
```

Ein Nachteil der Field-Injection ist, dass es im Gegensatz zur Konstruktor-Injection nicht möglich ist,
alle Instanzvariablen mit `final` zu deklarieren. Mehr Informationen zu der `@Autowired`-Annotation findest du auf dieser [Seite](05_annotationen.md).

### Singleton

Das Singleton Design Pattern stellt sicher, dass von einer Klasse nur eine Instanz existiert. Im Kontext von Spring
können Singleton-Beans erstellt werden, aber es ist wichtig zu beachten, das dies nur innerhalb des Spring-Containers
gilt und nicht systemweit.

### Beans

Ein Bean im Spring Framework ist ein Objekt, das vom Spring IoC (Inversion of Control) Container verwaltet wird.
Der IoC Container ist verantwortlich dafür, die Beans zu instanziieren, ihre Abhängigkeiten zu verwalten und sie
bei Bedarf bereitzustellen. Beans sind die grundlegenden Bausteine einer Spring-Anwendung und repräsentieren in der Regel Dienste,
Komponenten oder andere zentrale Teile der Anwendung.

Einfach ausgedrückt, wenn du eine Klasse hast, die du von Spring verwalten lassen möchtest, deklarierst du sie als Bean.
Der Spring Container kümmert sich dann um die Erstellung und Verwaltung dieses Objekts, sodass du dich nicht um die Details
der Instanziierung oder der Verwaltung von Abhängigkeiten kümmern musst. Dies erleichtert die Entwicklung und Wartung von Anwendungen,
da Spring viele dieser Aufgaben für dich übernimmt.

#### Erstellung von Beans

Beans können auf verschiedene Weisen erstellt werden:

- **XML-Konfiguration:** Historisch gesehen wurden Beans oft in XML-Dateien definiert. Hier wird beschrieben, wie der Container diese Instanzen erstellt und verwaltet.

  ```xml
  <bean id="exampleBean" class="com.example.ExampleClass">
      <property name="someProperty" value="Wert"/>
  </bean>
  ```

- **Java-Konfiguration:** Mit Annotationen und Java-Klassen kann die Konfiguration von Beans lesbarer und flexibler gestaltet werden.

  ```java
  @Configuration
  public class AppConfig {
      @Bean
      public ExampleClass exampleBean() {
          return new ExampleClass();
      }
  }
  ```

#### Verwendung von Beans

Beans werden normalerweise über Injektionen verwendet, um Abhängigkeiten zwischen verschiedenen Komponenten einer
Anwendung zu verwalten. Dies geschieht via Dependency Injection (hier wieder Konstruktor Injection):

```java
@Component
public class ExampleService {
    private final ExampleRepository repository;

    public ExampleService(ExampleRepository repository) {
        this.repository = repository;
    }

    // ...
}
```

Hier wird `ExampleRepository` als Abhängigkeit von `ExampleService` injiziert. Die `@Component`-Annotation wird für dieses Beispiel verwendet, damit die Abhängigkeiten via Dependency Injection eingefügt werden.

Beans sind flexibel, wiederverwendbar und ermöglichen die Modularität von Anwendungen.

In der folgenden offiziellen Dokumentation zu der `@Bean`-Annotation findest du weitere Beispiele, wie Beans erzeugt werden:

- [Using the Bean Annotation](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-bean-annotation)

Und wie sie verwendet werden können:

- [Dependency Injection](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html)

##### Scope

Der Scope eines Beans besagt, wann und wie ein Bean erstellt wird. Zudem sagt der Scope auch, wie lange ein Bean "lebt".

Hier eine Liste der Scopes:

| Scope                | Beschreibung                                                                                                                                                                          |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| singleton (Standard) | Singleton besagt, dass es immer nur eine Instanz eines Beans gibt, welche dann geteilt wird. Es wird daher nur **eine** Bean-Instanz in jedem IoC-Container. Mehr [hier](#singleton). |
| prototype            | Erstellt bei jeder Abhängigkeit eine neue Bean Instanz.                                                                                                                               |
| request              | Erstellt für jeden HTTP Request eine Bean Instanz.                                                                                                                                    |
| session              | Erstellt für jede HTTP `Session` eine Bean Instanz.                                                                                                                                   |
| application          | Erstellt für jeden `ServletContext` eine Bean Instanz.                                                                                                                                |
| websocket            | Erstellt für jeden `WebSocket` eine Bean Instanz.                                                                                                                                     |

Die beiden wichtigsten Scopes sind `singleton` und `prototype`.

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
