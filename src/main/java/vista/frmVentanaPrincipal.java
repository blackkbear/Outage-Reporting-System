/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;




import controlador.ControllerReporteyListadoAverias;

import controlador.ControllerUsuario;

import java.awt.Color;
import java.awt.Desktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.frmIngreso;


/**
 *
 * @author two_r
 */
public class frmVentanaPrincipal extends javax.swing.JFrame {
    
    Usuario mod;
    
    
   public frmVentanaPrincipal() {
        initComponents();
//        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_size.jpg"));
//        this.setIconImage(icon.getImage());
}
    
    public frmVentanaPrincipal(Usuario mod) {
        this.mod = mod;
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
 
        if(mod.getTipoRol().equals("GobiernoCentral")){ //gobierno central
            
        }else if (mod.getTipoRol().equals("Institucion")){ //institucion
            menuRegistros.setVisible(false);
            mitemUsuarios.setVisible(false);
            
                      
        }else if (mod.getTipoRol().equals("Ciudadano")){ //ciudadano
            menuRegistros.setVisible(false);
            mitemUsuarios.setVisible(false);
            mitemConcepto.setVisible(false);
            mitemSeguimiento.setVisible(false);
            
        }else if (mod.getTipoRol().equals("Reportes")){ //reportes
            menuRegistros.setVisible(false);
            mitemUsuarios.setVisible(false);
        }
    }

    /**
     * Creates new form frmVentanaPrincipal
     */
//   public frmVentanaPrincipal(String idUsuario, String nombreUsuario, String tipoUsuario ) {
 //       initComponents();
  //      setLocationRelativeTo(null);
 //       setExtendedState(JFrame.MAXIMIZED_BOTH);
 //      setTitle("Flash Repair - Mantenimientos");
  //     lblIdPrincip.setText("ID: " + idUsuario);
  //      lblNombrePrincip.setText("Usuario: " + nombreUsuario);
  //      lblTipoPrincip.setText("Tipo de Usuario: " + tipoUsuario);
       
        
       
   //            }
   

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        lblUsuario = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        mitemSalir = new javax.swing.JMenuItem();
        menuRegistros = new javax.swing.JMenu();
        mitemCiudadanos = new javax.swing.JMenuItem();
        menuRegistroInstituciones = new javax.swing.JMenuItem();
        menuMantenimiento = new javax.swing.JMenu();
        mitemUsuarios = new javax.swing.JMenuItem();
        mitemRegistroyListado = new javax.swing.JMenuItem();
        mitemSeguimiento = new javax.swing.JMenuItem();
        mitemConcepto = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        mitemSobre = new javax.swing.JMenuItem();
        mitemManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        desktopPane.setForeground(new java.awt.Color(255, 255, 255));

        lblRol.setText("jLabel2");

        desktopPane.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblRol, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(393, 393, 393)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(410, Short.MAX_VALUE))
        );

        desktopPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblRol, lblUsuario});

        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        desktopPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblRol, lblUsuario});

        jToolBar1.setRollover(true);

        menuArchivo.setText("Archivo");
        menuArchivo.setToolTipText("Salir");

        mitemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitemSalir.setText("Salir");
        mitemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(mitemSalir);

        menuBar.add(menuArchivo);

        menuRegistros.setText("Páginas de Registro");
        menuRegistros.setToolTipText("Registro de Citas");

        mitemCiudadanos.setText("Registro de Ciudadanos");
        mitemCiudadanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemCiudadanosActionPerformed(evt);
            }
        });
        menuRegistros.add(mitemCiudadanos);

        menuRegistroInstituciones.setText("Registro de Instituciones");
        menuRegistroInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistroInstitucionesActionPerformed(evt);
            }
        });
        menuRegistros.add(menuRegistroInstituciones);

        menuBar.add(menuRegistros);

        menuMantenimiento.setText("Páginas de Mantenimiento");
        menuMantenimiento.setToolTipText("Mantenimiento de Usuarios, Vets, Mascotas, Dueños");

        mitemUsuarios.setText("Usuarios");
        mitemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemUsuariosActionPerformed(evt);
            }
        });
        menuMantenimiento.add(mitemUsuarios);

        mitemRegistroyListado.setText("Registro y listado de averías");
        mitemRegistroyListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemRegistroyListadoActionPerformed(evt);
            }
        });
        menuMantenimiento.add(mitemRegistroyListado);

        mitemSeguimiento.setText("Seguimiento de averías");
        mitemSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemSeguimientoActionPerformed(evt);
            }
        });
        menuMantenimiento.add(mitemSeguimiento);

        mitemConcepto.setText("Inversión por concepto de averías");
        mitemConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemConceptoActionPerformed(evt);
            }
        });
        menuMantenimiento.add(mitemConcepto);

        menuBar.add(menuMantenimiento);

        menuAyuda.setText("Ayuda");
        menuAyuda.setToolTipText("Ver los Créditos y descargar Manual de uso del Sistema");

        mitemSobre.setText("Acerca De");
        mitemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemSobreActionPerformed(evt);
            }
        });
        menuAyuda.add(mitemSobre);

        mitemManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mitemManual.setText("Manual");
        mitemManual.setToolTipText("Presione \"Manual\" para abrir el PDF Manual. Para descargar, presione el disco de \"Guardar cómo\"");
        mitemManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemManualActionPerformed(evt);
            }
        });
        menuAyuda.add(mitemManual);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemUsuariosActionPerformed
        // TODO add your handling code here:
         frmUsuario obj = new frmUsuario();
        desktopPane.add(obj);
        ControllerUsuario con = new ControllerUsuario(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(desktopPane.getWidth() / 4 - obj.getWidth() / 4, desktopPane.getHeight() / 4 - obj.getHeight() / 4);
        obj.setVisible(true);
    }//GEN-LAST:event_mitemUsuariosActionPerformed

    private void mitemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemSalirActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Desea salir del sistema? Presione 'OK' para salir.");
        System.exit(0);
    }//GEN-LAST:event_mitemSalirActionPerformed

    private void mitemManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemManualActionPerformed
        // TODO add your handling code here:
        try {
           Desktop.getDesktop().open(new File(""));
        } catch (Exception ex) {
            Logger.getLogger(frmVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_mitemManualActionPerformed

    private void mitemCiudadanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemCiudadanosActionPerformed
          new frmRegistroCiudadanos().setVisible(true);
    }//GEN-LAST:event_mitemCiudadanosActionPerformed

    private void mitemConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemConceptoActionPerformed

    }//GEN-LAST:event_mitemConceptoActionPerformed

    private void mitemSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemSeguimientoActionPerformed
    new frmSeguimientoAverias().setVisible(true);
    }//GEN-LAST:event_mitemSeguimientoActionPerformed

    private void mitemRegistroyListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemRegistroyListadoActionPerformed
        // TODO add your handling code here:
       new frmReporteyListadoAverias().setVisible(true);
    }//GEN-LAST:event_mitemRegistroyListadoActionPerformed

    private void mitemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemSobreActionPerformed
    
    }//GEN-LAST:event_mitemSobreActionPerformed

    private void menuRegistroInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistroInstitucionesActionPerformed
        new frmRegistroInstituciones().setVisible(true);
    }//GEN-LAST:event_menuRegistroInstitucionesActionPerformed

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
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentanaPrincipal().setVisible(true);
           //lblIdPrincip.getText(), lblNombrePrincip.getText(), lblTipoPrincip.getText()     
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    public javax.swing.JMenu menuArchivo;
    public javax.swing.JMenu menuAyuda;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenu menuMantenimiento;
    public javax.swing.JMenuItem menuRegistroInstituciones;
    public javax.swing.JMenu menuRegistros;
    public javax.swing.JMenuItem mitemCiudadanos;
    public javax.swing.JMenuItem mitemConcepto;
    public javax.swing.JMenuItem mitemManual;
    public javax.swing.JMenuItem mitemRegistroyListado;
    public javax.swing.JMenuItem mitemSalir;
    public javax.swing.JMenuItem mitemSeguimiento;
    public javax.swing.JMenuItem mitemSobre;
    public javax.swing.JMenuItem mitemUsuarios;
    // End of variables declaration//GEN-END:variables
}
