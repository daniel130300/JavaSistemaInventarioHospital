/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
*
* @author Héctor López
*/
public class Validaciones 
{
    /**
    * @param campo String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarCampoVacio(String campo)
    {
        return campo.matches("^\\s*$");
    }
    
    /**
    * @param identidad String 
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarIdentidad(String identidad)
    {
        return identidad.matches("\\d{4}-?\\d{4}-?\\d{5}$");
    }
    
    /**
    * 
    * @param usuario String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarUsuario(String usuario)
    {
        return usuario.matches("^[a-zA-Z0-9ÁÉÍÓÚÜÑáéíóúüñ]*$");
    }
    
    /**
    * 
    * @param num String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarNumeros(String num) 
    {
        return num.matches("[0-9]+");
    }

    /**
    * 
    * @param letras String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarLetras(String letras) 
    {
        return letras.matches("[a-zA-ZÁÉÍÓÚÜÑáéíóúüñ ]+");
    }
    
    /**
    * 
    * @param campo String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean ValidarNumerosyLetras(String campo)
    {
       return campo.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$"); 
    }

    /**
    * 
    * @param correo String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarCorreo(String correo) 
    {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return correo.matches(regex);
    }
    
    /**
    * 
    * @param contrasenia String
    * Si el campo coincide con la expresión regular retorna true,
    * de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarContrasenia(String contrasenia) 
    {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return contrasenia.matches(regex);
    }   
    
    /**
    * 
    * @param n1 String 
    * @param n2 String
    * Si n1 es mayor a n2 retorna true de lo contrario retorna false
    * @return Boolean
    */
    public static Boolean validarStocks(String n1 , String n2)
    {
        Integer N1,N2;
        N1= Integer.parseInt(n1);
        N2= Integer.parseInt(n2);
        return N1>=N2;
    }
    
    /**
     * 
     * @param fecha String
     * Si el campo coincide con la expresión regular retorna true,
     * de lo contrario retorna false.
     * @return Boolean
     */
     public static Boolean ValidarFormatoFecha(String fecha)
    {
        String regex= "^\\d{4}([\\-])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$";
        return fecha.matches(regex);
        
    }
    
     /**
      * 
      * @param fecha String
      * Si la fecha de Caducidad es mayor a la fecha actual retorna true,
      * de lo contrario retorna false.
      * @return Boolean
      */
     public static Boolean ValidarFecha(String fecha)
    {
        
        Date ahora = new Date();
        SimpleDateFormat convertidor = new SimpleDateFormat("yyyy-MM-dd");
        String actual = convertidor.format(ahora);
        
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);

                if(fecha.compareTo(actual)<0){
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
                return false;
    }
}
