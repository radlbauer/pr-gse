# WEB-Shop #

In der SQL-Server-Datenbank [webshop.mdf](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/Webshop.mdf) befinden sich die Tabellen für die Abwicklung der Geschäfte eines WEB-Shops.

## Beschreibung der Datenbank ##

  * **benutzer:** In dieser Tabelle sind Benutzername und Kennwort sowie Benutzer-Typ abgelegt. Es gibt die Benutzer-Typen `admin`, `normal` und `inaktiv`. Manche Funktionalitäten können nur von `admin`-Benutzern angewendet werden. `Inaktive` Benutzer müssen erst wieder aktiviert werden, um sich anmelden zu können.

  * **kunden:** Ein Benutzer kann mehrere Kunden verwalten. (Fremdschlüssel `fk_k_benutzer`). In der **kunden**-Tabelle sind die Daten der Kunden gespeichert.

  * **adressen:** Jeder Kunde hat eine oder mehrere Adressen (Fremdschlüssel `fk_a_kunde`).

  * **laender:** Jeder Eintrag besteht aus einem Länder-Code und dem Namen des Landes. In der Tabelle **adressen** befindet sich ein Fremdschlüssel auf **laender** (`fk_a_land`)

  * **telefonnummern:** Jeder Kunde hat eine oder mehrere Telefonnummern (Fremdschlüssel `fk_t_kunde`)

  * **kategorien**: Die Produkte, welche im WEB-Shop angeboten werden, sind in Kategorien eingeteilt. Eine Kategorie kann mehrere Unterkategorien haben (Fremdschlüssel `fk_kat_super_kategorie`)

  * **produkte:** Neben den Spalten für Produktname, Ein- und Verkaufspreis, etc. enthält diese Tabelle einen Fremdschlüssel auf die Tabelle **kategorien** (`fk_p_kategorie`)


  * **warenkoerbe:** Jeder Kunde kann mehrere Warenkörbe anlegen (Fremdschlüssel `fk_w_kunde`)

  * **warenkorb\_positionen:** für jedes Produkt in einem Warenkorb wird eine Warenkorb-Position erstellt. Zusätzlich zu einer Spalte für die Menge gibt es daher einen Fremdschlüssel auf den Warenkorb (`fk_pw_warenkorb`) und einen Fremdschlüssel auf das Produkt (`fp_wp_produkt`).

  * **standorte:** Die Produkte sind an verschiedenen Standorten gelagert, wobei jeder Standort wiederum eine Adresse hat (`fk_s_adresse`).

  * **lagerpositionen:** in dieser Tabelle wird festgehalten, an welchen Lagerstandorten die Produkte gelagert sind. Der Primärschlüssel dieser Tabelle besteht aus einem Fremdschlüssel auf das Produkt (`fk_lp_produkt`) und aus einem Fremdschlüssel auf einen Standort(`fp_lp_standort`).

  * **einkaufs\_positionen:** Bevor die Produkte verkauft werden können, müssen sie natürlich eingekauft werden. Für die Dokumentation der Einkäufe dient diese Tabelle. Es gibt einen Fremdschlüssel auf das eingekaufte Produkt (`fk_ep_produkt`), einen Fremdschlüssel auf den Lagerstandort, wo das gekaufte Produkt gelagert wird (`fk_ep_standort`) und einen Fremdschlüssel auf die Kontobuchung für den Einkauf (`fk_ep_buchung`).

  * **konto\_buchungen:** Sowohl für Verkäufe als auch für Einkäufe von  Produkten werden jeweils Buchungen fällig.

  * **bestellungen:** Wenn ein Kunde die Produkte eines Warenkorbs bestellt, wird ein Datensatz in dieser Tabelle angelegt. Sie enthält eine Fremdschlüssel auf den Warenkorb (`fk_b_warenkorb`) und auch einen Fremdschlüssel auf die Adresse, wohin die Produkte versandt werden (`fk_b_adresse`). Es gibt ein Datum für das Anlegen der Bestellung und ein Versanddatum.

  * **rechnungen:** Für jede Bestellung wird auch eine Rechnung angelegt. Diese hat einen Fremdschlüssel auf die Bestellung (`fk_r_bestellung`), einen Fremdschlüssel für die Rechnungsadresse (`fk_r_adresse`) und einen Fremdschlüssel auf die Kontobuchungen, wenn die Rechnung bezahlt wird (`fk_r_buchung`). Das Rechnungsdatum entspricht dem Versanddatum der Rechnung.

  * **reklamationen:** Wenn ein Kunde ein Produkt reklamiert, wird hier ein Datensatz eingetragen. Es gibt einen Fremdschlüssel für das betroffene Produkt (`fk_rek_produkt`), für die betroffene Bestellung (`fk_rek_bestellung`) und für den Fall einer Erstattung einen Fremdschlüssel für die zugehörige Konto-Buchung (`fk_rek_buchung`). Eine Reklamation hat eine Status, welcher folgende Werte einnehmen kann: `neu`, `in Arbeit`, `behoben` oder `erstattet`.



## Aufbau der Applikation ##


Die Applikation soll modular aufgebaut sein, so dass mehrere Entwickler gleichzeitig daran arbeiten können.

Jedes Modul enthält eine Anmelde-Funktionalität. Das heißt, ein Benutzer muss sich erst mit gültigem Benutzernamen und Kennwort anmelden, um Zugriff auf die Funktionalitäten des Moduls zu haben.



### Benutzerverwaltung ###

Dieses Modul kann nur von einem Benutzer vom Typ admin verwendet werden. Es ermöglicht


  * das Erstellen und Ändern von Benutzern
  * das Löschen von Benuzern
  * die Neuzuordnung eines Kunden an einen anderen Benutzer


### Kundenverwaltung ###

Dieses Modul ermöglicht

  * das Anlegen eines neuen Kunden (wird dem angemeldeten Benutzer zugeordnet)
  * das Ändern von Kundendaten
  * das Löschen von Kunden


### Shopping ###

Dieses Modul ermöglicht

  * das Anlegen eines neuen Warenkorbs für einen Kunden
  * das Einfügen von Produkten in den Warenkorb.
  * das Löschen / Ändern von Produkten im Warenkorb.


### Bestellen ###

Dieses Modul ermöglicht es, für einen Warenkorb eine Bestellung durchzuführen. Es werden eine Bestellung und eine zugehörige Rechnung erstellt. Die Rechnung wird noch ohne Datum ausgestellt. Erst beim Versand der Rechnung wird ein Datum eigetragen.

Außerdem kann mit diesem Modul eine Bestellung storniert werden, falls sie noch nicht versandt ist.

### Versand ###

Dieses Modul kann nur von Benutzern des Typs admin verwendet werden. Es ermöglicht den Versand von offenen Bestellungen und Rechnungen.

Mit diesem Modul können auch Rechnungen gebucht werden (Kontobuchung erstellt und bei der Rechnung eingetragen)

### Kategorienverwaltung ###

Dieses Modul kann nur von Benutzern mit dem Typ admin verwendet werden. Es ermöglicht

  * das Erstellen und Ändern von Kategorien
  * das Löschen von Kategorien
  * die Neuzuordnung von Produkten zu Kategorien

### Produktverwaltung ###

Dieses Modul kann nur von Benutzern mit dem Typ admin verwendet werden. Es ermöglicht

  * das Anlegen von Produkten
  * das Ändern und Löschen von Produkten
  * die Neuzuordnung von Produkten zu Kategorien


### Einkauf ###

Dieses Modul kann nur von Benutzern des Typs admin verwendet werden. Es ermöglicht
  * das Anlegen neuer Standorte
  * das Ändern und Löschen von Standorten
  * das Einkaufen von Produkten (und Einlagern an einem Standort). In diesem Fall muss auch eine entsprechende Kontobuchung durchgeführt werden.


### Reklamationen erfassen ###

Dieses Modul ermöglicht das Erfassen und Bearbeiten von Reklamationen. Reklamationen können von einem Benutzer nur für seine eigenen Kunden erfasst werden.


### Reklamationen bearbeiten ###

Das Bearbeiten von Reklamationen kann nur ein Benutzer vom Typ admin durchführen.

Der Status einer Reklamation kann folgende Werte haben:
`neu`, `in Arbeit`, `behoben` oder `erstattet`.

Für eine Erstattung ist eine entsprechende Kontobuchung notwendig.