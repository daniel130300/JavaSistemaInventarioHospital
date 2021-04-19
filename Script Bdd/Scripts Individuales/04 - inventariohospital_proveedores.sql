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