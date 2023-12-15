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

## Block- und Inline-Elemente
Bevor wir Elemente dimensionieren, müssen wir wissen, welche Elemente wir überhaupt dimensionieren können.

In CSS gibt es zwei grundlegende "Display"-Elemente:
* Block-Elemente
* Inline-Elemente

Im Normalfall können wir nur Block-Elemente dimensionieren (eine Grösse geben). Was ist aber nun der Unterschied zwischen den beiden?

### Block-Elemente
Block-Elemente starten im Normalfall immer auf einer neuen Zeile und haben per Default um sich selbst herum einen Abstand zu anderen Elementen.

Block-Elemente beanspruchen per Default die volle Breite an Platz (von links bis rechts).

Typische Block-Elemente sind
* `<p>`
* `<div>`
* `<address>`
* `<article>`
* `<aside>`
* `<blockquote>`
* `<canvas>`
* `<div>`
* `<footer>`
* `<form>`
* `<h1>-<h6>`
* `<header>`
* `<hr>`
* `<main>`
* `<nav>`
* `<noscript>`
* `<ol>`, `<ul>`, `<dd>`, `<dl>`, `<dt>`, `<li>`
* `<pre>`
* `<section>`
* `<table>`

Um das zu verstehen, probiere bitte diesen Code aus:

```html
<p>Nur ein Paragraph</p>
<p>Ein Paragraph mit einem <span>Span</span>.</p>
<style>
    p {
        background-color: red;
    }
    span {
        background-color: yellow;
    }
</style>
```

Dieser Code zeigt gut, dass das Block-Element (hier `<p>`) die ganze Breite (abzüglich eines kleinen Randes) eingenommen hat, während das `<span>` sich auf das Wort beschränkt.

### Inline-Elemente
Im obigen Beispiel hast du bereits ein Inline-Element kennengelernt: `<span>`.

Inline-Elemente kommen meistens in einem Text vor. Inline-Elemente benötigen nur so viel Platz wie nötig. Als grossen Unterschied zu Block-Elementen, beginnen Inline-Elemente nicht auf einer neuen Zeile.

Typische Inline-Elemente sind:
* `<a>`
* `<b>`
* `<br>`
* `<button>`
* `<code>`
* `<dfn>`
* `<em>`
* `<i>`
* `<img>`
* `<input>`
* `<label>`
* `<script>`
* `<select>`
* `<small>`
* `<span>`
* `<strong>`
* `<textarea>`
* `<time>`

Und wichtig zu wissen ist, dass sich keine Block-Elemente in einem Inline-Element befinden dürfen.

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

Wenn du diesen Code ausprobierst, siehst du zwei hellblaue Quadrate untereinander. Mit dem `width`-Property definiert man die Breite und mit dem `height` die Höhe. Hiermit haben wir dem `<div class="box">` eine Höhe und Breite von 10em gegeben.

### Einheiten (Units)
Im vorherigen Beispiel haben wir dem Quadrat eine Seitenlänge von `10em` gegeben. Was sind aber `em`?

`1em` entspricht der Schriftgrösse des aktuellen Elements. Gibt man einem Text zum Beispiel `font-size: 2em`, so definiert man, dass die Schriftgrösse doppelt so gross sein soll wie beim übergeordneten Element. Somit ist die Grösseneinheit `em` proportional zur aktuellen Schriftgrösse.

Statt `em` kann man auch `rem` verwenden: `rem` ist im Prinzip das Gleiche wie `em`, nur dass es relativ zur Schriftgrösse des `root`-Elements ist (statt dem aktuellen Element). Somit ist `rem` auf der ganzen Seite immer gleich gross, `em` nicht.

Für Seiten im Browser verwendet man besser relative Einheiten wie `em` oder `rem`. Aber dennoch kommt man oft nicht an der absoluten Einheit `px` vorbei:

Oft möchte man z.B. den dünnsten möglichen Rand um ein Element von einem Pixel haben. In diesem Fall würde man die Breite des Randes (Borders) gleich `1px` setzen. Die Regel könnte so aussehen:

```css
div.box {
  ...
  border: 1px solid black;
}
```

Dieses Beispiel fügt einen schwarzen Rand von `1px` Breite hinzu. Das `solid` bedeutet, dass es eine normale Linie sein soll (also nicht gestrichtelt o.ä.).

#### Einheiten in der Übersicht
Grundsätzlich empfehle ich dir diese Übersicht: https://www.w3schools.com/cssref/css_units.asp

Unter den __absoluten Einheiten__ musst du nur folgende kennen:
* `px`

Die absoluten Einheiten sollten immer gleich gross sein. Sie sind aber nicht speziell für im Browser geeignet, weil sich die Bildschirmgrössen der Enduser stark unterscheiden.

Von den __relativen Einheiten__ solltest du mehrere kennen:
| Einheit     | Beschreibung
| ----------  | --------------
| `em`, `rem` | Längeneinheit relativ zur Schriftgrösse des aktuellen bzw. des root-Elements
| `vw`        | `1vw` = 1% von der Weite des ViewPorts (angezeigter Teil der Browser-Seite)
| `vh`        | `1vh` = 1% von der Höhe des ViewPorts (angezeigter Teil der Browser-Seite)
| `%`         | Relativ zum Parent. `width: 50%` bedeutet z.B., dass das Element halb so breit wie das übergeordnete Element sein soll. `%` funktioniert gut im Zusammenhang mit Breiten, aber nicht immer so gut im Zusammenhang mit Höhen.


Wenn du noch mehr über Einheiten erfahren möchtest, dann schaue dir bitte diese Seite an: https://web.dev/learn/css/sizing/

## Block-Elemente weiter dimensionieren (Box Model)
Wir haben bereits CSS-Properties wie `width`, `height`, `border` verwendet. Nun wird es Zeit zu verstehen, wie diese Werte die Dimensionen von Block-Elementen beeinflussen. Probiere dieses Beispiel aus:

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

![boxModel](https://web-dev.imgix.net/image/VbAJIREinuYvovrBzzvEyZOpw5w1/ECuEOJEGnudhXW5JEFih.svg "Das Box-Modell in CSS")

Die "Content Box" ist so zu sagen der Inhalt des Block-Elements. Die "Border Box" ist der Rahmen des Elements. Als wir die `width` gesetzt hatten, haben wir die Breite des _Content Box_ gesetzt. Oft wollen wir aber, dass die Box inkl. Rand 50% der Breite einnimmt. Hierfür gibt es mehrere Möglichkeiten: 

Theoretisch könnten wir die Weite mit einer Berechnung herbeibasteln, indem wir einfach den Rand von der Breite wegsubtrahieren:
```css
.half-width {
    width: calc(50% - 2 * 2em);
    ...
}
```

Dies sieht in den meisten Fällen unnötig kompliziert aus. Und dafür gibt es eine Abkürzung:

```css
.half-width {
    box-sizing: border-box;
    width: 50%;
    ...
}
```

Auf diese Weise nimmt die Box nur noch 50% der Breite insgesamt ein (inkl. Border). Der Default für `box-sizing` ist `content-box`.

Zur Vertiefung des Box Models kannst du gerne diese Seite studieren: https://web.dev/learn/css/box-model/.

## Abstände
### Abstände zu anderen Elementen (Margin)
Ziemlich oft möchtest du, dass Elemente untereinander einen Abstand haben. Genau dafür gibt es `margin`. Spiele mit diesem Wert ein bisschen herum:

```css
div.box {
    ...
    margin: 2em;
}
```
Du kannst die Abstände auch in jede Richtung einstellen:
```css
margin: 1em 2em 3em 4px;
```
was äquivalent zu dem ist:
```css
margin-top: 1em;
margin-right: 2em;
margin-bottom: 3em;
margin-left: 4px;
```

Beachte bei der kurzen Schreibweise, dass es oben beginnt und im Uhrzeigersinn weitergeht, bzw. merke dir "TRouBLe" (Top Right Bottom Left).

### Abstand vom Border zum Content (Padding)
Oft sieht es hässlich aus, wenn der Text direkt am Rand (am Border) ankommt. Das kann behoben werden, indem ein innerer Rand (Padding) eingefügt wird:

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


