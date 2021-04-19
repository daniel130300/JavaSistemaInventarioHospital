/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.CategoriaConexion;
import Models.Models.CategoriasModel;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
 * @author danie
 */
public class CategoriasController 
{
    public static Boolean MantenimientoCategorias(String accion, Integer id, 
            String descripcion, String estado, JLabel errDescripcion)
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errDescripcion.setText(null);

        String trimmedDescripcion = descripcion.trim();

        generalValidacionError = CategoriasController.validacionesGenerales(trimmedDescripcion,errDescripcion);
        
        if(generalValidacionError == false)
        { 
            CategoriasModel categoria = new CategoriasModel();
            categoria.setCprId(id);
            categoria.setCprDescripcion(descripcion);
            String msj = "";
            String resultado = "";
            
            switch(accion)
            {
                case "insertar":
                    categoria.setCprEstado("Activo");
                    resultado = CategoriaConexion.MantenimientoCategorias(accion, categoria);
                    msj =  "Categoría insertada con éxito";
                    mntError = CategoriasController.mensajesRetroalimentacion(msj, resultado);
                    
                break;
                
                case "editar":
                     categoria.setCprEstado(estado);
                    resultado = CategoriaConexion.MantenimientoCategorias(accion, categoria);
                    msj =  "Caetgoría actualizada con éxito";
                    mntError = CategoriasController.mensajesRetroalimentacion(msj, resultado);                   
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false); 
    }    
    
    private static boolean mensajesRetroalimentacion(String msj, String resultado)
    {
        boolean error = false;
        
        switch (resultado) 
        {
            case "OK":
                JOptionPane.showMessageDialog(null, msj);                   
            break;

            case "errDescripcion":
                JOptionPane.showMessageDialog(null, "La descripción ya se encuentra registrada.");
                error = true;
            break;
        }
        
        return error;
    }     
    
    private static boolean validacionesGenerales(String trimmedDescripcion,
        JLabel errDescripcion)
    {
        boolean error = false;
       
        if(Validaciones.validarCampoVacio(trimmedDescripcion))
        {
           errDescripcion.setText("La descripción es un campo obligatorio");
           error = true;
        }
               
        if(!Validaciones.ValidarNumerosyLetras(trimmedDescripcion))
        {
            errDescripcion.setText("La descripción ingresada es incorrecta");
            error = true;
        }
        
        return error;
    }
   
     public static Integer setDatosEditarFromTable(int seleccion, JTable tableCategorias, 
            JTextField txtDescripcion, JComboBox cmbEstado)
    {
        Integer CprId = null;
        CprId = Integer.parseInt((String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 0)))); 
        txtDescripcion.setText(String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 1)));
        cmbEstado.setSelectedItem(String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 2)));

        
        return CprId;
    }  
      
    public static void LlenarTableCategorias(JTable tableCategorias) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableCategorias.getModel(); 
        modelo.setRowCount(0);
        ArrayList<CategoriasModel> categorias = new ArrayList<>();
        categorias = CategoriaConexion.ListadoCategorias();
        
        for (int i = 0; i <categorias.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    categorias.get(i).getCprId(),
                    categorias.get(i).getCprDescripcion(),
                    categorias.get(i).getCprEstado()
                }
            );
        }
        FormatoTabla(tableCategorias, modelo.getColumnCount());
    }
    
    public static void FiltroTableCategorias(JTable tableCategorias, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableCategorias.getModel());
        tableCategorias.setRowSorter(rowSorter);
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