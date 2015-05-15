# Kontaktliste #

Erstellen Sie die folgenden Klassen zur Verwaltung von Kontakten:


<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/kontakt.jpg' />
</p>

Für jeden `Kontakt` werden folgende Daten verwaltet:

  * `name`: darf nicht leer sein
  * `email`: Email-Adresse; muss das Zeichen '@' enthalten
  * `tel`: Telefonnummer; optional ein führendes '+', dahinter nur Ziffern

In den `set`-Methoden ist dafür zu sorgen, dass diese Wertebereiche eingehalten werden.
Falls ein ungültiger Wert übergeben wird, wird eine `KontaktException` ausgelöst.

Die Methode `toString()` liefert einen String, in dem die Werte aller Attribute enthalten sind.

In einer `KontaktListe` werden mehrere `Kontakt`-Instanzen verwaltet.

Mit der Methode `add(...)` wird ein neuer `Kontakt` eingefügt.

Die Methode `toString()` liefert einen String, welcher eine Liste der Kontakte enthält.

Die Methode `sortieren(...)` sortiert nach dem übergebenen Kriterium. Als Kriterien sind folgende Strings erlaubt: "name", "email", "tel". Wird etwas anderes übergeben, dann wird ebenfalls eine `KontaktException` ausgelöst.


---


Kopieren Sie die Klasse [`Input`](http://pr-gse.googlecode.com/svn/trunk/vorgabe/src/eingabe/Input.java) und fügen Sie eine Klassenmethode
```
public static Kontakt readKontakt()
```
ein.
Diese liest alle Daten für einen Kontakt vom Benutzer ein, erstellt damit eine `Kontakt`-Instanz und liefert eine Referenz darauf als Rückgabewert.
Alle Exceptions sollen so behandelt werden, dass der Benutzer noch einmal aufgefordert wird, die entsprechenden Daten einzugeben.