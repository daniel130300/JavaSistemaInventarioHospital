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
-- Table structure for table `catalogoproductos`
--

DROP TABLE IF EXISTS `catalogoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogoproductos` (
  `PrdId` int NOT NULL AUTO_INCREMENT,
  `PrdNombre` varchar(40) NOT NULL,
  `PrdDescripcion` varchar(100) NOT NULL,
  `PrdStockMaximo` int NOT NULL,
  `PrdStockMinimo` int NOT NULL,
  `PrdEstado` varchar(15) NOT NULL,
  `CprId` int DEFAULT NULL,
  PRIMARY KEY (`PrdId`),
  KEY `IX_Relationship10` (`CprId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogoproductos`
--

LOCK TABLES `catalogoproductos` WRITE;
/*!40000 ALTER TABLE `catalogoproductos` DISABLE KEYS */;
INSERT INTO `catalogoproductos` VALUES (1,'Producto nuevo medico','Producto nuevo medico',50,10,'Activo',3),(2,'NCDiez','LAFLAME',60,10,'Inactivo',1),(4,'Panadol','Panadol antigripal',80,20,'Activo',1),(5,'Paracetamol','La que la cura todo',20,5,'Activo',3),(9,'asdasdas','dasdasdasdas',100,10,'Inactivo',3),(10,'dasdasaas','Lewis hamilton',70,20,'Activo',2),(11,'Producto prueba','asdasdasdasdas',100,4,'Activo',2),(12,'dsadasdas','saddasfdsfsd',12,1,'Activo',2),(13,'sdfsdfsdfsdf','asdasdasdas',12,1,'Activo',1),(14,'dsfsdfsd','sdfsdfsd',21,12,'Activo',1),(15,'asdasdasd','asdasdasdasd',12,1,'Activo',1),(16,'asdasd','asdasd',12,1,'Activo',1),(17,'asaafsd','sdfsdfsdfsdf',80,21,'Inactivo',6),(18,'NC-20','Descripción de prueba lorem ipsum',12,10,'Activo',2),(19,'Tabcin','Nueva tabcin gripe y tos',100,20,'Inactivo',3);
/*!40000 ALTER TABLE `catalogoproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 17:03:32
