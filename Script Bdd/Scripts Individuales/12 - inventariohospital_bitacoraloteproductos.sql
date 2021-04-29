-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 192.168.0.120    Database: inventariohospital
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `bitacoraloteproductos`
--

DROP TABLE IF EXISTS `bitacoraloteproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacoraloteproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(40) NOT NULL,
  `BcpAccion` varchar(15) NOT NULL,
  `BcpDescripcionCambios` varchar(300) DEFAULT NULL,
  `BcpFecha` datetime NOT NULL,
  `LprId` int DEFAULT NULL,
  PRIMARY KEY (`BcpId`),
  KEY `IX_Relationship2` (`LprId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraloteproductos`
--

LOCK TABLES `bitacoraloteproductos` WRITE;
/*!40000 ALTER TABLE `bitacoraloteproductos` DISABLE KEYS */;
INSERT INTO `bitacoraloteproductos` VALUES (1,'lfernandez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-01 a: 2022-01-12</center></html>; ','2021-04-20 14:47:53',1),(2,'lfernandez','Actualizar','<html><center>El stock cambio de: 100 a: 60;</center></html> ','2021-04-20 14:57:33',1),(3,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 80; </center></html>','2021-04-22 18:56:12',1),(4,'hlopez','Actualizar','<html><center><br>El stock cambio de: 80 a: 70; </center></html>','2021-04-22 19:06:30',1),(5,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-12 a: 2022-01-30; </center></html>','2021-04-22 19:06:37',1),(6,'hlopez','Actualizar','<html><center><br>El stock cambio de: 70 a: 50; </center></html>','2021-04-23 18:50:47',1),(7,'hlopez','Actualizar','<html><center><br>El stock cambio de: 50 a: 100; <br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:34:25',1),(8,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 30; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:34:36',1),(9,'hlopez','Actualizar','<html><center><br>El stock cambio de: 30 a: 100; </center></html>','2021-04-26 14:35:06',1),(10,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:35:11',1),(11,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:35:22',1),(12,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-30 a: 2022-02-21; </center></html>','2021-04-26 14:39:35',1),(13,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 50; <br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:39:46',1),(14,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:39:53',1),(15,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:40:00',1),(16,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:40:11',1),(17,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 15:05:35',1),(18,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 15:05:40',1),(19,'hlopez','Actualizar','<html><center><br>El stock cambio de: 50 a: 100; </center></html>','2021-04-26 15:43:56',1),(20,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-02-21 a: 2022-12-30; </center></html>','2021-04-26 15:44:20',1),(21,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 15:44:27',1),(22,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 90; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 18:27:48',1),(23,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 18:54:47',1),(25,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-12-30 a: 2022-02-20; <br>El stock cambio de: 90 a: 60; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 20:15:01',1),(26,'hlopez','Actualizar','<html><center><br>El stock cambio de: 60 a: 100; </center></html>','2021-04-26 20:34:00',1),(27,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-27 09:14:26',1),(28,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 20; </center></html>','2021-04-27 09:16:04',1),(29,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-02-20 a: 2022-02-21; <br>El stock cambio de: 20 a: 120; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-27 15:46:52',1);
/*!40000 ALTER TABLE `bitacoraloteproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 17:03:37
