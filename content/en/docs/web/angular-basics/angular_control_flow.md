---
title: "Angular Control Flow"
type: docs
linkTitle: "Angular Control Flow"
weight: 1
date: 2024-02-16
description: >
    Modul #F6 - Angular - Neuer Control Flow in Angular
---

## Control Flow
Im Doc [Directives](../../angular/02_7_angular_directives) hast du die Directives `*ngIf`, `*ngFor`, usw. kennengelernt.
In Angular 17 wurde nun ein Built-in Control Flow hinzugefügt, was bedeutet, dass Angular eine eigene Struktur für diese Operationen erstellt hat.
Diese Control Flows können in jedem Template (HTML) eingesetzt werden und lösen ab sofort die bisherigen Directives ab.

## Verwendung
Wie bereits erwähnt können die Control Flows direkt in jedem HTML eingesetzt werden. Aktuell gibt es folgende Control Flows.

### @if & @else
Mit den beiden neuen `@if` und `@else` wird die Verwendung vereinfacht, so dass beim Lesen des Codes auch das else klar sichtbar ist. Aktuell musste ein if und also so gemacht werden:

```angular2html
<div *ngIf="loggedIn; else anonymousUser">
  The user is logged in
</div>
<ng-template #anonymousUser>
  The user is not logged in
</ng-template>
```

Mit dem neuen Control Flow vereinfacht sich der Code zu:

```angular2html
@if (loggedIn) {
The user is logged in
} @else {
The user is not logged in
}
```

Auch durch dieses Update möglich ist ein `@else if`, was mit den alten directives nur sehr schwer und unschön möglich war.

### @switch

```angular2html
<div [ngSwitch]="accessLevel">
  <admin-dashboard *ngSwitchCase="admin"/>
  <moderator-dashboard *ngSwitchCase="moderator"/>
  <user-dashboard *ngSwitchDefault/>
</div>
```

```angular2html
@switch (accessLevel) {
  @case ('admin') { <admin-dashboard/> }
  @case ('moderator') { <moderator-dashboard/> }
  @default { <user-dashboard/> }
}
```

### @for