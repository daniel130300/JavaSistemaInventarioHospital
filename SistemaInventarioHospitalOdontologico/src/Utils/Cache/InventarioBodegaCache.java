/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.InventarioBodegaModel;

/**
 *
 * @author Katering Osorto
 */
public class InventarioBodegaCache {
    private static boolean DatosCompartidos = false;
    private static InventarioBodegaModel Id;

    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        InventarioBodegaCache.DatosCompartidos = DatosCompartidos;
    }

    public InventarioBodegaModel getId() {
        return Id;
    }

    public void setId(InventarioBodegaModel Id) {

        InventarioBodegaCache.Id = Id;
    }
}
