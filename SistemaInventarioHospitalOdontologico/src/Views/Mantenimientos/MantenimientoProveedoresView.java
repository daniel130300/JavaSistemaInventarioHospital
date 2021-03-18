/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Mantenimientos;

import Controllers.Controllers.ProveedorController;
import Views.Menus.MenuInicioView;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import Views.TablasGrande.TablaGrandeProveedoresView;
import Views.TablasGrande.TablaGrandeProveedoresView;

/**
 *
 * @author danie
 */
public class MantenimientoProveedoresView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public MantenimientoProveedoresView() {
        initComponents();
        ProveedorController.LlenarTableProveedores(tableProveedores);
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
        lblIconoUsuario = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        lblVentas2 = new javax.swing.JLabel();
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
        txtIdentidad5 = new javax.swing.JTextField();
        txtCorreo1 = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtContacto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProveedores = new javax.swing.JTable();
        btnEditar = new javax.swing.JPanel();
        lblEditar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JPanel();
        lblAgregar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        lblCancelar = new javax.swing.JLabel();
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

        lblIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_user_32px.png"))); // NOI18N
        pnlUsuario.add(lblIconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        lblVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(242, 242, 242));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas.setText("Dra. Lourdes");
        pnlUsuario.add(lblVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 28));

        lblVentas2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVentas2.setForeground(new java.awt.Color(242, 242, 242));
        lblVentas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas2.setText("Bienvenido(a)");
        pnlUsuario.add(lblVentas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 28));

        pnlBackbround.add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 130));

        pnlMenu.setBackground(new java.awt.Color(0, 49, 110));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setBackground(new java.awt.Color(45, 83, 150));
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lblErrorTelefono.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

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

        txtIdentidad5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentidad5ActionPerformed(evt);
            }
        });
        pnlMenu.add(txtIdentidad5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 220, -1));

        txtCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo1ActionPerformed(evt);
            }
        });
        pnlMenu.add(txtCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, -1));

        lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(242, 242, 242));
        lblDireccion.setText("Dirección: ");
        pnlMenu.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(242, 242, 242));
        lblTelefono.setText("Teléfono:");
        pnlMenu.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        pnlMenu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 310, 100));

        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        pnlMenu.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 220, -1));

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id proveedor", "RTN", "Nombre", "Correo", "Telefono", "Contacto", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableProveedores);

        pnlMenu.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 810, 120));

        btnEditar.setBackground(new java.awt.Color(59, 103, 181));
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        lblEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(242, 242, 242));
        lblEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditar.setText("Editar");

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 80, -1));

        btnAgregar.setBackground(new java.awt.Color(59, 103, 181));
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        lblAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(242, 242, 242));
        lblAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregar.setText("Agregar");

        javax.swing.GroupLayout btnAgregarLayout = new javax.swing.GroupLayout(btnAgregar);
        btnAgregar.setLayout(btnAgregarLayout);
        btnAgregarLayout.setHorizontalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAgregarLayout.setVerticalGroup(
            btnAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(59, 103, 181));
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        lblCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCancelar.setForeground(new java.awt.Color(242, 242, 242));
        lblCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelar.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 80, -1));

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
        btnVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(lblVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
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
        lblErrorDireccion.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        lblErrorRTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorRTN.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorRTN.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorRTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lblErrorNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorNombre.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorNombre.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        lblErrorCorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCorreo.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorCorreo.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        lblErrorContacto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorContacto.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorContacto.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH (4).png"))); // NOI18N
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
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnEditar;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JPanel btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblErrorContacto;
    private javax.swing.JLabel lblErrorCorreo;
    private javax.swing.JLabel lblErrorDireccion;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorRTN;
    private javax.swing.JLabel lblErrorTelefono;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuario;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRTN;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lblVentas2;
    private javax.swing.JLabel lblVisualizar;
    private javax.swing.JPanel pnlBackbround;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTable tableProveedores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdentidad5;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRTN;
    // End of variables declaration//GEN-END:variables
}
