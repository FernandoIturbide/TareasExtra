package org.example;

import org.example.Controlador.ControladorTabla;
import org.example.Modelo.Libro;
import org.example.Persistencia.DemoLibro;
import org.example.Persistencia.LibroDAO;
import org.example.Vista.VentanaLibro;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        VentanaLibro ventanaLibro = new VentanaLibro("MVC y JDBC");
        ControladorTabla ConTabla=new ControladorTabla(ventanaLibro);
    }
}