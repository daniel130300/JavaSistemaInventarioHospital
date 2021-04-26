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

public class MenuInicioController 
{
    //Hashmap de Hashmaps que contiene los privilegios del usuario. 
    private HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    /**
    * 
    * @param btnVentas JButton
    * @param btnSuministros JButton
    * @param btnProveedores JButton
    * @param btnCompras JButton
    * @param btnBodega JButton
    * @param btnUsuarios JButton
    * @param btnAlertas JButton 
    * Método que se encarga de establecer el acceso o no al usuario a los
    * módulos que recibe como parámetros a partir de los privilegios 
    * que el usuario logueado dispone.
    */
    public void AccesoModulos(JButton btnVentas, JButton btnSuministros, 
            JButton btnProveedores, JButton btnCompras, JButton btnBodega,
            JButton btnUsuarios, JButton btnAlertas)
    {
        this.AccessoModuloVentas(btnVentas);
        this.AccessoModuloSuministros(btnSuministros);
        this.AccessoModuloProveedores(btnProveedores);
        this.AccessoModuloCompras(btnCompras);
        this.AccessoModuloBodega(btnBodega);
        this.AccessoModuloUsuarios(btnUsuarios);
        this.AccessoModuloAlertas(btnAlertas);
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /** 
    * @param btnVentas JButton
    * Método que se encarga de proporcionar o no acceso al módulo Ventas
    */
    private void AccessoModuloVentas(JButton btnVentas)
    {  
        if(privilegios.get("ventas") != null)
        {
            btnVentas.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnVentas);
        }
    }
    
    /** 
    * @param btnVentas JButton
    * Método que se encarga de proporcionar o no acceso al módulo Ventas
    */
    private void AccessoModuloSuministros(JButton btnSuministros)
    {  
        if(privilegios.get("suministros") != null)
        {
            btnSuministros.setEnabled(true);
        }
        else
        {
           this.setModuloBloqueado(btnSuministros);
        }
    }
    
    /**
    * @param btnProveedores JButton
    * Método que se encarga de proporcionar o no acceso al módulo Proveedores
    */
    private void AccessoModuloProveedores(JButton btnProveedores)
    {  
        if(privilegios.get("proveedores") != null)
        {
            btnProveedores.setEnabled(true);
        }
        else
        {
           this.setModuloBloqueado(btnProveedores);
        }
    }
    
    /**
    * 
    * @param btnCompras JButton
    * Método que se encarga de proporcionar o no acceso al módulo Compras
    */
    private void AccessoModuloCompras(JButton btnCompras)
    {  
        if(privilegios.get("compras") != null)
        {
            btnCompras.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnCompras);
        }
    }
    
    /**
    * @param btnBodega JButton
    * Método que se encarga de proporcionar o no acceso al módulo Bodega
    */
    private void AccessoModuloBodega(JButton btnBodega)
    {  
        if(privilegios.get("bodega") != null)
        {
            btnBodega.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnBodega);
        }
    }
    
    /**
    * @param btnUsuarios JButton
    * Método que se encarga de proporcionar o no acceso al módulo Usuarios
    */
    private void AccessoModuloUsuarios(JButton btnUsuarios)
    {  
        if(privilegios.get("usuarios") != null)
        {
            btnUsuarios.setEnabled(true);
        }
        else
        {
           this.setModuloBloqueado(btnUsuarios);
        }
    }
    
    /**
    * 
    * @param btnAlerta JButton
    * Método que se encarga de proporcionar o no acceso al módulo Alertas
    */
    private void AccessoModuloAlertas(JButton btnAlerta)
    {  
        if(privilegios.get("usuarios") != null)
        {
            btnAlerta.setEnabled(true);
        }
        else
        {
            this.setModuloBloqueado(btnAlerta);
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
