/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.InventarioNietoModel;
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
public class InventarioNietoConexion {
    
     public static ArrayList<InventarioNietoModel> ListadoInventarioNieto() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<InventarioNietoModel> inventarioN = new ArrayList<>();
         try 
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    String query = "SELECT ivN.InvNId, ivN.InvNDescripcion, ivN.InvNCantidad, "
                                    + "ivN.InvHId, UndDescripcion "
                                    +"FROM inventariohospital.inventarionieto ivN " 
                                    +"INNER JOIN unidades und "
                                    +"ON ivN.UndId = und.UndId ";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        InventarioNietoModel invN = new InventarioNietoModel();
                        invN.setInvNId(rss.getInt("InvNId"));
                        invN.setInvNDescripcion(rss.getString("InvNDescripcion"));
                        invN.setInvNCantidad(rss.getInt("InvNCantidad"));;
                        invN.setInvHId(rss.getInt("InvHId"));
                        invN.setUndId(rss.getString("UndDescripcion"));
                        
                        inventarioN.add(invN);
                    } 
                    con.close();
                } 
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null,e);

                }
        return inventarioN;
    }

     public static Integer UltimoInvHId ()
    {   
        Integer Id=0;
        Connection con = null;
        Statement stm;
        ResultSet rss;
        try
        {
            con=Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT InvHId FROM inventariohijo"
                         + " WHERE InvHId =(SELECT MAX(InvHId)FROM inventariohijo); ";
            
            rss = stm.executeQuery(query);
            
            while(rss.next())
            {
                Id = rss.getInt("InvHId");
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
     * @param Nieto
    * Método que se encarga de ejecutar el procedimiento almacenado 
    * MantenimientoInventarioBodega.
    * @return String el cual contiene el parametro de salida del procedimiento. 
    */
    public static String MantenimientoInventarioNieto(String accion, InventarioNietoModel Nieto)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            query = "{CALL MantenimientoInventarioNieto(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, Nieto.getInvNId());
            cs.setString            (3, Nieto.getInvNDescripcion());
            cs.setInt               (4, Nieto.getInvNCantidad());
            cs.setInt               (5, Nieto.getInvHId());
            cs.setInt               (6, InventarioPadreConexion.getIdUnidad(Nieto.getUndId()));
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
    
}
