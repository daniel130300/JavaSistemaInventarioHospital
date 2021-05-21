/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.KitConexion;
import Models.Models.CatalogoProductoModel;
import Models.Models.KitModel;
import Models.Models.UnidadesModel;
import Utils.Cache.kitCache;
import Utils.Estados.Estados;
import Utils.PlaceHolders.TextPrompt;
import Utils.Validators.Validaciones;
import Views.Mantenimientos.MantenimientoKitsView;
import static Views.Mantenimientos.MantenimientoKitsView.tableProducto;
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
public class KitController {

    public static void setPlaceHolders(JTextField txtNombreKit, JTextArea txtDescripcion, JTextField txtCantidad)
    {
        TextPrompt placeholderFactura = new TextPrompt(" Ingrese el nombre de Kit ", txtNombreKit);
        TextPrompt placeholderNombre = new TextPrompt(" Ingrese la una descrición ", txtDescripcion);
        TextPrompt placeholderCorreo = new TextPrompt(" Ingrese un numero Ej: 2,5,6  ", txtCantidad);
    }    
    
    public static Boolean MantenimientoKit(String accion, Integer id,
            String nombre, String descripcion,String estado, String cantidad,
            JLabel errnombre, JLabel errdescripcion , JLabel errCantidad )
    { 
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        KitController.setErroresToNull(errnombre, errdescripcion);
        String trimmedNombre = nombre.trim();
        String trimmedDescripcion = descripcion.trim();
        String trimmedCantidad = cantidad.trim();
        generalValidacionError = KitController.validacionesGenerales( trimmedNombre, 
               trimmedDescripcion,trimmedCantidad ,errnombre, errdescripcion, errCantidad);
        
        if(generalValidacionError == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    mntError = KitController.insertarKit(
                            trimmedNombre, trimmedDescripcion);
                break;
                
                case "editar":   
                    mntError = KitController.editarKit(id, 
                            trimmedNombre, trimmedDescripcion, estado);            
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false);
    }

    public static void LlenarCmbUnidades(JComboBox CmbUnidades)
    {
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        unidades = KitConexion.ListadoUnidades();
        
        for (int i = 0; i<unidades.size(); i++)
        {
            CmbUnidades.addItem(unidades.get(i).getUndDescripcion());
        }
    }
    public static void LlenarCmbProducto(JComboBox CmbProducto)
    {
        ArrayList<CatalogoProductoModel> productos = new ArrayList<>();
        productos = KitConexion.ListadoProducto();
        
        for (int i = 0; i<productos.size(); i++)
        {
            CmbProducto.addItem(productos.get(i).getPrdNombre());
        }
    }
    
    
    public static void AgregarProducto(Object[] dataRow,JTable tableProducto, JLabel lblErrorCantidad, JTextField txtCantidad )
    {
        DefaultTableModel model =(DefaultTableModel) tableProducto.getModel();

        boolean err = false;
        boolean rp= false;  
        if(!Validaciones.validarNumeros(dataRow[4].toString()))
        {
           lblErrorCantidad.setText("La cantidad es un campo numerico");
           err = true;
        } 
        if(Validaciones.validarCampoVacio(dataRow[4].toString()))
        {
           lblErrorCantidad.setText("La cantidad es un campo obligatorio");
           err = true;
        }
        if(!Validaciones.validarmayor0(dataRow[4].toString()))
        {
           lblErrorCantidad.setText("La cantidad debe ser mayo a 0");
           err = true;
        }

        if(err == false)
        {
           for(int i =0 ; i<model.getRowCount();i++)
           {

                   if(model.getValueAt(i, 0) == dataRow[0] )
                   {
                       rp=true;
                   }            

           }       
        }
        
        if(err == false)
        {
            if(rp==false)
            {
                model.addRow(dataRow); 
                lblErrorCantidad.setText(null);
                txtCantidad.setText(null);
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Producto ya seleccionado.");
            }         
        }
    
    }
   public static void QuitarTableProSeleccionados( Integer PrdId )
    {
        System.out.println(PrdId);
        DefaultTableModel model =(DefaultTableModel) tableProducto.getModel();
        for(int i = 0; i < model.getRowCount(); i++  )
        {
            if(PrdId == model.getValueAt(i, 0)){
                model.removeRow(i);
            }  
        }
    }
    public static Integer setDatosEditarFromCache(JTable tableKit,JTextField txtNombre,
                JTextArea txtDescripcion, JComboBox cmbEstado)
    {
        Integer KitId = null;
        kitCache kCache = new kitCache();
        Estados estados = new Estados();
        if(kCache.isDatosCompartidos())
        {
            KitId = kCache.getKit().getKitId();
            txtNombre.setText(kCache.getKit().getKitNombre());
            txtDescripcion.setText(kCache.getKit().getKitDescripcion());
            cmbEstado.setSelectedItem(estados.getEstadoKey(kCache.getKit().getKitEstado()));
            KitController.LlenarTableDetalleKit(KitId);
            
        }
        return KitId;
    }
    private static boolean insertarKit(String trimmedNombre,String trimmedDescripcion)
    {
        Estados estados = new Estados();
        boolean error = false;
        Integer id = 0; 
        Integer estado = estados.getValueEstado("Activo");
        KitModel kitModel = new KitModel();
        kitCache cache = new kitCache();
        DefaultTableModel model =(DefaultTableModel) tableProducto.getModel();
        kitModel = KitController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion, estado);
        String resultado = KitConexion.MantenimientoKits("insertar", kitModel); 

        switch (resultado) 
        {
            case "OK":  
                cache.setKitId(KitConexion.UltimoKitId());
                if(MantenimientoDetalleKit("insertar",0,cache.getKitId(),model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Kit ingresado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los proveedores.");
                }     
            break;
            
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El kit ya se encuentra registrado.");
                error = true;
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static boolean editarKit(Integer id,String trimmedNombre,
            String trimmedDescripcion, String estado)
    {
        Estados estados = new Estados();
        boolean error = false; 
        KitModel kitModel = new KitModel();
        DefaultTableModel model =(DefaultTableModel) tableProducto.getModel();
        Integer est = estados.getValueEstado(estado);
        kitModel = KitController.setProductoModel(id, 
                trimmedNombre, trimmedDescripcion, est);
        String resultado = KitConexion.MantenimientoKits("editar", kitModel);
        switch (resultado) 
        {
            case "OK":   
; 
                if(MantenimientoDetalleKit("editar",0,id,model ) == false)
                {
                    JOptionPane.showMessageDialog(null, "Kit editado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error al editar los productos.");
                }      
            break;
            case "errNombre":
                JOptionPane.showMessageDialog(null, "El Kit ya se encuentra registrado.");
                error = true;
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        return error;
    }
    private static KitModel setProductoModel(Integer id,String trimmedNombre,
            String trimmedDescripcion,Integer estado)
    {
        Estados estados = new Estados();
        KitModel kitModel = new KitModel();
        kitModel.setKitId(id);
        kitModel.setKitNombre(trimmedNombre);
        kitModel.setKitDescripcion(trimmedDescripcion);
        kitModel.setKitEstado(estado); 
        
        return kitModel;
    } 
    
    private static boolean validacionesGenerales(String trimmedNombre,String trimmedDescripcion,String trimmedCantidad,
        JLabel errNombre, JLabel errDescripcion, JLabel errCantidad )
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
        if(Validaciones.validarTabla(MantenimientoKitsView.tableProducto)==true)
        {
            JOptionPane.showMessageDialog(null,"Error la tabla producto está vacía");
            error = true;
        } 
        
        return error;
    }      
        
    private static void setErroresToNull(JLabel errnombre, JLabel errdescripcion)
    {
        errnombre.setText(null);
        errdescripcion.setText(null);

    } 
    public static void LlenarTableKit(JTable tableKit, String accion) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tableKit.getModel(); 
        modelo.setRowCount(0);
        Estados estados = new Estados();
        ArrayList<KitModel> kits = new ArrayList<>();
        kits = KitConexion.ListadoKit(accion);
        for (int i = 0; i <kits.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    kits.get(i).getKitId(), 
                    kits.get(i).getKitNombre(),
                    kits.get(i).getKitDescripcion(),
                    estados.getEstadoKey(kits.get(i).getKitEstado())    
                }
            );
        } 
        FormatoTabla(tableKit, modelo.getColumnCount());
    }
    public static void LlenarTableDetalleKit(Integer id) 
    {  
        
        DefaultTableModel modelo = (DefaultTableModel) tableProducto.getModel(); 
        modelo.setRowCount(0);
        Estados estados = new Estados();
        ArrayList<KitModel> kits = new ArrayList<>();
        kits = KitConexion.ListadoProductos(id);
        for (int i = 0; i <kits.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    kits.get(i).getPrdId(), 
                    kits.get(i).getPrdNombre(),
                    kits.get(i).getUndId(),
                    kits.get(i).getUndDescripcion(),
                    kits.get(i).getDtkcCantidad(),              
                }
            );
        } 
        FormatoTabla(tableProducto, modelo.getColumnCount());
    }
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableKits, 
            JTextField txtNombre,JTextArea txtDescripcion, JComboBox cmbEstado )
    {
        Integer KidId = null;
        KidId = Integer.parseInt((String.valueOf(tableKits.getModel().getValueAt(seleccion, 0)))); 
        txtNombre.setText(String.valueOf(tableKits.getModel().getValueAt(seleccion, 1)));
        txtDescripcion.setText(String.valueOf(tableKits.getModel().getValueAt(seleccion, 2)));
        cmbEstado.setSelectedItem(String.valueOf(tableKits.getModel().getValueAt(seleccion,3))); 
        return KidId;
    }
        public static void FiltroTableProducto(JTable tableKit, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableKit.getModel());
        tableKit.setRowSorter(rowSorter);
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
        
    private static Boolean MantenimientoDetalleKit(String accion, Integer id, 
            Integer KitId, DefaultTableModel Kittmodel)
    {
  
        boolean error = false;
        KitModel kitmodel = new KitModel();        
        switch(accion)
        {
            case "insertar":
                error = false;
                for(int i=0; i<Kittmodel.getRowCount(); i++)
                {
                    kitmodel.setDtkId(0);
                    kitmodel.setKitId(KitId);
                    kitmodel.setPrdId(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 0))));
                    kitmodel.setUndId(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 2))));
                    kitmodel.setDtkcCantidad(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 4))));
                    
                    String estado = KitConexion.MantenimientoDetalleKits(accion, kitmodel);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
            break;
            
            case "editar":   
                error = false;
                KitModel kitModel = new KitModel();
                for(int i=0; i<kitModel.getAllDtId().size(); i++)
                {
                    kitmodel.setDtkId(kitModel.getAllDtId().get(i));
                    kitmodel.setKitId(0);
                    kitmodel.setPrdId(0);
                    kitmodel.setUndId(0);
                    kitmodel.setDtkcCantidad(0);
                    String estado = KitConexion.MantenimientoDetalleKits("eliminar", kitmodel);       
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
                if(!error)
                {
                    for(int i=0; i<Kittmodel.getRowCount(); i++)
                    {
                    kitmodel.setDtkId(0);
                    kitmodel.setKitId(KitId);
                    kitmodel.setPrdId(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 0))));
                    kitmodel.setUndId(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 2))));
                    kitmodel.setDtkcCantidad(Integer.parseInt(String.valueOf( Kittmodel.getValueAt(i, 4))));
                    String estado = KitConexion.MantenimientoDetalleKits(accion, kitmodel);     
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
