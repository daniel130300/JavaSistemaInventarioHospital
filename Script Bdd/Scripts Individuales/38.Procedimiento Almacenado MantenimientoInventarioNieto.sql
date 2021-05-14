CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoInventarioNieto`(
IN _Accion VARCHAR(15),
IN _InvNId INT,
IN _InvNDescripcion VARCHAR(150),
IN _InvNCantidad INT,
IN _InvHId INT,
IN _UndId INT,
OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    IF _Accion LIKE '%insertar%' THEN
    
	SET _InvHId = (SELECT InvHId FROM inventariohijo ORDER BY InvHId DESC LIMIT 1);
    
    IF (SELECT COUNT(InvNId) FROM inventarionieto WHERE InvHId = _InvHId) !=0 THEN
			SET _Estado = "errProducto"; 
		END IF;
        
		IF _Estado = "OK" THEN
         
        INSERT INTO inventarionieto
        VALUES
        (
			_InvNId,
			_InvNDescripcion,
            _InvNCantidad,
            _InvHId,
            _UndId
        );
    END IF; 
  END IF;  
  
    IF _Accion LIKE '%editar%' THEN 
         SET _InvHId = (SELECT InvHId FROM inventarionieto WHERE InvNId = _InvNId);
         
        IF _Estado = "OK" THEN
		
			UPDATE inventarionieto SET 
			InvNDescripcion = _InvNDescripcion, 
			InvNCantidad= _InvNCantidad,
			InvHId = _InvHId,
			UndId = _UndId
			WHERE InvNId =  _InvNId;
        END IF;
	END IF;
END