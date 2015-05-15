# Konto mit Buchungen #

Erstellen Sie die folgenden Klassen `Konto` und `Buchung`, welche dazu dienen, die Buchungen für ein Konto zu verwalten:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/KontoBuchung.jpg' />
</p>



### Klasse `Buchung` ###
Jede `Buchung` besteht aus einem Betrag, welcher positiv (Einzahlung) oder negativ (Auszahlung) sein kann, und einem Buchungstext. Beides wird im Konstruktor als Parameter übergeben. Der Buchungstext darf nicht leer sein, ansonsten erfolgt eine Fehlermeldung und der Text wird auf den Wert `„unbekannt“` gesetzt. Für beide Attribute gibt es eine `get`-Methode

### Klasse `Konto` ###
Jedes Konto hat eine Nummer. Diese wird im Konstruktor als Parameter übergeben. Sie muss positiv sein. Ansonsten erfolgt eine Fehlermeldung und die Nummer wird auf den Wert 0 gesetzt. Es gibt eine `get`-Methode für die Nummer.

Im Attribut `buchungen` werden die Buchungen für das Konto verwaltet. (Entscheiden Sie selbst, ob Sie dafür ein Array verwenden oder eine Instanz der Klasse `ArrayList`!)

Folgende Methoden sind zu implementieren:
  * `einzahlen(…)`: der eingezahlte Betrag und der Buchungstext werden als Parameter übergeben. Daraus wird eine neue `Buchung`-Instanz erstellt und in die Verwaltung übernommen. (Der übergebene Betrag muss positiv sein, ansonsten erfolgt eine Fehlermeldung.)
  * `auszahlen(…)`: der ausgezahlte Betrag und der Buchungstext werden als Parameter übergeben. Daraus wird eine neue `Buchung`-Instanz erstellt (Betrag negativ eingetragen) und in die Verwaltung übernommen. (Der im Parameter übergebene Betrag muss positiv sein, ansonsten erfolgt eine Fehlermeldung.) Beim Auszahlen muss darauf geachtet werden, dass der Saldo (Summe aller Buchungsbeträge) niemals negativ werden darf. Das Konto darf also nicht überzogen werden. Andernfalls wird die Buchung nicht durchgeführt, und es erfolgt eine Fehlermeldung.
  * `saldo()`: der aktuelle Saldo wird berechnet und als Rückgabewert geliefert. Der Saldo ist die Summe aller Buchungsbeträge.
  * `auszug()`: es wird ein Kontoauszug auf die Konsole ausgegeben: alle Buchungen in der Reihenfolge, in der sie ein- oder ausgezahlt wurden. Vor jeder Buchung steht die Buchungsnummer (Nummerierung beginnend bei 1). Beispiel:
```
    1	Gehalt		2130.90
    2	Überweisung	-230.99
    2	Versicherung	-133.33
    ...
```
  * `summeEin()`: die Summe aller Einzahlungen wird berechnet und als Rückgabewert geliefert.
  * `maxAus()`: die Methode sucht die `Buchung` jener Auszahlung mit dem größten Betrag. Eine Refererenz auf diese `Buchung` wird als Rückgabewert geliefert.
  * `stornieren(…)`: die `Buchung`  mit der übergebenen Nummer wird storniert (aus der Verwaltung gelöscht). Die Nummerierung der Buchungen beginnt bei 1.
  * anzahl(): liefert die Anzahl der Buchungen als Rückgabewert.
