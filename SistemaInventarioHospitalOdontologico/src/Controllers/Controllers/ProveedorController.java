/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.ProveedorConexion;
import Models.Models.ProveedorModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class ProveedorController 
{
    
    public static void LlenarTableProveedores(JTable tableProveedores) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableProveedores.getModel(); 
        modelo.setRowCount(0);
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        proveedores = ProveedorConexion.ListadoProveedores();
        
        for (int i = 0; i <proveedores.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    proveedores.get(i).getProId(), 
                    proveedores.get(i).getProRTN(),
                    proveedores.get(i).getProNombre(),
                    proveedores.get(i).getProCorreo(),
                    proveedores.get(i).getProTelefono(),
                    proveedores.get(i).getProContacto(),
                    proveedores.get(i).getProDireccion()
                }
            );
        }
        FormatoTabla(tableProveedores, modelo.getColumnCount());
    }
    
}
