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
public class KitModel {
    private Integer KitId;
    private String KitNombre;
    private String KitDescripcion;
    private Integer KitEstado;
    private Integer DtkId;
    private Integer PrdId;
    private String PrdNombre;
    private Integer UndId;
    private String UndDescripcion;
    private Integer DtkcCantidad;
    private static ArrayList<Integer> allDtId = new ArrayList<>();

    public String getPrdNombre() {
        return PrdNombre;
    }

    public void setPrdNombre(String PrdNombre) {
        this.PrdNombre = PrdNombre;
    }

    public String getUndDescripcion() {
        return UndDescripcion;
    }

    public void setUndDescripcion(String UndDescripcion) {
        this.UndDescripcion = UndDescripcion;
    }

    public ArrayList<Integer> getAllDtId() {
        return allDtId;
    }

    public void setAllDtId(Integer id) {
        this.allDtId.add(id);
    }

    public Integer getUndId() {
        return UndId;
    }

    public void setUndId(Integer UndId) {
        this.UndId = UndId;
    }

    public Integer getKitId() {
        return KitId;
    }

    public void setKitId(Integer KitId) {
        this.KitId = KitId;
    }

    public String getKitNombre() {
        return KitNombre;
    }

    public void setKitNombre(String KitNombre) {
        this.KitNombre = KitNombre;
    }

    public String getKitDescripcion() {
        return KitDescripcion;
    }

    public void setKitDescripcion(String KitDescripcion) {
        this.KitDescripcion = KitDescripcion;
    }

    public Integer getKitEstado() {
        return KitEstado;
    }

    public void setKitEstado(Integer KitEstado) {
        this.KitEstado = KitEstado;
    }

    public Integer getDtkId() {
        return DtkId;
    }

    public void setDtkId(Integer DtkId) {
        this.DtkId = DtkId;
    }

    public Integer getPrdId() {
        return PrdId;
    }

    public void setPrdId(Integer PrdId) {
        this.PrdId = PrdId;
    }


    public Integer getDtkcCantidad() {
        return DtkcCantidad;
    }

    public void setDtkcCantidad(Integer DtkcCantidad) {
        this.DtkcCantidad = DtkcCantidad;
    }
    
    
    
    
    
    
}
