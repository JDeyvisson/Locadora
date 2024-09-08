package br.com.locadora.dao;

import br.com.locadora.model.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadora");

    public void salvar(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void atualizar(Reserva reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(reserva);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Reserva buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Reserva reserva = em.find(Reserva.class, id);
            if (reserva != null) {
                em.remove(reserva);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Reserva> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva r", Reserva.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
