# Auto #

Für ein Computerspiel, in welchem ein Autorennen simuliert wird, wird die folgende Klasse `Auto` benötigt:

Attribute:
  * `kennzeichen`: Text - Autokennzeichen
  * `drehzahl`: Ganzzahl - Motordrehzahl
  * `gang`: Ganzzahl - Gang


Methoden:
  * Konstruktor: initialisiert die Attribute folgendermaßen: `kennzeichen`="unbekannt", `drehzahl`=1000, `gang`=0.
  * `setKennzeichen(...)`: set-Methode für das Attribut `kennzeichen`
  * `getKennzeichen()`: get-Methode für das Attribut `kennzeichen`
  * `getDrehzahl()`: get-Methode für das Attribut `drehzahl`
  * `getGang()`: get-Methode für das Attribut `gang`
  * `berechneGeschwindigkeit()`: berechnet die Geschwindigkeit nach der folgenden Formel und gibt das Ergebnis zurück:
> Geschwindigkeit = Gang x Drehzahl / 100.

  * `beschleunigen()`: multipliziert die Drehzahl mit 2
  * `bremsen()`: dividiert die Drehzahl durch 2
  * `hinaufschalten()`: erhöht den Gang um 1
  * `hinunterschalten()`: reduziert den Gang um 1

_Wie ändert sich das Verhalten, wenn man als Drehzahl eine Dezimalzahl nimmt?_