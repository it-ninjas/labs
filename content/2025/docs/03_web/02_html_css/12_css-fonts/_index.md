---
title: "Schriftarten"
type: docs
linkTitle: "Schriftarten"
weight: 13
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Typen von Schriftarten.
---

#### Ziele

- Ich kenne die verschiedenen Familien der Schriftarten und kenne ihre Eigenheiten.
- Ich weiss, wie man verschiedene Schriftarten in CSS einbindet und verstehe die Bedeutung und den Nutzen von Fallback-Schriftarten.
- Ich kann CSS-Properties anwenden, um Text und Schriftarten zu stylen.

## Arten von Schriftarten

Jeder Browser unterstützt mindestens die folgenden 5 Familien von Schriftarten:

![fontTypes](images/font-types.svg "Verschiedene Font-Types")

- Die wichtigste Unterscheidung liegt zwischen Serif- und Sans-Serif-Schriftarten. **Serif**-Schriftarten haben Serifs (also dünne Linien auf den Buchstabenlinien). Eine detailliertere Beschreibung findest du hier: https://de.wikipedia.org/wiki/Serife

- **Sans-Serif**-Schriftarten haben diese Serifs nicht.
- Bei **Monospace**-Schriftarten beanspruchen alle Buchstaben genau gleich viel Platz. Ein bekanntes Beispiel hierfür ist _Consolas_. Diese Schriftarten werden oft für Code verwendet.
- **Kursive** Schriftarten imitieren Handschrift.
- **Fantasy**-Schriftarten werden oft für kreative Zwecke eingesetzt.

Welche Schriftart tatsächlich im Browser angezeigt wird, hängt davon ab, welche Fonts auf dem jeweiligen System installiert sind. Unter Windows sind es für serifenlose Schriftarten meist Arial und Verdana, währen Linux Helvetica als Standard nutzt.

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

Als CSS-Property (=Eigenschaft) für das Ändern der Schriftart wird `font-family` verwendet. Dabei können mehrere Schriftarten übergeben werden, was aufgrund unterschiedlicher Browser-Kompatibilitäten empfohlen wird. Die erste Schriftart ist die wichtigste und wird, sofern möglich, auch immer verwendet. Sollte diese nicht geladen werden können, so wird die nächste Schriftart verwendet. Als Fallback für den Fall, dass keine der angegebenen Schriftarten geladen werden kann, kann man `serif`, `sans-serif`, `monospace`, `cursive` oder `fantasy` verwenden.

Weitere Informationen darüber findest du auf dieser Seite: https://www.w3schools.com/css/css_font.asp

## Weitere Font-Eigenschaften

Text kann auf viele weitere Arten gestylt werden:

| CSS-Property       | Code                    | Beschreibung                    | Beispiel                                         |
| ------------------ | ----------------------- | ------------------------------- | ------------------------------------------------ |
| `color`            | `color: blue`           | Schriftfarbe                    | <p style="color: blue">sample Text</p>           |
| `background-color` | `background-color: red` | Hintergrundfarbe (~Anstreichen) | <p style="background-color: red">sample Text</p> |
| `font-size`        | `font-size: 26px`       | Schriftgrösse                   | <p style="font-size: 26px">sample Text</p>       |
| `font-weight`      | `font-weight: bold`     | Schriftgrösse                   | <p style="font-weight: bold">sample Text</p>     |
| `text-align`       | `text-align: center`    | Einen Text zentrieren           | <p style="text-align: center">sample Text</p>    |

## Auftrag

Im Rahmen des Auftrags zu den Semantic-Tags hast du ein HTML-Dokument erstellt.

![task1](/images/task.png)
Versuche alle auf dieser Seite beschriebenen Properties in deinem HTML-Dokument zu verwenden.
