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
-- Table structure for table `bitacoracatalogoproductos`
--

DROP TABLE IF EXISTS `bitacoracatalogoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacoracatalogoproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(80) NOT NULL,
  `BcpAccion` varchar(15) NOT NULL,
  `BcpDescripcionCambios` varchar(600) DEFAULT NULL,
  `BcpFecha` datetime NOT NULL,
  `PrdId` int NOT NULL,
  PRIMARY KEY (`BcpId`),
  KEY `IX_Relationship1` (`PrdId`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoracatalogoproductos`
--

LOCK TABLES `bitacoracatalogoproductos` WRITE;
/*!40000 ALTER TABLE `bitacoracatalogoproductos` DISABLE KEYS */;
INSERT INTO `bitacoracatalogoproductos` VALUES (16,'lfernandez','Actualizar','<html><center>Nombre del producto cambio de: Quavo, Takeoff, Offset a: Producto prueba;</center></html> ','2021-04-19 20:31:12',2),(18,'lfernandez','Actualizar','<html><center>Nombre del producto cambio de: Producto prueba neuvo nsfsdf a: LAFLAME;</center></html>','2021-04-19 20:41:42',2),(20,'lfernandez','Insertar','<html><center>Nuevo producto:<br>Id: 5;<br>Nombre: MAX VERSTAPPEN;<br>Descripción: MAX VERSTAPPEN WOLD CHAMPION;<br>Stock Máximo: 20;<br>Stock Mínimo: 5;<br>Estado: Activo;<br>Categoría: CategoriaPrueba;<br>Unidad: Gramos</center></html>;','2021-04-19 21:01:47',5),(21,'lfernandez','Actualizar','<html><center>Nombre del producto cambio de: LAFLAME a: NC-17;<br>Descripción del producto cambio de: Quavos new product straight from migos shop a: LAFLAME;<br>Stock máximo del producto cambio de: 80 a: 60;<br>Stock mínimo del producto cambio de: 20 a: 10;<br>Estado del producto cambio de: Activo a: Inactivo;<br>Categoría del producto cambio de: CategoriaPrueba2 a: CategoriaPrueba;</center></html>','2021-04-20 18:34:41',2),(22,'hlopez','Actualizar','<html><center><br>Estado del producto cambio de: Activo a: Activo ; </center></html>','2021-04-26 15:13:51',9),(23,'hlopez','Actualizar','<html><center><br>Estado del producto cambio de: Activo  a: Inactivo; </center></html>','2021-04-26 15:13:58',9),(24,'hlopez','Actualizar','<html><center><br>Descripción del producto cambio de: dsfsdfsdsdf a: dasdasdasdas; <br>Categoría del producto cambio de: Categora Nueva a: Categoria 3; </center></html>','2021-04-26 15:14:10',9),(25,'hlopez','Actualizar','<html><center><br>Descripción del producto cambio de: LANDO NORRIS FOR THE WIN a: Panadol antigripal; <br>Estado del producto cambio de: Activo a: Activo ; <br>Categoría del producto cambio de: CategoriaPrueba a: Categoria 3; <br>Unidad del producto cambio de: Gramos a: Unidad normal</center></html>','2021-04-26 15:21:00',4),(27,'hlopez','Actualizar','<html><center><br>Stock máximo del producto cambio de: 100 a: 80; <br>Stock mínimo del producto cambio de: 10 a: 20; <br>Estado del producto cambio de: Activo  a: Inactivo; <br>Categoría del producto cambio de: Categoria 3 a: CategoriaPrueba; <br>Unidad del producto cambio de: Unidad normal a: Gramos</center></html>','2021-04-26 15:21:50',4),(28,'hlopez','Actualizar','<html><center><br>Estado del producto cambio de: Inactivo a: Activo ; </center></html>','2021-04-26 15:22:07',4),(31,'hlopez','Actualizar','<html><center>Nombre del producto cambio de: LANDO NORRIS a: Panadol; </center></html>','2021-04-26 15:31:31',4),(32,'hlopez','Actualizar','<html><center>Nombre del producto cambio de: MAX VERSTAPPEN a: Paracetamol; <br>Descripción del producto cambio de: MAX VERSTAPPEN WOLD CHAMPION a: La que la cura todo; <br>Estado del producto cambio de: Activo a: Activo ; <br>Categoría del producto cambio de: CategoriaPrueba a: Categoria 3; <br>Unidad del producto cambio de: Gramos a: Kilogramos</center></html>','2021-04-26 15:32:01',5),(33,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 10;<br>Nombre: Lewis Hamilton;<br>Descripción: Lewis hamilton;<br>Stock Máximo: 70;<br>Stock Mínimo: 20;<br>Estado: Activo;<br>Categoría: Categoria 3;<br>Unidad: Unidad normal;</center></html>','2021-04-26 16:11:43',10),(34,'hlopez','Actualizar','<html><center>Nombre del producto cambio de: Lewis Hamilton a: dasdasaas; <br>Estado del producto cambio de: Activo a: Activo ; <br>Categoría del producto cambio de: Categoria Prueba 3 a: Categoria Prueba 2; </center></html>','2021-04-26 16:38:40',10),(35,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 11;<br>Nombre: sdasdas;<br>Descripción: asdasdas;<br>Stock Máximo: 12;<br>Stock Mínimo: 4;<br>Estado: Activo;<br>Categoría: Categoria Prueba 2;<br>Unidad: Kilogramos;</center></html>','2021-04-26 18:40:33',11),(36,'hlopez','Actualizar','<html><center>Nombre del producto cambio de: sdasdas a: Producto prueba; <br>Descripción del producto cambio de: asdasdas a: asdasdasdasdas; <br>Stock máximo del producto cambio de: 12 a: 100; <br>Estado del producto cambio de: Activo a: Activo ; </center></html>','2021-04-26 18:41:06',11),(38,'lfernandez','Actualizar','<html><center><br>Estado del producto cambio de: Activo  a: Activo; </center></html>','2021-04-26 19:30:47',4),(39,'lfernandez','Actualizar','<html><center><br>Estado del producto cambio de: Activo  a: Activo; </center></html>','2021-04-26 19:30:47',5),(40,'lfernandez','Actualizar','<html><center><br>Estado del producto cambio de: Activo  a: Activo; </center></html>','2021-04-26 19:30:47',10),(41,'lfernandez','Actualizar','<html><center><br>Estado del producto cambio de: Activo  a: Activo; </center></html>','2021-04-26 19:30:47',11),(42,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 12;<br>Nombre: dsadasdas;<br>Descripción: saddasfdsfsd;<br>Stock Máximo: 12;<br>Stock Mínimo: 1;<br>Estado: Activo;<br>Categoría: Categoria Prueba 2;<br>Unidad: Kilogramos;</center></html>','2021-04-26 19:32:37',12),(43,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 13;<br>Nombre: sdfsdfsdfsdf;<br>Descripción: asdasdasdas;<br>Stock Máximo: 12;<br>Stock Mínimo: 1;<br>Estado: Activo;<br>Categoría: Categoria Prueba;<br>Unidad: Gramos;</center></html>','2021-04-26 20:00:12',13),(44,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 14;<br>Nombre: dsfsdfsd;<br>Descripción: sdfsdfsd;<br>Stock Máximo: 21;<br>Stock Mínimo: 12;<br>Estado: Activo;<br>Categoría: Categoria Prueba;<br>Unidad: Gramos;</center></html>','2021-04-26 20:00:36',14),(45,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 15;<br>Nombre: asdasdasd;<br>Descripción: asdasdasdasd;<br>Stock Máximo: 12;<br>Stock Mínimo: 1;<br>Estado: Activo;<br>Categoría: Categoria Prueba;<br>Unidad: Gramos;</center></html>','2021-04-26 20:01:12',15),(46,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 16;<br>Nombre: asdasd;<br>Descripción: asdasd;<br>Stock Máximo: 12;<br>Stock Mínimo: 1;<br>Estado: Activo;<br>Categoría: Categoria Prueba;<br>Unidad: Gramos;</center></html>','2021-04-26 20:02:56',16),(47,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 17;<br>Nombre: asaafsd;<br>Descripción: asdasdasdas;<br>Stock Máximo: 100;<br>Stock Mínimo: 20;<br>Estado: Activo;<br>Categoría: Categoria A;<br>Unidad: Kilogramos;</center></html>','2021-04-26 20:13:50',17),(48,'hlopez','Actualizar','<html><center><br>Descripción del producto cambio de: asdasdasdas a: sdfsdfsdfsdf; <br>Stock máximo del producto cambio de: 100 a: 82; <br>Stock mínimo del producto cambio de: 20 a: 21; <br>Estado del producto cambio de: Activo a: Inactivo; </center></html>','2021-04-26 20:14:03',17),(49,'hlopez','Actualizar','<html><center><br>Stock máximo del producto cambio de: 82 a: 80; </center></html>','2021-04-26 20:14:12',17),(50,'hlopez','Actualizar','<html><center>Nombre del producto cambio de: NC-17 a: NCDiez; </center></html>','2021-04-26 20:18:01',2),(53,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 18;<br>Nombre: NC-20;<br>Descripción: Descripción de prueba lorem ipsum;<br>Stock Máximo: 12;<br>Stock Mínimo: 10;<br>Estado: Activo;<br>Categoría: Categoria Prueba 2;<br>Unidad: Kilogramos;</center></html>','2021-04-26 20:23:48',18),(57,'hlopez','Insertar','<html><center>Nuevo producto:<br>Id: 19;<br>Nombre: Tabcin;<br>Descripción: dasdasasdas;<br>Stock Máximo: 100;<br>Stock Mínimo: 20;<br>Estado: Activo;<br>Categoría: Categoria Prueba 3;<br>Unidad: Gramos;</center></html>','2021-04-27 09:06:03',19),(58,'hlopez','Actualizar','<html><center><br>Descripción del producto cambio de: dasdasasdas a: sadasdasfdsfsdfsdfsdfsdfsdfdsfdsfsd; </center></html>','2021-04-27 09:08:07',19),(59,'hlopez','Actualizar','<html><center><br>Estado del producto cambio de: Activo a: Inactivo; </center></html>','2021-04-27 09:08:22',19),(60,'hlopez','Actualizar','<html><center><br>Descripción del producto cambio de: sadasdasfdsfsdfsdfsdfsdfsdfdsfdsfsd a: Nueva tabcin gripe y tos; </center></html>','2021-04-27 15:47:29',19),(61,'lfernandez','Insertar','<html><center>Nuevo producto:<br>Id: 20;<br>Nombre: sefeertre;<br>Descripción: fsdfsdfsdfsd;<br>Stock Máximo: 20;<br>Stock Mínimo: 10;<br>Estado: Activo;<br>Categoría: Categoria Prueba 2;</center></html>','2021-05-01 00:15:05',20),(62,'lfernandez','Actualizar','<html><center><br>Descripción del producto cambio de: Nueva tabcin gripe y tos a: asdasdas; </center></html>','2021-05-01 00:15:05',19);
/*!40000 ALTER TABLE `bitacoracatalogoproductos` ENABLE KEYS */;
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
