---
title: "REST-Endpoints"
linkTitle: "REST-Endpoints"
weight: 15
description: >
---

## Was ist REST

REST (Representational State Transfer) ist ein Designkonzept für das Internet, das Regeln und Standards definiert,
wie Webdienste miteinander kommunizieren. Es basiert auf dem Austausch von Daten über das HTTP-Protokoll und verwendet
einheitliche Methoden wie GET, POST, PUT und DELETE, um auf Ressourcen zuzugreifen und mit ihnen zu interagieren.
REST betont die Verwendung von klaren, eindeutigen URLs und fördert eine zustandslose Kommunikation, was bedeutet,
dass jede Anfrage alle benötigten Informationen enthält, um verstanden zu werden, ohne auf vergangene Anfragen
zurückgreifen zu müssen.

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
Annotation `@RequestMapping("/orders")` legt fest, dass alle Aufrufe, wessen URL mit `"/orders"` beginnen, diesen Rest-Controller
verwenden sollen.

Schauen wir uns die verschiedenen, in diesem File definierten, Endpoints doch gleich ein bisschen genauer an.

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

Hier wird mit der `@PutMapping` Annotation ein Put-Endpoint auf dem Pfad `orders/id` definiert. Wir man kann verschiedene Endpoints für denselben Pfad definieren. Wichtig ist jedoch, dass sie sich in der Request-Art(Get, Put, Post, Delete) unterscheiden.
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
