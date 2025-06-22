/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
     Connection con;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection(
                    
                // como sabras aqui va la ruta de la BD pero como tu sabes mejor como es la vaina te pido porfa que lo coloque  o me dices no c
                //
                "jdbc:mysql://localhost:3306/Cafecalle4tadavid","root","16102000");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
            con = null;
        }
        return con;
    }
    
}
