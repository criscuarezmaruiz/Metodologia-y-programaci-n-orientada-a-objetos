package org.example;

import run.Libro; // Importamos la clase Libro desde el paquete run

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Libro
        Libro libro1 = new Libro("Azul", "Rubén Darío", 208);

        // Mostrar la descripción
        System.out.println(libro1.getDescripcion());
    }
}
