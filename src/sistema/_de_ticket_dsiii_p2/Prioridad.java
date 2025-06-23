/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sistema._de_ticket_dsiii_p2;
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
public class Prioridad extends javax.swing.JInternalFrame {
 Conexion con= new Conexion();
 Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
   
public String idTecnico;



public Prioridad(String idTecnico, String tituloVentana) {
    initComponents();
    this.idTecnico = idTecnico;
    setTitle(tituloVentana);
    

    if ("Tickets Asignados".equalsIgnoreCase(tituloVentana)) {
        cargarTicketsAsignadosSinPrioridad(this.idTecnico);
    }
    
     if ("Tickets de Alta Prioridad".equalsIgnoreCase(tituloVentana)) {
    cargarTicketsAsignadosAltaPrioridad(this.idTecnico);
    }
    
       if ("Tickets de Prioridad Media".equalsIgnoreCase(tituloVentana)) {
     cargarTicketsAsignadosMediaPrioridad(this.idTecnico);
      }
     
           if ("Tickets de Prioridad Baja".equalsIgnoreCase(tituloVentana)) {
     cargarTicketsAsignadosBajaPrioridad(this.idTecnico);
      }
     
             if ("Tickets en General".equalsIgnoreCase(tituloVentana)) {
     cargarTicketsGeneral(this.idTecnico);
      }
}



    public void cargarTicketsAsignadosSinPrioridad(String idTecnico) {
    conet = con.getConnection();

    String sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
                 "FROM tickets t " +
                 "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                 "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                 "WHERE a.id_tecnico = ? AND t.prioridad = 'ninguna'";

    try {
        PreparedStatement pst = conet.prepareStatement(sql);  // ← aquí usamos PreparedStatement
        pst.setString(1, idTecnico);  // ← pasamos el id del técnico

        rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        modelo = new DefaultTableModel(null, columnas);
        Object[] fila = new Object[5];

        while (rs.next()) {
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }

        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los tickets: " + e.getMessage());
    }
}

    
     public void cargarTicketsAsignadosAltaPrioridad(String idTecnico) {
    conet = con.getConnection();

    String sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
                 "FROM tickets t " +
                 "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                 "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                 "WHERE a.id_tecnico = ? AND t.prioridad = 'alta'";

    try {
        PreparedStatement pst = conet.prepareStatement(sql);  // ← aquí usamos PreparedStatement
        pst.setString(1, idTecnico);  // ← pasamos el id del técnico

        rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        modelo = new DefaultTableModel(null, columnas);
        Object[] fila = new Object[5];

        while (rs.next()) {
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }

        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los tickets: " + e.getMessage());
    }
}
    
     
     public void cargarTicketsAsignadosMediaPrioridad(String idTecnico) {
    conet = con.getConnection();

    String sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
                 "FROM tickets t " +
                 "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                 "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                 "WHERE a.id_tecnico = ? AND t.prioridad = 'media'";

    try {
        PreparedStatement pst = conet.prepareStatement(sql);  // ← aquí usamos PreparedStatement
        pst.setString(1, idTecnico);  // ← pasamos el id del técnico

        rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        modelo = new DefaultTableModel(null, columnas);
        Object[] fila = new Object[5];

        while (rs.next()) {
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }

        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los tickets: " + e.getMessage());
    }
}
    
      public void cargarTicketsAsignadosBajaPrioridad(String idTecnico) {
    conet = con.getConnection();

    String sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
                 "FROM tickets t " +
                 "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                 "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                 "WHERE a.id_tecnico = ? AND t.prioridad = 'baja'";

    try {
        PreparedStatement pst = conet.prepareStatement(sql);  // ← aquí usamos PreparedStatement
        pst.setString(1, idTecnico);  // ← pasamos el id del técnico

        rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        modelo = new DefaultTableModel(null, columnas);
        Object[] fila = new Object[5];

        while (rs.next()) {
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }

        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los tickets: " + e.getMessage());
    }
}
    
       public void cargarTicketsGeneral(String idTecnico) {
    conet = con.getConnection();

    String sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
                 "FROM tickets t " +
                 "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
                 "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
                 "WHERE a.id_tecnico = ? ";

    try {
        PreparedStatement pst = conet.prepareStatement(sql);  // ← aquí usamos PreparedStatement
        pst.setString(1, idTecnico);  // ← pasamos el id del técnico

        rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        modelo = new DefaultTableModel(null, columnas);
        Object[] fila = new Object[5];

        while (rs.next()) {
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }

        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los tickets: " + e.getMessage());
    }
}
    
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBLbuscarticket = new javax.swing.JLabel();
        BTNbuscar = new javax.swing.JButton();
        TBid_ticket = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLprioridad = new javax.swing.JTable();
        BTNverdetalles = new javax.swing.JButton();
        BTNresuelto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tickets");

        LBLbuscarticket.setText("Buscar ticket:");

        BTNbuscar.setText("Buscar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tickets"));

        TBLprioridad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TBLprioridad);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        BTNverdetalles.setText("Ver detalles");

        BTNresuelto.setText("Resuelto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBLbuscarticket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TBid_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTNbuscar)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(BTNverdetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNresuelto)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLbuscarticket)
                    .addComponent(BTNbuscar)
                    .addComponent(TBid_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNverdetalles)
                    .addComponent(BTNresuelto))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNbuscar;
    private javax.swing.JButton BTNresuelto;
    private javax.swing.JButton BTNverdetalles;
    private javax.swing.JLabel LBLbuscarticket;
    private javax.swing.JTable TBLprioridad;
    private javax.swing.JTextField TBid_ticket;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
