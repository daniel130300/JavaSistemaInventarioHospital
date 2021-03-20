/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Validators;

/**
 *
 * @author danie
 */
public class Validaciones 
{
    public static Boolean validarCampoVacio(String campo)
    {
        return campo.matches("^\\s*$");
    }
    
    public static Boolean validarIdentidad(String identidad)
    {
        return identidad.matches("\\d{4}-?\\d{4}-?\\d{5}$");
    }
    
    public static Boolean validarUsuario(String usuario)
    {
        return usuario.matches("^[a-zA-Z0-9ÁÉÍÓÚÜÑáéíóúüñ]*$");
    }
    
    public static Boolean validarNumeros(String num) 
    {
        return num.matches("[0-9]+");
    }

    public static Boolean validarLetras(String letras) 
    {
        return letras.matches("[a-zA-ZÁÉÍÓÚÜÑáéíóúüñ ]+");
    }

    public static Boolean validarCorreo(String correo) 
    {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return correo.matches(regex);
    }
    
    public static Boolean validarContrasenia(String contrasenia) 
    {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return contrasenia.matches(regex);
    }    
}
