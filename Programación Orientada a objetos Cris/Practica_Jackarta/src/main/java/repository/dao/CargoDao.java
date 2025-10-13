package repository.dao;

import entities.Cargo;
import jakarta.persistence.EntityManager;
import repository.ICargo;

import java.util.List;

public class CargoDao implements ICargo {
    private final EntityManager em;

    public CargoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cargo guardar(Cargo cargo) {
        em.getTransaction().begin();
        if (cargo.getId() == null) {
            em.persist(cargo);
        } else {
            cargo = em.merge(cargo);
        }
        em.getTransaction().commit();
        return cargo;
    }

    @Override
    public List<Cargo> listar() {
        return em.createQuery("FROM Cargo", Cargo.class).getResultList();
    }
}
