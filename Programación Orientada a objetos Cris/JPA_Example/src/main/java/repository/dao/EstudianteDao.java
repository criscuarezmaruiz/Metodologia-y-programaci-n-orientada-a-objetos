package repository.dao;

import entities.Estudiante;
import jakarta.persistence.EntityManager;
import repository.IEstudiante;

import java.util.List;

public class EstudianteDao implements IEstudiante {

    private final EntityManager em;

    public EstudianteDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        try {
            em.getTransaction().begin();
            if (estudiante.getId() == null) {
                em.persist(estudiante);
            } else {
                estudiante = em.merge(estudiante);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
        return estudiante;
    }

    public Estudiante buscarPorId(Long id) {
        return em.find(Estudiante.class, id);
    }

    public List<Estudiante> buscarTodos() {
        return em.createQuery("FROM Estudiante", Estudiante.class).getResultList();
    }

    public void eliminar(Estudiante estudiante) {
        try {
            em.getTransaction().begin();
            if (!em.contains(estudiante)) {
                estudiante = em.merge(estudiante);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Estudiante> listar() {
        return buscarTodos();
    }
}
