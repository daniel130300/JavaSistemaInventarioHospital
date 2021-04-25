/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.AreasModel;
import Models.Models.DetalleUsuariosModel;
import Models.Models.PrivilegiosModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Models.Models.UsuarioModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
*
* @author Héctor López
*/

public class UsuarioConexion
{ 
    
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * 
    * Método que retorna los registros de la tabla usuarios y areas desde la bdd,
    * dependiendo de la acción que el usuario realice, ya sea mostrar los registros inactivos, activos o 
    * todos.
    * @return ArrayList de objetos tipo UsuarioModel
    */
    public static ArrayList<UsuarioModel> ListadoUsuarios(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        
        switch(accion){
            
            case "Activos":
                            try 
                            {
                                con = Conexion.getConexion(con);
                                stm = con.createStatement();
                                String query = "SELECT u.*, a.AreDescripcion "
                                        + "FROM usuarios u INNER JOIN areas a ON u.AreId = a.AreId "
                                        + "WHERE UsrId!=1 AND UsrId!=2 AND UsrEstado = 'Activo' "
                                        + "ORDER BY u.UsrId ASC";

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
                            break;
            case "Inactivos":
                            try 
                            {
                                con = Conexion.getConexion(con);
                                stm = con.createStatement();
                                String query = "SELECT u.*, a.AreDescripcion "
                                        + "FROM usuarios u INNER JOIN areas a ON u.AreId = a.AreId "
                                        + "WHERE UsrId!=1 AND UsrId!=2 AND UsrEstado = 'Inactivo' "
                                        + "ORDER BY u.UsrId ASC";

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
                            break;
            case "Todos":
                            try 
                            {
                                con = Conexion.getConexion(con);
                                stm = con.createStatement();
                                String query = "SELECT u.*, a.AreDescripcion "
                                        + "FROM usuarios u INNER JOIN areas a ON u.AreId = a.AreId "
                                        + "WHERE UsrId!=1 AND UsrId!=2 ORDER BY u.UsrId ASC";

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
                            break;
        }
        
        return usuarios;
    }
    
    /**
    * Método que retorna los registros de la tabla areas desde la bdd. 
    * @return ArrayList de objetos tipo AreasModel
    */
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
    
    /**
    * Método que retorna los registros de la tabla privilegios desde la bdd.
    * @return ArrayList de objetos tipo PrivilegiosModel
    */
    public static ArrayList<PrivilegiosModel> ListadoPrivilegios() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();

        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM privilegios ORDER BY PriIdModulo ASC;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                PrivilegiosModel privilegio = new PrivilegiosModel();
                privilegio.setPriId(rss.getInt("PriId"));
                privilegio.setPriDescripcion(rss.getString("PriDescripcion"));
                privilegios.add(privilegio);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return privilegios;
    }

    /**
    * @param LstElements ArrayList de tipo String
    * Método que se encarga de obtener los indices para los elementos dentro de
    * la lista
    * @return ArrayList de tipo Integer
    */
    public static ArrayList<Integer> getIndexesofLstElements(ArrayList<String> LstElements)
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<Integer> Indexes = new ArrayList<>();
        
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            
            for(int i=0; i<LstElements.size(); i++)
            {
                String query = "SELECT PriId FROM privilegios WHERE priDescripcion = '"+LstElements.get(i)+"';";
             
                rss = stm.executeQuery(query);

                while (rss.next()) 
                {
                    Indexes.add(rss.getInt("PriId"));
                }
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }

        return Indexes;
    }
    
    /**
    * @param UsrId Integer
    * Método que se encarga de obtener todos los indices de la tabla 
    * detalleusuarios para el id del usuario que se le manda como paramétro
    * @return ArrayList de tipo Integer
    */
    public static ArrayList<Integer> getDtuIndexesofUsr(Integer UsrId)
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<Integer> Indexes = new ArrayList<>();
        
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();

            String query = "SELECT DtuId FROM detalleusuarios WHERE UsrId = "+UsrId+";";
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                Indexes.add(rss.getInt("DtuId"));
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return Indexes;
    }
    
    /**
    * @param UsrId Integer
    * Método que se encarga de obtener las descripciones para los privilegios 
    * de el usuario 
    * @return ArrayList de objetos tipo PrivilegiosModel
    */
    public static ArrayList<PrivilegiosModel> getUsrPrivilegiosDescripcion(Integer UsrId)
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();
        
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();

            String query = "SELECT PriDescripcion "
                    + "FROM detalleusuarios Dtu INNER JOIN privilegios Pri "
                    + "ON Dtu.PriId = Pri.PriId WHERE UsrId = "+UsrId +";";
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                PrivilegiosModel privilegio = new PrivilegiosModel();
                privilegio.setPriDescripcion(rss.getString("PriDescripcion"));
                privilegios.add(privilegio);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return privilegios;
    }
  
    /**
    * @param accion String
    * @param usuario Objeto tipo UsuarioModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoUsuario
    * @return String el cual contiene el parametro de salida del procedimiento.
    */
    public static String MantenimientoUsuarios(String accion, UsuarioModel usuario)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
            
            query = "{CALL MantenimientoUsuarios(?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, usuario.getUsrId());
            cs.setString            (3, usuario.getUsrIdentidad());
            cs.setString            (4, usuario.getUsrNombre());
            cs.setString            (5, usuario.getUsrApellido());
            cs.setString            (6, usuario.getUsrCorreo());
            cs.setString            (7, usuario.getUsrUsuario());
            cs.setString            (8, usuario.getUsrContrasenia());
            cs.setString            (9, usuario.getUsrEstado());
            cs.setInt               (10, usuario.getAreId());
            cs.registerOutParameter (11, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(11);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        }
        return estado;
    }
    
    /**
    * @param accion String
    * @param detalleUsuario Objeto de tipo DetalleUsuariosModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoDetalleUsuarios
    * @return String el cual contiene el parametro de salida del procedimiento.
    */
    public static String MantenimientoDetalleUsuarios(String accion, DetalleUsuariosModel detalleUsuario)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);

            query = "{CALL MantenimientoDetalleUsuarios(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, detalleUsuario.getDtuId());
            cs.setInt               (3, detalleUsuario.getUsrId());
            cs.setInt               (4, detalleUsuario.getPriId());
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
}
