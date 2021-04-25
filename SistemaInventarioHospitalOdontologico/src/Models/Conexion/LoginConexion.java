/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.PrivilegiosModel;
import Models.Models.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class LoginConexion 
{
    
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * @param usrUsuario String
    * Método que se encarga de obtener los datos del usuario que se está
    * intentando loguear en el sistema
    * @return Objeto de tipo UsuarioModel
    */
    public static UsuarioModel getUsuariobyUsr(String usrUsuario)
    {
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rss;
        
        UsuarioModel usuarioModel = new UsuarioModel();
        
        try 
        {
            con = Conexion.getConexion(con);

            String query = "SELECT * FROM usuarios WHERE BINARY UsrUsuario = ? LIMIT 1;";
            stmt = con.prepareStatement(query);
            stmt.setString(1, usrUsuario);
            rss = stmt.executeQuery();
            
            while (rss.next()) 
            {
                usuarioModel.setUsrId(rss.getInt("UsrId"));
                usuarioModel.setUsrIdentidad(rss.getString("UsrIdentidad"));
                usuarioModel.setUsrUsuario(rss.getString("UsrUsuario"));
                usuarioModel.setUsrContrasenia(rss.getString("UsrContrasenia"));
                usuarioModel.setUsrNombre(rss.getString("UsrNombre"));
                usuarioModel.setUsrApellido(rss.getString("UsrApellido"));
                usuarioModel.setUsrCorreo(rss.getString("UsrCorreo"));
                usuarioModel.setUsrEstado(rss.getString("UsrEstado"));
            }
            
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return usuarioModel;
    }
    
    /**
    * @param usrId Integer
    * Método que se encarga de obtener los privilegios del usuario que se 
    * ha logueado
    * @return ArrayList de objetos tipo PrivilegiosModel
    */
    public static ArrayList<PrivilegiosModel> getPrivilegiosUsrLogueado(Integer usrId)
    {
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rss;
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();
        
        try
        {
            con = Conexion.getConexion(con);
            String query = "SELECT dtu.PriId, PriDescripcion, PriIdModulo "
                    + "FROM detalleusuarios dtu "
                    + "INNER JOIN privilegios pri ON dtu.PriId = pri.PriId "
                    + "WHERE UsrId = ?"; 
            
            stmt = con.prepareStatement(query);
            stmt.setInt(1, usrId);
            rss = stmt.executeQuery();
            
            while (rss.next()) 
            {
                PrivilegiosModel privilegiosModel = new PrivilegiosModel(); 
                privilegiosModel.setPriId(rss.getInt("PriId"));
                privilegiosModel.setPriDescripcion(rss.getString("PriDescripcion"));
                privilegiosModel.setPriIdModulo(rss.getInt("PriIdModulo"));
                privilegios.add(privilegiosModel);
            }
            
            con.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return privilegios;
    }
}
