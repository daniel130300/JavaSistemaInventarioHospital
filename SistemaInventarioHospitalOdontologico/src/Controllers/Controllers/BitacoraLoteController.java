/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.BitacoraLoteConexion;
import Models.Models.BitacoraLoteModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class BitacoraLoteController 
{
    
    public static void LlenarTableBitacoraLote(JTable tableLote) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableLote.getModel(); 
        modelo.setRowCount(0);
        ArrayList<BitacoraLoteModel> registros = new ArrayList<>();
        registros = BitacoraLoteConexion.ListadoBitacoraLote();
        
        for (int i = 0; i <registros.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    registros.get(i).getBcpId(),
                    registros.get(i).getUsrUsuario(),
                    registros.get(i).getLprId(),
                    registros.get(i).getPrdId(),
                    registros.get(i).getPrdNombre(),
                    registros.get(i).getBcpAccion(),
                    registros.get(i).getBcpDescripcionCambios(),
                    registros.get(i).getBcpFecha()
                }
            );
        }
        FormatoTabla(tableLote, modelo.getColumnCount());
    }
    
}
