package repository.dao;

import entities.Empleado;
import jakarta.persistence.EntityManager;
import repository.IEmpleados;

import java.util.List;

public class Empleadodao implements IEmpleados {
    private final EntityManager em;

    public Empleadodao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        em.getTransaction().begin();
        if (empleado.getId() == null) {
            em.persist(empleado);
        } else {
            empleado = em.merge(empleado);
        }
        em.getTransaction().commit();
        return empleado;
    }

    @Override
    public List<Empleado> listar() {
        return em.createQuery("FROM Empleado", Empleado.class).getResultList();
    }
}
