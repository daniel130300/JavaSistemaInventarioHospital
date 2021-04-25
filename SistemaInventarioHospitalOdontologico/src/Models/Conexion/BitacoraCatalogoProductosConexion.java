/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.BitacoraCatalogoProductosModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * 
 * @author Héctor López
 * 
 */
public class BitacoraCatalogoProductosConexion 
{
    
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Método que retorna los registros de la tabla bitacoracatalogoproductos
    * desde la bdd.
    * @return ArrayList de Objetos Tipo BitacoraCatalogoModel
    */
    public static ArrayList<BitacoraCatalogoProductosModel> ListadoBitacoraCatalogo() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<BitacoraCatalogoProductosModel> bitacorascatalogo = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT BcpId, UsrUsuario, PrdId, BcpAccion, BcpDescripcionCambios, BcpFecha FROM bitacoracatalogoproductos;";
            
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                BitacoraCatalogoProductosModel bitacoracatalogo = new BitacoraCatalogoProductosModel();
                bitacoracatalogo.setBcpId(rss.getInt("BcpId"));
                bitacoracatalogo.setUsrUsuario(rss.getString("UsrUsuario"));
                bitacoracatalogo.setPrdId(rss.getInt("PrdId"));
                bitacoracatalogo.setBcpAccion(rss.getString("BcpAccion"));
                bitacoracatalogo.setBcpDescripcionCambios(rss.getString("BcpDescripcionCambios"));
                bitacoracatalogo.setBcpFecha(rss.getString("BcpFecha"));
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
}
