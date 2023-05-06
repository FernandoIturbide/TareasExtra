package org.example;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LecturaArchivo LA =new LecturaArchivo();
        try {
            LA.metodoUno("datos.txt");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}