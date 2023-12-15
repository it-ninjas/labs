---
title: "NgRx Actions"
type: docs
linkTitle: "NgRx Actions"
weight: 28
date: 2023-05-26
description: >
  Hier findet man was NgRx Actions sind.
---
## Ziele
* Du weisst, was NgRx Actions sind und kannst diese anwenden.

## NgRx Actions
Actions sind einfache JS-Objekte, die eine bestimmte Aktion beschreiben, die in einer Anwendung ausgeführt werden soll. Jede Action hat einen Typ und optional zusätzliche Daten.

Actions spielen eine zentrale Rolle in der Redux-Architektur und dienen als Auslöser für Zustandsänderungen im Store. Durch die Verwendung von Actions, kann man den Zustand der Anwendung eindeutig beschreiben und die Auswirkungen dieser Aktionen auf den Zustand zentral verwalten.

Die Action Typen werden meistens in einem Enum definiert, so hat man eine bessere Übersicht welche Actions die Anwendung besitzt. Die Typen werden in eckigen Klammern mit einem präfix, der den Kontext der Aktion angibt, geschrieben.

Hier ein Beispiel:
```typescript
export enum ActionTypes {
    GETABILITIES = '[Dragon Warrior] Get Abilities',
    ADDABILITY ='[Dragon Warrior] Add Ability',
    DELETEABILITY= '[Dragon Warrior] Delete Ability'
}
```

Als Nächstes muss man die Typen in einer Action-Creator-Funktion verwenden. Dazu muss diese Funktion zuerst erstellt werden. Mithilfe der `createAction`-Funktion aus dem `@ngrx/store`-Package kann man Action-Creator-Funktionen erstellen. Die Funktion `createAction` akzeptiert den Action-Typ und optional zusätzliche Daten (Props) und gibt eine Action zurück.
```typescript
import { createAction, props } from '@ngrx/store';

export const getAbilities = createAction(
    ActionTypes.GETABILITIES
);

export const addAbility = createAction(
    ActionTypes.ADDABILITY, 
    props<{ ability: string }>()
);

export const deleteAbility = createAction(
    ActionTypes.DELETEABILITY, 
    props<{ ability: string }>()
);
```

Diese Action-Creator-Funktionen kann man nun in den Components verwenden und sie auslösen.
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { addAbility, deleteAbility } from 'src/app/actions/ability.actions';

@Component({
    // ..
})
export class AbilityComponent implements OnInit {
    ability$: Observable<{ abilities: string[]; }> = new Observable<{ abilities: string[]; }>();
    abilities$: Observable<string[]> = new Observable<string[]>();

    abilityForm: FormControl = new FormControl('');

    constructor(private store: Store<{ ability: {abilities: string[]} }>) {}

    ngOnInit(): void {
        this.ability$ = this.store.select('ability');

        this.abilities$ = this.ability$.pipe(map(x => {
            return x.abilities
        }))
    }

    addAbility() {
        this.store.dispatch(addAbility({ ability: this.abilityForm.value ?? '' }));
    }

    deleteAbility(ability: string) {
        this.store.dispatch(deleteAbility({ ability: ability }));
    }
}
```

Die Actions werden dann von den Reducer-Funktionen behandelt, um den Zustand zu aktualisieren und auf die Aktionen zu reagieren.