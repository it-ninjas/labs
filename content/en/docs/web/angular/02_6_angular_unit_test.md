---
title: "Testfiles"
type: docs
linkTitle: "Testfiles"
weight: 8
date: 2023-05-04
description: >
  In diesem Kapitel wird beschrieben wa genau das Unit Test File in Angular ist.
---
## Ziele
* Du weisst, was Unit-Tests in Angular sind.
* Du kannst, beschrieben welche Blöcke es in einem Unit-Test gibt.

## Unit Testing
Testdateien (.spec.ts Files) sind Teil des Test-Frameworks, das in Angular integriert ist. Sie dienen dazu, verschiedene Components, Services, Directives, Pipes etc in einer Angular-Anwendung zu testen. Das Testen ist ein wichtiger Bestandteil der Entwicklung, da es hilft, die Funktionalität einer Anwendung zu überprüfen, Fehler zu identifizieren und sicherzustellen, dass Änderungen keine unerwünschten Nebenwirkungen haben.

Als Beispiel sieht man einen minimalen Test, welcher für den AppComponent erstellt wurde:
```typescript
// app.component.ts
import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'docs-project';
}
```

```typescript
// app.component.spec.ts
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
    beforeEach(() => TestBed.configureTestingModule({
        imports: [RouterTestingModule],
        declarations: [AppComponent]
    }));

    it('should create the app', () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.componentInstance;
        expect(app).toBeTruthy();
    });

    it(`should have as title 'docs-project'`, () => {
        const fixture = TestBed.createComponent(AppComponent);
        const app = fixture.componentInstance;
        expect(app.title).toEqual('docs-project');
    });

    it('should render title', () => {
        const fixture = TestBed.createComponent(AppComponent);
        fixture.detectChanges();
        const compiled = fixture.nativeElement as HTMLElement;
        expect(compiled.querySelector('.content span')?.textContent).toContain('docs-project app is running!');
    });
});
```

Wozu die einzelnen Blöcke und Methoden im Testfile sind wird nachfolgend besser erläutert.

* **Test-Suites** (`describe`-Blöcke): Eine Testdatei enthält normalerweise eine oder mehrere Test-Suiten. Eine Test-Suite fasst eine Gruppe von verwandten Tests zusammen. Zum Beispiel kann man eine Test-Suite für einen bestimmten Component oder einen bestimmten Service erstellen.
* **Test-Cases** (`it`-Blöcke): Innerhalb einer Test-Suite werden einzelne Test-Cases definiert. Ein Test-Case überprüft eine bestimmte Funktionalität oder ein bestimmtes Verhalten der Anwendung. Man kann mehrere Test-Cases innerhalb einer Test-Suite haben.
* **Test-Setup** (`beforeEach`-Block): Vor jedem Testfall kann man den `beforeEach`-Block verwenden, um Vorbereitungsschritte auszuführen. Zum Beispiel kann man einen Component initialisieren, Abhängigkeiten injizieren oder den Zustand der Anwendung festlegen. Dies stellt sicher, dass jeder Test-Case in einem konsistenten Zustand beginnt.
* **Assertions**: In den Test-Cases verwendet man Assertions, um zu überprüfen, ob das erwartete Verhalten erfüllt ist. Man kann verschiedene Assertions verwenden, um Eigenschaften, Zustände, Ausgaben oder Verhalten des Components zu überprüfen. Beispiele für Assertions sind `expect()`, `toBe()`, `toEqual()`, `toContain()`, `toBeTruthy()` etc.

