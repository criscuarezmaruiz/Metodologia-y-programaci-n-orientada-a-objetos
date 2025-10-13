package repository.dao;

import entities.Carrera;
import jakarta.persistence.EntityManager;
import repository.ICarrera;

import java.util.List;

public class CarreraDao implements ICarrera {

    private final EntityManager em;

    public CarreraDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carrera guardar(Carrera carrera) {
        em.getTransaction().begin();
        if (carrera.getId() == null) {
            em.persist(carrera);
        } else {
            carrera = em.merge(carrera);
        }
        em.getTransaction().commit();
        return carrera;
    }

    public Carrera buscarPorId(Long id) {
        return em.find(Carrera.class, id);
    }

    public List<Carrera> buscarTodos() {
        return em.createQuery("FROM Carrera", Carrera.class).getResultList();
    }

    public void eliminar(Carrera carrera) {
        em.getTransaction().begin();
        if (!em.contains(carrera)) {
            carrera = em.merge(carrera);
        }
        em.remove(carrera);
        em.getTransaction().commit();
    }

    @Override
    public List<Carrera> listar() {
        return em.createQuery("FROM Carrera", Carrera.class).getResultList();
    }
}
