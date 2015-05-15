# Internet-Abstimmung #

Für eine Abstimmung per Internet wird die Datenbanktabelle STIMMEN eingerichtet:

| ID: | int (Auto-increment) | Primärschlüssel |
|:----|:---------------------|:------------------|
| ZEIT: | datetime |	Zeitpunkt der Abstimmung |
| ZUSTIMMUNG: | bool | ja oder nein |

_(Diese Tabelle können sie mit dem Script abstimmung.sql einrichten.)_

Erstellen Sie basierend auf dieser Tabelle die folgende Web-Applikation:

Beim Aufruf der Applikation erscheint eine Seite, auf der das bisherige Abstimmungsergebnis in Prozent angeführt ist. Außerdem kann der Benutzer selbst seine Stimme abgeben:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/internet_abstimmung/index.jpg' />
</p>

Klickt der Benutzer nun auf „Abstimmen“ dann wird ein neuer Datensatz in die Tabelle STIMMEN eingetragen und es erscheint die folgende Seite, auf welcher die bisherigen Stimmen auch in absoluten Zahlen angegeben sind:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/internet_abstimmung/danke.jpg' />
</p>