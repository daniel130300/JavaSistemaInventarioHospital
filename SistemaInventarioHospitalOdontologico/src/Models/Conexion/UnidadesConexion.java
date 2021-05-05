/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.UnidadesModel;
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
public class UnidadesConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Metodo que retorna los registros de la table tableUnidades
    * desde la bdd,dependiendo de la accion que realice el usuario; mostrar todos 
    * los registros, solo los activos o solo los inactivos.
     * @param accion
    * @return ArrayList de objeto tipo UnidadesModel
    */
    public static ArrayList<UnidadesModel> ListadoUnidades(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM unidades"
                            + " WHERE UndEstado = 1";

                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        UnidadesModel unidad = new UnidadesModel();
                        unidad.setUndId(rss.getInt("UndId"));
                        unidad.setUndDescripcion(rss.getString("UndDescripcion"));
                        unidad.setUndEstado(rss.getInt("UndEstado"));
                        unidades.add(unidad);
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
                    String query = "SELECT *FROM unidades "
                            + "WHERE UndEstado = 0";


                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        UnidadesModel unidad = new UnidadesModel();
                        unidad.setUndId(rss.getInt("UndId"));
                        unidad.setUndDescripcion(rss.getString("UndDescripcion"));
                        unidad.setUndEstado(rss.getInt("UndEstado"));
                        unidades.add(unidad);
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
                    String query = "SELECT *FROM unidades ";



                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        UnidadesModel unidad = new UnidadesModel();
                        unidad.setUndId(rss.getInt("UndId"));
                        unidad.setUndDescripcion(rss.getString("UndDescripcion"));
                        unidad.setUndEstado(rss.getInt("UndEstado"));
                        unidades.add(unidad);
                    }  
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
                
            break;                
        }
        
        return unidades;
    }    
     
    /**
    * Metodo que ejecuta el procedimiento almacenado MantenimientoUnidades
    * @param accion String
    * @param unidad Objeto de tipo UnidadesModel
    * @return String que contiene el parametro de salida del procedimiento
    */
   public static String MantenimientoUnidades(String accion, UnidadesModel unidad)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL MantenimientoUnidades(?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, unidad.getUndId());
            cs.setString            (3, unidad.getUndDescripcion());
            cs.setInt            (4, unidad.getUndEstado());
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

