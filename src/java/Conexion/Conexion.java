package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConexion() {

        Connection con = null;

        try {

            // Cargar el driver
            Class.forName(DRIVER);

            // Verificar si está ejecutándose en Railway
            String host = System.getenv("MYSQLHOST");

            String url;
            String user;
            String password;

            if (host == null || host.trim().isEmpty()) {

                // ============================
                // CONEXIÓN LOCAL (NetBeans/XAMPP)
                // ============================
                url = "jdbc:mysql://localhost:3306/nurse"
                        + "?useSSL=false"
                        + "&allowPublicKeyRetrieval=true"
                        + "&serverTimezone=UTC";

                user = "root";
                password = "";

                System.out.println("========================================");
                System.out.println("MODO LOCAL");
                System.out.println("URL: " + url);
                System.out.println("Usuario: " + user);
                System.out.println("========================================");

            } else {

                // ============================
                // CONEXIÓN RAILWAY
                // ============================
                String port = System.getenv("MYSQLPORT");
                String database = System.getenv("MYSQLDATABASE");
                user = System.getenv("MYSQLUSER");
                password = System.getenv("MYSQLPASSWORD");

                System.out.println("========================================");
                System.out.println("MODO RAILWAY");
                System.out.println("HOST: " + host);
                System.out.println("PORT: " + port);
                System.out.println("DATABASE: " + database);
                System.out.println("USER: " + user);
                System.out.println("========================================");

                url = "jdbc:mysql://" + host + ":" + port + "/" + database
                        + "?useSSL=false"
                        + "&allowPublicKeyRetrieval=true"
                        + "&serverTimezone=UTC";

                System.out.println("URL: " + url);
            }

            // Intentar conectar
            con = DriverManager.getConnection(url, user, password);

            System.out.println("========================================");
            System.out.println("✅ CONEXIÓN EXITOSA A MYSQL");
            System.out.println("========================================");

        } catch (ClassNotFoundException e) {

            System.out.println("========================================");
            System.out.println("❌ DRIVER MYSQL NO ENCONTRADO");
            e.printStackTrace();
            System.out.println("========================================");

        } catch (SQLException e) {

            System.out.println("========================================");
            System.out.println("❌ ERROR AL CONECTAR CON MYSQL");
            e.printStackTrace();
            System.out.println("========================================");

        } catch (Exception e) {

            System.out.println("========================================");
            System.out.println("❌ ERROR GENERAL");
            e.printStackTrace();
            System.out.println("========================================");

        }

        return con;
    }
}