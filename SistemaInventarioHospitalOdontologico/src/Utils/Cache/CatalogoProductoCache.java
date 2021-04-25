/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.CatalogoProductoModel;

/**
 *
 * @author fgodo
 */
public class CatalogoProductoCache {
    private static boolean DatosCompartidos = false;
    private static CatalogoProductoModel producto;
    public static Integer Idproducto;
    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        CatalogoProductoCache.DatosCompartidos = DatosCompartidos;
    }
    
    public CatalogoProductoModel getProducto() {
        return producto;
    }

    public void setProducto(CatalogoProductoModel prd) {
        CatalogoProductoCache.producto = prd;
    }
    
    public Integer getPrdId() {
        return Idproducto;
    }
    public void setPrdId(Integer PrdId) {
        this.Idproducto = PrdId;
    }
    
    

    
}
