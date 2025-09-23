---
title: "Angular Lyne - Custom Components der SBB"
type: docs
linkTitle: "Angular Lyne"
weight: 26
date: 2025-01-15
description: >
  Modul #F6 - Angular - Angular Lyne
---

## Ziele

- Du weisst, was Angular Lyne ist und wo du Informationen zu den Components finden kannst.
- Du weisst, wie du Lyne in einem Angular-Projekt integrieren kannst.
- Du weisst, wie man Lyne in einem Angular-Projekt einbindet.

## Was ist Angular Lyne?

[Angular Lyne](https://digital.sbb.ch/de/design-system/lyne/overview/) ist ein von der SBB entworfenes und gepflegtes Design System, womit Lyne mit Material vergleichbar, aber nicht gleichzusetzen ist.
Das System wurde entworfen, um SBB-weit eine konsistente und wartbare Designsprache um ein besseres Verständnis innerhalb der verschiedenen Anspruchsgruppen (Entwickler, Stakeholder etc.) zu gewährleisten.

Die weiter oben verlinkte Dokumentation wird als "the Single Source of Truth" - also die einzige Quelle der Wahrheit behandelt. Das heisst konkret, dass alle Guidelines, Designentscheidungen, Baublöcke (=Einzelkomponenten) und weiteres auf der Seite zu finden sind.

Einige Vorteile von Lyne umfassen:

- Es ist eine einzelne, firmenweit genutzte Sprache für Design
- Eine klare, optimisierte Kollaboration wird durch bspw. klare Feedbackmechanismen gewährleistet
- Lyne und die einzelnen Komponenten durchlaufen jeweils einen soliden Testprozess, was das Risiko von potenziell entstehenden Fehlern minimiert.
- Es wird ein Fokus auf eine langfristige Nutzung gelegt, was zukünftige Refactorings unwahrscheinlich macht.
- Und viele weitere.

Es gibt aber auch ein paar Risiken, welche von Seiten des Lyne-Teams klar kommuniziert werden:

- Lyne stellt einen "Single Point of Failure" dar. Wenn das Design-System ausfällt, betrifft das viele andere Projekte.
- Es besteht Potenzial, aufgrund der vorgegebenen Komponenten die Kreativität des Designers einzuschränken.
- Da die Dokumentation den Single Point of Truth darstellt, besteht das Risiko, dass stellenweise Informationen fehlen.

## Wie integriere ich Lyne in ein Angular-Projekt?

Man kann Lyne in drei verschiedene Arten von Projekten einbinden:

- Projekte, die pures Javascript nutzen
- Projekte, die Angular nutzen
- Projekte, die React / Next.js nutzen

Im Rahmen dieser Dokumentation fokussieren wir uns ausschliesslich auf die Einbindung in ein Angular-Projekt.
Möchtest du aber sehen, wie man Lyne in eine der anderen beiden Projektarten einbindet, kannst du das auf der [Getting Started-Page](https://lyne-storybook.app.sbb.ch/?path=/docs/introduction-getting-started--docs) von Lyne nachlesen.

Für diese Anleitung gilt es als Voraussetzung, dass die Angular CLI installiert ist und bereits ein Angular-Projekt besteht. (Vorzugsweise ein leeres, um Konflikte zu vermeiden)
Um Lyne in ein Angular-Projekt einzubinden, gilt es, den folgenden Schritten zu folgen:

1. Installiere mit dem folgenden Befehl über die Konsole das `@sbb-esta/lyne-elements`-Package:

```shell
npm install --save @sbb-esta/lyne-elements
```

2. Es wird vom Lyne-Team schärfstens empfohlen, die `global styles` zu inkludieren. Das kannst du tun, indem du die folgende Anpassung im `styles`-Tag in der `angular.json`-Datei vornimmst:

```json
...
"styles": [
  "src/styles.scss",
  "node_modules/@sbb-esta/lyne-elements/standard-theme.css"
],
...
```

3. Um die Web-Components in Angular zu nutzen, musst du zuletzt noch das `CUSTOM_ELEMENT_SCHEMA` aus dem `@angular/core`-Package im AppComponent importieren:

```typescript
import { CUSTOM_ELEMENTS_SCHEMA, Component } from "@angular/core";

import "@sbb-esta/lyne-elements/button.js";

@Component({
  selector: "lyne-app",
  standalone: true,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  template: ` <sbb-button>Lorem ipsum</sbb-button> `,
})
export class App {}
```

## Wie nutze ich Lyne in meinem Projekt?

Im Rahmen dieses Abschnitts sollen exemplarisch einige wichtige Aspekte beleuchtet werden, die beim Styling mit Lyne gut zu wissen sind.

### CSS-Dateien

Die von Lyne genutzten Styles befinden sich grundsätzlich alle in der `standard-theme.css`-Datei, welche nach der Integration von Lyne bereits im Projekt vorhanden sein sollten.

Möchtest du aber beispielsweise spezifischer aussuchen, welche Styles du genau brauchen möchtest, gibt es grundsätzlich folgende Dateien, welche von Lyne bereitgestellt werden:

| Dateiname                       | Beschreibung                                                                            |
| ------------------------------- | --------------------------------------------------------------------------------------- |
| `standard-theme.css`            | Beinhält normalizing, core styles und alle verfügbaren CSS-Klassen.                     |
| `font-characters-extension.css` | Beinhält das gesamte Character-Set für die SBB-Font.                                    |
| `normalize.css  `               | Beinhält grundlegende Styles, die die defaultmässigen Browser-Styles resetten.          |
| `core.css`                      | Beinhält nötige Basics, um die Lyne-Komponenten nutzen zu können. (Bspw. Design Tokens) |
| `a11y.css`                      | Stellt CSS-Klassen bereit, welche der Accesibility dienen.                              |
| `animation.css`                 | Stellt CSS-KLassen bereit, die Animation deaktivieren. (Bspw. nützlich für Testing)     |
| `layout.css`                    | Stellt CSS-KLassen bereit, die dem Layouting dienen. (Bspw. page-spacing, grid, etc.)   |
| `lists.css`                     | Stellt CSS-Klassen bereit, die für das Styling von Listen gebraucht werden.             |
| `scrollbar.css`                 | Stellt CSS-Klassen bereit, die für das Styling der Scrollbar gebraucht werden.          |
| `table.css`                     | Stellt CSS-Klassen bereit, die für das Styling von Tabellen gebraucht werden.           |
| `typography.css`                | Stellt CSS-Klassen bereit, die für die Typographie gebraucht werden.                    |

### Lean variant

Es ist möglich, mit Lyne Komponenten automatisch den kleinsten möglichen `size`-Wert annehmen zu lassen, um ohne viel Aufwand ein kompaktes Design zu ermöglichen.
Wichtig dabei zu beachten ist, dass das jeweils nur bei Komponenten funktioniert, die auch ein `size`-Property besitzen.
Um den "lean mode" zu aktivieren, muss lediglich die CSS-Klasse `sbb-lean` zum `html`-Tag hinzugefügt werden:

```html
<html lang="en" class="sbb-lean">
  <head>
    <title>Lean example</title>
  </head>
  <body>
    ...
  </body>
</html>
```

### Full Font

Die `standard-theme.css`-Datei beinhält ein Subset der SBB-Fonts, welche nicht alle Zeichen beinhält.
Um die Fonts mit den fehlenden Zeichensätzen zu ergänzen, muss die `font-characters-extension.css`-Datei in der Datei `styles.css` importiert werden.
Wichtig: Der Import muss direkt nach dem Import der `standard-theme.css`-Datei gemacht werden:

```css
@import "@sbb-esta/lyne-elements/standard-theme.css";
@import "@sbb-esta/lyne-elements/font-characters-extension.css";
```

### CSS-Klassen

Grundsätzlich sind die von Lyne bereitgestellten Styles in den Components. Es ist aber dennoch möglich, dass man in spezifischen Fällen die Styles von Components überschreiben möchte.
Um das zu bewerkstelligen, können die CSS Variablen eines Components verwendet werden. Die spezifischen Variablen, die man anpassen kann, sind in der Dokumentation des jeweiligen Lyne-Components einsehbar.

### Animations

Animations gehören grundsätzlich zum von Lyne vorgesehenen Design und sollten nicht unterdrückt / deaktiviert werden, es kann aber für das Testing stellenweise dennoch nützlich sein, die Animationen (zeitweise) zu deaktivieren.
Um die Animationen für ein Element zu deaktivieren, kann die CSS-Klasse `sbb-disable-animations` zum Element hinzugefügt werden. Wenn nur für ein übergreifendes Element (bspw. einen Wrapper) die Animation deaktiviert werden soll, kann die CSS-Klasse `sbb-disable-animations-locally` verwendet werden.
Es ist ebenfalls möglich, die Animationen des Parent-Elements mit `sbb-disable-animations` zu deaktivieren und die der Child-Components mit `sbb-enable-animations` zu aktivieren, was dasselbe bewerkstelligt:

```html
<sbb-component class="sbb-disable-animation-locally">
  <!-- animations will play -->
</sbb-component>

<!-- Or  alternatively-->

<sbb-component class="sbb-disable-animation">
  <sbb-component class="sbb-enable-animation">
    <!-- animations will play -->
  </sbb-component>
</sbb-component>
```

### Masseinheiten

Alle Tokens und Components von Lyne verwenden als Masseinheit `rem`. Damit keine Inkosistenzen beim Design entstehen, wird empfohlen, für den Rest der Applikation ebenfalls `rem` als Masseinheit zu verwenden.

### Fonts

Die SBB stellt einige verschiedene Fonts bereit, welche von der `font-weight` abhängen. Grundsätzlich wird in Lyne zwischen drei Arten von `font-weight` unterschieden:

- Roman
- Bold
- Light

Lyne mappt die Fonts automatisch auf das `font-weight`-Property. Wenn einem Element beispielsweise die Eigenschaft `font-weight: bold` hinzugefügt wird, wählt Lyne für dieses Element automatisch den korrespondierenden Zeichensatz aus.
Die SBB bietet zwar mehr Fonts an, Lyne beschränkt sich aber auf die drei genannten Fonts.
