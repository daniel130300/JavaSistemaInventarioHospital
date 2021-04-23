/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Conexion;

import Models.Models.InventarioBodegaModel;
import Utils.Cache.UsuarioLogueadoCache;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class InventarioBodegaConexion 
{
    
    // **************************************************
    // Métodos Públicos
    // **************************************************
    
    
    /**
    * @param accion String
    * Método que retorna los registros de la tabla Lote producto y Catalogos de productos desde la bdd,
    * dependiendo de la acción que el usuario realice, ya sea mostrar los registros inactivos, activos o 
    * todos.
    * @return ArrayList de objetos tipo InventarioBodegaModel
    */
    public static ArrayList<InventarioBodegaModel> ListadoInventarioBodega(String accion) 
    {
        Connection con = null;
        Statement stm;
        ResultSet rss;
        
        ArrayList<InventarioBodegaModel> bodega = new ArrayList<>();
        switch (accion){
            
            case "Activos":
                            try 
                            {
                                con = Conexion.getConexion(con);
                                stm = con.createStatement();
                                String query = "SELECT l.LprId, p.PrdId, p.PrdNombre, p.PrdDescripcion, "
                                               + "l.LprStock, p.PrdStockMaximo, p.PrdStockMinimo, " 
                                               + "l.LprFechaCaducidad, c.CprDescripcion, u.UndDescripcion, l.LprEstado "
                                               + "FROM loteproductos l INNER JOIN catalogoproductos p ON l.PrdId = p.PrdId "
                                               + "INNER JOIN categoriasproductos c ON p.CprId = c.CprId "
                                               + "INNER JOIN unidades u ON p.UndId = u.UndId "
                                               + "WHERE l.LprEstado = 'Activo' "
                                               + "ORDER BY l.LprFechaCaducidad ASC";

                                rss = stm.executeQuery(query);

                                while (rss.next()) 
                                {
                                    InventarioBodegaModel inventario = new InventarioBodegaModel();
                                    inventario.setLprId(rss.getInt("LprId"));
                                    inventario.setPrdId(rss.getInt("PrdId"));
                                    inventario.setPrdNombre(rss.getString("PrdNombre"));;
                                    inventario.setPrdDescripcion(rss.getString("PrdDescripcion"));
                                    inventario.setLprStock(rss.getInt("LprStock"));
                                    inventario.setPrdStockMaximo(rss.getInt("PrdStockMaximo"));
                                    inventario.setPrdStockMinimo(rss.getInt("PrdStockMinimo"));
                                    inventario.setLprFechaCaducidad(rss.getString("LprFechaCaducidad"));
                                    inventario.setCprDescripcion(rss.getString("CprDescripcion"));
                                    inventario.setUndDescripcion(rss.getString("UndDescripcion"));
                                    inventario.setLprEstado(rss.getString("LprEstado"));
                                    bodega.add(inventario);
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
                                String query = "SELECT l.LprId, p.PrdId, p.PrdNombre, p.PrdDescripcion, "
                                               + "l.LprStock, p.PrdStockMaximo, p.PrdStockMinimo, " 
                                               + "l.LprFechaCaducidad, c.CprDescripcion, u.UndDescripcion, l.LprEstado "
                                               + "FROM loteproductos l INNER JOIN catalogoproductos p ON l.PrdId = p.PrdId "
                                               + "INNER JOIN categoriasproductos c ON p.CprId = c.CprId "
                                               + "INNER JOIN unidades u ON p.UndId = u.UndId "
                                               + "WHERE l.LprEstado = 'Inactivo' "
                                               + "ORDER BY l.LprFechaCaducidad ASC";

                                rss = stm.executeQuery(query);

                                while (rss.next()) 
                                {
                                    InventarioBodegaModel inventario = new InventarioBodegaModel();
                                    inventario.setLprId(rss.getInt("LprId"));
                                    inventario.setPrdId(rss.getInt("PrdId"));
                                    inventario.setPrdNombre(rss.getString("PrdNombre"));;
                                    inventario.setPrdDescripcion(rss.getString("PrdDescripcion"));
                                    inventario.setLprStock(rss.getInt("LprStock"));
                                    inventario.setPrdStockMaximo(rss.getInt("PrdStockMaximo"));
                                    inventario.setPrdStockMinimo(rss.getInt("PrdStockMinimo"));
                                    inventario.setLprFechaCaducidad(rss.getString("LprFechaCaducidad"));
                                    inventario.setCprDescripcion(rss.getString("CprDescripcion"));
                                    inventario.setUndDescripcion(rss.getString("UndDescripcion"));
                                    inventario.setLprEstado(rss.getString("LprEstado"));
                                    bodega.add(inventario);
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
                                String query = "SELECT l.LprId, p.PrdId, p.PrdNombre, p.PrdDescripcion, "
                                               + "l.LprStock, p.PrdStockMaximo, p.PrdStockMinimo, " 
                                               + "l.LprFechaCaducidad, c.CprDescripcion, u.UndDescripcion, l.LprEstado "
                                               + "FROM loteproductos l INNER JOIN catalogoproductos p ON l.PrdId = p.PrdId "
                                               + "INNER JOIN categoriasproductos c ON p.CprId = c.CprId "
                                               + "INNER JOIN unidades u ON p.UndId = u.UndId "
                                               + "ORDER BY l.LprFechaCaducidad ASC";

                                rss = stm.executeQuery(query);

                                while (rss.next()) 
                                {
                                    InventarioBodegaModel inventario = new InventarioBodegaModel();
                                    inventario.setLprId(rss.getInt("LprId"));
                                    inventario.setPrdId(rss.getInt("PrdId"));
                                    inventario.setPrdNombre(rss.getString("PrdNombre"));;
                                    inventario.setPrdDescripcion(rss.getString("PrdDescripcion"));
                                    inventario.setLprStock(rss.getInt("LprStock"));
                                    inventario.setPrdStockMaximo(rss.getInt("PrdStockMaximo"));
                                    inventario.setPrdStockMinimo(rss.getInt("PrdStockMinimo"));
                                    inventario.setLprFechaCaducidad(rss.getString("LprFechaCaducidad"));
                                    inventario.setCprDescripcion(rss.getString("CprDescripcion"));
                                    inventario.setUndDescripcion(rss.getString("UndDescripcion"));
                                    inventario.setLprEstado(rss.getString("LprEstado"));
                                    bodega.add(inventario);
                                } 
                                con.close();
                            } 
                            catch (SQLException e) 
                            {
                                JOptionPane.showMessageDialog(null,e);

                            }
                            break;
            
        }
        
        return bodega;
    }
    
    /**
     * 
     * @param accion String
     * @param inventario InventarioBodegaModel
     * Método que se encarga de ejecutar el procedimiento almacenado 
     * MantenimientoInventarioBodega.
     * @return String el cual contiene el parametro de salida del procedimiento. 
     */
    public static String MantenimientoInventarioBodega(String accion, InventarioBodegaModel inventario)
    {
        String estado = "";
        Connection con = null;
        try
        {
            String query;
            con = Conexion.getConexion(con); 
            
            CrearTablaTemporal(con);
            
            query = "{CALL MantenimientoInventarioBodega(?,?,?,?,?,?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString            (1, accion);
            cs.setInt               (2, inventario.getLprId());
            cs.setString            (3, inventario.getLprFechaCaducidad());
            cs.setInt               (4, inventario.getLprStock());
            cs.setString            (5, inventario.getLprEstado());
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
    
    // **************************************************
    // Método Privado
    // **************************************************
    
    /**
     * Método que se encarga de crear la tabla temporal
     * loggedusuario para guardar el id usuario que esta
     * loggueado en el momento. 
     */
    private static void CrearTablaTemporal(Connection conexion){
        Connection con = null;
        PreparedStatement stm;     
        try 
        {
            con = conexion;
            String query = "CREATE TEMPORARY TABLE IF NOT EXISTS loggedusuario "
                    + "AS (SELECT * FROM usuarios WHERE UsrId = ?) ";
            UsuarioLogueadoCache usuario = new UsuarioLogueadoCache();
            stm = con.prepareStatement(query);
            stm.setInt(1, usuario.getUsrId());
            stm.executeUpdate();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }      
        
    }
}
