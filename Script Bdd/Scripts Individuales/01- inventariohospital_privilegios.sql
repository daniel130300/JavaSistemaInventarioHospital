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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegios`
--

LOCK TABLES `privilegios` WRITE;
/*!40000 ALTER TABLE `privilegios` DISABLE KEYS */;
INSERT INTO `privilegios` VALUES (1,'Mantenimiento Usuarios',6),(2,'Mantenimiento Proveedores',3),(3,'Registrar Compras',4),(4,'Mantenimiento Catálogo Bodega',5),(5,'Mantenimiento Inventario Bodega',5),(6,'Mantenimiento Inventario Suministros',2),(7,'Mantenimiento Productos Compuestos',2),(8,'Generar Suministros',2),(9,'Visualizar Alertas',7),(10,'Visualizar Inventario Suministros',2),(11,'Visualizar Inventario Bodega',5),(12,'Facturación',1),(13,'Devolución de Ventas',1),(14,'Bitácora Catálogo Bodega ',5),(15,'Mantenimiento Categorías',5),(16,'Mantenimiento Unidades',5),(17,'Bitácora Inventario Bodega',5),(18,'Mantenimiento Rubros',3),(19,'Devolucion de Compras',4),(20,'Historial de Compras',4);
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

-- Dump completed on 2021-04-29 17:03:33
