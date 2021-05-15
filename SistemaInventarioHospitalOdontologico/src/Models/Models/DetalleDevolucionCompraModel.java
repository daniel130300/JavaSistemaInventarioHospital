/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author usuario
 */
public class DetalleDevolucionCompraModel {
    
    private Integer InvPId;
    private String PrdNombre;
    private String InvPDescripcion;
    private String UndDescripcion;
    private String InvPFchCaducidad;
    private Integer DtcCantidad;
    private Double DtcPrecioCompra;
    private String DtctTieneImpuesto;

    public Integer getInvPId() {
        return InvPId;
    }

    public void setInvPId(Integer InvPId) {
        this.InvPId = InvPId;
    }

    public String getPrdNombre() {
        return PrdNombre;
    }

    public void setPrdNombre(String PrdNombre) {
        this.PrdNombre = PrdNombre;
    }

    public String getInvPDescripcion() {
        return InvPDescripcion;
    }

    public void setInvPDescripcion(String InvPDescripcion) {
        this.InvPDescripcion = InvPDescripcion;
    }

    public String getUndDescripcion() {
        return UndDescripcion;
    }

    public void setUndDescripcion(String UndDescripcion) {
        this.UndDescripcion = UndDescripcion;
    }

    public String getInvPFchCaducidad() {
        return InvPFchCaducidad;
    }

    public void setInvPFchCaducidad(String InvPFchCaducidad) {
        this.InvPFchCaducidad = InvPFchCaducidad;
    }

    public Integer getDtcCantidad() {
        return DtcCantidad;
    }

    public void setDtcCantidad(Integer DtcCantidad) {
        this.DtcCantidad = DtcCantidad;
    }

    public Double getDtcPrecioCompra() {
        return DtcPrecioCompra;
    }

    public void setDtcPrecioCompra(Double DtcPrecioCompra) {
        this.DtcPrecioCompra = DtcPrecioCompra;
    }

    public String getDtctTieneImpuesto() {
        return DtctTieneImpuesto;
    }

    public void setDtctTieneImpuesto(String DtctTieneImpuesto) {
        this.DtctTieneImpuesto = DtctTieneImpuesto;
    }
    
    
}
