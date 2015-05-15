# Zeiterfassungssystem #

Die DELTA Ges.m.b.H. hat den Auftrag bekommen, für einen mittleren Betrieb mit derzeit 15 Mitarbeiter/inne/n ein Zeiterfassungssystem zu implementieren.

Es besteht aus einem Frontend – eine WEB-Applikation – zum Erfassen der Zeiten, und einem Backend – ein klassisches Graphisches User Interface (GUI) – zum Verwalten der Mitarbeiterdaten.


### Daten ###

Als Datenbanksystem verwendet der Betrieb MySQL. Es sind für jede/n Mitarbeiter/in folgende Stammdaten zu erfassen:
  * die Mitarbeiternummer
  * der Name
  * ein Kennwort für die Anmeldung an das System (unverschlüsselt)
  * das Beschäftigungsausmaß (die normale Vollbeschäftigung beträgt 40 Stunden pro Woche)

Für jedes Kommen (Anmelden)  und Gehen (Abmelden) wird jeweils ein Zeitstempel erfasst.  Es werden keine Überstundenzuschläge berechnet, so dass alle Anwesenheits-Zeiten 1:1 in ein Zeitkonto aufgenommen werden und lediglich der daraus berechnete Zeit-Saldo relevant ist.

> ### Frontend ###

Das Frontend wird als Java WEB-Applikation mit Servlets und Java Server Pages (JSP) implementiert, so dass die Mitarbeiter/innen im Intranet jeweils ihr Kommen oder Gehen dokumentieren können. Es steht ein Apache Tomcat Server zur Verfügung.

Im ersten Schritt muss sich ein/e Mitarbeiter/in mit Mitarbeiternummer und Kennwort am System anmelden.
Nach erfolgreichem Login sieht die/der Mitarbeiter/in eine Seite mit folgendem Inhalt:
  * Mitarbeitername und -nummer
  * eine Liste der An- und Abmeldezeiten der aktuellen Woche
  * Zeit-Saldo der aktuellen Woche (Differenz zwischen Anwesenheitszeiten und Beschäftigungsausmaß)
  * eine Schaltfläche zum An- bzw. Abmelden (entsprechend dem letzten Eintrag: wenn der letzte Eintrag eine Anmeldung war, ist die Abmelde-Schaltfläche sichtbar und umgekehrt)

Wenn die/der Mitarbeiter/in die An- bzw. Abmelde-Schaltfläche betätigt, wird ein entsprechender Zeitstempel erfasst.


### Backend ###

Das Backend wird als Java Desktop-Applikation mit SWING-Oberfläche realisiert. Sie bietet die folgende Funktionalität:
  * Erfassen der Daten einer/s Mitarbeiters/in
  * Auflisten der An- und Abmeldezeiten der aktuellen Woche (siehe Frontend)
  * Anzeigen des Zeit-Saldos der aktuellen Woche (siehe Frontend)

### Realisierung ###

Sie sind sowohl für die Planung des Aufbaus der Datenbank und der Applikation als auch für die Realisierung verantwortlich. Dabei sind jedoch folgende Richtlinien zu beachten:
  * Es ist auf Bedienerfreundlichkeit zu achten.
  * Mögliche Fehlerfälle müssen mit entsprechenden Meldungen an den Anwender behandelt werden.
  * Bei den Datenbank-Zugriffen ist auf Performance und Sicherheit zu achten (Öffnen und Schließen der Datenbankverbindung, parametrierte Statemtents verwenden, unnötige Datenbankzugriffe vermeiden, Inkonsistenzen vermeiden)
  * Konzepte aus dem Unterricht sind nach Möglichkeit anzuwenden.