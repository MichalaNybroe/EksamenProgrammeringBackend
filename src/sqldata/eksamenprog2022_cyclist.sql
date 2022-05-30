CREATE DATABASE  IF NOT EXISTS `eksamenprog2022` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eksamenprog2022`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: eksamenprog2022
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cyclist`
--

DROP TABLE IF EXISTS `cyclist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cyclist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `mountain_points` int NOT NULL,
  `spurt_points` int NOT NULL,
  `total_time` time NOT NULL,
  `cycling_team_id` bigint DEFAULT NULL,
  `nationality` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlix5cgfcg3t6bkpgbonjdoo7i` (`cycling_team_id`),
  CONSTRAINT `FKlix5cgfcg3t6bkpgbonjdoo7i` FOREIGN KEY (`cycling_team_id`) REFERENCES `cycling_team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyclist`
--

LOCK TABLES `cyclist` WRITE;
/*!40000 ALTER TABLE `cyclist` DISABLE KEYS */;
INSERT INTO `cyclist` VALUES (20,22,'Sebastian','Berwick','',2,13,'00:55:01',1,'Australia'),(21,28,'Alexander ','Cataford','',5,2,'00:55:01',1,'Canada'),(22,33,'Guillaume ','Boivin','',5,2,'02:55:01',1,'Canada'),(23,28,'Rick ','Zabel','',5,2,'06:55:01',1,'Germany'),(24,21,'Taj ','Jones','',7,6,'01:55:01',1,'Australia'),(25,36,'Alessandro ','Marchi','De ',7,6,'00:45:32',1,'Italy'),(26,28,'Maximilian','Schachmann','',7,6,'00:45:32',2,'Germany'),(27,28,'Danny ','Poppel','van ',7,6,'02:12:56',2,'Netherlands'),(28,31,'Wilco ','Kelderman','',7,6,'03:12:56',2,'Netherlands'),(29,26,'Aleksandr ','Vlasov','',7,16,'01:12:56',2,'Russia'),(30,31,'Marco','Haller','',1,10,'03:12:56',2,'Austria'),(31,33,'Jon ','Aberasturi','',1,10,'05:12:56',3,'Spain'),(32,21,'Filippo','Baroncini','',12,10,'02:12:56',3,'Italy'),(33,30,'Julien ','Bernard','',12,10,'00:32:56',3,'France'),(34,37,'Dario ','Cataldo','',8,20,'01:06:28',3,'Italy'),(35,28,'Alexander ','Kamp','',8,7,'01:00:28',3,'Denmark'),(36,21,'Mattias ','Jensen','Skjelmose ',8,7,'01:00:28',3,'Denmark');
/*!40000 ALTER TABLE `cyclist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31  0:04:18
