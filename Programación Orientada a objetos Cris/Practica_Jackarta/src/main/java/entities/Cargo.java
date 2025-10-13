package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cargos")
@Getter
@Setter

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cargo", length = 100, nullable = false)
    private String nombre;

    @Column(name = "salario_cargo", nullable = false)
    private float salario;


    @Override
    public String toString() {
        return "Datos del Cargo" + '\n' +
                "id=" + id +
                "| nombre: " + nombre + '\n' +
                "| salario: " + salario + '\n' +
                "============================================";
    }
}
