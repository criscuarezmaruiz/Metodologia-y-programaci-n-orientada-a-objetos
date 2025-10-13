package repository;


import entities.Estudiante;

import java.util.List;

public interface IEstudiante {
    public Estudiante guardar(Estudiante estudiante);
    public List<Estudiante> listar();
}

