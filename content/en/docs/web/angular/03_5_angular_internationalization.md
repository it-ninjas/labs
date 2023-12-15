---
title: "Internationalization (i18n)"
type: docs
linkTitle: "Internationalization (i18n)"
weight: 22
date: 2023-04-20
description: >
  In diesem Kapitel wird erläutert was Internationalization ist.
---
## Ziele
* Du weisst, wofür Internationalisierung ist.
* Du kannst diese in deinen Projekten anwenden.

## Wofür ist Internationalisierung 
Internationalisierung (i18n) bezieht sich auf die Anpassung einer Anwendung, um sie für verschiedene Sprachen und Regionen weltweit zugänglich und benutzbar zu machen. Durch Internationalisierung wird die Anwendung so gestaltet, dass sie leicht in verschiedene Sprachen übersetzt werden kann, um eine breitere Benutzerbasis anzusprechen.

Meistens wird die Internationalisierung mit JSON und einer Translate-Pipe umgesetzt. Dabei werden JSON-Dateien verwendet, um die übersetzten Texte zu speichern, und die Translate-Pipe wird verwendet, um die entsprechenden Übersetzungen abzurufen und anzuzeigen.


## Internationalisierung mit JSON und einer Translate-Pipe einrichten
1. Zuerst muss man JSON-Dateien erstellen für die Übersetzungen: Für jede Sprache, die man unterstützen möchte, sollte man ein eigenes JSON erstellen. Diese sollten in einen neuen Ordner names `i18n` in den `assets` abgelegt werden. Die JSON-Dateien werden meistens [kürzel].json benannt. Also zum Beispiel für Deutsch `de.json`.
2. Inhalt einfügen: Nun kann man die Wörter und Texte, die man dynamisch übersetzen, lassen möchte in die JSON-Dateien eintragen. Diese werden nach dem Key-Value Prinzip eingetragen, wobei der Key in Capslock ist. Zudem müssen die Keys in allen JSONs immer gleich sein für den gleichen Text, ansonsten funktionierts nicht. Man kann einem Key auch mehrere weitere Key-Value Paare geben, dies wird getan, wenn sie zueinander gehören. 
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

3. Library installieren: Nun muss man eine Library installieren um die Pipe verwenden zu können. Dazu kann man den Befehl `npm install @ngx-translate/core` benutzen, um die `@ngx-translate/core`-Library zu installieren. Und den Befehl `npm install @ngx-translate/http-loader` damit man die Library `@ngx-translate/http-loader` verwenden kann, diese wird verwendet damit man HTTPLoader in ngx-translate verwenden kann.
4. TranslateModule konfigurieren: Das `TranslateModule` aus @ngx-translate/core muss man in das `app.module.ts` importieren. Danach muss man es in den `imports` konfiguriere. Nun muss man die Konfiguration entsprechend den Dateipfaden und Einstellungen anpassen.
```typescript
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

// ...

export function createTranslateLoader(http: HttpClient) {
    // Pfad der JSON-Datein mit den übersetzungen
    return new TranslateHttpLoader(http, './../assets/i18n/', '.json');
}

@NgModule({
    imports: [
        // ...
        HttpClientModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: createTranslateLoader,
                deps: [HttpClient]
            }
        })
    ],
    // ...
})
export class AppModule { }
```

5. Falls es noch kein `environment`-File im Projekt gibt muss man dieses erstellen. Dazu im `src` einen Ordner `environments` erstellen und darin das File `environment.ts
```typescript
export const environment = {
    // ...
    languages: ['de', 'en']
};
```

6. Sprachlokalisierung aktivierung: Mithilfe des `TranslateService` kann man die gewünschte Sprache einstellen und die übersetzten Texte in der entsprechenden Sprache anzeigen. Man kann die Sprache basierend auf Benutzervorlieben oder anderen Kriterien festlegen.
Dies wird immer im `app.components.ts` getan.
```typescript
import { TranslateService } from '@ngx-translate/core';
import { environment } from 'src/environments/environments';

@Component({
    // ...
})
export class AppComponent implements OnInit {
    // ..

    constructor(private translateService: TranslateService) {}

    ngOnInit() {
        this.translateService.addLangs(environment.languages);
        this.setLanguage('en')
    }

    setLanguage(lang: string) {
        this.translateService.use(lang);
    }
}
```

7. Translate-Pipe in den HTML-Dateien: In den HTML-Dateien der Components kann man die Translate-Pipe verwenden, um die lokalisierten Texte anzuzeigen. Dazu die Pipe `translate` mit dem Übersetzungs-Key verwenden, um die Übersetzungen abzurufen. Wurden einem Key mehrere neue Key-Value Paare geben so ruft man den äussersten Schlüssel auf und fügt ihn mittels eines Punktes (`.`) mit dem nächsten Key zusammen.
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

