/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.DevolucionCompraConexion;
import Models.Models.DetalleDevolucionCompraModel;
import Models.Models.DevolucionCompraModel;
import Utils.PlaceHolders.TextPrompt;
import java.util.ArrayList;
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
 * @author usuario
 */
public class DevolucionCompraController {
    
     public static void setPlaceHolders( JTextField txtBuscar, JTextField txtBuscar1)
    {
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
        TextPrompt placeholderBuscar1 = new TextPrompt(" Ingrese su búsqueda ", txtBuscar1);
    }
     
     public static void FiltroTableDevolucionCompra(JTable tableCompras, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableCompras.getModel());
        tableCompras.setRowSorter(rowSorter);
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
     
     public static void LlenarTableDevolucionCompra(JTable tableCompra) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableCompra.getModel(); 
        modelo.setRowCount(0);
        ArrayList<DevolucionCompraModel> DevolucionCompra = new ArrayList<>();
        DevolucionCompra = DevolucionCompraConexion.ListadoDevolucionCompra();        
        for (int i = 0; i <DevolucionCompra.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            DevolucionCompra.get(i).getCmpId(), 
                            DevolucionCompra.get(i).getProId(),
                            DevolucionCompra.get(i).getProRTN(),
                            DevolucionCompra.get(i).getProNombre(),
                            DevolucionCompra.get(i).getCmpFactura(),
                            DevolucionCompra.get(i).getCmpNumeroTransferencia(),
                            DevolucionCompra.get(i).getCmpOrdenCompra(),
                            DevolucionCompra.get(i).getCmpFecha(),
                            DevolucionCompra.get(i).getUsrUsuario()
                        }
                    );
                }
        
        FormatoTabla(tableCompra, modelo.getColumnCount());
    }
     
      public static void FiltroTableDetalleDevolucionCompra(JTable tableProductos, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableProductos.getModel());
        tableProductos.setRowSorter(rowSorter);
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
     
     public static void LlenarTableDetalleDevolucionCompra(JTable tableProductos, Integer CmpId) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel(); 
        modelo.setRowCount(0);
        ArrayList<DetalleDevolucionCompraModel> DetalleDevolucionCompra = new ArrayList<>();
        DetalleDevolucionCompra = DevolucionCompraConexion.ListadoDetalleDevolucionCompra(CmpId);        
        for (int i = 0; i <DetalleDevolucionCompra.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            DetalleDevolucionCompra.get(i).getInvPId(), 
                            DetalleDevolucionCompra.get(i).getPrdNombre(),
                            DetalleDevolucionCompra.get(i).getInvPDescripcion(),
                            DetalleDevolucionCompra.get(i).getUndDescripcion(),
                            DetalleDevolucionCompra.get(i).getInvPFchCaducidad(),
                            DetalleDevolucionCompra.get(i).getDtcCantidad(),
                            DetalleDevolucionCompra.get(i).getDtctTieneImpuesto(),
                            DetalleDevolucionCompra.get(i).getDtcPrecioCompra()
                        }
                    );
                }
        
        FormatoTabla(tableProductos, modelo.getColumnCount());
    }
     
      public static Integer setDatosDevolucionCompraFromTable(int seleccion, JTable tableProductos, 
            JTextField txtNombreProducto, JTextArea txtDescripcionProducto, JTextField txtUnidad,
            JTextField txtFechaCaducidad, JTextField txtCantidad, JTextField txtPagaImpuesto,
            JTextField txtPrecio)
    {
        Integer InvPId = null;

            InvPId = Integer.parseInt(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 0)));
            txtNombreProducto.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 1)));
            txtDescripcionProducto.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 2)));
            txtUnidad.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 3)));
            txtFechaCaducidad.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 4)));
            txtCantidad.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 5)));
            txtPagaImpuesto.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 6)));
            txtPrecio.setText(String.valueOf((tableProductos.getModel().getValueAt(seleccion, 7))));
            
        return InvPId;
    }
}
