---
title: "Interceptors"
type: docs
linkTitle: "Interceptors"
weight: 14
date: 2022-03-14
description: >
    Was Interceptors genau sind kann in diesem Kapitel nachgelesen werden.
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
        request: HttpRequest<any>, next: HttpHandler
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