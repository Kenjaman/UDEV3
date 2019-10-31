DROP DATABASE IF EXISTS gestioncoudev3;
CREATE DATABASE gestioncoudev3;
USE gestioncoudev3;

CREATE TABLE civilite(
	id INT NOT NULL,
	libelle VARCHAR(15) NOT NULL,
	CONSTRAINT PK_CIV PRIMARY KEY(id)
);

CREATE TABLE cpville(
    id INT NOT NULL,
    codepostal CHAR(5) NOT NULL,
    ville VARCHAR(100) NOT NULL,
    CONSTRAINT PK_CPVILLE PRIMARY KEY(id)
);

CREATE TABLE client(
    id INT NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    adresse1 VARCHAR(250) NOT NULL,
    adresse2 VARCHAR(250) DEFAULT NULL,
    idcpville INT NOT NULL,
	idcivilite INT NOT NULL,
    CONSTRAINT PK_CLIENT PRIMARY KEY(id),
    CONSTRAINT FK_CLI_CPVILLE FOREIGN KEY(idcpville) REFERENCES cpville(id),
    CONSTRAINT FK_CLI_CIVILITE FOREIGN KEY(idcivilite) REFERENCES civilite(id)
);

CREATE TABLE tva(
    id INT NOT NULL,
    taux FLOAT(5,2) NOT NULL,
    CONSTRAINT PK_TVA PRIMARY KEY(id),
    CONSTRAINT CHK_TVA CHECK (taux >= 0)
);

CREATE TABLE categorie(
	id INT NOT NULL,
	libelle VARCHAR(50) NOT NULL,
	idcatmere INT DEFAULT NULL,
	CONSTRAINT PK_CAT PRIMARY KEY (id),
	CONSTRAINT FK_CAT_CAT FOREIGN KEY (idcatmere) REFERENCES categorie(id)
);

CREATE TABLE produit(
	id INT NOT NULL,
	reference CHAR(20) NOT NULL,
	designation VARCHAR(200) DEFAULT NULL,
	puht FLOAT(14,2) NOT NULL,
	idcategorie INT NOT NULL,
	CONSTRAINT PK_PRODUIT PRIMARY KEY(id),
	CONSTRAINT FK_PROD_CAT FOREIGN KEY (idcategorie) REFERENCES categorie(id)
);

CREATE TABLE devis(
	id INT NOT NULL,
	code CHAR(10) NOT NULL,
	datedevis DATE NOT NULL,
	dureevalidite INT NOT NULL,
	idclient INT NOT NULL,
	CONSTRAINT PK_DEVIS PRIMARY KEY (id),
	CONSTRAINT FK_DEV_CLIENT FOREIGN KEY (idclient) REFERENCES client(id)
);

CREATE TABLE facture(
	id INT NOT NULL,
	code CHAR(10) NOT NULL,
	datefacture DATE NOT NULL,
	idclient INT NOT NULL,
	iddevis INT DEFAULT NULL,
	CONSTRAINT PK_FACTURE PRIMARY KEY (id),
	CONSTRAINT FK_FACT_CLIENT FOREIGN KEY (idclient) REFERENCES client(id),
	CONSTRAINT FK_FACT_DEVIS FOREIGN KEY (iddevis) REFERENCES devis(id)
);

CREATE TABLE lignedevis(
	id INT NOT NULL,
	description VARCHAR(200) DEFAULT NULL,
	qte INT NOT NULL,
	iddevis INT NOT NULL,
	idtva INT NOT NULL,
	idproduit INT NOT NULL,
	CONSTRAINT PK_LDEVIS PRIMARY KEY (id),
	CONSTRAINT FK_LDEV_DEV FOREIGN KEY (iddevis) REFERENCES devis(id),
	CONSTRAINT FK_LDEV_TVA FOREIGN KEY (idtva) REFERENCES tva(id),
	CONSTRAINT FK_LDEV_PDT FOREIGN KEY (idproduit) REFERENCES produit(id)
);

CREATE TABLE lignefacture(
	id INT NOT NULL,
	description VARCHAR(200) DEFAULT NULL,
	qte INT NOT NULL,
	idfacture INT NOT NULL,
	idtva INT NOT NULL,
	idproduit INT NOT NULL,
	CONSTRAINT PK_LFACTURE PRIMARY KEY (id),
	CONSTRAINT FK_LFACT_FACT FOREIGN KEY (idfacture) REFERENCES facture(id),
	CONSTRAINT FK_LFACT_TVA FOREIGN KEY (idtva) REFERENCES tva(id),
	CONSTRAINT FK_LFACT_PDT FOREIGN KEY (idproduit) REFERENCES produit(id)
);

ALTER TABLE lignedevis ADD CONSTRAINT CHK_QTELDEV CHECK (qte > 0);
ALTER TABLE lignefacture ADD CONSTRAINT CHK_QTELFACT CHECK (qte > 0);
ALTER TABLE tva ADD CONSTRAINT CHK_TAUXTVA CHECK (taux >= 0);
