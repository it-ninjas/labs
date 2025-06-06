---
title: "Components"
type: docs
linkTitle: "Components"
weight: 4
date: 2023-05-04
description: >
  Modul #F6 - Angular - Components
---

## Ziele

- Du weisst, was ein Angular Component ist.
- Du weisst, welche vier Dateien zu einem Component gehören.
- Du kannst einen Component ins Template einbinden.

Ein Angular Component setzt sich aus 4 Dateien zusammen:

- [Template](../02_5_templates)
- [Unit Test File](../02_7_unit-test)
- [Stylesheet](../02_6_stylesheet)
- Component (Class)

![Components Description](images/component-desc.png)

## Components

Components sind wie Grundbausteine in einer Angular-Applikation. Components werden mit dem `@Component` Decorator definiert.

Components sind TypeScript Klassen, die die Daten und Kontrollstrukturen zum Verhalten der Templates beinhalten.
Metadaten teilen Angular mit, wie die Components verarbeitet werden sollen (selector, template, style), das kann im Kapitel [Component Decorator](../03_3_decorator#component) genauer nachgelesen werden.
Ein Component hat einen von Angular verwalteten Lifecycle. Angular erstellt und rendert Components zusammen mit ihren Children.
Überprüft, wann sich ihre Properties ändern, und zerstört sie, bevor sie aus dem DOM entfernt werden.
Angular bietet sogenannte [Lifecycle-Hooks](../02_18_life_cycle_hook) an, mit denen wir handeln können, sobald ein bestimmter Teils des Lifecycles auftrtitt.

![Components](images/angular-components-description.png)

### Components im Template aufrufen

In Angular kann man Components im Template aufrufen, indem man ihren Selektor verwendet.

Durch das Aufrufen von Components im Template kann man wiederverwendbare Teile der Benutzeroberfläche erstellen und sie in verschiedenen Teilen der Anwendung verwenden, um Code-Duplikation zu vermeiden, aber auch, um die Lesbarkeit und Wartbarkeit des Codes zu verbessern.

Als erstes muss man den Component erstellen, das geht mit dem [CLI Command](../02_1_einfuehrung#commands) `ng generate component greeting` oder kürzer ` ng g c greeting`:

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-greeting",
  templateUrl: "./app-greeting.html",
  styleUrls: ["./app-greeting.scss"],
})
export class GreetingComponent {
  name: string = "Dragon Warrior";
}
```

```html
<!--app-greeting.html-->
<h1>Hello, {{ name }}!</h1>
```

Nachdem man den Component erstellt hat, kann man ihn im Template eines anderen Components aufrufen, dazu kann man den Selektor verwenden.

```html
<div>
  <app-greeting></app-greeting>
</div>
```

Das Ergebnis ist, dass die `<app-greeting></app-greeting>` Tags durch das gerenderte Template des `GreetingComponent` ersetzt werden. In diesem Fall wird eine Überschrift "Hello, John!" angezeigt, weil `name` im Typescript auf "John" gesetzt ist.
