---
title: "Mit mehreren Repositories arbeiten"
linkTitle: "Mit mehreren Repositories arbeiten"
weight: 4
---

## Voraussetzungen
Die Vorbereitungen aus [Aufgabe 1](../../../labs/git/vertiefung/01_team) sind umgesetzt. Insbesondere sind erledigt:

- zwei neue Repositories mit vorhandenen Projekten wurden erstellt
- es sind jeweils die Branches `master` und `develop` vorhanden
- alle Teammember haben diese Repositories geklont

## Simulieren einer realen Projektarbeit

Ein realistisches Szenario beinhaltet die konkurrierende Arbeit mehrerer Team-Mitglieder auf demselben
Repository, die Arbeit mit mehreren Projekten und die Notwendigkeit schnell zwischen den Projekten und
einzelnen Versionsständen wechseln zu können.

Im zweiten Abschnitt wird die parallele Arbeit mit mehreren Projekten bzw. Repositories simuliert.
Hier sollen die Kenntnisse zu den nachfolgenden Git Befehlen aufgefrischt werden.

- **branch**
- **checkout**
- **stash**
- **pull**
- **push**

In den Labs zu diesem Modul werden die Git-Aktionen hauptsächlich innerhalb von IntelliJ oder über
die Weboberfläche von Bitbucket ausgeführt, da dies das in den Projekten übliche Vorgehen ist.

## Arbeit mit mehreren Repositories

In diesem Abschnitt werdet ihr mit den gleichen Menueinträgen arbeiten, wie im vorigen. Wenn ihr nicht
sicher seid, welche das sind, schaut einfach noch einmal auf der vorigen Seite nach.

Nach Abschluss der Aufgaben solltet ihr in der Lage sein, zwischen unterschiedlichen Projekten und zwischen
verschiedenen Versionsständen eines Projektes zu wechseln ohne, dass eure lokalen Änderungen verloren gehen.

Wir werden in diesem Abschnitt mit beiden Projekten arbeiten, wobei auf nur dem zweiten Projekt
geändert wird. In einer ersten Aufgabe wird die parallele Arbeit an mehreren Projekten demonstriert.
Dabei werden die beiden möglichen Arbeitsweisen vorgestellt.

Die zweite Aufgabe thematisiert den Wechsel zwischen Branches oder Commits des gleichen Projekts.
Kleinere Änderungen werden auf mehrere Commits verteilt. Anschliessend wird zwischen diesen Commits
gewechselt, korrigiert, erneut committed oder mit stash zwischengespeichert.

Nach den Übungen könnt ihr zwischen Projekten oder zwischen verschiedenen Branches desselben Projekts
wechseln, wisst, wann stash eingesetzt wird und seid mit checkout, rebase, push und pull vertraut.

Zu den Labs:
- [Simultanes Arbeiten an mehreren Projekten](../../../labs/git/vertiefung/05_project-switch)
- [Wechseln zwischen Branches desselben Projekts](../../../labs/git/vertiefung/06_branch-switch)
