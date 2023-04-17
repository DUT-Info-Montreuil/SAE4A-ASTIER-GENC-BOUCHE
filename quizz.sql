-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 17, 2023 at 09:54 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quizz`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `intitule` varchar(50) NOT NULL,
  `reponse1` varchar(200) DEFAULT NULL,
  `reponse2` varchar(200) NOT NULL,
  `reponse3` varchar(200) NOT NULL,
  `reponse4` varchar(200) NOT NULL,
  `nReponse` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `intitule`, `reponse1`, `reponse2`, `reponse3`, `reponse4`, `nReponse`) VALUES
(117, '?', 'a', 'b', 'c', 'd', 2),
(118, '?', 'a', 'b', 'c', 'd', 2),
(119, 'azdad', 'azda', 'dad', 'ada', 'dad', 2);

-- --------------------------------------------------------

--
-- Table structure for table `questionduquestionnaire`
--

DROP TABLE IF EXISTS `questionduquestionnaire`;
CREATE TABLE IF NOT EXISTS `questionduquestionnaire` (
  `idQuestionnaire` bigint(20) UNSIGNED NOT NULL,
  `idQuestion` bigint(20) UNSIGNED NOT NULL,
  KEY `FK_id_questionnaire2` (`idQuestionnaire`),
  KEY `FK_id_question` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionduquestionnaire`
--

INSERT INTO `questionduquestionnaire` (`idQuestionnaire`, `idQuestion`) VALUES
(1, 117),
(1, 117),
(1, 118);

-- --------------------------------------------------------

--
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE IF NOT EXISTS `questionnaire` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `intitule` varchar(200) NOT NULL,
  `dateDeCreation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `score` int(11) NOT NULL,
  UNIQUE KEY `idQuestionnaire` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionnaire`
--

INSERT INTO `questionnaire` (`id`, `idUtilisateur`, `intitule`, `dateDeCreation`, `score`) VALUES
(1, 1, 'yuyu', '2023-04-10 01:01:38', 0),
(2, 1, 'yaya', '2023-04-10 01:01:38', 0),
(3, 0, 'babaje ultime', '2023-04-10 01:01:38', 0),
(4, 1, 'sup', '2023-04-10 01:01:38', 0),
(6, 0, 'sus', '2023-04-10 01:01:38', 0),
(7, 1, 'tropVieux', '2023-02-13 01:01:54', 0);

-- --------------------------------------------------------

--
-- Table structure for table `questionnairejoue`
--

DROP TABLE IF EXISTS `questionnairejoue`;
CREATE TABLE IF NOT EXISTS `questionnairejoue` (
  `idUtilisateur` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idQuestionnaire` bigint(20) UNSIGNED NOT NULL,
  `dateDeJeu` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `FK_id_questionnaire` (`idQuestionnaire`),
  KEY `FK_id_utilisateur` (`idUtilisateur`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionnairejoue`
--

INSERT INTO `questionnairejoue` (`idUtilisateur`, `idQuestionnaire`, `dateDeJeu`) VALUES
(1, 1, '2023-04-08 16:31:26'),
(2, 1, '2023-04-08 16:37:34'),
(1, 2, '2023-04-08 17:03:05'),
(1, 1, '2023-04-08 17:07:53'),
(1, 1, '2023-04-08 17:07:53'),
(1, 2, '2023-04-08 17:08:57'),
(1, 2, '2023-04-08 17:08:57'),
(2, 1, '2023-04-08 20:28:12'),
(2, 1, '2023-04-08 20:28:12'),
(2, 2, '2023-04-08 20:28:27'),
(2, 2, '2023-04-08 20:28:27'),
(2, 3, '2023-04-08 20:30:55'),
(2, 3, '2023-04-08 20:30:55'),
(2, 3, '2023-04-08 20:33:54'),
(1, 6, '2023-04-09 16:30:26'),
(1, 4, '2023-04-09 16:30:42'),
(1, 1, '2023-04-09 23:02:46'),
(1, 1, '2023-04-09 23:02:46'),
(1, 7, '2023-04-09 23:04:13'),
(1, 7, '2023-04-09 23:04:13'),
(1, 7, '2023-04-09 23:04:40'),
(1, 7, '2023-04-09 23:04:40'),
(1, 1, '2023-04-13 23:52:08'),
(7, 4, '2023-04-14 01:47:10'),
(7, 4, '2023-04-14 01:47:12'),
(7, 4, '2023-04-14 01:47:13'),
(7, 4, '2023-04-14 01:47:15'),
(7, 2, '2023-04-14 01:47:16'),
(7, 2, '2023-04-14 01:47:22'),
(7, 3, '2023-04-14 01:47:28'),
(7, 1, '2023-04-14 01:47:36');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `motdepasse` varchar(255) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `pseudo`, `email`, `motdepasse`) VALUES
(1, 'polo', 'polo@gmail.com', 'yayaya'),
(2, 'oo', 'ooooo@oo', 'ooo'),
(3, 'abc', 'ttb', 'ttt'),
(4, '888', '888', '888'),
(7, 'azer', 'azer', '$2y$10$ofV/7gXzlGi70RdatPW18u0wKTRlzHMZoqBYucgcp1Hb9kaYX/T1y'),
(8, 'azer', 'azer', '$2y$10$fpPTSbbfTiEhkoAgVuRhjO7QLYF.fjwkn1PA0dYQk5gWGzoBr0Vfu'),
(9, 'azer', 'azer', '$2y$10$TQZFz7hna4VPnhnQhkf23uML8uhQRGBK5aYx1Fz8IZjAsd93f.vye'),
(10, 'ololo', 'ololo@gmail.com', '$2y$10$L2jU2rye8bOj0NeAgP6Sa.2ylgaasevoekiHX0jKketh7i1Km6BDe');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questionduquestionnaire`
--
ALTER TABLE `questionduquestionnaire`
  ADD CONSTRAINT `FK_id_question` FOREIGN KEY (`idQuestion`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_id_questionnaire2` FOREIGN KEY (`idQuestionnaire`) REFERENCES `questionnaire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `questionnairejoue`
--
ALTER TABLE `questionnairejoue`
  ADD CONSTRAINT `FK_id_joueur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_id_questionnaire` FOREIGN KEY (`idQuestionnaire`) REFERENCES `questionnaire` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
