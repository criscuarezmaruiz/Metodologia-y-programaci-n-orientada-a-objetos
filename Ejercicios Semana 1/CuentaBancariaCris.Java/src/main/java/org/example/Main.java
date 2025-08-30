package org.example;

import run.CuentaBancaria; // Importamos la clase desde el paquete run

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta bancaria
        CuentaBancaria cuenta1 = new CuentaBancaria("Cristofer Cuarezma", 500.0);

        // Mostrar la información inicial
        System.out.println(cuenta1.getDescripcion());

        // Hacer operaciones
        cuenta1.depositar(200);
        cuenta1.retirar(100);
        cuenta1.retirar(700); // Intento fallido (saldo insuficiente)

        // Mostrar saldo final
        System.out.println("Saldo final: " + cuenta1.getSaldo());
    }
}
