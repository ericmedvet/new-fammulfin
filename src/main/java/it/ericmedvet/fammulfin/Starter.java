package it.ericmedvet.fammulfin;

import it.ericmedvet.fammulfin.resource.StatusResource;
import it.ericmedvet.fammulfin.resource.UserResource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * @author "Eric Medvet" on 2021/12/30 for new-fammulfin
 */
public class Starter {
  private static final String BASE_URI = "http://localhost:8080";
  private static final String API_PATH = "/api/";

  public static void main(String[] args) throws IOException {
    final EntityManager entityManager = Persistence.createEntityManagerFactory("fammulfin-persistence-unit")
        .createEntityManager();
    final ResourceConfig resourceConfig = new ResourceConfig()
        .registerClasses(StatusResource.class, UserResource.class)
        .register(new AbstractBinder() {
          @Override
          protected void configure() {
            bind(entityManager).to(EntityManager.class);
          }
        });
    final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
        URI.create(BASE_URI+API_PATH),
        resourceConfig
    );
    server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("static/"), "/");
    server.start();
  }
}
