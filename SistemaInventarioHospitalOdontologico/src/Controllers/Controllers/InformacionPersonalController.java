/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Models.Conexion.InformacionPersonalConexion;
import Models.Conexion.LoginConexion;
import Models.Models.UsuarioModel;
import Utils.Cache.UsuarioLogueadoCache;
import Utils.Validators.Validaciones;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danie
 */
public class InformacionPersonalController 
{
    
    public static boolean EditarInformacionPersonal(String nombre, 
            String apellido, String correo, JLabel errNombre, 
            JLabel errApellido, JLabel errCorreo)
    {
        
        boolean generalValidacionError = false;
        boolean mntError = false;
        
        InformacionPersonalController.setErroresToNull(errNombre, errApellido, errCorreo);
        
        String trimmedNombre = nombre.trim();
        String trimmedApellido = apellido.trim();
        String trimmedCorreo = correo.trim();

        generalValidacionError = InformacionPersonalController.validacionesGenerales(trimmedNombre, 
                trimmedApellido, trimmedCorreo, errNombre, 
                errApellido, errCorreo);
        
        if(!generalValidacionError)
        {
            String resultado = InformacionPersonalConexion.EditarInformacionPersonal(UsuarioLogueadoCache.getUsrId(),
                    nombre, apellido, correo);
            
            switch(resultado)
            {
                case "OK":
                    UsuarioModel usuarioModel = new UsuarioModel();
                    usuarioModel = InformacionPersonalConexion.recuperarInformacionActualizada(UsuarioLogueadoCache.getUsrId());
                    UsuarioLogueadoCache.setUsrNombre(usuarioModel.getUsrNombre());
                    UsuarioLogueadoCache.setUsrApellido(usuarioModel.getUsrApellido());
                    UsuarioLogueadoCache.setUsrCorreo(usuarioModel.getUsrCorreo());
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");
                break;
                
                case "errCorreo":
                    JOptionPane.showMessageDialog(null, "El correo ya se encuentra registrado.");
                    mntError = true;
                break;
            }  
        }
        
       return !(mntError==false && generalValidacionError==false);
    }
    
    private static void setErroresToNull(JLabel errNombre, JLabel errApellido,
            JLabel errCorreo)
    {
        errNombre.setText(null);
        errApellido.setText(null);
        errCorreo.setText(null);
    }
    
     private static boolean validacionesGenerales(String trimmedNombre, 
            String trimmedApellido, String trimmedCorreo, JLabel errNombre, 
            JLabel errApellido, JLabel errCorreo)
    {
        boolean error = false;
        
        if(!Validaciones.validarLetras(trimmedNombre))
        {
           errNombre.setText("El nombre ingresado es incorrecto");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedNombre))
        {
           errNombre.setText("El nombre es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarLetras(trimmedApellido))
        {
           errApellido.setText("El apellido ingresado es incorrecto");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedApellido))
        {
           errApellido.setText("El apellido es un campo obligatorio");
           error = true;
        }
        
        if(!Validaciones.validarCorreo(trimmedCorreo))
        {
            errCorreo.setText("El correo ingresado es incorrecto");
            error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedCorreo))
        {
           errCorreo.setText("El correo es un campo obligatorio");
           error = true;
        }

        return error;
    }
    
    
    public static void setCamposEditar(JTextField txtNombre, 
            JTextField txtApellido, JTextField txtCorreo)
    {
        txtNombre.setText(UsuarioLogueadoCache.getUsrNombre());
        txtApellido.setText(UsuarioLogueadoCache.getUsrApellido());
        txtCorreo.setText(UsuarioLogueadoCache.getUsrCorreo());
    }
    
}
