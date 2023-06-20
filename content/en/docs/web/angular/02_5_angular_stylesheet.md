---
title: "Stylesheet"
type: docs
linkTitle: "Stylesheet"
weight: 7
date: 2023-05-04
description: >
    In diesem Kapitel wird erläutert, wie Angular das Styling von HTML-Elementen vorsieht.
---
## Ziele
* Du weisst, was SCSS ist und kennst dessen Vorteile gegenüber CSS.
* Du kannst, ein Template anhand von Bedingungen stylen.

## Stylesheet
Zu jedem Angular Component gehört ein Stylesheet, dieses ist jedoch nur für diesen Component zuständig, sprich für das HTML-File dieses Components. Erstellt man einen neuen Component über die CLI so wird das Stylesheet automatisch erzeugt.
Somit wird schon vorgegeben das die Styles ausgelagert werden sollten und nicht inline erfolgen. Man kann jedoch auch ein oder mehrere globale Stylesheets erstellen, diese gelten dann wie der Name schon sagt für das gesamte Projekt.

Das Prinzip ist das gleiche wie bei normalem HTML und CSS, es werden KLassen und IDs erstellt um diese dann stylen zu können.

Beim Erstellen eines Angular Projekts kann man sagen, ob CSS, SCSS, SASS oder LESS verwenden möchte. SCSS schauen wir zu einem späteren Zeitpunkt noch an.

![Angular Stylesheet](../images/angular-stylesheet.png)

## SCSS
SCSS (Sassy CSS) ist eine Erweiterung der CSS-Sprache, die zusätzliche Funktionen und Möglichkeiten bietet, um die Entwicklung von Stylesheets zu vereinfachen und effizienter zu gestalten. Die Files erhalten dann nicht mehr den Suffix .css sondern .scss.

Die wichtigsten Hauptfunktionen von SCSS sind:

### Variablen
Mit SCSS kann man Variablen definieren und verwenden, um Werte wie Farben, Schriftarten etc. zu speichern und später im Stylesheet wiederverwenden zu können.

```scss
$black: #000000;

h1 {
  color: $black;
  font-size: 24px;
  font-weight: bold;
}
```

### Verschachtelte Regeln
Mit SCSS kann man verschachtelte Regeln schreiben, um die Lesbarkeit und Struktur des Stylesheets zu verbessern. Statt jedes Element separat zu selektieren, kann die Struktur des HTML-Codes reflektiert werden.

```scss
$black: #000000;

.container {
  width: 100%;

  h1 {
    color: $black;
    font-size: 24px;
    font-weight: bold;
  }

  p {
    color: $black;
    font-size: 16px;
  }
}
```

### Mixins
Mixins ermöglichen es, Gruppen von SCSS-Deklarationen zu definieren und sie an verschiedenen Stellen im Stylesheet wiederzuverwenden.

```scss
@mixin border-radius($radius) {
  -webkit-border-radius: $radius;
  -moz-border-radius: $radius;
  border-radius: $radius;
}

.button {
  @include border-radius(4px);
}
```

### Vererbung
SCSS ermöglicht es, Styles von einer Klasse zu einer anderen zu vererben, ähnlich wie bei der Vererbung in der objektorientierten Programmierung. Dies kann dazu beitragen, den Stylesheet-Code zu reduzieren und die Wartbarkeit zu verbessern.

```scss
$black: #000000;

.container {
  width: 100%;

  .text {
    color: $black;
    font-family: Helvetica, sans-serif;
  }

  h1 {
    @extend .text;
    font-size: 24px;
    font-weight: bold;
  }

  p {
    @extend .text;
    font-size: 16px;
  }
}
```

### Partials & Importieren von Dateien
Mit Partials kann man Stylesheet-Dateien in kleinere Teile aufteilen und sie bei Bedarf in andere Stylesheets importieren. Partials werden in der Regel mit einem führenden Unterstrich `_` in ihrem Dateinamen gekennzeichnet, z.B. `_variables.scss`, `_mixins.scss` etc. Dies hilft, den Code besser zu organisieren denn man kann ihn in logische Module aufzuteilen. Dadurch wird der Code wiederverwendbar. Es ermöglicht, somit nur die benötigten Partials zu importieren.

```scss
// _variables.scss
$black: #000000;
$white: #ffffff;
$gray: #808080;
$blue: #0000ff;
$red: #ff0000;
$yellow: #ffff00;

```
```scss
@import '_variables';

.container {
  width: 100%;

  .text {
    color: $black;
    font-family: Helvetica, sans-serif;
  }

  h1 {
    @extend .text;
    font-size: 24px;
    font-weight: bold;
  }

  p {
    @extend .text;
    font-size: 16px;
  }
}
```


## Template Styling
Es gibt zum einen das [ngClass Directive](../03_7_ts_directives#ngclass), welches verwendet werden kann um CSS/(SCSS)-Klassen dynamisch ins Template einzubinden. 
Alternative dazu gibt es noch die `[class.]` Syntax. Man kann diese Syntax verwenden, um eine einzelne CSS/(SCSS)-Klasse basierend auf einer Bedingung hinzuzufügen oder zu entfernen.
Ob eine Klasse hinzugefügt oder entfernt werden soll, wird meistens anhand eines Boolean aus dem Typescript geprüft. Ist das Boolean `true` so wird die Klasse hinzugefügt, ansonsten wird sie ignoriert.

```typescript
import { Component } from '@angular/core';

@Component({
    // ..
})
export class GreetingComponent {
    isText: boolean = true;
}
```
```html
<div [class.text]="isText">Text</div>
```
```scss
@import '_variables';

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}
```

Alternativ zur prüfung auf ein Boolean kann auch mit Operatoren gearbeitet werden, wie zum Beispiel:
```typescript
import { Component } from '@angular/core';

@Component({
    // ..
})
export class GreetingComponent {
  type: string = 'text';
  textLength: number = 10;
}
```
```html
<p [class.text]="type === 'text' && textLength === 10">Face your fears and embrace the challenges!</p>
```
```scss
@import '_variables';

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}
```

## Globales Stylesheet
Das globale Stylesheet wird automatisch generiert, wenn ein neues Angular-Projekt mit der Angular CLI erstellt wird. Dieses heisst dann im Fall von SCSS `styles.scss`.
Im globalen Stylesheet werden Styles definiert, welche über das ganze Projekt immer gleich sein sollen. Wie zum Beispiel das alle p-tags eine bestimmte Schriftgrösse, Schriftart, Schriftfarbe etc. haben.
```scss
/* Globaler Stil für den Body */

@import '_variables';

body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

.text {
    color: $black;
    font-family: Helvetica, sans-serif;
}

h1 {
    @extend .text;
    font-size: 24px;
    font-weight: bold;
}

p {
    @extend .text;
    font-size: 16px;
}

/* Weitere globale Stilregeln */
```

## ng-deep
In SCSS gibt es den sogenannten `::ng-deep` Selektor, der verwendet wird, um SCSS-Regeln auf Elemente innerhalb von Components anzuwenden, die von der View-Encapsulation betroffen sind. Die View-Encapsulation ist eine Funktion von Angular, die den CSS-Code in eines Components isoliert, um Kollisionen mit dem globalen Stylesheet zu vermeiden.

Wenn SCSS-Regeln in einem Component auf Elemente innerhalb von einem anderen Component, `ng-container` und `ng-template` anwenden möchte, kann dies manchmal zu Problemen führen, da die View-Encapsulation diese Regeln standardmässig nicht zulässt. Hier kommt `::ng-deep` ins Spiel.

Indem `::ng-deep` vor SCSS-Regeln innerhalb des Components gestellt werden, können diese Regeln auf die Elemente innerhalb von `ng-container` und `ng-template` anwenden, unabhängig von der View-Encapsulation.

Beachte jedoch, dass `::ng-deep` als "deprecated" markiert ist, was bedeutet, dass es in Zukunft möglicherweise entfernt wird. Angular empfiehlt stattdessen, eine bessere Strukturierung der Components und die Verwendung von spezifischen Selektoren zu priorisieren, um spezifische Styles auf Elemente anzuwenden.

```scss
  ::ng-deep p {
    /* Stilregel für alle p-Elemente innerhalb des Components,
       einschliesslich innerhalb von ng-container und ng-template */
  }
```
