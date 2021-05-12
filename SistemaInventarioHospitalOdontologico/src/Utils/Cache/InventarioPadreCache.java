/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.InventarioHijoModel;
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
    public static Integer InvPId;
    public static Integer InvHId;
    private static InventarioPadreModel Id;
    private static InventarioHijoModel IdH;
    
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

    public Integer getInvPId() {
        return InvPId;
    }

    public void setInvPId(Integer InvPId) {
        InventarioPadreCache.InvPId = InvPId;
    }

    public Integer getInvHId() {
        return InvHId;
    }

    public void setInvHId(Integer InvHId) {
        InventarioPadreCache.InvHId = InvHId;
    }

    public InventarioHijoModel getIdH() {
        return IdH;
    }

    public void setIdH(InventarioHijoModel IdH) {
        InventarioPadreCache.IdH = IdH;
    } 
}
