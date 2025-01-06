---
title: "NgRx Selectors"
type: docs
linkTitle: "NgRx Selectors"
weight: 4
date: 2023-05-26
description: >
  Modul #F7 - Angular NgRx - Selectors
---

## Ziele

- Du weisst, was NgRx Selectors sind und kannst diese anwenden.
- Du weisst, was das AppState ist.

## AppState

In einer typischen NgRx-Anwendung kann die AppState-Datei verwendet werden, um den gesamten Anwendungsstatus zu definieren und zu typisieren. Sie enthält normalerweise eine Schnittstelle oder ein Interface, das alle Teilzustände oder Slices des Anwendungsstatus definiert und zu einem Gesamtzustand kombiniert.
Dies findet man im `index.ts` und kann sie dort erweitern.

```typescript
export interface AbilityState {
  abilities: string[];
}

export interface AppState {
  ability: AbilityState;
}
```

## NgRx Selectors

Selectors sind Funktionen, die dazu dienen, bestimmte Teile des Zustands aus dem Store abzurufen. Sie ermöglichen es, den Zustand zu filtern, zu transformieren und zu kombinieren, um spezifische Daten abzurufen, die von den Components verwendet werden.

In unserem Beispiel vereinfachen wir das Beispiel aus den Actions da man dort nur mühsam zu den `abilities` gekommen ist.

```typescript
import { createSelector } from "@ngrx/store";
import { AppState } from "../reducer/index.ts";

export const selectAbilityState = (state: AppState) => state.ability;

export const getAbilities = createSelector(
  selectAbilityState,
  (state) => state.abilities,
);
```

```typescript
import { Component, OnInit } from "@angular/core";
import { Store, select } from "@ngrx/store";
import { addAbility, deleteAbility } from "src/app/actions/ability.actions";
import { AppState } from "src/app/reducer/index.ts";
import { getAbilities } from "src/app/selectors/ability.selectors";

@Component({
  // ..
})
export class AbilityComponent implements OnInit {
  abilities$: Observable<string[]> = new Observable<string[]>();

  private store = inject(Store<{ ability: { abilities: string[] } }>);

  constructor() {}

  ngOnInit(): void {
    this.abilities$ = this.store.select(getAbilities);
  }

  // ..
}
```
