/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author may_g
 */
public class BitacoraCatalogoModel {
    
    private Integer BcpId;
    private String UsrUsuario;
    private String BcpAccion;
    private String BcpDescripcionCambios;
    private String BcpFecha;
    private Integer PrdId;

    public Integer getBcpId() {
        return BcpId;
    }

    public void setBcpId(Integer BcpId) {
        this.BcpId = BcpId;
    }

    public String getUsrUsuario() {
        return UsrUsuario;
    }

    public void setUsrUsuario(String UsrUsuario) {
        this.UsrUsuario = UsrUsuario;
    }

    public String getBcpAccion() {
        return BcpAccion;
    }

    public void setBcpAccion(String BcpAccion) {
        this.BcpAccion = BcpAccion;
    }

    public String getBcpDescripcionCambios() {
        return BcpDescripcionCambios;
    }

    public void setBcpDescripcionCambios(String BcpDescripcionCambios) {
        this.BcpDescripcionCambios = BcpDescripcionCambios;
    }

    public String getBcpFecha() {
        return BcpFecha;
    }

    public void setBcpFecha(String BcpFecha) {
        this.BcpFecha = BcpFecha;
    }

    public Integer getPrdId() {
        return PrdId;
    }

    public void setPrdId(Integer PrdId) {
        this.PrdId = PrdId;
    }
    
    
}
