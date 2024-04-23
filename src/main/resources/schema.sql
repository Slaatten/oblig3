CREATE TABLE Billett (
    id smallint NOT NULL AUTO_INCREMENT,
    film VARCHAR(30),
    antall INTEGER NOT NULL,
    fornavn VARCHAR(30),
    etternavn VARCHAR(30),
    telefon VARCHAR(8),
    epost VARCHAR(30),
    PRIMARY KEY (id),
);