/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.BitacoraInventarioProductosModel;
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

public class BitacoraInventarioProductosConexion 
{
    //****************************
    // Metodos públicos
    //***************************
    
    /**
    * Método que retorna los registros de la tabla bitacoraloteproductos 
    * desde la bdd.
    * @return ArrayList de Objetos Tipo BitacoraLoteModel
    */
    public static ArrayList<BitacoraInventarioProductosModel> ListadoBitacoraInventario() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<BitacoraInventarioProductosModel> bitacorasinventario = new ArrayList<>();
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT BcpId, UsrUsuario, bip.InvPrdId, InvPrdCodInterno, BcpAccion, BcpDescripcionCambios, BcpFecha FROM bitacorainventarioproductos bip INNER JOIN inventarioproductos invp ON bip.InvprdId = invp.InvprdId ORDER BY BcpFecha DESC;;";

            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                BitacoraInventarioProductosModel bitacorainventario = new BitacoraInventarioProductosModel();
                bitacorainventario.setBcpId(rss.getInt("BcpId"));
                bitacorainventario.setUsrUsuario(rss.getString("UsrUsuario"));
                bitacorainventario.setInvPrdCodInterno(rss.getString("InvPrdCodInterno"));
                bitacorainventario.setBcpAccion(rss.getString("BcpAccion"));
                bitacorainventario.setBcpDescripcionCambios(rss.getString("BcpDescripcionCambios"));
                bitacorainventario.setBcpFecha(rss.getString("BcpFecha"));
                bitacorainventario.setInvPrdId(rss.getInt("InvPrdId"));
                bitacorasinventario.add(bitacorainventario);
            } 
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
        return bitacorasinventario;
    }
}
