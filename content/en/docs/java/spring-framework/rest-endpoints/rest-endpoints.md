---
title: "REST-Endpoints"
linkTitle: "REST-Endpoints"
weight: 14
description: >
  Modul #J8 - Spring Framework - REST-Endpoints
---

## Was ist REST

REST (Representational State Transfer) ist ein Architekturstil für die Kommunikation zwischen Computern in Netzwerken, insbesondere im World Wide Web.
Es basiert auf einer einfachen Idee: Ressourcen, wie z.B. Daten oder Dienste, werden durch eindeutige URLs (Uniform Resource Locators) identifiziert.
Um auf diese Ressourcen zuzugreifen oder sie zu manipulieren, verwendet man standardisierte HTTP-Methoden wie GET (zum Abrufen von Daten),
POST (zum Erstellen neuer Daten), PUT (zum Aktualisieren von Daten) und DELETE (zum Löschen von Daten).

Ein zentrales Konzept von REST ist die Zustandslosigkeit (Statelessness).
Das bedeutet, dass jede Anfrage vom Client an den Server alle Informationen enthalten muss,
die der Server benötigt, um sie zu verstehen und zu verarbeiten, ohne den Zustand von vorherigen Anfragen zu speichern.
Dadurch wird die Skalierbarkeit und Zuverlässigkeit der Kommunikation verbessert.

RESTful APIs (Application Programming Interfaces) sind weit verbreitet, weil sie einfach zu verstehen und zu implementieren sind.
Sie ermöglichen es verschiedenen Systemen, unabhängig von ihrer Plattform oder Technologie, miteinander zu interagieren.
Ein Beispiel für eine RESTful API könnte ein Online-Dienst sein, der Wetterdaten bereitstellt:
Durch eine einfache HTTP-Anfrage kann ein Client aktuelle Wetterinformationen für eine bestimmte Stadt abrufen.

## Verschiedene Request-Arten

Wir schauen uns ein Beispiel eines Controllers an, welcher verschiedene Endpoints definiert.

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
Annotation `@RequestMapping("/orders")` legt fest, dass alle Aufrufe, deren URL mit `"/orders"` beginnen, diesen Rest-Controller
verwenden sollen.

Schauen wir uns die verschiedenen, in diesem File definierten Endpoints doch genauer an.

### Get

Get wird generell genutzt, um Daten von einem bestimmten Ort abzurufen. Beispielsweise das Abrufen von Informationen über Benutzerprofile einer Social-Media-Plattform.

```java
@GetMapping("/{id}")
public Order findById(@PathVariable Long id){
    return orderService.findById(id).orElseThrow(EntityNotFoundException::new);
}
```

Mit der `@GetMapping` Annotation bestimmen wir, dass alle Anfragen auf dem `orders/id` Pfad von der
annotierten Methode gehandelt werden, wenn die HTTP-Methode `GET` verwendet wurde. `@PathVariable` bestimmt, dass die ID als Path-Variable (also in der URL)
angegeben wird. Das bedeutet, dass ein Aufruf auf `/orders/12` das gleiche Ergebnis hat wie der Methodenaufruf `findByID(12)`.

### Put

Put wird fürs Aktualisieren von bestehenden Ressourcen verwendet, indem neue Daten an einen bestimmten Ort gesendet werden.

```java
@PutMapping("/{id}")
public Order update(@PathVariable Long id,@RequestBody Order order){
    return orderService.update(id,order);
}
```

Hier wird mit der `@PutMapping` Annotation ein Put-Endpoint auf dem Pfad `orders/id` definiert. Man kann verschiedene Endpoints für denselben Pfad definieren.
Wichtig ist jedoch, dass sie sich in der Request-Methoden(Get, Put, Post, Delete) unterscheiden.
Die Annotation `@RequestBody` wird verwendet, um anzugeben, dass der Parameter `order` aus dem Request-Body des
HTTP-Requests gelesen werden soll.

### Post

Post wird verwendet, um neue Daten an den Server zu senden, beispielsweise beim Ausfüllen eines Formulars und Absenden der Informationen.

```java
@PostMapping
public Order save(@RequestBody Order order) {
    return orderService.save(order);
}
```

Mit der `@PostMapping` Annotation bestimmen wir, dass alle (Post-)Anfragen auf dem `orders/` Pfad von der
annotierten Methode behandelt werden. Mithilfe der Annotation `@RequestBody` werden die mitgeschickten Daten
(im JSON Format) in ein `order`-Objekt umgewandelt. Im Body der Methode wird nun das `order`-Objekt anhand des
Services gespeichert und das Ergebnis zurückgegeben.

### Delete

Delete wird genutzt, um eine spezifische Ressource auf dem Server zu entfernen. Wie beispielsweise das Löschen eines Benutzerkontos von einer Plattform.

```java
@DeleteMapping("/{id}")
public ResponseEntity delete(@PathVariable Long id) {
    orderService.delete(id);
    return ResponseEntity.ok().build();
}
```

Mit der `@DeleteMapping` Annotation bestimmen wir, dass alle Anfragen auf dem `orders/id` Pfad von diesem Endpoint behandelt werden,
wenn die HTTP-Methode `Delete` verwendet wurde. Dank der `@PathVariable` Annotation wird die ID des zu löschenden Objektes aus der URL genommen und als Long-Wert gespeichert.
Anschliessend wird im Body mithilfe des Services die `Order` mit der entsprechenden ID gelöscht.
Nach dem Löschen wird eine erfolgreiche Antwort (HTTP 200 OK) zurückgegeben.

Mehr Informationen zu den verschiedenen Annotationen findest du [hier](../spring/annotationen.md).
