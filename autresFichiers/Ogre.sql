	CREATE DATABASE  IF NOT EXISTS adhesion CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE adhesion;

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
