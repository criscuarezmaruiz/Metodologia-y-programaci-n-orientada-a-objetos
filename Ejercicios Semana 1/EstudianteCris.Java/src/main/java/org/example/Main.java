package org.example;

import run.Estudiante; // Importamos la clase Estudiante desde el paquete run

public class Main {
    public static void main(String[] args) {
        // Crear un estudiante de ejemplo
        Estudiante estudiante1 = new Estudiante("Cristofer Cuarezma", "2401-0935", 95);

        // Mostrar la información del estudiante
        System.out.println(estudiante1.getDescripcion());

        // Verificar si aprobó
        if (estudiante1.aprobo()) {
            System.out.println("El estudiante aprobó ✅");
        } else {
            System.out.println("El estudiante reprobó ❌");
        }
    }
}
