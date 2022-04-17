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

-- --------------------------------------------------------

--
-- Table structure for table `answers_TypeInteger`
--

CREATE TABLE `answers_TypeInteger` (
  `participantUUID` binary(16) NOT NULL,
  `questionID` int NOT NULL,
  `answer` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `answers_TypeList`
--

CREATE TABLE `answers_TypeList` (
  `participantUUID` binary(16) NOT NULL,
  `questionID` int NOT NULL,
  `answerID` tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `answers_TypeText`
--

CREATE TABLE `answers_TypeText` (
  `participantUUID` binary(16) NOT NULL,
  `questionID` int NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `participants`
--

CREATE TABLE `participants` (
  `participantUUID` binary(16) NOT NULL,
  `startedTimestamp` timestamp NOT NULL,
  `endedTimestamp` timestamp NULL DEFAULT NULL,
  `lastModifiedTimestamp` timestamp NULL DEFAULT NULL,
  `editingTime` int NOT NULL,
  `origine` varchar(255) NOT NULL,
  `device` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `questionID` int NOT NULL,
  `sectionID` int NOT NULL,
  `priority` tinyint NOT NULL,
  `questionTypeID` tinyint NOT NULL,
  `text` text NOT NULL,
  `isOptionnal` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionID`, `sectionID`, `priority`, `questionTypeID`, `text`, `isOptionnal`) VALUES
(1, 1, 1, 2, 'Quel est votre prénom ?', 0),
(2, 1, 2, 2, 'Quelle est votre adresse e-mail ?', 0),
(3, 1, 3, 2, 'Quel est votre pays de résidence ?', 0),
(4, 2, 1, 1, 'Avez-vous une voiture ?', 0),
(5, 2, 2, 5, 'Même si vous ne possédez pas de voiture, combien de kilomètres par an effectuez-vous en moyenne (avec d\'autres personnes) ?', 0),
(6, 2, 3, 3, 'Quelle énergie utilise votre voiture ?', 0),
(7, 2, 4, 5, 'Quelle est la consommation moyenne, en litres pour 100 kilomètres, de ce véhicule ? (ex: 6)', 0),
(8, 2, 5, 5, '(VOITURE) En moyenne, combien de kilomètres par an parcourez-vous seul ?', 0),
(9, 2, 6, 5, '(VOITURE) En moyenne, combien de kilomètres par an parcourez-vous avec les personnes composant le ménage ? (ex: vacances)', 0),
(10, 2, 7, 3, 'En moyenne, quelle est votre fréquence de remplacement de votre véhicule ?', 0),
(11, 2, 8, 5, '(AVION) En moyenne, combien de kilomètres par an parcourez-vous ? (faites une moyenne sur les 5 dernières années)', 0),
(12, 2, 9, 5, '(TRAIN) En moyenne, combien de kilomètres par an parcourez-vous ? (faites une moyenne sur les 5 dernières années)', 0),
(13, 3, 1, 5, 'Combien d\'adulte(s) habite(nt) au sein de votre logement ?', 0),
(14, 3, 2, 5, 'Combien d\'enfant(s) de moins de 18 ans habite(nt) au sein de votre logement ?', 0),
(15, 3, 3, 3, 'Quel est le type de votre logement ?', 0),
(16, 3, 4, 5, 'Quelle est la surface de votre logement (en m2) ?', 0),
(17, 3, 5, 3, 'Quelle est l\'énergie principale de chauffage ?', 0),
(18, 3, 6, 5, 'Quel est le nombre de kWh (kilowatt-heure) consommé PAR AN ? Cette valeur est disponible sur la facture transmise par votre fournisseur d\'énergie. Si jamais vous ne savez pas, vous pouvez passer à la question suivante où cette valeur vous est demandée en €', 1),
(19, 3, 7, 5, 'Quel est le montant de votre facture d\'énergie ANNUELLE en € pour le chauffage (fioul, gaz, bois) ? Si vous avez un chauffage électrique, indiquez le montant ANNUEL de votre facture.', 0),
(20, 3, 8, 1, 'Est-ce que vous avez installé une pompe à chaleur de type air/eau ou eau/eau ?', 0),
(21, 3, 9, 1, 'Votre température de confort est-elle supérieure à 19°C ?', 0),
(22, 3, 10, 1, 'Utilisez-vous un système de climatisation ?', 0),
(23, 3, 11, 5, 'Combien de pièces de votre logement sont équipées d\'un système de climatisation ?', 0),
(24, 3, 12, 5, 'En moyenne, combien de jours par an votre système de climatisation fonctionne-t-il ?', 0),
(25, 3, 13, 3, 'Prenez-vous des bains ou des douches ?', 0),
(26, 3, 14, 5, 'En moyenne, combien de fois par jour prenez-vous une douche ?', 0),
(27, 3, 15, 3, 'En moyenne, combien de temps dure une douche ?', 0),
(28, 3, 16, 1, 'Utilisez-vous une bouilloire pour chauffer l\'eau ?', 0),
(29, 3, 17, 5, 'En moyenne, combien de temps par jour utilisez-vous vos plaques de cuisson ? (en minutes)', 0),
(30, 3, 18, 5, 'En moyenne, combien de temps par jour utilisez-vous votre four ? (en minutes)', 0),
(31, 3, 19, 5, 'En moyenne, combien de temps par jour utilisez-vous votre lave-linge ? (en minutes)', 0),
(32, 3, 20, 5, 'En moyenne, combien de temps par jour utilisez-vous votre sèche-linge ? (en minutes)', 0),
(33, 3, 21, 5, 'En moyenne, combien de temps par jour utilisez-vous votre lave-vaisselle ? (en minutes)', 0),
(34, 3, 22, 5, 'Combien de réfrigérateur possédez-vous ?', 0),
(35, 3, 23, 5, 'Combien de congélateur possédez-vous ?', 0),
(36, 3, 24, 3, 'Quel est votre système d\'éclairage ?', 0),
(37, 4, 1, 1, 'Êtes-vous végétalien (vegan) ?', 0),
(38, 4, 2, 1, 'Consommez-vous des fruits et des légumes ?', 0),
(39, 4, 3, 1, 'Consommez-vous des produits laitiers ?', 0),
(40, 4, 4, 1, 'Consommez-vous des oeufs ?', 0),
(41, 4, 5, 1, 'Consommez-vous de la viande ?', 0),
(42, 4, 6, 5, 'En moyenne, combien de boissons en canette consommez-vous par jour ? (indiquer 0 si vous n\'en consommez pas)', 0),
(43, 4, 7, 1, 'Achetez-vous UNIQUEMENT des produits sans emballage ?', 0),
(44, 4, 8, 1, 'Consommez-vous UNIQUEMENT des produits locaux et de saison ?', 0),
(45, 5, 1, 5, 'Combien avez-vous de chat(s) ?', 0),
(46, 5, 2, 5, 'Combien avez-vous de chien(s) ?', 0),
(47, 5, 3, 1, 'Avez-vous un cheval ?', 0),
(48, 6, 1, 1, 'Avez-vous au moins un équipement numérique par personne dans le foyer ?', 0),
(49, 6, 2, 1, 'En moyenne, passez-vous plus de 2 heures par jour sur Internet ?', 0),
(50, 6, 3, 1, 'En moyenne, regardez-vous plus d\'une heure de vidéo par jour (ex: Netflix, YouTube, VOD,...) ?', 0),
(51, 6, 4, 1, 'En moyenne, achetez-vous pour plus de 600€ de vêtements et chaussures par an ?', 0);

-- --------------------------------------------------------

--
-- Table structure for table `questions_TypeListValues`
--

CREATE TABLE `questions_TypeListValues` (
  `questionID` int NOT NULL,
  `answerID` tinyint NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `questions_TypeListValues`
--

INSERT INTO `questions_TypeListValues` (`questionID`, `answerID`, `answer`) VALUES
(6, 1, 'Diesel'),
(6, 2, 'Electrique'),
(10, 1, 'Moins de 5 ans'),
(10, 2, 'Entre 5 et 10 ans'),
(10, 3, 'Entre 10 et 15 ans'),
(10, 4, 'Plus de 15 ans'),
(15, 1, 'Maison mitoyenne'),
(15, 2, 'Appartement'),
(17, 1, 'Bois'),
(17, 2, 'Electrique'),
(25, 1, 'Des bains'),
(25, 2, 'Des douches'),
(27, 1, 'Moins de 5 mins'),
(27, 2, 'Entre 5 et 10 mins'),
(27, 3, 'Entre 10 et 15 mins'),
(27, 4, 'Plus de 15 mins'),
(36, 1, 'Ampoules basse consommation'),
(36, 2, 'Ampoules classique');

-- --------------------------------------------------------

--
-- Table structure for table `questions_TypeValues`
--

CREATE TABLE `questions_TypeValues` (
  `questionTypeID` tinyint NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `questions_TypeValues`
--

INSERT INTO `questions_TypeValues` (`questionTypeID`, `type`) VALUES
(1, 'Boolean'),
(5, 'Integer'),
(3, 'List'),
(4, 'Multiple Selection'),
(2, 'Text');

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `sectionID` int NOT NULL,
  `priority` int NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`sectionID`, `priority`, `text`) VALUES
(1, 1, 'Questions générales'),
(2, 2, 'Transport'),
(3, 3, 'Habitation'),
(4, 4, 'Alimentation'),
(5, 5, 'Animaux'),
(6, 6, 'Loisirs');

-- --------------------------------------------------------

--
-- Table structure for table `workshops`
--

CREATE TABLE `workshops` (
  `workshopUUID` binary(16) NOT NULL,
  `startedTimestamp` timestamp NULL DEFAULT NULL,
  `endedTimestamp` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `workshopsParticipants`
--

CREATE TABLE `workshopsParticipants` (
  `workshopUUID` binary(16) NOT NULL,
  `participantUUID` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `answers_TypeInteger`
--
ALTER TABLE `answers_TypeInteger`
  ADD PRIMARY KEY (`participantUUID`,`questionID`),
  ADD KEY `questionID` (`questionID`);

--
-- Indexes for table `answers_TypeList`
--
ALTER TABLE `answers_TypeList`
  ADD PRIMARY KEY (`participantUUID`,`questionID`,`answerID`) USING BTREE,
  ADD KEY `answerID` (`answerID`),
  ADD KEY `questionID` (`questionID`);

--
-- Indexes for table `answers_TypeText`
--
ALTER TABLE `answers_TypeText`
  ADD PRIMARY KEY (`participantUUID`,`questionID`),
  ADD KEY `questionID` (`questionID`);

--
-- Indexes for table `participants`
--
ALTER TABLE `participants`
  ADD PRIMARY KEY (`participantUUID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionID`),
  ADD KEY `questionTypeID` (`questionTypeID`),
  ADD KEY `sectionID` (`sectionID`);

--
-- Indexes for table `questions_TypeListValues`
--
ALTER TABLE `questions_TypeListValues`
  ADD PRIMARY KEY (`questionID`,`answerID`),
  ADD KEY `answerID` (`answerID`);

--
-- Indexes for table `questions_TypeValues`
--
ALTER TABLE `questions_TypeValues`
  ADD PRIMARY KEY (`questionTypeID`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD PRIMARY KEY (`sectionID`);

--
-- Indexes for table `workshops`
--
ALTER TABLE `workshops`
  ADD PRIMARY KEY (`workshopUUID`);

--
-- Indexes for table `workshopsParticipants`
--
ALTER TABLE `workshopsParticipants`
  ADD PRIMARY KEY (`workshopUUID`,`participantUUID`),
  ADD KEY `participantUUID` (`participantUUID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `questions_TypeValues`
--
ALTER TABLE `questions_TypeValues`
  MODIFY `questionTypeID` tinyint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sections`
--
ALTER TABLE `sections`
  MODIFY `sectionID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers_TypeInteger`
--
ALTER TABLE `answers_TypeInteger`
  ADD CONSTRAINT `answers_TypeInteger_ibfk_2` FOREIGN KEY (`participantUUID`) REFERENCES `participants` (`participantUUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answers_TypeInteger_ibfk_3` FOREIGN KEY (`questionID`) REFERENCES `questions` (`questionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `answers_TypeList`
--
ALTER TABLE `answers_TypeList`
  ADD CONSTRAINT `answers_TypeList_ibfk_1` FOREIGN KEY (`participantUUID`) REFERENCES `participants` (`participantUUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answers_TypeList_ibfk_3` FOREIGN KEY (`answerID`) REFERENCES `questions_TypeListValues` (`answerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answers_TypeList_ibfk_4` FOREIGN KEY (`questionID`) REFERENCES `questions` (`questionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `answers_TypeText`
--
ALTER TABLE `answers_TypeText`
  ADD CONSTRAINT `answers_TypeText_ibfk_1` FOREIGN KEY (`participantUUID`) REFERENCES `participants` (`participantUUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answers_TypeText_ibfk_2` FOREIGN KEY (`questionID`) REFERENCES `questions` (`questionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`sectionID`) REFERENCES `sections` (`sectionID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `questions_ibfk_2` FOREIGN KEY (`questionTypeID`) REFERENCES `questions_TypeValues` (`questionTypeID`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Constraints for table `questions_TypeListValues`
--
ALTER TABLE `questions_TypeListValues`
  ADD CONSTRAINT `questions_TypeListValues_ibfk_1` FOREIGN KEY (`questionID`) REFERENCES `questions` (`questionID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `workshopsParticipants`
--
ALTER TABLE `workshopsParticipants`
  ADD CONSTRAINT `workshopsParticipants_ibfk_1` FOREIGN KEY (`participantUUID`) REFERENCES `participants` (`participantUUID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `workshopsParticipants_ibfk_2` FOREIGN KEY (`workshopUUID`) REFERENCES `workshops` (`workshopUUID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
