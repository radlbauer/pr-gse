# Zähler #

Erstellen Sie eine Klasse `Zaehler`, welche einen elektronischen Zähler repräsentiert, wie er z.B. in Ämtern verwendet wird:


Nach der Instanziierung hat der Zähler den Wert 0.

Bei jedem Aufruf der Methode `weiter()` wird er um 1 erhöht; wenn er allerdings dabei eine Obergrenze überschreiten würde (z.B. 25), dann wird er auf 0 zurückgesetzt.
Mit einer `set-`Methode kann ein beliebiger Wert zwischen 0 und Maximalwert eingestellt werden.


Mit einer `get-`Methode kann der aktuelle Wert des Zählers abgefragt werden.


<u>Zusatzaufgabe:</u> fügen Sie eine Methode `weiter(int n)` hinzu, mit der nicht nur um 1 sondern um einen beliebigen ganzzahligen Wert `n` weitergezählt wird. Der Aufruf `weiter(n)` soll den gleichen Effekt haben, wie wenn `n` Mal die Methode `weiter()` (ohne Parameter) aufgerufen wird.