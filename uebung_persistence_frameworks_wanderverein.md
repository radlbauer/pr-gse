# Wanderverein #

Der Wanderverein "Fitwanderer" hat sich entschlossen, seine Mitglieder und seine Aktivitäten EDV-mäßig zu

erfassen und organisieren.
Dazu wird eine Applikation benötigt, die folgende Funktionalitäten umfasst:

### Mitgliederverwaltung ###

  * Mitgliedsdaten können erfasst, verändert und gelöscht werden:

> - Vorname

> - Nachname

> - Geburtsdatum

> - Adresse

> - Telefonnummer

> - E-Mail

> - Datum des Eintritts in den Verein

  * Die Mitglieder können aufgelistet werden

  * Es kann nach Mitgliedern gesucht werden (Beginn des Nachnamens)

  * Beim Start der Applikation werden die Mitglieder angezeigt, welche heute Geburtstag haben.

  * Es können alle Mitglieder aufgelistet werden, welche schon über eine gewisse Anzahl von Jahren Mitglieder

des Vereins sind.


### Aktivitätenverwaltung ###

  * Es können die Daten für geplante Aktivitäten erfasst und verändert werden:

> - Bezeichnung der Aktivität (z.B. Wanderung nach Mariazell)

> - Veranstalter (ein Mitglied des Vereins)

> - Datum und Uhrzeit

> - Treffpunkt (Ort)

> - Dauer

> - Status (ok / abgesagt)

  * Alle zukünftigen Aktivitäten können aufgelistet werden.

  * Alle Aktivitäten innerhalb eines vorgegebenen Zeitraums können aufgelistet werden.

  * Beim Start der Applikation wird die nächste Aktivität angezeigt.



### Anmeldung ###

  * Es können Mitglieder des Vereins für eine Veranstaltung angemeldet werden.

  * Eine Anmeldung kann auch wieder storniert werden.



## Aufbau der Applikation ##

Die Applikation wird mit Java erstellt.

Die Datenhaltung erfolgt mittels einer MySQL-Datenbank. Die Anbindung erfolgt mit EclipseLink.
Die Applikation soll so erstellt werden, dass ein Umstieg auf ein anderes Datenbanksystem bzw. ein anderes

Persistenz-Framework möglichst ohne Änderungen im Java-Code möglich ist.

Die Oberfläche wird mit SWING erstellt. Es ist geplant, später auch einen WEB-Zugriff anzubieten. Daher sind die Fach- und Persistenzologik so zu erstellen, dass eine WEB-Anbindung ohne größere Änderungen möglich ist.