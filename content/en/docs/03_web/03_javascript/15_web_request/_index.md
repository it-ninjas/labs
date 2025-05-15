---
title: "Web Request"
type: docs
linkTitle: "Web Request"
weight: 15
date: 2022-04-20
description: >
  Modul #F4 - JavaScript - Web-Requests in JavaScript.
---

## Ziele

- Du weisst, wie man Web-Requests macht und die Antworten weiterverwenden kann.

## Webanfragen mit JavaScript

Wenn du eine Webanwendung schreibst, dann muss deine Website (=Frontend) wahrscheinlich Daten von (d)einem Backend abfragen.

In den meisten Fällen werden hierfür HTTP(S)-Requests verwendet, die du bereits kennengelernt hast (REST API in Spring und HTML Forms).

Um das einmal auszuprobieren, wollen wir testweise eine API anfragen, die als Antwort zufällige "Fakten" über Chuck Norris zurückschickt. Wenn wir diese URL im Browser per HTTP (GET) aufrufen, erhalten wir als Antwort einen Witz in Form eines JSON:

`GET https://api.chucknorris.io/jokes/random`

```json
{
  "categories": [],
  "created_at": "2020-01-05 13:42:20.262289",
  "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
  "id": "6F3bv9fIRUGCPTcma6Je1w",
  "updated_at": "2020-01-05 13:42:20.262289",
  "url": "https://api.chucknorris.io/jokes/6F3bv9fIRUGCPTcma6Je1w",
  "value": "Albert Einstein's hair used to be neatly combed...until the day he met Chuck Norris."
}
```

Damit für dich das Vorgehen verständlicher ist, führen wir einmal Schritt für Schritt alles in der Browser-Konsole aus.

Die Abfrage kannst du wie folgt manuell durchführen:

```javascript
fetch("https://api.chucknorris.io/jokes/random", { method: "get" });
```

Du wirst sehen, dass dieser Funktionsaufruf ein `Promise {<pending>}` zurückgibt (Promises sind im Kapitel [JS_Async](https://labs.it-ninjas.ch/docs/web/javascript/16_js_async/) zu finden). Wir sehen, dass die Anfrage noch nicht beendet ist (pending = anstehend). Dieses `Promise`-Objekt wird die Antwort enthalten, sobald die Antwort verfügbar ist. Da wir sowieso erst weiterfahren möchten, wenn die Antwort bereit ist, interessieren wir uns noch nicht für das `Promise`.
Daher können wir mit der Fortsetzung des Scripts solange warten, bis wir die Antwort hätten. Das können wir wie folgt machen:

```javascript
await fetch("https://api.chucknorris.io/jokes/random", { method: "get" });
```

Das `await`-Keyword führt dazu, dass das Script erst weiter durchläuft, wenn die Antwort angekommen ist. Zusätzlich wird die Antwort automatisch aus dem `Promise`-Objekt entpackt, womit wir direkt ein Objekt vom Typ `Response` erhalten.
In diesem Objekt sind mehrere wichtige Informationen enthalten, beispielsweise, ob die Request überhaupt erfolgreich war (`ok: true`), wie der HTTP-Statuscode aussieht und so weiter.
Zu beachten ist, dass `body` im unteren Beispiel als `ReadableStream` definiert ist, da es sich um einen Stream handelt und der tatsächliche Inhalt des Antwort-Body nicht direkt im JSON-Format angezeigt wird. Um den Inhalt des Antwort-Body zu lesen, müssen die entsprechenden Methoden wie `json()`, `text()` oder `blob()` verwendet werden, je nachdem welches Format der Inhalt hat.

```json
{
  "body": "ReadableStream",
  "bodyUsed": true,
  "headers": {},
  "ok": true,
  "redirected": false,
  "status": 200,
  "statusText": "",
  "type": "cors",
  "url": "https://api.chucknorris.io/jokes/random"
}
```

Theoretisch haben wir nun die Daten, die wir wollen. Da wir als Antwort ein JSON-Objekt erwarten, können wir diese direkt als solches anfordern:

```javascript
let response = await fetch("https://api.chucknorris.io/jokes/random", {
  method: "get",
});

response.json();
```

Komischerweise erhalten wir wieder ein `Promise {<pending>}` als Ergebnis. Was fehlt noch, um das JSON aus diesem Promise zu extrahieren?

Genau: Wir müssen es `await`en:

```javascript
let response = await fetch("https://api.chucknorris.io/jokes/random", {
  method: "get",
});

let jokeObject = await response.json();
```

Das ist notwendig, da die Methode [json()](https://developer.mozilla.org/en-US/docs/Web/API/Response/json) asynchron den Response-Stream ausliest.

Wenn du nun das `jokeObject` loggst (z.B. mit `console.log(jokeObject)`), siehst du, dass wir nun das gleiche Objekt, das wir ganz oben erwartet haben, einsehen können.

Den Witz kannst du wie folgt ausgeben:

```javascript
console.log(jokeObject.value);
```

### Anfrage in eine Funktion einbinden

Im Normalfall packt man Logik wie die oben beschriebene in eine Funktion. Den obenstehenden Code könntest du beispielsweise wie folgt in eine Methode einbinden:

```javascript
/**
 * Requests a random Chuck Norris joke and returns it.
 * @return {Promise<string>} a random Chuck Norris joke.
 */
async function fetchJoke() {
  const response = await fetch("https://api.chucknorris.io/jokes/random", {
    method: "get",
  });
  const jokeObject = await response.json();

  return jokeObject.value;
}
```

Dir ist sicher aufgefallen, dass wir in diesem Beispiel das `async`-Keyword vor `function` geschrieben haben. Das ist erforderlich, wenn man `await` in einer Funktion verwenden möchte. Dieses `async`-Keyword führt auch dazu, dass die Methode ein Objekt des Typen `Promise<...>` zurückgibt.

Wenn du diese Funktion definiert hast, kannst du den Rückgabewert von ihr wie folgt loggen:

```javascript
console.log(await fetchJoke());
```

### await umgehen

Du wirst in die Situation kommen, wo du eine Antwort auf eine asynchrone Anfrage erhältst, aber kein `await` brauchen darfst, weil du dich nicht in einer mit `async` gekennzeichneten Funktion befindest.

Statt ein Promise mit `await` zu erwarten, kannst du auch definieren, dass eine bestimmte Aktion durchgeführt werden soll, sobald die Antwort da ist. Das kannst du mit `Promise.then(...)` machen:

```javascript
fetchJoke().then(function (joke) {
  console.log(joke);
});
```

Das kannst du auch schöner schreiben, gewisse Browser (beispielsweise der Internet Explorer) unterstützen diese Schreibweise aber nicht:

```javascript
fetchJoke().then((joke) => console.log(joke));
```

Was genau haben wir hier gemacht?

Wir haben `fetchJoke()` asynchron aufgerufen, ohne auf die Antwort zu warten. Deswegen erhalten wir ein Promise-Objekt. Promise-Objekte enthalten implizit eine `then`-Methode. In dieser Methode kannst du eine Funktion übergeben. Die übergebene Funktion wird aufgerufen, sobald die Antwort erhalten wurde.

### Exception-Handling bei HTTP-Anfragen

Während einer HTTP-Anfrage passieren oft folgende typische Fehler:

- Der angefragte Server kann nicht erreicht werden bzw. der Browser erhält keine Antwort (`Response`).
- Die Anfrage wurde durch den Browser blockiert (zum Beispiel durch die CORS Policy).
- Der Server gibt eine Antwort mit einem Status-Code zurück, der einen Fehler beschreibt.

In den ersten beiden Fällen würde die `fetch()`-Funktion einen `Error` asynchron werfen. Diesen Fall könntest du mit einem `try` und `catch` abfangen.

Hingegen wird kein Fehler geworfen, wenn eine Antwort erhalten wird. Trotzdem kann die Response auf einen Fehler hindeuten, beispielsweise wenn der Status-Code `404` wäre. In diesem Fall hätten wir eine Antwort vom Server erhalten, die darauf hindeutet, dass die Seite hinter der URL nicht gefunden werden konnte.

Daher macht es Sinn, die `response` jeweils auf den Status Code zu überprüfen. Hierfür bietet das `response`-Objekt ein praktisches Property an: `ok`. Wenn `ok` true ist, dann liegt der Status-Code zwischen 200 und 299 (erfolgreiche Status-Codes).

Beide Fälle kombiniert resultieren in einem Error-Handling, das ungefähr so aussehen könnte:

```javascript
async function fetchJoke() {
  try {
    const response = await fetch("https://api.chucknorris.io/jokes/random", {
      method: "get",
    });

    if (!response.ok) {
      throw new Error(`Fehlerhafte Antwort. Status: ${response.status}`);
    }

    return await response.json();
  } catch (error) {
    console.error(error);
    // Hier müsste noch der Fehler behandelt werden und evtl. eine Nachricht dem User angezeigt werden.
    return null; // etwas zurückgebe, das auf einen Fehler hindeutet.
  }
}
```

Möchte man eine genauere Prüfung des Status-Codes vornehmen, dann könnte man statt `response.ok` das Property `response.status` überprüfen.

Hier noch ein Beispiel, wie es mit `.then()` und `.catch()` aussehen könnte:

```javascript
function fetchJoke() {
  return fetch("https://api.chucknorris.io/jokes/random", { method: "get" })
    .then((response) => {
      if (!response.ok) throw Error("API not reachable");
      return response.json();
    })
    .then((data) => {
      return data.value;
    })
    .catch((error) => {
      console.error("Error in fetchJoke:", error);
      return null; // etwas zurückgebe, das auf einen Fehler hindeutet.
    });
}
```

Ganz generell: Bei der Verwendung von `fetch()` kann man darüber diskutieren, ob es überhaupt Sinn ergibt, einen `fetch()`-Befehl überhaupt in einen `try`-`catch`-Block hereinzunehmen. In den meisten Fällen reicht es vollkommen aus, die `response` auf den Status-Code zu überprüfen. In Frameworks wie Angular wird oft auf einen `try`-`catch`-Block verzichtet, da das Framework einen "globalen Exception-Handler" besitzt, der den User dann über den Fehler informieren würde.

![asset](/images/hint.png) Hierzu findest du [zwei Aufgaben im Lab](../../../../labs/03_web/02_javascript/01_javascript/_index).

### Früher war alles besser?

Die `fetch`-Funktion hat Web-Requests stark vereinfacht. Früher durfte man sich noch mit XML HTTP Requests herumschlagen. Schau dir das auf der folgenden Seite kurz an: https://www.w3schools.com/xml/xml_http.asp
