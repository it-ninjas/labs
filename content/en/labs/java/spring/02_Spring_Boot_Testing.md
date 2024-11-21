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

- Schreibe Mockito-Tests für den `AdminService` (JDBC) respektive `SubjectService`(JPA).
- Ändere den `AdminControllerIntegrationTest` (JDBC) respektive `AdminSubjectTests` (JPA) zu einem `@WebMvcTest`.
- Schreibe einen `@DataJpaTest`, der das `AdminRepository` inkl. `SchoolSubject` (JDBC) respektive `SubjectRepository` inkl. `Subject` (JPA) (evtl. hast du auch andere Namen) abdeckt.
- Schreibe einen `@SpringBootTest` als kompletten Integrationstest, der vom Controller-Aufruf mittels `MockMvc` bis auf die H2-DB “runter” geht. Teste, ob das Anlegen eines neuen Schulfachs funktioniert und ob die Daten persistiert werden.

Tipp: Du musst bei den jeweiligen Aufgaben natürlich nur entweder JDBC- **oder** JPA- Tests umsetzen, abhängig davon, wie du deine Notenverwaltung umgesetzt hast.
