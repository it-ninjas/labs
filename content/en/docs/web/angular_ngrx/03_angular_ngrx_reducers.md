---
title: "NgRx Reducers"
type: docs
linkTitle: "NgRx Reducers"
weight: 3
date: 2023-05-26
description: >
  Modul #F7 - Angular NgRx - Reducers sind
---
## Ziele
* Du weisst, was NgRx Reducers sind und kannst diese anwenden.
* Du weisst, wie und warum die Reducers beim Root registriert werden.

## NgRx Reducers
Reducers sind Funktionen in NgRx, die den aktuellen Zustand des Stores und eine Action als Parameter entgegennehmen und den neuen Zustand des Stores zurückgeben. Sie sind dafür verantwortlich, den Zustand basierend auf den eingehenden Aktionen zu aktualisieren.

Reducers in NgRx folgen dem Redux-Muster und sollten immer eine rein funktionale Programmierung befolgen. Das bedeutet, dass sie den aktuellen Zustand nicht verändern, sondern einen neuen Zustand erstellen und zurückgeben.

Für jeden State, der in der Applikation verwendet werden soll, wird ein Interface erstellt. Diese Interfaces werden dazu verwendet mindestens einen weiteren State zu definieren, nämlich den Initialen State. Mit dem Initialen State wird vermieden, dass der State `undefined` sein kann.

Da meistens mehrere Actions vorhanden sind, müssen diese auch unterschieden werden. Dazu ist die `on`-Funktion da, diese kann einen Fallunterschied zwischen den Actions erstellen. Durch die Verwendung der props in den Action-Creator-Funktionen kann man die relevanten Daten an die Reducer-Funktion übergeben und im Reducer-Zustand verwenden.

Seit Angular 17 ist es so das es ein `index.ts`, innerhalb des reducer-Ordner gibt. In diese werden alle Reducers registriert, damit diese dann in die `app.config.ts` exportiert werden können. Es dient der neuen Struktur, welche für eine besser Übersicht sorgen soll.
```typescript
// index.ts

import { isDevMode } from '@angular/core';
import {
  ActionReducerMap,
  MetaReducer
} from '@ngrx/store';
import {abilityReducer} from "./abilityReducer.reducer";

export interface AbilityState {
    abilities: string[]
}

export interface AppState {
    ability: AbilityState;
}

export const reducers: ActionReducerMap<AppState> = {
    ability: abilityReducer,
};

export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [] : [];
```

```typescript
// abilityReducer.reducer.ts

import { createReducer, on } from '@ngrx/store';
import { addAbility, deleteAbility, getAbilities } from '../actions/ability.actions';
import { AbilityState } from "../reducer/index.ts";


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

## Reducers Registrieren
**Wichtig:** die Reducers müssen im `index.ts` in der Konstante `export const reducers` angegeben werden. Diese Konstante wird dann wie bereits erwähnt im `app.config.ts` innerhalb der Rundenklammern des `provideStore()` angegeben.

