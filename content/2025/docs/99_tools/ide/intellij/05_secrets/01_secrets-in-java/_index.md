---
title: "Secrets im Java-Projekt"
linkTitle: "Secrets Java"
weight: 1
description: >
  Zugriff auf API-Keys im Java-Code – mit `.env` und der Bibliothek `dotenv-java`
---

## Ziele

- Du lernst, wie man `.env`-Dateien verwendet.
- Du verwendest `dotenv-java` für einfache Integration in Java-Projekte.
- Du stellst sicher, dass deine API-Keys nicht im Code landen.

{{< zeit lesen="10" >}}

---

## Geheimnisse in einem Java-Projekt schützen

Die nachfolgende Anleitung soll dir helfen, Geheimnisse zu schützen, welche dein Projekt benötigt (z.B. Passwort für
Datenbank-Zugriff).

### Schritt 1: `.env`-Datei erstellen

Im Projektverzeichnis (z. B. `labs/`) eine Datei `.env` mit folgendem Inhalt anlegen:

```env
GOOGLE_API_KEY=dein_api_key
```

Diese Datei **enthält vertrauliche Informationen** und darf nicht ins Git-Repository eingecheckt werden.

Trage sie deshalb in `.gitignore` ein:

```
.env
```

{{< ninja warning >}}
Vergewissere dich, dass die `.env`-Datei nicht ins Git-Repository gelangt – **bevor** du deine Geheimnisse einträgst!
{{< /ninja >}}

---

### Schritt 2: Maven-Dependency hinzufügen

{{< pom >}}

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>
```

{{< /pom >}}

---

### Schritt 3: Zugriff im Java-Code

```java
import io.github.cdimascio.dotenv.Dotenv;
import java.util.MissingResourceException;

Dotenv dotenv = Dotenv.configure()
    .ignoreIfMissing()
    .load();

String apiKey = dotenv.get("GOOGLE_API_KEY");
if (apiKey == null) {
    throw new MissingResourceException(
        "API key not set. Please check your .env file or environment variables.",
        "GOOGLE_API_KEY",
        null
    );
}
```

`dotenv-java` prüft zuerst `System.getenv(...)`, dann `.env` – ideal für lokale Entwicklung, Testing und Verteilung.

{{< ninja info >}}
Wie die `.env`-Datei beim Deployment erstellt und verteilt wird, gehört zum Thema **Configuration Management** – das behandeln wir hier nicht weiter.
{{< /ninja >}}

---

### Schritt 4: Vorlage für andere bereitstellen

Lege eine `.env.template` oder `.env.example` mit folgendem Inhalt ins Repository:

```env
# This file contains the required environment variables! To use it, rename it to '.env'.
# Always make sure that the '.env' file containing sensitive information is never committed to a Git repository!

GOOGLE_API_KEY=HIER_EINTRAGEN
```

Diese Datei darf eingecheckt werden – sie enthält **keine** echten Schlüssel, sondern dient als Vorlage.

---

## Vorteile von `dotenv-java`

| Vorteil              | Beschreibung                                              |
| -------------------- | --------------------------------------------------------- |
| IDE-unabhängig       | Funktioniert mit IntelliJ, VS Code, CLI, Docker usw.      |
| Deployment-tauglich  | `.env` wird zur Laufzeit geladen – kein Startskript nötig |
| Testing-freundlich   | Ideal für Integrationstests mit Umgebungsvariablen        |
| Einfach integrierbar | Nur eine kleine, leichtgewichtige Dependency              |
| Zukunftssicher       | Standardlösung für reale Java-Projekte                    |

{{< ninja info >}}
Natürlich ist `dotenv-java` nicht die einzige Möglichkeit, um Konfiguration und Code voneinander zu trennen. In anderen
Projekten wirst du vielleicht auf alternative Lösungen stossen.

Wichtig ist dabei immer:  
Geheimnisse wie API-Schlüssel und Passwörter dürfen **niemals** im Quellcode oder in öffentlich zugänglichen Repositories gespeichert werden.
{{< /ninja >}}

{{< ninja info >}}
In CI/CD-Umgebungen (z. B. GitHub Actions, GitLab CI) ist die Verwendung einer `.env`-Datei nur im Rahmen von **Tests oder lokalen Simulationen** sinnvoll. Beim eigentlichen Build-Prozess hat sie **keine Wirkung**, da dort keine `.env` geladen wird – es sei denn, du startest deine Anwendung oder Tests explizit.

Für produktive CI/CD-Prozesse solltest du die benötigten Werte als echte **Umgebungsvariablen** im jeweiligen CI-System hinterlegen.
{{< /ninja >}}

---

## Optional: Einstieg mit IntelliJ Plugin „Env File“

Wenn du keine zusätzliche Bibliothek verwenden willst und nur lokal mit IntelliJ arbeitest, kannst du das Plugin **Env File** nutzen.

### Installation

1. IntelliJ IDEA öffnen → `Settings` → `Plugins`
2. Nach **Env File** (von _Aeris_) suchen und installieren
3. IntelliJ neu starten

### Run-Konfiguration anpassen

1. Run-Konfiguration öffnen (`Edit Configurations…`)
2. Abschnitt **EnvFile** aktivieren: ✅ „Enable EnvFile“
3. Mit ➕ deine `.env`-Datei hinzufügen

### Zugriff im Code

```java
import java.util.MissingResourceException;

String apiKey = System.getenv("GOOGLE_API_KEY");

if (apiKey == null) {
    throw new MissingResourceException(
        "API key not set. Please check your .env file or environment variables.",
        "GOOGLE_API_KEY",
        null
    );
}
```

{{< ninja info >}}
Das Plugin funktioniert **nur in IntelliJ** und ist **nicht geeignet für Deployment oder CI/CD**.  
Verwende es nur zum Einstieg oder für Tests – produktiv empfehlen wir `dotenv-java`.
{{< /ninja >}}

---

## Empfehlung für it-ninjas-Projekte

| Szenario                         | Empfehlung                 |
| -------------------------------- | -------------------------- |
| Lokale Entwicklung (kurzfristig) | `.env` + Plugin (optional) |
| Verteilung, Produktivbetrieb     | `.env` mit `dotenv-java`   |

Verwende `dotenv-java`, wenn dein Projekt wachsen oder weitergegeben werden soll.  
So stellst du sicher, dass deine Zugangsdaten **nicht im Code landen** – und dein Projekt **überall funktioniert**.
