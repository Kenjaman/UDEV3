CREATE TABLE `Plante` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `nom` varcharacter(200) UNIQUE NOT NULL,
  `image` blob,
  `creation_date` datetime DEFAULT "now()"
);

CREATE TABLE `Association` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_plante1` bigint,
  `id_plante2` bigint,
  `qualite` ENUM ('bon', 'neutre', 'mauvais')
);

CREATE TABLE `Utilisateur` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50),
  `creation_date` datetime DEFAULT "now()",
  `login` varchar(50) UNIQUE NOT NULL,
  `mdp` varchar(100)
);

CREATE TABLE `Jardin` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `creation_date` datetime DEFAULT "now()",
  `id_proprietaire` bigint
);

ALTER TABLE `Association` ADD FOREIGN KEY (`id_plante1`) REFERENCES `Plante` (`id`);

ALTER TABLE `Association` ADD FOREIGN KEY (`id_plante2`) REFERENCES `Plante` (`id`);

ALTER TABLE `Jardin` ADD FOREIGN KEY (`id_proprietaire`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Plante` ADD FOREIGN KEY (`id`) REFERENCES `Jardin` (`id`);
