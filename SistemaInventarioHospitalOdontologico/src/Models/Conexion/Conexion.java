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
    //****************************
    // Constantes
    //***************************
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "password";
    private static final String url = "jdbc:mysql://192.168.0.120:3306/inventariohospital?characterEncoding=utf8";
    
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * 
    * @param con Connection
    * Método que se encarga de establecer la conexion con MySQL
    * @return Connection
    */
    public static Connection getConexion(Connection con)
    {
        if (con == null)
        {
            try 
            {
                //con = DriverManager.getConnection("jdbc:mysql://192.168.0.120/inventariohospital?" +"user=root&password=password");
		con = DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "SQLState: " + ex.getSQLState());
                JOptionPane.showMessageDialog(null, "VendorError: " + ex.getErrorCode());
            }
        }
        return con;
    }
}
