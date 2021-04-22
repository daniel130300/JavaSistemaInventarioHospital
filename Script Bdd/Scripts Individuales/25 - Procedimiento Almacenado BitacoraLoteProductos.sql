CREATE DEFINER=`root`@`localhost` PROCEDURE `BitacoraLoteProductos`(
	IN Accion VARCHAR(15),
	IN NewLprId INT,
	IN NewLprFechaCaducidad DATE,
	IN NewLprStock VARCHAR (100),
	IN NewLprEstado VARCHAR(15),
	IN NewPrdId INT,
	IN OldLprId INT,
	IN OldLprFechaCaducidad DATE,
	IN OldLprStock VARCHAR (100),
	IN OldLprEstado VARCHAR(15),
	IN OldPrdId INT
)
BEGIN
	
    Declare LoggedUser VARCHAR(60);
	DECLARE cambios VARCHAR(600);
	SET cambios = "";
    
    IF Accion LIKE '%Actualizar%' THEN
	
		IF OldLprFechaCaducidad!=NewLprFechaCaducidad THEN 
			SET cambios = CONCAT("La fecha de caducidad cambio de: ", OldLprFechaCaducidad, " a: ", NewLprFechaCaducidad, "; "); 
		END IF;

		IF OldLprStock!= NewLprStock THEN 
			SET cambios = CONCAT(cambios, "<br>El stock cambio de: ", OldLprStock, " a: ", NewLprStock, "; "); 
		END IF;

		IF STRCMP(OldLprEstado, NewLprEstado) THEN 
			SET cambios =  CONCAT(cambios, "<br>El estado cambio de: ", OldLprEstado, " a: ", NewLprEstado, "; "); 
		END IF;

		IF(cambios IS NOT NULL OR cambios != "") THEN 
        
			SET cambios = CONCAT("<html><center>", cambios, "</center></html>");
			SET LoggedUser = (SELECT UsrUsuario FROM loggedusuario);
			
			INSERT INTO bitacoraloteproductos VALUES
			(
				0,
				LoggedUser,
				"Actualizar",
				cambios,
				CURRENT_TIMESTAMP(),
				NewLprId
			);
            
		END IF;
	END IF;
END