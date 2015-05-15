# Fuhrpark #

Eine Transportfirma in Spengerland benötigt für die Berechnung der Steuern ein Fahrzeugverwaltungsprogramm. Das Design für dieses Programm sieht folgendermaßen aus:

Die Klasse `Fuhrpark` verwaltet verschiedene Arten von Fahrzeugen: LKW, Busse und PKW.
Die Fahrzeugsteuern in Spengerland berechnen sich folgendermaßen:
  * Für einen LKW bezahlt man einen Fixbetrag von € 500 plus € 10 pro Tonne Nutzlast.
  * Für einen Bus bezahlt man einen Fixbetrag von € 800 plus € 5 pro Sitzplatz.
  * Für einen PKW bezahlt man einen Fixbetrag von € 200.

Erstellen Sie die folgenden Klassen:

### Klasse Fuhrpark ###

dient zur Verwaltung von Fahrzeugen. Diese enthält im Wesentlichen eine Methode zum Aufnehmen eines Fahrzeuges in die Verwaltung und eine Methode zur Berechnung der Steuersumme über alle Fahrzeuge. Außerdem soll eine Methode zur Ausgabe einer Liste aller Fahrzeuge mit Kennzeichen und der jeweils zu bezahlenden Steuer zur Verfügung stehen.

### Fahrzeugklassen ###

Je eine Klasse für die verschiedenen Fahrzeugarten;

enthalten im Wesentlichen Attribute für das Kennzeichen und für die nötigen Kenngrößen, um die Steuer zu berechnen sowie zugehörige `get`- und `set`-Methoden (Nutzlast für LKW, ....)

Es soll dann möglich sein, eine Instanz der Klasse `Fuhrpark` und mehrere Instanzen der verschiedenen Fahrzeug-Klassen zu erstellen, die jeweiligen Attribute zu setzen und an die `Fuhrpark`-Klasse zu übergeben.

Mit Hilfe der entsprechenden Methoden der `Fuhrpark`-Klasse kann man dann die Gesamtsteuer berechnen bzw. eine Fahrzeugliste ausgeben.


### Lösungsansatz ###

In diesem UML-Klassendiagramm sind die `get`- und `set`-Methoden nicht angeführt.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/fuhrpark.jpg' />
</p>

`Fahrzeug` ist eine (abstrakte) Basisklasse, welche neben dem Attribut `kennzeichen` im Wesentlichen die Methode `berechneSteuer()`  definiert, die dann von den anderen Klassen entsprechend implementiert wird.

Die Methode `toString()` liefert jeweils einen String, welcher die Werte der Attribute enthält um letztendlich die geforderte Fahrzeugliste zusammenszustellen.