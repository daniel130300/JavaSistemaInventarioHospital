CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoUnidades`(
IN _Accion VARCHAR(15),
IN _UndId INT,
IN _UndDescripcion VARCHAR(40),
IN _UndEstado VARCHAR(15),
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(UndId) FROM unidades WHERE UPPER(UndDescripcion) = UPPER(_UndDescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF;
		
		IF _Estado = "OK" THEN
			INSERT INTO unidades 
			VALUES
			(
				_UndId, 
				_UndDescripcion, 
                _UndEstado
			);
		END IF;
        
	END IF;    

	IF _Accion LIKE '%editar%' THEN
    
		IF (SELECT COUNT(UndId) FROM unidades WHERE UndId != _UndId AND UPPER(UndDescripcion) = UPPER(_UndDescripcion)) != 0 THEN
			SET _Estado = "errDescripcion";
		END IF;
	
		
		IF _Estado = "OK" THEN
				UPDATE unidades SET 
				UndDescripcion = _UndDescripcion, 
				UndEstado = _UndEstado
				WHERE UndId = _UndId;
		END IF;
        
	END IF;        
END