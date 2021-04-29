CREATE DEFINER=`root`@`localhost` PROCEDURE `EditarInformacionPersonal`(
	IN _UsrId INT,
	IN _UsrNombre VARCHAR(40),
    IN _UsrApellido VARCHAR(40),
    IN _UsrCorreo VARCHAR(60),
    OUT _Estado VARCHAR(15)
)
BEGIN
	SET _Estado = "OK";
    
	IF (SELECT COUNT(UsrId) FROM usuarios WHERE UsrId != _UsrId AND UsrCorreo = _UsrCorreo) != 0 THEN
		SET _Estado = "errCorreo";
	END IF;
    
    IF _Estado = "OK" THEN
		UPDATE usuarios 
        SET UsrNombre = _UsrNombre, UsrApellido = _UsrApellido, UsrCorreo = _UsrCorreo 
		WHERE UsrId = _UsrId;
	END IF;
END