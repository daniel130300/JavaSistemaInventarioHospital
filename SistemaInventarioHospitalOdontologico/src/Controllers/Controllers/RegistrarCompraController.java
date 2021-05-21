/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.ComprasConexion;
import Models.Models.ComprasModel;
import Models.Models.InventarioPadreModel;
import Models.Models.ProveedorModel;
import Utils.PlaceHolders.TextPrompt;
import Utils.Validators.Validaciones;
import static Views.Mantenimientos.RegistrarCompraView.tableDetalleCompra;
import static Views.Mantenimientos.RegistrarCompraView.lblUsuarioActual;
import java.io.File;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegistrarCompraController 
{
       
    public static void setPlaceHolders(JTextField txtNumeroFactura, JTextField txtNumeroTransferencia, JTextField txtNumeroOrden,
            JTextField txtNombreProducto, JTextField txtCantidad, JTextField txtPrecio)
    {
        TextPrompt placeholderFactura = new TextPrompt(" Ingrese el número de la factura ", txtNumeroFactura);
        TextPrompt placeholderNombre = new TextPrompt(" Ingrese el número de transferencia ", txtNumeroTransferencia);
        TextPrompt placeholderCorreo = new TextPrompt(" Ingrese número de la orden de compra ", txtNumeroOrden);
        TextPrompt placeholderNombreProducto = new TextPrompt(" Seleccione un producto ", txtNombreProducto);
        TextPrompt placeholderContacto = new TextPrompt(" Ingrese la cantidad ", txtCantidad);
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese el precio ", txtPrecio);
    }
    
    public static Boolean MantenimientoProducto(String accion, Integer id,
            String proveedor, String nfactura, String ffactura , String ntransferencia, 
            String ncompra,String forden, JLabel errnfactura, JLabel errffactura,
            JLabel errntransferencia, JLabel errncompra,JLabel errforden )
    { 
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        RegistrarCompraController.setErroresToNull(errnfactura, errffactura, errntransferencia, errncompra,errforden);
        String trimmedNfactura = nfactura.trim();
        String trimmedNtransferencia = ntransferencia.trim();
        String trimmedNcompra = ncompra.trim();
        generalValidacionError = RegistrarCompraController.validacionesGenerales( trimmedNfactura, ffactura,
                                trimmedNtransferencia,trimmedNcompra, forden, errnfactura,errffactura,
                                errntransferencia, errncompra,errforden);
        
        if(generalValidacionError == false)
        {            
            switch(accion)
            {
                case "insertar":
                    mntError = RegistrarCompraController.insertarCompra(
                            proveedor, nfactura, ffactura, 
                            ntransferencia, ncompra,forden );
                break;
               
            }
        }
        
        return !(mntError == false && generalValidacionError == false);
    }
     private static boolean insertarCompra(String proveedor,String nfactura,
            String ffactura,String ntransferencia,String ncompra, String forden)
    {
        boolean error = false;
        ComprasModel compra = new ComprasModel();
        DefaultTableModel model =(DefaultTableModel) tableDetalleCompra.getModel();        
        compra = RegistrarCompraController.setProductoModel(proveedor, nfactura,ffactura,
                ntransferencia, ncompra, forden);
  
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
             .build();
           MediaType mediaType = MediaType.parse("text/plain");
           RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
             .addFormDataPart("ProId",String.valueOf(compra.getInvPrdId()))
             .addFormDataPart("CmpFactura",compra.getCmpFactura())
             .addFormDataPart("CmpFotoFactura",compra.getCmpFotoFacturaPath(),
               RequestBody.create(MediaType.parse("application/octet-stream"),
               new File(compra.getCmpFotoFacturaPath())))
             .addFormDataPart("CmpNumeroTransferencia",compra.getCmpNumeroTransferencia())
             .addFormDataPart("CmpFotoOrden",compra.getCmpFotoOrdenCompraPath(),
               RequestBody.create(MediaType.parse("application/octet-stream"),
               new File(compra.getCmpFotoOrdenCompraPath())))
             .addFormDataPart("UsrUsuario",lblUsuarioActual.getText())
             .addFormDataPart("CmpOrdenCompra", compra.getCmpOrdenCompra())
             .build();
           Request request = new Request.Builder()
             .url("https://api.negocios.cointla.net/api/compras/insertar.php")
             .method("POST", body)
             .build();
           Response response = client.newCall(request).execute(); 
           error = MantenimientoDetalleCompras("insertar",model);
           if(error == false)
            {
               JOptionPane.showMessageDialog(null, "Compra ingresado con éxito.");    
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error ingresando los productos.");
            }                  
           }catch (Exception  ex)
           {
               System.out.println(ex);
           }       
        return error;
    } 

    private static Boolean MantenimientoDetalleCompras(String accion, DefaultTableModel compraModel)
    {
        Integer im=0;
        boolean error = false;
        ComprasModel compramodel = new ComprasModel();
        switch(accion)
        {
            case "insertar":
                error = false;
                for(int i=0; i<compraModel.getRowCount(); i++)
                {
                    compramodel.setDtcId(0);
                    compramodel.setCmpId(0);
                    compramodel.setDtcEstado(1);
                    compramodel.setInvPrdId(ComprasConexion.IdInvP(String.valueOf( compraModel.getValueAt(i, 0))));
                    compramodel.setDtcCantidad(Integer.parseInt(String.valueOf( compraModel.getValueAt(i, 1))));          
                    if(String.valueOf( compraModel.getValueAt(i, 2)).equals("Si")){im=1;}else{im=0;}                   
                    compramodel.setDtcTieneImpuesto(im);                  
                    compramodel.setDtcPrecioCompra(Double.parseDouble(String.valueOf( compraModel.getValueAt(i, 3))));
                    
                    String estado = ComprasConexion.MantenimientoCompras(accion, compramodel);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
            break;
            
        }
        
        return error;
    }       
     
    private static ComprasModel setProductoModel(String proveedor,
            String nfactura, String ffactura,String ntransferencia, String ncompra,
            String forden)
    {
        ComprasModel compra = new ComprasModel();
        compra.setCmpId(0);
        compra.setInvPrdId(ComprasConexion.IdProveedor(proveedor));
        compra.setCmpFactura(nfactura);
        compra.setCmpFotoFacturaPath(ffactura);
        compra.setCmpNumeroTransferencia(ntransferencia);
        compra.setCmpOrdenCompra(ncompra);
        compra.setCmpFotoOrdenCompraPath(forden);         
        return compra;
    }       
     
     private static boolean validacionesGenerales(String trimmedNfactura,String ffactura,
        String trimmedNtransferencia, String trimmedNcompra, String forden, JLabel errnfactura,
        JLabel errffactura, JLabel errntransferencia, JLabel errncompra, JLabel errforden)
    {
        boolean error = false;

        if(!Validaciones.validarNumeros(trimmedNfactura))
        {
           errnfactura.setText("Es un campo numerico obligatorio");
           error = true;
        }

        if(!Validaciones.validarNumeros(trimmedNtransferencia))
        {
           errntransferencia.setText("Es un campo numerico obligatorio");
           error = true;
        }

        if(!Validaciones.validarNumeros(trimmedNcompra))
        {
           errncompra.setText("Es un campo numerico obligatorio");
           error = true;
        }
        
        
        if(Validaciones.validarCampoVacio(trimmedNfactura))
        {
           errnfactura.setText("Es un campo obligatorio");
           error = true;
        }
                
        if(Validaciones.validarCampoVacio(ffactura))
        {
           errffactura.setText("Es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedNtransferencia))
        {
           errntransferencia.setText("Es un campo obligatorio");
           error = true;
        }
        if(Validaciones.validarCampoVacio(trimmedNcompra))
        {
           errncompra.setText("Es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(forden))
        {
           errforden.setText("Es un campo obligatorio");
           error = true;
        }        
        if(Validaciones.validarTabla(tableDetalleCompra))
        {
           JOptionPane.showMessageDialog(null, "Tabla de compras vacia");
           error = true;
        }
        return error;
    }       

    public static Double CalcularSubTotal (String Imp, Integer Cantidad, Double Precio)
    {
        System.out.println("llego 1");
        Double SubTotal;
        Double Isv = 0.00;
        SubTotal = Cantidad* Precio;
        if(Imp.equals("Si") )
        {
            Isv = SubTotal * 0.15;
             
        }
        else
        {
            Isv = 0.00;
        }
        return SubTotal + Isv ;
        
        
    } 
     
     
    
    public static void LlenarCmbProveedor(JComboBox cmbProveedores)
    {
        ArrayList<ProveedorModel> proveedor = new ArrayList<>();
        proveedor = ComprasConexion.ListadoProveedores();
        
        for (int i = 0; i<proveedor.size(); i++)
        {
            cmbProveedores.addItem(proveedor.get(i).getProNombre());
        }
    }     

    public static Boolean AgregarProducto(String nombre, String Cantidad, String impuesto , String Precio, 
            JLabel errcantidad, JLabel errprecio,JLabel errorSeleccionarProducto)
    { 
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        RegistrarCompraController.setErroresToNull1(errcantidad, errprecio,errorSeleccionarProducto);
        String trimmedPrecio= Precio.trim();
        String trimmedCantidad = Cantidad.trim();
        generalValidacionError = RegistrarCompraController.validacionesGenerales1(nombre, trimmedPrecio, 
               trimmedCantidad, errcantidad , errprecio,errorSeleccionarProducto);
        System.out.println(generalValidacionError);
        if(generalValidacionError == false)
        {
            mntError = RegistrarCompraController.AddRowToJTable(new Object[]{nombre ,trimmedCantidad ,impuesto,trimmedPrecio });      
        }
        return !(mntError == false && generalValidacionError == false);
    }
    
     
    private static boolean validacionesGenerales1(String nombre,String trimmedPrecio,String trimmedCantidad,
        JLabel  errcantidad , JLabel errprecio, JLabel errorseleccionarproducto)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trimmedPrecio))
        {
           errprecio.setText("El precio es un campo obligatorio");
           error = true;
        }

        if(Validaciones.validarCampoVacio(nombre))
        {
           errorseleccionarproducto.setText("El Producto es un campo obligatorio");
           error = true;
        }
                
        if(!Validaciones.validarNumerosDouble(trimmedPrecio))
        {
           errprecio.setText("El precio es un numerico con decimales");
           error = true;
        }          
        
        if(!Validaciones.validarNumeros(trimmedCantidad))
        {
           errcantidad.setText("La cantidad es un campo numerico entero");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedCantidad))
        {
           errcantidad.setText("La cantidad es un campo obligatorio");
           error = true;
        }
        return error;
    }    

    private static void setErroresToNull1(JLabel errcantidad, JLabel errprecio, JLabel errorSeleccionarProducto)
    {
        errcantidad.setText(null);
        errprecio.setText(null);
        errorSeleccionarProducto.setText(null);
    }   
       private static void setErroresToNull(JLabel errnfactura, JLabel errffactura, JLabel errorntransferencia,
               JLabel errncompra, JLabel errforden)
    {
        errnfactura.setText(null);
        errffactura.setText(null);
        errorntransferencia.setText(null);
        errncompra.setText(null);
        errforden.setText(null);
    }    
     public static void LlenarTableInventario(JTable tableInvetario) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tableInvetario.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioPadreModel> inventarios = new ArrayList<>();
        inventarios = ComprasConexion.ListadoInventario();
        for (int i = 0; i <inventarios.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    inventarios.get(i).getInvPId(), 
                    inventarios.get(i).getInvPCodInterno(),
                    inventarios.get(i).getInvPDescripcion()
 
                }
            );
        } 
        FormatoTabla(tableInvetario, modelo.getColumnCount());
    }     
    public static Boolean AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model =(DefaultTableModel) tableDetalleCompra.getModel();
        boolean rp= false;  
        for(int i =0 ; i<model.getRowCount();i++)
        {
            if( model.getValueAt(i,0).toString().replace(" ","").equals(dataRow[0].toString().replace(" ","")))
            {                
                rp=true;
            }
        }
        System.out.println(rp);
        if(rp==false)
        {
            model.addRow(dataRow);
            return false;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Producto ya ingresado.");
            return true;
        }     
    }       
    public static void QuitarTablePSeleccionados(String InvId, JTable tablainventario)
    {
        DefaultTableModel model =(DefaultTableModel) tablainventario.getModel();
        for(int i = 0; i < model.getRowCount(); i++  )
        {
            if(InvId == model.getValueAt(i, 0)){
                model.removeRow(i);
            }  
        }
    }     
    public static void FiltroTable(JTable table, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
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
    
}
