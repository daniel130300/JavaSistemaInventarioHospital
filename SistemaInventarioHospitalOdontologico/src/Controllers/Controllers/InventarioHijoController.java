/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.InventarioHijoConexion;
import Models.Models.InventarioHijoModel;
import Utils.Validators.Validaciones;
import Views.Mantenimientos.MantenimientoInventarioBodegaView;
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
 
    public static Boolean generalValidacionError2 = true;
   // public static Boolean errorHijo= false;
    
   /* public static Boolean MantenimientoInventarioHijo(String accion, 
            Integer Id, String descripcion, String cantidad ,
            String unidades, JLabel errdescripcion, JLabel errcantidad,
            JLabel errunidades)
    {
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        InventarioHijoController.setErroresToNull(errdescripcion, errcantidad, errunidades );
        String trimmedDescripcion = descripcion.trim();
        String trimmedUnidades = unidades.trim();
        String trimmedCantidad =cantidad;
        
        
        generalValidacionError = InventarioHijoController.validacionesGenerales(trimmedDescripcion, cantidad,
            trimmedUnidades,errdescripcion, errcantidad,errunidades);
        
       if(generalValidacionError == false)
        { 
            switch(accion)
            {
                case "insertar":
                    
                    mntError = InventarioHijoController.insertarInvHijo(
                    trimmedDescripcion,Integer.parseInt(trimmedCantidad), trimmedUnidades);
                break;
                
                case "editar":   
                   mntError = InventarioHijoController.editarInvHijo(Id, 
                   trimmedDescripcion,Integer.parseInt(trimmedCantidad), trimmedUnidades);              
                break;
            }
        }

        return !(mntError == false && generalValidacionError == false); 
      } */

    public static Boolean ValidacionInputsHijo(String descripcion, String cantidad ,
            String unidades, JLabel errdescripcion, JLabel errcantidad,
            JLabel errunidades)
    {
        InventarioHijoController.setErroresToNull(errdescripcion, errcantidad, errunidades );
        String trimmedDescripcion = descripcion.trim();
        String trimmedUnidades = unidades.trim();
        String trimmedCantidad = cantidad.trim();
        
        
        generalValidacionError2 = InventarioHijoController.validacionesGenerales(trimmedDescripcion, trimmedCantidad,
            trimmedUnidades,errdescripcion, errcantidad,errunidades);

        return !(generalValidacionError2 == false); 
      }
    
    public static boolean insertarInvHijo(String descripcion,
       String Cantidad, String unidades)
    {
        boolean error = false;
        Integer id = 0;
        Integer InvPId = 0;
        String trimmedDescripcion = descripcion.trim();
        String trimmedUnidades = unidades.trim();
        
        InventarioHijoModel inventarioHModel = new InventarioHijoModel();

        if(generalValidacionError2 == false)
        {
            inventarioHModel = InventarioHijoController.setInvHModel(id, 
                    trimmedDescripcion, Integer.parseInt(Cantidad), InvPId, trimmedUnidades);

            String resultado = InventarioHijoConexion.MantenimientoInventarioHijo("insertar", inventarioHModel);    

            switch (resultado) 
            {
                case "OK":  
                    if(MantenimientoInventarioBodegaView.accion.equals(2)){
                        JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");  
                        System.out.println("Producto Ingresado con éxito.");
                    }
                break;

                case "errProducto":
                    JOptionPane.showMessageDialog(null, "El producto Padre ya se encuentra registrado.");
                    error = true;
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                    error = true;
                break;
            }
        }
        return !(error == false && generalValidacionError2 == false);
    }
    
    public static boolean editarInvHijo(Integer Id, String descripcion, String Cantidad, 
             String unidades)
    {
        boolean error = false; 

        InventarioHijoModel productoModel = new InventarioHijoModel();
        Integer InvPId = 0;
        String trimmedDescripcion = descripcion.trim();
        String trimmedUnidades = unidades.trim();
        
        if(generalValidacionError2 == false)
        {
            productoModel = InventarioHijoController.setInvHModel(Id,
                    trimmedDescripcion, Integer.parseInt(Cantidad), InvPId, trimmedUnidades);

            String resultado = InventarioHijoConexion.MantenimientoInventarioHijo("editar", productoModel);

            switch (resultado) 
            {
                case "OK":   
                    JOptionPane.showMessageDialog(null, "Producto editado con éxito.");       
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                    error = true;
                break;
            }
        }
        return !(error == false && generalValidacionError2 == false);
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

    public static void AddNombreUnidadHijo(Object[] dataRow)
    {
        txtUnidadHijo.setText(String.valueOf(dataRow[1]));
    }
        
    /**
     * 
     * @param tableHijo JTable
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
        
        if(!Validaciones.validarNumeros(trimmedcantidad))
        {
           errcantidad.setText("La Cantidad ingresada es incorrecta");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedcantidad))
        {
           errcantidad.setText("La Cantidad es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedunidades))
        {
           errunidades.setText("La Unidad es un campo obligatorio");
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