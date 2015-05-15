# Anmeldesystem für Fachhochschule #

Das Anmeldesystem ermöglicht es den Studenten einer Fachhochschule sich selbst per Internet für Kurse auf der Fachhochschule anzumelden.

Das Datenmodell für das Anmeldesystem sieht folgendermaßen aus:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/fachhochschule.png' />
</p>

Die Datenbank kann mit dem Script [fachhochschule.sql](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/fachhochschule.sql) erstellt werden (getestet mit MySQL).

Jeder Kurs hat einen eindeutigen Code (Primärschlüssel). Weiters werden erfasst: der Titel des Kurses, Beginn und Ende des Kurses und die Anzahl der verfügbaren Plätze.

Jeder Student hat eine eindeutige ID (Primärschlüssel, Auto-Wert). Weiters werden erfasst: der Name, die Adresse, die Telefonnummer, und ein Kennwort für die Anmeldung ans System (nicht verschlüsselt).

Jede Anmeldung hat eine eindeutige Nummer (Primärschlüssel, Auto-Wert). Weiters werden der Code des Kurses, für den die Anmeldung gilt, und die ID des Studenten, der sich anmeldet, erfasst (Fremdschlüsseln).

## Aufgabenstellung ##

Zu dieser Datenbank ist  die entsprechende Verwaltungs- und Anmeldungsapplikation zu erstellen. Sie besteht aus zwei Teilen:

Das Administrations-Modul wird als Java-Swing-Applikation realisiert und umfasst die Funktionalität zum Verwalten von Kursen und Studenten.

Das Anmeldemodul wird als Java-WEB-Applikation realisiert und bietet den Studenten die Möglichkeit, sich selbst für Kurse anzumelden.

Im Folgenden werden die einzelnen Komponenten im Detail beschrieben.


### Administrations-Modul ###

Das Modul ist für Administratoren gedacht. Mit dieser Java-Swing-Applikation sind folgende Tätigkeiten möglich:

  * Eintragen der Kurse:
    * Auflisten aller vorhandenen Kurse: Nummer und Titel
    * Anzeigen der Details für einen Kurs: Nummer, Titel, Beginn, Ende, Anzahl der verfügbaren Plätze.
    * Eintragen eines neuen Kurses: Der Administrator gibt in einer Maske alle Details für einen neuen Kurs ein. Falls schon ein Kurs mit diesem Code existiert, wird beim Speichern eine entsprechende Fehlermeldung angezeigt. Ansonsten wird der Kurs als neuer Datensatz eingetragen.

  * Verwalten der Studenten:
    * Erstellen eines neuen Studenten-Eintrags: Der Anwender gibt in einer Maske alle Details (ausgenommen ID) für einen neuen Studenten ein und erhält nach dem Abspeichern eine Bestätigung mit der (automatisch generierten) ID des neu angelegten Studenten.


### Anmelde-Modul ###

Mit diesem WEB-Modul haben die Studenten die Möglichkeit, sich selbst für einen Kurs anzumelden:

  * Im ersten Schritt muss sich der Student mit ID und Kennwort anmelden.
  * Nach erfolgreicher Anmeldung werden automatisch die Daten des Studenten sowie alle verfügbaren Kurse angezeigt.
  * Anmeldung für einen Kurs: Der Student wählt einen Kurs aus und schickt die Anfrage für die Anmeldung ab. Das System muss verhindern, dass sich für einen Kurs mehr Studenten anmelden werden als Plätze verfügbar sind. Außerdem ist zu verhindern, dass ein Student sich für mehrere Kurse anmeldet, welche zur selben Zeit stattfinden (sich überschneiden). Nach erfolgreicher Anmeldung erhält der Student eine Bestätigung mit der (automatisch generierten) Anmeldenummer. Ist kein Platz mehr verfügbar oder würden sich Kurse zeitlich überschneiden, dann wird eine entsprechende Fehlermeldung angezeigt.
