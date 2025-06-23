package sistema._de_ticket_dsiii_p2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class CorreoUtil {

    public static void enviarCorreo(String correoTecnico, String claveTecnico, String correoCliente, String asunto, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", correoTecnico);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoTecnico, claveTecnico);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(correoTecnico));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoCliente));
            msg.setSubject(asunto);
            msg.setText(mensaje);
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al enviar correo: " + e.getMessage());
        }
    }
}
