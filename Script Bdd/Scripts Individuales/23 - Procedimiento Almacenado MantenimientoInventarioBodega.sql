CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoInventarioBodega`(
IN _Accion VARCHAR(15),
IN _LprId INT,
IN _LprFechaCaducidad DATE,
IN _LprStock INT,
IN _LprEstado VARCHAR(10),
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";

	IF _Accion LIKE '%editar%' THEN
    
		IF _Estado = "OK" THEN
				UPDATE loteproductos SET 
                LprFechaCaducidad = _LprFechaCaducidad,
                LprStock = _LprStock,
                LprEstado = _LprEstado
				WHERE LprId = _LprId;
		END IF;
        
	END IF;        
END