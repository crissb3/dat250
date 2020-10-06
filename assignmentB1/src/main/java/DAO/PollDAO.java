package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Poll;


public class PollDAO implements Dao<Poll>{
    @PersistenceContext
    EntityManager em;
    public PollDAO()
    {
        final String PERSISTENCE_UNIT_NAME = "poll";
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    @Override
    public void create(Poll poll) {
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Poll> find(){
        Query query = em.createQuery("SELECT p FROM Poll p");
        return query.getResultList();
    }

    @Override
    public Poll find(int id) {
        return em.find(Poll.class, id);
    }

    @Override
    public void save(Poll poll) {
        ((PollDAO) em).save(poll);
    }

    @Override
    public void update(Poll poll) {
        em.getTransaction().begin();
        em.merge(poll);
        em.getTransaction().commit();
    }
    @Override
    public void delete(int id)
    {
        Poll p = em.find(Poll.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
