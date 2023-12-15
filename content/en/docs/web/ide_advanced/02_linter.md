---
title: "Linter"
linkTitle: "Linter"
weight: 2
date: 2023-05-12
description: >
    Hier wird erklärt was Linter sind und wie man diese benutzt.
---
## Linter
Ein Linter analysiert den Quellcode auf der Grundlage vordefinierter Regeln, Konventionen und Best Practices. Er prüft den Code auf häufige Fehler wie fehlende Semikolons, undefinierte Variablen, nicht verwendete Importe, ungültige Syntax und andere potenzielle Probleme. Darüber hinaus kann ein Linter auch den Code-Stil überprüfen, um sicherzustellen, dass er den vereinbarten Standards im Projekt entspricht.
Der Hauptzweck eines Linters besteht darin, Entwicklern dabei zu helfen, qualitativ hochwertigen Code zu schreiben, der gut strukturiert und leicht wartbar ist.


### Prettier
Prettier ist ein beliebtes Codeformatierungstool, das dazu dient, den Code in einem einheitlichen und konsistenten Stil zu formatieren. Im Gegensatz zu einem Linter wie ESLint, der sich auf Code-Stilregeln konzentriert, konzentriert sich Prettier ausschliesslich auf die Formatierung des Codes.

Prettier unterstützt eine Vielzahl von Programmiersprachen, einschliesslich JavaScript, TypeScript, HTML, CSS, JSON etc.
Es bietet eine Reihe von Formatierungsregeln, die auf bewährten Praktiken basieren, um den Code lesbarer und einheitlicher zu gestalten.
Prettier kann den gesamten Code automatisch formatieren, einschliesslich Einrückungen, Zeilenumbrüchen, Leerzeichen, Klammern und anderen Formatierungsaspekten.

#### Prettier konfigurieren
Prettier benötigt normalerweise keine umfangreiche Konfiguration, da es über standardmässige Formatierungsregeln verfügt. Man kann jedoch bestimmte Einstellungen in einer .`prettierrc`-Datei festlegen, um das Verhalten anzupassen.

Hier ist ein Beispiel wie man dies tun kann:

Wenn man z.B.
* die Anzahl der Leerzeichen (2) festlegen will, die für einen Tab verwendet werden sollen,
* doppelte Anführungszeichen `"` mit einfachen `'` ersetzen will,
* Tabs durch Leerzeichen ersetzen will,
* fehlende Semikolons (im JavaScript) automatisch hinzufügen will,
* automatisch Space bei Klammern hinzufügen will,
  dann kann dies wie folgt getan werden.
```json
{
  "printWidth": 120,
  "singleQuote": true,
  "useTabs": false,
  "tabWidth": 2,
  "semi": true,
  "bracketSpacing": true
}
```

Weitere Informationen zu den verfügbaren Optionen und deren Werten finden man in der Prettier-Dokumentation unter https://prettier.io/docs/en/configuration.html.

#### Prettier ausführen
Das Prettier Plugin kann man wie folgt ausführe.
* **IntelliJ**: Alt-Shift-Ctrl-P auf Windows und Linux oder Alt-Shift-Cmd-P auf macOS.

* **VSCode**: [Shift] + [Alt] + [F] unter Windows und Linux und [Shift] + [Option] + [F] auf macOS. Alternativ kannst du durch Klick auf [F1] den Task "Format Document (With...)" auswählen. Auf diese Weise kannst du auch gleich den Default-Formatter festlegen (wenn du es noch nicht in der Datei `settings.json` wie oben beschrieben getan hast).


### ESLint
ESLint ist ein äusserst beliebtes und leistungsstarkes statisches Code-Analysetool für JavaScript- und TypeScript-Projekte.

### ESLinkt installieren
Bevor ESLint verwendet werden kann, muss es installiert werden (und bei Windows am besten noch den PC neustarten).
Mit den folgenden drei Befehlen kann man es installere:

```shell
npm install eslint --save-dev
npx eslint --init
npx eslint src/index.js
```

#### ESLint konfigurieren
Man kann eigene Regeln erstellen oder bereits vorhandene Regeln anpassen, um den Anforderungen des Projekts gerecht zu werden.
Die Konfiguration erfolgt über eine `.eslintrc`-Datei, in der man die Regeln, Erweiterungen und spezifischen Projekteinstellungen festlegen kann.

Hier einige Beispiele wie man dies tun kann:

**Anpassen bestehender Regel**:

In der `.eslintrc`-Datei kann man die Einstellungen für eine spezifische Regel ändern. Wenn die maximale Zeilenlänge auf 100 Zeichen beschränkt werden soll, wird dies wie folgt eingerichtet.
```json
{
  "rules": {
    "max-len": ["error", { "code": 100 }]
  }
}
```

**Hinzufügen neuer Regel**:

Man kann Regeln hinzufügen oder entfernen, indem man die `rules`-Eigenschaft anpassen. Angenommen, man möchten die Regel "no-console" aktivieren, um den Einsatz von console.log zu verhindern.
```json
{
  "rules": {
    "no-console": "error"
  }
}
```

Weitere Informationen findest du in der ESLint-Dokumentation unter https://eslint.org/docs/user-guide/configuring.

#### ESLint ausführen
ESLint kann man über die Konsole ausführen dazu sind folgende Schritte erforderlich:

1. In der Konsole zum Wurzelverzeichnis des Projekts navigieren.
2. Den Befehl `eslint` gefolgt von den Datei- oder Verzeichnisnamen ausführen, die man überprüfen möchten.
```shell
eslint src/index.js
```
3. ESLint überprüft nun die angegebenen Dateien oder Verzeichnisse anhand der definierten Regeln und gibt mögliche Fehler oder Warnungen in der Konsole aus.

ESLint kann man mit zusätzlichen Optionen und Flags verwenden, die wichtigste Flag ist  `--fix`. Man kann sie verwenden, um automatische Code-Fixes für bestimmte Probleme durchzuführen.
```shell
eslint --fix src/index.js
```

Vielfach ist ESLint bereits als Script im `packages.json` hinterlegt und kann dann so mit dem Befehl `npm run <scriptname>` (beispielsweise `npm run lint`) aufgerufen werden.

#### ESLint automatisch beim Speichern
**In VS-Code**:

Man öffnet die VS Code-Einstellungen, indem man "Datei" (File) in der Menüleiste wählt und dann "Einstellungen" (Preferences) auswählt. Oder man verwendet den Shortcut "[Ctrl] + [,]" für Windows/Linux oder "[Cmd] + [,]" für macOS.

Man sucht nach `Save Actions` in den Einstellungen und wählt "In settings.json bearbeiten" (Edit in settings.json).

In der `settings.json`-Datei fügt man den folgenden Code hinzu:
```json
"editor.formatOnSave": true,
"editor.defaultFormatter": "esbenp.prettier-vscode", 
"editor.codeActionsOnSave": {
  "source.fixAll.eslint": true
}
```

* `"editor.formatOnSave": true`: Diese Einstellung bewirkt, dass der Code automatisch entsprechend den in den Editor-Einstellungen konfigurierten Regeln formatiert wird, wenn das Dokument gespeichert wird.

* `"editor.defaultFormatter": "esbenp.prettier-vscode"`: Diese Einstellung gibt den Standard-Codeformatter an, der verwendet wird, wenn `"editor.formatOnSave"` aktiviert ist. In diesem Fall wird Prettier verwendet. 

* `"editor.codeActionsOnSave": { "source.fixAll.eslint": true }` : Diese Einstellung aktiviert Code-Aktionen beim Speichern des Dokuments. Konkret wird hier die ESLint-Erweiterung verwendet. Durch das Aktivieren von `"source.fixAll.eslint": true` werden automatisch Vorschläge zur Fehlerbehebung und Verbesserung des Codes angezeigt, wenn das Dokument gespeichert wird.

Nun noch die Datei speichern und VS-Code wird automatisch den Code formatieren und Lint-Fixes anwenden.


**In IntelliJ**:

Man öffnet die IntelliJ-Einstellungen, indem man den Shortcut "Strg + Alt + S" für Windows/Linux oder "Cmd + ," für macOS verwendet.

Man navigiert zu `Languages & Frameworks` -> `[Code-Language z.B. JavaScript]` -> `Code Quality Tools` -> `ESLint` nun wählt man die `Automatic ESLint configuration` und `Run eslint --fix on save` Option an.

## Überprüfen
Nun hoffen wir, dass alle nötigen Installationen erfolgreich ausgeführt wurden.

![task5](/images/task.png) 5' - Einzelarbeit

    - Öffne deine IDE
    - Öffne in deiner IDE ein neues Terminal
    - git --version
    - npm -v

Sofern alle Versionen angezeigt werden, war die Installation erfolgreich. Anderweitig solltest du einen Coach konsultieren.