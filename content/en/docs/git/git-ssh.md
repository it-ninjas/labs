---
title: "SSH-Key in Git"
linkTitle: "SSH-Key in Git"
weight: 7
---

## Was ist ein SSH-Key
Ein SSH-Schlüssel (Secure Shell Key) ist eine kryptografische Identifikation, die in Git verwendet wird, um die sichere Kommunikation zwischen Ihrem lokalen Computer und einem Remote-Repository zu ermöglichen. 
Es besteht aus einem öffentlichen und einem privaten Schlüssel.

Der öffentliche SSH-Schlüssel wird auf dem Git-Server gespeichert, während der private Schlüssel lokal auf dem Computer gespeichert ist. 
Wenn man auf ein Remote-Repository zugreifen möchten, übermittelt der Computer den öffentlichen Schlüssel an den Server. Der Server verwendet dann diesen Schlüssel, um zu überprüfen, ob man tatsächlich berechtigt ist, auf das Repository zuzugreifen. 
Der private Schlüssel bleibt auf dem Computer und wird verwendet, um die Identität zu bestätigen, wenn man auf das Repository zugreift.

Der SSH-Schlüssel wird für mehrere Zwecke verwendet:

1. **Authentifizierung**: Statt jedes Mal Benutzername und Passwort eingeben zu müssen, wenn auf ein Repository zugreifen möchten, wird der SSH-Schlüssel verwendet, um die Identität zu bestätigen. 
Dies ist sicherer und bequemer als die Verwendung von Benutzername und Passwort.
2. **Sicherheit**: SSH-Schlüssel bieten eine robuste Sicherheit, da sie auf Public-Key-Kryptografie basieren. Dadurch ist es schwieriger für Angreifer, die Verbindung zu kompromittieren.
3. **Automatisierung**: Wenn man Skripte oder automatisierte Prozesse verwenden, um auf Git zuzugreifen, können SSH-Schlüssel verwendet werden, um den Zugriff ohne Benutzereingriff zu ermöglichen.


### SSH-Key erstellen
Um einen SSH-Schlüssel zu erhalten, können die folgenden Schritte befolgt werden:

1. Öffnen von Git Bash oder dem Terminal.
2. Den Befehl `ssh-keygen -t rsa -b 4096 -C "your_email@example.com"` eingeben und die Eingabetaste drücken. Ersetze `your_email@example.com` durch die E-Mail-Adresse, mit dem das Git-Konto verknüpft ist.
3. Man wird aufgefordert, den Speicherort für den SSH-Schlüssel anzugeben. Einfach die Eingabetaste drücken, um den Standardpfad zu akzeptieren.
4. Man wird auch aufgefordert, ein Passwort für den SSH-Schlüssel einzugeben. Es kann ein Passwort festgelegt werden oder einfach die Eingabetaste drücken, um ohne Passwort fortzufahren (nicht empfohlen, da dies die Sicherheit verringert).
5. Sobald der Schlüssel generiert ist, wird der Pfad zum öffentlichen und privaten Schlüssel angezeigt. Der öffentliche Schlüssel (`id_rsa.pub`) wird standardmäßig im Verzeichnis `~/.ssh/` erstellt.


Sobald der SSH-Schlüssel generiert wurde, muss der öffentlichen Schlüssel auf BitBucket hinzugefügt werden. Dort muss man auf "Konto verwalten" -> "SSH-Key" gehen, danach auf hinzufügen klicken. 
In das Textfeld für den Schlüssel wird der Inhalt der Datei `id_rsa.pub` eingefügt.

