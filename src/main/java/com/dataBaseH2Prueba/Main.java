package com.dataBaseH2Prueba;

import com.dataBaseH2Prueba.DB.BootstrapServices;
import com.dataBaseH2Prueba.DB.ConexionDB;

import java.sql.*;

/**
 * Created by mt on 03/06/17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        BootstrapServices.startDb();

        Connection conn = ConexionDB.getConexion();
        conn.close();

        if(conn.isClosed()){
            System.out.println("Cerrada con exito!");
        }

        crearTablas();
        selectTabla("ESTUDIANTE");


        BootstrapServices.stopDb();

    }

    /**
     * Metodo para recrear las tablas necesarios
     * @throws SQLException
     */
    public static void crearTablas() throws  SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS ESTUDIANTE\n" +
                "(\n" +
                "  MATRICULA INTEGER PRIMARY KEY NOT NULL,\n" +
                "  NOMBRE VARCHAR(100) NOT NULL,\n" +
                "  APELLIDO VARCHAR(100) NOT NULL,\n" +
                "  TELEFONO VARCHAR(25) NOT NULL,\n" +
                "  CARRERA VARCHAR(50) NOT NULL\n" +
                ");";
        Connection con = ConexionDB.getConexion();
        Statement statement = con.createStatement();
        statement.execute(sql);
        statement.close();
        con.close();
    }

    public static void selectTabla(String nombreTabla) throws  SQLException{
        String sql = "SELECT " + " MATRICULA,NOMBRE,APELLIDO,TELEFONO,CARRERA FROM " + nombreTabla + ";";
        Connection con = ConexionDB.getConexion();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){

            int matricula= rs.getInt("MATRICULA");
            String nombre=rs.getString("NOMBRE");
            String apellido=rs.getString("APELLIDO");
            String telefono=rs.getString("TELEFONO");
            String carrera=rs.getString("CARRERA");
            System.out.println(matricula + " "  + nombre + " " + apellido + " " + telefono + " " + carrera + " "  + "\n");
        }
        statement.close();
        con.close();
    }
}
