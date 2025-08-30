package org.example;

import run.Persona; // Importamos la clase Persona desde el paquete run

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Persona
        Persona persona = new Persona();

        // Asignar valores a los atributos
        persona.nombre = "Gabriela López";
        persona.edad = 18;

        // Mostrar los datos de la persona
        System.out.println(persona.mostrarDatos());
    }
}
