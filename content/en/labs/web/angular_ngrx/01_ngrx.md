---
title: "(Zusatz) NgRx Labs"
type: docs
linkTitle: "(Zusatz) NgRx Labs"
weight: 3
date: 2023-05-26
description: >
  Ein paar zusätzliche/optionale Aufgaben zu NgRx.
---
# Aufgaben
## Aufgabe 1
Als Beispiel zur Verwendung von NgRx, setzen wir ein neues Angular-projekt auf und schreiben eine Anwendung mit einem Counter, der Inkrementier, Dekrementiert und Resettet werden kann.

### Einrichten
Als Erstes muss man ein neues Angular Projekt [aufsetzen](../../../../docs/web/angular/03_1_ts_einführung_angular#angular-projekt-aufsetzen).

Danach NgRx [installieren](../../../../docs/web/angular/08_1_ts_ngrx#installation).

Nun erstellt man der Übersicht halber noch zwei Ordner names actions und reducers. Darin werden dann alle Actions und Reducer erstellt.

### Actions erstellen
Als Erstes werden die Actions definiert, welche man alle für dieses Projekt benötigt. Wie bei der Einleitung erwähnt sind das Inkrementieren, Dekrementieren und Resetten. Dazu erstellt man nun ein neues Typescript File namens `counter.actions.ts`.
Lagere die Action Types in ein Enum aus.

Versuche selbständig auf eine Lösung zu kommen, bevor du dir die Lösung anschaust.

<details>
<summary>Lösung (click to expand)</summary>

```typescript
export enum ActionTypes {
    INCREMENT = '[Counter Component] Increment',
    DECREMENT = '[Counter Component] Decrement', 
    RESET= '[Counter Component] Reset'
}
```
```typescript
import { createAction } from '@ngrx/store';

export const increment = createAction(ActionTypes.INCREMENT);
export const decrement = createAction(ActionTypes.DECREMENT);
export const reset = createAction(ActionTypes.RESET);
```
</details>

### Reducer erstellen
Nun muss man eine Reducer-Funktion definieren, um Änderungen im Zählerwert basierend auf den bereitgestellten Aktionen zu verarbeiten. Erstelle dazu ein neues Typescript File namens `counter.reducer.ts` und setze die Funktion darin um.

Versuche selbständig auf eine Lösung zu kommen, bevor du dir die Lösung anschaust.

<details>
<summary>Lösung (click to expand)</summary>

```typescript
import { createReducer, on } from '@ngrx/store';
import { increment, decrement, reset } from './counter.actions';

export const initialState = 0;

export const counterReducer = createReducer(
    initialState,
    on(increment, (state) => state + 1),
    on(decrement, (state) => state - 1),
    on(reset, (state) => 0)
);
```
</details>

### Component erstellen
Erstelle mittels ng-Befehl einen neuen Component namens `my-counter` innerhalb des app-Ordners. Das HTML soll einen Titel besitzen, drei Buttons für jede Actions und eine Anzeige für den aktuellen Counter.
Im Typescript soll für jeden Button eine Methode erstellt werden, zudem ein Observable welches den aktuellen Count beinhaltet. Das Observable soll mit dem Wert des Stores verbunden sein.

Versuche selbständig auf eine Lösung zu kommen, bevor du dir die Lösung anschaust.

<details>
<summary>Lösung (click to expand)</summary>

```typescript
import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { increment, decrement, reset } from '../counter.actions';

@Component({
    selector: 'app-my-counter',
    templateUrl: './my-counter.component.html',
})
export class MyCounterComponent {
    count$: Observable<number>;

    constructor(private store: Store<{ count: number }>) {
        this.count$ = store.select('count');
    }

    increment() {
        this.store.dispatch(increment());
    }

    decrement() {
        this.store.dispatch(decrement());
    }

    reset() {
        this.store.dispatch(reset());
    }
}
```
```html
<button (click)="increment()">Increment</button>

<div>Current Count: {{ count$ | async }}</div>

<button (click)="decrement()">Decrement</button>

<button (click)="reset()">Reset Counter</button>

```
</details>

### AppModule anpassen
Das `app.module.ts` muss nun noch mit dem Store und Reducer ergänzt werden.

Versuche selbständig auf eine Lösung zu kommen, bevor du dir die Lösung anschaust.

<details>
<summary>Lösung (click to expand)</summary>

```typescript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { StoreModule } from '@ngrx/store';
import { counterReducer } from './counter.reducer';
import { MyCounterComponent } from './my-counter/my-counter.component';

@NgModule({
    declarations: [AppComponent, MyCounterComponent],
    imports: [BrowserModule, StoreModule.forRoot({ count: counterReducer })],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
```
</details>

### Im AppComponent anzeigen 
Der neue Component soll nun mit dem `app.component.html` verknüpft werden, sodass der Inhalt des Components sichtbar wird.

Versuche selbständig auf eine Lösung zu kommen, bevor du dir die Lösung anschaust.

<details>
<summary>Lösung (click to expand)</summary>

```html
<h1>NgRx Tutorial</h1>

<app-my-counter></app-my-counter>
```
</details>

## Aufgabe 2
Entwickle eine Angular-Anwendung für einen Online-Shop mit den folgenden Funktionen und Components: Produktübersicht und Warenkorb. Die Produktdaten sollen als Mockdaten in einem Service gespeichert werden. Implementiere Routing, um zwischen den verschiedenen Ansichten zu navigieren.

### Produkt Attribute
* Name
* Preis

### Produktübersicht
* Erstelle eine Seite für die Produktübersicht, auf der alle Produkte angezeigt werden.
* Rufe die Produktdaten aus einem Mock-Datenservice ab und zeige sie an.
* Implementiere zu jedem Produkt einen Button für das Hinzufügen von Produkten in den Warenkorb.

### Warenkorb:
* Erstelle eine Seite, auf der die Produkte im Warenkorb angezeigt werden.
* Verwende NgRx, um den Warenkorbzustand zu verwalten. Definiere Aktionen zum Hinzufügen und Entfernen von Produkten in den Warenkorb. (Verwende Selektoren, um den Zugriff auf den NgRx-Store zu erleichtern.))
* Zeige eine Liste der ausgewählten Produkte im Warenkorb an, inklusive Name und Preis.
* Implementiere einen Button für das Löschen von Produkten aus dem Warenkorb.
* Füge eine Bestellfunktion hinzu, um den Kaufprozess abzuschliessen (kann eine einfache Bestätigungsnachricht sein).

## Aufgabe 3
Erstelle eine Angular-Anwendung für eine TODO-Liste, die das NgRx-Modul verwendet, um den Zustand der Aufgaben zu verwalten. Die Anwendung sollte die folgenden Funktionen enthalten:

### Task Attribute
* ID
* Name
* Completed

### Übersicht
* Erstelle eine Seite, auf der die offene (Completed = false) Task (einfach der Name) angezeigt werden. (Verwende Selektoren, um den Zugriff auf die Tasks im NgRx-Store zu erleichtern.)
* Verwende NgRx, um den Taskzustand zu verwalten. Definiere Aktionen zum Hinzufügen, Entfernen und Complete von Tasks.
* Implementiere zu jedem Task einen Button für das Complete und Entfernen von Tasks.

### Taskerstellungs-Seite
* Erstelle auf der Seite eine Unterseite, auf der neue Task erfasst werden können. (Für die Id zu erstellen am einfachsten `new Date().getTime()` nehmen)
* Der Name des Tasks soll mittels Reactive Forms eingetragen werden.
* completed ist immer auf `false` bei 2einem neuen Task.

