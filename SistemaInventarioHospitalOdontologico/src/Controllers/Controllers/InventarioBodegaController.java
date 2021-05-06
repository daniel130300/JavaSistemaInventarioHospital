/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.InventarioBodegaConexion;
import Models.Models.InventarioBodegaModel;
import Utils.Cache.InventarioBodegaCache;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
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
 * @author Katering Osorto
 */

public class InventarioBodegaController {

    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    /**
     * 
     * @param accion String
     * @param Id Integer
     * @param Stock Integer
     * @param FechaCaducidad String
     * @param Estado String
     * @param errFechaCaducidad JLabel
     * @param errStock JLabel
     * Si los datos ingresados son incorrectos de acorde a las validaciones
     * retorna true, de lo contrario retorna false.
     * @return Boolean
     */
    
    public static Boolean MantenimientoInventarioBodega(String accion, 
            Integer Id, Integer Stock, String FechaCaducidad, 
            String Estado ,JLabel errFechaCaducidad, JLabel errStock)
    {
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errStock.setText(null);
        errFechaCaducidad.setText(null);
        
        Integer trimmedStock = Stock;
        String trimmedFechaCaducidad = FechaCaducidad.trim();
          
        generalValidacionError = InventarioBodegaController.validacionesGenerales(trimmedFechaCaducidad,errFechaCaducidad);

        if(generalValidacionError == false)
        { 
            InventarioBodegaModel inventario = new InventarioBodegaModel();
            inventario.setLprId(Id);
            inventario.setLprStock(Stock);
            inventario.setLprFechaCaducidad(FechaCaducidad); 
            String msj = "";
            String resultado = "";
            inventario.setLprEstado(Estado);
            switch(accion)
            {   
                case "editar":
                    resultado = InventarioBodegaConexion.MantenimientoInventarioBodega(accion, inventario);
                    msj =  "Registro actualizado con éxito."; 
                    mntError = InventarioBodegaController.mensajesRetroalimentacion(msj, resultado);
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false); 
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
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableBodega, 
             JSpinner numStock, JTextField txtFechaCaducidad, JComboBox cmbEstado)
            
        {
            Integer LprId = null;
            LprId = Integer.parseInt((String.valueOf(tableBodega.getModel().getValueAt(seleccion, 0))));
            numStock.setValue(tableBodega.getModel().getValueAt(seleccion, 4));
            txtFechaCaducidad.setText(String.valueOf(tableBodega.getModel().getValueAt(seleccion, 7)));
            cmbEstado.setSelectedItem(String.valueOf(tableBodega.getModel().getValueAt(seleccion, 10)));

            return LprId;
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
    public static Integer setDatosEditarFromCache(JTable tableBodega, JSpinner numStock,
             JTextField txtFechaCaducidad, JComboBox cmbEstado)
    {
        InventarioBodegaCache inventariobodegaCache = new InventarioBodegaCache();
        Integer LprId = null;
   
        if(inventariobodegaCache.isDatosCompartidos())
        {   
            LprId = inventariobodegaCache.getId().getLprId();
            numStock.setValue(inventariobodegaCache.getId().getLprStock());
            txtFechaCaducidad.setText(inventariobodegaCache.getId().getLprFechaCaducidad()); 
            cmbEstado.setSelectedItem(inventariobodegaCache.getId().getLprEstado());
        }
        
        return LprId;
    }
    
    /**
     * 
     * @param tableBodega JTable
     * @param fieldBusqueda JTextField
     * Método que se encarga de filtrar la tabla tableBodega
     * a partir de la busqueda del Lote Producto.
     */
    public static void FiltroTableInventarioBodega(JTable tableBodega, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableBodega.getModel());
        tableBodega.setRowSorter(rowSorter);
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
     * @param tableInventarioBodega JTable
     * @param accion String
     * Método que se encarga de llenar el JTable tableBodega 
     * con los datos que se obtienen del método ListadoInventarioBodega() 
     * de la clase InventarioBodegaConexion dependiendo de la acción
     * que el usuario realice.
     */
    public static void LlenarTableInventarioBodega(JTable tableInventarioBodega, String accion) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableInventarioBodega.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioBodegaModel> inventario = new ArrayList<>();
        inventario = InventarioBodegaConexion.ListadoInventarioBodega(accion);        
        for (int i = 0; i <inventario.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            inventario.get(i).getLprId(), 
                            inventario.get(i).getPrdId(),
                            inventario.get(i).getPrdNombre(),
                            inventario.get(i).getPrdDescripcion(),
                            inventario.get(i).getLprStock(),
                            inventario.get(i).getPrdStockMaximo(),
                            inventario.get(i).getPrdStockMinimo(),
                            inventario.get(i).getLprFechaCaducidad(),
                            inventario.get(i).getCprDescripcion(),
                            inventario.get(i).getUndDescripcion(),
                            inventario.get(i).getLprEstado()
                        }
                    );
                }
        
        FormatoTabla(tableInventarioBodega, modelo.getColumnCount());
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
    private static boolean mensajesRetroalimentacion(String msj, String resultado)
    {
        boolean error = false;
        
        switch (resultado) 
        {
            case "OK":
                JOptionPane.showMessageDialog(null, msj);                   
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
            break;
        }
        
        return error;
    }
    
    /**
     * 
     * @param trimmedFechaCaducidad String
     * @param errFechaCaducidad JLabel
     * Si los datos ingresados son incorrectos de acorde a las validaciones
     * establece los errores en los JLabels correspondientes y retorna true, 
     * de lo contrario retorna false.
     * @return Boolean
     */
    private static boolean validacionesGenerales(String trimmedFechaCaducidad,
        JLabel errFechaCaducidad)
    {
        boolean error = false;

         if(!Validaciones.ValidarFormatoFecha(trimmedFechaCaducidad))
         {
            errFechaCaducidad.setText("Formato de Fecha Incorrecto");
            error = true;
         }

         if(Validaciones.ValidarFecha(trimmedFechaCaducidad))
         {
            errFechaCaducidad.setText("La Fecha de Caducidad no debe ser anterior a la actual");
            error = true;
         }

        if(Validaciones.validarCampoVacio(trimmedFechaCaducidad))
        {
            errFechaCaducidad.setText("Es un campo obligatorio");
            error = true;
        }
        
        return error;
    }
}
