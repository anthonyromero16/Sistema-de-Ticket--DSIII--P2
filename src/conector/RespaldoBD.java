/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RespaldoBD {



    public static void RespaldoBD() {
   String rutaMysqldump = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe";
        String usuario = "antohny";
        String contraseña = "anthony16";
        String baseDatos = "teknosa_db";

        String userHome = System.getProperty("user.home");
        String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String rutaDescargas = userHome + "\\Downloads\\respaldo_" + fecha + ".sql";

        try {
            ProcessBuilder pb = new ProcessBuilder(
                rutaMysqldump,
                "-u", usuario,
                "-p" + contraseña,
                baseDatos
            );

            pb.redirectOutput(new File(rutaDescargas));
            pb.redirectErrorStream(true);

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Respaldo exitoso en: " + rutaDescargas);
            } else {
                System.out.println("Error al generar respaldo. Código: " + exitCode);
            }

        } catch (Exception e) {
            System.err.println("Excepción al respaldar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



