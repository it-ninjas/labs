---
title: "Control Flow"
type: docs
linkTitle: "Control Flow"
weight: 10
date: 2024-02-16
description: >
  Modul #F6 - Angular - Neuer Control Flow in Angular
---

### Ziele

- Du weisst, was ein control flow ist und wofür dieser verwendet wird.
- Du kennst die relevanten Änderungen der control flows, die im Rahmen von Angular 17 entstanden sind.

## Control Flow

Im Doc [Directives](../02_8_directives) hast du die Directives `*ngIf`, `*ngFor`, etc. kennengelernt.
In Angular 17 wurde nun ein Built-in Control Flow hinzugefügt, was bedeutet, dass Angular eine eigene Struktur für diese Operationen erstellt hat.
Diese Control Flows können in jedem Template (HTML) eingesetzt werden und lösen ab sofort die bisherigen Directives ab.

## Verwendung

Wie bereits erwähnt können die Control Flows direkt in jeder HTML-Datei in einem Angular-Projekt eingesetzt werden. Aktuell gibt es folgende Control Flows:

### @if & @else

Mit den beiden neuen `@if`- und `@else`-flows wird die Verwendung vereinfacht, sodass beim Lesen des Codes auch das `else` klar sichtbar ist. Bisher musste ein `if-else` also so umgesetzt werden:

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

Auch durch dieses Update ermöglich wurde der `@else if`-flow, was mit den alten directives nur sehr schwer und unschön umsetzbar war.

### @switch

Der neue `@switch`-Flow in Angular 17 bietet eine verbesserte und vereinfachte Möglichkeit, mehrere Bedingungen in einem Template zu überprüfen.
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

Wie du siehst, ist der neue `@switch`-Flow einfacher lesbar und einfacher zu verwenden als der alte `ngSwitch`.
Er ermöglicht eine klare und direkte Art, verschiedene Fälle in deinem Code zu behandeln.

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

Wie du siehst, ist der neue `@for`-Flow einfacher verständlich und simpler in der Verwendung als der alte `*ngFor`-Flow.
Er ermöglicht eine klare und direkte Art, über eine Sammlung von Elementen in deinem Code zu iterieren.

Es ist auch möglich, den Index des aktuellen Elements zu erhalten, das wird mit `track` bewerkstelligt. Hier ist ein Beispiel:

```angular17html
@for (item of items; track $index) {
    {{$index}}: {{item}}
}
```

In diesem Beispiel gibt `{{$index}}` den Index des aktuellen Elements in der Sammlung zurück und `{{item}}` gibt den Wert des aktuellen Elements zurück.
Dies ist besonders nützlich, wenn du sowohl den Index als auch den Wert des Elements in deinem Template benötigst.
Relevant ist hierbei, dass im Vergleich zu früher das Tracken des Index nicht mehr optional ist, sondern bei jeder Verwendung eines `@for`-Flows benötigt wird.

Passend zum `@for` gibt es `@empty`, welches einen Standardwert für den Fall bereitstellt, dass es keine Elemente gibt, über die iteriert werden kann. Hier ein Beispiel dazu:

```angular17html
@for (user of users; track user.id) {
  {{ user.name }}
} @empty {
  Empty list of users
}
```
