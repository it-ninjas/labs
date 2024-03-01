---
title: "Signals"
type: docs
linkTitle: "Signals"
weight: 29
date: 2024-02-27
description: >
    Modul #F6 - Angular - Signals in Angular
---

## Signals
Signals sind etwas Ähnliches wie Observable von RxJs. Es ist ein Wrapper um einen Wert, welcher Konsumenten benachrichtigen kann, wenn sich der Wert ändert.
Signals gibt es als Read-Only oder als Writable. Der Wert eines Signals wird immer durch eine getter-function gelesen. Wenn man ein Signal aufruft, wird der Wert darin gelesen.
Man kann in Signals von primitiven bis hin zu komplexen Datenstrukturen wrappen

### Writable Signals
Ein writable Signal kann ganz simple erstellt werden, in dem man die `signal()` funktion aufruft mit dem initialen Wert.
```ts
const count = signal(0);

// Signals are getter functions - calling them reads their value.
console.log('The count is: ' + count());
```

Wenn man den gesamten Wert unabhängig vom momentanen ändern möchte, kann man `.set()` aufrufen.
```ts
count.set(3);
```

Möchte man jedoch mithilfe des momentanen Wertes was machen möchte, muss man `.update()` aufrufen.
```ts
// Increment the count by 1.
count.update(value => value + 1);
```

Die Variabel `count` hat automatisch den Type `WritableSignal`.

### Computed signals (Read-Only)
Ein Computed Signal erhält seinen Wert von einem andern Signal, meist ein Writable Signal. Möchte man ein Computed Signal erstellen so die `computed()` Funktion verwenden.
```ts
const count: WritableSignal<number> = signal(0);
const doubleCount: Signal<number> = computed(() => count() * 2);
```

Bei einem Computed Signal kann man nicht direkt einen wert mit `.set()` setzen wie bei den Writable. Es wird einen Compilation Error geben.

### lazily evaluated and memoized
Der Wert des Computed Signals wird so lange nicht berechnet bis man es aufruft, danach wird der Wert gecached.
Wenn man nun den Wert des Computed Signals erneut liest, wird es nicht neu berechnet, sondern nimmt den Wert aus dem Cache.
Wenn man jedoch das Writable Signal, welches im Computed Signal verwendet wird ändert, weiss angular das der Wert im Cache für das Computed Signal nicht mehr valid ist.
Somit wird der Wert neu berechnet wenn man das Computed Signal das nächste Mal aufruft und wieder gespeichert.

### Computed signal dependencies are dynamic
Es werden nur die Signals getracked, die während der Ableitung auch gelesen werden.

Zum Beispiel wird im folgenden Beispiel das Signal "count" nur gelesen, wenn das Signal "showCount" wahr ist
```ts
const showCount = signal(false);
const count = signal(0);
const conditionalCount = computed(() => {
  if (showCount()) {
    return `The count is ${count()}.`;
  } else {
    return 'Nothing to see here!';
  }
});
```
Beim Lesen von `conditionalCount` wird, wenn `showCount` `false` ist, die Nachricht "Hier gibt es nichts zu sehen!" zurückgegeben, ohne das Signal `count` zu lesen. 
Das bedeutet, dass eine spätere Aktualisierung von `count` nicht dazu führt, dass `conditionalCount` neu berechnet wird.

Wenn `showCount` auf `true` setzen und dann erneut `conditionalCount` lesen, wird die Ableitung erneut ausgeführt und der Zweig ausgeführt, in dem `showCount` wahr ist. 
Es wird die Nachricht zurückgegeben, die den Wert von `count` anzeigt. Eine Änderung von `count` würde dann den zwischengespeicherten Wert von `conditionalCount ungültig machen.

Zu beachten ist, dass dependencies während einer Ableitung sowohl hinzugefügt als auch entfernt werden können. Wenn `showCount` später wieder auf `false` gesetzen wird, wird `count` nicht mehr als dependencies von `conditionalCount` betrachtet.


### Effects
Signals sind ein interessanter Aspekt in Angular, da sie consumers benachrichtigen, wenn sie sich ändern. Der `effect` ist eine Operation, welche ausgeführt wird sobald ein oder mehrere Werte eines Signals ändern.
`effect` werden folgendermassen erstellt:
```ts
effect(() => {
  console.log(`The current count is: ${count()}`);
});
```

`effect` werden im minimum immer einmal ausgeführt. Wenn ein `effect` ausgeführt wird, verfolgt er alle gelesenen Werte des Signals. Immer wenn sich einer dieser Werte ändert, wird der `effect` erneut ausgeführt.
Ähnlich wie bei computed signal verfolgen `effect` ihre dependencies dynamisch und erfassen nur Signals, die in der aktuellsten Ausführung gelesen wurden.
`effect` werden immer asynchron während des change detection process ausgeführt.

`effect` werden in den meisten Anwendungsfällen selten benötigt, können jedoch in speziellen Situationen nützlich sein. 
Hier sind einige Beispiele von Situationen, in denen ein `effect` eine gute Lösung sein könnte:
1. Logging von angezeigten Daten und deren Änderungen, entweder für Analysezwecke oder als Debugging-Tool.
2. Synchronisierung von Daten mit `window.localStorage`.
3. Hinzufügen von benutzerdefiniertem DOM-Verhalten, das nicht mit der Template-Syntax ausgedrückt werden kann.
4. Durchführung von benutzerdefinierter rendering auf einem `<canvas>`, in einer Diagrammbibliothek oder einer anderen UI-library von Drittanbietern.

## Advanced topics
### Signal equality functions
Wenn man ein Signal (egal ob Writable oder computed) erstellt, kann man optional eine `equality function` angeben. Diese wird verwendet um zu prüfen, ob ein neuer Wert sich zum vorherigen unterscheidet.
```ts
import _ from 'lodash';

const data = signal(['test'], {equal: _.isEqual});
// Even though this is a different array instance, the deep equality
// function will consider the values to be equal, and the signal won't
// trigger any updates.
data.set(['test']);
```

### Reading without tracking dependencies
Vereinzelt ist es erforderlich, Code auszuführen, der möglicherweise Signale innerhalb einer reaktiven Funktion wie `computed` oder `effect` liest, ohne eine dependency zu erstellen.

Beispielsweise, nehmen wir an, dass bei einer Änderung von `currentUser` der Wert eines `counter` protokolliert werden soll. Es kann ein Effekt erstellen werden, der beide Signale liest:
```ts
effect(() => {
  console.log(`User set to ${currentUser()} and the counter is ${untracked(counter)}`);
});
```

Dieses Beispiel gibt eine Meldung aus, wenn sich entweder `currentUser` oder `counter` ändert. 
Wenn der Effekt jedoch nur dann ausgeführt werden soll, wenn sich `currentUser` ändert, ist das Lesen von `counter` nur zufällig, und Änderungen an `counter` sollten keine neue Meldung protokollieren.

Man kann verhindern, dass ein Signal-Lesen verfolgt wird, indem man seinen Getter mit `untracked aufrufen:
```ts
effect(() => {
  console.log(`User set to ${currentUser()} and the counter is ${untracked(counter)}`);
});
```

`untracked` ist auch nützlich, wenn ein Effekt externen Code aufrufen muss, der nicht als dependency behandelt werden soll:
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
Diese `onCleanup`-Funktion ermöglicht es, einen callback zu registrieren, welcher aufgerufen wird, bevor der nächste Durchlauf des Effekts beginnt oder wenn der Effekt zerstört wird.
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

