/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.InventarioHijoModel;
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
 * @author Katering Osorto
 */
public class InventarioHijoConexion 
{
    // **************************************************
    // Métodos Públicos
    // **************************************************
    public static ArrayList<InventarioHijoModel> ListadoInventarioHijo() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<InventarioHijoModel> inventarioH = new ArrayList<>();
         try 
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT ivh.InvHId, ivh.InvHDescripcion, ivh.InvHCantidad, "
                                    + "ivh.InvPId, UndDescripcion "
                                    +"FROM inventariohospital.inventariohijo ivh " 
                                    +"INNER JOIN unidades und "
                                    +"ON ivh.UndId = und.UndId ";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        InventarioHijoModel inventarioh = new InventarioHijoModel();
                        inventarioh.setInvHId(rss.getInt("InvHId"));
                        inventarioh.setInvHDescripcion(rss.getString("InvHDescripcion"));
                        inventarioh.setInvHCantidad(rss.getInt("InvHCantidad"));;
                        inventarioh.setInvPId(rss.getInt("InvPId"));
                        inventarioh.setUndId(rss.getString("UndDescripcion"));
                        
                        inventarioH.add(inventarioh);
                    } 
                    con.close();
                } 
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null,e);

                }
        return inventarioH;
    }
    
     public static Integer UltimoInvPId ()
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT InvPId FROM inventariopadre"
                         + " WHERE InvPId =(SELECT MAX(InvPId)FROM inventariopadre); ";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("InvPId");
            }    
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return Id;
    }     
     
    /**
    * 
    * @param accion String
     * @param inventarioh
     * @param InvPId
    * @param inventario InventarioBodegaModel
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoInventarioBodega.
    * @return String el cual contiene el parametro de salida del procedimiento. 
    */
    public static String MantenimientoInventarioHijo(String accion, InventarioHijoModel inventarioh)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            query = "{CALL MantenimientoInventarioHijo(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, inventarioh.getInvHId());
            cs.setString            (3, inventarioh.getInvHDescripcion());
            cs.setInt               (4, inventarioh.getInvHCantidad());
            cs.setInt               (5, inventarioh.getInvPId());
            cs.setInt               (6, InventarioPadreConexion.getIdUnidad(inventarioh.getUndId()));
            cs.registerOutParameter (7, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(7);
            
            con.close();
 
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }
    
    // **************************************************
    // Método Privado
    // **************************************************
    
    /**
    * Método que se encarga de crear la tabla temporal
    * loggedusuario para guardar el id usuario que esta
    * loggueado en el momento. 
    */
}
