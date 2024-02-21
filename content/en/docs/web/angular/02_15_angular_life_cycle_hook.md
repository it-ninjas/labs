---
title: "Angular Life Cycle Hook"
type: docs
linkTitle: "Angular Life Cycle Hook"
weight: 17
date: 2023-05-05
description: >
  Modul #F6 - Angular - Life Cycle Hook
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

* **afterNextRender**: Wird einmal ausgeführt, sobald alle Komponenten das nächste Mal im DOM gerendert wurden. Diese kann man verwenden, um manuelle DOM-Operationen durchzuführen.

* **afterRender**: Wird jedes Mal ausgeführt, wenn alle Komponenten im DOM gerendert wurden. Diese kann man verwenden, um manuelle DOM-Operationen durchzuführen.

* **ngOnDestroy:** Wird aufgerufen, bevor ein Component zerstört wird. Hier kann man bereinigende Aktionen durchführen, Subscriptions beenden oder Ressourcen freigeben.

### afterNextRender & afterRender
Diese Funktionen unterscheiden sich von den anderen beschriebenen Lebenszyklus-Hooks. Anstatt einer Klassenmethode handelt es sich um eigenständige Funktionen, die einen Callback akzeptieren. 
Die Ausführung von Render-Callbacks ist nicht an eine bestimmte Komponenteninstanz gebunden, sondern erfolgt stattdessen über einen anwendungsweiten Hook.

![Lifecycle-Hooks ](../images/angular-lifecycle-init.png)

![Lifecycle-Hooks ](../images/angular-lifecycle-update.png)
