CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoInventarioHijo`(
IN _Accion VARCHAR(15),
IN _InvHId INT,
IN _InvHDescripcion VARCHAR(150),
IN _InvHCantidad INT,
IN _InvPId INT,
IN _UndId INT,
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    
    IF _Accion LIKE '%insertar%' THEN
    
	SET _InvPId = (SELECT InvPId FROM inventariopadre ORDER BY InvPId DESC LIMIT 1);
    
    IF (SELECT COUNT(InvHId) FROM inventariohijo WHERE InvPId = _InvPId) !=0 THEN
			SET _Estado = "errProducto"; 
		END IF;
        
		IF _Estado = "OK" THEN
         
        INSERT INTO inventariohijo
        VALUES
        (
			_InvHId,
			_InvHDescripcion,
            _InvHCantidad,
            _InvPId,
            _UndId
        );
    END IF; 
  END IF;  
  
    IF _Accion LIKE '%editar%' THEN 
         SET _InvPId = (SELECT InvPId FROM inventariohijo WHERE InvHId = _InvHId);
         
        IF _Estado = "OK" THEN
		
			UPDATE inventariohijo SET 
			InvHDescripcion = _InvHDescripcion, 
			InvHCantidad= _InvHCantidad,
			InvPId = _InvPId,
			UndId = _UndId
			WHERE InvHId =  _InvHId;
        END IF;
	END IF;
END