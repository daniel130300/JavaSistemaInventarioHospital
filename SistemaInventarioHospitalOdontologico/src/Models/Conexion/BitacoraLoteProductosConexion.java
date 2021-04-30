/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.BitacoraLoteProductosModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
* 
* @author Héctor López
*/

public class BitacoraLoteProductosConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Método que retorna los registros de la tabla bitacoraloteproductos 
    * desde la bdd.
    * @return ArrayList de Objetos Tipo BitacoraLoteModel
    */
    public static ArrayList<BitacoraLoteProductosModel> ListadoBitacoraLote() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<BitacoraLoteProductosModel> bitacoraslote = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT BcpId,UsrUsuario,LprId,a.PrdId,c.PrdNombre,a.BcpAccion,BcpDescripcionCambios,BcpFecha  FROM bitacoracatalogoproductos a " 
                            + " INNER JOIN loteproductos b on a.PrdId=b.PrdId" 
                            + " INNER JOIN catalogoproductos c on c.PrdId=b.PrdId" 
                            + " ORDER BY BcpFecha DESC;";

            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                BitacoraLoteProductosModel bitacoralote = new BitacoraLoteProductosModel();
                bitacoralote.setBcpId(rss.getInt("BcpId"));
                bitacoralote.setUsrUsuario(rss.getString("UsrUsuario"));
                bitacoralote.setLprId(rss.getInt("LprId"));
                bitacoralote.setPrdId(rss.getInt("PrdId"));
                bitacoralote.setPrdNombre(rss.getString("PrdNombre"));
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
}
