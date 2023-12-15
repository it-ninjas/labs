---
title: "(Zusatz) NgRx"
type: docs
linkTitle: "(Zusatz) NgRx"
weight: 27
date: 2023-04-20
description: >
  NgRx Übersicht, welcher jedoch ein Zusatz ist.
---
## Ziele
* Du weisst, was und wozu NgRx ist, und kennst das Kernkonzept davon.
* Du kannst, es bei dir installieren.

## NgRx
NgRx ist ein beliebtes State-Management-Framework für Angular-Anwendungen, das auf der Redux-Architektur basiert. Es bietet eine zentrale Datenquelle, den sogenannten Store, um den Anwendungsstatus zu verwalten. Mit NgRx kann man den Zustand einer Anwendung zentralisieren, die Datenflüsse vereinfachen und eine bessere Skalierbarkeit und Testbarkeit erreichen.

NgRx besteht aus verschiedenen Kernkonzepten:
* **Store**: Der Store ist der zentrale Speicherort für den Anwendungsstatus. Er enthält den globalen Zustand deiner Anwendung in einem einheitlichen JavaScript-Objekt. Du kannst den Zustand lesen und ihn mit Aktionen ändern.

* **Actions**: Actions repräsentieren Ereignisse oder Absichten, die in einer Anwendung auftreten können. Sie sind einfache JavaScript-Objekte, die eine Typ-Eigenschaft haben, um den Typ der Aktion zu definieren. Actions werden verwendet, um Änderungen im Zustand anzufordern.

* **Reducers**: Reducers sind pure Funktionen, die den vorherigen Zustand und eine Aktion als Eingabe erhalten und den neuen Zustand zurückgeben. Sie definieren, wie sich der Zustand der Anwendung basierend auf den empfangenen Aktionen ändert.

* **Selectors**: Selectors sind Funktionen, die den Zustand aus dem Store abrufen und bestimmte Teile des Zustands extrahieren. Sie werden verwendet, um Daten aus dem Store zu lesen und an die Components weiterzugeben.

* **Effects**: Effects ermöglichen die asynchrone Datenverarbeitung und die Interaktion mit externen APIs. Sie reagieren auf bestimmte Aktionen und führen Nebenwirkungen aus, wie z.B. das Abrufen von Daten von einem Server oder das Auslösen weiterer Aktionen.

![NgRx Statemanagement](../images/ngrx-statemanagement.png)

## Installation
Um NgRx in einem Angular-Projekt zu verwenden, werden folgende Schritte benötigt:
1. Stelle sicher, dass Node.js und npm (Node Package Manager) auf dem Computer installiert sind. (Kann mit `npm -v` geprüft werden.)
2. Öffne ein Terminal oder eine andere Shell und navigiere zum Hauptverzeichnis des Projekts. 
3. Folgenden Befehl ausführen, um NgRx zu installieren:
```shell
npm install @ngrx/store
```
Dieser installiert das NgRx Store-Paket, das den zentralen Store und andere wichtige Funktionen für das State-Management bereitstellt.
4. **Optional**: Je nachdem, welche NgRx-Features man verwenden möchte, kann man weitere NgRx-Pakete installieren. Hier sind einige gängige Pakete:
```shell
npm install @ngrx/effects       // Für die Verwendung von Effects
npm install @ngrx/entity        // Für die Verwendung von Entity State
npm install @ngrx/router-store  // Für die Integration von Router-Status mit dem Store
```

5. Sobald die Installation abgeschlossen ist, können die NgRx-Features im Projekt verwenden werden, indem die entsprechenden Module importiert und konfiguriert werden:
* NgRx Store: Um den NgRx Store zu verwenden, muss das `StoreModule` importiert und im `app.module.ts` konfiguriert werden.
```typescript
import { StoreModule } from '@ngrx/store';

@NgModule({
  imports: [
    // ...
    StoreModule.forRoot(reducers)  // Hier 'reducers' durch den eigenen Reducer ersetzen
  ],
  // ...
})
export class AppModule { }
```

* **Optional** NgRx Effects: Um den NgRx Effects zu verwenden, muss das `EffectsModule` importiert und im `app.module.ts` konfiguriert werden.
```typescript
import { EffectsModule } from '@ngrx/effects';
import { MyEffects } from './my-effects';  // Hier die eigenen Effects importieren

@NgModule({
  imports: [
    // ...
    EffectsModule.forRoot([MyEffects])  // Hier die eigenen Effects registrieren
  ],
  // ...
})
export class AppModule { }
```

* **Optional** NgRx Entity State: Um den NgRx Entity State zu verwenden, muss das `EntityStateModule` importiert und im `app.module.ts` konfiguriert werden.
```typescript
import { EntityStateModule } from '@ngrx/entity';

@NgModule({
  imports: [
    // ...
    EntityStateModule.forRoot(entityConfig)  // Hier 'entityConfig' durch die eigene Konfiguration ersetzen
  ],
  // ...
})
export class AppModule { }
```

## Debugging Tool
Damit man das gesamte auch gut debuggen kann, gibt es eine [Chrome Extension](https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd/related), welche dabei hilft.
Die Extension bietet eine Vielzahl von Funktionen, um den Zustand des Redux-Stores zu überwachen, Aktionen zu verfolgen und den Ablauf der Anwendung besser zu verstehen.
