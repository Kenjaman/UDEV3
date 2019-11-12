drop table client;
drop table adoption;
drop table animal;
drop table espece;
drop table race;


CREATE TABLE Client (
  id numeric(5)  NOT NULL ,
  nom varchar(100) NOT NULL,
  prenom varchar(60) NOT NULL,
  adresse varchar(200) DEFAULT NULL,
  code_postal varchar(6) DEFAULT NULL,
  ville varchar(60) DEFAULT NULL,
  pays varchar(60) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  date_naissance date DEFAULT NULL,
  PRIMARY KEY (id)
);


INSERT INTO Client VALUES (1,'Dupont','Jean','Rue du Centre, 5','45810','Houtsiplou','France','jean.dupont@email.com',NULL);
INSERT INTO Client VALUES (2,'Boudur','Marie','Place de la Gare, 2','35840','Troudumonde','France','marie.boudur@email.com',NULL);
INSERT INTO Client VALUES (3,'Trachon','Fleur','Rue haute, 54b','3250','Belville','Belgique','fleurtrachon@email.com',NULL);
INSERT INTO Client VALUES (4,'Van Piperseel','Julien',NULL,NULL,NULL,NULL,'jeanvp@email.com',NULL);
INSERT INTO Client VALUES (5,'Nouvel','Johan',NULL,NULL,NULL,'Suisse','johanetpirlouit@email.com',NULL);
INSERT INTO Client VALUES (6,'Germain','Frank',NULL,NULL,NULL,NULL,'francoisgermain@email.com',NULL);
INSERT INTO Client VALUES (7,'Antoine','Maximilien','Rue Moineau, 123','4580','Trocoul','Belgique','max.antoine@email.com',NULL);
INSERT INTO Client VALUES (8,'Di Paolo','Hector',NULL,NULL,NULL,'Suisse','hectordipao@email.com',NULL);
INSERT INTO Client VALUES (9,'Corduro','Anaelle',NULL,NULL,NULL,NULL,'ana.corduro@email.com',NULL);
INSERT INTO Client VALUES (10,'Faluche','Eline','Avenue circulaire, 7','45870','Garduche','France','elinefaluche@email.com',NULL);
INSERT INTO Client VALUES (11,'Penni','Carine','Boulevard Haussman, 85','1514','Plasse','Suisse','cpenni@email.com',NULL);
INSERT INTO Client VALUES (12,'Broussaille','Virginie','Rue du Fleuve, 18','45810','Houtsiplou','France','vibrousaille@email.com',NULL);
INSERT INTO Client VALUES (13,'Durant','Hannah','Rue des Pendus, 66','1514','Plasse','Suisse','hhdurant@email.com',NULL);
INSERT INTO Client VALUES (14,'Delfour','Elodie','Rue de Flore, 1','3250','Belville','Belgique','e.delfour@email.com',NULL);
INSERT INTO Client VALUES (15,'Kestau','Joel',NULL,NULL,NULL,NULL,'joel.kestau@email.com',NULL);



CREATE TABLE Espece (
  id numeric(6)  NOT NULL ,
  nom_courant varchar(40) NOT NULL,
  nom_latin varchar(40) NOT NULL,
  description varchar(500),
  prix decimal(7,2)  DEFAULT NULL,
  PRIMARY KEY (id)
) ;


INSERT INTO Espece VALUES (1,'Chien','Canis canis','Bestiole à quatre pattes qui aime les caresses et tire souvent la langue',200.00);
INSERT INTO Espece VALUES (2,'Chat','Felis silvestris','Bestiole à quatre pattes qui saute très haut et grimpe aux arbres',150.00);
INSERT INTO Espece VALUES (3,'Tortue d''Hermann','Testudo hermanni','Bestiole avec une carapace très dure',140.00);
INSERT INTO Espece VALUES (4,'Perroquet amazone','Alipiopsitta xanthops','Joli oiseau parleur vert et jaune',700.00);
INSERT INTO Espece VALUES (5,'Rat brun','Rattus norvegicus','Petite bestiole avec de longues moustaches et une longue queue sans poils',10.00);
INSERT INTO Espece VALUES (6,'Perruche terrestre','Pezoporus wallicus','Joli oiseau aux plumes majoritairement vert brillant',20.00);


drop table Race;
CREATE TABLE Race (
  id numeric(6)  NOT NULL ,
  nom varchar(40) NOT NULL,
  espece_id numeric(6)  NOT NULL,
  description varchar(500),
  prix decimal(7,2)  DEFAULT NULL,
  date_insertion timestamp DEFAULT NULL,
  utilisateur_insertion varchar(20) DEFAULT NULL,
  date_modification timestamp DEFAULT NULL,
  utilisateur_modification varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
  );

INSERT INTO Race VALUES (1,'Berger allemand',1,'Chien sportif et élégant au pelage dense, noir-marron-fauve, noir ou gris.',485.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (2,'Berger blanc suisse',1,'Petit chien au corps compact, avec des pattes courtes mais bien proportionnées et au pelage tricolore ou bicolore.',935.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (3,'Singapura',2,'Chat de petite taille aux grands yeux en amandes.',985.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (4,'Bleu russe',2,'Chat aux yeux verts et à la robe épaisse et argentée.',835.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (5,'Maine Coon',2,'Chat de grande taille, à poils mi-longs.',735.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'sdz@localhost');
INSERT INTO Race VALUES (7,'Sphynx',2,'Chat sans poils.',1235.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (8,'Nebelung',2,'Chat bleu russe, mais avec des poils longs...',985.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test');
INSERT INTO Race VALUES (9,'Rottweiller',1,'Chien d''apparence solide, bien musclé, à la robe noire avec des taches feu bien délimitées.',630.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'Test',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'sdz@localhost');
INSERT INTO Race VALUES (10,'Yorkshire terrier',1,'Chien de petite taille au pelage long et soyeux de couleur bleu et feu.',700.00,TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'sdz@localhost',TO_TIMESTAMP('2012-05-21 00:53:36', 'YYYY-MM-DD HH24:MI:SS'),'sdz@localhost');



CREATE TABLE Animal (
  id numeric(6)  NOT NULL ,
  sexe char(1) DEFAULT NULL,
  date_naissance timestamp NOT NULL,
  nom varchar(30) DEFAULT NULL,
  commentaires varchar(500),
  espece_id numeric(6)  NOT NULL,
  race_id numeric(6)  DEFAULT NULL,
  mere_id numeric(6)  DEFAULT NULL,
  pere_id numeric(6)  DEFAULT NULL,
  disponible int DEFAULT '1',
  PRIMARY KEY (id));

INSERT INTO Animal VALUES (1,'M',TO_TIMESTAMP('2010-04-05 13:43:00' ,'YYYY/MM/DD HH24:MI:SS'),'Rox','Mordille beaucoup',1,1,18,22,1);
INSERT INTO Animal VALUES (2,NULL,TO_TIMESTAMP('2010-03-24 02:23:00' ,'YYYY/MM/DD HH24:MI:SS'),'Roucky',NULL,2,NULL,40,30,1);
INSERT INTO Animal VALUES (3,'F',TO_TIMESTAMP('2010-09-13 15:02:00' ,'YYYY/MM/DD HH24:MI:SS'),'Schtroumpfette',NULL,2,4,41,31,0);
INSERT INTO Animal VALUES (4,'F',TO_TIMESTAMP('2009-08-03 05:12:00' ,'YYYY/MM/DD HH24:MI:SS'),NULL,'Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (5,NULL,TO_TIMESTAMP('2010-10-03 16:44:00' ,'YYYY/MM/DD HH24:MI:SS'),'Choupi','Né sans oreille gauche',2,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (6,'F',TO_TIMESTAMP('2009-06-13 08:17:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bobosse','Carapace bizarre',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (7,'F',TO_TIMESTAMP('2008-12-06 05:18:00' ,'YYYY/MM/DD HH24:MI:SS'),'Caroline',NULL,1,2,NULL,NULL,1);
INSERT INTO Animal VALUES (8,'M',TO_TIMESTAMP('2008-09-11 15:38:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bagherra',NULL,2,5,NULL,NULL,0);
INSERT INTO Animal VALUES (9,NULL,TO_TIMESTAMP('2010-08-23 05:18:00' ,'YYYY/MM/DD HH24:MI:SS'),NULL,'Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (10,'M',TO_TIMESTAMP('2010-07-21 15:41:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bobo','Petit pour son âge',1,NULL,7,21,1);
INSERT INTO Animal VALUES (11,'F',TO_TIMESTAMP('2008-02-20 15:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Canaille',NULL,1,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (12,'F',TO_TIMESTAMP('2009-05-26 08:54:00' ,'YYYY/MM/DD HH24:MI:SS'),'Cali',NULL,1,2,NULL,NULL,1);
INSERT INTO Animal VALUES (13,'F',TO_TIMESTAMP('2007-04-24 12:54:00' ,'YYYY/MM/DD HH24:MI:SS'),'Rouquine',NULL,1,1,NULL,NULL,1);
INSERT INTO Animal VALUES (14,'F',TO_TIMESTAMP('2009-05-26 08:56:00' ,'YYYY/MM/DD HH24:MI:SS'),'Fila',NULL,1,2,NULL,NULL,1);
INSERT INTO Animal VALUES (15,'F',TO_TIMESTAMP('2008-02-20 15:47:00' ,'YYYY/MM/DD HH24:MI:SS'),'Anya',NULL,1,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (16,'F',TO_TIMESTAMP('2009-05-26 08:50:00' ,'YYYY/MM/DD HH24:MI:SS'),'Louya',NULL,1,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (17,'F',TO_TIMESTAMP('2008-03-10 13:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Welva',NULL,1,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (18,'F',TO_TIMESTAMP('2007-04-24 12:59:00' ,'YYYY/MM/DD HH24:MI:SS'),'Zira',NULL,1,1,NULL,NULL,0);
INSERT INTO Animal VALUES (19,'F',TO_TIMESTAMP('2009-05-26 09:02:00' ,'YYYY/MM/DD HH24:MI:SS'),'Java',NULL,2,4,NULL,NULL,1);
INSERT INTO Animal VALUES (20,NULL,TO_TIMESTAMP('2007-04-24 12:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Balou',NULL,1,1,NULL,NULL,1);
INSERT INTO Animal VALUES (21,'F',TO_TIMESTAMP('2008-03-10 13:43:00' ,'YYYY/MM/DD HH24:MI:SS'),'Pataude','Rhume chronique',1,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (22,'M',TO_TIMESTAMP('2007-04-24 12:42:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bouli',NULL,1,1,NULL,NULL,1);
INSERT INTO Animal VALUES (24,'M',TO_TIMESTAMP('2007-04-12 05:23:00' ,'YYYY/MM/DD HH24:MI:SS'),'Cartouche',NULL,1,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (25,'M',TO_TIMESTAMP('2006-05-14 15:50:00' ,'YYYY/MM/DD HH24:MI:SS'),'Zambo',NULL,1,1,NULL,NULL,1);
INSERT INTO Animal VALUES (26,'M',TO_TIMESTAMP('2006-05-14 15:48:00' ,'YYYY/MM/DD HH24:MI:SS'),'Samba',NULL,1,1,NULL,NULL,0);
INSERT INTO Animal VALUES (27,'M',TO_TIMESTAMP('2008-03-10 13:40:00' ,'YYYY/MM/DD HH24:MI:SS'),'Moka',NULL,1,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (28,'M',TO_TIMESTAMP('2006-05-14 15:40:00' ,'YYYY/MM/DD HH24:MI:SS'),'Pilou',NULL,1,1,NULL,NULL,1);
INSERT INTO Animal VALUES (29,'M',TO_TIMESTAMP('2009-05-14 06:30:00' ,'YYYY/MM/DD HH24:MI:SS'),'Fiero',NULL,2,3,NULL,NULL,1);
INSERT INTO Animal VALUES (30,'M',TO_TIMESTAMP('2007-03-12 12:05:00' ,'YYYY/MM/DD HH24:MI:SS'),'Zonko',NULL,2,5,NULL,NULL,0);
INSERT INTO Animal VALUES (31,'M',TO_TIMESTAMP('2008-02-20 15:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Filou',NULL,2,4,NULL,NULL,1);
INSERT INTO Animal VALUES (32,'M',TO_TIMESTAMP('2009-07-26 11:52:00' ,'YYYY/MM/DD HH24:MI:SS'),'Spoutnik',NULL,3,NULL,52,NULL,0);
INSERT INTO Animal VALUES (33,'M',TO_TIMESTAMP('2006-05-19 16:17:00' ,'YYYY/MM/DD HH24:MI:SS'),'Caribou',NULL,2,4,NULL,NULL,1);
INSERT INTO Animal VALUES (34,'M',TO_TIMESTAMP('2008-04-20 03:22:00' ,'YYYY/MM/DD HH24:MI:SS'),'Capou',NULL,2,5,NULL,NULL,1);
INSERT INTO Animal VALUES (35,'M',TO_TIMESTAMP('2006-05-19 16:56:00' ,'YYYY/MM/DD HH24:MI:SS'),'Raccou','Pas de queue depuis la naissance',2,4,NULL,NULL,1);
INSERT INTO Animal VALUES (36,'M',TO_TIMESTAMP('2009-05-14 06:42:00' ,'YYYY/MM/DD HH24:MI:SS'),'Boucan',NULL,2,3,NULL,NULL,1);
INSERT INTO Animal VALUES (37,'F',TO_TIMESTAMP('2006-05-19 16:06:00' ,'YYYY/MM/DD HH24:MI:SS'),'Callune',NULL,2,8,NULL,NULL,1);
INSERT INTO Animal VALUES (38,'F',TO_TIMESTAMP('2009-05-14 06:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Boule',NULL,2,3,NULL,NULL,0);
INSERT INTO Animal VALUES (39,'F',TO_TIMESTAMP('2008-04-20 03:26:00' ,'YYYY/MM/DD HH24:MI:SS'),'Zara',NULL,2,5,NULL,NULL,0);
INSERT INTO Animal VALUES (40,'F',TO_TIMESTAMP('2007-03-12 12:00:00' ,'YYYY/MM/DD HH24:MI:SS'),'Milla',NULL,2,5,NULL,NULL,0);
INSERT INTO Animal VALUES (41,'F',TO_TIMESTAMP('2006-05-19 15:59:00' ,'YYYY/MM/DD HH24:MI:SS'),'Feta',NULL,2,4,NULL,NULL,0);
INSERT INTO Animal VALUES (42,'F',TO_TIMESTAMP('2008-04-20 03:20:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bilba','Sourde de l''oreille droite à 80%',2,5,NULL,NULL,0);
INSERT INTO Animal VALUES (43,'F',TO_TIMESTAMP('2007-03-12 11:54:00' ,'YYYY/MM/DD HH24:MI:SS'),'Cracotte',NULL,2,5,NULL,NULL,1);
INSERT INTO Animal VALUES (44,'F',TO_TIMESTAMP('2006-05-19 16:16:00' ,'YYYY/MM/DD HH24:MI:SS'),'Cawette',NULL,2,8,NULL,NULL,1);
INSERT INTO Animal VALUES (45,'F',TO_TIMESTAMP('2007-04-01 18:17:00' ,'YYYY/MM/DD HH24:MI:SS'),'Nikki','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (46,'F',TO_TIMESTAMP('2009-03-24 08:23:00' ,'YYYY/MM/DD HH24:MI:SS'),'Tortilla','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (48,'F',TO_TIMESTAMP('2006-03-15 14:56:00' ,'YYYY/MM/DD HH24:MI:SS'),'Lulla','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (49,'F',TO_TIMESTAMP('2008-03-15 12:02:00' ,'YYYY/MM/DD HH24:MI:SS'),'Dana','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (50,'F',TO_TIMESTAMP('2009-05-25 19:57:00' ,'YYYY/MM/DD HH24:MI:SS'),'Cheli','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (51,'F',TO_TIMESTAMP('2007-04-01 03:54:00' ,'YYYY/MM/DD HH24:MI:SS'),'Chicaca','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (52,'F',TO_TIMESTAMP('2006-03-15 14:26:00' ,'YYYY/MM/DD HH24:MI:SS'),'Redbul','Insomniaque',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (54,'M',TO_TIMESTAMP('2008-03-16 08:20:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bubulle','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (55,'M',TO_TIMESTAMP('2008-03-15 18:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Relou','Surpoids',3,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (56,'M',TO_TIMESTAMP('2009-05-25 18:54:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bulbizard','Bestiole avec une carapace très dure',3,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (57,'M',TO_TIMESTAMP('2007-03-04 19:36:00' ,'YYYY/MM/DD HH24:MI:SS'),'Safran','Coco veut un gâteau !',4,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (58,'M',TO_TIMESTAMP('2008-02-20 02:50:00' ,'YYYY/MM/DD HH24:MI:SS'),'Gingko','Coco veut un gâteau !',4,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (59,'M',TO_TIMESTAMP('2009-03-26 08:28:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bavard','Coco veut un gâteau !',4,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (60,'F',TO_TIMESTAMP('2009-03-26 07:55:00' ,'YYYY/MM/DD HH24:MI:SS'),'Parlotte','Coco veut un gâteau !',4,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (61,'M',TO_TIMESTAMP('2010-11-09 00:00:00' ,'YYYY/MM/DD HH24:MI:SS'),'Yoda',NULL,2,5,NULL,NULL,1);
INSERT INTO Animal VALUES (62,'M',TO_TIMESTAMP('2010-11-05 00:00:00' ,'YYYY/MM/DD HH24:MI:SS'),'Pipo',NULL,1,9,NULL,NULL,0);
INSERT INTO Animal VALUES (69,'F',TO_TIMESTAMP('2012-02-13 15:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Baba',NULL,5,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (70,'M',TO_TIMESTAMP('2012-02-13 15:48:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bibo','Agressif',5,NULL,72,73,1);
INSERT INTO Animal VALUES (72,'F',TO_TIMESTAMP('2008-02-01 02:25:00' ,'YYYY/MM/DD HH24:MI:SS'),'Momy',NULL,5,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (73,'M',TO_TIMESTAMP('2007-03-11 12:45:00' ,'YYYY/MM/DD HH24:MI:SS'),'Popi',NULL,5,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (75,'F',TO_TIMESTAMP('2007-03-12 22:03:00' ,'YYYY/MM/DD HH24:MI:SS'),'Mimi',NULL,5,NULL,NULL,NULL,0);
INSERT INTO Animal VALUES (76,'M',TO_TIMESTAMP('2012-03-12 00:00:00' ,'YYYY/MM/DD HH24:MI:SS'),'Rocco',NULL,1,9,NULL,NULL,1);
INSERT INTO Animal VALUES (77,'F',TO_TIMESTAMP('2011-09-21 15:14:00' ,'YYYY/MM/DD HH24:MI:SS'),'Bambi',NULL,2,NULL,NULL,NULL,1);
INSERT INTO Animal VALUES (78,'M',TO_TIMESTAMP('2012-02-28 03:05:00' ,'YYYY/MM/DD HH24:MI:SS'),'Pumba','Prématuré, à surveiller',1,9,NULL,NULL,1);
INSERT INTO Animal VALUES (79,'M',TO_TIMESTAMP('2011-05-24 23:51:00' ,'YYYY/MM/DD HH24:MI:SS'),'Lion',NULL,2,5,NULL,NULL,1);



CREATE TABLE Adoption (
  client_id numeric(5)  NOT NULL,
  animal_id numeric(5)  NOT NULL,
  date_reservation date NOT NULL,
  date_adoption date DEFAULT NULL,
  prix decimal(7,2)  NOT NULL,
  paye int  DEFAULT '0' NOT NULL,
  PRIMARY KEY (client_id,animal_id));

INSERT INTO Adoption VALUES (1,8,TO_DATE('2012-05-21' ,'YYYY/MM/DD'),NULL,735.00,1);
INSERT INTO Adoption VALUES (1,39,TO_DATE('2008-08-17','YYYY/MM/DD'),TO_DATE('2008-08-17','YYYY/MM/DD'),735.00,1);
INSERT INTO Adoption VALUES (1,40,TO_DATE('2008-08-17','YYYY/MM/DD'),TO_DATE('2008-08-17','YYYY/MM/DD'),735.00,1);
INSERT INTO Adoption VALUES (2,3,TO_DATE('2011-03-12','YYYY/MM/DD'),TO_DATE('2011-03-12','YYYY/MM/DD'),835.00,1);
INSERT INTO Adoption VALUES (2,18,TO_DATE('2008-06-04','YYYY/MM/DD'),TO_DATE('2008-06-04','YYYY/MM/DD'),485.00,1);
INSERT INTO Adoption VALUES (3,27,TO_DATE('2009-11-17','YYYY/MM/DD'),TO_DATE('2009-11-17','YYYY/MM/DD'),200.00,1);
INSERT INTO Adoption VALUES (4,26,TO_DATE('2007-02-21','YYYY/MM/DD'),TO_DATE('2007-02-21','YYYY/MM/DD'),485.00,1);
INSERT INTO Adoption VALUES (4,41,TO_DATE('2007-02-21','YYYY/MM/DD'),TO_DATE('2007-02-21','YYYY/MM/DD'),835.00,1);
INSERT INTO Adoption VALUES (5,21,TO_DATE('2009-03-08','YYYY/MM/DD'),TO_DATE('2009-03-08','YYYY/MM/DD'),200.00,1);
INSERT INTO Adoption VALUES (6,16,TO_DATE('2010-01-27','YYYY/MM/DD'),TO_DATE('2010-01-27','YYYY/MM/DD'),200.00,1);
INSERT INTO Adoption VALUES (7,5,TO_DATE('2011-04-05','YYYY/MM/DD'),TO_DATE('2011-04-05','YYYY/MM/DD'),150.00,1);
INSERT INTO Adoption VALUES (8,42,TO_DATE('2008-08-16','YYYY/MM/DD'),TO_DATE('2008-08-16','YYYY/MM/DD'),735.00,1);
INSERT INTO Adoption VALUES (9,38,TO_DATE('2007-02-11','YYYY/MM/DD'),TO_DATE('2007-02-11','YYYY/MM/DD'),985.00,1);
INSERT INTO Adoption VALUES (9,55,TO_DATE('2011-02-13','YYYY/MM/DD'),TO_DATE('2011-02-13','YYYY/MM/DD'),140.00,1);
INSERT INTO Adoption VALUES (9,59,TO_DATE('2012-05-22','YYYY/MM/DD'),NULL,700.00,0);
INSERT INTO Adoption VALUES (10,49,TO_DATE('2010-08-17','YYYY/MM/DD'),TO_DATE('2010-08-17','YYYY/MM/DD'),140.00,0);
INSERT INTO Adoption VALUES (11,32,TO_DATE('2008-08-17','YYYY/MM/DD'),TO_DATE('2010-03-09','YYYY/MM/DD'),140.00,1);
INSERT INTO Adoption VALUES (11,62,TO_DATE('2011-03-01','YYYY/MM/DD'),TO_DATE('2011-03-01','YYYY/MM/DD'),630.00,0);
INSERT INTO Adoption VALUES (12,15,TO_DATE('2012-05-22','YYYY/MM/DD'),NULL,200.00,1);
INSERT INTO Adoption VALUES (12,69,TO_DATE('2007-09-20','YYYY/MM/DD'),TO_DATE('2007-09-20','YYYY/MM/DD'),10.00,1);
INSERT INTO Adoption VALUES (12,75,TO_DATE('2012-05-21','YYYY/MM/DD'),NULL,10.00,0);
INSERT INTO Adoption VALUES (13,57,TO_DATE('2012-01-10','YYYY/MM/DD'),TO_DATE('2012-01-10','YYYY/MM/DD'),700.00,1);
INSERT INTO Adoption VALUES (14,58,TO_DATE('2012-02-25','YYYY/MM/DD'),TO_DATE('2012-02-25','YYYY/MM/DD'),700.00,1);
INSERT INTO Adoption VALUES (15,30,TO_DATE('2008-08-17','YYYY/MM/DD'),TO_DATE('2008-08-17','YYYY/MM/DD'),735.00,1);


ALTER TABLE Race ADD CONSTRAINT fk_race_espece_id FOREIGN KEY (espece_id) REFERENCES Espece (id);
ALTER TABLE Animal ADD CONSTRAINT fk_espece_id FOREIGN KEY (espece_id) REFERENCES Espece (id);
ALTER TABLE Animal ADD CONSTRAINT fk_mere_id FOREIGN KEY (mere_id) REFERENCES Animal (id);
ALTER TABLE Animal ADD CONSTRAINT fk_pere_id FOREIGN KEY (pere_id) REFERENCES Animal (id);
ALTER TABLE Animal ADD CONSTRAINT fk_race_id FOREIGN KEY (race_id) REFERENCES Race (id);
ALTER TABLE Adoption ADD CONSTRAINT fk_adoption_animal_id FOREIGN KEY (animal_id) REFERENCES Animal (id);
ALTER TABLE Adoption ADD CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES Client (id) ON DELETE CASCADE;
ALTER TABLE Adoption DROP CONSTRAINT fk_client_id;

commit;