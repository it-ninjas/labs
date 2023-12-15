---
title: "Modules"
type: docs
linkTitle: "Modules"
weight: 11
date: 2023-05-04
description: >
    In diesem Kapitel werden die Angular-Module besser erklärt.
---
## Ziele
* Du weisst, was Modules in Angular sind.
* Du kannst, erklären was in einem Module alles enthalten ist und wie es aufgebaut ist.

## Modules
In Angular ist ein Modul ein Mechanismus, um Components, Directives und Pipes und Services zu gruppieren, die miteinander zusammenhängen. Auf diese Weise können sie mit anderen Modulen kombiniert werden, um eine Anwendung zu erstellen.

Ein Angular-Modul wird mit dem `@NgModule`-Decorator definiert und kann die folgenden Eigenschaften haben:

* `declarations`: Die Components, Directives und Pipes, die zum Modul gehören.
* `imports`: Andere Module, die in diesem Modul verwendet werden können.
* `exports`: Die Components, Directives und Pipes, die von diesem Modul exportiert werden und von anderen Modulen verwendet werden können.
* `providers`: Services, die in diesem Modul verfügbar sein sollen.
* `bootstrap`: Die Components, die bei Anwendungsstart gerendert werden sollen.

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
```