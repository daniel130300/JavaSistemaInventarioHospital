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
import Models.Models.DetalleCatalogoProductosModel;
import Models.Models.UnidadesModel;
import Utils.Cache.CatalogoProductoCache;
import Utils.Estados.Estados;
import Utils.PlaceHolders.TextPrompt;
import Utils.Validators.Validaciones;
import Views.Mantenimientos.MantenimientoCatalogoProductosView;
import static Views.Mantenimientos.MantenimientoCatalogoProductosView.tableProveedores;
import java.util.ArrayList;
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
    static DefaultTableModel modelotableProoveedores = new DefaultTableModel(); 
    static JTable TableDetalle;
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    public static void setPlaceHolders(JTextField txtNombre, JTextArea txtDescripcion, JTextField txtBuscar)
    {
        TextPrompt placeholderNombre = new TextPrompt(" Ingrese el nombre del producto ", txtNombre);
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese la descripción del producto ", txtDescripcion);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }

    public static Boolean MantenimientoProducto(String accion, Integer id,
            String nombre, String descripcion, String stockmaximo , String stockminimo, 
            String estado,Integer id_categoria ,
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
                    mntError = CatalogoProductoController.insertarProducto(
                            trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                            trimmedStockMinimo, id_categoria);
                break;
                
                case "editar":   
                    mntError = CatalogoProductoController.editarProducto(id, 
                            trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                            trimmedStockMinimo, id_categoria, estado);              
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false);
    }
    
    public static void QuitarTablePSeleccionados(Integer ProId)
    {
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        for(int i = 0; i < model.getRowCount(); i++  )
        {
            if(ProId == model.getValueAt(i, 0)){
                model.removeRow(i);
            }  
        }
    }
    
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();

        boolean rp= false;  
        for(int i =0 ; i<model.getRowCount();i++)
        {
            if(model.getValueAt(i, 0) == dataRow[0] )
            {
                rp=true;
            }
        }
        if(rp==false)
        {
            model.addRow(dataRow); 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Proveedor ya seleccionado.");
        }     
    }   
     
    public static void ProductosProveedores(JTable tableDetalleProducto,Integer PrdId)
    {
        DefaultTableModel modelo = (DefaultTableModel) tableDetalleProducto.getModel(); 
        modelo.setRowCount(0);
        ArrayList<DetalleCatalogoProductosModel> detalleproductos = new ArrayList<>();
        detalleproductos = CatalogoProductoConexion.getDetalleProducto(PrdId);
        for (int i = 0; i<detalleproductos.size(); i++)
        {
              
             modelo.addRow
            (new Object[]
                {
                    detalleproductos.get(i).getProId(), 
                    detalleproductos.get(i).getProRTN(),
                    detalleproductos.get(i).getProNombre()
                }
            );
        }
        FormatoTabla(tableDetalleProducto, modelo.getColumnCount());
    }
    
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableProductos, 
            JTextField txtNombre,JTextArea txtDescripcion, JTextField txtStockMaximo,
            JTextField txtStockMinimo,JComboBox cmbCategoria,JComboBox cmbEstado )
    {
        Integer PrdId = null;
        PrdId = Integer.parseInt((String.valueOf(tableProductos.getModel().getValueAt(seleccion, 0)))); 
        txtNombre.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 1)));
        txtDescripcion.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 2)));
        txtStockMaximo.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 3)));
        txtStockMinimo.setText(String.valueOf(tableProductos.getModel().getValueAt(seleccion, 4)));
        cmbCategoria.setSelectedItem(String.valueOf(tableProductos.getModel().getValueAt(seleccion,6)));
        cmbEstado.setSelectedItem(String.valueOf(tableProductos.getModel().getValueAt(seleccion,7)));
        
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
    

    public static void LlenarTableProductos(JTable tableProductos, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tableProductos.getModel(); 
        modelo.setRowCount(0);
        Estados estados = new Estados();
        ArrayList<CatalogoProductoModel> productos = new ArrayList<>();
        productos = CatalogoProductoConexion.ListadoProducto(accion);
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
                    estados.getEstadoKey(productos.get(i).getProdEstado())    
                }
            );
        } 
        FormatoTabla(tableProductos, modelo.getColumnCount());
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
    
    public static Integer setDatosEditarFromCache(JTable tableProveedores, 
            JTextField txtNombre, JTextArea txtDescripcion, 
            JTextField txtStockMaximo, JTextField txtStockMinimo,JComboBox cmbCategoria,
            JComboBox cmbEstado)
    {
        Integer PrdId = null;
        CatalogoProductoCache productoCache = new CatalogoProductoCache();
        Estados estados = new Estados();
        if(productoCache.isDatosCompartidos())
        {
            PrdId = productoCache.getProducto().getPrdId();
            txtNombre.setText(productoCache.getProducto().getPrdNombre());
            txtDescripcion.setText(productoCache.getProducto().getPrdDescripcion());
            txtStockMaximo.setText(productoCache.getProducto().getPrdStockMaximo());
            txtStockMinimo.setText(productoCache.getProducto().getPrdStockMinimo());
            cmbCategoria.setSelectedItem(productoCache.getProducto().getCprDescripcion());
            cmbEstado.setSelectedItem(estados.getEstadoKey(productoCache.getProducto().getProdEstado()));
            CatalogoProductoController.ProductosProveedores(MantenimientoCatalogoProductosView.tableProveedores, PrdId);
        }
        return PrdId;
    }
        
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    private static boolean insertarProducto(String trimmedNombre,String trimmedDescripcion,
            String trimmedStockMaximo, String trimmedStockMinimo, 
            Integer id_categoria)
    {
        Estados estados = new Estados();
        boolean error = false;
        Integer id = 0; 
        Integer estado = estados.getValueEstado("Activo");
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        CatalogoProductoCache cache = new CatalogoProductoCache();
        DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel();
        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria, estado);
         System.out.println(productoModel.getProdEstado());
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("insertar", productoModel);    
       
        switch (resultado) 
        {
            case "OK":  
                cache.setPrdId(CatalogoProductoConexion.UltimoPrdId());
                if(MantenimientoProveedor("insertar",0,cache.getPrdId(),model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los proveedores.");
                }       
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
    
    private static boolean editarProducto(Integer id,String trimmedNombre,
            String trimmedDescripcion, String trimmedStockMaximo,String trimmedStockMinimo,
            Integer id_categoria, String estado)
    {
        Estados estados = new Estados();
        boolean error = false; 
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        Integer est = estados.getValueEstado(estado);
        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria, est);
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("editar", productoModel);
        switch (resultado) 
        {
            case "OK":   
                if(MantenimientoProveedor("editar",0,id,model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Producto editado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los proveedores.");
                }      
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
            Integer id_categoria,Integer estado)
    {
        Estados estados = new Estados();
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        productoModel.setPrdId(id);
        productoModel.setPrdNombre(trimmedNombre);
        productoModel.setPrdDescripcion(trimmedDescripcion);
        productoModel.setPrdStockMaximo(trimmedStockMaximo);
        productoModel.setPrdStockMinimo(trimmedStockMinimo);
        productoModel.setProdEstado(estado);       
        productoModel.setCprId(id_categoria);
        
        return productoModel;
    }   
    
    private static boolean validacionesGenerales(String trimmedNombre,String trimmedDescripcion,
        String trimmedStockMaximo, String trimmedStockMinimo, JLabel errNombre, JLabel errDescripcion,
        JLabel errStockMaximo, JLabel errStockMinimo)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedNombre))
        {
           errNombre.setText("El nombre es un campo obligatorio");
           error = true;
        }
                
        if(Validaciones.validarCampoVacio(trimmedDescripcion))
        {
           errDescripcion.setText("La descripción es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedStockMaximo))
        {
           errStockMaximo.setText("El stock máximo ingresado es incorrecto");
           error = true;
        }
        if(!Validaciones.validarStocks(trimmedStockMaximo,trimmedStockMinimo ))
        {
           errStockMinimo.setText("El stock máximo es menor que el stock mínimo");
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
      /*  if(Validaciones.validarTabla(MantenimientoCatalogoProductosView.tableProveedores)==true)
        {
            JOptionPane.showMessageDialog(null,"Error la tabla proveedores está vacía");
            error = true;
        } */
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
   
    private static Boolean MantenimientoProveedor(String accion, Integer id, 
            Integer PrdId, DefaultTableModel modelosTproveedores)
    {
  
        boolean error = false;
        DetalleCatalogoProductosModel detalleproductomodel = new DetalleCatalogoProductosModel();        
        switch(accion)
        {
            case "insertar":
                error = false;
                for(int i=0; i<modelosTproveedores.getRowCount(); i++)
                {
                    detalleproductomodel.setDcpId(0);
                    detalleproductomodel.setPrdId(PrdId);
                    detalleproductomodel.setProId(Integer.parseInt(String.valueOf( modelosTproveedores.getValueAt(i, 0))));
                    String estado = CatalogoProductoConexion.MantenimientoDetalleCatalogoProductos(accion, detalleproductomodel);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
            break;
            
            case "editar":   
                DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel(); 
                error = false;
                for(int i=0; i<detalleproducto.getAllDcpId().size(); i++)
                {
                    detalleproductomodel.setDcpId(detalleproducto.getAllDcpId().get(i));
                    detalleproductomodel.setPrdId(0);
                    detalleproductomodel.setProId(0);
                    String estado = CatalogoProductoConexion.MantenimientoDetalleCatalogoProductos("eliminar", detalleproductomodel);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
                if(!error)
                {
                    for(int i=0; i<modelosTproveedores.getRowCount(); i++)
                    {
                        detalleproductomodel.setDcpId(0);
                        detalleproductomodel.setPrdId(PrdId);
                        detalleproductomodel.setProId(Integer.parseInt(String.valueOf( modelosTproveedores.getValueAt(i, 0)))); 
                        String estado = CatalogoProductoConexion.MantenimientoDetalleCatalogoProductos(accion, detalleproductomodel);
                        if(!estado.equals("OK"))
                        {
                            error = true;
                        }
                    }
                    
                }                
            break;
        }
        
        return error;
    }  
}
