---
title: "JSON"
type: docs
linkTitle: "JSON"
weight: 14
date: 2023-10-25
description: >
  Modul #F4 - JavaScript - JSON
---

# JSON (JavaScript Object Notation)

JSON ist ein weit verbreitetes Datenformat zur Repräsentation strukturierter Informationen. Es basiert auf einer 
einfachen Syntax, die sowohl von Menschen als auch von Maschinen leicht verstanden werden kann. JSON-Daten bestehen 
aus Schlüssel-Wert-Paaren und geordneten Listen von Werten. Hier ist eine grundlegende Übersicht der JSON-Syntax:

## Schlüssel-Wert-Paare

Ein JSON-Objekt besteht aus einer Sammlung von Schlüssel-Wert-Paaren. Ein Schlüssel ist eine Zeichenfolge (String), 
gefolgt von einem Doppelpunkt und einem zugehörigen Wert. Die Paare sind durch Kommas getrennt und in geschweiften 
Klammern eingeschlossen:

```json
{
    "name": "John Doe",
    "age": 30,
    "city": "New York"
}
```
## Geordnete Listen
In JSON können auch geordnete Listen von Werten dargestellt werden. Diese Listen sind durch eckige Klammern 
gekennzeichnet und die Werte sind durch Kommas getrennt:

```json
{
    "fruits": ["apple", "banana", "orange"]
}
```

## Beispiel
Hier ist ein einfaches Beispiel, das ein JSON-Objekt darstellt:
```json
{
    "name": "Alice",
    "age": 25,
    "isStudent": true,
    "grades": [95, 89, 78]
}
```

JSON wird häufig in der Webentwicklung, APIs und Datenaustausch verwendet, da es leicht zu verarbeiten ist. Es ist eine 
effektive Möglichkeit, Daten in einer strukturierten Form zu speichern und zwischen verschiedenen Systemen auszutauschen.