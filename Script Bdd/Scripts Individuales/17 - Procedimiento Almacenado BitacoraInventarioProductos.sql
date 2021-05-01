CREATE DEFINER=`root`@`localhost` PROCEDURE `BitacoraInventarioProductos`(
	IN Accion VARCHAR(15),
	IN NewInvPrdId INT,
	IN NewInvPrdCodInterno VARCHAR(50),
	IN NewInvPrdFchCaducidad DATE,
	IN NewInvPrdEstado VARCHAR(15),
	IN NewInvPrdPadre INT,
    IN NewInvPrdFactor INT,
    IN NewInvPrdExtraible VARCHAR(3),
    IN NewUndId INT,
    IN OldInvPrdId INT,
	IN OldInvPrdCodInterno VARCHAR(50),
	IN OldInvPrdFchCaducidad DATE,
	IN OldInvPrdEstado VARCHAR(15),
	IN OldInvPrdPadre INT,
    IN OldInvPrdFactor INT,
    IN OldInvPrdExtraible VARCHAR(3),
    IN OldUndId INT
)
BEGIN
    DECLARE LoggedUser VARCHAR(60);
	DECLARE cambios VARCHAR(600);
	DECLARE OldUndDescripcion VARCHAR(40);
	DECLARE NewUndDescripcion VARCHAR(40);
	DECLARE cambiosPadre VARCHAR(20);
    DECLARE cambiosFecha VARCHAR(20);
    
	SET cambios = "";
    
    IF Accion LIKE "%Insertar%" THEN
    
		SET NewUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = NewUndId);
		SET LoggedUser = (SELECT UsrUsuario FROM loggedusuario);
        
		SET cambiosPadre = IFNULL(CAST(NewInvPrdPadre AS CHAR(10)), "nulo");
        SET cambiosFecha = IFNULL(CAST(NewInvPrdFchCaducidad AS CHAR(20)), "nulo");
		
		SET cambios = CONCAT("<html><center>Nuevo producto en inventario:<br>Id: ",NewInvPrdId,";<br>Código interno: ",NewInvPrdCodInterno,";<br>Fecha de caducidad: ",cambiosFecha,";<br>Estado: ",NewInvPrdEstado,";<br>Padre: ",cambiosPadre,";<br>Factor: ",NewInvPrdFactor,";<br>Es extraible: ",NewInvPrdExtraible ,";<br>Unidad: ",NewUndDescripcion,";</center></html>");
		
		INSERT INTO bitacorainventarioproductos VALUES
			(
				0,
				LoggedUser,
				"Insertar",
				cambios,
				CURRENT_TIMESTAMP(),
				NewInvPrdId
			);
            
	END IF;
    
    IF Accion LIKE '%Actualizar%' THEN
		
		IF OldInvPrdId != NewInvPrdId THEN
			SET cambios = CONCAT("El id del producto en el inventario cambio de: ", OldInvPrdId, " a: ", NewInvPrdId, "; "); 
        END IF;
		
        IF STRCMP(OldInvPrdCodInterno, NewInvPrdCodInterno) THEN
			SET cambios =  CONCAT(cambios, "<br>El código interno cambio de: ", OldInvPrdCodInterno, " a: ", NewInvPrdCodInterno, "; "); 
        END IF;
        
		IF OldInvPrdFchCaducidad!=NewInvPrdFchCaducidad THEN 
			SET cambios = CONCAT("La fecha de caducidad cambio de: ", OldInvPrdFchCaducidad, " a: ", NewInvPrdFchCaducidad, "; "); 
		END IF;
        
		IF STRCMP(OldInvPrdEstado, NewInvPrdEstado) THEN 
			SET cambios =  CONCAT(cambios, "<br>El estado cambio de: ", OldInvPrdEstado, " a: ", NewInvPrdEstado, "; "); 
		END IF;
        
        IF OldInvPrdPadre  != NewInvPrdPadre  THEN 
			SET cambios = CONCAT(cambios, "<br>El padre cambio de: ", OldInvPrdPadre, " a: ", NewInvPrdPadre, "; "); 
		END IF;
        
		IF OldInvPrdFactor != NewInvPrdFactor THEN 
			SET cambios = CONCAT(cambios, "<br>El factor cambio de: ", OldInvPrdFactor, " a: ", NewInvPrdFactor, "; "); 
		END IF;
        
        IF OldInvPrdExtraible  != NewInvPrdExtraible THEN 
			SET cambios = CONCAT(cambios, "<br>Es extraible cambio de: ", OldInvPrdExtraible, " a: ", NewInvPrdExtraible, "; "); 
		END IF;
        
		IF OldUndId != NewUndId THEN 
			SET NewUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = NewUndId);
			SET OldUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = OldUndId);
			SET cambios =  CONCAT(cambios, "<br>La unidad cambio de: ", OldUndDescripcion, " a: ", NewUndDescripcion, "; ");
		END IF;

		IF cambios != "" THEN
			SET cambios = CONCAT("<html><center>", cambios, "</center></html>");
			SET LoggedUser = (SELECT UsrUsuario FROM loggedusuario);
			
			INSERT INTO bitacorainventarioproductos VALUES
			(
				0,
				LoggedUser,
				"Actualizar",
				cambios,
				CURRENT_TIMESTAMP(),
				NewInvPrdId
			);
            
		END IF;
        
	END IF;
END