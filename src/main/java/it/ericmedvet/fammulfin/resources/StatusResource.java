package it.ericmedvet.fammulfin.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author "Eric Medvet" on 2021/12/30 for new-fammulfin
 */
@Path("status")
public class StatusResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response ping() {
    return Response.ok("Pong!").build();
  }

}
