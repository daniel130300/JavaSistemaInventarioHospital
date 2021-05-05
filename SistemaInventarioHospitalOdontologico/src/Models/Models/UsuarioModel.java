/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Models;

/**
*
* @author Héctor López
* Clase que se encarga de definir el modelo de datos para los usuarios
*/
public class UsuarioModel 
{
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer UsrId;
    private String UsrIdentidad;
    private String UsrNombre;
    private String UsrApellido;
    private String UsrCorreo;
    private String UsrUsuario;
    private String UsrContrasenia;
    private Integer UsrEstado;
    private Integer AreId;
    private String AreDescripcion;
    
    // **************************************************
    // Getters y Setters
    // **************************************************
    
    public Integer getUsrId() 
    {
        return UsrId;
    }

    public void setUsrId(Integer UsrId) 
    {
        this.UsrId = UsrId;
    }

    public String getUsrIdentidad() 
    {
        return UsrIdentidad;
    }

    public void setUsrIdentidad(String UsrIdentidad) 
    {
        this.UsrIdentidad = UsrIdentidad;
    }

    public String getUsrNombre() 
    {
        return UsrNombre;
    }

    public void setUsrNombre(String UsrNombre) 
    {
        this.UsrNombre = UsrNombre;
    }

    public String getUsrApellido() 
    {
        return UsrApellido;
    }

    public void setUsrApellido(String UsrApellido) 
    {
        this.UsrApellido = UsrApellido;
    }

    public String getUsrCorreo() 
    {
        return UsrCorreo;
    }

    public void setUsrCorreo(String UsrCorreo) 
    {
        this.UsrCorreo = UsrCorreo;
    }

    public String getUsrUsuario() 
    {
        return UsrUsuario;
    }

    public void setUsrUsuario(String UsrUsuario) 
    {
        this.UsrUsuario = UsrUsuario;
    }

    public String getUsrContrasenia() 
    {
        return UsrContrasenia;
    }

    public void setUsrContrasenia(String UsrContrasenia) 
    {
        this.UsrContrasenia = UsrContrasenia;
    }

    public Integer getUsrEstado() {
        return UsrEstado;
    }

    public void setUsrEstado(Integer UsrEstado) {
        this.UsrEstado = UsrEstado;
    }

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
