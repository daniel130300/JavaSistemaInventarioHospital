/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;
import Models.Models.CategoriasModel;
import Models.Models.CatalogoProductoModel;
import Models.Models.DetalleCatalogoProductosModel;
import Models.Models.UnidadesModel;
import Utils.Cache.UsuarioLogueadoCache;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fgodo
 */
public class CatalogoProductoConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    public static ArrayList<CatalogoProductoModel> ListadoProducto() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<CatalogoProductoModel> productos = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT a.*, b.CprDescripcion, c.UndDescripcion "
                    + "FROM catalogoproductos a INNER JOIN categoriasproductos b ON b.CprId = a.CprId "
                    + "INNER JOIN unidades c ON c.UndId = a.UndId "
                    + "ORDER BY a.PrdId ASC";
            
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                CatalogoProductoModel producto = new CatalogoProductoModel();
                producto.setPrdId(rss.getInt("PrdId"));
                producto.setPrdNombre(rss.getString("PrdNombre"));
                producto.setPrdDescripcion(rss.getString("PrdDescripcion"));;
                producto.setPrdStockMaximo(rss.getString("PrdStockMaximo"));
                producto.setPrdStockMinimo(rss.getString("PrdStockMinimo"));
                producto.setProdEstado(rss.getString("PrdEstado"));
                producto.setCprId(rss.getInt("CprId"));
                producto.setCprDescripcion(rss.getString("CprDescripcion"));                
                producto.setUndId(rss.getInt("UndId"));
                producto.setUndDescripcion(rss.getString("UndDescripcion"));
                productos.add(producto);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return productos;
    }
    
    public static ArrayList<DetalleCatalogoProductosModel> getDetalleProducto(Integer PrdId) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        ArrayList<DetalleCatalogoProductosModel> detalleproductos = new ArrayList<>();
        
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT DcpId, a.ProId, PrdId, ProNombre,ProRTN from detallecatalogoproductos a "
                    + "INNER JOIN proveedores b ON a.ProId=b.ProId " 
                    + "WHERE PrdId="+PrdId+" "   
                    + "ORDER BY DcpId ASC";
            rss = stm.executeQuery(query); 
            while (rss.next())  
            {
                DetalleCatalogoProductosModel detalleproducto = new DetalleCatalogoProductosModel();
                detalleproducto.setDcpId(rss.getInt("DcpId"));  
                detalleproducto.setPrdId(rss.getInt("PrdId"));
                detalleproducto.setProId(rss.getInt("ProId"));
                detalleproducto.setProRTN(rss.getString("ProRTN"));
                detalleproducto.setProNombre(rss.getString("ProNombre"));
                detalleproductos.add(detalleproducto);
                detalleproducto.setAllDcpId(detalleproducto.getDcpId());
            } 
           
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }        
        return detalleproductos;
    }
    
    public static ArrayList<CategoriasModel> ListadoCategorias() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        ArrayList<CategoriasModel> categorias = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM categoriasproductos "
                    + "WHERE CprEstado='Activo'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                CategoriasModel categoria = new CategoriasModel();
                categoria.setCprId(rss.getInt("CprId"));
                categoria.setCprDescripcion(rss.getString("CprDescripcion"));
                categorias.add(categoria);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return categorias;
    }
    
    public static Integer IdCategoria(String Categoria){
        Integer id_categoria=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT CprId FROM categoriasproductos "
                    + "WHERE CprDescripcion='"+Categoria+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                id_categoria=rss.getInt("CprId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return id_categoria;
    } 
    
    public static Integer IdUnidad(String Unidades){
        Integer id_unidades=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;        
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT UndId FROM unidades "
                    + "WHERE UndDescripcion='"+Unidades+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                id_unidades=rss.getInt("UndId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }        
        return id_unidades;
    }
    
    public static Integer UltimoPrdId ()
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT PrdId FROM catalogoproductos "
                    + "ORDER BY PrdId DESC LIMIT 1;";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("PrdId");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }     
    
    public static ArrayList<UnidadesModel> ListadoUnidades() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM unidades "
                    + "WHERE UndEstado='Activo'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                UnidadesModel unidad = new UnidadesModel();
                unidad.setUndId(rss.getInt("UndId"));
                unidad.setUndDescripcion(rss.getString("UndDescripcion"));
                unidades.add(unidad);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return unidades;
    }
    
    public static String MantenimientoCatalogoProducto(String accion, CatalogoProductoModel producto )
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            CrearTablaTemporal(con);
            query = "{CALL MantenimientoCatalogoProductos(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, producto.getPrdId());
            cs.setString            (3, producto.getPrdNombre());
            cs.setString            (4, producto.getPrdDescripcion());       
            cs.setString            (5, producto.getPrdStockMaximo());   
            cs.setString            (6, producto.getPrdStockMinimo());    
            cs.setString            (7, producto.getProdEstado());
            cs.setInt               (8, producto.getCprId());    
            cs.setInt               (9, producto.getUndId());         
            cs.registerOutParameter (10, Types.VARCHAR);         
            cs.executeUpdate();                     
            estado = cs.getString(10);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        }
        return estado;
    }
    
    public static String MantenimientoDetalleCatalogoProductos(String accion, DetalleCatalogoProductosModel detalleproductomodel)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            query = "{CALL MantenimientoDetalleCatalogoProductos(?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, detalleproductomodel.getDcpId());
            cs.setInt               (3, detalleproductomodel.getProId());
            cs.setInt               (4, detalleproductomodel.getPrdId());
            cs.setInt               (5, 0);
            cs.registerOutParameter (6, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(6);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }
    
    //****************************
    // Metodos privados
    //***************************
    
    private static void CrearTablaTemporal(Connection conexion)
    {
        Connection con = null;
        PreparedStatement stm;     
        try 
        {
            con = conexion;
            String query = "CREATE TEMPORARY TABLE IF NOT EXISTS loggedusuario "
                    + "AS (SELECT * FROM usuarios WHERE UsrId = ?) ";
            UsuarioLogueadoCache usuario = new UsuarioLogueadoCache();
            stm = con.prepareStatement(query);
            stm.setInt(1, usuario.getUsrId());
            stm.executeUpdate();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }      
    }
}
