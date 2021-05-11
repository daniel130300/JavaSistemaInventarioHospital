/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.CatalogoProductoModel;
import Models.Models.KitModel;
import Models.Models.UnidadesModel;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class KitConexion {
    
      public static ArrayList<KitModel> ListadoKit(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<KitModel> kits = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT * From kits "
                     + "WHERE KitEstado = 1 " 
                     + "ORDER BY KitId ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        KitModel kit = new KitModel();
                        kit.setKitId(rss.getInt("KitId"));
                        kit.setKitNombre(rss.getString("KitNombre"));
                        kit.setKitDescripcion(rss.getString("KitDescripcion"));;
                        kit.setKitEstado(rss.getInt("KitEstado"));                
                        kits.add(kit);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;
                
            case "Inactivos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From kits "
                     + "WHERE KitEstado = 0 " 
                     + "ORDER BY KitId ASC";


                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        KitModel kit = new KitModel();
                        kit.setKitId(rss.getInt("KitId"));
                        kit.setKitNombre(rss.getString("KitNombre"));
                        kit.setKitDescripcion(rss.getString("KitDescripcion"));;
                        kit.setKitEstado(rss.getInt("KitEstado"));                
                        kits.add(kit);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break; 
                
            case "Todos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT * From kits "
                     + "ORDER BY KitId ASC";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        KitModel kit = new KitModel();
                        kit.setKitId(rss.getInt("KitId"));
                        kit.setKitNombre(rss.getString("KitNombre"));
                        kit.setKitDescripcion(rss.getString("KitDescripcion"));;
                        kit.setKitEstado(rss.getInt("KitEstado"));                
                        kits.add(kit);
                    } 
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }

        return kits;
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
                    + "WHERE UndEstado=1";
             
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
            String query = "SELECT * FROM catalogoproductos "
                    + "WHERE PrdEstado=1";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                CatalogoProductoModel producto = new CatalogoProductoModel();
                producto.setPrdId(rss.getInt("PrdId"));
                producto.setPrdNombre(rss.getString("PrdNombre"));
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

    public static ArrayList<KitModel> ListadoProductos(Integer id) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        ArrayList<KitModel> kits = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "select a.*,b.UndDescripcion,c.PrdNombre from detallekits a " +
                            "INNER JOIN unidades b on b.UndId = a.UndId " +
                            "INNER JOIN catalogoproductos c on c.PrdId = a.PrdId " +
                            "Where KitId = '"+id +"' "+
                            "Order by a.DtkId Asc;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                KitModel kit = new KitModel();
                kit.setDtkId(rss.getInt("DtkId"));
                kit.setPrdId(rss.getInt("PrdId"));
                kit.setPrdNombre(rss.getString("PrdNombre"));
                kit.setUndId(rss.getInt("UndId"));
                kit.setUndDescripcion(rss.getString("UndDescripcion"));
                kit.setDtkcCantidad(rss.getInt("DtkCantidad"));
                kits.add(kit);
                kit.setAllDtId(kit.getDtkId());
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return kits;
    } 
    
    public static String MantenimientoKits(String accion, KitModel KitModel)
    {
        String estado = "";
        Connection con = null;
        try
        {
            
            String query;
            con = Conexion.getConexion(con);
            query = "{CALL MantenimientoKits(?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, KitModel.getKitId());                    
            cs.setString            (3, KitModel.getKitNombre());
            cs.setString            (4, KitModel.getKitDescripcion());
            cs.setInt               (5, KitModel.getKitEstado());
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
    public static Integer PrdId (String Nombre )
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
                    + "where PrdNombre= '"+Nombre+"'";
            
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
    public static Integer UltimoKitId ()
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT KitId FROM kits "
                    + "ORDER BY KitId DESC LIMIT 1;";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("KitId");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }     

    
    
    public static Integer UndId (String Descripcion )
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT UndId FROM unidades "
                    + "where UndDescripcion= '"+Descripcion+"'";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("UndId");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }     
    public static String MantenimientoDetalleKits(String accion, KitModel KitModel)
    {
        String estado = "";
        Connection con = null;
        try
        {
            
            String query;
            con = Conexion.getConexion(con);
            query = "{CALL MantenimientoDetalleKits(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, KitModel.getDtkId());
            cs.setInt               (3, KitModel.getKitId());
            cs.setInt               (4, KitModel.getPrdId());
            cs.setInt               (5, KitModel.getUndId());
            cs.setInt               (6, KitModel.getDtkcCantidad());
            cs.registerOutParameter (7, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(7);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }    
    
}
