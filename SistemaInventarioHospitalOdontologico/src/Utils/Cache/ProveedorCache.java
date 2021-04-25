/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.ProveedorModel;

/**
 *
 * @author fgodo
 */
public class ProveedorCache {
    private static boolean DatosCompartidos = false;
    private static ProveedorModel id;

    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        ProveedorCache.DatosCompartidos = DatosCompartidos;
    }
    
    public ProveedorModel getid() {
        return id;
    }

    public void setid(ProveedorModel id) {

        ProveedorCache.id = id;
    }    
}
