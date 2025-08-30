package run;

public class Persona {
    // atributos nombre y edad
    public String nombre;  // lo dejamos público para que se pueda asignar directamente desde Main
    public int edad;

    // método para mostrar los datos
    public String mostrarDatos() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
