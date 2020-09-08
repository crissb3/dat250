package creditcard.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "creditcard";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        Person p = new Person();
        p.setFirstName("Cristoffer");
   
        em.persist(p);
         
        em.getTransaction().commit();

        Query q = em.createQuery("select p from Person p");
        List<Person> pList = q.getResultList();
        for (Person person : pList) {
            System.out.println(person.getFirstName());
        }
        System.out.println("Size: " + pList.size());

        em.close();
    }
    
    
}

