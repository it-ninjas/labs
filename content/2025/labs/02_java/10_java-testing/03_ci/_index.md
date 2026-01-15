---
title: "CI-Pipeline - Aufgaben (optional)"
linkTitle: "CI-Pipeline - Aufgaben (optional)"
type: docs
weight: 3
description: >
  Aufgaben zu CI-Pipeline
---

Du hast bereits das [springboottesting-Repository](https://github.com/it-ninjas/springboottesting) kennengelernt. In diesem hat es diverse Tests, welche mit `mvn clean verify` ausgeführt werden können. Nun wollen wir das die Tests bei jedem `git push` automatisch ausgeführt werden.

#### Aufgabe

> Für diese Aufgabe brauchst du einen Account bei GitHub.

Mache als erstes ein Fork, eine Kopie, des springboottesting-Repositories auf deinen GitHub-Account.

1. Öffne das [springboottesting-Repository](https://github.com/it-ninjas/springboottesting)
2. Klicke oben rechts auf "Fork"
3. Klicke auf den grünen Button "Create Fork"

Nun solltest du ein `springboottesting`-Repository in deinem GitHub-Profil haben, welches eine 1:1 Kopie des Originals ist.

In diesem Repository soll mithilfe von [GH Actions](https://docs.github.com/en/actions/writing-workflows/quickstart) eine CI-Pipeline umgesetzt werden.

##### Anforderungen

- Die Pipeline wird bei jedem `git push` ausgeführt
- Die Pipeline führt die Tests mit `mvn clean verify` aus
- Die Pipeline schlägt fehl, wenn ein Test fehlschlägt
- Die Pipeline hat am Anfang immer eine Message, welche den User angibt der die Pipeline ausgelöst hat

---

Hier kannst du [zurück zur Theorie](../../../../docs/99_shared/cicd/01_continuous-integration).
