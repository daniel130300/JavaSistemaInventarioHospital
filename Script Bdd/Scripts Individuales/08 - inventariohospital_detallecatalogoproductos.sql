CREATE TABLE `detallecatalogoproductos` (
  `DcpId` int NOT NULL AUTO_INCREMENT,
  `ProId` int NOT NULL,
  `PrdId` int NOT NULL,
  `DcpPrecioCompra` decimal(9,2) NOT NULL,
  PRIMARY KEY (`DcpId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
