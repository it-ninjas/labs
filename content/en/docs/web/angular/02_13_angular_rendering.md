---
title: "Rendering"
type: docs
linkTitle: "Rendering"
weight: 14
date: 2024-03-01
description: >
    Modul #F6 - Angular - Rendering in Angular
---

## Server Side Rendering (SSR)
Das serverseitige Rendering (SSR) ist ein Prozess, bei dem Seiten auf dem Server gerendert werden, was zu einem anfänglichen HTML-Inhalt führt, der den anfänglichen Zustand der Seite enthält.
Sobald der HTML-Inhalt an einen Browser übermittelt wird, initialisiert Angular die Anwendung und nutzt die im HTML enthaltenen Daten.

Die Hauptvorteile von SSR im Vergleich zum clientseitigen Rendering (CSR) sind:
* **Verbesserte Leistung**: SSR kann die Leistung von Webanwendungen verbessern, indem es vollständig gerendertes HTML an den Client liefert, das der Browser parsen und anzeigen kann, bevor er die JavaScript-Anwendung herunterlädt.
  Dies kann besonders vorteilhaft für Benutzer mit geringer Bandbreite oder mobilen Geräten sein.
* **Verbesserte Core Web Vitals**: SSR führt zu Leistungsverbesserungen, die mit Core Web Vitals (CWV)-Statistiken gemessen werden können, wie z. B. reduziertem First Contentful Paint (FCP) und Largest Contentful Paint (LCP) sowie Cumulative Layout Shift (CLS).
* **Besseres SEO**: SSR kann die Suchmaschinenoptimierung (SEO) von Webanwendungen verbessern, indem es Suchmaschinen erleichtert, den Inhalt der Anwendung zu durchsuchen und zu indexieren.

Um ein neues Projekt mit SSR zu erstellen, führen man folgenden Befehl aus:
```shell
ng new --ssr
```

Um SSR zu einem vorhandenen Projekt hinzuzufügen, verwenden man den Angular CLI-Befehl `ng add`.
```shell
ng add @angular/ssr
```

Diese Befehle erstellen und aktualisieren den Anwendungscode, um SSR zu aktivieren, und fügen dem Projektstrukturspezifische Dateien hinzu.

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

Prerendering behält die gleichen Leistungsvorteile des serverseitigen Renderings (SSR) bei, erreicht jedoch eine reduzierte Time to First Byte (TTFB), was letztendlich die Benutzererfahrung verbessert.
Der wesentliche Unterschied liegt in seinem Ansatz, dass Seiten als statischer Inhalt bereitgestellt werden und keine anfragebasierte Rendern erfolgt.

Wenn die für das serverseitige Rendering erforderlichen Daten bei allen Benutzern konsistent bleiben, erweist sich die Strategie des Prerenderings als wertvolle Alternative.
Anstatt Seiten dynamisch für jede Benutzeranfrage zu rendern, geht das Prerendering proaktiv vor und rendert sie im Voraus.

Um eine statische Seite vorzuerrendern, fügt man in der Anwendung mit dem folgenden Angular CLI-Befehl die SSR-Fähigkeiten hinzu:
```shell
ng add @angular/ssr
```

Um eine Anwendung mit Prerendering-Fähigkeiten von Anfang an zu erstellen, verwendet man den Befehl:
```shell
ng new --ssr
```

Sobald SSR hinzugefügt wurde, kann man die statischen Seiten generieren, indem man den Build-Befehl ausführen:
```shell
ng build
```

## Hydration
Die Hydration ist der Vorgang, der die serverseitig gerenderte Anwendung auf dem Client wiederherstellt. Dazu gehört das Wiederverwenden der serverseitig gerenderten DOM-Strukturen, das Beibehalten des Anwendungszustands, das Übertragen von bereits vom Server abgerufenen Anwendungsdaten und andere Prozesse.

Die Hydration verbessert die Leistung der Anwendung, indem zusätzliche Arbeit zur Neuerstellung von DOM-Knoten vermieden wird. Stattdessen versucht Angular, vorhandene DOM-Elemente zur Laufzeit mit der Anwendungsstruktur abzugleichen und wiederverwendet DOM-Knoten, wenn möglich.
Dies führt zu einer Leistungsverbesserung, die anhand von Core Web Vitals (CWV)-Statistiken gemessen werden kann, z.B. der Reduzierung der First Input Delay (FID) und Largest Contentful Paint (LCP) sowie des Cumulative Layout Shift (CLS). Eine Verbesserung dieser Kennzahlen wirkt sich auch auf Dinge wie die SEO-Leistung aus.

Ohne aktiviert Hydration werden serverseitig gerenderte Angular-Anwendungen die DOM der Anwendung zerstören und erneut rendern, was zu einem sichtbaren Flackern der Benutzeroberfläche führen kann. Dieses erneute Rendern kann sich negativ auf Core Web Vitals wie LCP auswirken und zu einem Layout-Shift führen.
Durch Aktivieren der Hydration können die vorhandenen DOM-Elemente wiederverwendet werden und ein Flackern wird verhindert.

### Wie aktiviert man die Hydratisierung in Angular
Bevor man mit der Hydration beginnen kann, muss man eine serverseitig gerenderte (SSR) Anwendung besitzen. Sobald die Anwendung mit SSR zum Laufen gebracht wurde, können die Hydration aktiviert werden. Indem die Hauptanwendungskomponente oder das Hauptmodul besucht wird und `provideClientHydration` von `@angular/platform-browser` importiert wird.
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

Alternativ, wenn man `NgModules` verwendet, fügt man `provideClientHydration` zur Provider-Liste im Root-App-Moduls hinzu.

```ts
import {provideClientHydration} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

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

