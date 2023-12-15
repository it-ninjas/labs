---
title: "NgRx Reducers"
type: docs
linkTitle: "NgRx Reducers"
weight: 29
date: 2023-05-26
description: >
  Hier findet man was NgRx Reducers sind.
---
## Ziele
* Du weisst, was NgRx Reducers sind und kannst diese anwenden.
* Du weisst, wie und warum die Reducers beim Root registriert werden.

## NgRx Reducers
Reducers sind Funktionen in NgRx, die den aktuellen Zustand des Stores und eine Action als Parameter entgegennehmen und den neuen Zustand des Stores zurückgeben. Sie sind dafür verantwortlich, den Zustand basierend auf den eingehenden Aktionen zu aktualisieren.

Reducers in NgRx folgen dem Redux-Muster und sollten immer eine rein funktionale Programmierung befolgen. Das bedeutet, dass sie den aktuellen Zustand nicht verändern, sondern einen neuen Zustand erstellen und zurückgeben.

Für jeden State, der in der Applikation verwendet werden soll, wird ein Interface erstellt. Diese Interfaces werden dazu verwendet mindestens einen weiteren State zu definieren, nämlich den Initialen State. Mit dem Initialen State wird vermieden, dass der State `undefined` sein kann.

Da meistens mehrere Actions vorhanden sind, müssen diese auch unterschieden werden. Dazu ist die `on`-Funktion da, diese kann einen Fallunterschied zwischen den Actions erstellen. Durch die Verwendung der props in den Action-Creator-Funktionen kann man die relevanten Daten an die Reducer-Funktion übergeben und im Reducer-Zustand verwenden.


```typescript
import { createReducer, on } from '@ngrx/store';
import { addAbility, deleteAbility, getAbilities } from '../actions/ability.actions';

export interface AbilityState {
    abilities: string[]
}

export const initialState: AbilityState = {
    abilities: [],
};

export const abilityReducer = createReducer(
    initialState,
    on(getAbilities, (state) => state),
    on(addAbility, (state, { ability }) => ({ ...state, abilities: [...state.abilities, ability] })),
    on(deleteAbility, (state, { ability }) => ({
        ...state,
        abilities: state.abilities.filter((existingAbility) => existingAbility !== ability),
    }))
);
```

## Root State Registrieren
Der State muss registriert werden, damit er im NgRx Store verwaltet und von den Komponenten deiner Angular-Anwendung genutzt werden kann.

Besitzt man nur einen Reducer in der Anwendung so kann man diesen einfach im `app.module.ts` angeben.

**Wichtig** ist das der Key im `forRoot()` gleich ist wie der Key vom Reducername (z.B. auth: authReducer oder userProfile: userProfileReducer).

```typescript
import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';

@NgModule({
    // ..
    imports: [
        StoreModule.forRoot({ ability: abilityReducer })
        // ..
    ],
    // ..
})
export class AppModule {}
```

Wenn man mehr als einen Reducer besitzt, muss man eine Root-Reducer erstellen. Dieser kombiniert alle Reducer und definiert den Gesamtzustand einer Anwendung.
Durch die Registrierung des States im `app.module.ts` mit `StoreModule.forRoot(rootReducer)` wird der Root-Reducer als zentrale Instanz für das Verwalten des Zustands festgelegt.

```typescript
import { ActionReducerMap } from '@ngrx/store';
import { AppState } from './app-state';
import { reducer1 } from './reducer1';
import { reducer2 } from './reducer2';

export const rootReducer: ActionReducerMap<AppState> = {
    prop1: reducer1, 
    prop2: reducer2, 
    // Weitere Reducer für andere Zustandseigenschaften
};
```
```typescript
import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';
import { rootReducer } from './reducers'; // Hier muss man den Root-Reducer importieren

@NgModule({
    imports: [
        StoreModule.forRoot({ root: rootReducer })
        // ..
    ],
    // ..
})
export class AppModule {}
```
