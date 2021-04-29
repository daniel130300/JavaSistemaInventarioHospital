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
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `ProId` int NOT NULL AUTO_INCREMENT,
  `ProRTN` varchar(40) NOT NULL,
  `ProNombre` varchar(40) NOT NULL,
  `ProCorreo` varchar(60) NOT NULL,
  `ProTelefono` varchar(20) NOT NULL,
  `ProTelefono2` varchar(20) DEFAULT NULL,
  `ProTelefono3` varchar(20) DEFAULT NULL,
  `ProContacto` varchar(40) NOT NULL,
  `ProDireccion` varchar(100) NOT NULL,
  `ProEstado` varchar(45) NOT NULL,
  `RubId` int NOT NULL,
  PRIMARY KEY (`ProId`),
  KEY `IX_Relationship1` (`RubId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'080120000432','Proveedor Nuevo','proveedornuevo@gmail.com','97977966','32432342','','Juan Perez','Col. Kennedy','Activo',1),(2,'23423432432','Proveedor Prueba','proveedorprueba@gmail.com','97123112','','','Javier Lopez','Blvd. Morazan','Activo',1),(3,'08011234123456333','Proveedor 2','proveedor2@gmail.com','96965321','','','Carlos Gutierrez','Barrio la Concordia, Bloque b1 #234234','Activo',1),(4,'0801124424322','Proveedor 1','proveedor2@gmail.com','12121212','','','Francisco Aleman','Ciudad Lempira Bloque B1, Casa #8','Inactivo',1),(5,'080119921233','Proveedor Las Hadas','proveedor@gmail.com','82124212','','','Javier Martinez','dasdsdasdas','Inactivo',1);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
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
