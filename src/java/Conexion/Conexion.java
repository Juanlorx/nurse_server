   package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/nurse?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection getConexion() {

        Connection con = null;

        try {

            Class.forName(DRIVER);

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("✅ Conexión establecida correctamente.");

        } catch (ClassNotFoundException e) {

            System.out.println("❌ Driver no encontrado: "
                    + e.getMessage());

        } catch (SQLException e) {

            System.out.println("❌ Error SQL: "
                    + e.getMessage());
        }

        return con;
    }
}