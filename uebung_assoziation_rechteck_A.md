# Rechteck (A) #

Für ein Zeichenprogramm werden die Koordinaten von Objekten in Pixeln ausgehend von der linken oberen Ecke der Zeichenfläche angegeben:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/rechteck/koordinaten.gif' />
</p>

Erstellen Sie die beiden Klassen `Punkt` und `Rechteck`, welche als Objekte für das Zeichenprogramm verwendet werden könnten (auch wenn sie nicht wirklich gezeichnet werden).

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/rechteck/uml.jpg' />
</p>

### Klasse `Punkt` ###

In den Attributen werden die Koordinaten des Punktes gespeichert.

Ein Konstruktor bekommt als Parameter die Koordinaten des Punktes übergeben.

Ein zweiter Konstruktor bekommt eine Referenz auf eine andere `Punkt`-Instanz übergeben und kopiert dessen Koordinaten.

Es gibt `get`-Methoden für x- und y-Koordinaten.

Die Methode `verschieben(…)` bekommt die Anzahl der Pixel übergeben, um wie viel der Punkt horizontal und vertikal verschoben wird.

### Klasse `Rechteck` ###

In den Attributen werden die linke obere Ecke des Rechtecks sowie die Länge und die Breite gespeichert.

Der Konstruktor bekommt Länge und Breite übergeben. Als linke obere Ecke wird der Punkt (0,0) angenommen.

Die Methode `setLinksOben(…)` setzt den Punkt für die linke obere Ecke.

Die Methode `berechneUmfang()` liefert den Umfang des Rechtecks als Rückgabewert.

Die Methoden `horizontalVerschieben(…)` und `vertikalVerschieben(…)` verschieben das Rechteck um die übergebene Anzahl von Pixeln.

Die Methode `enthaelt(…)` liefert `true`, wenn der übergebene Punkt innerhalb des Rechtecks liegt, ansonsten `false`.