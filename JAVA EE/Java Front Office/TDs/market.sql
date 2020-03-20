CREATE DATABASE IF NOT EXISTS market;
use market;

CREATE  table client(
 num_client int not null auto_increment, 
 nom varchar(50), 
 adresse text, 
 cp varchar(10), 
 ville varchar(50),
 constraint pk_client primary key (num_client));
 
create table produit(
	code_produit int not null auto_increment,
	designation varchar(50),
	prix_unitaire float,
	disponible tinyint,
	photo_produit text,
	constraint pk_produit primary key (code_produit));

create table commande(
	num_commande int not null auto_increment,
	date_de_commande varchar(10),
	num_client int,
	code_produit int,
	qte_commande int,
	constraint fk_client foreign key(num_client) references client(num_client),
	constraint fk_produit foreign key(code_produit) references produit(code_produit),
	constraint pk_commande primary key (num_commande));