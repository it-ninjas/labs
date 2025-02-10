---
title: "Standalone Components"
type: docs
linkTitle: "Standalone Components"
weight: 5
date: 2024-02-16
description: >
  Modul #F6 - Angular - Was sind Standalone Components?
---

### Ziele

- Du weisst, was Standalone Components sind.
- Du kennst die Unterschiede zwischen standalone Components und regulären Components.

## Standalone Components

Seit Angular 16 gibt es eine neue Art von Components, die erstellt und vewendet werden kann.
Diese `Standalone Components` unterscheiden sich beim Grundaufbau nur gering von den traditionellen Components, die du bereits kennengelernt hat.
Jedoch verbirgt sich dahinter ein neuer Weg, wie du deine Applikation strukturieren kannst.

### Was bedeutet Standalone

Standalone Components sind anders als traditionelle Components `Module unabhängig`.
Das bedeutet, dass sie zum einen nicht in einem Module definiert werden müssen und zum anderen, dass sie keine Imports aus einem Module erhalten.
Durch diesen Aufbau können Standalone Components in jedem Kontext verwendet werden, ohne sie noch speziell deklarieren zu müssen.

### Standalone vs. Regular

#### Reguläre Komponenten

Im Gegensatz zu Standalone-Komponenten sind reguläre Komponenten modulabhängig. Sie müssen in einem Modul definiert und deklariert werden, um verwendet werden zu können. Sie können auch Imports aus ihrem Modul erhalten, was ihre Verwendung je nach Kontext einschränken kann.

#### Vergleich

- **Modulabhängigkeit**: Während reguläre Komponenten in einem Modul definiert werden müssen, sind Standalone-Komponenten modulunabhängig. Diese Tatsache gibt Standalone-Komponenten mehr Flexibilität, da sie in jedem Kontext verwendet werden können.
- **Imports**: Reguläre Komponenten können Imports aus ihrem Modul erhalten, während Standalone-Komponenten dies nicht tun. Dies kann die Wiederverwendbarkeit von Standalone-Komponenten erhöhen.
  **Verwendung**: Seit Angular 17 sind Standalone-Komponenten per Default aktiviert und eingesetzt, was ihre Verwendung fördert. Reguläre Komponenten hingegen erfordern eine spezifische Deklaration in ihrem Modul, um verwendet werden zu können.

Insgesamt bieten Standalone-Komponenten also eine grössere Flexibilität und Wiederverwendbarkeit im Vergleich zu regulären Komponenten, was sie zu einer attraktiven Option für die Strukturierung von Angular-Anwendungen macht.

### appConfig

Seit Angular 17 wird das [AppModule](02_11_angular_modules) nicht mehr automatisch beim Erstellen eines neuen Projekts generiert, da nun die Components default mässig Standalone sind.
Jedoch wird trotzdem noch eine Datei benötigt, um externe Abhängigkeiten anzugeben. Die ist in diesem Fall die Datei `app.config.ts`, dort werden zum Beispiel die Abhängigkeiten wie die Angular Routes angegeben.
Diese kann man einrichten, indem man `provideRouter(routes)` im `providers`-Array aufruft.

```typescript
import { ApplicationConfig } from "@angular/core";
import { provideRouter } from "@angular/router";

import { routes } from "./app.routes";

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)],
};
```
