---
title: "tsconfig Datei"
type: docs
linkTitle: "tsconfig Datei"
weight: 3
date: 2023-06-02
description: >
    Was die tsconfig Datei in Typescript ist, kann in diesem Kapitel nachgelesen werden.
---

## Konfigurationsdatei für TypeScript-Projekte
Die `tsconfig.json`-Datei ist eine Konfigurationsdatei für TypeScript-Projekte. Sie wird verwendet, um verschiedene Einstellungen für den TypeScript-Compiler festzulegen. Wenn sich die tsconfig.json-Datei im Stammverzeichnis eines Projekts befindet, werden diese Einstellungen automatisch von jeder TypeScript-Datei im Projekt übernommen.

Hier sind einige der wichtigsten Einstellungen, die in der `tsconfig.json`-Datei vorgenommen werden können:

* `compilerOptions`: Dieser Abschnitt enthält die Compiler-Optionen, die den Verhalten des TypeScript-Compilers steuern. Einstellungen wie die ECMAScript-Version (target), das Modulsystem (module), den Pfad zum Ausgabeverzeichnis (outDir), den Typen-Check-Modus (strict) und viele andere Optionen können hier konfigurieren werden.
* `include und exclude`: Mit diesen Optionen gibt man an, welche Dateien vom Compiler einbezogen bzw. ausgeschlossen werden sollen. Es können Muster (z.B. src/**/*.ts für alles .ts Dateien) verwendet werden, um Dateien zu filtern.
* `extends`: Diese Option ermöglicht es, eine andere tsconfig.json-Datei als Basis zu verwenden und ihre Einstellungen zu erweitern. Dies ist nützlich, wenn eine gemeinsame Konfiguration für mehrere Projekte vorhanden ist und nur spezifische Einstellungen in der aktuellen Datei ändern möchten.
* `files`: Diese Option ermöglicht es, explizit eine Liste von Dateien anzugeben, die vom Compiler verarbeitet werden sollen. Dies wird normalerweise verwendet, wenn die include-Option nicht verwendet werden soll und nur bestimmte Dateien im Projekt berücksichtigt werden sollen.
* `references`: Mit dieser Option können Referenzen zu anderen Projekten angegeben werden, um die Abhängigkeiten zwischen den Projekten zu definieren. Dies ist nützlich, wenn mehrere TypeScript-Projekte existieren und diese miteinander verknüpfen werden sollen.

Eine der wichtigsten `compilerOptions` ist die `strict`-Option. Diese ist eine Sammlung von Compiler-Optionen, welche aktiviert werden können, um die strenge Überprüfung von Typen und Codequalität sicherzustellen. Wenn die `strict`-Option auf `true` gesetzt wird, werden mehrere einzelne Compiler-Optionen aktiviert, um die Typsicherheit zu verbessern und potenziell unsichere Codepraktiken zu verhindern.

Hier sind einige der wichtigsten Compiler-Optionen, die von der strict-Option in der tsconfig.json-Datei aktiviert werden:

* `strictNullChecks`: Stellt sicher, dass `null` und `undefined` nur auf Nullable-Typen zugewiesen werden können. Dadurch werden potenzielle Fehler vermieden, wenn auf Eigenschaften oder Methoden von Null- oder Undefined-Werten zugegriffen wird.
* `noImplicitAny`: Verhindert, dass Variablen implizit den `any`-Typ annehmen. Dadurch wird man dazu gezwungen, explizite Typen für Variablen zu definieren und den `any`-Typ so weit wie möglich zu vermeiden.
* `strictFunctionTypes`: Erzwingt die Kompatibilität von Funktionstypen, einschliesslich der Rückgabetypen von Funktionen. Dadurch werden Fehler vermieden, wenn Funktionen mit inkompatiblen Typen zugewiesen oder aufgerufen werden. 
* `strictPropertyInitialization`: Stellt sicher, dass alle Eigenschaften von Klassen explizit initialisiert werden, entweder in ihrem Deklarationsabschnitt oder im Konstruktor. Dadurch wird verhindert, dass unbeabsichtigt auf nicht initialisierte Eigenschaften zugegriffen wird. 
* `strictBindCallApply`: Überprüft die Verwendung von `bind`, `call` und `apply` auf Funktionen und stellt sicher, dass die Parameter und Rückgabewerte korrekt typisiert sind. 
* `noImplicitThis`: Stellt sicher, dass `this` in Funktionen explizit typisiert wird, um Fehler bei der Verwendung zu vermeiden.

