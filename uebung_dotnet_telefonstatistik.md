# Telefonstatistik #

Ein Netzbetreiber schickt seinen Kunden monatlich eine CSV-Datei, welche seine Verbindungsdaten enthält:

Jede Zeile der Datei enthält einen Datensatz mit folgenden Feldern (jeweils getrennt durch Tabulator):

  * Datum - TT.MM.JJJJ
  * Uhrzeit (Beginn) - hh:mm:ss
  * Dauer - hh:mm:ss
  * Typ (Festnetz, Mobilfunk, sonstiges)
  * Rufnummer
  * Kosten

Hier können Sie 2 solche Dateien herunterladen:

> [Anrufe1.csv](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/Anrufe1.csv)

> [Anrufe2.csv](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/Anrufe2.csv)


Erstellen Sie ein C#-Programm mit WPF-Oberfläche, welches folgende Funktionalität anbietet:

### Menus ###

Im Menu `Datei` gibt es folgende Einträge:

  * `neu` - es wird eine neue Telefonstatistik erstellt; davor wird der Benutzer gefragt, ob er die aktuelle Statistik speichern will.
  * `öffnen` - eine früher abgespeicherte Telefonstatistik wird geladen.
  * `CSV hinzufügen` - eine CSV-Datei im oben beschriebenen Format wird eingelesen, und die Datensätze werden der aktuellen Telefonstatistik hinzugefügt.
  * `speichern` - die aktuelle Statistik wird gespeichert.
  * `beenden` - das Programm wird beendet; davor wird der Benutzer gefragt, ob er die aktuelle Statistik speichern will.

Im Menu `Anzeigen` gibt es den Eintrag `Liste`. Dieser ist weiter unten beschrieben.

### Aufbau der Oberfläche ###

Die Oberfläche enthält eine Liste aller angerufenen Telefonnummern. Darin kommt jede Nummer nur ein Mal vor. Neben der Nummer steht die Anzahl der Anrufe zur jeweiligen Nummer. Der Benutzer kann auswählen, wonach die Nummern sortiert werden:
  * nach Nummer
  * nach Anzahl der Anrufe zu dieser Nummer.

### Statistik ###

Wird eine Nummer in der Liste ausgewählt, dann erscheint in einem anderen Bereich der Oberfläche eine Statistik für die ausgewählte Nummer. Diese hat folgenden

Inhalt:

  * Anzahl der Anrufe zu dieser Nummer
  * Gesamtdauer der Anrufe zu dieser Nummer
  * Gesamtkosten der Anrufe zu dieser Nummer
  * Durchschnittliche Dauer der Anrufe zu dieser Nummer
  * Details des längsten Anrufes zu dieser Nummer
  * Details des teuersten Anrufes zu dieser Nummer

Ein weiterer Bereich der Oberfläche enthält eine Gesamtstatistik mit folgendem Inhalt:

  * Gesamtanzahl aller Anrufe
  * Gesamtdauer aller Anrufe
  * Gesamtkosten aller Anrufe
  * Durchschnittliche Dauer aller Anrufe
  * Details des längsten Anrufes
  * Details des teuersten Anrufes

### Detail-Liste ###
Bei Betätigung des Menus `Anzeigen - Liste` wird ein zusätzliches Fenster geöffnet, in welchem alle Anrufe zur aktuell ausgewählten Nummer aufgelistet sind.

### Aufbau der Applikation ###

Die Applikation ist sauber mit Schichtentrennung und entsprechendem Exception-Handling aufzubauen (GUI - Fachlogik - Dateianbindung).

Alle Fehler sind mit einer entsprechenden Fehlermeldung an den Benutzer zu behandeln.

Die vom WPF unterstützte Datenbindung ist anzuwenden.