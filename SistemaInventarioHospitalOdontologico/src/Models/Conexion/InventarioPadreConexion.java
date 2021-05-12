/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.InventarioPadreModel;
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
 * @author Katering Osorto
 */
public class InventarioPadreConexion 
{
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    public static ArrayList<InventarioPadreModel> ListadoInventarioPadre() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<InventarioPadreModel> Padre = new ArrayList<>();
 
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT ivp.InvPId, ivp.InvPCodInterno, ivp.InvPDescripcion,ivp.InvPFchCaducidad, " 
                                 + "ivp.InvPCantidad, und.UndDescripcion, ivp.KitId, k.KitNombre, "
                                 + "ivp.PrdId, ctp.PrdNombre " 
                                 + "FROM inventariopadre ivp INNER JOIN unidades und " 
                                 + "ON ivp.UndId = und.UndId INNER JOIN catalogoproductos ctp "
                                 + "ON ivp.PrdId = ctp.PrdId INNER JOIN kits k "
                                 + "ON ivp.KitId = k.KitId "
                                 + "ORDER BY ivp.InvPId ASC; ";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        InventarioPadreModel padre = new InventarioPadreModel();
                        padre.setInvPId(rss.getInt("InvPId"));
                        padre.setInvPCodInterno(rss.getString("InvPCodInterno"));
                        padre.setInvPDescripcion(rss.getString("InvPDescripcion"));;
                        padre.setInvPFchCaducidad(rss.getString("InvPFchCaducidad"));
                        padre.setInvPCantidad(rss.getInt("InvPCantidad"));
                        padre.setUndDescripcion(rss.getString("UndDescripcion"));
                        padre.setKitId(rss.getInt("KitId"));
                        padre.setKitNombre(rss.getString("KitNombre"));
                        padre.setPrdId(rss.getInt("PrdId"));
                        padre.setPrdNombre(rss.getString("PrdNombre"));                
                        Padre.add(padre);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
                
        return Padre;
    }

    
    /**
    * Método que retorna los registros de la tabla Lote producto y Catalogos de productos desde la bdd,
    * dependiendo de la acción que el usuario realice, ya sea mostrar los registros inactivos, activos o 
    * todos.
    * @return ArrayList de objetos tipo InventarioBodegaModel
    */
    
    public static String getNombreProducto(Integer PrdId)
    {
        String Producto= " ";
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT PrdNombre FROM catalogoproductos "
                    + "WHERE PrdId='"+PrdId+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Producto=rss.getString("PrdNombre");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Producto;
    }
    
    public static Integer getIdProducto(String Nombre)
    {
        Integer Producto= 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT PrdId FROM catalogoproductos "
                    + "WHERE PrdNombre='"+Nombre+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Producto=rss.getInt("PrdId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Producto;
    }    
    
    public static String getNombreUnidad(Integer UndId)
    {
        String Unidad= " ";
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT UndDescripcion FROM unidades "
                    + "WHERE UndId='"+UndId+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Unidad=rss.getString("UndDescripcion");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Unidad;
    }
    
    public static Integer getIdUnidad(String Nombre)
    {
        Integer Unidad= 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT UndId FROM unidades "
                    + "WHERE UndDescripcion='"+Nombre+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Unidad=rss.getInt("UndId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Unidad;
    }
    
    public static String getNomenclaturaProducto(String Nombre)
    {
        String Nomeclatura = "";
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT cpr.CprNomenclatura FROM catalogoproductos prd "
                    + "INNER JOIN categoriasproductos cpr "
                    + "ON prd.CprId = cpr.CprId "
                    + "WHERE prd.PrdNombre='"+Nombre+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Nomeclatura=rss.getString("CprNomenclatura");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Nomeclatura;
    }
    
    public static String getNombreKit(Integer KitId)
    {
        String Kit= " ";
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT KitNombre FROM kits "
                    + "WHERE KitId='"+KitId+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Kit=rss.getString("KitNombre");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Kit;
    }
    
    public static Integer getIdKit(String Nombre)
    {
        Integer Kit= 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT KitId FROM kits "
                    + "WHERE KitNombre='"+Nombre+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Kit=rss.getInt("KitId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return Kit;
    }
 
    /**
    * 
    * @param padre InventarioBodegaModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoInventarioBodega.
    * @return String el cual contiene el parametro de salida del procedimiento. 
    */
     public static String MantenimientoInventarioPadre(String accion,InventarioPadreModel padre)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            query = "{CALL MantenimientoInventarioPadre(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, padre.getInvPId());
            cs.setString            (3, padre.getInvPCodInterno());
            cs.setString            (4, padre.getInvPDescripcion());
            cs.setString            (5, padre.getInvPFchCaducidad());
            cs.setInt               (6, padre.getInvPCantidad());
            cs.setInt               (7, InventarioPadreConexion.getIdUnidad(padre.getUndDescripcion()));
            cs.setInt               (8, InventarioPadreConexion.getIdKit(padre.getKitNombre()));
            cs.setInt               (9, InventarioPadreConexion.getIdProducto(padre.getPrdNombre()));
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

}
