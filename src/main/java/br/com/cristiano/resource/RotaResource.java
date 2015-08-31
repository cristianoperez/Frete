package br.com.cristiano.resource;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cristiano.entity.Estrutura;
import br.com.cristiano.entity.Rota;
import br.com.cristiano.entity.RotaResponse;
import br.com.cristiano.service.MalhaService;
import br.com.cristiano.service.RotaService;

@Component
@Path("/calcular/{mapa}/{origem}/{destino}/{autonomia}/{valorCombustivel}")
public class RotaResource {

	@Autowired
	private MalhaService malhaService;
	
	@Autowired
	private RotaService rotaService;
	
	@GET
	public Response calcular(
			@PathParam("mapa") String mapa, 
			@PathParam("origem") String origem,
			@PathParam("destino") String destino, 
			@PathParam("autonomia") int autonomia,
			@PathParam("valorCombustivel") BigDecimal valorCombustivel) {
		
		RotaResponse response = new RotaResponse();
		response.setMapa(mapa);
		response.setOrigem(origem);
		response.setDestino(destino);
		
		Estrutura estrutura = rotaService.buildEstrutura(origem, destino);
		
		Rota menorRota = rotaService.buscarMenorRota(estrutura, destino, valorCombustivel, autonomia);

		response.setValorTotal(menorRota.getGasto());
		response.setTrajeto(menorRota.getRota());
		response.setDistanciaPercorrida(menorRota.getDistancia());
		return Response.ok(response, MediaType.APPLICATION_JSON).build();
	}
	
}
