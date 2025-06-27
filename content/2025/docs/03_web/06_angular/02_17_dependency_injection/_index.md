---
title: "Dependency Injection"
type: docs
linkTitle: "Dependency Injection"
weight: 18
date: 2023-05-04
description: >
  Modul #F6 - Angular - Dependency Injection
---

## Ziele

- Du weisst, was eine Dependency Injection ist und wie man diese in Angular anwendet.
- Du kannst Dependency Injection anwenden.

## Was sind Dependencies (Abhängigkeiten)?

Um eine loose Kopplung zu erreichen, werden verschiedene Aufgaben wie das Laden von Server-Daten in verschiedene Dateien ausgelagert. Die einzelnen Klassen haben Abhängigkeiten zueinander. In Angular gibt man die Abhängigkeiten zu anderen Klassen z.B. oft im Konstruktor an.

Angular erstellt und übergibt dann automatisch Instanzen dieser Klassen beim Laden der entsprechenden Klasse.
Auf diese Weise werden die Klassen wiederverwendbar und einfacher testbar.

## Was ist eine Dependency Injection?

Dependency Injection ist ein Coding-Pattern, bei welchem Klassen alle Abhängigkeiten von externen Quellen erhalten, anstatt sie selbst zu erstellen.

## Dependency Injection in Angular

Der Angular Dependency Injector liefert uns Vorteile wie Skalierbarkeit, Testbarkeit und eine klare Trennung der Aufgaben.

Um den Dependency Injector in Angular zu nutzen, müssen wir 3 Schritten folgen:

- Den `@Injectable()` Decorator der Klasse/ dem Service hinzufügen.
- Dem Injector davon erzählen, indem wir es als Provider aufzählen.
- Die Dependency injecten

1. `@Injectable` importieren und nutzen:

```typescript
import { Injectable } from "./@angular/core";

@Injectable({
  providedIn: "root",
})
export class WeaponService {}
```

2. Den WeaponService als Provider registrieren:

```typescript
// ..
import { WeaponService } from "./services/weapon.service";

export const appConfig: ApplicationConfig = {
  providers: [{ provide: WeaponService }],
};
```

Dann muss noch die folgende Einstellung in der `main.ts`-Datei gemacht werden:

```typescript
bootstrapApplication(AppComponent, appConfig);
```

3. Dependency injecten wo (in unserem Beispiel) der Service genutzt wird:

```typescript
import { WeaponService } from "./services/weapon.service";

@Component({
  // ..
})
export class WeaponComponent {
  weapons: string[] = [];

  constructor(private weaponService: WeaponService) {}

  ngOnInit() {
    this.weapons = this.weaponService.getWeapons();
  }
}
```

Das Minibeispiel soll lediglich die 3 wichtigen Schritte etwas besser darstellen.
Im gemachten Beispiel ist zudem die Dependency auf der `root`-Ebene verfügbar. (Sichtbar durch den Teil `providedIn: "root"` im `@Injectable`-Block) Das bedeutet, dass Angular für die gesamte Applikation genau eine Instanz des injizierbaren Services erstellt, welcher dann jeweils von allen Klassen verwendet wird, die ihn injecten.

Es gibt aber auch eine andere Möglichkeit, einen solchen Service zu injecten. Im folgenden Beispiel wird der Service auf der Component-Ebene injected und wird für jede neue Instanz des Components neu instanziert:

1. Dependency im Service bereitstellen

```typescript
@Injectable()
class WeaponService {}
```

2. Dependency in den gewünschten Component injizieren

```typescript
@Component({
  standalone: true,
  selector: "weapon",
  template: "...",
  providers: [WeaponService],
})
class WeaponComponent {}
```

Auf diese Weise wird für jede neue Instanz des Components auch eine neue Instanz des Service verwendet. Unter verwendung von `providedIn: 'root'` wird eine Instanz der inizierten Klasse für die gesamte Applikation verwendet.
Es gibt für beide Möglichkeiten valide Anwendungsfälle, grundsätzlich empfiehlt es sich aber, injizierbare Klassen auf der `root`-Ebene zu providen, da so nicht unnötig viele Instanzen erstellt werden und die Instanz auch von Angular entfernt werden kann, wenn sie nirgendwo gebraucht wird.

### Lernvideo

Wenn du dir das Konzept der Dependency-Injection etwas genauer anschauen möchtest, kannst du dieses
[Video](https://www.youtube.com/watch?v=yunF2PgJlHU) anschauen.
