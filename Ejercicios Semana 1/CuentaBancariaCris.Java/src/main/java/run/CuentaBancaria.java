package run;

public class CuentaBancaria {
    // Atributos
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor a 0.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("No es posible retirar esa cantidad. Saldo insuficiente o cantidad inválida.");
        }
    }

    // Método para consultar saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para mostrar información de la cuenta
    public String getDescripcion() {
        return "Titular: " + titular + ", Saldo actual: " + saldo;
    }
}
