/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.UnidadesConexion;
import Models.Models.UnidadesModel;
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
 * @author may_g
 */
public class UnidadesController {
    
    public static Boolean MantenimientoUnidades(String accion, Integer id, 
            String descripcion, String estado, JLabel errDescripcion)
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errDescripcion.setText(null);

        String trimmedDescripcion = descripcion.trim();

        generalValidacionError = UnidadesController.validacionesGenerales(trimmedDescripcion,errDescripcion);
        
        if(generalValidacionError == false)
        { 
            UnidadesModel unidad = new UnidadesModel();
            unidad.setUndId(id);
            unidad.setUndDescripcion(descripcion);
            String msj = "";
            String resultado = "";
            
            switch(accion)
            {
                case "insertar":
                    unidad.setUndEstado("Activo");
                    resultado = UnidadesConexion.MantenimientoUnidades(accion, unidad);
                    msj =  "Unidad insertada con éxito";
                    mntError = UnidadesController.mensajesRetroalimentacion(msj, resultado);
                    
                break;
                
                case "editar":
                     unidad.setUndEstado(estado);
                    resultado = UnidadesConexion.MantenimientoUnidades(accion, unidad);
                    msj =  "Unidad actualizada con éxito";
                    mntError = UnidadesController.mensajesRetroalimentacion(msj, resultado);                   
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
        
        errDescripcion.setText(null);
       
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
     
      public static Integer setDatosEditarFromTable(int seleccion, JTable tableUnidades, 
            JTextField txtDescripcion, JComboBox cmbEstado)
    {
        Integer UndId = null;
        UndId = Integer.parseInt((String.valueOf(tableUnidades.getModel().getValueAt(seleccion, 0)))); 
        txtDescripcion.setText(String.valueOf(tableUnidades.getModel().getValueAt(seleccion, 1)));
        cmbEstado.setSelectedItem(String.valueOf(tableUnidades.getModel().getValueAt(seleccion, 2)));

        
        return UndId;
    }  
      
      public static void LlenarTableUnidades(JTable tableUnidades) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableUnidades.getModel(); 
        modelo.setRowCount(0);
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        unidades = UnidadesConexion.ListadoUnidades();
        
        for (int i = 0; i <unidades.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    unidades.get(i).getUndId(),
                    unidades.get(i).getUndDescripcion(),
                    unidades.get(i).getUndEstado()
                }
            );
        }
        FormatoTabla(tableUnidades, modelo.getColumnCount());
    }
    public static void FiltroTableUnidades(JTable tableUnidades, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableUnidades.getModel());
        tableUnidades.setRowSorter(rowSorter);
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

