package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/nurse?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Cambia si tu MySQL tiene contraseña

    public Connection getConexion() {

        Connection con = null;

        try {
            Class.forName(DRIVER);

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Conexión establecida correctamente.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}