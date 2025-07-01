---
title: "Secrets im Node.js Projekt"
linkTitle: "Secrets Node.js"
weight: 7
description: >
  Zugriff auf API-Schlüssel in einem TypeScript-Projekt mit dotenv
---

## Ziele

- Du lernst, wie man `.env`-Dateien mit `dotenv` in Node.js verwendet.
- Du schützt deine Zugangsdaten vor versehentlicher Veröffentlichung.
- Du testest den Zugriff auf Variablen im TypeScript-Code.

{{< zeit lesen="10" >}}

---

## Geheimnisse in einem Typescript-Projekt schützen

Die nachfolgende Anleitung soll dir helfen, Geheimnisse zu schützen, welche dein Projekt benötigt (z.B. Passwort für
Datenbank-Zugriff).

### Schritt 1: `.env`-Datei erstellen

```env
GOOGLE_API_KEY=dein_api_key
```

In `.gitignore` eintragen:

```
.env
```

---

### Schritt 2: dotenv installieren

```bash
npm install dotenv
```

---

### Schritt 3: Zugriff im Code

```ts
import * as dotenv from "dotenv";
dotenv.config();

const apiKey = process.env.GOOGLE_API_KEY;
if (!apiKey) {
  throw new Error(
    "API key not set. Please check your .env file or environment variables.",
  );
}
```

---

### Schritt 4: `.env.template` bereitstellen

```env
# This file contains the required environment variables! To use it, rename it to '.env'.
# Never commit your real .env file with secrets!

GOOGLE_API_KEY=PLACEHOLDER
```

---

### Hinweise zu CI/CD

In GitHub Actions kannst du die Werte in den Secrets speichern:

```yaml
env:
  GOOGLE_API_KEY: ${{ secrets.GOOGLE_API_KEY }}
```

In GitLab CI via Settings → CI/CD → Variables eintragen.

---

### Empfehlung

Verwende `dotenv` in Kombination mit einem `.env.template`, um deinen Code sicher und teamfähig zu gestalten.
