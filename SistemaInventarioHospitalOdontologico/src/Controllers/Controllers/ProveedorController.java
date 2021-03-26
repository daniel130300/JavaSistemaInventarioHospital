/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import static Controllers.Controllers.GeneralController.FormatoTabla;
import Models.Conexion.ProveedorConexion;
import Models.Models.ProveedorModel;
import Utils.Validators.Validaciones;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Utils.Cache.ProveedorCache;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author danie
 */
public class ProveedorController 
{
    public static Boolean MantenimientoProveedores(String accion, Integer id, 
            String rtn, String nombre, String correo, String telefono, 
            String contacto, String direccion,JLabel errRTN, JLabel errNombre,
            JLabel errCorreo,JLabel errTelefono, JLabel errContacto, JLabel errDireccion)
    {
        
        Boolean generalValidacionError = false;
        Boolean mntError = false;
        
        errRTN.setText(null);
        errNombre.setText(null);
        errCorreo.setText(null);
        errCorreo.setText(null);
        errTelefono.setText(null);
        errContacto.setText(null);
        errDireccion.setText(null);
        
        String trimmedRTN = rtn.trim();
        String trimmedNombre = nombre.trim();
        String trimmedCorreo = correo.trim();
        String trimmedTelefono = telefono.trim();
        String trimmedContacto = contacto.trim();
        String trimmedDireccion = direccion.trim();
        
        if(!Validaciones.validarNumeros(trimmedRTN))
        {
           errRTN.setText("La RTN ingresada es incorrecta");
           generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedRTN))
        {
           errRTN.setText("La RTN es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarLetras(trimmedNombre))
        {
            errNombre.setText("El nombre ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedNombre))
        {
           errNombre.setText("El nombre es un campo obligatorio");
           generalValidacionError = true;
        }     
        
        if(!Validaciones.validarCorreo(trimmedCorreo))
        {
            errCorreo.setText("El correo ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedCorreo))
        {
           errCorreo.setText("El correo es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarNumeros(trimmedTelefono))
        {
           errTelefono.setText("La Teléfono ingresada es incorrecta");
           generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedTelefono))
        {
           errTelefono.setText("La teléfono es un campo obligatorio");
           generalValidacionError = true;
        }
        
        if(!Validaciones.validarLetras(trimmedContacto))
        {
            errContacto.setText("El contacto ingresado es incorrecto");
            generalValidacionError = true;
        }
        
        if(Validaciones.validarCampoVacio(trimmedContacto))
        {
           errContacto.setText("El contacto es un campo obligatorio");
           generalValidacionError = true;
        }       
        if(Validaciones.validarCampoVacio(trimmedDireccion))
        {
           errContacto.setText("El dirección es un campo obligatorio");
           generalValidacionError = true;
        }       
         
        if(generalValidacionError == false)
        {
            switch(accion)
            {
                case "insertar":
                        id = 0;                    
                        ProveedorModel proveedorModel = new ProveedorModel();
                        proveedorModel.setProId(id);
                        proveedorModel.setProRTN(trimmedRTN);
                        proveedorModel.setProNombre(trimmedNombre);
                        proveedorModel.setProCorreo(trimmedCorreo);
                        proveedorModel.setProTelefono(trimmedTelefono);
                        proveedorModel.setProContacto(trimmedContacto);
                        proveedorModel.setProDireccion(trimmedDireccion);            
                        
                        String resultado = ProveedorConexion.MantenimientoProveedores(accion, proveedorModel);
                        
                        switch (resultado) 
                        {
                            case "Ok":
                                   JOptionPane.showMessageDialog(null, "Proveedor ingresado con éxito.");    
                            break;
                            
                            case "errRTN":
                                JOptionPane.showMessageDialog(null, "La identidad ya se encuentra registrada.");
                                mntError = true;
                            break;
       
                            case "errCorreo":
                                JOptionPane.showMessageDialog(null, "EL Correo ya se encuentra registrada.");
                                mntError = true;
                            break;
                        }
                    
                break;
                case "editar":
                        ProveedorModel proveedoModel = new ProveedorModel();
                        proveedoModel.setProId(id);
                        proveedoModel.setProRTN(trimmedRTN);
                        proveedoModel.setProNombre(trimmedNombre);
                        proveedoModel.setProCorreo(trimmedCorreo);
                        proveedoModel.setProTelefono(trimmedTelefono);
                        proveedoModel.setProContacto(trimmedContacto);
                        proveedoModel.setProDireccion(trimmedDireccion);            

                        String resultados = ProveedorConexion.MantenimientoProveedores(accion, proveedoModel);
                        
                        switch (resultados) 
                        {
                            case "Ok":
                                    JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito.");    
                            break;
                            
                            case "errRTN":
                                JOptionPane.showMessageDialog(null, "El RTN ya se encuentra registrada.");
                                mntError = true;
                            break;
                            
                            default:
                                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ejecutar la operación entr.");
                                mntError = true;
                            break;
                        } 
                break;                
            }
        }
        if (mntError == false && generalValidacionError == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }    
    
    public static Integer setDatosEditarFromTable(int seleccion, JTable tableProveedores, 
            JTextField txtRTN,JTextField txtNombre, JTextField txtCorreo,
            JTextField txtTelefono, JTextField txtContacto,JTextArea txtDescripcion)
    {
        Integer UsrId = null;
        UsrId = Integer.parseInt((String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 0)))); 
        txtRTN.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 1)));
        txtNombre.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 2)));
        txtCorreo.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 3)));
        txtTelefono.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 4)));
        txtContacto.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 5)));
        txtDescripcion.setText(String.valueOf(tableProveedores.getModel().getValueAt(seleccion, 6)));

        
        return UsrId;
    }  
    
    public static Integer setDatosEditarFromCache(JTable tableProveeodres,JTextField txtRTN, 
             JTextField txtNombre, JTextField txtCorreo, JTextField txtTelefono, 
             JTextField txtContacto, JTextArea txtDireccion)
    {
        ProveedorCache proveedorCache = new ProveedorCache();
        Integer UsrId = null;
   
        if(proveedorCache.isDatosCompartidos())
        {   
            UsrId = proveedorCache.getid().getProId();
            txtRTN.setText(proveedorCache.getid().getProRTN());
            txtNombre.setText(proveedorCache.getid().getProNombre());
            txtCorreo.setText(proveedorCache.getid().getProCorreo());
            txtTelefono.setText(proveedorCache.getid().getProTelefono());
            txtContacto.setText(proveedorCache.getid().getProContacto());
            txtDireccion.setText(proveedorCache.getid().getProDireccion());
        }
        
        return UsrId;
    }     
    
    public static void FiltroTableProveedores(JTable tableUsuarios, JTextField fieldBusqueda)
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
                } else {
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
    
    public static void LlenarTableProveedores(JTable tableProveedores) 
    {  
        DefaultTableModel modelo = (DefaultTableModel) tableProveedores.getModel(); 
        modelo.setRowCount(0);
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        proveedores = ProveedorConexion.ListadoProveedores();
        
        for (int i = 0; i <proveedores.size(); i++) 
        {
            modelo.addRow
            (new Object[]
                {
                    proveedores.get(i).getProId(), 
                    proveedores.get(i).getProRTN(),
                    proveedores.get(i).getProNombre(),
                    proveedores.get(i).getProCorreo(),
                    proveedores.get(i).getProTelefono(),
                    proveedores.get(i).getProContacto(),
                    proveedores.get(i).getProDireccion()
                }
            );
        }
        FormatoTabla(tableProveedores, modelo.getColumnCount());
    }
}
