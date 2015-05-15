Erstellen Sie die folgende Klasse `BinaerZahl`, welche eine Zahl in binärer Darstellung (Zweierkomplement) repräsentieren soll:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/BinaerZahl.jpg' />
</p>

Die einzelnen Bits der Binärzahl werden im Array `bits` vom Typ `boolean` gespeichert. Der Wert `1` wird durch ein `true` repräsentiert, der Wert `0` durch ein `false`.

Im Konstruktor wird die Größe der Binärzahl (Anzahl der Bits) als Parameter mitgegeben. Hier sind nur Vielfache von 8 erlaubt.

Die Methode `setString(...)` bekommt als Parameter einen String, der die Binärzahl in Form von `0`- und `1`-Werten enthält. Damit wird das Array `bits` befüllt.

Die Methode `getString()` liefert im Rückgabewert die Binärzahl als String mit `0`- und `1`-Werten.

Die Methode `setInt(...)` bekommt als Parameter eine Ganzzahl. Diese muss in ihre binäre Form umgerechnet werden, um das Array `bits` zu befüllen.

Die Methode `getInt()` rechnet aus den Bits im Array `bits` die entsprechende Ganzzahl aus und liefert diese als Rückgabewert.

Die Methode `setHex(...)` bekommt als Parameter einen String, welcher eine Hexadezimalzahl in der üblichen Schreibweise (z.B. `0x1ABC`) enthält. Diese wird in ihre binäre Form umgerechnet, um das Array `bits` zu befüllen.

Die Methode `getHex()` liefert als Rückgabewert einen String, in welchem die Zahl in Hexadezimal-Repräsentation steht.

Die Methode `add(...)` bekommt eine Referenz auf eine andere Instanz von `BinaerZahl` als Parameter übergeben. Diese andere Binärzahl wird addiert (entsprechend den Rechenregeln für binäres Addieren). Das Ergebnis wird als neue Binärzahl zurückgeliefert

Die Methode `bitSumme()` liefert als Rückgabewert die Summe der Bits (= Anzahl der  `1`-Bits).