CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoDetalleCatalogoProductos`(	
	IN _Accion VARCHAR(10), 
    IN _DcpId INT,
	IN _ProId INT,
	IN _PrdId INT,
    IN _DcpPrecioCompra DOUBLE,
    OUT _Estado VARCHAR(10)
)
BEGIN
	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
        SET _PrdId = (SELECT PrdId FROM catalogoproductos ORDER BY PrdId DESC LIMIT 1);
		INSERT INTO detallecatalogoproductos
        VALUES
        (
			_DcpId,
			_ProId,
            _PrdId,
            _DcpPrecioCompra
        );
	END IF;
    
    IF _Accion LIKE '%editar%' THEN 
        INSERT INTO detallecatalogoproductos
        VALUES
        (
			_DcpId,
            _ProId,
            _PrdId,
            _DcpPrecioCompra
        );
	END IF;
    
    IF _Accion LIKE '%eliminar%' THEN
		  DELETE FROM detallecatalogoproductos WHERE DcpId = _DcpId;
    END IF;
    
END