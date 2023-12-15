---
title: "Angular Life Cycle Hook"
type: docs
linkTitle: "Angular Life Cycle Hook"
weight: 17
date: 2023-05-05
description: >
    Wie der Angular Life Cycle Hook genau aussieht findet man hier.
---
## Ziele
* Du weisst, was der Angular Life Cycle Hook ist und wozu dieser ist.
* Du kennst, die verschiedenen Hooks und weisst wozu diese zuständig sind.

## Angular Life Cycle Hook
Lifecycle-Hooks ermöglichen es Entwicklern, Code zu spezifischen Zeitpunkten im Lebenszyklus eines Components auszuführen und somit den Component zu initialisieren, auf Änderungen zu reagieren und Aufräumarbeiten durchzuführen.

* **ngOnChanges**: Wird aufgerufen, wenn einer oder mehrere Input-Properties eines Components sich ändern. Hier kann man auf die Änderungen reagieren und entsprechende Aktionen ausführen.

* **ngOnInit**: Wird einmalig aufgerufen, nachdem Angular die Input-Properties initialisiert hat und bevor der Component gerendert wird. Hier kann man Initialisierungslogik ausführen, Daten abrufen oder Abhängigkeiten initialisieren.

* **ngDoCheck**: Wird bei jedem Angular-Change-Detection-Durchlauf aufgerufen. Hier kann man benutzerdefinierte Änderungsüberprüfungen durchführen, um auf Änderungen zu reagieren, die Angular nicht automatisch erkennt.

* **ngAfterContentInit**: Wird aufgerufen, nachdem der eingebettete Inhalt (Content) im Component initialisiert wurde. Hier kann man auf den eingebetteten Inhalt zugreifen und damit interagieren.

* **ngAfterContentChecked**: Wird nach jedem Angular-Change-Detection-Durchlauf aufgerufen, nachdem der eingebettete Inhalt überprüft wurde. Hier kann man Aktionen ausführen, die nach der Überprüfung des eingebetteten Inhalts erforderlich sind.

* **ngAfterViewInit**: Wird aufgerufen, nachdem die View (DOM) des Components initialisiert wurde. Hier kann man auf die gerenderte View zugreifen und damit interagieren.

* **ngAfterViewChecked**: Wird nach jedem Angular-Change-Detection-Durchlauf aufgerufen, nachdem die View überprüft wurde. Hier kann man Aktionen ausführen, die nach der Überprüfung der View erforderlich sind.

* **ngOnDestroy:** Wird aufgerufen, bevor ein Component zerstört wird. Hier kann man bereinigende Aktionen durchführen, Subscriptions beenden oder Ressourcen freigeben.

![Lifecycle-Hooks ](../images/angular-lifecycle.png)