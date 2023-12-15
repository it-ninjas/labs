---
title: "JavaScript: Einführung"
type: docs
linkTitle: "Intro"
weight: 1
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Code im Browser auführen
---
Bevor man mit dem neuen Kapitel JavaScript beginnen kann, sollte man nochmals das Kapitel [Node JS Installation](../../ide_advanced/01_nodejs/#installation-von-nodejs) durcharbeiten und sicherstellen das alles installiert ist.

Jetzt wird es Zeit, dass du auch Programm-Logik auf deiner Website einbauen kannst. Dafür lernst du gleich die Programmiersprache JavaScript kennen, die von praktisch allen bekannten Browsern unterstützt wird.

Damit du eine Übersicht über die Programmiersprache bekommst, kannst du z.B. [dieses Video](https://www.youtube.com/watch?v=DHjqpvDnNGE) schauen, ohne dass du den ersten Satz verstehen musst.

## Motivation für JavaScript
JavaScript hat sehr viele Verwendungen im Browser. Einerseits können Funktionen ähnlich wie mit Java programmiert werden, sodass z.B. Berechnungen ausgeführt werden können. Zudem kann aber auch direkt mit dem angezeigten Inhalt interagiert werden. So können Validierungen oder auch Animationen ausgeführt werden. Wenn du mal sehen willst, wie eine Website aussieht ohne JS kannst du dir [hier](https://chrome.google.com/webstore/detail/disable-javascript/jfpdlihdedhlmhlbgooailmfhahieoem?hl=en) eine Chrome extension herunterladen mit welcher du JS komplett ausschalten kannst.

Nun beginnen wir aber zuerst klein: Mit einem Button, der beim Klick eine MessageBox anzeigt.

```html
<button onclick="onClickMeClick()" type="button">Klick mich</button>

<script>
    function onClickMeClick() {
        alert('Klick mich nicht an!!');
    }
</script>
```

Versuche zuerst, dieses Beispiel ohne Erläuterung zu verstehen.

<details>

<summary>Erläuterung (click to expand)</summary>
Zuerst hast du im HTML einen Button erstellt mit dem Text "Klick mich". 

Weiter unten siehst du ein `<script>`-Element. Dort drin ist eine Funktion namens `onClickMeClick()` definiert. Die Funktion ruft `alert(message: string)` auf. Diese `alert`-Funktion öffnet eine MessageBox mit der übergebenen Nachricht.

Wie du siehst, wird die selbst definierte Funktion beim Klick auf den Button aufgerufen. Dies passiert, weil du diesen Aufruf im `onclick`-Attribut des `<button>`s definiert hast. Beachte in diesem Beispiel, dass nicht die Funktion sondern deren Aufruf drin steht. Im Prinzip wird beim Button-Klick der Wert des `onclick`-Attributs ausgeführt. Theoretisch könntest du auch direkt `onclick="alert('Klick mich nicht an!!')"` schreiben.
</details>



## JavaScript einbinden

Wie du im oberen Beispiel gesehen hast, wird Javascript via `<script>`-Tag eingebunden. Dein Code kann direkt im `<script>`-Tag geschrieben werden:

```html
<script>
  console.log('my Js Code');
</script>
```

Du kannst aber dein Code auch in einem separatem .js File haben und via Script Tag referenzieren:

**index.html**
```html
<script src="mycode.js"></script>

```
**mycode.js**
```js
console.log('my Js Code');
```

Die zweite Variante ist meist sauberer, da Code und HTML sauber aufgeteilt wird. Bei unseren Übungen wirst du aber meist direkt im `<script>`-Tag arbeite können ohne separates JS File.