/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema._de_ticket_dsiii_p2;
import conector.Conexion;
import sistema._de_ticket_dsiii_p2.Soporte;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import java.io.FileOutputStream;
import sistema._de_ticket_dsiii_p2.Soporte;

/**
 *
 * @author antho
 */
public class Inicio extends javax.swing.JFrame {
  Conexion con= new Conexion();
  
   Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    public Inicio() {
        initComponents();
        jPanel1.setVisible(false);
           setLocationRelativeTo(null);
           
           
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTNiniciosesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TBnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TBcontrasena = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        TBcorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TBtelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TBcedula = new javax.swing.JTextField();
        BTNiniciosesion1 = new javax.swing.JButton();
        BTNiniciosesion2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BTNcrearusuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTNiniciosesion.setBackground(new java.awt.Color(153, 255, 255));
        BTNiniciosesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNiniciosesion.setText("Iniciar sesion");
        BTNiniciosesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNiniciosesionActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Inicia sesion en TEKNOSA ");

        jLabel4.setText("CORREO");

        jLabel5.setText("CEDULA");

        jLabel6.setText("TELEFONO");

        BTNiniciosesion1.setBackground(new java.awt.Color(153, 255, 255));
        BTNiniciosesion1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNiniciosesion1.setText("Unirce");
        BTNiniciosesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNiniciosesion1ActionPerformed(evt);
            }
        });

        BTNiniciosesion2.setBackground(new java.awt.Color(153, 255, 255));
        BTNiniciosesion2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNiniciosesion2.setText("Iniciar sesion");
        BTNiniciosesion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNiniciosesion2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Ya tienes cuenta?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TBtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TBcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BTNiniciosesion2)
                                    .addComponent(TBcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(BTNiniciosesion1)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(TBcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNiniciosesion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNiniciosesion2)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        BTNcrearusuario.setBackground(new java.awt.Color(153, 255, 255));
        BTNcrearusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTNcrearusuario.setText("Crear usuario");
        BTNcrearusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcrearusuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TBcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNiniciosesion)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TBnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(279, 279, 279)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTNcrearusuario)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TBnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TBcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNiniciosesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNcrearusuario)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNiniciosesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNiniciosesionActionPerformed
        Login();        
    }//GEN-LAST:event_BTNiniciosesionActionPerformed

    private void BTNiniciosesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNiniciosesion1ActionPerformed
CrearUsuario();

    }//GEN-LAST:event_BTNiniciosesion1ActionPerformed

    private void BTNcrearusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcrearusuarioActionPerformed
       jPanel1.setVisible(true);
       BTNiniciosesion.setVisible(false);
       BTNcrearusuario.setVisible(false);
    }//GEN-LAST:event_BTNcrearusuarioActionPerformed

    private void BTNiniciosesion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNiniciosesion2ActionPerformed
         jPanel1.setVisible(false);
       BTNiniciosesion.setVisible(true);
       BTNcrearusuario.setVisible(true);
    }//GEN-LAST:event_BTNiniciosesion2ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    
    
  void Login() {
    String nombre = TBnombre.getText();
    String contrasena = TBcontrasena.getText();

    if (nombre.equals("") || contrasena.equals("")) {
        JOptionPane.showMessageDialog(null, "Llene todos los campos");
        return;
    }

    conet = con.getConnection();

    try {
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ? AND activo = TRUE";
        PreparedStatement pst = conet.prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, contrasena);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String rol = rs.getString("rol");
            String idUsuario = rs.getString("id_usuario"); // Obtenemos la cédula

            if ("tecnico".equalsIgnoreCase(rol)) {
                JOptionPane.showMessageDialog(null, "Bienvenido " + nombre);

                // Pasamos la cédula al JFrame Soporte
                Soporte soporte = new Soporte(idUsuario);
                soporte.setVisible(true);
                soporte.setLocationRelativeTo(null);

                this.dispose(); // Cerrar el login
            } else if ("cliente".equalsIgnoreCase(rol)) {
                JOptionPane.showMessageDialog(null, "Bienvenido " + nombre);

                
                clientView cliente = new clientView(idUsuario);
                cliente.setVisible(true);
                cliente.setLocationRelativeTo(null);
                this.dispose();                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
    }
}

void CrearUsuario() {
    String nombre = TBnombre.getText();
    String contrasena = TBcontrasena.getText();
    String correo = TBcorreo.getText();
    String cedula = TBcedula.getText();
    String telefono = TBtelefono.getText();

    if (nombre.isEmpty() || contrasena.isEmpty() || correo.isEmpty() || cedula.isEmpty() || telefono.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Llene todos los campos.");
        return;
    }

    conet = con.getConnection();

    try {
        // Verificamos que no exista ya un usuario con esa cédula
        String checkSql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        PreparedStatement checkPst = conet.prepareStatement(checkSql);
        checkPst.setString(1, cedula);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esta cédula.");
            return;
        }

        // Insertamos el nuevo usuario
        String insertSql = "INSERT INTO usuarios (id_usuario, nombre, contrasena, correo, telefono, rol, activo) VALUES (?, ?, ?, ?, ?, 'cliente', TRUE)";
        PreparedStatement pst = conet.prepareStatement(insertSql);
        pst.setString(1, cedula);
        pst.setString(2, nombre);
        pst.setString(3, contrasena);
        pst.setString(4, correo);
        pst.setString(5, telefono);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente. Redirigiendo...");

            // Abrimos la vista cliente automáticamente
            clientView cliente = new clientView(cedula);
            cliente.setVisible(true);
            cliente.setLocationRelativeTo(null);

            this.dispose(); // Cerramos la ventana de inicio
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
        }

        pst.close();
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        e.printStackTrace();
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNcrearusuario;
    private javax.swing.JButton BTNiniciosesion;
    private javax.swing.JButton BTNiniciosesion1;
    private javax.swing.JButton BTNiniciosesion2;
    private javax.swing.JTextField TBcedula;
    private javax.swing.JPasswordField TBcontrasena;
    private javax.swing.JTextField TBcorreo;
    private javax.swing.JTextField TBnombre;
    private javax.swing.JTextField TBtelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
