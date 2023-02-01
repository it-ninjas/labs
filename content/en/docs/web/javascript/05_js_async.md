---
title: "Asynchrone Anfragen"
type: docs
linkTitle: "Asynchrone Anfragen"
weight: 5
date: 2022-04-19
description: >
  Webrequest mit JavaScript.
---

## Webanfrage mit JavaScript
Wenn du eine Webanwendung schreibst, dann muss deine Website (=Frontend) wahrscheinlich Daten von (d)einem Backend abfragen.

In den meisten Fällen werden hierfür HTTP-Requests verwendet, die du bereits kennengelernt hast (REST API bei Spring und HTML Forms).

Um das einmal auszuprobieren, wollen wir eine API anfragen, die als Antwort zufällige "Fakten" über Chuck Norris zurückschickt. Wenn wir diese URL im Browser aufrufen (= HTTP GET), erhalten wir einen Witz in Form von JSON:

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

Folglich interessiert uns der Wert für `"value"`.

Damit für dich das Vorgehen verständlicher ist, führen wir Schritt für Schritt in der Browser-Konsole aus.

Die Abfrage kannst du wie folgt durchführen:
```javascript
fetch('https://api.chucknorris.io/jokes/random', {method: 'get'})
```
Du wirst sehen, dass dieser Funktionsaufruf ein `Promise {<pending>}` zurückgibt. Wir sehen, dass die Anfrage noch nicht vorbei ist (pending = anstehend). Dieses `Promise`-Objekt wird die Antwort enthalten, sobald die Antwort verfügbar ist. Da wir sowieso erst weiterfahren möchten, wenn die Antwort bereit ist, interessieren wir uns  nicht für das `Promise`. Daher können wir einfach mit der Fortsetzung des Scriptes solange warten, bis wir die Antwort hätten. Das können wir wie folgt machen:

```javascript
await fetch('https://api.chucknorris.io/jokes/random', {method: 'get'})
```

Das `await` führt dazu, dass das Script erst weitergeht, wenn die Antwort da ist. Zusätzlich wird die Antwort automatisch aus dem `Promise`-Objekt entpackt und wir erhalten so direkt ein Objekt vom Typ `Response`.

Theoretisch haben wir nun die Daten, die wir wollen. Da wir als Antwort ein JSON-Objekt als Antwort erwarten, können wir direkt die Antwort als JavaScript-Objekt anfordern:

```javascript
let response = await fetch('https://api.chucknorris.io/jokes/random', {method: 'get'});

response.json();
```

Komischerweise erhalten wir wieder ein `Promise {<pending>}`. Was müssen wir machen, um das JSON aus diesem Promise zu kriegen?

Genau: Wir müssen es `await`en:
```javascript
let response = await fetch('https://api.chucknorris.io/jokes/random', {method: 'get'});

let jokeObject = await response.json()
```
Dies ist notwendig, da die Methode [json()](https://developer.mozilla.org/en-US/docs/Web/API/Response/json) asynchron den response Stream ausliest. 

Wenn du nun das `jokeObject` loggst (z.B. mit `console.log(jokeObject)`), siehst du, dass wir nun das gleiche Objekt, das wir ganz oben erwartet haben, erhalten haben.

Den Witz kannst du wie folgt ausgeben:
```javascript
console.log(jokeObject.value);
```

### Anfrage in eine Funktion einbinden
Im Normalfall packt man solche Logik in eine Funktion. Den oberen Code könntest du wie folgt in eine Methode einbinden:

```javascript
/** 
 * Requests a random Chuck Norris joke and returns it.
 * @return {Promise<string>} a random Chuck Norris joke.
*/
async function fetchJoke() {
    const response = await fetch('https://api.chucknorris.io/jokes/random', { method: 'get' })
    const jokeObject = await response.json();

    return jokeObject.value;
}
```

Dir ist sicher aufgefallen, dass wir nun das `async`-Keyword vor `function` geschrieben haben. Dies ist erforderlich, wenn man `await` in einer Funktion verwenden möchte. Dieses `async`-Keyword führt auch dazu, dass die Methode ein Objekt des Typen `Promise<...>` zurückgibt.

Wenn du diese Funktion definiert hast, kannst du den Rückgabewert von ihr wie folgt loggen:
```javascript
console.log(await fetchJoke());
```

### await umgehen
Du wirst in die Situation kommen, wo du eine Antwort auf eine asynchrone Anfrage erhälst, aber kein `await` brauchen darfst, weil du dich nicht in einer mit `async` gekennzeichneten Funktion befindest.

Statt ein Promise zu awaiten, kannst du auch definieren, dass eine bestimmte Aktion durchgeführt werden soll, sobald die Antwort da ist. Dies kannst du mit `Promise.then(...)` machen:

```javascript
fetchJoke().then(function(joke) {
    console.log(joke);
});
```

Das kannst du auch schöner schreiben, funktioniert so aber nicht mehr im Internet Explorer:
```javascript
fetchJoke().then(joke => console.log(joke));
```

Was genau haben wir hier gemacht?

Wir haben `fetchJoke()` asynchron aufgerufen, ohne auf die Antwort zu warten. Deswegen erhalten wir ein Promise-Objekt. Promise-Objekte enthalten eine `then`-Methode. Bei dieser Methode kannst du eine Funktion übergeben. Die übergebene Funktion wird aufgerufen, sobald die Antwort erhalten wurde.

![asset](/images/hint.png) Hierzu findest du [zwei Aufgaben im Lab](../../../../labs/web/html_css/03_javascript).

### Früher war alles besser?
Die `fetch`-Funktion hat Webrequest stark vereinfacht. Früher durftest du dich mit XML HTTP Requests herumschlagen. Aber siehe selbst: https://www.w3schools.com/xml/xml_http.asp 