/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Mantenimientos;

import Controllers.Controllers.LoginController;
import Controllers.Controllers.ProveedorController;
import Views.Menus.MenuInicioView;
import java.awt.Color;
import javax.swing.JPanel;
import Views.TablasGrande.TablaGrandeProveedoresView;

/**
 *
 * @author danie
 */
public class MantenimientoProveedoresView extends javax.swing.JFrame {

    Integer Id_proveedor = null;
    
    public MantenimientoProveedoresView() {
        initComponents();
        LoginController.setLabelUsrLogueado(this.lblUsuarioActual);
        ProveedorController.LlenarTableProveedores(tableProveedores);
        ProveedorController.FiltroTableProveedores(tableProveedores, txtBuscar);
        this.LlenarDatos();
    }
    
    private void LimpiarInputs()
    {
        this.txtRTN.setText(null);
        this.txtNombre.setText(null);
        this.txtCorreo.setText(null);
        this.txtTelefono.setText(null);
        this.txtContacto.setText(null);
        this.txtDireccion.setText(null);
        this.cmbEstado.setSelectedIndex(0);
    }
    
    private void LimpiarErrLabels()
    {
        this.lblErrorRTN.setText(null);
        this.lblErrorNombre.setText(null);
        this.lblErrorCorreo.setText(null);
        this.lblErrorTelefono.setText(null);
        this.lblErrorContacto.setText(null);
        this.lblErrorDireccion.setText(null);
    }
        private void LlenarDatos()
    {
        this.Id_proveedor = ProveedorController.setDatosEditarFromCache(this.tableProveedores, 
                this.txtRTN, this.txtNombre, this.txtCorreo, this.txtTelefono,
                this.txtContacto, this.txtDireccion, this.cmbEstado);
        
        if(Id_proveedor != null)
        {
            this.btnAgregar.setEnabled(false);
            this.btnEditar.setEnabled(true);
            this.cmbEstado.setEnabled(true);
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

        pnlBackbround = new javax.swing.JPanel();
        pnlUsuario = new javax.swing.JPanel();
        lblIconoUsuarioActual = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        lblMensajeBienvenida = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JPanel();
        lblIconoRegresar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblErrorTelefono = new javax.swing.JLabel();
        txtRTN = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblRTN = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtContacto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProveedores = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnVisualizar = new javax.swing.JPanel();
        lblVisualizar = new javax.swing.JLabel();
        lblContacto = new javax.swing.JLabel();
        lblErrorDireccion = new javax.swing.JLabel();
        lblErrorRTN = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();
        lblErrorCorreo = new javax.swing.JLabel();
        lblErrorContacto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblModulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBackbround.setBackground(new java.awt.Color(0, 49, 110));
        pnlBackbround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsuario.setBackground(new java.awt.Color(0, 49, 110));
        pnlUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconoUsuarioActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_user_32px.png"))); // NOI18N
        pnlUsuario.add(lblIconoUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        lblUsuarioActual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuarioActual.setForeground(new java.awt.Color(242, 242, 242));
        lblUsuarioActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlUsuario.add(lblUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 28));

        lblMensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensajeBienvenida.setForeground(new java.awt.Color(242, 242, 242));
        lblMensajeBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeBienvenida.setText("Bienvenido(a)");
        pnlUsuario.add(lblMensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 28));

        pnlBackbround.add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 130));

        pnlMenu.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnlMenu.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 30));

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(242, 242, 242));
        lblCorreo.setText("Correo: ");
        pnlMenu.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lblErrorTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorTelefono.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 20));

        txtRTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRTNActionPerformed(evt);
            }
        });
        pnlMenu.add(txtRTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 220, -1));

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(242, 242, 242));
        lblBuscar.setText("Buscar: ");
        pnlMenu.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        pnlMenu.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 520, -1));

        lblRTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRTN.setForeground(new java.awt.Color(242, 242, 242));
        lblRTN.setText("RTN:");
        pnlMenu.add(lblRTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        pnlMenu.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 220, -1));
        pnlMenu.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, -1));

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(242, 242, 242));
        lblDireccion.setText("Dirección: ");
        pnlMenu.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(242, 242, 242));
        lblTelefono.setText("Teléfono:");
        pnlMenu.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        pnlMenu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 310, 100));

        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        pnlMenu.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 220, -1));

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id proveedor", "RTN", "Nombre", "Correo", "Telefono", "Contacto", "Direccion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProveedores);

        pnlMenu.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 810, 120));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(242, 242, 242));
        lblNombre.setText("Nombre:");
        pnlMenu.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlMenu.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, -1));

        btnVisualizar.setBackground(new java.awt.Color(59, 103, 181));
        btnVisualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisualizarMouseClicked(evt);
            }
        });

        lblVisualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVisualizar.setForeground(new java.awt.Color(242, 242, 242));
        lblVisualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVisualizar.setText("Visualizar Tabla");

        javax.swing.GroupLayout btnVisualizarLayout = new javax.swing.GroupLayout(btnVisualizar);
        btnVisualizar.setLayout(btnVisualizarLayout);
        btnVisualizarLayout.setHorizontalGroup(
            btnVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnVisualizarLayout.setVerticalGroup(
            btnVisualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVisualizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 130, -1));

        lblContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContacto.setForeground(new java.awt.Color(242, 242, 242));
        lblContacto.setText("Contacto:");
        pnlMenu.add(lblContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        lblErrorDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorDireccion.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 300, 20));

        lblErrorRTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorRTN.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorRTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 220, 20));

        lblErrorNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorNombre.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 220, 20));

        lblErrorCorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCorreo.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 220, 20));

        lblErrorContacto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorContacto.setForeground(new java.awt.Color(231, 0, 2));
        pnlMenu.add(lblErrorContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 220, 20));

        btnCancelar.setBackground(new java.awt.Color(59, 103, 181));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(242, 242, 242));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 90, 30));

        btnAgregar.setBackground(new java.awt.Color(59, 103, 181));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(242, 242, 242));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 90, 30));

        btnEditar.setBackground(new java.awt.Color(59, 103, 181));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(242, 242, 242));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 80, 30));

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(242, 242, 242));
        lblEstado.setText("Estado: ");
        pnlMenu.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cmbEstado.setEnabled(false);
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        pnlMenu.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, -1));

        pnlBackbround.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 850, 550));

        pnlTitulo.setBackground(new java.awt.Color(0, 49, 110));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Inventario Hospital Odontológico");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        lblModulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblModulo.setForeground(new java.awt.Color(242, 242, 242));
        lblModulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulo.setText("Mantenimiento Proveedores");
        pnlTitulo.add(lblModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH_SM.png"))); // NOI18N
        pnlTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 80, 90));

        pnlBackbround.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 640, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackbround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackbround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        MenuInicioView homeView = new MenuInicioView();
        homeView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisualizarMouseClicked
        TablaGrandeProveedoresView consultaProveedoresView = new TablaGrandeProveedoresView();
        consultaProveedoresView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVisualizarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarMouseClicked

    private void txtCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo1ActionPerformed

    private void txtIdentidad5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentidad5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidad5ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtRTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRTNActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(!ProveedorController.MantenimientoProveedores("insertar", 0, 
            this.txtRTN.getText(), this.txtNombre.getText(), 
            this.txtCorreo.getText(), this.txtTelefono.getText(), 
            this.txtContacto.getText(), this.txtDireccion.getText(),this.cmbEstado.getSelectedItem().toString(), 
            this.lblErrorRTN, this.lblErrorNombre, this.lblErrorCorreo, 
            this.lblErrorTelefono, this.lblErrorContacto , this.lblErrorDireccion) )
        {
            this.LimpiarInputs();
            ProveedorController.LlenarTableProveedores(tableProveedores);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(!ProveedorController.MantenimientoProveedores("editar", this.Id_proveedor,
            this.txtRTN.getText(), this.txtNombre.getText(),
            this.txtCorreo.getText(), this.txtTelefono.getText(),
            this.txtContacto.getText(), this.txtDireccion.getText(),this.cmbEstado.getSelectedItem().toString(),
            this.lblErrorRTN, this.lblErrorNombre, this.lblErrorCorreo,
            this.lblErrorTelefono, this.lblErrorContacto , this.lblErrorDireccion))
        {
            this.btnAgregar.setEnabled(true);
            this.btnEditar.setEnabled(false);
            this.cmbEstado.setEnabled(false);
            this.LimpiarInputs();
            ProveedorController.LlenarTableProveedores(tableProveedores);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.btnAgregar.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.cmbEstado.setEnabled(false);
        this.tableProveedores.clearSelection();
        this.btnVisualizar.setEnabled(true); 
        this.LimpiarInputs();
        this.LimpiarErrLabels();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedoresMouseClicked
        int seleccion = this.tableProveedores.rowAtPoint(evt.getPoint()); 
        
        this.Id_proveedor = ProveedorController.setDatosEditarFromTable(seleccion, 
                this.tableProveedores, this.txtRTN, this.txtNombre, 
                this.txtCorreo, this.txtTelefono, this.txtContacto, 
                this.txtDireccion,this.cmbEstado);
        if(this.Id_proveedor != null)
        {
            this.LimpiarErrLabels();
            this.cmbEstado.setEnabled(true);
            this.btnAgregar.setEnabled(false);
            this.btnEditar.setEnabled(true);
        }     
    }//GEN-LAST:event_tableProveedoresMouseClicked

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoProveedoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProveedoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProveedoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoProveedoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoProveedoresView().setVisible(true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JPanel btnVisualizar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblErrorContacto;
    private javax.swing.JLabel lblErrorCorreo;
    private javax.swing.JLabel lblErrorDireccion;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorRTN;
    private javax.swing.JLabel lblErrorTelefono;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuarioActual;
    private javax.swing.JLabel lblMensajeBienvenida;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRTN;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JLabel lblVisualizar;
    private javax.swing.JPanel pnlBackbround;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTable tableProveedores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRTN;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
