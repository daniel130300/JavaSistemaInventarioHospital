/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;


import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.CatalogoProductoConexion;
import Models.Conexion.ProveedorConexion;
import Models.Models.CatalogoProductoModel;
import Models.Models.CategoriasModel;
import Models.Models.DetalleCatalogoProductosModel;
import Models.Models.ProveedorModel;
import Models.Models.UnidadesModel;
import Utils.Cache.CatalogoProductoCache;
import Utils.Cache.ProveedorCache;
import Utils.Validators.Validaciones;
import Views.Mantenimientos.MantenimientoCatalogoBodegaView;
import static Views.Mantenimientos.MantenimientoCatalogoBodegaView.tableProveedores;
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

                        mntError = CatalogoProductoController.insertarProducto(
                                trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                                trimmedStockMinimo, id_categoria, id_unidad);
                    
                break;
                
                case "editar":
                        mntError = CatalogoProductoController.editarProducto(id, 
                                trimmedNombre, trimmedDescripcion, trimmedStockMaximo, 
                                trimmedStockMinimo, id_categoria, id_unidad, estado);              
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false);
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
    
    private static boolean insertarProducto(String trimmedNombre,String trimmedDescripcion,
            String trimmedStockMaximo, String trimmedStockMinimo, 
            Integer id_categoria, Integer id_unidad)
    {
        boolean error = false;
        Integer id = 0; 
        String estado = "Activo";
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();
        CatalogoProductoCache cache = new CatalogoProductoCache();
        DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel();
        
        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria,id_unidad, estado);
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("insertar", productoModel);      
       switch (resultado) 
        {
            case "OK":
                JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");    
                cache.setPrdId(CatalogoProductoConexion.UltimoPrdId());
                if(MantenimientoProveedor("insertar",0,cache.getPrdId(),model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Producto ingresado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los Proveedores.");
                }       
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
    
    
    private static boolean editarProducto(Integer id,String trimmedNombre,
            String trimmedDescripcion, String trimmedStockMaximo,String trimmedStockMinimo,
            Integer id_categoria, Integer id_unidad, String estado)
    {
        boolean error = false; 
        CatalogoProductoModel productoModel = new CatalogoProductoModel();
        DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();

        productoModel = CatalogoProductoController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion,trimmedStockMaximo,
                trimmedStockMinimo, id_categoria,id_unidad, estado);
        String resultado = CatalogoProductoConexion.MantenimientoCatalogoProducto("editar", productoModel);
        switch (resultado) 
        {
            case "OK":   
                if(MantenimientoProveedor("editar",0,id,model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Producto editar con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los Proveedores.");
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
    public static Integer setDatosEditarFromCache(JTable tableProveedores, 
            JTextField txtNombre, JTextArea txtDescripcion, 
            JTextField txtStockMaximo, JTextField txtStockMinimo,JComboBox cmbCategoria,
            JComboBox cmbUnidad, JComboBox cmbEstado)
    {
        Integer PrdId = null;
        CatalogoProductoCache productoCache = new CatalogoProductoCache();
        if(productoCache.isDatosCompartidos())
        {
            PrdId = productoCache.getProducto().getPrdId();
            txtNombre.setText(productoCache.getProducto().getPrdNombre());
            txtDescripcion.setText(productoCache.getProducto().getPrdDescripcion());
            txtStockMaximo.setText(productoCache.getProducto().getPrdStockMaximo());
            txtStockMinimo.setText(productoCache.getProducto().getPrdStockMinimo());
            cmbCategoria.setSelectedItem(productoCache.getProducto().getCprDescripcion());
            cmbUnidad.setSelectedItem(productoCache.getProducto().getUndDescripcion());
            cmbEstado.setSelectedItem(productoCache.getProducto().getProdEstado());
            CatalogoProductoController.ProductosProveedores(MantenimientoCatalogoBodegaView.tableProveedores, PrdId);
        }
        return PrdId;
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
        if(Validaciones.validarTabla(MantenimientoCatalogoBodegaView.tableProveedores)==true)
        {
            JOptionPane.showMessageDialog(null,"Error Tabla Proveedores vacía");
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

    public static void AddRowToJTable(Object[] dataRow){
          DefaultTableModel model =(DefaultTableModel) tableProveedores.getModel();

          boolean rp= false;
          System.out.println(dataRow[0]);     
          for(int i =0 ; i<model.getRowCount();i++){
               System.out.println(model.getValueAt(i, 0));
              if(model.getValueAt(i, 0) == dataRow[0] ){
                  rp=true;
              }
          }
          if(rp==false)
          {
            model.addRow(dataRow); 
          }else{
              JOptionPane.showMessageDialog(null,"Proveedor ya seleccionado");
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
