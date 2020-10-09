package DAO;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Vote;

public class VoteDAO implements Dao<Vote>{
    @PersistenceContext
    EntityManager em;
    public VoteDAO()
    {
        final String PERSISTENCE_UNIT_NAME = "poll";
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }
    @Override
    public void create(Vote vote) {
        em.getTransaction().begin();
        em.persist(vote);
        em.getTransaction().commit();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Vote> find()
    {
        Query query = em.createQuery("SELECT v FROM Vote v");
        return query.getResultList();
    }
    @Override
    public Vote find(int id) {
        return em.find(Vote.class, id);
    }
    @Override
    public void save(Vote vote) {
        ((VoteDAO) em).save(vote);
    }
    @Override
    public void update(Vote vote) {
        em.getTransaction().begin();
        em.merge(vote);
        em.getTransaction().commit();
    }
    @Override
    public void delete(int id) {
        Vote v = em.find(Vote.class, id);
        em.getTransaction().begin();
        em.remove(v);
        em.getTransaction().commit();
    }
}
