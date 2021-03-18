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
-- Dumping events for database 'inventariohospital'
--

--
-- Dumping routines for database 'inventariohospital'
--
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoUsuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoUsuarios`(
IN _Accion VARCHAR(15),
IN _UsrId INT,
IN _UsrIdentidad VARCHAR(20),
IN _UsrNombre VARCHAR(40),
IN _UsrApellido VARCHAR(40),
IN _UsrCorreo VARCHAR(60),
IN _UsrUsuario VARCHAR(40),
IN _UsrContrasenia VARCHAR(128),
IN _UsrEstado VARCHAR(40),
IN _AreId INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrIdentidad = _UsrIdentidad) !=0 THEN
			SET _Estado = "errIdentidad"; 
		END IF;
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrCorreo = _UsrCorreo) !=0 THEN
			SET _Estado = "errCorreo";
		END IF;
		
		IF _Estado = "OK" THEN
			INSERT INTO usuarios 
			VALUES
			(
				_UsrId, 
				_UsrIdentidad, 
                _UsrNombre,
                _UsrApellido,
				_UsrCorreo,  
				_UsrUsuario,
				_UsrContrasenia,
				_UsrEstado,
				_AreId
			);
		END IF;
        
	END IF;

	IF _Accion LIKE '%editar%' THEN
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrIdentidad = _UsrIdentidad) != 0 THEN
			SET _Estado = "errIdentidad";
		END IF;
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrCorreo = _UsrCorreo) != 0 THEN
			SET _Estado = "errCorreo";
		END IF;
		
		IF _Estado = "OK" THEN
            IF _UsrContrasenia IS NULL OR _UsrContrasenia = "" THEN
				UPDATE usuarios SET 
				UsrIdentidad = _UsrIdentidad, 
				UsrNombre = _UsrNombre, 
				UsrApellido = _UsrApellido, 
				UsrCorreo = _UsrCorreo,
				UsrUsuario = _UsrUsuario,
				UsrEstado = _UsrEstado,
				AreId = _AreId
				WHERE UsrId = _UsrId;
			ELSE
				UPDATE usuarios SET 
				UsrIdentidad = _UsrIdentidad, 
				UsrNombre = _UsrNombre, 
				UsrApellido = _UsrApellido, 
				UsrCorreo = _UsrCorreo,
				UsrUsuario = _UsrUsuario,
				UsrContrasenia = _UsrContrasenia,
				UsrEstado = _UsrEstado,
				AreId = _AreId
				WHERE UsrId = _UsrId;
            END IF;
		END IF;
        
	END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 22:44:44
