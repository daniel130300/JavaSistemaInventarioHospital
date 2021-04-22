package Models.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
* @author Héctor López
* Clase que se encarga de establecer el modelo de datos para las áreas
*/

public class AreasModel 
{
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer AreId;
    private String AreDescripcion;

    // **************************************************
    // Getters y Setters
    // **************************************************
    
    public Integer getAreId() 
    {
        return AreId;
    }

    public void setAreId(Integer AreId) 
    {
        this.AreId = AreId;
    }

    public String getAreDescripcion() 
    {
        return AreDescripcion;
    }

    public void setAreDescripcion(String AreDescripcion) 
    {
        this.AreDescripcion = AreDescripcion;
    }
}
