/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.ProveedorModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    + "WHERE ProEstado='Activo'";
             
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
}
