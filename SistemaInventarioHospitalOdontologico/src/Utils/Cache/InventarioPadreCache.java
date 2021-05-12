/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.InventarioPadreModel;

/**
 *
 * @author Katering Osorto
 * 
 * Clase que permite pasar los datos seleccionados en la pantalla 
 * TablaGrandeMantenimientoInventarioBodegaView a MantenimientoInventarioBodegaView e 
 * InventarioBodegaView
 */
public class InventarioPadreCache {
    private static boolean DatosCompartidos = false;
    private static InventarioPadreModel Id;

    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        InventarioPadreCache.DatosCompartidos = DatosCompartidos;
    }

    public InventarioPadreModel getId() {
        return Id;
    }

    public void setId(InventarioPadreModel Id) {

        InventarioPadreCache.Id = Id;
    }
}
