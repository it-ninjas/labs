---
title: "Positionierung"
type: docs
linkTitle: "Positionierung"
weight: 17
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - HTML-Elemente auf der Seite positionieren.
---

#### Ziele

- Ich weiss, wie man mit `position: relative` HTML-Elemente positionieren kann, ohne den Textfluss zu beeinflussen.
- Ich weiss, wie man mit `position: absolute` Elemente an einer festen Position innerhalb eines Containers platziert.
- Ich kann `position: fixed` anwenden, um Elemente unabhängig vom Scrollen an einer festen Position zu halten.

## relative Positionierung: Element ein bisschen verschieben

Angenommen, du hast ein Bild in einem Text:

```html
Are you a
<img src="https://it-ninjas.ch/img/svg/Ninja%20Elements_kopf.svg" alt="" />?

<style>
  body {
    font-size: 5em;
  }
  img {
    height: 1em;
  }
</style>
```

In diesem Fall wird das Bild mit aller Wahrscheinlichkeit nicht perfekt im Text ausgerichtet sein. In diesem Beispiel setzen wir es uns zum Ziel, dass wir das Bild ein Stück weit nach unten verschieben. Das kannst du wie folgt bewerkstelligen:

```css
img {
    position: relative;
    top: 0.2em;
    ...
}
```

Mit `position: relative` bewirken wir, dass CSS-Properties wie `top`, `bottom`, `left` und `right` beachtet werden. Mithilfe der relativen Positionierung können wir dann das Element verschieben, ohne dass es andere Elemente bzw. den Textfluss verändert. Wir haben hier `top` verwendet, um **oben** einen Abstand einzufügen. Würdest du `left` verwenden, so würde sich das Element entsprechend nach rechts verschieben. Wichtig zu beachten ist hierbei, dass unter Verwendung von `top`, `bottom`, `left` und `right` der Abstand relativ zum Objekt selbst eingefügt wird.  

![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](../../../../labs/web/html_css/02_css).

## Absolute Positionierung

Möchtest du ein Element an einer bestimmten Position platzieren, dann kann dir `position: absolute` weiterhelfen:

```html
Are you a
<img src="https://it-ninjas.ch/img/svg/Ninja%20Elements_kopf.svg" alt="" />?

<style>
  img {
    position: absolute;
    top: 20em;
    right: 10em;

    height: 150px;
  }
</style>
```

Bei der Verwendung von `position: absolute` wird das Element relativ vom nächsten **ebenfalls positionierten** Parent-Element positioniert. Gibt es kein solches, wird das Element relativ zum `html`-Element positioniert. 

Mache deinen Browser mal ein wenig kleiner und beobachte, wie sich die Positionierung verhält, wenn du scrollst.

Möchtest du, dass die Positionierung immer - unabhängig vom Scrollen - gleich ist? Dann versuche mal, das Bild mit `position: fixed` zu platzieren.

![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](../../../../labs/web/html_css/02_css).
