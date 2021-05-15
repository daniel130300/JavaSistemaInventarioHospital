CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarCantidadInventarioPadre`(
IN _InvPId INT,
IN _InvPCantidad INT
)
BEGIN  
UPDATE inventariopadre SET 
			InvPCantidad = (InvPCantidad - _InvPCantidad)
			WHERE InvPId = _InvPId;
END