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

public class MenuProveedoresController 
{
    //Hashmap de Hashmaps que contiene los privilegios del usuario.
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
   
    public void AccesoModulos(JButton btnMantenimientoProveedores, 
            JButton btnMantenimientoRubros)
    {
        this.AccessoModuloMantenimientoProveedores(btnMantenimientoProveedores);
        this.AccessoModuloMantenimientoRubros(btnMantenimientoRubros);
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************

    private void AccessoModuloMantenimientoProveedores(JButton btnMantenimientoProveedores)
    {  
        if(privilegios.get("proveedores")
                .get(2) != null)
        {
            btnMantenimientoProveedores.setEnabled(true);
            btnMantenimientoProveedores.setText("<html><center>Mantenimiento<br/>Proveedores</center></html>");
        }
        else
        {
           this.setModuloBloqueado(btnMantenimientoProveedores);
        }
    }
   
    private void AccessoModuloMantenimientoRubros(JButton btnMantenimientoRubros)
    {  
        if(privilegios.get("proveedores")
                .get(18) != null)
        {
            btnMantenimientoRubros.setEnabled(true);
            btnMantenimientoRubros.setText("<html><center>Mantenimiento<br/>Rubros</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnMantenimientoRubros);
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
