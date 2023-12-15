---
title: "Mit JavaScript das DOM verändern"
type: docs
linkTitle: "DOM-Manipulation"
weight: 3
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Website mit Hilfe von JavaScript verändern.
---

## Auf DOM-Elemente zugreifen
Eines der häufigsten Anwendungszwecke von JavaScript ist es, mit Elementen auf einer Website zu interagieren.

Nehmen wir folgendes Code-schnipsel als Beispiel:
```html
<div id="message-div"></div>

<p>This page has <span id="likes-count">0</span> likes.</p>
<button type="button">+1</button>
```

Mit JavaScript möchten wir, dass sich die Zahl im `<span>` erhöht. In einem ersten Schritt versuchen wir, auf das `<span>`-Element zuzugreifen und eine andere Zahl reinzuschreiben. Das probieren wir direkt in der Konsole des Browsers aus:

```javascript
let span = document.getElementById('likes-count');
span.textContent = 999;
```

Du wirst sehen, dass sich die Zahl im `<span>` tatsächlich verändert hat. Probieren wir aber zuerst, den Code zu verstehen!
<details>

<summary>Erläuterung (click to expand)</summary>

* `document` ist ein Objekt, das uns im Browser zur Verfügung steht. Dieses Objekt repräsentiert das DOM. Mit diesem `document`-Objekt können wir auf die Elemente im Browser zugreifen.
* `getElementById(...)` ist eine Methode auf diesem `document`-Objekt. Diese Methode sucht auf der aktuellen Seite ein Element, das die übergebene `id` besitzt.
* Das gefundene Element möchten wir in einer Variablen namens `span` zwischenspeichern.
* `textContent` ist ein Feld (= ein Attribut) auf diesem Element, das den Inhalt des Elements (als Text) repräsentiert. Diesen Wert können wir einfach so kopieren.

</details>


Mit diesem Code konnten wir die Anzahl Likes auf eine andere Zahl setzen. Nun möchten wir aber, dass sich diese Anzahl um genau 1 erhöht. Dafür benötigen wir noch zwei Zwischenschritte:
1. Die aktuelle Zahl auslesen
2. Diese Zahl von einem String in eine Nummer konvertieren
3. Und die erhöhte Zahl ins `<span>` schreiben.

Versuche dies zu implementieren, bevor du dir die Lösung ansiehst.

<details>

<summary>Lösung (click to expand)</summary>
Das könnte ungefähr so aussehen:

```javascript
let span = document.getElementById('likes-count');
let likes = parseInt(span.textContent);
likes++;
span.textContent = likes;
```

Neu dazugekommen ist
* der Aufruf von `parseInt(...)`. Diese Methode ist standartmässig Global verfügbar und kann somit ohne imports verwendet werden. Diese Methode versucht, den übergeben Wert in eine Ganzzahl (Integer) zu konvertieren.
* `likes++` bedeutet gleich viel wie `likes = likes + 1`. Damit erhöhen wir die `likes`-Variable also um 1.
* Mit `span.textContent = likes` setzen wir den Text des `span`s neu. Eine Umwandlung in String ist nicht notwendig.

Versuche das ganze nun mal ohne die parseInt Methode.
Du wirst sehen, dass es trotzdem funktioniert. Das liegt daran, dass JS keine "starke" typen (strong types) kennt. Sprich der JS-Interpreter versucht auch einen String als Zahl zu verwenden und wenn es sich wirklich um eine Zahl handelt, funktioniert das auch:

```js
    function onLikeClick() {
        let span = document.getElementById('likes-count');
        let likes = span.textContent;
        likes++;
        span.textContent = likes;
    }
```

Dies ist aber sehr fragil, daher ist es good practice, die Variablen trotzdem in die korrekten typen umzuwandeln. 
Gut zu wissen, ist das sich JavaScript teilweise etwas unerwartet verhält. 
</details>


### Manipulation beim Button-Klick ausführen lassen
Nun wollen wir noch, dass das, was wir vorher programmiert haben, dann passiert, wenn der User auf den Button klickt. Ändere die HTML-Seite wie folgt ab:

```html
...
<button type="button" onclick="onLikeClick()">+1</button>

<script>
    function onLikeClick() {
        let span = document.getElementById('likes-count');
        let likes = parseInt(span.textContent);
        likes++;
        span.textContent = likes;
    }
</script>
...
```

## Ein neues Element hinzufügen
Manchmal möchtest du ein neues Element auf der Website generieren lassen.

Im kommenden Beispiel möchten wir so viele Bilder von "Thumbs Ups" (also 👍) wie Likes anzeigen.

Um das zu erzielen, kannst du die `onLikeClick`-Funktion wie folgt erweitern:
```javascript
// draw a thumb up for every like:
const imgHtml = '<img src="https://upload.wikimedia.org/wikipedia/commons/c/ce/Emoji_u1f44d.svg" alt="like" height="25">';
let insertHtml = '';
for (let i = 0; i < likes; i++) {
    insertHtml += imgHtml;
}
const messageDiv = document.querySelector('div#message-div');
messageDiv.innerHTML = insertHtml;
```

Dieser Code macht folgendes:
* für jedes Like, wird im `<div id="message-div">` folgendes Element/Bild hinzugefügt: `<img src="https://upload.wikimedia.org/wikipedia/commons/c/ce/Emoji_u1f44d.svg" alt="like" height="25">`
* Das HTML für dieses Bild haben wir zuerst in einer Konstante (`const`) gespeichert. `const` ist das Gleiche wie `let` mit dem Unterschied, dass sich dieser Wert nie verändern darf innerhalb dieser Methode. Wenn sich eine Variable nie im definierten Block verändert, so wird empfohlen, `const` statt `let` zu verwenden.
* Die String-Variable `insertHtml` brauchen wir als Zwischenspeicher, in welcher wir den HTML-String zusammensetzen, welche wir später im HTML/DOM haben möchten.
* Die `for`-Schlaufe wird so oft durchlaufen, wie es Likes gab. Das bedeutet, dass pro Like ein Bild ins `insertHtml` kopiert wird.
* Anschliessend holen wir uns das `<div id="message-div">` via JavaScript. Wir hätten hier auch `document.getElementById('message-div')` verwenden können. Aber `querySelector` funktioniert hier auch. Die `querySelector`-Methode akzeptiert ein CSS-Selektor und gibt dann das Element zurück, das damit angesprochen wird. In diesem Beispiel war `div#message-div` ein möglicher CSS-Selektor (wie `#message-div` eigentlich auch), der das `<div id="message-div"` anspricht.
* Als letztes verändern wir das HTML dieses `<div>`s, indem wir das `innerHTML`-Feld neu setzen.


Element können jedoch nicht nur mit `querySelector` hinzugefügt werden, sondern auh mit `document.createElement()`. Mit der `document.createElement()`-Methode kann man neue HTML-Elemente dynamisch erstellen und diese im DOM hinzufügen.
```html
<!DOCTYPE html>
<html>
<head>
    <title>JavaScript Create Element</title>
</head>
<body>
    <h1>JavaScript Create Element</h1>

    <div id="container">
        <!-- Hier werden die neuen Elemente hinzugefügt -->
    </div>
</body>
</html>

```
```js
var container = document.getElementById("container");

// Erstelle ein neues <p>-Element
var paragraph = document.createElement("p");
paragraph.textContent = "Dies ist ein neuer Absatz.";
// Füge das <p>-Element dem <div>-Element hinzu
container.appendChild(paragraph);
```

Super, nun hast du schon ein paar Dinge auf deiner Seite mit JavaScript dynamisch verändert. 

Bitte denke daran, dass das Verwenden von `.innerHTML` als eine Art "Holzfäller-Methode" angesehen wird. JavaScript bietet hierfür bereits eine elegantere Möglichkeit, die aber oft viel zu umständlich ist. Bitte schaue dir diese trotzdem kurz an: https://www.w3schools.com/js/js_htmldom_nodes.asp