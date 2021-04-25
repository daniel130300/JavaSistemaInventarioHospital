/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Utils.Cache.UsuarioLogueadoCache;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class MenuBodegaController 
{
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    public void AccesoModulos(
            JButton btnMantenimientoCatalogoBodega,
            JButton btnBitacoraCatalogoBodega,
            JButton btnMantenimientoInventarioBodega,
            JButton btnInventarioBodega, 
            JButton btnMantenimientoCategorias,
            JButton btnMantenimientoUnidades
            )
    {
        this.AccessoModuloMantenimientoCatalogoBodega(btnMantenimientoCatalogoBodega);
        this.AccessoModuloInventarioBodega(btnInventarioBodega);
        this.AccessoModuloMantenimientoInventarioBodega(btnMantenimientoInventarioBodega);
        this.AccessoModuloMantenimientoCategorias(btnMantenimientoCategorias);
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
            this.setModuloBloqueado(btnMantenimientoCatalogoBodega);
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
            this.setModuloBloqueado(btnMantenimientoInventarioBodega);
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
            this.setModuloBloqueado(btnInventarioBodega);
        }
    }
    
    private void AccessoModuloMantenimientoCategorias(JButton btnMantenimientoCategorias)
    {  
       if(privilegios.get("bodega")
                .get(5) != null)
        {
            btnMantenimientoCategorias.setEnabled(true);
                        btnMantenimientoCategorias.setText("<html><center>Mantenimiento<br/>Categorías</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoCategorias);
        }
    }
    
    private void setIconoCandado(JButton boton)
    {
        try 
        {
            boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_padlock8_32px.png")));
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    private void setModuloBloqueado(JButton boton)
    {
        boton.setEnabled(false);
        boton.setText(null);
        this.setIconoCandado(boton);
    }
}
