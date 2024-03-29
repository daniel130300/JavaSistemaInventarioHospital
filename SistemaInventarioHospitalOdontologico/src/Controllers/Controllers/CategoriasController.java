/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.CategoriaConexion;
import Models.Models.CategoriasModel;
import Utils.Estados.Estados;
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
* @author Héctor López
*/
public class CategoriasController 
{
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
     public static void setPlaceHolders(JTextField txtNomenclatura,JTextField txtDescripcion, JTextField txtBuscar)
    {
        TextPrompt placeholderNomenclatura = new TextPrompt(" Ingrese la nomenclatura", txtNomenclatura);
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese la descripción de la categoría ", txtDescripcion);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
    
    /**
    * @param accion String
    * @param id Integer
    * @param descripcion String
    * @param estado Srting
    * @param errDescripcion JLabel
    * Si los datos ingresados son incorrectos de acorde a las validaciones
    * retorna true, de lo contrario retorna false 
    * @return Boolean
    */
    public static Boolean MantenimientoCategorias(String accion, Integer id, 
            String nomenclatura,String descripcion, String estado, JLabel errDescripcion, JLabel errNomenclatura)
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errDescripcion.setText(null);
        errNomenclatura.setText(null);
        
        String trimmedDescripcion = descripcion.trim();
        String trimmedNomenclatura = nomenclatura.trim();
        generalValidacionError = CategoriasController.validacionesGenerales(trimmedDescripcion,trimmedNomenclatura,errDescripcion,errNomenclatura);
        if(generalValidacionError == false)
        { 
            CategoriasModel categoria = new CategoriasModel();
            Estados estados = new Estados();
            categoria.setCprId(id);
            categoria.setCprNomenclatura(trimmedNomenclatura);
            categoria.setCprDescripcion(trimmedDescripcion);
            String msj = "";
            String resultado = "";
            
            switch(accion)
            {
                case "insertar":
                    categoria.setCprEstado(estados.getValueEstado("Activo"));
                    resultado = CategoriaConexion.MantenimientoCategorias(accion, categoria);
                    msj =  "Categoría insertada con éxito.";
                    mntError = CategoriasController.mensajesRetroalimentacion(msj, resultado);
                break;
                
                case "editar":
                     categoria.setCprEstado(estados.getValueEstado(estado));
                    resultado = CategoriaConexion.MantenimientoCategorias(accion, categoria);
                    msj =  "Categoría actualizada con éxito.";
                    mntError = CategoriasController.mensajesRetroalimentacion(msj, resultado);                   
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false); 
    }    
    
    /**
    * 
    * @param seleccion int
    * @param tableCategorias JTable
    * @param txtDescripcion JTextField
    * @param cmbEstado JComboBox
    * Método que se encarga de pasar los campos de la tabla a los JTextFields 
    * correspondientes para poder ser editados y retorna el Id de la categoría de la tabla
    * @return Integer
    */
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableCategorias,JTextField txtNomenclatura, 
            JTextField txtDescripcion, JComboBox cmbEstado)
    {
        Integer CprId = null;
        CprId = Integer.parseInt((String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 0))));
        txtNomenclatura.setText(String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 1)));
        txtDescripcion.setText(String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 2)));
        cmbEstado.setSelectedItem(String.valueOf(tableCategorias.getModel().getValueAt(seleccion, 3)));

        
        return CprId;
    }  
    
    /**
    * 
    * @param tableCategorias JTable
    * Método que se encarga de llenar el JTable tableCategorias
    * con los datos que se obtienen del método ListadoCategorias() 
    * de la clase CategoriaConexion dependiendo de la accion que el usuario
    * realice.
     * @param accion
    * 
    */
    public static void LlenarTableCategorias(JTable tableCategorias,String accion) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableCategorias.getModel(); 
        modelo.setRowCount(0);
        ArrayList<CategoriasModel> categorias = new ArrayList<>();
        Estados estados = new Estados();
        categorias = CategoriaConexion.ListadoCategorias(accion);
        for (int i = 0; i <categorias.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            categorias.get(i).getCprId(),
                            categorias.get(i).getCprNomenclatura(),
                            categorias.get(i).getCprDescripcion(),
                            estados.getEstadoKey(categorias.get(i).getCprEstado())    
                        }
                    );
                }
            FormatoTabla(tableCategorias, modelo.getColumnCount());
    }
    /**
    * 
    * @param tableCategorias JTable
    * @param fieldBusqueda JTextField 
    * Método que se encarga de filtrar la tabla tableCategorias
    * a partir de la busqueda del usuario
    */
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
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /**
    * 
    * @param msj String
    * @param resultado Stting
    * Método que se encarga de mostrar en pantalla si la realización ha 
    * sido realizada con éxito o si ha habdido un error debido a el parametro de 
    * salida del procedimiento almacenado MantenimientoCategorias
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
            
            case "errNomenclatura":
                JOptionPane.showMessageDialog(null, "La nomenclatura ya se encuentra registrada.");
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
    private static boolean validacionesGenerales(String trimmedDescripcion,String trimmedNomenclatura,
        JLabel errDescripcion,JLabel errNomenclatura)
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
        if(Validaciones.validarCampoVacio(trimmedNomenclatura))
        {
           errNomenclatura.setText("La nomenclatura es un campo obligatorio");
           error = true;
        }
        if(!Validaciones.validarNomenclatura(trimmedNomenclatura))
        {
            errNomenclatura.setText("La nomenclatura ingresada es incorrecta");
            error = true;
        }
        return error;
    }
}
