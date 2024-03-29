/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.UsuarioModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor López
 */

public class InformacionPersonalConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * @param id Integer
    * @param nombre String
    * @param apellido String
    * @param correo String
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * EditarInformacionPersonal 
    * @return String el cual contiene el parametro de salida del procedimiento.
    */
    public static String EditarInformacionPersonal(Integer id, String nombre, 
            String apellido, String correo)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            
            query = "{CALL EditarInformacionPersonal(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setInt               (1, id);
            cs.setString            (2, nombre);
            cs.setString            (3, apellido);
            cs.setString            (4, correo);
            cs.registerOutParameter (5, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(5);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        }
        return estado;
    }
    
    /**
    * @param id Integer
    * Método que se encarga de recargar los datos modificados para el usuario
    * @return Objeto de tipo UsuarioModel
    */
    public static UsuarioModel recuperarInformacionActualizada(Integer id)
    {
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rss;
        
        UsuarioModel usuarioModel = new UsuarioModel();
        
        try 
        {
            con = Conexion.getConexion(con);

            String query = "SELECT * FROM usuarios WHERE UsrId = ? LIMIT 1;";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rss = stmt.executeQuery();
            
            while (rss.next()) 
            {
                usuarioModel.setUsrNombre(rss.getString("UsrNombre"));
                usuarioModel.setUsrApellido(rss.getString("UsrApellido"));
                usuarioModel.setUsrCorreo(rss.getString("UsrCorreo"));
            }
            
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return usuarioModel;
    }
}
