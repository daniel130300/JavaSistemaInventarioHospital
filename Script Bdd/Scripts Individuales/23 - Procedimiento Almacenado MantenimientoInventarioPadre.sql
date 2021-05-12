CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoInventarioPadre`(
IN _Accion VARCHAR(15),
IN _InvPId INT,
IN _InvPCodInterno VARCHAR(45),
IN _InvPDescripcion VARCHAR(150), 
IN _InvPFchCaducidad DATE,
IN _InvPCantidad INT,
IN _UndId INT,
IN _KitId INT,
IN _PrdId INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		
        IF (SELECT COUNT(InvPId) FROM inventariopadre WHERE PrdId != 1 AND PrdId = _PrdId) !=0 THEN
			SET _Estado = "errProducto"; 
		END IF;
        
        IF (_PrdId = 20 AND _KitId = 1) !=0 THEN
          SET _Estado = "errRegistro";
        END IF;
	
    IF (SELECT COUNT(InvPId) FROM inventariopadre WHERE KitId != 1 AND KitId = _KitId) !=0 THEN
			SET _Estado = "errKit"; 
		END IF;
        
		IF _Estado = "OK" THEN
			INSERT INTO inventariopadre 
			VALUES
			(
				_InvPId,
				_InvPCodInterno,
				_InvPDescripcion, 
				_InvPFchCaducidad,
				_InvPCantidad,
				_UndId,
				_KitId,
                _PrdId 
			);
		END IF;
	END IF;

	IF _Accion LIKE '%editar%' THEN
    
		IF (SELECT COUNT(InvPId) FROM inventariopadre WHERE InvPId != _InvPId AND PrdId != 1 AND PrdId = _PrdId) !=0 THEN
			SET _Estado = "errProducto"; 
		END IF;
        
	IF (_PrdId = 1 AND _KitId = 1) !=0 THEN
          SET _Estado = "errRegistro";
        END IF;
        
    IF (SELECT COUNT(InvPId) FROM inventariopadre WHERE InvPId != _InvPId AND KitId != 1 AND KitId = _KitId) !=0 THEN
			SET _Estado = "errKit"; 
		END IF;
	
		IF _Estado = "OK" THEN
			UPDATE inventariopadre SET 
			InvPCodInterno =  _InvPCodInterno,
			InvPDescripcion = _InvPDescripcion, 
			invPFchCaducidad= _InvPFchCaducidad,
			InvPCantidad = _InvPCantidad,
			UndId = _UndId,
			KitId = _KitId,
            PrdId = _PrdId
			WHERE InvPId = _InvPId;
		END IF; 
	END IF;
END