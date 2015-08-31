package br.com.cristiano.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.cristiano.entity.Malha;
import br.com.cristiano.service.MalhaService;

@Component
@Path("/malha")
public class MalhaResource {

	@Autowired
	private MalhaService malhaService;
	
	@POST
	public Response salvar(@FormParam("origem") String origem, @FormParam("destino") String destino, @FormParam("distancia") int distancia){
		if(StringUtils.isEmpty(origem) || StringUtils.isEmpty(destino)){
			return Response.serverError().entity("Os parametros origem e destino são obrigatórios").build();
		}
		Malha malha = new Malha(origem, destino, distancia);
		malhaService.salvar(malha);
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Malha> list(){
		return malhaService.findAll();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> delete(){
		Map<String, String> map = new HashMap<String, String>();
		String msg = "Foram removido(s) %d registro(s)";
		int delete = malhaService.delete();
		String.format(msg, delete);
		map.put("message", msg);
		return map;
	}
	
}
