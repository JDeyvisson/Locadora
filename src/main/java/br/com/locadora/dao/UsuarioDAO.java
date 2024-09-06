package br.com.locadora.dao;
import br.com.locadora.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadora");

    public void save(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuario find(Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }

    public List<Usuario> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
        em.close();
        return usuarios;
    }

    public Usuario findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Usuário não encontrado
        } finally {
            em.close();
        }
    }
    

}
