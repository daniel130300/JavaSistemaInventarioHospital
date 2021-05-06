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
