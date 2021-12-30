package it.ericmedvet.fammulfin.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Date;

/**
 * @author "Eric Medvet" on 2021/12/30 for new-fammulfin
 */
@Path("/status")
public class StatusResource {

  public record Status(String message, Date date) {}

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Status ping() {
    return new Status("Ok", new Date());
  }

  @Path("/{name}")
  @GET
  public Response sayHello(@PathParam("name") String name) {
    return Response.ok(String.format("Hello %s!", name)).build();
  }

}
