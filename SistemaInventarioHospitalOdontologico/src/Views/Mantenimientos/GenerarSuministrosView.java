/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Mantenimientos;

import Controllers.Controllers.LoginController;
import java.awt.Color;
import javax.swing.JPanel;
import Views.Listados.ListadoSuministrosView;
import Views.Menus.MenuSuministrosView;

/**
 *
 * @author danie
 */
public class GenerarSuministrosView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public GenerarSuministrosView() {
        initComponents();
        LoginController.setLabelUsrLogueado(this.lblUsuarioActual);
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
        btnGenerarSuministros = new javax.swing.JPanel();
        lblGenerarSuministros = new javax.swing.JLabel();
        lblNombreSuministro = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        lblPrecioVenta = new javax.swing.JLabel();
        lblSeleccionarSuministro = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblUnidad = new javax.swing.JLabel();
        lblErrorCantidad = new javax.swing.JLabel();
        btnSeleccionarSuministro = new javax.swing.JPanel();
        lblSeleccionarProducto1 = new javax.swing.JLabel();
        txtNombreSuministro = new javax.swing.JTextField();
        lblErrorSeleccionarSuministro = new javax.swing.JLabel();
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

        pnlBackbround.add(pnlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 130));

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

        btnGenerarSuministros.setBackground(new java.awt.Color(59, 103, 181));
        btnGenerarSuministros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnGenerarSuministros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarSuministros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarSuministrosMouseClicked(evt);
            }
        });

        lblGenerarSuministros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGenerarSuministros.setForeground(new java.awt.Color(242, 242, 242));
        lblGenerarSuministros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenerarSuministros.setText("Generar Suministros");

        javax.swing.GroupLayout btnGenerarSuministrosLayout = new javax.swing.GroupLayout(btnGenerarSuministros);
        btnGenerarSuministros.setLayout(btnGenerarSuministrosLayout);
        btnGenerarSuministrosLayout.setHorizontalGroup(
            btnGenerarSuministrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGenerarSuministrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGenerarSuministros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnGenerarSuministrosLayout.setVerticalGroup(
            btnGenerarSuministrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGenerarSuministrosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGenerarSuministros, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnGenerarSuministros, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        lblNombreSuministro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreSuministro.setForeground(new java.awt.Color(242, 242, 242));
        lblNombreSuministro.setText("Nombre del Suministro: ");
        pnlMenu.add(lblNombreSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        pnlMenu.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 80, -1));

        lblPrecioVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecioVenta.setForeground(new java.awt.Color(242, 242, 242));
        lblPrecioVenta.setText("Precio Venta: ");
        pnlMenu.add(lblPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        lblSeleccionarSuministro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSeleccionarSuministro.setForeground(new java.awt.Color(242, 242, 242));
        lblSeleccionarSuministro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeleccionarSuministro.setText("Seleccionar Suministro:");
        pnlMenu.add(lblSeleccionarSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(242, 242, 242));
        lblCantidad.setText("Cantidad: ");
        pnlMenu.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, 20));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        pnlMenu.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 80, 20));

        lblUnidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUnidad.setForeground(new java.awt.Color(242, 242, 242));
        lblUnidad.setText("unidades");
        pnlMenu.add(lblUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        lblErrorCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorCantidad.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorCantidad.setText("Error este campo es requerido");
        pnlMenu.add(lblErrorCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, 20));

        btnSeleccionarSuministro.setBackground(new java.awt.Color(59, 103, 181));
        btnSeleccionarSuministro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 115, 196)));
        btnSeleccionarSuministro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionarSuministro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarSuministroMouseClicked(evt);
            }
        });

        lblSeleccionarProducto1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSeleccionarProducto1.setForeground(new java.awt.Color(242, 242, 242));
        lblSeleccionarProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeleccionarProducto1.setText("Seleccionar Suministro");

        javax.swing.GroupLayout btnSeleccionarSuministroLayout = new javax.swing.GroupLayout(btnSeleccionarSuministro);
        btnSeleccionarSuministro.setLayout(btnSeleccionarSuministroLayout);
        btnSeleccionarSuministroLayout.setHorizontalGroup(
            btnSeleccionarSuministroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSeleccionarSuministroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSeleccionarProducto1)
                .addContainerGap())
        );
        btnSeleccionarSuministroLayout.setVerticalGroup(
            btnSeleccionarSuministroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSeleccionarSuministroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSeleccionarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMenu.add(btnSeleccionarSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        txtNombreSuministro.setEditable(false);
        txtNombreSuministro.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        txtNombreSuministro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreSuministroActionPerformed(evt);
            }
        });
        pnlMenu.add(txtNombreSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 190, -1));

        lblErrorSeleccionarSuministro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorSeleccionarSuministro.setForeground(new java.awt.Color(231, 0, 2));
        lblErrorSeleccionarSuministro.setText("Error debe seleccionar un suministro");
        pnlMenu.add(lblErrorSeleccionarSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        pnlBackbround.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 850, 420));

        pnlTitulo.setBackground(new java.awt.Color(0, 49, 110));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Inventario Hospital Odontológico");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        lblModulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblModulo.setForeground(new java.awt.Color(242, 242, 242));
        lblModulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulo.setText("Generar Suministros");
        pnlTitulo.add(lblModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH_SM.png"))); // NOI18N
        pnlTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 90));

        pnlBackbround.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackbround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackbround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        MenuSuministrosView menuSuministrosView = new MenuSuministrosView();
        menuSuministrosView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnGenerarSuministrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarSuministrosMouseClicked
        
    }//GEN-LAST:event_btnGenerarSuministrosMouseClicked

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnSeleccionarSuministroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarSuministroMouseClicked
        ListadoSuministrosView listadoSuministrosView = new ListadoSuministrosView();
        listadoSuministrosView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarSuministroMouseClicked

    private void txtNombreSuministroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreSuministroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreSuministroActionPerformed

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
            java.util.logging.Logger.getLogger(GenerarSuministrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarSuministrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarSuministrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarSuministrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarSuministrosView().setVisible(true);
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
    private javax.swing.JPanel btnGenerarSuministros;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JPanel btnSeleccionarSuministro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblErrorCantidad;
    private javax.swing.JLabel lblErrorSeleccionarSuministro;
    private javax.swing.JLabel lblGenerarSuministros;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuarioActual;
    private javax.swing.JLabel lblMensajeBienvenida;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblNombreSuministro;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblSeleccionarProducto1;
    private javax.swing.JLabel lblSeleccionarSuministro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JPanel pnlBackbround;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombreSuministro;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
