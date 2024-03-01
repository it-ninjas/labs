---
title: "Labs zu RxJS"
type: docs
linkTitle: "RxJS Labs"
weight: 2
date: 2023-05-04
description: >
    Aufgaben zu Observales und RxJS.
---
# Aufgaben

[//]: # (## Aufgabe 1)

[//]: # (![task1]&#40;/images/task.png&#41; - Einzelarbeit)

[//]: # ()
[//]: # (Erstelle eine Website, welche anhand von Observables eine Browsernotification ausgibt.)

[//]: # (Dazu soll sich auf der Website ein Button befinden, welcher das Event auslöst, um die Notification im Browser anzuzeigen.)

[//]: # ()
[//]: # (Vorgehen:)

[//]: # (Lade die [Datei]&#40;/files/exams/angular/uebung1.html&#41; herunter und öffne sie in VS Code. &#40;Wenn sie im Browser geöffnet ist, mittels rechtsklick und dann "Speichern unter".&#41; )

[//]: # (Die Datei enthält lediglich das Grundgerüst der Übung, füge an den auskommentierten Stellen den entsprechenden Code ein.)

[//]: # (Am Grundgerüst der Datei soll nichts verändert werden.)

[//]: # ()
[//]: # (![asset]&#40;/images/hint.png&#41;)

[//]: # (Damit die Notifications fehlerfrei funktionieren, muss die Extension "Live Server" in VS Code hinzugefügt und angewendet werden.)

[//]: # ()
[//]: # ([//]: # &#40;TODO: datei ersetzen mit collapsable&#41;)

## Aufgabe 1
Im folgenden Code befindet sich eine Funktion für das Erhalten einer zufälligen Zahl zwischen dem min und max. Zudem befindet sich bereits ein Observable im Code, welches in zufälligen Intervallen einen Wert zurückgeben soll.

Die Aufgabe ist nun das Observable so anzupassen, dass in der Subscription jeweils in zufälligen Abständen ein Wert zurückgegeben wird.

```typescript
import { Observable } from "rxjs";

function getRandomInterval(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Observable
const intervalObservable = new Observable<number>();

// subcription
intervalObservable.subscribe((interval) => {
  console.log(`Interval: ${interval}ms`);
});
```


## Aufgabe 2
Auch bei dieser Aufgabe ist bereits ein wenig Code schon gegeben. Und zwar erneut eine Funktion zum Erhalten einer zufälligen Zahl für die Celsiusgrade.
Auch das Observable ist hier bereits gegeben, dieses emitted alle zwei Sekunden eine neue Random Celsiusgrad Zahl.

Die Aufgabe ist nun beim subscriben auf das Observable, die kommende Celsius Zahl in Fahreinheiten umzuwandeln und dann beide zu loggen.

```typescript
import { Observable } from "rxjs";

function getRandomDegree(min: number, max: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const temperatureInC = new Observable<number>((subscriber) => {
  setInterval(() => {
    subscriber.next(getRandomDegree(0, 45));
  }, 2000);
});

temperatureInC.subscribe((celsius) => {
  console.log(`Celsius: ${celsius}`);
});
```

## Aufgabe 3
In den Docs wurden dir verschiedene Versionen von Subjects vorgestellt. Jede davon hat ihre speziellen Eigenschaften.
Diese sollst du in dieser Aufgabe vertiefen. In der nachfolgenden Vorlage befindet sich ein grober Aufbau, den du erweitern sollt.
Du sollst anhand dieser Vorlage eine Art Chat erstellen, der eine Nachricht an ein Subject schickt. Jede Nachricht soll ausserdem einen Zeitstempel haben.
Ziel ist es, dass du alle bekannten Subjects verwendest. Schlussendlich soll jeweils die Ausgabe der Subjects im `<div class="output">` zu sehen sein.
Schreibe dazu die benötigten Funktionen `submit`, `addSubscriptions` und `complete`. 


{{% details title="Vorlage" %}}

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Subject Lab</title>
    <script src="https://unpkg.com/rxjs@6.2.0/bundles/rxjs.umd.min.js"></script>
    <script>
        function submit() {
            // TODO: Nachricht zu Subject senden
        }

        function addSubscriptions() {
            // TODO: Subscription starten
        }

        function complete() {
            // TODO: Subject complete
        }

    </script>
</head>
<body>
<div class="wrapper">
    <div class="actions">
        <input id="chat" type="text" placeholder="Please enter your message">
        <button id="submit">Send</button>
        <button id="add-subscriptions">Subscriptions</button>
        <button id="complete">Complete</button>
    </div>

    <div class="output">
        <!--        TODO: Für jeden Typ von Subject einen separaten Output-->
    </div>
</div>
</body>
</html>
```

{{% /details %}}
