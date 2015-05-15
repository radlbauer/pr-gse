# MP3-Verwaltung #

Erstellen Sie für die Verwaltung von MP3s die folgenden Klassen `PlayList` und `Song`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/PlayList.jpg' />
</p>


### Klasse Song ###

Für jeden `Song` werden folgende Daten erfasst (Attribute):

> `titel` – dieser wird dem Konstruktor als Parameter übergeben. Der Titel darf nicht leer sein. Falls ein Leerstring übergeben wird, erfolgt eine Fehlermeldung und der Titel wird auf den Wert „unbekannt“ gesetzt.

> `dauer` – in Sekunden; Standardwert: 600

> `groesse` – in MB; Standardwert: 100

Für jedes Attribut gibt es eine `get`-Methode, für `dauer` und `groesse` gibt es auch eine set-Methode.

### Klasse PlayList ###

In einer Instanz der Klasse `PlayList` wird eine `liste` von `Song`-Instanzen verwaltet. (Entscheiden Sie selbst, ob Sie für das Attribut `liste` ein Array oder eine Instanz der Klasse `ArrayList` verwenden!)

Jede `PlayList` hat auch eine `bezeichnung`. Der Wert für dieses Attribut wird dem Konstruktor als Parameter übergeben. `bezeichnung` darf nicht leer sein. Falls ein Leerstring übergeben wird, erfolgt eine Fehlermeldung, und es wird der Standardwert „unbekannt“  gesetzt.

Die Klasse `PlayList` bietet folgende Methoden an:

  * eine `get`-Methode für das Attribut `bezeichnung`
  * `einfuegen(…)`: nimmt einen `Song` in die Verwaltung auf. Der `Song` wird nicht eingefügt, falls schon ein `Song` mit dem gleichen Titel vorhanden ist, oder falls die Gesamtgröße aller Songs 750 MB überschreiten würde. In diesen Fällen erfolgt eine entsprechende Fehlermeldung.
  * `loeschen(…)`: der `Song` mit dem entsprechenden Index wird aus der Liste entfernt (die Nummerierung beginnt bei 0). Falls ein ungültiger Index übergeben wird, erfolgt eine Fehlermeldung.
  * `gesamtDauer()`: berechnet die Gesamtdauer aller Songs in der `PlayList` und liefert diese als Rückgabewert.
  * `liste()`: gibt die Song-Liste in folgendem Format auf die Konsole aus: Index, Größe, Dauer, Titel – Beispiel:
```
0	150	1000	Song 1
1	50	200	Song 2
2	450	3000	Song 3
```
  * `suchen(…)`: sucht den `Song` mit dem übergebenen Titel in der `PlayList`. Falls er gefunden wird, liefert der Rückgabewert eine Referenz auf die entsprechende `Song`-Instanz, ansonsten `null`.
  * `laengerAls(…)`: liefert die Anzahl der Songs in der `PlayList`, bei welchen die Dauer größer ist als der übergebene Wert.