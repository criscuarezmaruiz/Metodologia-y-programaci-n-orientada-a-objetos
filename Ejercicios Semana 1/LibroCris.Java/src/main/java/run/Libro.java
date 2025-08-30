package run;

public class Libro {
    // Atributos
    private String titulo;
    private String autor;
    private int numPaginas;

    // Constructor
    public Libro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Método que devuelve una descripción
    public String getDescripcion() {
        return "Título: " + titulo + ", Autor: " + autor + ", Páginas: " + numPaginas;
    }
}
