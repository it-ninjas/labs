---
title: "Pipes"
type: docs
linkTitle: "Pipes"
weight: 19
date: 2022-03-14
description: >
    In diesem Kapitel findet man relevante Informationen zu Pipes.
---
## Ziele
* Du weisst, was Pipes sind und wozu man sie benötigt.
* Du kennst, die verschiedenen Arten von Pipes und wie man sie anwendet.
* Du kannst, selbst Custom Pipes erstellen.

## Pipes
Jede Anwendung beginnt mit einer scheinbar einfachen Aufgabe: Daten abrufen, transformieren und Benutzern zeigen.
Das Abrufen von Daten kann so einfach wie das Erstellen einer lokalen Variablen oder so komplex wie das Streamen von Daten über ein WebSocket sein.
Sobald Daten eingehen, könnte man ihre rohen toString-Werte direkt in die View übertragen. Dies führt jedoch selten zu einer guten user experience. In den meisten Anwendungsfällen
bevorzugen Benutzer beispielsweise die Anzeige eines Datums in einem einfachen Format wie `15. January 1929` anstelle des rohen Stringformats `Tu 15. January 1929 00:00:00 GMT-0700 (Pacific Daylight Time)`.

Es ist klar, dass einige Werte von etwas Bearbeitung profitieren. Viele der Transformationen werden sowohl innerhalb als auch zwischen Anwendungen wiederholt.
Dazu sind Pipes sehr praktisch. Man kann sie sich fast als Stile vorstellen.

Eine Pipe nimmt Daten als Eingabe auf und wandelt sie in eine gewünschte Ausgabe um.
In diesem Beispiel verwenden wir Pipes, um das Datum der Geburtstage eines Components in ein leserliches Datum umzuwandeln.

```typescript
import {Component} from '@angular/core';

@Component({
    // ..
})
export class BirthdaysComponent {
    // ..

    datesOfBirth: Date[] = [
        new Date(1412, 0, 23),
        new Date(1823, 2, 12),
        new Date(1945, 3, 20),
        new Date(2023, 10, 20),
    ];
    
    // ..
}
```
```html
<div *ngFor="let birthday of birthdays; let i = index">
    <p>{{ birthday }}, {{ datesOfBirth[i] | date }}</p>
</div>
```

## Parametrisierte Pipes
Eine Pipe kann eine beliebige Anzahl optionaler Parameter akzeptieren, um ihre Ausgabe zu optimieren. Um einer Pipe Parameter hinzuzufügen,
fügen wir nach dem Pipe-Namen einen Doppelpunkt (:) und danach den Parameterwert (z. B. date: `MMM/dd/yy`) hinzu.
Wenn die Pipe mehrere Parameter akzeptiert, trennen wir die Werte durch Doppelpunkte (z. B. Slice: 1: 5).

Unser Beispiel von vorher könnten wir z.B. so ausgeben:
```html
<div *ngFor="let birthday of birthdays; let i = index">
    <p>{{ birthday }}, {{ datesOfBirth[i] | date:"MMM/dd/yy" }}</p>
</div>
```

## Chaining Pipes
Wir können Pipes in nützlichen Kombinationen miteinander verketten. Im folgenden Beispiel wird der Geburtstag an die DatePipe und an die UpperCasePipe
angekettet, um den Geburtstag in Grossbuchstaben anzuzeigen.

```html
<div *ngFor="let birthday of birthdays; let i = index">
    <p>{{ birthday }}, {{ datesOfBirth[i] | date: "MMM/dd/yy" | uppercase }}</p>
</div>
```

Das Datum wird nun so angezeigt: APR/20/45

## AsyncPipe
Die AsyncPipe wird verwendet, um Observables oder Promises im Template zu subscriben und automatisch zu aktualisieren, sobald neue Werte verfügbar sind.
```html
<p>{{ myObservableData$ | async }}</p>
<p>{{ myPromiseData | async }}</p>
<p>{{ myObservableData$ | async | uppercase }}</p>
```

## Custom Pipes
Für spezielle Anwendungsfälle können wir auch unsere eigenen Pipes schreiben. 

Wir können Beispielsweise die Schreibweise eines Strings anhand einer Custom Pipe im Template verändern.
``` html
 <li *ngFor="let birthday of birthdays">{{ birthday | capitalize }}</li>
```

Der Code für die Custom Pipe dieses Beispiels würde so aussehen:
```typescript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'capitalize'
})
export class CapitalizePipe implements PipeTransform {
    transform(value: string): string {
        if (value) {
            return value.charAt(0).toUpperCase() + value.slice(1);
        }
        return '';
    }
}
```
* Um Angular mitzuteilen, dass dies eine Pipe ist, wenden wir den `@Pipe` Decorator an, welchen wir aus `@angular/core` importieren.
* Die Pipe-Klasse implementiert die Methode `transform` des PipeTransform Interface, die einen Eingabewert gefolgt von optionalen Parametern akzeptiert und den transformierten Wert zurückgibt.
* Für jeden an die Pipe übergebenen Parameter gibt es ein zusätzliches Argument für die Methode `transform`. Unsere Pipe hat einen solchen Parameter: die `extension`.
* Mit dem `@Pipe` Decorator können wir den Pipe-Namen definieren, welchen wir im Template verwenden.

