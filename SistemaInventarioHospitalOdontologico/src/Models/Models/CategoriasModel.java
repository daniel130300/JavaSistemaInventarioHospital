/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
*
* @author Héctor López
* Clase que se encarga de definir el modelo para los datos 
* en CategoriasController.
*/
public class CategoriasModel 
{
    
    private Integer CprId;
    private String CprDescripcion;
    private String CprEstado;

    public Integer getCprId() {
        return CprId;
    }

    public void setCprId(Integer CprId) {
        this.CprId = CprId;
    }

    public String getCprDescripcion() {
        return CprDescripcion;
    }

    public void setCprDescripcion(String CprDescripcion) {
        this.CprDescripcion = CprDescripcion;
    }

    public String getCprEstado() {
        return CprEstado;
    }

    public void setCprEstado(String CprEstado) {
        this.CprEstado = CprEstado;
    }
}
