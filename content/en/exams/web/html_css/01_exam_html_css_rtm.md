---
title: "Exam zu den HTML- und CSS-Basics"
type: docs
linkTitle: "HTML- und CSS-Basics"
weight: 2
date: 2021-11-01
description: >
    Erstelle dein eigenes Zeiterfassungs-Dashboard - zumindest das Layout dafür ;).
---

# Exam 1 - HTML5 & CSS3
![task1](/images/task.png) - Einzelarbeit<br>
Erstelle mit Hilfe deines aktuellen Wissen eine neue Webseite. <br>
Sie soll nur die HTML-Elemente und das CSS-Styling besitzen. <br>
Die logischen Instrumente sind nicht nötig, da wir uns im nächsten Kurs mit Javascript/Typescript beschäftigen werden.
Verwende die HTML5 konformen Tags.

## RTM
Nachzubauen ist die neue Webseite vom RTM(login).<br>
Nachfolgend werden die einzelnen Komponenten erklärt. Es werden nur diverse Stylings gegeben, den Rest müsst ihr selber versuchen zu definieren. <br>
Zu unterst im File findet ihr noch diverse Hints, welche euch helfen könnten.<br>
Die Icons sind [hier](../icons/logos-rtm.zip) hinterlegt. <br>
![asset](../rtm_home_page.png)   

### Header
![asset](../rtm_header.png)   
|Was|Farbe|Logo|Grösse|Hover Farbe|
|--------|--------|--------|--------|--------|
|Hintergrundfarbe in Header|rgba(236,239,242,1);|-|height: 57.25px;|-|
|login Logo|-|login_logo.svg|width: 180px;|-|
|Text in Header|rgba(119,119,119,1);|-|-|-|
|Datum(Tag)|rgba(213,45,40,1);|-|-|-|
|Kommen Logo|-|kommen.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|
|Farbe untere Zeile Logo|rgba(255,0,0,1);|-|width: 250px;|rgba(255,255,255,1);|
|Uhr Logo|-|uhr.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|
|Pfeil (Menu Sprache) Logo|-|pfeil_unten.svg|-|rgba(255,255,255,1);|
|Refresh Logo|-|refresh.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|
|Personen Logo|-|persons.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|
|Profil Logo|-|profil.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|
|Logout Logo|-|logout.svg|width: 22px; height: 22px;|rgba(255,255,255,1);|

### Linke Sidenav
![asset](../rtm_left_sidenav.png)
|Was|Farbe|Logo|Grösse|Hover Farbe|
|--------|--------|--------|--------|--------|
|Hintergrund in Sidenav|rgba(0,158,195,1)|-|width: 180px;|rgba(0,100,128,1);|
|Profil Logo|-|profil.svg|width: 88px;height: 88px;|-|
|Abwesend Text|rgb(211, 47, 47);|-|-|-|
|Cockpit Logo|background: rgba(230,230,230,1);color: rgba(115,115,115,1);|cockpit.svg|width: 16px; height: 16px;|-|
|Personen Logo|-|persons.svg|width: 16px; height: 16px;|background: rgba(0,100,128,1);|
|Einsatzplan Logo|-|einsatzplan.svg|width: 16px; height: 16px;|background: rgba(0,100,128,1);|
|Abfragen Logo|-|abfragen.svg|width: 16px; height: 16px;|background: rgba(0,100,128,1);|
|Abfragen Pfeil Logo|-|pfeil_oben.svg|width: 9px; height: 14px;|rgba(0,100,128,1);|
|Palungsliste Logo|-|einsatzplan.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Tagesübersicht Logo|-|buchung.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Buchungsliste Logo|-|buchung.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Zeitwertliste Logo|-|buchung.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Saldoübersicht Logo|-|saldo.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Spesenauswertung Logo|-|buchung.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Auftragsauswertung Logo|-|buchung.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|
|Berichte Logo|-|drucken.svg|width: 16px; height: 16px;|rgba(0,100,128,1);|

### Rechte Sidenav
![asset](../rtm_right_sidenav.png)
|Was|Farbe|Logo|Grösse|Hover Farbe|
|--------|--------|--------|--------|--------|
|Hintergrund in Sidenav|rgba(255, 255, 255, 1);|-|width: 250px;|rgba(245, 245, 245, 1);|
|Anwesend Text|rgba(66,159,70,1);|-|-|-|
|Profil Logo|-|profil.svg|width: 35px; height: 35px;|-|
|Uhr Logo|-|clock.svg|width: 24px; height: 28px;|-|
|Abwesend Text|rgba(255,0,0,1);|-|-|-|
|Text allgemein|rgba(33,33,33,1);|-|-|-|

### Content
![asset](../rtm_content.png)
|Was|Farbe|Logo|Grösse|Hover Farbe|
|--------|--------|--------|--------|--------|
|Hintergrund in Content|background: rgb(243, 243, 243,1); color: rgba(33,33,33,1);|-|-|-|
|Bearbeiten Logo|-|edit.svg|width: 14px; height: 14px;|rgba(250, 250, 250, 1);|
|Plus Logo|(disabled)|plus.svg|color: lightgrey; width: 11px; height: 14px;|rgba(250, 250, 250, 1);|
|Pfeil-Unten Logo|(disabled)|pfeil_unten.svg|color: lightgrey; width: 9px; height: 14px;|rgba(250, 250, 250, 1);|
|Speichern Logo|(disabled)|save.svg|color: lightgrey; width: 12px; height: 14px;|rgba(250, 250, 250, 1);|
|Rückgängig Logo|(disabled)|undo.svg|color: lightgrey; width: 12px; height: 14px;|rgba(250, 250, 250, 1);|
|SBB Crackhead|rgba(217,230,242,1);|-|width: 716.5px; height: 180px;|rgba(224,231,235,1);|
|Profil Logo|-|profil.svg|width: 140px; height: 140px;|-|
|Ausrufezeichen Logos|-|request.svg|width: 24px; height: 24px;|-|
|Absenzen Text|rgb(33, 150, 243);|-|width: 352.75px; height: 180px;|-|
|Visum Text|rgb(16, 85, 192);|-|width: 352.75px; height: 180px;|-|
|Warnung Logo|-|warning.svg|width: 24px; height: 24px;|-|
|Warnung Text|rgb(219, 73, 216);|-|width: 352.75px; height: 180px;|-|
|Alarm Logo|-|alert.svg|width: 24px; height: 24px;|-|
|Alart Text|rgb(255, 67, 81);|-|width: 352.75px; height: 180px;|-|


![task1](/images/hint.png)    
    Hint: über allen hover-Elementen pointer<br>
    Schatten: box-shadow<br>
    Scrollleiste: overflow-y oder overflow-x<br>



## Sobald du fertig bist...
Wenn du fertig mit diesem Exam bist, zeige dein Resultat einem Coach. Nach dem Okay des Coaches kannst du mit  [JavaScript](../../../../docs/web/javascript/01_js_intro) beginnen. 