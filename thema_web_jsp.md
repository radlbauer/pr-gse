# Java Server Pages (JSP) #

## Aufbau einer JSP ##

JSPs enthalten im Wesentlichen HTML-Code und zusätzliche JSP-Tags und Scripting-Elemente. Die Servlet-Engine übersetzt eine JSP normalerweise beim ersten Aufruf in ein Java-Servlet. Im Apache Tomcat Server trägt dieser JSP -> Java - Compiler den Namen "Jasper".

Auf die Scripting-Möglichkeiten in JSPs wird hier nicht näher eingegangen, da bei intensiver Verwendung von JSP-Scripting ein ziemlich unlesbares Durcheinander von Java und HTML herauskommt.

Als Beispiel wird hier die Applikation [anmeldung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/web_beispiele/anmeldung) verwendet, welche bereits im Thema [Servlets](thema_web_servlets.md) beschrieben wurde.

Die Seite [schade.jsp](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/jsp/schade.jsp) sieht etwa folgendermaßen aus:

![http://pr-gse.googlecode.com/svn/wiki/images/servlet/schade.jpg](http://pr-gse.googlecode.com/svn/wiki/images/servlet/schade.jpg)

Neben dem fixen Text (Überschrift, ...) wird hier eine dynamisch generierte Tabelle angezeigt. Das passiert mit folgendem Code:
```
        <table border="1">
            <thead>
                <tr>
                    <th>Email</th>
                    <th>eingetragen am/um </th>
                    <th>zugesagt</th>
                </tr>
            </thead>
            <tbody>
                <anmeldung:liste>
                    <tr>
                        <td><anmeldung:eintrag feld="email"/></td>
                        <td><anmeldung:eintrag feld="zeitpunkt"/></td>
                        <td><anmeldung:eintrag feld="zusage"/></td>
                    </tr>
                </anmeldung:liste>
            </tbody>
        </table>
```

## Selbst definierte Tags ##

Hier findet man folgende bekannte HTML-Tags wie man sie z.B bei [SELFHTML](http://de.selfhtml.org/html/tabellen/index.htm) dokumentiert findet:
  * `table` - für die Definition der Tabelle
  * `thead` - für die Definition der Überschriftenzeile
  * `th` - die Zellen der Überschriftenzeile
  * `tbody` - die Daten der Tabelle
  * `tr` - die Zeilen der Tabelle
  * `td` - die einzelnen Datenfelder der Tabelle

Dazwischen befinden sich aber noch die selbst definierten Tags `anmeldung:liste` und `anmeldung:eintrag`. Diese Tags werden folgendermaßen definiert:

Die JSP-Seite beginnt mit dem JSP-Prolog:
```
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
```

Danach befindet sich ein Verweis auf eine Tag-Bibliothek:
```
<%@taglib prefix="anmeldung" uri="/anmeldung"%>
```

Der Prefix `anmeldung` definiert, dass innerhalb der JSP vor allen Tags aus dieser Tag-Bibliothek eben dieser Prefix steht: `anmeldung:liste` und `anmeldung:eintrag`.

Der universal resource identifier (uri) `/anmeldung` ist auch im Deployment-Deskriptor [web.xml](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/WEB-INF/web.xml) zu finden:
```
    <jsp-config>
        <taglib>
            <taglib-location>
                /WEB-INF/tld/anmeldung.tld
            </taglib-location>
            <taglib-uri>
                /anmeldung
            </taglib-uri>
        </taglib>
    </jsp-config>
```

Der entsprechende `taglib`-Eintrag verweist auf den Tag-Library-Descriptor [anmeldung.tld](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/WEB-INF/tld/anmeldung.tld) im Verzeichnis `WEB-INF/tld`.

## Tag-Library-Deskriptor (TLD) ##

Auch ein Tag-Library-Deskriptor (TLD) ist eine Datei im XML-Format. Er definiert einzelne Tags. Am Beginn der Datei steht wie immer der XML-Prolog und das Basiselement `taglib` mit dem Verweis auf das XML-Schema:
```
<?xml version="1.0" encoding="UTF-8" ?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
    version="2.0">
```

Danach kommen Taglib-Version und URI:
```
        <tlib-version>1.0</tlib-version>
        <uri>/anmeldung</uri>
```

Dann kommen die eigentlichen Tag-Definitionen. Die wesentlichsten Elemente einer Tag-Definition sind der Name des Tags und die dazugehörige Tag-Handler-Klasse. Weiters wird hier für den Tag `eintrag` auch noch ein Attribut mit dem Namen `feld` definiert.
```
        <tag>
            <tag-class>anmeldung.web.ListeTag</tag-class>
            <name>liste</name>
        </tag>

        <tag>
            <tag-class>anmeldung.web.EintragTag</tag-class>
            <name>eintrag</name>
            <attribute>
                <name>feld</name>
                <required>true</required>
            </attribute>
        </tag>
```

Findet sich nun in der JSP ein hier definierter Tag, dann werden an dieser Stelle die entsprechenden Methoden des zugehörigen Tag-Handlers aufgerufen.

## Tag-Handler-Klasse ##
Zum Tag `liste` gehört die Tag-Handler-Klasse [ListeTag](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/src/java/anmeldung/web/ListeTag.java).

Ein Tag-Handler muss das Interface `Tag` implementieren. Meist wird von der Klasse `TagSupport` abgeleitet.

An dieser Stelle sind noch ein paar Begriffe im Zusammenhang mit HTML- bzw. XML-Tags zu erklären. Der Tag `anmeldung:liste` besteht aus 3 Teilen:
  * `<anmeldung:liste>` ist der Start des Tags
  * `</anmeldung:liste>` ist das Ende des Tags
  * alles dazwischen ist der Körper (body) des Tags

So sind auch die Methoden der Klasse `TagSupport` zu verstehen:
  * An der Stelle, wo der Tag startet, wird die Methode `doStartTag()` ausgeführt.
  * Vor dem Ende des Tags wird die Methode `doAfterBody()` ausgeführt.
  * An der Stelle des Tag-Endes wird die Methode `doEndTag()` ausgeführt.
Man kann nun diese Methoden je nach Bedarf überschreiben.

Über den Rückgabewert der jeweiligen Methode wird gesteuert, was danach passiert. Beispielsweise kann `doStartTag()` die Konstante `SKIP_BODY` zurückliefern, wenn der Körper des Tags ignoriert werden soll. `EVAL_BODY_INCLUDE` bedeutet, dass der Körper des Tags eingefügt werden soll. Mit dem Rückgabewert `EVAL_BODY_AGAIN` von der Methode `doAfterBody()` kann man eine Schleife steuern.


---


In der Klasse [ListeTag](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/src/java/anmeldung/web/ListeTag.java) sind die Methoden `doStartTag()` und `doArterBody()` implementiert.

In der Methode `doStartTag()` wird zuerst von der Fachlogik die Liste aller Einträge angefordert:
```
        List<Eintrag> liste = Anmeldungen.getInstance().eintraege();
```

Falls Einträge vorhanden sind, wird ein Itertor angefordert und als Attribut mit dem Namen "iterator" an den `pageContext` gehängt. (Der Page-Context ist ein Context-Objekt, welches innerhalb einer JSP gültig ist):
```
            Iterator<Eintrag> iterator = liste.iterator();
            pageContext.setAttribute("iterator", iterator);
```

Weiters wird auch gleich der erste `Eintrag` vom Iterator angefordert und als Attribut mit dem Namen "eintrag" an den `pageContext` gehängt:
```
            pageContext.setAttribute("eintrag", iterator.next());
```

Mit dem Rückgabewert `EVAL_BODY_INCLUDE` wird gesteuert, dass nun der Körper des Tags ausgewertet wird. Dieser besteht aus einer Tabellenzeile mit 3 Datenfeldern:
```
                    <tr>
                        <td><anmeldung:eintrag feld="email"/></td>
                        <td><anmeldung:eintrag feld="zeitpunkt"/></td>
                        <td><anmeldung:eintrag feld="zusage"/></td>
                    </tr>
```

Die Datenfelder werden mit dem selbstdefinierten Tag `anmeldung` (mit verschiedenen Attributen) befüllt.

Vorher betrachten wir aber noch die `doAfterBody()`-Methode von `ListeTag`. Hier wird der Iterator wieder aus dem `pageContext` herausgeholt, und falls es einen weiteren `Eintrag` gibt, wird dieser als Attribut mit dem Namen "eintrag" an den `pageContext` angehängt. Der Rückgabewert `EVAL_BODY_AGAIN` bewirkt, dass nun sozusagen in einer Schleife der Tag-Körper erneut ausgewertet wird, also die nächste Zeile der Tabelle mit der nächsten `Eintrag`-Instanz:
```
    public int doAfterBody() throws JspException
    {
        Iterator<Eintrag> iterator = (Iterator<Eintrag>) pageContext.getAttribute("iterator");
        if (iterator.hasNext())
        {
            pageContext.setAttribute("eintrag", iterator.next());
            return EVAL_BODY_AGAIN;
        }
        else
            return SKIP_BODY;
    }
```

Erst wenn kein weiterer `Eintrag` mehr vorhanden ist, wird mit `SKIP_BODY` gesteuert, dass jetzt das Tag-Ende drankommt.


---


Nun kommen wir zur Betrachtung des Tags `eintrag` mit dem zugehörigen Tag-Handler [EintragTag](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/src/java/anmeldung/web/EintragTag.java). Hier ist nur die Methode `doStartTag()` implementiert. Darin wird die aktuelle `Eintrag`-Instanz vom `pageContext` abgeholt. (Wir erinnern uns, dass diese vom oben beschriebenen Tag-Handler `ListeTag` angehängt wurde. Je nach Wert des Attributs `feld` wird eine Information aus der `Eintrag`-Instanz über den `JspWriter` (angefordert mit `pageContext.getOut()`) ausgegeben.
```
            Eintrag eintrag = (Eintrag) pageContext.getAttribute("eintrag");
            if ("email".equals(feld))
                pageContext.getOut().print(eintrag.getEmail());
            else if ("zeitpunkt".equals(feld))
                pageContext.getOut().print(DATEFORMAT.format(eintrag.getZeitpunkt()));
            else if ("zusage".equals(feld))
                pageContext.getOut().print((eintrag.isZusage()) ? "ja" : "nein");
```
Das Attribut `feld` wurde im Tag-Library-Descriptor [anmeldung.tld](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/WEB-INF/tld/anmeldung.tld) für den Tag `eintrag` als Attribut definiert:
```
        <tag>
            <tag-class>anmeldung.web.EintragTag</tag-class>
            <name>eintrag</name>
            <attribute>
                <name>feld</name>
                <required>true</required>
            </attribute>
        </tag>
```
Wenn für den Tag ein solches Attribut definiert ist, muss man nur in der Tag-Handler-Klasse ein Attribut mit exakt dem gleichen Namen und `get()`- und `set()`-Methode entsprechend den Java Coding-Konventionen schreiben. Dann kann das Attribut in der JSP gesetzt werden:
```
<anmeldung:eintrag feld="email"/>
```