---
title: "Lazy Loading"
type: docs
linkTitle: "Lazy Loading"
weight: 13
date: 2022-03-14
description: >
  Modul #F6 - Angular - Lazy Loading
---
## Zeile
* Du weisst, was Lazy-Loading ist und kannst es erklären.
* Du kannst, Lazy Loading anwenden.

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
    { path: '', component: GreetingComponent },
    { path: 'triumph/:id', component: TriumphsComponent},
    { path: 'weapon', canActivate: [WeaponGuard], loadChildren: () => import('./components/weapon/weapon.module').then(m => m.WeaponModule) },
];
```

Das neue Modul muss jedoch im `.module.ts`-File, in welchem sich das Routing mit dem `loadChildren` befindet in den imports angegeben werden.
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { WeaponModule } from './components/weapon/weapon.module';


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
export class AppModule { }
```

Für das neuen Modul muss man nun auch dessen Routen verfassen. Dazu ein neues `-routing.module.ts`-File erstellen und eine Standart-Route definieren, dessen Component wird aufgerufen, wenn das Modul geladen wird, also genauer gesagt, wenn in einem anderen Routing die Route mit dem `loadChildren` aufruft wird.
Wichtig hier ist man bei den imports im NgModule nicht mehr `forRoot` für die Routen benötigt sondern `forChild`.

```typescript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeaponComponent } from './weapon.component';

const routes: Routes = [
    { path: '', component: WeaponComponent }, // Standart-Route wenn man vom AppModule auf das WeaponModul wechselt
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
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeaponComponent } from './weapon.component';
import { WeaponRoutingModule } from './weapon-routing.module';


@NgModule({
    declarations: [
        WeaponComponent
    ],
    imports: [
        CommonModule,
        WeaponRoutingModule
    ]
})
export class WeaponModule { }
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