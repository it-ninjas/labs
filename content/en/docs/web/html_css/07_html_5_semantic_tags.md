---
title: "HTML5 Semantic Tags"
linkTitle: "HTML5 Semantic Tags"
weight: 7
description: >
  Modul #F3 - HTML- und CSS-Tags, welche ihre Bedeutung dem Browser und dem Entwickler beschreiben.
---

#### Ziele

- Ich weiss, was nicht-semantische Tags sind und wofür sie verwendet werden.
- Ich weiss, was semantische Tags sind und wofür sie verwendet werden.
- Ich kann in HTML-5 semantische Elemente anwenden.

## Einführung

Semantik, auch Bedeutungslehre genannt, ist die wissenschaftliche Beschäftigung mit Bedeutung und mit den verschiedenen Beziehungen zwischen einem Zeichen und dem Bezeichneten.

In HTML – insbesondere seit HTML 5 – gibt es semantische Tags, bei denen die Elemente eine ganz bestimmte Bedeutung haben (z.B. `<h1>` oder `<label>`) und nicht-semantische Tags (z.B. `<span>` oder `<div>`).

## Nicht-semantische Tags

Oft kommst du in die Situation, in der du mehrere Elemente in einem anderen Element gruppieren möchtest. In den meisten Fällen verwendet man dafür das `div`-Element.

`<div>`-Tags werden oft als Container (Behälter) für HTML-Elemente verwendet. Dieser Container kann dann als Ganzes mit CSS gestylt oder mit JavaScript manipuliert werden. Probiere das nächste Beispiel einmal aus, ohne das Styling zu beachten (ignoriere also das, was im `<style>`-Element steht):

```html
Just a Text
<div class="content">
  <h1>Hello</h1>
  <p>This is my amazing website!</p>
</div>
Other Text

<style>
  .content {
    width: 20em;
    padding: 1em;
    border-radius: 1em;
    background-color: orange;
  }
</style>
```

Das ist ein typisches Beispiel für die Verwendung von `<div>` Elementen.

Möchtest du hingegen ein paar Wörter (aber nicht einen ganzen Block/Paragrafen) speziell stylen, kannst du ein `<span>`-Element verwendet. Möchtest du beispielsweise das Datum in einem Text hervorheben, dann könnte das z.B. so aussehen:

```html
Das nächste Event findet am <span class="date">20. Mai</span> statt.
<style>
  .date {
    font-size: 1.25em;
    font-weight: bold;
    color: blue;
  }
</style>
```

In den beiden obenstehenden Beispielen wurde bei den Tags eine Klasse angegeben. Durch das Ansprechen der Klasse in CSS lässt sich das Element als Ganzes manipulieren.

## Semantische Tags

Mit HTML5 wurden viele neue semantische Tags eingeführt, die in einigen Fällen `<div>`-Elemente und `<span>`-Elemente ersetzen.

Das "Zeit"-`<span>`-Beispiel könnte folgendermassen vereinfacht werden:

```html
Das nächste Event findet am <time>20. Mai</time> statt.
<style>
  time {
    font-size: 1.25em;
    font-weight: bold;
    color: blue;
  }
</style>
```

In HTML5 wurden ebenfalls viele neue Tags eingeführt, die die Struktur von HTML-Dateien genauer beschreiben. Oft hat eine Website eine Struktur, die der folgenden ähnelt:

![semanticTags](https://www.w3schools.com/html/img_sem_elements.gif "Semantic Tags, die es seit HTML5 gibt")

Der `<header>` ist das Element, welches auf einer Website zuoberst angezeigt wird. Dieser enthält oft den Titel der Applikation, das Logo der Firma und jenachdem auch eine `<nav>`igation (also Links wie für 'Home', 'About', 'Kontakt' etc.).

Das Gegenteil des `<header>`-Elements ist der `<footer>`. Der Footer befindet sich am Ende der Website (also ganz unten) und enthält oft den Verweis auf das Copyright sowie weiterführende Links, beispielsweise zu den Datenschutzbestimmungen.

Nicht auf diesem Bild vorhanden, aber trotzdem relevant: Oft befindet sich der Hauptteil einer Website (dazu gehören **nicht** der `<header>` und der `<footer>` ) in einem `<main>`-Element. Wenn die Website einen Leseartikel beschreibt, dann wäre der Text inkl. Überschriften dort drin.

Einzelne Abschnitte (beispielsweise Unterkapitel inklusive Überschriften) werden oft in `<section>`-Elemente gebündelt und sind im nachfolgenden Beispiel-Code eine gute Alternative zu `<div>`-Elementen.

Was genau ein `<article>` ist, würde den Rahmen hier definitiv sprengen, grundsätzlich beschreibt ein `article` aber ein von der aktuellen Website unabhängiges und in sich geschlossenes Element. Ein `article`-Element könnte man also einfach von der aktuellen Seite ausschneiden und in eine andere kopieren.

Schaue dir diese Dokumentation zu HTML Semantic Tags an. Dort ist unter anderem auch das `<article>`-Element genauer beschrieben: https://www.w3schools.com/html/html5_semantic_elements.asp

Mit semantischen Tags könnte man zum Beispiel den folgenden Code:

```html
<!doctype html>
<html>
  <head></head>
  <body>
    <div id="header">
      <h1>The Header</h1>
      <div class="nav-links">
        <p>Nav:</p>
        <p>Home</p>
        <p>News</p>
        <p>About</p>
      </div>
    </div>
    <div id="content">
      <h1>The Article - BANANA TREE</h1>
      <div class="chapter">
        <h2>Section 1</h2>
        <p>
          A banana tree is a must if you wish to bring a sizeable touch of the
          tropics into your home.
        </p>
      </div>
      <div class="chapter">
        <h2>Section 2</h2>
        <p>There are some 400 species worldwide.</p>
        <div class="move-to-the-right">
          <h2>A Aside - Why are bananas bent?</h2>
          Gravity causes the fruit to hang down.
        </div>
      </div>
      <p>
        The text is from:
        <a href="https://www.thejoyofplants.co.uk/banana-tree"
          >The Joy of Plants.co.uk</a
        >
      </p>
    </div>
    <div id="end-of-the-page">
      <h2>The Footer</h2>
      <div>
        <p>Contact</p>
        <p>Impressum</p>
      </div>
    </div>
  </body>
</html>
```

in diese Form vereinfachen:

```html
<!doctype html>
<html>
  <head></head>
  <body>
    <header>
      <h1>The Header</h1>
      <nav>
        <p>Nav:</p>
        <p>Home</p>
        <p>News</p>
        <p>About</p>
      </nav>
    </header>
    <main>
      <article>
        <h1>The Article - BANANA TREE</h1>
        <section>
          <h2>Section 1</h2>
          <p>
            A banana tree is a must if you wish to bring a sizeable touch of the
            tropics into your home.
          </p>
        </section>
        <section>
          <h2>Section 2</h2>
          <p>There are some 400 species worldwide.</p>
          <aside>
            <h2>A Aside - Why are bananas bent?</h2>
            Gravity causes the fruit to hang down.
          </aside>
        </section>
        <p>
          The text is from:
          <a href="https://www.thejoyofplants.co.uk/banana-tree"
            >The Joy of Plants.co.uk</a
          >
        </p>
      </article>
    </main>
    <footer>
      <h2>The Footer</h2>
      <div>
        <p>Contact</p>
        <p>Impressum</p>
      </div>
    </footer>
  </body>
</html>
```

![asset](/images/hint.png) Jetzt bist du dran. Löse die [Aufgabe 3](../../../../labs/web/html_css/01_html#aufgabe-3---dokument-als-html) in den Labs.
