package repository;

import entities.Empleado;

import java.util.List;

public interface IEmpleados {
    Empleado guardar(Empleado empleado);
    List<Empleado> listar();
}
