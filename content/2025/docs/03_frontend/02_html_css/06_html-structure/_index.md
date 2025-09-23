---
title: "HTML-Struktur"
linkTitle: "HTML-Struktur"
weight: 6
description: >
  Modul #F3 - HTML und CSS - HTML-Seite strukturieren
---

#### Ziele

- Ich weiss, wie ich eine HTML-Seite strukturiere.
- Ich weiss, was das DOM ist.
- Ich weiss, wie ich das DOM einer Webseite inspizieren kann.
- Ich weiss, was Meta-Tags sind und wozu sie verwendet werden.
- Ich weiss, wie ich meine Seite auf Syntax-Fehler überprüfen kann.

## Struktur einer HTML-Seite

Bisher haben wir ohne erkennbare Struktur HTML-Elemente hinzugefügt.

Normalerweise folgt eine HTML-Datei der folgenden Struktur (ohne die `h1`- und `p`-Elemente):

```html
<!doctype html>
<html lang="en">
  <head>
    <!-- Place for external resources and meta tags. -->
    <title>My Website</title>
  </head>

  <body>
    <!-- Place for your website's content. -->
    <h1>Hello</h1>
    <p>This is my amazing website!</p>
  </body>
</html>
```

Auf der ersten Zeile definieren wir, dass es sich um ein HTML-Dokument handelt. Diese Zeile ist erforderlich und seit HTML5 praktisch immer gleich.

Alle weiteren Elemente befinden sich dann im (einzigen) `<html>`-Element. Im `<html>`-Tag kann noch die Sprache der Seite mit dem `lang`-Attribut angegeben werden. Auf der nächsten Stufe sind nur `<head>` und `<body>` erlaubt. Im `<head>` befinden sich Meta-Informationen über die Website wie z.B. der Tab-Titel der Website. Der eigentliche Seiteninhalt befindet sich vollständig im `<body>`.

### DOM (Document Object Model)

In der Webentwicklung wird sehr oft vom "DOM" gesprochen. Visualisiert sähe das DOM für das obige Beispiel ungefähr so aus:

![dom](images/dom.png "(DOM einer einfachen HTML-Seite.)")

Was ist nun aber dieses "Document Object Model"? Simpel ausgedrückt beschreibt das DOM die Struktur der Website zur Laufzeit (also im Browser). Das DOM enthält also die Information, wie die Seite inklusive ihrer Elemente aufgebaut und verschachtelt ist. Im Gegensatz zum HTML-Dokument kann sich das DOM während des Besuches der Seite verändern (z.B. durch JavaScript). Das DOM enthält also die Information, was aktuell auf der Seite ist.

Zusätzliche Informationen findest du hier:

- https://www.w3schools.com/js/js_htmldom.asp
- https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction

Wie das DOM auf einer beliebigen Webseite aussieht, kannst du ganz einfach herausfinden:

- Öffne die Entwickler-Tools von deinem Browser (normalerweise mit der [F12]-taste)
- Wechsle zum Reiter "Elemente"
- Nun siehst du das aktuelle DOM:

![domBrowser](images/browser-dom.jpg "(DOM im Browser einer einfachen HTML-Seite.)")

Mache dich mit diesen Entwickler-Tools (auch mit dem Inspection-Button ganz oben links im Bild) unbedingt vertraut!

Diese Tools sind sehr praktische Hilfsmittel bei der Entwicklung von HTML-Seiten, da du damit den aktuellen Zustand deiner Seite inspizieren kannst. Wenn du eine Webseite entwickelst, wirst du nicht daran vorbeikommen, diese Tools zu verwenden.

### Der Head

Wichtig für dich zum Wissen ist auch, dass deine HTML-Seite bestimmte Meta-Tags haben sollte, damit sie als "valid" gilt. Nachfolgend ein paar wichtigere `<meta>`-Tags:

```html
<head>
     
  <!-- Place for external resources and meta tags. -->
     
  <title>My Website</title>
     
  <meta charset="UTF-8" />
     
  <meta name="description" content="A simple useless website" />
     
  <meta name="keywords" content="HTML, Meta tags" />
     
  <meta name="author" content="Karl Klammer" />
     
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
```

- Der `title` ist der Text, der im Tab angezeigt wird.
- Das `charset` beschreibt, welcher Zeichensatz im Dokument verwendet wird, also wie die einzelnen Zeichen interpretiert werden. Damit du alle gängigen Zeichen brauchen kannst, wird "UTF-8" empfohlen. Das Fehlen dieser Zeile führt oft dazu, dass bestimmte Zeichen falsch dargestellt werden (Beispielsweise "ä", "ö", "ü" etc.).
- Die `description` wird zum Beispiel von Suchmaschinen verwendet. Wie z.B. Google solche Tags auswertet, erfährst du hier: https://developers.google.com/search/docs/advanced/crawling/special-tags?hl=de. `keywords` geht in eine ähnliche Richtung.
- Die Zeile für den `viewport` kann praktisch immer eins zu eins übernommen werden. Dieser Wert führt dazu, dass die Seite auf mobilen Endgeräten nicht wie eine Desktop-Seite aussieht. Mit diesem Element wird der Text auf Smartphones meistens grösser. Dieses Meta-Tag wird empfohlen, wenn die Seite auf Smartphones gut aussehen soll.

### Ist meine Seite valid?

Um die Seite auf Syntax-Fehler und andere gängige Fehler zu überprüfen, kann es Sinn machen, die Seite von einem Validator überprüfen zu lassen. Dazu geeignet ist zum Beispiel der folgende: https://validator.w3.org/#validate_by_input

Hier kannst du deinen HTML-Code reinkopieren, worauf der Validator dir dann die Fehler anzeigt, die er in deinem Code entdeckt hat.

![asset](/images/hint.png) Jetzt bist du dran. Löse die [Aufgabe 2](../../../../labs/03_frontend/01_html-css/01_html#aufgabe-2---inspiziere-diese-seite) in den Labs.
