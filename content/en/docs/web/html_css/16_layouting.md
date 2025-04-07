---
title: "Layouting"
type: docs
linkTitle: "Layouting"
weight: 16
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Layouting von Block-Elementen.
---

#### Ziele

- Ich weiss, was Floating ist und wie es verwendet wird, um Elemente nebeneinander anzuordnen.
- Ich weiss, was Flexbox ist und wie man display: flex anwendet, um flexible Layouts zu erstellen.
- Ich kann Media-Queries nutzen, um Flexbox-Layouts auf unterschiedliche Bildschirmgrößen anpassen zu können.

Du hast dich vielleicht schon gefragt, wie du mehrere Elemente nebeneinander anordnen kannst. Hierfür müssen zuerst ein paar Worte über Layouting verloren werden.

## Floating

Vor dem Zeitalter von Flexboxen und Grids war das Layouting von Webseiten noch um einiges umständlicher. Es gab die Möglichkeit, die Elemente, die man nebeneinander haben wollte, mit `float` zu positionieren. Das kann aussehen wie folgt:

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

In diesem Beispiel wurde das Container-`div` nur zur Demonstration verwendet. Da du diese Technik wahrscheinlich nie benötigen wirst, musst du im Moment auch nicht verstehen, weshalb im Beispiel `overflow: auto` verwendet wurde.

Was genau passiert hier? Wichtig ist, dass die mit `float` platzierten Elemente das Property `display: block` innehaben (was bei einem `<div>` bereits defaultmässig so ist). Mit `float: left` werden die Elemente der Reihe nach von links nach rechts angeordnet. Wenn die Elemente über den Rand hinausgehen würden, wird eine neue Zeile begonnen und das Element auf dieser platziert (wrap). Das ist im Grundsatz bereits die ganze Magie.

![task1](/images/task.png) Ändere den Wert auf `float: right`. Nun platziert das erste Element auf der rechten Seite. Was müsstest du machen, damit die Elemente zwar rechtsbündig sind, diese aber trotzdem jeweils links voneinander platziert werden?

## Flexboxen

Wenn man das `float`-Property viel braucht, wird man schnell merken, dass die Anwendung dieser Technik teils sehr umständlich sein kann.

Die gute Nachricht ist aber, dass man seit der Einführung von Flexboxen kaum mehr auf das manuelle Positionieren mit dem `float`-Property zurückgreifen muss. Das obenstehende Beispiel kann mithilfe von Flexbox auf die folgende Grösse verkleinert werden:

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

Der grosse Unterschied hierbei ist, dass es einen Container braucht, den "flex-container". Du kannst ein beliebiges Element als Flex-Container definieren, indem du `display: flex` auf dieses Element anwendest.

Das `flex-wrap`-Property ist hingegen nicht zwingend nötig, ist aber in diesem Fall dafür verantwortlich, dass ein Zeilenumbruch gemacht wird, wenn die Elemente über den Rand hinausgehen würden, ansonsten war es das bereits. Interessanterweise müssen weder der Flex-Container noch die Flex-Items das `display: block`-Property innehaben. In diesem Beispiel könntest du also die `<div>`-Elemente mit `<span>`-Elementen (Inline-Element) ersetzen, worauf nach wie vor dasselbe Ergebnis entstehen würde (ist aber grundsätzlich nicht empfehlenswert).

Wenn du keinen Zeilenumbruch (`wrap`) möchtest, dann kannst du die `flex-wrap`-Regel entfernen. Wenn du das machst, gilt die `width: 10em`-Regel nicht immer, beispielsweise wenn es zu wenig Platz gäbe. In diesem Fall kannst du `width` mit `min-width` ersetzen oder das `flex-shrink: 0`-Property auf den Items (`.box`) setzen. Das `flex-shrink: 0`-Property bewirkt, dass sich die Items nicht verkleinern, wenn zu wenig Platz vorhanden ist. Beachte in beiden Fällen, dass die Elemente über den Rand hinausgehen würden, wenn zu wenig Platz vorhanden ist!

Dieses Problem kannst du umgehen, indem du im Flex-Container definierst, dass der Teil, der über den Rand hinausgehen würde,

- entweder versteckt / abgeschnitten werden soll (`overflow: hidden`)
- oder eine Scrollbar angezeigt werden soll (`overflow: auto` oder `overflow: scroll`).

### Flex-Boxen mit flexiblen Items

Prinzipiell sind Flex-Boxen nicht kompliziert, auch wenn man damit durchaus komplexe Layouts bewerkstelligen kann.

Schaue dir das Video [CSS Flexbox in 100 Seconds](https://www.youtube.com/watch?v=K74l26pE4YA) an. Dort ist die Technologie knackig und interessant zusammengefasst.

Oft möchte man mehrere Spalten nebeneinander positionieren, die alle den gleichen Platz beanspruchen sollen, wobei zugleich alle Spalten zusammen möglichst dynamisch die ganze Breite des Browsers ausnutzen sollen.

Folgendes Beispiel bewirkt genau das:

```html
<p>
  Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor
  congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus
  malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra
  imperdiet enim. Fusce est.
</p>
<div class="flex-container">
  <p style="flex: 1">
    Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et
    malesuada fames ac turpisegestas. Proin pharetra nonummy pede. Mauris et
    orci. Aenean nec lorem. In porttitor.
  </p>
  <p style="flex: 1">
    Mauris eget neque at sem venenatis eleifend. Ut nonummy. Fusce aliquet pede
    non pede. Suspendisse dapibus lorem pellentesque magna. Integer nulla.
  </p>
  <div style="flex: 1">
    <img
      src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png"
      alt="A picture"
      style="max-width: 100%;"
    />
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

Mit `flex: 1` sagen wir aus, dass jede dieser Spalten genau gleich viel Platz beanspruchen soll. Ändere testweise beim `<div>` mit dem Bild den `flex`-Wert auf 2. Du wirst sehen, dass dieses `<div>` nun anteilsmässig doppelt so viel Platz beansprucht wie die anderen.

Welche Zahlen du genau verwendest, spielt keine grosse Rolle. Du kannst beispielsweise auch `flex: 25%` verwenden, was auch funktioniert. Wichtig zu wissen ist, dass sozusagen alle Flex-Werte zusammenaddiert werden. Wenn du also den `flex`-Wert des Bild-`div`s auf 2 geändert hast, so beansprucht dieses `div`-Element **2 / (1 + 2 + 1) = 2/4 = 50%** der Breite. Wenn du diese Rechnung nicht verstehen solltest, frage unbedingt bei einem Praxisbildner nach!

### Ausrichtung der Flex-Box

Per Default werden die Elemente von links nach rechts angeordnet, was auch durchaus Sinn ergibt. Um Elemente vertikal (also von oben nach unten) anzuordnen, braucht man eigentlich kein spezielles Layout.

Möchtest du aber beispielsweise bei einem grossen Bildschirm die Elemente horizontal nebeneinander haben, bei einem kleinen Bildschirm aber aus Platzgründen untereinander, so kannst du für kleinere Bildschirme die folgende Regel hinzufügen:

```css
@media (max-width: 600px) {
  .flex-container {
    flex-direction: column;
  }
}
```

Das `@media (max-width: 600px)`-Property wird "Media-Query" genannt. Wenn die Breite des Browsers einen bestimmten Wert(in diesem Beispiel 600 Pixel) unterschreitet, dann wird die Regel darin aktiv. Mehr über Media Queries erfährst du hier: https://www.w3schools.com/css/css_rwd_mediaqueries.asp

### Beide Richtungen

Bevor wir zum praktischen Teil übergehen, musst du noch zwei Begriffe kennen:

- MainAxis und
- CrossAxis

Hat dein Flex-Container eine horizontale Ausrichtung (default: `flex-direction: row`), so ist die MainAxis die x-Achse (von links nach rechts) und die CrossAxis die y-Achse (oben nach unten). Bei einer vertikalen Ausrichtung (`flex-direction: column`) ist das genau umgekehrt.

### Flex-Elemente ausrichten

Flexboxen erleichtern das Ausrichten von Inhalten stark.

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

  .flex-container > div {
    background-color: white;
    width: 100px;
    height: 100px;
    margin: 10px;
  }
</style>
```

Da per Default `flex-direction: row` gilt, werden die Elemente von oben links nach rechts dargestellt. Um die Elemente horizontal (bzw. auf der **MainAxis**) zu zentrieren, kannst du folgende Regel auf den Flex-Container anwenden: `justify-content: center`.

Auf horizontaler Ebene (MainAxis) kannst du die Elemente zudem auf viele andere Arten ausrichten. Probiere folgende Werte für `justify-content` (beispielsweise mithilfe der Entwickler-Tools deines Browsers via [F12]!) einmal aus:

- center
- space-around
- space-between
- space-evenly
- flex-start
- flex-end

Möchtest du hingegen die Elemente vertikal (auf der **CrossAxis**) ausrichten, dann hilft dir die `align-items`-Regel weiter. Die Elemente kannst du vertikal mit `align-items: center` zentrieren. Die Elemente kannst du auch oben beziehungsweise unten ausrichten mithlfe von `align-items: flex-start` oder `flex-end`.

Hast du Zeilenumbrüche drin, dann kannst du vertikal (auf der CrossAxis) die Abstände noch genauer spezifizieren. Um das auszuprobieren, setze `flex-wrap: wrap` auf dem Flex-Container und erstelle weitere `<div>`-Elemente darin, damit es genug Elemente hat. Probiere im Flex-Container nun folgende Werte für `align-content` aus:

- center
- space-around
- space-between
- space-evenly
- flex-start
- flex-end

Wie du gesehen hast, sind die Property-Namen für die Ausrichtung komplizierter, als sie es sein müssten. Deshalb hier noch einmal eine Übersicht:

Um horizontal (also in der MainAxis) Elemente auszurichten:

- `justify-content`

Um vertikal (also in der CrossAxis) Elemente auszurichten:

- `align-items`
- `align-content` in Kombination mit `flex-wrap: wrap`

### Website-Layout mit Flex-Boxen

Theoretisch reicht das Wissen über Flexboxen bereits aus, um eine ganze Seite zu layouten. Damit du ein Gefühl dafür bekommst, schaue dir das unterste Beispiel auf dieser Seite an: https://www.w3schools.com/css/css3_flexbox_responsive.asp

### Hilfestellung

Hier bekommst du eine gute visuelle Übersicht über die einzelnen Flex-Properties: https://css-tricks.com/snippets/css/a-guide-to-flexbox/#aa-flexbox-properties
Hier findest du die von w3schools bereitgestellten wichtigsten Eigenschaften von Flex-Boxen beschrieben: https://www.w3schools.com/css/css3_flexbox.asp
Die Definition von Dimensionen - besonders auch der Höhe von Elementen -, sowie Flexlayout und Gridlayout sind komplexe Themen, bei denen gerne Missverständnisse auftreten können. Hier wird die Dokumentation von https://wiki.selfhtml.org/wiki/CSS/Tutorials/Flexbox (deutsch) als Ergänzung empfohlen.

### Display-Flex-Properties üben

Auf [Flexbox Froggy](https://flexboxfroggy.com/#de) kannst du dein Flexbox-Wissen auf lustige Art und Weise trainieren. Nimm dir kurz Zeit dafür.
