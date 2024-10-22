---
title: "CSS-Grundlagen"
type: docs
linkTitle: "CSS-Grundlagen"
weight: 11
date: 2022-04-14
description: >
  Modul #F3 - HTML und CSS - Grundlagen der CSS-Sprache.
---

## Wie funktioniert CSS?

Um CSS anwenden zu können, müssen wir als Erstes das Grundprinzip von CSS verstehen:

Mit CSS wird das Aussehen (und zum Teil auch das Verhalten) von HTML-Elementen definiert. Diese Styledefinition wird nur auf passende HTML-elemente angewendet. Wenn kein passendes HTML-Element vorhanden ist, bleibt die Definition wirkungslos. Hierfür gibt es verschiedene Möglichkeiten, welche wir im Verlaufe des Kurses kennenlernen werden.

CSS hält sich dabei an die folgende Syntax:

```css
p {
  color: blue;
  background-color: red;
}
```

- Die Zeichenfolge vor den geschweiften Klammern ist der sogenannte Selektor (Englisch: Selector). Er definiert, auf welche Elemente das Styling angewendet werden soll. In diesem Fall würde das Styling auf alle `<p>`-Elemente angewandt werden.
- Die Zeilen innerhalb der geschweiften Klammern definieren, welche Art von Styling angewandt werden soll. Beim gezeigten Beispiel wird die Textfarbe auf Blau und die Hintergrundfarbe rot eingestellt.

## Wie kann ich CSS anwenden?

Als Nächstes schauen wir an, wie man CSS in eine Webseite (bzw. in ein HTML File) einbinden kann.

### Direktes einbinden in HTML-Elemente

Die wohl schnellste Möglichkeit CSS auf ein HTML-Element anzuwenden, ist, das "style"-Attribut des HTML-Elements anzupassen. Dies würde wie folgt ausschauen:

```html
<p style="color: blue; background-color: red">
  Hier steht blauer Text auf rotem Hintergrund
</p>
```

Dabei ist anzumerken, dass sich die Syntax gegenüber der herkömmlichen Syntax (siehe erstes Beispiel) etwas unterscheidet. Einerseits müssen wir den Selektor nicht angeben und andererseits gibt es keine geschweiften Klammern mehr.

### Einbinden über einen Style-Tag

Man kann CSS aber auch über einen sogenannten "Style" Tag direkt in die HTML-Datei einbinden. Dies sähe dann aus wie folgt:

```html
<head>
  ...
  <style>
    p {
      color: blue;
      background-color: red;
    }
  </style>
  ...
</head>
```

Hierbei können wir innerhalb des Style-Tags herkömmliches CSS anwenden, wie wir es bereits aus dem ersten Beispiel kennen. Der Style-Tag kann irgendwo (auch verschachtelt) irgendwo im `<head>` oder `<body>` stehen, wo genau macht funktionstechnisch aber keinen Unterschied. Am meisten Sinn macht es aber, den Style-Tag im `<head>` nach den `<meta>`-Tags einzubinden, da er dort am besten sichtbar ist.

### Einbinden über ein externes CSS-File

Die wohl am weitesten verbreitete und "schönste" Methode CSS in eine Webseite einzubinden ist es, das CSS in ein CSS-File auszulagern und dann im HTML auf dieses zu verweisen. Nachfolgend ein Beispiel, wie man das machen kann:

Datei: index.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
      /* Verweis auf das CSS-File */ 
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
    <p>Hier steht blauer Text auf rotem Hintergrund</p>
  </body>
</html>
```

Datei: styles.css

```css
p {
  color: blue;
  background-color: red;
}
```

Der wichtigste Teil des HTML-Codes in diesem Beispiel ist dabei folgender Tag im Head:

```html
<link rel="stylesheet" href="styles.css" />
```

Dieser Link-Tag definiert, dass der CSS-Code der Datei mit dem Pfad "styles.css" auf die aktuelle HTML-Datei als "stylesheet" angewandt werden soll.

## Was gibt es für CSS-Styling-Properties?

Es gibt unzählige CSS-Properties. Zu viele, um auf jedes detailliert einzugehen. Auf [dieser Seite](https://www.tutorialrepublic.com/css-reference/css3-properties.php) findet ihr eine ganze Reihe CSS-Properties.

Auf die wichtigsten dieser Properties werden wir nachfolgend konkreter eingehen.
