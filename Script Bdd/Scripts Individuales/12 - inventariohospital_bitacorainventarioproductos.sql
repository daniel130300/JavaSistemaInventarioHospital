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
-- Table structure for table `bitacorainventarioproductos`
--

DROP TABLE IF EXISTS `bitacorainventarioproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacorainventarioproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(40) NOT NULL,
  `BcpAccion` varchar(15) NOT NULL,
  `BcpDescripcionCambios` varchar(300) DEFAULT NULL,
  `BcpFecha` datetime NOT NULL,
  `InvPrdId` int DEFAULT NULL,
  PRIMARY KEY (`BcpId`),
  KEY `IX_Relationship2` (`InvPrdId`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacorainventarioproductos`
--

LOCK TABLES `bitacorainventarioproductos` WRITE;
/*!40000 ALTER TABLE `bitacorainventarioproductos` DISABLE KEYS */;
INSERT INTO `bitacorainventarioproductos` VALUES (1,'lfernandez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-01 a: 2022-01-12</center></html>; ','2021-04-20 14:47:53',1),(2,'lfernandez','Actualizar','<html><center>El stock cambio de: 100 a: 60;</center></html> ','2021-04-20 14:57:33',1),(3,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 80; </center></html>','2021-04-22 18:56:12',1),(4,'hlopez','Actualizar','<html><center><br>El stock cambio de: 80 a: 70; </center></html>','2021-04-22 19:06:30',1),(5,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-12 a: 2022-01-30; </center></html>','2021-04-22 19:06:37',1),(6,'hlopez','Actualizar','<html><center><br>El stock cambio de: 70 a: 50; </center></html>','2021-04-23 18:50:47',1),(7,'hlopez','Actualizar','<html><center><br>El stock cambio de: 50 a: 100; <br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:34:25',1),(8,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 30; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:34:36',1),(9,'hlopez','Actualizar','<html><center><br>El stock cambio de: 30 a: 100; </center></html>','2021-04-26 14:35:06',1),(10,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:35:11',1),(11,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:35:22',1),(12,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-01-30 a: 2022-02-21; </center></html>','2021-04-26 14:39:35',1),(13,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 50; <br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:39:46',1),(14,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:39:53',1),(15,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 14:40:00',1),(16,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 14:40:11',1),(17,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 15:05:35',1),(18,'hlopez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 15:05:40',1),(19,'hlopez','Actualizar','<html><center><br>El stock cambio de: 50 a: 100; </center></html>','2021-04-26 15:43:56',1),(20,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-02-21 a: 2022-12-30; </center></html>','2021-04-26 15:44:20',1),(21,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 15:44:27',1),(22,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 90; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 18:27:48',1),(23,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-26 18:54:47',1),(25,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-12-30 a: 2022-02-20; <br>El stock cambio de: 90 a: 60; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-26 20:15:01',1),(26,'hlopez','Actualizar','<html><center><br>El stock cambio de: 60 a: 100; </center></html>','2021-04-26 20:34:00',1),(27,'hlopez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-04-27 09:14:26',1),(28,'hlopez','Actualizar','<html><center><br>El stock cambio de: 100 a: 20; </center></html>','2021-04-27 09:16:04',1),(29,'hlopez','Actualizar','<html><center>La fecha de caducidad cambio de: 2022-02-20 a: 2022-02-21; <br>El stock cambio de: 20 a: 120; <br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-04-27 15:46:52',1),(30,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-05-01 02:21:03',1),(31,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-05-01 02:21:03',2),(32,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Activo a: Inactivo; </center></html>','2021-05-01 02:21:03',3),(33,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-05-01 02:22:28',1),(34,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-05-01 02:22:28',2),(35,'lfernandez','Actualizar','<html><center><br>El estado cambio de: Inactivo a: Activo; </center></html>','2021-05-01 02:22:28',3),(36,'lfernandez','Actualizar','<html><center><br>La extraibilidad cambio de: NO a: SI; </center></html>','2021-05-01 02:28:14',1),(37,'lfernandez','Actualizar','<html><center><br>La extraibilidad cambio de: NO a: SI; </center></html>','2021-05-01 02:28:14',2),(38,'lfernandez','Actualizar','<html><center><br>La extraibilidad cambio de: SI a: NO; </center></html>','2021-05-01 02:28:52',1),(39,'lfernandez','Actualizar','<html><center><br>La extraibilidad cambio de: SI a: NO; </center></html>','2021-05-01 02:28:52',2),(40,'lfernandez','Actualizar','<html><center><br>El padre cambio de: 1 a: 2; </center></html>','2021-05-01 02:29:17',2),(41,'lfernandez','Actualizar','<html><center><br>El padre cambio de: 2 a: 1; </center></html>','2021-05-01 02:29:17',3),(42,'lfernandez','Actualizar','<html><center><br>El padre cambio de: 2 a: 1; </center></html>','2021-05-01 02:29:26',2),(43,'lfernandez','Actualizar','<html><center><br>El padre cambio de: 1 a: 2; </center></html>','2021-05-01 02:29:26',3),(48,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 4;</center></html>','2021-05-01 02:57:48',4),(49,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 4;<br>Código interno: CAT2-0003-0004;<br>Fecha de caducidad: 2021-10-21;<br>Estado: Activo;</center></html>','2021-05-01 03:01:06',4),(52,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 4;<br>Código interno: CAT2-0003-0004;<br>Fecha de caducidad: 2021-10-21;<br>Estado: Activo;<br>Padre: null;</center></html>','2021-05-01 03:13:31',4),(53,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 5;<br>Código interno: CAT3-0006-0005;<br>Fecha de caducidad: 2021-10-29;<br>Estado: Activo;<br>Padre: null;</center></html>','2021-05-01 03:15:21',5),(59,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 5;<br>Código interno: CAT3-0006-0005;<br>Fecha de caducidad: 2021-10-23;<br>Estado: Activo;<br>Padre: nulo;</center></html>','2021-05-01 03:36:26',5),(62,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 6;<br>Código interno: CAT3-0006-0006;<br>Fecha de caducidad: 2021-10-24;<br>Estado: Activo;<br>Padre: 1;</center></html>','2021-05-01 03:42:23',6),(64,'lfernandez','Insertar','<html><center>Nuevo producto en inventario:<br>Id: 6;<br>Código interno: CAT3-0006-0006;<br>Fecha de caducidad: nulo;<br>Estado: Activo;<br>Padre: nulo;<br>Factor: 1;<br>Es extraible: SI;<br>Unidad: Unidad;</center></html>','2021-05-01 03:47:44',6);
/*!40000 ALTER TABLE `bitacorainventarioproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30 21:57:01
