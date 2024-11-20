---
title: "Zusammenarbeit im Projekt"
linkTitle: "Zusammenarbeit im Projekt"
weight: 3
---

## Voraussetzungen
Die Vorbereitungen aus [Aufgabe 1](../../../labs/git/vertiefung/01_team) sind umgesetzt. Insbesondere sind erledigt:

- Zwei neue Repositories mit vorhandenen Projekten wurden erstellt.
- Es sind jeweils die Branches `master` und `develop` vorhanden.
- Alle Team-Mitglieder haben diese Repositories geklont.

## Simulieren einer realen Projektarbeit

Ein realistisches Szenario beinhaltet die konkurrierende Arbeit mehrerer Team-Mitglieder auf demselben
Repository, die Arbeit mit mehreren Projekten und die Notwendigkeit schnell zwischen den Projekten und
einzelnen Versionsständen wechseln zu können.

Im ersten Abschnitt wird die Zusammenarbeit an einem Projekt simuliert, um die Kenntnisse zum Anlegen,
Aktualisieren,Vergleichen und  Mergen von Branches aufzufrischen. Hierzu werden die Git Befehle

- **branch**,
- **checkout**,
- **push**,
- **diff**,
- **branch -merged**,
- **merge**,
- **rebase**

verwendet/wiederholt. In den Labs zu diesem Modul werden die Git-Aktionen hauptsächlich innerhalb
von IntelliJ oder über die Weboberfläche von Bitbucket ausgeführt, da dies das in den Projekten
übliche Vorgehen ist.

### Bitbucket
#### Hauptansicht
Die Standardanzeige von Bitbucket ist die Auflistung der vorhandenen Branches. Wichtige Elemente auf
der Bitbucket Weboberfläche, die in diesem Modul benutzt werden, sind durch rote Markierungen hervorgehoben.

![Bitbucket Mainview](../images/bitbucket-main.jpg)

Ein Pull Request kann durch einen Klick auf den Branch in der Branch-Übersicht oder auf der
Übersichtsseite der Pull Requests über den Button `Pull-Anfrage erstellen` (oben rechts) erstellt werden.
(*siehe nächstes Bild*)

#### Pull Request
**Übersicht aller Pull Requests.** Hier werden alle im Repository erstellt Pull Requests aufgelistet.
Dabei kann ausgewählt werden, ob nur die offenen Pull Requests (*Standardeinstellung*), die zusammengeführten,
abgelehnten oder alle Pull Requests angezeigt werden sollen.

![Bitbucket Pull Requests](../images/bitbucket-pr-overview.jpg)

Wird ein neuer Pull Request erstellt, sind Ausgangs- und Zielbranch bereits vorbelegt. Beide können
geändert oder auch die Richtung der Zusammenführung umgekehrt werden.
Bei der Erstellung eines neuen Pull Request ist besonders darauf zu achten, dass der richtige Zielbranch
(rote Markierung) ausgewählt ist. Für die Übungen in diesem Modul wird das immer `develop` sein.

![Bitbucket Pull Request erstellen](../images/bitbucket-create-pr.jpg)

Will man einen Pull Request überprüfen, so gibt es verschiedene Informationen und Aktionen, die dabei
helfen können.
1. Fügt den aktuellen User als Prüfer hinzu.
2. Zeigt die Aktionen an die erforderlich sind, bevor der Pull Request gemergt werden kann. Dazu gehören neben den erforderlichen Freigaben durch den/die Prüfer, auch erfoderliche Builds und eventuell zu lösende Konflikte.
3. Startet die Überprüfung (nur nötig, wenn eine Protokollierung gefordert ist).

Ausserdem werden die Kommentare des Erstellers und anderer Prüfer in der *Übersicht* angezeigt. *Diff*
führt die Unterschiede zwischen Ausgangs- und Zielbranch auf. Dabei werden entfernte Zeilen rot und
hinzugefügte Zeilen grün hinterlegt. Jede Änderung an einer Zeile, und sei es auch nur ein einzelnes
Zeichen, wird immer als Entfernen der alten Zeile und Einfügen der neuen Zeile dargestellt.
Alle zu diesem Pull Request gehörenden *Commits* und auch alle *Builds* können einzeln angeschaut werden.

![Bitbucket Pull Request prüfen](../images/bitbucket-approve-pr.jpg)

### IDEA IntelliJ
Einige der Git-Befehle werden auch in IntelliJ ausgeführt. Die in den Labs verwendeten Menueinträge
sind farbig markiert.

![IDEA IntelliJ Git Menu](../images/intellij-git-menu.jpg)

Will man die Änderungen vom Arbeitsbereich in das Repository übertragen, wird `git commit` verwendet.
In IntelliJ kann dazu der Menu-Eintrag *Commit...* oder auch *Push* aus dem Kontextmenu des Projekts
aufgerufen werden. Die Ansicht wechselt nun auf die Commit-View:

![IDEA IntelliJ Commit View](../images/intellij-commit.jpg)

1. Anzeige der geänderten Dateien; hier können einzelne oder alle Dateien ausgewählt werden, die bei Ausführung von commit im Repository aktualisiert werden.
2. Die Commit-Message ist erforderlich und beschreibt die übertragenen Änderungen in Kurzfassung.
3. Mit dem Button `Commit` werden die Änderungen in das lokale Repository übernommen, mit `Commit and Push..` werden sie anschliessend auch auf das remote Repository übertragen, wo sie dann allen zugänglich sind.

### Collaboration
In der Praxis ist es üblich, dass in grossen Projekten mehrere Entwickler an der gleichen Codebasis
arbeiten, aber für unterschiedliche fachliche Features zuständig sind. Diese Änderungen müssen regelmässig
zusammengeführt werden, damit alle Entwickler auf dem aktuellen Stand arbeiten können. Dabei kommt es
immer wieder auch vor, dass Änderungen an einer Klasse in unterschiedlichen Branches zusammen geführt
werden müssen. Im Regelfall erledigt Git diese Zusammenführung (*merge*) automatisch. Wenn jedoch Konflikte
auftreten, d.h. eine Zeile in beiden Branches, die zusammengeführt werden sollen, geändert wurde, kann
Git nicht entscheiden, welches die "richtige" Version ist. Hier muss der Entwickler entscheiden.

Dieses Szenario kann leicht nachgestellt werden, indem mehrere Team-Mitglieder einen Feature-Branch
von develop erstellen und auf diesem arbeiten.

In einer ersten Aufgabe sollen kleine Änderungen ohne Merge-Konflikte vorgenommen und zusammegeführt
werden. Dazu werden in den Feature-Branches unterschiediche Dateien bzw. Codestellen bearbeitet und
anschliessend auf `develop` zusammengeführt.

Der zweite Teil stellt Merge-Konflikte und deren Auflösung durch den Entwickler nach. Hier sollen
jeweils mehrere kleine Änderungen am Code vorgenommen werden. Dabei wird mindestens eine Zeile einer
bestimmten Datei von allen beteiligten Entwicklern geändert. Die Änderungen werden auf den Feature-Branch
gepusht und dann nacheinander auf `develop` zusammengeführt. Jetzt sollte es zu merge-Konflikten kommen,
die es zu lösen gilt.

Die passenden Aufgaben sind in den Labs unter
- [Vorbereiten der IDE](../../../labs/git/vertiefung/02_preparing)
- [Gemeinsames Arbeiten an einem Projekt (ohne Konflikte)](../../../labs/git/vertiefung/03_collaboration)
- und [Gemeinsames Arbeitane an einem Projekt (mit Merge-Konflikten)](../../../labs/git/vertiefung/04_merge-conflict)

zu finden.
