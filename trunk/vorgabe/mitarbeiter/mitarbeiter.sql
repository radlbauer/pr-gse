CREATE SCHEMA PUBLIC AUTHORIZATION DBA
CREATE SEQUENCE MITARBEITERNUMMER AS INTEGER START WITH 1 
CREATE MEMORY TABLE MITARBEITER(MA_NR INTEGER NOT NULL PRIMARY KEY,MA_VORNAME VARCHAR(32),MA_NACHNAME VARCHAR(64),MA_GEBURTSDATUM TIMESTAMP,MA_GESCHLECHT CHAR(1))
CREATE MEMORY TABLE DUMMY(DUMMY INTEGER)
CREATE USER SA PASSWORD ""
GRANT DBA TO SA
SET WRITE_DELAY 10
SET SCHEMA PUBLIC
INSERT INTO DUMMY VALUES(1)
