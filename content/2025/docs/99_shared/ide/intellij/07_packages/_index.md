---
title: "Packages lokal verwenden"
linkTitle: "Packages lokal verwenden"
weight: 7
description: >
  In diesem Modul lernst du, wie du ein eigenes Java-Package in IntelliJ als .jar-Datei exportierst und in einem anderen Projekt ohne Maven verwenden kannst.
---

{{< module "J1" >}}

## Ziele

- Ich weiss, wie man in IntelliJ eine `.jar`-Datei aus einem Java-Projekt erzeugt.
- Ich kann eine `.jar`-Datei lokal speichern und weitergeben.
- Ich kann ein lokal gespeichertes Package in einem anderen Projekt einbinden und verwenden.

{{< zeit lesen="10" >}}

## Warum das wichtig ist

Wenn du eigene Hilfsklassen oder Utility-Packages erstellt hast, möchtest du sie vielleicht in mehreren Projekten
verwenden – **ohne sie jedes Mal neu zu schreiben**. Dafür eignet sich das Java-Archivformat (`.jar`).

Dieses Modul zeigt dir, wie du in **IntelliJ IDEA ohne Maven**:

- ein `.jar`-Archiv erzeugst
- es in einem anderen Projekt wieder einbindest

Falls du mehr über Java Packages erfahren willst:
[Java Grundlagen - Java Packages](../../../../02_java/03_java-grundlagen/12_packages/)

## Schritt 1: Projekt vorbereiten

Stelle sicher, dass dein Projekt eine sinnvolle Package-Struktur hat und die Klassen `public` sind:

```java
package ch.itninja.util;

public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```

## Schritt 2: `.jar`-Datei erzeugen

1. Öffne dein Projekt in IntelliJ
2. Gehe auf **File → Project Structure** (`Ctrl+Alt+Shift+S`)
3. Unter **Artifacts**:
   - Klicke auf das `+` → **JAR → From modules with dependencies**
   - Wähle dein Hauptmodul und die Hauptklasse (oder „extract to the classes directory“)
   - Setze das Häkchen bei **Include in project build**
4. Klicke auf **Apply** und **OK**

Nun kannst du das `.jar`-File erstellen:

- Menü **Build → Build Artifacts... → Build**
- Die Datei findest du im Ordner `out/artifacts/...`

## Schritt 3: `.jar` in neues Projekt einbinden

1. Erstelle ein neues Java-Projekt in IntelliJ
2. Öffne wieder die **Project Structure** (`Ctrl+Alt+Shift+S`)
3. Unter **Libraries**:
   - Klicke auf das `+` → **Java**
   - Wähle dein `.jar`-File aus
   - IntelliJ fügt es dem Projekt hinzu

Nun kannst du in deinem Code importieren:

```java
import ch.itninja.util.MathUtils;
```

Und verwenden:

```java
int result = MathUtils.add(3, 5);
```

## Weitergabe an andere

Du kannst die `.jar`-Datei einfach:

- per **E-Mail**, **USB-Stick** oder **Cloudspeicher** weitergeben
- in ein **gemeinsames Netzlaufwerk** legen

Wenn du das `.jar` regelmässig aktualisierst, empfiehlt sich später ein zentraler Server oder ein Maven-Repository.

{{< ninja tip >}}
Die `.jar`-Datei enthält nur die kompilierten `.class`-Dateien. JavaDoc-Kommentare oder Quellcode sind darin nicht
enthalten.

Wenn du willst, kannst du im Artifact auch den Sourcecode oder die JavaDoc einbinden.
{{< /ninja >}}
