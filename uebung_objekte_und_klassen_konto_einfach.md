# Konto #

Erstellen Sie die folgende Klasse `Konto`:

Attribute:
  * `nummer`: Ganzzahl - Kontonummer
  * `besitzer`: Text - Besitzer des Kontos
  * `saldo`: Dezimalzahl - Kontostand

Methoden:
  * `setNummer(...)`: set-Methode für das Attribut `nummer`
  * `setBesitzer(...)`: set-Methode für das Attribut `besitzer`
  * `getNummer()`: get-Methode für das Attribut `nummer`
  * `getBesitzer()`: get-Methode für das Attribut `besitzer`
  * `getSaldo()`: get-Methode für das Attribut `saldo`
  * `einzahlen(double betrag)`: es wird der übergebene Betrag auf das Konto eingezahlt (`saldo` wird um diesen Betrag erhöht).
  * `abheben(double betrag)`: es wird der übergebene Betrag vom Konto abgehoben (`saldo` wird um diesen Betrag reduziert).
_(Es gibt keine set-Methode für das Attribut `saldo` - der Kontostand kann nur durch einzahlen oder abheben verändert werden.)_