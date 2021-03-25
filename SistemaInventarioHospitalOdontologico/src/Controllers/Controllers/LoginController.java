package Controllers.Controllers;


import Models.Conexion.LoginConexion;
import Models.Models.PrivilegiosModel;
import Models.Models.UsuarioModel;
import Utils.Cache.UsuarioLogueadoCache;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class LoginController 
{
    public static boolean verificarIniciarSesion(String usuario, 
            String contrasenia, JLabel errUsuario, JLabel errContrasenia, 
            JLabel errGeneral)
    {
        boolean autorizacion = false;
        boolean privilegios = false;
        
        errUsuario.setText(null);
        errContrasenia.setText(null);
        errGeneral.setText(null);
        Boolean generalValidacionError = false;
        
        if(Validaciones.validarCampoVacio(usuario))
        {
           errUsuario.setText("El usuario no puede ir vacio.");
           generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(contrasenia))
        {
           errContrasenia.setText("La contraseña no puede ir vacia.");
           generalValidacionError = true;
        }
                
        if(!generalValidacionError)
        {
            UsuarioModel usuarioModel = new UsuarioModel(); 
            usuarioModel = LoginConexion.getUsuariobyUsr(usuario);

            if(usuarioModel.getUsrId() != null)
            {
                String bddContrasenia = usuarioModel.getUsrContrasenia();

                if(compararContraseniaEncriptada(bddContrasenia, contrasenia))
                {
                    UsuarioLogueadoCache.setUsrId(usuarioModel.getUsrId());
                    UsuarioLogueadoCache.setUsrNombre(usuarioModel.getUsrNombre());
                    UsuarioLogueadoCache.setUsrUsuario(usuarioModel.getUsrUsuario());
                    UsuarioLogueadoCache.setUsrApellido(usuarioModel.getUsrApellido());
                    UsuarioLogueadoCache.setUsrCorreo(usuarioModel.getUsrCorreo());    

                    if(usuarioModel.getUsrEstado().equals("Activo"))
                    {
                        autorizacion = true;
                        privilegios = setUsrLogueadoPrivilegios(UsuarioLogueadoCache.getUsrId(), autorizacion);
                        
                        if(!privilegios)
                        {
                            errGeneral.setText("El usuario no cuenta con privilegios.");
                        }
                    }
                    else
                    {
                        errGeneral.setText("Usuario inactivo.");
                    }
                }
                else
                {
                    errContrasenia.setText("Contraseña incorrecta.");
                }
            }
            else
            {
                errGeneral.setText("Las credenciales son incorrectas.");
            }
        }
        
        return autorizacion && privilegios;
    }

    private static boolean compararContraseniaEncriptada(String cotraseniaBdd, 
            String contraseniaIngresada)
    {
        boolean valido = false; 
       
        String hashedpassword = UsuarioController.sha256Encryption(contraseniaIngresada);

        if(hashedpassword.equals(cotraseniaBdd))
        {
            valido = true;
        }
        
       return valido;
    }
    
    
    private static boolean setUsrLogueadoPrivilegios(Integer UsrId, boolean autorizacion)
    {
        boolean hasPrivileges = false;
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();
        
        if(autorizacion)
        {
            privilegios = LoginConexion.getPrivilegiosUsrLogueado(UsrId);
            
            if(privilegios.size()!=0)
            {
                hasPrivileges = true;
                UsuarioLogueadoCache.setPrivilegios(privilegios);
            }
        }
        
        return hasPrivileges;
    }
    
    public static void setLabelUsrLogueado(JLabel lblUsrLogueado)
    {
        lblUsrLogueado.setText(UsuarioLogueadoCache.getUsrUsuario());
    }
    
    public static void Logout()
    {
        UsuarioLogueadoCache.setUsrId(null);
        UsuarioLogueadoCache.setUsrUsuario(null);
        UsuarioLogueadoCache.setUsrNombre(null);
        UsuarioLogueadoCache.setUsrApellido(null);
        UsuarioLogueadoCache.setUsrCorreo(null);
    }
    
}
