---
title: "Schriftarten"
type: docs
linkTitle: "Schriftarten"
weight: 13
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Arten von Schriftarten.
---

## Arten von Schriftarten
Browser unterstützen mindestens diese 5 Arten von Schriftarten:

![fontTypes](../font-types.svg "Verschiedene Font-Types")

* Die wichtigste Unterscheidung ist zwischen Serif- und Sans-Serif-Schriftarten. __Serif__-Schriftarten haben Serife (also dünne Linien auf den Buchstabenlinien). Eine detailliertere Beschreibung findest du hier: https://de.wikipedia.org/wiki/Serife

* __Sans-Serif__-Schriftarten haben diese Serifen nicht.
* Bei __Monospace__-Schriftarten beanspruchen alle Buchstaben gleich viel Platz. Ein bekanntes Beispiel hierfür ist _Consolas_. Diese werden oft für Code verwendet.
* __Kursive__ Schriftarten imitieren Handschrift.
* __Fantasy__-Schriftarten werden oft für kreative Zwecke eingesetzt.

## Schriftarten in CSS
Im CSS kannst du Schriftarten wie folgt einbinden:
```css
.p1 {
  font-family: "Times New Roman", Times, serif;
}
.p2 {
  font-family: Arial, Helvetica, sans-serif;
}
.p3 {
  font-family: "Consolas", monospace;
}
.p4 {
  font-family: "Lucida Handwriting", cursive;
}
.p5 {
  font-family: "Comic Sans MS", fantasy;
}
```

Als CSS-Property (=Eigenschaft) wird `font-family` verwendet. Dabei können mehrere Schriftarten übergeben werden, was auf Grund von Browser-Kompatibilität empfohlen wird. Die erste Schriftart ist die wichtigste. Sollte diese nicht geladen werden können, so wird die nächste Schriftart ausprobiert. Als Fallback kann man dann `serif`, `sans-serif`, `monospace`, `cursive` oder `fantasy` verwenden.


Weitere Informationen darüber kriegst du hier: https://www.w3schools.com/css/css_font.asp


## Weitere Font-Eigenschaften
Text kann auf viele weitere Arten gestylt werden:

| CSS-Property       | Beispiel             | Beschreibung
| ------------       | -------------------- | ------------
| `color`            | `color: blue`        | Schriftfarbe
| `background-color` | `color: blue`        | Hintergrundfarbe (~Anstreichen)
| `font-size`        | `font-size: 16px`    | Schriftgrösse.
| `text-align`       | `text-align: center` | Einen Text zentrieren. 

## Auftrag
Im Rahmen der Semantic-Tags hast du ein HTML-Dokument erstellt. 

![task1](/images/task.png)
Versuche alle Properties von dieser Seite auf deiner zu verwenden.