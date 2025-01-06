---
title: "Lazy Loading"
type: docs
linkTitle: "Lazy Loading"
weight: 15
date: 2022-03-14
description: >
  Modul #F6 - Angular - Lazy Loading
---

## Zeile

- Du weisst, was Lazy-Loading ist und kannst es erklären.
- Du kannst, Lazy Loading anwenden.

## Was ist Lazy Loading

Lazy Loading bezeichnet ganz allgemein eine Technik in der Software-Entwicklung, um Daten erst ab diesem Zeitpunkt zu laden, wenn sie benötigt werden.
Im Zusammenhang mit Websites geht es darum, beispielsweise Bilder erst dann vom Server zu laden, wenn diese im sichtbaren Bereich sind.
Dadurch wird die Ladezeit der Seite zu Beginn reduziert. So wird dem User z.B. schon eine Seite angezeigt, obwohl andere Dinge noch geladen werden.
![Lazy loading](../images/lazy_loading.png)

## Lazy Loading in Angular

Standardmässig lädt der Browser alle Angular-Module, bevor der Benutzer mit ihnen arbeiten kann.
Natürlich gibt es auch einige, die nicht oder zumindest nicht sofort benötigt werden.

Genau hier setzt das Lazy Loading an, um die Startgeschwindigkeit zu optimieren: Es stellt sicher, dass nur die wichtigsten Anwendungsbestandteile
im Browser landen, der Rest wird später bei Bedarf angefordert.

Dazu muss man als erstes alle Module identifizieren welche man mittels lazy loading laden möchte. Danach erstellt man für jedes Modul eine neue separate Moduldatei (.module.ts).
Jetzt kann man neuen Components, Services etc. welche zu diesem Modul gehören erstellen oder bestehende verschieben. Damit jedoch immer noch genau glich auf die Components zugegriffen werden können, muss man das routing anpassen.
Die Routen müssen mit der Eigenschaft `loadChildren` verwendet werden, darin sagt man dann welches Modul geladen werden soll, wenn man auf diese Route zugreift.

```typescript
const routes: Routes = [
  { path: "", component: GreetingComponent },
  { path: "triumph/:id", component: TriumphsComponent },
  {
    path: "weapon",
    canActivate: [WeaponGuard],
    loadChildren: () =>
      import("./components/weapon/weapon.module").then((m) => m.WeaponModule),
  },
];
```

Das neue Modul muss jedoch im `.module.ts`-File, in welchem sich das Routing mit dem `loadChildren` befindet in den imports angegeben werden.

```typescript
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { WeaponModule } from "./components/weapon/weapon.module";

@NgModule({
  declarations: [
    // ..
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    WeaponModule,
    // ..
  ],
  // ..
})
export class AppModule {}
```

Für das neuen Modul muss man nun auch dessen Routen verfassen. Dazu ein neues `-routing.module.ts`-File erstellen und eine Standart-Route definieren, dessen Component wird aufgerufen, wenn das Modul geladen wird, also genauer gesagt, wenn in einem anderen Routing die Route mit dem `loadChildren` aufruft wird.
Wichtig hier ist man bei den imports im NgModule nicht mehr `forRoot` für die Routen benötigt sondern `forChild`.

```typescript
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { WeaponComponent } from "./weapon.component";

const routes: Routes = [
  { path: "", component: WeaponComponent }, // Standart-Route wenn man vom AppModule auf das WeaponModul wechselt
  // ..
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WeaponRoutingModule {}
```

Im `.module.ts`-File der neuen Moduls kann man alle Components, etc. des Moduls deklarieren und die imports angeben genau wie beim AppModul. Wichtig ist jedoch das man für das Routing hier dann das neu erstellt des Moduls verwendet und nicht mehr das `AppRoutingModule`.

```typescript
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { WeaponComponent } from "./weapon.component";
import { WeaponRoutingModule } from "./weapon-routing.module";

@NgModule({
  declarations: [WeaponComponent],
  imports: [CommonModule, WeaponRoutingModule],
})
export class WeaponModule {}
```

## Lazy Loading mit Angular Material

Einige Components von [Angular Material](../04_1_angular_material) unterstützen Lazy Loading.

Ein Beispiel hierzu ist das Expansion-Panel.

![Expansion Panel](../images/expansion_panel.png)

Die Inhalte des Expansion Panels werden geladen, auch wenn das Expansion-Panel geschlossen ist.
Wenn man auf einer Ansicht beispielsweise 30 dieser Expansion-Panels anzeigt und den jeweiligen Inhalt lädt, kann dies zu Performance-Problemen führen.

Jedoch unterstützt dieser Component Lazy Loading, wodurch man die Performance-Probleme sehr einfach umgehen kann.
Inhalte werden erst geladen, wenn sich das Expansion-Panel öffnet.

In den meisten Fällen ist das Anwenden von Lazy Loading in Angular Material Components auch kein grosser Aufwand.

Schaut also auf der Angular Material Website in "Overview" des Components immer **gut** nach, ob der Component Lazy Loading unterstützt.

## Deferrable Views

Mit dem Update von Angular 17 wurde eine neue Art des Lazy Loadings hinzugefügt, nämlich die `Deferrable Views`.
Mit der neuen Syntax `@defer` können Components oder andere Inhalte innerhalb eines spezifischen Component dynamisch geladen werden.
Beispielsweise kann ein Component erst geladen werden, sobald er bereitsteht (Alle Dependencies würde aufgelöst).
Das würde dann so aussehen:

```angular17html
@defer {
    <shopping-cart />
}
```

Zum `@defer`-Block gibt es noch einige zusätzliche erweiternden Blöcke, die das Laden und Anzeigen verschönern. Hier eine kurze Übersicht:

### `@placeholder`

Standardmässig lädt der `@defer`-Block keinen Inhalt, was meist unschön ist. Dazu gibt es den `@placeholder`-Block.
Dieser kann als normales Div verwendet werden und beliebigen Inhalt haben.
Logischerweise sollte hier kein Inhalt platziert werden, der auch mit Lazy Loading geladen werden muss/soll.

```angular17html
@defer {
    <shopping-cart />
} @placeholder {
    I'm a placeholder :D
}
```

Der Placeholder bleibt so lange stehen, bis der Inhalt des `@defer` geladen hat.
Wenn es gewünscht ist kann eine Mindestzeit bestimmt werden, in der der Placeholder angezeigt werden muss:

```angular17html
@defer {
    <shopping-cart />
} @placeholder (minimum 500ms){
    I'm a placeholder :D I will stay here atleast 500ms ;)
}
```

### `@loading`

Der `@loading`-Block ähnelt sehr dem `@placeholder`-Block, jedoch ist im `@loading` noch eine zusätzliche Option verfügbar.
Mit `after` kann definiert werden, wann der `@loading`-Block zusehen sein soll.
Dieser überschreibt somit ab diesem Zeitpunkt auch den `@placeholder`-Block.

```angular17html
@defer {
    <shopping-cart />
} @placeholder {
    I'm a placeholder :D I will be overwritten in 100ms :'(
} @loading (after 100ms; minimum 1s) {
  <img alt="loading..." src="loading.gif" />
}
```

Der `@loading`-Block ist vor allem in Kombination mit den [triggers](#defer-mit-trigger) sinnvoll.

### `@error`

Auch der `@error`-Block macht das, was man sich unter dem Namen vorstellt, wenn das Laden des Inhalts fehlschlägt wird der Inhalt des `@error`-Blocks angezeigt.

```angular17html
@defer {
    <shopping-cart />
} @error {
    <p>Failed to load shopping cart :( </p>
}
```

<br>
Alle erwähnten Blöcke können natürlich auch aneinander gereiht werden und so eine klare Struktur abbilden:

```angular17html
@defer {
  <comment-list/>
} @loading {
  Loading…
} @error {
  Loading failed :(
} @placeholder {
  <img src="shopping-placeholder.png">
}
```

### Defer mit Trigger

In einigen Fällen ist es hilfreich, wenn selbst bestimmt werden kann, wann das Lazy Loading beginnt.
Dazu wurden den Deferrable Views zusätzlich `Triggers` hinzugefügt, die den Zeitpunkt des Ladens einschränken.

#### Viewport

Einer dieser `Trigger` ist der `Viewport`. Dieser Trigger wird ausgelöst, wenn ein `@placeholder` im Viewport sichtbar ist.
Der Code dazu würde dann ungefähr so aussehen:

```angular17html
@defer (on viewport) {
    <shopping-cart />
} @placeholder {
  <!-- A placeholder content to show until the shopping-cart loads -->
  <img src="shopping-placeholder.png">
}
```

#### Idle

Der `Trigger` `idle` teilt Angular mit, dass der Inhalt erst geladen werden soll, wenn der Browser keine wichtigen Aufgaben mehr zu erledigen hat.

```angular17html
@defer (on idle) {
    <unimportant-info />
} @placeholder {
  <!-- A placeholder content to show until the unimportant-info loads -->
  <img src="unimportant-info-placeholder.png">
}
```

#### Interaction

Der Name `interaction` verrät bereits, dass der Inhalt hier erst geladen wird, wenn eine Aktion (Klick oder Keydown) auf einem bestimmten Element durchgeführt wird.
Standardmässig ist dieses Element der Placeholder.

```angular17html
@defer (on interaction) {
    <shopping-cart />
} @placeholder {
  <!-- A placeholder content to show until the shopping-cart loads -->
  <img src="shopping-placeholder.png">
}
```

Ein anderes Element kannst du so bestimmen:

```angular17html
<button type="button" #greeting>Hello!</button>
@defer (on interaction(greeting)) {
    <shopping-cart />
} @placeholder {
    <div>Shopping Cart placeholder</div>
}
```

Hier wird also das `shopping-cart` erst geladen, wenn der Button geklickt wird.

#### Hover

Gleich wie beim `Trigger` `interaction` wird hier der Inhalt geladen, wenn über ein Element gehovert wird.
Auch hier ist Standardmässig der Placeholder dieses Element.

```angular17html
@defer (on hover) {
    <shopping-cart />
} @placeholder {
  <!-- A placeholder content to show until the shopping-cart loads -->
  <img src="shopping-placeholder.png">
}
```

Ein anderes Element kannst du so bestimmen:

```angular17html
<div #greeting>Hello!</div>
@defer (on hover(greeting)) {
    <shopping-cart />
} @placeholder {
    <div>Shopping Cart placeholder</div>
}
```

Hier wird also das `shopping-cart` erst geladen, wenn der über das `Hello!` gehovert wird.

#### Timer

Mit dem `Timer` Trigger kann eine bestimmte Zeit in Millisekunden angegeben werden, die gewartet werden soll, bis das Laden beginnt.

```angular17html
@defer (on timer(500ms)) {
    <shopping-cart />
} @placeholder {
  <!-- A placeholder content to show until the shopping-cart loads -->
  <img src="shopping-placeholder.png">
}
```

#### Immediate

Anders als die anderen Trigger wird `Immediate` nicht verzögert durchgeführt, jedoch wird der Inhalt immer noch mit Lazy Loading geladen.
`Immediate` kann hilfreich sein, wenn es Inhalte gibt, die priorität vor anderen Inhalten haben.

```angular17html
@defer (on immediate) {
    <shopping-cart />
} @placeholder {
  <!-- A placeholder content to show until the shopping-cart loads -->
  <img src="shopping-placeholder.png">
}
```

#### When

Mit dem Trigger `When` kann selbst definiert werden unter welchen Bedingungen ein Inhalt geladen wird.
Das `When` funktioniert grundsätzlich wie ein normales if.

```angular17html
@defer (when bedingung) {
<shopping-cart />
}
```

### Prefetching

In einigen Anwendungsfällen kann es Sinn machen, wenn der Inhalt eines `@defer`s bereits bei Möglichkeit vorgeladen wird.
Wenn beispielsweise ein `interaction`-Trigger eingesetzt wird und dieser lange nicht ausgelöst wird.
Dazu kann das Preloading wie folgt aktiviert werden:

```angular17html
@defer (on interaction(greeting); prefetch on idle) {
    <shopping-cart />
} @placeholder {
    <div>Shopping Cart placeholder</div>
}
```

Hier wird zusätzlich zum Trigger noch ein zweiter Trigger für das `prefetch` eingesetzt.
Alle verfügbaren Trigger (inkl. `when`) sind hier zulässig, jedoch macht z.B. `interaction` meist wenig Sinn.
