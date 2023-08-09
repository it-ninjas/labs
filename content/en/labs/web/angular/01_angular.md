---
title: "Labs zu Angular"
type: docs
linkTitle: "Angular Labs"
weight: 1
date: 2021-11-01
description: >
     Aufgaben zu Angular.
---
# Aufgaben
In diesen Aufgaben wirst du eine Applikation erstellen, die dir Informationen über verschiedene Velos anzeigt. Erstelle die Applikation anhand des bereitgestellten Codes und den dazugehörigen Informationen.
## Aufgabe 1
Folgender Code ist gegeben:
Datei `../interfaces.ts`:
```typescript
export interface Bicycle {
    name: string;
    url: string;
  }
  
  export interface BicycleImage {
    displayLink: string;
    fileFormat: string;
    htmlSnippet: string;
    htmlTitle: string;
    image: {
      byteSize: number;
      contextLink: string;
      height: number;
      thumbnailHeight: number;
      thumbnailLink: string;
      thumbnailWidth: number;
      width: number;
    };
    kind: string;
    link: string;
    mime: string;
    snippet: string;
    title: string;
  }
  
  export interface GoogleCustomSearchResponse {
    kind: string;
    url: {
      type: string;
      template: string;
    };
    queries: {
      request: {
        count: number;
        cx: string;
        inputEncoding: string;
        outputEncoding: string;
        safe: string;
        searchTerms: string;
        searchType: string;
        startIndex: number;
        title: string;
        totalResults: string;
      }[];
      nextPage: {
        count: number;
        cx: string;
        inputEncoding: string;
        outputEncoding: string;
        safe: string;
        searchTerms: string;
        searchType: string;
        startIndex: number;
        title: string;
        totalResults: string;
      }[];
    };
    searchInformation: {
      searchTime: number;
      formattedSearchTime: string;
      totalResults: string;
      formattedTotalResults: string;
    };
    items: BicycleImage[];
    context?: {
      title: string;
    };
  }
```

Datei `bicycle.component.ts`:
```typescript
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bicycle, BicycleImage, GoogleCustomSearchResponse } from '../interfaces';

@Component({
  selector: 'app-bicycle',
  templateUrl: './bicycle.component.html',
  styleUrls: ['./bicycle.component.scss'],
})
export class BicycleComponent implements OnInit {
  public bicycle: Bicycle = { name: '', url: '' };
  favoriteBicycle: BicycleImage[] = [];

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.bicycle.name = 'Specialized Diverge Pro Carbon';
    this.bicycle.url =
            'https://assets.specialized.com/i/specialized/96220-10_DIVERGE-PRO-CARBON-ETAP-REDWD-SMK-CHRM_HERO?bg=rgb(241,241,241)&w=2500&h=1406&fmt=auto';
  }

  public displayBicycleName() {
    alert(this.bicycle.name);
  }

  public getFavoriteBicycleImage() {
    const url =
            'https://www.googleapis.com/customsearch/v1?key=AIzaSyDNGfS6NUdgwXOwKu9xlZPJFm84ylG6J4g&cx=005124428384360536924:rstfldysumw&q=' +
            this.bicycle.name +
            '&searchType=image&safe=high';

    this.httpClient.get<GoogleCustomSearchResponse>(url).subscribe((response: GoogleCustomSearchResponse) => {
      for (let i = 0; i < 4; i++) {
        let item: BicycleImage = response.items[i];
        item.image.height = (200 / item.image.width) * item.image.height;
        item.image.width = 200;
        this.favoriteBicycle.push(item);
      }
    });
  }
}
```
Folgendes muss angezeigt werden, wenn die Seite geladen wurde:

![Components Description](./../../../../docs/web/angular/images/first-page.png)


- "Wie heisst mein Fahrrad?" ist mit der Funktion "displayBicycleName()" verknüpft.
- "Mein Liebslingsfahrrad suchen" ist mit der Funktion "getFavoriteBicycleImage()" verknüpft.
- Für die Anzeige der Lieblingsfahrräder muss ein `*ngFor` gebraucht werden.
- Tipp: Die Weite und Höhe der Bilder kann direkt mit einem Propertybinding gemacht werden.

Folgendes wird nach dem Klick auf "Wie heisst mein Fahrrad?" angezeigt:

![Bicycle Notification](../../../../docs/web/angular/images/bicycle-name-notification.png)


Folgende Seite wird nach dem Klick auf "Mein Lieblingsfahrrad suchen" angezeigt:

![Components Description](../../../../docs/web/angular/images/second-page.png)

## Aufgabe 1.1
Passe den bestehenden Code aus Aufgabe 1 so an, dass das Inputfeld ein `FormControl` ist. Zudem soll neu dieses Inputfeld als Suche funktionieren, das bedeutet das man der Funktion der Wert des Inputs übergeben kann.
So soll dann immer die Bilder zum Wert angezeigt werden und auch der Text "Mein Lieblingsfahrrad: " sollte immer den Wert es Inputs anzeigen.

## Aufgabe 2
Diese Aufgabe wird ein nun grösseres Projekt, der Sinn hinter diesem ist das Verwalten der Fahrräder mit einem objekt-orientierten Ansatz. Zusätzlich soll die Trennung von Modell-Klassen, Services und Components detaillierter betrachtet werden.
Zudem besitzt man nach Abschluss der Aufgabe ein richtiges und praxisorientiertem Beispiel für ein Frontend.

Erstelle ein neues Angular Projekt. 

Im neu erstellten Projekt wollen wir Daten für folgende (Datenbank-)Entitäten mit einem objekt-orientierten Ansatz abbilden:
![ERD](../../../../docs/web/angular/images/bicycle-erd-diagram.png)

Folgende Anforderungen sind gegeben:
- Erstelle für jede Entität (ohne die Zwischentabelle `Bicycle_Type`) des Models eine geeignete Modell-Klasse.
- Erstelle für jede Modell-Klasse einen Service.
- Erstelle bei jedem Service Beispieldaten.
- Behalte die Ordnerstruktur korrekt (Ordner für die Components, Ordner für die Services, etc.).
- Der BicycleService enthält folgende Funktionen: `getBicycle(id: number)`, `getAllBicycle()` und `getFullBicycle(id: number)`. (Der Unterschied zwischen Bicycle und FullBicycle sollte sein das beim Full die Typen und Marke als String angegeben werden und bim Bicycle kann es nur die ID sein.)
- Der BrandService enthält folgende Funktionen: `getBrand(id: number)` und `getBrandName(id: number)`.
- Der TypeService enthält folgende Funktionen: `getTypes(ids: number[])` und `getTypesName(ids: number[])`.
- Sollte der Benutzer bei den Services versuchen etwas zu getten was es nicht gibt sol einen Fehler geworfen werden mit `throw Error`.
- Erstelle einen globalen ErrorHandler um die möglichen Fehler der Services abzufangen und gib eine Mitteilung damit der Benutzer weiss, das ein Fehler passierte (Subject verwenden).
- Erstelle einen neuen Component um die Daten alles Fahrräder anzuzeigen.

## Aufgabe 2.1
Erweitern wir die Anwendung nun ein wenig.
- Erstelle einen weiteren neuen Component, welcher ein Eingabefeld, mit ReactiveForms, besitzt um nach einem Fahrrad zu suchen und dieses anzuzeigen.
- Erstelle eine Navigation für zwischen den Components hin und her zu wechseln.
- Erstelle eine Route für die Components. Der Component welcher alle Fahrräder anzeigt ist zudem die Defaultroute.
- Füge auf der Seite aller Fahrräder zwei Buttons hinzu. Einer um die Such-Seite zu aktiveren und den anderen um sie zu deaktivieren. Verwende hier ein `BehaviorSubject` um den momentan State zu kennen.
- Erstelle einen Guard welcher dich nur zu der Suche-Seite lässt, wenn du diese aktiviert hast mittels Button.
- Erstelle auch ein Routing auf den neu zu Erstellenden Component, welche mithilfe eines Parameters alle Fahrräder (der name, wert, marke und typen) der jeweiligen Marke anzeigt. Zudem soll die Marke als Titel der Seite stehen.
- Verlinke die brand_id, als routerLink auf der Seite aller Fahrräder um auf den neuen Component zu gelangen.


## Aufgabe 2.2
In den vorherigen Aufgaben hast du eine Grundstruktur geschaffen für die Anzeige. Wenn man nach einem Fahrrad sucht, sollte nun das Ergebnis mit einer Pipe angepasst werden.
- Erstelle nun eine Pipe welche die Spalte `value` im Format `1'720.00 CHF` anzeigt. Der Währungstyp wird mit einem Parameter weitergegeben.
  Sofern nichts angegeben wird, wähle Standardmässig `CHF`.
- Geh davon aus das in der Spalte `value` auch Zahlen wie `1287.87` oder `5421.21` gespeichert sind. Runde diese je nachdem auf oder ab.
- Auch das Hochzeichen (`'`) soll immer nach 3 Stellen erscheinen.
- Erstelle eine weitere Pipe, welche den Markennamen nur mit Grossbuchstaben anzeigt und hinter den Markennamen ein Copyrightzeichen (`©`) setzt.

**Wichtig**: Wende die Pipe im Template an und nicht im Typescript.

## Aufgabe 2.3
Um die Anwendung nun ein bisschen schöner darzustellen, brauchen wir nun Angular Material.
Hier kannst du selbst auswählen welche Components du verwenden möchtest. Du musst jedoch mindestens 5 verschiedene Components in deiner Anwendung verwendet haben.
