---
title: "CI/CD-Pipelines"
linkTitle: "CI/CD-Pipelines"
type: docs
weight: 5
description: >
  TODO
---

#### Ziele

- Ich kann den Begriff Continuous Integration erklären
- Ich kann einen typischen Aufbau eine CI-Pipeline erklären
- Ich kenne typische Aufgaben einer CI-Pipeline
- Ich kann den Begriff Continous Deployment erklären
- Ich kenne typische Aufgaben einer CD-Pipelines

## Continous Integration

Continous Integration, oder kurz CI, heisst auf Deutsch so viel wie "Fortlaufende Integration". Es beschreibt die Praxis Codeänderungen oft und regelmässig in die Code Basis zu integrieren. Dazu gehört auch das Testen dieser Änderungen sowie andere Checks, wie etwa Security Scans. Da dies mühsame Arbeit ist, passiert das meistens vollautomatisiert in einer sogenannten Pipeline. Diese heissen so da die der Code wie durch ein (oder mehre) Rohre muss, welche diese Checks ausführen und das Ventil zudrehen können, sollte etwas nicht gut sein.

![](../pipeline.gif)

Das Ausführen so einer Pipeline passieren entweder nach einem bestimmten Ereignis, z.B. einem Push auf einen Git-Branch, oder periodisch, jede Nacht um 3:00. Damit das Möglich ist, werden sie nicht auf dem Computer des Entwicklers sondern einem separaten CI-Server ausgeführt. So kann sichergestellt werden das nicht vergessen geht und die Ergebnise transparent sind.

Wichtig ist dass das fortlaufende Integrieren von Änderungen nicht heisst, das nach jeder Änderung eine neue Version der Software verfügbar ist. Das kann der Fall sein (siehe [Continous Deployment](#continous-deployment)) muss aber nicht. Viel mehr geht es darum das die Änderungen jeweils klein und gut getestet sind.

### Beispiel einer CI-Pipeline

Als Beispiel nehmen wir eine Anwendung, welche eine neue Login-Page bekommen soll. Der Entwickler macht also einen neuen Branch `feature/new-login-page`. Auf diesem nimmt er seine Änderungen vor und mergt, sobald er fertig ist, diese wieder in den `main`-Branch. Vor dem Mergen können andere Entwickler noch Tests ausführen oder einen Security Scan laufen lassen. Da dies jedoch manuell gemacht werden muss, geht das oft vergessen oder wird aus Faulheit nicht umgesetzt.

![](../no-ci.png)

<!--
gitGraph
    commit
    commit
    branch feature/new-login-page
    checkout feature/new-login-page
    commit id: "Remove Google+"
    commit id: "Implement new design"
    commit id: "Fix styling"
    checkout main
    merge feature/new-login-page id: "Merge into main"
    commit
-->

Mithilfe einer CI-Pipeline können wir diese zwei Sachen automatisiert ausführen nach (oder idealerweise noch vor) einem Merge. Pipelines können also dazu dienen langweilige, wiederkehrende Arbeiten zu verrichten und Entwickler zum einhalten von Standards zu bewegen. Durch die Pipeline merken wir z.B. das mehrere Unit-Test fehlschlagen. Dazu hat die Pipeline ganz einfach den Maven-Command `mvn clean test` ausgeführt und geschaut ob jeder Test grün ist. So wie es ein Entwickler auch auf seiner Maschine tun kann.

![](../simple-ci.png)

<!--
gitGraph
    commit id: "0-2932c65"
    commit id: "1-8da8549"
    branch feature/new-login-page
    checkout feature/new-login-page
    commit id: "Remove Google+"
    commit id: "Implement new design"
    commit id: "Fix styling"
    checkout main
    merge feature/new-login-page id: "✅ Security Scan ❌ Tests"
    commit id: "6-e293507"
-->

Das hätte der Entwickler merken können wenn er nach jedem Commit die Tests ausgeführt hat. Da dies aber manuelle und langweilige Arbeit ist, hat er das natürlich nicht gemacht. Werden die Tests stattdessen auch in einer Pipeline nach jedem `git push` ausgeführt merkt der Entwickler schneller das sein Code noch nicht gut ist.

![](../reasonable-ci.png)

<!--
gitGraph
    commit id: "0-2932c65"
    commit id: "1-8da8549"
    branch feature/new-login-page
    checkout feature/new-login-page
    commit id: "Remove Google+ ✅ Tests"
    commit id: "Implement new design ❌ Tests"
    commit id: "Fix styling ✅ Tests"
    checkout main
    merge feature/new-login-page id: "✅ Security Scan ✅ Tests"
    commit id: "6-e293507"
-->

Es muss also nicht für jedes Ereignis die gleiche Pipeline ausgeführt werden. Der Security Scan kann etwa mehrere Minuten dauern, weshalb er nicht bei jedem `git push` sondern nur vor einem Merge ausgeführt wird. Grosse Projekte können duzende solcher Pipelines haben, für verschiedene Anlässe und Zwecke.

### Anwendungszwecke von CI-Pipelines

- **Testing**  
   Die wahrscheinlich häufigste Verwendung ist das automatiserte Ausführen von Tests. Das können von Unit-Tests bis hin zu E2E-Tests alles sein. Ein Vorteil davon ist das die Entwickler das nicht mehr manuell machen müssen. Ein weiterer das die Test beschleunigt werden können, etwa durch das Aufteilen der Tests viele Maschinen. Es wird auch vermieden das die Test auf einem Entwickler-Laptop laufen, auf einem anderen aber nicht und nun nicht klar ist ob die Tests gut sind oder nicht. Das was in der CI-Pipeline passiert gilt.
- **Durchsetzen von Standards**
  Ebenfalls sehr häufig werden Pipelines eingesetzt um gewisse Standards zu überprüfen. Dazu gehört etwa ob der Code richtig formattiert ist oder genügend Tests geschrieben wurden.
- **Security Checks**
  Niemand hat Zeit sich alle Meldungen über Hacks oder Sicherheitslücken durchzulesen und herauszufinden ob diese auf die eigene Software zutreffen. Eine Pipeline kann stattdessen jede Nacht einen automatisierten Scan durchführen und so die Entwickler am nächsten Morgen benachrichtigen.
- **Bauen von Artefakten**
  Docker-Container oder JARs können durch die Pipelines automatisch generiert und richtig versioniert werden. So sind sie für ein spätere Deployment bereit oder können sogar in einer anderen Pipeline verwendet werden.

### Umsetzen einer CI-Pipeline

Es gibt viele Möglichkeiten eine CI-Pipeline umzusetzen. Gewisse sind eigenständige Tools wie [Jenkins](https://www.jenkins.io/) oder [CircleCI](https://circleci.com/). Viele Plattformen bauen direkt ihre eigenen Lösungen ein, wie etwa [GitLab](https://docs.gitlab.com/ee/ci/) oder [GitHub](https://github.com/features/actions).

TODO

## Continous Deployment

Continous Deployment, oder kurz CD, ist das gleiche Prinzip wie CI aber auf das veröffentlich einer Software bezogen. Das kann z.B. das Updaten einer Website oder das Veröffentlichen einer neuen Version einer App.

TODO
