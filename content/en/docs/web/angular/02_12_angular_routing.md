---
title: "Routing"
type: docs
linkTitle: "Routing"
weight: 13
date: 2023-05-09
description: >
  Modul #F6 - Angular - Routing
---

## Ziele

- Du weisst, was Routing in Angular ist.
- Du kannst Routing anwenden und weisst, wie man es einsetzt.
- Du kennst die verschiedenen Arten von Routen.
- Du weisst, was RouteGuards sind und kannst diese anwenden.
- Du kennst die Navigation Directive und kannst sie anwenden.

## Routing

Der Angular Router ist ein leistungsstarker JavaScript-Router, der vom Angular Core Team erstellt und gewartet wird. Der Router wird über das Paket `@angular/router` installiert.
Das Paket bietet eine vollständige Routing-Library inklusive:

- Mehreren Router-Outlets
- Verschiedenen Strategien für Path-Matching
- Einem Einfachen Zugriff auf Route-Parameter und Route-Guards, um Components vor unbefugtem Zugriff zu schützen.

Der Angular-Router ist ein zentraler Bestandteil der Angular-Plattform. Entwickler können damit Single Page Applications mit mehreren Views erstellen und zwischen diesen navigieren.

## Router-Outlet

Die Router-Library stellt uns die Router-Outlet Direktive zur Verfügung. In dieser Direktive fügt der Router den Component ein, der anhand der URL abgeglichen wird.
Wir können in einer Angular-Applikation mehrere Outlets hinzufügen, um erweiterte Routing-Szenarien zu implementieren.
Für den Anfang werden wir uns jedoch auf einen einzelnen Outlet beschränken.

```html
<!--app.component.html-->
<div>
  <router-outlet></router-outlet>
</div>
```

## Routen und Pfade

Routen sind Objekte, die aus mindestens einem Pfad- und einem Component-Attribut bestehen.
Das Pfad-Attribut bezieht sich auf den Teil der URL, der eine eindeutige View festlegt, die angezeigt werden soll.
Das Component-Attribut bezieht sich auf den Angular-Component, der dem Pfad zugeordnet wird.

Jede Route ordnet einem Component einen URL-Pfad zu.

Der Router kann, basierend auf einer von uns bereitgestellten Routendefinition, den Benutzer zu einer bestimmten View navigieren.

Schauen wir uns ein Beispiel einer Route an:

```typescript
import { Routes } from "@angular/router";
import { TriumphsComponent } from "./components/triumphs/triumphs.component";
import { WeaponComponent } from "./components/weapon/weapon.component";

const routes: Routes = [
  { path: "triumph", component: TriumphsComponent },
  { path: "weapon", component: WeaponComponent },
];
```

Seit Angular 18 muss in der `app.component.ts`-Datei `RouterOutlet` in den imports hinzugefügt werden, da das Routing ansonsten nicht funktioniert.

```typescript
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  providers: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

```

Falls diese Route so in der Router Konfiguration festgelegt wird, wird der Router den Component `TriumphsComponent` rendern, sobald die URL des Browsers `/triumph` beinhaltet.

### Standard Route

Der Pfad kann auch leer sein. Dieser gibt den Standardpfad einer Applikation an und ist normalerweise auch der Startpunkt der Applikation.

Wichtig ist, dass die Route mit dem leeren Pfad vor anderen Routen definiert ist, da Angular die Routen in der Reihenfolge überprüft, in der sie definiert sind. Dadurch wird sichergestellt, dass die Standardroute für den leeren Pfad richtig erkannt wird.

Beispiel:

```typescript
{ path: '', component: GreetingComponent }
```

### Wildcard Route

Der Pfad kann einen Wildcard String (\*\*) enthalten. Der Router wählt diese Route aus, wenn die angeforderte URL keinen Pfaden der definierten Routen entspricht.
Wenn keine Übereinstimmung gefunden wird, kann dies zum Anzeigen einer "Nicht gefunden"-View oder zum Umleiten zu einer bestimmten View verwendet werden.

Es ist wichtig sicherzustellen, dass die Catch-All-Route am Ende der Route-Konfiguration platziert wird, da Angular die Routen in der Reihenfolge überprüft, in der sie definiert sind. Dadurch wird sichergestellt, dass zuerst nach übereinstimmenden Pfaden gesucht wird, bevor die Standardroute zum Einsatz kommt.

Beispiel:

```typescript
{ path: '**', component: NotFoundComponent }
```

### dynamische Route

Routen können mit Variablen verwendet werden, um dynamische Routen zu ermöglichen. Man kann zum Beispiel den Platzhalter `:id` in der Routendefinition verwenden, um eine Variable (hier eine ID) in den Pfad einzufügen. Diese Variable kann dann von dem entsprechenden Component abgerufen werden.

```typescript
  { path: 'triumph/:id', component: TriumphsComponent },
```

Um die Variable im Component zu verwenden, musst du den `ActivatedRoute`-Service von Angular importieren und im Component verwenden.

Hier ist ein Beispiel, wie man die ID-Variable im UserComponent abrufen kann:

```typescript
import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  // ..
})
export class TriumphsComponent {
  // ..

  id: string = "";

  constructor(private route: ActivatedRoute) {
    const idParam = this.route.snapshot.paramMap.get("id");
    this.id = idParam ? idParam : "";
  }
}
```

Wichtig ist, dass der String innerhalb des `this.route.snapshot.paramMap.get('');` gleich geschrieben ist wie die Variable, welche man im path der Route gegeben hat. Das beduetet, dass man beliebige Variablen setzen kann und nicht nur "id" wie im Beispiel.

## Route Guards

Ein Route Guard ist ein Feature des Angular Routers, mit der wir Logik ausführen können, wenn eine Route angefordert wird.
Es wird häufig verwendet, um zu überprüfen, ob ein Benutzer angemeldet ist und über die nötigen Berechtigungen verfügt, bevor er zugreifen kann.
Somit können wir also dem Benutzer den Zugriff auf die Route ermöglichen oder verweigern.

Für den Route Guard müssen wir das `CanActivateFn`-Interface implementieren, welches im `@angular/router` Paket verfügbar ist.
Die `canActivateFn()` Methode des Interfaces enthält die Logik, um den Zugriff auf die Route zuzulassen oder zu verweigern.

Beispielsweise ermöglicht folgender `Guard` immer den Zugriff auf eine Route, wenn im `WeaponService` die Methode `getWeapons()` keine Waffe zurückliefert:

```typescript
import {
  ActivatedRouteSnapshot,
  CanActivateFn,
  RouterStateSnapshot,
} from "@angular/router";
import { inject } from "@angular/core";
import { WeaponService } from "../services/weapon.service";

export const WeaponGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot,
): boolean => {
  return inject(WeaponService).getWeapons().length === 0;
};
```

`return inject(WeaponService)` in Angular bedeutet, dass die Instanz des `WeaponService` mithilfe der `inject`-Funktion abgerufen wird. Diese Vorgehensweise wird typischerweise in Szenarien angewendet, in denen die Dependency Injection nicht direkt im Konstruktor verfügbar ist.

Eine Route können wir nun anhand dieses Guards schützen, indem wir das "canActivate"-Attribut des Pfades benutzen:

```typescript
{ path: "weapon", canActivate: [WeaponGuard], component: WeaponComponent }
```

**Wichtig**
Wenn man nun auf der Webseite auf die Route navigieren möchte, wird folgender Error in der Konsole erscheinen: `NullInjectorError: No provider for Component!`.

Wenn in diesem Fall ein Guard einen Component verwenden möchte, muss dieser als Abhängigkeit im Guard aufgelöst werden können. Dies kann durch die Verwendung von Dependency Injection gemacht werden.

Die Providers in Angular dienen dazu, Dependency Injection zu konfigurieren, indem sie angeben, welche Objekte (Services, Components, etc.) zur Verfügung gestellt werden und wie sie instanziiert werden sollen. Wenn ein Component oder ein Service als Provider registriert ist, kann darauf zugegriffen werden, indem es als Parameter in den Konstruktor von anderen Components, Services oder Guards eingefügt wird.

Es ist wichtig zu beachten, dass das Registrieren eines Components als Provider in einem Module nicht bedeutet, dass der Component überall automatisch erzeugt wird. Es bedeutet lediglich, dass der Component im Dependency Injection-System verfügbar ist und bei Bedarf instanziiert werden kann.

```typescript
import { WeaponComponent } from "./components/weapon/weapon.component";

@NgModule({
  // ..
  providers: [WeaponComponent],
  // ..
})
export class AppModule {}
```

## Navigation Directive

Der Angular Router stellt die `routerLink`-Directive zum Erstellen von Navigationslinks bereit.
Dieses Directive navigiert anhand des Pfads, welcher dem Component zugeordnet ist.

Beispielsweise:

```html
<a [routerLink]="'/weapon'">Weapon</a>
```

## Resolvers

Ein Resolver ist ein Interface, welches von Klassen als Daten-Provider implementiert werden kann. Ein solcher Provider kann in zusammenarbeit mit dem Router verwendet werden, um Daten während der navigation zu liefern.
Es gibt in jedem Resolver eine `resolve()`-Methode. Der Router wartet jeweils, bis die Daten geliefert sind, bevor die Route aktiviert wird. Nachfolgend ein Beispiel für einen Resolver:

```typescript
interface Resolve<T> {
  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): MaybeAsync<T | RedirectCommand>;
}
```

Genauere Infos zu Resolvern findest du in der Angular-Dokumentation: [Resolvers](https://angular.dev/api/router/Resolve)
