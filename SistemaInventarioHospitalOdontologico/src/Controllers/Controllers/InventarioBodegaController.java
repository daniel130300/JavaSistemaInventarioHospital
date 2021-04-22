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
            
            switch(accion)
            {   
                case "editar":
                    inventario.setLprEstado(Estado);
                    resultado = InventarioBodegaConexion.MantenimientoInventarioBodega(accion, inventario);
                    msj =  "Registro actualizado con éxito"; 
                    mntError = InventarioBodegaController.mensajesRetroalimentacion(msj, resultado);
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
        }
        
        return error;
    }
    
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
    
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableBodega, 
             JSpinner numStock, JTextField txtFechaCaducidad, JComboBox cmbEstado)
            
        {
            Integer LprId = null;
            LprId = Integer.parseInt((String.valueOf(tableBodega.getModel().getValueAt(seleccion, 0))));
            numStock.setValue(tableBodega.getModel().getValueAt(seleccion, 4));
            txtFechaCaducidad.setText(String.valueOf(tableBodega.getModel().getValueAt(seleccion, 7)));
            cmbEstado.setSelectedItem(String.valueOf(tableBodega.getModel().getValueAt(seleccion, 3)));

            return LprId;
        }
    
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
    
    public static void LlenarTableInventarioBodega(JTable tableInventarioBodega, String accion) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableInventarioBodega.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioBodegaModel> inventario = new ArrayList<>();
         switch (accion){
            
            case "Activos":
                            inventario = InventarioBodegaConexion.ListadoInventarioBodega("Activos");
        
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
                            break;
        case "Inactivos":
                            inventario = InventarioBodegaConexion.ListadoInventarioBodega("Inactivos");
        
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
                            break;
        case "Todos":
                            inventario = InventarioBodegaConexion.ListadoInventarioBodega("Todos");
        
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
                            break;
        }
    }
    
}
