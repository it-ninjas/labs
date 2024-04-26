---
title: "Errorhandling"
type: docs
linkTitle: "Errorhandling"
weight: 17
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
      console.log("test", error.message)
        
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

<details>
<summary>Error-Handler in Angular 17</summary>

Der Error-Handler beleibt in Angular 17 gleich zum erstellen, nur das verwenden ist anders.

Man muss ihn neu im `app.config.ts` angeben, das sieht dann wie folgt aus:

```ts
export const appConfig: ApplicationConfig = {
    providers: [provideRouter(routes), provideHttpClient(withInterceptors(
        [authInterceptor]
)), {
        provide: ErrorHandler, 
        useClass: GlobalErrorHandler
    }]
};
```

Wenn man den Error-Handler auch bei Service-Subscription verwenden möchte. Muss man einen Interceptor dafür verwenden, dieser fängt dann die Error ab, welche vom Service kommen.

```ts
import { HttpInterceptorFn } from '@angular/common/http';
import {catchError, throwError} from "rxjs";

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(catchError(error => {
    return throwError(() => error)
  }));
};
```

Diesen Interceptor muss man dann, wie andere auch, im `app.config.ts` angeben.
```ts
export const appConfig: ApplicationConfig = {
    providers: [provideRouter(routes), provideHttpClient(withInterceptors(
        [authInterceptor, errorInterceptor]
)), {
        provide: ErrorHandler, 
        useClass: GlobalErrorHandler
}]
};
```

</details>