package com.dataBaseH2Prueba.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mt on 04/06/17.
 */
public class ConexionDB {
    private static String URL = "jdbc:h2:tcp://localhost/~/prueba";



    private static void registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConexion() {
        registrarDriver();
        Connection con = null;

        try {
            con = DriverManager.getConnection(URL, "sa", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }


}
