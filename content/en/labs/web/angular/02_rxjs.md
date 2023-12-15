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
## Aufgabe 1
![task1](/images/task.png) - Einzelarbeit

Erstelle eine Website, welche anhand von Observables eine Browsernotification ausgibt.
Dazu soll sich auf der Website ein Button befinden, welcher das Event auslöst, um die Notification im Browser anzuzeigen.

Vorgehen:
Lade die [Datei](/files/exams/angular/uebung1.html) herunter und öffne sie in VS Code. (Wenn sie im Browser geöffnet ist, mittels rechtsklick und dann "Speichern unter".) 
Die Datei enthält lediglich das Grundgerüst der Übung, füge an den auskommentierten Stellen den entsprechenden Code ein.
Am Grundgerüst der Datei soll nichts verändert werden.

![asset](/images/hint.png)    
Damit die Notifications fehlerfrei funktionieren, muss die Extension "Live Server" in VS Code hinzugefügt und angewendet werden.


## Aufgabe 2
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


## Aufgabe 3
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
