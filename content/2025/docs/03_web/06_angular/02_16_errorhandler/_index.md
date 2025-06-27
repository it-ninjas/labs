---
title: "Error Handling"
type: docs
linkTitle: "Error Handling"
weight: 17
date: 2023-05-04
description: >
  Modul #F6 - Angular - Error Handling
---

## Ziele

- Ich weiss, wozu ErrorHandler verwendet werden und wie ich selbst solche implementieren kann.

## ErrorHandler

Da man `try-catch` laut Best-Practises ja so gut wie möglich vermeiden sollte, muss man einen anderen Weg finden, Errors abzufangen zu behandeln. Zudem wäre überaus ineffizient, für jeden einzelnen Fehler einen entsprechenden `try-catch`-Block hinzuzufügen.
Praktischer wäre ein globales Handling von Fehlern. Und genau da kommt der `ErrorHandler` ins Spiel.

Der `ErrorHandler` ist eine abstrakte Klasse, welche von Angular bereitgestellt wird und über die `handleError()`-Methode verfügt. Der Handler wird verwendet, um global Fehler in einer Anwendung abzufangen und entsprechend zu behandeln.

```typescript
import { ErrorHandler, Injectable } from "@angular/core";

class GlobalErrorHandler implements ErrorHandler {
  handleError(error: any): void {
    console.log("test", error.message);

    // Weitere Aktionen ausführen, z.B. Fehlermeldung anzeigen oder Logging durchführen
  }
}
```

Seit der Änderung zu standardmässig als `standalone` gehandelten Komponenten muss der `ErrorHandler` nun nicht mehr im `AppModule`, sondern in der `main.ts`-Datei in den Providers hinzugefügt werden:

```typescript
bootstrapApplication(AppComponent, {
  providers: [{ provide: ErrorHandler, useClass: GlobalErrorHandler }],
});
```

Wenn du aber trotzdem eine `module`-basierte entwickelst, musst du den Provider stattdessen innerhalb des `@NgModule`-Decorators des jeweiligen Moduls hinzufügen:

```typescript
@NgModule({
  providers: [{ provide: ErrorHandler, useClass: GlobalErrorHandler }],
})
class MyModule {}
```

Jeder Fehler, der in der Anwendung auftritt, wird auf diese Weise automatisch durch den `GlobalErrorHandler` abgefangen und entsprechend behandelt.
