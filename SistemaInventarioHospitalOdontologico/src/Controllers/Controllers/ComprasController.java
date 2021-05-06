/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Models.Conexion.ComprasConexion;
import Models.Conexion.Conexion;
import Models.Models.ProveedorModel;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fgodo
 */
public class ComprasController {
    public static void LlenarCmbProveedores(JComboBox cmbProveedores)
    {
        ArrayList<ProveedorModel> proveedores = new ArrayList<>();
        proveedores = ComprasConexion.ListadoProveedores();
        
        for (int i = 0; i<proveedores.size(); i++)
        {
            cmbProveedores.addItem(proveedores.get(i).getProNombre());

        }
    }     
    public static void SelectFotos(JLabel foto)
    {
        JFileChooser factura = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("3 Formatos Soportados", "jpg","png","jpeg");
        factura.setFileFilter(filtro);
        int selected = factura.showOpenDialog(null);
        if (selected == JFileChooser.APPROVE_OPTION){
            File file = factura.getSelectedFile();
            String getselectImage = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null, getselectImage);
            ImageIcon imIco = new ImageIcon(getselectImage);
            
            Image imFit = imIco.getImage();
            Image imgFit = imFit.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
            
            
            foto.setIcon(new ImageIcon(imgFit));
        }
    }
    
    
}
