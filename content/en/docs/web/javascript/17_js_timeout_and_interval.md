---
title: "Timeouts und Intervalle"
type: docs
linkTitle: "Timeouts und Intervalle"
weight: 17
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Code verzögert ausführen.
---

## Ziele

- Du weisst, was `setTimeout(...)` ist, wie man die Methode verwendet und wie man einen Timeout frühzeitig abbricht.
- Du weisst, was `setInterval(...)` ist, wie man die Methode verwendet und wie man ein Interval frühzeitig abbricht.

## Code verzögert ausführen: setTimeout(...)

Manchmal möchte man eine Aktion verzögert ausführen. Das lässt sich einfach mit der Funktion `setTimeout(callback, time)` realisieren:

```javascript
setTimeout(function () {
  console.log("Thanks for waiting :)");
}, 5000);
```

Das erste Argument innerhalb der Funktion ist die Aktion/Funktion, die ausgeführt wird, sobald die angegebene Zeit abgelaufen ist. Das zweite Argument ist die Zeit (in Millisekunden), die verstreichen muss, bis die übergebene Funktion ausgeführt wird.

## Code immer wieder ausführen: setInterval(...)

Folgender Code wird jede Sekunde ausgeführt:

```javascript
setInterval(function () {
  console.log("hey!");
}, 1000);
```

Vielleicht ist dir aufgefallen, dass `setTimeout(...)` und `setInterval(...)` jeweils eine Ganzzahl zurückgeben. Das ist die ID des Timeouts bzw. Intervalls. Es macht Sinn, diesen Wert zu behalten, damit das Intervall auch wieder beendet werden kann:

```javascript
const intervalId = setInterval(function(){}, 1000);
...

clearInterval(intervalId);
```

Es ist auch möglich, ein `setTimeout(...)` frühzeitig abzubrechen. Auch hierzu benötigen wir die jeweilige ID der jeweiligen `setTimeout(...)`-Instanz. Zum Abbrechen eines Timeouts wird die `clearTimeout(...)`-Methode verwendet:

```javascript
const timeoutId = setTimeout(function () {
  console.log("Cance me!");
}, 10000);

clearTimeout(timeoutId);
```

Insofern der Timeout zum Zeitpunkt, in dem `clearTimeout(timeoutId)` aufgerufen wird, nicht bereits ausgelaufen ist, wird er so abgebrochen. Wicht zu wissen ist hierbei, dass die callback-Function im Falle eines Abbruchs nicht ausgeführt wird.

![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](https://labs.it-ninjas.ch/labs/web/javascript/01_javascript/#aufgabe-3---uhr).
