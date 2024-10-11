---
title: "Angular Strukturen"
type: docs
linkTitle: "Angular Strukturen"
weight: 3
date: 2023-05-04
description: >
  Modul #F6 - Angular - Angular Strukturen
---

## Ziele

- Du kennst, die grundlegende Struktur von Angular und kannst diese erläutern.

## Grundlegende Struktur einer Angular-Anwendung

In Angular gibt es eine definierte Struktur, die von Entwicklern empfohlen wird, um eine konsistente und leicht verständliche Anwendungsentwicklung sicherzustellen.

Die grundlegende Struktur einer Angular-Anwendung besteht aus folgenden Files:

- [Module](../02_9_angular_modules): Ein Angular-Modul ist eine Sammlung von Components, Services, Directives und anderen Funktionen, die für eine bestimmte Funktionalität oder einen bestimmten Zweck zusammengefasst werden. Ein Modul wird in der Regel in einer separaten File deklariert und exportiert.

- [Component](../02_3_angular_components): Eine Angular-Component ist eine Klasse, die das Verhalten und das Aussehen einer Benutzeroberflächeneinheit definiert. Eine Component besteht aus TypeScript-Fie und einer Vorlage, die das HTML definiert, das die Benutzeroberfläche darstellt. Eine Component kann andere Component enthalten oder sich selbst in andere Component einbetten.

- [Services](../02_8_angular_services): Ein Angular-Service ist eine Klasse, die Funktionen und Daten bereitstellt, die von anderen Teilen der Anwendung verwendet werden können. Ein Services kann z.B. eine Datenbankabfrage durchführen, eine REST-API aufrufen oder Benutzerinformationen verwalten.

- [Directives](../02_7_angular_directives): Eine Angular-Directives ist eine Anweisung, die auf ein HTML-Element angewendet wird, um sein Verhalten oder Aussehen zu ändern. Eine Directives kann z.B. ein Attribut oder eine Struktur sein, die das Verhalten eines HTML-Elements steuert oder ein Template-Element sein, das dynamisch in die Benutzeroberfläche eingefügt wird.

- [Template](../02_4_angular_templates): Ein Template ist die HTML-Datei, die eine Component darstellt. Es kann auch spezielle Angular-Directives und -Syntax verwenden, um die Interaktivität und Funktionalität der Anwendung zu verbessern.

![Angular](../images/architektur.png)

## Ordnerstruktur

Die Ordnerstruktur in Angular kann nach persönlichen Präferenzen gewählt werden. Jedoch ist die unten folgenden Struktur die gängigste Best-Practices Variante und sollte daher auch immer so angewendet werden.
Die Struktur bietet eine klare Trennung der verschiedenen Artefakte einer Angular-Anwendung und fördert die Modularität, Wiederverwendbarkeit und Testbarkeit des Codes.

```text
├── e2e
│   └── ...
├── src
│   ├── app
│   │   ├── components
│   │   │   ├── component1
│   │   │   │   ├── component1.component.ts
│   │   │   │   ├── component1.component.html
│   │   │   │   ├── component1.component.scss
│   │   │   │   └── component1.component.spec.ts
│   │   │   ├── component2
│   │   │   │   ├── component2.component.ts
│   │   │   │   ├── component2.component.html
│   │   │   │   ├── component2.component.scss
│   │   │   │   └── component2.component.spec.ts
│   │   │   └── ...
│   │   ├── services
│   │   │   ├── service1
│   │   │   │   ├── service1.service.ts
│   │   │   │   └── service1.service.spec.ts
│   │   │   ├── service2
│   │   │   │   ├── service2.service.ts
│   │   │   │   └── service2.service.spec.ts
│   │   │   └── ...
│   │   ├── directives
│   │   │   ├── directive1
│   │   │   │   ├── directive1.directive.ts
│   │   │   │   └── directive1.directive.spec.ts
│   │   │   ├── directive2
│   │   │   │   ├── directive2.directive.ts
│   │   │   │   └── directive2.directive.spec.ts
│   │   │   └── ...
│   │   ├── shared
│   │   │   ├── shared1
│   │   │   ├── shared2
│   │   │   └── ...
│   │   ├── models
│   │   │   ├── model1.ts
│   │   │   ├── model2.ts
│   │   │   └── ...
│   │   ├── pipes
│   │   │   ├── pipe1
│   │   │   │   ├── pipe1.pipe.ts
│   │   │   │   └── pipe1.pipe.spec.ts
│   │   │   ├── pipe2
│   │   │   │   ├── pipe2.pipe.ts
│   │   │   │   └── pipe2.pipe.spec.ts
│   │   │   └── ...
│   │   ├── guards
│   │   │   ├── guard1
│   │   │   │   ├── guard1.guard.ts
│   │   │   │   └── guard1.guard.spec.ts
│   │   │   ├── guard2
│   │   │   │   ├── guard2.guard.ts
│   │   │   │   └── guard2.guard.spec.ts
│   │   │   └── ...
│   │   ├── modules
│   │   │   ├── module1
│   │   │   │   ├── module1.module.ts
│   │   │   │   └── module1.module.spec.ts
│   │   │   ├── module2
│   │   │   │   ├── module2.module.ts
│   │   │   │   └── module2.module.spec.ts
│   │   │   └── ...
│   │   ├── utilities
│   │   │   ├── utility1.ts
│   │   │   ├── utility2.ts
│   │   │   └── ...
│   │   ├── app.component.ts
│   │   ├── app.component.html
│   │   ├── app.component.scss
│   │   ├── app.component.spec.ts
│   │   ├── app.module.ts
│   │   └── app.routing.module.ts
│   ├── assets
│   │   ├── images
│   │   ├── fonts
│   │   └── ...
│   ├── styles
│   │   ├── _variables.scss
│   │   ├── _mixins.scss
│   │   ├── main.scss
│   │   └── ...
│   ├── environments
│   │   ├── environment.prod.ts
│   │   └── environment.ts
│   ├── index.html
│   ├── main.ts
│   ├── polyfills.ts
│   ├── styles.scss
│   └── ...
├── angular.json
├── package.json
├── tsconfig.json
├── tslint.json
└── ...

```
