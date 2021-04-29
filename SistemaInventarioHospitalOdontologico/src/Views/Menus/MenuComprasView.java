/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Menus;

import Controllers.Controllers.LoginController;
import Controllers.Controllers.MenuComprasController;
import Views.Mantenimientos.DevolucionComprasView;
import Views.Mantenimientos.RegistrarCompraView;
import java.awt.Color;
import javax.swing.JPanel;
import Views.Mantenimientos.MantenimientoRubrosView;

/**
 *
 * @author danie
 */
public class MenuComprasView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public MenuComprasView() {
        initComponents();
        noFocusJButtons();
        LoginController.setLabelUsrLogueado(this.lblUsuarioActual);
        MenuComprasController menuComprasController = new MenuComprasController();
        menuComprasController.AccesoModulos(this.btnRegistrarCompra, 
                this.btnDevolucionCompra, this.btnHistorialCompras);
    }
    
    private void noFocusJButtons()
    {
        this.btnRegistrarCompra.setFocusable(false);
        this.btnDevolucionCompra.setFocusable(false);
        this.btnHistorialCompras.setFocusable(false);
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
        btnHistorialCompras = new javax.swing.JButton();
        btnRegistrarCompra = new javax.swing.JButton();
        btnDevolucionCompra = new javax.swing.JButton();
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
        pnlUsuario.add(lblIconoUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        lblUsuarioActual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuarioActual.setForeground(new java.awt.Color(242, 242, 242));
        lblUsuarioActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlUsuario.add(lblUsuarioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 130, 28));

        lblMensajeBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMensajeBienvenida.setForeground(new java.awt.Color(242, 242, 242));
        lblMensajeBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeBienvenida.setText("Bienvenido(a)");
        pnlUsuario.add(lblMensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 130, 28));

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

        pnlMenu.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, 30));

        btnHistorialCompras.setBackground(new java.awt.Color(45, 83, 150));
        btnHistorialCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorialCompras.setForeground(new java.awt.Color(242, 242, 242));
        btnHistorialCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_order_history_32px.png"))); // NOI18N
        btnHistorialCompras.setText("Historial de Compras");
        btnHistorialCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorialCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHistorialCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialComprasActionPerformed(evt);
            }
        });
        pnlMenu.add(btnHistorialCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 180, 130));

        btnRegistrarCompra.setBackground(new java.awt.Color(45, 83, 150));
        btnRegistrarCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarCompra.setForeground(new java.awt.Color(242, 242, 242));
        btnRegistrarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_purchase_order_32px.png"))); // NOI18N
        btnRegistrarCompra.setText("Registrar Compra");
        btnRegistrarCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });
        pnlMenu.add(btnRegistrarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 180, 130));

        btnDevolucionCompra.setBackground(new java.awt.Color(45, 83, 150));
        btnDevolucionCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDevolucionCompra.setForeground(new java.awt.Color(242, 242, 242));
        btnDevolucionCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_refund_32px.png"))); // NOI18N
        btnDevolucionCompra.setText("Devolución de Compra");
        btnDevolucionCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDevolucionCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDevolucionCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionCompraActionPerformed(evt);
            }
        });
        pnlMenu.add(btnDevolucionCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 180, 130));

        pnlBackbround.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 920, 420));

        pnlTitulo.setBackground(new java.awt.Color(0, 49, 110));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(242, 242, 242));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sistema de Inventario Hospital Odontológico");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        lblModulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblModulo.setForeground(new java.awt.Color(242, 242, 242));
        lblModulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulo.setText("Menú Compras");
        pnlTitulo.add(lblModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/Isotipo.HospitalOdontológico.UNICAH_SM.png"))); // NOI18N
        pnlTitulo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 80, 90));

        pnlBackbround.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 710, 130));

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
            .addComponent(pnlBackbround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        MenuInicioView menuInicioView = new MenuInicioView();
        menuInicioView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnHistorialComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialComprasActionPerformed
       
    }//GEN-LAST:event_btnHistorialComprasActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        RegistrarCompraView registrarCompraView = new RegistrarCompraView();
        registrarCompraView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void btnDevolucionCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionCompraActionPerformed
        DevolucionComprasView devolucionComprasView = new DevolucionComprasView();
        devolucionComprasView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDevolucionCompraActionPerformed

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
            java.util.logging.Logger.getLogger(MenuComprasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuComprasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuComprasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuComprasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuComprasView().setVisible(true);
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
    private javax.swing.JButton btnDevolucionCompra;
    private javax.swing.JButton btnHistorialCompras;
    private javax.swing.JButton btnRegistrarCompra;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuarioActual;
    private javax.swing.JLabel lblMensajeBienvenida;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JPanel pnlBackbround;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlUsuario;
    // End of variables declaration//GEN-END:variables
}
