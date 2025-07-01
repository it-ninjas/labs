---
title: "Geheimnisse schützen"
linkTitle: "Geheimnisse schützen"
weight: 5
description: >
  Warum Passwörter und API-Keys nicht in den Code gehören – und wie du sie schützt.
---

## Ziele

- Du verstehst, was API-Schlüssel und Passwörter im Code bedeuten.
- Du erkennst die Risiken bei falscher Handhabung.
- Du lernst, wie man sensible Daten sicher speichert.
- Du kennst die gängigen Formate und Methoden zur Trennung von Code und Konfiguration.

{{< zeit lesen="5" >}}

---

## Warum überhaupt schützen?

Viele moderne Anwendungen greifen auf externe Dienste zu – z. B. Google, OpenAI oder Wetterdaten-Anbieter.  
Damit diese Dienste erkennen, wer du bist, brauchst du:

- **Passwörter**: zum Schutz persönlicher Konten oder Serverzugänge.
- **API-Keys** (Application Programming Interface Keys): Zugangsschlüssel, die automatisch mitgeschickt werden, wenn dein Programm eine API verwendet.

Ein API-Key ist wie ein **digitaler Ausweis** für deine Software. Er identifiziert deine Anwendung gegenüber dem Dienst – und ist oft mit **Zugriffsrechten, Kosten oder Nutzungslimits** verbunden.

{{< ninja warning >}}
Wer deinen API-Key oder dein Passwort kennt, kann auf Dienste in deinem Namen zugreifen – im schlimmsten Fall auf deine Kosten.
{{< /ninja >}}

---

## Gute Praxis: Trennung von Code und Konfiguration

Sensibler Inhalt wie API-Schlüssel, Passwörter oder geheime Tokens gehört **nicht** in den Quellcode.  
Stattdessen verwendest du Umgebungsvariablen oder `.env`-Dateien – sie sind lokal, einfach zu nutzen und sicher (wenn man sie nicht aus Versehen committed).

Die konkrete Umsetzung hängt davon ab, ob du mit Java, Node.js, Python oder einer anderen Sprache arbeitest.

---

Wähle nun die passende Anleitung:
