-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: inventariohospital
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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `UsrId` int NOT NULL AUTO_INCREMENT,
  `UsrIdentidad` varchar(20) NOT NULL,
  `UsrNombre` varchar(40) NOT NULL,
  `UsrApellido` varchar(40) NOT NULL,
  `UsrCorreo` varchar(60) NOT NULL,
  `UsrUsuario` varchar(40) NOT NULL,
  `UsrContrasenia` varchar(128) NOT NULL,
  `UsrEstado` varchar(40) NOT NULL,
  `AreId` int DEFAULT NULL,
  PRIMARY KEY (`UsrId`),
  KEY `IX_Relationship1` (`AreId`),
  CONSTRAINT `Usuarios_Areas` FOREIGN KEY (`AreId`) REFERENCES `areas` (`AreId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'0801200006012','Héctor Daniel','López Borjas','daniel130300@outlook.com','hlopez','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855','Inactivo',1),(2,'0801200612345','David','López','david@gmail.com','dlopez','f6cbc0bdda14c7382db819f9b2b0138341fa0000630ef026bcec20fb03a4d7f2','Activo',2),(3,'0801200054321','Enden Gabriel','Midence Castillo','midence@gmail.com','emidence','0d5498f63c029aa8f7f5022e4873eb8c3380274ff728302da469f98d5384b6ea','Activo',1),(4,'0801200098765','Jose','Guillen','joseguillen@gmail.com','jguillen','344dac26d74a0a0ceaae45a1ebcd2af12d8b5abeae0ff248e76e1443af71b1e2','Inactivo',3),(5,'0801200006014','Ope','Pots','opepots@gmail.com','Opepots','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855','Activo',1),(6,'0801200006015','Héctor Daniel','López Borjas','sfsdfsd@gmail.com','dsgdfgdf','470943e33f08a2d131bc89763c346fbd9ff9212d7c0cd9fc004cf09212a4fd9a','Activo',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 22:44:32
