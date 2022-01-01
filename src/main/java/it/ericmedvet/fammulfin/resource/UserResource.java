package it.ericmedvet.fammulfin.resource;

import it.ericmedvet.fammulfin.entity.User;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/01 for new-fammulfin
 */
@Path("/users")
public class UserResource {

  @Inject
  private EntityManager entityManager;
  @Context
  private SecurityContext securityContext;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> all() {
    try {
      System.out.printf("Auth scheme is: %s%n", securityContext.getAuthenticationScheme());
      System.out.printf("Current principal is: %s%n", securityContext.getUserPrincipal());
    } catch (Throwable t) {
      t.printStackTrace();
    }
    return entityManager.createQuery("select u from User u", User.class).getResultList();
  }
}
