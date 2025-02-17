---
title: "NgRx angwendet (Erst anschauen, nachdem das NgRx-Labs durchgeführt wurde)"
type: docs
linkTitle: "NgRx angewendet"
weight: 5
date: 2025-01-27
description: >
  In diesem Abschnitt sollen die Lösungen aus dem zusätzlichen Labs für NgRx nochmal genauer beleuchtet werden.
---

## Ziele

- in diesem Abschnitt sollen die Lösungen zu den (optionalen) NgRx-Labs genauer beleuchtet werden.

Wenn du die Labs zu NgRx noch nicht gemacht hast, musst du dir diese Dokumentation nicht
anschauen.

Wir gehen hier Schritt für Schritt die Aufgaben des NgRx-Labs durch, um zum Einen den
Lösungsfindungsweg genauer anzuschauen, zum Anderen aber auch, um potenzielle Unklarheiten aus dem
Weg zu räumen, die bei der Erarbeitung der Aufgabe aufgekommen sein könnten.

## Aufgabe 1 - Aufgabenstellung

Im Rahmen der ersten Aufgabe des Labs galt es, in einer neuen Angular-Applikation mit NgRx einen
Counter zu erstellen, mit dem man:

- Den Wert des Counters inkrementieren kann (`Wert + 1`)
- Den Wert des Counters dekrementieren kann (`Wert - 1`)
- Den Wert des Counters zurücksetzen kann (`Wert auf 0`)

Die Umsetzung dieser Anforderungen gehen wir nun Stück für Stück durch. Wir beginnen mit den
Actions.

## Aufgabe 1- Actions erstellen

Als erstes gilt es, die jeweiligen Actions für die drei oben beschriebenen Anwendungsfälle zu
definieren. Für die Actions solltest du eine Datei `counter.actions.ts` erstellen, in der du die
Actions erstellen kannst.
Die fertigen Actions sehen dann aus wie folgt:

```typescript
import { createAction } from "@ngrx/store";

export enum ActionTypes {
  INCREMENT = "[Counter Component] Increment",
  DECREMENT = "[Counter Component] Decrement",
  RESET = "[Counter Component] Reset",
}

export const increment = createAction(ActionTypes.INCREMENT);
export const decrement = createAction(ActionTypes.DECREMENT);
export const reset = createAction(ActionTypes.RESET);
```

Gehen wir das also einmal durch:
In der Aufgabenstellung war es vorgesehen, dass die verschiedenen Actions in ein Enum ausgelagert
werden. So sind diese direkt alle über `ActionTypes` verfügbar. Dafür kannst du einfach die
einzelnen Actions in ein Enum wrappen, wie es im Code oben gemacht wurde.
Der String nach dem `=` wird jeweils hinzugefügt, um die Action in Kontext zur Applikation zu
stellen. In diesem Fall sagen sie also aus, dass im `CounterComponent` der Wert entweder
inkrementiert, dekrementiert oder resettet wurde.

Nun haben wir bereits das Grundgerüst für die Actions, diese können aber noch nicht verwendet
werden. Um das zu Ändern, müssen wir diese zu exportierbaren Actions machen, was im zweiten
Abschnitt des Codebeispiels oben passiert.
Für jede Action, die wir definieren wollen, müssen wir eine entsprechende exportierbare Konstante
erstellen. Relevant ist hierbei das Keyword `createAction`, welches die Actions erste wirklich als
solche definiert.

Haben wir nun für jede Action eine entsprechende Definition vorgenommen, können wir mit dem nächsten
Schritt fortfahren, den Reducers.

## Aufgabe 1 - Reducers erstellen

Damit nun beim Aufrufen der Actions, die wir definiert haben, auch etwas passiert, müssen wir die
für die Actions entsprechendne Reducers erstellen.
Der entsprechende Code-Block in der Datei `counter.reducer.ts`, die du erstellt haben solltest,
sieht aus wie folgt:

```typescript
import { createReducer, on } from "@ngrx/store";
import { increment, decrement, reset } from "./counter.actions";

export const initialState = 0;

export const counterReducer = createReducer(
  initialState,
  on(increment, (state) => state + 1),
  on(decrement, (state) => state - 1),
  on(reset, (state) => 0),
);
```

Gehen wir das mal Schritt für Schritt durch: Auf der vierten Zeile wird eine exportierbare Konstante
`initialState` definiert. Diese gibt den Ausgangswert unseres Counters an, in diesem Fall `0`.
Interessant wird es aber ab Zeile 6: Hier wird eine exportierbare Konstante `counterReducer`
definiert, welche dann die eigentlichen Reducer mit der Funktion `createReducer()` erstellt.
Die Funktion nimmt (in unserem Fall) insgesamt 4 Argumente entgegen:

- Den initialen Zustand
- Den Reducer für das Inkrementieren des Counters
- Den Reducer für das Dekrementieren des Counters
- Den Reducer für das Resetten des Counters

Der `initialState` wird hierbei als Ausgangswert für den Counter mitgegeben. Die jeweiligen Reducer
entsprechen jeweils den Actions, die wir in der Datei `counter.actions.ts` definiert haben.
Die Definition funktioniert jeweils wie folgt: Der Reducer wird in die Funktion `on()` verpackt. Als
erstes Argument wird hierbei die Action angegeben, die als Auslöser für den Reducer fungiert. (Wie
du auf Zeile 1 sehen kannst, werden die jeweiligen Actions direkt aus `counter.actions` importiert.)
Insofern also eine der Actions getriggert wird, wird als nächstes der `state` ausgelesen. Dieser
beschreibt den derzeitigen Zustand des Counters, den wir mit den Reducers mutieren wollen.
Zuletzt wird dann auch schon die entsprechende Mutation durchgeführt; Im Falle der Inkrementation
wird der state um 1 erhöht, im Falle der Dekrementation um 1 verringert und im Falle des
Zurücksetzens auf 0 gesetzt.

Das heisst also: Prinzipiell wartet der `Reducer` ab, bis eine bestimmte `Action` aufgerufen wird
und mutiert dann entsprechend den `state`.

## Aufgabe 1 - Component

Der nächste Schritt nach dem Erstellen der Reducers ist es, den entsprechenden Component zu
erstellen, von dem aus die Logik für den Counter ausgelöst werden kann.
Der Component, den du im Rahmen der Aufgabe erstellt haben solltest, sollte aussehen wie folgt:

```typescript
import { Component } from "@angular/core";
import { Store } from "@ngrx/store";
import { Observable } from "rxjs";
import { increment, decrement, reset } from "../counter.actions";
import { AsyncPipe } from "@angular/common";

@Component({
  selector: "app-my-counter",
  templateUrl: "./my-counter.component.html",
  imports: [AsyncPipe],
})
export class MyCounterComponent {
  count$: Observable<number>;

  constructor(private store: Store<{ count: number }>) {
    this.count$ = store.select("count");
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

Gehen wir auch diesen Code mal Schritt für Schritt durch: Der Component ist grundsätzlich aufgebaut
wie jeder andere. Er besteht aus einer `HTML`-Datei, einer `(S)CSS`-Datei, einer `TS`-Datei und
einer `spec.ts`-Datei und beinhält einen Constructor.
Interessant wird es ab Zeile 11: Dort wird ein Obvservable `count$` (achte hierbei auf das `$` am
Ende der Variable => Best Practice bei der Benennung von Observables!) definiert, welches uns
anschliessend zur Darstellung des Counts nutzen wird.
Im Konstruktor auf Zeile 13 wird eine private Variable `store` instanziert, welche die
Zahlen-Variable `count` in diesem erstellt.

Der `Store` dient in NgRx als "Eimer" für die `States` und ist applikationsweit zugänglich. Diese
`States` werden dann auf Befehl der `Actions` von den `Reducern` mutiert.

Auf Zeile 14 wird dann direkt beim Erstellen des Components dem Observable `count$` der derzeitige
Zustand der Variable `count` aus dem Store zugeschrieben, welcher zu diesem Zeitpunkt beim
`initalState`, also bei `0` liegen sollte.
Hiermit ist die Vorbereitung auch schon erledigt, womit wir nun zur Component-Logik weiterkönnen. In
unserem Fall mussten 3 Funktionen definiert werden:

- `increment()`
- `decrement()`
- `reset()`

Die Logik in diesen gehen wir nun ebenfalls kurz durch. Innerhalb der Funktionen wird der im
Constructor instanzierte Store genutzt und dessen Methode `dispatch()` aufgerufen. Diese Methode
wird verwendet, um im Store eine Action auszulösen.
In unseren 3 Fällen wären das die Actions `increment()`, `decrement()` und `reset()`.

Alles was nun noch bleibt, ist das Template. (Siehe oben) Dieses besteht aus 4 Bestandteilen:

- Jeweils ein `button`-Element pro Funktion
- Ein `div`-Element, welches den derzeitigen Zustand des Counters anzeigt.

In den jeweiligen Buttons muss jeweils lediglich das `(click)`-Event abgefangen werden, woraufhin
die jeweilige Funktion aufgerufen wird.

## Aufgabe 1 - app.config.ts anpassen

Seit in Angular standardmässig standalone-Component verwendet werden und somit normalerweise kein
AppModule mehr exisitert, muss für das korrekte Funktionieren der Reducer eine Anpassung in der
`app.config.ts`-Datei gemacht werden, nämlich die folgende:

```typescript
import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection,
} from "@angular/core";
import { provideRouter } from "@angular/router";

import { routes } from "./app.routes";
import { provideStore, StoreModule } from "@ngrx/store";
import { counterReducer } from "./aufgabe-1/counter.reducers";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideStore(),
    importProvidersFrom(StoreModule.forRoot({ count: counterReducer })),
  ],
};
```

Für uns relevant sind die beiden letzten provider in der `appConfig`. Zum einen muss der Store
provided werden, zum anderen müssen aber auch Provider für die Reducer importiert werden.
Auf der letzten Zeile innerhalb `forRoot` müssen also **alle** Reducer hinzugefügt werden, ansonsten
funktioniert gar nichts.
Hast du das alles gemacht (und natürlich den MyCounterComponent im `app.component.html` hinzugefügt,
damit dieser angezeigt wird) dürfte der Counter wie gewünscht funktionieren.

## Aufgabe 2 - Aufgabenstellung

Gehen wir nun weiter zur zweiten Aufgabe. Das Ziel der Aufgabe ist es, einen Online-Shop mit einer
Produkübersicht und einem Warenkorb zu erstellen. Dabei sollen die Produktdaten als Mockdaten
über einen Service bereitgestellt werden.
Zudem soll es möglich sein, mithilfe von Routing zwischen den beiden Ansichten hin- und
herzuwechseln.

Ein Produkt besteht aus 2 Attributen:

- Name
- Preis

In der Produktübersicht sollen alle Produkte angezeigt werden, indem Sie aus dem angesprochenen
Service geholt werden. Für jedes Produkt soll ein Button bestehen, mit welchem man dieses zum
Warenkorb hinzufügen kann.
Der Warenkorb soll alle Produkte anzeigen, welche in der Produktübersicht zu diesem hinzugefügt
wurden. Der Warenkorbzustand soll hierbei mithilfe von NgRx verwaltet werden. Die folgenden Aktionen
sollen im Kontext des Warenkorbs ausgeführt werden können:

- Hinzufügen von Produkten in den Warenkorb
- Entfernen von Produkten aus dem Warenkorb
- Ausgabe einer Liste aller Produkte im Warenkorb

Zudem soll es ebenfalls möglich sein, den Kaufprozess per Knopfdruck abzuschliessen (und somit den
Warenkorb leeren), womit ebenfalls die folgende Funktionalität dazukommt:

- Leeren des Warenkorbs

Wir gehen die Lösung, gleich wie bei der ersten Aufgabe, nun Schritt für Schritt durch:

## Aufgabe 2 - Actions

Wie bei der ersten Aufgabe gilt es als erstes, die jeweiligen nötigen Actions zu definieren.
Aus der Aufgabenstellung konnten wir die folgenden 4 Anwendungsfälle auslesen:

- Hinzufügen eines Produkts in den Warenkorb
- Entfernen eines Produkts aus dem Warenkorb
- Leeren des Warenkorbs
- Abschliessen einer Bestellung

Da das Leeren des Warenkorbs und das Abschliessen einer Bestellung grundsätzlich dasselbe Verhalten
zur Folge haben, nämlich einen leeren Warenkorb, könnte man die Anzahl der Actions auf 3 reduzieren
und beim Abschliessen einer Bestellung
einfach die Action für das leeren des Warenkorbs nutzen, der Vollständigkeit halber wird in diesem
Beispiel aber mit einer separaten Action für den Abschluss einer Bestellung gearbeitet.
Die 4 Actions sähen umgesetzt aus wie folgt (in diesem Fall heisst die Datei
`shopping-cart.actions.ts`):

```typescript
import { createAction, props } from "@ngrx/store";
import { ProductModel } from "../models/product-model";

export enum ActionTypes {
  ADDPRODUCT = "[ShoppingCart Component] add product",
  REMOVEPRODUCT = "[ShoppingCart Component] remove product",
  EMPTYSHOPPINGCART = "[ShoppingCart Component] empty shopping cart",
  COMPLETEORDER = "[ShoppingCart Component] complete order",
}

export const addProduct = createAction(
  ActionTypes.ADDPRODUCT,
  props<{ product: ProductModel }>(),
);
export const removeProduct = createAction(
  ActionTypes.REMOVEPRODUCT,
  props<{ name: string }>(),
);
export const emptyShoppingCart = createAction(ActionTypes.EMPTYSHOPPINGCART);
export const completeOrder = createAction(ActionTypes.COMPLETEORDER);
```

Die Actions für das Leeren des Warenkorbs und das Abschliessen der Bestellung sind wie oben erwähnt
identisch und unterscheiden sich nicht von den bisherigen Actions, die wir gesehen haben.
Interessant wird es bei der Action für das hinzufügen eines Produkts; Dort nutzen wir nämlich die
`props`-Funktion.
In diesem Fall beschreibt `props` die Parameter, die wir der Action beifügen wollen. Im Falle von
`addProduct` entspricht das einer Instanz des `ProductModel` (schauen wir gleich noch an), im Falle
von `removeProduct` einem string, welcher den Namen des zu entfernenden Produkts enthält.
Das ist bereits alles, was wir in den Actions machen müssen.

## Aufgabe 2 - Model

Oben haben wir bereits das `ProductModel` verwendet. Dieses ist eine Klasse, welches wir der
Einfachheit halber verwenden, um die nötigen Attribute `name` und `preis` zum jeweiligen Produkt zu
speichern.
Das Model sieht aus wie folgt und befindet sich in diesem Beispiel in der Datei `product-model.ts`:

```typescript
export class ProductModel {
  name: string;
  price: number;

  constructor(name: string, price: number) {
    this.name = name;
    this.price = price;
  }
}
```

Dieses Model werden wir durch die Aufgabenstellung immer wieder verwenden.

## Aufgabe 2 - interfaces

Um uns die Handhabung der jeweiligen States, insbesondere für den Fall, dass mehrere in einer
Applikation verwendet werden, einfacher zu gestalten und die spätere Nutzung von `selectors` zu
ermöglichen, können wir jeweils eigene definieren.
Der eigene State für die Produkte, die später im Warenkorb angezeigt werden, sieht im Beispiel aus
wie folgt und befindet sich in der (eigens erstellten) Datei `index.ts`:

```typescript
import { ProductModel } from "../models/product-model";

export interface ProductState {
  products: ProductModel[];
}

export const initalState: ProductState = {
  products: [],
};
```

Der Ablauf hier ist relativ simpel: Wir definieren ein exportierbares interface `ProductState`,
welches ein Array von ProductModels enthält.
Zudem definieren wir einen initialen Zustand für den Inhalt des States, in diesem Fall einfach ein
leeres Array.

## Aufgabe 2 - Reducers

Wie bereits bei der ersten Aufgabe folgt auf die Definition der Actions die Definition der
jeweiligen dazugehörigen Reducers.
Diese sehen aus wie folgt und befinden sich in diesem Beispiel in der Datei
`shopping-cart.reducers.ts`:

```typescript
import { createReducer, on } from "@ngrx/store";
import {
  addProduct,
  completeOrder,
  emptyShoppingCart,
  removeProduct,
} from "./shopping-cart.actions";
import { initalState } from "./index";

export const shoppingCartReducer = createReducer(
  initalState,

  on(addProduct, (state, { product }) => ({
    ...state,
    products: [...state.products, product],
  })),

  on(removeProduct, (state, { name }) => ({
    ...state,
    products: state.products.filter((product) => product.name !== name),
  })),

  on(emptyShoppingCart, (state) => ({
    ...state,
    products: [],
  })),
  on(completeOrder, (state) => ({
    ...state,
    products: [],
  })),
);
```

Hier wird es interessant: Da wir mit einem Array arbeiten, können wir nicht, wie beispielsweise in
der ersten Aufgabe, einfach den state nehmen und diesen mutieren.
Schauen wir uns mal den ersten Reducer an:

```typescript
on(addProduct, (state, { product }) => ({
  ...state,
  products: [...state.products, product],
}));
```

Als erstes definieren wir wieder zu Beginn mit `on()`, wann der Reducer ausgeführt werden soll. In
diesem Fall passiert das, sobald die Action `addProduct` aufgerufen wird.
Danach wird es spannend: In den runden Klammern als zweites Argument geben wir `state, {product}`an.
Der state erklärt sich von selbst, den brauchen wir immer. `{product}` hingegen stellt den Parameter
an, der mit der Action geliefert wird.
Innerhalb der Arrow-Function passieren dann zwei Dinge:

1. Es wird eine `shallow-copy` des states gemacht.
2. Das Attribut `products` wird mit den bisherigen products + dem neu hinzuzufügenden product
   angereichert.

Auf diese Art und Weise garantieren wir, dass beim Hinzufügen eines neuen Produkts alle bisherigen
Werte ebenfalls übernommen werden.

Auch interessant ist der zweite Reducer, der zum Entfernen eines Produkts aus dem state verwendet
wird:

```typescript
on(removeProduct, (state, { name }) => ({
  ...state,
  products: state.products.filter((product) => product.name !== name),
}));
```

Der Ablauf bis zur Anreicherung des `products`-Arrays ist derselbe, ausser dass hier nur der name
des Produkts und nicht die ganze Struktur als Parameter erwartet wird.
In der Definition des `products`-Arrays werden dann der aktuelle Zustand des Arrays genommen und
alle darin enthaltenen Produkte mit dem entsprechenden Namen, der geliefert wurde, entfernt.

Wichtig: Diese Lösung ist eher unschön, es werden nämlich alle Instanzen eines Produkts aus dem
Array entfernt, wenn mehrere vorhanden sind.
Wenn beispielsweise 2 Fussbälle im Array sind, werden beide entfernt, da sie ja denselben Namen
haben. Hätten wir eine ID für die jeweiligen Produkte verwendet, hätte man mit dieser auch einzelne
Instanzen mehrfach vorkommender Produkte entfernen können.
Da in der Aufgabenstellung aber keine ID vorgesehen ist, können wir in diesem Fall dieses Verhalten
akzeptieren.
Es ist aber auch möglich, den Filter so anzupassen, dass nach einer Entfernung eines Elements, das
mehrfach vorkommt, die Filtrierung gestoppt wird. Wenn du möchtest, kannst du probieren, den Filter
entsprechend anzupassen.

Die beiden Reducer für das Leeren des Warenkorbs und das Abschliessend der Bestellung sind hierbei
nicht gross erwähnenswert, da einfach das Array `products` auf einen leeren Zustand zurückgesetzt
wird.

## Aufgabe 2 - Selectors

Im Vergleich zu der ersten Aufgabe gibt es hier ein neues Konzept, welches wir verwenden, nämlich
die sogenannten `Selectors`.
In der ersten Aufgabe haben wir den Inhalt des Stores mit `store.select()` ausgelesen und dabei
einfach den entsprechenden Key aus dem Store verwendet.
Um die Auslese der Daten aus dem Store aber ein wenig zu verschönern und applikationsweit zu
vereinheitlichen, können wir mit Selektoren arbeiten.
Der Selektor für diese Aufgabe sieht aus wie folgt und befindet sich in der Datei
`shopping-cart.selectors.ts`:

```typescript
import { ProductState } from "./index";
import { createFeatureSelector, createSelector } from "@ngrx/store";

export const selectShoppingCartState =
  createFeatureSelector<ProductState>("products");

export const getShoppingCartProducts = createSelector(
  selectShoppingCartState,
  (state) => state.products,
);
```

Hier kommt der `ProductState` zum Tragen, den wir zu Beginn in der `index.ts` Datei definiert haben.
Mit diesem erstellen wir zuerst eine exportierbare Konstante `selectShoppingCartState`, die einen
sogenannten FeatureSelector darstellt, die den `ProductState` ausliest.
Daraufhin müssen wir erneut eine exportierbare Konstante `getShoppingCartProducts` erstellen, welche
wir dann jeweils in den Components aufrufen können.
Dieser nimmt innerhalb der Funktion `createSelector` als Parameter entgegen und gibt darauf aus dem
state heraus die products aus.
Das wäre bereits alles, was wir im Rahmen der Selectors machen müssen.

## Aufgabe 2 - app.config.ts

Damit unsere Reducer und Selektoren korrekt funktionieren, müssen wir, wie in der ersten Aufgabe,
Anpassungen in der `app.config.ts`-Datei machen:

```typescript
import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection,
} from "@angular/core";
import { provideRouter } from "@angular/router";
import { routes } from "./app.routes";
import { provideStore, StoreModule } from "@ngrx/store";
import { shoppingCartReducer } from "./aufgabe-2/ngrx/shopping-cart.reducers";
import { provideStoreDevtools } from "@ngrx/store-devtools";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideStore(),
    importProvidersFrom(StoreModule.forRoot({ products: shoppingCartReducer })),
  ],
};
```

Relevant sind für uns die beiden Auszüge aus dem `providers`-Array:

```typescript
provideStore(), importProvidersFrom(StoreModule.forRoot({ products: shoppingCartReducer })
```

`provideStore` benötigen wir, um überhaupt erst den Store nutzen zu können, den zweiten Teil
benötigen wir wiederum, damit die Reducer funktionieren und der State mit `state.select("products")`
im Selektor ausgelesen werden kann.

## Aufgabe 2 - Service

Im Rahmen der Aufgabe solltest du einen Service erstellen, mit dem du gemockte Daten an den
Übersichts-Component senden kannst.
Einen neuen Service für die Produkte kannst du einfach via `ng g s product` in der Konsole
generieren lassen. Der Inhalt des Services bleibt dabei relativ simpel:
Wir müssen zum einen die Produkte mocken (dafür können wir direkt das Model nutzen, das wir bisher
gebraucht haben) und eine Methode bereitstellen, die diese an den entsprechenden Component liefern
kann.
Der Service sähe dann in etwa so aus:

```typescript
import { Injectable } from "@angular/core";
import { ProductModel } from "../models/product-model";

@Injectable({
  providedIn: "root",
})
export class ProductService {
  private products: ProductModel[] = [];

  constructor() {
    this.products = [
      { name: "Federball 🏸", price: 100 },
      { name: "Fussball ⚽", price: 1000 },
      { name: "Basketball 🏀", price: 500 },
      { name: "Volleyball 🏐", price: 800 },
      { name: "Skateboard 🛹", price: 900 },
      { name: "Tennisball 🎾", price: 2 },
      { name: "Bowlingkugel 🎳", price: 600 },
      { name: "Tischtennisball 🏓", price: 800 },
      { name: "Hockeyball 🏑", price: 700 },
      { name: "Abschlussball 🕺", price: 800 },
    ];
  }

  getAllProducts() {
    return this.products;
  }
}
```

## Aufgabe 2 - Components erstellen / Routing

Wir brauchen in dieser Aufgabe 2 Components;

- Ein Component als Startseite mit allen Produkten
- Ein Component als Warenkorb mit allen ausgewählten Produkten

Diese beiden Components kannst du wieder einfach per Konsole mit dem Befehl `ng g c {name}`
generieren lassen. Wie die Components genau aussehen, schauen wir gleich genauer an.
Vorher definieren wir aber direkt das Routing zwischen den jeweiligen Komponenten. Als erstes muss
direkt das `router-outlet`-Tag im AppComponent hinzugefügt werden, damit das Routing überhaupt
funktioniert.
Das ist auch schon alles, was in die Datei `app.component.html` rein muss:

```html
<router-outlet></router-outlet>
```

Danach können wir die Routen bereits in der `app.routes.ts`-Datei definieren. In diesem Beispiel
heissen die Components `OverviewComponent` und `ShoppingCartComponent`. Wenn du deine Components
anders bezeichnet hast, musst du lediglich die Definition nach `component:` entsprechend anpassen.
Für das Beispiel sähen die Routen aber aus wie folgt:

```typescript
import { Routes } from "@angular/router";
import { OverviewComponent } from "./aufgabe-2/components/overview/overview.component";
import { ShoppingCartComponent } from "./aufgabe-2/components/shopping-cart/shopping-cart.component";

export const routes: Routes = [
  { path: "", component: OverviewComponent },
  { path: "shopping-cart", component: ShoppingCartComponent },
];
```

Als Ausgangscomponent nehmen wir (logischerweise) den Component mit der Übersicht, dafür geben wir
ihm einfach einen leeren Path an.
Nun bleiben nur noch die Components, dann haben wir die Übung bereits geschafft.

## Aufgabe 2 - Übersichts-Component

Im Übersichts-Component wollen wir als erstes die Mock-Daten aus dem Service holen. Dazu müssen wir
lediglich im Constructor die `getAllProducts()` aus dem Service ausrufen und einer entsprechenden
Variable zuweisen:

```typescript
import { Component } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { ProductModel } from "../../models/product-model";
import { Store } from "@ngrx/store";
import { addProduct } from "../../ngrx/shopping-cart.actions";
import { RouterLink } from "@angular/router";

@Component({
  selector: "app-overview",
  imports: [RouterLink],
  templateUrl: "./overview.component.html",
  styleUrl: "./overview.component.scss",
})
export class OverviewComponent {
  protected products: ProductModel[] = [];

  constructor(
    private store: Store<{ products: ProductModel[] }>,
    private productService: ProductService,
  ) {
    this.products = this.productService.getAllProducts();
  }
}
```

Nachdem wir die Daten für die Anzeige vorbereitet haben, können wir direkt auch schon die Funktion
für das Hinzufügen eines Produkts definieren:

```typescript
addProduct(product
:
ProductModel
)
{
  this.store.dispatch(addProduct({ product: product }));
}
```

Da wir das jeweilige Product aus dem Template erhalten, geben wir dieses hier als Parameter für die
Funktion an.
Die action für das hinzufügen des Produkts lösen wir entsprechend mit
`this.store.dispatch(addProduct()))` aus. Neu ist hier die Nutzung eines Parameters innerhalb der
Action.
Parameter für actions werden jeweils in geschweiften Klammern als key-value-Paar angegeben. Da wir
in der entsprechenden Action den Parameter als `product` definiert haben, ist das hier auch der key.
Als value geben wir dann noch das aus dem Template gelieferte `product` an. Das ist bereits alles,
was wir auf der Seite der Logik machen müssen.

Als nächstes schauen wir das Template und somit die Anzeige der Daten an:

```html
<div class="title-container">
  <a routerLink="">Übersicht</a>
  <a routerLink="shopping-cart">Warenkorb</a>
</div>

@for (product of products; track product.name){
<div class="product-container">
  <p>Name: {{product.name}}</p>
  <p>Preis: {{product.price}}</p>
  <button (click)="this.addProduct(product)">🛒</button>
</div>
}
```

Hier fallen direkt einige Dinge auf:
Zuoberst haben wir die Navigation, die zwischen den beiden Components stattfindet. Die jeweiligen
Links befinden sich standardmässig in `a`-Tags.
Hierbei aber ganz wichtig: Es muss `routerLink` statt `href` für die Angabe des Paths verwendet
werden. Wenn in Angular per `href` navigiert wird, wird in NgRx der Store auf den Ausgangswert
zurückgesetzt. Unter Vewendung von `routerLink` tritt dieses Verhalten hingegen nicht auf.

Der Rest ist eigentlich relativ simpel. Wir iterieren mit `@for` über die Elemente des `products`
-Arrays und generieren für jedes Element eine Anzeige des Namens und des Preises und einen Button,
der für das jeweilige Element die `addProduct`-action auslöst.
In der Erarbeitung dieser Lösung wurde zusätzlich ein wenig SCSS verwendet, um die Seite
einigermassen anschaulich zu gestalten. Du musst das jeweils nicht machen, bei Interesse kannst du
dir aber dennoch das SCSS anschauen:

```scss
.title-container {
  font-size: 2rem;
  display: flex;
  justify-content: space-around;
}

.product-container {
  text-align: center;
  width: 49%;
  float: left;
  display: inline-block;
  font-size: 1.5rem;
  margin: 0 0 2% 0;
}
```

Die Seite sieht, wenn sie so umgesetzt und gestylt wird wie hier, schlussendlich so aus:
![Overview Page](../images/ngrx_applied_exercise_2_overview_page.png)

## Aufgabe 2 - Warenkorb-Component

Zum Schluss müssen wir nun noch einen Component für den Warenkorb erstellen, in welchem die
jeweiligen zum Warenkorb hinzugefügten Produkte angezeigt werden.
Zur Erinnerung; Im Warenkorb müssen die folgenden Funktionalitäten umgesetzt sein:

- Entfernen eines Produkts aus dem Warenkorb
- Leeren des Warenkorbs
- Abschliessen der Bestellung

Beginnen wir wieder in der Typescript-Datei:

```typescript
import { Component } from "@angular/core";
import { Observable } from "rxjs";
import { Store } from "@ngrx/store";
import { ProductModel } from "../../models/product-model";
import { AsyncPipe } from "@angular/common";
import { getShoppingCartProducts } from "../../ngrx/shopping-cart.selectors";
import { RouterLink } from "@angular/router";
import {
  completeOrder,
  emptyShoppingCart,
  removeProduct,
} from "../../ngrx/shopping-cart.actions";

@Component({
  selector: "app-shopping-cart",
  imports: [RouterLink, AsyncPipe],
  templateUrl: "./shopping-cart.component.html",
  styleUrl: "./shopping-cart.component.scss",
})
export class ShoppingCartComponent {
  products$: Observable<ProductModel[]> = new Observable<ProductModel[]>();

  constructor(private store: Store<{ products: ProductModel[] }>) {
    this.products$ = this.store.select(getShoppingCartProducts);
  }

  removeProduct(productName: string) {
    this.store.dispatch(removeProduct({ name: productName }));
  }

  emptyShoppingCart() {
    this.store.dispatch(emptyShoppingCart());
  }

  completeOrder() {
    this.store.dispatch(completeOrder());
    alert("Bestellung abgeschlossen!");
  }
}
```

Hier passiert direkt einiges:

1. Werden die Produkte in einem Observable gespeichert, da die Daten unter Auslesung aus dem Store
   diese Form annehmen. Der Typ des Observables ist dabei `ProductModel[]`.
2. Wir definieren im Constructor einen privaten `store`, über den wir die actions ausführen. Mit
   `{products: ProductModel[]}` spezifizieren wir dabei, welche Form die Ausgelesenen Daten haben.
3. Wir lesen die Daten aus dem Store mit dem zu Beginn von uns definierten selector
   `getShoppingCartProducts` und übergeben diese an `products$`.
4. Wir definieren die jeweiligen Funktionen für das Entfernen eines Produkts, das Leeren des
   Warenkorbs und das Abschliessen einer Bestellung.

Den logischen Teil im Component haben wir nun bereits abgeschlossen. Nun bleibt nur noch das
Template:

```html
<div class="title-container">
  <a routerLink="">Übersicht</a>
  <a routerLink="shopping-cart">Warenkorb</a>
</div>

@for (product of products$ | async; track product) {
<div class="product-container">
  <p>{{ product.name }}</p>
  <p>{{ product.price }}</p>
  <button class="remove-product" (click)="removeProduct(product.name)">
    🗑
  </button>
</div>
} @empty {
<div class="no-products-container">
  <p class="no-products-text">No Products in shopping cart</p>
</div>
}
<div class="empty-shopping-cart-container">
  <button class="empty-shopping-cart-button" (click)="emptyShoppingCart()">
    Empty Shopping Cart
  </button>
</div>

<div class="complete-order-container">
  <button class="complete-order-button" (click)="completeOrder()">
    Complete Order
  </button>
</div>
```

Wie im Overview-Component hat es zuoberst als erstes die jeweilige Navigation zwischen den
Components.
Darauf wird wieder mit `@for` über die Produkte iteriert. Ein wichtiger Unterschied ist hierbei die
`|async`-Pipe. Diese wird benötigt, da nur asynchron über Observables iteriert werden kann.
Innerhalb des Loops hat es wieder eine Darstellung mit dem jeweligen Namen und Preis und einen
Button für das entfernen eines Produkts aus dem Warenkorb.
Mit `@empty` nach dem Loop wird beschrieben, was passieren soll, wenn `products$` keinen Wert
enthält. In diesem Fall wird einfach ein Text "No Products in shopping cart" angezeigt.

Schlussendlich hat es dann noch 2 Buttons, welche jeweils die Funktionen für das Leeren des
Warenkorbs und das Abschliessen einer Bestellung aufrufen.

Hier noch das SCSS-File für die Interessierten:

```scss
.title-container {
  font-size: 2rem;
  display: flex;
  justify-content: space-around;
}

.product-container {
  text-align: center;
  width: 24%;
  float: left;
  display: inline-block;
  font-size: 1.5rem;
  margin: 5% 0 2% 0;

  .remove-product {
    font-size: 1.2rem;
  }
}

.no-products-container {
  width: 100%;
  text-align: center;

  .no-products-text {
    text-align: center;
    font-size: 50px;
  }
}

.empty-shopping-cart-container,
.complete-order-container {
  width: 47%;
  display: inline-block;
  text-align: center;

  .empty-shopping-cart-button,
  .complete-order-button {
    width: 90%;
    margin: 2% 2% 0 2%;
    font-size: 50px;
  }
}
```

Die fertige Seite sieht mit dem obenstehenden Design dann aus wie folgt:

![Warenkorb Component](../images/ngrx_applied_exercise_2_shopping_cart_page.png)

## Aufgabe 3 - Aufgabenstellung

Nun bleibt uns noch die dritte Aufgabe. Diese sieht es vor, eine TODO-Liste mithilfe von NgRx
umzusetzen.
Eine Task in dieser Liste beinhält jeweils die folgenden 3 Attribute:

- ID
- Name
- Completed

Es sollen, ähnlich wie bei der zweiten Aufgabe, 2 Seiten erstellt werden:

- Eine, auf der alle offenen Tasks angezeigt werden. (Also alle, die im Attribut `completed` einen
  Wert von `false` innehaben.) Hier sollen Tasks hinzugefügt, entfernt und komplettiert werden
  können. Zudem sollen wie bei Aufgabe 2 Selektoren für das Auslesen der Tasks verwendet werden.
- Eine, auf der neue Tasks erstellt werden können. Hierbei soll der Name mittels eines Reactive
  Forms eingetragen werden können und der Wert `completed` immer mit `false` instanziert werden. Um
  sicherzugehen, dass die IDs jeweils einzigartig send, nutzen wir für die Definition dieser
  `new Date().getTime()` (aktuelle Uhrzeit).

Gehen wir also nun wie gewohnt die einzelnen Schritte durch:

## Aufgabe 3 - Actions

Als erstes kommen wieder die Actions, die wir anhand der vorgegebenen Anwendungsfälle definieren
müssen. In dieser Aufgabe gibt es drei Funktionalitäten, die wir mithilfe von Actions bereitstellen
müssen:

- Es muss möglich sein, eine neue Task zu erstellen
- Es muss möglich sein, eine Task zu entfernen
- Es muss möglich sein, eine Task abzuschliessen

Aus dieser Aufgabenstellung ergeben sich dann die folgenden 3 Actions:

```typescript
import { createAction, props } from "@ngrx/store";
import { TaskModel } from "../models/task-model";

export enum ActionTypes {
  ADDTASK = "[Task Component] add task",
  REMOVETASK = "[Task Component] remove task",
  COMPLETETASK = "[Task Component] complete task",
}

export const addTask = createAction(
  ActionTypes.ADDTASK,
  props<{ task: TaskModel }>(),
);
export const removeTask = createAction(
  ActionTypes.REMOVETASK,
  props<{ id: number }>(),
);
export const completeTask = createAction(
  ActionTypes.COMPLETETASK,
  props<{ id: number }>(),
);
```

Hier gibt es im Vergleich zu Aufgabe 2 eigentlich nichts Neues. Wie gewohnt erstellen wir zuerst die
jeweliigen `ActionTypes`, die die actions jeweils nachvollziehbar machen.
Darauf folgt dann die effektive Definition der actions. Dabei wird wie immer zuerst der jewelige
`ActionType` zugewiesen. In unserem Fall benötigen alle actions jeweils noch `props` (Paramater).
`addTask` braucht eine ganze Task (da ja eine neue erstellt werden soll), wohingegen `removeTask`und
`completeTask` jeweils nur die id der betroffenen Task brauchen.

## Aufgabe 3 - Model

Wie auch schon in Aufgabe 2 benutzen wir in dieser Lösung für die Tasks, um das Ganze übersichtlich
zu gestalten. Diese wurde in den Actions bereits in den `props` von `addTask` verwendet und sieht so
aus:

```typescript
export class TaskModel {
  id: number;
  name: string;
  completed: boolean;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
    this.completed = false;
  }
}
```

Achte hierbei darauf, dass das `completed`-Attribut **nicht** durch als Parameter im Constructor
geliefert wird, sondern direkt auf false gesetzt wird.
In der Aufgabenstellung steht als Anforderungen, dass Tasks zum Zeitpunkt der Erstellung **immer**
nicht completed sein sollen, daher können wir uns so jeweils einen Parameter beim Erstellen einer
neuen Task sparen.

## Aufgabe 3 - Interfaces

Wie auch in Aufgabe 2 macht es in diesem Fall Sinn, einen separaten State für die Tasks zu
erstellen. Dazu wurde hier wieder eine Datei `index.ts` erstellt, um den das Interface für den State
und den intialState für den Reducer unterzubringen.
Die Datei sieht aus wie folgt:

```typescript
import { TaskModel } from "../models/task-model";

export interface TaskState {
  tasks: TaskModel[];
}

export const initalState: TaskState = {
  tasks: [],
};
```

Da wir mit mehreren Tasks arbeiten, geben wir im TaskState an, dass wir ein Array an TaskModels
speichern möchten. Als `initalState` geben wir einfach ein leeres Array an.

## Aufgabe 3 - Reducers

Nun kommen wir auch schon zu den Reducers; Wie bisher auch müssen wir für jede Action, die wir
definiert haben, einen entsprechenden Reducer schreiben, der die effektiv ausgeführte Logik
beinhält.
Die `task.reducers.ts`-Datei sollte dabei aussehen wie folgt:

```typescript
import { createReducer, on } from "@ngrx/store";
import { initalState } from "./index";
import { addTask, completeTask, removeTask } from "./task.actions";

export const taskReducer = createReducer(
  initalState,

  on(addTask, (state, { task }) => ({
    ...state,
    tasks: [...state.tasks, task],
  })),

  on(removeTask, (state, { id }) => ({
    ...state,
    tasks: state.tasks.filter((task) => task.id !== id),
  })),

  on(completeTask, (state, { id }) => ({
    ...state,
    tasks: state.tasks.map((task) =>
      task.id === id ? { ...task, completed: true } : task,
    ),
  })),
);
```

Als erstes wird in der `createReducer` Funktion der `initialState` aus der `index.ts` als Parameter
mitgegeben, worauf dann die jeweiligen Reducer folgen.
Der Reducer für die `addTask`-action ist hierbei praktisch gleich wie der `addProduct`-Reducer aus
Aufgabe 2; Es wird eine Shallow-Copy des derzeitigen `state` gemacht und die neue task wird
angehängt,

Der Reducer für `removeTask` funktioniert ebenfalls praktisch gleich wie der `removeProduct`-Reducer
aus Aufgabe 2; Es wird eine Shallow-Copy des derzeitigen `state` gemacht, wonach der Eintrag im
Array mit der mitgegebenen `id` aus dem Array gefiltert wird.
Denken wir nochmal kurz zu Aufgabe 2 zurück: Dort war das Problem bei `removeProduct` ja, dass alle
Einträge mit demselben Namen aus dem Array entfernt wurden, da wir anhand des `name`-Attributs des
Produkts gefiltert haben.
Dieses Problem gibt es hier nicht mehr, da wir mit der `id` gefiltert haben, die ja einzigartig
ist (Da sie basierend auf der derzeitigen Uhrzeit generiert wird, die Umsetzung dazu folgt noch).

Der Reducer für `completeTask` ist hierbei der spannendenste. Wir können nicht einfach eine neue
Task anfügen oder herausfiltern. Wir müssen stattdessen anhand der gelieferten `id` den
entsprechenden Eintrag aus dem Array herauspicken und dessen `completed`-Attribut verändern.
Dazu können wir die auf dem `tasks`-Array die `map`-Methode nutzen, um auf die einzelnen Tasks
zugreifen zu können. Bei den einzelnen Tasks prüfen wir daraufhin, ob deren `id` mit der gelieferten
übereinstimmt.
Ist das der Fall, wird für die jeweilige Task das `completed`-Attribut auf `true` gesetzt, ansonsten
passiert nichts.

## Aufgabe 3 - Selectors

Wie auch schon in Aufgabe 2 sieht die Aufgabenstellung vor, dass wir Selectors nutzen, um die Tasks
aus dem Store auszulesen. Der Code dazu sieht aus wie folgt:

```typescript
import { createFeatureSelector, createSelector } from "@ngrx/store";
import { TaskState } from "./index";

export const selectTaskState = createFeatureSelector<TaskState>("tasks");

export const getTasks = createSelector(selectTaskState, (state) => state.tasks);
```

Der Aufbau des Selectors ist genau derselbe wie bei Aufgabe 2; Als erstes definieren wir eine
exportierbare Konstante `selectTaskState`, die einen `FeatureSelector` erstellt, der die `tasks` aus
dem `TaskState` ausliest.
Danach definieren wir eine exportierbare Konstante `getTasks`, welche einen Selector beinhält, der
den `TaskState` mit `selectTaskSate` ausliest und darauf basierend die `tasks` zurückgibt.

## Aufgabe 3 - app.config.ts

Wie immer müssen wir die Datei `app.config.ts` Anpassen, damit unsere Reducer und Selectors
funktionieren. Die Datei sollte angepasst so aussehen:

```typescript
import {
  ApplicationConfig,
  importProvidersFrom,
  provideZoneChangeDetection,
} from "@angular/core";
import { provideRouter } from "@angular/router";
import { routes } from "./app.routes";
import { provideStore, StoreModule } from "@ngrx/store";
import { provideStoreDevtools } from "@ngrx/store-devtools";
import { taskReducer } from "./aufgabe-3/ngrx/task.reducers";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideStore(),
    importProvidersFrom(StoreModule.forRoot({ tasks: taskReducer })),
  ],
};
```

## Aufgabe 3 - Components erstellen / Routing

Die Aufgabenstellung sieht zwei Views vor: Einmal eine Übersicht mit allen offenen Tasks und einmal
eine Seite, auf der die Tasks erstellt werden können. Dazu können wir einfach mit dem Befehl
`ng g c {name}` die beiden Components in der Konsole erstellen.
Nach der Erstellung können wir direkt das Routing für die beiden Components vorbereiten, damit wir
nachher nur noch in den Components selbst arbeiten müssen. Die `app.routes.ts`-Datei sollte daher
aussehen wie folgt:

```typescript
import { Routes } from "@angular/router";
import { OverviewComponent } from "./aufgabe-3/components/overview/overview.component";
import { CreateTaskComponent } from "./aufgabe-3/components/create-task/create-task.component";

export const routes: Routes = [
  { path: "", component: OverviewComponent },
  { path: "create-task", component: CreateTaskComponent },
];
```

Da der `OverviewComponent` als Ausgangscomponent dienen soll, geben wir diesem einen leeren Path.

## Aufgabe 3 - Component für die Task-Erstellung

Nun bleibt uns nur noch die Umsetzung der beiden Components. Wir fangen hierbei mit dem Component
für die Erstellung der Tasks an, da wir ansonsten Daten für die Umsetzung des Übersichts-Components
mocken müssten.
Beginnen wir beim `ts`-File des Components:

```typescript
import { Component } from "@angular/core";
import { FormControl, ReactiveFormsModule } from "@angular/forms";
import { TaskModel } from "../../models/task-model";
import { Store } from "@ngrx/store";
import { addTask } from "../../ngrx/task.actions";
import { RouterLink } from "@angular/router";

@Component({
  selector: "app-create-task",
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: "./create-task.component.html",
  styleUrl: "./create-task.component.scss",
})
export class CreateTaskComponent {
  name = new FormControl("");

  constructor(private store: Store<{ tasks: TaskModel[] }>) {}

  addTask() {
    let task = new TaskModel(
      Date.now(),
      this.name.value ? this.name.value : "",
    );
    this.store.dispatch(addTask({ task }));
    this.name = new FormControl("");
  }
}
```

Als erstes bereiten wir in der Datei die `FormControl` für die Eingabe des Namens vor (die
Aufgabenstellung sieht vor, dass der Name der zu erstellenden Task mit einem Reactive Forms
eingetragen wird).
Im Constructor instanzieren wir darauf direkt den Store, um anschliessend die Actions aufrufen zu
können.

Zuletzt bereiten wir auch schon direkt die Funktion für das Erstellen einer neuen Task vor. Dazu
erstellen wir zuerst ein neues Objekt vom Typ `TaskModel`.
Als Parameter geben wir dabei zuerst die id in Form von `Date.now()` mit, da wir so garantieren
können, dass das `id`-Attribut über alle Tasks einzigartig ist.
Als zweiten Parameter geben wir dann, insofern der value der `FormControl` für den Namen nicht `null`
oder `undefned` entspricht, den Inhalt der `FormControl` mit. Entspricht dieser `null` oder
`undefined` geben wir einen leeren String als Namen mit.

Zuletzt instanzieren wir die `FormControl` für den Namen neu, um die das Textfeld für den Nutzer
wieder zu leeren.

Als nächstes muss das entsprechende Template für die Erstellung der Task umgesetzt werden. Das sieht
in diesem Fall aus wie folgt:

```html
<div class="header">
  <a class="header-link" routerLink="">Übersicht</a>
  <a class="header-link" routerLink="/create-task">Task erstellen</a>
</div>

<div class="create-task-container">
  <label class="create-task-label" for="name">Name: </label>
  <input class="create-task-input" id="name" type="text" [formControl]="name" />
  <button
    class="create-task-button"
    (click)="addTask()"
    [disabled]="name.value === ''"
  >
    Create
  </button>
</div>
```

Das Template ist in diesem Fall relativ überschaubar. Als erstes haben wir einen kleinen Header, mit
dem wir zwischen der Übersicht und der Task-Erstellung hin- und herwechseln können.

Darunter befindet sich dann schon die Eingabe für die Task-Erstellung. Wir verbinden einen `Input`
mit der `FormControl` und einen Knopf mit der `addTask()`-Funktion, die wir vorher erstellt haben.
Wie auch schon in Aufgabe 2 wurde für diese Lösung ein rudimentäres Styling umgesetzt, welches ihr
aber **nicht** braucht. Für die Interessierten folgt noch der Inhalt das `SCSS`-Files:

```scss
.header {
  width: 100vw;
  text-align: center;

  .header-link {
    margin: 0 5% 0 5%;
    font-size: 2rem;
  }
}

.create-task-container {
  width: 100vw;
  margin: 5% 0 0 0;
}
```

Die fertige Seite für die Erstellung der Tasks sieht schlussendlich aus wie folgt:
![Task Erstellung](../images/ngrx_applied_exercise_3_create_task_page.png)

## Aufgabe 3 - Übersicht

Da wir nun die Erstellung der Tasks ermöglicht haben, können wir nun zum Schluss noch die Seite für
die Übersicht aller offenen Tasks umsetzten.
Die fertige Version der `ts`-Datei für diesen Component sieht aus wie folgt:

```typescript
import { Component } from "@angular/core";
import { RouterLink } from "@angular/router";
import { TaskModel } from "../../models/task-model";
import { Observable } from "rxjs";
import { getTasks } from "../../ngrx/task.selectors";
import { Store } from "@ngrx/store";
import { AsyncPipe } from "@angular/common";
import { completeTask, removeTask } from "../../ngrx/task.actions";

@Component({
  selector: "app-overview",
  imports: [RouterLink, AsyncPipe],
  templateUrl: "./overview.component.html",
  styleUrl: "./overview.component.scss",
})
export class OverviewComponent {
  tasks$ = new Observable<TaskModel[]>();

  constructor(private store: Store<TaskModel[]>) {
    this.tasks$ = this.store.select(getTasks);
  }

  completeTask(id: number) {
    this.store.dispatch(completeTask({ id }));
  }

  removeTask(id: number) {
    this.store.dispatch(removeTask({ id }));
  }
}
```

Als erstes erstellen wir Observable vom Typ `Observable<TaskModel[]>`, in dem wir anschliessend die
Tasks aus dem Store ablegen können.
Im Constructor instanzieren wir daraufhin den Store, um die Ausführung von Actions und das Nutzen
von Selectors zu ermöglichen. Innerhalb des Constructors befüllen wir zudem direkt das vorher
erstellte Observable mit den Tasks, indem wir den Selector ausführen.

Zuletzt definieren wir direkt die beiden Funktionen für das komplettieren und entfernen der Tasks.
Beide Funktionen nehmen jeweils die `id` der jeweiligen Task entgegen und rufen mit
`this.store.dispatch()` die enstprechende action aus.

Anschliessend können wir das Template umsetzen, das im Falle dieser Lösung aussieht wie folgt:

```html
<div class="header">
  <a class="header-link" routerLink="">Übersicht</a>
  <a class="header-link" routerLink="/create-task">Task erstellen</a>
</div>

@for (task of tasks$ | async; track task.id) { @if (!task.completed) {
<div class="task-container">
  <p class="task-text">ID: {{ task.id }}</p>
  <p class="task-text">Name: {{ task.name }}</p>
  <p>{{task.completed}}</p>
  <div class="task-button-container">
    <button (click)="completeTask(task.id)">Task abschliessen</button>
    <button (click)="removeTask(task.id)">Task entfernen</button>
  </div>
</div>
} } @empty {
<p class="task-text">Keine Tasks vorhanden</p>
}
```

Zuoberst haben wir den exakt selben Header wie im Component für die Erstellung der Tasks.

Spannend wird es aber ab Zeile 6. Dort iterieren wir übr das `tasks$`-Observable. (`|async`-Pipe
nicht vergessen!)
Darauf prüfen wir, bevor etwas angezeigt wird, für jede Task, ob das `completed`-Attribut auf `false`
gesetzt ist. Die Task wird nur angezeigt, solange das der Fall ist.
Insofern `completed` auf `false` gesetzt ist, wird anschliessend die `id` und der `name` der Task angezeigt. Für jede Task werden zudem zwei Knöpfe angezeigt, über die man sie jeweils abschliessen oder entfernen kann.
Für den Fall, dass `tasks$` keinen Inhalt hat, definieren wir `@empty` den Text "Keine Tasks vorhanden" als "Platzhalter", damit nicht einfach nichts angezeigt wird.

Für die Interessierten folgt noch das SCSS-File zum Component:

```scss
.header {
  width: 100vw;
  text-align: center;

  .header-link {
    margin: 0 5% 0 5%;
    font-size: 2rem;
  }
}

.task-container {
  width: 45%;
  display: inline-block;
  background: blueviolet;
  border: 2px black solid;
  margin: 5% 1% 0 1%;
  .task-text {
    font-size: 2rem;
  }

  .task-button-container {
    width: 100%;
    display: flex;
  }
}
```

Der fertige Component sollte dann aussehen wie folgt:
![Overview Component](../images/ngrx_applied_exercise_3_overview_page.png)
