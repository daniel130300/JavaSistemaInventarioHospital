CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoCategorias`(
IN _Accion VARCHAR(15),
IN _CprId INT,
IN _CprDescripcion VARCHAR(40),
IN _CprEstado VARCHAR(15),
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(CprId) FROM categoriasproductos WHERE UPPER(CprDescripcion) = UPPER(_CprDescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF;
		
		IF _Estado = "OK" THEN
			INSERT INTO categoriasproductos 
			VALUES
			(
				_CprId, 
				_CprDescripcion, 
                _CprEstado
			);
		END IF;
        
	END IF;    

	IF _Accion LIKE '%editar%' THEN
    
		IF (SELECT COUNT(CprId) FROM categoriasproductos WHERE CprId != _CprId AND UPPER(CprDescripcion) = UPPER(_CprDescripcion)) != 0 THEN
			SET _Estado = "errDescripcion";
		END IF;
	
		
		IF _Estado = "OK" THEN
				UPDATE categoriasproductos SET 
				CprDescripcion = _CprDescripcion, 
				CprEstado = _CprEstado
				WHERE CprId = _CprId;
		END IF;
        
	END IF;        
END