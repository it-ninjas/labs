---
title: "Weitere HTML-Tags"
linkTitle: "Weitere HTML-Tags"
weight: 4
description: >
    Modul #F3 - HTML und CSS - Nützliche HTML Tags
---

#### Ziele
* Ich weiss, wie ich HTML-Dokumente strukturieren kann.
* Ich weiss, wie ich mit HTML Texte formatieren kann.
* Ich weiss, wie ich Links und Bilder in einer Webseite hinzufügen kann.
* Ich weiss, wie ich geordnete/sortierte Listen erstellen kann.
* Ich weiss, wie ich ungeordnete/unsortierte Listen erstellen kann.
* Ich weiss, was Definitionslisten sind und wie und wozu ich sie einsetzen kann.

## Titel (Heading)
Du hast bereits erfahren, dass du mit `<h1>` für Titel verwenden kannst. Oft hast du aber einen Titel für die Seite und dann Titel, die diesem Titel untergeordnet sind. Wie in einem Word-Dokument kannst du auch in HTML Titel hierarchisch verschachteln. Das geht so:

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

Es gibt also Tags für Titel erster bis sechste Stufe. Grundsätzlich gilt, je kleiner die Zahl der Stufe, je grösser wird der Titel dargestellt. Das obrige Ergebnis zeigt, wie Titel per Default gestylt werden. Du kannst das Styling dieser Titel selbstverständlich anpassen (kommt im CSS-Teil).

## Paragrafen
Du hast bereits erfahren, dass Zeilenumbrüche in HTML keine Wirkung haben. Möchtest du eine neue Zeile einfügen, könnte dir das `<br/>`-Tag weiterhelfen. Besser ist aber, wenn du den Text, der zusammengehört, auch entsprechend markierst: Das kannst du mit dem `<p>`-Tag erreichen. Der Text, der innerhalb dieses Tags steht, wird in einem gleichen Abschnitt dargestellt. Ausserdem trennt es diesen Inhalt mit Leerschlag zum nächsten Element. Das wird im folgenden Beispiel verdeutlicht:

```html
<h2>Title</h2>
This is one line. 
This the second one. <br/> And the third one.
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

Beachte hier, dass `<p>`-Tags mehr Leerraum erzeugen als `<br/>`.



## Text formatieren
Du wirst in die Situation kommen, wo du einen bestimmten Teil eines Textes z.B. fett oder kursiv formatieren musst.

Das kannst du mit HTML sehr einfach erreichen, denn dafür gibt es spezielle Tags:

```html
<p>
    <strong>Heared</strong> about
    the new restaurant called
    <em>Karma?</em>
</p>
<p>
    There's <b>no menu</b>:
    You get what you <i>deserve</i>.
</p>

```

Um also einen bestimmten Text fett darzustellen, kannst du es in ein `<strong>`- oder `<b>`-Element schmeissen. Beide Tags BEZWECKEN im Prinzip genau das Gleiche, MEINEN aber nicht zwingend das Gleiche: `<b>`-Elemente sind einfach fett-gedruckt, während `<strong>`-Elemente betont sein sollen. `<strong>` soll dem fett-gedruckten Wort also mehr Ausdruck verleihen. Mit einem eigenen Styling (kommt im CSS-Teil) könntest du `<strong>`-Elemente z.B. auch grösser oder rot darstellen. Mit einem `<b>`-Element sagt man im Prinzip nur, dass der Text fett-gedruckt sein soll.

Einen Text kursiv darstellen kannst du mit `<i>` bzw. `<em>`. Das Pendant zu `<b>` ist `<i>` (italic), und dasjenige zu `<strong>` das `<em>` (emphasis = Betonung).

Das obige Beispiel wird so gerendert:
<div style="border: 2px solid black; padding: 2em">
    <p>
        <strong>Heared</strong> about
        the new restaurant called
        <em>Karma?</em>
    </p>
    <p>
        There's <b>no menu</b>: You get what you <i>deserve</i>.
    </p>
</div>

![asset](/images/hint.png) Bitte beachte:
Text zu formatieren ist Styling. Styling wiederum ist normalerweise die Aufgabe von CSS und nicht von HTML.

## Links und Bilder
Eines der wichtigsten Elemente in HTML sind Links auf andere Seiten. Links werden mit `a`-Elementen (anchor) realisiert. Einen Link kann wie folgt erstellt werden:

```html
<a href="https://labs.it-ninjas.ch/">Home</a>
```

Probiere das einmal aus.

Du wirst einen blauen und unterstrichenen Text "Home" sehen. `<a>` ist der Tag, der generell für Hyperlinks verwendet wird. `href` ist ein Attribut des `a`-Tags,
mit dem die URL des Links spezifiziert wird. In unserem Fall ist `https://labs.it-ninjas.ch/` die URL, die beim Klick aufgerufen wird. `Home` ist der Text, der dem User angezeigt wird.


Ziemlich ähnlich kannst du auch ein Bild aus dem Internet einbinden:

```html
<img src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png" 
     alt="IT Ninjas"
     width="300" />
```

Ganz offensichtlich wird das `<img/>`-Tag (Image) für Bilder verwendet. Das `<img/>`-Tag ist ein Tag, welches keinen Inhalt zwischen Opening- und Closing-Tag hat. Mit dem `/` im Opening-Tag kann man symbolisieren, dass das Tag ohne Closing-Tag geschlossen wird.

Das wichtigste Attribut im `img`-Tag ist `src` (source = Quelle). Als `src` wird eine URL zu einem Bild erwartet. Vergiss nicht, bei absoluten Pfaden das Protokoll (also https://) anzugeben. Nicht zwingend aber erwartet wird das `alt`-Attribut (alternative). Dieser Text wird angezeigt, wenn das Bild nicht geladen werden konnte. Völlig optional sind hingegen Attribute wie `width` oder `height`, welche die Breite und Höhe des Bildes festlegen. Diese Grössen werden aber besser mit CSS spezifiziert, da CSS genauere Spezifikationen zulässt (also nicht nur in 'Pixel' sondern auch anderen Einheiten).

Wenn du willst, dass man beim Klick auf ein Bild weitergeleitet wird, kannst du dein Bild in ein `<a>`-Element schmeissen:

```html
<a href="https://it-ninjas.ch/">
    <img src="https://it-ninjas.ch/img/png/Ninja%20Elements_ninja_phone.png" alt="IT Ninjas" />
</a>
```

## Listen
In HTML gibt es verschiedene Arten, um Aufzählungen darzustellen. Wir schauen uns Bullet-Point-Listen, Nummerierte-Listen und Definitions-Listen an.

Eine Bullet-Point-Liste kann man mit einer unsortierten Liste (unordered list) kreieren:

```html
<h4>What do you do in case of emergency?</h4>
<ul>
    <li>git commit -m "message"</li>
    <li>git push</li>
    <li>Leave the building.</li>
</ul>
```

Möchtest du hingegen eine Nummerierung, dann verwende eine sortierte Liste (ordered list):

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

Das Ganze sieht dann ungefähr so aus:

<div style="border: 2px solid black; padding: 2em">

#### What do you do in case of emergency?</h4>
* git commit -m "message"
* git push
* Leave the building

#### Most Difficult Programming Languages
1. Brainf*ck
2. Cow
3. Intercal
4. Malbolge
5. Whitespace
</div>

Eine 3. Art von Listen sind Definitionslisten. Diese Art von Liste wird zwar nicht oft verwendet, kann aber hilfreich für ein Glossar oder Ähnliches sein. Schaue dir hierfür folgendes Beispiel an:

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
