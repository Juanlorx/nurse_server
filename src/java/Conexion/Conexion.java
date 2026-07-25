package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {


    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    private static final String HOST = System.getenv("MYSQLHOST");
    private static final String PORT = System.getenv("MYSQLPORT");
    private static final String DATABASE = System.getenv("MYSQLDATABASE");
    private static final String USER = System.getenv("MYSQLUSER");
    private static final String PASSWORD = System.getenv("MYSQLPASSWORD");



    public static Connection getConexion(){


        Connection con = null;


        try {


            Class.forName(DRIVER);


            String url =
                    "jdbc:mysql://"
                    + HOST
                    + ":"
                    + PORT
                    + "/"
                    + DATABASE
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC";


            System.out.println("MYSQL URL: " + url);
            System.out.println("MYSQL USER: " + USER);



            con = DriverManager.getConnection(
                    url,
                    USER,
                    PASSWORD
            );


            System.out.println("==============================");
            System.out.println(" MYSQL RAILWAY CONECTADO ");
            System.out.println("==============================");



        } catch(ClassNotFoundException e){


            System.out.println("NO ESTA EL DRIVER MYSQL");
            e.printStackTrace();



        } catch(SQLException e){


            System.out.println("ERROR MYSQL RAILWAY");
            e.printStackTrace();



        }


        return con;

    }


}