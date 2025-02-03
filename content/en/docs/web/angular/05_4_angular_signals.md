---
title: "Signals"
type: docs
linkTitle: "Signals"
weight: 30
date: 2024-02-27
description: >
  Modul #F6 - Angular - Signals in Angular
---

## Ziele

- Du weisst, was Signals in Angular sind und wie man diese verwendet.

## Signals

Signals funktionieren in Angular ähnlich wie Observables. Ein Signal umfasst einen Wrapper um einen Wert, welcher Konsumenten benachrichtigen kann, wenn sich der Wert ändert.
Signals gibt es als Read-Only- oder als Writable-Variante. Der Wert eines Signals wird immer durch eine `getter`-function gelesen. Wenn man ein Signal aufruft, wird der Wert darin gelesen.
Man kann Signals von primitiven bis hin zu komplexen Datenstrukturen definieren.

### Writable Signals

Ein writable Signal kann ganz einfach erstellt werden, nämlich indem man die `signal()`-Funktion mit dem initialen Wert aufruft.

```ts
import { signal } from "@angular/core";
const count = signal(0);

// Signals are getter functions - calling them reads their value.
console.log("The count is: " + count());
```

Wenn man den gesamten Wert unabhängig vom momentanen ändern möchte, kann man `.set()` aufrufen.

```ts
count.set(3);
```

Möchte man jedoch mithilfe des momentanen Wertes etwas machen, muss man `.update()` aufrufen.

```ts
// Increment the count by 1.
count.update((value) => value + 1);
```

Die Variable `count` nimmt übrigens automatisch den Typ `WritableSignal` an.

### Computed signals (Read-Only)

Ein Computed Signal erhält seinen Wert von einem andern Signal, meist von einem Writable Signal. Möchte man ein Computed Signal erstellen, muss die `computed()` Funktion verwendet werden.

```ts
const count: WritableSignal<number> = signal(0);
const doubleCount: Signal<number> = computed(() => count() * 2);
```

Bei einem Computed Signal kann man nicht direkt einen wert mit `.set()` setzen, wie es bei den Writable Signals der Fall ist. Es wird einen Compilation Error geben, wenn man das versucht.

### lazily evaluated and memorized

Der Wert des Computed Signals wird so lange nicht berechnet, bis man es aufruft, danach wird der Wert gecached.
Wenn man nun den Wert des Computed Signals erneut liest, wird es nicht neu berechnet, sondern nimmt den Wert aus dem Cache.
Wenn man jedoch das Writable Signal, welches im Computed Signal verwendet wird, ändert, weiss Angular, dass der Wert im Cache für das Computed Signal nicht mehr valide ist.
Somit wird der Wert neu berechnet wenn man das Computed Signal das nächste Mal aufruft und wieder darin gespeichert.

### Computed signal dependencies are dynamic

Es werden nur die Signals getracked, die während der Ableitung auch gelesen werden.

Zum Beispiel wird im folgenden Beispiel das Signal `count` nur gelesen, wenn das Signal `showCount` `true ` entspricht.

```ts
const showCount = signal(false);
const count = signal(0);
const conditionalCount = computed(() => {
  if (showCount()) {
    return `The count is ${count()}.`;
  } else {
    return "Nothing to see here!";
  }
});
```

Beim Lesen von `conditionalCount` wird, wenn `showCount` `false` ist, die Nachricht "Nothing to see here!" zurückgegeben, ohne das Signal `count` zu lesen.
Das bedeutet, dass eine spätere Aktualisierung von `count` nicht dazu führt, dass `conditionalCount` neu berechnet wird.

Wenn `showCount` auf `true` gesetzt wird und dann erneut `conditionalCount` gelesen wird, wird die Ableitung erneut ausgeführt und der Zweig ausgeführt, in dem `showCount` wahr ist.
Es wird die Nachricht zurückgegeben, die den Wert von `count` anzeigt. Eine Änderung von `count` würde dann den zwischengespeicherten Wert von `conditionalCount ungültig machen.

Zu beachten ist, dass Dependencies während einer Ableitung sowohl hinzugefügt als auch entfernt werden können. Wenn `showCount` später wieder auf `false` gesetzt wird, wird `count` nicht mehr als Dependency von `conditionalCount` betrachtet.

### Effects

Signals sind ein interessanter Aspekt in Angular, da sie consumers benachrichtigen, wenn sie sich ändern. Der `effect` ist eine Operation, welche ausgeführt wird, sobald sich ein oder mehrere Werte eines Signals ändern.
`effect`s werden folgendermassen erstellt:

```ts
effect(() => {
  console.log(`The current count is: ${count()}`);
});
```

`effect`s werden immer mindestens einmal ausgeführt. Wenn ein `effect` ausgeführt wird, verfolgt er alle gelesenen Werte des Signals. Immer wenn sich einer dieser Werte ändert, wird der `effect` erneut ausgeführt.
Ähnlich wie bei Computed Signals verfolgen `effect`s ihre Dependencies dynamisch und erfassen nur Signals, die in der aktuellsten Ausführung gelesen wurden.
`effect`s werden immer asynchron während des Change-Detection-Prozesses ausgeführt.

`effect`s werden in den meisten Anwendungsfällen nur selten benötigt, können jedoch in speziellen Situationen durchaus nützlich sein.
Hier sind einige Beispiele für Situationen, in denen ein `effect` eine gute Lösung darstellen kann:

1. Logging von angezeigten Daten und deren Änderungen, entweder für Analysezwecke oder als Debugging-Tool.
2. Synchronisierung von Daten mit `window.localStorage`.
3. Hinzufügen von benutzerdefiniertem DOM-Verhalten, das nicht mit der Template-Syntax ausgedrückt werden kann.
4. Durchführung von benutzerdefiniertem Rendering auf einem `<canvas>`, in einer Diagrammbibliothek oder einer anderen UI-library von Drittanbietern.

## Advanced topics

### Signal equality functions

Wenn man ein Signal (egal ob Writable oder Computed) erstellt, kann man optional eine `equality function` angeben. Diese wird verwendet, um zu prüfen, ob ein neuer Wert sich zum vorherigen unterscheidet.

```ts
import _ from "lodash";

const data = signal(["test"], { equal: _.isEqual });
// Even though this is a different array instance, the deep equality
// function will consider the values to be equal, and the signal won't
// trigger any updates.
data.set(["test"]);
```

### Reading without tracking dependencies

Vereinzelt ist es erforderlich, Code auszuführen, der möglicherweise Signale innerhalb einer reaktiven Funktion wie `computed` oder `effect` liest, ohne eine Dependency zu erstellen.

Nehmen wir beispielsweise an, dass bei einer Änderung von `currentUser` der Wert eines `counter`s protokolliert werden soll. Es kann ein Effekt erstellen werden, der beide Signale liest:

```ts
effect(() => {
  console.log(`User set to ${currentUser()} and the counter is ${counter}`);
});
```

Dieses Beispiel gibt eine Meldung aus, wenn sich entweder `currentUser` oder `counter` ändert.
Wenn der Effekt jedoch nur dann ausgeführt werden soll, wenn sich `currentUser` ändert, ist das Lesen von `counter` nur zufällig, und Änderungen an `counter` sollten keine neue Meldung protokollieren.

Man kann verhindern, dass ein Signal-Lesen durchgeführt wird, indem man seinen Getter mit `untracked` aufruft:

```ts
effect(() => {
  console.log(
    `User set to ${currentUser()} and the counter is ${untracked(counter)}`,
  );
});
```

`untracked` ist auch nützlich, wenn ein Effekt externen Code aufrufen muss, der nicht als Dependency behandelt werden soll:

```ts
effect(() => {
  const user = currentUser();
  untracked(() => {
    // If the `loggingService` reads signals, they won't be counted as
    // dependencies of this effect.
    this.loggingService.log(`User set to ${user}`);
  });
});
```

### Effect cleanup functions

Effekte können lang laufende Operationen starten, die abgebrochen werden sollten, wenn der Effekt zerstört wird oder bevor die erste Operation abgeschlossen ist und der Effekt erneut gestartet wird.
Wenn man einen Effekt erstellt, kann die Funktion optional eine `onCleanup`-Funktion als ihren ersten Parameter akzeptieren.
Diese `onCleanup`-Funktion ermöglicht es, einen Callback zu registrieren, welcher aufgerufen wird, bevor der nächste Durchlauf des Effekts beginnt oder wenn der Effekt zerstört wird.

```ts
effect((onCleanup) => {
  const user = currentUser();
  const timer = setTimeout(() => {
    console.log(`1 second ago, the user became ${user}`);
  }, 1000);
  onCleanup(() => {
    clearTimeout(timer);
  });
});
```
