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

- Schreibe Mockito-Tests für den Service, der die Schulfächer verwaltet (z.B. `SchulfachAdminService`).
- Ändere den Integrationstest zur Verwaltung von Schulfächern (z.B. `AdminControllerIntegrationTest`) zu einem `@WebMvcTest`.
- Schreibe einen `@DataJpaTest` respektive `@DataJdbcTest`, der das Repository zur Verwaltung von Schulfächern inklusive seiner Entities abdeckt.
- Schreibe einen `@SpringBootTest` als kompletten Integrationstest, der vom Controller-Aufruf mittels `MockMvc` bis auf die H2-DB “runter” geht. Teste, ob das Anlegen eines neuen Schulfachs funktioniert und ob die Daten persistiert werden.
