---
title: "Templates"
type: docs
linkTitle: "Templates"
weight: 6
date: 2023-05-04
description: >
    In diesem Kapitel wird beschrieben wa genau das Template in Angular ist.
---
## Ziele
* Du weisst, was ein Template ist.
* Du weisst, für was ng-container und ng-template sind und kannst diese anwenden.

## Was ist ein Template?
In Angular ist das Template der Teil eines Components, der die Benutzeroberfläche definiert. Es ist im Wesentlichen das HTML, das vom Component angezeigt wird und mit der Benutzer interagieren kann.

Das Template kann jedoch mehr als nur HTML enthalten. Es kann auch Angularspezifische Syntax wie 
[Template Styling](../02_5_angular_stylesheet#template-styling), [Directives](../02_7_angular_directives), [Pipes](../03_2_angular_pipes), 
[Interpolationen](../03_1_angular_data_binding#interpolation) und [Bindings](../03_1_angular_data_binding) enthalten, die die Funktionalität und das Verhalten des Components bestimmen.

```html
<div>
    <h1>Hello, {{ name }}!</h1>

    <div *ngIf="name === 'Dragon Warrior'; else otherName">
        <p>Welcome to the battle against the enemy Angular!</p>

        <p>May your path be filled with glory and triumph!</p>
    </div>

    <ng-template #otherName>
        <p>You are not the true Dragon Warrior. You are not worthy of this battle.</p>
    </ng-template>


    <p>Additional content specific to all warriors...</p>
    <p>Face your fears and embrace the challenges!</p>
</div>
```

## Was ist das DOM
Das Document Object Model (DOM) ist eine Programmierschnittstelle, die eine strukturierte Darstellung des HTML zur Verfügung stellt. Es stellt eine Baumstruktur dar, in der jedes Element im HTML als Knoten (Node) repräsentiert wird.

Durch die Verwendung des DOMs können Entwickler dynamische Webseiten erstellen, auf Benutzerinteraktionen reagieren, Inhalte ändern und vieles mehr. Es ermöglicht die Trennung von Inhalt (HTML), Präsentation (CSS) und Verhalten (JavaScript), was eine flexible und interaktive Webentwicklung ermöglicht.


## ng-container &  ng-template
Durch die Verwendung von `ng-container` und `ng-template` kann der HTML-Code in Components besser strukturiert, lesbarer und wiederverwendbarer gemacht werden. Sie bieten eine flexible Möglichkeit, Inhalte bedingt anzuzeigen, dynamische Templates zu erstellen und den Code effizienter zu gestalten.

`ng-container` und `ng-template` erzeugen kein zusätzliches HTML-Element im DOM, das bedeutet das man nur den HTML-Code innerhalb der beiden im DOM sieht und nur von diesen welche aktiv sind.
Dies eignet sich gut, wenn man andere Directives wie `*ngIf`, `*ngFor` oder `*ngSwitch` verwenden möchte.

Um das `else`-Statement in Kombination mit `ngIf` zu verwenden, definiert man einen Template-Verweis (Referenz) mit einem #-Präfix und verwendet ihn in einem `ng-template`. Somit kann man sagen das wenn die Condition nicht zutrifft man ein anderes Template anzeigen möchte.

Wenn man `ng-container` und `ng-template` verwendet ist vielfach auch ein `*ngTemplateOutlet` im Spiel. `*ngTemplateOutlet` ist auch ein Directive, welche verwendet wird, um ein Template an einer bestimmten Stelle in einem Template eines Components einzusetzen. Es wird verwendet, wenn man nicht mit `*ngif` arbeiten muss (oder will, weil die Bedingung immer true sein sollte). Es ist wie im `else` eine Template-Verweis.


```typescript
import { Component } from '@angular/core';

@Component({
    // ..
})
export class GreetingComponent {
    name: string = 'Dragon Warrior';
}
```
```html
<div>
    <h1>Hello, {{ name }}!</h1>

    <ng-container *ngIf="name === 'Dragon Warrior'; else otherName">
        <ng-container *ngTemplateOutlet="dragonWarrior"></ng-container>
    </ng-container>
    
    <ng-template #dragonWarrior>
        <p>Welcome to the battle against the enemy Angular!</p>

        <p>May your path be filled with glory and triumph!</p>
    </ng-template>

    <ng-template #otherName>
        <p>You are not the true Dragon Warrior. You are not worthy of this battle.</p>
    </ng-template>


    <p>Additional content specific to all warriors...</p>
    <p>Face your fears and embrace the challenges!</p>
</div>
```
Wenn der obenstehende Code gerendert wurde, sieht man das im DOM nun nur der div-tag, den h1-tag und die beiden p-tags zusehen sind, das `ng-container` und `ng-template` nicht.

![DOM](../images/template-dom.png) 
