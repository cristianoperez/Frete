package br.com.cristiano.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/healthCheck")
public class HealthCheckResource {

	@GET
	public Response healCheck(){
		return Response.status(200).entity("ok").type(MediaType.APPLICATION_JSON).build();
	}
}
