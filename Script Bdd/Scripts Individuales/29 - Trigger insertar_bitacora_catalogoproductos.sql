CREATE DEFINER=`root`@`localhost` TRIGGER `insertar_bitacora_catalogoproductos` AFTER INSERT ON `catalogoproductos` FOR EACH ROW CALL BitacoraCatalogoProductos
(
	"Insertar",
	New.PrdId,
	New.PrdNombre,
	New.PrdDescripcion,
	New.PrdStockMaximo,
	New.PrdStockMinimo,
	New.PrdEstado,
	New.CprId,
	0,
	"",
	"",
	0,
	0,
	"",
	0
)