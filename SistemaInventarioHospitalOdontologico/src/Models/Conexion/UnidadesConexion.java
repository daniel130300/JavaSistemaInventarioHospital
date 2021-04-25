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
 * @author may_g
 */
public class UnidadesConexion {
    
     public static ArrayList<UnidadesModel> ListadoUnidades() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<UnidadesModel> unidades = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM unidades;";
            
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                UnidadesModel unidad = new UnidadesModel();
                unidad.setUndId(rss.getInt("UndId"));
                unidad.setUndDescripcion(rss.getString("UndDescripcion"));
                unidad.setUndEstado(rss.getString("UndEstado"));;
                unidades.add(unidad);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return unidades;
    }
     
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
            cs.setString            (4, unidad.getUndEstado());
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

