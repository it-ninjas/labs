---
title: "Mit JavaScript das DOM verändern"
type: docs
linkTitle: "DOM-Manipulation"
weight: 3
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Website mithilfe von JavaScript manipulieren.
---

## Auf DOM-Elemente zugreifen

Eines der häufigsten Anwendungszwecke von JavaScript ist, mit Elementen auf einer Website zu interagieren.

Nehmen wir folgenden Codeausschnitt als Beispiel:

```html
<div id="message-div"></div>

<p>This page has <span id="likes-count">0</span> likes.</p>
<button type="button">+1</button>
```

Wir möchten mit Javascript bewerkstelligen, dass sich die Zahl im `<span>` erhöht. In einem ersten Schritt versuchen wir, direkt auf das `<span>`-Element selbst zuzugreifen und eine andere Zahl als Wert zu übergeben. Probiere das direkt in der Konsole deines Browsers aus:

```javascript
let span = document.getElementById("likes-count");
span.textContent = 999;
```

Du wirst sehen, dass sich die Zahl im `<span>`-Element tatsächlich verändert hat. Probieren wir mal zu verstehen, was im Code passiert:

<details>

<summary>Erläuterung (click to expand)</summary>

- `document` ist ein Objekt, welches uns im Browser zur Verfügung steht. Dieses Objekt repräsentiert das DOM. Mit diesem `document`-Objekt können wir in Javascript auf die einzelnen Elemente im Browser zugreifen.
- `getElementById(...)` ist eine Methode dieses `document`-Objekts. Diese Methode sucht auf der aktuellen Seite das Element, welches die als Parameter übergebene `id` besitzt.
- Das gefundene Element möchten wir in einer Variable namens `span` zwischenspeichern.
- `textContent` ist ein Attribut auf dem gesuchten `<span>`-Element, welches den Inhalt des Elements in textform repräsentiert.

</details>

Mithilfe dieses Codeausschnitts konnten wir die Anzahl Likes auf einen anderen Zahlenwert setzen. Nun möchten wir aber, dass sich diese Anzahl um genau 1 erhöht. Dazu müssen wir die folgenden Schritte durchführen:

1. Die aktuelle Zahl auslesen
2. Diese Zahl von einem String in eine Nummer konvertieren
3. Die inkrementierte Zahl ins `<span>` schreiben.

Versuch einmal, das selbst zu implementieren, bevor du dir die Lösung dazu ansiehst.

<details>

<summary>Lösung (click to expand)</summary>
Eine Lösung für die gegebenen Anforderungen könnte wie folgt aussehen:

```javascript
let span = document.getElementById("likes-count");
let likes = parseInt(span.textContent);
likes++;
span.textContent = likes;
```

In diesem Codeausschnitt kannst du einige neue Kontrollstrukturen erkennen:

- Der Aufruf von `parseInt(...)`. Diese Methode ist standardmässig global verfügbar und kann somit ohne zusätzliche Imports verwendet werden. Diese Methode wird verwendet, um den als Parameter übergebenen Wert in eine Ganzzahl (Integer) zu konvertieren.
- `likes++` ist gleichzusetzen mit dem Ausdruck `likes = likes + 1`. Damit erhöhen wir die `likes`-Variable also um 1. Diesen Vorgang beschreibt man meistens als Inkrementierung.
- Mit der Zeile `span.textContent = likes` setzen wir den Text des `span`s neu. Eine explizite Umwandlung des Werts in einen String ist nicht notwendig.

Versuche jetzt den obenstehenden Codeausschnitt mal aus, ohne die `parseInt`-Methode zu verwenden.
Du wirst sehen, dass der Code trotzdem funktioniert. Das liegt daran, dass JS keine "starken" typen (strong types) kennt. Das heisst konkret, dass der JS-Interpreter versucht, den String auch als Zahl zu verwenden. Wenn es sich wirklich um eine Zahl handelt, funktioniert das auch:

```js
function onLikeClick() {
  let span = document.getElementById("likes-count");
  let likes = span.textContent;
  likes++;
  span.textContent = likes;
}
```

Dieses Vorgehen ist aber ziemlich fragil, weshalb es grundsätzlich immer empfehlenswert ist, die verwendeten Werten dennoch immer in die korrekten Typen umzuwandeln.

</details>

### Manipulation beim Button-Klick ausführen lassen

Als Letztes wollen wir jetzt noch, dass die Funktionalität, welche wir vorher programmiert haben, dann ausgeführt wird, wenn der User auf den Button klickt. Ändere das HTML-Dokument daher wie folgt ab:

```html
...
<button type="button" onclick="onLikeClick()">+1</button>

<script>
  function onLikeClick() {
    let span = document.getElementById("likes-count");
    let likes = parseInt(span.textContent);
    likes++;
    span.textContent = likes;
  }
</script>
...
```

Was passiert hier genau? Im `button`-Element haben wir das Attribut `onclick=` hinzugefügt, welches jeweils darauf wartet, dass auf dem Knopf aus ein Klick-Event passiert.
Wenn also der Nutzer auf den Knopf drückt und somit das `onclick`-Event getriggert wird, wird der Teil innerhalb von `onclick` ausgeführt, in diesem Fall ein Aufruf auf die `onLikeClick()`-Funktion.
Indem wir innerhalb des `<script>`-Tags unseren Code als Funktion `onLikeClick` zusammengefasst haben, wird nun bei jedem Klick auf den Knopf diese ausgeführt und somit der Wert von `likes` um 1 erhöht.

## Ein neues Element hinzufügen

Manchmal möchtest du über Javascript ein neues Element auf deiner Website generieren lassen.

Im kommenden Beispiel möchten wir eine der Anzahl Likes entsprechende Anzahl Instanzen eines "ThumbsUp"-Bilds (also 👍) anzeigen.

Um das zu erzielen, kannst du die `onLikeClick`-Funktion mit dem folgenden Codeausschnitt erweitern:

```javascript
// draw a thumb up for every like:
const imgHtml =
  '<img src="https://upload.wikimedia.org/wikipedia/commons/c/ce/Emoji_u1f44d.svg" alt="like" height="25">';
let insertHtml = "";
for (let i = 0; i < likes; i++) {
  insertHtml += imgHtml;
}
const messageDiv = document.querySelector("div#message-div");
messageDiv.innerHTML = insertHtml;
```

In diesem Abschnitt passiert das Folgende:

- für jeden Like wird im `<div id="message-div">` folgendes `<img>`-Element hinzugefügt: `<img src="https://upload.wikimedia.org/wikipedia/commons/c/ce/Emoji_u1f44d.svg" alt="like" height="25">`
- Das HTML-Element dieses Bilds haben wir zuerst in einer Konstante (`const`) gespeichert. `const` ist prinzipiell dasselbe wie `let`, nur mit dem Unterschied, dass sich dieser Wert nach der Initialisierung nie verändern darf.
- Die String-Variable `insertHtml` brauchen wir als Zwischenspeicher, in welcher wir den HTML-String zusammensetzen, welchen wir später in das DOM einspeisen möchten.
- Die Anzahl der Durchläufe der `for`-Schlaufe entspricht der Anzahl Likes. Das bedeutet, dass pro Like ein Bild in `insertHtml` kopiert wird.
- Anschliessend holen wir uns das `<div id="message-div">`-Element via JavaScript. Wir hätten hier auch `document.getElementById('message-div')` verwenden können, `querySelector` funktioniert hier aber auch. Die `querySelector`-Funktion akzeptiert als Argument einen CSS-Selektor und gibt dann das entsprechende Element zurück, das damit angesprochen wird. In diesem Beispiel war `div#message-div` ein möglicher CSS-Selektor (wie `#message-div` auch), der das `<div id="message-div"` anspricht.
- Als Letztes verändern wir das HTML dieses `<div>`-Elements, indem wir das `innerHTML`-Feld neu populieren.

Elemente können nicht nur mit dem `querySelector` hinzugefügt werden, sondern auch mit `document.createElement()`. Mit der `document.createElement()`-Methode kann man neue HTML-Elemente dynamisch erstellen und diese im DOM hinzufügen.

```html
<!doctype html>
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

Nun hast du schon ein paar Dinge auf deiner Seite mit JavaScript dynamisch verändert.

Bitte denke dran, dass das Verwenden von `.innerHTML` als eine Art "Holzfäller-Methode" angesehen wird. JavaScript bietet hierfür elegantere Möglichkeiten, die aber oft umständlicher sind. Schaue dir diese trotzdem kurz an: https://www.w3schools.com/js/js_htmldom_nodes.asp
