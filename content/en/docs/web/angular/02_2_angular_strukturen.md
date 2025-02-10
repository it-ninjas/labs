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

- Du kennst die grundlegende Struktur eines Angular-Projekts und kannst diese erläutern.

## Grundlegende Struktur einer Angular-Anwendung

In Angular gibt es eine vordefinierte Struktur, die von Entwicklern empfohlen wird, um eine konsistente und leicht verständliche Anwendungsentwicklung sicherzustellen.

Die grundlegende Struktur einer Angular-Anwendung besteht aus folgenden Files:

- [Module](./02_2_angular_strukturen.md): Ein Angular-Modul ist eine Sammlung von Components, Services, Directives und anderen Funktionen, die für eine bestimmte Funktionalität oder einen bestimmten Zweck zusammengefasst werden. Ein Modul wird in der Regel in einem separaten File deklariert und exportiert.

- [Component](./02_3_angular_components): Ein Angular-Component ist eine Klasse, die das Verhalten und das Aussehen einer Benutzeroberflächeneinheit definiert. Ein Component besteht aus TypeScript-Files und einer Vorlage, die das HTML definiert, das die Benutzeroberfläche darstellt. Ein Component kann andere Component enthalten oder sich selbst in andere Components einbetten.

- [Services](./02_10_angular_services): Ein Angular-Service ist eine Klasse, die Funktionen und Daten bereitstellt, die von anderen Teilen der Anwendung verwendet werden können. Ein Service kann z.B. eine Datenbankabfrage durchführen, eine REST-API aufrufen oder Benutzerinformationen verwalten.

- [Directives](./02_8_angular_directives): Eine Angular-Directive ist eine Anweisung, die auf ein HTML-Element angewendet wird, um sein Verhalten oder Aussehen zu ändern. Eine Directive kann z.B. ein Attribut oder eine Struktur sein, die das Verhalten eines HTML-Elements steuert oder ein Template-Element sein, das dynamisch in die Benutzeroberfläche eingefügt wird.

- [Template](./02_5_angular_templates): Ein Template ist die HTML-Datei, die ein Component darstellt. Es kann auch spezielle Angular-Directives und -Syntax verwenden, um die Interaktivität und Funktionalität der Anwendung zu verbessern.

![Angular](../images/architektur.png)

## Ordnerstruktur

Die Ordnerstruktur in Angular kann nach persönlichen Präferenzen gewählt werden. Jedoch ist die unten folgenden Struktur die gängigste Best-Practice-Variante und sollte daher auch immer so angewendet werden.
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
│   │   ├── app.module.ts (Wird nicht mehr ohne weiteres automatisch erstellt)
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
