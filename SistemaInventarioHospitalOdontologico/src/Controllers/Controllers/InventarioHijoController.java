/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.InventarioHijoConexion;
import Models.Models.InventarioHijoModel;
import Utils.Cache.InventarioPadreCache;
import Utils.Validators.Validaciones;
import static Views.Listados.ListadoUnidadesView.tableUnidades;
import static Views.Mantenimientos.MantenimientoInventarioBodegaView.txtUnidadHijo;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Katering Osorto
 */

public class InventarioHijoController {
 
    /**
     * 
     * @param accion String
     * @param Id Integer
     * @param descripcion
     * @param cantidad
     * @param unidades
     * @return Boolean
     */
    
    public static Boolean MantenimientoInventarioHijo(String accion, 
            Integer Id, String descripcion, String cantidad ,
            String unidades, JLabel errdescripcion, JLabel errcantidad,
            JLabel errunidades)
    {
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        InventarioHijoController.setErroresToNull(errdescripcion, errcantidad, errunidades );
        String trimmedDescripcion = descripcion.trim();
        String trimmedUnidades = unidades.trim();
        Integer trimmedCantidad =Integer.parseInt(cantidad);
        
        
        generalValidacionError = InventarioHijoController.validacionesGenerales(trimmedDescripcion, cantidad,
            trimmedUnidades,errdescripcion, errcantidad,errunidades);
        
       if(generalValidacionError == false)
        { 
            switch(accion)
            {
                case "insertar":
                    
                    mntError = InventarioHijoController.insertarInvHijo(
                    trimmedDescripcion,trimmedCantidad, trimmedUnidades);
                break;
                
                case "editar":   
                   // mntError = InventarioBodegaController.editarInvHijo(Id, 
                   //        trimmedDescripcion,cantidad,id_padre,trimmedUnidades);              
                break;
            }
        }

        return !(mntError == false && generalValidacionError == false); 
      }

    private static boolean insertarInvHijo( String trimmedDescripcion,
       Integer trimmedcantidad, String trimmedUnidades)
    {
        boolean error = false;
        Integer id = 0;
        Integer InvPId = 0;
        
        InventarioHijoModel inventarioHModel = new InventarioHijoModel();

        inventarioHModel = InventarioHijoController.setInvHModel(id, 
                trimmedDescripcion,trimmedcantidad, InvPId, trimmedUnidades);
        
        String resultado = InventarioHijoConexion.MantenimientoInventarioHijo("insertar", inventarioHModel);    
       
        switch (resultado) 
        {
            case "OK":  
               /* cache.setInvPId(InventarioBodegaConexion.UltimoInvPId());
                if(Mantenimiento("insertar",0,trimmedDescripcion,trimmedcantidad,cache.getInvPId(),trimmedUnidades,model)== false){
                    JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");   
                }*/
                JOptionPane.showMessageDialog(null, "Producto ingresado con éxito."); 
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    
    private static InventarioHijoModel setInvHModel(Integer id,
            String trimmedDescripcion,Integer Cantidad, Integer InvPId,
           String trimmedUnidades)
    {
        
        InventarioHijoModel invHModel = new InventarioHijoModel();
        invHModel.setInvHId(id);
        invHModel.setInvHDescripcion(trimmedDescripcion);
        invHModel.setInvHCantidad(Cantidad);
        invHModel.setInvPId(InvPId);
        invHModel.setUndId(trimmedUnidades);
        
        return invHModel;
    }  
    
    /**
     * 
     * @param seleccion int
     * @param tableBodega JTable
     * @param numStock JSpinner
     * @param txtFechaCaducidad JTextField
     * @param cmbEstado JComboBox
     * Método que se encarga de pasar los campos de la tabla a los JTextFields, JSpinner 
     * y JComboxes correspondientes para poder ser editados y retorna el Id de Lote del Producto.
     * @return Integer
     */
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableHijo, 
             JTextArea txtDescripcionHijo, JTextField txtCantidadHijo, JTextField txtUnidadHijo)
            
        {
            Integer InvHId = null;
            InvHId = Integer.parseInt((String.valueOf(tableHijo.getModel().getValueAt(seleccion, 0))));
            txtDescripcionHijo.setText(String.valueOf(tableHijo.getModel().getValueAt(seleccion, 1)));
            txtCantidadHijo.setText(String.valueOf(tableHijo.getModel().getValueAt(seleccion, 2)));
            txtUnidadHijo.setText(String.valueOf(tableHijo.getModel().getValueAt(seleccion, 4)));

            return InvHId;
        }
    /**
     * 
     * @param tableBodega JTable
     * @param numStock JSpinner
     * @param txtFechaCaducidad JTextField
     * @param cmbEstado JComboBox
     * Método que se encarga de pasar los campos de la clase InventarioBodegaCache a 
     * los JTextFields, JSpinner y JComboxes correspondientes para poder ser editados y
     * retorna el Id de Lote Producto.
     * @return Integer
     */
    public static Integer setDatosEditarFromCache(JTable tableHijo, JTextArea txtDescripcionHijo,
             JTextField txtCantidadHijo, JTextField txtUnidadHijo)
    {
        Integer InvHId = null;
        InventarioPadreCache inventariopadrecache = new InventarioPadreCache();
   
        if(inventariopadrecache.isDatosCompartidos())
        {   
            InvHId = inventariopadrecache.getIdH().getInvHId();
            txtDescripcionHijo.setText(inventariopadrecache.getIdH().getInvHDescripcion());
            txtCantidadHijo.setText(inventariopadrecache.getIdH().getInvHCantidad().toString());
            txtUnidadHijo.setText(inventariopadrecache.getIdH().getUndId());
        }
        
        return InvHId;
    }
    
    public static void AddNombreUnidadHijo(Object[] dataRow)
    {
        DefaultTableModel model =(DefaultTableModel) tableUnidades.getModel();
        txtUnidadHijo.setText(String.valueOf(dataRow[1]));
    }
        
    /**
     * 
     * @param tableBodega JTable
     * @param fieldBusqueda JTextField
     * Método que se encarga de filtrar la tabla tableBodega
     * a partir de la busqueda del Lote Producto.
     */
    public static void FiltroTableInventarioHijo(JTable tableHijo, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableHijo.getModel());
        tableHijo.setRowSorter(rowSorter);
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
    
     /**
     * 
     * @param tableHijo JTable
     * Método que se encarga de llenar el JTable tableBodega 
     * con los datos que se obtienen del método ListadoInventarioBodega() 
     * de la clase InventarioBodegaConexion dependiendo de la acción
     * que el usuario realice.
     */
    public static void LlenarTableInventarioHijo(JTable tableHijo) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableHijo.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioHijoModel> Hijo = new ArrayList<>();
        Hijo = InventarioHijoConexion.ListadoInventarioHijo();        
        for (int i = 0; i <Hijo.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            Hijo.get(i).getInvHId(), 
                            Hijo.get(i).getInvHDescripcion(),
                            Hijo.get(i).getInvHCantidad(),
                            Hijo.get(i).getInvPId(),
                            Hijo.get(i).getUndId()
                        }
                    );
                }
        
        FormatoTabla(tableHijo, modelo.getColumnCount());
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /**
     * 
     * @param msj String 
     * @param resultado String
     * Método que se encarga de mostrar en pantalla si la realización ha 
     * sido realizada con éxito.
     * @return Boolean
     */
    
    /**
     * 
     * @param trimmedFechaCaducidad String
     * @param errFechaCaducidad JLabel
     * Si los datos ingresados son incorrectos de acorde a las validaciones
     * establece los errores en los JLabels correspondientes y retorna true, 
     * de lo contrario retorna false.
     * @return Boolean
     */
    private static boolean validacionesGenerales(String trimmedDescripcion, String trimmedcantidad ,
            String trimmedunidades, JLabel errDescripcion, JLabel errcantidad,
            JLabel errunidades)
    {
        boolean error = false;

          if(Validaciones.validarCampoVacio(trimmedDescripcion))
        {
           errDescripcion.setText("La descripción es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedcantidad))
        {
           errcantidad.setText("La Cantidad es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedcantidad))
        {
           errcantidad.setText("El Cantidad ingresada es incorrecta");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedunidades))
        {
           errunidades.setText("La Unidad es un campo obligatorio");
           error = true;
        }  
        
        if(!Validaciones.validarLetras(trimmedunidades))
        {
           errunidades.setText("La Unidad ingresada es incorrecto");
           error = true;
        }
        
        
        return error;
    }
    
    private static void setErroresToNull(JLabel errdescripcion,JLabel errcantidad,JLabel errunidades)
    {
       errdescripcion.setText(null);
       errcantidad.setText(null);
       errunidades.setText(null);
    }  
    

}