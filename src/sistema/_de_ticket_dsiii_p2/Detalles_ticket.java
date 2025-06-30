/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sistema._de_ticket_dsiii_p2;

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
/**
 *
 * @author antho
 */
public class Detalles_ticket extends javax.swing.JDialog {
    Conexion con= new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    /**
     * Creates new form Detalles_ticket
     */

    public String idTicket; 
    public String rol;
    public String idTecnico;
    
    
public Detalles_ticket(java.awt.Frame parent, boolean modal, String idTicket, String rol, String idTecnico) {
    super(parent, modal);
    initComponents();
    this.idTicket = idTicket;
  this.idTecnico = idTecnico;

    this.rol = rol;
cargarComentariosTicket();
   

    BTNAgregar_comentario.requestFocusInWindow();

    // Configuración del área de comentarios
    TAcomentario.setText("Inserte su comentario aquí");
    TAcomentario.setForeground(Color.GRAY);
    TAcomentario.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (TAcomentario.getText().equals("Inserte su comentario aquí")) {
                TAcomentario.setText("");
                TAcomentario.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (TAcomentario.getText().trim().isEmpty()) {
                TAcomentario.setText("Inserte su comentario aquí");
                TAcomentario.setForeground(Color.GRAY);
            }
        }
    });
    
     // Cargar los detalles del ticket usando el ID
    cargarDetallesTicket();
    
    }

   
    
    
    
       
private void cargarDetallesTicket() {
    try {
        conet = con.getConnection();
        String sql = "SELECT t.id_ticket, t.titulo, t.descripcion, t.estado, t.prioridad, t.fecha_creacion, " +
                     "u.nombre AS cliente, ut.nombre AS tecnico " +
                     "FROM tickets t " +
                     "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                     "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                     "JOIN usuarios ut ON a.id_tecnico = ut.id_usuario " +
                     "WHERE t.id_ticket = ?";

        PreparedStatement pst = conet.prepareStatement(sql);
        pst.setString(1, idTicket);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            LBLid_ticket.setText(rs.getString("id_ticket"));
            LBLtecnico.setText(rs.getString("tecnico")); // técnico a cargo del ticket
            LBLtitulo.setText(rs.getString("titulo"));
            LBLdescripcion.setText(rs.getString("descripcion"));
            
            JCBprioridad.setSelectedItem(rs.getString("prioridad"));
JCBestado.setSelectedItem(rs.getString("estado"));
            LBLfecha_creacion.setText(rs.getString("fecha_creacion"));
            LBLcliente.setText(rs.getString("cliente"));
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró información para el ticket.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar detalles: " + e.getMessage());
    }
}

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BTNAgregar_comentario = new javax.swing.JButton();
        LBLcliente = new javax.swing.JLabel();
        LBLid_ticket = new javax.swing.JLabel();
        LBLtitulo = new javax.swing.JLabel();
        LBLtecnico = new javax.swing.JLabel();
        LBLfecha_creacion = new javax.swing.JLabel();
        LBLdescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAcomentario = new javax.swing.JTextArea();
        BTNresuelto = new javax.swing.JButton();
        JCBprioridad = new javax.swing.JComboBox<>();
        JCBestado = new javax.swing.JComboBox<>();
        BTNchat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LBLcomentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DETALLES DEL TICKET");

        jLabel2.setText("ID Ticket:");

        jLabel3.setText("Cliente: ");

        jLabel4.setText("Técnico asignado:");

        jLabel5.setText("´Título:");

        jLabel6.setText("Prioridad:");

        jLabel7.setText("Estado:");

        jLabel8.setText("Fecha de Creación:");

        jLabel9.setText("Descripción:");

        BTNAgregar_comentario.setText("Agregar Comentario");
        BTNAgregar_comentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgregar_comentarioActionPerformed(evt);
            }
        });

        LBLcliente.setText("---");

        LBLid_ticket.setText("---");

        LBLtitulo.setText("---");

        LBLtecnico.setText("---");

        LBLfecha_creacion.setText("---");

        LBLdescripcion.setText("---");

        TAcomentario.setColumns(20);
        TAcomentario.setForeground(new java.awt.Color(204, 204, 204));
        TAcomentario.setRows(5);
        TAcomentario.setText("Inserte su comentario aquí ");
        TAcomentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAcomentarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TAcomentario);

        BTNresuelto.setText("Guardar Actualizaciones");
        BTNresuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNresueltoActionPerformed(evt);
            }
        });

        JCBprioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ninguna", "alta", "media", "baja", " " }));

        JCBestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "en espera", "en proceso", "resuelto", "cancelado" }));

        BTNchat.setText("Chat");
        BTNchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNchatActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(242, 242, 242));

        LBLcomentario.setEditable(false);
        LBLcomentario.setColumns(20);
        LBLcomentario.setRows(5);
        jScrollPane2.setViewportView(LBLcomentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LBLdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(LBLid_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LBLtecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LBLcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LBLtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LBLfecha_creacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JCBprioridad, 0, 119, Short.MAX_VALUE)
                                            .addComponent(JCBestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(159, 159, 159))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BTNAgregar_comentario)
                                        .addGap(54, 54, 54)
                                        .addComponent(BTNchat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTNresuelto)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LBLid_ticket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LBLcliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LBLtecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LBLtitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JCBprioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(JCBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LBLfecha_creacion))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LBLdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNAgregar_comentario)
                    .addComponent(BTNresuelto)
                    .addComponent(BTNchat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TAcomentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAcomentarioMouseClicked
       
   
    }//GEN-LAST:event_TAcomentarioMouseClicked

    private void BTNAgregar_comentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgregar_comentarioActionPerformed
   
       String comentario = TAcomentario.getText().trim();
  
comentario();
  
    }//GEN-LAST:event_BTNAgregar_comentarioActionPerformed

    private void BTNchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNchatActionPerformed
    Chat dialog = new Chat(null, true, idTicket, rol, idTecnico); // ← pasas los 3 valores
    dialog.setVisible(true);

   
    }//GEN-LAST:event_BTNchatActionPerformed

    private void BTNresueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNresueltoActionPerformed
GuardarActualizacion();      
    }//GEN-LAST:event_BTNresueltoActionPerformed

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
            java.util.logging.Logger.getLogger(Detalles_ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalles_ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalles_ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalles_ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
   String idTicket = "5";         // ← simulado o real
    String rol = "tecnico";        // ← simulado o real
    String idTecnico = "123456";   // ← simulado o real

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Detalles_ticket dialog = new Detalles_ticket(
                new javax.swing.JFrame(), 
                true, 
                idTicket, 
                rol, 
                idTecnico
            );
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

    
    
    public void GuardarActualizacion() {
    String nuevoEstado = JCBestado.getSelectedItem().toString();
    String nuevaPrioridad = JCBprioridad.getSelectedItem().toString();

  

    Connection conn = con.getConnection();
    PreparedStatement ps = null;

    try {
        String sql = "UPDATE tickets SET estado = ?, prioridad = ? WHERE id_ticket = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, nuevoEstado);
        ps.setString(2, nuevaPrioridad);
        ps.setString(3, idTicket);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el ticket para actualizar.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el ticket: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
        }
    }
}
    
public void comentario() {
    String comentarioTexto = TAcomentario.getText().trim();

    if (comentarioTexto.isEmpty() || comentarioTexto.equals("Inserte su comentario aquí")) {
        JOptionPane.showMessageDialog(this, "Debe escribir un comentario válido.");
        return;
    }

    String estado = JCBestado.getSelectedItem().toString().toLowerCase().trim();
    String prioridad = JCBprioridad.getSelectedItem().toString().toLowerCase().trim();

    Connection conn = con.getConnection();

    try {
        // 1. Insertar en seguimiento_tickets
        String sql = "INSERT INTO seguimiento_tickets (id_ticket, id_usuario, comentario, estado, prioridad) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, idTicket);
        pst.setString(2, idTecnico);
        pst.setString(3, comentarioTexto);
        pst.setString(4, estado);
        pst.setString(5, prioridad);

        int result = pst.executeUpdate();

        if (result > 0) {
            // 2. Obtener comentarios actuales
            String comentarioActual = LBLcomentario.getText();
            if (comentarioActual.equals("-------------------------------")) {
                comentarioActual = "";
            }

            // 3. Agregar nuevo comentario con salto de línea si ya había uno
            if (!comentarioActual.isEmpty()) {
                comentarioActual += "\n";
            }
            comentarioActual += "comentario: " + comentarioTexto;

            // 4. Mostrar en el área
            LBLcomentario.setText(comentarioActual);

            // 5. Resetear el campo de entrada
            TAcomentario.setText("Inserte su comentario aquí");
            TAcomentario.setForeground(Color.GRAY);

            JOptionPane.showMessageDialog(this, "Comentario agregado correctamente.");
        }

        pst.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al agregar comentario: " + e.getMessage());
    }
}

private void cargarComentariosTicket() {
    Connection conn = con.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT comentario FROM seguimiento_tickets WHERE id_ticket = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, idTicket);

        rs = pst.executeQuery();

        StringBuilder comentariosTotales = new StringBuilder();
        while (rs.next()) {
            String c = rs.getString("comentario");

            if (comentariosTotales.length() > 0) {
                comentariosTotales.append("\n"); // salto de línea solo si ya hay algo
            }

            comentariosTotales.append("comentario: ").append(c);
        }

        LBLcomentario.setText(comentariosTotales.toString());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar comentarios: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cerrar conexión: " + ex.getMessage());
        }
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgregar_comentario;
    private javax.swing.JButton BTNchat;
    private javax.swing.JButton BTNresuelto;
    private javax.swing.JComboBox<String> JCBestado;
    private javax.swing.JComboBox<String> JCBprioridad;
    private javax.swing.JLabel LBLcliente;
    private javax.swing.JTextArea LBLcomentario;
    private javax.swing.JLabel LBLdescripcion;
    private javax.swing.JLabel LBLfecha_creacion;
    private javax.swing.JLabel LBLid_ticket;
    private javax.swing.JLabel LBLtecnico;
    private javax.swing.JLabel LBLtitulo;
    private javax.swing.JTextArea TAcomentario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
