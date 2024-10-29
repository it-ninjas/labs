---
title: "JavaScript: Einführung"
type: docs
linkTitle: "Intro"
weight: 1
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Code im Browser ausführen
---

Bevor du mit dem neuen Kapitel JavaScript beginnen kannst, solltest du nochmals das Kapitel [Node JS Installation](../../ide_advanced/01_nodejs/#installation-von-nodejs) durcharbeiten und sicherstellen, dass alles Nötige installiert ist.

Jetzt wird es Zeit, dass du auch Programm-Logik auf deiner Website einbauen kannst. Dafür lernst du nachfolgend die Programmiersprache JavaScript kennen, die von praktisch allen bekannten Browsern unterstützt wird.

Um eine Übersicht über die Programmiersprache zu erhalten, kannst du dir als Erstes [dieses Video](https://www.youtube.com/watch?v=DHjqpvDnNGE) anschauen.

## Motivation für JavaScript

JavaScript hat sehr viele Anwendungsfälle im Browser. Einerseits können Funktionen ähnlich wie mit Java programmiert werden, sodass beispielsweise Berechnungen ausgeführt werden können. Dazu kann aber auch direkt mit dem angezeigten Inhalt interagiert werden. So können Validierungen oder auch Animationen ausgeführt werden. Wenn du mal sehen willst, wie eine Website aussieht, die kein JS verwendet, kannst du dir [hier](https://chrome.google.com/webstore/detail/disable-javascript/jfpdlihdedhlmhlbgooailmfhahieoem?hl=en) eine Chrome-Extension herunterladen, mit welcher du das JS einer Webseite komplett ausschalten kannst.

Wir beginnen erstmal klein: Mit einem Button, der bei einem Klick eine MessageBox anzeigt.

```html
<button onclick="onClickMeClick()" type="button">Klick mich</button>

<script>
  function onClickMeClick() {
    alert("Klick mich nicht an!!");
  }
</script>
```

Versuche zuerst, dieses Beispiel ohne Erläuterung zu verstehen.

<details>

<summary>Erläuterung (click to expand)</summary>
Zuerst hast du im HTML einen Button erstellt mit dem Text "Klick mich".

Weiter unten siehst du ein `<script>`-Element. In diesem ist eine Funktion namens `onClickMeClick()` definiert. Die Funktion führt den Block `alert(message: string)` aus. Diese `alert`-Funktion öffnet eine MessageBox mit der übergebenen Nachricht.

Wie du siehst, wird die selbst definierte Funktion beim Klick auf den Button aufgerufen. Dies passiert, weil du diesen Aufruf im `onclick`-Attribut des `<button>`-Elements definiert hast. Beachte in diesem Beispiel, dass nicht die Funktion, sondern deren Aufruf darin steht. Im Prinzip wird beim Button-Klick der Wert des `onclick`-Attributs ausgeführt. Theoretisch könntest du auch direkt `onclick="alert('Klick mich nicht an!!')"` schreiben.

</details>