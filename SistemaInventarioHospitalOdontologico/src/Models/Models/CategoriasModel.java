/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
*
* @author Héctor López
* Clase que se encarga de establecer el modelo de datos para las Categorías
*/
public class CategoriasModel 
{
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer CprId;
    private String CprNomenclatura;
    private String CprDescripcion;
    private String CprEstado;
    
    // **************************************************
    // Getters y Setters
    // **************************************************
    public String getCprNomenclatura() 
    {
        return CprNomenclatura;
    }
    public void setCprNomenclatura(String CprNomenclatura) {
        this.CprNomenclatura = CprNomenclatura;
    }

    public Integer getCprId() {
        return CprId;
    }

    public void setCprId(Integer CprId) 
    {
        this.CprId = CprId;
    }

    public String getCprDescripcion() 
    {
        return CprDescripcion;
    }

    public void setCprDescripcion(String CprDescripcion) 
    {
        this.CprDescripcion = CprDescripcion;
    }

    public String getCprEstado() 
    {
        return CprEstado;
    }

    public void setCprEstado(String CprEstado) 
    {
        this.CprEstado = CprEstado;
    }
}
