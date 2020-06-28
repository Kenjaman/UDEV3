-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE IF NOT EXISTS `permApp`;
USE `permApp`;
DROP TABLE IF EXISTS `Plante`;
CREATE TABLE `Plante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(200) NOT NULL,
  `date_creation` date NOT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Plante` (`id`, `nom`, `date_creation`, `image`) VALUES
(1,	'Tomate',	'2020-06-22',	NULL),
(2,	'patate',	'2020-06-22',	NULL);

DROP TABLE IF EXISTS `Association`;
CREATE TABLE `Association` (
  `id_plante1` int NOT NULL,
  `id_plante2` int NOT NULL,
  `relation` varchar(10) NOT NULL,
  PRIMARY KEY (`id_plante1`,`id_plante2`),
  CONSTRAINT `Association_ibfk_2` FOREIGN KEY (`id_plante1`) REFERENCES `Plante` (`id`),
  CONSTRAINT `Association_ibfk_3` FOREIGN KEY (`id_plante2`) REFERENCES `Plante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Association` (`id_plante1`, `id_plante2`, `relation`) VALUES
( 1,	2,	'Mauvais');


-- 2020-06-23 11:02:12
