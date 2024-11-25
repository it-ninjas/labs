---
title: "Übergänge und Animationen"
type: docs
linkTitle: "Übergänge und Animationen"
weight: 18
date: 2023-03-07
description: >
  Modul #F3 - HTML und CSS - Erstelle professionelle Animationen - nur mit CSS und komplett ohne JavaScript.
---

## Ziele

- Du weisst, wie du bei Elementen Übergänge für CSS-Property-Änderungen hinzufügen kannst.
- Du weisst, wie du mit Keyframes sich wiederholende Animationen erstellen kannst.

## Übergänge

Übergänge werden häufig eingesetzt, um zu visualisieren, dass eine Schaltfläche den Fokus erhalten oder verloren hat oder um Grössenänderungen (beispielsweise von Navigationsleisten) weniger abrupt und damit für das Auge angenehmer zu gestalten.

In CSS kannst du relativ leicht Übergänge erstellen. Zum Beispiel kannst du die Form eines `<div>`-Elements wie folgt verändern:

```html
<div class="box"></div>

<style>
  .box {
    /* Initialzustand: */
    width: 10em;
    height: 10em;
    background-color: lightgrey;
    border: 5px solid black;
    border-radius: 50%;

    /* Übergang wird mittels `transition` angegeben: */
    transition:
      width 1s,
      background-color 2s,
      border-radius 3s;
  }

  .box:hover {
    /* Zustand, wenn sich die Maus über dem Element befindet: */
    width: 20em;
    background-color: #ffbf00;
    border-radius: 0;
  }
</style>
```

Probiere das einmal selbst aus!

Aber wie funktioniert das genau? Beschränken wir uns für dieses Beispiel einmal auf die Änderung der Breite. Da in der regulären CSS-Regel (also `.box`) die Regel `transition: width 1s` steht, reagiert dieses HTML-Element auf eine Änderung in der Breite mit einem Übergang (transition). In dieser CSS-Regel war `width` der Name des CSS-Properties, auf welche der Übergang angewandt wurde. Die Angabe `1s` spezifiziert, dass der Übergang 1 Sekunde lang dauern soll.

Oft lässt sich die Angabe der Transition in diesem Format beobachten:

```css
transition: width 1s ease;
```

Das Keyword `ease` beschreibt, wie die Animation beschleunigt wird: `ease`-Animationen beginnen langsam, sind dann schneller und am Schluss wird sie "gebremst". `ease` ist der Default-Wert und muss daher nicht explizit angegeben werden. Es gibt viele weitere Arten, die Geschwindigkeit der Animation zu gestalten:

- ease
- linear
- ease-in
- ease-out
- ease-in-out
- cubic-bezier(n,n,n,n)

Weitere Informationen zu Transitions erhältst du hier: https://www.w3schools.com/css/css3_transitions.asp

## Animationen

In CSS sind auch Animationen einfach realisierbar - auch ohne die Verwendung von JavaScript.

Im folgenden Beispiel lassen wir eine Hand winken:

```html
<span class="hand">🖐</div>

<style>
    .hand {
        /* transform geht nicht für inline-Elemente: */
        display: inline-block;
        font-size: 72px;

        /* Animation properties: */
        animation-name: wave;
        animation-duration: 2s;
        animation-direction: alternate;
        animation-iteration-count: infinite;
    }

    @keyframes wave {
        0%   {transform: rotate(-90deg);}
        10%  {transform: rotate(-90deg);}
        90%  {transform: rotate(90deg);}
        100% {transform: rotate(90deg);}
      }
</style>
```

Das Zentrale an diesem Code-Beispiel ist der `@keyframes`-Block. Das erste Wort nach diesem Schlüsselbegriff ist der Name, der du der Animation gibst.

Das `0%` steht für den Anfang der Animation, diese Prozentangaben beschreiben also eine Zeitangabe: Zu welchem Zeitpunkt der Animation soll das Element wie gestylt werden?

Damit du die Animation (hier mit dem Namen `wave`) verwenden kannst, musst du diese referenzieren: Das hast du mit `animation-name: wave` gemacht. Anschliessend haben wir die Animation weiter konfiguriert:

- Mit `animation-direction: alternate` haben wir angegeben, dass die Animation wieder rückwärts ablaufen soll, wenn sie durchgelaufen ist. Hierfür war Folgendes ebenfalls notwendig:
- `animation-iteration-count: infinite` bewirkt, dass die Animation unendlich wiederholt wird.

Das ist bereits alles an Basis-Wissen, das es zu Animationen in CSS zu wissen gibt. Interessierst du dich weiter für Animationen, dann kannst du dein Wissen gerne hier vertiefen: https://www.w3schools.com/css/css3_animations.asp

Damit du erkennst, wofür Animationen eingesetzt werden können, schaue dir dieses Beispiel an, wie einfach und ohne die Nutzung von Javascript ein Ladebalken implementiert werden kann: https://www.w3schools.com/howto/howto_css_loader.asp
