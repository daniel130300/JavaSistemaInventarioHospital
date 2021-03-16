/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.AreasModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Models.Models.UsuarioModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class UsuarioConexion
{ 
    public static ArrayList<UsuarioModel> ListadoUsuarios() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT u.*, a.AreDescripcion FROM usuarios u "
                     + "INNER JOIN areas a ON u.AreId = a.AreId;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setUsrId(rss.getInt("UsrId"));
                usuario.setUsrIdentidad(rss.getString("UsrIdentidad"));
                usuario.setUsrNombre(rss.getString("UsrNombre"));;
                usuario.setUsrApellido(rss.getString("UsrApellido"));
                usuario.setUsrCorreo(rss.getString("UsrCorreo"));
                usuario.setUsrUsuario(rss.getString("UsrUsuario"));
                usuario.setUsrEstado(rss.getString("UsrEstado"));
                usuario.setAreId(rss.getInt("AreId"));
                usuario.setAreDescripcion(rss.getString("AreDescripcion"));
                usuarios.add(usuario);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return usuarios;
    }
    
    public static ArrayList<AreasModel> ListadoAreas() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<AreasModel> areas = new ArrayList<>();

        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM areas;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                AreasModel area = new AreasModel();
                area.setAreId(rss.getInt("AreId"));
                area.setAreDescripcion(rss.getString("AreDescripcion"));
                areas.add(area);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return areas;
    }
    
    public static String MantenimientoUsuarios(String accion, UsuarioModel usuario)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            query = "{CALL mantenimiento_usuarios(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            CallableStatement cs = con.prepareCall(query);
            cs.setString    (1, accion);
            cs.setInt       (2, usuario.getUsrId());
            cs.setString    (3, usuario.getUsrIdentidad());
            cs.setString    (4, usuario.getUsrNombre());
            cs.setString    (5, usuario.getUsrApellido());
            cs.setString    (6, usuario.getUsrCorreo());
            cs.setString    (7, usuario.getUsrUsuario());
            cs.setString    (8, usuario.getUsrContrasenia());
            cs.setString    (9, usuario.getUsrEstado());
            cs.setInt       (10, usuario.getAreId());
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            estado = cs.getString(11);
            cs.execute();
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        
        return estado;
    }   
}
