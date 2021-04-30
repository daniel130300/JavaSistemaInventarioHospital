/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author fgodo
 */
public class CatalogoProductoModel 
{
        
    private Integer PrdId;
    private String PrdNombre;
    private String PrdDescripcion;
    private String PrdStockMaximo;
    private String PrdStockMinimo;
    private String ProdEstado;
    private Integer CprId;
    private String CprDescripcion;
    public Integer getPrdId() 
    {
        return PrdId;
    }
    public void setPrdId(Integer PrdId) 
    {
        this.PrdId = PrdId;
    }
    public String getPrdNombre() 
    {
        return PrdNombre;
    }
    public void setPrdNombre(String PrdNombre) 
    {
        this.PrdNombre = PrdNombre;
    }
    public String getPrdDescripcion() 
    {
        return PrdDescripcion;
    }
    public void setPrdDescripcion(String PrdDescripcion) 
    {
        this.PrdDescripcion = PrdDescripcion;
    }
    public String getPrdStockMaximo() 
    {
        return PrdStockMaximo;
    }
    public void setPrdStockMaximo(String PrdStockMaximo) 
    {
        this.PrdStockMaximo = PrdStockMaximo;
    }
    public String getPrdStockMinimo() 
    {
        return PrdStockMinimo;
    }
    public void setPrdStockMinimo(String PrdStockMinimo) 
    {
        this.PrdStockMinimo = PrdStockMinimo;
    }    
    public String getProdEstado() 
    {
        return ProdEstado;
    }
    public void setProdEstado(String ProdEstado) 
    {
        this.ProdEstado = ProdEstado;
    }    
    public Integer getCprId() 
    {
        return CprId;
    }
    public void setCprId(Integer CprId) 
    {
        this.CprId = CprId;
    }            
    public String getCprDescripcion() 
    {
        return CprDescripcion;
    }
    public void setCprDescripcion(String CprDescripcion) 
    {
        this.CprDescripcion = CprDescripcion;
    }      
}
