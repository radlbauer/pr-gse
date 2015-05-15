# Folgenschreiber #

Erstellen Sie die folgende Klasse `FolgenSchreiber`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/folgen.jpg' />
</p>

Objekte dieser Klasse dienen dazu, mit den verschiedenen Methoden jeweils eine Folge von Zahlen auf die Konsole auszugeben.

Das Attribut `anzahl` gibt an, wie viele Folgenglieder jeweils auszugeben sind. Im Standardkonstruktor wird `anzahl` auf den Wert 10 gesetzt. Dem zweiten Konstruktor wird `anzahl` als Parameter übergeben.

Für das Attribut `anzahl` gibt es eine `get-` und eine `set-`Methode. Im 2. Konstruktor und in der `set-`Methode ist abzusichern, dass `anzahl` größer als 0 ist.

### Methoden ###
  * `einfach()`: gibt die Zahlen von 1 bis `anzahl` aus:
```
1 2 3 4 5 6 7 8 9 10
```
  * `umgekehrt()`: gibt die Zahlen von `anzahl` bis 1 aus:
```
10 9 8 7 6 5 4 3 2 1 
```
  * `summe()`: bildet die Summe der Zahlen von 1 bis `anzahl`; dabei wird jede Zwischensumme ausgegeben:
```
1 3 6 10 15 21 28 36 45 55 
```
  * `faktorielle()`: bildet das Produkt der Zahlen von 1 bis `anzahl`; dabei wird jedes Zwischenprodukt ausgegeben:
```
1 2 6 24 120 720 5040 40320 362880 3628800 
```
  * `fibonacci()`: gibt die ersten `anzahl` Glieder der [Fibonacci-Folge](http://de.wikipedia.org/wiki/Fibonacci-Folge) aus:
```
0 1 1 2 3 5 8 13 21 34
```
  * `primzahlen()`: gibt die ersten `anzahl` Primzahlen aus:
```
1 2 3 5 7 11 13 17 19 23
```
  * `alleFolgen()`: gibt alle Folgen aus (ruft die anderen Methoden auf) und schreibt davor jeweils eine Beschreibung:
```
Zahlen von 1 bis 10: 1 2 3 4 5 6 7 8 9 10 
Zahlen von 10 bis 1: 10 9 8 7 6 5 4 3 2 1 
Summen von 1 bis 10: 1 3 6 10 15 21 28 36 45 55 
Produkte von 1 bis 10: 1 2 6 24 120 720 5040 40320 362880 3628800 
Die ersten 10 Fibonacci-Zahlen: 0 1 1 2 3 5 8 13 21 34 
Die ersten 10 Primzahlen: 1 2 3 5 7 11 13 17 19 23 
```