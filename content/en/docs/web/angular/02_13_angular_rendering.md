---
title: "Rendering"
type: docs
linkTitle: "Rendering"
weight: 14
date: 2024-03-01
description: >
  Modul #F6 - Angular - Rendering in Angular
---

### Ziele
- Du weisst, was Server Side Rendering ist und welche Vorteile dieses bietet. 
- Du weisst, was Static Site Generation ist und welche Vorteile diese bietet. 
- Du kennst das Konzept der Hydration und weisst, wie man diese für ein Angular-Projekt aktiviert. 

## Server Side Rendering (SSR)

Das serverseitige Rendering (SSR) ist ein Prozess, bei dem Seiten einer Webseite auf dem Server gerendert werden, was zu einem anfänglichen HTML-Inhalt führt, der den anfänglichen Zustand der Seite enthält.
Sobald der HTML-Inhalt an einen Browser übermittelt wird, initialisiert Angular die Anwendung und nutzt die im HTML enthaltenen Daten.

Die Hauptvorteile von SSR im Vergleich zu clientseitigem Rendering (CSR) sind:

- **Verbesserte Leistung**: SSR kann die Leistung von Webanwendungen verbessern, indem es vollständig gerendertes HTML an den Client liefert, welches der Browser parsen und anzeigen kann, bevor er die JavaScript-Anwendung herunterlädt.
  Dies kann besonders vorteilhaft für Benutzer mit geringer Bandbreite oder mobilen Geräten sein.
- **Verbesserte Core Web Vitals**: SSR führt zu Leistungsverbesserungen, die mit Core Web Vitals (CWV)-Statistiken gemessen werden können, wie z. B. reduziertem First Contentful Paint (FCP) und Largest Contentful Paint (LCP) sowie Cumulative Layout Shift (CLS).
- **Besseres SEO**: SSR kann die Suchmaschinenoptimierung (SEO) von Webanwendungen verbessern, indem es es Suchmaschinen erleichtert, den Inhalt der Anwendung zu durchsuchen und zu indexieren.

Seit Angular 17 muss man keine speziellen Schritte mehr durchführen, um das Server-Side-Rendering in seine Angular-Applikaton zu integrieren.
Wird ein neues Angular-Projekt mit `ng new <>` generiert, wird seit Angular 17 direkt beim Generieren gefragt, ob SSR für das Projekt aktiviert werden soll.

Um SSR zu einem bereits existierenden Angular-Projekt hinzuzufügen, kann man den folgenden Befehl ausführen: 
```shell
ng add @angular/ssr
```
Diese Befehle erstellen und aktualisieren den Anwendungscode, um SSR zu aktivieren, und fügen dem Projekt strukturspezifische Dateien hinzu.

### Projektstruktur

```
my-app
|-- server.ts                       # Anwendungsserver
└── src
    |-- app
    |   └── app.config.server.ts    # Konfiguration für den Server
    └── main.server.ts              # Haupt-Bootstrapping für den Anwendungsserver
```

## Static Site Generation (SSG)

Prerendering, häufig als Static Site Generation (SSG) bezeichnet, stellt die Methode dar, bei der Seiten während des Build-Prozesses zu statischen HTML-Dateien gerendert werden.

Prerendering behält die Leistungsvorteile des serverseitigen Renderings (SSR) bei, erreicht jedoch eine reduzierte Time to First Byte (TTFB), was letztendlich die Benutzererfahrung verbessert.
Der wesentliche Unterschied liegt im Ansatz, dass Seiten als statischer Inhalt bereitgestellt werden und kein anfragebasiertes Rendern erfolgt.

Wenn die für das serverseitige Rendering erforderlichen Daten bei allen Benutzern konsistent bleiben, erweist sich die Strategie des Prerenderings als wertvolle Alternative.
Anstatt Seiten dynamisch für jede Benutzeranfrage zu rendern, geht das Prerendering proaktiv vor und rendert sie im Voraus.

Insofern ein Angular-Projekt mit SSR-Funktionalitäten erstellt wird oder SSR zu einem bestehenden Angular-Projekt hinzugefügt wird, wird auch automatisch SSG aktiviert. 
Es ist möglich, SSG je nach Wunsch ein- oder auszuschalten. Das lässt sich in der `angular.json`-Datei bewerkstelligen: 

```json
{
  "architect": {
    "build": {
      "options": {
        "server": "src/main.server.ts",
        //Mithilfe des "prerender"-Settings lässt sich SSG für das Projekt ein- oder ausschalten  
        "prerender": false,
        "ssr": {
          "entry": "server.ts"
        }
      }
    }
  }
}
```

Es ist ebenfalls möglich, nur SSG ohne SSR zu verwenden. Die Konfiguration sieht dabei ähnlich aus wie beim Fall oben:

```json
{
  "architect": {
    "build": {
      "options": {
        "server": "src/main.server.ts",
        "prerender": {
          "routesFile": "prerender-routes.txt"
          "discoverRoutes": false
        },
        //Mithilfe des "ssr"-Settings lässt sich SSR für das Projekt ein- oder ausschalten 
        "ssr": false
      }
    }
  }
}
```

Um zu prüfen, ob alles funktioniert wie gewünscht, kannst du das Projekt mit dem folgenden Befehl lokal builden. 

```shell
ng build
```

## Hydration

Als Hydration beschreibt man den Vorgang, der die serverseitig gerenderte Anwendung auf dem Client wiederherstellt. Dazu gehört das Wiederverwenden der serverseitig gerenderten DOM-Strukturen, das Beibehalten des Anwendungszustands, das Übertragen von bereits vom Server abgerufenen Anwendungsdaten und andere Prozessen.

Die Hydration verbessert die Leistung der Anwendung, indem zusätzliche Arbeit zur Neuerstellung von DOM-Knoten vermieden wird. Stattdessen versucht Angular, vorhandene DOM-Elemente zur Laufzeit mit der Anwendungsstruktur abzugleichen und verwendet DOM-Knoten wieder, wenn möglich.
Dies führt zu einer Leistungsverbesserung, die anhand von Core Web Vitals (CWV)-Statistiken gemessen werden kann, z.B. der Reduzierung des First Input Delay (FID) und Largest Contentful Paint (LCP) sowie des Cumulative Layout Shift (CLS). Eine Verbesserung dieser Kennzahlen wirkt sich auch auf Aspekte wie die SEO-Leistung aus.

Ohne aktivierte Hydration werden serverseitig gerenderte Angular-Anwendungen die DOM der Anwendung zerstören und erneut rendern, was zu einem sichtbaren Flackern der Benutzeroberfläche führen kann. Dieses erneute Rendern kann sich negativ auf Core Web Vitals wie LCP auswirken und zu einem Layout-Shift führen.
Durch Aktivieren der Hydration können die vorhandenen DOM-Elemente wiederverwendet werden, wodurch ein Flackern verhindert wird.

### Wie man die Hydratisierung in Angular aktiviert

Bevor man mit der Hydration beginnen kann, muss man eine serverseitig gerenderte (SSR) Anwendung besitzen. Sobald die Anwendung mit SSR zum Laufen gebracht wurde, kann die Hydration aktiviert werden. Indem die Hauptanwendungskomponente oder das Hauptmodul besucht wird und `provideClientHydration` von `@angular/platform-browser` importiert wird.
Anschliessend fügt man diesen Provider zur Liste der Bootstrapping-Provider in der App hinzu.

```ts
import {
  bootstrapApplication,
  provideClientHydration,
} from '@angular/platform-browser';

...

bootstrapApplication(AppComponent, {
  providers: [provideClientHydration()]
});
```

Alternativ, insofern man `NgModules` verwendet, fügt man `provideClientHydration` zur Provider-Liste im Root-App-Module hinzu.

```ts
import { provideClientHydration } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

@NgModule({
  declarations: [AppComponent],
  exports: [AppComponent],
  bootstrap: [AppComponent],
  providers: [provideClientHydration()],
})
export class AppModule {}
```

**WICHTIG:** Es muss sichergestellt werden, dass der Aufruf von `provideClientHydration()` auch in einer Liste von Providern enthalten ist, die zum Bootstrappen einer Anwendung auf dem Server verwendet wird. In Anwendungen mit der standardmässigen Projektstruktur (generiert durch den Befehl `ng new`), sollte es ausreichen, den Aufruf im Root-App-Modul hinzuzufügen, da dieser vom Servermodul importiert wird.
Wenn man eine benutzerdefinierte Konfiguration verwendet, sollte man den Aufruf von `provideClientHydration()` zur Provider-Liste in der Konfiguration zum Server-Bootstrapping hinzufügen.
