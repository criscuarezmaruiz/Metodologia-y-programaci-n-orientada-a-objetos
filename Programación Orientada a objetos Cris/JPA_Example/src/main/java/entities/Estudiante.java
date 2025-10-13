package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Estudiantes")
@Getter
@Setter
public class Estudiante {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cif", length = 30, nullable = false, unique = true)
    private String cif;

    @Column(name = "nombre_estudiante", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", carrera=" + (carrera != null ? carrera.getNombre() : "N/A") +
                '}';
    }
}
