CREATE DEFINER=`root`@`localhost` TRIGGER `actualizar_bitacora_loteproductos` AFTER UPDATE ON `loteproductos` FOR EACH ROW CALL BitacoraLoteProductos
(
	"Actualizar",
	New.LprId,
	New.LprFechaCaducidad,
	New.LprStock,
	New.LprEstado,
	New.PrdId,
	Old.LprId,
	Old.LprFechaCaducidad,
	Old.LprStock,
	Old.LprEstado,
	Old.PrdId
)