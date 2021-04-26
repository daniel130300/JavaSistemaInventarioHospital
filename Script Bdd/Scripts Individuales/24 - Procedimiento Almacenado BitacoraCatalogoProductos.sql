CREATE DEFINER=`root`@`localhost` PROCEDURE `BitacoraCatalogoProductos`(
IN Accion VARCHAR(15),
IN NewPrdId INT,
IN NewPrdNombre VARCHAR(40),
IN NewPrdDescripcion VARCHAR (100),
IN NewPrdStockMaximo INT,
IN NewPrdStockMinimo INT,
IN NewPrdEstado Varchar(15),
IN NewCprId INT,
IN NewUndId INT,
IN OldPrdId INT,
IN OldPrdNombre VARCHAR(40),
IN OldPrdDescripcion VARCHAR (100),
IN OldPrdStockMaximo INT,
IN OldPrdStockMinimo INT,
IN OldPrdEstado Varchar(15),
IN OldCprId INT,
IN OldUndId INT
)
BEGIN

Declare LoggedUser VARCHAR(60);
DECLARE cambios VARCHAR(600);
DECLARE OldCprDescripcion VARCHAR(40);
DECLARE OldUndDescripcion VARCHAR(20);
DECLARE NewCprDescripcion VARCHAR(40);
DECLARE NewUndDescripcion VARCHAR(20);
SET cambios = "";

IF Accion LIKE "Insertar" THEN

	SET NewCprDescripcion = (SELECT CprDescripcion FROM categoriasproductos WHERE CprId = NewCprId);
    SET NewUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = NewUndId);
    SET LoggedUser = (SELECT * FROM loggedusuario);
    
	SET cambios = CONCAT("<html><center>Nuevo producto:<br>Id: ", NewPrdId, ";<br>Nombre: ", NewPrdNombre, ";<br>Descripción: ", NewPrdDescripcion, ";<br>Stock Máximo: ", NewPrdStockMaximo, ";<br>Stock Mínimo: ", NewPrdStockMinimo, ";<br>Estado: ", NewPrdEstado, ";<br>Categoría: ", NewCprDescripcion, ";<br>Unidad: ", NewUndDescripcion, ";</center></html>");
    
	INSERT INTO bitacoracatalogoproductos VALUES
		(
			0,
			LoggedUser,
			Accion,
			cambios,
			CURRENT_TIMESTAMP(),
			NewPrdId
		);
END IF;


IF Accion LIKE "Actualizar" THEN

	IF STRCMP(OldPrdNombre, NewPrdNombre)!=0 THEN 
		SET cambios = CONCAT("Nombre del producto cambio de: ", OldPrdNombre, " a: ", NewPrdNombre, "; "); 
	END IF;

	IF STRCMP(OldPrdDescripcion, NewPrdDescripcion)!=0 THEN 
		SET cambios = CONCAT(cambios, "<br>Descripción del producto cambio de: ", OldPrdDescripcion, " a: ", NewPrdDescripcion, "; "); 
	END IF;

	IF OldPrdStockMaximo != NewPrdStockMaximo THEN 
		SET cambios = CONCAT(cambios, "<br>Stock máximo del producto cambio de: ", OldPrdStockMaximo, " a: ", NewPrdStockMaximo, "; "); 
	END IF;

	IF OldPrdStockMinimo != NewPrdStockMinimo THEN 
		SET cambios = CONCAT(cambios, "<br>Stock mínimo del producto cambio de: ", OldPrdStockMinimo, " a: ", NewPrdStockMinimo, "; "); 
	END IF;

	IF STRCMP(OldPrdEstado, NewPrdEstado) THEN 
		SET cambios =  CONCAT(cambios, "<br>Estado del producto cambio de: ", OldPrdEstado, " a: ", NewPrdEstado, "; "); 
	END IF;

	IF NewCprId != OldCprId THEN 
		SET NewCprDescripcion = (SELECT CprDescripcion FROM categoriasproductos WHERE CprId = NewCprId);
		SET OldCprDescripcion = (SELECT CprDescripcion FROM categoriasproductos WHERE CprId = OldCprId);
		SET cambios =  CONCAT(cambios, "<br>Categoría del producto cambio de: ", OldCprDescripcion, " a: ", NewCprDescripcion, "; ");
	END IF;

	IF NewUndId != OldUndId THEN  
		SET NewUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = NewUndId);
		SET OldUndDescripcion = (SELECT UndDescripcion FROM unidades WHERE UndId = OldUndId);
		SET cambios =  CONCAT(cambios, "<br>Unidad del producto cambio de: ", OldUndDescripcion, " a: ", NewUndDescripcion); 
	END IF;

	IF(cambios IS NOT NULL OR cambios != "") THEN 
		
        SET cambios = CONCAT("<html><center>", cambios, "</center></html>");
		SET LoggedUser = (SELECT UsrUsuario FROM loggedusuario);
		
		INSERT INTO bitacoracatalogoproductos VALUES
		(
			0,
			LoggedUser,
			Accion,
			cambios,
			CURRENT_TIMESTAMP(),
			NewPrdId
		);
		
	END IF;
    
END IF;

END