CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoUsuarios`(
IN _Accion VARCHAR(15),
IN _UsrId INT,
IN _UsrIdentidad VARCHAR(20),
IN _UsrNombre VARCHAR(40),
IN _UsrApellido VARCHAR(40),
IN _UsrCorreo VARCHAR(60),
IN _UsrUsuario VARCHAR(40),
IN _UsrContrasenia VARCHAR(128),
IN _UsrEstado VARCHAR(40),
IN _AreId INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrIdentidad = _UsrIdentidad) !=0 THEN
			SET _Estado = "errIdentidad"; 
		END IF;
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrCorreo = _UsrCorreo) !=0 THEN
			SET _Estado = "errCorreo";
		END IF;
        
        IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrUsuario = _UsrUsuario) !=0 THEN
			SET _Estado = "errUsuario";
		END IF;
		
		IF _Estado = "OK" THEN
			INSERT INTO usuarios 
			VALUES
			(
				_UsrId, 
				_UsrIdentidad, 
                _UsrNombre,
                _UsrApellido,
				_UsrCorreo,  
				_UsrUsuario,
				_UsrContrasenia,
				_UsrEstado,
				_AreId
			);
		END IF;
        
	END IF;

	IF _Accion LIKE '%editar%' THEN
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrIdentidad = _UsrIdentidad) != 0 THEN
			SET _Estado = "errIdentidad";
		END IF;
		
		IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrCorreo = _UsrCorreo) != 0 THEN
			SET _Estado = "errCorreo";
		END IF;
        
         IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrUsuario = _UsrUsuario) !=0 THEN
			SET _Estado = "errUsuario";
		END IF;
		
		IF _Estado = "OK" THEN
            IF _UsrContrasenia IS NULL OR _UsrContrasenia = "" THEN
				UPDATE usuarios SET 
				UsrIdentidad = _UsrIdentidad, 
				UsrNombre = _UsrNombre, 
				UsrApellido = _UsrApellido, 
				UsrCorreo = _UsrCorreo,
				UsrUsuario = _UsrUsuario,
				UsrEstado = _UsrEstado,
				AreId = _AreId
				WHERE UsrId = _UsrId;
			ELSE
				UPDATE usuarios SET 
				UsrIdentidad = _UsrIdentidad, 
				UsrNombre = _UsrNombre, 
				UsrApellido = _UsrApellido, 
				UsrCorreo = _UsrCorreo,
				UsrUsuario = _UsrUsuario,
				UsrContrasenia = _UsrContrasenia,
				UsrEstado = _UsrEstado,
				AreId = _AreId
				WHERE UsrId = _UsrId;
            END IF;
		END IF;
        
	END IF;
    
END