package org.example.Modelo;

import org.example.Persistencia.LibroDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaLibro implements TableModel {
    public static final int COLUMNAS=3;
    private ArrayList<Libro> datos;
    private LibroDAO lDAO;

    public ModeloTablaLibro() {
        lDAO= new LibroDAO();
        datos=new ArrayList<>();
    }

    public ModeloTablaLibro(ArrayList<Libro> datos) {
        this.datos = datos;
        lDAO= new LibroDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Título";
            case 2:
                return "Autor";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Libro tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getID();
            case 1:
                return tmp.getTitulo();
            case 2:
                return tmp.getAutor();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).getID();
                break;
            case 1:
                datos.get(rowIndex).setTitulo((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setAutor((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void CargarDatos(){
        try {
            ArrayList<Libro> tirar=lDAO.obtenerTodo();
            System.out.println(tirar);
            datos=lDAO.obtenerTodo();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }

    }
}
