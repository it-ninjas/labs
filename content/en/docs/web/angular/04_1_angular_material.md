---
title: "Angular Material, Responsive Web Design und Accessibility"
type: docs
linkTitle: "Angular Material"
weight: 23
date: 2022-03-14
description: >
    Material Design ist eine Designsprache, die für das neue Betriebssystem von Google Android entwickelt wurde, das im Sommer 2014 angekündigt wurde.
    Obwohl sich die Material Design hauptsächlich auf das Touch-Based-Design mobiler Apps konzentriert, ist es möglich, dieselben Ideen in das Webdesign zu übertragen.
---
## Ziele
* Du weisst, das es Material in Angular gibt und wie du es verwendest.

## Material in Angular
Für Angular gibt es eine spezifische Version von Material Design.

Auf der offiziellen Website von Angular Material sehen wir welche Components uns zur Verfügung gestellt werden.

Wenn wir zum Beispiel den "Slider" in unsere Applikation implementieren möchten, gibt es einige Schritte welche wir beachten müssen.
Jeder Component wird auf der Website wie folgt beschrieben:

* **Overview**: Auf der Übersicht wird beschrieben, wie und wozu man den Component anwenden kann.
Oftmals werden hier auch erweiterte Funktionen eines Components aufgelistet. Daher gilt: **Immer aufmerksam durchlesen!**
*  **API**: In diesem Abschnitt ist für uns vor allem der Import wichtig. Für jeden Component muss erst das dazugehörige Modul importiert werden:

```typescript
import { MatSliderModule } from '@angular/material/slider';
...
@NgModule({
    imports: [
        // ..
        MatSliderModule,
        // ..
    ],
    // ..
})
```

* **Examples**: Hier werden Anwendungsbeispiele aufgezeigt, von welchen wir unseren Code ableiten können.
```html
<mat-slider
    class="example-margin"
    [disabled]="disabled"
    [invert]="invert"
    [max]="max"
    [min]="min"
    [step]="step"
    [thumbLabel]="thumbLabel"
    [tickInterval]="getSliderTickInterval()"
    [(ngModel)]="value"
    [vertical]="vertical"
    aria-labelledby="example-name-label">
</mat-slider>
```

Wie Ihr Material in Eurer Angular-Applikation installiert, wird auf der [offiziellen Website](https://material.angular.io/guide/getting-started) ausführlich beschrieben.

## Material Theming
Material Design unterstützt Theming. Ein Theme ist eine Farbpalette, welche für jeden Angular Material Component angewendet wird. 

Ein Theme besteht aus:
* Primärfarbe
* Akzentfarbe
* Warnung
* Vordergrund
* Hintergrund

Es gibt verschiedene pre-built Themes in Material Design, sodass man sich das Erstellen eines Themes von Hand ersparen kann:
* deeppurple-amber.css
* indigo-pink.css
* pink-bluegrey.css
* purple-green.css

Um ein solches Theme zu verwenden, müssen wir dies in unserem globalen Stylesheet importieren:

```typescript
@import '@angular/material/prebuilt-themes/deeppurple-amber.css';
```

Natürlich kann man auch sein eigene Theme für Angular Material erstellen.
Wie ihr dies machen könnt, wird [hier](https://material.angular.io/guide/theming#defining-a-custom-theme) ausführlich beschrieben (Für diejenigen, die mit den Übungen frühzeitig fertig sind).