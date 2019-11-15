CREATE TABLE Personne(
id int AUTO_INCREMENT NOT NULL,
nom_personne varchar(100) NOT NULL,
prenom_personne varchar(100) NOT NULL,
date_naissance varchar(100) NOT NULL,
CONSTRAINT pk_personne PRIMARY KEY(id));

CREATE TABLE Fonction(
id int AUTO_INCREMENT NOT NULL,
libelle_fonction VARCHAR(100) NOT NULL,
CONSTRAINT pk_fonction PRIMARY KEY(id));

CREATE TABLE Fonction_personne(
id_personne int NOT NULL,
id_fonction int NOT NULL,
CONSTRAINT pk_fonction_personne PRIMARY KEY(id_personne,id_fonction),
CONSTRAINT fk_personne_fonction FOREIGN KEY (id_personne) REFERENCES Personne(id),
CONSTRAINT fk_fonction_personne FOREIGN KEY (id_fonction) REFERENCES Fonction(id)
);

CREATE TABLE Serie(
	id INT AUTO_INCREMENT NOT NULL,
	nom_serie VARCHAR(100) NOT NULL,
	nom_original_serie VARCHAR(100) NOT NULL,
	annee_parution TINYINT,
	synopsis LONGTEXT,
	CONSTRAINT PK_ID_SERIE PRIMARY KEY(id)
);

CREATE TABLE Saison(
	id INT AUTO_INCREMENT NOT NULL,
	index_saison INT NOT NULL,
	synopsis LONGTEXT,
	annee_parution_saison TINYINT,
    id_serie INT NOT NULL,
    CONSTRAINT PK_SAISON PRIMARY KEY(id),
    CONSTRAINT FK_SERIE_SAISON FOREIGN KEY(id_serie) REFERENCES Serie(id)
);

CREATE TABLE Public(
	id INT AUTO_INCREMENT NOT NULL,
	libelle_public VARCHAR(100) NOT NULL,
	CONSTRAINT PK_ID_PUBLIC PRIMARY KEY(id)
);

CREATE TABLE Episode(
id int AUTO_INCREMENT NOT NULL,
index_episode int NOT NULL,
titre_original varchar(100) NOT NULL,
titre_france varchar(100) NOT NULL,
duree int NOT NULL,
annee_real_episode TINYINT,
synopsis_episode LONGTEXT,
id_public int NOT NULL,
id_saison int NOT NULL,
CONSTRAINT pk_episode PRIMARY KEY(id),
CONSTRAINT fk_public_episode FOREIGN KEY(id_public) REFERENCES Public(id),
CONSTRAINT fk_saison_episode FOREIGN KEY(id_saison) REFERENCES Saison(id)
);



CREATE TABLE Participe(
id_personne int NOT NULL,
id_fonction int NOT NULL,
id_episode int NOT NULL,
role varchar(100),
CONSTRAINT pk_participe PRIMARY KEY(id_episode,id_personne,id_fonction),
CONSTRAINT fk_fonction_participe FOREIGN KEY(id_fonction) REFERENCES Fonction(id),
CONSTRAINT fk_personne_participe FOREIGN KEY(id_personne) REFERENCES Personne(id),
CONSTRAINT fk_episode_participe FOREIGN KEY(id_episode) REFERENCES Episode(id)
);


CREATE TABLE Pays(
id int AUTO_INCREMENT NOT NULL,
nom_pays varchar(100) NOT NULL,
CONSTRAINT pk_pays PRIMARY key(id));

CREATE TABLE Nationaliser(
id_pays int NOT NULL,
id_personne int NOT NULL,
origine bool NOT NULL,
CONSTRAINT pk_nationaliser PRIMARY KEY(id_pays,id_personne),
CONSTRAINT fk_pays FOREIGN KEY(id_pays) REFERENCES Pays(id),
CONSTRAINT fk_personne FOREIGN KEY(id_personne) REFERENCES Personne(id)
);


CREATE TABLE Genre(
	id INT AUTO_INCREMENT NOT NULL,
	libelle_genre VARCHAR(200) NOT NULL,
	CONSTRAINT PK_ID_GENRE PRIMARY KEY(id)
);
CREATE TABLE Langue(
	id INT AUTO_INCREMENT NOT NULL,
	libelle_langue VARCHAR(100) NOT NULL,
	CONSTRAINT PK_ID_LANGUE PRIMARY KEY(id)
);
CREATE TABLE Plateforme(
	id INT AUTO_INCREMENT NOT NULL,
	nom_plateforme VARCHAR(100) NOT NULL,
	url_plateforme VARCHAR(100) NOT NULL,
	CONSTRAINT PK_ID_PLATEFORME PRIMARY KEY(id)
);
CREATE TABLE Classer(
    id_serie INT NOT NULL,
	id_genre INT NOT NULL,
	CONSTRAINT PK_CLASSER PRIMARY KEY(id_serie, id_genre),
    CONSTRAINT FK_SERIE FOREIGN KEY(id_serie) REFERENCES Serie(id),
    CONSTRAINT FK_GENRE FOREIGN KEY(id_genre) REFERENCES Genre(id)
);
CREATE TABLE Trailer(
    url_trailer VARCHAR(200) NOT NULL,
	id_episode INT NOT NULL,
	id_plateforme INT NOT NULL,
    CONSTRAINT PK_TRAILER PRIMARY KEY(id_episode, id_plateforme),
    CONSTRAINT FK_EPISODE_TRAILER FOREIGN KEY(id_episode) REFERENCES Episode(id),
    CONSTRAINT FK_PLATEFORME_TRAILER FOREIGN KEY(id_plateforme) REFERENCES Plateforme(id)
);
CREATE TABLE Stream(
    url_episode VARCHAR(200) NOT NULL,
    id_episode INT NOT NULL,
	id_plateforme INT NOT NULL,
    CONSTRAINT PK_STREAM PRIMARY KEY(id_episode, id_plateforme),
    CONSTRAINT FK_EPISODE_STREAM FOREIGN KEY(id_episode) REFERENCES Episode(id),
    CONSTRAINT FK_PLATEFORME_STREAM FOREIGN KEY(id_plateforme) REFERENCES Plateforme(id)
);
CREATE TABLE SousTitrer(
    id_episode INT NOT NULL,
	id_langue INT NOT NULL,
    CONSTRAINT PK_SOUS_TITRE PRIMARY KEY(id_episode, id_langue),
    CONSTRAINT FK_SOUS_TITRE_EPISODE FOREIGN KEY(id_episode) REFERENCES Episode(id),
    CONSTRAINT FK_SOUS_TITRE_LANGUE FOREIGN KEY(id_langue) REFERENCES Langue(id)
);
CREATE TABLE APourAudio(
	version_originale BOOL NOT NULL,
    id_episode INT NOT NULL,
	id_langue INT NOT NULL,
    CONSTRAINT PK_AUDIO PRIMARY KEY(id_episode, id_langue),
    CONSTRAINT FK_AUDIO_EPISODE FOREIGN KEY(id_episode) REFERENCES Episode(id),
    CONSTRAINT FK_AUDIO_LANGUE FOREIGN KEY(id_langue) REFERENCES Langue(id)
);


