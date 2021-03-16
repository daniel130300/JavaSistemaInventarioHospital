/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Models.Conexion.UsuarioConexion;
import Models.Models.AreasModel;
import Models.Models.UsuarioModel;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author danie
 */
public class UsuarioController extends GeneralController
{   
    
    public static Boolean MantenimientoUsuarios(String accion, Integer id, 
            String identidad, String nombre, String apellido, String correo, 
            String usuario, String contrasenia, String estado, Integer id_area,
            JLabel errIdentidad, JLabel errNombre, JLabel errApellido, 
            JLabel errCorreo, JLabel errUsuario, JLabel errContrasenia, 
            JLabel errEstado)
    { 
        Boolean contraseniaValidacionError = false;
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errIdentidad.setText(null);
        errNombre.setText(null);
        errApellido.setText(null);
        errCorreo.setText(null);
        errUsuario.setText(null);
        errContrasenia.setText(null);
        errEstado.setText(null);

        if(!Validaciones.validarIdentidad(identidad))
        {
           errIdentidad.setText("La identidad ingresada es incorrecta");
           generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(identidad))
        {
           errIdentidad.setText("La identidad es un campo obligatorio");
           generalValidacionError = true;
        }
               
        if(!Validaciones.validarLetras(nombre))
        {
            errNombre.setText("El nombre ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(nombre))
        {
           errNombre.setText("El nombre es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarLetras(apellido))
        {
           errApellido.setText("El apellido ingresado es incorrecto");
           generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(apellido))
        {
           errApellido.setText("El apellido es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarCorreo(correo))
        {
            errCorreo.setText("El correo ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(correo))
        {
           errCorreo.setText("El correo es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarUsuario(usuario))
        {
            errUsuario.setText("El usuario ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(usuario))
        {
            errUsuario.setText("El usuario es un campo obligatorio");
            generalValidacionError = true;
        }
        
        if(generalValidacionError == false)
        {
            switch(accion)
            {
                case "insertar":
                    if(!Validaciones.validarContrasenia(contrasenia))
                    {
                        errContrasenia.setText("La contraseña debe contener una letra mayúscula"
                        + "\ndebe contener una letra minuscula,"
                        + "\ndebe contener un digito y"
                        + "\nun caracter especial!");
                        contraseniaValidacionError = true;
                    }

                    if(Validaciones.validarCampoVacio(contrasenia))
                    {
                        errContrasenia.setText("La contraseña es un campo obligatorio");
                        contraseniaValidacionError = true;
                    }
                    
                    if(contraseniaValidacionError == false)
                    {
                        id = 0; 
                        estado = "Activo";
                        UsuarioModel usuarioModel = new UsuarioModel();
                        usuarioModel.setUsrId(id);
                        usuarioModel.setUsrIdentidad(identidad);
                        usuarioModel.setUsrNombre(nombre);
                        usuarioModel.setUsrApellido(apellido);
                        usuarioModel.setUsrCorreo(correo);
                        usuarioModel.setUsrUsuario(usuario);
                        usuarioModel.setUsrContrasenia(contrasenia);
                        usuarioModel.setUsrEstado(estado);
                        usuarioModel.setAreId(id_area+1);
                        
                        String resultado = UsuarioConexion.MantenimientoUsuarios(accion, usuarioModel);
                        System.out.println(resultado);
                        /*
                        if(resultado.equals("correcto"))
                        {
                            JOptionPane.showMessageDialog(null, "Se ha ingresado el usuario con éxito");
                        }
                        else if (resultado.equals("errIdentidad"))
                        {
                            JOptionPane.showMessageDialog(null, "La identidad ya se encuentra ingresada en la bdd");
                            mntError = true;
                        }
                        else if (resultado.equals("errCorreo"))
                        {
                            JOptionPane.showMessageDialog(null, "El correo ya se encuentra ingresado en la bdd");
                            mntError = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación");
                            mntError = true;
                        }
                        */
                    }  
                break;
                
                case "editar":
                    
                    
                break;
            }
        }
        
        return mntError;
    }
    
    public static void LlenarCmbAreas(JComboBox cmbAreas)
    {
        ArrayList<AreasModel> areas = new ArrayList<>();
        areas = UsuarioConexion.ListadoAreas();
        
        for (int i = 0; i<areas.size(); i++)
        {
            cmbAreas.addItem(areas.get(i).getAreDescripcion());
        }
    }

    public static void LlenarTableUsuarios(JTable tableUsuarios) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel(); 
        modelo.setRowCount(0);
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        usuarios = UsuarioConexion.ListadoUsuarios();
        
        for (int i = 0; i <usuarios.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    usuarios.get(i).getUsrId(), 
                    usuarios.get(i).getUsrIdentidad(),
                    usuarios.get(i).getUsrNombre(),
                    usuarios.get(i).getUsrApellido(),
                    usuarios.get(i).getUsrCorreo(),
                    usuarios.get(i).getUsrUsuario(),
                    usuarios.get(i).getUsrEstado(),
                    usuarios.get(i).getAreId(),
                    usuarios.get(i).getAreDescripcion()
                }
            );
        }
        FormatoTabla(tableUsuarios, modelo.getColumnCount());
    }
}
