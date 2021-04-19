CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoProveedores`(
IN _Accion VARCHAR(15),
IN _ProId INT,
IN _ProRTN VARCHAR(40),
IN _ProNombre VARCHAR(40),
IN _ProCorreo VARCHAR(60),
IN _ProTelefono VARCHAR(20),
IN _ProContacto VARCHAR(40),
IN _ProDireccion VARCHAR(100),
IN _ProEstado VARCHAR(10),
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "Ok";
    
	IF _Accion LIKE '%insertar%' THEN
    
		IF (SELECT COUNT(ProId) FROM proveedores WHERE ProRTN = _ProRTN) !=0 THEN
			SET _Estado = "errRTN"; 
		END IF;
		
		IF (SELECT COUNT(ProId) FROM proveedores WHERE ProCorreo = _ProCorreo) !=0 THEN
			SET _Estado = "errCorreo";
		END IF;
		
		IF _Estado = "Ok" THEN
			INSERT INTO proveedores 
			VALUES
			(
				_ProId, 
				_ProRTN, 
                _ProNombre,
                _ProCorreo,
				_ProTelefono,  
				_ProContacto,
				_ProDireccion,
                "Activo"
			);
		END IF;
        
	END IF;    

	IF _Accion LIKE '%editar%' THEN
    
		IF (SELECT COUNT(ProId) FROM proveedores WHERE ProId != _ProId AND ProRTN = _ProRTN) != 0 THEN
			SET _Estado = "errRTN";
		END IF;
	
		
		IF _Estado = "Ok" THEN
				UPDATE proveedores SET 
				ProRTN = _ProRTN, 
				ProNombre = _ProNombre, 
				ProCorreo = _ProCorreo, 
				ProTelefono = _ProTelefono,
				ProContacto = _ProContacto,
				ProDireccion = _ProDireccion,
                ProEstado= _ProEstado
				WHERE ProId = _ProId;
		END IF;
        
	END IF;        
    

END