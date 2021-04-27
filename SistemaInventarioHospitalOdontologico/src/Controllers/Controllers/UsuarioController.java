/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Models.Conexion.UsuarioConexion;
import Models.Models.AreasModel;
import Models.Models.DetalleUsuariosModel;
import Models.Models.PrivilegiosModel;
import Models.Models.UsuarioModel;
import Utils.Cache.UsuariosCache;
import Utils.PlaceHolders.TextPrompt;
import Utils.Validators.Validaciones;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
* @author Héctor López
*/
public class UsuarioController extends GeneralController
{   
    // **************************************************
    // Métodos Públicos
    // **************************************************

    public static void setPlaceHolders(JTextField txtIdentidad, JTextField txtNombre, 
            JTextField txtApellido, JTextField txtCorreo, JTextField txtUsuario,
            JTextField txtContrasenia, JTextField txtBuscar)
    {
        TextPrompt placeholderIdentidad = new TextPrompt(" Ej: 0801200054321 ", txtIdentidad);
        TextPrompt placeholderNombre = new TextPrompt(" Ingrese el nombre de la persona ", txtNombre);
        TextPrompt placeholderApellido = new TextPrompt(" Ingrese el apellido de la persona ", txtApellido);
        TextPrompt placeholderCorreo = new TextPrompt(" Ingrese el correo de la persona ", txtCorreo);
        TextPrompt placeholderUsuario = new TextPrompt(" Ingrese el usuario de la persona ", txtUsuario);
        TextPrompt placeholderContrasenia = new TextPrompt(" Ingrese el usuario de la persona ", txtContrasenia);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
    
    /**
    * 
    * @param accion String
    * @param id Integer
    * @param identidad String
    * @param nombre String
    * @param apellido String
    * @param correo String
    * @param usuario String
    * @param contrasenia String
    * @param estado String
    * @param id_area Integer
    * @param errIdentidad JLabel
    * @param errNombre JLabel
    * @param errApellido JLabel
    * @param errCorreo JLabel
    * @param errUsuario JLabel
    * @param errContrasenia JLabel
    * @param errEstado JLabel
    * @param errPrivilegios JLabel
    * @param modeloLstPrivilegiosSeleccionados JLabel
    * Si los datos ingresados son incorrectos de acorde a las validaciones
    * retorna true, de lo contrario retorna false 
    * @return Boolean
    */
    public static Boolean MantenimientoUsuarios(String accion, Integer id, 
            String identidad, String nombre, String apellido, String correo, 
            String usuario, String contrasenia, String estado, Integer id_area,
            JLabel errIdentidad, JLabel errNombre, JLabel errApellido, 
            JLabel errCorreo, JLabel errUsuario, JLabel errContrasenia, 
            JLabel errEstado, JLabel errPrivilegios, DefaultListModel modeloLstPrivilegiosSeleccionados)
    { 
        Boolean contraseniaValidacionError = false;
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        Boolean dohash = false;
        
        UsuarioController.setErroresToNull(errIdentidad, errNombre, errApellido, errCorreo, errUsuario, errContrasenia, errEstado, errPrivilegios);

        String trimmedIdentidad = identidad.trim();
        String trimmedNombre = nombre.trim();
        String trimmedApellido = apellido.trim();
        String trimmedCorreo = correo.trim();
        String trimmedUsuario = usuario.trim();
        String trimmedContrasenia = contrasenia.trim();

        generalValidacionError = UsuarioController.validacionesGenerales(trimmedIdentidad, trimmedNombre, 
               trimmedApellido, trimmedCorreo, trimmedUsuario, modeloLstPrivilegiosSeleccionados, 
               errIdentidad, errNombre, errApellido, errCorreo, 
               errUsuario, errPrivilegios);
        
        if(generalValidacionError == false)
        {
            switch(accion)
            {
                case "insertar":
                    if(!Validaciones.validarContrasenia(trimmedContrasenia))
                    {
                        errContrasenia.setText("<html>La contraseña debe contener al menos una mayúscula,<br/>"
                                + "una letra minuscula, un digito y un caracter especial!</html>");
                        contraseniaValidacionError = true;
                    }

                    if(Validaciones.validarCampoVacio(trimmedContrasenia))
                    {
                        errContrasenia.setText("La contraseña es un campo obligatorio");
                        contraseniaValidacionError = true;
                    }
                    
                    if(contraseniaValidacionError == false)
                    {
                        mntError = UsuarioController.insertarUsuario(
                                trimmedIdentidad, trimmedNombre, trimmedApellido, 
                                trimmedCorreo, trimmedUsuario, trimmedContrasenia, 
                                id_area, modeloLstPrivilegiosSeleccionados);
                    }  
                break;
                
                case "editar":
                    if(!trimmedContrasenia.equals(""))
                    {
                        if(!Validaciones.validarContrasenia(trimmedContrasenia))
                        {
                            errContrasenia.setText("<html>La contraseña debe contener al menos una mayúscula,<br/>"
                                    + "una letra minuscula, un digito y un caracter especial.</html>");
                            contraseniaValidacionError = true;
                        }
                        dohash = true;
                    }
                    
                    if(contraseniaValidacionError == false)
                    {
                        mntError = UsuarioController.editarUsuario(dohash, id, 
                                trimmedIdentidad, trimmedNombre, 
                                trimmedApellido, trimmedCorreo, trimmedUsuario, 
                                trimmedContrasenia, estado, id_area, 
                                modeloLstPrivilegiosSeleccionados);
                    }    
                break;
            }
        }
        
        return !(mntError == false && generalValidacionError == false 
                && contraseniaValidacionError == false);
    }
    
    /**
    * 
    * @param data String
    * Método que se encarga de encriptar el parámetro que recibe
    * @return String encriptado por medio del algoritmo sha256
    */
    public static String sha256Encryption(String data)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) 
            {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    /**
    * 
    * @param cmbAreas JComboBox
    * Método que se encarga de llenar el JComboBox cmbAreas
    * con los datos que se obtienen del método ListadoAreas() 
    * de la clase UsuarioConexion
    */
    public static void LlenarCmbAreas(JComboBox cmbAreas)
    {
        ArrayList<AreasModel> areas = new ArrayList<>();
        areas = UsuarioConexion.ListadoAreas();
        
        for (int i = 0; i<areas.size(); i++)
        {
            cmbAreas.addItem(areas.get(i).getAreDescripcion());
        }
    }
    
    /**
    * @param tableUsuarios JTable
    * Método que se encarga de llenar el JTable tableUsuarios
    * con los datos que se obtienen del método ListadoUsuarios() 
    * de la clase UsuarioConexion dependiendo de la acción
     * que el usuario realice.
    */
    public static void LlenarTableUsuarios(JTable tableUsuarios,String accion) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel(); 
        modelo.setRowCount(0);
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        
        switch(accion)
        {
            case "Activos":
                usuarios = UsuarioConexion.ListadoUsuarios("Activos");

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
                break;
            case "Inactivos":
                usuarios = UsuarioConexion.ListadoUsuarios("Inactivos");

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
                break;
            case "Todos":
                usuarios = UsuarioConexion.ListadoUsuarios("Todos");

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
                break;
        }
    }
    
    /**
    * 
    * @param tableUsuarios JTable
    * @param fieldBusqueda JTextField 
    * Método que se encarga de filtrar la tabla Usuarios
    * a partir de la busqueda del usuario
    */
    public static void FiltroTableUsuarios(JTable tableUsuarios, JTextField fieldBusqueda)
    {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tableUsuarios.getModel());
        tableUsuarios.setRowSorter(rowSorter);
        fieldBusqueda.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = fieldBusqueda.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }
        );  
    }
    
    /**
     * 
     * @param seleccion Integer
     * @param tableUsuarios JTable
     * @param txtIdentidad JTextField
     * @param txtNombre JTextField
     * @param txtApellido JTextField
     * @param txtCorreo JTextField
     * @param txtUsuario String
     * @param cmbEstado JComboBox
     * @param cmbArea JComboBox
     * Método que se encarga de pasar los campos de la tabla a los JTextFields
     * y JComboxes correspondientes para poder ser editados 
     * y retorna el Id del usuario de la tabla
     * @return Integer
     */
    public static Integer setDatosEditarFromTable(Integer seleccion, JTable tableUsuarios, 
            JTextField txtIdentidad, JTextField txtNombre, 
            JTextField txtApellido, JTextField txtCorreo, JTextField txtUsuario,
            JComboBox cmbEstado, JComboBox cmbArea)
    {
        Integer UsrId = null;
        UsrId = Integer.parseInt((String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 0)))); 
        txtIdentidad.setText(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 1)));
        txtNombre.setText(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 2)));
        txtApellido.setText(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 3)));
        txtCorreo.setText(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 4)));
        txtUsuario.setText(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion, 5)));
        cmbEstado.setSelectedItem(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion,6)));
        cmbArea.setSelectedItem(String.valueOf(tableUsuarios.getModel().getValueAt(seleccion,8)));
        
        return UsrId;
    }
    
    /**
    * 
    * @param tableUsuarios JTable
    * @param txtIdentidad JTextField
    * @param txtNombre JTextField
    * @param txtApellido JTextField
    * @param txtCorreo JTextField
    * @param txtUsuario JTextField
    * @param cmbEstado JComboBox
    * @param cmbArea JComboBox
    * Método que se encarga de pasar los campos de la clase usuarioCache a 
    * los JTextFields y JComboxes correspondientes para poder ser editados y
    * retorna el Id del usuario
    * @return Integer
    */
    public static Integer setDatosEditarFromCache(JTable tableUsuarios, 
            JTextField txtIdentidad, JTextField txtNombre, 
            JTextField txtApellido, JTextField txtCorreo, JTextField txtUsuario,
            JComboBox cmbEstado, JComboBox cmbArea)
    {
        Integer UsrId = null;
        UsuariosCache usuarioCache = new UsuariosCache();
        if(usuarioCache.isDatosCompartidos())
        {
            UsrId = usuarioCache.getUsuario().getUsrId();
            txtIdentidad.setText(usuarioCache.getUsuario().getUsrIdentidad());
            txtNombre.setText(usuarioCache.getUsuario().getUsrNombre());
            txtApellido.setText(usuarioCache.getUsuario().getUsrApellido());
            txtCorreo.setText(usuarioCache.getUsuario().getUsrCorreo());
            txtUsuario.setText(usuarioCache.getUsuario().getUsrUsuario());
            cmbEstado.setSelectedItem(usuarioCache.getUsuario().getUsrEstado());
            cmbArea.setSelectedItem(usuarioCache.getUsuario().getAreDescripcion());
        }
        
        return UsrId;
    }
    
    /**
    * 
    * @param modelo DefaultListModel
    * Método que se encarga de llenar el DefaultListModel del JList 
    * lstPrivilegiosDisponibles con los datos que se obtienen del método 
    * ListadoPrivilegios() de la clase UsuarioConexion
    */
    public static void LlenarListPrivilegios(DefaultListModel modelo)
    {
        modelo.clear();
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();
        privilegios = UsuarioConexion.ListadoPrivilegios();
        
        for (int i = 0; i<privilegios.size(); i++)
        {
            modelo.addElement(privilegios.get(i).getPriDescripcion());
        }
    }
    
    /**
    * 
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * @param modeloLstPrivilegiosDisponibles DefaultListModel
    * @param UsrId Integer
    * Método que se encarga de llenar el DefaultListModel del JList 
    * lstPrivilegiosSeleccionados con los datos que se obtienen del método 
    * getUsrPrivilegiosDescripcion(Integer UsrId) de la clase UsuarioConexion
    * y de remover los privilegios seleccionados de los privilegios disponibles.
    */
    public static void LlenarListPrivilegiosUsuario(DefaultListModel modeloLstPrivilegiosSeleccionados, DefaultListModel modeloLstPrivilegiosDisponibles, Integer UsrId)
    {
        modeloLstPrivilegiosSeleccionados.clear();
        ArrayList<PrivilegiosModel> privilegios = new ArrayList<>();
        privilegios = UsuarioConexion.getUsrPrivilegiosDescripcion(UsrId);
        
        for (int i = 0; i<privilegios.size(); i++)
        {
            modeloLstPrivilegiosSeleccionados.addElement(privilegios.get(i).getPriDescripcion());
            modeloLstPrivilegiosDisponibles.removeElement(privilegios.get(i).getPriDescripcion());
        }
    }
    
    /**
    * 
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel 
    * @param lstPrivilegiosDisponibles JList
    * @param modeloLstPrivilegiosDisponibles DefaultListModel
    * Método que se encarga de mover los privilegios seleccionados en el modeloLstPrivilegiosDisponibles a el modeloLstPrivilegiosSeleccionados
    */    
    public static void AgregarListPrivilegiosSeleccionados(DefaultListModel modeloLstPrivilegiosSeleccionados, JList lstPrivilegiosDisponibles, DefaultListModel modeloLstPrivilegiosDisponibles)
    {
        for(Object selectedValue:lstPrivilegiosDisponibles.getSelectedValuesList())
        {
            modeloLstPrivilegiosSeleccionados.addElement(selectedValue);  
            modeloLstPrivilegiosDisponibles.removeElement(selectedValue);
        }
    }
    
    /**
    * 
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * @param lstPrivilegiosSeleccionados JList
    * @param modeloLstPrivilegiosDisponibles DefaultListModel
    * Método que se encarga de mover los privilegios seleccionados en el modeloLstPrivilegiosSeleccionados a el modeloLstPrivilegiosDisponibles
    */
    public static void QuitarListPrivilegiosSeleccionados(DefaultListModel modeloLstPrivilegiosSeleccionados, JList lstPrivilegiosSeleccionados, DefaultListModel modeloLstPrivilegiosDisponibles)
    {
        for(Object selectedValue:lstPrivilegiosSeleccionados.getSelectedValuesList())
        {
            modeloLstPrivilegiosDisponibles.addElement(selectedValue);  
            modeloLstPrivilegiosSeleccionados.removeElement(selectedValue);
        }
    }
    
    // **************************************************
    // Métodos Privados
    // **************************************************
    
    /**
    * 
    * @param errIdentidad JLabel
    * @param errNombre JLabel
    * @param errApellido JLabel
    * @param errCorreo JLabel
    * @param errUsuario JLabel
    * @param errContrasenia JLabel
    * @param errEstado JLabel
    * @param errPrivilegios JLabel
    * Método que se encarga de limpiar el texto dentro de los JLabels que recibe
    */
    private static void setErroresToNull(JLabel errIdentidad, JLabel errNombre, 
            JLabel errApellido, JLabel errCorreo, JLabel errUsuario, 
            JLabel errContrasenia, JLabel errEstado, JLabel errPrivilegios)
    {
        errIdentidad.setText(null);
        errNombre.setText(null);
        errApellido.setText(null);
        errCorreo.setText(null);
        errUsuario.setText(null);
        errContrasenia.setText(null);
        errEstado.setText(null);
        errPrivilegios.setText(null);
    }
    
    /**
    * 
    * @param trimmedIdentidad String
    * @param trimmedNombre String
    * @param trimmedApellido String 
    * @param trimmedCorreo String
    * @param trimmedUsuario String
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * @param errIdentidad JLabel
    * @param errNombre JLabel
    * @param errApellido JLabel
    * @param errCorreo JLabel
    * @param errUsuario JLabel
    * @param errPrivilegios JLabel
    * Si los datos ingresados son incorrectos de acorde a las validaciones
    * establece los errores en los JLabels correspondientes y retorna true, 
    * de lo contrario retorna false. 
    * @return boolean
    */
    private static boolean validacionesGenerales(String trimmedIdentidad, 
            String trimmedNombre,String trimmedApellido, String trimmedCorreo, 
            String trimmedUsuario,DefaultListModel modeloLstPrivilegiosSeleccionados, 
            JLabel errIdentidad, JLabel errNombre, JLabel errApellido,
            JLabel errCorreo, JLabel errUsuario, JLabel errPrivilegios)
    {
        boolean error = false;
        
        if(!Validaciones.validarIdentidad(trimmedIdentidad))
        {
           errIdentidad.setText("La identidad ingresada es incorrecta");
           error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedIdentidad))
        {
           errIdentidad.setText("La identidad es un campo obligatorio");
           error = true;
        }
               
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
        
        if(!Validaciones.validarUsuario(trimmedUsuario))
        {
            errUsuario.setText("El usuario ingresado es incorrecto");
            error = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedUsuario))
        {
            errUsuario.setText("El usuario es un campo obligatorio");
            error = true;
        } 
        
        if(modeloLstPrivilegiosSeleccionados.getSize() == 0)
        {
            errPrivilegios.setText("No ha seleccionado ningún privilegio");
            error = true;
        }
        
        return error;
    }
    
    /**
     * 
    * @param id Integer
    * @param trimmedIdentidad String
    * @param trimmedNombre String
    * @param trimmedApellido String
    * @param trimmedCorreo String
    * @param trimmedUsuario String
    * @param hashedpassword String
    * @param estado String
    * @param id_area Integer
    * Método que se encarga de crear un objeto de tipo UsuarioModel a partir 
    * de los parametros recibidos y retornar este mismo. 
    * @return Objeto de tipo UsuarioModel
    */
    private static UsuarioModel setUsuarioModel(Integer id, String trimmedIdentidad,
            String trimmedNombre, String trimmedApellido, String trimmedCorreo,
            String trimmedUsuario, String hashedpassword, String estado,
            Integer id_area)
    {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setUsrId(id);
        usuarioModel.setUsrIdentidad(trimmedIdentidad);
        usuarioModel.setUsrNombre(trimmedNombre);
        usuarioModel.setUsrApellido(trimmedApellido);
        usuarioModel.setUsrCorreo(trimmedCorreo);
        usuarioModel.setUsrUsuario(trimmedUsuario);
        usuarioModel.setUsrContrasenia(hashedpassword);
        usuarioModel.setUsrEstado(estado);
        usuarioModel.setAreId(id_area+1);
        
        return usuarioModel;
    }
    
    /**
    * 
    * @param trimmedIdentidad String
    * @param trimmedNombre String
    * @param trimmedApellido String
    * @param trimmedCorreo String
    * @param trimmedUsuario String
    * @param trimmedContrasenia String
    * @param id_area Integer
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * Método que se encarga de insertar un usuario en la bdd, si los datos 
    * como la identidad, correo o usuario no se encuentran ya registrados, 
    * de ser así se muestra el respectivo mensaje de error.
    * @return Si hay un error de validación retorna true de lo contrario false.
    */
    private static boolean insertarUsuario(String trimmedIdentidad, 
            String trimmedNombre, String trimmedApellido, String trimmedCorreo, 
            String trimmedUsuario, String trimmedContrasenia, Integer id_area, 
            DefaultListModel modeloLstPrivilegiosSeleccionados)
    {
        boolean error = false;
        String hashedpassword = null;
        
        Integer id = 0; 
        String estado = "Activo";

        UsuarioModel usuarioModel = new UsuarioModel();
        hashedpassword = UsuarioController.sha256Encryption(trimmedContrasenia);

        usuarioModel = UsuarioController.setUsuarioModel(id, 
                trimmedIdentidad, trimmedNombre, 
                trimmedApellido, trimmedCorreo, trimmedUsuario, 
                hashedpassword, estado, id_area);

        String resultado = UsuarioConexion.MantenimientoUsuarios("insertar", usuarioModel);

        switch (resultado) 
        {
            case "OK":
                if(MantenimientoDetalleUsuarios("insertar", id, modeloLstPrivilegiosSeleccionados) == false)
                {
                    JOptionPane.showMessageDialog(null, "Usuario ingresado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error ingresando los privilegios.");
                }
            break;

            case "errIdentidad":
                JOptionPane.showMessageDialog(null, "La identidad ya se encuentra registrada.");
                error = true;
            break;

            case "errCorreo":
                JOptionPane.showMessageDialog(null, "El correo ya se encuentra registrado.");
                error = true;
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        
        return error;
    }
    
    /**
    * 
    * @param dohash boolean
    * @param id Integer
    * @param trimmedIdentidad String
    * @param trimmedNombre String
    * @param trimmedApellido String
    * @param trimmedCorreo String
    * @param trimmedUsuario String
    * @param trimmedContrasenia String
    * @param estado String
    * @param id_area Integer
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * Método que se encarga de editar un usuario en la bdd, si los datos 
    * como la identidad, correo o usuario no se encuentran ya registrados, 
    * de ser así se muestra el respectivo mensaje de error.
    * @return Si hay un error de validación retorna true de lo contrario false.
    */
    private static boolean editarUsuario(boolean dohash, 
            Integer id, String trimmedIdentidad, String trimmedNombre,
            String trimmedApellido, String trimmedCorreo, String trimmedUsuario,
            String trimmedContrasenia, String estado, Integer id_area, 
            DefaultListModel modeloLstPrivilegiosSeleccionados)
    {
        boolean error = false; 
        String hashedpassword = null;
        UsuarioModel usuarioModel = new UsuarioModel();

        if(dohash)
        {
            hashedpassword = UsuarioController.sha256Encryption(trimmedContrasenia);
        }

        usuarioModel = UsuarioController.setUsuarioModel(id, 
                trimmedIdentidad, trimmedNombre, 
                trimmedApellido, trimmedCorreo, trimmedUsuario, 
                hashedpassword, estado, id_area);

        String resultado = UsuarioConexion.MantenimientoUsuarios("editar", usuarioModel);

        switch (resultado) 
        {
            case "OK":
                if(MantenimientoDetalleUsuarios("editar", id, modeloLstPrivilegiosSeleccionados) == false)
                {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito.");    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error actualizando los privilegios.");
                }
            break;

            case "errIdentidad":
                JOptionPane.showMessageDialog(null, "La identidad ya se encuentra registrada.");
                error = true;
            break;

            case "errCorreo":
                JOptionPane.showMessageDialog(null, "El correo ya se encuentra registrado.");
                error = true;
            break;

            case "errUsuario":
                JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado.");
                error = true;
            break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación.");
                error = true;
            break;
        }
        
        return error;
    }
    
    /**
    * 
    * @param accion String 
    * @param UsrId Integer
    * @param modeloLstPrivilegiosSeleccionados DefaultListModel
    * Método que se encarga de insertar o editar los privilegios seleccionados 
    * para el usuario
    * @return Si hay un error de validación retorna true de lo contrario false.
    */
    private static Boolean MantenimientoDetalleUsuarios(String accion, 
            Integer UsrId, DefaultListModel modeloLstPrivilegiosSeleccionados)
    {
        boolean error = false;
        DetalleUsuariosModel detalleUsuariosModel = new DetalleUsuariosModel();
        ArrayList<Integer> Indexes = new ArrayList<>();
        ArrayList<String> Privilegios = new ArrayList<>();
        
        for(int i=0; i<modeloLstPrivilegiosSeleccionados.getSize(); i++)
        {
            Privilegios.add(modeloLstPrivilegiosSeleccionados.get(i).toString());
        }

        Indexes = UsuarioConexion.getIndexesofLstElements(Privilegios);
        
        switch(accion)
        {
            case "insertar":
                error = false;
                for(int i=0; i<modeloLstPrivilegiosSeleccionados.getSize(); i++)
                {
                    detalleUsuariosModel.setDtuId(0);
                    detalleUsuariosModel.setUsrId(0);
                    detalleUsuariosModel.setPriId(Indexes.get(i));
                    String estado = UsuarioConexion.MantenimientoDetalleUsuarios(accion, detalleUsuariosModel);
                    
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
            break;
            
            case "editar":
                error = false;
                ArrayList<Integer> DtuIds = new ArrayList<>();
                DtuIds = UsuarioConexion.getDtuIndexesofUsr(UsrId);
                
                for(Integer Id:DtuIds)
                {
                    detalleUsuariosModel.setDtuId(Id);
                    detalleUsuariosModel.setUsrId(0);
                    detalleUsuariosModel.setPriId(0);
                    String estado = UsuarioConexion.MantenimientoDetalleUsuarios("eliminar", detalleUsuariosModel);
                    
                    if(!estado.equals("OK"))
                    {
                        error = true;
                    }
                }
                
                if(!error)
                {
                    for(int i=0; i<modeloLstPrivilegiosSeleccionados.getSize(); i++)
                    {
                        detalleUsuariosModel.setDtuId(0);
                        detalleUsuariosModel.setUsrId(UsrId);
                        detalleUsuariosModel.setPriId(Indexes.get(i));
                        String estado = UsuarioConexion.MantenimientoDetalleUsuarios(accion, detalleUsuariosModel);

                        if(!estado.equals("OK"))
                        {
                            error = true;
                        }
                    }
                }
            break;
        }
        return error;
    }
}
