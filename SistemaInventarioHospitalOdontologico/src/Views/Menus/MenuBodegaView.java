/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Menus;

import Controllers.Controllers.LoginController;
import Controllers.Controllers.MenuBodegaController;
import Views.Mantenimientos.BitacoraCatalogoProductoView;
import Views.Mantenimientos.BitacoraInventarioProductosView;
import java.awt.Color;
import javax.swing.JPanel;
import Views.Mantenimientos.InventarioBodegaView;
import Views.Mantenimientos.MantenimientoCatalogoProductosView;
import Views.Mantenimientos.MantenimientoCategoriasView;
import Views.Mantenimientos.MantenimientoInventarioBodegaView;
import Views.Mantenimientos.MantenimientoUnidadesView;

/**
 *
 * @author danie
 */
public class MenuBodegaView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public MenuBodegaView() {
        initComponents();
        noFocusJButtons();
        LoginController.setLabelUsrLogueado(this.lblUsuarioActual);
        MenuBodegaController menuBodegaController = new MenuBodegaController();
        menuBodegaController.AccesoModulos(
                this.btnMantenimientoCatalogoBodega,
                this.btnMantenimientoCategorias,
                this.btnMantenimientoUnidades,
                this.btnBitacoraCatalogoBodega,
                this.btnMantenimientoInventarioBodega,
                this.btnInventarioBodega, 
                this.btnBitacoraInventarioBodega
                );
    }
    
    private void noFocusJButtons()
    {
        this.btnMantenimientoCatalogoBodega.setFocusable(false);
        this.btnMantenimientoCategorias.setFocusable(false);
        this.btnMantenimientoUnidades.setFocusable(false);
        this.btnBitacoraCatalogoBodega.setFocusable(false);
        this.btnMantenimientoInventarioBodega.setFocusable(false);
        this.btnInventarioBodega.setFocusable(false);
        this.btnBitacoraInventarioBodega.setFocusable(false);
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
        lblIconoUsuarioAcual = new javax.swing.JLabel();
        lblUsuarioActual = new javax.swing.JLabel();
        lblMensajeBienvenida = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JPanel();
        lblIconoRegresar = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        btnMantenimientoInventarioBodega = new javax.swing.JButton();
        btnMantenimientoUnidades = new javax.swing.JButton();
        btnInventarioBodega = new javax.swing.JButton();
        btnBitacoraCatalogoBodega = new javax.swing.JButton();
        btnMantenimientoCategorias = new javax.swing.JButton();
        btnMantenimientoCatalogoBodega = new javax.swing.JButton();
        btnBitacoraInventarioBodega = new javax.swing.JButton();
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

        lblIconoUsuarioAcual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_user_32px.png"))); // NOI18N
        pnlUsuario.add(lblIconoUsuarioAcual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

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

        pnlMenu.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 150, 30));

        btnMantenimientoInventarioBodega.setBackground(new java.awt.Color(45, 83, 150));
        btnMantenimientoInventarioBodega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoInventarioBodega.setForeground(new java.awt.Color(242, 242, 242));
        btnMantenimientoInventarioBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_edit_property_32px.png"))); // NOI18N
        btnMantenimientoInventarioBodega.setText("Mantenimiento Inventario Bodega");
        btnMantenimientoInventarioBodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimientoInventarioBodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenimientoInventarioBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoInventarioBodegaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnMantenimientoInventarioBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 180, 130));

        btnMantenimientoUnidades.setBackground(new java.awt.Color(45, 83, 150));
        btnMantenimientoUnidades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoUnidades.setForeground(new java.awt.Color(242, 242, 242));
        btnMantenimientoUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_conversion_32px.png"))); // NOI18N
        btnMantenimientoUnidades.setText("Mantenimiento Unidades");
        btnMantenimientoUnidades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimientoUnidades.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenimientoUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoUnidadesActionPerformed(evt);
            }
        });
        pnlMenu.add(btnMantenimientoUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 180, 130));

        btnInventarioBodega.setBackground(new java.awt.Color(45, 83, 150));
        btnInventarioBodega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventarioBodega.setForeground(new java.awt.Color(242, 242, 242));
        btnInventarioBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_view_details_32px.png"))); // NOI18N
        btnInventarioBodega.setText("Inventario Bodega");
        btnInventarioBodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventarioBodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventarioBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioBodegaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnInventarioBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 180, 130));

        btnBitacoraCatalogoBodega.setBackground(new java.awt.Color(45, 83, 150));
        btnBitacoraCatalogoBodega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBitacoraCatalogoBodega.setForeground(new java.awt.Color(242, 242, 242));
        btnBitacoraCatalogoBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_log_32px.png"))); // NOI18N
        btnBitacoraCatalogoBodega.setText("Bitácora Catálogo Productos");
        btnBitacoraCatalogoBodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBitacoraCatalogoBodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBitacoraCatalogoBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitacoraCatalogoBodegaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnBitacoraCatalogoBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 180, 130));

        btnMantenimientoCategorias.setBackground(new java.awt.Color(45, 83, 150));
        btnMantenimientoCategorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoCategorias.setForeground(new java.awt.Color(242, 242, 242));
        btnMantenimientoCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_sorting_32px.png"))); // NOI18N
        btnMantenimientoCategorias.setText("Mantenimiento Categorías");
        btnMantenimientoCategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimientoCategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenimientoCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoCategoriasActionPerformed(evt);
            }
        });
        pnlMenu.add(btnMantenimientoCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 180, 130));

        btnMantenimientoCatalogoBodega.setBackground(new java.awt.Color(45, 83, 150));
        btnMantenimientoCatalogoBodega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMantenimientoCatalogoBodega.setForeground(new java.awt.Color(242, 242, 242));
        btnMantenimientoCatalogoBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_warehouse_32px.png"))); // NOI18N
        btnMantenimientoCatalogoBodega.setText("Mantenimiento Catálogo Productos");
        btnMantenimientoCatalogoBodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimientoCatalogoBodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMantenimientoCatalogoBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoCatalogoBodegaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnMantenimientoCatalogoBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 180, 130));

        btnBitacoraInventarioBodega.setBackground(new java.awt.Color(45, 83, 150));
        btnBitacoraInventarioBodega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBitacoraInventarioBodega.setForeground(new java.awt.Color(242, 242, 242));
        btnBitacoraInventarioBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Images/icons8_log_32px.png"))); // NOI18N
        btnBitacoraInventarioBodega.setText("Bitácora Inventario Bodega");
        btnBitacoraInventarioBodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBitacoraInventarioBodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBitacoraInventarioBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitacoraInventarioBodegaActionPerformed(evt);
            }
        });
        pnlMenu.add(btnBitacoraInventarioBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 180, 130));

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
        lblModulo.setText("Menú Bodega");
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

    private void btnMantenimientoInventarioBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoInventarioBodegaActionPerformed
       MantenimientoInventarioBodegaView mantenimientoInventarioBodegaView = new MantenimientoInventarioBodegaView();
       mantenimientoInventarioBodegaView.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnMantenimientoInventarioBodegaActionPerformed

    private void btnMantenimientoUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoUnidadesActionPerformed
        MantenimientoUnidadesView mantenimientoUnidadesView = new MantenimientoUnidadesView();
        mantenimientoUnidadesView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMantenimientoUnidadesActionPerformed

    private void btnInventarioBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioBodegaActionPerformed
        InventarioBodegaView inventarioBodegaView = new InventarioBodegaView();
        inventarioBodegaView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInventarioBodegaActionPerformed

    private void btnBitacoraCatalogoBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacoraCatalogoBodegaActionPerformed
        BitacoraCatalogoProductoView bitacoraCatalogoProductoView = new BitacoraCatalogoProductoView();
        bitacoraCatalogoProductoView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBitacoraCatalogoBodegaActionPerformed

    private void btnMantenimientoCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoCategoriasActionPerformed
        MantenimientoCategoriasView mantenimientoCategoriasView = new  MantenimientoCategoriasView();
        mantenimientoCategoriasView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMantenimientoCategoriasActionPerformed

    private void btnMantenimientoCatalogoBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoCatalogoBodegaActionPerformed
        MantenimientoCatalogoProductosView mantenimientoCatalogoBodegaView = new MantenimientoCatalogoProductosView();
        mantenimientoCatalogoBodegaView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMantenimientoCatalogoBodegaActionPerformed

    private void btnBitacoraInventarioBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacoraInventarioBodegaActionPerformed
        BitacoraInventarioProductosView bitacoraLoteProductosView  = new BitacoraInventarioProductosView();
        bitacoraLoteProductosView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBitacoraInventarioBodegaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBodegaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBodegaView().setVisible(true);
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
    private javax.swing.JButton btnBitacoraCatalogoBodega;
    private javax.swing.JButton btnBitacoraInventarioBodega;
    private javax.swing.JButton btnInventarioBodega;
    private javax.swing.JButton btnMantenimientoCatalogoBodega;
    private javax.swing.JButton btnMantenimientoCategorias;
    private javax.swing.JButton btnMantenimientoInventarioBodega;
    private javax.swing.JButton btnMantenimientoUnidades;
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIconoRegresar;
    private javax.swing.JLabel lblIconoUsuarioAcual;
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
