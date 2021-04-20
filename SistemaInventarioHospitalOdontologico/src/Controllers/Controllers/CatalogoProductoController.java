/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;


import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.CatalogoProductoConexion;
import Models.Models.CatalogoProductoModel;
import Models.Models.CategoriasModel;
import Models.Models.UnidadesModel;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
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
 * @author fgodo
 */
public class CatalogoProductoController 
{
    public static Boolean MantenimientoProducto(String accion, Integer id,
            String nombre, String descripcion, String stockmaximo , String stockminimo, 
            String estado,Integer id_categoria , Integer id_unidad,
            JLabel errnombre, JLabel errdescripcion, JLabel errstockmaximo, JLabel errstockminimo )
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        CatalogoProductoController.setErroresToNull(errnombre, errdescripcion, errstockmaximo, errstockminimo);
        String trimmedNombre = nombre.trim();
        String trimmedDescripcion = descripcion.trim();
        String trimmedStockMaximo = stockmaximo.trim();
        String trimmedStockMinimo = stockminimo.trim();

        generalValidacionError = CatalogoProductoController.validacionesGenerales( trimmedNombre, 
               trimmedDescripcion, trimmedStockMaximo, trimmedStockMinimo,errnombre, errdescripcion, 
               errstockmaximo, errstockminimo);
        
        if(generalValidacionError == false)
        {
            switch(accion)
            {
                case "insertar":

                        mntError = CatalogoProductoController.insertarProveedor(
                                trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                                trimmedStockMinimo, id_categoria, id_unidad);
                    
                break;
                
                case "editar":
                        mntError = CatalogoProductoController.editarProveedor(id, 
                                trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                                trimmedStockMinimo, id_categoria, id_unidad, estado);              
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false);
    } 
    private static boolean insertarProveedor(String trimmedNombre,String trimmedDescripcion,
            String trimmedStockMaximo, String trimmedStockMinimo, 
            Integer id_categoria, Integer id_unidad)
    {
        boolean error = false;
        
        Integer id = 0; 
        String estado = "Activo";
        JOptionPane.showMessageDialog(null, "Cate: "+id_categoria+" Uni: "+id_unidad);
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        
        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria,id_unidad, estado);
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("insertar", productoModel);
          
       switch (resultado) 
        {
            case "OK":
                    JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");    
            break;

            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Producto ya se encuentra registrado.");
                error = true;
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        
        return error;
    }
    private static boolean editarProveedor(Integer id,String trimmedNombre,
            String trimmedDescripcion, String trimmedStockMaximo,String trimmedStockMinimo,
            Integer id_categoria, Integer id_unidad, String estado)
    {
        boolean error = false; 
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria,id_unidad, estado);
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("editar", productoModel);
        switch (resultado) 
        {
            case "OK":
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");      
            break;
            case "errNombre":
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
    private static CatalogoProductoModel setProductoModel(Integer id,String trimmedNombre,
            String trimmedDescripcion, String trimmedStockMaximo, String trimmedStockMinimo,
            Integer id_categoria,Integer id_unidad,String estado)
    {
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        productoModel.setPrdId(id);
        productoModel.setPrdNombre(trimmedNombre);
        productoModel.setPrdDescripcion(trimmedDescripcion);
        productoModel.setPrdStockMaximo(trimmedStockMaximo);
        productoModel.setPrdStockMinimo(trimmedStockMinimo);
        productoModel.setProdEstado(estado);       
        productoModel.setCprId(id_categoria);
        productoModel.setUndId(id_unidad);
        
        return productoModel;
    }   
    public static void FiltroTableProducto(JTable tableUsuarios, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableUsuarios.getModel());
        tableUsuarios.setRowSorter(rowSorter);
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
        
    
    
    private static boolean validacionesGenerales(String trimmedNombre,String trimmedDescripcion,
        String trimmedStockMaximo, String trimmedStockMinimo, JLabel errNombre, JLabel errDescripcion,
        JLabel errStockMaximo, JLabel errStockMinimo)
    {
        boolean error = false;
        if(!Validaciones.validarLetras(trimmedNombre))
        {
           errNombre.setText("La nombre ingresada es incorrecta");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedNombre))
        {
           errNombre.setText("La nombre es un campo obligatorio");
           error = true;
        }
                
        if(Validaciones.validarCampoVacio(trimmedDescripcion))
        {
           errDescripcion.setText("El descripción es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedStockMaximo))
        {
           errStockMaximo.setText("El stock máximo ingresado es incorrecto");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedStockMaximo))
        {
           errStockMaximo.setText("El stock máximo es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedStockMinimo))
        {
            errStockMinimo.setText("El stock mínimo ingresado es incorrecto");
            error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedStockMinimo))
        {
           errStockMinimo.setText("El stock mínimo es un campo obligatorio");
           error = true;
        }
        
        return error;
    }    
    private static void setErroresToNull(JLabel errnombre, JLabel errdescripcion, 
        JLabel errstockmaximo, JLabel errstockminimos)
    {
        errnombre.setText(null);
        errdescripcion.setText(null);
        errstockmaximo.setText(null);
        errstockminimos.setText(null);
    }     
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableProductos, 
            JTextField txtNombre,JTextArea txtDescripcion, JTextField txtStockMaximo,
            JTextField  txtStockMinimo,JComboBox cmbCategoria,JComboBox cmbUnidad,JComboBox cmbEstado )
    {
        Integer PrdId = null;
        PrdId = Integer.parseInt((String.valueOf(tableProductos.getModel().getValueAt(seleccion, 0)))); 
        txtNombre.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 1)));
        txtDescripcion.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 2)));
        txtStockMaximo.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 3)));
        txtStockMinimo.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 4)));
        cmbCategoria.setSelectedItem(String.valueOf(tableProductos.getModel().getValueAt(seleccion,6)));
        cmbUnidad.setSelectedItem(String.valueOf(tableProductos.getModel().getValueAt(seleccion,8)));
        cmbEstado.setSelectedItem(String.valueOf(tableProductos.getModel().getValueAt(seleccion,9)));
        
        return PrdId;
    }     
    public static void LlenarCmbCategoria(JComboBox cmbCategorias)
    {
        ArrayList<CategoriasModel> categorias = new ArrayList<>();
        categorias = CatalogoProductoConexion.ListadoCategorias();
        
        for (int i = 0; i<categorias.size(); i++)
        {
            cmbCategorias.addItem(categorias.get(i).getCprDescripcion());
        }
    } 
    public static void LlenarCmbUnidades(JComboBox cmbUnidades)
    {
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        unidades = CatalogoProductoConexion.ListadoUnidades();
        
        for (int i = 0; i<unidades.size(); i++)
        {
            cmbUnidades.addItem(unidades.get(i).getUndDescripcion());
        }
    }
    public static void LlenarTableProductos(JTable tableProductos) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel(); 
        modelo.setRowCount(0);
        ArrayList<CatalogoProductoModel> productos = new ArrayList<>();
        productos = CatalogoProductoConexion.ListadoProducto();
        
        for (int i = 0; i <productos.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    productos.get(i).getPrdId(), 
                    productos.get(i).getPrdNombre(),
                    productos.get(i).getPrdDescripcion(),
                    productos.get(i).getPrdStockMaximo(),
                    productos.get(i).getPrdStockMinimo(),
                    productos.get(i).getCprId(),
                    productos.get(i).getCprDescripcion(), 
                    productos.get(i).getUndId(),                  
                    productos.get(i).getUndDescripcion(),
                    productos.get(i).getProdEstado()    
                }
            );
        }
        
        FormatoTabla(tableProductos, modelo.getColumnCount());
    }   
    
    
   
}
