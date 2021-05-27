/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.Conexion;
import Models.Conexion.InventarioPadreConexion;
import Models.Models.InventarioPadreModel;
import Utils.Cache.InventarioPadreCache;
import Utils.Estados.Estados;
import Utils.PlaceHolders.TextPrompt;
import Utils.Validators.Validaciones;
import Views.Mantenimientos.MantenimientoInventarioBodegaView;
import static Views.Mantenimientos.MantenimientoInventarioBodegaView.txtKit;
import static Views.Mantenimientos.MantenimientoInventarioBodegaView.txtProducto;
import static Views.Mantenimientos.MantenimientoInventarioBodegaView.txtUnidadPadre;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class InventarioPadreController {
    
    public static Boolean generalValidacionError1 = true;
    //public static Boolean errorPadre = false;
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
     public static void setPlaceHoldersPadre(JTextField txtProducto, JTextArea txtDescripcionPadre, 
             JTextField txtFechaCaducidad, JTextField txtCantidadPadre, JTextField txtUnidadPadre, 
             JTextField txtKit, JTextField txtBuscar)
    {
        TextPrompt placeholderProducto = new TextPrompt(" Seleccione el Nombre del producto ", txtProducto);
        TextPrompt placeholderDescripcionPadre = new TextPrompt(" Ingrese la descripción del producto ", txtDescripcionPadre);
        TextPrompt placeholderFechaCaducidad = new TextPrompt(" Año/Mes/Día ", txtFechaCaducidad);
        TextPrompt placeholderCantidadPadre = new TextPrompt(" Ej: 24 ", txtCantidadPadre);
        TextPrompt placeholderUnidadPadre = new TextPrompt(" Seleccione el nombre de la Unidad ", txtUnidadPadre);
        TextPrompt placeholderKit = new TextPrompt(" Seleccione el nombre del Kit ", txtKit);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
     
      public static void setPlaceHolders(JTextArea txtDescripcion, JTextField txtCantidad,
              JTextField txtUnidad, JTextField txtBuscar)
    {
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese la descripción del producto ", txtDescripcion);
        TextPrompt placeholderCantidad = new TextPrompt(" Ej: 30 ", txtCantidad);
        TextPrompt placeholderUnidad = new TextPrompt(" Seleccione el nombre de la Unidad ", txtUnidad);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
    /**
     * 
     * @param accion String
     * @param Id Integer
     * @param Descripcion String
     * @param FechaCaducidad String
     * @param Cantidad String
     * @param Unidad String
     * @param Kit String
     * @param Producto String
     * @param errDescripcion JLabel
     * @param errFechaCaducidad JLabel
     * @param errCantidad JLabel
     * @param errUnidad JLabel
     * @param errKit JLabel
     * @param errProducto JLabel
     * Si los datos ingresados son incorrectos de acorde a las validaciones
     * retorna true, de lo contrario retorna false.
     * @return Boolean
     */
    /* public static Boolean MantenimientoInventarioPadre(String accion, 
            Integer Id, String Descripcion, String FechaCaducidad, String Cantidad, String Unidad,
            String Kit,String Producto,  JLabel errDescripcion, 
            JLabel errFechaCaducidad, JLabel errCantidad, JLabel errUnidad,
            JLabel errKit, JLabel errProducto)
    {
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        InventarioPadreController.setErroresToNull(errDescripcion, errFechaCaducidad, errCantidad, errUnidad, errKit, errProducto);  
        String trimmedDescripcion = Descripcion.trim();
        String trimmedFechaCaducidad = FechaCaducidad.trim();
        String trimmedCantidad = Cantidad.trim();
        String trinmedKit = Kit.trim();
        String trinmedUnidad = Unidad.trim();
        String trinmedProducto = Producto.trim();
        String Nomenclatura = "";
        String N = "Ninguno";
        
        generalValidacionError = InventarioPadreController.validacionesGenerales( trimmedDescripcion,
               trimmedFechaCaducidad, trimmedCantidad, trinmedUnidad, trinmedKit, trinmedProducto,
               errDescripcion, errFechaCaducidad, errCantidad, errUnidad, errKit, errProducto );    
        
        if(trinmedProducto.compareTo(N)==0){
           Nomenclatura = "KIT";
        }else{
           Nomenclatura = InventarioPadreConexion.getNomenclaturaProducto(trinmedProducto);
        }
        Integer UndId = InventarioPadreConexion.getIdUnidad(trinmedUnidad);
        String CorrelativoUnidad = InventarioPadreController.Correlativo_UndId(UndId);
        String CorelativoInvPIdAgregar = InventarioPadreController.Correlativo_PrdPIdAgregar();
        String CorelativoInvPIdEditar = InventarioPadreController.Correlativo_PrdPIdEditar(Id);
        String trimmedCodigoInternoAgregar = Nomenclatura+"-"+CorrelativoUnidad+"-"+CorelativoInvPIdAgregar;
        String trimmedCodigoInternoEditar = Nomenclatura+"-"+CorrelativoUnidad+"-"+CorelativoInvPIdEditar;
        
        if(generalValidacionError == false)
        {
            
            switch(accion)
            {
                case "insertar":
                    mntError = InventarioPadreController.insertarProducto( trimmedCodigoInternoAgregar,
                            trimmedDescripcion, trimmedFechaCaducidad, Integer.parseInt(trimmedCantidad), 
                            trinmedUnidad, trinmedKit, trinmedProducto);
                break;
                
                case "editar":  
                    mntError = InventarioPadreController.editarProducto(Id, trimmedCodigoInternoEditar,
                            trimmedDescripcion, trimmedFechaCaducidad,Integer.parseInt(trimmedCantidad), 
                            trinmedUnidad, trinmedKit, trinmedProducto);              
                break;
            }
        }
        return !(mntError == false && generalValidacionError == false);
    }  */
     
     public static Boolean ValidacionInputsPadre(String Descripcion, 
            String FechaCaducidad, String Cantidad, String Unidad,
            String Kit,String Producto,  JLabel errDescripcion, 
            JLabel errFechaCaducidad, JLabel errCantidad, JLabel errUnidad,
            JLabel errKit, JLabel errProducto)
    {
        InventarioPadreController.setErroresToNull(errDescripcion, errFechaCaducidad, errCantidad, errUnidad, errKit, errProducto);  
        String trimmedDescripcion = Descripcion.trim();
        String trimmedFechaCaducidad = FechaCaducidad.trim();
        String trimmedCantidad = Cantidad.trim();
        String trinmedKit = Kit.trim();
        String trinmedUnidad = Unidad.trim();
        String trinmedProducto = Producto.trim();
        
        generalValidacionError1 = InventarioPadreController.validacionesGenerales( trimmedDescripcion,
               trimmedFechaCaducidad, trimmedCantidad, trinmedUnidad, trinmedKit, trinmedProducto,
               errDescripcion, errFechaCaducidad, errCantidad, errUnidad, errKit, errProducto );    

        return !(generalValidacionError1 == false);
    }
     
    public static boolean insertarProducto( 
            String Descripcion, String FechaCaducidad, String Cantidad, 
            String Unidad, String Kit, String Producto)
    {
        boolean error = false; 
        Integer Id = 0; 
        String trimmedDescripcion = Descripcion.trim();
        String trimmedFechaCaducidad = FechaCaducidad.trim();
        String trinmedKit = Kit.trim();
        String trinmedUnidad = Unidad.trim();
        String trinmedProducto = Producto.trim();
        String Nomenclatura = "";
        String N = "Ninguno";
        
         if(trinmedProducto.compareTo(N)==0){
           Nomenclatura = "KIT";
        }else{
           Nomenclatura = InventarioPadreConexion.getNomenclaturaProducto(trinmedProducto);
        }
        Integer UndId = InventarioPadreConexion.getIdUnidad(trinmedUnidad);
        String CorrelativoUnidad = InventarioPadreController.Correlativo_UndId(UndId);
        String CorelativoInvPIdAgregar = InventarioPadreController.Correlativo_PrdPIdAgregar();
        String trimmedCodigoInternoAgregar = Nomenclatura+"-"+CorrelativoUnidad+"-"+CorelativoInvPIdAgregar;;
        
        if(generalValidacionError1 == false)
        {
            InventarioPadreModel productoModel = new InventarioPadreModel();

            productoModel = InventarioPadreController.setProductoModel(Id, 
                     trimmedCodigoInternoAgregar, trimmedDescripcion, trimmedFechaCaducidad, 
                     Integer.parseInt(Cantidad), trinmedUnidad, trinmedKit, trinmedProducto);
            String resultado = InventarioPadreConexion.MantenimientoInventarioPadre("insertar", productoModel);    
            
            switch (resultado) 
            {
                case "OK":  
                        if(MantenimientoInventarioBodegaView.accion.equals(1)){
                            JOptionPane.showMessageDialog(null, "Producto Ingresado Correctamente."); 
                            System.out.println("Producto Ingresado Correctamente.");
                        }
                break;

                case "errProducto":
                    JOptionPane.showMessageDialog(null, "El Producto ya se encuentra registrado.");
                    error = true;
                break;
                
                 case "errRegistro":
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto o Kit diferente de ninguno");
                    error = true;
                break;

                case "errIngresar":
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto o Kit");
                    error = true;
                break;
                
                case "errKit":
                    JOptionPane.showMessageDialog(null, "El Kit ya se encuentra registrado.");
                    error = true;
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                    error = true;
                break;
            }
        }
        return !(error == false && generalValidacionError1 == false);
    }

     public static boolean editarProducto(Integer Id,
             String Descripcion,String FechaCaducidad, String Cantidad, 
             String Unidad, String Kit, String Producto)
    {

        boolean error = false; 
        String trimmedDescripcion = Descripcion.trim();
        String trimmedFechaCaducidad = FechaCaducidad.trim();
        String trinmedKit = Kit.trim();
        String trinmedUnidad = Unidad.trim();
        String trinmedProducto = Producto.trim();
        String Nomenclatura = "";
        String N = "Ninguno";
        
         if(trinmedProducto.compareTo(N)==0){
           Nomenclatura = "KIT";
        }else{
           Nomenclatura = InventarioPadreConexion.getNomenclaturaProducto(trinmedProducto);
        }
        Integer UndId = InventarioPadreConexion.getIdUnidad(trinmedUnidad);
        String CorrelativoUnidad = InventarioPadreController.Correlativo_UndId(UndId);
        String CorelativoInvPIdEditar = InventarioPadreController.Correlativo_PrdPIdEditar(Id);
        String trimmedCodigoInternoEditar = Nomenclatura+"-"+CorrelativoUnidad+"-"+CorelativoInvPIdEditar;

        if(generalValidacionError1 == false)
        {
            InventarioPadreModel productoModel = new InventarioPadreModel();

            productoModel = InventarioPadreController.setProductoModel(Id, trimmedCodigoInternoEditar,
                    trimmedDescripcion, trimmedFechaCaducidad, Integer.parseInt(Cantidad),
                    trinmedUnidad, trinmedKit, trinmedProducto);

            String resultado = InventarioPadreConexion.MantenimientoInventarioPadre("editar", productoModel);

            switch (resultado) 
            {
                case "OK":   
                    JOptionPane.showMessageDialog(null, "Producto editado con éxito.");       
                break;

                case "errProducto":
                    JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado.");
                    error = true;
                break;
                
                 case "errRegistro":
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto o Kit diferente de ninguno");
                    error = true;
                break;

                 case "errIngresar":
                    JOptionPane.showMessageDialog(null, "Seleccione un Producto o Kit");
                    error = true;
                break;
                
                case "errKit":
                    JOptionPane.showMessageDialog(null, "El Kit ya se encuentra registrado.");
                    error = true;
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                    error = true;
                break;
            }
        }
        return !(error == false && generalValidacionError1 == false);
    }
     
    public static Integer setDatosEditarFromTable(int seleccion, JTable tablePadre, 
            JTextArea txtDescripcion, JTextField txtFechaCaducidad,
            JTextField txtCantidad, JTextField txtUnidad,JTextField txtKit,
            JTextField txtProducto)
    {
        Integer InvPId = null;

            InvPId = Integer.parseInt(String.valueOf(tablePadre.getModel().getValueAt(seleccion, 0)));
            txtDescripcion.setText(String.valueOf(tablePadre.getModel().getValueAt(seleccion, 2)));
            txtFechaCaducidad.setText(String.valueOf(tablePadre.getModel().getValueAt(seleccion, 3)));
            txtCantidad.setText(String.valueOf(tablePadre.getModel().getValueAt(seleccion, 4)));
            txtUnidad.setText(String.valueOf(tablePadre.getModel().getValueAt(seleccion, 5)));
            txtKit.setText(InventarioPadreConexion.getNombreKit(Integer.parseInt(tablePadre.getModel().getValueAt(seleccion, 6).toString())));
            txtProducto.setText(InventarioPadreConexion.getNombreProducto(Integer.parseInt((tablePadre.getModel().getValueAt(seleccion, 8).toString()))));
            
        return InvPId;
    }
    
    private static InventarioPadreModel setProductoModel(Integer Id, String trinmedCodigoInterno, 
            String trinmedDescripcion, String trinmedFechaCaducidad, 
            Integer trinmedCantidad, String trinmedUnidad, String trinmedKit,
            String trinmedProducto)
    {
        InventarioPadreModel productoModel = new InventarioPadreModel();
        productoModel.setInvPId(Id);
        productoModel.setInvPCodInterno(trinmedCodigoInterno);
        productoModel.setInvPDescripcion(trinmedDescripcion);
        productoModel.setInvPFchCaducidad(trinmedFechaCaducidad);
        productoModel.setInvPCantidad(trinmedCantidad);
        productoModel.setUndDescripcion(trinmedUnidad);
        productoModel.setKitNombre(trinmedKit);
        productoModel.setPrdNombre(trinmedProducto);
        return productoModel;
    }
    
    public static Integer setDatosEditarFromCache(JTable tablePadre, 
            JTextArea txtDescripcion, JTextField txtFechaCaducidad,
            JTextField txtCantidad, JTextField txtUnidad,JTextField txtKit,
            JTextField txtProducto)
    {
        Integer InvPId = null;
        InventarioPadreCache productoCache = new InventarioPadreCache();
        Estados estados = new Estados();
        if(productoCache.isDatosCompartidos())
        {
            InvPId = productoCache.getId().getInvPId();
            txtDescripcion.setText(productoCache.getId().getInvPDescripcion());
            txtFechaCaducidad.setText(productoCache.getId().getInvPFchCaducidad());
            txtCantidad.setText(productoCache.getId().getInvPCantidad().toString());
            txtUnidad.setText(productoCache.getId().getUndDescripcion());
            txtKit.setText(productoCache.getId().getKitNombre());
            txtProducto.setText(productoCache.getId().getPrdNombre());
        }
        return InvPId;
    }
    
    
     public static void AddNombreProducto(Object[] dataRow)
    {
        
        txtProducto.setText(String.valueOf(dataRow[1]));
    }
     
    public static void AddNombreUnidad(Object[] dataRow)
    {
        txtUnidadPadre.setText(String.valueOf(dataRow[1])); 
 
    }
    
    public static void AddNombreKit(Object[] dataRow)
    {
        txtKit.setText(String.valueOf(dataRow[1]));
    }
     
    /**
     * 
     * @param tablePadre JTable
     * @param fieldBusqueda JTextField
     * Método que se encarga de filtrar la tabla tableBodega
     * a partir de la busqueda del Lote Producto.
     */
    public static void FiltroTableInventarioPadre(JTable tablePadre, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablePadre.getModel());
        tablePadre.setRowSorter(rowSorter);
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
      * @param tablePadre JTable
      * Método que se encarga de llenar el JTable tableBodega 
      * con los datos que se obtienen del método ListadoInventarioBodega() 
      * de la clase InventarioBodegaConexion dependiendo de la acción
      * que el usuario realice.
      */
    public static void LlenarTableInventarioPadre(JTable tablePadre)  
    {  
        DefaultTableModel modelo = (DefaultTableModel) tablePadre.getModel(); 
        modelo.setRowCount(0);
        ArrayList<InventarioPadreModel> Padre = new ArrayList<>();
        Padre = InventarioPadreConexion.ListadoInventarioPadre();        
        for (int i = 0; i <Padre.size(); i++) 
                {
                    modelo.addRow
                    (new Object[]
                        {
                            Padre.get(i).getInvPId(), 
                            Padre.get(i).getInvPCodInterno(),
                            Padre.get(i).getInvPDescripcion(),
                            InventarioPadreController.ConvertirFormatoFecha(Padre.get(i).getInvPFchCaducidad()),
                            Padre.get(i).getInvPCantidad(),
                            Padre.get(i).getUndDescripcion(),
                            Padre.get(i).getKitId(),
                            Padre.get(i).getKitNombre(),
                            Padre.get(i).getPrdId(),
                            Padre.get(i).getPrdNombre()
                        }
                    );
                }
        
        FormatoTabla(tablePadre, modelo.getColumnCount());
    }

    private static void setErroresToNull(JLabel errDescripcion, JLabel errFechaCaducidad, 
            JLabel errCantidad, JLabel errUnidad, JLabel errKit, JLabel errProducto)
    {
        errUnidad.setText(null);
        errDescripcion.setText(null);
        errFechaCaducidad.setText(null);
        errCantidad.setText(null);
        errKit.setText(null);
        errProducto.setText(null);
        
    }
    
    private static boolean validacionesGenerales( String trinmedDescripcion, 
            String trinmedFechaCaducidad, String trinmedCantidad, String trinmedUnidad, String trinmedKit,
            String trinmedProducto, JLabel errDescripcion, JLabel errFechaCaducidad, JLabel errCantidad, 
           JLabel errUnidad, JLabel errKit, JLabel errProducto)
    {
        boolean error = false;
        
        if(Validaciones.validarCampoVacio(trinmedDescripcion))
        {
           errDescripcion.setText("La descripción es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.ValidarFormatoFecha(trinmedFechaCaducidad))
         {
            errFechaCaducidad.setText("Formato de Fecha Incorrecto");
            error = true;
         }
        
        if(Validaciones.validarCampoVacio(trinmedFechaCaducidad))
        { 
           errFechaCaducidad.setText("La Fecha Caducidad es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.ValidarFecha(trinmedFechaCaducidad))
         {
            errFechaCaducidad.setText("La Fecha de Caducidad no debe ser anterior a la actual");
            error = true;
         }
        
        if(!Validaciones.validarNumeros(trinmedCantidad))
        {
           errCantidad.setText("La Cantidad ingresada es incorrecta");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trinmedCantidad))
        {
           errCantidad.setText("La Cantidad es un campo obligatorio");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trinmedUnidad))
        {
           errUnidad.setText("La Unidad es un campo obligatorio");
           error = true;
        }  
        
        if(Validaciones.validarCampoVacio(trinmedKit))
        {
           errKit.setText("El Kit es un campo obligatorio");
           error = true;
        }
 
        if(Validaciones.validarCampoVacio(trinmedProducto))
        {
           errProducto.setText("El Producto es un campo obligatorio");
           error = true;
        }
        
        return error;
    }
    
    
   public static String Correlativo_PrdPIdAgregar(){
        
        String correlativo_PrdPId="", PrdPId="", correlativo_siguiente="", correlativo_completo="";
        int c2=0;
        Connection con = null;

            try{
                con = Conexion.getConexion(con);
                
                CallableStatement cst=con.prepareCall("SELECT InvPId " +
                        " FROM inventariopadre" +
                        " WHERE InvPId =(SELECT MAX(InvPId)FROM inventariopadre); ");
                ResultSet rs=cst.executeQuery();
                
                if(rs.next()){
                    correlativo_PrdPId=rs.getString("InvPId").trim();
                    c2=Integer.parseInt(correlativo_PrdPId)+1;
                    PrdPId=String.valueOf(c2);
                    if(PrdPId.length()<=6){
                        for(int x=0;x<(6-PrdPId.length());x++){
                            correlativo_siguiente=correlativo_siguiente+"0";
                        }
                    correlativo_siguiente=correlativo_siguiente+PrdPId;
                    correlativo_completo=correlativo_siguiente;
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR: ","El Número de Correlativo ha llegado a su màximo",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    c2=1;
                    PrdPId=String.valueOf(c2);
                    if(PrdPId.length()<=6){
                        for(int x=0;x<(6-PrdPId.length());x++){
                            correlativo_siguiente=correlativo_siguiente+"0";
                        }
                    correlativo_siguiente=correlativo_siguiente+PrdPId;
                    correlativo_completo=correlativo_siguiente;
                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR: ","El Número de Correlativo ha llegado a su màximo",JOptionPane.ERROR_MESSAGE);
                    }
                }
                
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            
        return correlativo_completo;
    }
   
   public static String Correlativo_PrdPIdEditar(Integer Id){
        String correlativo_PrdPId="", PrdPId="", correlativo_siguiente="", correlativo_completo="";
        
        PrdPId=String.valueOf(Id);
        if(PrdPId.length()<=6){
            for(int x=0;x<(6-PrdPId.length());x++){
                 correlativo_siguiente=correlativo_siguiente+"0";
            }
            correlativo_siguiente=correlativo_siguiente+PrdPId;
            correlativo_completo=correlativo_siguiente;
        }else{
            JOptionPane.showMessageDialog(null,"ERROR: ","El Número de Correlativo ha llegado a su màximo",JOptionPane.ERROR_MESSAGE);
        }
                
        return correlativo_completo;
    }
   
   public static String Correlativo_UndId(Integer Id){
       
        String correlativo_UndId="", UndId="", correlativo_siguiente="", correlativo_completo="";

            UndId=String.valueOf(Id);
            if(UndId.length()<=6){
                for(int x=0;x<(6-UndId.length());x++){
                    correlativo_siguiente=correlativo_siguiente+"0";
                }
                correlativo_siguiente=correlativo_siguiente+UndId;
                correlativo_completo=correlativo_siguiente;
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR: ","El Número de Correlativo ha llegado a su màximo",JOptionPane.ERROR_MESSAGE);
                }
        
        return correlativo_completo;
    }

   public static String ConvertirFormatoFecha(String fecha)
    {   
       final String OLD_FORMAT = "yyyy-MM-dd"; 
       final String NEW_FORMAT = "yyyy/MM/dd"; 
       String oldDateString = fecha; 
       String FechaCaducidad = " "; 
      try{ 
          
       SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT); 
       Date d = sdf.parse(oldDateString); 
       sdf.applyPattern(NEW_FORMAT); 
       FechaCaducidad = sdf.format(d);
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex);
      }
       return FechaCaducidad;
    }
}
