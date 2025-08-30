package org.example;

import run.Coche;  // Importa la clase desde el paquete "run"

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Coche
        Coche miCoche = new Coche("Toyota", "Corolla", 2022);

        // Mostrar la información
        miCoche.mostrarInfo();
    }
}

