package it.ericmedvet.fammulfin;

import it.ericmedvet.fammulfin.resources.StatusResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * @author "Eric Medvet" on 2021/12/30 for new-fammulfin
 */
public class Starter {
  public static final String BASE_URI = "http://localhost:8080/";

  public static void main(String[] args) throws IOException {
    final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),
        new ResourceConfig().registerClasses(StatusResource.class)
    );
    server.start();
  }
}
