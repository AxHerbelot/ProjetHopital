CREATE DATABASE IF NOT EXISTS `hopital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hopital`;

DROP TABLE IF EXISTS `compte`;
CREATE TABLE `compte` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(200) DEFAULT NULL,
  `mdp` varchar(200) DEFAULT NULL,
  `typeCompte` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `idPatient` int NOT NULL,
  `nom` varchar(200) DEFAULT NULL,
  `prenom` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idPatient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `visite`;
CREATE TABLE `visite` (
  `numeroVisite` int NOT NULL,
  `idPatient` int DEFAULT NULL,
  `id` int DEFAULT NULL,
  `cout` double DEFAULT NULL,
  `salle` varchar(6) DEFAULT NULL,
  `dateVisite` datetime DEFAULT NULL,
  PRIMARY KEY (`numeroVisite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
