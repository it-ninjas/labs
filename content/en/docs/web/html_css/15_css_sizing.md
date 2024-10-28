---
title: "Sizing"
type: docs
linkTitle: "Sizing"
weight: 15
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Dimensionierung von (Inline-)Block-Elementen mit CSS.

  Auf dieser Seite erfährst du, wie du die Grössen von Elementen definierst.
---

#### Ziele

- Ich verstehe den Unterschied zwischen Block- und Inline-Elementen und kann diese in HTML erkennen.
- Ich kann sowohl relative als auch absolute Einheiten in CSS verwenden, um die Größe von Elementen zu bestimmen.
- Ich kann Abstände zwischen und innerhalb von Elementen mithilfe von Margin und Padding in CSS gezielt einstellen.

## Block- und Inline-Elemente

Bevor wir Elemente dimensionieren, müssen wir wissen, welche Elemente wir überhaupt dimensionieren können.

In CSS gibt es zwei grundlegende "Display"-Elemente:

- Block-Elemente
- Inline-Elemente

Im Normalfall können wir nur Block-Elemente dimensionieren (eine Grösse geben). Was ist aber genau der Unterschied zwischen den beiden Elementtypen?

### Block-Elemente

Block-Elemente starten im Normalfall immer auf einer neuen Zeile und haben per Default um sich selbst herum einen Abstand zu anderen Elementen.

Block-Elemente beanspruchen per Default die volle Breite an Platz (von links bis rechts).

Typische Block-Elemente sind

- `<p>`
- `<div>`
- `<address>`
- `<article>`
- `<aside>`
- `<blockquote>`
- `<canvas>`
- `<div>`
- `<footer>`
- `<form>`
- `<h1>-<h6>`
- `<header>`
- `<hr>`
- `<main>`
- `<nav>`
- `<noscript>`
- `<ol>`, `<ul>`, `<dd>`, `<dl>`, `<dt>`, `<li>`
- `<pre>`
- `<section>`
- `<table>`

Um das zu verstehen, probiere diesen Code aus:

```html
<p>Nur ein Paragraf</p>
<p>Ein Paragraf mit einem <span>Span</span>.</p>
<style>
  p {
    background-color: red;
  }
  span {
    background-color: yellow;
  }
</style>
```

Dieser Code zeigt gut, dass das Block-Element (hier `<p>`) die ganze Breite (abzüglich eines kleinen Randes) eingenommen hat, während das `<span>`-Element sich auf das Wort beschränkt.

### Inline-Elemente

Im obenstehenden Beispiel hast du bereits ein Inline-Element gesehen, nämlich das `<span>`-Element.

Inline-Elemente kommen zumeist in einem Text vor. Inline-Elemente benötigen nur so viel Platz wie nötig. Im Gegensatz zu Block-Elementen beginnen Inline-Elemente also nicht auf einer neuen Zeile.

Typische Inline-Elemente sind:

- `<a>`
- `<b>`
- `<br>`
- `<button>`
- `<code>`
- `<dfn>`
- `<em>`
- `<i>`
- `<img>`
- `<input>`
- `<label>`
- `<script>`
- `<select>`
- `<small>`
- `<span>`
- `<strong>`
- `<textarea>`
- `<time>`

Wichtig zu wissen ist ausserdem, dass sich keine Block-Elemente in einem Inline-Element befinden dürfen.

## Block-Elemente dimensionieren

Bei Block-Elementen kannst du die Grösse verändern:

```html
<div class="box">
  <p>Inside the first Box</p>
</div>

<div class="box">
  <p>Inside the second Box</p>
</div>

<style>
  div.box {
    /*display: block;*/
    width: 10em;
    height: 10em;
    background-color: cornflowerblue;
  }
</style>
```

Wenn du diesen Code ausprobierst, siehst du zwei hellblaue Quadrate untereinander. Mit dem `width`-Property definiert man die Breite und mit dem `height`-Property die Höhe. Hiermit haben wir dem `<div class="box">` eine Höhe und Breite von 10em gegeben.

### Einheiten (Units)

Im vorherigen Beispiel haben wir dem Quadrat eine Seitenlänge von `10em` gegeben. Aber was sind überhaupt `em`?

`1em` entspricht der Schriftgrösse des aktuellen Elements. Gibt man einem Text zum Beispiel `font-size: 2em`, so definiert man, dass die Schriftgrösse doppelt so gross sein soll wie beim übergeordneten Element. Somit ist die Grösseneinheit `em` proportional zur aktuellen Schriftgrösse.

Statt `em` kann man auch `rem` verwenden: `rem` ist prinzipiell dasselbe wie `em`, nur dass es relativ zur Schriftgrösse des `root`-Elements ist (statt dem aktuellen Element). Somit ist `rem` auf der ganzen Seite immer gleich gross, `em` nicht.

Für Seiten im Browser verwendet man am besten relative Einheiten wie `em` oder `rem`. Dennoch kommt man oft nicht an der absoluten Einheit `px` vorbei:

Oft möchte man nämlich beispielsweise den dünnsten möglichen Rand um ein Element haben, welcher einen Pixel breit ist. In diesem Fall würde man die Breite des Randes (Borders) gleich `1px` setzen. Die Zuweisung sähe aus wie folgt:

```css
div.box {
  ...
  border: 1px solid black;
}
```

Dieses Beispiel fügt einen schwarzen Rand von einem Pixel Breite hinzu. Das `solid` bedeutet, dass es eine normale, durchgehende Linie sein soll (die Linie also beispielsweise nicht gestrichelt ist).

#### Einheiten in der Übersicht

Grundsätzlich empfehlen wir dir diese Übersicht: https://www.w3schools.com/cssref/css_units.asp

Von den **absoluten Einheiten** musst du nur folgende kennen:

- `px`

Die absoluten Einheiten sollten prinzipiell immer gleich gross sein. Sie sind aber nicht speziell für die Benutzung im Browser geeignet, da sich die Bildschirmgrössen der Benutzer untereinander teilweise stark unterscheiden.

Von den **relativen Einheiten** solltest du mehrere kennen:

| Einheit     | Beschreibung                                                                                                                                                                                                                                   |
| ----------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `em`, `rem` | Längeneinheit relativ zur Schriftgrösse des aktuellen bzw. des root-Elements                                                                                                                                                                   |
| `vw`        | `1vw` = 1% der Weite des ViewPorts (angezeigter Teil der Browser-Seite)                                                                                                                                                                        |
| `vh`        | `1vh` = 1% der Höhe des ViewPorts (angezeigter Teil der Browser-Seite)                                                                                                                                                                         |
| `%`         | Relativ zum Parent-Element. `width: 50%` bedeutet beispielsweise, dass das Element halb so breit wie das übergeordnete Element sein soll. `%` funktioniert gut im Zusammenhang mit Breiten, aber nicht immer so gut im Zusammenhang mit Höhen. |

Wenn du noch mehr über Einheiten erfahren möchtest, dann schaue dir diese Seite an: https://web.dev/learn/css/sizing/

## Block-Elemente weiter dimensionieren (Box Model)

Wir haben bereits CSS-Properties wie `width`, `height` und `border` verwendet. Nun wird es Zeit zu verstehen, wie diese Werte die Dimensionen von Block-Elementen beeinflussen. Probiere dieses Beispiel aus:

```html
<div class="box">
  <p>Inside the first Box</p>
</div>

<div class="box">
  <p>Inside the second Box</p>
  <p class="half-width">Halbe Breite</p>
</div>

<style>
  div.box {
    /*display: block;*/
    width: 10em;
    height: 10em;
    background-color: cornflowerblue;
  }
  .half-width {
    width: 50%;
    background-color: white;
    border: 2em solid gray;
  }
</style>
```

Du wirst sehen, dass das weisse Feld mit "Halbe Breite" die halbe Breite der übergeordneten Box beansprucht. Zusammen mit dem Rand macht das aber mehr als die Hälfte aus! Somit schauen wir uns das Box-Modell in CSS an:

![boxModel](../boxen_css.PNG)

Die "Content Box" ist sozusagen der Inhalt des Block-Elements. Die "Border Box" ist der Rahmen des Elements. Als wir die `width` gesetzt hatten, haben wir die Breite der _Content Box_ gesetzt. Oft wollen wir aber, dass die Box inklusive Rand 50% der Breite einnimmt. Hierfür gibt es mehrere Möglichkeiten:

Theoretisch könnten wir die Breite berechnen, indem wir einfach den Rand von der Breite subtrahieren:

```css
.half-width {
    width: calc(50% - 2 * 2em);
    ...
}
```

In den meisten Fällen ist das aber unnötig kompliziert. Es gibt aber eine Abkürzung, die einem diesen Umweg erspart:

```css
.half-width {
    box-sizing: border-box;
    width: 50%;
    ...
}
```

Auf diese Weise nimmt die Box nur noch 50% der gesamten Breite ein (inklusive Border). Der Default für `box-sizing` ist `content-box`.

Zur Vertiefung des Box Models kannst du gerne diese Seite studieren: https://web.dev/learn/css/box-model/.

## Abstände

### Abstände zu anderen Elementen (Margin)

Oft gibt es die Anforderung, dass Elemente untereinander einen Abstand haben sollen. Genau dafür verwendet man das `margin`-Property. Spiel mit diesem Wert ein bisschen herum, um zu sehen, wie sich die Elemente je nach `margin` verhalten:

```css
div.box {
    ...
    margin: 2em;
}
```

Du kannst das `margin`-Property mit insgesamt vier Werten versehen, wobei jeder Wert für eine Richtung steht. (Top, Right, Bottom, Left)

```css
margin: 1em 2em 3em 4px;
```

Die folgenden vier Zeilen sind dementsprechend äquivalent zum obenstehenden Beispiel:

```css
margin-top: 1em;
margin-right: 2em;
margin-bottom: 3em;
margin-left: 4px;
```

Beachte bei der kurzen Schreibweise, dass die Angabe der Werte oben beginnt und im Uhrzeigersinn weitergeht.

Eine gute Eselsbrücke, um sich das zu merken, ist das Wort *TR*ou*BL*e. Anhand der Reihenfolge der Buchstaben lässt sich die Reihenfolge gut merken. (Top, Right, Bottom, Left)

### Abstand der Border zum Content (Padding)

Oft sieht es unschön aus, wenn der Text direkt am Rand (am Border) aneckt. Das kann behoben werden, indem innerhalb des Elements ein Rand (Padding) eingefügt wird:

```css
.half-width {
  padding: 0.5em;
  ...
  box-sizing: border-box;
  width: 73%;
  background-color: white;
  border: 7px solid gray;
}
```

Beachte, dass bei einer Angabe wie `width: 40%` mit `box-sizing: content-box` die Weite sich nur auf den Content bezieht. Das Padding kommt in diesem Beispiel zu den 40% noch hinzu!
