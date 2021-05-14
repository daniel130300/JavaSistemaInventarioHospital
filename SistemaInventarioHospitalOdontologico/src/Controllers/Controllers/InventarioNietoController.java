/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.InventarioNietoConexion;
import Models.Models.InventarioNietoModel;
import Utils.Validators.Validaciones;
import static Views.Mantenimientos.MantenimientoInventarioBodegaView.txtUnidadNieto;
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
 * @author Maryury Zuniga
 */
public class InventarioNietoController {
    /**
     * 
     * @param accion
     * @param Id
     * @param descripcion
     * @param cantidad
     * @param unidades
     * @param errdescripcion
     * @param errcantidad
     * @param errunidades
     * Si los datos ingresados son correctos retornara true de lo contrario sera
     * false.
     * @return boolean 
     */
    public static Boolean MantenimientoInventarioNieto(String accion, 
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
                    
                    mntError = InventarioNietoController.insertarInvNieto(
                    trimmedDescripcion,trimmedCantidad, trimmedUnidades);
                break;
                
                case "editar":   
                   mntError = InventarioNietoController.editarInvNieto(Id, 
                   trimmedDescripcion,trimmedCantidad, trimmedUnidades);              
                break;
            }
        }

        return !(mntError == false && generalValidacionError == false); 
      }
    /**
     * 
     * @param trimmedDescripcion
     * @param trimmedcantidad
     * @param trimmedUnidades
     * @return boolean
     */
    private static boolean insertarInvNieto( String trimmedDescripcion,
       Integer trimmedcantidad, String trimmedUnidades)
    {
        boolean error = false;
        Integer id = 0;
        Integer InvHId = 0;
        
        InventarioNietoModel inventarioNModel = new InventarioNietoModel();

        inventarioNModel = InventarioNietoController.setInvNModel(id, 
                trimmedDescripcion,trimmedcantidad, InvHId, trimmedUnidades);
        
        String resultado = InventarioNietoConexion.MantenimientoInventarioNieto("insertar", inventarioNModel);    
       
        switch (resultado) 
        {
            case "OK":  
                JOptionPane.showMessageDialog(null, "Producto ingresado con éxito."); 
            break;
            
            case "errProducto":
                JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado.");
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
     * @param Id
     * @param trinmedDescripcion
     * @param trinmedCantidad
     * @param trinmedUnidad
     * @return 
     */
    private static boolean editarInvNieto(Integer Id, String trinmedDescripcion, Integer trinmedCantidad, 
             String trinmedUnidad)
    {

        boolean error = false; 

        InventarioNietoModel productoModel = new InventarioNietoModel();
        Integer InvHId = 0;
        
        productoModel = InventarioNietoController.setInvNModel(Id,
                trinmedDescripcion, trinmedCantidad, InvHId, trinmedUnidad);
        
        String resultado = InventarioNietoConexion.MantenimientoInventarioNieto("editar", productoModel);
        
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
        return error;
    }
    /**
     * 
     * @param id
     * @param trimmedDescripcion
     * @param Cantidad
     * @param InvPId
     * @param trimmedUnidades
     * @return 
     */
    private static InventarioNietoModel setInvNModel(Integer id,
            String trimmedDescripcion,Integer Cantidad, Integer InvPId,
           String trimmedUnidades)
    {
        
        InventarioNietoModel invNModel = new InventarioNietoModel();
        invNModel.setInvNId(id);
        invNModel.setInvNDescripcion(trimmedDescripcion);
        invNModel.setInvNCantidad(Cantidad);
        invNModel.setInvHId(InvPId);
        invNModel.setUndId(trimmedUnidades);
        
        return invNModel;
    }  
    /**
     * 
     * @param seleccion
     * @param tableNieto
     * @param txtDescripcionNieto
     * @param txtCantidadNieto
     * @param txtUnidadNieto
     * @return 
     */
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableNieto, 
             JTextArea txtDescripcionNieto, JTextField txtCantidadNieto, JTextField txtUnidadNieto)
            
        {
            Integer InvNId = null;
            InvNId = Integer.parseInt((String.valueOf(tableNieto.getModel().getValueAt(seleccion, 0))));
            txtDescripcionNieto.setText(String.valueOf(tableNieto.getModel().getValueAt(seleccion, 1)));
            txtCantidadNieto.setText(String.valueOf(tableNieto.getModel().getValueAt(seleccion, 2)));
            txtUnidadNieto.setText(String.valueOf(tableNieto.getModel().getValueAt(seleccion, 4)));

            return InvNId;
        }

    public static void AddNombreUnidadNieto(Object[] dataRow)
    {
        txtUnidadNieto.setText(String.valueOf(dataRow[1]));
    }
        
    /**
     * 
     * @param tableNieto
     * @param fieldBusqueda JTextField
     * Método que se encarga de filtrar la tabla tableNieto
     * 
     */
    public static void FiltroTableInventarioNieto(JTable tableNieto, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableNieto.getModel());
        tableNieto.setRowSorter(rowSorter);
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
     * @param tableNieto
     * Método que se encarga de llenar el JTable tableNieto
     * con los datos que se obtienen del método ListadoInventarioNieto() 
     * de la clase InventarioNietoConexion
     */
    public static void LlenarTableInventarioNieto(JTable tableNieto) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableNieto.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioNietoModel> Nieto = new ArrayList<>();
        Nieto= InventarioNietoConexion.ListadoInventarioNieto();        
        for (int i = 0; i <Nieto.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            Nieto.get(i).getInvNId(), 
                            Nieto.get(i).getInvNDescripcion(),
                            Nieto.get(i).getInvNCantidad(),
                            Nieto.get(i).getInvHId(),
                            Nieto.get(i).getUndId()
                        }
                    );
                }
        
        FormatoTabla(tableNieto, modelo.getColumnCount());
    }
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /**
     * 
     * @param trimmedDescripcion
     * @param trimmedcantidad
     * @param trimmedunidades
     * @param errDescripcion
     * @param errcantidad
     * @param errunidades
     * Si los datos ingresados son incorrectos de acorde a las validaciones
     * establece los errores en los JLabels correspondientes y retorna true, 
     * de lo contrario retorna false.
     * @return boolean
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
    
    /**
     * 
     * @param errdescripcion
     * @param errcantidad
     * @param errunidades 
     */
    private static void setErroresToNull(JLabel errdescripcion,JLabel errcantidad,JLabel errunidades)
    {
       errdescripcion.setText(null);
       errcantidad.setText(null);
       errunidades.setText(null);
    }  
    
}
