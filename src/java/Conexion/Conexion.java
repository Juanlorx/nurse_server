package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConexion() {

        Connection con = null;

        try {

            Class.forName(DRIVER);

            String host = System.getenv("MYSQLHOST");

            String url;
            String user;
            String password;

            if (host == null || host.isEmpty()) {
                // Ejecutando en tu PC (NetBeans)
                url = "jdbc:mysql://localhost:3307/nurse?useSSL=false&serverTimezone=UTC";
                user = "root";
                password = "";
            } else {
                // Ejecutando en Railway
                String port = System.getenv("MYSQLPORT");
                String db = System.getenv("MYSQLDATABASE");
                user = System.getenv("MYSQLUSER");
                password = System.getenv("MYSQLPASSWORD");

                url = "jdbc:mysql://" + host + ":" + port + "/" + db
                        + "?useSSL=true&serverTimezone=UTC";
            }

            con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ Conexión establecida correctamente.");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }

        return con;
    }
}
