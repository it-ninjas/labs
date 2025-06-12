---
title: "Exam zu NgRx"
type: docs
linkTitle: "NgRx"
weight: 1
date: 2024-03-02
description: >
  Eine Aufgaben zu NgRx.
---

Im Exam zu Angular hast du eine Notenverwaltung erstellt. Nun sollst du sie geschickt mit NgRx erweitern, um die Fächer, Noten, Durchschnitte usw. mithilfe von NgRx zu speichern.
Achte darauf, dass bei Hinzufügen, Bearbeiten oder Löschen von Noten die Berechnung des Durchschnitts nicht über einen Backend-Request erfolgt, sondern über einen Selector.
Zudem sollen die GET-Anfragen minimiert werden, sodass nach dem POST einer Note keine direkte GET-Anfrage mehr erforderlich ist. Das GET ist bei NgRx nicht mehr notwendig.
