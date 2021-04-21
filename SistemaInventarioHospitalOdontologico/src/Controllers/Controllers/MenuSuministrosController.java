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
* @author Héctor López
*/

public class MenuSuministrosController 
{
    //Hashmap de Hashmaps que contiene los privilegios del usuario.
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    /**
    * @param btnMantenimientoInventarioSuministros JButton
    * @param btnInventarioSuministros JButton
    * @param btnGenerarSuministro JButton
    * @param btnMantenimientoProductosCompuestos JButton 
    * Método que se encarga de establecer el acceso o no al usuario a los
    * módulos que recibe como parámetros a partir de los privilegios 
    * que el usuario logueado dispone.
    */
    public void AccesoModulos(JButton btnMantenimientoInventarioSuministros, 
            JButton btnInventarioSuministros, JButton btnGenerarSuministro,
            JButton btnMantenimientoProductosCompuestos)
    {
        this.AccessoModuloMantenimientoInventarioSuministros(btnMantenimientoInventarioSuministros);
        this.AccessoModuloInventarioSuministros(btnInventarioSuministros);
        this.AccessoModuloGenerarSuministro(btnGenerarSuministro);
        this.AccessoModuloMantenimientoProductosCompuestos(btnMantenimientoProductosCompuestos);
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /**
    * @param btnMantenimientoInventarioSuministros JButton
    * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Inventario Suministros
    */
    private void AccessoModuloMantenimientoInventarioSuministros(JButton btnMantenimientoInventarioSuministros)
    {  
        if(privilegios.get("suministros")
                .get(6) != null)
        {
            btnMantenimientoInventarioSuministros.setEnabled(true);
            btnMantenimientoInventarioSuministros.setText("<html><center>Mantenimiento<br/>Inventario<br/>Suministros</center></html>");
        }
        else
        {
           this.setModuloBloqueado(btnMantenimientoInventarioSuministros);
        }
    }
    
    /**
    * @param btnInventarioSuministros JButton
    * Método que se encarga de proporcionar o no acceso al módulo Inventario Suministros
    */
    private void AccessoModuloInventarioSuministros(JButton btnInventarioSuministros)
    {  
        if(privilegios.get("suministros")
                .get(10) != null)
        {
            btnInventarioSuministros.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnInventarioSuministros);
        }
    }
    
    /**
    * @param btnGenerarSuministro JButton
    * Método que se encarga de proporcionar o no acceso al módulo Generar Suministros
    */
    private void AccessoModuloGenerarSuministro(JButton btnGenerarSuministro)
    {  
       if(privilegios.get("suministros")
                .get(8) != null)
        {
            btnGenerarSuministro.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnGenerarSuministro);
        }
    }
    
    /**
    * @param btnMantenimientoProductosCompuestos JButton
    * Método que se encarga de proporcionar o no acceso al módulo Mantenimiento Productos Compuestos
    */
    private void AccessoModuloMantenimientoProductosCompuestos(JButton btnMantenimientoProductosCompuestos)
    {  
       if(privilegios.get("suministros")
                .get(7) != null)
        {
            btnMantenimientoProductosCompuestos.setEnabled(true);
            btnMantenimientoProductosCompuestos.setText("<html><center>Mantenimiento<br/>Productos<br/>Compuestos</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoProductosCompuestos);
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
