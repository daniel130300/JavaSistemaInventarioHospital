/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Mantenimientos;

import Controllers.Controllers.InventarioHijoController;
import Controllers.Controllers.InventarioPadreController;
import Controllers.Controllers.LoginController;
import Models.Models.InventarioHijoModel;
import Models.Models.InventarioPadreModel;
import Utils.Cache.InventarioPadreCache;
import Views.Listados.ListadoCatalogoBodegaView;
import Views.Listados.ListadoKitsView;
import Views.Listados.ListadoUnidadesView;
import Views.Menus.MenuBodegaView;
import Views.TablasGrande.TablaGrandeMantenimientoInventarioBodegaView;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


/**
 *
 * @author danie
 */
public class MantenimientoInventarioBodegaView extends javax.swing.JFrame {

   public static Integer Id_Padre = null;
   public static Integer Id_producto = null;
   public static Integer Id_Hijo = null;
    
    ListadoCatalogoBodegaView producto = new ListadoCatalogoBodegaView();
    ListadoKitsView kit = new ListadoKitsView();
    ListadoUnidadesView unidad = new ListadoUnidadesView();
    
    
    public MantenimientoInventarioBodegaView() {
        initComponents();
        LoginController.setLabelUsrLogueado(this.lblUsuarioActual);
        this.tablePadre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        InventarioPadreController.LlenarTableInventarioPadre(tablePadre); 
        InventarioPadreController.FiltroTableInventarioPadre(this.tablePadre, this.txtBuscar);
        InventarioPadreController.setPlaceHoldersPadre(this.txtProducto, this.txtDescripcionPadre, this.txtFechaCaducidad,
               this.txtCantidadPadre, this.txtUnidadPadre, this.txtKit ,this.txtBuscar);
        InventarioPadreController.setPlaceHolders(this.txtDescripcionHijo, this.txtCantidadHijo, this.txtUnidadHijo,
                this.txtBuscar1);
        InventarioPadreController.setPlaceHolders(this.txtDescripcionNieto, this.txtCantidadNieto, this.txtUnidadNieto,
                this.txtBuscar2);
        InventarioHijoController.LlenarTableInventarioHijo(tableHijo);
        LlenarDatosPadre();
        ValidadSeleccion();
    }  

    private void ValidadSeleccion(){
        if(rbnPadre.isSelected()==true){
            this.btnAgregarHijo.setEnabled(false);
            this.btnCancelarHijo.setEnabled(true);
            this.btnEditarHijo.setEnabled(false);
            this.btnAgregarNieto.setEnabled(false);
            this.btnCancelarNieto.setEnabled(true);
            this.btnEditarNieto.setEnabled(false);
            this.txtCantidadHijo.setEnabled(false);
            this.txtDescripcionHijo.setEnabled(false);
            this.txtUnidadHijo.setEnabled(false);
            this.btnSeleccionarUnidadHijo.setEnabled(false);
            this.tableHijo.setEnabled(false);
            this.txtCantidadNieto.setEnabled(false);
            this.txtDescripcionNieto.setEnabled(false);
            this.txtUnidadNieto.setEnabled(false);
            this.btnSeleccionarUnidadNieto.setEnabled(false);
            this.tableNieto.setEnabled(false);
        }
    }
    private void LimpiarInputsPadre()
    {
        this.txtProducto.setText(null);
        this.txtDescripcionPadre.setText(null);
        this.txtFechaCaducidad.setText(null);
        this.txtCantidadPadre.setText(null);
        this.txtUnidadPadre.setText(null);
        this.txtKit.setText(null);  
    }
    
    private void LimpiarInputsHijo()
    {
        this.txtCantidadHijo.setText(null);
        this.txtDescripcionHijo.setText(null);
        this.txtUnidadHijo.setText(null);  
    }
    
    private void LimpiarInputsNieto()
    {
        this.txtCantidadNieto.setText(null);
        this.txtDescripcionNieto.setText(null);
        this.txtUnidadNieto.setText(null);  
    }
    
     private void LimpiarErrLabelsPadre()
    {
        this.lblErrorProducto.setText(null);
        this.lblErrorDescripcionPadre.setText(null);
        this.lblErrorFechaCaducidad.setText(null);
        this.lblErrorCantidadPadre.setText(null);
        this.lblErrorUnidadPadre.setText(null);
        this.lblErrorKit.setText(null);
    }
     private void LimpiarErrLabelsHijo()
    {
        this.lblErrorCantidadHijo.setText(null);
        this.lblErrorDescripcionHijo.setText(null);
        this.lblErrorUnidadHijo.setText(null);
    }
     private void LimpiarErrLabelsNieto()
    {
        this.lblErrorCantidadNieto.setText(null);
        this.lblErrorDescripcionNieto.setText(null);
        this.lblErrorUnidadNieto.setText(null);
    }
     
     private void LlenarDatosPadre()
    {
        this.Id_Padre = InventarioPadreController.setDatosEditarFromCache(this.tablePadre, 
            this.txtDescripcionPadre, this.txtFechaCaducidad,
            this.txtCantidadPadre,this.txtUnidadPadre, this.txtKit,
            this.txtProducto);
        
        if(Id_Padre != null)
        {
            
            this.btnAgregarPadre.setEnabled(false);
            this.btnEditarPadre.setEnabled(true);
        }
        
    } 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblModulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlBackbround = new javax.swing.JPanel();
        pnlUsuario = new javax.swing.JPanel();
        lblIconoUsuarioActual = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        lblMensajeBienvenida = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnlGeneral = new javax.swing.JTabbedPane();
        pnlMenu1 = new javax.swing.JPanel();
        lblErrorEstado = new javax.swing.JLabel();
        lblErrorCategoria = new javax.swing.JLabel();
        lblErrorUnidad = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JPanel();
        lblIconoRegresar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePadre = new javax.swing.JTable();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCancelarPadre = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionPadre = new javax.swing.JTextArea();
        lblErrorCantidadPadre = new javax.swing.JLabel();
        lblErrorProducto = new javax.swing.JLabel();
        txtCantidadPadre = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        lblErrorNombre2 = new javax.swing.JLabel();
        lblErrorFechaCaducidad = new javax.swing.JLabel();
        txtFechaCaducidad = new javax.swing.JTextField();
        lblErrorDescripcionPadre = new javax.swing.JLabel();
        txtUnidadPadre = new javax.swing.JTextField();
        lblErrorUnidadPadre = new javax.swing.JLabel();
        txtKit = new javax.swing.JTextField();
        lblErrorKit = new javax.swing.JLabel();
        btnVisualizarTablaPadre = new javax.swing.JButton();
        btnAgregarPadre = new javax.swing.JButton();
        btnEditarPadre = new javax.swing.JButton();
        btnSeleccionarUnidadPadre = new javax.swing.JButton();
        btnSeleccionarKit = new javax.swing.JButton();
        btnSeleccionarProducto = new javax.swing.JButton();
        lblNombre12 = new javax.swing.JLabel();
        rbnNieto = new javax.swing.JRadioButton();
        rbnPadre = new javax.swing.JRadioButton();
        rbnHijo = new javax.swing.JRadioButton();
        pnlMenu2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHijo = new javax.swing.JTable();
        lblNombre6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcionHijo = new javax.swing.JTextArea();
        lblErrorUnidadHijo = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        txtCantidadHijo = new javax.swing.JTextField();
        lblErrorDescripcionHijo = new javax.swing.JLabel();
        lblBuscar1 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        lblNombre8 = new javax.swing.JLabel();
        txtUnidadHijo = new javax.swing.JTextField();
        btnAgregarHijo = new javax.swing.JButton();
        btnEditarHijo = new javax.swing.JButton();
        btnCancelarHijo = new javax.swing.JButton();
        lblErrorCantidadHijo = new javax.swing.JLabel();
        btnSeleccionarUnidadHijo = new javax.swing.JButton();
        pnlMenu3 = new javax.swing.JPanel();
        lblErrorStockMinimo1 = new javax.swing.JLabel();
        lblErrorEstado1 = new javax.swing.JLabel();
        lblErrorCantidadNieto = new javax.swing.JLabel();
        lblErrorCategoria1 = new javax.swing.JLabel();
        lblErrorUnidad1 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcionNieto = new javax.swing.JTextArea();
        lblErrorUnidadNieto = new javax.swing.JLabel();
        lblNombre10 = new javax.swing.JLabel();
        txtCantidadNieto = new javax.swing.JTextField();
        lblErrorNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        txtUnidadNieto = new javax.swing.JTextField();
        btnAgregarNieto = new javax.swing.JButton();
        btnEditarNieto = new javax.swing.JButton();
        btnCancelarNieto = new javax.swing.JButton();
        txtBuscar2 = new javax.swing.JTextField();
        lblBuscar2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableNieto = new javax.swing.JTable();
        btnSeleccionarUnidadNieto = new javax.swing.JButton();
        lblErrorDescripcionNieto = new javax.swing.JLabel();
        pnlTitulo1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblModulo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        pnlTitulo.setBackground(new java.awt.Color(0, 49, 110));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Inventario Hospital Odontológico");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        lblModulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblModulo.setForeground(new java.awt.Color(242, 242, 242));
        lblModulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulo.setText("Mantenimiento Inventario Bodega");
        pnlTitulo.add(lblModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 300, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH_SM.png"))); // NOI18N
        pnlTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, 90));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackbround.setBackground(new java.awt.Color(0, 49, 110));
        pnlBackbround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsuario.setBackground(new java.awt.Color(0, 49, 110));
        pnlUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconoUsuarioActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_user_32px.png"))); // NOI18N
        pnlUsuario.add(lblIconoUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        lblUsuarioActual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuarioActual.setForeground(new java.awt.Color(242, 242, 242));
        lblUsuarioActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlUsuario.add(lblUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 28));

        lblMensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensajeBienvenida.setForeground(new java.awt.Color(242, 242, 242));
        lblMensajeBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeBienvenida.setText("Bienvenido(a)");
        pnlUsuario.add(lblMensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, 28));

        pnlBackbround.add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 130));

        getContentPane().add(pnlBackbround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlMenu.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGeneral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pnlMenu1.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblErrorEstado.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorEstado.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 140, -1));

        lblErrorCategoria.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCategoria.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 140, -1));

        lblErrorUnidad.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorUnidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorUnidad.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 140, -1));

        btnRegresar.setBackground(new java.awt.Color(45, 83, 150));
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        lblIconoRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_go_back_32px.png"))); // NOI18N

        lblRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRegresar.setForeground(new java.awt.Color(242, 242, 242));
        lblRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegresar.setText("Regresar");

        javax.swing.GroupLayout btnRegresarLayout = new javax.swing.GroupLayout(btnRegresar);
        btnRegresar.setLayout(btnRegresarLayout);
        btnRegresarLayout.setHorizontalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRegresarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnRegresarLayout.setVerticalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIconoRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenu1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 30));

        tablePadre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Padre", "Código Interno", "Descripción", "Fecha Caducidad", "Cantidad", "Unidad", "Id Kit", "Nombre Kit", "Id Producto", "Nombre Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePadreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePadre);
        if (tablePadre.getColumnModel().getColumnCount() > 0) {
            tablePadre.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        pnlMenu1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 397, 970, 120));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(242, 242, 242));
        lblBuscar.setText("Buscar: ");
        pnlMenu1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 590, -1));

        btnCancelarPadre.setBackground(new java.awt.Color(59, 103, 181));
        btnCancelarPadre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelarPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarPadre.setText("Cancelar");
        btnCancelarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnCancelarPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 90, 30));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre.setText("Tipo Producto:");
        pnlMenu1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lblNombre1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre1.setText("Descripción:");
        pnlMenu1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        lblNombre2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre2.setText("Fecha Caducidad:");
        pnlMenu1.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        lblNombre3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre3.setText("Cantidad:");
        pnlMenu1.add(lblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        lblNombre4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre4.setText("Unidad:");
        pnlMenu1.add(lblNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        lblNombre5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre5.setText("Kit:");
        pnlMenu1.add(lblNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, -1));

        txtDescripcionPadre.setColumns(20);
        txtDescripcionPadre.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionPadre);

        pnlMenu1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 240, 70));

        lblErrorCantidadPadre.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorCantidadPadre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCantidadPadre.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorCantidadPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 270, 20));

        lblErrorProducto.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorProducto.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 250, 20));

        txtCantidadPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtCantidadPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 20));

        txtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProductoMouseClicked(evt);
            }
        });
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 240, 20));

        lblErrorNombre2.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorNombre2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorNombre2.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 240, 20));

        lblErrorFechaCaducidad.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorFechaCaducidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorFechaCaducidad.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorFechaCaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 270, 20));

        txtFechaCaducidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCaducidadActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtFechaCaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 200, 20));

        lblErrorDescripcionPadre.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorDescripcionPadre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorDescripcionPadre.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorDescripcionPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 270, 20));

        txtUnidadPadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUnidadPadreMouseClicked(evt);
            }
        });
        txtUnidadPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtUnidadPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 220, 20));

        lblErrorUnidadPadre.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorUnidadPadre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorUnidadPadre.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorUnidadPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 240, 20));

        txtKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKitMouseClicked(evt);
            }
        });
        txtKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKitActionPerformed(evt);
            }
        });
        pnlMenu1.add(txtKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 220, 20));

        lblErrorKit.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorKit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorKit.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu1.add(lblErrorKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 240, 20));

        btnVisualizarTablaPadre.setBackground(new java.awt.Color(59, 103, 181));
        btnVisualizarTablaPadre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVisualizarTablaPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizarTablaPadre.setText("Visualizar Tabla");
        btnVisualizarTablaPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarTablaPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnVisualizarTablaPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 350, 130, 30));

        btnAgregarPadre.setBackground(new java.awt.Color(59, 103, 181));
        btnAgregarPadre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPadre.setText("Agregar");
        btnAgregarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnAgregarPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 90, 30));

        btnEditarPadre.setBackground(new java.awt.Color(59, 103, 181));
        btnEditarPadre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPadre.setText("Editar");
        btnEditarPadre.setEnabled(false);
        btnEditarPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnEditarPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 90, 30));

        btnSeleccionarUnidadPadre.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarUnidadPadre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSeleccionarUnidadPadre.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarUnidadPadre.setText("Seleccionar");
        btnSeleccionarUnidadPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUnidadPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnSeleccionarUnidadPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, 30));

        btnSeleccionarKit.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarKit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSeleccionarKit.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarKit.setText("Seleccionar");
        btnSeleccionarKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarKitActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnSeleccionarKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, 30));

        btnSeleccionarProducto.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarProducto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSeleccionarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarProducto.setText("Selecionar");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });
        pnlMenu1.add(btnSeleccionarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, 30));

        lblNombre12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre12.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre12.setText("Producto:");
        pnlMenu1.add(lblNombre12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        rbnNieto.setBackground(new java.awt.Color(0, 49, 110));
        rbnNieto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnNieto.setForeground(new java.awt.Color(255, 255, 255));
        rbnNieto.setText("Nieto");
        rbnNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnNietoActionPerformed(evt);
            }
        });
        pnlMenu1.add(rbnNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        rbnPadre.setBackground(new java.awt.Color(0, 49, 110));
        rbnPadre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnPadre.setForeground(new java.awt.Color(255, 255, 255));
        rbnPadre.setSelected(true);
        rbnPadre.setText("Padre");
        rbnPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnPadreActionPerformed(evt);
            }
        });
        pnlMenu1.add(rbnPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        rbnHijo.setBackground(new java.awt.Color(0, 49, 110));
        rbnHijo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbnHijo.setForeground(new java.awt.Color(255, 255, 255));
        rbnHijo.setText("Hijo");
        rbnHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnHijoActionPerformed(evt);
            }
        });
        pnlMenu1.add(rbnHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        pnlGeneral.addTab("Padre", pnlMenu1);

        pnlMenu2.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableHijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Hijo", "Descripción", "Cantidad", "Id Padre", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHijo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHijoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableHijo);
        if (tableHijo.getColumnModel().getColumnCount() > 0) {
            tableHijo.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        pnlMenu2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 397, 950, 120));

        lblNombre6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre6.setText("Descripción:");
        pnlMenu2.add(lblNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtDescripcionHijo.setColumns(20);
        txtDescripcionHijo.setRows(5);
        jScrollPane4.setViewportView(txtDescripcionHijo);

        pnlMenu2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 260, 70));

        lblErrorUnidadHijo.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorUnidadHijo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorUnidadHijo.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu2.add(lblErrorUnidadHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 250, 20));

        lblNombre7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre7.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre7.setText("Cantidad:");
        pnlMenu2.add(lblNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        txtCantidadHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(txtCantidadHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 20));

        lblErrorDescripcionHijo.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorDescripcionHijo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorDescripcionHijo.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu2.add(lblErrorDescripcionHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 270, 20));

        lblBuscar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscar1.setForeground(new java.awt.Color(242, 242, 242));
        lblBuscar1.setText("Buscar: ");
        pnlMenu2.add(lblBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });
        pnlMenu2.add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 590, -1));

        lblNombre8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre8.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre8.setText("Unidad:");
        pnlMenu2.add(lblNombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        txtUnidadHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(txtUnidadHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 240, 20));

        btnAgregarHijo.setBackground(new java.awt.Color(59, 103, 181));
        btnAgregarHijo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarHijo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarHijo.setText("Agregar");
        btnAgregarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(btnAgregarHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 90, 30));

        btnEditarHijo.setBackground(new java.awt.Color(59, 103, 181));
        btnEditarHijo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarHijo.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarHijo.setText("Editar");
        btnEditarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(btnEditarHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 90, 30));

        btnCancelarHijo.setBackground(new java.awt.Color(59, 103, 181));
        btnCancelarHijo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelarHijo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarHijo.setText("Cancelar");
        btnCancelarHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(btnCancelarHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 90, 30));

        lblErrorCantidadHijo.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorCantidadHijo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCantidadHijo.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu2.add(lblErrorCantidadHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 20));

        btnSeleccionarUnidadHijo.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarUnidadHijo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSeleccionarUnidadHijo.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarUnidadHijo.setText("Seleccionar");
        btnSeleccionarUnidadHijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUnidadHijoActionPerformed(evt);
            }
        });
        pnlMenu2.add(btnSeleccionarUnidadHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, 30));

        pnlGeneral.addTab("Hijo", pnlMenu2);

        pnlMenu3.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblErrorStockMinimo1.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorStockMinimo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorStockMinimo1.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorStockMinimo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 290, 20));

        lblErrorEstado1.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorEstado1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorEstado1.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 140, -1));

        lblErrorCantidadNieto.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorCantidadNieto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCantidadNieto.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorCantidadNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 220, 20));

        lblErrorCategoria1.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCategoria1.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 140, -1));

        lblErrorUnidad1.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorUnidad1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorUnidad1.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 140, -1));

        lblNombre9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre9.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre9.setText("Descripción:");
        pnlMenu3.add(lblNombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtDescripcionNieto.setColumns(20);
        txtDescripcionNieto.setRows(5);
        jScrollPane5.setViewportView(txtDescripcionNieto);

        pnlMenu3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 260, 70));

        lblErrorUnidadNieto.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorUnidadNieto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorUnidadNieto.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorUnidadNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 260, 20));

        lblNombre10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre10.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre10.setText("Cantidad:");
        pnlMenu3.add(lblNombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        txtCantidadNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(txtCantidadNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 20));

        lblErrorNombre10.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorNombre10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorNombre10.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorNombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 20));

        lblNombre11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre11.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre11.setText("Unidad:");
        pnlMenu3.add(lblNombre11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        txtUnidadNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(txtUnidadNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 240, 20));

        btnAgregarNieto.setBackground(new java.awt.Color(59, 103, 181));
        btnAgregarNieto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarNieto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarNieto.setText("Agregar");
        btnAgregarNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(btnAgregarNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 90, 30));

        btnEditarNieto.setBackground(new java.awt.Color(59, 103, 181));
        btnEditarNieto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarNieto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarNieto.setText("Editar");
        btnEditarNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(btnEditarNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 90, 30));

        btnCancelarNieto.setBackground(new java.awt.Color(59, 103, 181));
        btnCancelarNieto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelarNieto.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarNieto.setText("Cancelar");
        btnCancelarNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(btnCancelarNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 90, 30));

        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });
        pnlMenu3.add(txtBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 590, -1));

        lblBuscar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscar2.setForeground(new java.awt.Color(242, 242, 242));
        lblBuscar2.setText("Buscar: ");
        pnlMenu3.add(lblBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        tableNieto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Nieto", "Descripción", "Cantidad", "Id Hijo", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableNieto);
        if (tableNieto.getColumnModel().getColumnCount() > 0) {
            tableNieto.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        pnlMenu3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 397, 950, 120));

        btnSeleccionarUnidadNieto.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarUnidadNieto.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSeleccionarUnidadNieto.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarUnidadNieto.setText("Seleccionar");
        btnSeleccionarUnidadNieto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUnidadNietoActionPerformed(evt);
            }
        });
        pnlMenu3.add(btnSeleccionarUnidadNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, 30));

        lblErrorDescripcionNieto.setBackground(new java.awt.Color(255, 51, 51));
        lblErrorDescripcionNieto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorDescripcionNieto.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu3.add(lblErrorDescripcionNieto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 270, 20));

        pnlGeneral.addTab("Nieto", pnlMenu3);

        pnlMenu.add(pnlGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 570));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1000, 570));

        pnlTitulo1.setBackground(new java.awt.Color(0, 49, 110));
        pnlTitulo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Sistema de Inventario Hospital Odontológico");
        pnlTitulo1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        lblModulo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblModulo1.setForeground(new java.awt.Color(242, 242, 242));
        lblModulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulo1.setText("Mantenimiento Inventario");
        pnlTitulo1.add(lblModulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 300, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH_SM.png"))); // NOI18N
        pnlTitulo1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 80, 90));

        getContentPane().add(pnlTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 800, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        InventarioPadreCache InventarioBodegaCache = new InventarioPadreCache();
        InventarioBodegaCache.setDatosCompartidos(false);
        MenuBodegaView menuBodegaView = new MenuBodegaView();
        menuBodegaView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCantidadPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadPadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadPadreActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void txtFechaCaducidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCaducidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCaducidadActionPerformed

    private void txtUnidadPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadPadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadPadreActionPerformed

    private void txtKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKitActionPerformed

    private void txtCantidadHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadHijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadHijoActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void txtUnidadHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadHijoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadHijoActionPerformed

    private void btnCancelarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarHijoActionPerformed
        this.btnAgregarHijo.setEnabled(true);
        this.btnEditarHijo.setEnabled(false);
        this.tableHijo.clearSelection();
        this.LimpiarInputsHijo();
        this.LimpiarErrLabelsHijo();
    }//GEN-LAST:event_btnCancelarHijoActionPerformed

    private void txtCantidadNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadNietoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadNietoActionPerformed

    private void txtUnidadNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadNietoActionPerformed
        
    }//GEN-LAST:event_txtUnidadNietoActionPerformed

    private void btnCancelarNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNietoActionPerformed
       this.btnAgregarNieto.setEnabled(true);
        this.btnEditarNieto.setEnabled(false);
        this.tableNieto.clearSelection();
        this.LimpiarInputsNieto();
        this.LimpiarErrLabelsNieto();
    }//GEN-LAST:event_btnCancelarNietoActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void btnSeleccionarUnidadNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUnidadNietoActionPerformed
        unidad.setVisible(true);
        unidad.tableUnidades.clearSelection();
    }//GEN-LAST:event_btnSeleccionarUnidadNietoActionPerformed

    private void btnSeleccionarUnidadHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUnidadHijoActionPerformed
        unidad.setVisible(true);
        unidad.tableUnidades.clearSelection();
    }//GEN-LAST:event_btnSeleccionarUnidadHijoActionPerformed

    private void btnSeleccionarUnidadPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUnidadPadreActionPerformed
        unidad.setVisible(true);
        unidad.tableUnidades.clearSelection();
        
    }//GEN-LAST:event_btnSeleccionarUnidadPadreActionPerformed

    private void btnSeleccionarKitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarKitActionPerformed
        kit.setVisible(true);
        kit.tableKits.clearSelection();
    }//GEN-LAST:event_btnSeleccionarKitActionPerformed

    private void btnCancelarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPadreActionPerformed
        this.btnAgregarPadre.setEnabled(true);
        this.btnEditarPadre.setEnabled(false);
        this.tablePadre.clearSelection();
        this.btnVisualizarTablaPadre.setEnabled(true);
        this.LimpiarInputsPadre();
        this.LimpiarErrLabelsPadre();
    }//GEN-LAST:event_btnCancelarPadreActionPerformed

    private void btnAgregarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPadreActionPerformed

        if(!InventarioPadreController.MantenimientoInventarioPadre("insertar", 0,
            this.txtDescripcionPadre.getText(), this.txtFechaCaducidad.getText(),
            this.txtCantidadPadre.getText(),this.txtUnidadPadre.getText(), this.txtKit.getText(),
            this.txtProducto.getText(), this.lblErrorDescripcionPadre,this.lblErrorFechaCaducidad,
            this.lblErrorCantidadPadre, this.lblErrorUnidadPadre, this.lblErrorKit,this.lblErrorProducto))
        {
            InventarioPadreModel PadreModel = new InventarioPadreModel();
            Id_Padre = PadreModel.getInvPId();
            InventarioPadreController.LlenarTableInventarioPadre(tablePadre);
            this.LimpiarInputsPadre();
        }
    }//GEN-LAST:event_btnAgregarPadreActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        producto.setVisible(true);
        producto.tableProductos.clearSelection();
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void txtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductoMouseClicked
   
    }//GEN-LAST:event_txtProductoMouseClicked

    private void txtUnidadPadreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUnidadPadreMouseClicked
  
    }//GEN-LAST:event_txtUnidadPadreMouseClicked

    private void txtKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKitMouseClicked
   
    }//GEN-LAST:event_txtKitMouseClicked

    private void tablePadreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePadreMouseClicked
        int seleccion = this.tablePadre.rowAtPoint(evt.getPoint());
        
        this.Id_Padre = InventarioPadreController.setDatosEditarFromTable(seleccion, this.tablePadre, 
                this.txtDescripcionPadre, this.txtFechaCaducidad, this.txtCantidadPadre,
                this.txtUnidadPadre, this.txtKit, this.txtProducto);
        
        if(Id_Padre != null)
        {
            this.btnAgregarPadre.setEnabled(false);
            this.btnEditarPadre.setEnabled(true);
            this.btnCancelarPadre.setEnabled(true);
        }
    }//GEN-LAST:event_tablePadreMouseClicked

    private void btnEditarPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPadreActionPerformed
        
           if(!InventarioPadreController.MantenimientoInventarioPadre("editar", this.Id_Padre,
                this.txtDescripcionPadre.getText(), this.txtFechaCaducidad.getText(),
                this.txtCantidadPadre.getText(),this.txtUnidadPadre.getText(), this.txtKit.getText(),
                this.txtProducto.getText(), this.lblErrorDescripcionPadre,this.lblErrorFechaCaducidad,
                this.lblErrorCantidadPadre, this.lblErrorUnidadPadre, this.lblErrorKit,this.lblErrorProducto))
            {
                InventarioPadreController.LlenarTableInventarioPadre(tablePadre);
                this.LimpiarInputsPadre();
                this.btnAgregarPadre.setEnabled(true);
                this.btnEditarPadre.setEnabled(false);
            }
        
    }//GEN-LAST:event_btnEditarPadreActionPerformed

    private void btnVisualizarTablaPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarTablaPadreActionPerformed
        TablaGrandeMantenimientoInventarioBodegaView TablaGrandeMantenimientoInventarioBodega = new TablaGrandeMantenimientoInventarioBodegaView();
        TablaGrandeMantenimientoInventarioBodega.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVisualizarTablaPadreActionPerformed

    private void rbnNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnNietoActionPerformed
        this.btnAgregarPadre.setEnabled(false);
        this.btnCancelarPadre.setEnabled(true);
        this.btnEditarPadre.setEnabled(false);
        this.txtProducto.setEnabled(true);
        this.txtDescripcionPadre.setEnabled(true);
        this.txtFechaCaducidad.setEnabled(true);
        this.txtCantidadPadre.setEnabled(true);
        this.txtUnidadPadre.setEnabled(true);
        this.txtKit.setEnabled(true);
        
        this.btnAgregarHijo.setEnabled(false);
        this.btnCancelarHijo.setEnabled(true);
        this.btnEditarHijo.setEnabled(false);
        this.txtCantidadHijo.setEnabled(true);
        this.txtDescripcionHijo.setEnabled(true);
        this.txtUnidadHijo.setEnabled(true);
        this.btnSeleccionarUnidadHijo.setEnabled(true);
        this.tableHijo.setEnabled(true);
        
        this.btnAgregarNieto.setEnabled(true);
        this.btnCancelarNieto.setEnabled(true);
        this.btnEditarNieto.setEnabled(false);
        this.txtCantidadNieto.setEnabled(true);
        this.txtDescripcionNieto.setEnabled(true);
        this.txtUnidadNieto.setEnabled(true);
        this.btnSeleccionarUnidadNieto.setEnabled(true);
        this.tableNieto.setEnabled(true);
        
        this.rbnHijo.setSelected(false);
        this.rbnPadre.setSelected(false);

        LimpiarInputsNieto();
  
    }//GEN-LAST:event_rbnNietoActionPerformed

    private void rbnPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnPadreActionPerformed
        this.btnAgregarPadre.setEnabled(true);
        this.btnEditarPadre.setEnabled(false);
        this.btnCancelarPadre.setEnabled(true);
        
        this.btnAgregarHijo.setEnabled(false);
        this.btnCancelarHijo.setEnabled(true);
        this.btnEditarHijo.setEnabled(false);
        this.txtCantidadHijo.setEnabled(false);
        this.txtDescripcionHijo.setEnabled(false);
        this.txtUnidadHijo.setEnabled(false);
        this.btnSeleccionarUnidadHijo.setEnabled(false);
        this.tableHijo.setEnabled(false);
        
        this.btnAgregarNieto.setEnabled(false);
        this.btnCancelarNieto.setEnabled(true);
        this.btnEditarNieto.setEnabled(false); 
        this.txtCantidadNieto.setEnabled(false);
        this.txtDescripcionNieto.setEnabled(false);
        this.txtUnidadNieto.setEnabled(false);
        this.btnSeleccionarUnidadNieto.setEnabled(false);
        this.tableNieto.setEnabled(false);
        
        this.rbnNieto.setSelected(false);
        this.rbnHijo.setSelected(false);
        
        LimpiarInputsHijo();
        LimpiarInputsNieto();
       
    }//GEN-LAST:event_rbnPadreActionPerformed

    private void rbnHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnHijoActionPerformed
        this.btnAgregarPadre.setEnabled(false);
        this.btnCancelarPadre.setEnabled(true);
        this.btnEditarPadre.setEnabled(false);
        
        this.btnAgregarHijo.setEnabled(true);
        this.btnCancelarHijo.setEnabled(true);
        this.btnEditarHijo.setEnabled(false);
        this.txtCantidadHijo.setEnabled(true);
        this.txtDescripcionHijo.setEnabled(true);
        this.txtUnidadHijo.setEnabled(true);
        this.btnSeleccionarUnidadHijo.setEnabled(true);
        this.tableHijo.setEnabled(true);
        
        this.btnAgregarNieto.setEnabled(false);
        this.btnCancelarNieto.setEnabled(true);
        this.btnEditarNieto.setEnabled(false);
        this.txtCantidadNieto.setEnabled(false);
        this.txtDescripcionNieto.setEnabled(false);
        this.txtUnidadNieto.setEnabled(false);
        this.btnSeleccionarUnidadNieto.setEnabled(false);
        this.tableNieto.setEnabled(false);
        
        this.rbnPadre.setSelected(false);
        this.rbnNieto.setSelected(false);
        
        LimpiarInputsHijo();
        LimpiarInputsNieto();
    }//GEN-LAST:event_rbnHijoActionPerformed

    private void btnAgregarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHijoActionPerformed
       
        if(!InventarioPadreController.MantenimientoInventarioPadre("insertar", 0,
            this.txtDescripcionPadre.getText(), this.txtFechaCaducidad.getText(),
            this.txtCantidadPadre.getText(),this.txtUnidadPadre.getText(), this.txtKit.getText(),
            this.txtProducto.getText(), this.lblErrorDescripcionPadre,this.lblErrorFechaCaducidad,
            this.lblErrorCantidadPadre, this.lblErrorUnidadPadre, this.lblErrorKit,this.lblErrorProducto))
        {
            InventarioPadreModel PadreModel = new InventarioPadreModel();
            Id_Padre = PadreModel.getInvPId();
            InventarioPadreController.LlenarTableInventarioPadre(tablePadre);
            this.LimpiarInputsPadre();
        }
        
        if(!InventarioHijoController.MantenimientoInventarioHijo("insertar", 0,
            this.txtDescripcionHijo.getText(),this.txtCantidadHijo.getText(),this.txtUnidadHijo.getText(),
            this.lblErrorDescripcionHijo,this.lblErrorCantidadHijo, this.lblErrorUnidadHijo))
        {
            InventarioHijoModel HijoModel = new InventarioHijoModel();
            Id_Hijo = HijoModel.getInvHId();
            InventarioHijoController.LlenarTableInventarioHijo(tableHijo);
            this.LimpiarInputsHijo();
        }
    }//GEN-LAST:event_btnAgregarHijoActionPerformed

    private void tableHijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHijoMouseClicked
        
        int seleccion = this.tableHijo.rowAtPoint(evt.getPoint());
        
        this.Id_Hijo = InventarioHijoController.setDatosEditarFromTable(seleccion, this.tableHijo, 
                this.txtDescripcionHijo, this.txtCantidadHijo,this.txtUnidadHijo);
        
        if(Id_Hijo != null)
        {
            this.btnAgregarHijo.setEnabled(false);
            this.btnEditarHijo.setEnabled(true);
            this.btnCancelarHijo.setEnabled(true);
        }
    }//GEN-LAST:event_tableHijoMouseClicked

    private void btnEditarHijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarHijoActionPerformed
       
        if(!InventarioHijoController.MantenimientoInventarioHijo("editar", this.Id_Hijo,
                this.txtDescripcionHijo.getText(),this.txtCantidadHijo.getText(),this.txtUnidadHijo.getText(),
                this.lblErrorDescripcionHijo,this.lblErrorCantidadHijo, this.lblErrorUnidadHijo))
            {
                InventarioHijoController.LlenarTableInventarioHijo(tableHijo);
                this.LimpiarInputsHijo();
                this.btnAgregarHijo.setEnabled(true);
                this.btnEditarHijo.setEnabled(false);
            }
    }//GEN-LAST:event_btnEditarHijoActionPerformed

    private void btnAgregarNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNietoActionPerformed
        
        if(!InventarioPadreController.MantenimientoInventarioPadre("insertar", 0,
            this.txtDescripcionPadre.getText(), this.txtFechaCaducidad.getText(),
            this.txtCantidadPadre.getText(),this.txtUnidadPadre.getText(), this.txtKit.getText(),
            this.txtProducto.getText(), this.lblErrorDescripcionPadre,this.lblErrorFechaCaducidad,
            this.lblErrorCantidadPadre, this.lblErrorUnidadPadre, this.lblErrorKit,this.lblErrorProducto))
        {
            InventarioPadreModel PadreModel = new InventarioPadreModel();
            Id_Padre = PadreModel.getInvPId();
            InventarioPadreController.LlenarTableInventarioPadre(tablePadre);
            this.LimpiarInputsPadre();
        }
        
        if(!InventarioHijoController.MantenimientoInventarioHijo("insertar", 0,
            this.txtDescripcionHijo.getText(),this.txtCantidadHijo.getText(),this.txtUnidadHijo.getText(),
            this.lblErrorDescripcionHijo,this.lblErrorCantidadHijo, this.lblErrorUnidadHijo))
        {
            InventarioHijoModel HijoModel = new InventarioHijoModel();
            Id_Hijo = HijoModel.getInvHId();
            InventarioHijoController.LlenarTableInventarioHijo(tableHijo);
            this.LimpiarInputsHijo();
        }
        
    }//GEN-LAST:event_btnAgregarNietoActionPerformed

    private void btnEditarNietoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarNietoActionPerformed
       
    }//GEN-LAST:event_btnEditarNietoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarioBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarioBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarioBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarioBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoInventarioBodegaView().setVisible(true);
            }
        });
    }
    
    private void setcolor(JPanel panel)
    {
        panel.setBackground(new Color(45,83,150));
    }
    
    void resetcolor(JPanel panel)
    {
        panel.setBackground(new Color(0,49,110));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarHijo;
    private javax.swing.JButton btnAgregarNieto;
    private javax.swing.JButton btnAgregarPadre;
    private javax.swing.JButton btnCancelarHijo;
    private javax.swing.JButton btnCancelarNieto;
    private javax.swing.JButton btnCancelarPadre;
    private javax.swing.JButton btnEditarHijo;
    private javax.swing.JButton btnEditarNieto;
    private javax.swing.JButton btnEditarPadre;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JButton btnSeleccionarKit;
    private javax.swing.JButton btnSeleccionarProducto;
    public static javax.swing.JButton btnSeleccionarUnidadHijo;
    public static javax.swing.JButton btnSeleccionarUnidadNieto;
    public static javax.swing.JButton btnSeleccionarUnidadPadre;
    private javax.swing.JButton btnVisualizarTablaPadre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscar1;
    private javax.swing.JLabel lblBuscar2;
    private javax.swing.JLabel lblErrorCantidadHijo;
    private javax.swing.JLabel lblErrorCantidadNieto;
    private javax.swing.JLabel lblErrorCantidadPadre;
    private javax.swing.JLabel lblErrorCategoria;
    private javax.swing.JLabel lblErrorCategoria1;
    private javax.swing.JLabel lblErrorDescripcionHijo;
    private javax.swing.JLabel lblErrorDescripcionNieto;
    private javax.swing.JLabel lblErrorDescripcionPadre;
    private javax.swing.JLabel lblErrorEstado;
    private javax.swing.JLabel lblErrorEstado1;
    private javax.swing.JLabel lblErrorFechaCaducidad;
    private javax.swing.JLabel lblErrorKit;
    private javax.swing.JLabel lblErrorNombre10;
    private javax.swing.JLabel lblErrorNombre2;
    private javax.swing.JLabel lblErrorProducto;
    private javax.swing.JLabel lblErrorStockMinimo1;
    private javax.swing.JLabel lblErrorUnidad;
    private javax.swing.JLabel lblErrorUnidad1;
    private javax.swing.JLabel lblErrorUnidadHijo;
    private javax.swing.JLabel lblErrorUnidadNieto;
    private javax.swing.JLabel lblErrorUnidadPadre;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuarioActual;
    private javax.swing.JLabel lblMensajeBienvenida;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblModulo1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JPanel pnlBackbround;
    private javax.swing.JTabbedPane pnlGeneral;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenu1;
    private javax.swing.JPanel pnlMenu2;
    private javax.swing.JPanel pnlMenu3;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlTitulo1;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JRadioButton rbnHijo;
    private javax.swing.JRadioButton rbnNieto;
    private javax.swing.JRadioButton rbnPadre;
    private javax.swing.JTable tableHijo;
    private javax.swing.JTable tableNieto;
    public javax.swing.JTable tablePadre;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtCantidadHijo;
    private javax.swing.JTextField txtCantidadNieto;
    private javax.swing.JTextField txtCantidadPadre;
    private javax.swing.JTextArea txtDescripcionHijo;
    private javax.swing.JTextArea txtDescripcionNieto;
    private javax.swing.JTextArea txtDescripcionPadre;
    private javax.swing.JTextField txtFechaCaducidad;
    public static javax.swing.JTextField txtKit;
    public static javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtUnidadHijo;
    public static javax.swing.JTextField txtUnidadNieto;
    public static javax.swing.JTextField txtUnidadPadre;
    // End of variables declaration//GEN-END:variables
}
