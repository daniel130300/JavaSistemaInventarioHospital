/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

import java.util.ArrayList;

/**
 *
 * @author fgodo
 */
public class DetalleCatalogoProductosModel {
    private Integer DcpId;
    private Integer ProId;
    private Integer PrdId;  
    private String ProNombre;
    private String ProRTN;
    private static ArrayList<Integer> allDcpId = new ArrayList<>();

    public ArrayList<Integer> getAllDcpId() {
        return allDcpId;
    }
    public void setAllDcpId(Integer id) {
        this.allDcpId.add(id);
    } 
    public Integer getDcpId() {
        return DcpId;
    }
    public void setDcpId(Integer DcpId) {
        this.DcpId = DcpId;
    }

    public Integer getProId() {
        return ProId;
    }
    public void setProId(Integer ProId) {
        this.ProId = ProId;
    }
    
    public Integer getPrdId() {
        return PrdId;
    }
    public void setPrdId(Integer PrdId) {
        this.PrdId = PrdId;
    }   
    public String getProNombre() {
        return ProNombre;
    }
    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }       
     public String getProRTN() {
        return ProNombre;
    }
    public void setProRTN(String ProRTN) {
        this.ProRTN = ProRTN;
    } 
    
}
