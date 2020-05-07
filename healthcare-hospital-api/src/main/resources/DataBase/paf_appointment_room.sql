-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: paf
-- ------------------------------------------------------
-- Server version	8.0.19

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '50ab16df-6c76-11ea-ad3c-1831bf2b9a22:1-79,
5a1b6067-6c76-11ea-83ae-1831bf2b9a22:1-78';

--
-- Table structure for table `appointment_room`
--

DROP TABLE IF EXISTS `appointment_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_room` (
  `appointment_room_id` varchar(100) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `hospital_ID` int DEFAULT NULL,
  PRIMARY KEY (`appointment_room_id`),
  KEY `hospital_id_idx` (`hospital_ID`),
  CONSTRAINT `hospital_id` FOREIGN KEY (`hospital_ID`) REFERENCES `hospital` (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_room`
--

LOCK TABLES `appointment_room` WRITE;
/*!40000 ALTER TABLE `appointment_room` DISABLE KEYS */;
INSERT INTO `appointment_room` VALUES ('AHC001','NEPHROLOGIST',2),('AHC002','ONCOLOGY',2),('AHM001','CONSULTANT',6),('DH001','CARDIOLOGISTS',5),('DH002','ONCOLOGY',5),('KPH001','DENTISTS',1),('KPH002','CARDIOLOGISTS',1),('KPH1','App Room 1',7),('LH001','NEPHROLOGIST',4),('LH002','PULMONOLOGIST',4),('NH001','PULMONOLOGIST',3),('NH002','CARDIOLOGISTS',3);
/*!40000 ALTER TABLE `appointment_room` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 23:17:34
