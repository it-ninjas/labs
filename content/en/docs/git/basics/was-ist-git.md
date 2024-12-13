---
title: "Was ist Git"
linkTitle: "Was ist Git"
weight: 1
---

> Git [ɡɪt] ist eine freie Software zur verteilten Versionsverwaltung von Dateien, die durch Linus Torvalds initiiert wurde.

## Inhalt

- [Was ist Versionsverwaltung](#was-ist-versionsverwaltung)
- [Geschichte](#geschichte)
- [Name](#name)
- [Wie funktioniert Git](#wie-funktioniert-git)

## Ziele

- Ich weiss, was eine Versionsverwaltung ist und kann erklären, wofür sie verwendet wird.
- Ich kenne die Unterschiede zwischen lokaler, zentraler und verteilter Versionsverwaltung.
- Ich kann anhand der drei Zustände einer Datei grob beschreiben wie Git funktioniert.

## Was ist Versionsverwaltung

Eine Versionsverwaltung ist ein System, welches Änderungen an einer oder mehreren Dateien über die Zeit protokolliert, um die Entwicklung nachvollziehbar zu machen und womit man jederzeit auf bestimmte vorherige Versionen zugreifen kann.

### Lokale Versionsverwaltung

Eine lokale Versionsverwaltung hat wohl fast jeder schon mal bei sich eingesetzt. Die einfachste Version davon ist, wenn man zum Beispiel eine Datei kopiert und an der Kopie weiter arbeitet:

```bash
[user@computer ~/gymi/arbeit/]$ ls
matura_arbeit.docx  matura_arbeit_fastfertig.docx  matura_arbeit_wirklichfertig.docx  matura_arbeit_wirklichfertig_formatiert.docx  matura_final.docx
```

Dies ist jedoch sehr fehleranfällig, da man schnell die falsche Datei erwischt. Aus diesem Grund, haben Programmierer bereits vor langer Zeit, lokale Versionsverwaltungssysteme entwickelt, die alle Änderungen an allen relevanten Dateien in einer Datenbank verwalten. Ein Beispiel dafür ist [RCS](https://www.gnu.org/software/rcs/)

### Zentrale Versionsverwaltung

Um die Zusammenarbeit von mehreren Personen zu vereinfachen wurden zentrale Versionsverwaltungssysteme entwickelt. Diese Systeme basieren auf einem zentralen Server der alle Dateien verwaltet. User holen eine Datei ab (Auschecken oder engl. to check out) editieren sie und nur berechtigte User dürfen die Datei anschliessend wieder auf den Server stellen. Ein Beispiel dafür ist [SVN](https://subversion.apache.org/)

### Verteilte Versionsverwaltung

Im Gegensatz zu zentralen Systemen, wo der Benutzer nur den letzten Stand zur Verfügung hat, kopiert er bei verteilten Versionsverwaltungen einen vollständigen Klon des Repositories auf sein System und hat somit auch die komplette Geschichte lokal. Dies vereinfacht dem Entwickler das lokale arbeiten und erhöht die Ausfallsicherheit. Zusätzlich können solche Systeme gut mit verschiedenen externen Repositories (Remotes) umgehen, was die Zusammenarbeit weiter vereinfacht. Ein Beispiel dafür ist [GIT](https://git-scm.com)

## Geschichte

Git entstand aufgrund einer Lizenzänderung von `BitKeeper`, der Versionsverwaltung welche vom Linux Kernel bis 2005 verwendet wurde. Da die Kernel Entwickler die Software nicht mehr kostenlos nutzen konnten, entwickelten sie selber eine Lösung. Ziele der neuen Software waren Geschwindigkeit, einfaches Design, gute Unterstützung von nicht linearer Entwicklung, dezentrale Struktur und die Fähigkeit grosse Projekte effektiv zu verwalten. Git wird seit 2005 kontinuierlich weiterentwickelt.

## Name

Der Name „Git“ bedeutet in der britischen Umgangssprache so viel wie „Blödmann“. Linus Torvalds erklärte seine Wahl des ungewöhnlichen Namens mit einem Witz sowie damit, dass das Wort praktikabel und in der Softwarewelt noch weitgehend unbenutzt war:

> „Ich bin ein egoistischer Mistkerl, und ich benenne all meine Projekte nach mir. Zuerst ‚Linux‘, jetzt eben ‚Git‘.“

– Linus Torvalds

Dazu muss man anmerken, dass Linus den Namen Linux nur widerwillig akzeptierte.

## Wie funktioniert Git

Git funktioniert im Gegensatz zu den meisten anderen Versionsverwaltungen nicht, indem es eine Liste von Änderungen an einer Datei abspeichert, sondern eher wie ein Dateisystem, welches bei jedem Commit ein Snapshot aller Dateien anlegt. Um effizient zu bleiben, werden unveränderte Dateien nicht kopiert sondern nur verknüpft. Weiter stellt Git die Integrität aller verwalteten Dateien sicher, indem es eine Prüfsumme jeder Datei anlegt. Dies verunmöglicht Änderungen an Dateien, ohne dass es Git mitbekommen würde.

### Drei Zustände einer Datei

Eine Datei in einem Git Repository kann drei (Haupt-) Zustände haben:

- **Modified**: Die Datei wurde geändert aber noch nicht in die lokale Datenbank eingecheckt.
- **Staged**: Die Datei wurde im aktuellen Zustand für den nächsten Commit vorgemerkt.
- **Commited**: Die Datei ist im aktuellen Zustand in die lokale Datenbank eingecheckt.

### Minimaler Workflow

Hat man ein Repository von einem anderen Rechner _geklont_, kann man eine oder mehrere Dateien im Verzeichnisbaum editieren. Anschliessend _staged_ man diese Änderungen und _commited_ diese zum Schluss.
