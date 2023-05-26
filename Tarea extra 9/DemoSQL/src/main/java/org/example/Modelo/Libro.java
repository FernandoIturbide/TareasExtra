package org.example.Modelo;

public class Libro {
    private int ID;
    private String Titulo;
    private String Autor;

    public Libro() {
    }

    public Libro(int ID, String titulo, String autor) {
        this.ID = ID;
        Titulo = titulo;
        Autor = autor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ID=" + ID +
                ", Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                '}';
    }
}
