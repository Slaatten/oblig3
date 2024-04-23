CREATE TABLE Kjop (
    id smallint NOT NULL AUTO_INCREMENT,
    film VARCHAR(30) NOT NULL,
    antall INTEGER NOT NULL,
    fornavn VARCHAR(30) NOT NULL,
    etternavn VARCHAR(30) NOT NULL,
    telefon VARCHAR(8) NOT NULL,
    epost VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
);