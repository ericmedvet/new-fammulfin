package it.ericmedvet.fammulfin.resource;

import it.ericmedvet.fammulfin.entity.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/01 for new-fammulfin
 */
@Path("/users")
public class UserResource {

  @Inject
  private EntityManager entityManager;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> all() {
    System.out.println("req!");
    try {
      List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
      System.out.println(users.size());
      return users;
    } catch (Throwable t) {
      t.printStackTrace();
      throw t;
    }
  }
}
