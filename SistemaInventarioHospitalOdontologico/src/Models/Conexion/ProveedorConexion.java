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
import java.sql.CallableStatement;
import java.sql.Types;

/**
*
* @author Franciso Godoy
*/
public class ProveedorConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Método que retorna los registros de la tabla proveedores,
    * dependiendo de la acción que el usuario realice, ya sea mostrar los registros inactivos, activos o 
    * todos.
    * @return ArrayList de objetos tipo ProveedorModel
    */
    public static ArrayList<ProveedorModel> ListadoProveedores(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        
        switch(accion){
            
            case "Activos":
                            try 
                            {
                                con = Conexion.getConexion(con);
                                stm = con.createStatement();
                                String query = "SELECT * FROM proveedores "
                                        + "WHERE ProEstado = 'Activo'"
                                        + " ORDER BY ProId ASC";

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
                                    proveedor.setProEstado(rss.getString("ProEstado"));

                                    proveedores.add(proveedor);
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
                                String query = "SELECT * FROM proveedores "
                                        + "WHERE ProEstado = 'Inactivo'"
                                        + " ORDER BY ProId ASC";

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
                                    proveedor.setProEstado(rss.getString("ProEstado"));

                                    proveedores.add(proveedor);
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
                                    proveedor.setProEstado(rss.getString("ProEstado"));

                                    proveedores.add(proveedor);
                                } 
                                con.close();
                            } 
                            catch (SQLException e) 
                            {
                                JOptionPane.showMessageDialog(null,e);
                            }
                            break;
        }
        
        return proveedores;
    }
    public static ArrayList<ProveedorModel>  ListadoDetalleProductoProveedores() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM proveedores WHERE ProEstado='Activo' ORDER BY ProId ASC";
             
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
                proveedor.setProEstado(rss.getString("ProEstado"));
                
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
    
    /**
    * @param accion String
    * @param proveedor ProveedorModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoProveedores
    * @return String el cual contiene el parametro de salida del procedimiento.
    */
    public static String MantenimientoProveedores(String accion, ProveedorModel proveedor)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL MantenimientoProveedores(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, proveedor.getProId());
            cs.setString            (3, proveedor.getProRTN());
            cs.setString            (4, proveedor.getProNombre());
            cs.setString            (5, proveedor.getProCorreo());
            cs.setString            (6, proveedor.getProTelefono());
            cs.setString            (7, proveedor.getProContacto());
            cs.setString            (8, proveedor.getProDireccion());
            cs.setString            (9, proveedor.getProEstado());
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
