/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Utils.Cache.UsuarioLogueadoCache;
import java.awt.Image;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class MenuSuministrosController 
{
    HashMap<String, HashMap<Integer, String>> privilegios = UsuarioLogueadoCache.getHashUsrPrivilegios();
    
    public void AccesoModulos(JButton btnMantenimientoInventarioSuministros, 
            JButton btnInventarioSuministros, JButton btnGenerarSuministro,
            JButton btnMantenimientoProductosCompuestos)
    {
        this.AccessoModuloMantenimientoInventarioSuministros(btnMantenimientoInventarioSuministros);
        this.AccessoModuloInventarioSuministros(btnInventarioSuministros);
        this.AccessoModuloGenerarSuministro(btnGenerarSuministro);
        this.AccessoModuloMantenimientoProductosCompuestos(btnMantenimientoProductosCompuestos);
    }
    
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
            btnMantenimientoInventarioSuministros.setEnabled(false);
        }
    }
    
    private void AccessoModuloInventarioSuministros(JButton btnInventarioSuministros)
    {  
        if(privilegios.get("suministros")
                .get(10) != null)
        {
            btnInventarioSuministros.setEnabled(true);
        }
        else
        {
            btnInventarioSuministros.setEnabled(false);
        }
    }
    
    private void AccessoModuloGenerarSuministro(JButton btnGenerarSuministro)
    {  
       if(privilegios.get("suministros")
                .get(8) != null)
        {
            btnGenerarSuministro.setEnabled(true);
        }
        else
        {
            btnGenerarSuministro.setEnabled(false);
        }
    }
    
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
            btnMantenimientoProductosCompuestos.setEnabled(false);
        }
    }
    
    public void setIconoCandado(JButton boton)
    {
        try 
        {
            Image img = ImageIO.read(getClass().getResource("Views/Images/icons8_padlock8_32px.png"));
            boton.setIcon(new ImageIcon(img));
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
