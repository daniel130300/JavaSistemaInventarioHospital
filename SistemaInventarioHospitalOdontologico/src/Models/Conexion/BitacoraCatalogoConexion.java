/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.BitacoraCatalogoModel;
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
public class BitacoraCatalogoConexion {
    
     public static ArrayList<BitacoraCatalogoModel> ListadoBitacoraCatalogo() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<BitacoraCatalogoModel> bitacorascatalogo = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM bitacoracatalogoproductos;";
            
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
               BitacoraCatalogoModel bitacoracatalogo = new BitacoraCatalogoModel();
                bitacoracatalogo.setBcpId(rss.getInt("BcpId"));
                bitacoracatalogo.setUsrUsuario(rss.getString("UsrUsuario"));
                bitacoracatalogo.setBcpAccion(rss.getString("BcpAccion"));
                bitacoracatalogo.setBcpDescripcionCambios(rss.getString("BcpDescripcionCambios"));
                bitacoracatalogo.setBcpFecha(rss.getString("BcpFecha"));
                bitacoracatalogo.setPrdId(rss.getInt("PrdId"));
                bitacorascatalogo.add(bitacoracatalogo);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return bitacorascatalogo;
    }
     
     public static String BitacoraCatalogoProductos(String accion, BitacoraCatalogoModel bitacoracatalogo)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL BitacoraCatalogoProductos(?,?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, bitacoracatalogo.getBcpId());
            cs.setString            (3, bitacoracatalogo.getUsrUsuario());
            cs.setString            (4, bitacoracatalogo.getBcpAccion());
            cs.setString            (5, bitacoracatalogo.getBcpDescripcionCambios());
            cs.setString            (6, bitacoracatalogo.getBcpFecha());
            cs.setInt               (7, bitacoracatalogo.getPrdId());
            cs.registerOutParameter (8, Types.VARCHAR);
            cs.executeUpdate();
            estado = cs.getString(8);
            con.close();
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }   
}
