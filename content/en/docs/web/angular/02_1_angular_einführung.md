---
title: "Einführung in Angular"
type: docs
linkTitle: "Einführung in Angular"
weight: 2
date: 2023-05-04
description: >
  Modul #F6 - Angular - Was ist Angular?
---

### Ziele

- Du kennst die Vor- und Nachteile von Angular. 
- Du weisst, wie du ein erstes Angular-Projekt aufsetzen kannst.



## Was ist Angular

Angular ist ein Framework um SPA’s (Single Page Applications) mittels HTML und JavaScript zu erstellen und besteht aus verschiedenen Core- und Optional-JavaScript-Bibliotheken.
Angular wird für Frontend-Applikationen verwendet. Oft wird ein Backend via HTTP(S) angebunden.
![Angular](../images/angular_einführung.png)

### Vorteile von Angular

- **Umfangreiche Funktionalität**: Angular bietet eine Vielzahl von Funktionen und Features, die für die Entwicklung von komplexen Webanwendungen erforderlich sind. Es enthält ein leistungsfähiges Template-System, Datenbindung, Routing, Formularvalidierung, Dependency Injection und vieles mehr.

- **Strukturierte Architektur**: Angular basiert auf dem Konzept der Components-Based Architektur. Die Anwendung wird in unabhängige, wiederverwendbare Components strukturiert, was die Wartbarkeit und Testbarkeit erleichtert.

- **Produktivität**: Angular bietet viele Hilfsmittel, die die Entwicklungszeit verkürzen. Dazu gehören die Angular CLI (Command Line Interface) zur Projektgenerierung und automatisierten Aufgaben, ein reichhaltiges Ökosystem von Libraries und Extensions sowie eine umfangreiche Dokumentation.

- **TypeScript-Unterstützung**: Angular ist in TypeScript geschrieben. TypeScript bietet statische Typisierung, verbesserte IDE-Unterstützung und ermöglicht eine bessere Fehlererkennung zur Entwicklungszeit.

- **Grosse Community**: Angular ist ein viel genutztes Framework, wodurch bereits viele Best-Practices, standartisierte Vorgehensweisen und bewährte Praktiken und Konventionen bestehen, an denen man sich als Entwickler orientieren kann.   
### Nachteile von Angular

- **Lernkurve**: Angular ist ein umfangreiches Framework und erfordert eine gewisse Einarbeitungszeit. Die Konzepte wie Dependency Injection, TypeScript und das Componentmodel können für Entwickler mit wenig Erfahrung zunächst herausfordernd sein.

- **Grösse**: Angular ist ein umfangreiches Framework, was zu grossen Anwendungen führen kann. Das kann die Ladezeit beeinflussen, insbesondere für mobile Geräte mit langsamer Internetverbindung.

- **Komplexität**: Aufgrund der vielen Funktionen und Konzepte kann die Komplexität von Angular zunehmen, insbesondere für kleinere Projekte, bei denen nicht alle Funktionen benötigt werden.

- **Abhängigkeit von Google**: Angular wurde von Google entwickelt und ist stark mit dem Unternehmen verbunden. Einige Entwickler haben Bedenken hinsichtlich der langfristigen Unterstützung und der Unabhängigkeit von Google.

## Angular Projekt aufsetzen

Um ein neues Angular-Projekt zu erstellen, kannst du das Angular CLI (Command Line Interface) verwenden. Dazu muss es aber zuerst installiert werden.

### Angular CLI installieren

Man muss als Vorarbeit sicherstellen, dass Node.js auf dem Computer installiert ist (`npm -v` im Terminal eingeben). Im Terminal muss man danach den folgenden Befehl ausführen, um die Angular CLI global zu installieren:

```shell
npm install -g @angular/cli
```

### Projekt erstellen

Nun muss in das Verzeichnis gewechselt werden, in dem das Angular-Projekt erstellen werden soll, und nun muss man den folgenden Befehl ausführen:

```shell
ng new new-angular-project
```

Als nächstes muss in das Projektverzeichnis gewechselt werden, indem man den folgenden Befehl ausführt:

```shell
cd new-angular-project
``` 

### Projekt starten

Mit dem folgenden Befehl kann man den Entwicklungsserver starten, um das Angular-Projekt im Browser anzuzeigen:

```shell
ng serve
```

Der Entwicklungsserver wird gestartet und die Anwendung wird (standardmässig) auf http://localhost:4200 bereitgestellt. Man kann diese URL in einem Webbrowser öffnen, um die Angular-Anwendung anzuschauen.

## Angular CLI

Das Angular CLI (Command Line Interface) ist ein Befehlszeilenwerkzeug, das von Angular bereitgestellt wird. Es ermöglicht Entwicklern, effizienter mit Angular zu arbeiten, indem es verschiedene Funktionen und Befehle zur Verfügung stellt, um die Erstellung, Entwicklung, Bereitstellung und Wartung von Angular-Projekten zu unterstützen.

### Commands

- ng new <projektname>: Erstellt ein neues Angular-Projekt mit der angegebenen Projektstruktur und -konfiguration.

- ng serve: Startet den Entwicklungsserver und stellt die Angular-Anwendung auf http://localhost:4200 bereit. Änderungen werden in Echtzeit reflektiert.

- ng serve --open: Startet den Entwicklungsserver und öffnet automatisch den Standardwebbrowser, um die Anwendung anzuzeigen.

- ng generate <art> <name> (oder ng g <art> <name>): Generiert eine neue Datei oder Komponente basierend auf einer vorgegebenen Vorlage.

  - **Component**: ng generate component <name> oder ng g c <name>
    Erzeugt eine neue Komponente mit einer Component-Datei, einer Template-Datei, einer Stylesheet-Datei und einem Testfile.

  - **Module**: ng generate module <name> oder ng g m <name>
  - **Service**: ng generate service <name> oder ng g s <name>
  - **Directive**: ng generate directive <name> oder ng g d <name>
  - **Klassen**: ng generate class <name> oder ng g cl <name>
  - **Enum**: ng generate enum <name> oder ng g e <name>
  - **Interface**: ng generate interface <name> oder ng g i <name>
  - **Pipe**: ng generate pipe <name> oder ng g p <name>

  - **Guard**: ng generate guard <name>

- ng build: Kompiliert und baut die Angular-Anwendung für die Produktion. Erzeugt optimierten JavaScript-Code, der für die Bereitstellung auf einem Webserver verwendet werden kann.

- ng test: Führt die Unit-Tests des Projekts aus, um sicherzustellen, dass die Anwendung ordnungsgemäß funktioniert.

- ng lint: Überprüft den Code auf Einhaltung der definierten Linting-Regeln.

- ng update: Aktualisiert die Angular-Abhängigkeiten und -Pakete auf die neuesten Versionen.

- ng add <paketname>: Fügt ein externes Paket oder eine Bibliothek zum Angular-Projekt hinzu. Installiert und konfiguriert das Paket automatisch.

- ng help: Zeigt eine Liste der verfügbaren Befehle und Optionen der Angular CLI an.

## Konfigurationsdatei für eine Angular-Anwendung

Die `angular.json`-Datei ist die Konfigurationsdatei eines Angular-Projekts. Sie enthält verschiedene Einstellungen und Konfigurationen für das Build-System, die Erstellung des Projekts, den Asset-Manager und vieles mehr. Die Datei wird automatisch generiert, wenn ein neues Angular-Projekt mit der Angular CLI erstellt wird.

## Einstiegspunkt einer Angular-Anwendung

### Typescript

Der Einstiegspunkt einer Angular-Anwendung ist die Datei main.ts. Diese Datei ist das Hauptmodul der Anwendung, in dem der Bootstrap-Prozess gestartet wird.

```typescript
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule)
        .catch(err => console.error(err));
```

Das AppModule selbst ist das Root-Modul der Angular-Anwendung. Es wird in der Regel in einer separaten Datei (`app.module.ts`) definiert und enthält die erforderlichen Importe und Konfigurationen für die Anwendung, einschliesslich der Components, Services, Modules und anderer Funktionen, welche d Anwendung benötigt.

Die `main.ts`-Datei wird beim Starten der Angular-Anwendung vom Build-System oder von der Angular CLI aufgerufen. Sie ist der erste Punkt, an dem der Angular-Bootstrap-Prozess beginnt und die erforderlichen Ressourcen und Module geladen werden.

Es ist wichtig zu beachten, dass die `main.ts`-Datei normalerweise nicht manuell bearbeitet werden muss, es sei denn, man hat spezifische Anpassungen oder Erweiterungen für den Bootstrap-Prozess vorzunehmen. Die meisten Änderungen und Konfigurationen sollten im AppModule und den anderen Modulen der Anwendung vorgenommen werden.

Es ist wichtig zu beachten, dass seit Angular 17 das App-Modul **nicht** mehr standardmässig beim Erstellen eines neuen Angular-Projekts generiert wird, da seit Angular 17 
alle Components standardmässig standalone sind und alle nötigen Imports selber enthalten, womit das App-Modul entfällt. Wenn du trotzdem ein App-Modul generieren möchtest, musst du beim Erstellen
des Angular-Projekts das "-- no-standalone"-Flag zum Befehl hinzufügen: 

```shell
ng new <name> --no-standalone
```

Das Einstiegs-HTML-Dokument einer Angular-Anwendung ist die `index.html`-Datei. Diese Datei wird automatisch generiert, wenn die Anwendung kompiliert.

In der `index.html`-Datei befindet sich das grundlegende HTML-Markup für die Anwendung. Hier werden die erforderlichen Skripte und Stylesheets eingebunden und der Ort definiert, an dem die Angular-Anwendung in das DOM eingefügt wird.

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Angular App</title>
    <base href="/" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
  </head>
  <body>
    <app-root></app-root>
  </body>
</html>
```

Im `<head>`-Tag befindet sich der `<title>`-tag, dieser definiert den Titel der Webseite, der normalerweise im Browser-Tab angezeigt wird.
Das `<link rel="icon" type="image/x-icon" href="...">`-Tag bindet das Favicon (Favoriten-Symbol) der Webseite ein, das normalerweise im Browser-Tab und in Lesezeichen angezeigt wird.
Diese zwei kann man nach Belieben ändern.

Beim Starten der Angular-Anwendung wird der Inhalt der `index.html`-Datei vom Webbrowser geladen. Der Angular-Bootstrap-Prozess findet das `<app-root>`-Element und ersetzt es durch den gerenderten Inhalt der Angular-Komponenten.

## App Component

Der "AppComponent" ist der Hauptcomponent einer Angular-Anwendung. Es handelt sich um den Wurzelcomponent, von dem aus alle anderen Components und Elemente der Anwendung hierarchisch aufgebaut sind.

Er wird automatisch während der Initialisierung der Anwendung erstellt und gerendert. Er dient als Container für das gesamte Anwendungslayout und ist der erste Component, der in der `index.html`-Datei der Anwendung mittels dem `<app-root>`-Tag geladen wird.

## Angular Best(Good)-Practices

Angular bietet eine Reihe von bewährten Best Practices, die helfen können, die Angular-Anwendungen effizienter, wartbarer und skalierbarer zu gestalten. Hier sind einige wichtige Angular Best Practices:

- **Verwendung der Angular CLI**: Die Angular CLI erstellt automatisch eine standardisierte Projektstruktur, die bewährten Praktiken und Konventionen folgt. Das erleichtert die Organisation und Wartung des Codes, da Entwickler eine einheitliche Struktur innerhalb des Projekts erwarten können. Daher sollte zum Erstellen von neuen Dateien und / oder Komponenten auch immer die CLI verwendet werden.
- **Eine Aufgabe pro Component**: Der Code sollte in kleine, wiederverwendbare Komponenten aufgeteilt werden. Jeder Component sollte eine klare Verantwortung haben und nur für eine spezifische Aufgabe zuständig sein. Um im Typescript Code Konventionen und Best Practices zu befolgen, sollte man zudem einen Linter verwenden, um dies zu prüfen.
- **Nutzung der Angular Template-Syntax**: Es sollte die Angular-spezifische Template-Syntax verwendet werden, um Data-Bindung, Ereignisbehandlung und Strukturierung des DOMs im Templates zu erleichtern. Komplexe Logik in den Templates sollte vermieden werden, sie sollte möglichst lesbar sein. Dazu kann man Formatter wie Prettier verwenden, um den gesamten Code zu vereinfachen.
- **Nutzung von Lazy Loading für Module**: Das Lazy-Loading-Feature von Angular sollte verwendet werden, um die Ladezeit der Anwendung zu verbessern. Man sollte Module nur dann laden, wenn sie benötigt werden, anstatt die gesamte Anwendung auf einmal zu laden.

## Angular Dokumentation

Die offizielle Dokumentation bietet den Entwicklern eine umfassende und verlässliche Informationsquelle für das entsprechende Framework oder die entsprechende Technologie bereitzustellen.
Diese Dokumentationen bieten eine strukturierte Anleitungen und Erklärungen zu den verschiedenen Funktionen, Konzepten, APIs, Best Practices und Verwendungsmöglichkeiten.
Angular hat mit dem Update auf die Version 19 auch eine neue [Dokumentationsseite](https://angular.dev/) veröffentlicht. In dieser findet man alle Informationen zu den neuen Standards und Funktionen.

Ein wichtiger Teil der Dokumentation ist die detaillierte API-Referenz. Hier werden alle verfügbaren Klassen, Methoden, Parameter und Rückgabewerte beschrieben.
Dies erleichtert es Entwicklern, die verfügbaren Funktionalitäten zu verstehen und effektiv zu nutzen.

Abgesehen von reinen Codebeispielen bieten Dokumentationen auch konzeptionelle Erklärungen. Diese beschreiben die zugrunde liegenden Prinzipien, Architekturkonzepte und Entscheidungen, die beim Design der Technologie getroffen wurden.

In der Angular Dokumentation sind zudem auch [Tutorials](https://angular.dev/tutorials) zu finden, welche durchgeführt werden können, um das Verständnis in Angular zu stärken.

Zudem ist nun auch ein sogenannter [Playground](https://angular.dev/playground) von Angular selbst hinzugefügt worden, diesen kann man auch über die Dokumentation erreichen.
Der Playground erfüllt den Nutzen, dass Entwickler ihren Code vorab isoliert im Browser testen können, ohne dafür ein neues Angular-Projekt aufsetzen zu müssen.
Vor dem offiziellen Playground musste fürs Testen vorab  [Stackblitz](https://stackblitz.com/) verwenden. Die Seite ist jedoch auch heutzutage immer noch sehr hilfreich, da man dort in verschiedensten Sprachen Code im Browser testen kann.


## Debugging

Auch bei Angular bleibt Debugging ein wichtiges Thema. Grundsätzlich bleibt alles gleich wie bei JavaScript, wenn du dein Wissen jedoch nochmals auffrischen möchtest, kannst du [hier klicken](../javascript/24_debugging.md).
