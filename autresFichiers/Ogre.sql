CREATE DATABASE  IF NOT EXISTS OGRE CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE OGRE;

-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 29, 2022 at 03:37 PM
-- Server version: 8.0.27
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `OGRE`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS adherant;

CREATE TABLE adherant (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom varchar(45) DEFAULT NULL,
  prenom varchar(45) DEFAULT NULL,
  genre varchar(45) DEFAULT NULL,
  date_de_naissance date DEFAULT NULL,
  promo varchar(45) DEFAULT NULL,
  campus varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  mailing_liste BOOL DEFAULT 0,
  cotisant tinyint DEFAULT 0,
  connaissances_info varchar(45) DEFAULT NULL,
  attentes varchar(45) DEFAULT NULL,
  centres_interet varchar(45) DEFAULT NULL);

    INSERT INTO adherant Values (1, 'John', 'Doe', 'M','1999-03-30', 'ING2','Cergy', 'John@cy-tech.fr', 1, 1,"","","");
    INSERT INTO adherant Values (2, 'rené', 'provence', 'neutre','1999-03-30', 'ING2','Pau', 'rené@cy-tech.fr', 0, 0,"","","");
    INSERT INTO adherant Values (3, 'guillaume', 'Ricou', 'M','1999-04-30', 'ING3','Cergy', 'guigui@cy-tech.fr', 1, 1,"","","");
    INSERT INTO adherant Values (4, 'John', 'Deux', 'F','1999-03-30', 'ING2','Cergy', 'John2@cy-tech.fr', 1, 0,"","","");
    INSERT INTO adherant Values (5, 'John', 'trois', 'M','1999-03-30', 'ING3','Cergy', 'Johny3@cy-tech.fr', 1, 0,"","","");
    INSERT INTO adherant Values (6, 'DAVID', 'Doa', 'David','1999-03-30', 'ING3','Cergy', 'David@cy-tech.fr', 1, 1,"","","");
  	INSERT INTO adherant Values (7, 'Jeveu', 'Payer', 'argent','2000-12-30', 'ING3','Cergy', 'argentd@cy-tech.fr', 1, 2,"","","");


CREATE TABLE `accounts` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rank` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 18, 2022 at 05:06 PM
-- Server version: 8.0.27
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `OGRE`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `question` (
  `id` int NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `voiturePossede` int NOT NULL,
  `voitureKM` int NOT NULL,
  `voitureEnergie` varchar(255) NOT NULL,
  `voitureConso` int NOT NULL,
  `voitureKMSeul` int NOT NULL,
  `voitureKMTous` int NOT NULL,
  `voitureRemplacement` varchar(255) NOT NULL,
  `avionKM` int NOT NULL,
  `trainKM` int NOT NULL,
  `logementAdulte` int NOT NULL,
  `logementEnfant` int NOT NULL,
  `logementType` varchar(255) NOT NULL,
  `logementSurface` int NOT NULL,
  `chauffageEnergie` varchar(255) NOT NULL,
  `energieKWH` int DEFAULT NULL,
  `energieFacture` int NOT NULL,
  `pompeChaleur` int NOT NULL,
  `temperatureConfort` int NOT NULL,
  `climatisation` int NOT NULL,
  `climatisationPieces` int NOT NULL,
  `climatisationsTemps` int NOT NULL,
  `bainsOUDouches` varchar(255) NOT NULL,
  `doucheFrequence` int NOT NULL,
  `doucheDuree` varchar(255) NOT NULL,
  `bouilloire` int NOT NULL,
  `plaqueCuisson` int NOT NULL,
  `four` int NOT NULL,
  `laveLinge` int NOT NULL,
  `secheLinge` int NOT NULL,
  `laveVaisselle` int NOT NULL,
  `refrigirateur` int NOT NULL,
  `congelateur` int NOT NULL,
  `eclairage` varchar(255) NOT NULL,
  `vegetalien` int NOT NULL,
  `fruitETLegume` int NOT NULL,
  `produitLaitier` int NOT NULL,
  `oeufs` int NOT NULL,
  `viande` int NOT NULL,
  `canette` int NOT NULL,
  `emballage` int NOT NULL,
  `locaux` int NOT NULL,
  `chat` int NOT NULL,
  `chien` int NOT NULL,
  `cheval` int NOT NULL,
  `equipementNumerique` int NOT NULL,
  `internet` int NOT NULL,
  `videos` int NOT NULL,
  `vetements` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


