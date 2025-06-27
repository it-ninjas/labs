---
title: "Internationalization (i18n)"
type: docs
linkTitle: "Internationalization (i18n)"
weight: 24
date: 2023-04-20
description: >
  Modul #F6 - Angular - Internationalization
---

## Ziele

- Du weisst, wofür die Internationalisierung verwendet wird.
- Du kannst diese in deinen Projekten anwenden.

## Wofür wird die Internationalisierung verwendet?

Internationalisierung (i18n) bezieht sich auf die Anpassung einer Anwendung, um sie für verschiedene Sprachen und Regionen weltweit zugänglich und benutzbar zu machen. Durch Internationalisierung wird die Anwendung so gestaltet, dass sie leicht in verschiedene Sprachen übersetzt werden kann, um eine breitere Benutzerbasis anzusprechen.

Meistens wird die Internationalisierung mit JSON und einer Translate-Pipe umgesetzt. Dabei werden JSON-Dateien verwendet, um die einzelnen Texte jeweils pro Sprache zu speichern, und die Translate-Pipe wird verwendet, um die passenden Übersetzungen abzurufen und anzuzeigen.
Wichtig zu beachten ist hierbei, dass bei einem Wechsel der Sprache die Texte umgeschalten werden, ohne dass die Seite neu laden muss.

## Internationalisierung mit JSON und einer Translate-Pipe einrichten

1. Zuerst muss man für die jeweiligen Übersetzungen JSON-Dateien erstellen: Für jede Sprache, die man unterstützen möchte, sollte man ein eigenes JSON erstellen. Diese sollten in einen neuen Ordner names `i18n` in den `assets` des Projekts abgelegt werden. Die JSON-Dateien werden meistens [kürzel].json benannt. Also zum Beispiel für Deutsch `de.json`.
2. Inhalt einfügen: Nun kann man die Wörter und Texte, die man dynamisch übersetzen lassen möchte, in die JSON-Dateien eintragen. Diese werden nach dem Key-Value Prinzip eingetragen, wobei der Key in Capslock ist. Zudem müssen die Keys für die jeweiligen entsprechenden Textteile in allen JSON-Dateien immer gleich sein, ansonsten funktioniert die Übersetzung nicht. Man kann einem Key auch mehrere weitere Key-Value Paare geben, was gemacht wird, wenn sie zueinander gehören.

```json
// de.json
{
  "TITEL": "Hallo, ",
  "TEXT": {
    "DRAGONWARRIOR": {
      "WELCOME": "Willkommen im Kampf gegen den Feind Angular!",
      "OTHER": "Möge dein Weg von Ruhm und Triumph erfüllt sein!"
    },
    "OTHER": "Du bist nicht der wahre Drachenkrieger. Du bist dieses Kampfes nicht würdig."
  }
}
```

```json
// en.json
{
  "TITEL": "Hello, ",
  "TEXT": {
    "DRAGONWARRIOR": {
      "WELCOME": "Welcome to the battle against the enemy Angular!",
      "OTHER": "May your path be filled with glory and triumph!"
    },
    "OTHER": "You are not the true Dragon Warrior. You are not worthy of this battle."
  }
}
```

3. Library installieren: Nun muss man eine Library installieren, um die translate-Pipe verwenden zu können. Dazu kann man den Befehl `npm install @ngx-translate/core` benutzen, um die `@ngx-translate/core`-Library zu installieren. Und den Befehl `npm install @ngx-translate/http-loader`, damit man die Library `@ngx-translate/http-loader` verwenden kann. Diese wird verwendet, damit der HTTPLoader in ngx-translate verwendet werden kann.
4. Das Translate-Module importieren: Um die Übersetzung App-weit zu ermöglichen, muss das TranslateModule im AppComponent imporiert werden.

```typescript
@Component({
  //...
  standalone: true,
  imports: [CommonModule, TranslateModule],
  //...
})
export class AppComponent {
  //....
}
```

5. Falls es noch kein `environment`-File im Projekt gibt, muss dieses erstellt werden. Dazu muss in `src` ein Ordner `environments` erstellt werdne. Darin dann das File `environment.ts`.

```typescript
export const environment = {
  // ...
  languages: ["de", "en"],
};
```

6. Sprachlokalisierung aktivieren: Mithilfe des `TranslateService` kann man die gewünschte Sprache einstellen und die übersetzten Texte in der entsprechenden Sprache anzeigen. Man kann die Sprache basierend auf Benutzervorlieben oder anderen Kriterien festlegen.
   Das wird immer im `app.components.ts` gemacht.

```typescript
import { TranslateService } from "@ngx-translate/core";
import { environment } from "src/environments/environments";

@Component({
  // ...
})
export class AppComponent implements OnInit {
  // ..

  constructor(private translateService: TranslateService) {}

  ngOnInit() {
    this.translateService.addLangs(environment.languages);
    this.setLanguage("en");
  }

  setLanguage(lang: string) {
    this.translateService.use(lang);
  }
}
```

7. Translate-Pipe in den HTML-Dateien: In den HTML-Dateien der Components kann man nun die Translate-Pipe verwenden, um die lokalisierten Texte anzuzeigen. Dazu die Pipe `translate` mit dem Übersetzungs-Key verwenden, um die Übersetzungen abzurufen. Wurden einem Key mehrere neue Key-Value Paare gegeben, so ruft man den äussersten Schlüssel auf und fügt ihn mittels eines Punktes (`.`) mit dem nächsten Key zusammen.

```html
<h1>{{ 'TITEL' | translate }}{{ name }}!</h1>

<ng-container *ngIf="name === 'Dragon Warrior'; else otherName">
  <ng-container *ngTemplateOutlet="dragonWarrior"></ng-container>
</ng-container>

<ng-template #dragonWarrior>
  <p>{{ 'TEXT.DRAGONWARRIOR.WELCOME' | translate }}</p>

  <p>{{ 'TEXT.DRAGONWARRIOR.OTHER' | translate }}</p>
</ng-template>

<ng-template #otherName>
  <p>{{ 'TEXT.OTHER' | translate }}</p>
</ng-template>
```

## Anwendungsbeispiele

```typescript
// Fügt die Sprachen "en" und "de" zu den möglichen Sprachen hinzu.
this.translateService.addLangs(["en", "de"]);
// Gibt Englisch als standardmässig verwendete Sprache an.
this.translateService.setDefaultLang("en");
// Liest die derzeitige im Browser verwendete Sprache aus.
const browserLang = translateService.getBrowserLang();
// Prüft, ob die derzeitige im Browser verwendete Sprache englisch oder deutsch entspricht. Entspricht einer der beiden Fälle
this.translateService.use(browserLang.match(/en|de/) ? browserLang : "en");
```
