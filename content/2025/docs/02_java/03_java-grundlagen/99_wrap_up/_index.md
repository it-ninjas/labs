---
title: "Module abschliessen"
linkTitle: "Module abschliessen"
weight: 99
description: >
  Du hast das Modul Java Grundlagen abgeschlossen. Folgendes musst du noch erledigen, bevor du mit dem Examen beginnen kannst.
---

## Ziele

- Ich bin bereit für das Examen

{{< zeit lesen="10" >}}

---

### 1. Repository aufräumen

#### Master/Main Branch erstellen

Parallel zum Modul Java Grundlagen hast du auch schon erste Erfahrungen mit [Git](../../../04_git/01_grundwissen/) gesammelt und viele Branches angelegt.  
Durch deinen Praxisbildner oder das Selbststudium weisst du nun auch, was ein Main- oder Master-Branch ist.

Führe nun alle deine Branches in den Master/Main Branch zusammen und lösche die übrigen Branches. Falls du Probleme beim Mergen hast, frag die anderen Auszubildenden oder einen Praxisbildner um Hilfe.

#### Unnötige Dateien aus dem Repository entfernen

Zu Beginn haben wir einfach alle Dateien ins Repository committed. Einige davon gehören jedoch nicht in ein Repository:

- lokale Konfigurationsdateien von IntelliJ
- Build-Output
- temporär erstellte Dateien

Das Aufräumen erfolgt in folgenden Schritten:

1. Erstelle einen neuen Branch (wie immer, wenn du eine Änderung machen willst). Du kannst ihn `cleanup` nennen.
2. Erstelle ein [.gitignore](../../../99_tools/ide/intellij/04_git/#gitignore-anpassen) für IntelliJ.
3. Committe die `.gitignore`-Datei.
4. Lösche in den einzelnen Projekten die nicht notwendigen Dateien und Verzeichnisse, falls vorhanden:
   - im `.idea`-Verzeichnis alles ausser dem Unterverzeichnis `runConfigurations`
   - das `target`-Verzeichnis
   - die Datei `.itninja.hugo.json`
   - ZIP-Dateien (ausser wenn in einer Übung benötigt)
   - vorhandene `*.iml`-Dateien
5. Committe deine Änderungen.
6. Push auf `origin` und erstelle einen Pull-/Merge-Request.
7. Lass den Request von einem anderen Auszubildenden prüfen und mergen.

### 2. Praxisbildner zu einem Fachgespräch einladen

Nutze diesen Moment, um dich mit deinem Praxisbildner über das Gelernte auszutauschen. Vielleicht erhältst du noch den einen oder anderen Hinweis oder Tipp.

Sende einem deiner Praxisbildner eine Terminanfrage für 1 Stunde. Die Einladung muss einen Link zu deinem Repository enthalten.  
Stelle sicher, dass der Praxisbildner Lese- und Schreibrechte auf das Repository hat.

{{< ninja warning >}}
Der Praxisbildner benötigt vor dem Fachgespräch Zeit, um sich das Repository anzuschauen. Plane deshalb mindestens 1–2 Arbeitstage zwischen dem Versenden deiner Einladung und dem Termin ein.
{{< /ninja >}}

{{< ninja tip >}}
Nutze die Zeit bis zum Fachgespräch und gehe die Java Grundlagen nochmals durch. Das Fachgespräch bietet dir die Möglichkeit, offene Fragen zu klären und deinem Praxisbildner dein Wissen zu zeigen.
{{< /ninja >}}
