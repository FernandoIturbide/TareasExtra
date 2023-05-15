package org.example;

import java.sql.*;

import org.sqlite.JDBC;
public class DemoSQLite {
    public static void main(String[] args) {
        String DB_URL = "jdbc:sqlite:LibrosDB.sqbpro";
        Connection conexion=null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion= DriverManager.getConnection(DB_URL);
            Statement stm=conexion.createStatement();
            ResultSet rs=stm.executeQuery("SELECT * FROM libros");
            while (rs.next()){
                System.out.println(rs.getString(1)+ " "+rs.getString(2));
            }
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
