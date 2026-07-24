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
                // Ejecutando en tu PC (Local / NetBeans)
                url = "jdbc:mysql://localhost:3306/nurse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
                user = "root";
                password = "";
            } else {
                // Ejecutando en Railway (Red Privada)
                String port = System.getenv("MYSQLPORT");
                String db = System.getenv("MYSQLDATABASE");
                user = System.getenv("MYSQLUSER");
                password = System.getenv("MYSQLPASSWORD");

                // CAMBIO AQUÍ: Cambiamos useSSL=true a useSSL=false y agregamos allowPublicKeyRetrieval=true
                url = "jdbc:mysql://" + host + ":" + port + "/" + db 
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            }

            con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ Conexión establecida correctamente a: " + host);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver no encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error SQL al conectar: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }
}
