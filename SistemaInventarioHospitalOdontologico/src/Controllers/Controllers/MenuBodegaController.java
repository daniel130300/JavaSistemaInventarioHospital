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
* @author Héctor López
*/
public class MenuBodegaController 
{
    
    //Hashmap de Hashmaps que contiene los privilegios del usuario. 
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
       
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    /**
    * 
    * @param btnMantenimientoCatalogoBodega JButton
    * @param btnMantenimientoCategorias JButton
    * @param btnMantenimientoUnidades JButton
    * @param btnBitacoraCatalogoBodega JButton
    * @param btnMantenimientoInventarioBodega JButton
    * @param btnInventarioBodega JButton
    * @param btnBitacoraInventarioBodega JButton 
    * Método que se encarga de establecer el acceso o no al usuario a los
    * módulos que recibe como parámetros a partir de los privilegios 
    * que el usuario logueado dispone
    */
    public void AccesoModulos(
            JButton btnMantenimientoCatalogoBodega,
            JButton btnMantenimientoCategorias,
            JButton btnMantenimientoUnidades,
            JButton btnBitacoraCatalogoBodega,
            JButton btnMantenimientoInventarioBodega,
            JButton btnInventarioBodega, 
            JButton btnBitacoraInventarioBodega
            )
    {
        this.AccessoModuloMantenimientoCatalogoBodega(btnMantenimientoCatalogoBodega);
        this.AccessoModuloMantenimientoCategorias(btnMantenimientoCategorias);
        this.AccessoModuloMantenimientoUnidades(btnMantenimientoUnidades);
        this.AccessoModuloBitacoraCatalogoBodega(btnBitacoraCatalogoBodega);
        this.AccessoModuloMantenimientoInventarioBodega(btnMantenimientoInventarioBodega);
        this.AccessoModuloInventarioBodega(btnInventarioBodega);
        this.AccessoModuloBitacoraInventarioBodega(btnBitacoraInventarioBodega);
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /** 
    * @param btnMantenimientoCatalogoBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Catálogo Bodega
    */
    private void AccessoModuloMantenimientoCatalogoBodega(JButton btnMantenimientoCatalogoBodega)
    {  
        if(privilegios.get("bodega")
                .get(4) != null)
        {
            btnMantenimientoCatalogoBodega.setEnabled(true);
            btnMantenimientoCatalogoBodega.setText("<html><center>Mantenimiento<br/>Catálogo<br/>Productos</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoCatalogoBodega);
        }
    }  
    
    /**
    * @param btnMantenimientoCategorias JButton
    * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Categorías
    */
    private void AccessoModuloMantenimientoCategorias(JButton btnMantenimientoCategorias)
    {  
       if(privilegios.get("bodega")
                .get(15) != null)
        {
            btnMantenimientoCategorias.setEnabled(true);
                        btnMantenimientoCategorias.setText("<html><center>Mantenimiento<br/>Categorías</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoCategorias);
        }
    }
    
     /**
     * @param btnMantenimientoUnidades JButton
     * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Unidades
     */
    private void AccessoModuloMantenimientoUnidades(JButton btnMantenimientoUnidades)
    {  
       if(privilegios.get("bodega")
                .get(16) != null)
        {
            btnMantenimientoUnidades.setEnabled(true);
                        btnMantenimientoUnidades.setText("<html><center>Mantenimiento<br/>Unidades</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoUnidades);
        }
    }
    
    /**
    * 
    * @param btnBitacoraCatalogoBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Bitácora Catálogo Bodega
    */
    private void AccessoModuloBitacoraCatalogoBodega(JButton btnBitacoraCatalogoBodega)
    {  
        if(privilegios.get("bodega")
                .get(14) != null)
        {
            btnBitacoraCatalogoBodega.setEnabled(true);
            btnBitacoraCatalogoBodega.setText("<html><center>Bitácora<br/>Catálogo<br/>Productos</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnBitacoraCatalogoBodega);
        }
    }  
    
    /**
    * 
    * @param btnMantenimientoInventarioBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Inventario Bodega
    */
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
    
    /**
    * @param btnInventarioBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Inventario Bodega
    */
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
    
    /**
    * @param btnBitacoraInventarioBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Bitacora Inventario Bodega
    */
    private void AccessoModuloBitacoraInventarioBodega(JButton btnBitacoraInventarioBodega)
    {
        if(privilegios.get("bodega")
                .get(17) != null)
        {
            btnBitacoraInventarioBodega.setEnabled(true);
            btnBitacoraInventarioBodega.setText("<html><center>Bitácora<br/>Inventario<br/>Bodega</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnBitacoraInventarioBodega);
        }
    }
    
    /**
    * @param boton JButton
    * Método que se encarga de establecer un icono de candado al botón
    */
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
    
    /**
    * @param boton JButton
    * Método que se encarga de bloquear un módulo.
    */
    private void setModuloBloqueado(JButton boton)
    {
        boton.setEnabled(false);
        boton.setText(null);
        this.setIconoCandado(boton);
    }
}
