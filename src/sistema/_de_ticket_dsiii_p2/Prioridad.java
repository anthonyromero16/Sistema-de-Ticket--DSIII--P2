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
private String ticketSeleccionadoId = null;
private String tituloVentana;

public Prioridad(String idTecnico, String tituloVentana) {
     initComponents();
 
    this.idTecnico = idTecnico;
    this.tituloVentana = tituloVentana; // ← ESTA LÍNEA FALTABA
    setTitle(tituloVentana);
    

    if ("Tickets Asignados".equalsIgnoreCase(tituloVentana)) {  cargarTicketsAsignadosSinPrioridad(this.idTecnico); } 
    if ("Tickets de Alta Prioridad".equalsIgnoreCase(tituloVentana)) { cargarTicketsAsignadosAltaPrioridad(this.idTecnico); }
    if ("Tickets de Prioridad Media".equalsIgnoreCase(tituloVentana)) { cargarTicketsAsignadosMediaPrioridad(this.idTecnico); }   
    if ("Tickets de Prioridad Baja".equalsIgnoreCase(tituloVentana)) {  cargarTicketsAsignadosBajaPrioridad(this.idTecnico);   }  
    if ("Tickets en General".equalsIgnoreCase(tituloVentana)) { cargarTicketsGeneral(this.idTecnico);  }
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
    
      ////////////////////////////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////////////////////////////
       
       void buscarTicketsAsignadosSinPrioridad() {
    String entrada = TBid_ticket.getText().trim();

    if (entrada.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de ticket o cédula de cliente.");
        return;
    }

    String sql = "";
    boolean buscarPorID = entrada.matches("\\d+"); // Si es solo números, se asume que es ID de ticket

    if (buscarPorID) {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'ninguna' AND t.id_ticket = ?";
    } else {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'ninguna' AND t.id_cliente = ?";
    }

    try (PreparedStatement pst = con.getConnection().prepareStatement(sql)) {
        pst.setString(1, idTecnico); // Usa el id del técnico actual
        pst.setString(2, entrada);   // ID del ticket o cédula del cliente

        ResultSet rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
boolean hayResultados = false;
        while (rs.next()) {
             hayResultados = true;
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }
if (!hayResultados) {
    JOptionPane.showMessageDialog(null, "No se encontraron tickets con ese dato.");
}
        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar tickets de sin prioridad: " + e.getMessage());
    }
}

       
       void buscarTicketsAsignadosAltaPrioridad() {
    String entrada = TBid_ticket.getText().trim();

    if (entrada.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de ticket o cédula de cliente.");
        return;
    }

    String sql = "";
    boolean buscarPorID = entrada.matches("\\d+"); // Si es solo números, se asume que es ID de ticket

    if (buscarPorID) {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'alta' AND t.id_ticket = ?";
    } else {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'alta' AND t.id_cliente = ?";
    }

    try (PreparedStatement pst = con.getConnection().prepareStatement(sql)) {
        pst.setString(1, idTecnico); // Usa el id del técnico actual
        pst.setString(2, entrada);   // ID del ticket o cédula del cliente

        ResultSet rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
boolean hayResultados = false;
        while (rs.next()) {
             hayResultados = true;
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }
if (!hayResultados) {
    JOptionPane.showMessageDialog(null, "No se encontraron tickets de prioridad alta con ese dato.");
}
        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar tickets de baja prioridad: " + e.getMessage());
    }
}

       
       void buscarTicketsAsignadosMediaPrioridad() {
    String entrada = TBid_ticket.getText().trim();

    if (entrada.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de ticket o cédula de cliente.");
        return;
    }

    String sql = "";
    boolean buscarPorID = entrada.matches("\\d+"); // Si es solo números, se asume que es ID de ticket

    if (buscarPorID) {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'media' AND t.id_ticket = ?";
    } else {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'media' AND t.id_cliente = ?";
    }

    try (PreparedStatement pst = con.getConnection().prepareStatement(sql)) {
        pst.setString(1, idTecnico); // Usa el id del técnico actual
        pst.setString(2, entrada);   // ID del ticket o cédula del cliente

        ResultSet rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
boolean hayResultados = false;
        while (rs.next()) {
             hayResultados = true;
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }
if (!hayResultados) {
    JOptionPane.showMessageDialog(null, "No se encontraron tickets de prioridad media con ese dato.");
}
        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar tickets de media prioridad: " + e.getMessage());
    }
}

       
    void buscarTicketsAsignadosBajaPrioridad() {
    String entrada = TBid_ticket.getText().trim();

    if (entrada.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de ticket o cédula de cliente.");
        return;
    }

    String sql = "";
    boolean buscarPorID = entrada.matches("\\d+"); // Si es solo números, se asume que es ID de ticket

    if (buscarPorID) {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'baja' AND t.id_ticket = ?";
    } else {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN asignaciones a ON t.id_ticket = a.id_ticket " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE a.id_tecnico = ? AND t.prioridad = 'baja' AND t.id_cliente = ?";
    }

    try (PreparedStatement pst = con.getConnection().prepareStatement(sql)) {
        pst.setString(1, idTecnico); // Usa el id del técnico actual
        pst.setString(2, entrada);   // ID del ticket o cédula del cliente

        ResultSet rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
boolean hayResultados = false;
        while (rs.next()) {
             hayResultados = true;
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }
if (!hayResultados) {
    JOptionPane.showMessageDialog(null, "No se encontraron tickets de prioridad baja con ese dato.");
}
        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar tickets de baja prioridad: " + e.getMessage());
    }
} 
     
    void buscarTicketsGeneral() {
    String entrada = TBid_ticket.getText().trim();

    if (entrada.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese un ID de ticket o cédula de cliente.");
        return;
    }

    String sql = "";
    boolean buscarPorID = entrada.matches("\\d+"); // si solo contiene números
  conet = con.getConnection();
    if (buscarPorID) {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE t.id_ticket = ?";
    } else {
        sql = "SELECT t.id_ticket, t.titulo, t.estado, t.fecha_creacion, u.nombre AS cliente " +
              "FROM tickets t " +
              "JOIN usuarios u ON t.id_cliente = u.id_usuario " +
              "WHERE t.id_cliente = ?";
    }

    try (PreparedStatement pst = conet.prepareStatement(sql)) {
        pst.setString(1, entrada);

        ResultSet rs = pst.executeQuery();

        String[] columnas = {"ID", "Título", "Estado", "Fecha", "Cliente"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
boolean hayResultados = false;
        while (rs.next()) {
             hayResultados = true;
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("id_ticket");
            fila[1] = rs.getString("titulo");
            fila[2] = rs.getString("estado");
            fila[3] = rs.getTimestamp("fecha_creacion");
            fila[4] = rs.getString("cliente");
            modelo.addRow(fila);
        }
if (!hayResultados) {
    JOptionPane.showMessageDialog(null, "No se encontraron tickets  con ese dato.");
}
        TBLprioridad.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el ticket: " + e.getMessage());
    }
}

      
     ////////////////////////////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////////////////////////////
       //////////////////////////////////////////////////////////////////////////////////////////////
    
    

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
        BTNbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNbuscarActionPerformed(evt);
            }
        });

        TBid_ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBid_ticketActionPerformed(evt);
            }
        });

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
        TBLprioridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLprioridadMouseClicked(evt);
            }
        });
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
        BTNverdetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNverdetallesActionPerformed(evt);
            }
        });

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

        setBounds(0, 0, 466, 488);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNbuscarActionPerformed
     
         if ("Tickets Asignados".equalsIgnoreCase(tituloVentana)) {
       buscarTicketsAsignadosSinPrioridad();
    }
    
     if ("Tickets de Alta Prioridad".equalsIgnoreCase(tituloVentana)) {
   buscarTicketsAsignadosAltaPrioridad();
    }
    
       if ("Tickets de Prioridad Media".equalsIgnoreCase(tituloVentana)) {
     buscarTicketsAsignadosMediaPrioridad();
      }
     
           if ("Tickets de Prioridad Baja".equalsIgnoreCase(tituloVentana)) {
     buscarTicketsAsignadosBajaPrioridad();
      }
          if ("Tickets en General".equalsIgnoreCase(tituloVentana)) {
        buscarTicketsGeneral();
          }
          
          
          
          
          
        
    }//GEN-LAST:event_BTNbuscarActionPerformed

    private void TBid_ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBid_ticketActionPerformed
      if (TBid_ticket.getText().trim().isEmpty()) {
       cargarTicketsGeneral(this.idTecnico); 
    }
    }//GEN-LAST:event_TBid_ticketActionPerformed

    private void TBLprioridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLprioridadMouseClicked
        int fila = TBLprioridad.getSelectedRow();
    if (fila != -1) {
        ticketSeleccionadoId = TBLprioridad.getValueAt(fila, 0).toString(); // columna 0 es id_ticket
    }
    }//GEN-LAST:event_TBLprioridadMouseClicked

    private void BTNverdetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNverdetallesActionPerformed
       if (ticketSeleccionadoId != null) {
        Detalles_ticket dialog = new Detalles_ticket(null, true, ticketSeleccionadoId); // constructor con parámetro
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un ticket de la tabla.");
    }
    }//GEN-LAST:event_BTNverdetallesActionPerformed


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
