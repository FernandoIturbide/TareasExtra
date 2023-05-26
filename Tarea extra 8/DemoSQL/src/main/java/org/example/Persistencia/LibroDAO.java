package org.example.Persistencia;

import org.example.Modelo.Libro;
import org.example.Persistencia.InterfazDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO implements InterfazDAO {
    public LibroDAO() {
    }

    @Override
    public boolean insertar(Object o) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?);";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sql);
        pstm.setString(1,((Libro)o).getTitulo());
        pstm.setString(2,((Libro)o).getAutor());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean update(Object o) throws SQLException {
        String sqlUpdate = "UPDATE libros SET titulo=?, autor=? WHERE id=?;";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Libro)o).getTitulo());
        pstm.setString(2,((Libro)o).getAutor());
        pstm.setInt(3,((Libro)o).getID());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id=?;";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount=pstm.executeUpdate();

        return rowCount>0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM libros";
        ArrayList<Libro> resultado=new ArrayList<>();

            Statement stm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while (res.next()){
                resultado.add(new Libro(res.getInt(1), res.getString(2),res.getString(3)) );
            }

        return resultado;
    }

    @Override
    public Object buscarPorID(String id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id = ?;";
        Libro libro=null;

            PreparedStatement pstm=ConexionSingleton.getInstance("LibrosDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(id));
            ResultSet res=pstm.executeQuery();
            if (res.next()){
                libro=new Libro(res.getInt(1), res.getString(2),res.getString(3));
                return libro;
            }
        return null;

    }
}
