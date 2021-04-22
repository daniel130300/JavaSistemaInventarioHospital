/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
*
* @author Héctor López
* 
* Clase que se encarga de establecer la conexión a MySQL de acorde 
* a las credenciales proporcionadas
*/

public abstract class Conexion 
{
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "password";
    private static final String url = "jdbc:mysql://localhost:3306/inventariohospital?characterEncoding=utf8";
    
    
    public static Connection getConexion(Connection con)
    {
        if (con == null)
        {
            try 
            {
                Class.forName(driver);
                con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        
        return con;
    }
}
