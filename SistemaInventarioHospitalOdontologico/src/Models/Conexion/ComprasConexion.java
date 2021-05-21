/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.ComprasModel;
import Models.Models.InventarioPadreModel;
import Models.Models.ProveedorModel;
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
public class ComprasConexion {
    public static ArrayList<ProveedorModel> ListadoProveedores() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM proveedores "
                    + "WHERE ProEstado=1";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                ProveedorModel proveedor = new ProveedorModel();
                proveedor.setProId(rss.getInt("ProId"));
                proveedor.setProNombre(rss.getString("ProNombre"));
                proveedores.add(proveedor);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return proveedores;
    }
    public static Integer IdProveedor(String Proveedor)
    {
        Integer id_proveedor=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT ProId FROM proveedores "
                    + "WHERE ProNombre='"+Proveedor+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                id_proveedor=rss.getInt("ProId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return id_proveedor;
    }     
    public static Integer IdInvP(String Inventario)
    {
        Integer id_proveedor=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT InvPId FROM inventariopadre "
                    + "WHERE InvPDescripcion='"+Inventario+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                id_proveedor=rss.getInt("InvPId");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return id_proveedor;
    }        

    public static ArrayList<InventarioPadreModel> ListadoInventario() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<InventarioPadreModel> inventarios = new ArrayList<>();
            try 
            {
                con = Conexion.getConexion(con);
                stm = con.createStatement();
                String query = "SELECT * FROM  inventariopadre ";

                rss = stm.executeQuery(query);

                while (rss.next()) 
                {
                    InventarioPadreModel inventario = new InventarioPadreModel();
                    inventario.setInvPId(rss.getInt("InvPId"));
                    inventario.setInvPCodInterno(rss.getString("InvPCodInterno"));
                    inventario.setInvPDescripcion(rss.getString("InvPDescripcion"));
                    inventarios.add(inventario);
               } 
               con.close();
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null,e);
            }

        
        return inventarios;
    }    
    
    public static String MantenimientoCompras(String accion, ComprasModel compras)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            System.out.println( "------------------");
            System.out.println( compras.getDtcId());
            System.out.println(compras.getCmpId());
            System.out.println(compras.getInvPrdId());
            System.out.println(compras.getDtcCantidad());
            System.out.println(compras.getDtcTieneImpuesto());
            System.out.println(compras.getDtcPrecioCompra()); 
            System.out.println( "------------------");
            query = "{CALL MantenimientoDetalleCompras(?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, compras.getDtcId());
            cs.setInt               (3, compras.getCmpId());
            cs.setInt               (4, compras.getInvPrdId());
            cs.setInt               (5, compras.getDtcCantidad());
            cs.setInt               (6, compras.getDtcTieneImpuesto());
            cs.setDouble            (7, compras.getDtcPrecioCompra());
            cs.setInt               (8, compras.getDtcEstado());
            cs.registerOutParameter (9, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(9);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }    
}
