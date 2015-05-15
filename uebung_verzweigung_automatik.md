# Auto mit Automatikgetriebe #

Wir wollen ein Rennfahr-Computerspiel mit einem Auto ausstatten, welches ein Automatikgetriebe besitzt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/automatik.jpg' />
</p>

In den Attributen merken wir uns das Kennzeichen, die aktuelle Motordrehzahl und den aktuellen Gang.

Dem Konstruktor muss man ein Kennzeichen als Parameter übergeben. Außerdem initialisiert der Konstruktor die Drehzahl mit dem Wert 1000 und den Gang mit 0.

Für das Attribut `kennzeichen` gibt es auch eine get- und eine set-Methode.

Die Geschwindigkeit berechnet sich folgendermaßen(`berechneGeschwindigkeit()`):

> Geschwindigkeit = Gang x Drehzahl / 200.

Für `gang` und `drehzahl` gibt es nur get-Methoden. Die Werte dieser Attribute verändern sich beim `beschleunigen()` und `bremsen()`:

Ein Aufruf der Methode `beschleunigen()` bewirkt eine Erhöhung der Drehzahl um 1000. Liegt danach die Drehzahl bei 6000 oder darüber, dann schaltet das Getriebe automatisch auf den nächsthöheren Gang. Bei jedem Schaltvorgang bleibt die Geschwindigkeit konstant; d.h. die Drehzahl wird wieder entsprechend reduziert.
Ist der Gang noch auf 0, so bewirkt ein Aufruf von `beschleunigen()`, dass der Gang auf 1 geschaltet wird (Drehzahl bleibt in diesem Fall unverändert).

Das Automatikgetriebe hat 5 Gänge. Danach kann noch beschleunigt werden, bis die Drehzahl 8000 erreicht ist, dann ist die Maximalgeschwindigkeit erreicht. Ein weiteres Beschleunigen bleibt dann wirkungslos.

Ein Aufruf der Methode `bremsen()` bewirkt eine Reduzierung der Drehzahl auf die Hälfte. Wird die Drehzahl 1000 erreicht oder unterschritten, dann schaltet das Getriebe automatisch auf den nächstniedrigeren Gang. Beim Hinunterschalten bleibt ebenfalls die Geschwindigkeit konstant (außer wenn der Gang 0 erreicht wurde); d.h. die Drehzahl wird wieder entsprechend erhöht.

Sobald der Gang 0 erreicht ist steht das Auto. Ein weiteres Bremsen bleibt dann wirkungslos.