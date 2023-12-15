---
title: "RxJS Subjects"
type: docs
linkTitle: "RxJS Subjects"
weight: 25
date: 2023-04-21
description: >
  RxJS Subjects
---
## Ziele
* Du weisst, was RxJS-Subjects sind.
* Du kennst, die vier Arten von Subjects und kannst diese erläutern und anwenden.

RxJS-Subjects sind spezielle Arten von Observables, die sowohl als Observables als auch als Observer fungieren können. Mit anderen Worten, sie ermöglichen das Senden und Empfangen von Werten und Ereignissen und das Weiterleiten dieser Werte und Ereignisse an andere Observable-Subscriber.

Es gibt vier Arten von Subjects:
* `Subject`: Ein einfacher Subject, das die neuesten Werte an seine Abonnenten weiterleitet.
* `BehaviorSubject`: Ein Subject, das den letzten Wert beibehält, der an ihn gesendet wurde, und ihn an jeden neuen Abonnenten sofort weitergibt.
* `ReplaySubject`: Ein Subject, das alle Werte an seine neuen Abonnenten weiterleitet, unabhängig davon, wann sie das Abonnement starten.
* `AsyncSubject`: Ein Subject, das nur den letzten Wert weiterleitet, wenn es vollständig abgeschlossen ist.

Subjects sind besonders nützlich, wenn du eine zentrale Stelle benötigst, um Daten innerhalb deiner Anwendung zu verwalten und zu teilen. Zum Beispiel könntest du ein Subject verwenden, um Benutzerinteraktionen zu verfolgen und diese Daten an verschiedene Komponenten deiner Anwendung weiterzuleiten, um sie zu aktualisieren oder anzuzeigen.

## Subject
Das `Subject` speichert keine Werte, die vor der Registrierung/Abonnierung (Subscription) der Observer gesendet wurden. Wenn ein Observer sich später registriert, empfängt er nur die Werte, die nach seiner Registrierung/Abonnierung gesendet wurden.

Es ist zu beachten, dass die Observer in der Reihenfolge registriert werden, in der sie `subscribe` aufrufen.

```typescript
import { Subject } from 'rxjs';

const mySubject = new Subject();

mySubject.subscribe((value) => {
  console.log('Observer 1 received value:', value);
});

mySubject.next('Hello Dragon Warrior!');

mySubject.subscribe((value) => {
  console.log('Observer 2 received value:', value);
});

mySubject.next('Another value');

// Observer 1 received value: Hello Dragon Warrior!
// Observer 1 received value: Another value
// Observer 2 received value: Another value
```

## BehaviorSubject
Im Gegensatz zum normalen `Subject` speichert das `BehaviorSubject` den letzten gesendeten Wert, sodass er ihn an neue Observer weitergeben kann. Wenn keine Werte zuvor gesendet wurden, gibt das `BehaviorSubject` den initialen Wert zurück, der ihm während der Initialisierung zugewiesen wurde.

Ein `BehaviorSubject` kann nützlich sein, wenn man einen Wert benötigt, auf den man jederzeit zugreifen kann, auch wenn es keine neuen Ereignisse gibt.

```typescript
import { BehaviorSubject } from 'rxjs';

const myBehaviorSubject = new BehaviorSubject('initial value');

myBehaviorSubject.subscribe((value) => {
  console.log('Observer 1 received value:', value);
});

mySubject.next('Hello Dragon Warrior!');

myBehaviorSubject.subscribe((value) => {
  console.log('Observer 2 received value:', value);
});

myBehaviorSubject.next('Another value');

// Observer 1 received value: initial value
// Observer 1 received value: Hello Dragon Warrior!
// Observer 2 received value: Hello Dragon Warrior!
// Observer 1 received value: Another value
// Observer 2 received value: Another value
```

## ReplaySubject
Im Gegensatz zum `BehaviorSubject`, welches nur den letzten Wert speichert, speichert das `ReplaySubject` eine definierte Anzahl von Werten, die es an neue Observer weitergibt. Wenn ein neuer Observer sich beim `ReplaySubject` registriert, erhält er die gespeicherten Werte in der Reihenfolge, in der sie gesendet wurden, bevor er auf zukünftige Werte wartet.

Ein `ReplaySubject` kann nützlich sein, wenn man eine feste Anzahl von Werten benötigen, auf die man jederzeit zugreifen kann, auch wenn es keine neuen Ereignisse gibt.

Zu beachten ist, dass die Größe des `ReplaySubject` bei der Initialisierung angegeben wird und die maximale Anzahl der gespeicherten Werte definiert. Wenn mehr Werte gesendet werden, als die Größe des `ReplaySubject` zulässt, werden ältere Werte entfernt.

```typescript
import { ReplaySubject } from 'rxjs';

const myReplaySubject = new ReplaySubject(2);

myReplaySubject.next('Value 1');
myReplaySubject.next('Value 2');
myReplaySubject.next('Value 3');

myReplaySubject.subscribe((value) => {
  console.log('Observer 1 received value:', value);
});

myReplaySubject.next('Value 4');

myReplaySubject.subscribe((value) => {
  console.log('Observer 2 received value:', value);
});

// Observer 1 received value: Value 2
// Observer 1 received value: Value 3
// Observer 1 received value: Value 4
// Observer 2 received value: Value 3
// Observer 2 received value: Value 4
```

## AsyncSubject
Im Gegensatz zu anderen Typen von Subjects speichert das `AsyncSubject` nur den letzten Wert, der von einem Observable gesendet wird, wenn das Observable vollständig abgeschlossen (`complete()`) ist, selbst wenn die `next()` Methode aufgerufen wurde. Wurde das Observable vollständig abgeschlossen, wird der letzte Wert an alle Observer weitergegeben, die auf das `AsyncSubject` subscriben. Ansonsten wird der letzte Wert nicht weitergegeben.

```typescript
import { AsyncSubject } from 'rxjs';

const myAsyncSubject = new AsyncSubject();

myAsyncSubject.subscribe((value) => {
  console.log('Observer 1 received value:', value);
});

myAsyncSubject.next('Value 1');
myAsyncSubject.next('Value 2');

myAsyncSubject.subscribe((value) => {
  console.log('Observer 2 received value:', value);
});

myAsyncSubject.next('Value 3');
myAsyncSubject.complete();

myAsyncSubject.subscribe((value) => {
  console.log('Observer 3 received value:', value);
});
// Observer 1 received value: Value 3
// Observer 2 received value: Value 3
// Observer 3 received value: Value 3
```