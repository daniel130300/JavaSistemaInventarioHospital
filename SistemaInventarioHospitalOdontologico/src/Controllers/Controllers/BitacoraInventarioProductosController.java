/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.BitacoraInventarioProductosConexion;
import Models.Models.BitacoraInventarioProductosModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
*
* @author Héctor López
*/

// **************************************************
// Métodos Públicos
// **************************************************

public class BitacoraInventarioProductosController 
{
    /**
    * 
    * @param tableBitacoraInventarioProductos JTable 
    * Método que se encarga de llenar el JTable tableBitacoraLoteProductos
    * con los datos que se obtienen del método ListadoBitacoraLote() 
    * de la clase BitacoraLoteConexion.
    */
    public static void LlenarTableBitacoraInventario(JTable tableBitacoraInventarioProductos) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableBitacoraInventarioProductos.getModel(); 
        modelo.setRowCount(0);
        ArrayList<BitacoraInventarioProductosModel> registros = new ArrayList<>();
        registros = BitacoraInventarioProductosConexion.ListadoBitacoraInventario();
        
        for (int i = 0; i <registros.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    registros.get(i).getBcpId(),
                    registros.get(i).getUsrUsuario(),
                    registros.get(i).getInvPrdId(),
                    registros.get(i).getInvPrdCodInterno(),
                    registros.get(i).getBcpAccion(),
                    registros.get(i).getBcpDescripcionCambios(),
                    registros.get(i).getBcpFecha()
                }
            );
        }
        
        FormatoTabla(tableBitacoraInventarioProductos, modelo.getColumnCount());
        tableBitacoraInventarioProductos.setRowHeight(170);
    }
    
    /**
    * @param tableBitacoraLoteProductos JTable 
    * @param fieldBusqueda JTextField
    * Método que se encarga de filtrar la tabla tableBitacoraLoteProductos
    * a partir de la busqueda del usuario.
    */
    public static void FiltroTableBitacoraInventario(JTable tableBitacoraInventarioProductos, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableBitacoraInventarioProductos.getModel());
        tableBitacoraInventarioProductos.setRowSorter(rowSorter);
        fieldBusqueda.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }
        );  
    }  
    
}
