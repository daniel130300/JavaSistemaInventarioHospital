/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.BitacoraLoteModel;
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
public class BitacoraLoteConexion {
    public static ArrayList<BitacoraLoteModel> ListadoBitacoraLote() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<BitacoraLoteModel> bitacoraslote = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT * FROM bitacoraloteproductos;";
            
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
               BitacoraLoteModel bitacoralote = new BitacoraLoteModel();
                bitacoralote.setBcpId(rss.getInt("BcpId"));
                bitacoralote.setUsrUsuario(rss.getString("UsrUsuario"));
                bitacoralote.setBcpAccion(rss.getString("BcpAccion"));
                bitacoralote.setBcpDescripcionCambios(rss.getString("BcpDescripcionCambios"));
                bitacoralote.setBcpFecha(rss.getString("BcpFecha"));
                bitacoraslote.add(bitacoralote);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return bitacoraslote;
    }
     
     public static String BitacoraLoteProductos(String accion, BitacoraLoteModel bitacoralote)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con);
                        
            query = "{CALL BitacoraLoteProductos(?,?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, bitacoralote.getBcpId());
            cs.setString            (3, bitacoralote.getUsrUsuario());
            cs.setString            (4, bitacoralote.getBcpAccion());
            cs.setString            (5, bitacoralote.getBcpDescripcionCambios());
            cs.setString            (6, bitacoralote.getBcpFecha());
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
