---
title: "Modules"
type: docs
linkTitle: "Modules"
weight: 12
date: 2023-05-04
description: >
  Modul #F6 - Angular - Module
---

## Ziele

- Du weisst, was Modules in Angular sind.
- Du kannst erklären, was in einem Module alles enthalten ist und wie es aufgebaut ist.

## Modules

Wichtig: Dieser Abschnitt ist im Rahmen der Veröffentlichung von Angular 18 inzwischen mehr oder weniger überflüssig, da seit Angular 18 alle Komponenten standardmässig als standalone behandelt werden. Da es aber nach wie vor möglich ist, mit Modulen zu arbeiten, ist es dennoch empfehlenswert, sich diesen Abschnitt kurz zu Gemüte zu führen.

In Angular ist ein Modul ein Mechanismus, um Components, Directives und Pipes und Services zu gruppieren, die miteinander zusammenhängen. Auf diese Weise können sie mit anderen Modulen kombiniert werden, um eine Anwendung zu erstellen.

Ein Angular-Modul wird mit dem `@NgModule`-Decorator definiert und kann die folgenden Eigenschaften haben:

- `declarations`: Die Components, Directives und Pipes, die zum Modul gehören.
- `imports`: Andere Module, die in diesem Modul verwendet werden können.
- `exports`: Die Components, Directives und Pipes, die von diesem Modul exportiert werden und von anderen Modulen verwendet werden können.
- `providers`: Services, die in diesem Modul verfügbar sein sollen.
- `bootstrap`: Die Components, die beim Anwendungsstart gerendert werden sollen.

```typescript
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppComponent } from "./app.component";

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```
