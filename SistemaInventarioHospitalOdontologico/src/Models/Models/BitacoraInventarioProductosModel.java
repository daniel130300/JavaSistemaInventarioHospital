/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author Maryury Zuniga
 *  Clase que se encarga de establecer el modelo de datos para la Bitacora del 
 *  Lote de Productos
 */
public class BitacoraInventarioProductosModel 
{
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer BcpId;
    private String UsrUsuario;
    private Integer InvPrdId;
    private String InvPrdCodInterno;    
    private String BcpAccion;
    private String BcpDescripcionCambios;
    private String BcpFecha;


    // **************************************************
    // Getters y Setters
    // **************************************************
    
    public Integer getBcpId() 
    {
        return BcpId;
    }

    public void setBcpId(Integer BcpId) 
    {
        this.BcpId = BcpId;
    }

    public String getUsrUsuario() 
    {
        return UsrUsuario;
    }

    public void setUsrUsuario(String UsrUsuario) 
    {
        this.UsrUsuario = UsrUsuario;
    }

    public String getBcpAccion() {
        return BcpAccion;
    }

    public void setBcpAccion(String BcpAccion) 
    {
        this.BcpAccion = BcpAccion;
    }

    public String getBcpDescripcionCambios() 
    {
        return BcpDescripcionCambios;
    }

    public void setBcpDescripcionCambios(String BcpDescripcionCambios) 
    {
        this.BcpDescripcionCambios = BcpDescripcionCambios;
    }

    public String getBcpFecha() 
    {
        return BcpFecha;
    }

    public void setBcpFecha(String BcpFecha) 
    {
        this.BcpFecha = BcpFecha;
    }

    public Integer getInvPrdId() {
        return InvPrdId;
    }

    public void setInvPrdId(Integer InvPrdId) {
        this.InvPrdId = InvPrdId;
    }

    public String getInvPrdCodInterno() {
        return InvPrdCodInterno;
    }

    public void setInvPrdCodInterno(String InvPrdCodInterno) {
        this.InvPrdCodInterno = InvPrdCodInterno;
    }
}
