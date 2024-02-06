---
title: "Errorhandling"
type: docs
linkTitle: "Errorhandling"
weight: 15
date: 2023-05-04
description: >
  Modul #F6 - Angular - Errorhandling
---
## Ziele
* Ich weiss, wozu ErrorHandler verwendet werden und wie ich selbst solche implementieren kann.

## ErrorHandler
Da man ja ein `try-catch` nicht verwenden sollte laut Best-Practises, muss man einen anderen Weg finden Error anzufangen. Zudem wäre es mühsam überall einen solchen `try-catch` Block hinzuzufügen.
Praktischer wäre doch ein globales Behandeln von Fehlern. Da kommt dann der `ErrorHandler` ins Spiel.

Der `ErrorHandler` ist eine abstrakte Klasse, die von Angular bereitgestellt wird und über die `handleError()`-Methode verfügt. Der Handler wird verwendet, um globale Fehler in einer Anwendung abzufangen und entsprechend zu behandeln.

```typescript
import { ErrorHandler, Injectable } from '@angular/core';

@Injectable()
export class GlobalErrorHandler extends ErrorHandler {
    override handleError(error: any): void {
      console.log("test")
        
      // Weitere Aktionen ausführen, z.B. Fehlermeldung anzeigen oder Logging durchführen
    }
}
```

Indem du den `GlobalErrorHandler` in der `providers`-Eigenschaft der AppModule-Klasse registrierst, wird dieser als globaler `ErrorHandler` für die Anwendung verwendet. Jeder Fehler, der in der Anwendung auftritt, wird automatisch durch den `GlobalErrorHandler` abgefangen und entsprechend behandelt.
```typescript
@NgModule({
    // ..
    providers: [
        { provide: ErrorHandler, useClass: GlobalErrorHandler }
    ], 
    // ..
})
export class AppModule { }
```
