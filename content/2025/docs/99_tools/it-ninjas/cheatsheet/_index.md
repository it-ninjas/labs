---
title: "Cheatsheet"
linkTitle: "Cheatsheet"
weight: 1
description: >
  Auf dieser Seite zeigen wir den Aufbau einer Modulseite innerhalb it-ninjas.
---

{{< module J1 >}}

## Ziele

- Es soll für jedes Modul klar sein, was das Ziel ist (Im Abschnitt **Ziele**, also hier).
- Wir geben eine grobe Schätzung, wie lange das lesen dauert (Shortcode `time` nach den Zielen).
-

{{< zeit lesen="10">}}

---

## Erster Titel

In diesem Abschnitt zeigen wir die verschiedenen ninja boxen:

{{< ninja info>}}
Das ist eine Information.
{{< /ninja>}}

{{< ninja tip>}}
Das ist ein Tip.
{{< /ninja>}}

{{< ninja warning>}}
Das ist eine Warnung, hier besonders aufpassen.
{{< /ninja>}}

{{< todo >}}
Hier fehlt noch was...
{{< / todo>}}

Um ein Video einzubinden:
{{< video "./" "Zusätzliche Info">}}

---

## Zweiter Titel

In diesem Abschnitt zeigen wir weitere Shortcodes, welche die Darstellung vereinheitlichen:

Um Code einzubinden:
{{< code >}}
code für Windows oder Linux (default)
// windows
code für Windows
// linux
code für Linux
// all
nochmals code für Windows oder Linux
//windows
auch code für Windows
//linux
auch code für Linux
{{< /code >}}

Um einen Link für eine Aufgabe einzubinden:
{{<aufgabe "./">}}

Um einen Link für mehrere Aufgaben einzubinden:
{{<aufgaben "./">}}

Falls Du einen Link zu einem Lab machen willst:
{{< lablink "./" "Text vom Link">}}

Oder so (Pfad in VS Code überprüfbar):
{{< lablink "[Text vom Link](./)">}}

Oder in Richtung Html Link:
{{< lablinkml "./">}}Anderer Text vom Link{{< /lablinkml>}}

Um in einem Lab einen Link zurück in die Dokumentation zu machen:
{{< dokumentation "./" >}}

Mit Zusätzlicher Info
{{< dokumentation "./" "Dieses Cheatsheet" >}}

{{< linux >}}
Das wird nur angezeigt, wenn in der Konfiguration Linux eingestellt ist.
{{< /linux >}}

{{< windows >}}
Das wird nur angezeigt, wenn in der Konfiguration Wind eingestellt ist.
{{< /windows >}}

Wenn was in einem `pom.xml` geändert werden muss:
{{< pom >}}

```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>
```

{{< /pom >}}

## Dritter Titel

Spezielle Informationen für SBB, Puzzle,...:
{{< sbb >}}
Das wird nur angezeigt, wenn als Ausbildungsort 'SBB' ausgewählt wurde.
{{< /sbb >}}

Weitere folgen...

## Vierter Titel

In diesem Abschnitt sind Shortcodes, welche man nicht mehr verwenden sollte.

{{< SBBOnly >}}
Das ist deprecated! Besser Shortcode `sbb` verwenden...
{{< /SBBOnly >}}
