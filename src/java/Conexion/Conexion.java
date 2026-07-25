package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {


    // Driver MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    // ==============================
    // CONEXIÓN MYSQL RAILWAY
    // USANDO VARIABLES DE ENTORNO
    // ==============================

    private static final String URL =
            "jdbc:mysql://"
            + System.getenv("DB_HOST")
            + ":"
            + System.getenv("DB_PORT")
            + "/"
            + System.getenv("DB_NAME")
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC";


    private static final String USER =
            System.getenv("DB_USER");


    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");



    public static Connection getConexion(){


        Connection cn = null;


        try{


            // Cargar driver MySQL

            Class.forName(DRIVER);



            // Crear conexión

            cn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );



            System.out.println("===============================");
            System.out.println(" CONEXIÓN EXITOSA MYSQL RAILWAY ");
            System.out.println("===============================");



        }catch(ClassNotFoundException e){


            System.out.println("ERROR: DRIVER MYSQL NO ENCONTRADO");

            e.printStackTrace();



        }catch(SQLException e){


            System.out.println("ERROR AL CONECTAR MYSQL RAILWAY");

            e.printStackTrace();



        }catch(Exception e){


            System.out.println("ERROR GENERAL DE CONEXIÓN");

            e.printStackTrace();


        }


        return cn;


    }


}