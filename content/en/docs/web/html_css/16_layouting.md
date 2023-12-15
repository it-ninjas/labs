---
title: "Layouting"
type: docs
linkTitle: "Layouting"
weight: 16
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Block-Elemente layouten.
---

Du hast dich sicherlich schon gefragt, wie du mehrere Elemente nebeneinander haben kannst. Hierfür müssen wir ein paar Worte über Layouting verlieren.

## Floating
Vor dem Zeitalter von FlexBoxen und Grids war das Layouting noch ein bisschen mühsamer. Eine Möglichkeit war es, die Elemente, die man z.B. nebeneinander haben wollte, dass diese ge`float`et werden. Das hätte ungefähr so ausgesehen:

```html
<div class="container">
    <div class="box">Element 1</div>
    <div class="box">Element 2</div>
    <div class="box">Element 3</div>
    <div class="box">Element 4</div>
    <div class="box">Element 5</div>
    <div class="box">Element 6</div>
    <div class="box">Element 7</div>
    <div class="box">Element 8</div>
    <div class="box">Element 9</div>
    <div class="box">Element 10</div>
</div>

<style>
    .container {
        overflow: auto;

        background-color: lightgray;
    }

    .box {
        display: block;
        float: left;

        margin: 1em;
        width: 10em;
        height: 10em;

        background-color: orange;
    }
</style>
```

In diesem Beispiel wurde das container-`div` nur zur Demonstration verwendet. Da du diese Technik wahrscheinlich nie benötigen wirst, musst du im Moment auch nicht verstehen, weshalb `overflow: auto` verwendet wurde.

Was genau passiert hier? Wichtig ist, dass die gefloateten Elemente `display: block` haben (was bei einem `<div>` bereits default ist). Mit `float: left` werden die Elemente der Reihe nach von links nach rechts angeordnet. Wenn es in den Rand hinaus gehen würde, wird eine neue Zeile begonnen (wrap). Das wäre bereits die ganze Magie.

![task1](/images/task.png) Ändere den Wert auf `float: right`. Nun beginnt ist das erste Element rechts. Was müsstest du machen, damit die Elemente zwar rechtsbündig sind, aber das erste Element dennoch links vom zweiten usw. ist?

## Flex-Boxen
Wenn du Floating oft brauchen würdest, dann wirst du schnell merken, dass diese Technik sehr mühsam sein kann.

Die gute Nachricht ist, dass man die vorherige Technik praktisch gar nicht mehr benötigt seit der Einführung von Flex-Boxen. Das obige Beispiel kann verkürzt werden auf:

```html
<div class="flex-container">
    <div class="box">Element 1</div>
    <div class="box">Element 2</div>
    <div class="box">Element 3</div>
    <div class="box">Element 4</div>
    <div class="box">Element 5</div>
    <div class="box">Element 6</div>
    <div class="box">Element 7</div>
    <div class="box">Element 8</div>
    <div class="box">Element 9</div>
    <div class="box">Element 10</div>
</div>

<style>
    .flex-container {
        display: flex;
        flex-wrap: wrap;
        gap: 1em;
        background-color: lightgray;
    }

    .box {
        width: 10em;
        height: 10em;

        background-color: orange;
    }
</style>
```

Der grosse Unterschied hier ist, dass es einen Container braucht, den "Flex-Container". Du kannst ein beliebiges Element als Flex-Container definieren, indem du `display: flex` auf dieses Element anwendest.

Das `flex-wrap` ist nicht zwingend nötig, ist aber dafür verantwortlich, dass es einen Zeilenumbruch gibt, wenn die Elemente in den Rand hinaus gehen würden. Ansonsten war es das bereits. Interessanter Weise muss weder Flex-Container noch Flex-Item `display: block` haben. In diesem Beispiel könntest du also die `<div>`s mit `<span>`s (Inline-Element) ersetzen und es würde immer noch funktionieren (aber nicht empfehlenswert).

Wenn du den Zeilenumbruch (das `wrap`) nicht willst, dann kanst du die `flex-wrap`-Regel entfernen. Wenn du das machst, dann zieht die `width: 10em`-Regel nicht immer, z.B. wenn es zu wenig Platz dafür hätte. In diesem Fall kannst du `width` mit `min-width` ersetzen oder `flex-shrink: 0` auf den Items (`.box`) setzen. `flex-shrink: 0` bedeutet, dass sich die Items nicht verkleinern, wenn zu wenig Platz da ist. Beachte in beiden Fällen, dass die Elemente in den Rand hinaus gehen würden, wenn zu wenig Platz da wäre! 

Dieses Problem könntest du umgehen, indem du auf dem Flex-Container definierst, dass der Teil, der aus dem Rand hinausgehen würde,
* entweder versteckt werden würde (`overflow: hidden`)
* oder eine Scrollbar angezeigt würde (`overflow: auto` oder `overflow: scroll`)


### Flex-Boxen mit flexiblen Items
Im Prinzip sind Flex-Boxen überhaupt nicht kompliziert, auch wenn man sehr komplexe Layouts damit machen kann.

Schaue dir rasch [CSS Flexbox in 100 Seconds](https://www.youtube.com/watch?v=K74l26pE4YA) an. Dort ist die ganze Technik gut und interessant zusammengefasst.

Oft möchte man z.B. mehrere Spalten nebeneinander haben, die alle gleich viel Platz beanspruchen und zugleich sollen alle Spalten zusammen möglichst dynamisch die ganze Breite des Browsers ausnutzen.

Folgendes Beispiel macht genau das:

```html
<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. </p>
<div class="flex-container">
    <p style="flex: 1">Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpisegestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem. In porttitor.</p>
    <p style="flex: 1">Mauris eget neque at sem venenatis eleifend. Ut nonummy. Fusce aliquet pede non pede. Suspendisse dapibus lorem pellentesque magna. Integer nulla. </p>
    <div style="flex: 1">
        <img src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png" alt="A picture" style="max-width: 100%;" />
        <p>Mauris eget neque at sem venenatis eleifend. Ut nonummy.</p>
    </div>
</div>
<style>
    .flex-container {
        display: flex;
        gap: 1em;
    }
</style>
```

Mit `flex: 1` haben wir gesagt, dass jede dieser Spalten genau gleich viel Platz beanspruchen soll. Ändere z.B. beim `<div>` mit dem Bild den `flex`-Wert auf 2. Du wirst sehen, dass dieses `<div>` nun anteilmässig doppelt so viel Platz beansprucht wie die anderen.

Welche Zahlen du genau verwendest, spielt keine grosse Rolle. Du kannst z.B. auch `flex: 25%` eingeben, was auch funktioniert. Wichtig zu wissen ist, dass so zu sagen alle Flex-Werte zusammen-addiert werden.  Wenn du z.B. den `flex`-Wert des Bild-`div`s auf 2 geändert hast, so beansprucht dieses `div` 2 / (1 + 2 + 1) = 2/4 = 50% der Breite. Wenn du diese Rechnung nicht verstehen solltest, frage unbedingt nach!

### Ausrichtung der Flex-Box
Per Default werden die Elemente von links nach rechts angeordnet, was auch sehr viel Sinn macht: Um Elemente vertikal (also von oben nach unten) anzuordnen, braucht man eigentlich kein spezielles Layout.

Möchtest du aber bei einem grossen Screen Elemente horizontal nebeneinander haben, aber bei einem kleinen Screen aus Platzgründen untereinander, so kannst du für kleinere Bildschirme folgende Regel hinzufügen:

```css
@media (max-width: 600px) {
    .flex-container {
        flex-direction: column;
    }
}
```

Das `@media (max-width: 600px)` wird "Media Query" genannt. Wenn die Breite des Browsers einen bestimmten Wert unterschreitet, dann wird die Regel darin aktiv. Mehr über Media Queries erfährst du hier: https://www.w3schools.com/css/css_rwd_mediaqueries.asp

### Beide Richtungen
Bevor wir an das Praktische gehen, musst du noch zwei Begriffe kennen:
* MainAxis und
* CrossAxis

Hat dein Flex-Container eine horizontale Ausrichtung (default: `flex-direction: row`), so ist die MainAxis die x-Achse (von links nach rechts) und die CrossAxis die y-Achse (oben nach unten). Bei einer vertikalen Ausrichtung (`flex-direction: column`) ist das genau umgekehrt.

### Flex-Elemente ausrichten
Flex-Boxen machen das Ausrichten von Inhalt sehr einfach.

Der Einfachheit halber nehmen wir einmal dieses Beispiel:
```html
<div class="flex-container">
    <div>1</div>
    <div>2</div>
    <div>3</div>
</div>

<style>
    .flex-container {
        display: flex;
        height: 20em;
        background-color: cornflowerblue;
    }

    .flex-container>div {
        background-color: white;
        width: 100px;
        height: 100px;
        margin: 10px;
    }
</style>
```

Da per Default `flex-direction: row` gilt, werden die Elemente von oben links nach rechts dargestellt. Um die Elemente horizontal (bzw. auf der __MainAxis__) zu zentrieren, kannst du folgende Regel auf den Flex-Container anwenden: `justify-content: center`.

Auf horizontaler Ebene (MainAxis) kannst du die Elemente noch auf viele andere Arten ausrichten. Probiere folgende Werte für `justify-content` (z.B. mit Hilfe der Entwickler-Tools deines Browsers via [F12]) einmal aus:
* center
* space-around
* space-between
* space-evenly
* flex-start
* flex-end

Möchtest du hingegen die Elemente vertikal (auf der __CrossAxis__) ausrichten, dann hilft dir `align-items` weiter. Die Elemente kannst du vertikal zentrieren mit `align-items: center`. Die Elemente kannst du auch oben bzw. unten ausrichten mit `align-items: flex-start` bzw. `flex-end`.

Hast du Zeilenumbrüche drin, dann kannst du vertikal (auf der CrossAxis) die Abstände noch genauer spezifizieren. Um das auszuprobieren, setze `flex-wrap: wrap` auf dem Flex-Container und erstelle weitere `<div>`s darin, damit es genug Elemente hat. Probiere im Flex-Container nun folgende Werte für `align-content` aus:
* center
* space-around
* space-between
* space-evenly
* flex-start
* flex-end

Wie du gesehen hast, sind die Property-Namen für die Ausrichtung unnötig kompliziert gewählt worden. Deshalb hier noch einmal in der Übersicht:

Um horizontal (bzw. in der MainAxis) Elemente auszurichten:
* `justify-content`

Um vertikal (bzw. in der CrossAxis) Elemente auszurichten:
* `align-items`
* `align-content` in Kombination mit `flex-wrap: wrap`

### Website-Layout mit Flex-Boxen
Theoretisch reicht das Wissen über Flex-Boxen bereits, um eine ganze Seite zu layouten. Damit du ein Gefühl dafür bekommst, schaue dir bitte das unterste Beispiel auf dieser Seite an: https://www.w3schools.com/css/css3_flexbox_responsive.asp

### Hilfestellung
Hier kriegst du eine gute visuelle Übersicht über die einzelnen Flex-Properties: https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-flexbox-properties
Hier sind von w3schools die wichtigsten Eigenschaften von Flex-Boxen beschrieben: https://www.w3schools.com/css/css3_flexbox.asp

### Display-Flex-Properties üben
Auf [Flexbox Froggy](https://flexboxfroggy.com/#de) kannst du dein Flexbox-Wissen auf lustige Art und Weise trainieren. Nimm dir rasch Zeit dafür.

### Aufgaben im Lab
![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](../../../../labs/web/html_css/02_css).