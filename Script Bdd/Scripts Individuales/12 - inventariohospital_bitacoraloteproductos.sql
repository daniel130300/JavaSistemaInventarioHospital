CREATE TABLE `bitacoraloteproductos` (
  `BcpId` int NOT NULL AUTO_INCREMENT,
  `UsrUsuario` char(40) NOT NULL,
  `BcpAccion` varchar(5) NOT NULL,
  `BcpDescripcionCambios` varchar(300) DEFAULT NULL,
  `BcpFecha` date NOT NULL,
  PRIMARY KEY (`BcpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
