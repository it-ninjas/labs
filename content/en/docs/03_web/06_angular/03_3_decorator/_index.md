---
title: "Decorators"
type: docs
linkTitle: "Decorators"
weight: 22
date: 2023-05-17
description: >
  Modul #F6 - Angular - Decorators.
---

## Ziele

- Du weisst, was Decorators in Angular sind.
- Du kennst die verschiedenen Decorators von Angular und kannst diese anwenden.

## Decorators

Decorators sind spezielle Funktionen, die verwendet werden, um zusätzliche Informationen zu einer Klasse, Methode oder Eigenschaft hinzuzufügen oder das Verhalten davon zu ändern. Sie helfen dabei, den Code besser zu organisieren und bestimmte Aufgaben automatisch auszuführen.

Folgende sieben Decorators sind in Angular die meistverwendeten:

- `@Component`: Der `@Component`-Decorator wird verwendet, um einen Component zu definieren.

- `@Directive`: Der `@Directive`-Decorator wird verwendet, um eine [Directives](https://labs.it-ninjas.ch/docs/web/angular/02_8_directives/) zu definieren.

- `@Injectable`: Der `@Injectable`-Decorator wird verwendet, um einen [Service](../02_10_services) zu definieren, er wird aber auch bei [Dependency Injection](../02_17_dependency_injection) verwendet.

- `@Input`: Der `@Input`-Decorator wird verwendet, um eine Eingabeeigenschaft in eines Components oder einer Directive zu definieren.

- `@Output`: Der `@Output`-Decorator wird verwendet, um eine Ausgabeeigenschaft in eines Components oder einer Directive zu definieren.

- `@ViewChild`: Der `@ViewChild`-Decorator wird verwendet, um auf ein Child-Element eines Components zuzugreifen.

- `@ViewChildren`: Der `@ViewChildren`-Decorator wird verwendet, um auf eine Liste von Child-Elementen eines Components zuzugreifen.

### @Component

Der `@Component`-Decorator wird verwendet, um einen Component zu definieren. Er ist einer der wichtigsten Decorators und enthält Metadaten, die Angular dabei helfen, den Component zu verstehen und zu rendern.

Er wird über der Klassen-Deklaration platziert und enthält ein Objekt mit verschiedenen Eigenschaften:

- `selector`: Der selector gibt an, wie der Component in HTML-Dateien referenziert wird. Im folgenden Beispiel wäre das `<app-my-component></app-my-component>`.

- `templateUrl` (oder `template`): Der `templateUrl`-Eigenschaftswert gibt den Pfad zur HTML-Datei an, die das Template des Components enthält. Alternativ kann man auch die template-Eigenschaft verwenden, um das Template direkt innerhalb des `@Component`-Decorators zu definieren, das sollte jedoch vermieden werden.

- `styleUrls` (oder `styles`): Die `styleUrls`-Eigenschaft gibt ein Array von CSS-Dateipfaden an, die für den Component gelten sollen. Man kann auch die `styles`-Eigenschaft verwenden, um den CSS-Code direkt im `@Component`-Decorator einzufügen, dies sollte jedoch vermieden werden.

```typescript
import { Component } from "@angular/core";

@Component({
  selector: "app-greeting",
  templateUrl: "./greeting.component.html",
  styleUrls: ["./greeting.component.scss"],
})
export class GreetingComponent {
  // gesamte Compoenentlogik
}
```

### @Input

Der @Input-Decorator ermöglicht es, Daten von einem übergeordneten Component (Parent) an einen untergeordneten Component (Child) zu übergeben.
Somit wird die Kommunikation zwischen den Components erleichtert:

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

Um die Eingabeeigenschaft zu verwenden und Daten vom Parent zu erhalten, verwendet man die Property-Binding-Syntax im Parent-Element.

```angular17html
<app-triumphs *ngIf="hasTriumphs" [title]="'Triumphs'" [triumphs]="triumphs"></app-triumphs>
```

#### required

Seit Angular 17 bietet `@Input` die Möglichkeit ein Input als benötigt zu markieren.
Der Required-Status wird dadurch dann durch den Compiler geprüft und es wird ein Fehler geworfen, falls der Input nicht angegeben wird.

```typescript
import { Component, Input } from "@angular/core";

@Component({
  // ..
})
export class TriumphsComponent {
  @Input({ required: true }) title: string;
  @Input() triumphs?: string[];
}
```

Somit wäre hier der Input `triumphs` nicht nötig, `title` hingegen schon.

```angular17html
<app-triumphs *ngIf="hasTriumphs" [title]="'Triumphs'"></app-triumphs>
```

#### transform

Mit Angular 17 wurde auch `transform` hinzugefügt, diese Option kann den eingegebenen Wert ähnlich wie eine Pipe umwandeln.
Ein gutes Beispiel dafür ist, wenn eine Grössenangabe gemacht werden muss.
Im folgenden Beispiel kann einfach die Zahl angegeben werden und der Input wird automatisch in Pixel umgewandelt.

```typescript
@Component({...})
export class CustomSlider {
  @Input({transform: appendPx}) widthPx: string = '';
}
function appendPx(value: number) {
  return `${value}px`;
}
```

### @Output

Mit dem @Output-Decorator kann ein Component Ereignisse an den übergeordneten Component (Parent) senden und mitteilen, dass etwas im Component (Child) geschehen ist.

```typescript
import { Component, Output, EventEmitter } from "@angular/core";

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
<p>Triumphpage Titel: {{ triumphTitel }}</p>
<app-triumphs
  *ngIf="hasTriumphs"
  [title]="'Triumphs'"
  [triumphs]="triumphs"
  (titleChange)="handleTitleChange($event)"
></app-triumphs>
```

### @ViewChild

`@ViewChild` wird verwendet, um auf ein Element oder eine Directive in der View eines Components zuzugreifen. Der `@ViewChild`-Decorator wird normalerweise zusammen mit einer Template-Referenzvariable verwendet, um das gewünschte Element oder die gewünschte Directive zu identifizieren.

```typescript
import { Component, ViewChild, ElementRef } from "@angular/core";

@Component({
  // ..
})
export class GreetingComponent implements AfterViewInit {
  @ViewChild("triumphsComponent") triumphsComponent!: TriumphsComponent;

  ngAfterViewInit() {
    this.triumphsComponent.datesOfTriumph.forEach((date) => {
      console.log(date);
    });
  }
}
```

```html
<app-triumphs
  #triumphsComponent
  *ngIf="hasTriumphs"
  [title]="'Triumphs'"
  [triumphs]="triumphs"
  (titleChange)="handleTitleChange($event)"
></app-triumphs>
```

Auf das Element sollte dann erst in der `ngAfterViewInit`-Lifecycle-Hook-Methode zugegriffen werden, da dieser Hook erst ausgelöst wird, wenn die View initialisiert wurde.

### @ViewChildren

Es gibt auch den `@ViewChildren`-Decorator, der ähnlich wie der `@ViewChild`-Decorator funktioniert, jedoch verwendet wird, um auf mehrere Elemente oder Directives in der View eines Components zuzugreifen.

Der `@ViewChildren`-Decorator wird normalerweise zusammen mit einem Selektor oder einer Klasse verwendet, um die gewünschten Elemente oder Directives zu identifizieren. Das Ergebnis ist eine `QueryList`, die eine Sammlung der gefundenen Elemente oder Directives darstellt.

```typescript
import { Component, ViewChildren, QueryList, ElementRef } from "@angular/core";

@Component({
  // ..
})
export class TriumphsComponent implements AfterViewInit {
  @ViewChildren("triumphElements") triumphElements!: QueryList<ElementRef>;

  // ..

  triumphElements: Date[] = [
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
<div *ngFor="let element of datesOfTriumph" #triumphElements>{{ element }}</div>
```
