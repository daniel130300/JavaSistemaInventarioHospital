/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.RubrosConexion;
import Models.Models.RubrosModel;
import Utils.PlaceHolders.TextPrompt;
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
 * @author Maryury Zuniga
 */
public class RubrosController 
{
    //**************************
    // Metodos Públicos
    //**************************

    public static void setPlaceHolders(JTextField txtDescripcion, JTextField txtBuscar)
    {
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese la descripción del rubro ", txtDescripcion);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
    
    
    public static Boolean MantenimientoRubros(String accion, Integer id, 
            String descripcion, String estado, JLabel errDescripcion)
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errDescripcion.setText(null);

        String trimmedDescripcion = descripcion.trim();

        generalValidacionError = RubrosController.validacionesGenerales(trimmedDescripcion,errDescripcion);
        
        if(generalValidacionError == false)
        { 
            RubrosModel rubro = new RubrosModel();
            rubro.setRubId(id);
            rubro.setRubDescripcion(descripcion);
            String msj = "";
            String resultado = "";
            
            switch(accion)
            {
                case "insertar":
                    rubro.setRubEstado("Activo");
                    resultado = RubrosConexion.MantenimientoRubros(accion, rubro);
                    msj =  "Rubro insertado con éxito.";
                    mntError = RubrosController.mensajesRetroalimentacion(msj, resultado);
                    
                break;
                
                case "editar":
                    rubro.setRubEstado(estado);
                    resultado = RubrosConexion.MantenimientoRubros(accion, rubro);
                    msj =  "Rubro actualizado con éxito.";
                    mntError = RubrosController.mensajesRetroalimentacion(msj, resultado);                   
                break; 
            }
        }
        
        return !(mntError == false && generalValidacionError == false); 
    }   
    
    /**
    * @param seleccion
    * @param tableUnidades
    * @param txtDescripcion
    * @param cmbEstado
    * Metodo encargado de pasar los datos de la tabla a los JTextFields
    * correspondientes para ser editados, retorna el id de la unidad de la tabla
    * @return Integer
    */
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableRubros, 
            JTextField txtDescripcion, JComboBox cmbEstado)
    {
        Integer UndId = null;
        UndId = Integer.parseInt((String.valueOf(tableRubros.getModel().getValueAt(seleccion, 0)))); 
        txtDescripcion.setText(String.valueOf(tableRubros.getModel().getValueAt(seleccion, 1)));
        cmbEstado.setSelectedItem(String.valueOf(tableRubros.getModel().getValueAt(seleccion, 2)));

        return UndId;
    } 
    
    /**
    * @param tableUnidades 
    * Metodo para el llenado de JTable table Unidades con datos obtenidos 
    * del metodo ListadoUnidades() de la clase UnidadesConexion dependiendo de
    * la accion que realice el usuario.
     * @param accion
    */
    public static void LlenarTableRubros(JTable tableUnidades, String accion) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableUnidades.getModel(); 
        modelo.setRowCount(0);
        ArrayList<RubrosModel> rubros = new ArrayList<>();
        rubros = RubrosConexion.ListadoRubros(accion);     
        for (int i = 0; i <rubros.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            rubros.get(i).getRubId(),
                            rubros.get(i).getRubDescripcion(),
                            rubros.get(i).getRubEstado()
                        }
                    );
                }
                FormatoTabla(tableUnidades, modelo.getColumnCount());
    } 
    /*
    * @param tableCategorias JTable
    * @param fieldBusqueda JTextField 
    * Método que se encarga de filtrar la tabla tableUnidades
    * a partir de la busqueda del usuario
    */
     public static void FiltroTableRubros(JTable tableRubros, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableRubros.getModel());
        tableRubros.setRowSorter(rowSorter);
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
    // **************************************************
    // Métodos Privados
    // **************************************************
  
    /**
    * 
    * @param msj String
    * @param resultado String
    * Dependiendo del parametro resultado muestra un mensaje en pantalla por
    * medio de un JOptionPane
    * @return boolean
    */
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
            
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        
        return error;
    }  
    
    /**
    * 
    * @param trimmedDescripcion String
    * @param errDescripcion JLabel
    * Si los datos ingresados son incorrectos de acorde a las validaciones
    * establece los errores en los JLabels correspondientes y retorna true, 
    * de lo contrario retorna false. 
    * @return boolean
    */
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
}

