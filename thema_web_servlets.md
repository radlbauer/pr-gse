# Servlets #

Ein Servlet ist eine Java-Klasse, welche das Interface `javax.servlet.Servlet` implementiert. (Dieses sowie auch alle anderen Klassen und Interfaces der Servlet und JSP API ist nicht Bestandteil der Java Standard-Edition sondern gehört zur Java Enterprise Edition.) Im Normalfall wird ein Servlet als Sub-Klasse der Klasse `javax.servlet.http.HttpServlet` definiert.

Ein Servlet wird normalerweise beim ersten Aufruf von der Servlet-Engine instanziiert und kann dann Requests vom Browser empfangen und eine Antwort senden oder aber auf eine andere Seite weiterleiten.

Je nach der Methode, mit welcher der Request gesendet wurde (GET, POST, ...) ruft die Servlet-Engine eine entsprechende Methode des Servlets auf: `doGet(...)`, `doPost(...)`, ... .

Als Parameter bekommen diese Methoden jeweils eine Referenz auf ein `HttpServletRequest`- und auf ein `HttpServletResponse`-Objekt. Ersteres lässt sich eine Reihe von Informationen über den Request entlocken, zweiteres kann verwendet werden, um die Antwort an den Client zu erstellen.

Für die weiteren Erläuterungen soll das Beispiel [anmeldung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/web_beispiele/anmeldung) (Deployment Deskriptor: [web.xml](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/WEB-INF/web.xml)) herangezogen werden. Dabei handelt es sich um eine einfache WEB-Applikation, mit der sich Personen für eine WEB-Party anmelden oder auch eine Absage übermitteln können.

## Konfiguration des Servlets ##

Die Konfiguration des Servlets erfolgt zweistufig:

Einerseits durch den `servlet`-Eintrag, in welchem für das Servlet ein Name oder Alias vergeben wird. Weiters wird hier die Servlet-Klasse definiert, und es könnten auch noch Initialisierungsparameter definiert werden.
```
    <servlet>
        <servlet-name>Anmeldung</servlet-name>
        <servlet-class>anmeldung.web.Anmeldung</servlet-class>
    </servlet>
```
Andererseits durch das `servlet-mapping` mit welchem dem Servlet-Namen ein URL-Pattern zugeordnet wird:
```
    <servlet-mapping>
        <servlet-name>Anmeldung</servlet-name>
        <url-pattern>/anmelden</url-pattern>
    </servlet-mapping>
```
(Einem Servlet könnten auch mehrere URL-Patterns zugeordnet werden.)

Dieses Servlet würde man also etwa folgendermaßen aufrufen:

`http://localhost:8080/anmeldung/`**anmelden**

## Request-Parameter auswerten ##

Das Servlet Anmeldung in unserem Beispiel wird von der HTML-Seite [hello.html](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/web/html/hello.html) aufgerufen, welche etwa so aussieht:

![http://pr-gse.googlecode.com/svn/wiki/images/servlet/hello.jpg](http://pr-gse.googlecode.com/svn/wiki/images/servlet/hello.jpg)

Die HTML-Seite enthält im Wesentlichen ein Formular, welches mit der Action das Servlet Anmeldung aufruft:
```
<form action="anmelden">
...
</form>
```

Darin befindet sich das Textfeld für die Eingabe der E-Mail-Adresse:
```
Deine E-Mail-Adresse: <input type="text" name="email" value="" size="100" />
```
Der Name des Textfeldes ist `email`. Mit Hilfe dieses Namens wird der vom Benutzer eingegebene Inhalt des Textfeldes abgefragt: Methode `processRequest(...)` in [Anmeldung.java](http://code.google.com/p/pr-gse/source/browse/trunk/web_beispiele/anmeldung/src/java/anmeldung/web/Anmeldung.java) (diese Methode wird sowohl von `doGet(...)` als auch von `doPost(...)` aufgerufen.

Der Inhalt des Textfeldes kann vom `HttpServletRequest`-Objekt abgefragt werden:
```
String email = request.getParameter("email");
```

Ähnlich funktioniert die Abfrage der Auswahl des Benutzers bei den Radio-Buttons. Hier ist allerdings zu beachten, dass alle zusammengehörigen Radio-Buttons den gleichen namen haben. Der Inhalt ist dann der `value` des ausgewählten Radio-Buttons:
```
<input type="radio" name="zusage" value="ja" checked="checked" />
<input type="radio" name="zusage" value="nein" />
```
abgefragt in in `processRequest(...)`:
```
boolean kommt = "ja".equals(request.getParameter("zusage"));
```
In der Variable `kommt` wird also dann `true` stehen, wenn der Benutzer den Radio-Button mit `value="ja"` ausgewählt hat.

## Weiterleitung auf andere Seite ##

Es werden also im Servlet die Benutzereingaben ausgewertet und in der Oberflächenlogik verarbeitet. Die Oberflächenlogik interagiert dann mit der Fachlogik (was sich in diesem Fall auf die Zeile
```
Anmeldungen.getInstance().eintragen(email, kommt);
```
beschränkt.

Nun könnte das Servlet selbst die Antwortseite generieren, was jedoch in der Praxis recht umständlich ist. Besser ist es sicher, auf eine andere Seite weiterzuleiten, welche dann die Antwortseite darstellt. Diese Seite kann eine (statische) HTML-Seite sein:
```
request.getRequestDispatcher("html/freumich.html").forward(request, response);
```
Es kann aber auch eine (dynamisch aufgebaute) JSP sein:
```
request.getRequestDispatcher("jsp/schade.jsp").forward(request, response);
```

_Bei der hier praktizierten Umleitung handelt es sich um eine Server-interne Umleitung. Eine andere Möglichkeit wäre das senden einer Redirect-Aufforderung an den Client:_
```
response.sendRedirect("jsp/schade.jsp");
```
_Diese Art der Umleitung verursacht jedoch zusätzlichen Traffik. Außerdem gehen die Request-Daten verloren. Daher emfiehlt sich diese Vorgangsweise eigentlich nur dann, wenn man z.B auf einen anderen Server umleiten will._

Die Fortsetzung der Beschreibung dieses Beispiels befindet sich im Thema [Java Server Pages](thema_web_jsp.md).