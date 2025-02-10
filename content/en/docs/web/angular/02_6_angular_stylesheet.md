---
title: "Stylesheet"
type: docs
linkTitle: "Stylesheet"
weight: 7
date: 2023-05-04
description: >
  Modul #F6 - Angular - Stylesheet
---

## Ziele

- Du weisst, was SCSS ist und kennst die Vorteile gegenüber CSS.
- Du kannst ein Template anhand von Bedingungen stylen.

## Stylesheet

Zu jedem Angular Component gehört ein Stylesheet, welches jeweils nur für die entsprechende Komponente verantwortlich ist, sprich für das HTML-File dieses Components. Erstellt man einen neuen Component über die CLI, so wird das Stylesheet automatisch erzeugt.
Somit wird schon vorgegeben, dass die Styles ausgelagert werden sollten und nicht inline erfolgen. Man kann jedoch auch ein oder mehrere globale Stylesheets erstellen, diese gelten dann, wie der Name schon vermuten lässt, für das gesamte Projekt.

Das Prinzip ist das gleiche wie bei normalem HTML und CSS, es werden KLassen und IDs vergeben, um diese dann stylen zu können.

Beim Erstellen eines Angular Projekts kann man angeben, ob CSS, SCSS, SASS oder LESS verwendet werden soll. SCSS schauen wir nun etwas genauer an:

![Angular Stylesheet](../images/angular-stylesheet.png)

## SCSS

SCSS (Sassy CSS) ist eine Erweiterung der CSS-Sprache, die zusätzliche Funktionen und Möglichkeiten bietet, um die Entwicklung von Stylesheets zu vereinfachen und effizienter zu gestalten. Die Files erhalten dann nicht mehr den Suffix `.css` sondern `.scss`.

Die wichtigsten Hauptfunktionen von SCSS sind:

### Variablen

Mit SCSS kann man Variablen definieren und verwenden, um Werte wie Farben, Schriftarten oder Ähnliches zu speichern und später im Stylesheet wiederverwenden zu können.

```scss
$black: #000000;

h1 {
  color: $black;
  font-size: 24px;
  font-weight: bold;
}
```

### Verschachtelte Regeln

Mit SCSS kann man verschachtelte Regeln schreiben, um die Lesbarkeit und Struktur des Stylesheets zu verbessern. Statt jedes Element separat zu selektieren, kann die Struktur des HTML-Codes innerhalb des SCSS-Files reflektiert werden.

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

SCSS ermöglicht es, Styles von einer Klasse zu einer anderen zu vererben, ähnlich wie bei der Vererbung in der objektorientierten Programmierung. Das kann dazu beitragen, die Menge des Stylesheet-Codes zu reduzieren und die Wartbarkeit zu verbessern.

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

Mit Partials kann man Stylesheet-Dateien in kleinere Teile aufteilen und sie bei Bedarf in andere Stylesheets importieren. Partials werden in der Regel mit einem führenden Unterstrich `_` in ihrem Dateinamen gekennzeichnet, z.B. `_variables.scss`, `_mixins.scss` etc. Das hilft, den Code besser zu organisieren, da man ihn somit in logische Module aufteilt. Dadurch wird der Code wiederverwendbar.

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
@import "_variables";

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

Es gibt zum einen das [ngClass Directive](./02_8_angular_directives.md#ngclass), welches verwendet werden kann, um CSS/(SCSS)-Klassen dynamisch ins Template einzubinden.
Alternativ dazu gibt es noch die `[class.]` Syntax. Man kann diese Syntax verwenden, um eine einzelne CSS/(SCSS)-Klasse basierend auf einer Bedingung hinzuzufügen oder zu entfernen.
Ob eine Klasse hinzugefügt oder entfernt werden soll, wird meistens anhand eines Boolean-Werts aus dem Typescript geprüft. Ist das Boolean `true`, so wird die Klasse hinzugefügt, ansonsten wird sie ignoriert.

```typescript
import { Component } from "@angular/core";

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
@import "_variables";

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}
```

Alternativ zur Prüfung auf ein Boolean kann auch mit einer Bedingung gearbeitet werden, wie im folgenden Beispiel:

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
<p [class.text]="type === 'text' && textLength === 10">
  Face your fears and embrace the challenges!
</p>
```

```scss
@import "_variables";

.text {
  color: $black;
  font-family: Helvetica, sans-serif;
}
```

## Globales Stylesheet

Das globale Stylesheet wird automatisch generiert, wenn ein neues Angular-Projekt mit der Angular CLI erstellt wird. Diese Datei heisst dann im Fall von SCSS `styles.scss`.
Im globalen Stylesheet werden Styles definiert, welche über das ganze Projekt immer gleich sein sollen. Zum Beispiel, dass alle p-tags überall eine bestimmte Schriftgrösse, Schriftart, Schriftfarbe oder ähnliches haben.

```scss
/* Globaler Stil für den Body */

@import "_variables";

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

In SCSS gibt es den sogenannten `::ng-deep`-Selektor, der verwendet wird, um SCSS-Regeln auf Elemente innerhalb von Components anzuwenden, die von der View-Encapsulation betroffen sind. Die View-Encapsulation ist eine Funktion von Angular, die den CSS-Code eines Components isoliert, um Kollisionen mit dem globalen Stylesheet zu vermeiden.

Wenn SCSS-Regeln in einem Component auf Elemente innerhalb eines anderen Components, bspw. `ng-container` und `ng-template` angwendet werden sollen, kann dies manchmal zu Problemen führen, da die View-Encapsulation diese Regeln standardmässig nicht zulässt. Hier kommt `::ng-deep` ins Spiel.

Indem `::ng-deep` vor SCSS-Regeln innerhalb des Components hinzugefügt wird, können diese Regeln auf die Elemente innerhalb von `ng-container` und `ng-template` angewendet werden, unabhängig von der View-Encapsulation.

Beachte jedoch, dass `::ng-deep` als "deprecated" markiert ist, was bedeutet, dass es in Zukunft möglicherweise entfernt oder nicht mehr supported wird. Angular empfiehlt stattdessen, eine bessere Strukturierung der Components und die Verwendung von spezifischen Selektoren zu priorisieren, um spezifische Styles auf Elemente anzuwenden.

```scss
::ng-deep p {
  /* Stilregel für alle p-Elemente innerhalb des Components,
       einschliesslich innerhalb von ng-container und ng-template */
}
```
