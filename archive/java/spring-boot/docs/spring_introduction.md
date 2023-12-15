---
title: "Spring Framework Introduction"
linkTitle: "Spring Framework Introduction"
weight: 103
description: >
  A short introduction to the Spring framework
sectionnumber: 6
---

![](../general/outdated.png "Site is outdated")

## {{% param sectionnumber %}}.0: Meta


### {{% param sectionnumber %}}.0.1: Goals

* TODO


### {{% param sectionnumber %}}.0.2: Changelog

| Author | Version | Date | Change |
| --- | --- | --- | --- |  
| Raffael Hertle | 0.1 | 23.1.2022 | Initial version |


### {{% param sectionnumber %}}.0.3: Requirements

* I understand Java basics
* I understand the difference between classes and interfaces and their usages


## {{% param sectionnumber %}}.1: What is a framework

Before understanding what the Spring framework is and does, we need some kind of definition of a framework:

{{% alert title="Framework" %}}

A framework, or software framework, is a platform for developing software applications. It provides a foundation on which software developers can build programs for a specific platform. For example, a framework may include predefined classes and functions that can be used to process input, manage hardware devices, and interact with system software. This streamlines the development process since programmers don't need to reinvent the wheel each time they develop a new application.

A framework is similar to an application programming interface (API), though technically a framework includes an API. As the name suggests, a framework serves as a foundation for programming, while an API provides access to the elements supported by the framework. A framework may also include code libraries, a compiler, and other programs used in the software development process.

> [TechTerms.com](https://techterms.com/definition/framework)

{{% /alert %}}


### {{% param sectionnumber %}}.1.1: What is the Spring framework

At its core the Spring framework is a dependency injection and inversion of control framework. Don't get too confused over these two fancy words yet, we will take a look at them in a second. The Spring framework brings us utility to do almost anything we need in a basic web application: creating web-accessible API endpoints, connecting to a database and saving objects - all comes (more or less) out of the box with the Spring framework.

Let us dive a bit into the concepts and design patterns of enterprise application programming.


### {{% param sectionnumber %}}.2: Core concepts

When designing software and facing problems, we often find ourselves in a similar situation. The problem might be similar, or the solution after a while might be very familiar with what we have done in an earlier project. By generalizing problems and their solutions we create reusable approaches which we call 'design patterns':

{{% alert title="Design pattern" %}}

Design patterns are reusable solutions for software development. They serve as templates that programmers can use when creating applications. They are not specific to individual programming languages, but instead are best practices or heuristics that can be applied in different programming environments.

While design patterns are not language-dependent, they often include objects or classes. Therefore, they are typically associated with object-oriented programming. Individual patterns can be classified into three different categories: 1) creational patterns, 2) structural patterns, and 3) behavioral patterns.

> [TechTerms.com](https://techterms.com/definition/design_pattern)

{{% /alert %}}

The following core concepts are all general design patterns used in almost every enterprise application.

#### {{% param sectionnumber %}}.2.1: Inversion of Control

{{% alert title="Inversion of Control" %}}

Inversion of Control (IoC) is a design principle (although, some people refer to it as a pattern). As the name suggests, it is used to invert different kinds of controls in object-oriented design to achieve loose coupling. Here, controls refer to any additional responsibilities a class has, other than its main responsibility. This includes control over the flow of an application, and control over the flow of an object creation or dependent object creation and binding.

IoC is all about inverting the control. To explain this in layman's terms, suppose you drive a car to your work place. This means you control the car. The IoC principle suggests to invert the control, meaning that instead of driving the car yourself, you hire a cab, where another person will drive the car. Thus, this is called inversion of the control - from you to the cab driver. You don't have to drive a car yourself and you can let the driver do the driving so that you can focus on your main work.

The IoC principle helps in designing loosely coupled classes which make them testable, maintainable and extensible.

> [tutorialsteacher.com](https://www.tutorialsteacher.com/ioc/inversion-of-control)

{{% /alert %}}


#### {{% param sectionnumber %}}.2.2: Dependency Injection

{{% alert title="Dependency Injection" %}}

“In software engineering, dependency injection is a technique whereby one object supplies the dependencies of another object. A ‘dependency’ is an object that can be used, for example as a service. Instead of a client specifying which service it will use, something tells the client what service to use. The ‘injection’ refers to the passing of a dependency (a service) into the object (a client) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.” Source: Wikipedia

Creating objects directly within the class is inflexible because it commits the class to particular objects and makes it impossible to change the instantiation later independently from the class. It stops the class from being reusable if other objects are required and it makes the class hard to test because real objects can not be replaced with mock objects.

> [growin.com](https://www.growin.com/blog/what-is-dependency-injection/)

{{% /alert %}}

We will see a practical example later. Keep the pattern in mind, even though it might be hard to understand at first.


#### {{% param sectionnumber %}}.2.3: Singleton

When talking about Singletons in programming, we talk about objects which are the only instantiation of its class. Meaning that when we use an object of said class, we can be sure that it is the only one instance at runtime of this class.

Read the explanation on [refactoring.guru](https://refactoring.guru/design-patterns/singleton).

The usage shall yet be a mystery to you, we will also use this pattern a lot in the upcoming exercise.


#### {{% param sectionnumber %}}.2.4: Repository

The Repository design pattern is a very common design pattern for managing data access. The repository will be the interface to access all our data stored in our database. Think of the repository being your library front desk manager. We want to access books in the library and we have no idea how they get them to us. We only know their API (instructions) and the results we can expect. The repository usually is an interface defined something like this:

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

The implementation of the interface does not really concern us. Most of the times this is done by the frameworks behind the application. In our case with the Spring framework letting our class extend the `Repository` class of Spring Data will suffice and all the implementation is magically going to happen!


#### {{% param sectionnumber %}}.2.5: REST

The abbreviation **REST** stands for **RE**presentational **S**tate **T**ransfer. It is a architectural approach and became the standard for all web-based applications and is built upon the HTTP protocol. In a RESTful world everything is called a resource. Resources are accessed using standard HTTP methods (GET / POST / DELETE / PUT).

The REST server simply provides access to resources and the client can read and modify these resources. The resources itself are identified by URIs and IDs. REST does not define in which "language" server and client communicate, but most of the times resources are represented by JSON objects.

The following standards are defined for the HTTP methods to access resources:

* **GET**: Provides read only access to a resource
* **POST**: Creates new resources
* **DELETE**: Deletes resources
* **PUT**: Updates or creates resource if not found

Let us take a look at how our REST resources could look like at our store web-application. As we said resources and their access are defined by HTTP Method, Resource name and ID. For example a HTTP GET request to `/orders/15` would return information about the order with ID 15. Resources in a RESTful world are always written in plural. Here are some other examples:

* `POST /orders`: Create a new order
* `GET /orders`: List all orders available
* `PUT /orders/15`: Update order with ID 15
* `DELETE /orders/15`: Delete the order with ID 15


#### {{% param sectionnumber %}}.2.6: (REST-) Resource / Controller

The resource or controller will be the entrypoint of all requests reaching our web-application. Users will make HTTP requests by the frontend to our backend. This API is going to be the code representation of our REST resources.

A representation of a REST resource for our `/orders` resource might look like this:

```java
@RestController
@RequestMapping("/orders")
public class OrderResource {

    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        // Get all orders from the order magical order service
        List<Order> orders = orderService.findAll();
        return orders;
    }
}
```

Do not yet care too much about the code itself. We are going to dive into the code in a few chapters.


#### {{% param sectionnumber %}}.2.7 Assignment 1

Can you provide a definition of a REST resource for an order resource in our theoretical web shop application? Define the methods and endpoints (`/orders/15`). List at least 5 endpoints and their usage in the API.


### {{% param sectionnumber %}}.3: The life in Spring

Let us take a look at the freshly learned design patterns and how we can implement / use them with the help of the Spring framework. Up until now most of the part from this chapter might still be a lot of magic and sound confusing to you.

Most modern web applications are most commonly divided into three layers:

* **Boundary**: The layer that represents the API boundary of the application
* **Control**: The control layer holds all classes with business logic
* **Entity**: The entity layer holds the representation of the data models and their data access classes (repositories)

Let us take a look at code examples representing the core concepts from the chapters before, layer by layer.


#### {{% param sectionnumber %}}.3.1: Boundary Layer

In the boundary layer we define our REST resources. Without further theory, here is an example REST resource for a `Order` class in our web shop:

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

If we take a short look at the class above, we can guess what the class does and what it is used for. This class represents a REST resource in our application. The annotation `@RestController` (Almost all annotations discussed here are from the Spring Framework) defines the class as a REST resource. The annotation `@RequestMapping("/orders")` defines that all HTTP calls requesting the `/orders` path, will invoke this REST controller.

Each method in this REST resource defines an endpoint serving the basic CRUD REST instructions. Let us take a look at one of the methods in detail:

```java

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

```

This method defines that in the context of the resource (`/orders`) all HTTP GET requests on the `/{id}` path will get handled by the function `OrderResource.findById(...)`. The only parameter of this function is `id: Long` which is annotated by the `@PathVariable` annotation, telling us that the parameter called `id` will be handed over as a path variable. Meaning that any request coming to the endpoint `/orders/10` will be interpreted as a call similar to `OrderResource::findById(10)`. Inside the `OrderResource::findById` function we simply delegate the job to the `OrderService` instance to handle the request and fetch the desired order.

Most of the other REST endpoints are quite similar to the function described above, except for the PUT and POST request which have another annotation:

```java

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

```

Here in the PUT mapping we have the annotation `@PathVariable` on the parameter `id: Long` which we already know. The next parameter `order: Order` is annotated with `@RequestBody`. This annotation tells the Spring framework that the parameter will come as the body part of the request:

```s

curl -X POST -d '{"name": "Example"}' -H 'Content-Type: application/json' http://localhost:8080/orders

```

This is an example for a valid request to the POST endpoint on `/orders`. As you can see the request comes with a body `-d '{"name": "Example"}'` which holds a JSON representation of an Order object. The Spring framework will automatically map the JSON Object in the body to the Java Object as the parameter of the request.

Another thing that is new is how we utilize the `OrderService` class. All the functions in the `OrderResource` get passed over to the `OrderService`. This is what we call separation of concern: We let the REST resource handle all the logic connected to the REST and HTTP world and the service class handle all the business logic. But as you already recognized, the object `orderService: OrderService` does not get initialized in this class. It gets passed to the constructor. This is what we call **Constructor Injection** and is a type of **Dependency Injection**. Here is how this works: In the Spring framework there are several annotations which define **Beans** in the applications context.

{{% alert title="Bean" %}}

The objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. These beans are created with the configuration metadata that you supply to the container.

> [tutorialspoint.com](https://www.tutorialspoint.com/spring/spring_bean_definition.htm)

{{% /alert %}}

In other words: Java classes with certain annotations (`@Service` , `@Repository`, `@RestController`, ...) will define **Singletons** in the Spring frameworks context. The framework now sees that another class uses one of these beans (for example defined by constructor injection) and injects the instance in the class automatically.

```java

    [...]

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    [...]

```


#### {{% param sectionnumber %}}.3.2: Control Layer

The control layer holds all the business logic and builds normally the core of all applications. On a technical level this is the most basic and least interesting layer in the application. The orders service class looks as the following:

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

You can see directly that this class looks less complicated and has fewer annotations than the REST resource before. The only annotations in this class are `@Service` and `@Transactional`. The `@Service` annotation tells the Spring framework that the following class is a Java bean holding business logic. The `@Transactional` annotation will simply annotate that all the functions in the class should be executed in a single transaction. Don't mind yet about the `@Transactional` annotation. As you can see we also inject another bean into this class by constructor injection: the `OrderRepository`.


#### {{% param sectionnumber %}}.3.3: Entity Layer

Classes in the entity layer represent the database entities and their access classes (repositories). The `Order` object is represented by the following class:

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

Without the annotations the class looks like one of the simplest java classes. The annotations are pretty straightforward too. The `@Entity` annotation indicates that this is a managed persistence class. The `@Table(name = "")` annotations lets you define how the table is called managing this class. The `@Id` annotations annotates the field `id: Long` to define that the field is used as the primary key in the database. `@GeneratedValue` lets you define values which are created by the underlying data store or database.

To access the database and manage the `Order` objects in the application we use the `OrderRepository`:

```java
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
```

You will notice that the `OrderRepository` is not a `class` but only an `interface` extending Spring's `CrudRepository`. The type parameterization behind the `CrudRepository<Order, Long>` indicates that the managed objects by this repository are `Order` and identified by `Long` (Remember the `@Id Long id` from the `Order` class?). If you check the [documentation](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html) for Spring's `CrudRepository`, you can see what methods are already defined by the interface. You will also notice that we just define an interface and do not implement any of these methods. Spring does this magic for you,


#### {{% param sectionnumber %}}.4: Your own application

Now it is time to get your hands dirty! The first assignment will be to have a Spring Boot application up and running. We will set up a sample dummy application.

There are several ways to get your first application up and running, we will take a look at two of them.


#### {{% param sectionnumber %}}.4.1: UI Approach

To get started with Spring Boot you can use their own starter tool called [spring initializr](https://start.spring.io/). Open the link in the browser of your choice and click through the setup. For a simple hello world example you can just use the following configuration:

* Project: Maven project
* Language: Java
* Spring Boot: Default
* Project Metadata:
  * GroupId: ch.itninja
  * Artifact: helloworld
  * Name: helloworld
  * Description: ...
  * Package name: ch.sbbt.example.helloworld
  * Packaging: Jar
  * Java: 11

Simply click generate afterwards and unzip the project.


#### {{% param sectionnumber %}}.4.2: CLI Approach

For the people who are more CLI focussed, you can use the same tool with your CLI favorites via HTTP.

```s
$ curl -G https://start.spring.io/starter.zip \
    -d dependencies=web \
    -d javaVersion=11 \
    -d groupId=ch.itninja \
    -d artifactId=helloworld \
    -d baseDir=helloworld \
    -o helloworld.zip

$ unzip helloworld.zip
```

or

```s
$ curl -G https://start.spring.io/starter.tgz \
    -d dependencies=web \
    -d javaVersion=11 \
    -d groupId=ch.itninja \
    -d artifactId=helloworld \
    -d baseDir=helloworld \
    -o helloworld.tar

$ tar -xfv helloworld.tar
```

depending on your preferences in compression tools.


#### {{% param sectionnumber %}}.4.3: Start the Application

Import the project in your favorite IDE. Most of the times this can be achieved by opening the maven project file `pom.xml` in your IDE of choice and then import it as a project.

Most IDEs (including IntelliJ) support Spring applications out of the box. As soon as you have your project imported you can start up your application by running the pre-configured run-configuration. If you do not want to rely on your IDE to start up your application you can use any shell of your choice and simply execute:

```s
./mvnw spring-boot:run
```

Let maven download and build your dependencies and as soon as you have a message like:

```s
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.3)

2022-02-09 13:57:45.493  INFO 477193 --- [           main] ch.itninja.helloworld.DemoApplication    : Starting DemoApplication using Java 11.0.2 on rhertle-puzzle with PID 477193 (**************************)
2022-02-09 13:57:45.495  INFO 477193 --- [           main] ch.itninja.helloworld.DemoApplication    : No active profile set, falling back to default profiles: default
2022-02-09 13:57:46.050  INFO 477193 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-02-09 13:57:46.057  INFO 477193 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-02-09 13:57:46.057  INFO 477193 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.56]
2022-02-09 13:57:46.100  INFO 477193 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-02-09 13:57:46.100  INFO 477193 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 569 ms
2022-02-09 13:57:46.322  INFO 477193 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-02-09 13:57:46.329  INFO 477193 --- [           main] ch.itninja.helloworld.DemoApplication    : Started DemoApplication in 1.112 seconds (JVM running for 1.414)
2022-02-09 13:58:03.800  INFO 477193 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-02-09 13:58:03.801  INFO 477193 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-02-09 13:58:03.801  INFO 477193 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms

```

your application has been successfully started! Congratulations!


#### {{% param sectionnumber %}}.4.4: Assignment 2

No it is your turn to implement some code!


##### {{% param sectionnumber %}}.4.4.1: Task 1

Create a resource `GreetingResource` at the path `/greetings` which greets you with a String "Hello World!" response when sending a GET request to `/greetings`.

```s
$ curl -X GET http://localhost:8080/greetings
"Hello World!"
```

Take a look at the classes in the chapter before and implement it yourself.

{{% details title="Solution Task 1" %}}

```java
package ch.itninja.helloworld.greetings.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingResource {

    @GetMapping
    public String greeting() {
        return "Hello, World!";
    }

}
```

The request should return the following:

```s
$ curl http://localhost:8080/greetings
Hello, World!%                                     
```

{{% /details %}}


##### {{% param sectionnumber %}}.4.4.2: Task 2

Continue with your DemoApplication and extend your `GreetingResource` by another endpoint. GET requests at `/greeting/{name}` should return a personalized message `Hello {name}!` as a response!

```s
$ curl -X GET http://localhost:8080/greetings/raffael
"Hello raffael!"
```

Take a look at the classes in the chapter before and implement it yourself.

If you're stuck, take a look at the hint.

{{% details title="Hint Task 2" %}}

We can use the `@PathVariable` annotation to annotate a parameter of the function to get mapped to a path segment of the endpoint definition. Take a look at the example in {{% param sectionnumber %}}.3.1!

{{% /details %}}

If you still cannot solve the Task, you can help yourself with the solution.

{{% details title="Solution Task 2" %}}

```java

package ch.itninja.helloworld.greetings.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingResource {

    @GetMapping
    public String greeting() {
        return "Hello, World!";
    }

    @GetMapping("/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello " + name + "!";
    }


}

```

The request should return the following:

```s
$ curl http://localhost:8080/greetings/raffael
Hello raffael!%                                     
```

{{% /details %}}


##### {{% param sectionnumber %}}.4.4.3: Task 3: Setup application

Now let's build our Order application from the web shop example all the way! We will build all the resources for the `Order` class from scratch:

* Setup Application
* Setup database, application model and repository layer
* Create service / business logic layer
* Define REST endpoints for resources

Let's start with the creation of our application. Create the spring application like we have already seen in the previous chapters. And make a quick check if your application is able to start up!

Try to already create folders for the different packages: order-entity, -control, -boundary:

```s

└── order
    ├── boundary
    │   └── OrderResource.java
    ├── control
    │   └── OrderService.java
    └── entity
        ├── Order.java
        └── OrderRepository.java

```

{{% details title="Hint Task 3" %}}

If you're stuck take a look at the first section {{% param sectionnumber %}}.4!

{{% /details %}}

{{% details title="Solution Task 3" %}}

Use the [spring initializr](https://start.spring.io/) or the CLI approach:

With

```s
$ curl -G https://start.spring.io/starter.zip \
    -d dependencies=web \
    -d javaVersion=11 \
    -d groupId=ch.itninja \
    -d artifactId=helloworld \
    -d baseDir=helloworld \
    -o helloworld.zip

$ unzip helloworld.zip
```

or

```s
$ curl -G https://start.spring.io/starter.tgz \
    -d dependencies=web \
    -d javaVersion=11 \
    -d groupId=ch.itninja \
    -d artifactId=helloworld \
    -d baseDir=helloworld \
    -o helloworld.tar

$ tar -xfv helloworld.tar
```

{{% /details %}}


##### {{% param sectionnumber %}}.4.4.4: Task 4: Database entity

To work with a database we need some additional dependencies to the project.

Let us extend the dependency list in the `pom.xml` and add the following entries:

```xml
    <dependencies>
        <!-- COPY FROM HERE -->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>

        <!-- -->
    </dependencies>

```

These two dependencies allow us to start up a h2 database and add the support for JPA (Java Persistence API) to our application.

Before we start implementing our services and data models, we need to configure the database connections. Copy the following into your `application.properties` file in your project:

```s

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true

```

We first create a simple `Order` class in the `order.entity` package. The `Order` class should have the following properties:

* id
* name
* address
* amount
* date of order

If you need a hint, here you go!

{{% details title="Hint Task 4" %}}

If you're stuck take a look at the first section {{% param sectionnumber %}}.3.3. The other properties can be represented by the following data types:

* name: String
* address: String
* amount: Double
* dataOfOrder: Instant

The new fields do not need any annotations!

{{% /details %}}

If you are completely overwhelmed try the following solution:

{{% details title="Solution Task 4" %}}

```java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String address;
    Double amount;
    Instant dateOfOrder;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Instant getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Instant dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}

```

{{% /details %}}

Try to start up your application! If the application starts normally, you should be alright and ready to continue!


##### {{% param sectionnumber %}}.4.4.5: Task 5: Database repository

So far we have a web application and a data representation for our orders. To do anything with our data representation in our database, we need to access it. This is what the repository will be for. Create the interface `OrderRepository` in the `order.entity` package similar to the example in {{% param sectionnumber %}}.3.3!

{{% details title="Solution Task 5" %}}

```java

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}


```

{{% /details %}}


##### {{% param sectionnumber %}}.4.4.6: Task 6: Control / business logic layer

In this task you will create a service bean to do the basic CRUD operations on the order entity. Take a look at the section {{% param sectionnumber %}}.3.2 and implement an `OrderService` on your own.

To be continued...
