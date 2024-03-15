---
title: "Control Flow"
type: docs
linkTitle: "Control Flow"
weight: 10
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

```angular17html
<div *ngIf="loggedIn; else anonymousUser">
  The user is logged in
</div>
<ng-template #anonymousUser>
  The user is not logged in
</ng-template>
```

Mit dem neuen Control Flow vereinfacht sich der Code zu:

```angular17html
@if (loggedIn) {
    The user is logged in
} @else {
    The user is not logged in
}
```

Auch durch dieses Update möglich ist ein `@else if`, was mit den alten directives nur sehr schwer und unschön möglich war.

### @switch
Der neue @switch Control Flow in Angular 17 bietet eine verbesserte und vereinfachte Möglichkeit, mehrere Bedingungen in einem Template zu überprüfen. 
Hier ist ein Vergleich zwischen dem alten und dem neuen Ansatz:

Angular 16:
```angular17html

<div [ngSwitch]="accessLevel">
    <admin-dashboard *ngSwitchCase="admin"/>
    <moderator-dashboard *ngSwitchCase="moderator"/>
    <user-dashboard *ngSwitchDefault/>
</div>
```

Angular 17:
```angular17html
@switch (accessLevel) {
    @case ('admin') { <admin-dashboard/> }
    @case ('moderator') { <moderator-dashboard/> }
    @default { <user-dashboard/> }
}
```

Wie du siehst, ist der neue @switch Control Flow viel lesbarer und einfacher zu verwenden als der alte ngSwitch. 
Es ermöglicht eine klare und direkte Art, verschiedene Fälle in deinem Code zu behandeln.

### @for

Der `@for` Control Flow in Angular 17 bietet eine verbesserte und vereinfachte Möglichkeit, über eine Sammlung von Elementen zu iterieren. 
Hier ist ein Vergleich zwischen dem alten und dem neuen Ansatz:

Angular 16:
```angular17html
<div *ngFor="let item of items">
  {{item}}
</div>
```

Angular 17:
```angular17html
@for (item of items; track item) {
    {{item}}
}
```

Wie du siehst, ist der neue `@for` Control Flow viel lesbarer und einfacher zu verwenden als der alte `*ngFor`. 
Es ermöglicht eine klare und direkte Art, über eine Sammlung von Elementen in deinem Code zu iterieren.

Es ist auch möglich, den Index des aktuellen Elements zu erhalten, aber das wird jetzt mit `track` gemacht. Hier ist ein Beispiel:
```angular17html
@for (item of items; track $index) {
    {{$index}}: {{item}}
}
```

In diesem Beispiel gibt `{{$index}}` den Index des aktuellen Elements in der Sammlung zurück und `{{item}}` gibt den Wert des aktuellen Elements zurück.
Dies ist besonders nützlich, wenn du sowohl den Index als auch den Wert des Elements in deinem Template benötigst.

Passend zum `@for` gibt es das `@empty`, welches einen Standardwert oder Ansicht bereitstellt. Hier ein Beispiel dazu:

```angular17html
@for (user of users; track user.id) {
  {{ user.name }}
} @empty {
  Empty list of users
}
```
