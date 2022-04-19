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
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

-- INSERT INTO question Values(2,"cirno","cirno@gmail.com","Tchad",1,1000,"Diesel",20,1000,0,3,0,0,1,0,"appartement",10,"froid",0,0,0,1,1,4,12,"douche",2,10,0,0,50,20,10,120,0,3,"Ampoule basse consomation",0,1,0,1,1,1,0,1,0,0,0,1,1,1,0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


