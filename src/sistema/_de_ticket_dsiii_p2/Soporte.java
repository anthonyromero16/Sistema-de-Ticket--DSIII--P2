/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema._de_ticket_dsiii_p2;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author antho
 */

public class Soporte extends javax.swing.JFrame {
private String idTecnico;

    /**
     * Creates new form Soporte
     */
 
        public Soporte(String idTecnico) {
            initComponents();
            this.idTecnico = idTecnico;        
            Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets en General");
            verventanaticketsasignados.setTitle("Tickets en General"); // Aquí modificas el título
            escritorio.add(verventanaticketsasignados);
            verventanaticketsasignados.setVisible(true);        
            setTitle("Panel Técnico - " + idTecnico); // opcional
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        JMIticketsasignados = new javax.swing.JMenuItem();
        JMIprioridadalta = new javax.swing.JMenuItem();
        JMIprioridadmedia = new javax.swing.JMenuItem();
        JMIprioridadbaja = new javax.swing.JMenuItem();
        JMItodos = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Tickets - TEKNOSIA");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jMenuBar1.setAlignmentY(10.0F);

        jMenu4.setText("Inicio");

        jMenuItem1.setText("Cerrar sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Mis tickets");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        JMIticketsasignados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMIticketsasignados.setText("Ver tickets asignados");
        JMIticketsasignados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIticketsasignadosActionPerformed(evt);
            }
        });
        jMenu5.add(JMIticketsasignados);

        JMIprioridadalta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMIprioridadalta.setText("Prioridad alta ");
        JMIprioridadalta.setToolTipText("");
        JMIprioridadalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIprioridadaltaActionPerformed(evt);
            }
        });
        jMenu5.add(JMIprioridadalta);

        JMIprioridadmedia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMIprioridadmedia.setText("Prioridad media");
        JMIprioridadmedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIprioridadmediaActionPerformed(evt);
            }
        });
        jMenu5.add(JMIprioridadmedia);

        JMIprioridadbaja.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMIprioridadbaja.setText("Prioridad baja");
        JMIprioridadbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIprioridadbajaActionPerformed(evt);
            }
        });
        jMenu5.add(JMIprioridadbaja);

        JMItodos.setText("Todos los tickets");
        JMItodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMItodosActionPerformed(evt);
            }
        });
        jMenu5.add(JMItodos);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ayuda");

        jMenuItem4.setText("Manual de uso");
        jMenu6.add(jMenuItem4);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
      
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void JMIticketsasignadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIticketsasignadosActionPerformed
        Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets Asignados");
        verventanaticketsasignados.setTitle("Tickets Asignados"); // Aquí modificas el título
        escritorio.add(verventanaticketsasignados);
        verventanaticketsasignados.setVisible(true);
    }//GEN-LAST:event_JMIticketsasignadosActionPerformed

    private void JMIprioridadaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIprioridadaltaActionPerformed
        Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets de Alta Prioridad");
        verventanaticketsasignados.setTitle("Tickets de Alta Prioridad"); // Aquí modificas el título
        escritorio.add(verventanaticketsasignados);
        verventanaticketsasignados.setVisible(true);
    }//GEN-LAST:event_JMIprioridadaltaActionPerformed

    private void JMIprioridadmediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIprioridadmediaActionPerformed
        Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets de Prioridad Media");
        verventanaticketsasignados.setTitle("Tickets de Prioridad Media"); // Aquí modificas el título
        escritorio.add(verventanaticketsasignados);
        verventanaticketsasignados.setVisible(true);
    }//GEN-LAST:event_JMIprioridadmediaActionPerformed

    private void JMIprioridadbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIprioridadbajaActionPerformed
        Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets de Prioridad Baja");
        verventanaticketsasignados.setTitle("Tickets de Prioridad Baja"); // Aquí modificas el título
        escritorio.add(verventanaticketsasignados);
        verventanaticketsasignados.setVisible(true);
    }//GEN-LAST:event_JMIprioridadbajaActionPerformed

    private void JMItodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMItodosActionPerformed
        Prioridad verventanaticketsasignados = new Prioridad(idTecnico, "Tickets en General");
        verventanaticketsasignados.setTitle("Tickets en General"); // Aquí modificas el título
        escritorio.add(verventanaticketsasignados);
        verventanaticketsasignados.setVisible(true);        
    }//GEN-LAST:event_JMItodosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(Soporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    // Prueba con una cédula válida como idTecnico (debes tenerlo en tu BD)
    String idTecnico = "123456789"; // ← Usa aquí una cédula existente en tu tabla usuarios

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Soporte(idTecnico).setVisible(true);
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIprioridadalta;
    private javax.swing.JMenuItem JMIprioridadbaja;
    private javax.swing.JMenuItem JMIprioridadmedia;
    private javax.swing.JMenuItem JMIticketsasignados;
    private javax.swing.JMenuItem JMItodos;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
