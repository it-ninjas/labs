---
title: "Git Workflow im Ausbildungsprogramm"
linkTitle: "Git Workflow im Ausbildungsprogramm"
weight: 2
description: >
  Richtlinien, um einen effizienten und reibungslosen Review-Prozess sicherzustellen.
---

## Grundstruktur

Ziel: Eine saubere, stabile und nachvollziehbare Git-Umgebung für Labs und Exams.

- Der `main`-Branch bleibt jederzeit stabil und sauber.
- Es wird **niemals direkt auf main gepusht**.
- Für das Entwickeln von den Labs/Exams wird vom `main` ein `dev`-Branch erstellt.
- Für jedes Lab/Exam wird vom `main` ein eigener `review`-Branch erstellt.
- Sobald ein Lab/Exam abgeschlossen ist, wird der entsprechende `dev`-Branch in den `review`-Branch gemergt.
- Der `review`-Branch stellt den Stand für den offiziellen Review-Prozess dar.

### Hinweis

- Dev-Branches gehören zur persönlichen Arbeit
- Review-Branches sind “eingefrorene” Stände für PBs
  ![](images/workflow.png)

---

## Naming und Prefixes

Zweck: Klare Identifikation, einheitliche Struktur.

Jeder Branch erhält einen Prefix, z. B.:

- `dev/xyz`
- `fix/xyz`
- `review/xyz`

**Prefixes erleichtern:**

- Sofortiges Erkennen der Branch-Art
- Ordnung und Struktur im Repository
- Automatisierte Workflows (z. B. CI/CD)
- Saubere, nachvollziehbare Review-Prozesse

**Naming-Conventions:**

- Kleinschreibung
- Bindestriche statt Leerzeichen
- Name beschreibt klar den Inhalt
  - z. B. `dev/sort-algorithm-task5` statt `dev/newbranch`

**Aufgaben-übergreifende Branches:**

- z. B. `dev/java-grundlagen-exams`

---

## Verbesserungen / Feedback auf Review korrekt implementieren

Ziel: Klare Nachvollziehbarkeit aller Review-Anpassungen.

- Jede zu machende Verbesserung aus dem Review wird in einen eigenen Task überführt.
- Was das für Tasks werden, wird im Review besprochen.
- Sobald eine Verbesserung umgesetzt wurde, wird der Task abgehakt.
- Nach Abschluss aller Tasks gibst du Bescheid.
- PBs überprüfen die Verbesserungen und resolven die Tasks, sobald sie zufrieden sind.
- Die Verbesserungen erfolgen auf einem `fix`-Branch, der auf dem `review`-Branch basiert.

---

## Regeln

- Keine direkten Commits auf `main`.
- Keine direkten Commits auf `review`.
- Für Labs/Exams erstellt ihr den Pull Request.

### Reviewer

- Lab: mindestens **1 PB**
- Exam: mindestens **2 PB**

### Sobald der PR eröffnet ist:

- Keine neuen Änderungen mehr auf den `review`-Branch pushen.
- Weitere Arbeit darf auf neuen `dev`- oder `fix`-Branches stattfinden.
- Gemergt wird erst nach abgeschlossenem Review.

### Ein Lab/Exam gilt als abgeschlossen, wenn:

- Der PR von den PBs approved wurde.
- Der `review`-Branch in `main` gemergt wurde.
- Nur die PBs dürfen auf `main` mergen.

### Aufräumen

- Branches, die nach Merge nicht mehr gebraucht werden, sollen gelöscht werden.

---

## Best Practices

- Commits klein und thematisch sauber halten.
- PR-Beschreibung ausfüllen: Was wurde gemacht? Was muss beachtet werden?
- Branches nicht zu lange offen halten → hohes Konfliktpotenzial.
- Beim Arbeiten an mehreren Tasks: separate `fix`-Branches statt “alles in einen Branch mischen”.
