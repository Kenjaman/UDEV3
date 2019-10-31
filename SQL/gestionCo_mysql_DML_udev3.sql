/* Script d'insertion des données */
USE gestioncoudev3;

INSERT INTO civilite(id, libelle) VALUES (1, 'Madame');
INSERT INTO civilite(id, libelle) VALUES (2, 'Monsieur');
INSERT INTO civilite(id, libelle) VALUES (3, 'Mademoiselle');

INSERT INTO tva(id, taux) VALUES (1, 0.0);
INSERT INTO tva(id, taux) VALUES (2, 2.1);
INSERT INTO tva(id, taux) VALUES (3, 5.5);
INSERT INTO tva(id, taux) VALUES (4, 10.0);
INSERT INTO tva(id, taux) VALUES (5, 20.0);

INSERT INTO categorie(id, libelle, idcatmere) VALUES (1, 'Informatique', null);
INSERT INTO categorie(id, libelle, idcatmere) VALUES (2, 'Ordinateur', (SELECT id FROM categorie cat WHERE libelle = 'Informatique'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (3, 'Composants', (SELECT id FROM categorie cat WHERE libelle = 'Ordinateur'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (4, 'CPU', (SELECT id FROM categorie cat WHERE libelle = 'Composants'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (5, 'RAM', (SELECT id FROM categorie cat WHERE libelle = 'Composants'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (6, 'Stockage', (SELECT id FROM categorie cat WHERE libelle = 'Composants'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (7, 'SSD', (SELECT id FROM categorie cat WHERE libelle = 'Stockage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (8, 'HDD', (SELECT id FROM categorie cat WHERE libelle = 'Stockage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (9, 'USB', (SELECT id FROM categorie cat WHERE libelle = 'Stockage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (10, 'Outillage', null);
INSERT INTO categorie(id, libelle, idcatmere) VALUES (11, 'Jardinage', (SELECT id FROM categorie cat WHERE libelle = 'Outillage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (12, 'Manuel', (SELECT id FROM categorie cat WHERE libelle = 'Jardinage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (13, 'Electrique', (SELECT id FROM categorie cat WHERE libelle = 'Outillage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (14, 'Tronçonneuses', (SELECT id FROM categorie cat WHERE libelle = 'Electrique'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (15, 'Tondeuses', (SELECT id FROM categorie cat WHERE libelle = 'Electrique'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (16, 'Thermique', (SELECT id FROM categorie cat WHERE libelle = 'Outillage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (17, 'Tronçonneuses', (SELECT id FROM categorie cat WHERE libelle = 'Thermique'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (18, 'Tondeuses', (SELECT id FROM categorie cat WHERE libelle = 'Thermique'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (19, 'Electricité', (SELECT id FROM categorie cat WHERE libelle = 'Outillage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (20, 'Maçonnerie', (SELECT id FROM categorie cat WHERE libelle = 'Outillage'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (21, 'Truelles', (SELECT id FROM categorie cat WHERE libelle = 'Maçonnerie'));
INSERT INTO categorie(id, libelle, idcatmere) VALUES (22, 'Niveaux', (SELECT id FROM categorie cat WHERE libelle = 'Maçonnerie'));

INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (1, 'TOND0002', 'Tondeuse 12,5 CC 18 CV 64 CM', 654.00, 
	(SELECT id FROM categorie WHERE libelle = 'Tondeuses' AND idcatmere = 
		(SELECT id FROM categorie WHERE libelle = 'Thermique')));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (2, 'PERC0002', 'Perceuse à percussion 18.8 V', 199.00, 
	(SELECT id FROM categorie WHERE libelle = 'Electrique'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (3, 'AMD00004', 'AMD Athlon FX 8350 2,2 GHz', 89.00, 
	(SELECT id FROM categorie WHERE libelle = 'CPU'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (4, 'TRON0005', 'Tronçonneuse 24KW 52 CM', 99.00, 
	(SELECT id FROM categorie WHERE libelle = 'Tronçonneuses' AND idcatmere = 
		(SELECT id FROM categorie WHERE libelle = 'Electrique')));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (5, 'TRU00006', 'Truelle rectangle 25x12', 13.50, 
	(SELECT id FROM categorie WHERE libelle = 'Truelles'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (6, 'NIV00006', 'Niveau aimanté 150CM', 45.50, 
	(SELECT id FROM categorie WHERE libelle = 'Niveaux'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (7, 'SSD00005', 'SSD 128Go 256Mo', 49.00, 
	(SELECT id FROM categorie WHERE libelle = 'SSD'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (8, 'PINC0002', 'Pince coupante', 9.90, 
	(SELECT id FROM categorie WHERE libelle = 'Electricité'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (9, 'AMD00006', 'AMD Athlon Q6600 2 GHz', 49.00, 
	(SELECT id FROM categorie WHERE libelle = 'CPU'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (10, 'AMD00008', 'AMD Athlon FX 6800 1,8 GHz', 69.00, 
	(SELECT id FROM categorie WHERE libelle = 'CPU'));
INSERT INTO produit (id, reference, designation, puht, idcategorie) 
VALUES (11, 'SSD00006', 'SSD 256Go 256Mo', 69.00, 
	(SELECT id FROM categorie WHERE libelle = 'CPU'));

INSERT INTO cpville(id, codepostal, ville) VALUES (1, '33000', 'Bordeaux');
INSERT INTO cpville(id, codepostal, ville) VALUES (2, '33200', 'Bordeaux Caudéran');
INSERT INTO cpville(id, codepostal, ville) VALUES (3, '33700', 'Mérignac');
INSERT INTO cpville(id, codepostal, ville) VALUES (4, '33600', 'Pessac');
INSERT INTO cpville(id, codepostal, ville) VALUES (5, '33115', 'Pyla sur Mer');
INSERT INTO cpville(id, codepostal, ville) VALUES (6, '33115', 'Le moulleau');
INSERT INTO cpville(id, codepostal, ville) VALUES (7, '33620', 'Gazinet');

INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (1, 'DUCK', 'Donald', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (2, 'DUCK', 'Riri', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (3, 'DUCK', 'Fifi', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33600' AND ville = 'Pessac'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (4, 'MISS', 'Tick', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 1);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (5, 'VILLE', 'Brequin', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (6, 'ADHEMAR', 'Patamob', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33115' AND ville = 'Le moulleau'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (7, 'BONNEAU', 'Jean', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (8, 'DEBOUT', 'Bastien', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33620' AND ville = 'Gazinet'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (9, 'DANSLESVOILES', 'Yvan', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 2);
INSERT INTO client(id, nom, prenom, adresse1, adresse2, idcpville, idcivilite) VALUES (10, 'OCHET', 'Frédérique', 'A cette adresse', null, (SELECT id FROM cpville WHERE codepostal = '33000' AND ville = 'Bordeaux'), 3);


INSERT INTO devis(id, code, dureevalidite, datedevis, idclient) VALUES (1, 'D201909001', 30, '2019-09-02', (SELECT id FROM client WHERE nom = 'DUCK' AND prenom = 'Riri'));
INSERT INTO devis(id, code, dureevalidite, datedevis, idclient) VALUES (2, 'D201908129', 30, '2019-08-22', (SELECT id FROM client WHERE nom = 'VILLE' AND prenom = 'Brequin'));
INSERT INTO devis(id, code, dureevalidite, datedevis, idclient) VALUES (3, 'D201906001', 90, '2019-06-04', (SELECT id FROM client WHERE nom = 'BONNEAU' AND prenom = 'Jean'));
INSERT INTO devis(id, code, dureevalidite, datedevis, idclient) VALUES (4, 'D201906002', 60, '2019-06-06', (SELECT id FROM client WHERE nom = 'DEBOUT' AND prenom = 'Bastien'));

INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (1, 
	(SELECT id FROM devis WHERE code = 'D201909001'), null, 5, 
	(SELECT id FROM produit WHERE reference = 'TRU00006'), 
	(SELECT id FROM tva WHERE taux = 5.5)); 
INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (2, 
	(SELECT id FROM devis WHERE code = 'D201909001'), null, 5, 
	(SELECT id FROM produit WHERE reference = 'NIV00006'), 
	(SELECT id FROM tva WHERE taux = 5.5)); 
INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (3, 
	(SELECT id FROM devis WHERE code = 'D201909001'), null, 5, 
	(SELECT id FROM produit WHERE reference = 'TRON0005'), 
	(SELECT id FROM tva WHERE taux = 5.5)); 

INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (4, 
	(SELECT id FROM devis WHERE code = 'D201908129'), null, 8, 
	(SELECT id FROM produit WHERE reference = 'AMD00008'), 
	(SELECT id FROM tva WHERE taux = 20)); 

INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (5, 
	(SELECT id FROM devis WHERE code = 'D201906001'), null, 12, 
	(SELECT id FROM produit WHERE reference = 'SSD00005'), 
	(SELECT id FROM tva WHERE taux = 20)); 
INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (6, 
	(SELECT id FROM devis WHERE code = 'D201906001'), null, 6, 
	(SELECT id FROM produit WHERE reference = 'SSD00006'), 
	(SELECT id FROM tva WHERE taux = 20)); 

INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (7, 
	(SELECT id FROM devis WHERE code = 'D201906002'), null, 21, 
	(SELECT id FROM produit WHERE reference = 'SSD00005'), 
	(SELECT id FROM tva WHERE taux = 20)); 
INSERT INTO lignedevis (id, iddevis, description, qte, idproduit, idtva) 
VALUES (8, 
	(SELECT id FROM devis WHERE code = 'D201906002'), null, 13, 
	(SELECT id FROM produit WHERE reference = 'SSD00006'), 
	(SELECT id FROM tva WHERE taux = 20)); 

INSERT INTO facture (id, code, datefacture, idclient, iddevis)
(SELECT id, REPLACE(code, 'D', 'F'), datedevis, idclient, id FROM devis WHERE code = 'D201908129');
INSERT INTO facture (id, code, datefacture, idclient, iddevis)
(SELECT id, REPLACE(code, 'D', 'F'), datedevis, idclient, id FROM devis WHERE code = 'D201906001');
INSERT INTO facture (id, code, datefacture, idclient, iddevis)
(SELECT id, REPLACE(code, 'D', 'F'), datedevis, idclient, id FROM devis WHERE code = 'D201906002');

INSERT INTO lignefacture (id, idfacture, description, idproduit, idtva, qte)
(
	SELECT lignedevis.id, (SELECT id FROM facture WHERE code = REPLACE(d.code, 'D', 'F')), 
		description, idproduit, idtva, qte 
	FROM lignedevis INNER JOIN devis d ON lignedevis.iddevis = d.id
	WHERE d.id in (SELECT iddevis FROM facture WHERE code = REPLACE(d.code, 'D', 'F'))
);


