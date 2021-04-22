/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author Katering Osorto
 */
public class InventarioBodegaModel {

    private Integer LprId;
    private Integer PrdId;
    private String PrdNombre;
    private String PrdDescripcion;
    private Integer LprStock;
    private Integer PrdStockMaximo;
    private Integer PrdStockMinimo;
    private String LprFechaCaducidad;
    private String CprDescripcion;
    private String UndDescripcion;
    private String LprEstado;


    public Integer getLprId() {
        return LprId;
    }

    public void setLprId(Integer LprId) {
        this.LprId = LprId;
    }

    public Integer getPrdId() {
        return PrdId;
    }

    public void setPrdId(Integer PrdId) {
        this.PrdId = PrdId;
    }

    public String getPrdNombre() {
        return PrdNombre;
    }

    public void setPrdNombre(String PrdNombre) {
        this.PrdNombre = PrdNombre;
    }

    public String getPrdDescripcion() {
        return PrdDescripcion;
    }

    public void setPrdDescripcion(String PrdDescripcion) {
        this.PrdDescripcion = PrdDescripcion;
    }

    public Integer getLprStock() {
        return LprStock;
    }

    public void setLprStock(Integer LprStock) {
        this.LprStock = LprStock;
    }

    public Integer getPrdStockMaximo() {
        return PrdStockMaximo;
    }

    public void setPrdStockMaximo(Integer PrdStockMaximo) {
        this.PrdStockMaximo = PrdStockMaximo;
    }

    public Integer getPrdStockMinimo() {
        return PrdStockMinimo;
    }

    public void setPrdStockMinimo(Integer PrdStockMinimo) {
        this.PrdStockMinimo = PrdStockMinimo;
    }

    public String getLprFechaCaducidad() {
        return LprFechaCaducidad;
    }

    public void setLprFechaCaducidad(String LprFechaCaducidad) {
        this.LprFechaCaducidad = LprFechaCaducidad;
    }

    public String getCprDescripcion() {
        return CprDescripcion;
    }

    public void setCprDescripcion(String CprDescripcion) {
        this.CprDescripcion = CprDescripcion;
    }

    public String getUndDescripcion() {
        return UndDescripcion;
    }

    public void setUndDescripcion(String UndDescripcion) {
        this.UndDescripcion = UndDescripcion;
    }
    
     public String getLprEstado() {
        return LprEstado;
    }

    public void setLprEstado(String LprEstado) {
        this.LprEstado = LprEstado;
    }
    
}
