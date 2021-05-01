CREATE DEFINER=`root`@`localhost` TRIGGER `actualizar_bitacora_catalogoproductos` AFTER UPDATE ON `catalogoproductos` FOR EACH ROW CALL BitacoraCatalogoProductos
(
	"Actualizar",
	New.PrdId,
	New.PrdNombre,
	New.PrdDescripcion,
	New.PrdStockMaximo,
	New.PrdStockMinimo,
	New.PrdEstado,
	New.CprId,
	Old.PrdId,
	Old.PrdNombre,
	Old.PrdDescripcion,
	Old.PrdStockMaximo,
	Old.PrdStockMinimo,
	Old.PrdEstado,
	Old.CprId
)