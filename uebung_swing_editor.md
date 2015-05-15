# Editor #

Erstellen Sie einen Editor, der dem Windows-Editor ähnlich ist. Er besteht aus einem großen Text-Bereich (TextArea), in welchen der Text eingetippt bzw. geladen wird und verschiedenen Menus.

Der Editor soll grundsätzlich ohne automatischen Zeilenumbruch arbeiten, jedoch bei Bedarf Scrollbalken anbieten.


### Funktionalität ###

Folgende Funktionalitäten sollen verfügbar sein:

Datei neu/öffnen/speichern/speichern unter ... - Dabei soll exakt das Verhalten des Windows-Editors nachbebildet werden:

Wenn eine neue Datei angelegt wird oder das Fenster geschlossen wird, muss vorher überprüft werden, ob die letzten Änderungen der aktuellen Datei bereits gespeichert wurden. Andernfalls ist der Benutzer zu fragen, wie vorgegangen werden soll: Datei speichern, Änderungen verwerfen, Aktion abbrechen.

Ebenso darf beim Speichern eine bereits vorhandene Datei nicht ohne Nachfragen überschrieben werden.

Mit dem Menu Format soll es möglich sein die Schriftgröße und die Textfarbe einzustellen.

Die anderen Funktionalitäten des Windows-Editors sind nicht zu implementieren.