package it.ericmedvet.fammulfin;

import it.ericmedvet.fammulfin.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * @author "Eric Medvet" on 2021/12/30 for new-fammulfin
 */
public class DAO {
  public static void main(String[] args) {
    //String urlConnection = "jdbc:derby:/home/eric/.derby/fammulfin;create=true;";


    EntityManagerFactory factory = Persistence.createEntityManagerFactory("fammulfin-persistence-unit");
    EntityManager em = factory.createEntityManager();
    List<User> users = em.createQuery("select u from User u", User.class).getResultList();
    System.out.println(users);

    User user = new User("First", String.format("Last-%d", users.size()), "a@b.c");
    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();
    em.close();

    factory.close();
  }
}
