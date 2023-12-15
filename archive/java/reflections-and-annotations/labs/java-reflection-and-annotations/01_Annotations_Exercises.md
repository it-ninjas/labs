---
title: "Annotationen - Aufgaben"
linkTitle: "Annotationen - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #J6 - Annotationen & Reflection API
---

Die folgenden Aufgaben dienen der Vertiefung der beiden Themen Reflection API und Annotations.

## Aufgabe 1

Implementiere eine eigene Annotation. Die Annotation soll der Dokumentation einer Klasse dienen und
die folgenden Eigenschaften aufweisen:

- Verfügbar zur Compile Time
- Verfügbar auf Klassen
- Attribut zur Aufnahme von einem oder mehreren Autoren als String-Array
- Attribut zur Aufnahme einer Beschreibung als String, der Default-Wert soll ein leerer String sein
- Attribut zur Aufnahme einer Version als String, der Default-Wert ist 0.0.1

Der Name der Annotation soll anhand ihres Zwecks gewählt werden.

## Aufgabe 2

Implementiere eine sinnvolle Modell-Klasse und wende deine neue Annotation an.
Fülle die Werte für Autor, Beschreibung und Version ab.

## Aufgabe 3

Implementiere einen Annotations-Prozessor, welcher die oben geschriebene Annotation auf der
Modell-Klasse auswertet.
Die Auswertung soll auf die Kommandozeile erfolgen.

### Schritt 1

Implementiere eine neue Klasse, welche die folgende Basis hat:

```java

@SupportedAnnotationTypes(/*1*/)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DocumentationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
```

Füge beim Punkt 1 den kompletten Pfad (Package und Name) deiner Annotation ein.

### Schritt 2

Die beiden Parameter annotations und roundEnv werden durch den Annotations-Prozessor benutzt, um
während der Kompilierung die entsprechende Annotation zu erhalten.
Im Set annotations befinden sich alle Annotationen, welche unter Punkt 1 angegeben werden.
Die Klasse RoundEnvironment erlaubt den Zugriff auf alle Elemente während der Kompilierung.
Ergänze die Methode des Annotations-Prozessors mit den folgenden Loops:

```java
for(TypeElement annotation:annotations){
    Set<?extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
    for(Element element:annotatedElements){
        X annotation=element.getAnnotation(X.class);
    }
}
```

Die Klasse X kannst du durch deine Annotation ersetzen. Jetzt hast du Zugriff auf die Elemente
deiner Annotation.

### Schritt 3

Ergänze die Implementation, um den Klassennamen der Modell-Klasse und die Werte der Annotation
auszudrucken. Hier ein Beispiel, wie der Ausdruck in etwa aussehen könnte:

```text
------
Person
------
Model class representing a person with a name and age
[u210148 (Claudio Zesiger)]
0.0.1
```

### Schritt 4

Kompiliere die Annotation und den Annotations-Prozessor auf der Kommandozeile (Terminal) mit dem
Befehl javac.

```shell
cd ./src/main/java  # Befehle funktionieren ab diesem Verzeichnis.
javac ./<path/to/my>/<Annotation>.java <path/to/my>/<AnnotationProcessor>.java
```

Ersetze die Pfade und die Namen der Annotation/des Annotations-Prozessors mit deinen Angaben.

### Schritt 5

Kompiliere die implementierte Modell-Klasse mit dem folgenden Befehl:

```shell
javac -processor <package>.<AnnotationsProcessor> <path/to/my><ModelKlasse>.java
```

Die Ausgabe auf die Kommandozeile durch den Annotations-Prozessor sollte anschliessend angezeigt werden.
