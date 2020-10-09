package DAO;

import java.util.List;


import javax.persistence.*;
import model.User;

public class UserDAO implements Dao<User>{



    @PersistenceContext
    private EntityManager em;
    public UserDAO()
    {
        final String PERSISTENCE_UNIT_NAME = "poll";
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

    }
    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> find(){
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
    @Override
    public User find(int id) {
        return em.find(User.class, id);
    }
    @Override
    public void save(User user) {
        ((UserDAO) em).save(user);
    }
    @Override
    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    @Override
    public void delete(int id) {
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }








}