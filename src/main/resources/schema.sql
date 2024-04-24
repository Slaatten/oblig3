CREATE TABLE Kjop (
    id smallint NOT NULL AUTO_INCREMENT,
    film VARCHAR(100) NOT NULL,
    antall INTEGER NOT NULL,
    fornavn VARCHAR(50) NOT NULL,
    etternavn VARCHAR(50) NOT NULL,
    telefon VARCHAR(15) NOT NULL,
    epost VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);