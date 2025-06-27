---
title: "NgRx"
type: docs
linkTitle: "NgRx"
weight: 1
date: 2023-04-20
description: >
  Modul #F7 - Angular NgRx - Übersicht
---

## Ziele

- Du weisst was NgRx ist, kennst die dazugehörigen Kernkonzepte und weisst, wofür man NgRx nutzt.
- Du kannst NgRx bei dir installieren.

## NgRx

NgRx ist ein beliebtes State-Management-Framework für Angular-Anwendungen, das auf der Redux-Architektur basiert. Es bietet eine zentrale Datenquelle, den sogenannten Store, um den Anwendungsstatus zu verwalten. Mit NgRx kann man den Zustand einer Anwendung zentralisieren, die Datenflüsse vereinfachen und eine bessere Skalierbarkeit und Testbarkeit erreichen.

NgRx besteht aus verschiedenen Kernkonzepten:

- **Store**: Der Store ist der zentrale Speicherort für den Anwendungsstatus. Er enthält den globalen Zustand deiner Anwendung in einem einheitlichen JavaScript-Objekt. Du kannst den Zustand von praktisch überall auslesen und ihn mit Actions ändern.

- **Actions**: Actions repräsentieren Ereignisse oder Absichten, die in einer Anwendung auftreten können. Sie sind einfache JavaScript-Objekte, die eine Typ-Eigenschaft haben, um den Typ der Aktion zu definieren. Actions werden verwendet, um Änderungen im Zustand anzufordern.

- **Reducers**: Reducers sind pure Funktionen, die den vorherigen Zustand und eine Aktion als Eingabe erhalten und den neuen Zustand zurückgeben. Sie definieren, wie sich der Zustand der Anwendung basierend auf den empfangenen Actions ändert.

- **Selectors**: Selectors sind Funktionen, die den Zustand aus dem Store abrufen und bestimmte Teile des Zustands extrahieren. Sie werden verwendet, um Daten aus dem Store zu lesen und an die Components weiterzugeben.

- **Effects**: Effects ermöglichen die asynchrone Datenverarbeitung und die Interaktion mit externen APIs. Sie reagieren auf bestimmte Aktionen und führen Nebenwirkungen aus, wie z.B. das Abrufen von Daten von einem Server oder das Auslösen weiterer Aktionen.

## Installation

Um NgRx in einem Angular-Projekt zu verwenden, werden folgende Schritte benötigt:

1. Stelle sicher, dass Node.js und npm (Node Package Manager) auf dem Computer installiert sind. (Kann mit `npm -v` geprüft werden)
2. Öffne ein Terminal oder eine andere Shell und navigiere zum Hauptverzeichnis des Projekts.
3. Führe den folgenden Befehl aus, um NgRx zu installieren:

```shell
npm install @ngrx/store
```

Dieser installiert das NgRx Store-Paket, das den zentralen Store und andere wichtige Funktionen für das State-Management bereitstellt. 4. **Optional**: Je nachdem, welche NgRx-Features man verwenden möchte, kann man weitere NgRx-Pakete installieren. Hier sind einige gängige Pakete:

```shell
npm install @ngrx/effects       // Für die Verwendung von Effects
npm install @ngrx/entity        // Für die Verwendung von Entity State
npm install @ngrx/router-store  // Für die Integration von Router-Status mit dem Store
```

5. Sobald die Installation abgeschlossen ist, können die NgRx-Features im Projekt verwendet werden, indem die entsprechenden Provides angegeben und konfiguriert werden:

- NgRx Store: Um den NgRx Store zu verwenden, muss `provideStore` importiert und in der `app.config.ts`-Datei konfiguriert werden.
  (`reducers` stammt aus der `index.ts`-Datei im `reducers`-Ordner)

```typescript
import { provideStore } from "@ngrx/store";
import { reducers } from "./reducers";

export const appConfig: ApplicationConfig = {
  providers: [provideStore(reducers)],
};
```

- **Optional** NgRx Effects: Um den NgRx Effects zu verwenden, muss `provideEffects` importiert und in der `app.config.ts`-Datei konfiguriert werden.

```typescript
import { provideEffects } from "@ngrx/effects";
import { RouterEffects } from "@ngrx/router-store";
export const appConfig: ApplicationConfig = {
  providers: [provideEffects(RouterEffects)],
};
```

## Debugging Tool

Damit man mit NgRx auch anständig debuggen kann, gibt es eine [Chrome Extension](https://chromewebstore.google.com/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd), welche dabei sehr helfen kann.
Die Extension bietet eine Vielzahl von Funktionen, um den Zustand des Redux-Stores zu überwachen, Aktionen zu verfolgen und den Ablauf der Anwendung besser zu verstehen.
