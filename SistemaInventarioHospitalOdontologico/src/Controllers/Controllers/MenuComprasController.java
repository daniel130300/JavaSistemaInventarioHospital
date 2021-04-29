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

public class MenuComprasController 
{
    //Hashmap de Hashmaps que contiene los privilegios del usuario.
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    public void AccesoModulos(JButton btnRegistrarCompra, 
            JButton btnDevolucionCompra, JButton btnHistorialCompras)
    {
        this.AccessoModuloRegistrarCompra(btnRegistrarCompra);
        this.AccessoModuloDevolucionCompra(btnDevolucionCompra);
        this.AccessoModuloHistorialCompras(btnHistorialCompras);
        
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************

    private void AccessoModuloRegistrarCompra(JButton btnRegistrarCompra)
    {  
        if(privilegios.get("compras")
                .get(3) != null)
        {
            btnRegistrarCompra.setEnabled(true);
            btnRegistrarCompra.setText("<html><center>Registrar<br/>Compra</center></html>");
        }
        else
        {
           this.setModuloBloqueado(btnRegistrarCompra);
        }
    }
   
    private void AccessoModuloDevolucionCompra(JButton btnDevolucionCompra)
    {  
        if(privilegios.get("compras")
                .get(19) != null)
        {
            btnDevolucionCompra.setEnabled(true);
            btnDevolucionCompra.setText("<html><center>Devolución<br/>de la Compra</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnDevolucionCompra);
        }
    }
    
    private void AccessoModuloHistorialCompras(JButton btnHistorialCompras)
    {  
        if(privilegios.get("compras")
                .get(20) != null)
        {
            btnHistorialCompras.setEnabled(true);
            btnHistorialCompras.setText("<html><center>Historial<br/>de Compras</center></html>");
        }
        else
        {
            this.setModuloBloqueado(btnHistorialCompras);
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
