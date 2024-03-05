---
title: "Interceptors"
type: docs
linkTitle: "Interceptors"
weight: 16
date: 2022-03-14
description: >
  Modul #F6 - Angular - Interceptors
---
## Ziele
* Du weisst, was Interceptors in Angular sind und kannst diese anwenden.

## Interceptor
Interceptors in Angular sind eine einfache Möglichkeit des Frameworks, die http-Requests global abzufangen und zu verändern, bevor sie an den Server gesendet werden.
Dies ist sehr praktisch, wenn wir Authentifizierungs-Token konfigurieren, Protokolle der Requests erstellen und benutzerdefinierte Header hinzufügen wollen.

![Interceptor](../images/interceptor.png)

Um einen Interceptor zu implementieren, müssen wir eine Klasse erstellen, die die `Intercept` Methode des `HttpInterceptor` Interface implementiert.

Der folgende Interceptor ist sehr simpel gehalten. Er gibt einfach jeden Request in der Konsole aus:

```typescript
@Injectable()
export class RequestLogInterceptor implements HttpInterceptor {

    intercept(
        request: HttpRequest<any>, 
        next: HttpHandler
    ) : Observable<HttpEvent<any>> {
        console.log(request.url);
        return next.handle(request);
    }
}
```
Die `Intercept` Methode wandelt jeden Request in Observables um, die später durch Aufrufen von `next.handle()` aufgelöst werden.
Für unsere Implementierung ist es also ganz einfach: Wir nehmen den Request entgegen, protokollieren die URL und rufen `next.handle()` auf, um den Request an den Server zu senden, ohne Änderungen daran vorzunehmen.

## Interceptors Providen
Da die Interceptors eine Dependency des HttpClients sind, müssen diese als Provider im gleichen Injektor wie der HttpClient bereitgestellt werden.
Angenommen, wir haben unser `HttpClientModule` in das AppModule importiert, müssen wir die Interceptors hier zu den Providern hinzufügen.

```typescript
//...
import { HTTP_INTERCEPTORS} from '@angular/common/http';
import { RequestLogInterceptor} from '...';

@NgModule({
    //..
    imports: [
        HttpClientModule,
        // ..
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: RequestLogInterceptor,
            multi: true
        },
        // ..
    ],
    // ..
})
export class AppModule{ }
```

Die Option `multi: true` teilt Angular mit, dass Wir mehrere Interceptors bereitstellen, und ist erforderlich, wenn dies das Szenario ist.
In unserem Beispielszenario wäre dies nicht erforderlich, da wir nur einen Interceptor implementiert haben.

Es ist auch wichtig zu berücksichtigen, dass Angular Interceptors in der Reihenfolge anwendet, in der sie bei den Providers des Moduls angegeben sind.

<details>
<summary>Interceptors in Angular 17</summary>

Angular 17 bringt auch bei den Interceptors einigen Änderungen, da man ja nun nicht mehr mit den `modules` arbeitet müssen sie anders angegeben werden. 
Das wird jetzt auch von der `app.config.ts` übernommen.

In der `app.config.ts` muss man nun das `provideHttpClient(withInterceptors([AuthInterceptor]))`angeben. in den eckigen klammern von dem `withInterceptors` gibt man die definierten Konstanten an.
```ts
import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {AuthInterceptor} from "./interceptors/auth.interceptor";

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideHttpClient(withInterceptors([AuthInterceptor]))]
};
```

Zudem ist der Interceptor keine `class` mehr mit `implements`. Er ist nun einfach eine Konstante mit dem Typ eines Interceptors. Ansonsten funktioniert noch alles genau gleich.
```ts
import {HttpRequest, HttpEvent, HttpInterceptorFn, HttpHandlerFn} from '@angular/common/http';
import { Observable } from 'rxjs';

export const AuthInterceptor: HttpInterceptorFn = (
  req: HttpRequest<any>,
  next: HttpHandlerFn
): Observable<HttpEvent<any>> => {
    console.log(request.url);
    return next.handle(request);
};
```

Beispiel für eine Authentifizierung wo das Passwort und der Benutzer, welche mit Base64 verschlüsselt wurden (`btoa`), im Header versendet werden. Jedoch, nur wenn es keine `GET`-Request ist.

```ts
import {HttpRequest, HttpEvent, HttpInterceptorFn, HttpHandlerFn} from '@angular/common/http';
import { Observable } from 'rxjs';

export const AuthInterceptor: HttpInterceptorFn = (
    req: HttpRequest<any>,
    next: HttpHandlerFn
): Observable<HttpEvent<any>> => {

    if (req.method !== 'GET') {
        const authRequest = req.clone({
            setHeaders: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa('admin:admin')
            },
        });
        return next(authRequest);
    }
    return next(req);
};
```
</details>
