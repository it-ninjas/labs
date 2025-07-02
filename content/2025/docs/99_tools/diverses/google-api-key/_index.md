---
title: "Google API Key"
linkTitle: "Google API Key"
weight: 1
description: >
  Für Übungen, welche API's von Google verwenden. Nur bei Bedarf.
---

## Ziele

- Du kannst ein Google-Konto erstellen.
- Du kannst dich im Google Developer Portal anmelden.
- Du kannst einen API Key für die Custom Search API generieren.
- Du weißt, wie du den API Key sicher speicherst.

{{< zeit lesen="10" praxis="15">}}

---

## Google API Key erstellen

Die folgenden Schritte leiten dich durch den Prozess um einen API Key für die Google APIs zu erhalten.

{{< ninja warning>}}
Behandle den Key vertraulich. Er sollte nicht in einem Git-Repository gespeichert werden. [Hier](../../ide/intellij/05_secrets/) erfährst du, wie du es in unseren Übungen machen kannst.
{{< /ninja>}}

1. Öffne [https://developers.google.com/?hl=de](https://developers.google.com/?hl=de)

2. Melde Dich oben rechts an
   ![Anmelden](./images/konto.png)

3. Erstelle ein neues Konto

   Falls du bereits ein Konto hast, welches Du benutzen willst, kannst Du die nachfolgenden Schritte überspringen

   ![Konto erstellen](./images/anmelden.png)

   ![Konto erstellen für die Arbeit](./images/fuerArbeit.png)

   ![Gmail-Adresse anfordern](./images/kostenlos.png)

   ![Vorname](./images/name.png)

   ![Angaben](./images/angaben.png)

   Du kannst dir eine neue Email Adresse erstellen (nicht empfohlen)...

   ![Neue Email](./images/neueEmail.png)

   oder eine bestehende Email Adresse nehmen (empfohlen)

   {{< sbb >}}
   Nimm deine Email Adresse von SBB (vorname.name@sbb.ch)
   {{< /sbb >}}

   ![Bestehende Email](./images/bestehendeEmail.png)

   ![Code eingeben](./images/emailCode.png)

   ![Passwort](./images/newPassword.png)

   ![Telefon Nummer](./images/telefonNummer.png)

   ![Prüfen](./images/pruefen.png)

   ![Einstellungen](./images/einstellungen1.png)

   ![EULA](./images/einstellungen2.png)

   ![Bestätigen](./images/einstellungen3.png)

   ![Datenschutz](./images/einstellungen4.png)

   ![Jetzt nicht](./images/einstellungen5.png)

4. Auf [https://developers.google.com/?hl=de](https://developers.google.com/?hl=de) Developers Program als Student

   ![Developer Program](./images/developerProgram.png)

   ![Student](./images/developerProgramRegister.png)

   ![Kein Premium](./images/upgradeToPremium.png)

5. API Key anfordern

   https://developers.google.com/custom-search/v1/overview?hl=de

   ![Api-Key anfordern](./images/requestApiKey.png)

   ![Enable Custom Search API](./images/enableCustomSearchApi.png)

   ![Show Key](./images/showKey.png)

   {{< ninja warning>}}
   Den Key kopieren und sicher ablegen. Nicht ins Git-Repository. Vertraulich behandeln! [Hier](../../ide/intellij/05_secrets/) erfährst du, wie du es in unseren Übungen machen kannst.
   {{< /ninja >}}
