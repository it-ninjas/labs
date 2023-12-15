---
title: "Decorators"
type: docs
linkTitle: "Decorators"
weight: 20
date: 2023-05-17
description: >
    In disem Kapitel findet man die wichtigsten Informationen u Angular Decorators.
---
## Ziele
* Du weisst, was Decorators in Angular sind.
* Du kennst, die verschiedenen Decorators von Angular und kannst diese anwenden.

## Decorators
Decorators sind spezielle Funktionen, die verwendet werden, um zusätzliche Informationen zu einer Klasse, Methode oder Eigenschaft hinzuzufügen oder das Verhalten davon zu ändern. Sie helfen dabei, den Code besser zu organisieren und bestimmte Aufgaben automatisch auszuführen.

Folgende sieben Decorators sind in Angular die meistverwendeten:
* `@Component`: Der @Component-Decorator wird verwendet, um den Component zu definieren.

* `@Directive`: Der @Directive-Decorator wird verwendet, um eine [Directives](../02_7_angular_directives) zu definieren. 

* `@Injectable`: Der @Injectable-Decorator wird verwendet, um einen [Service](../02_8_angular_services) zu definieren, er wird aber auch bei [Dependency Injection](../02_14_angular_dependency_injection) verwendet. 

* `@Input`: Der @Input-Decorator wird verwendet, um eine Eingabeeigenschaft in eines Components oder Directive zu definieren.

* `@Output`: Der @Output-Decorator wird verwendet, um eine Ausgabeeigenschaft in eines Components oder Directive zu definieren. 

* `@ViewChild`: Der @ViewChild-Decorator wird verwendet, um auf ein Child-Element in eines Components zuzugreifen.

* `@ViewChildren`: Der @ViewChildren-Decorator wird verwendet, um auf eine Liste von Child-Elementen in einen Component zuzugreifen.


### @Component
Der @Component-Decorator wird verwendet, um einen Component zu definieren. Er ist einer der wichtigsten Decorators und enthält Metadaten, die Angular dabei helfen, den Component zu verstehen und zu rendern.

Er wird über der Klassen-Deklaration platziert und enthält ein Objekt mit verschiedenen Eigenschaften:

* `selector`: Der selector gibt an, wie der Component in HTML-Dateien referenziert wird. Im folgenden Beispiel wäre das `<app-my-component></app-my-component>`, damit kann man den Components in anderen Templates verwenden.

* `templateUrl` (oder `template`): Der templateUrl-Eigenschaftswert gibt den Pfad zur HTML-Datei an, die das Template des Components enthält. Alternativ kann man auch die template-Eigenschaft verwenden, um das Template direkt innerhalb des @Component-Decorators zu definieren, das sollte jedoch vermieden werden.

* `styleUrl`s (oder `styles`): Die styleUrls-Eigenschaft gibt ein Array von CSS-Dateipfaden an, die für den Component gelten sollen. Man kann auch die styles-Eigenschaft verwenden, um den CSS-Code direkt im @Component-Decorator einzufügen, dies sollte jedoch vermieden werden.

```typescript
import { Component } from '@angular/core';

@Component({
    selector: 'app-greeting',
    templateUrl: './greeting.component.html',
    styleUrls: ['./greeting.component.scss']
})
export class GreetingComponent {
  // gesamte Compoenentlogik 
}
```

### @Input
Der @Input-Decorator ermöglicht es, Daten von einem übergeordneten Component (Parent) an einen untergeordnete Component (Child) zu übergeben.
Somit wird die Kommunikation zwischen den Components erleichtern

```typescript
import { Component, Input } from '@angular/core';

@Component({
    // ..
})
export class TriumphsComponent {
    @Input() title: string = "";
    @Input() triumphs: string[] = [];
}
```

Um die Eingabeeigenschaft zu verwenden und Daten vom Parent zu erhalten, verwendet man die Property-Bindingsyntax im Parent.
```html
<app-triumphs *ngIf="hasTriumphs" [title]="'Triumphs'" [triumphs]="triumphs"></app-triumphs>
```

### @Output
Mit dem @Output-Decorator kann ein Component Ereignisse an den übergeordneten Component (Parent) senden und mitteilen, dass etwas im Component (Child) geschehen ist.

```typescript
import { Component, Output, EventEmitter } from '@angular/core';

@Component({
    // ..
})
export class TriumphsComponent {
    // ..
    @Output() titleChange: EventEmitter<string> = new EventEmitter<string>();

    // ..
    onTitleChange(value: string) {
        this.title = value;
        this.titleChange.emit(value);
    }
}
```
```html
<input [ngModel]="title" (ngModelChange)="onTitleChange($event)" />
```

Um das Ereignis im Parent zu empfangen und darauf zu reagieren, wird das Event-Binding verwendet.
```html
<p> Triumphpage Titel: {{ triumphTitel }}</p>
<app-triumphs *ngIf="hasTriumphs" [title]="'Triumphs'" [triumphs]="triumphs" (titleChange)="handleTitleChange($event)"></app-triumphs>
```

### @ViewChild
`@ViewChild` wird verwendet, um auf ein Element oder ein Directive in der View eines Components zuzugreifen. Der @ViewChild-Decorator wird normalerweise zusammen mit einer Template-Referenzvariable verwendet, um das gewünschte Element oder das gewünschte Directive zu identifizieren.

```typescript
import { Component, ViewChild, ElementRef } from '@angular/core';

@Component({
    // ..
})
export class GreetingComponent implements AfterViewInit {
    @ViewChild('triumphsComponent') triumphsComponent!: TriumphsComponent;


    ngAfterViewInit() {
        this.triumphsComponent.datesOfTriumph.forEach((date) => {
            console.log(date);
        })
    }
}
```
```html
    <app-triumphs #triumphsComponent *ngIf="hasTriumphs" [title]="'Triumphs'" [triumphs]="triumphs" (titleChange)="handleTitleChange($event)"></app-triumphs>
```

Auf das Element sollte dann erst in der `ngAfterViewInit`-Lifecycle-Hook-Methode zugegriffen werden, da dieser Hook erst ausgelöst wird wenn die View initialisiert wurde.

### @ViewChildren
Es gibt auch den `@ViewChildren`-Decorator, der ähnlich wie der `@ViewChild`-Decorator funktioniert, jedoch verwendet wird, um auf mehrere Elemente oder Directives in der View eines Components zuzugreifen.

Der `@ViewChildren-Decorator` wird normalerweise zusammen mit einem Selektor oder einer Klasse verwendet, um die gewünschten Elemente oder Directives zu identifizieren. Das Ergebnis ist eine `QueryList`, die eine Sammlung der gefundenen Elemente oder Directives darstellt.

```typescript
import { Component, ViewChildren, QueryList, ElementRef } from '@angular/core';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    @ViewChildren('triumphElements') triumphElements!: QueryList<ElementRef>;

    // ..
    
    datesOfTriumph: Date[] = [
        new Date(1412, 0, 23),
        new Date(1823, 2, 12),
        new Date(1945, 3, 20),
        new Date(2023, 10, 20),
    ];
    
    // ..

    ngAfterViewInit(): void {
        this.triumphElements.forEach((triumph) => {
            console.log(triumph.nativeElement);
        });
    }
    
    // ..
}
```
```html
<div *ngFor="let element of elements" #element>{{ element }}</div>
```
