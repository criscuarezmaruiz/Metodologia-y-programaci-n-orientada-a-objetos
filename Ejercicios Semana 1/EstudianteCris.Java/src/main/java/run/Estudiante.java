package run;

public class Estudiante {
    // Atributos
    private String nombre;
    private String matricula;
    private double promedio;

    // Constructor
    public Estudiante(String nombre, String matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    // Método que indica si aprobó
    public boolean aprobo() {
        return promedio >= 70;
    }

    // Método para mostrar información
    public String getDescripcion() {
        return "Nombre: " + nombre + ", Matrícula: " + matricula + ", Promedio: " + promedio;
    }
}
