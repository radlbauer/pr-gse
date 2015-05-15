# JDBC mit HSQLDB #

### Download der Datenbank-Software ###

Von der [HSQLDB Web-Seite](http://hsqldb.org/) die letzte stabile Version herunterladen. Es handelt sich um eine ZIP-Datei, welche an geeigneter Stelle entpackt wird (z.B.: C:\Programme\hsqldb).

### Starten der Management-Console und erzeugen einer Datenbank ###

Im Verzeichnis ...\hsqldb\demo\ befindet sich die Batch-Datei runManagerSwing.bat. Startet man diese mit Doppelklick, so bekommt man folgendes Fenster:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/images/jdbc_hsqldb/anmeldefenster.png' />
</p>

Wählt man beim Auswahlfeld "Type" anstatt "HSQL Database Engine In-Memory" den Typ "HSQL Database Engine Standalone" aus, dann ändert sich das Feld URL auf den Wert "`jdbc:hsqldb:file:«database/path?»`"

Was bedeuten nun die verschiedenen Eingabefelder:
  * Type: HSQLDB kann auf verschiedene Arten betrieben werden.
  * Driver: hier wird die Datenbank-Treiberklasse angegeben.
  * URL: die URL, mit der zur Datenbank verbunden wird.
  * USER, Password: Benutzerkennung für die Verbindung zur Datenbank.

Als nächste Schritt ist die URL richtig einzutragen. Anstatt "«database/path?»" ist ein gültiger Dateiname einzutragen. Diese Datei muss noch nicht existieren, wohl aber der Ordner. In der angegebenen Datei wird dann die Datenbank angelegt; z.B. "`jdbc:hsqldb:file:C:\meineHsqlDatenbank`".
(Bitte keine Dateiendung angeben. Diese wird von HSQLDB angelegt.)

In allen anderen Feldern (auch USER und Password) kann man die Standardwerte belassen.
Bei Klick auf OK wird die Verbindung zur Datenbank geöffnet.

Im Menu `Options` gibt es einen Eintrag `Insert test data`. Führt man dieses aus, dann werden für diese Datenbank Testdaten generiert. Diese kann man im linken Teil des Fensters im Schema sehen. (Dafür ist es eventuell nötig, im Menu `Schemas` zuerst auf `INFORMATION_SCHEMA` umzuschalten und dann wieder zurück auf `PUBLIC`, um das Schema zu aktualisieren).

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/images/jdbc_hsqldb/testdaten.png' />
</p>

Nun kann man ein bisschen mit diesen Testdaten herumspielen: Im oberen Teil des Hauptfensters kann man SQL-Befehle eingeben. Bei Klick auf die Schaltfläche `Execute SQL` werden diese ausgeführt, und die Ergebenisse werden im unteren Teil des Hauptfensters angezeigt.

Wichtig ist es dann, ein SHUTDOWN durchzuführen - bitte das Kommando "SHUTDOWN" ins SQL-Fenster eingeben und mit `Execute SQL` ausführen. Dadurch ist die Verbindung zur Datenbankdatei getrennt, und auch alle Daten werden erst durch das SHUTDOWN in die Dateien geschrieben.

Man kann dann die Datei mit der Endung ".script" (in unserem Fall "C:\meineHsqlDatenbank.script") mit einem Editor anschauen. HSQLDB speichert alle Daten in Form einer Script-Datei:

```
CREATE SCHEMA PUBLIC AUTHORIZATION DBA
CREATE MEMORY TABLE CUSTOMER(ID INTEGER NOT NULL PRIMARY KEY,FIRSTNAME VARCHAR(20),LASTNAME VARCHAR(20),STREET VARCHAR(20),CITY VARCHAR(20))
CREATE MEMORY TABLE PRODUCT(ID INTEGER NOT NULL PRIMARY KEY,NAME VARCHAR(20),PRICE DECIMAL(10,2))
CREATE MEMORY TABLE INVOICE(ID INTEGER NOT NULL PRIMARY KEY,CUSTOMERID INTEGER,TOTAL DECIMAL(10,2),CONSTRAINT SYS_FK_54 FOREIGN KEY(CUSTOMERID) REFERENCES CUSTOMER(ID) ON DELETE CASCADE)
CREATE MEMORY TABLE ITEM(INVOICEID INTEGER NOT NULL,ITEM INTEGER NOT NULL,PRODUCTID INTEGER,QUANTITY INTEGER,COST DECIMAL(10,2),PRIMARY KEY(INVOICEID,ITEM),CONSTRAINT SYS_FK_59 FOREIGN KEY(INVOICEID) REFERENCES INVOICE(ID) ON DELETE CASCADE,CONSTRAINT SYS_FK_60 FOREIGN KEY(PRODUCTID) REFERENCES PRODUCT(ID) ON DELETE CASCADE)
CREATE USER SA PASSWORD ""
GRANT DBA TO SA
SET WRITE_DELAY 10
SET SCHEMA PUBLIC
INSERT INTO CUSTOMER VALUES(0,'Laura','Steel','429 Seventh Av.','Dallas')
INSERT INTO CUSTOMER VALUES(1,'Robert','King','267 - 20th Ave.','Seattle')
INSERT INTO CUSTOMER VALUES(2,'Robert','Sommer','22 - 20th Ave.','Oslo')
INSERT INTO CUSTOMER VALUES(3,'Michael','Smith','455 Upland Pl.','Lyon')
INSERT INTO CUSTOMER VALUES(4,'Bill','Fuller','363 Seventh Av.','Oslo')
INSERT INTO CUSTOMER VALUES(5,'Laura','White','127 - 20th Ave.','Dallas')

INSERT INTO CUSTOMER VALUES(6,'Robert','King','550 Seventh Av.','Palo Alto')
INSERT INTO CUSTOMER VALUES(7,'Susanne','Clancy','138 Seventh Av.','Paris')
INSERT INTO CUSTOMER VALUES(8,'Bob','Heiniger','226 - 20th Ave.','Dallas')
INSERT INTO CUSTOMER VALUES(9,'Robert','Ott','2 - 20th Ave.','Seattle')
INSERT INTO CUSTOMER VALUES(10,'Anne','Smith','125 - 20th Ave.','Paris')
INSERT INTO CUSTOMER VALUES(11,'Susanne','Karsen','53 Seventh Av.','New York')
.......
```


### Verbindung aus einem Java-Programm herstellen ###

Zuerst einmal müssen die Datenbanktreiber-Klassen im Klassenpfad liegen. Dazu ist die Datei hsqldb.jar in den Klassenpfad aufzunehmen. Sie befindet sich im Verzeichnis ...\hsqldb\lib\ .

**Netbeans:**

Mit rechter Maustaste auf das Projekt klicken und `Properties` anwählen. Dann kann man `Libraries` auswählen. Es gibt nun verschiedene Karteikarten für .jar-Dateien, welche beim Compilieren beim Ausführen der Programme oder aber beim Testen im CLASSPATH enthalten sein sollen.


**Eclipse:**

In Eclipse ist es am einfachsten, die Datei hsqldb.jar ins Projekt hineinzuziehen, danach mit der rechten Maustaste daraufzuklicken, und im Context-Menu `Build Path` die Aktion `Add to Build Path` auszuwählen.

Dann ist der Datenbanktreiber zu laden:
```
Class.forName("org.hsqldb.jdbcDriver");
```
Hier ist die Exception `ClassNotFoundException` abzufangen.

Als Nächstes wird die Verbindung geöffnet:
```
Connection con = DriverManager.getConnection("jdbc:hsqldb:file:d:\\temp\\testdb", "SA", "");
```
Hier ist die `SQLException` zu behandeln.

Die Verbindung ist am besten in einem `finally`-Block wieder zu schließen:
```
con.close();
```
Auch hier sowie bei allen weiteren Schritten kann eine `SQLException` auftreten und muss somit behandelt werden.

Um jetzt wirklich ein Query zur Datenbank zu schicken, verwendet man am besten ein `PreparedStatement`:
```
PreparedStatement pstmt = con.prepareStatement("SELECT id, firstname, lastname FROM customer");
```

Das Query ist also vorbereitet und wird dann mit `executeQuery()` wirklich durchgeführt. Diese Methode liefert als Ergebnis ein `ResultSet`:
```
ResultSet rs = pstmt.executeQuery();
```

Das `ResultSet` ist so etwas wie ein Datenbank-Cursor und kann nun Datensatz für Datensatz abgearbeitet werden:
```
while (rs.next())
{
    System.out.print(rs.getInt("id") + "\t");
    System.out.print(rs.getString("firstname") + "\t");
    System.out.println(rs.getString("lastname"));
}
```

Danach sollte man nicht vergessen, das `ResultSet` und das `PreparedStatement` wieder freizugeben:
```
rs.close();
pstmt.close();
```