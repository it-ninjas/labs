---
title: "Services"
type: docs
linkTitle: "Services"
weight: 11
date: 2023-05-04
description: >
  Modul #F6 - Angular - Services
---
## Ziele
* Du weisst, wozu Services in Angular sind und kannst dies erläutern.

## Services
Angular-Services sind in Angular eine wichtige Art, Code zu organisieren und wiederzuverwenden. Sie bieten eine Möglichkeit, Funktionen und Daten zu teilen, die von mehreren Components innerhalb einer Anwendung benötigt werden. Ein Service ist eine Klasse, die von anderen Components injiziert werden kann, um auf seine Funktionen und Daten zuzugreifen.

Services können beispielsweise Daten von einem Backend-Server abrufen, eine benutzerdefinierte Logik ausführen, eine Konfiguration bereitstellen oder andere Arbeiten erledigen, die für mehrere Komponenten relevant sind. Im Gegensatz zu Komponenten haben Services normalerweise keine visuelle Darstellung, sondern dienen als reine "Helfer"-Klassen.

```typescript
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class WeaponService {
    private weapons: string[] = [
        'Sword',
        'Bow',
        'Axe',
        'Staff',
        'Dagger'
    ];

    getWeapons(): string[] {
        return this.weapons;
    }
}
```

