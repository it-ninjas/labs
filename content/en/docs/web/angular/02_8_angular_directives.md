---
title: "Directives"
type: docs
linkTitle: "Directives"
weight: 9
date: 2023-05-05
description: >
  Modul #F6 - Angular - Directives
---

## Ziele

- Du weisst, was ein Directive ist und wozu es verwendet wird.
- Du kennst, die drei Arten von Directives und kannst diese beschrieben
- Du kannst, ngIf, ngFor, ngSwitch und ngClass anwenden und erklären.

## Directives

Directives sind ein Mechanismus, um die Darstellung von HTML-Elementen und das Verhalten von Components zu manipulieren. Direktiven ermöglichen es, benutzerdefinierte HTML-Attribute oder -Elemente zu definieren, die spezielle Funktionalitäten bereitstellen, die standardmässig nicht in HTML verfügbar sind.

Es gibt drei Arten von Directives in Angular

## Components-Directives

Components-Directives sind die am häufigsten verwendeten Directives in Angular. Sie erweitern das HTML durch die Definition von benutzerdefinierten HTML-Elementen und enthalten zugehörige Templates und Logik. Components-Direktiven sind im Wesentlichen Angular-Components.

```html
<!--app-greeting.html-->
<app-triumphs [title]="'Triumphs'"></app-triumphs>
```

```typescript
import { Component, Input } from "@angular/core";

@Component({
  // ..
})
export class TriumphsComponent {
  @Input() title: string = "";
}
```

```html
<!--app-triumphs.html-->
<h1>{{ title }}</h1>
```

### Struktur-Directives

Struktur-Directives sind Directives, die das DOM manipulieren und Elemente hinzufügen oder entfernen. Ein Beispiel für eine Struktur-Directive ist `*ngIf`, das ein Element ausblendet, wenn eine Bedingung nicht erfüllt ist.

```html
<!--app-greeting.html-->
<app-triumphs *ngif="hasTriumphs" [title]="'Triumphs'"></app-triumphs>
```

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  // ..
  triumphs: string[] = ["HTML", "CSS", "JavaScript", "TypeScript"];
  hasTriumphs: boolean = this.triumphs.length > 0;
}
```

### \*ngIf

Die `*ngIf`-Direktive wird verwendet, um im Template eines Components Bedingungen zu überprüfen und den darin enthaltenen HTML-Code nur dann anzuzeigen, wenn die Bedingung erfüllt ist. Wenn die Bedingung nicht erfüllt ist, wird der entsprechende HTML-Code aus der gerenderten View entfernt.

Die Verwendung von `*ngIf` ermöglicht es, dynamisch Elemente in der View zu steuern.

```html
<!--app-greeting.html-->
<app-triumphs *ngif="hasTriumphs" [title]="'Triumphs'"></app-triumphs>
```

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  // ..
  triumphs: string[] = ["HTML", "CSS", "JavaScript", "TypeScript"];
  hasTriumphs: boolean = this.triumphs.length > 0;
}
```

### \*ngFor

Die `*ngFor`-Direktive wird verwendet, um eine Liste von Elementen im Template eines Components zu rendern. Mit `*ngFor` kann man über eine Datenquelle iterieren und für jedes Element den entsprechenden Code im Template generieren. Es ist besonders nützlich wenn man Kachel anzeigen möchte oder eine Liste mit User Objekten anzeigen möchte.

```html
<!--app-greeting.html-->
<app-triumphs
  *ngIf="hasTriumphs"
  [title]="'Triumphs'"
  [triumphs]="triumphs"
></app-triumphs>
```

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  // ..
  triumphs: string[] = ["HTML", "CSS", "JavaScript", "TypeScript"];
  hasTriumphs: boolean = this.triumphs.length > 0;
}
```

```html
<!--app-triumphs.html-->
<div *ngFor="let triumph of triumphs">
  <p>{{ triumph }}</p>
</div>
```

```typescript
import { Component, Input } from "@angular/core";

@Component({
  // ..
})
export class TriumphsComponent {
  @Input() title: string = "";
  @Input() triumphs: string[] = [];
}
```

Wenn man den Index bei einem `*ngFor` benötigt kann dieser sehr einfach angegeben werden. Dazu muss man nach dem `*ngFor` den Code `; let i = index` hinzufügen. Nun kann man in den Elementen innerhalb des `*ngFor` auf den Index der Elemente zu greifen.

```html
<div *ngFor="let triumph of triumphs; let i = index">
  <p>{{ triumph }}, {{ i }}</p>
</div>
```

### \*ngSwitch

Das `ngSwitch`-Directive ermöglicht das bedingte Rendern von Inhalten auf der Grundlage eines Ausdrucks mit mehreren möglichen Werten. Es funktioniert ähnlich wie ein `switch` in anderen Programmiersprachen.

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class WeaponComponent {
  weapons: string[] = ["Sword"];
}
```

```html
<div [ngSwitch]="chosenWeapon">
  <div *ngSwitchCase="'Sword'">
    <p>You are wielding a mighty sword!</p>
    <p>Defeat your enemies with precision and power.</p>
  </div>
  <div *ngSwitchCase="'Bow'">
    <p>You have a deadly bow and arrows!</p>
    <p>Strike your foes from a distance with accuracy.</p>
  </div>
  <div *ngSwitchCase="'Staff'">
    <p>Your staff is a conduit of mystical energy!</p>
    <p>Harness the power of magic to overcome your adversaries.</p>
  </div>
  <div *ngSwitchDefault>
    <p>You have not chosen a weapon yet.</p>
    <p>Find your destined weapon and embark on your epic journey.</p>
  </div>
</div>
```

## Attribut-Directives

Attribut-Directives sind Directives, die das Verhalten von HTML-Elementen ändern, ohne sie zu ersetzen. Ein Beispiel für eine Attribut-Direktive ist ngClass, die es ermöglicht, CSS-Klassen basierend auf Bedingungen hinzuzufügen oder zu entfernen.

```html
<h1 appTriumphs>{{ title }}</h1>
```

```typescript
import { Directive, ElementRef, Renderer2 } from "@angular/core";

@Directive({
  selector: "[appTriumphs]",
})
export class TriumphsDirective {
  constructor(
    private elementRef: ElementRef,
    private renderer: Renderer2,
  ) {
    this.renderer.setStyle(this.elementRef.nativeElement, "padding", "10px");
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      "font-style",
      "italic",
    );
    this.renderer.setStyle(
      this.elementRef.nativeElement,
      "text-decoration",
      "underline",
    );
  }
}
```

### ngClass

Die Direktive `ngClass` wird verwendet, um dynamisch CSS/(SCSS)-Klassen auf ein HTML-Element anzuwenden. Sie ermöglicht es, CSS/(SCSS)-Klassen basierend auf Bedingungen oder Ausdrücken hinzuzufügen oder zu entfernen.

Es gibt zwei verschiedene Arten wie `ngClass` verwendet wird.

#### **Variante 1**:

Bei der ersten Variante gibt man zuerst die Klasse an und nach einem Doppelpunkt dann die Bedingung. Bei der Bedingung kann wieder mit Booleans oder Operatoren gearbeitet werden.

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  type: string = "text";
}
```

```html
<div [ngClass]="{'text': type === 'text'}">Text</div>
```

```scss
@import "_variables";

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}
```

Man kann jedoch diese Variante auch für mehrere Klassen machen, indem man diese aneinander reiht und mit einem Komma trennt.

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  type: string = "text";
  textLength: number = 10;
}
```

```html
<div [ngClass]="{'text': type === 'text', 'title' : textLength === 10 }">
  Text
</div>
```

```scss
@import "_variables";

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}

.title {
  color: $black;
  font-family: Arial, sans-serif;
  font-size: 24px;
  font-weight: bold;
}
```

#### **Variante 2**:

Bei der zweiten Variante arbeitet man mit dem [ternary Operator](../../javascript/06_js_operators#ternary-operator-), um zu prüfen ist eine Bedingung `true`, wenn ja verwende die erste angegebene Klasse. Ist die Bedingung jedoch `false` so verwende die zweite Klasse.

```typescript
import { Component } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent {
  textLength: number = 10;
}
```

```html
<div [ngClass]="textLength === 10 ? 'title' : 'text'">Text</div>
```

```scss
@import "_variables";

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}

.title {
  color: $black;
  font-family: Arial, sans-serif;
  font-size: 24px;
  font-weight: bold;
}
```
