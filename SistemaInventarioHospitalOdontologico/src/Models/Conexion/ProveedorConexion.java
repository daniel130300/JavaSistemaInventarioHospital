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
 * @author danie
 */
public class ProveedorConexion 
{
    
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
            String query = "SELECT * FROM proveedores ORDER BY ProId ASC";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                ProveedorModel proveedor = new ProveedorModel();
                proveedor.setProId(rss.getInt("ProId"));
                proveedor.setProRTN(rss.getString("ProRTN"));
                proveedor.setProNombre(rss.getString("ProNombre"));;
                proveedor.setProCorreo(rss.getString("ProCorreo"));
                proveedor.setProTelefono(rss.getString("ProTelefono"));
                proveedor.setProContacto(rss.getString("ProContacto"));
                proveedor.setProDireccion(rss.getString("ProDireccion"));
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
    
    
}
