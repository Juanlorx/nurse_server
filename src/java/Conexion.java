import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 1. Obtener variables de Railway
            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String db   = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            // 2. Si no existen (por si pruebas en local), usar valores por defecto
            if (host == null) {
                host = "localhost";
                port = "3306";
                db   = "nurse"; // el nombre de tu BD local
                user = "root";
                pass = "";
            }

            // 3. Armar la URL dinámica
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&serverTimezone=UTC";
            
            cn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}