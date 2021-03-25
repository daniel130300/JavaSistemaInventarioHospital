/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Utils.Cache.UsuarioLogueadoCache;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author danie
 */
public class MenuBodegaController 
{
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    public void AccesoModulos(JButton btnMantenimientoCatalogoBodega, 
            JButton btnInventarioBodega, 
            JButton btnMantenimientoInventarioBodega)
    {
        this.AccessoModuloMantenimientoCatalogoBodega(btnMantenimientoCatalogoBodega);
        this.AccessoModuloInventarioBodega(btnInventarioBodega);
        this.AccessoModuloMantenimientoInventarioBodega(btnMantenimientoInventarioBodega);
    }
    
    private void AccessoModuloMantenimientoCatalogoBodega(JButton btnMantenimientoCatalogoBodega)
    {  
        if(privilegios.get("bodega")
                .get(4) != null)
        {
            btnMantenimientoCatalogoBodega.setEnabled(true);
            btnMantenimientoCatalogoBodega.setText("<html><center>Mantenimiento<br/>Catálogo<br/>Bodega</center></html>");
        }
        else
        {
            btnMantenimientoCatalogoBodega.setEnabled(false);
        }
    }
    
    private void AccessoModuloInventarioBodega(JButton btnInventarioBodega)
    {  
        if(privilegios.get("bodega")
                .get(11) != null)
        {
            btnInventarioBodega.setEnabled(true);
        }
        else
        {
            btnInventarioBodega.setEnabled(false);
        }
    }
    
    private void AccessoModuloMantenimientoInventarioBodega(JButton btnMantenimientoInventarioBodega)
    {  
       if(privilegios.get("bodega")
                .get(5) != null)
        {
            btnMantenimientoInventarioBodega.setEnabled(true);
                        btnMantenimientoInventarioBodega.setText("<html><center>Mantenimiento<br/>Inventario<br/>Bodega</center></html>");
        }
        else
        {
            btnMantenimientoInventarioBodega.setEnabled(false);
        }
    }
}
