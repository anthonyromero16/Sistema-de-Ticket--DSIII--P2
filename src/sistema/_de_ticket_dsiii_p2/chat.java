/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sistema._de_ticket_dsiii_p2;

import javax.swing.text.*;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JOptionPane;

import conector.Conexion;
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


public class chat extends javax.swing.JDialog {
Conexion con= new Conexion();
 Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    StyledDocument doc;
SimpleAttributeSet estiloTecnico;
SimpleAttributeSet estiloCliente;
SimpleAttributeSet estiloMensaje;
private String idTicket;
   public chat(java.awt.Frame parent, boolean modal, String idTicket) {
    super(parent, modal);
    initComponents();
    this.idTicket = idTicket;
    this.emisor_id = emisor_id;
    this.receptor_id = receptor_id;
    
    
    doc = JTPchat.getStyledDocument();
    estiloTecnico = new SimpleAttributeSet();
    StyleConstants.setForeground(estiloTecnico, Color.GREEN);
    StyleConstants.setBold(estiloTecnico, true);

    estiloCliente = new SimpleAttributeSet();
    StyleConstants.setForeground(estiloCliente, Color.BLUE);
    StyleConstants.setBold(estiloCliente, true);

    estiloMensaje = new SimpleAttributeSet();
    StyleConstants.setForeground(estiloMensaje, Color.BLACK);

    cargarMensajesChat(idTicket); // opcional
}
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTPchat = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        JTmensaje = new javax.swing.JTextField();
        BTNenviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setViewportView(JTPchat);

        jLabel1.setText("CHAT");

        JTmensaje.setToolTipText("");
        JTmensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTmensajeActionPerformed(evt);
            }
        });

        BTNenviar.setText("ENVIAR");
        BTNenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNenviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNenviar)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(167, 167, 167))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNenviar))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTmensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTmensajeActionPerformed

    }//GEN-LAST:event_JTmensajeActionPerformed

    private void BTNenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNenviarActionPerformed
                                       
    String mensaje = JTmensaje.getText().trim();
if (!mensaje.isEmpty()) {
    String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    agregarMensajeEnPantalla("tecnico", mensaje, fechaHora);
    JTmensaje.setText("");

    try {
        conet = con.getConnection();
       String sql = "INSERT INTO mensajes_chat (id_ticket, emisor_id, receptor_id, mensaje, fecha_envio) VALUES (?, ?, ?, ?, ?)";
PreparedStatement pst = conet.prepareStatement(sql);
      pst.setString(1, idTicket);
pst.setString(2, emisor_id);   // cédula del técnico que envía
pst.setString(3, receptor_id);   // cédula del cliente que recibe
pst.setString(4, mensaje);
pst.setString(5, fechaHora);
pst.executeUpdate();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al guardar mensaje: " + ex.getMessage());
    }
}
    }//GEN-LAST:event_BTNenviarActionPerformed

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
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          chat dialog = new chat(new javax.swing.JFrame(), true, "5");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    private void agregarMensajeEnPantalla(String remitente, String mensaje, String fechaHora) {
    try {
        if (remitente.equalsIgnoreCase("tecnico")) {
            doc.insertString(doc.getLength(), remitente + " [" + fechaHora + "]\n", estiloTecnico);
        } else {
            doc.insertString(doc.getLength(), remitente + " [" + fechaHora + "]\n", estiloCliente);
        }

        doc.insertString(doc.getLength(), mensaje + "\n\n", estiloMensaje);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}

    
 private void cargarMensajesChat(String idTicket) {
    try {
        Connection conn = con.getConnection();
        String sql = "SELECT emisor_id, mensaje, fecha_envio FROM mensajes_chat WHERE id_ticket = ? ORDER BY fecha_envio ASC";
        PreparedStatement pst = conn.prepareStatement(sql); // <- Faltaba esta línea antes del execute
        pst.setString(1, idTicket);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String remitente = rs.getString("emisor_id");
            String mensaje = rs.getString("mensaje");
            String fechaHora = rs.getString("fecha_envio");

            // Aquí puedes comparar con la cédula del técnico logueado si quieres
            agregarMensajeEnPantalla(remitente, mensaje, fechaHora);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar el chat: " + e.getMessage());
    }
}

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNenviar;
    private javax.swing.JTextPane JTPchat;
    private javax.swing.JTextField JTmensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
