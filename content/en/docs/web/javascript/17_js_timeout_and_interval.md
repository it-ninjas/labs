---
title: "Timeouts und Intervalle"
type: docs
linkTitle: "Timeouts und Intervalle"
weight: 17
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Code verzögert ausführen.
---

## Code verzögert ausführen: setTimeout(...)

Manchmal muss eine Aktion verzögert ausgeführt werden. Dies kannst du ganz einfach mit der Funktion `setTimeout(callback, time)` realisieren:

```javascript
setTimeout(function () {
  console.log("Thanks for waiting :)");
}, 5000);
```

Das erste Argument ist die Aktion/Funktion, die ausgeführt wird, sobald die Zeit abgelaufen ist. Das zweite Argument ist die Zeit in Millisekunden, die verstreichen muss, bis die übergebene Funktion ausgeführt wird.

## Code immer wieder ausführen: setInterval(...)

Folgender Code wird jede Sekunde ausgeführt:

```javascript
setInterval(function () {
  console.log("hey!");
}, 1000);
```

Vielleicht ist dir aufgefallen, dass `setTimeout(...)` und `setInterval(...)` eine Ganzzahl zurückgeben. Das ist die ID des Timeouts bzw. Intervalls. Es macht Sinn, diesen Wert zu merken, damit man das Intervall wieder beendet werden kann:

```javascript
const intervalId = setInterval(function(){}, 1000);
...

clearInterval(intervalId);
```

![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](../../../labs/web/javascript/01_javascript.md).
