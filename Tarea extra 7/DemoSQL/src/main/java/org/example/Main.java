package org.example;

import org.example.Modelo.Libro;
import org.example.Persistencia.DemoLibro;
import org.example.Persistencia.LibroDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LibroDAO lDAO= new LibroDAO();
        Libro libro=new Libro(1,"El perfume","Patrick Suskind");
        try {
            /*Libro res=(Libro) lDAO.buscarPorID("1");
            System.out.println(res);
            System.out.println("___________________");
            for (Object lib:lDAO.obtenerTodo()) {
                System.out.println((Libro)lib);
            }*/
            if (lDAO.insertar(libro)){
                System.out.println("Se logró");
            }else {
                System.out.println("No se logró");
            }
        }catch (SQLException es){
            System.out.println("Error");
            System.out.println(es.getMessage());
        }

    }
}