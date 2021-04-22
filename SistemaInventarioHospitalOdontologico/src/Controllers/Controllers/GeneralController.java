/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
*
* @author Héctor López
*/
public abstract class GeneralController 
{
    // **************************************************
    // Métodos Protegidos
    // **************************************************
    
    /**
    * 
    * @param tabla JTable
    * @param columnas Número de columnas que contiene la tabla
    * Método que se encarga de ajustar el ancho y centrar las columnas de la 
    * tabla de acorde a su contenido.
    */
    protected static void FormatoTabla(JTable tabla, Integer columnas)  
    {
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);  

        for (int i = 0; i<columnas; i++)
        {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        
        final TableColumnModel columnModel = tabla.getColumnModel(); 
        for (int columna = 0; columna < tabla.getColumnCount(); columna++) 
        { 
            int ancho = 100;
            
            for (int fila = 0; fila < tabla.getRowCount(); fila++) 
            { 
                TableCellRenderer renderer = tabla.getCellRenderer(fila, columna); 
                Component comp = tabla.prepareRenderer(renderer, fila, columna); 
                ancho = Math.max(comp.getPreferredSize().width+1 , ancho);              
            }
            
            if(ancho > 300)
            {
                ancho=300; 
            }
            
            columnModel.getColumn(columna).setPreferredWidth(ancho); 
        }
    } 
}
