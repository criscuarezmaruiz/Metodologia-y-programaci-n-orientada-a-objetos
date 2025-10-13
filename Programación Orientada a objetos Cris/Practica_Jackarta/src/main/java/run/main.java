package run;

import config.JPAUtil;
import entities.Cargo;
import entities.Empleado;
import jakarta.persistence.EntityManager;
import repository.dao.CargoDao;
import repository.dao.Empleadodao;

import java.util.List;

public class main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            CargoDao cargoDao = new CargoDao(em);
            Empleadodao empleadoDao = new Empleadodao(em);

            Cargo cargo = new Cargo();
            cargo.setNombre("Gerente General");
            cargo.setSalario(Float.parseFloat("7000"));
            cargo = cargoDao.guardar(cargo);

            System.out.println("Cargo guardado: " + cargo.getNombre());
            System.out.println("Salario guardado: " + cargo.getSalario());

            Empleado empleado = new Empleado();
            empleado.setCif("77167125");
            empleado.setNombre("Wilmer");
            empleado.setApellido("Ruiz");
            empleado.setCargo(cargo);
            empleadoDao.guardar(empleado);

            System.out.println("Empleado guardado: " + empleado.getNombre() + " " + empleado.getApellido()
                    + " | Cargo: " + empleado.getCargo().getNombre());

            mostrarEmpleados(empleadoDao);
            mostrarCargos(cargoDao);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }

    private static void mostrarEmpleados(Empleadodao empleadoDao) {
        List<Empleado> empleados = empleadoDao.listar();
        System.out.println("\nListado de Empleados:");
        for (Empleado e : empleados) {
            System.out.println(e.getId() + " - " + e.getNombre() + " " + e.getApellido()
                    + " | Cargo: " + (e.getCargo() != null ? e.getCargo().getNombre() : "No asignado"));
        }
    }

    private static void mostrarCargos(CargoDao cargoDao) {
        List<Cargo> cargos = cargoDao.listar();
        System.out.println("\nListado de Cargos:");
        for (Cargo c : cargos) {
            System.out.println(c.getId() + " - " + c.getNombre() + " | Salario: " + c.getSalario());
        }
    }
}
