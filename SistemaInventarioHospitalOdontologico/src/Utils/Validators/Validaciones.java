/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

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
    
    public static Boolean ValidarNumerosyLetras(String campo)
    {
       return campo.matches("^[A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ _]*[A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ][A-Za-z0-9ÁÉÍÓÚÜÑáéíóúüñ _]*$"); 
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
    
    public static Boolean validarStocks(String n1 , String n2)
    {
        Integer N1,N2;
        N1= Integer.parseInt(n1);
        N2= Integer.parseInt(n2);
        if(N1>=N2){return  true;}else{return  false;}
    }
    
    public static boolean validarTabla(JTable proveedor)
    {
        if(0<proveedor.getRowCount())
        {
            return false;
        }
        else
        {
            return true;
        }
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
        
            try 
            {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);

                if(fecha.compareTo(actual)<0)
                {
                    return true;
                }

                } 
            catch (Exception e) 
            {
                return false;
            }
        
        return false;
    }
    
    public static Boolean validarNomenclatura(String letras) 
    {
        return letras.matches("[a-zA-Z]{3}");
    }
}
