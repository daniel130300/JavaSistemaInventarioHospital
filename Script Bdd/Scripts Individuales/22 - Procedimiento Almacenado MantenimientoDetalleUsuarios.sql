CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoDetalleUsuarios`(	
	IN _Accion VARCHAR(10), 
	IN _DtuId INT,
	IN _UsrId INT,
    IN _PriId INT,
    OUT _Estado VARCHAR(10)
)
BEGIN
	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
        SET _UsrId = (SELECT UsrId FROM usuarios ORDER BY usuarios.UsrId DESC LIMIT 1);
		INSERT INTO detalleusuarios
        VALUES
        (
			_DtuId,
            _UsrId,
            _PriId
        );
	END IF;
    
    IF _Accion LIKE '%editar%' THEN 
        INSERT INTO detalleusuarios 
        VALUES
        (
			_DtuId,
            _UsrId,
            _PriId
        );
	END IF;
    
    IF _Accion LIKE '%eliminar%' THEN
		  DELETE FROM detalleusuarios WHERE DtuId = _DtuId;
    END IF;
    
END