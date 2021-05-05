/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.CategoriasModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
* @author Héctor López
*/

public class CategoriaConexion 
{   
    
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Método que retorna los registros de la tabla categoriasproductos
    * desde la bdd, dependiendo de la accion que realice el usuario; mostrar todos 
    * los registros, solo los activos o solo los inactivos.
     * @param accion
    * @return ArrayList de objeto tipo CategoriasModel
    */
    public static ArrayList<CategoriasModel> ListadoCategorias(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<CategoriasModel> categorias = new ArrayList<>();
        switch(accion)
        {
            case "Activos":
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT *FROM categoriasproductos"
                            + " WHERE CprEstado = 1";

                     rss = stm.executeQuery(query); 

                     while(rss.next())
                     {
                        CategoriasModel categoria = new CategoriasModel();
                        categoria.setCprId(rss.getInt("CprId"));
                        categoria.setCprNomenclatura(rss.getString("CprNomenclatura"));
                        categoria.setCprDescripcion(rss.getString("CprDescripcion"));
                        categoria.setCprEstado(rss.getInt("CprEstado"));
                        categorias.add(categoria);
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
                    String query = "SELECT *FROM categoriasproductos "
                            + "WHERE CprEstado = 0";


                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                       CategoriasModel categoria = new CategoriasModel();
                       categoria.setCprId(rss.getInt("CprId"));
                       categoria.setCprNomenclatura(rss.getString("CprNomenclatura"));
                       categoria.setCprDescripcion(rss.getString("CprDescripcion"));
                       categoria.setCprEstado(rss.getInt("CprEstado"));
                       categorias.add(categoria);
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
                    String query = "SELECT *FROM categoriasproductos ";

                    rss = stm.executeQuery(query); 

                    while(rss.next())
                    {
                        CategoriasModel categoria = new CategoriasModel();
                        categoria.setCprId(rss.getInt("CprId"));
                        categoria.setCprNomenclatura(rss.getString("CprNomenclatura"));
                        categoria.setCprDescripcion(rss.getString("CprDescripcion"));
                        categoria.setCprEstado(rss.getInt("CprEstado"));
                        categorias.add(categoria);
                    }  
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            break;                
        }
        return categorias;
    }    
    
    /**
    * @param accion String
    * @param categoria Objeto de tipo CategoriasModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoCategorias
    * @return String el cual contiene el parametro de salida del procedimiento.
    */
    public static String MantenimientoCategorias(String accion, CategoriasModel categoria)
    {
        String estado = "";
        Connection con = null;
        
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL MantenimientoCategorias(?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, categoria.getCprId());
            cs.setString            (3, categoria.getCprNomenclatura());
            cs.setString            (4, categoria.getCprDescripcion());
            cs.setInt               (5, categoria.getCprEstado());
            cs.registerOutParameter (6, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(6);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }   
}
