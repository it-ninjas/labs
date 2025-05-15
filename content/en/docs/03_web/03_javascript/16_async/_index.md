---
title: "Promises"
type: docs
linkTitle: "Promises"
weight: 16
date: 2022-04-19
description: >
  Modul #F4 - JavaScript - Promises.
---

## Ziele

- Du weisst, was Promises sind und wozu sie verwendet werden.
- Du kannst Promises in Funktionen korrekt anwenden.

## Promises

Ein Promise repräsentiert einen Wert, der möglicherweise in der Zukunft verfügbar sein wird.

Promises werden oft verwendet, um asynchrone Operationen wie das Laden von Daten von einem Server oder das Ausführen eines HTTP-Requests zu verwalten. Ein Promise kann sich in einem von drei Zuständen befinden:

- Pending (ausstehend): Das Promise ist noch nicht erfüllt (`resolved`) oder abgelehnt (`rejected`) worden.
- Fulfilled (erfüllt): Die asynchrone Operation wurde erfolgreich abgeschlossen (`resolved`) und der Promise enthält den gelieferten Wert.
- Rejected (abgelehnt): Die asynchrone Operation ist fehlgeschlagen und das Promise enthält den jeweiligen Fehler.

Ein Promise kann mit der Funktion `new Promise()` erstellt werden. Diese Funktion nimmt eine Funktion als Argument, die zwei Parameter enthält: `resolve` und `reject`. `resolve` wird aufgerufen, wenn die Operation erfolgreich abgeschlossen wurde, und `reject`, wenn ein Fehler aufgetreten ist.

```javascript
const promise = new Promise((resolve, reject) => {
  if (success) {
    resolve("success");
  } else {
    reject("error");
  }
});
```

Promises bieten zwei Methoden an, um mit dem Ergebnis oder dem Fehler der asynchronen Operation umzugehen:

- `then()`
- `catch()`

Die `then()` Methode wird verwendet, um eine Funktion zu registrieren, die ausgeführt wird, wenn das Promise erfolgreich erfüllt wird. Diese Funktion erhält das Ergebnis des erfüllten Promise als Parameter:

```javascript
const promise = new Promise((resolve, reject) => resolve("success"));

promise.then((result) => {
  console.log(result); // 'success'
});
```

Die `then()`-Methode kann auch mehrmals hintereinander verwendet werden, um eine Kette von Funktionen zu erstellen, die nacheinander ausgeführt werden, wenn das Promise erfüllt wird.

Durch die Verwendung von `then()` in Kombination mit `return` in jeder Funktion kann eine Kette von Funktionen erstellt werden, die nacheinander ausgeführt werden, wobei jedes Ergebnis das Argument für die nächste Funktion in der Kette ist.

```javascript
const promise = new Promise((resolve, reject) => resolve(2));

promise
  .then((result) => {
    console.log(result); // 2
    return result * 2;
  })
  .then((result) => {
    console.log(result); // 4
    return result * 2;
  })
  .then((result) => {
    console.log(result); // 8
  });
```

Die `catch()` Methode wird verwendet, um eine Funktion zu registrieren, die ausgeführt wird, wenn das Promise fehlschlägt. Diese Funktion erhält den Fehler als Parameter.

```javascript
const promise = new Promise((resolve, reject) => reject("error"));

promise.catch((result) => {
  console.log(result); // 'error'
});
```

`then()` und `catch()` werden fast immer zusammen verwendet:

```javascript
const number = 10;
const promise = new Promise((resolve, reject) => {
  if (number > 0) {
    resolve("success");
  } else {
    reject("error");
  }
});

promise
  .then((result) => {
    console.log(result); // 'success'
  })
  .catch((error) => {
    console.error(error); // 'error'
  });
```

### Promises als Function

Promises in Funktionen zu integrieren ist eine gängige Praxis in JavaScript, um asynchrone Operationen und Callbacks zu verwalten. Indem man Promises in Funktionen einbettet, kann man sicherstellen, dass die asynchronen Operationen sequentiell ausgeführt werden und man eine klare Struktur im Code hat.

Dazu muss man das gesamte Promise in der Funktion returnen:

```javascript
function promiseFunction(number) {
  return new Promise((resolve, reject) => {
    if (number > 0) {
      resolve("success");
    } else {
      reject("error");
    }
  });
}
```

Nun kann man diese Funktion innerhalb von anderen Funktionen verwenden. Wichtig ist, dass diese mit `await` gekennzeichnet sein müssen, um auf das Ergebnis des Promises zu warten, bevor der Rest der Funktion fortgesetzt wird. So kann man sicher gehen, dass das Resultat aus dem Promise zur Verfügung steht und es danach in der Funktion verwendet werden kann. Wenn man jedoch ein `await` in einer Funktion verwendet, muss die gesamte Funktion asynchron sein. Dazu muss die Funktion mit `async` gekennzeichnet sein.

```javascript
function promiseFunction(number) {
  return new Promise((resolve, reject) => {
    if (number > 0) {
      resolve("success");
    } else {
      reject("error");
    }
  });
}

async function callPromiseFunction() {
  const successResult = await promiseFunction(10);
  console.log(successResult);

  const errorResult = await promiseFunction(-5);
  console.log(errorResult);
}

callPromiseFunction();
// 'success'
// Promise {<rejected>: 'error'}
```

Ohne das `async`-Keyword wäre es nämlich so, dass der Code je nachdem bereits weiter durchläuft, bevor das Promise erfüllt wurde und ein Resultat vorliegt.

```javascript
function promiseFunction(number) {
  return new Promise((resolve, reject) => {
    if (number > 0) {
      resolve("success");
    } else {
      reject("error");
    }
  });
}

function callPromiseFunction() {
  const promise = promiseFunction(10)
    .then((result) => {
      console.log(result);
    })
    .catch((error) => {
      console.error(error);
    });

  console.log(promise);
}

callPromiseFunction();
// Promise {<pending>}
// 'success'
```
