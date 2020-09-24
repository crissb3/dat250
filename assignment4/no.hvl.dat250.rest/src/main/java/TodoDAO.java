import javax.persistence.*;
import java.util.List;

public class TodoDAO {
    @PersistenceContext
    EntityManager em;
    public TodoDAO()
    {
        final String PERSISTENCE_UNIT_NAME = "todos";
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    public void create(Todo todo) {
        em.getTransaction().begin();
        em.persist(todo);
        em.getTransaction().commit();
    }

    public List<Todo> find()
    {
        Query query = em.createQuery("SELECT t FROM Todo t");
        return query.getResultList();
    }

    public Todo find(int id) {
        return em.find(Todo.class, id);
    }

    public void update(Todo todo) {
        em.getTransaction().begin();
        em.merge(todo);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Todo t = em.find(Todo.class, id);
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }

}
