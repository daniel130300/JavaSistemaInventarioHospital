/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author Maryury Zuniga
 * Clase que se encarga de definir el modelo de datos para las Unidades
 */
public class UnidadesModel {
    
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer UndId;
    private String UndDescripcion;
    private String UndEstado;

    // **************************************************
    // Getters y Setters
    // **************************************************
    
    public Integer getUndId() 
    {
        return UndId;
    }

    public void setUndId(Integer UndId) 
    {
        this.UndId = UndId;
    }
    
    public String getUndDescripcion() 
    {
        return UndDescripcion;
    }

    public void setUndDescripcion(String UndDescripcion) 
    {
        this.UndDescripcion = UndDescripcion;
    }

    public String getUndEstado() 
    {
        return UndEstado;
    }

    public void setUndEstado(String UndEstado) 
    {
        this.UndEstado = UndEstado;
    } 
}
