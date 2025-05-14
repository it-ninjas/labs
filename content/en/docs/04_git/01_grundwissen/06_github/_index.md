---
title: "GitHub"
linkTitle: "GitHub"
weight: 6
---

_(Dieses Modul ist optional)_

GitHub ist ein Webservice für das Verwalten von Software Code via Git. Darüber hinaus bietet GitHub viele weitere Funktionen, von Projektmanagement mit Taskverwaltung, über Wikis bis zum Buildserver. GitHub ist die Plattform für Opensource Projekte.

Weitere Infos:

- [Wikipedia](https://de.wikipedia.org/wiki/GitHub)
- [GitHub Doku](https://try.github.com/)

## GitHub Alternativen

Natürlich ist GitHub nicht die einzige Plattform, welche diesen Service anbietet. Alle Alternativen haben ihre eigenen Features und Limitierungen, im Kern verwenden aber alle Git.

Alternativen:

- Gitea: https://gitea.io
- Gitolite: https://gitolite.com
- Gitosis: https://github.com/tv42/gitosis
- GitLab: https://gitlab.com/
- Bitbucket: https://bitbucket.org

## GitHub Account

Falls du noch keinen GitHub-Account hast, wäre jetzt der Moment einen zu erstellen. https://github.com/signup

## Git Protokolle

Um auf ein entferntes Git Repository zuzugreifen, gibt es in der Regel zwei Varianten:

- HTTPS
- SSH

Beide Protokolle bieten standardmässig Verschlüsselung, Authentifizierung und Komprimierung.

### Git über HTTPS

Kurze Wiederholung: Um ein Repository über HTTPS zu klonen verwendet man den Befehl:

```bash
$ git clone https://github.com/kelseyhightower/nocode.git
```

Dies ist die einfachste Variante, um Code schnell herunterzuladen und lokal im eigenen Editor zu betrachten.

Vorteile:

- Anonymer Zugriff möglich
- Zugriff für Systeme, auf denen SSH weniger verbreitet ist
- HTTPS ist auf vielen Corporate Firewalls standardmässig offen

Nachteile:

- Zwischenspeicherung der Anmeldedaten mit HTTPS weniger benutzerfreundlich als mit SSH Keys
- Konfiguration des Webservers etwas komplizierter als die von SSH

### Git über SSH

Um ein Repository mit SSH zu klonen, kommt folgender Befehl zum Einsatz:

```bash
$ git clone git@github.com:cajotafer/10xengineers.git
```

Für die meisten Anwendungsfälle ist dies der bevorzugte Weg, um entfernte Git Repositories zu verwenden.

Vorteile:

- SSH ist auf jedem Linux System bereits vorinstalliert (server- wie clientseitig)
- SSH Server sind sehr einfach zu konfigurieren
- Der Zugriff via SSH ist sehr sicher

Nachteile:

- Bietet keinen anonymen Zugriff

## GitHub Features

| Feature        | Funktion                                                                                                                                           |
| -------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- |
| Issues         | Ermöglichen es, Tasks in einem Repo zu erstellen und zu tracken.                                                                                   |
| Pull Requests  | Ein Pull Request ermöglicht es, Changes zu reviewen und zu besprechen, bevor sie in einen Branch gemerged werden.                                  |
| Forks          | Eine Fork ist eine Kopie von einem Git-Repo. Die Fork kann dann bearbeitet und angepasst werden, ohne dass das originale Repo davon betroffen ist. |
| GitHub Pages   | Basic Webseiten welche auf GitHub gehostet werden                                                                                                  |
| GitHub Actions | CI/CD Integration von GitHub                                                                                                                       |

## Hands On

Für dieses Hands-On werden wir alles via Webinterface von GitHub machen. Ein Grossteil der Tasks können jedoch auch Lokal mit Git im Terminal gemacht werden.

### Branches und Pull Requests

1. https://guides.github.com/activities/hello-world/

### Forks, Pull Requests, Reviews

1. Fork erstellen vom [Repo](https://github.com/SylivanKenobi/hello-world).
   ![Create Fork](images/create-fork.png "Create Fork")
1. Weitere User auf Fork hinzufügen
   ![Add User](images/add-user.png "Add User")
1. Branch auf Fork erstellen
1. `hello-world.sh` auf dem Master Branch anpassen und committen.

   ```bash
   #!/bin/bash

   echo 'Hello World Master'
   ```

1. `hello-world.sh` auf dem neuen Branch anpassen und committen.

   ```bash
   #!/bin/bash

   echo 'Hello World Feature'
   ```

1. Pull Request erstellen
1. Da auf beiden Branches die gleiche Zeile bearbeitet wurde, kann GitHub die Branches nicht automatisch Mergen. Aus diesem Grund müssen zuerst die Konflikte gelöst werden
   ![Fix Merge](images/fix-merge.png "Fix Merge")
1. Teamkollege als Reviewer zuweisen.
1. Review Changes umsetzen.
1. Pull Request mergen.
1. Merge Request auf [Original Repo](https://github.com/SylivanKenobi/hello-world) erstellen
1. Ende
