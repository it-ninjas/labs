---
title: "Farben"
type: docs
linkTitle: "Farben"
weight: 14
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Arten, um Farben anzugeben.
---

## Zuweisen von Farben
Um einem Text eine Schriftfarbe zuzuweisen, ist folgendes eine Option:
```css
span {
  /*font color:*/
  color: orange;
}
```

Den Hintergrund von einem Element kann mit dem `background-color`-Property bestimmt werden:
```css
div {
  /*Color of the container*/
  background-color: orange;
}
```


## Arten von Farben
In den oberen Beispielen wurde die Farbe mit dem Wort `orange` bestimmt. Es gibt aber viele Arten, diese Farbe zu übergeben:

* via Color-Name: `orange`
* via RGB-Angaben (red green blue): `rgb(255,165,0)`
* via hexadezimalen Wert (HEX color): `#ffa500`

Es gibt noch weitere Möglichkeiten. Du findest diese hier: https://www.w3schools.com/colors/default.asp

Die folgende CSS-Regel setzt die Schriftfarbe auf Orange. Nur eine dieser 3 Regeln wird benötigt:
```css
.orange {
  color: orange;
  color: rgb(255,165,0);
  color: #ffa500;
}
```

Da diese Farbe in CSS bereits einen Namen hat ("`orange`"), wird hier die Angabe via Farbnamen empfohlen.

Obwohl die Angabe mit RGB in CSS möglich ist, sieht man in der Webentwicklung häufiger die hexadezimale Schreibweise.

Nachfolgend sind diese 3 Varianten genauer beschrieben.

### Via Color-Name
Am lesbarsten ist die Angabe der Farben via Namen. Es werden mindestens 140 Farben mit Namen unterstützt. Häufig verwendete Farben sind z.B.:
* black
* white
* gray (American) oder grey (British), lightgray
* blue, lightblue
* cornflowerblue
* red
* orange
* yellow

Hier findest du eine Liste der Farben: https://www.w3schools.com/colors/colors_names.asp

### via RGB
RGB steht für Rot-Grün-Blau. Wenn man die Farben via RGB angibt, so gibt man an, wie intensiv jede dieser 3 Farben in der gewünschten Farbe vorkommt. 0 bedeutet, dass die Farbe nicht vorkommt, 255 bedeutet hingegen, dass die Farbe zu 100% gebraucht wird.

Folgende RGB-Werte solltest du als Informatiker:in kennen:

| Name     | RGB
| -------- |-----
| red      | rgb(255, 0, 0)
| green    | rgb(0, 255, 0)
| blue     | rgb(0, 0, 255)
| yellow   | rgb(255, 255, 0)
| white    | rgb(255, 255, 255)
| black    | rgb(0, 0, 0)


In RGB (oder HEX) gibts du Farben an, die der Browser nicht per Namen kennt. Ein Beispiel hierfür wäre die Farbe 'amber', die es leider noch nicht in die offizielle Liste geschafft hat. 

Möchtest du herausfinden, wie der RGB- oder HEX-Wert einer Farbe ist, so kannst du dafür Online-Tools wie https://www.color-hex.com/color-names.html verwenden. Dort kannst du den Namen der Farbe eingeben und dann kannst du nachschauen, wie diese Werte für diese Farben sind. Im Beispiel der Farbe 'amber' erhälst du folgende Werte:

Name  | RGB              | HEX
----- | ---------------- | -------
amber | rgb(255, 191, 0) | #ffbf00

### via HEX color
Am häufigsten werden im Web die Farben via Hex color angegeben.

Farben in hexadezimale sind auch in RGB angegeben, wobei jeder dieser 3 Farben 2 Stellen in diesem Code ausmachen.

Kennen solltest du sicher:

| Farbe  | HEX color
| -----  | ----------
| red    | #ff0000 oder #f00
| grenn  | #00ff00 oder #0f0
| blue   | #0000ff oder #00f
| yellow | #ffff00 oder #ff0
| white  | #ffffff oder #fff
| black  | #000000 oder #000
| gray   | #808080

Wenn bei allen Farben die beiden Ziffern gleich sind, dann kann bei jeder Farbe die zweite Ziffer weggelassen werden (siehe Tabelle).