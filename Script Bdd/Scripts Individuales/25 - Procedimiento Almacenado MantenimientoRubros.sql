CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoRubros`(
IN _Accion VARCHAR(15),
IN _RubId INT,
IN _RubDescripcion VARCHAR(40),
IN _RubEstado VARCHAR(15),
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(RubId) FROM rubros WHERE UPPER(RubDescripcion) = UPPER(_RubDescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF;
		
		IF _Estado = "OK" THEN
			INSERT INTO rubros 
			VALUES
			(
				_RubId, 
				_RubDescripcion, 
                _RubEstado
			);
		END IF;
        
	END IF;    

	IF _Accion LIKE '%editar%' THEN
    
		IF (SELECT COUNT(RubId) FROM rubros WHERE RubId != _RubId AND UPPER(RubDescripcion) = UPPER(_RubDescripcion)) != 0 THEN
			SET _Estado = "errDescripcion";
		END IF;
	
		
		IF _Estado = "OK" THEN
				UPDATE rubros SET 
				RubDescripcion = _RubDescripcion, 
				RubEstado = _RubEstado
				WHERE RubId = _RubId;
		END IF;
        
	END IF;        
END