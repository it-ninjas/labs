---
title: "Farben"
type: docs
linkTitle: "Farben"
weight: 14
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Arten, Farben anzugeben.
---

#### Ziele

- Ich kenne die verschiedenen Möglichkeiten, Farben in CSS zu definieren.
- Ich verstehe die Unterschiede zwischen der Farbangabe über Namen, RGB und HEX in CSS.
- Ich kann Farben in CSS korrekt und gezielt einsetzen.

## Zuweisen von Farben

Um einem Text eine Schriftfarbe zuzuweisen, kannst du das `color`-Attribut verwenden.

```css
span {
  /*font color:*/
  color: orange;
}
```

Den Hintergrund von einem Element kann mit dem `background-color`-Attribut bestimmt werden.

```css
div {
  /*Color of the container*/
  background-color: orange;
}
```

## Arten von Farben

In den oberen Beispielen wurde die Farbe mit dem Wort `orange` bestimmt. Es gibt aber viele Arten, diese Farbe zu übergeben:

- via (vordefiniertem) Color-Name: `orange`
- via RGB-Angaben (Red-Green-Blue-Wert): `rgb(255,165,0)`
- via hexadezimalen Wert (HEX color): `#ffa500`

Es gibt noch weitere Möglichkeiten, Farben in CSS anzugeben. Diese findest du auf dieser Seite: https://www.w3schools.com/colors/default.asp

Jede dieser CSS-Zeilen setzt die Schriftfarbe jeweils auf Orange:

```css
.orange {
  color: orange;
  color: rgb(255, 165, 0);
  color: #ffa500;
}
```

Da diese Farbe in CSS bereits einen Namen hat ("`orange`"), wäre in diesem Fall die Angabe via Farbnamen empfehlenswert.

Obwohl die Angabe mit RGB in CSS ebenfalls möglich ist, sieht man in der Webentwicklung häufiger die hexadezimale Schreibweise.

Nachfolgend sind diese 3 Varianten genauer beschrieben.

### Via Color-Name

Am besten lesbar ist die Angabe der Farben via Namen. Es werden mindestens 140 Farben mit Namen unterstützt. Diese Art der Farbangabe ist aber stark eingeschränkt, da man im Gegensatz zu RGB oder HEX keine Anpassungen an der Farbe vornehmen kann. Häufig verwendete Farben sind z.B.:

- black
- white
- gray (American) oder grey (British), lightgray
- blue, lightblue
- cornflowerblue
- red
- orange
- yellow

Hier findest du eine Liste der Farben: https://www.w3schools.com/colors/colors_names.asp

### via RGB

RGB steht für Rot-Grün-Blau. Wenn man die Farben via RGB angibt, so gibt man an, wie intensiv jede dieser 3 Farben in der gewünschten Farbe teilhaben soll. 0 bedeutet, dass die Farbe nicht vorkommt, 255 bedeutet hingegen, dass die Farbe zu 100% gebraucht wird. Zusätzlich kann auch noch ein 4. Wert der sogenannte Alpha-Wert, angegeben werden. Dieser legt die Transparenz der Farbe fest, wobei 0 für komplette Transparenz und 255 für Undurchsichtigkeit steht.

Folgende RGB-Werte solltest du als Informatiker:in kennen:

| Name   | RGB                |
| ------ | ------------------ |
| red    | rgb(255, 0, 0)     |
| green  | rgb(0, 255, 0)     |
| blue   | rgb(0, 0, 255)     |
| yellow | rgb(255, 255, 0)   |
| white  | rgb(255, 255, 255) |
| black  | rgb(0, 0, 0)       |

In RGB (oder HEX) gibst du Farben an, die der Browser nicht per Namen kennt. Ein Beispiel hierfür wäre die Farbe 'amber', die es leider noch nicht in die offizielle Liste geschafft hat.

Möchtest du herausfinden, wie der RGB- oder HEX-Wert einer Farbe ist, so kannst du dafür Online-Tools wie https://www.color-hex.com/color-names.html verwenden. Dort kannst du den Namen der Farbe eingeben und dann nachschauen, wie die Werte für diese Farben sind. Im Beispiel der Farbe 'amber' erhältst du folgende Werte:

| Name  | RGB              | HEX     |
| ----- | ---------------- | ------- |
| amber | rgb(255, 191, 0) | #ffbf00 |

Das folgende Beispiel definiert einen schwarzen Hintergrund, der halbtransparent ist. Das hat den effekt, dass der darüberliegende Inhalt zwar noch sichtbar ist, aber verdunkelt wirkt.

```css
background-color: rgb(0, 0, 0, 128);
```

### via HEX color

Am häufigsten werden in der Web-Entwicklung die Farben via Hex-Code angegeben.

Farben in Hexadezimalen sind auch nach dem RGB-Konzept aufgebaut, wobei jeweils 2 Stellen des Codes eine Farbe ausmachen.

Kennen solltest du sicher:

| Farbe  | HEX color         |
| ------ | ----------------- |
| red    | #ff0000 oder #f00 |
| grenn  | #00ff00 oder #0f0 |
| blue   | #0000ff oder #00f |
| yellow | #ffff00 oder #ff0 |
| white  | #ffffff oder #fff |
| black  | #000000 oder #000 |
| gray   | #808080           |

Wenn bei allen Farben die beiden Ziffern gleich sind, dann kann bei jeder Farbe jeweils die zweite Ziffer weggelassen werden (siehe Tabelle).

```css
background-color: #b2222280; /*dunkles Rot, zur Hälfte transparent*/
```
