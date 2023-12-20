-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 24, 2022 at 07:54 AM
-- Server version: 8.0.27
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `veterinaria`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `validar_genero`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `validar_genero` (IN `genero` VARCHAR(1))  BEGIN
IF (genero != 'F' && genero != 'M') THEN
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Genero invalido [F/M]';
END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `idAnimal` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `genero` char(1) DEFAULT 'M',
  `especie` varchar(40) NOT NULL,
  `raca` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cor` varchar(25) NOT NULL,
  `idade` smallint NOT NULL,
  `idDono` int NOT NULL,
  PRIMARY KEY (`idAnimal`),
  KEY `idDono` (`idDono`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`idAnimal`, `nome`, `genero`, `especie`, `raca`, `cor`, `idade`, `idDono`) VALUES
(1, 'Pablito', 'M', 'gato', '', 'azul', 3, 1),
(2, 'Rex', 'M', 'cao', '', 'preto', 5, 2),
(3, 'Figo', 'M', 'Rato', '', 'azul', 3, 3),
(4, 'Rosquinha', 'M', 'Cao', '', 'azul', 3, 4),
(5, 'Xoxo', 'M', 'Cao', '', 'cinza', 3, 4),
(6, 'Bolinha', 'M', 'Cão', '', 'preto', 2, 1),
(7, 'Fofinho', 'M', 'Gato', 'vira-lata', 'branca', 2, 1),
(8, 'RatoGordo', 'M', 'Roedor', 'porco', 'mulato', 3, 1),
(9, 'Amorzinho', 'M', 'Cão', 'Pastor Alemao', 'castanha', 8, 8);

--
-- Triggers `animal`
--
DROP TRIGGER IF EXISTS `genero_invalido_animal`;
DELIMITER $$
CREATE TRIGGER `genero_invalido_animal` BEFORE INSERT ON `animal` FOR EACH ROW BEGIN
call validar_genero(new.genero);
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `idade_invalida`;
DELIMITER $$
CREATE TRIGGER `idade_invalida` BEFORE INSERT ON `animal` FOR EACH ROW BEGIN
IF ( new.idade < 0 || new.idade > 30) THEN
SIGNAL SQLSTATE '45000' 
SET MESSAGE_TEXT = 'Inserção de idade invalida';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `animal_leitointernado`
--

DROP TABLE IF EXISTS `animal_leitointernado`;
CREATE TABLE IF NOT EXISTS `animal_leitointernado` (
  `idAnimal` int NOT NULL,
  `numeroLeito` int NOT NULL,
  PRIMARY KEY (`idAnimal`,`numeroLeito`),
  KEY `numeroLeito` (`numeroLeito`),
  KEY `idAnimal` (`idAnimal`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal_leitointernado`
--

INSERT INTO `animal_leitointernado` (`idAnimal`, `numeroLeito`) VALUES
(2, 3),
(1, 5),
(4, 6),
(5, 6);

-- --------------------------------------------------------

--
-- Table structure for table `animal_sintomas`
--

DROP TABLE IF EXISTS `animal_sintomas`;
CREATE TABLE IF NOT EXISTS `animal_sintomas` (
  `idSintomas` int NOT NULL,
  `idAnimal` int NOT NULL,
  `idveterinario` int NOT NULL,
  `sintoma` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dataSintoma` date DEFAULT NULL,
  PRIMARY KEY (`idSintomas`,`idAnimal`,`idveterinario`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idveterinario` (`idveterinario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal_sintomas`
--

INSERT INTO `animal_sintomas` (`idSintomas`, `idAnimal`, `idveterinario`, `sintoma`, `dataSintoma`) VALUES
(1, 1, 1, 'dores de cabeca', NULL),
(2, 2, 2, 'Febre', NULL),
(3, 1, 5, 'Febre', '2021-12-07'),
(3, 3, 5, 'dores de cabeca', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `animal_tratamento`
--

DROP TABLE IF EXISTS `animal_tratamento`;
CREATE TABLE IF NOT EXISTS `animal_tratamento` (
  `idAnimal` int NOT NULL,
  `idTratamento` int NOT NULL,
  PRIMARY KEY (`idAnimal`,`idTratamento`),
  KEY `Tratamento_FK` (`idTratamento`),
  KEY `idAnimal` (`idAnimal`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal_tratamento`
--

INSERT INTO `animal_tratamento` (`idAnimal`, `idTratamento`) VALUES
(1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `animal_veterinarioanalisa`
--

DROP TABLE IF EXISTS `animal_veterinarioanalisa`;
CREATE TABLE IF NOT EXISTS `animal_veterinarioanalisa` (
  `idAnimal` int NOT NULL,
  `idveterinario` int NOT NULL,
  `dataAnalisa` date NOT NULL,
  PRIMARY KEY (`idAnimal`,`idveterinario`),
  KEY `idveterinario` (`idveterinario`),
  KEY `idAnimal` (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal_veterinarioanalisa`
--

INSERT INTO `animal_veterinarioanalisa` (`idAnimal`, `idveterinario`, `dataAnalisa`) VALUES
(2, 4, '2021-12-09'),
(3, 2, '2021-12-26');

-- --------------------------------------------------------

--
-- Table structure for table `animal_veterinariotrata`
--

DROP TABLE IF EXISTS `animal_veterinariotrata`;
CREATE TABLE IF NOT EXISTS `animal_veterinariotrata` (
  `idAnimal` int NOT NULL,
  `idveterinario` int NOT NULL,
  `idTratamento` int NOT NULL,
  `idMedicamento` int NOT NULL,
  PRIMARY KEY (`idAnimal`,`idveterinario`,`idTratamento`,`idMedicamento`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idveterinario` (`idveterinario`),
  KEY `idTratamento` (`idTratamento`),
  KEY `idMedicamento` (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal_veterinariotrata`
--

INSERT INTO `animal_veterinariotrata` (`idAnimal`, `idveterinario`, `idTratamento`, `idMedicamento`) VALUES
(1, 5, 1, 1),
(2, 4, 1, 2),
(3, 5, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `dono`
--

DROP TABLE IF EXISTS `dono`;
CREATE TABLE IF NOT EXISTS `dono` (
  `idDono` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apelido` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `genero` char(1) DEFAULT 'M',
  `contacto1` varchar(9) NOT NULL,
  `contacto2` varchar(9) DEFAULT NULL,
  `contacto3` varchar(9) DEFAULT NULL,
  `bairro` varchar(40) NOT NULL,
  `rua` varchar(40) DEFAULT NULL,
  `casa` int DEFAULT NULL,
  PRIMARY KEY (`idDono`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dono`
--

INSERT INTO `dono` (`idDono`, `nome`, `apelido`, `genero`, `contacto1`, `contacto2`, `contacto3`, `bairro`, `rua`, `casa`) VALUES
(1, 'Keven', ' Uqueio', 'M', '848055510', '878544487', '845522332', 'Tsalala', 'Av.Industrias', NULL),
(2, 'Kianda', 'Yesterday', 'F', '845548947', NULL, NULL, 'Tsalala', 'Av.Industrias', 458),
(3, 'Mario', 'Markovinickov', 'M', '874548947', NULL, NULL, 'Tsalala', 'Av.Industrias', 587),
(4, 'Joaquim', ' Marrengula', 'M', '848054310', '878547547', '845522332', 'Tsalala', 'Av.Industrias', NULL),
(5, 'hmgc', 'hhj', 'M', '841234567', '0', '0', 'jhvjh', 'jbh', 555),
(6, 'Swagg', 'Pig', 'M', '848522214', '0', '0', 'baixa', 'KarlMarks', 121),
(7, 'sadfsdaf', 'asdfdsaf', 'M', '841234567', '0', '0', 'sadfdsaf', 'sadfdsaf', 22),
(8, 'Alex', 'Merenkov', 'M', '863732035', '', '', 'Sommershield', 'Mao Tse Tung', 5);

--
-- Triggers `dono`
--
DROP TRIGGER IF EXISTS `genero_invalido_dono`;
DELIMITER $$
CREATE TRIGGER `genero_invalido_dono` BEFORE INSERT ON `dono` FOR EACH ROW BEGIN
call validar_genero(new.genero);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dono_recepcionistaatende`
--

DROP TABLE IF EXISTS `dono_recepcionistaatende`;
CREATE TABLE IF NOT EXISTS `dono_recepcionistaatende` (
  `idRecepcionista` int NOT NULL,
  `idDono` int NOT NULL,
  PRIMARY KEY (`idRecepcionista`,`idDono`),
  KEY `idDono` (`idDono`),
  KEY `idRecepcionista` (`idRecepcionista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dono_recepcionistaatende`
--

INSERT INTO `dono_recepcionistaatende` (`idRecepcionista`, `idDono`) VALUES
(2, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `dono_reciborecebe`
--

DROP TABLE IF EXISTS `dono_reciborecebe`;
CREATE TABLE IF NOT EXISTS `dono_reciborecebe` (
  `idRecibo` int NOT NULL,
  `idDono` int NOT NULL,
  PRIMARY KEY (`idRecibo`,`idDono`),
  KEY `idDono` (`idDono`),
  KEY `idRecibo` (`idRecibo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dono_reciborecebe`
--

INSERT INTO `dono_reciborecebe` (`idRecibo`, `idDono`) VALUES
(1, 1),
(2, 2),
(2, 3),
(1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `leito`
--

DROP TABLE IF EXISTS `leito`;
CREATE TABLE IF NOT EXISTS `leito` (
  `numeroleito` int NOT NULL,
  PRIMARY KEY (`numeroleito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `leito`
--

INSERT INTO `leito` (`numeroleito`) VALUES
(1),
(2),
(4),
(5),
(6);

--
-- Triggers `leito`
--
DROP TRIGGER IF EXISTS `numeroLeito_invalido`;
DELIMITER $$
CREATE TRIGGER `numeroLeito_invalido` BEFORE INSERT ON `leito` FOR EACH ROW BEGIN
IF ( new.numeroLeito <= 0 || new.numeroLeito > 30) THEN
SIGNAL SQLSTATE '45000' 
SET MESSAGE_TEXT = 'numero de leito invalido';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE IF NOT EXISTS `medicamento` (
  `idMedicamento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `custo` double(20,2) NOT NULL,
  PRIMARY KEY (`idMedicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `medicamento`
--

INSERT INTO `medicamento` (`idMedicamento`, `nome`, `custo`) VALUES
(1, 'paracemol', 45.00),
(2, 'aspirina', 785.00);

-- --------------------------------------------------------

--
-- Table structure for table `recepcionista`
--

DROP TABLE IF EXISTS `recepcionista`;
CREATE TABLE IF NOT EXISTS `recepcionista` (
  `idRecepcionista` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apelido` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `genero` char(1) DEFAULT 'F',
  `contacto1` varchar(9) NOT NULL,
  `contacto2` varchar(9) DEFAULT NULL,
  `contacto3` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idRecepcionista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `recepcionista`
--

INSERT INTO `recepcionista` (`idRecepcionista`, `nome`, `apelido`, `genero`, `contacto1`, `contacto2`, `contacto3`) VALUES
(1, 'Raquel', 'Sitoe', 'F', '823430245', NULL, NULL),
(2, 'Janny', 'Hotney', 'F', '845670245', NULL, NULL),
(3, 'Susan', 'Hotney', 'F', '845670245', '853939503', NULL);

--
-- Triggers `recepcionista`
--
DROP TRIGGER IF EXISTS `genero_invalido_recepcionista`;
DELIMITER $$
CREATE TRIGGER `genero_invalido_recepcionista` BEFORE INSERT ON `recepcionista` FOR EACH ROW BEGIN
call validar_genero(new.genero);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `recepcionista_animalrecebe`
--

DROP TABLE IF EXISTS `recepcionista_animalrecebe`;
CREATE TABLE IF NOT EXISTS `recepcionista_animalrecebe` (
  `idAnimal` int NOT NULL,
  `idRecepcionista` int NOT NULL,
  `dataEntrada` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dataSaida` datetime DEFAULT NULL,
  PRIMARY KEY (`idAnimal`,`idRecepcionista`),
  KEY `idRecepcionista` (`idRecepcionista`),
  KEY `idAnimal` (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `recepcionista_animalrecebe`
--

INSERT INTO `recepcionista_animalrecebe` (`idAnimal`, `idRecepcionista`, `dataEntrada`, `dataSaida`) VALUES
(1, 1, '2021-12-04 00:00:00', '2021-12-24 00:00:00'),
(2, 1, '2021-04-16 00:00:00', '2021-12-10 00:00:00'),
(2, 2, '2022-06-13 00:00:00', '2022-06-15 00:00:00'),
(2, 3, '2022-08-13 00:00:00', '2022-08-15 00:00:00'),
(3, 1, '2022-07-13 00:00:00', '2022-07-15 00:00:00'),
(3, 2, '2022-08-13 00:00:00', '2022-08-16 00:00:00'),
(3, 3, '2022-08-13 00:00:00', '2022-08-15 00:00:00'),
(5, 1, '2022-08-13 00:00:00', '2022-08-16 00:00:00');

--
-- Triggers `recepcionista_animalrecebe`
--
DROP TRIGGER IF EXISTS `animal_alta`;
DELIMITER $$
CREATE TRIGGER `animal_alta` AFTER UPDATE ON `recepcionista_animalrecebe` FOR EACH ROW begin 
if (new.dataSaida != null) then
delete from animal_leitointernado as al where al.idAnimal = old.idAnimal and al.numeroLeito = (select numeroLeito from animal_leitointernado
where idAnimal = old.idAnimal);
end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `recepcionista_recibogera`
--

DROP TABLE IF EXISTS `recepcionista_recibogera`;
CREATE TABLE IF NOT EXISTS `recepcionista_recibogera` (
  `idRecepcionista` int NOT NULL,
  `idRecibo` int NOT NULL,
  PRIMARY KEY (`idRecepcionista`,`idRecibo`),
  UNIQUE KEY `idRecepcionista` (`idRecepcionista`,`idRecibo`),
  KEY `idRecibo` (`idRecibo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `recepcionista_recibogera`
--

INSERT INTO `recepcionista_recibogera` (`idRecepcionista`, `idRecibo`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
CREATE TABLE IF NOT EXISTS `recibo` (
  `idRecibo` int NOT NULL AUTO_INCREMENT,
  `valor` double(20,3) NOT NULL,
  `dataImpressao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idRecibo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `recibo`
--

INSERT INTO `recibo` (`idRecibo`, `valor`, `dataImpressao`) VALUES
(1, 3000.000, '2021-12-16 00:00:00'),
(2, 7000.000, '2022-11-16 00:00:00'),
(3, 9000.000, '2022-10-16 00:00:00'),
(5, 9000.000, '0000-00-00 00:00:00'),
(6, 12000.000, '2022-01-16 18:51:56');

--
-- Triggers `recibo`
--
DROP TRIGGER IF EXISTS `valor_recibo_invalido`;
DELIMITER $$
CREATE TRIGGER `valor_recibo_invalido` BEFORE INSERT ON `recibo` FOR EACH ROW BEGIN
IF ( new.valor <= 0 ) THEN
SIGNAL SQLSTATE '45000' 
SET MESSAGE_TEXT = 'valor do recibo invalido';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tratamento`
--

DROP TABLE IF EXISTS `tratamento`;
CREATE TABLE IF NOT EXISTS `tratamento` (
  `idTratamento` int NOT NULL AUTO_INCREMENT,
  `tratamento` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `designacao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `custo` double(20,2) NOT NULL,
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idTratamento`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tratamento`
--

INSERT INTO `tratamento` (`idTratamento`, `tratamento`, `designacao`, `custo`, `data`) VALUES
(1, 'lavar e vacinacao', 'Tomar banho Sempre', 7245.00, '2021-12-02 00:00:00'),
(2, 'vacinacao', 'foram aplicadas todas as vacinas necessarias', 2500.00, '2022-01-02 00:00:00'),
(3, 'Vacina contra Raiva', NULL, 500.00, '2022-01-23 22:13:40'),
(4, 'Vacinação completa', NULL, 1200.00, '2022-01-23 22:25:36'),
(5, 'vacina multipla', NULL, 700.00, '2022-01-23 22:28:51'),
(6, 'vacina contra gripe', NULL, 200.00, '2022-01-23 22:28:51'),
(7, 'Vacina contra Raiva', NULL, 500.00, '2022-01-24 09:14:44'),
(8, 'Vacina contra Raiva', NULL, 500.00, '2022-01-24 09:17:36'),
(9, 'Vacina contra Raiva', NULL, 500.00, '2022-01-24 09:18:59'),
(10, 'Vacina contra Raiva', NULL, 500.00, '2022-01-24 09:24:00');

-- --------------------------------------------------------

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
CREATE TABLE IF NOT EXISTS `veterinario` (
  `idVeterinario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apelido` varchar(40) NOT NULL,
  `genero` char(1) DEFAULT 'M',
  `contacto1` varchar(9) NOT NULL,
  `contacto2` varchar(9) DEFAULT NULL,
  `contacto3` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idVeterinario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `veterinario`
--

INSERT INTO `veterinario` (`idVeterinario`, `nome`, `apelido`, `genero`, `contacto1`, `contacto2`, `contacto3`) VALUES
(1, 'Martin', 'Luther', 'M', '878566621', NULL, NULL),
(2, 'Melia', 'Languelo', 'F', '845930230', NULL, NULL),
(4, 'Joaquim', 'Savanguana', 'M', '845454264', NULL, NULL),
(5, 'Jorge', 'Manhica', 'M', '845780230', NULL, NULL);

--
-- Triggers `veterinario`
--
DROP TRIGGER IF EXISTS `genero_invalido_veterinario`;
DELIMITER $$
CREATE TRIGGER `genero_invalido_veterinario` BEFORE INSERT ON `veterinario` FOR EACH ROW BEGIN
call validar_genero(new.genero);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `zelador`
--

DROP TABLE IF EXISTS `zelador`;
CREATE TABLE IF NOT EXISTS `zelador` (
  `idZelador` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `contacto1` varchar(9) NOT NULL,
  `contacto2` varchar(9) DEFAULT NULL,
  `contacto3` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`idZelador`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `zelador`
--

INSERT INTO `zelador` (`idZelador`, `nome`, `contacto1`, `contacto2`, `contacto3`) VALUES
(1, 'Amelia', '874367543', NULL, NULL),
(2, 'Win', '842256890', NULL, NULL),
(3, 'Shola', '825256890', NULL, NULL),
(4, 'Armin', '825254455', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `zelador_animalcuida`
--

DROP TABLE IF EXISTS `zelador_animalcuida`;
CREATE TABLE IF NOT EXISTS `zelador_animalcuida` (
  `idAnimal` int NOT NULL,
  `data` date NOT NULL,
  `idZelador` int NOT NULL,
  PRIMARY KEY (`idAnimal`,`idZelador`),
  KEY `idZelador` (`idZelador`),
  KEY `idAnimal` (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `zelador_animalcuida`
--

INSERT INTO `zelador_animalcuida` (`idAnimal`, `data`, `idZelador`) VALUES
(1, '2021-12-02', 2),
(2, '2011-12-01', 3),
(3, '2021-07-05', 2);

-- --------------------------------------------------------

--
-- Table structure for table `zelador_leitocuida`
--

DROP TABLE IF EXISTS `zelador_leitocuida`;
CREATE TABLE IF NOT EXISTS `zelador_leitocuida` (
  `idZelador` int NOT NULL,
  `numeroleito` int NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`idZelador`,`numeroleito`),
  KEY `idzelador` (`idZelador`),
  KEY `numeroleito` (`numeroleito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `zelador_leitocuida`
--

INSERT INTO `zelador_leitocuida` (`idZelador`, `numeroleito`, `data`) VALUES
(1, 5, '2021-12-02'),
(3, 5, '2021-07-05');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idDono`) REFERENCES `dono` (`idDono`);

--
-- Constraints for table `animal_sintomas`
--
ALTER TABLE `animal_sintomas`
  ADD CONSTRAINT `animal_sintomas_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`),
  ADD CONSTRAINT `animal_sintomas_ibfk_2` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idVeterinario`);

--
-- Constraints for table `animal_veterinarioanalisa`
--
ALTER TABLE `animal_veterinarioanalisa`
  ADD CONSTRAINT `animal_veterinarioanalisa_ibfk_1` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idVeterinario`),
  ADD CONSTRAINT `animal_veterinarioanalisa_ibfk_2` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`);

--
-- Constraints for table `animal_veterinariotrata`
--
ALTER TABLE `animal_veterinariotrata`
  ADD CONSTRAINT `animal_veterinariotrata_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`),
  ADD CONSTRAINT `animal_veterinariotrata_ibfk_2` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idVeterinario`),
  ADD CONSTRAINT `animal_veterinariotrata_ibfk_3` FOREIGN KEY (`idTratamento`) REFERENCES `tratamento` (`idTratamento`),
  ADD CONSTRAINT `animal_veterinariotrata_ibfk_4` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`idMedicamento`);

--
-- Constraints for table `dono_recepcionistaatende`
--
ALTER TABLE `dono_recepcionistaatende`
  ADD CONSTRAINT `dono_recepcionistaatende_ibfk_1` FOREIGN KEY (`idDono`) REFERENCES `dono` (`idDono`),
  ADD CONSTRAINT `dono_recepcionistaatende_ibfk_2` FOREIGN KEY (`idRecepcionista`) REFERENCES `recepcionista` (`idRecepcionista`);

--
-- Constraints for table `dono_reciborecebe`
--
ALTER TABLE `dono_reciborecebe`
  ADD CONSTRAINT `dono_reciborecebe_ibfk_1` FOREIGN KEY (`idDono`) REFERENCES `dono` (`idDono`),
  ADD CONSTRAINT `dono_reciborecebe_ibfk_2` FOREIGN KEY (`idRecibo`) REFERENCES `recibo` (`idRecibo`);

--
-- Constraints for table `zelador_animalcuida`
--
ALTER TABLE `zelador_animalcuida`
  ADD CONSTRAINT `zelador_animalcuida_ibfk_1` FOREIGN KEY (`idZelador`) REFERENCES `zelador` (`idZelador`),
  ADD CONSTRAINT `zelador_animalcuida_ibfk_2` FOREIGN KEY (`idAnimal`) REFERENCES `animal` (`idAnimal`);

--
-- Constraints for table `zelador_leitocuida`
--
ALTER TABLE `zelador_leitocuida`
  ADD CONSTRAINT `zelador_leitocuida_ibfk_1` FOREIGN KEY (`idZelador`) REFERENCES `zelador` (`idZelador`),
  ADD CONSTRAINT `zelador_leitocuida_ibfk_2` FOREIGN KEY (`numeroleito`) REFERENCES `leito` (`numeroleito`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
