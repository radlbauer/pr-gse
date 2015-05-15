# Tapete #

Erstellen Sie die folgende Klasse `Tapete`, welche dazu verwendet werden kann, einfache Muster auszugeben:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/tapete.jpg' />
</p>

Die Attribute `breite` und `hoehe` geben an, wie viele Spalten breit und wie viele Zeilen hoch das Muster sein soll.

Es gibt einen Standardkonstruktor, welcher `breite` und `hoehe` jeweils auf den Wert 5 setzt.

Dem zweiten Konstruktor übergibt man Breite und Höhe als Parameter.

Es gibt jeweils eine `get-` und `set-`Methode für `breite` und `hoehe`.

Die Methode `printMuster(...)` gibt das gewünschte Muster auf die Konsole aus. Mit dem Parameter wird angegeben, welches Muster gewünscht ist:

1) Höhe: 5, Breite: 7
```
*******
*******
*******
*******
*******
```
2) Höhe: 5, Breite: 7
```
*.*.*.*
.*.*.*.
*.*.*.*
.*.*.*.
*.*.*.*
```
3) Höhe: 5, Breite wird ignoriert
```
    *  
   *** 
  *****
 *******
*********
```
4) Höhe: 5, Breite wird ignoriert
```
    *
   *+*
  *+++*
 *+++++*
*********
```
5) Höhe: 5, Breite wird ignoriert
```
    *
   *+*
  *+-+*
 *+-+-+*
*********
```
6) Höhe: 5, Breite: 7
```
1234567
8901234
5678901
2345678
9012345
```
7) Höhe: 5, Breite: 9
```
1.2.3.5.7
.11.13.17
.19.23.29
.31.37.41
.43.47.53
```