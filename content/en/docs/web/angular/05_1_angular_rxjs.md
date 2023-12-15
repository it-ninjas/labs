---
title: "RxJS"
type: docs
linkTitle: "RxJS"
weight: 24
date: 2023-04-20
description: >
  RxJS Übersicht
---
## Ziele
* Du weisst, was RxJS ist und welches Konzept es besitzt.
* Du kennst, Observable, Observer und Subscription und kannst diese anwenden.

## RxJS
RxJS (Reactive Extensions for JavaScript) ist eine Library für funktionale, reaktive Programmierung in JavaScript. Das Konzept von RxJS basiert auf der Idee, dass alles in der Welt um uns herum ständig Veränderungen unterworfen ist und dass wir diese Veränderungen durch die Verarbeitung von Ereignissen und Strömen von Daten verwalten können.

RxJS bietet eine Reihe von Tools und Operatoren, mit denen man Ereignisse und Ströme von Daten auf eine reaktive und deklarative Weise verarbeiten kann. Dabei wird der Fokus auf die Verarbeitung der Daten selbst gelegt, anstatt auf den Ablauf des Codes.

RxJS bietet verschiedene Arten von Observables und Subjects an, um Daten innerhalb deiner Anwendung zu verwalten und zu teilen. Diese können verwendet werden, um Daten zwischen verschiedenen Komponenten zu übertragen oder um globale Ereignisse zu verwalten.

## Konzept
Das zentrale Konzept von RxJS ist das Observable-Pattern. Ein Observable ist eine Art von Datenstrom, der Ereignisse oder Werte über einen Zeitraum hinweg ausgibt. Ein Observable kann auf Ereignisse wie Benutzerinteraktionen, Datenbankabfragen, API-Aufrufe und mehr reagieren und diese verarbeiten.

Mit RxJS kannst du Observable-Ströme transformieren, filtern, kombinieren und verwalten, indem du eine Kette von Operatoren auf die Observable anwendest. Das Ergebnis dieser Verarbeitung ist ein neuer Observable-Strom, der die transformierten Daten oder Ereignisse ausgibt.

## Installation
Um RxJS in ein Angular-Projekt zu installieren, kann man die folgenden Schritte ausführen:
1. Sicherstelle, dass Node.js und npm (Node Package Manager) auf dem Computer installiert ist. (Kann mit `npm -v`erledigt werden.)
2. Nun ein Terminal öffnen oder eine andere Shell und navigiere zum Hauptverzeichnis des Projekts.
3. Folgenden Befehl ausführen, um NgRx zu installieren:
```shell
npm install rxjs
```

## Observables
Wie schon ein wenig erwähnt ist ein Observable eine Art von Datenstrom, der Werte oder Ereignisse asynchron und über einen bestimmten Zeitraum hinweg ausgibt. Ein Observable kann auf Ereignisse wie Benutzerinteraktionen, Datenbankabfragen, API-Aufrufe und mehr reagieren und diese verarbeiten.

Ein Observable ist im Grunde genommen eine Funktion, die einen Datenstrom definiert und zurückgibt. Diese Funktion kann dann durch verschiedene Operatoren transformiert werden, um den Datenstrom auf verschiedene Weise zu bearbeiten.

Beispiel für ein Observable zu erstellen:
```typescript
import { Observable } from 'rxjs';

const myObservable$ = new Observable((observer) => {
    // einiger Wert des Observable
    // mit next() wird der Wert an die Subscriber gesendet
    observer.next('Hello Dragon Warrior!');
    
    // schliesst das Observable ab
    observer.complete();
});
```

## Observer
In RxJS ist ein Observer ein Objekt, das eine Funktion oder eine Reihe von Funktionen definiert, um auf Werte oder Ereignisse zu reagieren, die von einem Observable ausgegeben werden. Ein Observer wird in der Regel beim Subscriben eines Observables verwendet, um die ausgegebenen Werte zu verarbeiten.

Ein Observer-Objekt in RxJS muss mindestens eine der folgenden Funktionen implementieren:
* `next(value: T)`: Wird aufgerufen, wenn ein neuer Wert von einem Observable ausgegeben wird. Der Parameter value enthält den ausgegebenen Wert. 
* `error(error: any)`: Wird aufgerufen, wenn ein Fehler bei der Ausgabe eines Wertes auftritt. Der Parameter error enthält den Fehler. 
* `complete()`: Wird aufgerufen, wenn das Observable abgeschlossen ist und keine weiteren Werte ausgegeben werden.

Ein Observer wird normalerweise durch eine `subscribe` Methode an das Observable angehängt, um den Output des Observables zu empfangen.

```typescript
import { Observable } from 'rxjs';

const myObservable$ = new Observable((observer) => {
    observer.next('Hello Dragon Warrior!');
    observer.complete();
});

const myObserver = {
    next: (value) => console.log(value),
    error: (error) => console.error(error),
    complete: () => console.log('Observable completed'),
};

myObservable$.subscribe(myObserver);
```

Es ist möglich, einen Observer als Callback (Subscription) zu verwenden. Dies ist die gängigste Verwendungsmöglichkeit von Observers.
```typescript
import { Observable } from 'rxjs';

const myObservable$ = new Observable((observer) => {
    observer.next('Hello Dragon Warrior!');
    observer.complete();
});

myObservable$.subscribe(
    (value) => console.log('Received value:', value),
    (error) => console.error('Error:', error),
    () => console.log('Completed')
);
```

Es ist wichtig zu beachten, dass jede dieser Funktionen optional ist und weggelassen werden kann, wenn sie nicht benötigt wird.
```typescript
import { Observable } from 'rxjs';

const myObservable$ = new Observable((observer) => {
    observer.next('Hello Dragon Warrior!');
});

myObservable$.subscribe((value) => {
    console.log(value);
});
```

## Subscription
Eine Subscription kann durch die `subscribe` Methode auf einem Observable erstellt werden. Wenn eine Subscription erstellt wird, wird eine Verbindung zwischen dem Observable und dem Observer hergestellt und der Datenfluss wird gestartet. Die Subscription gibt ein Objekt zurück, das eine Methode `unsubscribe` enthält. Diese Methode kann aufgerufen werden, um die Subscription zu beenden und den Datenfluss zu stoppen.
Sie wird verwendet um den Datenfluss kontrollieren und den Speicherbedarf reduzieren, indem man ungenutzte Datenströme stoppt.

In dem folgenden Beispiel ist `mySubscription` die Subscription, diese wird erstellt durch `myObservable.subscribe`.

```typescript
import { Observable } from 'rxjs';

const myObservable$ = new Observable((observer) => {
    observer.next('Hello Dragon Warrior!');
    observer.complete();
});

const mySubscription = myObservable$.subscribe(
    (value) => {
        console.log('Received value:', value);
    },
    (error) => {
        console.log('Error:', error);
    },
    () => {
        console.log('Observable completed.');
    }
);

mySubscription.unsubscribe();
```

