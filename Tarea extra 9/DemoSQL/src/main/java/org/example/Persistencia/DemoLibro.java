package org.example.Persistencia;

import org.example.Modelo.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemoLibro {
    public DemoLibro() {
    }
    public void InsertStatement(){
        String elTitulo="Arrancame la vida";
        String elAutor="Angeles Matreta";
        try{
            Statement stm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().createStatement();
            String sqlIncert="INSERT INTO libros(titulo,autor) VALUES('"+elTitulo+"','"+elAutor+"')";
            int rowCount=stm.executeUpdate(sqlIncert);
            System.out.println("Se insertaron "+rowCount+" registros");
        }catch (SQLException es){
            System.out.println("Error al conectar"+es.getMessage());
        }
    }
    public void InsertPreparedStatetment(){
        String elTitulo="El principito";
        String elAutor="No me acuerdo";
        String sqlInsert="INSERT INTO libros(titulo,autor) VALUES(?, ?)";
        try{
            PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,elTitulo);
            pstm.setString(2,elAutor);
            int rowCount=pstm.executeUpdate();
            System.out.println("Se insertaron "+rowCount+" registros");
        }catch (SQLException se){
            System.out.println("Error Prepared statetment "+se.getMessage());
        }
    }
    public boolean InsertarLibro(Libro libro){
        String sqlInsert="INSERT INTO libros(titulo,autor) VALUES(?, ?)";
        int rowCount=0;
        try{
            PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,libro.getTitulo());
            pstm.setString(2,libro.getTitulo());
            rowCount=pstm.executeUpdate();
        }catch (SQLException se){
            System.out.println("Error Prepared statetment "+se.getMessage());
        }
        return rowCount>0;
    }
    public Libro buscarLibroId(int id){
        String sql = "SELECT * FROM libros WHERE id = ?;";
        Libro libro=null;
        try{
            PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet res=pstm.executeQuery();
            if (res.next()){
                libro=new Libro(res.getInt(1), res.getString(2),res.getString(3));
            }
        }catch (SQLException se){
            System.out.println("Error Prepared statetment "+se.getMessage());
        }
        return libro;
    }
    public ArrayList<Libro> ObtenerTodos(){
        String sql = "SELECT * FROM libros";
        ArrayList<Libro> resultado=new ArrayList<>();
        try {
            Statement stm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                resultado.add(new Libro(res.getInt(1), res.getString(2),res.getString(3)) );
            }
        }catch (SQLException SQE){
            System.out.println(SQE.getMessage());
        }
        return resultado;
    }
}
