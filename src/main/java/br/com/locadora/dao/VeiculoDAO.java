package br.com.locadora.dao;

import br.com.locadora.model.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class VeiculoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadora");

    public void save(Veiculo veiculo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        em.close();
    }

    public Veiculo find(String placa) {
        EntityManager em = emf.createEntityManager();
        Veiculo veiculo = em.find(Veiculo.class, placa);
        em.close();
        return veiculo;
    }

    public List<Veiculo> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Veiculo> veiculos = em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
        em.close();
        return veiculos;
    }

    public Veiculo findByPlaca(String placa) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Veiculo v WHERE v.placa = :placa", Veiculo.class)
                    .setParameter("placa", placa)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } finally {
            em.close();
        }
    }

    public void remover(String placa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Veiculo veiculo = em.find(Veiculo.class, placa);
            if (veiculo != null) {
                em.remove(veiculo);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e; 
        } finally {
            em.close();
        }
    }
    
    public void update(Veiculo veiculo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(veiculo); 
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
