# Town #

Diese Übung ist eine Erweiterung der Übung [Village](uebung_assoziation_village.md).

Wenn mehrere Dörfer zusammenwachsen, entsteht daraus eine Stadt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/town.jpg' />
</p>


Es gilt ganz analog zur Klasse `Village`:


Eine `Town` besteht aus bis zu 3 Dörfern (`village1`, `village2`, `village3`). Es gibt 2 Möglichkeiten, eine Stadt zu erstellen:

Der Standardkonstruktor erstellt eine Stadt ohne Dörfer. Diese müssen dann erst mit der Methode `add()` eingefügt werden.

Der zweite Konstruktor bekommt im Parameter die Anzahl der Dörfer übergeben, die er gleich instanziieren soll (kann 0, 1, 2 oder 3 sein). Überlegen Sie sich selbst eine sinnvolle Anordnung für diese Dörfer.

Mit der Methode `add(...)` kann ein Dorf in die Stadt eingefügt werden. Die Attribute `village1`, `village2`, `village3` werden in dieser Reihenfolge besetzt.

Die Methoden `makeVisible()`, `makeInvisible()`, `moveHorizontal(...)` und `moveVertical(...)` funktionieren analog wie in den Klassen `House` und `Village`.

Die Stadt hat zusätzlich zu den Dörfern das Attribut `sun`, es scheint also die Sonne.

Die Methode `sunset()` bewirkt, dass die Sonne langsam nach unten geht und verschwindet. Dann wird es Nacht und alle Dörder werden dunkel.