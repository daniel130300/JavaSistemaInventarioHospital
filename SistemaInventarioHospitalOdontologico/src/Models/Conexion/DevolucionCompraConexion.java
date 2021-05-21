/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.DetalleDevolucionCompraModel;
import Models.Models.DevolucionCompraModel;
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
 * @author usuario
 */
public class DevolucionCompraConexion {
    
    public static ArrayList<DevolucionCompraModel> ListadoDevolucionCompra() 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<DevolucionCompraModel> DevolucionCompra = new ArrayList<>();
 
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT cmp.CmpId, cmp.ProId, pro.ProRTN, pro.ProNombre, " 
                                 + "cmp.CmpFactura, cmp.CmpNumeroTransferencia, cmp.CmpOrdenCompra, " 
                                 + "cmp.CmpFecha, cmp.UsrUsuario " 
                                 + "FROM compras cmp INNER JOIN proveedores pro " 
                                 + "ON cmp.ProId = pro.ProId "
                                 + "ORDER BY cmp.CmpId ASC; ";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        DevolucionCompraModel devolucioncompra = new DevolucionCompraModel();
                        devolucioncompra.setCmpId(rss.getInt("CmpId"));
                        devolucioncompra.setProId(rss.getInt("ProId"));
                        devolucioncompra.setProRTN(rss.getString("ProRTN"));;
                        devolucioncompra.setProNombre(rss.getString("ProNombre"));
                        devolucioncompra.setCmpFactura(rss.getString("CmpFactura"));
                        devolucioncompra.setCmpNumeroTransferencia(rss.getString("CmpNumeroTransferencia"));
                        devolucioncompra.setCmpOrdenCompra(rss.getString("CmpOrdenCompra"));
                        devolucioncompra.setCmpFecha(rss.getString("CmpFecha"));
                        devolucioncompra.setUsrUsuario(rss.getString("UsrUsuario"));               
                        DevolucionCompra.add(devolucioncompra);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
                
        return DevolucionCompra;
    }
    
    public static ArrayList<DetalleDevolucionCompraModel> ListadoDetalleDevolucionCompra(Integer CmpId) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<DetalleDevolucionCompraModel> DetalleDevolucionCompra = new ArrayList<>();
 
                try
                {
                    con = Conexion.getConexion(con);
                    stm = con.createStatement();
                    
                    String query = "SELECT ivp.InvPId, ctp.PrdNombre, ivp.InvPDescripcion, " 
                                 + "und.UndDescripcion, ivp.InvPFchCaducidad, dtc.DtcCantidad, " 
                                 + "dtc.DtctTieneImpuesto, dtc.DtcPrecioCompra "
                                 + "FROM catalogoproductos ctp INNER JOIN inventariopadre ivp " 
                                 + "ON ctp.PrdId = ivp.PrdId INNER JOIN detallecompras dtc " 
                                 + "ON ivp.InvPId = dtc.InvPrdId INNER JOIN unidades und "
                                 + "ON ivp.UndId = und.UndId " 
                                 + "WHERE dtc.DtcEstado = 1 AND dtc.CmpId = "+CmpId+"; ";

                    rss = stm.executeQuery(query);

                    while (rss.next()) 
                    {
                        DetalleDevolucionCompraModel detalledevolucioncompra = new DetalleDevolucionCompraModel();
                        detalledevolucioncompra.setInvPId(rss.getInt("InvPId"));
                        detalledevolucioncompra.setPrdNombre(rss.getString("PrdNombre"));
                        detalledevolucioncompra.setInvPDescripcion(rss.getString("InvPDescripcion"));;
                        detalledevolucioncompra.setUndDescripcion(rss.getString("UndDescripcion"));
                        detalledevolucioncompra.setInvPFchCaducidad(rss.getString("InvPFchCaducidad"));
                        detalledevolucioncompra.setDtcCantidad(rss.getInt("DtcCantidad"));
                        detalledevolucioncompra.setDtctTieneImpuesto(rss.getString("DtctTieneImpuesto"));
                        detalledevolucioncompra.setDtcPrecioCompra(rss.getDouble("DtcPrecioCompra"));               
                        DetalleDevolucionCompra.add(detalledevolucioncompra);
                    } 
                    
                    con.close();
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
                
        return DetalleDevolucionCompra;
    }
    
     public static Double SubTotal1(Integer CmpId, Double ISV)
    {
        double SubTotal = 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT ROUND(SUM((dtc.DtcPrecioCompra * '"+ISV+"' ) + (dtc.DtcCantidad*dtc.DtcPrecioCompra)), 2) AS TOTAL " 
                          + "FROM inventariopadre ivp INNER JOIN detallecompras dtc " 
                          + "ON ivp.InvPId = dtc.InvPrdId "
                          + "WHERE dtc.DtcEstado = 1 AND dtc.CmpId = '"+CmpId+"' AND dtc.DtctTieneImpuesto = 1;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                SubTotal=rss.getDouble("TOTAL");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return SubTotal;
    }
     
       public static Double SubTotal2(Integer CmpId)
    {
        double SubTotal = 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT ROUND(SUM(dtc.DtcCantidad*dtc.DtcPrecioCompra), 2) AS TOTAL " 
                          + "FROM inventariopadre ivp INNER JOIN detallecompras dtc " 
                          + "ON ivp.InvPId = dtc.InvPrdId "
                          + "WHERE dtc.DtcEstado = 1 AND dtc.CmpId = '"+CmpId+"' AND dtc.DtctTieneImpuesto = 0;";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                SubTotal=rss.getDouble("TOTAL");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return SubTotal;
    }
     
       public static Double ISV(Integer CmpId)
    {
        double ISV = 0;
        Connection con = null;
        Statement stm;
        ResultSet rss;    
        try 
        {
            con = Conexion.getConexion(con);
            stm = con.createStatement();
            String query = "SELECT  CmpIsv FROM compras " 
                         + "WHERE CmpId = '"+CmpId+"'";
             
            rss = stm.executeQuery(query);
            
            while (rss.next()) 
            {
                ISV=rss.getDouble("CmpIsv");
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }  
        return ISV;
    }
       
    public static String ActualizarCantidadInventarioPadre(Integer InvPId, Integer Cantidad)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            query = "{CALL ActualizarCantidadInventarioPadre(?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setInt               (1, InvPId);
            cs.setInt               (2, Cantidad);
            cs.executeUpdate();
            
            con.close();
 
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }
    
    public static String ActualizarEstadoDetalleCompras(Integer InvPId)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            query = "{CALL ActualizarEstadoDetalleCompras(?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setInt            (1, InvPId);
            cs.executeUpdate();
            
            con.close();
 
        }
        catch (SQLException e)
        {
            estado = e.toString();
        } 
        return estado;
    }
}
