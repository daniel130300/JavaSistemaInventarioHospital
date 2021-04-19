CREATE TABLE `loteproductos` (
  `LprId` int NOT NULL,
  `LprFechaCaducidad` date NOT NULL,
  `LprStock` int NOT NULL,
  `PrdId` int DEFAULT NULL,
  PRIMARY KEY (`LprId`),
  KEY `IX_Relationship4` (`PrdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
