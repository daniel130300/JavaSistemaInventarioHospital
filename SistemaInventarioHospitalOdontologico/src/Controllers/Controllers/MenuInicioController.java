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
public class MenuInicioController 
{
    private HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
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
    
    private void AccessoModuloVentas(JButton btnVentas)
    {  
        if(privilegios.get("ventas") != null)
        {
            btnVentas.setEnabled(true);
        }
        else
        {
            btnVentas.setEnabled(false);
        }
    }
    
    private void AccessoModuloSuministros(JButton btnSuministros)
    {  
        if(privilegios.get("suministros") != null)
        {
            btnSuministros.setEnabled(true);
        }
        else
        {
            btnSuministros.setEnabled(false);
        }
    }
    
    private void AccessoModuloProveedores(JButton btnProveedores)
    {  
        if(privilegios.get("proveedores") != null)
        {
            btnProveedores.setEnabled(true);
        }
        else
        {
            btnProveedores.setEnabled(false);
        }
    }
    
    private void AccessoModuloCompras(JButton btnCompras)
    {  
        if(privilegios.get("compras") != null)
        {
            btnCompras.setEnabled(true);
        }
        else
        {
            btnCompras.setEnabled(false);
        }
    }
    
    private void AccessoModuloBodega(JButton btnBodega)
    {  
        if(privilegios.get("bodega") != null)
        {
            btnBodega.setEnabled(true);
        }
        else
        {
            btnBodega.setEnabled(false);
        }
    }
    
    private void AccessoModuloUsuarios(JButton btnUsuarios)
    {  
        if(privilegios.get("usuarios") != null)
        {
            btnUsuarios.setEnabled(true);
        }
        else
        {
            btnUsuarios.setEnabled(false);
        }
    }
    
    private void AccessoModuloAlertas(JButton btnAlerta)
    {  
        if(privilegios.get("usuarios") != null)
        {
            btnAlerta.setEnabled(true);
        }
        else
        {
            btnAlerta.setEnabled(false);
        }
    }
}
