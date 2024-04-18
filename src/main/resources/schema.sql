CREATE TABLE Film (
    film VARCHAR(20) NOT NULL,
    PRIMARY KEY (film)
);

CREATE TABLE Billett (
    id smallint NOT NULL AUTO_INCREMENT,
    antall INTEGER NOT NULL,
    fornavn VARCHAR(30),
    etternavn VARCHAR(30),
    telefon VARCHAR(8),
    epost VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (film) references Film(film)
);