/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.BitacoraCatalogoConexion;
import Models.Models.BitacoraCatalogoModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class BitacoraCatalogoController 
{
    
    public static void LlenarTableBitacoraCatalogo(JTable tableCatalogo) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableCatalogo.getModel(); 
        modelo.setRowCount(0);
        ArrayList<BitacoraCatalogoModel> registros = new ArrayList<>();
        registros = BitacoraCatalogoConexion.ListadoBitacoraCatalogo();
        
        for (int i = 0; i <registros.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    registros.get(i).getBcpId(),
                    registros.get(i).getUsrUsuario(),
                    registros.get(i).getPrdId(),
                    registros.get(i).getBcpAccion(),
                    registros.get(i).getBcpDescripcionCambios(),
                    registros.get(i).getBcpFecha()
                }
            );
        }
        FormatoTabla(tableCatalogo, modelo.getColumnCount());
    }
    
}
