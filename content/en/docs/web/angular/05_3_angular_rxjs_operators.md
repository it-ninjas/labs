---
title: "RxJS Operators"
type: docs
linkTitle: "RxJS Operators"
weight: 28
date: 2023-04-21
description: >
  Modul #F6 - Angular - RxJS Operators
---

## Ziele

- Du kennst, die viele verschiedenen RxJS-Operatoren und kannst diese auch anwenden.

## Operators

RxJS bietet eine Vielzahl von Operatoren, die auf Observables angewendet werden können, um sie zu transformieren, zu filtern, zu kombinieren und vieles mehr. Folgend werden die wichtigsten vorgestellt.

## Piping

Piping ist ein wichtiger Operator, der es ermöglicht, eine Observable-Kette zu erstellen, indem verschiedene Operatoren nacheinander angewendet werden. Der Piping-Operator wird verwendet, um die Lesbarkeit und Wartbarkeit von Observable-Ketten zu verbessern, indem man sie in kleinere und leichter zu verstehende Abschnitte unterteilt.
Wie [map](./05_3_angular_rxjs_operators#map) funktioniert kann man hier nachlesen.

```typescript
import { of, map } from "rxjs";

of(1, 2, 3)
  .pipe(map((x) => x * x))
  .subscribe((v) => console.log(`value: ${v}`));

// value: 1
// value: 4
// value: 9
```

## Creation Operators

### from

Der `from` Operator, wandelt eine Reihe von Werten oder ein Iterable in ein Observable um. Er akzeptiert eine Quelle von Werten, wie beispielsweise ein Array oder eine Map, und gibt ein Observable zurück, das die Werte dieser Quelle nacheinander emittiert.

```typescript
import { from } from "rxjs";

const source = from([1, 2, 3, 4, 5]);

source.subscribe((value) => console.log(value));

// 1
// 2
// 3
// 4
// 5
```

### of

Der `of` Operator, wandelt wie der `from` Operator auch eine feste Anzahl von Werten in ein Observable um. Der Operator akzeptiert jedoch eine beliebige Anzahl von Argumenten und gibt ein Observable zurück, das diese Argumente in der Reihenfolge ihres Auftretens emittiert.

Der Operator ist besonders nützlich, um eine feste Anzahl von Werten zu emittieren, die bekannt sind, bevor das Observable abonniert wird. Wenn man eine Quelle von Werten hat, die dynamisch generiert werden, ist es wahrscheinlich sinnvoller, den `from` Operator zu verwenden.

```typescript
import { of } from "rxjs";

const source = of(1, 2, 3, 4, 5);

source.subscribe((value) => console.log(value));

// 1
// 2
// 3
// 4
// 5
```

## Join Creation Operators

Info: In RxJS bezieht sich "Emission" auf den Wert, der von einem Observable emittiert oder ausgegeben wird.

### forkJoin

`forkJoin` ist ein Kombinationsoperator, der ein Array von Observables akzeptiert und wartet, bis alle Observables ihre Emissionen abgeschlossen haben, bevor er ein neues Observable zurückgibt. Das zurückgegebene Observable gibt ein Array von Werten zurück, das den letzten Wert jedes Observables enthält, das dem `forkJoin` Operator übergeben wurde.

Dieser Operator ist besonders nützlich, wenn man mehrere Quellen von Daten hat, die parallel verarbeitet werden können, und man auf alle Ergebnisse warten muss, bevor man mit der nächsten Phase der Verarbeitung fortfahren kann.

Zu beachten ist, dass der Operator fehlschlägt, wenn eines der übergebenen Observables einen Fehler emittiert, bevor es seine Emissionen abgeschlossen hat.

```typescript
import { forkJoin, of } from "rxjs";

const source1 = of("Hello");
const source2 = of("World!");

forkJoin([source1, source2]).subscribe(([value1, value2]) => {
  console.log(value1 + " " + value2);
});

// "Hello World!"
```

### concat

Der `concat` Operator kombiniert mehrere Observables sequentiell, indem er die Emissionen des ersten Observables vollständig verarbeitet, bevor er mit dem nächsten Observable fortfährt. Dies bedeutet, dass das zweite Observable erst dann subscribed wird, wenn das erste Observable seine Emissionen vollständig abgeschlossen hat, und so weiter.

Dieser Operator ist besonders nützlich, wenn man sicherstellen muss, dass bestimmte Aktionen in einer bestimmten Reihenfolge ausgeführt werden müssen, oder wenn man die Emissionen von Observables in einer bestimmten Sequenz verarbeiten muss.

Zu beachten gilt jedoch, dass der Operator blockierend ist und erst dann zur nächsten Phase der Verarbeitung übergeht, wenn das vorherige Observable abgeschlossen wurde.

```typescript
import { concat, of } from "rxjs";

const source1 = of("Hello");
const source2 = of("Dragon Warrior!");

concat(source1, source2).subscribe((value) => {
  console.log(value);
});

// "Hello"
// "Dragon Warrior!"
```

### merge

Der `merge` Operator kombiniert auch mehrere Observables, indem er die Emissionen aller Observables in einem einzigen Observable zusammenführt. Im Gegensatz zum `concat` Operator führt `merge` die Emissionen parallel aus, unabhängig davon, welches Observable die Emissionen zuerst ausgibt.

Beachten muss man jedoch, dass dieser Operator keine Garantie für die Reihenfolge der Emissionen gibt und dass es möglich ist, dass die Emissionen der Observables sich gegenseitig überschneiden.

```typescript
import { merge, of } from "rxjs";

const source1 = of("Hello");
const source2 = of("Dragon Warrior!");

merge(source1, source2).subscribe((value) => {
  console.log(value);
});

// "Hello"
// "Dragon Warrior!"
```

### zip

Der `zip` Operator kombiniert die Emissionen mehrerer Observables zu einer einzelnen Emission. Dabei werden die Emissionen jedes Observables zu einer Gruppe kombiniert, und sobald alle Observables eine Emission abgegeben haben, wird diese Gruppe als Emission des resultierenden Observables ausgegeben.

Dieser Operator ist besonders nützlich, wenn man mehrere Datenströme kombiniert und sicherstellen muss, dass alle Daten synchronisiert sind. Man muss jedoch beachten, dass der Operator die Emissionen jedes Observables zu einer Gruppe kombiniert, was bedeutet, dass die Grösse jeder Emission vom Observable mit der geringsten Anzahl an Emissionen begrenzt wird.

Auch zu beachten ist, dass der Operator darauf wartet, dass alle Observables eine Emission abgeben, bevor er eine Emission ausgibt. Wenn ein Observable keine Emission abgibt, wird das resultierende Observable keine Emissionen ausgeben.

```typescript
import { zip, of } from "rxjs";

const source1 = of("Hello");
const source2 = of("Dragon");
const source3 = of("Warrior");

zip(source1, source2, source3).subscribe((value) => {
  console.log(value);
});

// ["Hello", "Dragon", "Warrior"]
```

## Transformation Operators

### map

Der meist verwendete RxJS-Operator ist der `map` Operator wird verwendet, um die Werte eines Observables zu transformieren. Es gibt viele Anwendungsfälle für diesen Operator, einschliesslich der Umwandlung von Daten in ein anderes Format, der Extraktion von bestimmten Werten aus einem Datenstrom oder der Anwendung einer Funktion auf jeden Wert in einem Observable.

```typescript
import { of } from "rxjs";
import { map } from "rxjs/operators";

const source = of(1, 2, 3, 4, 5);

const doubled = source.pipe(map((value) => value * 2));

doubled.subscribe((value) => console.log(value));

// 2
// 4
// 6
// 8
// 10
```

### mergeALL/mergeMap

Es kann passieren das man Observable eine Methode aufruft, die ein weiteres Observable zurückgibt, das ist vielfach der Fall bei API-Abfrage. Somit hat man dann ein äusseres und inneres Observable, um nun an die Daten zu gelangen, müsste man auf beide subscriben was auch möglich ist:

```typescript
import { of, from, map } from "rxjs";

const getData = (param) => {
  return of(`retrieved new data with param ${param}`);
};

from([1, 2, 3, 4])
  .pipe(map((param) => getData(param)))
  .subscribe((value) => value.subscribe((data) => console.log(data)));

// retrieved new data with param 1
// retrieved new data with param 2
// retrieved new data with param 3
// retrieved new data with param 4
```

Dies ist aber alles andere als optimal, weshalb man `mergeMap` benutzen kann. `mergeMap` ist eine kombination von `mergeAll` und `map`. `mergeAll` erledigt die subscription auf das innere Observable so muss man dann nicht mehr zweimal subscriben zudem merged es das innere Observable in das äussere.

Beispiel mit `mergeAll`:

```typescript
import { of, from, map, mergeAll } from "rxjs";

const getData = (param) => {
  return of(`retrieved new data with param ${param}`);
};

from([1, 2, 3, 4])
  .pipe(
    map((param) => getData(param)),
    mergeAll(),
  )
  .subscribe((value) => console.log(value));

// retrieved new data with param 1
// retrieved new data with param 2
// retrieved new data with param 3
// retrieved new data with param 4
```

Beispiel mit `mergeMap`:

```typescript
import { of, from, mergeMap } from "rxjs";

const getData = (param) => {
  return of(`retrieved new data with param ${param}`);
};

from([1, 2, 3, 4])
  .pipe(mergeMap((param) => getData(param)))
  .subscribe((value) => console.log(value));

// retrieved new data with param 1
// retrieved new data with param 2
// retrieved new data with param 3
// retrieved new data with param 4
```

### switchAll/switchMap

`switchMap` ist ähnlich wie das `mergeMap`, es subscribed auch das innere Observable. Auch hier ist `switchMap` eine Kombination, und zwar von `switchAll` und `map`. `switchAll` canceled die vorherige Subscription und subscribed auf die neue, wenn ein neues Observable reinkommt.

Wie [delay](../angular/05_3_angular_rxjs_operators#delay) funktioniert kann man hier nachlesen.

Beispiel mit `switchAll`:

```typescript
import { of, from, map, switchAll, delay } from "rxjs";

const getData = (param) => {
  return of(`retrieved new data with param ${param}`).pipe(delay(1000));
};

from([1, 2, 3, 4])
  .pipe(
    map((param) => getData(param)),
    switchAll(),
  )
  .subscribe((value) => console.log(value));

// retrieved new data with param 4
```

Beispiel mit `switchMap`:

```typescript
import { of, from, switchMap, delay } from "rxjs";

const getData = (param) => {
  return of(`retrieved new data with param ${param}`).pipe(delay(1000));
};

from([1, 2, 3, 4])
  .pipe(switchMap((param) => getData(param)))
  .subscribe((value) => console.log(value));

// retrieved new data with param 4
```

### concatMap

Auch `concatMap` subscribed auf das innere Observable. Der Unterschied zum `switchMap` ist das `concatMap` nicht die Subscription canceled, wenn ein neues Observable reinkommt, sondern es subscribed solange nicht auf das nächste Observable bis das momentan fertig ist.

```typescript
import { of, from, delay, concatMap } from "rxjs";

const getData2 = (param) => {
  return of(`2 retrieved new data with param ${param}`).pipe(delay(1000));
};

from([1, 2, 3, 4])
  .pipe(concatMap((param) => getData2(param)))
  .subscribe((value) => console.log(value));

// [wait 1s]
// retrieved new data with param 1
// [wait 1s]
// retrieved new data with param 2
// [wait 1s]
// retrieved new data with param 3
// [wait 1s]
// retrieved new data with param 4
```

### groupBy

Die `groupBy()` Methode ermöglicht es, ein Observable in mehrere Observables aufzuteilen, die auf der Grundlage eines bestimmten Schlüssels gruppiert sind.

Der Prozess besteht darin, die ursprünglichen Emissionen in Gruppen aufzuteilen, die jeweils auf einen eindeutigen Schlüssel abgebildet werden. Jede Gruppe ist ein eigenes Observable, das alle Emissionen enthält, die diesem Schlüssel zugeordnet sind.

```typescript
import { from } from "rxjs";
import { groupBy, mergeMap, toArray } from "rxjs/operators";

interface Person {
  name: string;
  age: number;
}

const people: Person[] = from([
  { name: "John", age: 30 },
  { name: "Jane", age: 25 },
  { name: "Bob", age: 30 },
  { name: "Alice", age: 25 },
]);

people
  .pipe(
    groupBy((person) => person.age),
    mergeMap((group) => group.pipe(toArray())),
  )
  .subscribe((group) => console.log(group));

// [ { name: 'Jane', age: 25 }, { name: 'Alice', age: 25 } ]
// [ { name: 'John', age: 30 }, { name: 'Bob', age: 30 } ]
```

## Filtering Operators

### elementAt

`elementAt()` wir benutzt um, ein Element eines Observable an der angegebenen Indexposition auszugeben und das Observable zu schliessen. Der Operator gibt ein Observable zurück, das nur das angeforderte Element emittiert und dann vollständig schliesst.

Man kann nach der Indexposition auch einen Defaultwert angeben, welcher zurückgegeben wird, wenn das Element an der angegebenen Indexposition nicht gefunden wurde.

```typescript
import { of } from "rxjs";
import { elementAt } from "rxjs/operators";

const source$ = of("A", "B", "C", "D", "E");

// ohne Defaultwert
source$
  .pipe(
    elementAt(2), // 'C'
  )
  .subscribe(console.log);

// mit Defaultwert
source$
  .pipe(
    elementAt(10, "F"), // 'F'
  )
  .subscribe(console.log);
```

### filter

`filter` wird verwendet, um Observable-Elemente zu filtern, die nicht den Bedingungen entsprechen, die in der übergebenen Funktion definiert sind. Die Filterfunktion gibt ein neues Observable zurück, das nur Elemente enthält, die die Bedingungen der Filterfunktion erfüllen.

```typescript
import { of } from "rxjs";
import { filter } from "rxjs/operators";

const source = of(1, 2, 3, 4, 5);
const filtered = source.pipe(filter((x) => x % 2 === 0));
filtered.subscribe((x) => console.log(x));
// 2
// 4
```

### first

Der `first` Operator gibt nur das erste Element aus einem Observable zurück. Man kann den Operator aber auch mittels einer Funktion ergänzen, um eine Bedienung zu schaffen, somit wird dann das erste Element zurückgegeben, welches nach dieser Bedingung zutrifft. Nach der Funktion kann man auch einen Defaultwert hinzufügen, welcher zurückgegeben werden soll, wenn kein Element gefunden wird. Gibt man keinen Defaultwert an und die Bedingung trifft nicht zu, so wird ein fehler ausgegeben.

```typescript
import { of } from "rxjs";
import { first } from "rxjs/operators";

const source = of(1, 2, 3);

source.pipe(first()).subscribe((value) => console.log(value)); // 1

source.pipe(first((x) => x > 2)).subscribe((value) => console.log(value)); // 3

source.pipe(first((x) => x > 3, null)).subscribe((value) => console.log(value)); // null
```

### last

Der `last` Operator funktioniert genau gleich wie der [first](#first) Operator. Nur das hier immer das letzte Element zurückgegeben wird.

```typescript
import { of } from "rxjs";
import { first, last } from "rxjs/operators";

const source = of(1, 2, 3);

source.pipe(last()).subscribe((value) => console.log(value)); // 3

source.pipe(last((x) => x > 2)).subscribe((value) => console.log(value)); // 3

source.pipe(last((x) => x > 3, null)).subscribe((value) => console.log(value)); // null
```

### skip

Der `skip` Operator gibt an, wie viele Ereignisse in einem Observable übersprungen werden sollen, bevor sie an einen Subscriber weitergegeben werden. Es wird verwendet, um den Startpunkt eines Observables zu verschieben.

```typescript
import { of } from "rxjs";
import { skip } from "rxjs/operators";

const source = of(1, 2, 3, 4, 5);
const result = source.pipe(skip(3));
result.subscribe((value) => console.log(value));
// 4
// 5
```

### take

Der `take()` Operator gibt eine bestimmte Anzahl von Werten eines Observables aus und schliesst es dann ab. Der Operator akzeptiert als Parameter die Anzahl der Werte, die ausgegeben werden sollen. Wenn der Parameter nicht angegeben wird, wird standardmässig nur ein Wert ausgegeben. Sind weniger Werte verfügbar asl angegeben, gibt der Operator die Anzahl Werte, die er zur Verfügung hat aus.

```typescript
import { of } from "rxjs";
import { take } from "rxjs/operators";

const source = of(1, 2, 3, 4, 5);

source.pipe(take(3)).subscribe((value) => console.log(value));
// 1
// 2
// 3

source.pipe(take(10)).subscribe((value) => console.log(value));
// 1
// 2
// 3
// 4
// 5
```

### takeUntil

`takeUntil` ist ein Operator, der ein Observable subscribed, bis ein anderes Observable ein Ereignis ausgibt. Es wird verwendet, um das Subscriben eines Observables zu beenden, basierend auf einem anderen Observable.

Das zweite Observable wird als "Abbruch- oder Trigger-Observable" bezeichnet. Sobald das Trigger-Observable ein Ereignis ausgibt, wird das Subscriben des ersten Observables beendet und das Observable gibt keine weiteren Werte mehr aus.

```typescript
import { interval, Subject } from "rxjs";
import { takeUntil } from "rxjs/operators";

const stop$: Subject<void> = new Subject<void>();

// ein Observable, das jede Sekunde eine Zahl sendet
const observable$ = interval(1000).pipe(takeUntil(stop$));

observable$.subscribe((val) => console.log(val));

// Observable nach 5 Sekunden stoppen
setTimeout(() => {
  stop$.next();
  stop$.complete();
}, 5000);

// 0
// 1
// 2
// 3
// 4
```

In der Praxis wird es häufig in Nomination von `ngOnDestroy` verwendet. Den `ngOnDestroy()`ist eine Lifecycle-Methode welche aufgerufen wird, bevor eine Komponente aus dem DOM entfernt wird. Somit kann man `takeUntil` verwenden, um Subscriptions zu beenden und somit Ressourcen freizugeben und Speicherlecks zu vermeiden.

```typescript
import { Component, OnInit, OnDestroy } from "@angular/core";
import { interval, Subject } from "rxjs";
import { takeUntil } from "rxjs/operators";

@Component({
  // ..
})
export class WeaponComponent implements OnInit, OnDestroy {
  private destroy$: Subject<void> = new Subject<void>(); // Ein Subject erstellen, das das Zerstören des Observable signalisiert

  ngOnInit() {
    interval(1000)
      .pipe(takeUntil(this.destroy$)) // Das Observable subscriben und es beenden, wenn das destroy$-Subject ein Ereignis auslöst
      .subscribe((value) => console.log(value));
  }

  ngOnDestroy() {
    this.destroy$.next(); // Das destroy$-Subject ein Ereignis auslösen, um das Observable zu beenden
    this.destroy$.complete(); // Das destroy$-Subject komplett schliessen, um Speicherlecks zu vermeiden
  }
}
```

## Error Handling Operators

### catchError

`catchError` ist ein Operator, der verwendet wird, um Fehler in Observables zu verarbeiten. Er erlaubt es, einen alternativen Observable zurückzugeben oder eine andere Aktion auszuführen, wenn ein Fehler im ursprünglichen Observable auftritt.

Denn normalerweise, wenn ein Fehler in einem Observable auftritt, wird das gesamte Observable abgebrochen und keine weiteren Werte emittiet. Wenn man jedoch `catchError` verwendet, kann man eine Funktion angeben, die den Fehler verarbeitet und ein alternatives Observable zurückgibt. Dadurch kann man das Observable weiterlaufen lassen, anstatt es abzubrechen.

```typescript
import { of } from "rxjs";
import { catchError, map } from "rxjs/operators";

const source = of(1, 2, 3, 4, 5);

const result = source.pipe(
  map((value) => {
    if (value === 3) {
      throw new Error("Value cannot be 3");
    }
    return value;
  }),
  catchError((error) => {
    console.log(`Caught error: ${error}`);
    return of("one", "two");
  }),
);

result.subscribe({
  next: (value) => {
    console.log(`Result: ${value}`);
  },
  error: (error) => {
    console.log(`Error: ${error}`);
  },
  complete: () => {
    console.log("Complete");
  },
});

// Result: 1
// Result: 2
// Caught error: Error: Value cannot be 3
// Result: one
// Result: two
// Complete
```

### retry

`retry()` versucht, das Observable beim ersten Fehler neu zu starten. Dabei wird das gesamte Observable neu subscribed. Wenn das erneute Subscriben wieder einen Fehler erzeugt, wird das Observable erneut neu gestartet und so weiter, bis das erneute Subscriben erfolgreich ist.

Wenn man dies aber nicht unendlich machen möchte, bis man erfolgreich ist, kann man die Anzahl der Wiederholungen als Parameter dem `retry()` mitgeben.

In der Praxis verwendet man es viel, um API-Request zu wiederholen, wenn sie fehlschlagen, da sie evtl. zu lange hatten.

```typescript
import { interval } from "rxjs";
import { retry, map } from "rxjs/operators";

const result = interval(1000).pipe(
  map((value) => {
    if (Math.random() < 0.5) {
      throw new Error("Something went wrong");
    }
    return value;
  }),
  retry(2),
);

result.subscribe(
  (value) => console.log("Value: ", value),
  (error) => console.log("Error: ", error),
);
```

## Utility Operators

### tap

Das `tap` Operator ermöglicht es, "side actions" auf den Werten auszuführen, die von einem Observable emittiert werden, ohne die emittierten Werte zu verändern. Man kann es verwenden, um die emittierten Werte zu debuggen und zu untersuchen oder um eine Aktion auf Grundlage dieser Werte auszulösen, ohne die Observable-Pipeline zu beeinflussen.

```typescript
import { tap } from "rxjs/operators";
import { of } from "rxjs";

const source = of(1, 2, 3);

source
  .pipe(
    tap((value) => console.log(`Value before: ${value}`)),
    tap((value) => value * 2),
    tap((value) => console.log(`Value after: ${value}`)),
  )
  .subscribe((value) => console.log(value));

// Value before: 1
// Value after: 1
// 1
// Value before: 2
// Value after: 2
// 2
// Value before: 3
// Value after: 3
// 3
```

### delay

`delay` verzögert das Weiterleiten von Werten eines Observable um eine bestimmte Zeitspanne. Dadurch kann man eine Verzögerung in der Ausführung von Aktionen erzielen, was besonders nützlich ist, wenn man z.B. Animationen oder Zeitabhängigkeiten implementiert.

```typescript
import { delay, of } from "rxjs";

const source = of(1, 2, 3, 4, 5);
const delayedSource = source.pipe(delay(1000));

// dauert eine Sekunde bis alle Werte ausgegben werden
delayedSource.subscribe((value) => console.log(value));
```

## Conditional and Boolean Operators

### every

Der `every` Operator prüft, ob alle Werte, die von einem Observable emittiert werden, eine bestimmte Bedingung erfüllen. Wenn die Bedingung für alle Werte `true` zurückgibt, gibt der Operator `true` zurück. Wenn die Bedingung für mindestens einen Wert `false` zurückgibt, gibt auch der Operator `false` zurück.

```typescript
import { from } from "rxjs";
import { every } from "rxjs/operators";

const source = from([1, 2, 3, 4, 5]);

const resultTrue = source.pipe(every((value) => value < 6));
const resultFalse = source.pipe(every((value) => value < 5));

resultTrue.subscribe(console.log); // Output: true
resultFalse.subscribe(console.log); // Output: false
```

### find

`find` ist ein Operator, welcher es ermöglicht, in einem Observable nach dem ersten Element zu suchen, das eine angegebene Bedingung erfüllt. Wenn das Element gefunden wird, wird es in einem Observable zurückgegeben und die Suche wird beendet.

```typescript
import { from } from "rxjs";
import { find } from "rxjs/operators";

const numbers = from([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

numbers.pipe(find((x) => x > 5)).subscribe(
  (value) => console.log(value), // 6
);

numbers.pipe(find((x) => x > 10)).subscribe(
  (value) => console.log(value), // undefined
);
```

### findIndex

Der `findIndex` Operator gibt den Index des ersten Elements in eines Observables zurück, das die angegebene Bedingung erfüllt. Sie funktioniert ähnlich wie [find](#find), aber gibt den Index des Elements statt des Elements selbst zurück.

```typescript
import { findIndex, from } from "rxjs";

const numbers = from([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

numbers.pipe(findIndex((x) => x > 5)).subscribe(
  (value) => console.log(value), // 5
);

numbers.pipe(findIndex((x) => x > 10)).subscribe(
  (value) => console.log(value), // -1
);
```

### isEmpty

`isEmpty` ist ein Operator, welcher prüft, ob eine Observable leer ist oder nicht. Wenn das Observable leer ist, gibt der Operator `true` zurück, andernfalls `false`.

```typescript
import { of } from "rxjs";
import { isEmpty } from "rxjs/operators";

const emptySource = of();
const fullSource = of(1, 2, 3, 4, 5);

const emptyObservable = emptySource.pipe(isEmpty());
const fullObseravle = fullSource.pipe(isEmpty());

emptyObservable.subscribe((value) => console.log(value)); // true
fullObseravle.subscribe((value) => console.log(value)); // false
```
