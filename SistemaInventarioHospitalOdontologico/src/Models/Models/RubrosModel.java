/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
 *
 * @author Héctor López
 * Clase que se encarga de definir el modelo de datos para los Rubros
 */
public class RubrosModel 
{
    
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer RubId;
    private String RubDescripcion;
    private String RubEstado;

    // **************************************************
    // Getters y Setters
    // **************************************************

    public Integer getRubId() 
    {
        return RubId;
    }

    public void setRubId(Integer RubId) 
    {
        this.RubId = RubId;
    }

    public String getRubDescripcion() 
    {
        return RubDescripcion;
    }

    public void setRubDescripcion(String RubDescripcion) 
    {
        this.RubDescripcion = RubDescripcion;
    }

    public String getRubEstado() 
    {
        return RubEstado;
    }

    public void setRubEstado(String RubEstado) 
    {
        this.RubEstado = RubEstado;
    }
}
