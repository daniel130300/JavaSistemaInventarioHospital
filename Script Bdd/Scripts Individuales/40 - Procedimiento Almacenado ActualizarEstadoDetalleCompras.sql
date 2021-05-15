CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEstadoDetalleCompras`(
IN _InvPId INT
)
BEGIN  
UPDATE detallecompras SET 
			DtcEstado = 0
			WHERE InvPadreId = _InvPId;
END