---
title: "Dependency Injection"
type: docs
linkTitle: "Dependency Injection"
weight: 16
date: 2023-05-04
description: >
  Modul #F6 - Angular - Dependency Injection
---
## Ziele
* Du weisst, was eine Dependency Injection ist und was es in Angular ist.
* Du kannst, eine Dependency Injection anwenden.

## Was sind Dependencies (Abhängigkeiten)
Um eine loose Kopplung zu erreichen, werden verschiedene Aufgaben wie das Laden von Server-Daten in verschiedene Dateien ausgelagert. Die einzelnen Klassen haben Abhängigkeiten zu einander. In Angular gibt man die Abhängigkeiten zu anderen Klassen oft z.B. im Konstruktor an.

Angular erstellt und übergibt dann automatisch Instanzen dieser Klassen beim Laden der entsprechenden Klasse.
Auf diese Weise werden die Klassen wiederverwendbarer und einfacher testbar.

## Was ist eine Dependency Injection
Dependency Injection ist ein Coding pattern, bei welchem Klassen alle Abhängigkeiten von externen Quellen erhalten, anstatt sie selbst zu erstellen.

## Dependency Injection in Angular
Der Angular Dependency Injector liefert uns Vorteile wie Skalierbarkeit, Testbarkeit und eine klare Trennung von Aufgaben.

Um den Dependency Injector in Angular zu nutzen, müssen wir 3 Schritte erledigen

* Den `@Injectable()` Decorator der Klasse/ dem Service hinzufügen.
* Den Injector davon erzählen, indem wir es als Provider aufzählen.
* Die Dependency injecten

1. @Injectable importieren und nutzen:
  ```typescript
  import {Injectable} from './@angular/core';

    @Injectable({
        providedIn: 'root'
    })
export class WeaponService {}
  ```
2. Den WeaponService als Provider registrieren (in `module.ts`):
```typescript
// ..
import { WeaponService } from './services/weapon.service';

@NgModule({
    declatations: [],
    // ..
    bootstrap: [AppComponent],
    providers: [WeaponService]
})
export class AppModule{ }
```
3. Dependency injecten wo (in unserem Beispiel) der Service genutzt wird:
```typescript
import { WeaponService } from './services/weapon.service';

@Component({
    // ..
})

export class WeaponComponent {
    weapons: string[] = [];

    constructor(private weaponService: WeaponService) {}

    ngOnInit(){
        this.weapons = this.weaponService.getWeapons();
    }
}
```
Das Minibeispiel soll lediglich die 3 wichtigen Schritte etwas besser darstellen.

### Lernvideo
Wenn du dir die Erklärung noch mit einem Video genauer anschauen möchtest, empfiehlt dir das Coaching-Team dieses
[Video](https://www.youtube.com/watch?v=yunF2PgJlHU).
