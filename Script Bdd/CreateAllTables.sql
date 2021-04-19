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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `AreId` int NOT NULL AUTO_INCREMENT,
  `AreDescripcion` varchar(40) NOT NULL,
  PRIMARY KEY (`AreId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'Administración'),(2,'Suministros'),(3,'Bodega'),(4,'Ventas');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:00


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
-- Table structure for table `privilegios`
--

DROP TABLE IF EXISTS `privilegios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilegios` (
  `PriId` int NOT NULL AUTO_INCREMENT,
  `PriDescripcion` varchar(80) NOT NULL,
  `PriIdModulo` int DEFAULT NULL COMMENT 'Este codigo se utiliza para definir a que modulo general pertenece el privilegio.\n1 - Ventas\n2 - Suministros\n3 - Proveedores\n4 - Compras\n5 - Bodega\n6 - Usuarios\n7 - Alertas ',
  PRIMARY KEY (`PriId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegios`
--

LOCK TABLES `privilegios` WRITE;
/*!40000 ALTER TABLE `privilegios` DISABLE KEYS */;
INSERT INTO `privilegios` VALUES (1,'Mantenimiento Usuarios',6),(2,'Mantenimiento Proveedores',3),(3,'Mantenimiento Compras',4),(4,'Mantenimiento Catálogo Bodega',5),(5,'Mantenimiento Inventario Bodega',5),(6,'Mantenimiento Inventario Suministros',2),(7,'Mantenimiento Productos Compuestos',2),(8,'Generar Suministros',2),(9,'Visualizar Alertas',7),(10,'Visualizar Inventario Suministros',2),(11,'Visualizar Inventario Bodega',5),(12,'Facturación',1),(13,'Devolución de Ventas',1),(14,'Bitacora Catálogo Bodega ',5),(15,'Mantenimiento Categorías',5),(16,'Mantenimiento Unidades',5);
/*!40000 ALTER TABLE `privilegios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:02


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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'0801200006012','Lourdes','Fernandez','lfernandez@unicah.edu','lfernandez','364e75c08b4215d15991c9ef95ce2f02055851abe467ecab693ca93446900e7e','Activo',1),(2,'0801200612345','Héctor Daniel','López Borjas','daniel130300@outlook.com','hlopez','f6cbc0bdda14c7382db819f9b2b0138341fa0000630ef026bcec20fb03a4d7f2','Activo',2),(3,'0801200054321','Enden Gabriel','Midence Castillo','midence@gmail.com','emidence','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855','Activo',1),(4,'0801200098765','José Daniel','Guillen','jguillen130300@outlook.com','jguillen','344dac26d74a0a0ceaae45a1ebcd2af12d8b5abeae0ff248e76e1443af71b1e2','Activo',2),(5,'0801200006014','Ope','Pots','opepots@gmail.com','Opepots','f5fd497e61d4785dbc83fae83d47517cd8186f150de3923de9b48963d60be48f','Activo',3),(11,'0801123454321','Dereck Rene','Zavala','dzavala@gmail.com','dzavala','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855','Activo',4),(14,'0801432112345','Carlos','Ordoñez','cordonez@gmail.com','cordonez','f5fd497e61d4785dbc83fae83d47517cd8186f150de3923de9b48963d60be48f','Activo',1),(15,'0801199912345','Juan Carlos','Ordoñez','juanordonez@gmail.com','jordonez','f5fd497e61d4785dbc83fae83d47517cd8186f150de3923de9b48963d60be48f','Activo',2),(16,'0801432154321','Luis','Martinez','lmartinez@gmail.com','lmartinez','3374c93b2fdf1235bc2bc32e0bd86776e2a55441b2760a69fe24d940c2d62829','Activo',4),(18,'0801199954321','Armando José','López López','arma_jose9@hotmail.es','alopez','f6cbc0bdda14c7382db819f9b2b0138341fa0000630ef026bcec20fb03a4d7f2','Activo',3),(19,'0801123406012','Jose','Lainez','joselainez@gmail.com','jlainez','a4aa9f186b333fbadfd4d9c470a6b8d9c2e4bcf9871944c917d6a40d20a43140','Inactivo',4);
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

-- Dump completed on 2021-04-18 18:26:01

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
-- Table structure for table `detalleusuarios`
--

DROP TABLE IF EXISTS `detalleusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleusuarios` (
  `DtuId` int NOT NULL AUTO_INCREMENT,
  `UsrId` int NOT NULL,
  `PriId` int NOT NULL,
  PRIMARY KEY (`DtuId`)
) ENGINE=InnoDB AUTO_INCREMENT=416 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleusuarios`
--

LOCK TABLES `detalleusuarios` WRITE;
/*!40000 ALTER TABLE `detalleusuarios` DISABLE KEYS */;
INSERT INTO `detalleusuarios` VALUES (15,12,1),(16,12,2),(17,12,3),(18,12,4),(19,12,5),(20,12,6),(21,12,7),(22,12,8),(23,12,9),(24,12,10),(25,12,11),(26,12,12),(27,12,13),(28,13,1),(29,13,2),(30,13,3),(31,13,4),(32,13,5),(33,13,6),(34,13,7),(35,13,8),(36,13,9),(37,13,10),(38,13,11),(39,13,12),(40,13,13),(41,14,1),(42,14,2),(43,14,3),(44,14,4),(45,14,5),(46,14,6),(47,14,7),(48,14,8),(49,14,9),(50,14,10),(51,14,11),(52,14,12),(53,14,13),(78,11,12),(79,11,13),(199,3,1),(200,3,2),(201,3,3),(202,3,4),(203,3,5),(204,3,6),(205,3,7),(206,3,8),(207,3,10),(208,3,11),(209,3,12),(210,3,13),(211,3,9),(281,5,2),(282,5,3),(283,5,4),(284,5,5),(285,5,14),(293,16,12),(294,16,13),(309,17,12),(310,17,13),(311,17,6),(312,17,7),(313,17,8),(314,17,10),(315,17,2),(316,17,3),(317,17,4),(319,17,14),(320,17,5),(322,17,11),(361,15,7),(362,15,8),(363,18,4),(364,18,5),(365,1,1),(366,1,2),(367,1,3),(368,1,4),(369,1,5),(370,1,6),(371,1,7),(372,1,8),(373,1,9),(374,1,10),(375,1,11),(376,1,12),(377,1,13),(378,2,6),(379,2,10),(380,2,7),(381,2,12),(382,2,13),(383,2,8),(384,2,2),(385,2,3),(386,2,4),(387,2,5),(388,2,11),(389,2,1),(390,2,9),(405,4,6),(406,4,7),(407,4,10),(408,1,14),(409,1,15),(410,1,16),(411,2,14),(412,2,15),(413,2,16),(414,19,12),(415,19,13);
/*!40000 ALTER TABLE `detalleusuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:02

CREATE TABLE `proveedores` (
  `ProId` int NOT NULL AUTO_INCREMENT,
  `ProRTN` varchar(40) NOT NULL,
  `ProNombre` varchar(40) NOT NULL,
  `ProCorreo` varchar(60) NOT NULL,
  `ProTelefono` varchar(20) NOT NULL,
  `ProContacto` varchar(40) NOT NULL,
  `ProDireccion` varchar(100) NOT NULL,
  `ProEstado` varchar(45) NOT NULL,
  PRIMARY KEY (`ProId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM inventariohospital.proveedores;

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
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades` (
  `UndId` int NOT NULL,
  `UndDescripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`UndId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades`
--

LOCK TABLES `unidades` WRITE;
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:00


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
-- Table structure for table `categoriasproductos`
--

DROP TABLE IF EXISTS `categoriasproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoriasproductos` (
  `CprId` int NOT NULL AUTO_INCREMENT,
  `CprDescripcion` varchar(40) NOT NULL,
  `CprEstado` varchar(15) NOT NULL,
  PRIMARY KEY (`CprId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasproductos`
--

LOCK TABLES `categoriasproductos` WRITE;
/*!40000 ALTER TABLE `categoriasproductos` DISABLE KEYS */;
INSERT INTO `categoriasproductos` VALUES (1,'CategoriaPrueba','Activo'),(2,'CategoriaPrueba2','Inactivo'),(3,'Categoria 3','Activo'),(4,'Categora Nueva','Activo'),(5,'Categoria Nueva','Activo');
/*!40000 ALTER TABLE `categoriasproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:01



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
-- Table structure for table `catalogoproductos`
--

DROP TABLE IF EXISTS `catalogoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogoproductos` (
  `PrdId` int NOT NULL,
  `PrdNombre` varchar(40) NOT NULL,
  `PrdDescripcion` varchar(100) NOT NULL,
  `PrdStockMaximo` int NOT NULL,
  `PrdStockMinimo` int NOT NULL,
  `PrdEstado` varchar(15) NOT NULL,
  `CprId` int DEFAULT NULL,
  `UndId` int DEFAULT NULL,
  PRIMARY KEY (`PrdId`),
  KEY `IX_Relationship10` (`CprId`),
  KEY `IX_Relationship11` (`UndId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogoproductos`
--

LOCK TABLES `catalogoproductos` WRITE;
/*!40000 ALTER TABLE `catalogoproductos` DISABLE KEYS */;
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

-- Dump completed on 2021-04-18 18:26:02


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
-- Table structure for table `bitacoracatalogoproductos`
--

DROP TABLE IF EXISTS `bitacoracatalogoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacoracatalogoproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(40) NOT NULL,
  `BcpAccion` varchar(5) NOT NULL,
  `BcpDescripcionCambios` varchar(300) DEFAULT NULL,
  `BcpFecha` date NOT NULL,
  PRIMARY KEY (`BcpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoracatalogoproductos`
--

LOCK TABLES `bitacoracatalogoproductos` WRITE;
/*!40000 ALTER TABLE `bitacoracatalogoproductos` DISABLE KEYS */;
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

-- Dump completed on 2021-04-18 18:26:02


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
-- Table structure for table `detallebitacoracatalogoproductos`
--

DROP TABLE IF EXISTS `detallebitacoracatalogoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallebitacoracatalogoproductos` (
  `PrdId` int NOT NULL,
  `BcpId` int NOT NULL,
  PRIMARY KEY (`PrdId`,`BcpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallebitacoracatalogoproductos`
--

LOCK TABLES `detallebitacoracatalogoproductos` WRITE;
/*!40000 ALTER TABLE `detallebitacoracatalogoproductos` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallebitacoracatalogoproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 18:26:01


CREATE TABLE `loteproductos` (
  `LprId` int NOT NULL,
  `LprFechaCaducidad` date NOT NULL,
  `LprStock` int NOT NULL,
  `PrdId` int DEFAULT NULL,
  PRIMARY KEY (`LprId`),
  KEY `IX_Relationship4` (`PrdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `bitacoraloteproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(40) NOT NULL,
  `BcpAccion` varchar(5) NOT NULL,
  `BcpDescripcionCambios` varchar(300) DEFAULT NULL,
  `BcpFecha` date NOT NULL,
  PRIMARY KEY (`BcpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `detallebitacoraloteproductos` (
  `BcpId` int NOT NULL,
  `LprId` int NOT NULL,
  PRIMARY KEY (`BcpId`,`LprId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;










