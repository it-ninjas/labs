---
title: "Projekt aufsetzen in TypeScript"
type: docs
linkTitle: "Projekt aufsetzen in TypeScript"
weight: 4
date: 2023-06-02
description: >
    In diesem Kapitel wird beschrieben, wie man in Typescript ein Projekt aufsetzt und startet.
---
## Hello World
Da Node.js bereits installiert wurde, kann nun anhand des Node Package Manager mühelos typescript installiert werden.
Dazu öffnet man eine Konsole und gibt den folgenden Befehl ein: 
``` shell
npm install -g typescript
```

Sobald die Installation abgeschlossen ist, erstellt man eine Datei und nennt diese `hello-world.ts`.
Nun die Datei mit einer IDE öffnen und die folgende Codezeile reinschreiben:
``` typescript
console.log("Hello World");
```

Somit wurde das erste Typescript "Projekt" erstellt. Um dieses auszuführen, muss der Quellcode zu JS transpilieren.
Dazu eine Konsole öffnen und sich in das Verzeichnis, indem sich die Datei befindet, begeben.

Danach folgenden Befehl in der Konsole eingeben: 
``` shell
tsc hello-world.ts
```

Wie nun zu sehen ist, befindet sich im Verzeichnis eine gleichnamige JS Datei.

Diese kann nun mit Node ausgeführt werden: 
``` shell
node hello-word.js
```

Falls alles funktioniert hat, gibt die Konsole `Hello World` aus.

