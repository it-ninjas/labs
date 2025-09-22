---
title: "Angular Material, Responsive Web Design und Accessibility"
type: docs
linkTitle: "Angular Material"
weight: 25
date: 2022-03-14
description: >
  Modul #F6 - Angular - Angular Material
---

## Ziele

- Du weisst, was Angular Material ist und wie du es verwendest.

## Was ist Material

Material Design ist eine Designsprache, die für das neue Betriebssystem von Google Android entwickelt wurde, das im Sommer 2014 angekündigt wurde.
Obwohl sich Material Design hauptsächlich auf das Touch-Based-Design mobiler Apps konzentriert, ist es möglich, dieselben Ideen in das Webdesign zu übertragen.

## Material in Angular

Für Angular gibt es eine speziell angefertigte Version von Material Design.

Auf der [offiziellen Website von Angular Material](https://material.angular.io/) ist einsehbar, welche Components zur Verfügung gestellt werden.

Wenn wir zum Beispiel den `MatSlider` in unsere Applikation implementieren möchten, gibt es einige Schritte, welche wir beachten müssen.
Jeder Component wird auf der Website von Material wie folgt beschrieben:

- **Overview**: Auf der Übersicht wird beschrieben, wie und wozu man den Component anwenden kann.
  Oftmals werden hier auch erweiterte Funktionen eines Components aufgelistet. Daher gilt: **Immer aufmerksam durchlesen!**
  Wenn du einen spezifischen Use-Case mit einem Material-Component abdecken möchtest, kannst du so im Vorhinein schon bestimmen, ob der
  der Component das von dir gewünschte Verhalten / Design umsetzen kann.
- **API**: In diesem Abschnitt ist für uns vor allem der Import wichtig. Für jeden Component muss erst das dazugehörige Modul importiert werden:

```typescript
import { MatSliderModule } from '@angular/material/slider';
...
@Component({
  selector: 'xyz',
  templateUrl: 'xyz.html',
  styleUrl: 'xyz.scss',
  imports:[
    MatSliderModule
  ]
})
```

- **Examples**: In diesem Abschnitt werden jeweils Anwendungsbeispiele aufgezeigt, von welchen wir unseren Code ableiten können.
  Das ist insbesondere nützlich, wenn man noch nicht mit dem Component vertraut ist und sich einen Überblick verschaffen möchte, was alles
  damit umsetzbar ist.

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
  aria-labelledby="example-name-label"
>
</mat-slider>
```

Wie man Material in seiner Angular-Applikation installiert, wird auf der [offiziellen Website](https://material.angular.io/guide/getting-started) ausführlich beschrieben.

## Material Theming

Material Design unterstützt Theming. Ein Theme ist eine Farbpalette, welche defaultmässig auf jeden Angular Material Component angewendet wird
und der App somit ohne grösseren Aufwand einen von Anfang an relativ einheitlichen Look verleiht.

Ein Theme besteht aus:

- Einer Primärfarbe
- Einer Akzentfarbe
- Einer Farbe für Warnungen
- Einer Farbe für den Vordergrund
- Einer Farbe für den Hintergrund

Es gibt verschiedene pre-built Themes in Material Design, sodass man sich das Erstellen eines Themes von Hand ersparen kann:

- deeppurple-amber.css
- indigo-pink.css
- pink-bluegrey.css
- purple-green.css

Um ein solches Theme zu verwenden, müssen wir dies in unserem globalen Stylesheet importieren:

```typescript
@import '@angular/material/prebuilt-themes/deeppurple-amber.css';
```

Bei der ersten Installation von Material wird man bereits gefragt, ob man ein Theme für seine App haben möchte. Insofern
bei der Installation also bereits ein Theme ausgewählt wurde, kann man sich den obenstehenden Schritt sparen.

Natürlich kann man auch sein eigene Theme für Angular Material erstellen.
Wie ihr dies machen könnt, wird [hier](https://material.angular.io/guide/theming#defining-a-custom-theme) ausführlich beschrieben (Für diejenigen, die mit den Übungen frühzeitig fertig sind).
