---
title: "Einführung in Angular"
type: docs
linkTitle: "Einführung in Angular"
weight: 3
date: 2023-05-04
description: >
  Angular ist ein Framework um SPA’s (Single Page Applications) mittels HTML und JavaScript zu erstellen und besteht aus verschiedenen core und optionalen JavaScript Bibliotheken
---

## Was ist Angular
Angular wird für Frontend-Applikationen verwendet. Oft wird ein Backend via HTTP(s) angebunden.
![Angular](../images/angular_einführung.png)  


### Vorteile von Angular

* **Umfangreiche Funktionalität**: Angular bietet eine Vielzahl von Funktionen und Features, die für die Entwicklung von komplexen Webanwendungen erforderlich sind. Es enthält ein leistungsfähiges Template-System, Datenbindung, Routing, Formularvalidierung, Dependency Injection und vieles mehr.

* **Strukturierte Architektur**: Angular basiert auf dem Konzept der Components-Based Architektur. Die Anwendung wird in unabhängige, wiederverwendbare Components strukturiert, was die Wartbarkeit und Testbarkeit erleichtert.

* **Produktivität**: Angular bietet viele Hilfsmittel, die die Entwicklungszeit verkürzen. Dazu gehören die Angular CLI (Command Line Interface) zur Projektgenerierung und automatisierten Aufgaben, ein reichhaltiges Ökosystem von Libraries und Extensions sowie eine umfangreiche Dokumentation.

* **TypeScript-Unterstützung**: Angular ist in TypeScript geschrieben, einer statisch typisierten Variante von JavaScript. TypeScript bietet statische Typisierung, verbesserte IDE-Unterstützung und ermöglicht eine bessere Fehlererkennung zur Entwicklungszeit.

### Nachteile von Angular

* **Lernkurve**: Angular ist ein umfangreiches Framework und erfordert eine gewisse Einarbeitungszeit. Die Konzepte wie Dependency Injection, TypeScript und das Componentmodel können für Entwickler mit wenig Erfahrung zunächst herausfordernd sein.

* **Grösse**: Angular ist ein umfangreiches Framework, was zu einer grösseren Dateigrösse der Anwendung führen kann. Dies kann die Ladezeit beeinflussen, insbesondere für mobile Geräte mit langsamer Internetverbindung.

* **Komplexität**: Aufgrund der vielen Funktionen und Konzepte kann die Komplexität von Angular zunehmen, insbesondere für kleinere Projekte, bei denen nicht alle Funktionen benötigt werden.

* **Abhängigkeit von Google**: Angular wurde von Google entwickelt und ist stark mit dem Unternehmen verbunden. Einige Entwickler haben Bedenken hinsichtlich der langfristigen Unterstützung und der Unabhängigkeit von Google.


## Angular Projekt aufsetzen
Um ein neues Angular-Projekt zu erstellen, kann man das Angular CLI (Command Line Interface) verwenden. Dazu muss es aber zuerst installiert werden.

### Angular CLI installieren
Man muss als Vorarbeit sicherstellen, dass Node.js auf dem Computer installiert ist (`npm -v` im Terminal eingeben). Im Terminal muss man danach den folgenden Befehl ausführen, um die Angular CLI global zu installieren:
```shell
npm install -g @angular/cli
```

### Projekt erstellen
Nun muss in das Verzeichnis wechseln, in dem das Angular-Projekt erstellen werden möchten, und nun muss man den folgenden Befehl ausführen:
```shell
ng new new-angular-project
```

Als Nächstes in das Projektverzeichnis wechseln, indem man den folgenden Befehl ausführen:
```shell
cd new-angular-project
```

### Projekt starten
Mit dem folgenden Befehl, kann man den Entwicklungsserver starten und das Angular-Projekt im Browser anzuzeigen:
```shell
ng serve
```

Der Entwicklungsserver wird gestartet und die Anwendung wird auf http://localhost:4200 bereitgestellt. Man kann diese URL in einem Webbrowser öffnen, um die Angular-Anwendung zu sehen.


## Angular CLI
Das Angular CLI (Command Line Interface) ist ein Befehlszeilenwerkzeug, das von Angular bereitgestellt wird. Es ermöglicht Entwicklern, effizienter mit Angular zu arbeiten, indem es verschiedene Funktionen und Befehle zur Verfügung stellt, um die Erstellung, Entwicklung, Bereitstellung und Wartung von Angular-Projekten zu unterstützen.

### Commands
* ng new <projektname>: Erstellt ein neues Angular-Projekt mit der angegebenen Projektstruktur und Konfiguration.

* ng serve: Startet den Entwicklungsserver und stellt Ihre Angular-Anwendung auf http://localhost:4200 bereit. Änderungen werden in Echtzeit reflektiert.

* ng serve --open: Startet den Entwicklungsserver und öffnet automatisch Ihren Standardwebbrowser, um Ihre Anwendung anzuzeigen.

* ng generate <art> <name> (oder ng g <art> <name>): Generiert eine neue Datei oder Komponente basierend auf einer vorgegebenen Vorlage. 
  * **Component**: ng generate component <name> oder ng g c <name>
  Erzeugt eine neue Component mit einer Componentdatei, einer Template-Datei, einer Stylesheet-Datei und einem Testfile.

  * **Module**: ng generate module <name> oder ng g m <name>
  
  * **Service**: ng generate service <name> oder ng g s <name>
  
  * **Directive**: ng generate directive <name> oder ng g d <name>
  
  * **Klassen**: ng generate class <name> oder ng g cl <name>
  
  * **Enum**: ng generate enum <name> oder ng g e <name>
  
  * **Interface**: ng generate interface <name> oder ng g i <name>
  
  * **Pipe**: ng generate pipe <name> oder ng g p <name>

  * **Guard**: ng generate guard <name>

* ng build: Kompiliert und baut Ihre Angular-Anwendung für die Produktion. Erzeugt optimierten JavaScript-Code, der für die Bereitstellung auf einem Webserver verwendet werden kann.

* ng test: Führt Ihre Unit-Tests aus, um sicherzustellen, dass Ihre Anwendung ordnungsgemäß funktioniert.

* ng lint: Überprüft Ihren Code auf Einhaltung der definierten Linting-Regeln.

* ng update: Aktualisiert Ihre Angular-Abhängigkeiten und -Pakete auf die neuesten Versionen.

* ng add <paketname>: Fügt ein externes Paket oder eine Bibliothek zu Ihrem Angular-Projekt hinzu. Installiert und konfiguriert das Paket automatisch.

* ng help: Zeigt eine Liste der verfügbaren Befehle und Optionen der Angular CLI an.


## Konfigurationsdatei für eine Angular-Anwendung
Die `angular.json`-Datei ist die Konfigurationsdatei für ein Angular-Projekt. Sie enthält verschiedene Einstellungen und Konfigurationen für das Build-System, die Erstellung des Projekts, den Asset-Manager und vieles mehr. Die Datei wird automatisch generiert, wenn ein neues Angular-Projekt mit der Angular CLI erstellt wird.


## Einstiegspunkt einer Angular-Anwendung
### Typescript
Der Einstiegspunkt einer Angular-Anwendung ist die Datei main.ts. Diese Datei ist das Hauptmodul der Anwendung, in dem der Bootstrap-Prozess gestartet wird.

```typescript
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule)$
        .catch(err => console.error(err));
```

Das AppModule selbst ist das Root-Modul der Angular-Anwendung. Es wird in der Regel in einer separaten Datei (`app.module.ts`) definiert und enthält die erforderlichen Importe und Konfigurationen für die Anwendung, einschliesslich der Components, Services, Modules und anderer Funktionen, welche d Anwendung benötigt.

Die `main.ts`-Datei wird beim Starten der Angular-Anwendung vom Build-System oder von der Angular CLI aufgerufen. Sie ist der erste Punkt, an dem der Angular-Bootstrap-Prozess beginnt und die erforderlichen Ressourcen und Module geladen werden.

Es ist wichtig zu beachten, dass die `main.ts`-Datei normalerweise nicht manuell bearbeitet werden muss, es sei denn, man hat spezifische Anpassungen oder Erweiterungen für den Bootstrap-Prozess vorzunehmen. Die meisten Änderungen und Konfigurationen sollten im AppModule und den anderen Modulen der Anwendung vorgenommen werden.

### HTML
Das Einstiegs-HTML-Dokument einer Angular-Anwendung ist die `index.html`-Datei. Diese Datei wird automatisch generiert, wenn die Anwendung kompiliert.

In der `index.html`-Datei befindet sich das grundlegende HTML-Markup für die Anwendung. Hier werden die erforderlichen Skripte und Stylesheets eingebunden und der Ort definiert, an dem die Angular-Anwendung in das DOM eingefügt wird.
```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Angular App</title>
  <base href="/">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>
```
Im `<head>`-tag befindet sich der `<title>`-tag, dieser definiert den Titel der Webseite, der normalerweise im Browser-Tab angezeigt wird.
Das `<link rel="icon" type="image/x-icon" href="...">` bindet das Favicon (Favoriten-Symbol) der Webseite ein, das normalerweise im Browser-Tab und in Lesezeichen angezeigt wird.
Diese zwei kann man auch nach Belieben ändern.

Beim Starten der Angular-Anwendung wird der Inhalt der `index.html`-Datei vom Webbrowser geladen. Der Angular-Bootstrap-Prozess findet das `<app-root>`-Element und ersetzt es durch den gerenderten Inhalt der Angular-Komponenten.


## App Component
Der "AppComponent" ist der Hauptcomponent einer Angular-Anwendung. Es handelt sich um die Wurzelcomponent, von der aus alle anderen Components und Elemente der Anwendung hierarchisch aufgebaut sind.

Er wird automatisch während der Initialisierung der Anwendung erstellt und gerendert. Er dient als Container für das gesamte Anwendungslayout und ist der erste Component, die in der `index.html`-Datei der Anwendung geladen wird mittels dem `<app-root>`-Tag.


## Angular Best(Good)-Practices
Angular bietet eine Reihe von Best Practices, die helfen können, die Angular-Anwendungen effizienter, wartbarer und skalierbarer zu gestalten. Hier sind einige wichtige Angular Best Practices:
* **Verwendung der Angular CLI**: Die Angular CLI erstellt automatisch eine standardisierte Projektstruktur, die bewährte Praktiken und Konventionen folgt. Dies erleichtert die Organisation und Wartung des Codes, da Entwickler eine einheitliche Struktur erwarten können. Daher sollte zum Erstellen von neuen Dateien sollte auch immer die CLI verwendet werden. 
* **Eine Aufgabe pro Component**: Den Code sollte in kleine, wiederverwendbare Komponenten aufgeteilt werden. Jeder Component sollte eine klare Verantwortung haben und nur für eine spezifische Aufgabe zuständig sein. Um im Typescript Code Konventionen und Best Practices zu befolgen sollte man zudem einen Linter verwenden, um dies zu prüfen.
* **Nutzung der Angular Template-Syntax**: Es sollte die Angular-spezifische Template-Syntax verwendet werden, um Data-Bindung, Ereignisbehandlung und Strukturierung des DOMs im Templates zu erleichtern. Komplexe Logik in den Templates sollte vermieden werden, es sollte möglichst lesbar sein. Dazu kann man den Formatter wie Prettier am besten verwenden, um das gesamte zu vereinfachen.
* **Nutzung von Lazy Loading für Module**: Das Lazy Loading-Feature von Angular sollte verwendet werden, um die Ladezeit der Anwendung zu verbessern. Man sollte Module nur dann laden, wenn sie benötigt werden, anstatt die gesamte Anwendung auf einmal zu laden.

