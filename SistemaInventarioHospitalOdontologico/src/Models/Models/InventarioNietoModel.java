/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author Maryury Zuniga
 * Clase que se encarga de establecer el modelo de datos para el Inventario Nieto
 */
public class InventarioNietoModel {
    
    // **************************************************
    // Variables
    // **************************************************
    private Integer InvNId;
    private String InvNDescripcion;
    private Integer InvNCantidad;
    private Integer InvHId;
    private String UndId;

    // **************************************************
    // Getters y Setters
    // **************************************************
    public Integer getInvNId() {
        return InvNId;
    }

    public void setInvNId(Integer InvNId) {
        this.InvNId = InvNId;
    }

    public String getInvNDescripcion() {
        return InvNDescripcion;
    }

    public void setInvNDescripcion(String InvNDescripcion) {
        this.InvNDescripcion = InvNDescripcion;
    }

    public Integer getInvNCantidad() {
        return InvNCantidad;
    }

    public void setInvNCantidad(Integer InvNCantidad) {
        this.InvNCantidad = InvNCantidad;
    }

    public Integer getInvHId() {
        return InvHId;
    }

    public void setInvHId(Integer InvHId) {
        this.InvHId = InvHId;
    }

    public String getUndId() {
        return UndId;
    }

    public void setUndId(String UndId) {
        this.UndId = UndId;
    }
    
    
}
