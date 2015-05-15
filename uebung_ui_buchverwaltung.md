# Buchverwaltung mit Benutzerinteraktion #

Erstellen Sie eine zeilenorientierte Benutzerschnittstelle für die [diese Musterlösung](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/bibliothek) von der Übung [Bibliothek](uebung_arraylist_bibliothek.md).

Für das Einlesen von Informationen vom Benutzer verwenden Sie die Klasse [Input.java](http://pr-gse.googlecode.com/svn/trunk/vorgabe/src/eingabe/Input.java)

---


### Hauptmenü ###
Beim Start des Programms sowie nach jeder abgeschlossenen Aktion wird folgendes Menü gezeigt:
```
n) neues Buch anlegen
l) Bücher auflisten
a) Buch ausmustern
e) entlehnte Bücher auflisten
v) verfügbare Bücher auflisten
1) entlehnen
2) zurückgeben

```

Gibt der Benutzer einen der aufgelisteten Buchstaben ein, so wird die entsprechende Aktion ausgeführt:

---


### Buch anlegen ###
Der Benutzer wird zur Eingabe der Informationen für ein Buch aufgefordert, z.B.:
```
ISBN-Nummer: 3-8237-5005-4
Autor: H.Hobmair
Titel: Psychologie
Verlag: Stam
Seitenzahl: 512
```
Dann wird eine Buch-Instanz angelegt und in die Buchverwaltung aufgenommen.

---


### Bücher auflisten ###
Es wird eine Liste der Bücher in etwa folgendem Format ausgegeben:
```
ISBN		Autor			Titel				Verlag		entlehnt
1-6517-1234-4	Grimm			Schneewittchen			Reutters	ja
1-6517-4321-4	Karl Marx		Das Kapital			Dorner		nein
.....
```

---


### Buch ausmustern ###
Der Benutzer wird nach der ISBN-Nummer gefragt. Wird das Buch mit der eingegebenen Nummer in der Verwaltung gefunden, dann wird es ausgemustert, andernfalls erfolgt eine Fehlermeldung.

---


### Entlehnte / verfügbare Bücher auflisten ###
Funktioniert im Prinzip wie das Auflisten der Bücher. Vor der Liste wird noch die jeweilige Anzahl (entlehnte bzw. verfügbare Bücher angezeigt.

---


### Buch entlehnen / zurückgeben ###
Der Benutzer wird nach der ISBN-Nummer gefragt. Wird das Buch nicht in der Verwaltung gefunden, so erfolgt eine Fehlermeldung.

Beim Entlehnen muss geprüft werden, ob das Buch verfügbar ist. Falls ja, wird der Benutzer nach dem Kundennamen gefragt. Dieser wird dann eingetragen.

Beim Zurückgeben wird der aktuell eingetragene Kunde ausgegeben, dann wird das Buch zurückgegeben.