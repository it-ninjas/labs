---
title: "Spring Boot Testing - Aufgaben"
linkTitle: "Spring Boot Testing - Aufgaben"
type: docs
weight: 2
description: >
  Testen der Spring Boot Applikation für die Notenverwaltung aus Modul #J8
---

## Aufträge

Erweitere/Korrigiere deine Tests aus den [Spring und Spring Boot Aufgaben](./01_spring/) wie folgt:

- Schreibe Mockito-Tests für den _AdminService_.
- Ändere den _AdminControllerIntegrationTest_ zu einem WebMvcTest.
- Schreibe einen DataJpaTest, der das _StudentRepository_ inkl. _SchoolSubject_ (evtl. hast du einen anderen Namen) abdeckt.
- Schreibe einen SpringBootTest als kompletten Integrationstest, der vom Controller-Aufruf mittels MockMvc bis auf die H2-DB "runter" geht. Teste, ob das Anlegen eines neuen Schulfachs funktioniert und ob die Daten persistiert werden.

