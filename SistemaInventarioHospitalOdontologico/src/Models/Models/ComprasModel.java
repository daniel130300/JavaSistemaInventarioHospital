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
public class ComprasModel {
        
    private Integer ProId;
    private String CmpFactura;
    private String CmpFotoFacturaPath;
    private String CmpNumeroTransferencia;
    private String CmpOrdenCompra;
    private String CmpFotoOrdenCompraPath;
    private Integer DtcId;
    private Integer CmpId;    
    private Integer InvPrdId;
    private Integer DtcCantidad;
    private Integer DtcTieneImpuesto;
    private Double DtcPrecioCompra;
    private Integer DtcEstado;

    public Integer getCmpId() {
        return CmpId;
    }

    public void setCmpId(Integer CmpId) {
        this.CmpId = CmpId;
    }

    public Integer getDtcId() {
        return DtcId;
    }

    public void setDtcId(Integer DtcId) {
        this.DtcId = DtcId;
    }

    public Integer getInvPrdId() {
        return InvPrdId;
    }

    public void setInvPrdId(Integer InvPrdId) {
        this.InvPrdId = InvPrdId;
    }

    public Integer getDtcCantidad() {
        return DtcCantidad;
    }

    public void setDtcCantidad(Integer DtcCantidad) {
        this.DtcCantidad = DtcCantidad;
    }

    public Integer getDtcTieneImpuesto() {
        return DtcTieneImpuesto;
    }

    public void setDtcTieneImpuesto(Integer DtcTieneImpuesto) {
        this.DtcTieneImpuesto = DtcTieneImpuesto;
    }

    public Double getDtcPrecioCompra() {
        return DtcPrecioCompra;
    }

    public void setDtcPrecioCompra(Double DtcPrecioCompra) {
        this.DtcPrecioCompra = DtcPrecioCompra;
    }

    public Integer getDtcEstado() {
        return DtcEstado;
    }

    public void setDtcEstado(Integer DtcEstado) {
        this.DtcEstado = DtcEstado;
    }
    
    
    

    public Integer getProId() {
        return ProId;
    }

    public void setProId(Integer ProId) {
        this.ProId = ProId;
    }

    public String getCmpFactura() {
        return CmpFactura;
    }

    public void setCmpFactura(String CmpFactura) {
        this.CmpFactura = CmpFactura;
    }

    public String getCmpFotoFacturaPath() {
        return CmpFotoFacturaPath;
    }

    public void setCmpFotoFacturaPath(String CmpFotoFacturaPath) {
        this.CmpFotoFacturaPath = CmpFotoFacturaPath;
    }

    public String getCmpNumeroTransferencia() {
        return CmpNumeroTransferencia;
    }

    public void setCmpNumeroTransferencia(String CmpNumeroTransferencia) {
        this.CmpNumeroTransferencia = CmpNumeroTransferencia;
    }

    public String getCmpOrdenCompra() {
        return CmpOrdenCompra;
    }

    public void setCmpOrdenCompra(String CmpOrdenCompra) {
        this.CmpOrdenCompra = CmpOrdenCompra;
    }

    public String getCmpFotoOrdenCompraPath() {
        return CmpFotoOrdenCompraPath;
    }

    public void setCmpFotoOrdenCompraPath(String CmpFotoOrdenCompraPath) {
        this.CmpFotoOrdenCompraPath = CmpFotoOrdenCompraPath;
    }
}
