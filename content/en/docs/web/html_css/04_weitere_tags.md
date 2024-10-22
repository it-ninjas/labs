---
title: "Weitere HTML-Tags"
linkTitle: "Weitere HTML-Tags"
weight: 4
description: >
  Modul #F3 - HTML und CSS - Nützliche HTML-Tags
---

#### Ziele

- Ich weiss, wie ich HTML-Dokumente strukturieren kann.
- Ich weiss, wie ich mit HTML Texte formatieren kann.
- Ich weiss, wie ich Links und Bilder in eine Webseite einbetten kann.
- Ich weiss, wie ich geordnete/sortierte Listen erstellen kann.
- Ich weiss, wie ich ungeordnete/unsortierte Listen erstellen kann.
- Ich weiss, was Definitionslisten sind und wie und wozu ich sie einsetzen kann.

## Überschrift (Heading)

Du hast bereits gelernt, dass du `<h1>` für Überschriften verwenden kannst. Oft hast du aber eine Überschrift für die Seite und danach weitere Überschriften, die diesem Titel untergeordnet sind. Wie in einem Word-Dokument kannst du auch in HTML Überschriften hierarchisch verschachteln. Das geht so:

```html
<h1>Heading 1</h1>
<p>Hello</p>
<h2>Heading 2</h2>
<h3>Heading 3</h3>
<h4>Heading 4</h4>
<h5>Heading 5</h5>
<h6>Heading 6</h6>
<p>Hello</p>
```

Dies führt zu folgendem Ergebnis:

![headings](../headings.jpg "(Bild, das zeigt, wie Headings dargestellt werden.)")

Es gibt also Tags für Überschriften erster bis sechste Stufe. Grundsätzlich gilt; je kleiner die Zahl, desto grösser wird die Überschrift dargestellt. Das obige Ergebnis zeigt, wie Überschriften per Default formatiert werden. Du kannst das Styling dieser Überschriften selbstverständlich anpassen (kommt im CSS-Teil).

## Absätze (Paragraf)

Du hast bereits erfahren, dass Zeilenumbrüche in HTML keine Wirkung haben. Möchtest du eine neue Zeile einfügen, könnte dir das `<br/>`-Tag weiterhelfen. Besser ist aber, wenn du den Text, der zusammengehört, auch entsprechend gruppierst: Das kannst du mit dem `<p>`-Tag bewerkstelligen. Der Text, der innerhalb dieses Tags steht, wird im gleichen Abschnitt dargestellt. Wenn ein weiteres p-Element hinzugefügt wird, wird dieses mit einem Leerschlag vom vorherigen getrennt. Das lässt sich im folgenden Beispiel gut sehen:

```html
<h2>Title</h2>
This is one line. This the second one. <br />
And the third one.
<p>And this is inside a paragraph.</p>
<p>This too.</p>
```

<div style="border: 2px solid black; padding: 2em">
    <h2>Title</h2>
    <p>
    This is one line. 
    This the second one. <br/> And the third one.</p>
    <p>And this is inside a paragraph.</p>
    <p>This too.</p>
</div>

Beachte hierbei, dass aufeinanderfolgende `<p>`-Tags mehr Leerraum erzeugen als `<br/>`-Tags.

## Text formatieren

Du wirst in die Situation kommen, in der du einen bestimmten Teil eines Textes fett oder kursiv formatieren musst.

Das kannst du mit HTML sehr einfach bewerkstelligen, dafür gibt es nämlich spezielle Tags:

```html
<p><strong>Heard</strong> about the new restaurant called<em>Karma?</em></p>
<p>There's <b>no menu</b>: You get what you <i>deserve</i>.</p>
```

Um also einen bestimmten Text fett darzustellen, kannst du diesen in ein `<strong>`- oder `<b>`-Element einbinden. Beide Tags **bezwecken** im Prinzip genau das Gleiche, **bedeuten** aber nicht das Gleiche: `<b>`-Elemente sind einfach fett-gedruckt, während `<strong>`-Elemente betont sein sollen. `<strong>` soll dem fett-gedruckten Wort also mehr Ausdruck verleihen. Dieser Unterschied ist vor allem für den Einsatz von Screenreadern wichtig. Mit einem eigenen Styling (kommt im CSS-Teil) könntest du `<strong>`-Elemente z.B. auch grösser oder rot darstellen. Mit einem `<b>`-Element sagt man im Prinzip nur, dass der Text fett-gedruckt sein soll.

Einen Text kursiv darstellen kannst du mit `<i>` beziehungsweise `<em>`. Das Pendant zu `<b>` ist `<i>` (italic), wobei das von `<strong>` `<em>` (emphasis = Betonung) ist.

Das obige Beispiel wird gerendert wie folgt:

<div style="border: 2px solid black; padding: 2em">
    <p>
        <strong>Heard</strong> about
        the new restaurant called
        <em>Karma?</em>
    </p>
    <p>
        There's <b>no menu</b>: You get what you <i>deserve</i>.
    </p>
</div>

![asset](/images/hint.png) Bitte beachte:
Text zu formatieren ist Styling. Styling wiederum wird normalerweise durch CSS bewerkstelligt, nicht von HTML.

## Links und Bilder

Eines der wichtigsten Konzepte in HTML sind Links auf andere Seiten. Links werden mit `a`-Elementen (anchor) realisiert. Ein Link kann wie folgt erstellt werden:

```html
<a href="https://labs.it-ninjas.ch/">Home</a>
```

Probier das einmal aus.

Du wirst einen blauen und unterstrichenen Text "Home" sehen. `<a>` ist der Tag, der generell für Hyperlinks verwendet wird. `href` ist ein Attribut des `a`-Tags,
mit dem die URL des Links spezifiziert wird. In unserem Fall ist `https://labs.it-ninjas.ch/` die URL, die beim Klick aufgerufen wird. `Home` ist der Text, der dem User angezeigt wird.

Ähnlich lässt sich auch ein Bild aus dem Internet einbinden:

```html
<img
  src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png"
  alt="IT Ninjas"
  width="300"
/>
```

Für die Einbindung von Bildern wird das `<img/>`-Tag verwendet. Das `<img/>`-Tag ist ein Tag, welches keinen Inhalt zwischen Opening- und Closing-Tag hat. HTML bietet auch die Möglichkeit einer verkürzten Schreibweise: Statt `<img src=""></img>` kann man auch `<img src="..."/>` schreiben. Das gilt für alle Elemente, die per default keinen Inhalt haben.

Das wichtigste Attribut im `img`-Tag ist `src` (source = Quelle). Als `src` wird ein relativer oder absoluter Pfad zu einem Bild erwartet, welcher sowohl auf ein Bild auf dem eigenen PC als auch im Internet zeigen kann. Vergiss nicht, bei absoluten Pfaden auch das Protokoll (also https://) anzugeben. Nicht zwingend aber erwartet wird das `alt`-Attribut (alternative). Dieser Text wird angezeigt, wenn das Bild nicht geladen werden konnte. Völlig optional sind hingegen Attribute wie `width` oder `height`, welche die Breite und Höhe des Bildes festlegen. Diese Grössen werden aber besser mit CSS spezifiziert, da CSS genauere Spezifikationen zulässt (also nicht nur in 'Pixel' sondern auch anderen Einheiten).

Wenn du möchtest, dass man beim Klick auf ein Bild weitergeleitet wird, kannst du dein Bild in ein `<a>`-Element einbinden:

```html
<a href="https://it-ninjas.ch/">
  <img
    src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png"
    alt="IT Ninjas"
  />
</a>
```

## Listen

In HTML gibt es verschiedene Arten, um Aufzählungen darzustellen. Wir schauen uns die folgenden Listenarten an:

- ungeordnete Liste (unordered lists, Bullet Point-Listen),
- geordnete Listen (ordered lists, nummerierte Listen)
- und Definitionslisten (definition list)

Eine Bullet-Point-Liste kann man mit einer unsortierten Liste (unordered list) kreieren:

```html
<h4>What do you do in case of emergency?</h4>
<ul>
     
  <li>git commit -m "message"</li>
     
  <li>git push</li>
     
  <li>Leave the building.</li>
</ul>
```

Möchtest du hingegen eine Nummerierung, musst du eine sortierte Liste (ordered list) verwenden:

```html
<h4>Most Difficult Programming Languages</h4>
<ol>
     
  <li>Brainf*ck</li>
     
  <li>Cow</li>
     
  <li>Intercal</li>
     
  <li>Malbolge</li>
     
  <li>Whitespace</li>
</ol>
```

Die obigen Beispiele würden in der Praxis aussehen wie folgt:

<div style="border: 2px solid black; padding: 2em">

#### What do you do in case of emergency?</h4>

- git commit -m "message"
- git push
- Leave the building

#### Most Difficult Programming Languages

1. Brainf\*ck
2. Cow
3. Intercal
4. Malbolge
5. Whitespace
</div>

Definitionslisten sind eine weitere Art der Aufzählung. Diese Art von Liste wird zwar nicht oft verwendet, kann aber hilfreich für ein Glossar oder Ähnliches sein. Schaue dir hierfür folgendes Beispiel an:

```html
<h2>Glossary</h4>
<dl>
    <dt>buffoonish</dt>
    <dd>like a clown </dd>
   
    <dt>heyday</dt>
    <dd>the period of greatest prosperity or productivity</dd>
</dl>

```

<div style="border: 2px solid black; padding: 2em">

#### Glossary

<dl>
    <dt>buffoonish</dt>
    <dd>like a clown </dd>
    
    <dt>heyday</dt>
    <dd>the period of greatest prosperity or productivity</dd>
</dl>
</div>
