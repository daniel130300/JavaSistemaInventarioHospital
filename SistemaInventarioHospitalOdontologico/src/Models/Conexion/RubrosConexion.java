/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.RubrosModel;
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
 * @author Maryury Zuniga
 */
public class RubrosConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    public static ArrayList<RubrosModel> ListadoRubros(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<RubrosModel> rubros = new ArrayList<>();
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM rubros"
                            + " WHERE RubEstado = 'Activo'";

                     rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                       RubrosModel rubro = new RubrosModel();
                       rubro.setRubId(rss.getInt("RubId"));
                       rubro.setRubDescripcion(rss.getString("RubDescripcion"));
                       rubro.setRubEstado(rss.getString("RubEstado"));
                       rubros.add(rubro);
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
                    String query = "SELECT *FROM rubros "
                            + "WHERE RubEstado = 'Inactivo'";

                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        RubrosModel rubro = new RubrosModel();
                        rubro.setRubId(rss.getInt("RubId"));
                        rubro.setRubDescripcion(rss.getString("RubDescripcion"));
                        rubro.setRubEstado(rss.getString("RubEstado"));
                        rubros.add(rubro);
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
                    String query = "SELECT *FROM rubros ";

                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        RubrosModel rubro = new RubrosModel();
                        rubro.setRubId(rss.getInt("RubId"));
                        rubro.setRubDescripcion(rss.getString("RubDescripcion"));
                        rubro.setRubEstado(rss.getString("RubEstado"));
                        rubros.add(rubro);
                    }  
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }
        
        return rubros;
    }    
     
    public static String MantenimientoRubros(String accion, RubrosModel rubro)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL MantenimientoRubros(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, rubro.getRubId());
            cs.setString            (3, rubro.getRubDescripcion());
            cs.setString            (4, rubro.getRubEstado());
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

