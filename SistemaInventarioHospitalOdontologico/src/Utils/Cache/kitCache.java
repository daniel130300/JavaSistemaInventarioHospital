/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.KitModel;

/**
 *
 * @author fgodo
 */
public class kitCache {

    private static boolean DatosCompartidos = false;
    private static KitModel kit;
    public static Integer Idkit;
    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        kitCache.DatosCompartidos = DatosCompartidos;
    }
    
    public KitModel getKit() {
        return kit;
    }

    public void setKit(KitModel kit) {
        kitCache.kit = kit;
    }
    
    public Integer getKitId() {
        return Idkit;
    }
    public void setKitId(Integer Idkit) {
        this.Idkit = Idkit;
    }    
}
