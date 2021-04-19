CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoCatalogoProductos`(
IN _Accion VARCHAR(15),
IN _PrdId INT,
IN _PrdNombre VARCHAR(40),
IN _PrdDescripcion VARCHAR(100),
IN _PrdStockMaximo INT,
IN _PrdStockMinimo INT,
IN _PrdEstado VARCHAR(15),
IN _CprId INT,
IN _UndId INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(PrdId) FROM catalogoproductos WHERE UPPER(PrdNombre) = UPPER(_PrdNombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
        
		IF _Estado = "OK" THEN
			INSERT INTO catalogoproductos 
			VALUES
			(
				_PrdId, 
				_PrdNombre, 
                _PrdDescripcion,
                _PrdStockMaximo,
				_PrdStockMinimo,  
				_PrdEstado,
				_CprId,
				_UndId
			);
		END IF;
	END IF;

	IF _Accion LIKE '%editar%' THEN
        IF (SELECT COUNT(PrdId) FROM catalogoproductos WHERE PrdId != _PrdId AND UPPER(PrdNombre) = UPPER(_PrdNombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
	
		IF _Estado = "OK" THEN
			UPDATE catalogoproductos SET 
			PrdDescripcion = _PrdDescripcion, 
			PrdStockMaximo = _PrdStockMaximo, 
			PrdStockMinimo = _PrdStockMinimo, 
			PrdEstado = _PrdEstado,
			CprId = _CprId,
			UndId = _UndId
			WHERE PrdId = _PrdId;
		END IF; 
	END IF;
END