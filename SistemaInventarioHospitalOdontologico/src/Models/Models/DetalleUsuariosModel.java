package Models.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
*
* @author Héctor López 
* Clase que se encarga de establecer el modelo de datos para los privilegios 
* del usuario a editar o registrarse 
*/
public class DetalleUsuariosModel 
{
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer DtuId;
    private Integer UsrId;
    private Integer PriId;
    
    // **************************************************
    // Getters y Setters
    // **************************************************

    public Integer getDtuId() 
    {
        return DtuId;
    }

    public void setDtuId(Integer DtuId) 
    {
        this.DtuId = DtuId;
    }

    public Integer getUsrId() {
        return UsrId;
    }

    public void setUsrId(Integer UsrId) 
    {
        this.UsrId = UsrId;
    }

    public Integer getPriId() 
    {
        return PriId;
    }

    public void setPriId(Integer PriId) 
    {
        this.PriId = PriId;
    }
}
