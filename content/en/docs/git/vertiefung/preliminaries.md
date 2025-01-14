---
title: "Voraussetzungen"
linkTitle: "Voraussetzungen"
weight: 2
---

Das Modul soll den Einsatz von Git/Bitbucket unter realen Bedingungen vermitteln. Dazu ist es erforderlich,
dass ihr als Team agiert. Mehrere IT-Ninjas, die das Modul #S1 - Git erfolgreich abgeschlossen haben, bilden ein
Team, welches gemeinsam an zwei unterschiedlichen Projekten arbeitet. Hierbei geht es weniger um die
Programmierung, sondern um die gemeinsame Arbeit an der gleichen Codebase und den daraus folgenden Herausforderungen
in der Zusammenarbeit und in der Arbeit mit den Versionierungstools.

## Ziele

- Ihr wisst, wer zu eurem Team gehört und wie die Aufgaben verteilt sind.
- Ihr habt alle den Zugriff auf dieselben Repositories mit der initialen Version des Beispielprojektes.
- Die Branches `master` und `develop` sind angelegt.
- Alle Teammitglieder haben die Repositories ausgecheckt.

## Aufgaben

In einem ersten Schritt solltet ihr die Voraussetzungen für dieses Modul schaffen. Dazu müsst ihr

- ein Team bilden, das aus minimal zwei, maximal fünf IT-Ninjas besteht, die das Modul Git erfolgreich abgeschlossen haben.
- die folgenden Aufgaben als Team ausführen.
- ein Szenario aufbauen, welches den Wechsel zwischen Branches und Projekten unterstützt und eine praxisnahe Zusammenarbeit ermöglicht.

![Bild eines Teams das an zwei Projekten arbeitet](../preliminaries/team.png)

Für die Umsetzung könnt ihr die Git Befehle über die Kommandozeile eingeben oder die Funktionen in
IntelliJ und der Bitbucket Weboberfläche nutzen. Die folgenden Screenshots sollen euch dabei helfen,
die Funktionen in den Tools schneller zu finden.

### Fork eines Repositories erstellen (Bitbucket)

**Achtung:** Diese Aktion muss nur von einem Team-Mitglied ausgeführt werden!

**Hinweis:**<br>
Die Bilder zeigen ein Beispielprojekt, welches nicht zur Verfügung steht. Als Projekte für diese Aufgabe
können die bereits abgeschlossenen Labs oder Exams der Module #J2 und #J3 verwendet werden.

Für die Arbeit im Team sollten neue Repositories angelegt werden, damit die Arbeit aus den abgeschlossenen
Modulen erhalten bleibt. Dazu kann der Fork Befehl genutzt werden. Entweder über die Git Kommandozeile oder - bequemer -
über die Bitbucket Weboberfläche:

![Bitbucket Weboberfläche (Fork)](../preliminaries/bitbucket_fork.png)

Wenn du die Kopien der Repositories erfolgreich angelegt hast, musst du diese noch für die anderen
Team-Mitglieder freigeben.

### Klonen von Repositories in IntelliJ

Jeder Ninja erstellt einen Klon der Repositories in seinem lokalen Arbeitsbereich:

1. Bitbucket im Browser aufrufen und zum gewünschten Repository wechseln. Dann Klonen in der Seitenleiste auswählen und die URL kopieren.
2. Git im Menu auswählen (ggf. zuerst auf das Hamburger-Menu klicken).
3. Im Git-Submenu den Eintrag Clone... auswählen.
4. Im oberen Feld wird die aus Bitbucket kopierte URL eingefügt. Im unteren Feld ist das lokale Zielverzeichnis (muss leer sein!) auszuwählen.

![Bitbucket Weboberfläche (Klonen)](../preliminaries/bitbucket.png)

![IntelliJ Menueintrag Git](../preliminaries/intellij_git.png)

![IntelliJ Git Clone](../preliminaries/intellij_clone.png)

![Clone Dialog](../preliminaries/intellij_clonedialog.png)

#### Hier geht es zu den Labs.

- [Teambildung](../../../labs/git/vertiefung/01_team)
- [Vorbereitung](../../../labs/git/vertiefung/02_preparing)
