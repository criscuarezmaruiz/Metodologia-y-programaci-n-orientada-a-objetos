package run;

import config.JPAUtil;
import entities.Carrera;
import entities.Estudiante;
import jakarta.persistence.EntityManager;
import repository.dao.CarreraDao;
import repository.dao.EstudianteDao;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            CarreraDao carreraDao = new CarreraDao(em);
            EstudianteDao estudianteDao = new EstudianteDao(em);

          
            Carrera carrera = new Carrera();
            carrera.setNombre("Ingeniería en Sistemas XYZ");
            carrera.setPrecio(250);
            carrera = carreraDao.guardar(carrera);
            System.out.println("Carrera guardada: " + carrera);


            Estudiante estudiante = new Estudiante();
            estudiante.setCif("CIF24012173");
            estudiante.setNombre("Cristofer");
            estudiante.setApellido("Cuarezma");
            estudiante.setCarrera(carrera);
            estudiante = estudianteDao.guardar(estudiante);
            System.out.println("\nEstudiante guardado: " + estudiante);

            Scanner scanner = new Scanner(System.in);

            mostrarEstudiantes(estudianteDao);


            System.out.print("\nIngrese el ID del estudiante que desea eliminar: ");
            Long idEstudianteEliminar = scanner.nextLong();
            Estudiante estudianteAEliminar = estudianteDao.buscarPorId(idEstudianteEliminar);
            if (estudianteAEliminar != null) {
                System.out.println("Estudiante encontrado: " + estudianteAEliminar.getNombre() + " " +
                        estudianteAEliminar.getApellido() + " - Carrera: " + estudianteAEliminar.getCarrera().getNombre());
                estudianteDao.eliminar(estudianteAEliminar);
                System.out.println("Estudiante eliminado: " + estudianteAEliminar.getNombre());
            } else {
                System.out.println("No existe un estudiante con ese ID.");
            }


            mostrarEstudiantes(estudianteDao);


            mostrarCarreras(carreraDao);


            System.out.print("\nIngrese el ID de la carrera a eliminar: ");
            Long idCarreraEliminar = scanner.nextLong();
            Carrera carreraAEliminar = carreraDao.buscarPorId(idCarreraEliminar);
            if (carreraAEliminar != null) {
                carreraDao.eliminar(carreraAEliminar);
                System.out.println("Carrera eliminada: " + carreraAEliminar.getNombre());
            } else {
                System.out.println("No existe una carrera con ese ID.");
            }


            mostrarCarreras(carreraDao);

            scanner.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }

    private static void mostrarEstudiantes(EstudianteDao estudianteDao) {
        List<Estudiante> estudiantes = estudianteDao.listar();
        System.out.println("\nListado de Estudiantes:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getId() + " - " + e.getNombre() + " " + e.getApellido() +
                    " | Carrera: " + (e.getCarrera() != null ? e.getCarrera().getNombre() : "No asignada"));
        }
    }

    private static void mostrarCarreras(CarreraDao carreraDao) {
        List<Carrera> carreras = carreraDao.listar();
        System.out.println("\nListado de Carreras:");
        for (Carrera c : carreras) {
            System.out.println(c.getId() + " - " + c.getNombre());
        }
    }
}
