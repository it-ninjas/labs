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