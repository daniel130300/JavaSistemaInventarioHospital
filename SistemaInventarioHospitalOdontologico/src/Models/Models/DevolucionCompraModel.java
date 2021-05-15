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
public class DevolucionCompraModel {
    
    private Integer CmpId;
    private Integer ProId;
    private String ProRTN;
    private String ProNombre;
    private String CmpFactura;
    private String CmpNumeroTransferencia;
    private String CmpOrdenCompra;
    private String CmpFecha;
    private String UsrUsuario;

    public Integer getCmpId() {
        return CmpId;
    }

    public void setCmpId(Integer CmpId) {
        this.CmpId = CmpId;
    }

    public Integer getProId() {
        return ProId;
    }

    public void setProId(Integer ProId) {
        this.ProId = ProId;
    }

    public String getProRTN() {
        return ProRTN;
    }

    public void setProRTN(String ProRTN) {
        this.ProRTN = ProRTN;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getCmpFactura() {
        return CmpFactura;
    }

    public void setCmpFactura(String CmpFactura) {
        this.CmpFactura = CmpFactura;
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

    public String getCmpFecha() {
        return CmpFecha;
    }

    public void setCmpFecha(String CmpFecha) {
        this.CmpFecha = CmpFecha;
    }

    public String getUsrUsuario() {
        return UsrUsuario;
    }

    public void setUsrUsuario(String UsrUsuario) {
        this.UsrUsuario = UsrUsuario;
    }
    
    
}
