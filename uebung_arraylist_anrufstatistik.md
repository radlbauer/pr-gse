# Anrufstatistik #

Ein Programm für die Auswertung von Telefonaten und deren Kosten benötigt die folgenden Klassen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/anrufstatistik.jpg' />
</p>


### Klasse Anruf ###

Für jeden Anruf werden folgende Daten gespeichert (Klasse `Anruf`):

| **Attribut** | **Inhalt** | **Wertebereich** | **Standardwert** |
|:-------------|:-----------|:-----------------|:-----------------|
| nr | angerufene Telefonnummer | nicht leer | "000" |
| dauer | Anrufdauer (Sekunden) | > 0 | 1 |
| tarif | Tarif für diesen Anruf | g: Geschäftszeit, f: Freizeit | f |

Es gibt einen Standardkonstruktor und einen Konstruktor, der die Telefonnummer als Parameter übernimmt.

Für Alle Attribute gibt es `get`- und `set`-Methoden.

In den Konstruktoren und `set`-Methoden ist zu gewährleisten, dass die oben angeführten Wertebereiche eingehalten werden. Andernfalls ist eine Fehlermeldung auszugeben.

Die Methode `berechneKosten()` liefert als Rückgabewert die Kosten des Anrufes (in €):

> Geschäftszeit: 	€ 0,07 pro angefangene Minute <br />
> Freizeit: 		€ 0,04 pro angefangene Minute


### Klasse AnrufStatistik ###

In einer Instanz der Klasse `AnrufStatistik` werden `Anruf`-Instanzen verwaltet.

Die Methode `add(…)` erlaubt das Hinzufügen eines Anrufes.

Die Methode `berechneGesamtKosten()` liefert als Rückgabewert die Summe der Kosten aller Anrufe.

Die Methode `berechneKosten(nr)` liefert als Rückgabewert die Summe der Kosten aller Anrufe an die übergebene Nummer.

Die Methode `nummernListe()` liefert in einer `ArrayList` alle Nummern, zu denen Anrufe getätigt wurden. Dabei soll jede Nummer nur einmal in der Liste vorkommen, egal wie oft sie angerufen wurde.

Die Methode `statistik()` liefert in einem String eine Liste aller Nummern mit der Summe der Kosten aller Anrufe an diese Nummer.

```
Nummer		Kosten
=====================
018103345		10.50
066412345		12.10
.....
```